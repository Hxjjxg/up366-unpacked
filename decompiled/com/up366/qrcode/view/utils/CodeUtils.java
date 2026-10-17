package com.up366.qrcode.view.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CodeUtils {
    public static final java.lang.String LAYOUT_ID = "layout_id";
    public static final int RESULT_FAILED = 2;
    public static final java.lang.String RESULT_STRING = "result_string";
    public static final int RESULT_SUCCESS = 1;
    public static final java.lang.String RESULT_TYPE = "result_type";

    public interface AnalyzeCallback {
        void onAnalyzeFailed();

        void onAnalyzeSuccess(android.graphics.Bitmap bitmap, java.lang.String str);
    }

    public static void analyzeBitmap(java.lang.String str, com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback analyzeCallback) {
        com.google.zxing.Result resultDecodeWithState;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i = (int) (options.outHeight / 400.0f);
        options.inSampleSize = i > 0 ? i : 1;
        android.graphics.Bitmap bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(str, options);
        com.google.zxing.MultiFormatReader multiFormatReader = new com.google.zxing.MultiFormatReader();
        java.util.Hashtable hashtable = new java.util.Hashtable(2);
        java.util.Vector vector = new java.util.Vector();
        if (vector.isEmpty()) {
            vector = new java.util.Vector();
            vector.addAll(com.up366.qrcode.view.decoding.DecodeFormatManager.ONE_D_FORMATS);
            vector.addAll(com.up366.qrcode.view.decoding.DecodeFormatManager.QR_CODE_FORMATS);
            vector.addAll(com.up366.qrcode.view.decoding.DecodeFormatManager.DATA_MATRIX_FORMATS);
        }
        hashtable.put(com.google.zxing.DecodeHintType.POSSIBLE_FORMATS, vector);
        multiFormatReader.setHints(hashtable);
        try {
            resultDecodeWithState = multiFormatReader.decodeWithState(new com.google.zxing.BinaryBitmap(new com.google.zxing.common.HybridBinarizer(new com.up366.qrcode.view.camera.BitmapLuminanceSource(bitmapDecodeFile))));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            resultDecodeWithState = null;
        }
        if (resultDecodeWithState != null) {
            if (analyzeCallback != null) {
                analyzeCallback.onAnalyzeSuccess(bitmapDecodeFile, resultDecodeWithState.getText());
            }
        } else if (analyzeCallback != null) {
            analyzeCallback.onAnalyzeFailed();
        }
    }

    public static android.graphics.Bitmap createImage(java.lang.String str, int i, int i2, android.graphics.Bitmap bitmap) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            android.graphics.Bitmap scaleLogo = getScaleLogo(bitmap, i, i2);
            int i7 = i / 2;
            int i8 = i2 / 2;
            int i9 = 0;
            if (scaleLogo != null) {
                int width = scaleLogo.getWidth();
                int height = scaleLogo.getHeight();
                i5 = width;
                i6 = height;
                i3 = (i - width) / 2;
                i4 = (i2 - height) / 2;
            } else {
                i3 = i7;
                i4 = i8;
                i5 = 0;
                i6 = 0;
            }
            java.util.Hashtable hashtable = new java.util.Hashtable();
            hashtable.put(com.google.zxing.EncodeHintType.CHARACTER_SET, com.igexin.push.g.s.b);
            hashtable.put(com.google.zxing.EncodeHintType.ERROR_CORRECTION, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.H);
            hashtable.put(com.google.zxing.EncodeHintType.MARGIN, 0);
            com.google.zxing.common.BitMatrix bitMatrixEncode = new com.google.zxing.qrcode.QRCodeWriter().encode(str, com.google.zxing.BarcodeFormat.QR_CODE, i, i2, hashtable);
            int[] iArr = new int[i * i2];
            int i10 = 0;
            while (i10 < i2) {
                for (int i11 = i9; i11 < i; i11++) {
                    int i12 = com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR;
                    if (i11 >= i3 && i11 < i3 + i5 && i10 >= i4 && i10 < i4 + i6) {
                        int pixel = scaleLogo.getPixel(i11 - i3, i10 - i4);
                        if (pixel != 0) {
                            i12 = pixel;
                        } else if (!bitMatrixEncode.get(i11, i10)) {
                            i12 = -1;
                        }
                        iArr[(i10 * i) + i11] = i12;
                    } else if (bitMatrixEncode.get(i11, i10)) {
                        iArr[(i10 * i) + i11] = -16777216;
                    } else {
                        iArr[(i10 * i) + i11] = -1;
                    }
                }
                i10++;
                i9 = 0;
            }
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
            return bitmapCreateBitmap;
        } catch (com.google.zxing.WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static android.graphics.Bitmap getScaleLogo(android.graphics.Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        float fMin = java.lang.Math.min(((i * 1.0f) / 5.0f) / bitmap.getWidth(), ((i2 * 1.0f) / 5.0f) / bitmap.getHeight());
        matrix.postScale(fMin, fMin);
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void setFragmentArgs(com.up366.qrcode.view.activity.CaptureFragment captureFragment, int i) {
        if (captureFragment == null || i == -1) {
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt(LAYOUT_ID, i);
        captureFragment.setArguments(bundle);
    }

    public static void isLightEnable(boolean z) {
        if (z) {
            android.hardware.Camera camera = com.up366.qrcode.view.camera.CameraManager.get().getCamera();
            if (camera != null) {
                android.hardware.Camera.Parameters parameters = camera.getParameters();
                parameters.setFlashMode("torch");
                camera.setParameters(parameters);
                return;
            }
            return;
        }
        android.hardware.Camera camera2 = com.up366.qrcode.view.camera.CameraManager.get().getCamera();
        if (camera2 != null) {
            android.hardware.Camera.Parameters parameters2 = camera2.getParameters();
            parameters2.setFlashMode("off");
            camera2.setParameters(parameters2);
        }
    }
}
