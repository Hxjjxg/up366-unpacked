package com.up366.smartscan2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SmartScan2 {
    public static final int ERROR_MODEL_PREPARE_FAILED = -1001;

    private static native int nativeFindCorner(byte[] bArr, int i, int i2, float[] fArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4);

    private static native int nativeFindCornerByFile(java.lang.String str, float[] fArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4);

    private static native int nativeFindCornerDirect(byte[] bArr, int i, int i2, float[] fArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4);

    public static native int nativeFindCornerFromBitmap(android.graphics.Bitmap bitmap, float[] fArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4);

    private static native int nativeFreeImageInfo(java.lang.String str);

    private static native com.up366.smartscan2.PaperCodeResult nativeRecognizePaperCode(java.lang.String str);

    private static native int nativeScanExit();

    private static native int nativeScanInit(java.lang.String str);

    private static native java.lang.String nativeScanOneImage(boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, boolean z2, java.lang.String str5, boolean z3, boolean z4, int i);

    static {
        java.lang.System.loadLibrary("smartscan2");
    }

    public static int init(android.content.Context context) {
        if (!com.up366.smartscan2.SmartScan2ConfigHelper.prepareModel(context)) {
            com.up366.common.log.Logger.error("SmartScan2 init failed: model is not ready");
            return -1001;
        }
        return nativeScanInit(com.up366.smartscan2.SmartScan2ConfigHelper.getConfigFileDirPath(context));
    }

    public static int freeImageInfo(java.lang.String str) {
        return nativeFreeImageInfo(str);
    }

    public static com.up366.smartscan2.PaperCodeResult recognizePaperCode(java.lang.String str) {
        return nativeRecognizePaperCode(str);
    }

    public static int scanExit() {
        return nativeScanExit();
    }

    public static java.lang.String scanOneImage(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, boolean z, java.lang.String str5, int i) {
        return scanOneImage(true, str, str2, str3, str4, z, str5, false, false, i);
    }

    public static java.lang.String scanOneImageNoStrictCheck(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, boolean z, java.lang.String str5, int i) {
        return scanOneImage(false, str, str2, str3, str4, z, str5, false, false, i);
    }

    public static java.lang.String scanOneImage(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, boolean z, java.lang.String str5, int i, boolean z2) {
        return scanOneImage(true, str, str2, str3, str4, z, str5, false, z2, i);
    }

    public static java.lang.String scanOneImageNoStrictCheck(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, boolean z, java.lang.String str5, int i, boolean z2) {
        return scanOneImage(false, str, str2, str3, str4, z, str5, false, z2, i);
    }

    public static java.lang.String scanOneImage(boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, boolean z2, java.lang.String str5, boolean z3, boolean z4, int i) {
        return nativeScanOneImage(z, str, str2, str3, str4, z2, str5, z3, z4, i);
    }

    public static void findConner(java.lang.String str, com.up366.smartscan2.ConnerData connerData) {
        connerData.reset();
        connerData.setErrorCode(nativeFindCornerByFile(str, connerData.getConfidence(), connerData.getTopLeft(), connerData.getTopRight(), connerData.getBottomLeft(), connerData.getBottomRight()));
    }

    public static void findConner(byte[] bArr, int i, int i2, com.up366.smartscan2.ConnerData connerData) {
        connerData.reset();
        connerData.setErrorCode(nativeFindCorner(bArr, i, i2, connerData.getConfidence(), connerData.getTopLeft(), connerData.getTopRight(), connerData.getBottomLeft(), connerData.getBottomRight()));
    }

    public static com.up366.smartscan2.ConnerData findConnerDirect(byte[] bArr, int i, int i2) {
        com.up366.smartscan2.ConnerData connerData = new com.up366.smartscan2.ConnerData();
        connerData.setErrorCode(nativeFindCornerDirect(bArr, i, i2, connerData.getConfidence(), connerData.getTopLeft(), connerData.getTopRight(), connerData.getBottomLeft(), connerData.getBottomRight()));
        return connerData;
    }

    public static com.up366.smartscan2.ConnerData findConnerBitmap(android.graphics.Bitmap bitmap) {
        com.up366.smartscan2.ConnerData connerData = new com.up366.smartscan2.ConnerData();
        connerData.setErrorCode(nativeFindCornerFromBitmap(bitmap, connerData.getConfidence(), connerData.getTopLeft(), connerData.getTopRight(), connerData.getBottomLeft(), connerData.getBottomRight()));
        return connerData;
    }
}
