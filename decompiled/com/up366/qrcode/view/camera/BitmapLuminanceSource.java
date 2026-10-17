package com.up366.qrcode.view.camera;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class BitmapLuminanceSource extends com.google.zxing.LuminanceSource {
    private byte[] bitmapPixels;

    public BitmapLuminanceSource(android.graphics.Bitmap bitmap) {
        super(bitmap.getWidth(), bitmap.getHeight());
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        this.bitmapPixels = new byte[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(iArr, 0, getWidth(), 0, 0, getWidth(), getHeight());
        for (int i = 0; i < width; i++) {
            this.bitmapPixels[i] = (byte) iArr[i];
        }
    }

    public byte[] getMatrix() {
        return this.bitmapPixels;
    }

    public byte[] getRow(int i, byte[] bArr) {
        java.lang.System.arraycopy(this.bitmapPixels, i * getWidth(), bArr, 0, getWidth());
        return bArr;
    }
}
