package com.up366.smart.paper.opencv.line;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class Quadrilateral {
    private boolean allowArea;
    private double areaRatio;
    private java.util.List<com.up366.smart.paper.opencv.line.PointLine> pointLines = new java.util.ArrayList();

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

    public void add(com.up366.smart.paper.opencv.line.PointLine pointLine) {
        if (pointSize() > 4) {
            return;
        }
        if (!this.pointLines.contains(pointLine)) {
            this.pointLines.add(pointLine);
        }
        sortPoints();
    }

    public int pointSize() {
        return this.pointLines.size();
    }

    public java.util.List<com.up366.smart.paper.opencv.line.PointLine> getPointLines() {
        return this.pointLines;
    }

    public void add(java.util.List<com.up366.smart.paper.opencv.line.PointLine> pointLineList) {
        this.pointLines.clear();
        this.pointLines.addAll(pointLineList);
        sortPoints();
    }

    private void sortPoints() {
        if (this.pointLines.size() == 4) {
            java.util.Collections.sort(this.pointLines, new java.util.Comparator() { // from class: com.up366.smart.paper.opencv.line.Quadrilateral$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                    return com.up366.smart.paper.opencv.line.Quadrilateral.lambda$sortPoints$0((com.up366.smart.paper.opencv.line.PointLine) obj, (com.up366.smart.paper.opencv.line.PointLine) obj2);
                }
            });
            java.util.ArrayList arrayList = new java.util.ArrayList(4);
            com.up366.smart.paper.opencv.line.PointLine pointLine = this.pointLines.get(0);
            this.pointLines.remove(0);
            java.util.Iterator<com.up366.smart.paper.opencv.line.PointLine> it = this.pointLines.iterator();
            com.up366.smart.paper.opencv.line.PointLine pointLine2 = null;
            com.up366.smart.paper.opencv.line.PointLine pointLine3 = null;
            while (it.hasNext()) {
                com.up366.smart.paper.opencv.line.PointLine next = it.next();
                if (pointLine.firstTwoLine.equals(next.firstTwoLine) || pointLine.firstTwoLine.equals(next.secondTwoLine)) {
                    it.remove();
                    pointLine2 = next;
                } else if (pointLine.secondTwoLine.equals(next.firstTwoLine) || pointLine.secondTwoLine.equals(next.secondTwoLine)) {
                    it.remove();
                    pointLine3 = next;
                }
            }
            if (pointLine2 == null || pointLine3 == null) {
                return;
            }
            if (pointLine2.point.x < pointLine3.point.x) {
                com.up366.smart.paper.opencv.line.PointLine pointLine4 = pointLine3;
                pointLine3 = pointLine2;
                pointLine2 = pointLine4;
            }
            arrayList.add(pointLine);
            arrayList.add(pointLine2);
            arrayList.add(this.pointLines.get(0));
            arrayList.add(pointLine3);
            this.pointLines.clear();
            this.pointLines.addAll(arrayList);
        }
    }

    static /* synthetic */ int lambda$sortPoints$0(com.up366.smart.paper.opencv.line.PointLine pointLine, com.up366.smart.paper.opencv.line.PointLine pointLine2) {
        return java.lang.Math.pow(pointLine.point.x, 2.0d) + java.lang.Math.pow(pointLine.point.y, 2.0d) > java.lang.Math.pow(pointLine2.point.x, 2.0d) + java.lang.Math.pow(pointLine2.point.y, 2.0d) ? 1 : -1;
    }

    public boolean sameQuadrilateral(com.up366.smart.paper.opencv.line.Quadrilateral quadrilateral) {
        if (pointSize() != quadrilateral.pointSize() || pointSize() != 4) {
            return false;
        }
        java.util.Iterator<com.up366.smart.paper.opencv.line.PointLine> it = this.pointLines.iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!quadrilateral.getPointLines().contains(it.next())) {
                z = false;
            }
        }
        return z;
    }

    public static double triangleArea(double a, double b, double c) {
        double d = ((a + b) + c) / 2.0d;
        return java.lang.Math.sqrt((d - a) * d * (d - b) * (d - c));
    }

    public boolean containCenterPoint(org.opencv.core.Point centerPoint) {
        if (this.pointLines.size() != 4) {
            return false;
        }
        org.opencv.core.Point point = this.pointLines.get(0).point;
        org.opencv.core.Point point2 = this.pointLines.get(1).point;
        org.opencv.core.Point point3 = this.pointLines.get(2).point;
        org.opencv.core.Point point4 = this.pointLines.get(3).point;
        return (((triangleArea(point, point2, centerPoint) + triangleArea(point2, point3, centerPoint)) + triangleArea(point3, point4, centerPoint)) + triangleArea(point4, point, centerPoint)) - 2.0d < triangleArea(point, point2, point3) + triangleArea(point3, point4, point);
    }

    public double triangleArea() {
        if (this.pointLines.size() != 4) {
            return 0.0d;
        }
        org.opencv.core.Point point = this.pointLines.get(0).point;
        org.opencv.core.Point point2 = this.pointLines.get(1).point;
        org.opencv.core.Point point3 = this.pointLines.get(2).point;
        return triangleArea(point, point2, point3) + triangleArea(point3, this.pointLines.get(3).point, point);
    }

    public double triangleArea(org.opencv.core.Point a, org.opencv.core.Point b, org.opencv.core.Point c) {
        return java.lang.Math.abs(((((((a.x * b.y) + (b.x * c.y)) + (c.x * a.y)) - (b.x * a.y)) - (c.x * b.y)) - (a.x * c.y)) / 2.0d);
    }

    public void checkArea(int width, int height) {
        double d = width * height;
        org.opencv.core.Point point = getPointLines().get(0).point;
        org.opencv.core.Point point2 = getPointLines().get(1).point;
        org.opencv.core.Point point3 = getPointLines().get(3).point;
        double dTriangleArea = triangleArea();
        double d2 = (point2.x - point.x > point3.y - point.y ? 0.2d : 0.15d) * d;
        this.areaRatio = dTriangleArea / d;
        this.allowArea = dTriangleArea >= d2;
    }

    public java.lang.String toString() {
        return "Quadrilateral{ " + this.pointLines.get(0).toString() + " " + this.pointLines.get(1).toString() + " " + this.pointLines.get(2).toString() + " " + this.pointLines.get(3).toString() + '}';
    }
}
