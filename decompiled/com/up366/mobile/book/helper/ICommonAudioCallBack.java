package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface ICommonAudioCallBack {
    public static final int AUDIO_STATE_LOADING = 9;
    public static final int AUDIO_STATE_OVER = 4;
    public static final int AUDIO_STATE_PAUSE = 1;
    public static final int AUDIO_STATE_START = 0;
    public static final int STAT_EX_APP_DEFAULT = 0;
    public static final int STAT_EX_APP_PAUSE = 1;
    public static final int STAT_EX_APP_STOP = 2;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AudioEXState {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AudioState {
    }

    void onMediaStateResult(java.lang.String str, int i, int i2);

    void onWavUpdate(java.lang.String str, byte[] bArr);
}
