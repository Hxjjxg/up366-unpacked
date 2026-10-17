package com.up366.mobile.book.exercise.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RegisterHelper {
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
    public static final java.lang.String EVENT_RECORD_STATE_CHANGE = "recorderstatechange";
    public static final java.lang.String EVENT_RECORD_STATE_CHANGEV1 = "recorderstatechangev1";
    public static final java.lang.String EVENT_RESUME = "resume";
    private java.util.Map<java.lang.String, java.lang.String> eventMap = new java.util.HashMap();
    private final com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView;
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public RegisterHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView) {
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
            this.webView.callJSMethodIgnoreBridge(str3 + str2);
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
}
