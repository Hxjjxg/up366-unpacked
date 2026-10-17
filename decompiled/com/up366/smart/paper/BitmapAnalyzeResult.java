package com.up366.smart.paper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class BitmapAnalyzeResult {
    private boolean allowArea;
    private double areaRatio;
    private int bitmapDegrees;
    private android.graphics.Rect bitmapRect;
    private java.util.List<org.opencv.core.Point> points = new java.util.ArrayList();

    public android.graphics.Rect getBitmapRect() {
        return this.bitmapRect;
    }

    public void setBitmapRect(android.graphics.Rect bitmapRect) {
        this.bitmapRect = bitmapRect;
    }

    public int getBitmapDegrees() {
        return this.bitmapDegrees;
    }

    public void setBitmapDegrees(int bitmapDegrees) {
        this.bitmapDegrees = bitmapDegrees;
    }

    public void addPoint(org.opencv.core.Point point) {
        this.points.add(point);
    }

    public java.util.List<org.opencv.core.Point> getPoints() {
        return this.points;
    }

    public void setPoints(java.util.List<org.opencv.core.Point> points) {
        this.points = points;
    }

    public double getAreaRatio() {
        return this.areaRatio;
    }

    public void setAreaRatio(double areaRatio) {
        this.areaRatio = areaRatio;
    }

    public boolean isAllowArea() {
        return this.allowArea;
    }

    public void setAllowArea(boolean allowArea) {
        this.allowArea = allowArea;
    }

    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("BitmapAnalyzeResult{ ");
        java.lang.StringBuilder sb = new java.lang.StringBuilder("bitmapRect=");
        android.graphics.Rect rect = this.bitmapRect;
        sb.append(rect == null ? com.igexin.push.core.b.m : rect.toString());
        stringBuffer.append(sb.toString());
        stringBuffer.append(", bitmapDegrees=" + this.bitmapDegrees).append(", areaRatio=" + this.areaRatio).append(", allowArea=" + this.allowArea);
        stringBuffer.append(", points= { ");
        if (!this.points.isEmpty()) {
            for (int i = 0; i < this.points.size(); i++) {
                stringBuffer.append(i + "-->" + this.points.get(i).toString());
            }
            stringBuffer.append(" }");
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }
}
