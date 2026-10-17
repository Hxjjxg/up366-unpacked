package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class NetworkUtils {
    public static boolean isWifiProxy() {
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            return false;
        }
        try {
            if (android.text.TextUtils.isEmpty(java.lang.System.getProperty("http.proxyHost"))) {
                return false;
            }
            return !android.text.TextUtils.isEmpty(java.lang.System.getProperty("http.proxyPort"));
        } catch (java.lang.Exception unused) {
            com.up366.common.log.Logger.error("isWifiProxy error");
            return false;
        }
    }
}
