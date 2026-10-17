package com.up366.mobile.common.crash;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WebViewCrashLevelStrategy implements com.up366.mobile.common.crash.CrashLevelHandlingStrategy<java.lang.Object> {
    @Override // com.up366.mobile.common.crash.CrashLevelHandlingStrategy
    public void handleCrash(java.lang.Object obj) {
    }

    @Override // com.up366.mobile.common.crash.CrashLevelHandlingStrategy
    public java.lang.String getCrashLevelSummary(java.lang.String str) {
        android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
        com.up366.mobile.common.crash.helper.CrashLevelHelper.getInstance(applicationContext, com.up366.mobile.common.crash.Constants.SP_PREF_NAME.WEB_PREF).recordCrashEvent();
        return "\n=== WebView 崩溃统计 ===\n" + com.up366.mobile.common.crash.helper.CrashLevelHelper.getInstance(applicationContext, com.up366.mobile.common.crash.Constants.SP_PREF_NAME.WEB_PREF).getCrashSummary();
    }

    @Override // com.up366.mobile.common.crash.CrashLevelHandlingStrategy
    public java.lang.String getCrashType() {
        return com.up366.mobile.common.crash.Constants.CrashType.WEB;
    }
}
