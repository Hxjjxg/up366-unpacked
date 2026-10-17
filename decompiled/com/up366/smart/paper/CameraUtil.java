package com.up366.smart.paper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CameraUtil {
    public static java.util.List<org.opencv.core.Point> changePoints(java.util.List<org.opencv.core.Point> points, android.graphics.Matrix matrix) {
        if (points != null && points.size() == 4) {
            float[] fArr = new float[8];
            for (int i = 0; i < 4; i++) {
                org.opencv.core.Point point = points.get(i);
                int i2 = i * 2;
                fArr[i2] = (float) point.x;
                fArr[i2 + 1] = (float) point.y;
            }
            matrix.mapPoints(fArr);
            points = new java.util.ArrayList<>(4);
            for (int i3 = 0; i3 < 4; i3++) {
                int i4 = i3 * 2;
                points.add(new org.opencv.core.Point(fArr[i4], fArr[i4 + 1]));
            }
        }
        return points;
    }

    public static android.graphics.Matrix getMappingMatrix(android.graphics.Rect cropRect, int rotationDegrees, int width, int height) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        float[] fArr = {cropRect.left, cropRect.top, cropRect.right, cropRect.top, cropRect.right, cropRect.bottom, cropRect.left, cropRect.bottom};
        float[] fArr2 = new float[8];
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        float f = width;
        fArr2[2] = f;
        fArr2[3] = 0.0f;
        fArr2[4] = f;
        float f2 = height;
        fArr2[5] = f2;
        fArr2[6] = 0.0f;
        fArr2[7] = f2;
        int i = (rotationDegrees / 90) * 2;
        float[] fArr3 = (float[]) fArr2.clone();
        for (int i2 = 0; i2 < 8; i2++) {
            fArr2[i2] = fArr3[(i2 + i) % 8];
        }
        matrix.setPolyToPoly(fArr, 0, fArr2, 0, 4);
        return matrix;
    }

    public static android.graphics.Bitmap JpegImageToBitmap(androidx.camera.core.ImageProxy image) {
        if (image.getImage() == null) {
            return null;
        }
        java.nio.ByteBuffer buffer = image.getImage().getPlanes()[0].getBuffer();
        buffer.rewind();
        int iCapacity = buffer.capacity();
        byte[] bArr = new byte[iCapacity];
        buffer.get(bArr);
        android.graphics.Rect cropRect = image.getCropRect();
        android.graphics.Bitmap bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, iCapacity);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmapDecodeByteArray, cropRect.left, cropRect.top, cropRect.width(), cropRect.height());
        gcBitmap(bitmapDecodeByteArray, bitmapCreateBitmap);
        return image.getImageInfo().getRotationDegrees() != 0 ? bitmapRotate(bitmapCreateBitmap, image.getImageInfo().getRotationDegrees()) : bitmapCreateBitmap;
    }

    public static byte[] jpegImageToJpegByteArray(androidx.camera.core.ImageProxy image) {
        java.nio.ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.rewind();
        buffer.get(bArr);
        return bArr;
    }

    public static org.opencv.core.Mat imageToCropMat(androidx.camera.core.ImageProxy image, java.lang.String imagePath) {
        saveByteArrayToJpeg(imagePath, jpegImageToJpegByteArray(image));
        return com.up366.smart.paper.opencv.OpencvCrop.cropAndRotate(imagePath, image);
    }

    public static void imageToCropMatAndSave(androidx.camera.core.ImageProxy image, java.lang.String imagePath, com.up366.smart.paper.BitmapAnalyzeResult analyzeResult, int reduceRatio) {
        saveByteArrayToJpeg(imagePath, jpegImageToJpegByteArray(image));
        org.opencv.core.Mat matCropAndRotate = com.up366.smart.paper.opencv.OpencvCrop.cropAndRotate(imagePath, image);
        org.opencv.core.Mat matCrop = com.up366.smart.paper.opencv.OpencvCrop.crop(matCropAndRotate, changePoints(analyzeResult.getPoints(), getMappingMatrix(analyzeResult.getBitmapRect(), analyzeResult.getBitmapDegrees(), matCropAndRotate.width(), matCropAndRotate.height())), reduceRatio);
        matCropAndRotate.release();
        com.up366.smart.paper.opencv.OpencvUtil.saveMat(matCrop, imagePath);
    }

    public static void bitmapToCropAndSave(android.graphics.Bitmap bitmap, java.lang.String imagePath, com.up366.smart.paper.BitmapAnalyzeResult analyzeResult, int reduceRatio) {
        com.up366.smart.paper.BitmapAnalyzeResult bitmapAnalyzeResultAnalyze = com.up366.smart.paper.opencv.OpencvImageAnalyze.analyze(bitmap);
        if (bitmapAnalyzeResultAnalyze != null && bitmapAnalyzeResultAnalyze.getPoints().size() == 4) {
            saveBitmap(com.up366.smart.paper.opencv.OpencvCrop.bitmapTransformCrop(bitmap, bitmapAnalyzeResultAnalyze.getPoints()), imagePath);
            return;
        }
        org.opencv.core.Mat matBitmapToMat = com.up366.smart.paper.opencv.OpencvUtil.bitmapToMat(bitmap);
        org.opencv.core.Mat matCrop = com.up366.smart.paper.opencv.OpencvCrop.crop(matBitmapToMat, changePoints(analyzeResult.getPoints(), getMappingMatrix(analyzeResult.getBitmapRect(), analyzeResult.getBitmapDegrees(), matBitmapToMat.width(), matBitmapToMat.height())), reduceRatio);
        matBitmapToMat.release();
        com.up366.smart.paper.opencv.OpencvUtil.saveMat(matCrop, imagePath);
    }

    public static void saveByteArrayToJpeg(java.lang.String imagePath, byte[] bytes) {
        try {
            java.io.File file = new java.io.File(imagePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(imagePath);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static java.util.List<org.opencv.core.Point> scalePoints(java.util.List<org.opencv.core.Point> points, android.graphics.Rect cropRect, int bitmapWidth, int bitmapHeight) {
        if (points == null || points.isEmpty()) {
            return new java.util.ArrayList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(6);
        double dWidth = bitmapWidth / cropRect.width();
        double dHeight = bitmapHeight / cropRect.height();
        arrayList.add(new org.opencv.core.Point(points.get(0).x * dWidth, points.get(0).y * dHeight));
        arrayList.add(new org.opencv.core.Point(points.get(1).x * dWidth, points.get(1).y * dHeight));
        arrayList.add(new org.opencv.core.Point(points.get(2).x * dWidth, points.get(2).y * dHeight));
        arrayList.add(new org.opencv.core.Point(points.get(3).x * dWidth, points.get(3).y * dHeight));
        return arrayList;
    }

    public static android.graphics.Rect rotateRect(android.graphics.Rect rect, int imageWidth, int imageHeight, int degrees) {
        if (degrees == 90) {
            return new android.graphics.Rect(imageWidth - rect.bottom, rect.left, imageWidth - rect.top, rect.right);
        }
        if (degrees == 180) {
            return new android.graphics.Rect(imageHeight - rect.right, imageWidth - rect.bottom, imageHeight - rect.left, imageHeight - rect.top);
        }
        return degrees == 270 ? new android.graphics.Rect(rect.top, imageHeight - rect.right, rect.bottom, imageHeight - rect.left) : rect;
    }

    public static java.lang.Boolean rectBeyondScreen(java.util.List<org.opencv.core.Point> points, android.graphics.Rect rect) {
        if (points.size() != 4) {
            return false;
        }
        for (org.opencv.core.Point point : points) {
            if (!rect.contains((int) point.x, (int) point.y)) {
                return true;
            }
        }
        return false;
    }

    public static android.graphics.Bitmap bitmapRotate(android.graphics.Bitmap src, float degrees) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate(degrees, src.getWidth() / 2, src.getHeight() / 2);
        return android.graphics.Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, false);
    }

    public static void saveBitmap(android.graphics.Bitmap bitmap, java.lang.String imagePath) {
        java.io.File file = new java.io.File(imagePath);
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (java.lang.Exception e) {
            android.util.Log.i("CameraUtil", "CameraUtil saveBitmap: error:" + e.getMessage());
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
