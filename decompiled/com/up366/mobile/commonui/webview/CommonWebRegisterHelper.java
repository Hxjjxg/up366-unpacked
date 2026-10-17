package com.up366.mobile.commonui.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonWebRegisterHelper {
    public static final java.lang.String EVT_AUDIO_FFT_UPDATE = "audiofftupdate";
    public static final java.lang.String EVT_AUDIO_STATE_CHANGE = "audiostatechange";
    public static final java.lang.String EVT_BEFORE_GO_BACK = "beforegoback";
    public static final java.lang.String EVT_BEFORE_WEBVIEW_DESTROY = "beforewebviewdestory";
    public static final java.lang.String EVT_BOOK_DATA_UPDATE = "bookdataupdate";
    public static final java.lang.String EVT_FILE_UPLOAD = "fileupload";
    public static final java.lang.String EVT_MESSAGE = "message";
    public static final java.lang.String EVT_PAUSE = "pause";
    public static final java.lang.String EVT_RECORD_FFT_UPDATE = "recordfftupdate";
    public static final java.lang.String EVT_RECORD_STATE_CHANGE = "recordstatechange";
    public static final java.lang.String EVT_RESUME = "resume";
    private static final java.lang.String _EVT_GO_BUY_ = "_EVT_GO_BUY_";
    private static final java.lang.String _EVT_GO_LOGIN_ = "_EVT_GO_LOGIN_";
    private static final java.lang.String _EVT_GO_NETWORK_HELP_ = "_EVT_GO_NETWORK_HELP_";
    private static final java.lang.String _EVT_GO_STUDYTASK_ = "_EVT_GO_STUDYTASK_";
    private static final java.lang.String _EVT_GO_WORDNOTE_ = "_EVT_GO_WORDNOTE_";
    private static final java.lang.String _EVT_GO_WRONGNOTE_ = "_EVT_GO_WRONGNOTE_";
    private final com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity context;
    private final java.util.Map<java.lang.String, java.lang.String> eventMap = new java.util.HashMap();
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public CommonWebRegisterHelper(com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity commonJsBridgeWebViewActivity, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        this.context = commonJsBridgeWebViewActivity;
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
            com.up366.common.log.Logger.info("V6RegisterHelper - not register event : " + str);
        } else {
            this.webView.callJSMethod(str3 + str2);
        }
    }

    public void register(java.lang.String str, java.lang.String str2) {
        this.eventMap.put(str, str2);
    }

    public void unRegister(java.lang.String str) {
        this.eventMap.remove(str);
    }

    public void destroy() {
        this.eventMap.clear();
    }

    public void postMessage(java.lang.String str) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.JSGlobalEvent(str));
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("type");
        object.getJSONObject("detail");
        if (_EVT_GO_LOGIN_.equals(string)) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.webview.CommonWebRegisterHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$postMessage$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$0() throws java.lang.Exception {
        this.context.startActivity(new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.user.account.login.AccountLoginActivity.class));
    }
}
