package com.up366.mediamuxlibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FFJni {
    public static native int exec(int i, java.lang.String[] strArr);

    static {
        java.lang.System.loadLibrary("mux_ffmpeg");
        java.lang.System.loadLibrary("ffmpeg_wrap");
    }
}
