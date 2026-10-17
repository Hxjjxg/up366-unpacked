package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TimeSyncMgr {
    private static final int MAX_PRINT_LOG = 2000;
    private static final java.lang.String PREF_BOOT_TIME = "boot_time";
    private static final java.lang.String PREF_DELTA_TIME = "delta_time";
    private static final java.lang.String PREF_LAST_SYNC_REALTIME = "last_sync_realtime";
    private static final java.lang.String PREF_LAST_SYNC_WALLTIME = "last_sync_walltime";
    private static final long SYNC_VALIDITY = java.util.concurrent.TimeUnit.HOURS.toMillis(2);
    private static final long MIN_SYNC_INTERVAL = java.util.concurrent.TimeUnit.MINUTES.toMillis(5);
    private static final long MANIPULATION_TOLERANCE = java.util.concurrent.TimeUnit.MINUTES.toMillis(3);
    private static volatile long ntpDeltaTime = Long.MAX_VALUE;
    private static volatile long lastSuccessfulSyncTime = 0;
    private static volatile long lastSyncTime = 0;
    private static volatile boolean isSyncing = false;
    private static long printLogNumber = -1;

    public static void init() {
        if (com.up366.mobile.common.utils.PlatformUtils.isCustomClosePad()) {
            com.up366.mobile.common.utils.PreferenceUtils.putLongSync(PREF_DELTA_TIME, Long.MAX_VALUE);
            com.up366.mobile.common.utils.PreferenceUtils.putLongSync(PREF_BOOT_TIME, 0L);
            com.up366.mobile.common.utils.PreferenceUtils.putLongSync(PREF_LAST_SYNC_REALTIME, 0L);
            com.up366.mobile.common.utils.PreferenceUtils.putLongSync(PREF_LAST_SYNC_WALLTIME, 0L);
        }
        long j = com.up366.mobile.common.utils.PreferenceUtils.getLong(PREF_BOOT_TIME, 0L);
        long j2 = com.up366.mobile.common.utils.PreferenceUtils.getLong(PREF_LAST_SYNC_REALTIME, 0L);
        long j3 = com.up366.mobile.common.utils.PreferenceUtils.getLong(PREF_DELTA_TIME, Long.MAX_VALUE);
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (j3 != Long.MAX_VALUE) {
            ntpDeltaTime = j3;
        }
        if (j > 0 && jElapsedRealtime >= j) {
            lastSuccessfulSyncTime = j2;
        } else {
            lastSuccessfulSyncTime = 0L;
        }
    }

    public static void syncNtpTime() {
        if (com.up366.common.NetworkUtilsUp.isConnected() && !isSyncing) {
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            if (com.up366.mobile.common.utils.PlatformUtils.isCustomClosePad() || ((lastSuccessfulSyncTime <= 0 || jElapsedRealtime - lastSuccessfulSyncTime >= MIN_SYNC_INTERVAL) && jElapsedRealtime - lastSyncTime >= MANIPULATION_TOLERANCE)) {
                isSyncing = true;
                lastSyncTime = jElapsedRealtime;
                com.up366.common.log.Logger.info("开始同步网络时间");
                com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.GET_NTP_TIME) { // from class: com.up366.mobile.common.utils.TimeSyncMgr.1
                    @Override // com.up366.common.http.RequestParams
                    public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                        map.put("r", java.lang.String.valueOf(java.lang.Math.random()));
                    }

                    @Override // com.up366.common.http.RequestParams
                    public java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                        com.up366.mobile.common.utils.TimeSyncMgr.updateFromServerTime(com.alibaba.fastjson.JSONObject.parseObject(str).getLongValue("currentTime"));
                        return null;
                    }

                    @Override // com.up366.common.http.RequestParams
                    public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                        super.onResponse(response, obj);
                        com.up366.mobile.common.utils.TimeSyncMgr.isSyncing = false;
                    }
                });
            }
        }
    }

    public static void updateFromServerTime(long j) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        synchronized (com.up366.mobile.common.utils.TimeSyncMgr.class) {
            ntpDeltaTime = j - jCurrentTimeMillis;
            lastSuccessfulSyncTime = jElapsedRealtime;
            com.up366.mobile.common.utils.PreferenceUtils.putLong(PREF_DELTA_TIME, ntpDeltaTime);
            com.up366.mobile.common.utils.PreferenceUtils.putLong(PREF_BOOT_TIME, jElapsedRealtime);
            com.up366.mobile.common.utils.PreferenceUtils.putLong(PREF_LAST_SYNC_REALTIME, jElapsedRealtime);
            com.up366.mobile.common.utils.PreferenceUtils.putLong(PREF_LAST_SYNC_WALLTIME, j);
            com.up366.mobile.AppStateMonitor.INSTANCE.updateBatchIdState("time_sync");
            com.up366.mobile.common.onlinelog.ActionLogTool.onTimeSyncSuccess();
        }
        com.up366.common.log.Logger.info(java.lang.String.format("=== 时间同步成功 ===\nServerTime(准确): %s (%d)\nSystemTime(本地): %s (%d)\nDelta(server - system): %d ms\n保存的 lastSyncWall: %s (%d)\n保存的 lastSyncRt  : %d (elapsedRealtime ms)\n", com.up366.common.TimeUtils.formatTime(j, "yyyy-MM-dd HH:mm:ss"), java.lang.Long.valueOf(j), com.up366.common.TimeUtils.formatTime(jCurrentTimeMillis, "yyyy-MM-dd HH:mm:ss"), java.lang.Long.valueOf(jCurrentTimeMillis), java.lang.Long.valueOf(ntpDeltaTime), com.up366.common.TimeUtils.formatTime(j, "yyyy-MM-dd HH:mm:ss"), java.lang.Long.valueOf(j), java.lang.Long.valueOf(jElapsedRealtime)));
    }

    public static long getReliableTime() {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j = com.up366.mobile.common.utils.PreferenceUtils.getLong(PREF_LAST_SYNC_REALTIME, 0L);
        long j2 = com.up366.mobile.common.utils.PreferenceUtils.getLong(PREF_LAST_SYNC_WALLTIME, 0L);
        if (j > 0 && j2 > 0 && jElapsedRealtime >= j) {
            long j3 = j2 + (jElapsedRealtime - j);
            printLog1(j3, j2, j, jElapsedRealtime);
            return j3;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() + getNtpDeltaTime();
        printLog(jCurrentTimeMillis);
        syncNtpTime();
        return jCurrentTimeMillis;
    }

    private static void printLog1(long j, long j2, long j3, long j4) {
        long j5 = printLogNumber;
        printLogNumber = 1 + j5;
        if (j5 % 2000 != 0) {
            return;
        }
        com.up366.common.log.Logger.info(java.lang.String.format("=== 计算可靠时间 ===\nlastSyncWall: %s (%d)\nlastSyncRt  : %d\nnowRt       : %d\n推算结果     : %s (%d)\n", com.up366.common.TimeUtils.formatTime(j2, "yyyy-MM-dd HH:mm:ss"), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3), java.lang.Long.valueOf(j4), com.up366.common.TimeUtils.formatTime(j, "yyyy-MM-dd HH:mm:ss"), java.lang.Long.valueOf(j)));
    }

    private static void printLog(long j) {
        long j2 = printLogNumber;
        printLogNumber = 1 + j2;
        if (j2 % 2000 != 0) {
            return;
        }
        com.up366.common.log.Logger.info(java.lang.String.format("=== 使用 Fallback 时间 ===\nSystemTime : %s (%d)\nDelta      : %d ms\n结果        : %s (%d)\n", com.up366.common.TimeUtils.formatTime(java.lang.System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()), java.lang.Long.valueOf(getNtpDeltaTime()), com.up366.common.TimeUtils.formatTime(j, "yyyy-MM-dd HH:mm:ss"), java.lang.Long.valueOf(j)));
    }

    public static long getNtpDeltaTime() {
        if (ntpDeltaTime == Long.MAX_VALUE) {
            ntpDeltaTime = com.up366.mobile.common.utils.PreferenceUtils.getLong(PREF_DELTA_TIME, 0L);
        }
        return ntpDeltaTime;
    }

    public static boolean isTimeReliable() {
        long j = com.up366.mobile.common.utils.PreferenceUtils.getLong(PREF_LAST_SYNC_REALTIME, 0L);
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        return j != 0 && jElapsedRealtime >= j && jElapsedRealtime - j < SYNC_VALIDITY;
    }

    public static boolean isTimeManipulated() {
        long j = com.up366.mobile.common.utils.PreferenceUtils.getLong(PREF_LAST_SYNC_REALTIME, 0L);
        return j == 0 || com.up366.mobile.common.utils.PreferenceUtils.getLong(PREF_LAST_SYNC_WALLTIME, 0L) == 0 || android.os.SystemClock.elapsedRealtime() < j;
    }
}
