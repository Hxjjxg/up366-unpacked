package com.up366.yuv;

/* JADX INFO: compiled from: YuvUtils.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Ja\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006H\u0086 ¨\u0006\u0012"}, d2 = {"Lcom/up366/yuv/YuvUtils;", "", "()V", "convertYUV420ToRGB", "", "yBuffer", "Ljava/nio/ByteBuffer;", "uBuffer", "vBuffer", "width", "", "height", "yStride", "uStride", "vStride", "uPixelStride", "vPixelStride", "rgbBuffer", "yuv_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class YuvUtils {
    public static final com.up366.yuv.YuvUtils INSTANCE = new com.up366.yuv.YuvUtils();

    public final native void convertYUV420ToRGB(java.nio.ByteBuffer yBuffer, java.nio.ByteBuffer uBuffer, java.nio.ByteBuffer vBuffer, int width, int height, int yStride, int uStride, int vStride, int uPixelStride, int vPixelStride, java.nio.ByteBuffer rgbBuffer);

    private YuvUtils() {
    }

    static {
        java.lang.System.loadLibrary("yuvconvert2");
    }
}
