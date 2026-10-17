package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DateUtils {
    private static final java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS");

    public static long getCurrentTimeMillis() {
        java.lang.String string = com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        if (string.length() > 10) {
            string = string.substring(0, 10);
        }
        return com.up366.medialibrary.common.utils.ValueOf.toLong(string);
    }

    public static int dateDiffer(long j) {
        try {
            return (int) java.lang.Math.abs(getCurrentTimeMillis() - j);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static java.lang.String formatSecondDurationTime(long j) {
        return java.lang.String.format(java.util.Locale.getDefault(), "%02d:%02d", java.lang.Long.valueOf(java.util.concurrent.TimeUnit.SECONDS.toMinutes(j)), java.lang.Long.valueOf(j - java.util.concurrent.TimeUnit.MINUTES.toSeconds(java.util.concurrent.TimeUnit.SECONDS.toMinutes(j))));
    }

    public static java.lang.String formatDurationTime(long j) {
        return java.lang.String.format(java.util.Locale.getDefault(), "%02d:%02d", java.lang.Long.valueOf(java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(j)), java.lang.Long.valueOf((java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(j) - java.util.concurrent.TimeUnit.MINUTES.toSeconds(java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(j))) + ((j % 1000) / 500)));
    }

    public static java.lang.String getCreateFileName(java.lang.String str) {
        return str + sf.format(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
    }

    public static java.lang.String getCreateFileName() {
        return sf.format(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
    }

    public static java.lang.String cdTime(long j, long j2) {
        long j3 = j2 - j;
        if (j3 > 1000) {
            return (j3 / 1000) + "秒";
        }
        return j3 + "毫秒";
    }

    public static long parseTime(java.lang.String str) {
        try {
            java.util.Date date = new java.text.SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(str);
            if (date != null) {
                return date.getTime();
            }
            return 0L;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
