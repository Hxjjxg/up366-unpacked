package com.up366.mobile.book.helper.interfaces;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface IRegisterHelper {
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
    public static final java.lang.String _EVT_GO_STUDYTASK_ = "_EVT_GO_STUDYTASK_";
    public static final java.lang.String _EVT_IM_ON_MESSAGE_ = "_EVT_IM_ON_MESSAGE_";
    public static final java.lang.String _EVT_UPDATE_COOKIE_ = "_EVT_UPDATE_COOKIE_";
    public static final java.lang.String _SUBMIT_TASK_ = "_SUBMIT_TASK_";

    void callJsEvent(java.lang.String str);

    void callJsEvent(java.lang.String str, java.lang.String str2);

    void callJsEvent(java.lang.String str, java.lang.String str2, java.lang.Object... objArr);

    void destroy();

    boolean hasRegister(java.lang.String str);

    void register(java.lang.String str, java.lang.String str2);

    void unRegister(java.lang.String str);
}
