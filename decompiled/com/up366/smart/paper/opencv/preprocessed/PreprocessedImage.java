package com.up366.smart.paper.opencv.preprocessed;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@java.lang.Deprecated
public class PreprocessedImage {
    private static final java.lang.String TAG = "PreprocessedImage";

    public static org.opencv.core.Mat preprocessedImage(org.opencv.core.Mat src, org.opencv.core.Point[] points) {
        org.opencv.core.Mat matClone = src.clone();
        org.opencv.imgproc.Imgproc.cvtColor(src, matClone, 6);
        org.opencv.core.Mat matClone2 = src.clone();
        org.opencv.imgproc.Imgproc.threshold(matClone, matClone2, 0.0d, 255.0d, 8);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        org.opencv.imgproc.Imgproc.findContours(matClone2, arrayList, new org.opencv.core.Mat(), 0, 1);
        if (arrayList.size() > 1) {
            java.util.Collections.sort(arrayList, new java.util.Comparator() { // from class: com.up366.smart.paper.opencv.preprocessed.PreprocessedImage$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                    return com.up366.smart.paper.opencv.preprocessed.PreprocessedImage.lambda$preprocessedImage$0((org.opencv.core.MatOfPoint) obj, (org.opencv.core.MatOfPoint) obj2);
                }
            });
            org.opencv.core.MatOfPoint2f matOfPoint2f = new org.opencv.core.MatOfPoint2f(((org.opencv.core.MatOfPoint) arrayList.get(0)).toArray());
            double dArcLength = org.opencv.imgproc.Imgproc.arcLength(matOfPoint2f, true);
            org.opencv.core.MatOfPoint2f matOfPoint2f2 = new org.opencv.core.MatOfPoint2f();
            org.opencv.imgproc.Imgproc.approxPolyDP(matOfPoint2f, matOfPoint2f2, dArcLength * 0.01d, true);
            java.util.List<org.opencv.core.Point> listHandlSelectPoints = handlSelectPoints(matOfPoint2f2.toList());
            if (listHandlSelectPoints.size() != 4) {
                return null;
            }
            double d = listHandlSelectPoints.get(0).x;
            double d2 = listHandlSelectPoints.get(0).x;
            double d3 = listHandlSelectPoints.get(0).y;
            double d4 = listHandlSelectPoints.get(0).y;
            int i = 0;
            for (int i2 = 4; i < i2; i2 = 4) {
                if (listHandlSelectPoints.get(i).x < d) {
                    d = listHandlSelectPoints.get(i).x;
                }
                if (listHandlSelectPoints.get(i).x > d2) {
                    d2 = listHandlSelectPoints.get(i).x;
                }
                if (listHandlSelectPoints.get(i).y < d3) {
                    d3 = listHandlSelectPoints.get(i).y;
                }
                if (listHandlSelectPoints.get(i).y > d4) {
                    d4 = listHandlSelectPoints.get(i).y;
                }
                i++;
            }
            if ((d2 - d) * (d4 - d3) < (src.cols() * src.rows()) / 10) {
                return null;
            }
            org.opencv.core.Point[] pointArrSortPointClockwise = sortPointClockwise(listHandlSelectPoints);
            if (pointArrSortPointClockwise.length == 4) {
                if (!com.up366.smart.paper.opencv.preprocessed.PointUtil.containCenterPoint(pointArrSortPointClockwise, matClone2)) {
                    android.util.Log.i(TAG, "preprocessedImage: no centerPoint");
                    return null;
                }
                if (!com.up366.smart.paper.opencv.preprocessed.PointUtil.analyzePointsAngle(pointArrSortPointClockwise, 70, 110)) {
                    android.util.Log.i(TAG, "preprocessedImage: angle no ");
                    return null;
                }
                for (int i3 = 0; i3 < 4; i3++) {
                    points[i3] = pointArrSortPointClockwise[i3];
                }
                return matClone2;
            }
            pointArrSortPointClockwise[0] = new org.opencv.core.Point(0.0d, 0.0d);
            pointArrSortPointClockwise[1] = new org.opencv.core.Point(matClone2.cols(), 0.0d);
            pointArrSortPointClockwise[2] = new org.opencv.core.Point(matClone2.cols(), matClone2.rows());
            pointArrSortPointClockwise[3] = new org.opencv.core.Point(0.0d, matClone2.rows());
        }
        return null;
    }

    static /* synthetic */ int lambda$preprocessedImage$0(org.opencv.core.MatOfPoint matOfPoint, org.opencv.core.MatOfPoint matOfPoint2) {
        return org.opencv.imgproc.Imgproc.contourArea(matOfPoint) >= org.opencv.imgproc.Imgproc.contourArea(matOfPoint2) ? -1 : 1;
    }

    public static org.opencv.core.Point[] sortPointClockwise(java.util.List<org.opencv.core.Point> points) {
        org.opencv.core.Point point;
        java.util.ArrayList<org.opencv.core.Point> arrayList = new java.util.ArrayList(points);
        if (arrayList.size() != 4) {
            return (org.opencv.core.Point[]) arrayList.toArray(new org.opencv.core.Point[0]);
        }
        org.opencv.core.Point[] pointArr = new org.opencv.core.Point[4];
        double d = -1.0d;
        for (org.opencv.core.Point point2 : arrayList) {
            double d2 = (point2.x * point2.x) + (point2.y * point2.y);
            if (d == -1.0d || d2 < d) {
                pointArr[0] = point2;
                d = d2;
            }
        }
        org.opencv.core.Point point3 = pointArr[0];
        if (point3 != null) {
            arrayList.remove(point3);
            if (pointSideLine(point3, (org.opencv.core.Point) arrayList.get(0), (org.opencv.core.Point) arrayList.get(1)) * pointSideLine(point3, (org.opencv.core.Point) arrayList.get(0), (org.opencv.core.Point) arrayList.get(2)) < 0.0d) {
                pointArr[2] = (org.opencv.core.Point) arrayList.get(0);
            } else if (pointSideLine(point3, (org.opencv.core.Point) arrayList.get(1), (org.opencv.core.Point) arrayList.get(0)) * pointSideLine(point3, (org.opencv.core.Point) arrayList.get(1), (org.opencv.core.Point) arrayList.get(2)) < 0.0d) {
                pointArr[2] = (org.opencv.core.Point) arrayList.get(1);
            } else if (pointSideLine(point3, (org.opencv.core.Point) arrayList.get(2), (org.opencv.core.Point) arrayList.get(0)) * pointSideLine(point3, (org.opencv.core.Point) arrayList.get(2), (org.opencv.core.Point) arrayList.get(1)) < 0.0d) {
                pointArr[2] = (org.opencv.core.Point) arrayList.get(2);
            }
        }
        org.opencv.core.Point point4 = pointArr[0];
        if (point4 != null && (point = pointArr[2]) != null) {
            arrayList.remove(point);
            if (pointSideLine(point4, point, (org.opencv.core.Point) arrayList.get(0)) > 0.0d) {
                pointArr[1] = (org.opencv.core.Point) arrayList.get(0);
                pointArr[3] = (org.opencv.core.Point) arrayList.get(1);
            } else {
                pointArr[1] = (org.opencv.core.Point) arrayList.get(1);
                pointArr[3] = (org.opencv.core.Point) arrayList.get(0);
            }
        }
        return (pointArr[1] == null || pointArr[2] == null || pointArr[3] == null) ? (org.opencv.core.Point[]) points.toArray(new org.opencv.core.Point[0]) : pointArr;
    }

    private static double pointSideLine(org.opencv.core.Point lineP1, org.opencv.core.Point lineP2, org.opencv.core.Point point) {
        double d = lineP1.x;
        double d2 = lineP1.y;
        double d3 = lineP2.x;
        double d4 = lineP2.y;
        return ((point.x - d) * (d4 - d2)) - ((point.y - d2) * (d3 - d));
    }

    public static java.util.List<org.opencv.core.Point> handlSelectPoints(java.util.List<org.opencv.core.Point> points) {
        if (points.size() <= 4) {
            return points;
        }
        org.opencv.core.Point point = points.get(0);
        double d = point.x;
        double d2 = point.x;
        double d3 = point.y;
        double d4 = point.y;
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).x < d) {
                d = points.get(i).x;
            }
            if (points.get(i).x > d2) {
                d2 = points.get(i).x;
            }
            if (points.get(i).y < d3) {
                d3 = points.get(i).y;
            }
            if (points.get(i).y > d4) {
                d4 = points.get(i).y;
            }
        }
        org.opencv.core.Point point2 = new org.opencv.core.Point((d + d2) / 2.0d, (d3 + d4) / 2.0d);
        org.opencv.core.Point pointChoosePoint = choosePoint(point2, points, 0);
        org.opencv.core.Point pointChoosePoint2 = choosePoint(point2, points, 1);
        org.opencv.core.Point pointChoosePoint3 = choosePoint(point2, points, 2);
        org.opencv.core.Point pointChoosePoint4 = choosePoint(point2, points, 3);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(pointChoosePoint);
        arrayList.add(pointChoosePoint2);
        arrayList.add(pointChoosePoint3);
        arrayList.add(pointChoosePoint4);
        return arrayList;
    }

    private static org.opencv.core.Point choosePoint(org.opencv.core.Point center, java.util.List<org.opencv.core.Point> points, int type) {
        int i;
        int i2 = 0;
        if (type == 0) {
            i = -1;
            double d = 0.0d;
            while (i2 < points.size()) {
                if (points.get(i2).x < center.x && points.get(i2).y < center.y) {
                    double dSqrt = java.lang.Math.sqrt(java.lang.Math.pow(points.get(i2).x - center.x, 2.0d) + java.lang.Math.pow(points.get(i2).y - center.y, 2.0d));
                    if (dSqrt > d) {
                        i = i2;
                        d = dSqrt;
                    }
                }
                i2++;
            }
        } else if (type == 1) {
            i = -1;
            double d2 = 0.0d;
            while (i2 < points.size()) {
                if (points.get(i2).x < center.x && points.get(i2).y > center.y) {
                    double dSqrt2 = java.lang.Math.sqrt(java.lang.Math.pow(points.get(i2).x - center.x, 2.0d) + java.lang.Math.pow(points.get(i2).y - center.y, 2.0d));
                    if (dSqrt2 > d2) {
                        i = i2;
                        d2 = dSqrt2;
                    }
                }
                i2++;
            }
        } else if (type == 2) {
            i = -1;
            double d3 = 0.0d;
            while (i2 < points.size()) {
                if (points.get(i2).x > center.x && points.get(i2).y < center.y) {
                    double dSqrt3 = java.lang.Math.sqrt(java.lang.Math.pow(points.get(i2).x - center.x, 2.0d) + java.lang.Math.pow(points.get(i2).y - center.y, 2.0d));
                    if (dSqrt3 > d3) {
                        i = i2;
                        d3 = dSqrt3;
                    }
                }
                i2++;
            }
        } else if (type == 3) {
            i = -1;
            double d4 = 0.0d;
            while (i2 < points.size()) {
                if (points.get(i2).x > center.x && points.get(i2).y > center.y) {
                    double dSqrt4 = java.lang.Math.sqrt(java.lang.Math.pow(points.get(i2).x - center.x, 2.0d) + java.lang.Math.pow(points.get(i2).y - center.y, 2.0d));
                    if (dSqrt4 > d4) {
                        i = i2;
                        d4 = dSqrt4;
                    }
                }
                i2++;
            }
        } else {
            i = -1;
        }
        if (i != -1) {
            return new org.opencv.core.Point(points.get(i).x, points.get(i).y);
        }
        return new org.opencv.core.Point(0.0d, 0.0d);
    }
}
