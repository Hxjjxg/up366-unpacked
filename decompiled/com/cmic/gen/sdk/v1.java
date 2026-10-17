package com.cmic.gen.sdk;

/* JADX INFO: compiled from: UmcConfigUtil.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
class v1 {
    static boolean a() {
        return java.lang.System.currentTimeMillis() >= com.cmic.gen.sdk.h1.a("sso_config_xf", "client_valid", 0L);
    }

    static java.lang.String b(java.lang.String str) {
        java.lang.String strA = com.cmic.gen.sdk.h1.a("sso_config_xf", "https_get_phone_scrip_host", (java.lang.String) null);
        return android.text.TextUtils.isEmpty(strA) ? str : strA;
    }

    static boolean c(boolean z) {
        return "1".equals(com.cmic.gen.sdk.h1.a("sso_config_xf", "CLOSE_IPV4_LIST", !z ? "0" : "1"));
    }

    static boolean d(boolean z) {
        return "1".equals(com.cmic.gen.sdk.h1.a("sso_config_xf", "CLOSE_IPV6_LIST", !z ? "0" : "1"));
    }

    static boolean e(boolean z) {
        return "1".equals(com.cmic.gen.sdk.h1.a("sso_config_xf", "CLOSE_LOGS_VERSION", z ? "1" : "0"));
    }

    static boolean f(boolean z) {
        java.lang.String str = !z ? "0" : "1";
        return "1".equals(com.cmic.gen.sdk.h1.a("sso_config_xf", "CLOSE_M008_APPID_LIST", str)) || "1".equals(com.cmic.gen.sdk.h1.a("sso_config_xf", "CLOSE_M008_SDKVERSION_LIST", str));
    }

    static java.lang.String a(java.lang.String str) {
        java.lang.String strA = com.cmic.gen.sdk.h1.a("sso_config_xf", "config_host", (java.lang.String) null);
        return android.text.TextUtils.isEmpty(strA) ? str : strA;
    }

    static boolean b(boolean z) {
        return com.cmic.gen.sdk.h1.a("sso_config_xf", "CLOSE_FRIEND_WAPKS", z ? "CU" : "").contains("CU");
    }

    static boolean a(boolean z) {
        return com.cmic.gen.sdk.h1.a("sso_config_xf", "CLOSE_FRIEND_WAPKS", z ? com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_CONTENT : "").contains(com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_CONTENT);
    }

    static java.lang.String c(java.lang.String str) {
        java.lang.String strA = com.cmic.gen.sdk.h1.a("sso_config_xf", "logHost", "");
        return android.text.TextUtils.isEmpty(strA) ? str : strA;
    }

    static int b(int i) {
        return com.cmic.gen.sdk.h1.a("sso_config_xf", "maxFailedLogTimes", i);
    }

    static int a(int i) {
        return com.cmic.gen.sdk.h1.a("sso_config_xf", "pauseTime", i);
    }
}
