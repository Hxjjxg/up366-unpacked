package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V7RegisterHelper {
    public static final java.lang.String EVT_AUDIO_FFT_UPDATE = "audiofftupdate";
    public static final java.lang.String EVT_AUDIO_STATE_CHANGE = "audiostatechange";
    public static final java.lang.String EVT_BATCH_FILE_DOWNLOAD = "batchFiledownload";
    public static final java.lang.String EVT_BEFORE_GO_BACK = "beforegoback";
    public static final java.lang.String EVT_BEFORE_WEBVIEW_DESTROY = "beforewebviewdestory";
    public static final java.lang.String EVT_BOOK_DATA_UPDATE = "bookdataupdate";
    public static final java.lang.String EVT_FILE_DOWNLOAD = "filedownload";
    public static final java.lang.String EVT_FILE_UPLOAD = "fileupload";
    public static final java.lang.String EVT_MESSAGE = "message";
    public static final java.lang.String EVT_ON_TOP_RESUMED_ACTIVITY_CHANGED = "onTopResumedActivityChanged";
    public static final java.lang.String EVT_PAUSE = "pause";
    public static final java.lang.String EVT_RECORD_FFT_UPDATE = "recordfftupdate";
    public static final java.lang.String EVT_RECORD_STATE_CHANGE = "recordstatechange";
    public static final java.lang.String EVT_RESUME = "resume";
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
    public static final java.lang.String _EVT_UPDATE_COOKIE_ = "_EVT_UPDATE_COOKIE_";
    private final android.app.Activity context;
    private final java.util.Map<java.lang.String, java.lang.String> eventMap = new java.util.HashMap();
    private final com.up366.mobile.book.helper.V7ExerciseOpenHelper openHelper;
    private final com.up366.mobile.book.StudyActivityInterface studyActivityInterface;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public V7RegisterHelper(com.up366.mobile.book.StudyActivityInterface studyActivityInterface, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.V7ExerciseOpenHelper v7ExerciseOpenHelper) {
        this.studyActivityInterface = studyActivityInterface;
        this.context = studyActivityInterface.getContext();
        this.webView = studyPageWebView;
        this.openHelper = v7ExerciseOpenHelper;
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
            com.up366.common.log.Logger.info("V7RegisterHelper - not register event : " + str);
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

    public void postMessage(java.lang.String str) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.JSGlobalEvent(str));
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("type");
        final com.alibaba.fastjson.JSONObject jSONObject = object.getJSONObject("detail");
        if (_EVT_GO_LOGIN_.equals(string)) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7RegisterHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$postMessage$0();
                }
            });
        }
        if (_EVT_GO_BUY_.equals(string)) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7RegisterHelper$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$postMessage$1(jSONObject);
                }
            });
        }
        if (_EVT_GO_WRONGNOTE_.equals(string)) {
            com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions funtions = com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions.WRONGNOTE;
            final com.up366.mobile.book.helper.V7ExerciseOpenHelper v7ExerciseOpenHelper = this.openHelper;
            java.util.Objects.requireNonNull(v7ExerciseOpenHelper);
            com.up366.mobile.common.helper.PageFunctionCheckHelper.checkFunCheck(funtions, new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.V7RegisterHelper$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    v7ExerciseOpenHelper.openWrongQuestion();
                }
            });
        }
        if (_EVT_GO_WORDNOTE_.equals(string)) {
            com.up366.mobile.common.helper.PageFunctionCheckHelper.checkFunCheck(com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions.WORDNOE, new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.V7RegisterHelper$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$postMessage$2();
                }
            });
        }
        if ("_EVT_GO_STUDYTASK_".equals(string)) {
            com.up366.mobile.book.helper.OpenHelper.openTaskList(this.context, jSONObject);
        }
        if (_EVT_GO_NETWORK_HELP_.equals(string)) {
            com.up366.mobile.book.helper.OpenHelper.openNetHelp(this.context);
        }
        if (_EVT_GO_STUDNET_REPORT_.equals(string)) {
            com.up366.mobile.book.helper.OpenHelper.openPersonalReport(this.context, jSONObject);
        }
        if (_EVT_REBOOT_.equals(string)) {
            com.up366.mobile.book.helper.OpenHelper.reboot(this.context);
        }
        if (_EVT_REFRESH_JOB_LIST_.equals(string)) {
            com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent();
        }
        if (_EVT_IM_SEND_MESSAGE_.equals(string)) {
            com.up366.mobile.book.helper.OpenHelper.sendIMMessage(jSONObject);
        }
        if ("_EVT_UPDATE_COOKIE_".equals(string)) {
            com.up366.mobile.common.logic.Auth.autoLoginSyncForH5();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$0() throws java.lang.Exception {
        com.up366.mobile.user.account.login.AccountLoginActivity.open(this.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$1(com.alibaba.fastjson.JSONObject jSONObject) throws java.lang.Exception {
        this.studyActivityInterface.getBuyBookHelper().buy(jSONObject.getIntValue("productId"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$2() {
        com.up366.mobile.book.helper.OpenHelper.openWordNote(this.studyActivityInterface);
    }
}
