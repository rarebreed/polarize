package com.github.redhatqe.polarize;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.redhatqe.polarize.configuration.PolarizeConfig;
import com.github.redhatqe.polarize.configurator.PolarizeYAML;
import com.github.redhatqe.polarize.metadata.*;
import com.github.redhatqe.polarize.reporter.importer.testcase.Parameter;
import com.github.redhatqe.polarize.reporter.importer.testcase.Testcase;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class Reflector {
    public HashMap<String, List<MetaData>> testsToClasses;
    public List<MetaData> methods;
    public List<Meta<TestDefinition>> testDefs;
    public List<Meta<TestDefAdapter>> testDefAdapters;
    private Set<String> testTypes;
    private static Logger logger = LogManager.getLogger(Reflector.class.getSimpleName());
    public Map<Testcase, Meta<TestDefinition>> testCaseToMeta = new HashMap<>();
    public Map<String,
               Map<String, IdParams>> mappingFile;
    public PolarizeYAML pcfg;
    public PolarizeConfig config;
    public String tcPath;
    private Map<String, List<Testcase>> tcMap = new HashMap<>();
    public Map<String,
               Map<String, Meta<TestDefinition>>> methToProjectDef;
    public Map<String, String> methodToDesc = new HashMap<>();
    private String configPath = System.getProperty("polarize.configuration");

    public Reflector() {
        pcfg = new PolarizeYAML();
        this.init();
    }

    public Reflector(String cfgPath) {
        pcfg = new PolarizeYAML(cfgPath);
        this.init();
    }

    private void init() {
        config = pcfg.cfg;
        testsToClasses = new HashMap<>();
        testTypes = new HashSet<>(Arrays.asList("AcceptanceTests", "Tier1Tests", "Tier2Tests", "Tier3Tests"));
        testDefs = new ArrayList<>();
        mappingFile = FileHelper.loadMapping(new File(config.getMapping()));
        tcPath = config.getTestcasesXml();
        tcPath = config.getTestcasesXml();
    }

    private <T> List<Meta<TestDefinition>> getTestDefsMetaData(Class<T> c) {
        Method[] methods = c.getMethods();
        List<Method> meths = new ArrayList<>(Arrays.asList(methods));
        List<Method> filtered = meths.stream()
                .filter(m -> m.getAnnotation(TestDefinitions.class) != null)
                .collect(Collectors.toList());
        return filtered.stream().flatMap(m -> this.flatMapTestDefinitions(m, c))
                .filter(meta -> !meta.className.isEmpty() && !meta.methName.isEmpty())
                .collect(Collectors.toList());
    }

    private <T> Stream<Meta<TestDefinition>> flatMapTestDefinitions(Method m, Class<T> c) {
        TestDefinition ann = m.getAnnotation(TestDefinition.class);
        String className = c.getName();
        String pkg = c.getPackage().getName();
        String methName = m.getName();
        String qual = className + "." + methName;
        DefTypes.Project[] projects = ann.projectID();
        String[] polarionIDs = ann.testCaseID();
        if (polarionIDs.length > 0 && polarionIDs.length != projects.length)
            logger.error("Length of projects and polarionIds not the same");

        if (className.contains(".")) {
            String[] split = className.split("\\.");
            className = split[split.length - 1];
        }

        // TODO: This doesnt get clojure param names. Might need to make Reflector and JarHelper
        // in clojure, and get the args that way.
        java.lang.reflect.Parameter[] params = m.getParameters();
        List<Parameter> args = Arrays.stream(params)
                .map(arg -> {
                    Parameter pm = new Parameter();
                    pm.setName(arg.getName());
                    pm.setScope("local");
                    return pm;
                })
                .collect(Collectors.toList());

        List<Meta<TestDefinition>> metas = new ArrayList<>();
        for(int i = 0; i < projects.length; i++) {
            String project = projects[i].toString();
            String id = "";
            Boolean dirty = false;
            try {
                id = polarionIDs[i];
            }
            catch (ArrayIndexOutOfBoundsException ae) {
                dirty = true;
            }
            Meta<TestDefinition> meta = Meta.create(qual, methName, className, pkg, project, id, args,
                    ann);
            if (dirty)
                meta.dirty = dirty;
            metas.add(meta);
        }
        return metas.stream().map( me -> me);
    }

    /**
     * This is the equivalent of  TestDefinitionProcess.makeMetaFromTestDefinition
     *
     * @param c
     * @param <T>
     * @return
     */
    private <T> List<Meta<TestDefinition>> getTestDefMetaData(Class<T> c) {
        Method[] methods = c.getMethods();
        List<Method> meths = new ArrayList<>(Arrays.asList(methods));
        List<Method> filtered = meths.stream()
                        .filter(m -> m.getAnnotation(TestDefinition.class) != null)
                        .collect(Collectors.toList());
        return filtered.stream().flatMap(m -> this.flatMapTestDefinitions(m, c))
                        .filter(meta -> !meta.className.isEmpty() && !meta.methName.isEmpty())
                        .collect(Collectors.toList());
    }

    /**
     * Gets any methods annotated with TestDefinition
     *
     * @param c
     * @param <T>
     * @return
     */
    public <T> List<MetaData> getTestNGMetaData(Class<T> c) {
        Method[] methods = c.getMethods();
        List<Method> meths = new ArrayList<>(Arrays.asList(methods));
        List<MetaData> classMethods =
                meths.stream()
                        .filter(m -> m.getAnnotation(Test.class) != null)
                        .map(m -> {
                            Test ann = m.getAnnotation(Test.class);
                            String desc = ann.description();
                            String className = c.getName();
                            String methName = m.getName();
                            String provider = ann.dataProvider();
                            Boolean isProvider = !provider.isEmpty();
                            Boolean enabled = ann.enabled();
                            String[] groups = ann.groups();
                            String[] dependsOnGroups = ann.dependsOnGroups();
                            String[] dependsOnMethods = ann.dependsOnMethods();
                            //return className + "." + m.getName();
                            return new MetaData( methName, className, desc, enabled, isProvider, provider
                                               , groups, dependsOnGroups, dependsOnMethods);
                        })
                        .filter(e -> !e.className.isEmpty() && !e.methodName.isEmpty())
                        .collect(Collectors.toList());
        return classMethods;
    }

    public static String findDescription(String qualname, List<MetaData> md) {
        Optional<MetaData> methodMD = md.stream()
                .filter(m -> {
                    String fqpn = String.format("%s.%s", m.className, m.methodName);
                    return qualname.equals(fqpn);
                })
                .findFirst();
        return methodMD.map(metaData -> metaData.description).orElseGet(() -> "This is an automated test: " + qualname);
    }

    public <T> void getAnnotations(Class<T> c) {
        List<MetaData> classMethods = this.getTestNGMetaData(c);
        if(this.methods == null) {
            this.methods = classMethods;
        }
        else
            this.methods.addAll(classMethods);

        this.methodToDesc = this.methods.stream()
                .reduce(new HashMap<String, String>(), // the identity value (or accumulator)
                        (accum, n) -> {
                            accum.put(n.className + "." + n.methodName, n.description);
                            return accum;
                        },
                        (partial, next) -> {
                            partial.putAll(next);
                            return partial;
                        });

        this.testDefs.addAll(this.getTestDefMetaData(c));
        this.testDefs.addAll(this.getTestDefsMetaData(c));

        // Get the groups from the Test annotation, store it in a set
        Annotation ann = c.getAnnotation(Test.class);
        if (ann == null) return;
        String[] groups = ((Test) ann).groups();
        Set<String> groupSet = new TreeSet<>(Arrays.asList(groups));

        // Get only the groups from testTypes
        groupSet = groupSet.stream()
                .filter(testTypes::contains)
                .collect(Collectors.toSet());

        for (String g : groupSet) {
            if (!this.testsToClasses.containsKey(g)) {
                this.testsToClasses.put(g, classMethods);
            } else {
                this.testsToClasses.get(g).addAll(classMethods);
            }
        }
    }


    public void processTestDefs() {
        File mapPath = new File(this.config.getMapping());
        this.testDefs.forEach(td ->
                TestDefinitionProcessor.processTC(td, this.mappingFile, this.testCaseToMeta, this.tcPath, this.tcMap,
                        mapPath, this.methodToDesc, this.config, this.methToProjectDef));
    }

    Map<String, Map<String, Meta<TestDefinition>>> makeMethToProjectMeta() {
        Map<String, Map<String, Meta<TestDefinition>>> methToProjectMeta = new HashMap<>();
        for(Meta<TestDefinition> meta: this.testDefs) {
            String qual = meta.qualifiedName;
            String project = meta.project;
            Map<String, Meta<TestDefinition>> projToMeta = new HashMap<>();
            projToMeta.put(project, meta);
            methToProjectMeta.put(qual, projToMeta);
        }
        return methToProjectMeta;
    }

    static List<Meta<TestDefAdapter>> sortTestDefs(List<Meta<TestDefAdapter>> defs) {
        List<Meta<TestDefAdapter>> adaps = defs.stream().sorted((d1, d2) -> {
            String qual1 = d1.qualifiedName;
            String qual2 = d2.qualifiedName;
            if (qual1 == null || qual2 == null) {
                String class1 = d1.className;
                String class2 = d2.className;
                String meth1 = d1.methName;
                String meth2 = d2.methName;
                qual1 = String.format("%s.%s", class1, meth1);
                qual2 = String.format("%s.%s", class2, meth2);
            }
            return qual1.compareTo(qual2);
        }).collect(Collectors.toList());
        return adaps;
    }

    List<Optional<ObjectNode>> testcasesImporterRequest() {
        String sName = this.config.getTestcase().getSelector().getName();
        String sVal = this.config.getTestcase().getSelector().getValue();
        String user = this.config.getServers().get("polarion").getUser();
        String pw = this.config.getServers().get("polarion").getPassword();
        String url = this.config.getServers().get("polarion").getUrl() + this.config.getTestcase().getEndpoint();
        Boolean enabled = this.config.getTestcase().getEnabled();
        return TestDefinitionProcessor.tcImportRequest(this.tcMap, sName, sVal, url, user, pw, this.tcPath,
                this.config.getTestcase(), enabled, this.pcfg.configFilePath);
    }
}
