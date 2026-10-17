package com.up366.library.opusencoder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OpusEncoder {
    public native void closeEncoder();

    public native void closeStreamEncoder();

    public native boolean convertWavToOpus(java.lang.String str, java.lang.String str2, int i, int i2, int i3);

    public native boolean encodeFrame(short[] sArr, int i);

    public native byte[] encodeFrameToPacket(short[] sArr, int i);

    public native boolean initEncoder(java.lang.String str, int i, int i2, int i3);

    public native boolean initStreamEncoder(int i, int i2, int i3);

    static {
        java.lang.System.loadLibrary("ogg");
        java.lang.System.loadLibrary("opus");
        java.lang.System.loadLibrary("opusencoder-lib");
    }
}
