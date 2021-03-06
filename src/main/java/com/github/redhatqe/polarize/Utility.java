package com.github.redhatqe.polarize;

import java.time.LocalDateTime;

/**
 * Created by stoner on 11/3/16.
 */
public class Utility {
    public static String makeTimeStamp() {
        // Create a timestamped file polarize-config-<timestamp>.xml in backup from polarize-config.xml
        LocalDateTime now = LocalDateTime.now();
        String timestamp = "%s-%s-%d-%d-%d-%d-%d";
        timestamp = String.format(timestamp, now.getMonth().toString(), now.getDayOfMonth(), now.getYear(),
                now.getHour(), now.getMinute(), now.getSecond(), now.getNano());
        return timestamp;
    }

    public static String makeTimeStamp(String base, String end) {
        // Create a timestamped file polarize-config-<timestamp>.xml in backup from polarize-config.xml
        LocalDateTime now = LocalDateTime.now();
        if (!base.equals(""))
            base += "-";
        String timestamp = "%s%s-%s-%d-%d-%d-%d-%d";
        timestamp = String.format(timestamp, base, now.getMonth().toString(), now.getDayOfMonth(), now.getYear(),
                now.getHour(), now.getMinute(), now.getSecond(), now.getNano());
        return timestamp.trim() + end;
    }

    public static String removeLast(String s) {
        return s.substring(0, s.length() - 1);
    }
}
