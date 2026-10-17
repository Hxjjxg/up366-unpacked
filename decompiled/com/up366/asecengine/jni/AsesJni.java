package com.up366.asecengine.jni;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsesJni {
    private static final java.lang.String TAG = "AsesJni";

    private native byte[] LsxAsesVoasGetTextNative(java.lang.String str);

    public native java.lang.String LsxAsesGetErrorInfo(int i);

    public native java.lang.String LsxAsesGetParam(java.lang.String str, java.lang.String str2);

    public native java.lang.String LsxAsesSessionBegin(java.lang.String str, java.lang.String str2);

    public native int LsxAsesSessionDataIn(java.lang.String str, java.lang.String str2, int i, java.lang.String str3);

    public native int LsxAsesSessionEnd(java.lang.String str);

    public native java.lang.String LsxAsesSessionGetResult(java.lang.String str, java.lang.String str2);

    public native java.lang.String LsxAsesSessionGetSubResource(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5);

    public native int LsxAsesSessionSetParam(java.lang.String str, java.lang.String str2, java.lang.String str3);

    public native int[] LsxAsesSessionSpeechIn(java.lang.String str, byte[] bArr, int i, java.lang.String str2);

    public native int LsxAsesSetParam(java.lang.String str, java.lang.String str2, java.lang.String str3);

    public native java.lang.String LsxAsesStart(java.lang.String str);

    public native int LsxAsesStop(java.lang.String str);

    public native java.lang.String LsxAsesVersion();

    public native int[] LsxAsesVoasGetTextSplit(java.lang.String str, int i);

    public native int LsxAsesVoasGetTextSplitCount(java.lang.String str);

    public native int LsxAsesVoasIsKeyWord(java.lang.String str, int i);

    public native java.lang.String LsxAsesVoasLoadNet(byte[] bArr, int i, java.lang.String str);

    public native int LsxAsesVoasUnLoadNet(java.lang.String str);

    public native void delNoice(byte[] bArr, int i, int i2);

    public native boolean fft(int i, int i2, byte[] bArr, int i3, byte[] bArr2, int i4);

    public native int getEngineErrorCode();

    static {
        try {
            java.lang.System.loadLibrary("c++_shared");
            java.lang.System.loadLibrary("lsx-ases-export-4.6.1");
            java.lang.System.loadLibrary("ases_engine");
        } catch (java.lang.Throwable th) {
            android.util.Log.e(TAG, th.getMessage(), th);
            com.up366.common.log.Logger.error("TAG - AsesJni - static initializer - ", th);
        }
    }

    public java.lang.String LsxAsesVoasGetText(java.lang.String str) {
        try {
            return new java.lang.String(LsxAsesVoasGetTextNative(str), "GBK");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return "nop!";
        }
    }

    public void checkEngineState() {
        int engineErrorCode = getEngineErrorCode();
        if (engineErrorCode != 0) {
            com.up366.common.log.Logger.error(new java.lang.IllegalStateException("TAG - AsesJni - checkEngineState - code : " + engineErrorCode + " info : " + LsxAsesGetErrorInfo(engineErrorCode)));
        }
    }
}
