package com.up366.smart.paper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class YuvToRgbConverter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private android.renderscript.RenderScript rs;
    private android.renderscript.ScriptIntrinsicYuvToRGB scriptYuvToRgb;
    private int pixelCount = -1;
    private byte[] yuvBuffer = null;
    private android.renderscript.Allocation inputAllocation = null;
    private android.renderscript.Allocation outputAllocation = null;

    public YuvToRgbConverter(android.content.Context context) {
        android.renderscript.RenderScript renderScriptCreate = android.renderscript.RenderScript.create(context);
        this.rs = renderScriptCreate;
        this.scriptYuvToRgb = android.renderscript.ScriptIntrinsicYuvToRGB.create(renderScriptCreate, android.renderscript.Element.U8_4(renderScriptCreate));
    }

    public synchronized void yuvToRgb(android.media.Image image, android.graphics.Bitmap output) {
        if (image == null) {
            return;
        }
        if (this.yuvBuffer == null) {
            this.pixelCount = image.getCropRect().width() * image.getCropRect().height();
            this.yuvBuffer = new byte[(this.pixelCount * android.graphics.ImageFormat.getBitsPerPixel(35)) / 8];
        }
        imageToByteArray(image, this.yuvBuffer);
        if (this.inputAllocation == null) {
            android.renderscript.RenderScript renderScript = this.rs;
            this.inputAllocation = android.renderscript.Allocation.createSized(this.rs, new android.renderscript.Type.Builder(renderScript, android.renderscript.Element.YUV(renderScript)).setYuvFormat(17).create().getElement(), this.yuvBuffer.length);
        }
        if (this.outputAllocation == null) {
            this.outputAllocation = android.renderscript.Allocation.createFromBitmap(this.rs, output);
        }
        this.inputAllocation.copyFrom(this.yuvBuffer);
        this.scriptYuvToRgb.setInput(this.inputAllocation);
        this.scriptYuvToRgb.forEach(this.outputAllocation);
        this.outputAllocation.copyTo(output);
    }

    private void imageToByteArray(android.media.Image image, byte[] outputBuffer) {
        int i;
        int i2;
        com.up366.smart.paper.YuvToRgbConverter yuvToRgbConverter = this;
        android.graphics.Rect cropRect = image.getCropRect();
        android.media.Image.Plane[] planes = image.getPlanes();
        int i3 = 0;
        while (i3 < planes.length) {
            android.media.Image.Plane plane = planes[i3];
            if (i3 == 0) {
                i = 1;
                i2 = 0;
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        i2 = yuvToRgbConverter.pixelCount;
                    }
                    i = 1;
                    i2 = 0;
                } else {
                    i2 = yuvToRgbConverter.pixelCount + 1;
                }
                i = 2;
            }
            java.nio.ByteBuffer buffer = plane.getBuffer();
            int rowStride = plane.getRowStride();
            int pixelStride = plane.getPixelStride();
            android.graphics.Rect rect = i3 == 0 ? cropRect : new android.graphics.Rect(cropRect.left / 2, cropRect.top / 2, cropRect.right / 2, cropRect.bottom / 2);
            int iWidth = rect.width();
            int iHeight = rect.height();
            byte[] bArr = new byte[plane.getRowStride()];
            int i4 = (pixelStride == 1 && i == 1) ? iWidth : ((iWidth - 1) * pixelStride) + 1;
            int i5 = 0;
            while (i5 < iHeight) {
                android.graphics.Rect rect2 = cropRect;
                buffer.position(((rect.top + i5) * rowStride) + (rect.left * pixelStride));
                if (pixelStride == 1 && i == 1) {
                    buffer.get(outputBuffer, i2, i4);
                    i2 += i4;
                } else {
                    buffer.get(bArr, 0, i4);
                    for (int i6 = 0; i6 < iWidth; i6++) {
                        outputBuffer[i2] = bArr[i6 * pixelStride];
                        i2 += i;
                    }
                }
                i5++;
                cropRect = rect2;
            }
            i3++;
            yuvToRgbConverter = this;
        }
    }
}
