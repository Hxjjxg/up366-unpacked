package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TimeUtilsApp {
    public static final long ThirtyDays = 2592000000L;

    public static java.lang.String getTimeToString(long j) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        long j2 = j / 1000;
        int i = (((int) j2) / 1440) / 60;
        int i2 = (int) (j2 / 3600);
        int i3 = (int) ((j2 / 60) % 60);
        int i4 = (int) (j2 % 60);
        if (i > 0) {
            sb.append(i);
            sb.append("天");
        }
        if (i2 > 0) {
            sb.append(i2);
            sb.append("时");
        }
        if (i3 > 0) {
            sb.append(i3);
            sb.append("分");
        }
        if (sb.length() == 0 || ((i == 0 && i2 == 0 && i4 != 0) || (i == 0 && i2 == 0 && i3 == 0))) {
            sb.append(i4);
            sb.append("秒");
        }
        return sb.toString();
    }

    public static java.lang.String getTimeToStringInEnglish(long j) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        long j2 = j / 1000;
        int i = (((int) j2) / 1440) / 60;
        int i2 = (int) (j2 / 3600);
        int i3 = (int) ((j2 / 60) % 60);
        int i4 = (int) (j2 % 60);
        if (i > 0) {
            sb.append(i);
            sb.append("day");
        }
        if (i2 > 0) {
            sb.append(i2);
            sb.append("h");
        }
        if (i3 > 0) {
            sb.append(i3);
            sb.append("min");
        }
        if (sb.length() == 0 || ((i == 0 && i2 == 0 && i4 != 0) || (i == 0 && i2 == 0 && i3 == 0))) {
            sb.append(i4);
            sb.append(com.igexin.push.core.d.d.g);
        }
        return sb.toString();
    }

    public static java.lang.String getWeek(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(new java.util.Date(j));
        int i = calendar.get(7);
        if (i == 1) {
            return "星期日";
        }
        if (i == 2) {
            return "星期一";
        }
        if (i == 3) {
            return "星期二";
        }
        if (i == 4) {
            return "星期三";
        }
        if (i == 5) {
            return "星期四";
        }
        if (i == 6) {
            return "星期五";
        }
        if (i == 7) {
            return "星期六";
        }
        return null;
    }

    public static java.lang.String formatTime(long j, java.lang.String str) {
        return new java.text.SimpleDateFormat(str, java.util.Locale.ENGLISH).format(new java.util.Date(j));
    }

    public static long dateStrToLong(java.lang.String str, java.lang.String str2) {
        java.util.Date date;
        try {
            date = new java.text.SimpleDateFormat(str2, java.util.Locale.ENGLISH).parse(str);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            date = null;
        }
        return date.getTime();
    }

    public static java.lang.String getEndTime(long j) {
        long currentNtpTimeInMillisecond = j - com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        java.lang.String timeToString = getTimeToString(java.lang.Math.abs(currentNtpTimeInMillisecond));
        if ("0秒".equals(timeToString)) {
            return "刚刚结束";
        }
        if (!timeToString.contains("天")) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(currentNtpTimeInMillisecond >= 0 ? "剩余" : "过期");
            sb.append(timeToString);
            return sb.toString();
        }
        if (currentNtpTimeInMillisecond < 0) {
            return "过期" + timeToString.substring(0, timeToString.indexOf("天") + 1);
        }
        return "截止时间：" + com.up366.common.TimeUtils.formatTime(j, "MM-dd HH:mm");
    }

    public static java.lang.String getCreateTime(long j) {
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - j;
        if (currentNtpTimeInMillisecond < 60000) {
            return "刚刚";
        }
        if (currentNtpTimeInMillisecond > 259200000) {
            return com.up366.common.TimeUtils.formatTime(j, "MM-dd HH:mm");
        }
        java.lang.String time = com.up366.common.TimeUtils.formatTime(j, "yyyy-MM-dd");
        if (time.equals(com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd"))) {
            return com.up366.common.TimeUtils.formatTime(j, "今天 HH:mm");
        }
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        calendar.add(5, -1);
        if (time.equals(com.up366.common.TimeUtils.formatTime(calendar.getTimeInMillis(), "yyyy-MM-dd"))) {
            return com.up366.common.TimeUtils.formatTime(j, "昨天 HH:mm");
        }
        calendar.add(5, -1);
        if (time.equals(com.up366.common.TimeUtils.formatTime(calendar.getTimeInMillis(), "yyyy-MM-dd"))) {
            return com.up366.common.TimeUtils.formatTime(j, "前天 HH:mm");
        }
        return com.up366.common.TimeUtils.formatTime(j, "MM-dd HH:mm");
    }

    public static boolean isToday(long j) {
        return com.up366.common.TimeUtils.formatTime(j, "yyyy-MM-dd").equals(com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd"));
    }

    public static boolean isNowYear(long j) {
        return com.up366.common.TimeUtils.formatTime(j, "yyyy").equals(com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy"));
    }

    public static boolean isYesterday(long j) {
        java.lang.String time = com.up366.common.TimeUtils.formatTime(j, "yyyy-MM-dd");
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        calendar.add(5, -1);
        return time.equals(com.up366.common.TimeUtils.formatTime(calendar.getTimeInMillis(), "yyyy-MM-dd"));
    }

    public static java.lang.Long getDailyStartTime(java.lang.Long l) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return java.lang.Long.valueOf(calendar.getTimeInMillis());
    }

    public static java.lang.String getSubmitTime(long j) {
        if (j == 0) {
            return "0";
        }
        java.lang.String timeToString = getTimeToString(java.lang.Math.abs(j - com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
        long currentNtpTimeInMillisecond = (((com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() / 24) / 3600) / 1000) - (((j / 24) / 3600) / 1000);
        if ("0秒".equals(timeToString)) {
            return "刚刚提交";
        }
        java.lang.String time = com.up366.common.TimeUtils.formatTime(j, "HH:mm");
        if (timeToString.contains("天")) {
            java.lang.String strSubstring = timeToString.substring(0, timeToString.indexOf("天"));
            if ("1".equals(strSubstring)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(currentNtpTimeInMillisecond < 1 ? "昨天 " : "前天");
                sb.append(time);
                return sb.toString();
            }
            if ("2".equals(strSubstring) && currentNtpTimeInMillisecond < 1) {
                return "前天 " + time + "提交";
            }
            return "提交时间 " + com.up366.common.TimeUtils.formatTime(j, "MM-dd HH:mm");
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(currentNtpTimeInMillisecond < 1 ? "今天 " : "昨天");
        sb2.append(time);
        sb2.append("提交");
        return sb2.toString();
    }

    public static long getMondayTimeStamp(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(new java.util.Date(j));
        int i = calendar.get(7);
        if (i == 1) {
            calendar.add(5, -6);
        } else {
            calendar.add(5, (-i) + 2);
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static java.lang.String formatTimer(long j) {
        java.lang.Object objValueOf;
        java.lang.Object objValueOf2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        long j2 = j / 86400000;
        long j3 = (j % 86400000) / 3600000;
        long j4 = (j % 3600000) / 60000;
        if (j2 > 0) {
            sb.append(j2);
            sb.append("天");
        }
        if (j3 >= 10) {
            objValueOf = java.lang.Long.valueOf(j3);
        } else {
            objValueOf = "0" + j3;
        }
        sb.append(objValueOf);
        sb.append("小时");
        if (j4 < 10) {
            objValueOf2 = "0" + j4;
        } else {
            objValueOf2 = java.lang.Long.valueOf(j4);
        }
        sb.append(objValueOf2);
        sb.append("分");
        return sb.toString();
    }

    public static java.lang.String formatSecondTime(long j) {
        if (j <= 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        long j2 = j / 86400;
        long j3 = (j % 86400) / 3600;
        long j4 = (j % 3600) / 60;
        if (j2 > 0) {
            sb.append(j2);
            sb.append("d");
        }
        if (j3 > 0) {
            sb.append(j3);
            sb.append("h");
        }
        if (j4 > 0) {
            sb.append(j4);
            sb.append("min");
        }
        return sb.toString();
    }

    public static int getDayNumberByYearMonth(java.lang.String str) {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM");
        try {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(str));
            return calendar.getActualMaximum(5);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return 31;
        }
    }

    public static long getDayStartTime(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static long getDayEndTime(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTimeInMillis();
    }

    public static java.lang.Long getMonthStartTime(java.lang.Long l) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        calendar.add(1, 0);
        calendar.add(2, 0);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return java.lang.Long.valueOf(calendar.getTimeInMillis());
    }

    public static java.lang.Long getMonthEndTime(java.lang.Long l) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        calendar.add(1, 0);
        calendar.add(2, 0);
        calendar.set(5, calendar.getActualMaximum(5));
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return java.lang.Long.valueOf(calendar.getTimeInMillis());
    }
}
