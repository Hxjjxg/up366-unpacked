package com.up366.mobile.book.exercise.js.v2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RegisterHelperV2 {
    public static final java.lang.String EVENT_AUDIO_FFT_UPDATE = "audiofftupdate";
    public static final java.lang.String EVENT_AUDIO_STATE_CHANGE = "audiostatechange";
    public static final java.lang.String EVENT_FEEDBACK_UPLOAD = "feedbackupload";
    public static final java.lang.String EVENT_HTTP_RESPONSE = "httpresponse";
    public static final java.lang.String EVENT_LOAD_PAPER_DATA = "loadpaperdata";
    public static final java.lang.String EVENT_ON_BACK_PRESSED = "backpressed";
    public static final java.lang.String EVENT_PAUSE = "pause";
    public static final java.lang.String EVENT_PHOTO_RECOGNITION_RESLT = "onOCRFinished";
    public static final java.lang.String EVENT_PICK_PHOTO = "pickphoto";
    public static final java.lang.String EVENT_QUESTION_FEEDBACK_UPLOAD = "questionfeedbackupload";
    public static final java.lang.String EVENT_RECORD_FFT_UPDATE = "recordfftupdate";
    public static final java.lang.String EVENT_RESUME = "resume";
    public static final java.lang.String EVT_BEFORE_GO_BACK = "beforegoback";
    public static final java.lang.String EVT_MESSAGE = "message";
    public static final java.lang.String EVT_ON_TOP_RESUMED_ACTIVITY_CHANGED = "onTopResumedActivityChanged";
    public static final java.lang.String EVT_RECORD_STATE_CHANGE = "recordstatechange";
    private static final java.lang.String _EVT_GO_LOGIN_ = "_EVT_GO_LOGIN_";
    private static final java.lang.String _EVT_REFRESH_JOB_LIST_ = "_EVT_REFRESH_JOB_LIST_";
    private java.util.Map<java.lang.String, java.lang.String> eventMap = new java.util.HashMap();
    private final com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public RegisterHelperV2(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView) {
        this.exerciseHtmlView = exerciseHtmlView;
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
            com.up366.common.log.Logger.info("RegisterHelper - not register event : " + str);
        } else {
            this.webView.callJSMethod(str3 + str2);
        }
    }

    public void register(java.lang.String str, java.lang.String str2) {
        this.eventMap.put(str, str2);
        if (this.exerciseHtmlView != null && "loadpaperdata".equals(str)) {
            this.exerciseHtmlView.notifyPaperDataUpdate();
        }
    }

    public java.lang.String unRegister(java.lang.String str) {
        this.eventMap.remove(str);
        return "unRegisterEvent";
    }

    public void clear() {
        this.eventMap.clear();
    }

    public void postMessage(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("type");
        object.getJSONObject("detail");
        if (_EVT_REFRESH_JOB_LIST_.equals(string)) {
            com.up366.common.log.Logger.info("V7RegisterHelper _EVT_REFRESH_JOB_LIST_");
            com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent();
        }
        if (_EVT_GO_LOGIN_.equals(string)) {
            com.up366.mobile.user.account.login.AccountLoginActivity.open(this.exerciseHtmlView.context);
        }
    }
}
