package com.up366.common.download;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface IDownloadStateChangeListener {
    public static final int STATE_CANCEL = 3;
    public static final int STATE_DOWNLOADING = 1;
    public static final int STATE_EMPTY = 4;
    public static final int STATE_ERROR = -1;
    public static final int STATE_SUCCESS = 2;
    public static final int STATE_WAIT = 0;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface OkHttpDownloadErrorCode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface OkHttpDownloadState {
    }

    void onStateChange(int i, long j, long j2, int i2, java.lang.String str);
}
