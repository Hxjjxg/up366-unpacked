package com.up366.qrcode.view.decoding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class DecodeThread extends java.lang.Thread {
    public static final java.lang.String BARCODE_BITMAP = "barcode_bitmap";
    private final com.up366.qrcode.view.activity.CaptureFragment fragment;
    private android.os.Handler handler;
    private final java.util.concurrent.CountDownLatch handlerInitLatch = new java.util.concurrent.CountDownLatch(1);
    private final java.util.Hashtable<com.google.zxing.DecodeHintType, java.lang.Object> hints;

    DecodeThread(com.up366.qrcode.view.activity.CaptureFragment captureFragment, java.util.Vector<com.google.zxing.BarcodeFormat> vector, java.lang.String str, com.google.zxing.ResultPointCallback resultPointCallback) {
        this.fragment = captureFragment;
        java.util.Hashtable<com.google.zxing.DecodeHintType, java.lang.Object> hashtable = new java.util.Hashtable<>(3);
        this.hints = hashtable;
        if (vector == null || vector.isEmpty()) {
            vector = new java.util.Vector<>();
            vector.addAll(com.up366.qrcode.view.decoding.DecodeFormatManager.ONE_D_FORMATS);
            vector.addAll(com.up366.qrcode.view.decoding.DecodeFormatManager.QR_CODE_FORMATS);
            vector.addAll(com.up366.qrcode.view.decoding.DecodeFormatManager.DATA_MATRIX_FORMATS);
        }
        hashtable.put(com.google.zxing.DecodeHintType.POSSIBLE_FORMATS, vector);
        if (str != null) {
            hashtable.put(com.google.zxing.DecodeHintType.CHARACTER_SET, str);
        }
        hashtable.put(com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultPointCallback);
    }

    android.os.Handler getHandler() {
        try {
            this.handlerInitLatch.await();
        } catch (java.lang.InterruptedException unused) {
        }
        return this.handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        android.os.Looper.prepare();
        this.handler = new com.up366.qrcode.view.decoding.DecodeHandler(this.fragment, this.hints);
        this.handlerInitLatch.countDown();
        android.os.Looper.loop();
    }
}
