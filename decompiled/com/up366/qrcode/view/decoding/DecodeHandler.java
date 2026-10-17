package com.up366.qrcode.view.decoding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class DecodeHandler extends android.os.Handler {
    private static final java.lang.String TAG = "DecodeHandler";
    private final com.up366.qrcode.view.activity.CaptureFragment fragment;
    private final com.google.zxing.MultiFormatReader multiFormatReader;

    DecodeHandler(com.up366.qrcode.view.activity.CaptureFragment captureFragment, java.util.Hashtable<com.google.zxing.DecodeHintType, java.lang.Object> hashtable) {
        com.google.zxing.MultiFormatReader multiFormatReader = new com.google.zxing.MultiFormatReader();
        this.multiFormatReader = multiFormatReader;
        multiFormatReader.setHints(hashtable);
        this.fragment = captureFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        if (message.what == com.up366.qrcode.R.id.decode) {
            decode((byte[]) message.obj, message.arg1, message.arg2);
        } else if (message.what == com.up366.qrcode.R.id.quit) {
            android.os.Looper.myLooper().quit();
        }
    }

    private void decode(byte[] bArr, int i, int i2) {
        com.google.zxing.Result resultDecodeWithState;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        com.up366.qrcode.view.camera.PlanarYUVLuminanceSource planarYUVLuminanceSourceBuildLuminanceSource = com.up366.qrcode.view.camera.CameraManager.get().buildLuminanceSource(bArr2, i2, i);
        try {
            resultDecodeWithState = this.multiFormatReader.decodeWithState(new com.google.zxing.BinaryBitmap(new com.google.zxing.common.HybridBinarizer(planarYUVLuminanceSourceBuildLuminanceSource)));
            this.multiFormatReader.reset();
        } catch (com.google.zxing.ReaderException unused) {
            this.multiFormatReader.reset();
            resultDecodeWithState = null;
        } catch (java.lang.Throwable th) {
            this.multiFormatReader.reset();
            throw th;
        }
        if (resultDecodeWithState != null) {
            long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
            android.util.Log.d(TAG, "Found barcode (" + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms):\n" + resultDecodeWithState.toString());
            android.os.Message messageObtain = android.os.Message.obtain(this.fragment.getHandler(), com.up366.qrcode.R.id.decode_succeeded, resultDecodeWithState);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelable(com.up366.qrcode.view.decoding.DecodeThread.BARCODE_BITMAP, planarYUVLuminanceSourceBuildLuminanceSource.renderCroppedGreyscaleBitmap());
            messageObtain.setData(bundle);
            messageObtain.sendToTarget();
            return;
        }
        android.os.Message.obtain(this.fragment.getHandler(), com.up366.qrcode.R.id.decode_failed).sendToTarget();
    }
}
