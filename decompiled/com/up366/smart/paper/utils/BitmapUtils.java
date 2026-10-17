package com.up366.smart.paper.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class BitmapUtils {
    private static final java.lang.String TAG = "BitmapUtils";

    public static android.graphics.Bitmap getBitmap(java.nio.ByteBuffer data, com.up366.smart.paper.utils.FrameMetadata metadata) {
        data.rewind();
        int iLimit = data.limit();
        byte[] bArr = new byte[iLimit];
        data.get(bArr, 0, iLimit);
        try {
            android.graphics.YuvImage yuvImage = new android.graphics.YuvImage(bArr, 17, metadata.getWidth(), metadata.getHeight(), null);
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            yuvImage.compressToJpeg(new android.graphics.Rect(0, 0, metadata.getWidth(), metadata.getHeight()), 80, byteArrayOutputStream);
            android.graphics.Bitmap bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            byteArrayOutputStream.close();
            return bitmapDecodeByteArray;
        } catch (java.lang.Exception e) {
            android.util.Log.e("VisionProcessorBase", "Error: " + e.getMessage());
            return null;
        }
    }

    public static android.graphics.Bitmap getBitmap(androidx.camera.core.ImageProxy image) {
        return getBitmap(yuv420ThreePlanesToNV21(image.getImage().getPlanes(), image.getWidth(), image.getHeight()), new com.up366.smart.paper.utils.FrameMetadata.Builder().setWidth(image.getWidth()).setHeight(image.getHeight()).setRotation(image.getImageInfo().getRotationDegrees()).build());
    }

    public static android.graphics.Bitmap rotateBitmap(android.graphics.Bitmap bitmap, int rotationDegrees, boolean flipX, boolean flipY) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postRotate(rotationDegrees);
        matrix.postScale(flipX ? -1.0f : 1.0f, flipY ? -1.0f : 1.0f);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public static android.graphics.Bitmap getBitmapFromContentUri(android.content.ContentResolver contentResolver, android.net.Uri imageUri) throws java.io.IOException {
        android.graphics.Bitmap bitmap = android.provider.MediaStore.Images.Media.getBitmap(contentResolver, imageUri);
        if (bitmap == null) {
            return null;
        }
        int exifOrientationTag = getExifOrientationTag(contentResolver, imageUri);
        int i = -90;
        boolean z = false;
        boolean z2 = 1;
        switch (exifOrientationTag) {
            case 2:
                i = 0;
                z = true;
                z2 = i;
                break;
            case 3:
                i = 180;
                z2 = 0;
                break;
            case 4:
                i = 0;
                break;
            case 5:
                i = 90;
                z2 = 0;
                z = true;
                break;
            case 6:
                i = 90;
                z2 = 0;
                break;
            case 7:
                z2 = 0;
                z = true;
                break;
            case 8:
                z2 = 0;
                break;
            default:
                i = 0;
                z2 = i;
                break;
        }
        return rotateBitmap(bitmap, i, z, z2);
    }

    private static int getExifOrientationTag(android.content.ContentResolver resolver, android.net.Uri imageUri) {
        if (!com.igexin.sdk.FlymePushReceiver.CONTENT.equals(imageUri.getScheme()) && !"file".equals(imageUri.getScheme())) {
            return 0;
        }
        try {
            java.io.InputStream inputStreamOpenInputStream = resolver.openInputStream(imageUri);
            if (inputStreamOpenInputStream == null) {
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return 0;
            }
            try {
                androidx.exifinterface.media.ExifInterface exifInterface = new androidx.exifinterface.media.ExifInterface(inputStreamOpenInputStream);
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return exifInterface.getAttributeInt("Orientation", 1);
            } finally {
            }
        } catch (java.io.IOException e) {
            android.util.Log.e(TAG, "failed to open file to read rotation meta data: " + imageUri, e);
            return 0;
        }
    }

    private static java.nio.ByteBuffer yuv420ThreePlanesToNV21(android.media.Image.Plane[] yuv420888planes, int width, int height) {
        int i = width * height;
        byte[] bArr = new byte[((i / 4) * 2) + i];
        if (areUVPlanesNV21(yuv420888planes, width, height)) {
            yuv420888planes[0].getBuffer().get(bArr, 0, i);
            java.nio.ByteBuffer buffer = yuv420888planes[1].getBuffer();
            yuv420888planes[2].getBuffer().get(bArr, i, 1);
            buffer.get(bArr, i + 1, ((i * 2) / 4) - 1);
        } else {
            unpackPlane(yuv420888planes[0], width, height, bArr, 0, 1);
            unpackPlane(yuv420888planes[1], width, height, bArr, i + 1, 2);
            unpackPlane(yuv420888planes[2], width, height, bArr, i, 2);
        }
        return java.nio.ByteBuffer.wrap(bArr);
    }

    private static boolean areUVPlanesNV21(android.media.Image.Plane[] planes, int width, int height) {
        int i = width * height;
        java.nio.ByteBuffer buffer = planes[1].getBuffer();
        java.nio.ByteBuffer buffer2 = planes[2].getBuffer();
        int iPosition = buffer2.position();
        int iLimit = buffer.limit();
        buffer2.position(iPosition + 1);
        buffer.limit(iLimit - 1);
        boolean z = buffer2.remaining() == ((i * 2) / 4) - 2 && buffer2.compareTo(buffer) == 0;
        buffer2.position(iPosition);
        buffer.limit(iLimit);
        return z;
    }

    private static void unpackPlane(android.media.Image.Plane plane, int width, int height, byte[] out, int offset, int pixelStride) {
        java.nio.ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int iLimit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (iLimit == 0) {
            return;
        }
        int i = width / (height / iLimit);
        int rowStride = 0;
        for (int i2 = 0; i2 < iLimit; i2++) {
            int pixelStride2 = rowStride;
            for (int i3 = 0; i3 < i; i3++) {
                out[offset] = buffer.get(pixelStride2);
                offset += pixelStride;
                pixelStride2 += plane.getPixelStride();
            }
            rowStride += plane.getRowStride();
        }
    }

    public static void gcBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public static void gcBitmap(android.graphics.Bitmap oldMap, android.graphics.Bitmap newBitmap) {
        if (oldMap == null || oldMap.isRecycled() || oldMap == newBitmap) {
            return;
        }
        oldMap.recycle();
    }
}
