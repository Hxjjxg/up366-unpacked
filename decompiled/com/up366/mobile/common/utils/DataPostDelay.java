package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DataPostDelay {
    private static final int DEFAULT_PERIOD = 2;
    private static java.util.Map<java.lang.String, java.lang.Long> cacheMap = new java.util.HashMap();

    public static boolean isOutOfDate(java.lang.String str) {
        return !isNoOutOfDate(str);
    }

    public static void clearCache() {
        cacheMap.clear();
    }

    public static void doIfNoCache(java.lang.String str, java.lang.Runnable runnable) {
        if (isOutOfDate(str)) {
            addCacheFlag(str, 2);
            runnable.run();
        }
    }

    public static void doIfNoCache(java.lang.String str, int i, java.lang.Runnable runnable) {
        if (isOutOfDate(str)) {
            addCacheFlag(str, i);
            runnable.run();
        }
    }

    public static boolean isNoOutOfDate(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return false;
        }
        long j = getLong(com.up366.mobile.common.logic.Auth.getUserInfo().getUuid() + str.hashCode(), 0);
        long currentNtpTimeInSecond = com.up366.common.TimeUtils.getCurrentNtpTimeInSecond();
        return j - currentNtpTimeInSecond <= 600 && currentNtpTimeInSecond < j;
    }

    public static void addCacheFlag(java.lang.String str, int i) {
        putLong(com.up366.mobile.common.logic.Auth.getUserInfo().getUuid() + str.hashCode(), com.up366.common.TimeUtils.getCurrentNtpTimeInSecond() + ((long) i));
    }

    private static void putLong(java.lang.String str, long j) {
        cacheMap.put(str, java.lang.Long.valueOf(j));
    }

    private static long getLong(java.lang.String str, int i) {
        java.lang.Long l = cacheMap.get(str);
        return l == null ? i : l.longValue();
    }
}
