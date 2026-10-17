package com.up366.mobile.common.crash.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CrashLevelHelper {
    private static final long CLEANUP_INTERVAL = 604800000;
    private static final java.lang.String KEY_CRASH_TIMESTAMPS = "crash_timestamps";
    private static final java.lang.String KEY_LAST_CLEANUP = "last_cleanup_timestamp";
    private static final long ONE_DAY_MS = 86400000;
    private static final long SEVEN_DAYS_MS = 604800000;
    private static final int SEVERE_THRESHOLD = 5;
    private static final long THIRTY_DAYS_MS = 2592000000L;
    private static final int WARNING_THRESHOLD = 2;
    private static volatile com.up366.mobile.common.crash.helper.CrashLevelHelper instance;
    private final android.content.Context mContext;
    private final android.content.SharedPreferences mSharedPreferences;

    public enum CrashLevel {
        SEVERE,
        WARNING,
        INFO
    }

    public static com.up366.mobile.common.crash.helper.CrashLevelHelper getInstance(android.content.Context context, java.lang.String str) {
        if (instance == null) {
            synchronized (com.up366.mobile.common.crash.helper.CrashLevelHelper.class) {
                if (instance == null) {
                    instance = new com.up366.mobile.common.crash.helper.CrashLevelHelper(context, str);
                }
            }
        }
        return instance;
    }

    private CrashLevelHelper(android.content.Context context, java.lang.String str) {
        this.mContext = context;
        this.mSharedPreferences = context.getSharedPreferences(str, 0);
        com.up366.common.log.Logger.info("TAG - CrashLevelHelper - SharedPreferences - name : " + str);
        cleanupExpiredData();
    }

    public void recordCrashEvent() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.Set<java.lang.String> crashTimestamps = getCrashTimestamps();
        if (isDuplicateCrash(crashTimestamps, jCurrentTimeMillis)) {
            return;
        }
        java.util.HashSet hashSet = new java.util.HashSet(crashTimestamps);
        hashSet.add(java.lang.String.valueOf(jCurrentTimeMillis));
        saveCrashTimestamps(hashSet);
        handleCrashLevel(getCrashLevel());
    }

    public java.lang.String getCrashSummary() {
        int crashCountInLastDay = getCrashCountInLastDay();
        int crashCountInLastSevenDays = getCrashCountInLastSevenDays();
        int crashCountInLastThirtyDays = getCrashCountInLastThirtyDays();
        return "崩溃等级：" + getCrashLevelTip(getCrashLevel()) + "\n崩溃总次数(最近1天)：" + crashCountInLastDay + "\n崩溃总次数(最近7天)：" + crashCountInLastSevenDays + "\n崩溃总次数(最近30天)：" + crashCountInLastThirtyDays + "\n";
    }

    private com.up366.mobile.common.crash.helper.CrashLevelHelper.CrashLevel getCrashLevel() {
        int crashCountInLastDay = getCrashCountInLastDay();
        if (crashCountInLastDay >= 5) {
            return com.up366.mobile.common.crash.helper.CrashLevelHelper.CrashLevel.SEVERE;
        }
        if (crashCountInLastDay >= 2) {
            return com.up366.mobile.common.crash.helper.CrashLevelHelper.CrashLevel.WARNING;
        }
        return com.up366.mobile.common.crash.helper.CrashLevelHelper.CrashLevel.INFO;
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.crash.helper.CrashLevelHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$up366$mobile$common$crash$helper$CrashLevelHelper$CrashLevel;

        static {
            int[] iArr = new int[com.up366.mobile.common.crash.helper.CrashLevelHelper.CrashLevel.values().length];
            $SwitchMap$com$up366$mobile$common$crash$helper$CrashLevelHelper$CrashLevel = iArr;
            try {
                iArr[com.up366.mobile.common.crash.helper.CrashLevelHelper.CrashLevel.SEVERE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$up366$mobile$common$crash$helper$CrashLevelHelper$CrashLevel[com.up366.mobile.common.crash.helper.CrashLevelHelper.CrashLevel.WARNING.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$up366$mobile$common$crash$helper$CrashLevelHelper$CrashLevel[com.up366.mobile.common.crash.helper.CrashLevelHelper.CrashLevel.INFO.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public java.lang.String getCrashLevelTip(com.up366.mobile.common.crash.helper.CrashLevelHelper.CrashLevel crashLevel) {
        int i = com.up366.mobile.common.crash.helper.CrashLevelHelper.AnonymousClass1.$SwitchMap$com$up366$mobile$common$crash$helper$CrashLevelHelper$CrashLevel[crashLevel.ordinal()];
        if (i == 1) {
            return "严重 (应用崩溃频率过高，建议处理)";
        }
        if (i == 2) {
            return "警告 (应用崩溃频率较高，需要关注)";
        }
        if (i == 3) {
            return "信息 (崩溃次数在接受范围内)";
        }
        return "";
    }

    private void handleCrashLevel(com.up366.mobile.common.crash.helper.CrashLevelHelper.CrashLevel crashLevel) {
        int i = com.up366.mobile.common.crash.helper.CrashLevelHelper.AnonymousClass1.$SwitchMap$com$up366$mobile$common$crash$helper$CrashLevelHelper$CrashLevel[crashLevel.ordinal()];
        if (i == 1) {
            com.up366.common.log.Logger.error("TAG - CrashLevelHelper - handleCrashLevel - SEVERE");
            return;
        }
        if (i == 2) {
            com.up366.common.log.Logger.warn("TAG - CrashLevelHelper - handleCrashLevel - WARNING");
        } else if (i == 3) {
            com.up366.common.log.Logger.info("TAG - CrashLevelHelper - handleCrashLevel - INFO");
        } else {
            com.up366.common.log.Logger.info("TAG - CrashLevelHelper - handleCrashLevel - default");
        }
    }

    public java.util.List<java.lang.Long> getAllCrashTimestamps() {
        java.util.Set<java.lang.String> crashTimestamps = getCrashTimestamps();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.lang.String> it = crashTimestamps.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(java.lang.Long.valueOf(java.lang.Long.parseLong(it.next())));
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("TAG - CrashLevelHelper - getAllCrashTimestamps - error:" + e.getMessage());
            }
        }
        java.util.Collections.sort(arrayList);
        return arrayList;
    }

    private int getCrashCountInLastDay() {
        return getCrashCountInRange(86400000L);
    }

    private int getCrashCountInLastThirtyDays() {
        return getCrashCountInRange(2592000000L);
    }

    private int getCrashCountInLastSevenDays() {
        return getCrashCountInRange(604800000L);
    }

    private void cleanupExpiredData() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (jCurrentTimeMillis - this.mSharedPreferences.getLong(KEY_LAST_CLEANUP, 0L) < 604800000) {
            com.up366.common.log.Logger.info("TAG - CrashLevelHelper - cleanupExpiredData - no need to cleanup");
            return;
        }
        java.util.Set<java.lang.String> crashTimestamps = getCrashTimestamps();
        if (crashTimestamps.isEmpty()) {
            com.up366.common.log.Logger.info("TAG - CrashLevelHelper - cleanupExpiredData - no crash data");
            return;
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        long j = jCurrentTimeMillis - 2592000000L;
        int i = 0;
        for (java.lang.String str : crashTimestamps) {
            try {
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("TAG - CrashLevelHelper - cleanupExpiredData - error:" + e.getMessage());
            }
            if (java.lang.Long.parseLong(str) >= j) {
                hashSet.add(str);
            } else {
                i++;
            }
        }
        if (i > 0) {
            saveCrashTimestamps(hashSet);
            this.mSharedPreferences.edit().putLong(KEY_LAST_CLEANUP, jCurrentTimeMillis).apply();
            com.up366.common.log.Logger.info("TAG - CrashLevelHelper - cleanupExpiredData - 数据清理完成 - 移除了 " + i + " 条过期记录");
        }
    }

    private int getCrashCountInRange(long j) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - j;
        java.util.Iterator<java.lang.String> it = getCrashTimestamps().iterator();
        int i = 0;
        while (it.hasNext()) {
            try {
                long j3 = java.lang.Long.parseLong(it.next());
                if (j3 >= j2 && j3 <= jCurrentTimeMillis) {
                    i++;
                }
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("TAG - CrashLevelHelper - getCrashCountInRange - error:" + e.getMessage());
            }
        }
        return i;
    }

    private java.util.Set<java.lang.String> getCrashTimestamps() {
        return this.mSharedPreferences.getStringSet(KEY_CRASH_TIMESTAMPS, new java.util.HashSet());
    }

    private void saveCrashTimestamps(java.util.Set<java.lang.String> set) {
        this.mSharedPreferences.edit().putStringSet(KEY_CRASH_TIMESTAMPS, set).apply();
    }

    private boolean isDuplicateCrash(java.util.Set<java.lang.String> set, long j) {
        long j2;
        long j3 = j - 1000;
        java.util.Iterator<java.lang.String> it = set.iterator();
        while (it.hasNext()) {
            try {
                j2 = java.lang.Long.parseLong(it.next());
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("TAG - CrashLevelHelper - isDuplicateCrash - error:" + e.getMessage());
            }
            if (j2 >= j3 && j2 <= j) {
                return true;
            }
        }
        return false;
    }
}
