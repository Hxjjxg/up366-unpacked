package com.up366.smart.paper.opencv;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class OpencvUtil {
    public static org.opencv.core.Mat bitmapToMat(android.graphics.Bitmap bitmap) {
        org.opencv.core.Mat mat = new org.opencv.core.Mat();
        org.opencv.android.Utils.bitmapToMat(bitmap, mat);
        return mat;
    }

    public static android.graphics.Bitmap matToBitmap(org.opencv.core.Mat mat) {
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(mat.width(), mat.height(), android.graphics.Bitmap.Config.ARGB_8888);
        org.opencv.android.Utils.matToBitmap(mat, bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public static void saveMat(org.opencv.core.Mat mat, java.lang.String path) {
        java.io.File file = new java.io.File(path);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        org.opencv.imgcodecs.Imgcodecs.imwrite(path, mat);
        mat.release();
    }

    public static org.opencv.core.Mat resize(org.opencv.core.Mat mat, float scale) {
        org.opencv.core.Mat mat2 = new org.opencv.core.Mat();
        org.opencv.imgproc.Imgproc.resize(mat, mat2, new org.opencv.core.Size(mat.cols() * scale, mat.rows() * scale));
        return mat2;
    }

    public static org.opencv.core.Mat dilate(org.opencv.core.Mat src, int size) {
        org.opencv.core.Mat matClone = src.clone();
        double d = size;
        org.opencv.imgproc.Imgproc.dilate(src, matClone, org.opencv.imgproc.Imgproc.getStructuringElement(0, new org.opencv.core.Size(d, d)));
        return matClone;
    }

    public static org.opencv.core.Mat erode(org.opencv.core.Mat src, int size) {
        org.opencv.core.Mat matClone = src.clone();
        double d = size;
        org.opencv.imgproc.Imgproc.erode(src, matClone, org.opencv.imgproc.Imgproc.getStructuringElement(0, new org.opencv.core.Size(d, d)));
        return matClone;
    }

    public static org.opencv.core.Mat blur(org.opencv.core.Mat src) {
        org.opencv.core.Mat matClone = src.clone();
        org.opencv.imgproc.Imgproc.blur(src, matClone, new org.opencv.core.Size(7.0d, 7.0d));
        return matClone;
    }

    public static org.opencv.core.Mat threshold(org.opencv.core.Mat src) {
        org.opencv.core.Mat matClone = src.clone();
        org.opencv.imgproc.Imgproc.threshold(src, matClone, 127.0d, 255.0d, 8);
        return matClone;
    }

    public static void releaseMat(org.opencv.core.Mat... mats) {
        for (org.opencv.core.Mat mat : mats) {
            if (mat != null) {
                mat.release();
            }
        }
    }
}
