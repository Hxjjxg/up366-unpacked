package com.up366.mobile.common.crash;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CrashDataManager {
    private static volatile com.up366.mobile.common.crash.CrashDataManager instance;

    public static com.up366.mobile.common.crash.CrashDataManager getInstance() {
        if (instance == null) {
            synchronized (com.up366.mobile.common.crash.CrashDataManager.class) {
                if (instance == null) {
                    instance = new com.up366.mobile.common.crash.CrashDataManager();
                }
            }
        }
        return instance;
    }

    private CrashDataManager() {
    }

    public void collectJVMCrashData(java.lang.Thread thread, java.lang.Throwable th) {
        android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
        java.lang.String summary = com.up366.mobile.common.crash.helper.CrashInfoHelper.getInstance(thread, th).getSummary();
        java.lang.String memoryInfo = com.up366.mobile.common.crash.helper.MemoryHelper.getInstance().getMemoryInfo(applicationContext);
        java.lang.String crashLevelSummary = new com.up366.mobile.common.crash.CrashLevelHandlerContext().getCrashLevelSummary(com.up366.mobile.common.crash.Constants.CrashType.JVM);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(summary);
        sb.append(memoryInfo);
        sb.append(crashLevelSummary);
        com.up366.common.log.Logger.error("TAG - CrashDataManager - collectJVMCrashData - " + ((java.lang.Object) sb));
    }

    public void collectWebViewCrashData(com.alibaba.fastjson.JSONObject jSONObject) {
        android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
        java.lang.String jsonToString = parseJsonToString(jSONObject);
        java.lang.String summary = com.up366.mobile.common.crash.helper.CrashInfoHelper.getInstance(null, null).getSummary();
        java.lang.String memoryInfo = com.up366.mobile.common.crash.helper.MemoryHelper.getInstance().getMemoryInfo(applicationContext);
        java.lang.String crashLevelSummary = new com.up366.mobile.common.crash.CrashLevelHandlerContext().getCrashLevelSummary(com.up366.mobile.common.crash.Constants.CrashType.WEB);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(jsonToString);
        sb.append(summary);
        sb.append(memoryInfo);
        sb.append(crashLevelSummary);
        com.up366.common.log.Logger.error("TAG - CrashDataManager - collectWebViewCrashData - " + ((java.lang.Object) sb));
    }

    private java.lang.String parseJsonToString(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.size() == 0) {
            com.up366.common.log.Logger.info("TAG - CrashDataManager - parseJsonToString - jsonData is null or empty");
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("\n=== WebView onRenderProcessGone信息 ===\n");
        for (java.lang.String str : jSONObject.keySet()) {
            sb.append(str);
            sb.append(": ");
            sb.append(jSONObject.getString(str));
            sb.append("\n");
        }
        return sb.toString();
    }
}
