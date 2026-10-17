package com.up366.mobile.commonui.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonWebRegisterHelper {
    public static final java.lang.String EVENT_HTTP_RESPONSE = "httpresponse";
    public static final java.lang.String EVENT_ON_BACK_PRESSED = "backpressed";
    public static final java.lang.String EVENT_PHOTO_RECOGNITION_RESULT = "ocr";
    public static final java.lang.String EVENT_SHARE_RESULT = "share";
    public static final java.lang.String EVT_MESSAGE = "message";
    public static final java.lang.String EVT_PAUSE = "pause";
    public static final java.lang.String EVT_RESUME = "resume";
    private static final java.lang.String _EVT_GO_LOGIN_ = "_EVT_GO_LOGIN_";
    private static final java.lang.String _EVT_GO_NETWORK_HELP_ = "_EVT_GO_NETWORK_HELP_";
    private java.util.Map<java.lang.String, java.lang.String> eventMap = new java.util.HashMap();
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public CommonWebRegisterHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        this.webView = studyPageWebView;
    }

    public boolean hasRegister(java.lang.String str) {
        return !com.up366.common.StringUtils.isEmptyOrNull(this.eventMap.get(str));
    }

    public void callJsEvent(java.lang.String str) {
        callJsEvent(str, "()");
    }

    public void callJsEvent(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        callJsEvent(str, java.lang.String.format(str2, objArr));
    }

    public void callJsEvent(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = this.eventMap.get(str);
        if (com.up366.common.StringUtils.isEmptyOrNull(str3)) {
            com.up366.common.log.Logger.info("ReportRegisterHelper - not register event : " + str);
        } else {
            this.webView.callJSMethod(str3 + str2);
        }
    }

    public void register(java.lang.String str, java.lang.String str2) {
        this.eventMap.put(str, str2);
    }

    public java.lang.String unRegister(java.lang.String str) {
        this.eventMap.remove(str);
        return "unRegisterEvent";
    }

    public void clear() {
        this.eventMap.clear();
    }

    public void postMessage(java.lang.String str) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.JSGlobalEvent(str));
        android.content.Context context = this.webView.getContext();
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("type");
        object.getJSONObject("detail");
        if (_EVT_GO_LOGIN_.equals(string)) {
            com.up366.mobile.user.account.login.AccountLoginActivity.open(context);
        }
        if (_EVT_GO_NETWORK_HELP_.equals(string)) {
            com.up366.mobile.commonui.LookHelpActivity.openPage(context);
        }
    }
}
