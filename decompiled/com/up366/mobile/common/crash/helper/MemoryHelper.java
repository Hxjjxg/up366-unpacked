package com.up366.mobile.common.crash.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MemoryHelper {
    private static volatile com.up366.mobile.common.crash.helper.MemoryHelper instance;

    public static com.up366.mobile.common.crash.helper.MemoryHelper getInstance() {
        if (instance == null) {
            synchronized (com.up366.mobile.common.crash.helper.MemoryHelper.class) {
                if (instance == null) {
                    instance = new com.up366.mobile.common.crash.helper.MemoryHelper();
                }
            }
        }
        return instance;
    }

    private MemoryHelper() {
    }

    public java.lang.String getMemoryInfo(android.content.Context context) {
        return "\n=== 内存信息 ===\n" + getMemoryState(context) + getAppHeapMemory();
    }

    private java.lang.String getMemoryState(android.content.Context context) {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return "运行内存(RAM)状态 [ Avail: " + (memoryInfo.availMem / com.up366.medialibrary.config.PictureConstants.MB) + "MB | Total: " + (memoryInfo.totalMem / com.up366.medialibrary.config.PictureConstants.MB) + "MB | LowMemory: " + memoryInfo.lowMemory + " | Threshold: " + (memoryInfo.threshold / com.up366.medialibrary.config.PictureConstants.MB) + "MB ]\n";
        }
        return "";
    }

    private java.lang.String getAppHeapMemory() {
        java.lang.Runtime runtime = java.lang.Runtime.getRuntime();
        long j = runtime.totalMemory();
        long jFreeMemory = runtime.freeMemory();
        return "堆内存(Heap Memory)状态 [ Total: " + (j / com.up366.medialibrary.config.PictureConstants.MB) + "MB | Used: " + ((j - jFreeMemory) / com.up366.medialibrary.config.PictureConstants.MB) + "MB | Free: " + (jFreeMemory / com.up366.medialibrary.config.PictureConstants.MB) + "MB | Max: " + (runtime.maxMemory() / com.up366.medialibrary.config.PictureConstants.MB) + "MB ]\n";
    }
}
