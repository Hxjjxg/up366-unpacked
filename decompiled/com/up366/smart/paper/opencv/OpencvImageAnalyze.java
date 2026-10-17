package com.up366.smart.paper.opencv;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class OpencvImageAnalyze {
    private static final java.lang.String TAG = "OpencvImageAnalyze";

    public static com.up366.smart.paper.BitmapAnalyzeResult analyze(android.graphics.Bitmap src) {
        java.lang.System.currentTimeMillis();
        int i = 0;
        android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(com.up366.smart.paper.TensorFlowUtil.sImageDetector.detectImage(src), src.getWidth(), src.getHeight(), false);
        org.opencv.core.Mat matBitmapToMat = com.up366.smart.paper.opencv.OpencvUtil.bitmapToMat(bitmapCreateScaledBitmap);
        com.up366.smart.paper.CameraUtil.gcBitmap(bitmapCreateScaledBitmap);
        int iMax = java.lang.Math.max(matBitmapToMat.width(), matBitmapToMat.height());
        float f = iMax > 500 ? (iMax * 1.0f) / 500.0f : 1.0f;
        if (f != 1.0f) {
            double dWidth = matBitmapToMat.width() / f;
            double dHeight = matBitmapToMat.height() / f;
            org.opencv.core.Mat matZeros = org.opencv.core.Mat.zeros(new org.opencv.core.Size(dWidth, dHeight), matBitmapToMat.type());
            org.opencv.imgproc.Imgproc.resize(matBitmapToMat, matZeros, new org.opencv.core.Size(dWidth, dHeight));
            matBitmapToMat = matZeros;
        }
        com.up366.smart.paper.BitmapAnalyzeResult bitmapAnalyzeResultPreprocessedImage = com.up366.smart.paper.opencv.preprocessed.PreprocessedImageV2.preprocessedImage(matBitmapToMat);
        com.up366.smart.paper.opencv.OpencvUtil.releaseMat(matBitmapToMat);
        if (bitmapAnalyzeResultPreprocessedImage == null || bitmapAnalyzeResultPreprocessedImage.getPoints().size() == 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(bitmapAnalyzeResultPreprocessedImage.getPoints());
        bitmapAnalyzeResultPreprocessedImage.getPoints().clear();
        if (f == 1.0f) {
            while (i < 4) {
                bitmapAnalyzeResultPreprocessedImage.addPoint((org.opencv.core.Point) arrayList.get(i));
                i++;
            }
        } else {
            while (i < 4) {
                org.opencv.core.Point point = (org.opencv.core.Point) arrayList.get(i);
                double d = f;
                point.x *= d;
                point.y *= d;
                bitmapAnalyzeResultPreprocessedImage.addPoint(point);
                i++;
            }
        }
        return bitmapAnalyzeResultPreprocessedImage;
    }
}
