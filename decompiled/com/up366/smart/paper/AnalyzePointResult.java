package com.up366.smart.paper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AnalyzePointResult {
    private static final int RADIUS = 20;
    public static final int TIMES = 6;
    private com.up366.smart.paper.BitmapAnalyzeResult analyzeResult;
    private java.util.List<org.opencv.core.Point> avaragePoints = new java.util.ArrayList();
    public int times = 1;

    public AnalyzePointResult(com.up366.smart.paper.BitmapAnalyzeResult result) {
        this.analyzeResult = null;
        this.analyzeResult = result;
        java.util.Iterator<org.opencv.core.Point> it = result.getPoints().iterator();
        while (it.hasNext()) {
            this.avaragePoints.add(it.next());
        }
    }

    public com.up366.smart.paper.BitmapAnalyzeResult getAnalyzeResult() {
        return this.analyzeResult;
    }

    public boolean addPoints(com.up366.smart.paper.BitmapAnalyzeResult result) {
        java.util.List<org.opencv.core.Point> points = result.getPoints();
        if (pointDistance(this.avaragePoints.get(0), points.get(0)) > 20.0d || pointDistance(this.avaragePoints.get(1), points.get(1)) > 20.0d || pointDistance(this.avaragePoints.get(2), points.get(2)) > 20.0d || pointDistance(this.avaragePoints.get(3), points.get(3)) > 20.0d) {
            return false;
        }
        average(new java.util.ArrayList(points));
        this.analyzeResult = result;
        this.times++;
        return true;
    }

    public void average(java.util.List<org.opencv.core.Point> points) {
        org.opencv.core.Point point = this.avaragePoints.get(0);
        point.x = (point.x + points.get(0).x) / 2.0d;
        point.y = (point.y + points.get(0).y) / 2.0d;
        org.opencv.core.Point point2 = this.avaragePoints.get(1);
        point2.x = (point2.x + points.get(1).x) / 2.0d;
        point2.y = (point2.y + points.get(1).y) / 2.0d;
        org.opencv.core.Point point3 = this.avaragePoints.get(2);
        point3.x = (point3.x + points.get(2).x) / 2.0d;
        point3.y = (point3.y + points.get(2).y) / 2.0d;
        org.opencv.core.Point point4 = this.avaragePoints.get(3);
        point4.x = (point4.x + points.get(3).x) / 2.0d;
        point4.y = (point4.y + points.get(3).y) / 2.0d;
    }

    private double pointDistance(org.opencv.core.Point first, org.opencv.core.Point second) {
        return java.lang.Math.sqrt(java.lang.Math.pow(first.x - second.x, 2.0d) + java.lang.Math.pow(first.y - second.y, 2.0d));
    }
}
