package com.up366.smart.paper.opencv;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class OpencvCrop {
    private static final java.lang.String TAG = "OpencvCrop";

    public static org.opencv.core.Mat crop(org.opencv.core.Mat srcMat, java.util.List<org.opencv.core.Point> cropPoints, int reduceRatio) {
        java.util.List<org.opencv.core.Point> listReduce = com.up366.smart.paper.opencv.BalanceUtil.reduce(cropPoints, reduceRatio);
        org.opencv.core.Point point = listReduce.get(0);
        org.opencv.core.Point point2 = listReduce.get(1);
        org.opencv.core.Point point3 = listReduce.get(2);
        org.opencv.core.Point point4 = listReduce.get(3);
        int pointsDistance = (int) ((getPointsDistance(point, point2) + getPointsDistance(point4, point3)) / 2.0d);
        int pointsDistance2 = (int) ((getPointsDistance(point, point4) + getPointsDistance(point2, point3)) / 2.0d);
        com.up366.common.log.Logger.info("OpencvCrop crop Image width=" + pointsDistance + " height=" + pointsDistance2);
        org.opencv.core.Mat matZeros = org.opencv.core.Mat.zeros(pointsDistance2, pointsDistance, srcMat.type());
        org.opencv.core.Point[] pointArr = {new org.opencv.core.Point(point.x, point.y), new org.opencv.core.Point(point2.x, point2.y), new org.opencv.core.Point(point4.x, point4.y), new org.opencv.core.Point(point3.x, point3.y)};
        double d = (double) pointsDistance;
        double d2 = (double) pointsDistance2;
        org.opencv.core.Mat perspectiveTransform = org.opencv.imgproc.Imgproc.getPerspectiveTransform(new org.opencv.core.MatOfPoint2f(pointArr), new org.opencv.core.MatOfPoint2f(new org.opencv.core.Point[]{new org.opencv.core.Point(0.0d, 0.0d), new org.opencv.core.Point(d, 0.0d), new org.opencv.core.Point(0.0d, d2), new org.opencv.core.Point(d, d2)}));
        org.opencv.imgproc.Imgproc.warpPerspective(srcMat, matZeros, perspectiveTransform, matZeros.size());
        perspectiveTransform.release();
        return matZeros;
    }

    public static org.opencv.core.Mat cropAndRotate(java.lang.String imageFile, androidx.camera.core.ImageProxy image) {
        org.opencv.core.Mat matImread = org.opencv.imgcodecs.Imgcodecs.imread(imageFile, -1);
        android.graphics.Rect cropRect = image.getCropRect();
        org.opencv.core.Rect rect = new org.opencv.core.Rect();
        rect.x = cropRect.left;
        rect.y = cropRect.top;
        rect.width = cropRect.width();
        rect.height = cropRect.height();
        org.opencv.core.Mat mat = new org.opencv.core.Mat(matImread, rect);
        matImread.release();
        int rotationDegrees = image.getImageInfo().getRotationDegrees();
        if (rotationDegrees == 90) {
            org.opencv.core.Mat mat2 = new org.opencv.core.Mat();
            org.opencv.core.Core.transpose(mat, mat2);
            org.opencv.core.Mat mat3 = new org.opencv.core.Mat();
            org.opencv.core.Core.flip(mat2, mat3, 1);
            com.up366.smart.paper.opencv.OpencvUtil.releaseMat(mat, mat2);
            return mat3;
        }
        if (rotationDegrees == 180) {
            org.opencv.core.Mat matClone = mat.clone();
            org.opencv.core.Core.flip(matClone, matClone, 0);
            org.opencv.core.Core.flip(matClone, matClone, 1);
            mat.release();
            return matClone;
        }
        if (rotationDegrees == 270) {
            org.opencv.core.Mat matClone2 = mat.clone();
            org.opencv.core.Core.transpose(matClone2, matClone2);
            org.opencv.core.Core.flip(matClone2, matClone2, 0);
            mat.release();
            return matClone2;
        }
        matImread.release();
        return mat;
    }

    public static android.graphics.Bitmap bitmapTransformCrop(android.graphics.Bitmap src, java.util.List<org.opencv.core.Point> cropPoints, int reduceRatio) {
        if (cropPoints.size() != 4) {
            return null;
        }
        return bitmapTransformCrop(src, com.up366.smart.paper.opencv.BalanceUtil.reduceNoDegrees(cropPoints, reduceRatio));
    }

    public static android.graphics.Bitmap bitmapTransformCrop(android.graphics.Bitmap src, java.util.List<org.opencv.core.Point> cropPoints) {
        if (cropPoints.size() != 4) {
            return null;
        }
        org.opencv.core.Point point = cropPoints.get(0);
        org.opencv.core.Point point2 = cropPoints.get(1);
        org.opencv.core.Point point3 = cropPoints.get(2);
        org.opencv.core.Point point4 = cropPoints.get(3);
        int pointsDistance = (int) ((getPointsDistance(point, point2) + getPointsDistance(point4, point3)) / 2.0d);
        int pointsDistance2 = (int) ((getPointsDistance(point, point4) + getPointsDistance(point2, point3)) / 2.0d);
        org.opencv.core.Mat matBitmapToMat = com.up366.smart.paper.opencv.OpencvUtil.bitmapToMat(src);
        com.up366.common.log.Logger.info("OpencvCrop crop Image width=" + pointsDistance + " height=" + pointsDistance2);
        org.opencv.core.Mat matZeros = org.opencv.core.Mat.zeros(pointsDistance2, pointsDistance, matBitmapToMat.type());
        org.opencv.core.Point[] pointArr = {new org.opencv.core.Point(point.x, point.y), new org.opencv.core.Point(point2.x, point2.y), new org.opencv.core.Point(point4.x, point4.y), new org.opencv.core.Point(point3.x, point3.y)};
        double d = (double) pointsDistance;
        double d2 = (double) pointsDistance2;
        org.opencv.imgproc.Imgproc.warpPerspective(matBitmapToMat, matZeros, org.opencv.imgproc.Imgproc.getPerspectiveTransform(new org.opencv.core.MatOfPoint2f(pointArr), new org.opencv.core.MatOfPoint2f(new org.opencv.core.Point[]{new org.opencv.core.Point(0.0d, 0.0d), new org.opencv.core.Point(d, 0.0d), new org.opencv.core.Point(0.0d, d2), new org.opencv.core.Point(d, d2)})), matZeros.size());
        android.graphics.Bitmap bitmapMatToBitmap = com.up366.smart.paper.opencv.OpencvUtil.matToBitmap(matZeros);
        com.up366.smart.paper.opencv.OpencvUtil.releaseMat(matBitmapToMat, matZeros);
        return bitmapMatToBitmap;
    }

    public static android.graphics.Bitmap crop(android.graphics.Bitmap src, java.util.List<org.opencv.core.Point> cropPoints) {
        if (cropPoints.size() != 4) {
            return null;
        }
        org.opencv.core.Point point = cropPoints.get(3);
        org.opencv.core.Point point2 = cropPoints.get(0);
        org.opencv.core.Point point3 = cropPoints.get(1);
        org.opencv.core.Point point4 = cropPoints.get(2);
        int pointsDistance = (int) ((getPointsDistance(point, point2) + getPointsDistance(point4, point3)) / 2.0d);
        int pointsDistance2 = (int) ((getPointsDistance(point, point4) + getPointsDistance(point2, point3)) / 2.0d);
        org.opencv.core.Mat matBitmapToMat = com.up366.smart.paper.opencv.OpencvUtil.bitmapToMat(src);
        com.up366.common.log.Logger.info("OpencvCrop crop Image width=" + pointsDistance + " height=" + pointsDistance2);
        org.opencv.core.Mat matZeros = org.opencv.core.Mat.zeros(pointsDistance2, pointsDistance, matBitmapToMat.type());
        double d = (double) pointsDistance;
        double d2 = (double) pointsDistance2;
        org.opencv.imgproc.Imgproc.warpPerspective(matBitmapToMat, matZeros, org.opencv.imgproc.Imgproc.getPerspectiveTransform(new org.opencv.core.MatOfPoint2f(new org.opencv.core.Point[]{new org.opencv.core.Point(point.x, point.y), new org.opencv.core.Point(point2.x, point2.y), new org.opencv.core.Point(point4.x, point4.y), new org.opencv.core.Point(point3.x, point3.y)}), new org.opencv.core.MatOfPoint2f(new org.opencv.core.Point[]{new org.opencv.core.Point(0.0d, 0.0d), new org.opencv.core.Point(d, 0.0d), new org.opencv.core.Point(0.0d, d2), new org.opencv.core.Point(d, d2)})), matZeros.size());
        return com.up366.smart.paper.opencv.OpencvUtil.matToBitmap(matZeros);
    }

    public static double getPointsDistance(org.opencv.core.Point p1, org.opencv.core.Point p2) {
        return getPointsDistance(p1.x, p1.y, p2.x, p2.y);
    }

    public static double getPointsDistance(double x1, double y1, double x2, double y2) {
        return java.lang.Math.sqrt(java.lang.Math.pow(x1 - x2, 2.0d) + java.lang.Math.pow(y1 - y2, 2.0d));
    }
}
