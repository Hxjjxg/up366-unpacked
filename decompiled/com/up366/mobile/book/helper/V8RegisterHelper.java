package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V8RegisterHelper implements com.up366.mobile.book.helper.interfaces.IRegisterHelper {
    public static final java.lang.String EVT_APP_LOG_UPLOAD = "appLogsUpload";
    public static final java.lang.String EVT_AUDIO_FFT_UPDATE = "audioFFTUpdate";
    public static final java.lang.String EVT_AUDIO_STATE_CHANGE = "audioStateChange";
    public static final java.lang.String EVT_BATCH_FILE_DOWNLOAD = "fileDownload";
    public static final java.lang.String EVT_BATCH_UPLOAD = "taskUpload";
    public static final java.lang.String EVT_BEFORE_GO_BACK = "beforeGoBack";
    public static final java.lang.String EVT_BEFORE_WEBVIEW_DESTROY = "beforeLeavePage";
    public static final java.lang.String EVT_BOOK_DATA_UPDATE = "bookdataupdate";
    public static final java.lang.String EVT_FILE_DOWNLOAD = "filedownload";
    public static final java.lang.String EVT_FILE_UPLOAD = "fileUpload";
    public static final java.lang.String EVT_HEADSET_STATUS_CHANGE = "headSetStatusChange";
    public static final java.lang.String EVT_MESSAGE = "message";
    public static final java.lang.String EVT_ON_TOP_RESUMED_ACTIVITY_CHANGED = "onTopResumedActivityChanged";
    public static final java.lang.String EVT_PAUSE = "pause";
    public static final java.lang.String EVT_RECORD_FFT_UPDATE = "recordFFTUpdate";
    public static final java.lang.String EVT_RECORD_STATE_CHANGE = "recordStateChange";
    public static final java.lang.String EVT_RESUME = "resume";
    public static final java.lang.String EVT_SCAN_PAPER_DATA_OBTAINED = "scanPaperDataObtained";
    public static final java.lang.String EVT_TASK_UPLOAD = "taskUpload";
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
    public static final java.lang.String _SUBMIT_TASK_ = "_SUBMIT_TASK_";
    private final android.content.Context context;
    private final java.util.Map<java.lang.String, java.lang.String> eventMap = new java.util.HashMap();
    private final com.up366.mobile.book.StudyActivityInterface studyActivityInterface;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public V8RegisterHelper(com.up366.mobile.book.StudyActivityInterface studyActivityInterface, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        this.studyActivityInterface = studyActivityInterface;
        this.context = studyActivityInterface.getContext();
        this.webView = studyPageWebView;
    }

    @Override // com.up366.mobile.book.helper.interfaces.IRegisterHelper
    public boolean hasRegister(java.lang.String str) {
        return !com.up366.common.StringUtils.isEmptyOrNull(this.eventMap.get(str));
    }

    @Override // com.up366.mobile.book.helper.interfaces.IRegisterHelper
    public void callJsEvent(java.lang.String str) {
        callJsEvent(str, "()");
    }

    @Override // com.up366.mobile.book.helper.interfaces.IRegisterHelper
    public void callJsEvent(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        callJsEvent(str, java.lang.String.format(str2, objArr));
    }

    @Override // com.up366.mobile.book.helper.interfaces.IRegisterHelper
    public void callJsEvent(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = this.eventMap.get(str);
        if (com.up366.common.StringUtils.isEmptyOrNull(str3)) {
            com.up366.common.log.Logger.info("V8RegisterHelper - not register event : " + str);
            com.up366.common.log.Logger.info(this.eventMap.keySet().toString());
            return;
        }
        this.webView.callJSMethod(str3 + str2);
    }

    @Override // com.up366.mobile.book.helper.interfaces.IRegisterHelper
    public void register(java.lang.String str, java.lang.String str2) {
        this.eventMap.put(str, str2);
    }

    @Override // com.up366.mobile.book.helper.interfaces.IRegisterHelper
    public void unRegister(java.lang.String str) {
        this.eventMap.remove(str);
    }

    @Override // com.up366.mobile.book.helper.interfaces.IRegisterHelper
    public void destroy() {
        this.eventMap.clear();
    }

    public void postMessage(java.lang.String str) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.JSGlobalEvent(str));
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("type");
        final com.alibaba.fastjson.JSONObject jSONObject = object.getJSONObject("detail");
        if (_EVT_GO_LOGIN_.equals(string)) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V8RegisterHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$postMessage$0();
                }
            });
        }
        if (_EVT_GO_BUY_.equals(string)) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V8RegisterHelper$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$postMessage$1(jSONObject);
                }
            });
        }
        if (_EVT_GO_WORDNOTE_.equals(string)) {
            com.up366.mobile.book.helper.OpenHelper.openWordNote(this.context, this.studyActivityInterface.getBookInfoStudy());
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
}
