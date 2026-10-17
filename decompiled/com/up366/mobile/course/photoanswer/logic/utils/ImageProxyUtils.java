package com.up366.mobile.course.photoanswer.logic.utils;

/* JADX INFO: compiled from: ImageProxyUtils.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/utils/ImageProxyUtils;", "", "<init>", "()V", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageProxyUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.course.photoanswer.logic.utils.ImageProxyUtils.Companion INSTANCE = new com.up366.mobile.course.photoanswer.logic.utils.ImageProxyUtils.Companion(null);

    /* JADX INFO: compiled from: ImageProxyUtils.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u0002¨\u0006\u000f"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/utils/ImageProxyUtils$Companion;", "", "<init>", "()V", "convertRgbaToRgb", "", "rgbaData", "width", "", "height", "convertBitmapRgbaToRgb", "baseBitmap", "Landroid/graphics/Bitmap;", "convertBitmapRgbaToRgbChunked", "chunkHeight", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final byte[] convertRgbaToRgb(byte[] rgbaData, int width, int height) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rgbaData, "rgbaData");
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(width * height * 3);
            byte[] bArr = new byte[width * 3];
            int i = 0;
            for (int i2 = 0; i2 < height; i2++) {
                int i3 = 0;
                for (int i4 = 0; i4 < width; i4++) {
                    bArr[i3] = rgbaData[i];
                    int i5 = i3 + 2;
                    bArr[i3 + 1] = rgbaData[i + 1];
                    i3 += 3;
                    bArr[i5] = rgbaData[i + 2];
                    i += 4;
                }
                byteArrayOutputStream.write(bArr, 0, i3);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            return byteArray;
        }

        public final byte[] convertBitmapRgbaToRgb(android.graphics.Bitmap baseBitmap) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseBitmap, "baseBitmap");
            return convertBitmapRgbaToRgbChunked(baseBitmap, 100);
        }

        static /* synthetic */ byte[] convertBitmapRgbaToRgbChunked$default(com.up366.mobile.course.photoanswer.logic.utils.ImageProxyUtils.Companion companion, android.graphics.Bitmap bitmap, int i, int i2, java.lang.Object obj) {
            if ((i2 & 2) != 0) {
                i = 100;
            }
            return companion.convertBitmapRgbaToRgbChunked(bitmap, i);
        }

        private final byte[] convertBitmapRgbaToRgbChunked(android.graphics.Bitmap baseBitmap, int chunkHeight) {
            int i = chunkHeight;
            int width = baseBitmap.getWidth();
            int height = baseBitmap.getHeight();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(width * height * 3);
            byte[] bArr = new byte[width * i * 3];
            kotlin.ranges.IntProgression intProgressionStep = kotlin.ranges.RangesKt.step(kotlin.ranges.RangesKt.until(0, height), i);
            int first = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                int i2 = first;
                while (true) {
                    int iMin = java.lang.Math.min(i, height - i2);
                    int i3 = width * iMin;
                    int[] iArr = new int[i3];
                    int i4 = i2;
                    baseBitmap.getPixels(iArr, 0, width, 0, i2, width, iMin);
                    int i5 = 0;
                    for (int i6 = 0; i6 < i3; i6++) {
                        int i7 = iArr[i6];
                        bArr[i5] = (byte) ((i7 >> 16) & 255);
                        int i8 = i5 + 2;
                        bArr[i5 + 1] = (byte) ((i7 >> 8) & 255);
                        i5 += 3;
                        bArr[i8] = (byte) (i7 & 255);
                    }
                    byteArrayOutputStream.write(bArr, 0, i5);
                    if (i4 == last) {
                        break;
                    }
                    i2 = i4 + step;
                    i = chunkHeight;
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            return byteArray;
        }
    }
}
