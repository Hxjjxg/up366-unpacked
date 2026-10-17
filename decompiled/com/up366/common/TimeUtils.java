package com.up366.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TimeUtils {
    public static java.lang.String convertHumanizeDuration(long j) {
        if (j > 32140800000L) {
            return (j / 32140800000L) + "年前";
        }
        if (j > 2678400000L) {
            return (j / 2678400000L) + "个月前";
        }
        if (j > 86400000) {
            return (j / 86400000) + "天前";
        }
        if (j > 3600000) {
            return (j / 3600000) + "个小时前";
        }
        if (j > 60000) {
            return (j / 60000) + "分钟前";
        }
        return "刚刚";
    }

    public static long getCurrentNtpTimeInSecond() {
        return com.up366.common.global.GB.get().getReliableTime() / 1000;
    }

    public static long getCurrentNtpTimeInMillisecond() {
        return com.up366.common.global.GB.get().getReliableTime();
    }

    public static java.lang.String formatTime(long j, java.lang.String str) {
        return new java.text.SimpleDateFormat(str).format(new java.util.Date(j));
    }

    public static java.lang.String formatTime(java.util.Date date, java.lang.String str) {
        return new java.text.SimpleDateFormat(str).format(new java.util.Date(date.getTime()));
    }

    public static java.util.Date parseTime(java.lang.String str, java.lang.String str2) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return null;
        }
        try {
            return new java.text.SimpleDateFormat(str2).parse(str);
        } catch (java.text.ParseException e) {
            com.up366.common.log.Logger.error("ParseException error:" + e.getMessage(), e);
            return null;
        }
    }
}
