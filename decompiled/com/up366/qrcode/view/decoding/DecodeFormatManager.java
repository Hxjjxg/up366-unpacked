package com.up366.qrcode.view.decoding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DecodeFormatManager {
    private static final java.util.regex.Pattern COMMA_PATTERN = java.util.regex.Pattern.compile(com.igexin.push.core.b.an);
    public static final java.util.Vector<com.google.zxing.BarcodeFormat> DATA_MATRIX_FORMATS;
    public static final java.util.Vector<com.google.zxing.BarcodeFormat> ONE_D_FORMATS;
    public static final java.util.Vector<com.google.zxing.BarcodeFormat> PRODUCT_FORMATS;
    public static final java.util.Vector<com.google.zxing.BarcodeFormat> QR_CODE_FORMATS;

    static {
        java.util.Vector<com.google.zxing.BarcodeFormat> vector = new java.util.Vector<>(5);
        PRODUCT_FORMATS = vector;
        vector.add(com.google.zxing.BarcodeFormat.UPC_A);
        vector.add(com.google.zxing.BarcodeFormat.UPC_E);
        vector.add(com.google.zxing.BarcodeFormat.EAN_13);
        vector.add(com.google.zxing.BarcodeFormat.EAN_8);
        java.util.Vector<com.google.zxing.BarcodeFormat> vector2 = new java.util.Vector<>(vector.size() + 4);
        ONE_D_FORMATS = vector2;
        vector2.addAll(vector);
        vector2.add(com.google.zxing.BarcodeFormat.CODE_39);
        vector2.add(com.google.zxing.BarcodeFormat.CODE_93);
        vector2.add(com.google.zxing.BarcodeFormat.CODE_128);
        vector2.add(com.google.zxing.BarcodeFormat.ITF);
        java.util.Vector<com.google.zxing.BarcodeFormat> vector3 = new java.util.Vector<>(1);
        QR_CODE_FORMATS = vector3;
        vector3.add(com.google.zxing.BarcodeFormat.QR_CODE);
        java.util.Vector<com.google.zxing.BarcodeFormat> vector4 = new java.util.Vector<>(1);
        DATA_MATRIX_FORMATS = vector4;
        vector4.add(com.google.zxing.BarcodeFormat.DATA_MATRIX);
    }

    private DecodeFormatManager() {
    }

    static java.util.Vector<com.google.zxing.BarcodeFormat> parseDecodeFormats(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.up366.qrcode.view.decoding.Intents.Scan.SCAN_FORMATS);
        return parseDecodeFormats(stringExtra != null ? java.util.Arrays.asList(COMMA_PATTERN.split(stringExtra)) : null, intent.getStringExtra(com.up366.qrcode.view.decoding.Intents.Scan.MODE));
    }

    static java.util.Vector<com.google.zxing.BarcodeFormat> parseDecodeFormats(android.net.Uri uri) {
        java.util.List<java.lang.String> queryParameters = uri.getQueryParameters(com.up366.qrcode.view.decoding.Intents.Scan.SCAN_FORMATS);
        if (queryParameters != null && queryParameters.size() == 1 && queryParameters.get(0) != null) {
            queryParameters = java.util.Arrays.asList(COMMA_PATTERN.split(queryParameters.get(0)));
        }
        return parseDecodeFormats(queryParameters, uri.getQueryParameter(com.up366.qrcode.view.decoding.Intents.Scan.MODE));
    }

    private static java.util.Vector<com.google.zxing.BarcodeFormat> parseDecodeFormats(java.lang.Iterable<java.lang.String> iterable, java.lang.String str) {
        if (iterable != null) {
            java.util.Vector<com.google.zxing.BarcodeFormat> vector = new java.util.Vector<>();
            try {
                java.util.Iterator<java.lang.String> it = iterable.iterator();
                while (it.hasNext()) {
                    vector.add(com.google.zxing.BarcodeFormat.valueOf(it.next()));
                }
                return vector;
            } catch (java.lang.IllegalArgumentException unused) {
            }
        }
        if (str == null) {
            return null;
        }
        if (com.up366.qrcode.view.decoding.Intents.Scan.PRODUCT_MODE.equals(str)) {
            return PRODUCT_FORMATS;
        }
        if (com.up366.qrcode.view.decoding.Intents.Scan.QR_CODE_MODE.equals(str)) {
            return QR_CODE_FORMATS;
        }
        if (com.up366.qrcode.view.decoding.Intents.Scan.DATA_MATRIX_MODE.equals(str)) {
            return DATA_MATRIX_FORMATS;
        }
        if (com.up366.qrcode.view.decoding.Intents.Scan.ONE_D_MODE.equals(str)) {
            return ONE_D_FORMATS;
        }
        return null;
    }
}
