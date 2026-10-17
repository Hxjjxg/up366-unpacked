package com.up366.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class EncryptUtil {
    public static native java.lang.String decryptDk(java.lang.String str, java.lang.String str2);

    public static native byte[] decryptGcmJs(byte[] bArr, java.lang.String str);

    public static native byte[] decryptLegacyJs(byte[] bArr);

    public static native java.lang.String decryptMk(java.lang.String str);

    public static native byte[] enc(byte[] bArr, int i);

    public static native java.lang.String errMsg();

    public static native boolean generateValid(java.lang.String str);

    public static native boolean matchMkEdk(java.lang.String str, java.lang.String str2);

    public static native java.lang.String readDkFromValid(java.lang.String str);

    public static native boolean saveValidExt(java.lang.String str, java.lang.String str2, java.lang.String str3);

    public static native boolean valid(java.lang.String str);

    static {
        java.lang.System.loadLibrary("native-lib");
    }
}
