package com.up366.smart.paper.opencv.preprocessed;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PreprocessedImageV2 {
    private static final java.lang.String TAG = "PreprocessedImageV2";

    public static com.up366.smart.paper.BitmapAnalyzeResult preprocessedImage(org.opencv.core.Mat src) {
        char c;
        org.opencv.core.Mat mat;
        char c2;
        int i;
        char c3;
        org.opencv.core.Mat matClone = src.clone();
        org.opencv.imgproc.Imgproc.cvtColor(src, matClone, 6);
        org.opencv.core.Mat matClone2 = src.clone();
        org.opencv.imgproc.Imgproc.threshold(matClone, matClone2, 0.0d, 255.0d, 8);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        org.opencv.core.Mat mat2 = new org.opencv.core.Mat();
        int i2 = 0;
        char c4 = 1;
        org.opencv.imgproc.Imgproc.findContours(matClone2, arrayList, mat2, 0, 1);
        org.opencv.core.Mat matZeros = org.opencv.core.Mat.zeros(matClone2.size(), matClone2.type());
        if (arrayList.size() > 0) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                org.opencv.core.MatOfPoint2f matOfPoint2f = new org.opencv.core.MatOfPoint2f(((org.opencv.core.MatOfPoint) it.next()).toArray());
                double dArcLength = org.opencv.imgproc.Imgproc.arcLength(matOfPoint2f, true);
                org.opencv.core.MatOfPoint2f matOfPoint2f2 = new org.opencv.core.MatOfPoint2f();
                org.opencv.imgproc.Imgproc.approxPolyDP(matOfPoint2f, matOfPoint2f2, dArcLength * 0.01d, true);
                org.opencv.core.MatOfPoint matOfPoint = new org.opencv.core.MatOfPoint();
                matOfPoint2f2.convertTo(matOfPoint, 4);
                arrayList2.add(matOfPoint);
            }
            org.opencv.imgproc.Imgproc.drawContours(matZeros, arrayList2, -1, new org.opencv.core.Scalar(255.0d, 255.0d, 255.0d, 255.0d), 1, 16);
            com.up366.smart.paper.opencv.OpencvUtil.releaseMat((org.opencv.core.Mat[]) arrayList2.toArray(new org.opencv.core.MatOfPoint[0]));
            org.opencv.core.Mat mat3 = new org.opencv.core.Mat();
            org.opencv.imgproc.Imgproc.threshold(matZeros, mat3, 0.0d, 255.0d, 8);
            org.opencv.core.Mat mat4 = new org.opencv.core.Mat();
            mat4.release();
            org.opencv.imgproc.Imgproc.HoughLinesP(mat3, mat4, 1.0d, 0.017453292519943295d, 100, 50.0d, 10.0d);
            int iRows = mat4.rows();
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            int i3 = 0;
            while (i3 < iRows) {
                double[] dArr = mat4.get(i3, i2);
                arrayList3.add(new com.up366.smart.paper.opencv.line.Line(new org.opencv.core.Point(dArr[i2], dArr[c4]), new org.opencv.core.Point(dArr[2], dArr[3])));
                i3++;
                matClone2 = matClone2;
                i2 = 0;
                c4 = 1;
            }
            mat = matClone2;
            com.up366.smart.paper.BitmapAnalyzeResult bitmapAnalyzeResultAnalyze = com.up366.smart.paper.opencv.line.LineAnalyze.analyze(arrayList3, matZeros.width(), matZeros.height());
            if (bitmapAnalyzeResultAnalyze.getPoints() != null && bitmapAnalyzeResultAnalyze.getPoints().size() == 4) {
                com.up366.smart.paper.opencv.OpencvUtil.releaseMat(mat, mat2, matZeros, mat3, mat4);
                return bitmapAnalyzeResultAnalyze;
            }
            c3 = 0;
            c = 1;
            c2 = 2;
            i = 3;
        } else {
            c = 1;
            mat = matClone2;
            c2 = 2;
            i = 3;
            c3 = 0;
        }
        org.opencv.core.Mat[] matArr = new org.opencv.core.Mat[i];
        matArr[c3] = mat;
        matArr[c] = mat2;
        matArr[c2] = matZeros;
        com.up366.smart.paper.opencv.OpencvUtil.releaseMat(matArr);
        return null;
    }
}
