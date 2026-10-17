package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6RegisterHelper {
    public static final java.lang.String EVT_BACKBTN_CLICK = "EVT_BACKBTN_CLICK";
    public static final java.lang.String EVT_CHAPTER_REFRESHED = "EVT_CHAPTER_REFRESHED";
    public static final java.lang.String EVT_DOWNLOAD_PROGRESS = "EVT_DOWNLOAD_PROGRESS";
    public static final java.lang.String EVT_HTTP_REQUEST = "EVT_HTTP_REQUEST";
    public static final java.lang.String EVT_LEFT_SLIDER = "EVT_LEFT_SLIDER";
    public static final java.lang.String EVT_MESSAGE = "message";
    public static final java.lang.String EVT_MIX_AUDIO_VIDEO = "EVT_MIX_AUDIO_VIDEO";
    public static final java.lang.String EVT_ON_TOP_RESUMED_ACTIVITY_CHANGED = "onTopResumedActivityChanged";
    public static final java.lang.String EVT_REFRESH_CHAPTER = "EVT_REFRESH_CHAPTER";
    public static final java.lang.String EVT_SAVE_TO_GALLERYPRO = "EVT_SAVE_TO_GALLERYPRO";
    private static final java.lang.String _EVT_GO_BUY_ = "_EVT_GO_BUY_";
    private static final java.lang.String _EVT_GO_LOGIN_ = "_EVT_GO_LOGIN_";
    private static final java.lang.String _EVT_GO_NETWORK_HELP_ = "_EVT_GO_NETWORK_HELP_";
    private static final java.lang.String _EVT_GO_STUDNET_REPORT_ = "_EVT_GO_STUDNET_REPORT_";
    public static final java.lang.String _EVT_GO_STUDYTASK_ = "_EVT_GO_STUDYTASK_";
    private static final java.lang.String _EVT_GO_WORDNOTE_ = "_EVT_GO_WORDNOTE_";
    private static final java.lang.String _EVT_GO_WRONGNOTE_ = "_EVT_GO_WRONGNOTE_";
    public static final java.lang.String _EVT_IM_ON_MESSAGE_ = "_EVT_IM_ON_MESSAGE_";
    private static final java.lang.String _EVT_IM_SEND_MESSAGE_ = "_EVT_IM_SEND_MESSAGE_";
    private static final java.lang.String _EVT_REBOOT_ = "_EVT_REBOOT_";
    private static final java.lang.String _EVT_REFRESH_JOB_LIST_ = "_EVT_REFRESH_JOB_LIST_";
    private final java.util.Map<java.lang.String, java.lang.String> eventMap = new java.util.HashMap();
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public V6RegisterHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
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
            com.up366.common.log.Logger.info(this.eventMap.keySet().toString());
            return;
        }
        this.webView.callJSMethod(str3 + str2);
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

    /* JADX WARN: Type inference failed for: r1v3, types: [android.content.Context, com.up366.mobile.book.StudyActivity] */
    public void postMessage(java.lang.String str) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.JSGlobalEvent(str));
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("type");
        final com.alibaba.fastjson.JSONObject jSONObject = object.getJSONObject("detail");
        final ?? r1 = (com.up366.mobile.book.StudyActivity) this.webView.getContext();
        com.up366.mobile.book.helper.V6ExerciseOpenHelper v6ExerciseOpenHelper = new com.up366.mobile.book.helper.V6ExerciseOpenHelper(r1);
        if (_EVT_GO_LOGIN_.equals(string)) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V6RegisterHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.user.account.login.AccountLoginActivity.open(r1);
                }
            });
        }
        if (_EVT_GO_BUY_.equals(string)) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V6RegisterHelper$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() {
                    r1.buyBookHelper.buy(jSONObject.getIntValue("productId"));
                }
            });
        }
        if (_EVT_GO_WRONGNOTE_.equals(string)) {
            v6ExerciseOpenHelper.openWrongQuestion();
        }
        if (_EVT_GO_WORDNOTE_.equals(string)) {
            v6ExerciseOpenHelper.openWordNote();
        }
        if ("_EVT_GO_STUDYTASK_".equals(string)) {
            com.up366.mobile.book.helper.OpenHelper.openTaskList(r1, jSONObject);
        }
        if (_EVT_GO_NETWORK_HELP_.equals(string)) {
            com.up366.mobile.book.helper.OpenHelper.openNetHelp(r1);
        }
        if (_EVT_GO_STUDNET_REPORT_.equals(string)) {
            com.up366.mobile.book.helper.OpenHelper.openPersonalReport(r1, jSONObject);
        }
        if (_EVT_REBOOT_.equals(string)) {
            com.up366.mobile.book.helper.OpenHelper.reboot(r1);
        }
        if (_EVT_REFRESH_JOB_LIST_.equals(string)) {
            com.up366.common.log.Logger.info("V6RegisterHelper _EVT_REFRESH_JOB_LIST_");
            com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent();
        }
        if (_EVT_IM_SEND_MESSAGE_.equals(string)) {
            com.up366.common.log.Logger.info("V6RegisterHelper _EVT_IM_SEND_MESSAGE_");
            com.up366.mobile.book.helper.OpenHelper.sendIMMessage(jSONObject);
        }
    }
}
