package com.up366.common.download;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface IUnZipListener {
    public static final int STATE_FAILED = 2;
    public static final int STATE_SUCCESS = 1;
    public static final int STATE_UNZIPING = 0;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FileUnZipErrorCode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FileUnZipState {
    }

    void onUnzip(java.lang.String str, int i, int i2, int i3, int i4, java.lang.String str2);
}
