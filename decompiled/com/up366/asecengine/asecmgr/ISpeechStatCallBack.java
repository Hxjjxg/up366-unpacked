package com.up366.asecengine.asecmgr;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface ISpeechStatCallBack {
    public static final int RECORD_STATE_BEGIN = 0;
    public static final int RECORD_STATE_FAILED = -1;
    public static final int RECORD_STATE_FORCE_OVER = 99;
    public static final int RECORD_STATE_ONLINE_FALLBACK_BEGIN = 6;
    public static final int RECORD_STATE_ONLINE_FALLBACK_FAILED = 7;
    public static final int RECORD_STATE_ONLINE_FALLBACK_SUCCESS = 8;
    public static final int RECORD_STATE_ONLINE_RESUME_REQUIRED = 9;
    public static final int RECORD_STATE_ONLINE_STOP_RESUME_BEGIN = 10;
    public static final int RECORD_STATE_ONLINE_UPLOAD_SUCCESS = 5;
    public static final int RECORD_STATE_OVER = 4;
    public static final int RECORD_STATE_RECORD_OVER = 2;
    public static final int RECORD_STATE_RECORD_STOP = 1;
    public static final int RECORD_STATE_SCORE = 3;

    void onMediaStateResult(com.up366.asecengine.englishengine.AsecSession asecSession, int i);
}
