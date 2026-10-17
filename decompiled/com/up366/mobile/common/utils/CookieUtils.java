package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CookieUtils {
    public static void syncCookie() {
        try {
            java.util.List<okhttp3.Cookie> listLoadForRequest = com.up366.common.http.HttpUtilsUp.loadForRequest(okhttp3.HttpUrl.parse(com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.common.http.HttpMgrUtils.tickets)));
            android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            for (okhttp3.Cookie cookie : listLoadForRequest) {
                cookieManager.setCookie(cookie.domain(), cookie.toString());
            }
            cookieManager.flush();
        } catch (java.lang.Exception unused) {
            com.up366.common.log.Logger.error("syncCookie error ");
        }
    }

    public static void clearAllCookie() {
        try {
            android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.removeAllCookies(new android.webkit.ValueCallback() { // from class: com.up366.mobile.common.utils.CookieUtils$$ExternalSyntheticLambda0
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(java.lang.Object obj) {
                    com.up366.common.log.Logger.info("removeAllCookies " + ((java.lang.Boolean) obj));
                }
            });
            cookieManager.flush();
        } catch (java.lang.Exception unused) {
            com.up366.common.log.Logger.error("clearAllCookie error ");
        }
    }

    public static void handleGrayCookie() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.CookieUtils$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.utils.CookieUtils.lambda$handleGrayCookie$2();
            }
        });
    }

    static /* synthetic */ void lambda$handleGrayCookie$2() throws java.lang.Exception {
        java.lang.String targetHost = com.up366.mobile.common.utils.PlatformUtils.getTargetHost();
        if (com.up366.mobile.common.utils.PlatformUtils.isGray()) {
            android.webkit.CookieManager.getInstance().setCookie(targetHost, "u3h=1;Path=/;domain=" + targetHost);
            return;
        }
        java.lang.String cookie = android.webkit.CookieManager.getInstance().getCookie(targetHost);
        if (cookie == null || !cookie.contains("u3h=1")) {
            return;
        }
        android.webkit.CookieManager.getInstance().removeAllCookies(new android.webkit.ValueCallback() { // from class: com.up366.mobile.common.utils.CookieUtils$$ExternalSyntheticLambda1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(java.lang.Object obj) {
                com.up366.common.log.Logger.info("TAG - ApplicationHelper - removeAllCookies : " + ((java.lang.Boolean) obj));
            }
        });
    }
}
