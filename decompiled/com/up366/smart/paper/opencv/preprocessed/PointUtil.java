package com.up366.smart.paper.opencv.preprocessed;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PointUtil {
    public static double pointsAngle(org.opencv.core.Point left, org.opencv.core.Point center, org.opencv.core.Point right) {
        double d = left.x - center.x;
        double d2 = left.y - center.y;
        double d3 = right.x - center.x;
        double d4 = right.y - center.y;
        double dSqrt = java.lang.Math.sqrt((d * d) + (d2 * d2)) * java.lang.Math.sqrt((d3 * d3) + (d4 * d4));
        if (dSqrt == 0.0d) {
            return -1.0d;
        }
        return (java.lang.Math.acos(((d * d3) + (d2 * d4)) / dSqrt) / 3.141592653589793d) * 180.0d;
    }

    public static boolean analyzePointsAngle(org.opencv.core.Point[] points, int minAngle, int maxAngle) {
        if (points.length != 4) {
            return false;
        }
        org.opencv.core.Point point = points[0];
        org.opencv.core.Point point2 = points[1];
        org.opencv.core.Point point3 = points[2];
        org.opencv.core.Point point4 = points[3];
        double dPointsAngle = pointsAngle(point4, point, point2);
        double d = minAngle;
        if (dPointsAngle >= d) {
            double d2 = maxAngle;
            if (dPointsAngle <= d2) {
                double dPointsAngle2 = pointsAngle(point, point2, point3);
                if (dPointsAngle2 >= d && dPointsAngle2 <= d2) {
                    double dPointsAngle3 = pointsAngle(point2, point3, point4);
                    if (dPointsAngle3 >= d && dPointsAngle3 <= d2) {
                        double dPointsAngle4 = pointsAngle(point3, point4, point);
                        if (dPointsAngle4 >= d && dPointsAngle4 <= d2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean containCenterPoint(org.opencv.core.Point[] points, org.opencv.core.Mat src) {
        if (points.length != 4) {
            return false;
        }
        org.opencv.core.Point point = new org.opencv.core.Point(src.cols() / 2, src.rows() / 2);
        org.opencv.core.Point point2 = points[0];
        org.opencv.core.Point point3 = points[1];
        org.opencv.core.Point point4 = points[2];
        org.opencv.core.Point point5 = points[3];
        return ((triangleArea(point2, point3, point) + triangleArea(point3, point4, point)) + triangleArea(point4, point5, point)) + triangleArea(point5, point2, point) > (triangleArea(point2, point3, point4) + triangleArea(point4, point5, point2)) - 2.0d;
    }

    public static double triangleArea(org.opencv.core.Point a, org.opencv.core.Point b, org.opencv.core.Point c) {
        return java.lang.Math.abs(((((((a.x * b.y) + (b.x * c.y)) + (c.x * a.y)) - (b.x * a.y)) - (c.x * b.y)) - (a.x * c.y)) / 2.0d);
    }

    public static double pointsDistance(org.opencv.core.Point a, org.opencv.core.Point b) {
        return java.lang.Math.sqrt(java.lang.Math.pow(a.x - b.x, 2.0d) + java.lang.Math.pow(a.y - b.y, 2.0d));
    }
}
