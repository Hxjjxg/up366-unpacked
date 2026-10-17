package com.up366.smart.paper.opencv;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class BalanceUtil {
    public static java.util.List<org.opencv.core.Point> reduce(java.util.List<org.opencv.core.Point> src, int reduce) {
        org.opencv.core.Point point = src.get(3);
        org.opencv.core.Point point2 = src.get(0);
        org.opencv.core.Point point3 = src.get(1);
        org.opencv.core.Point point4 = src.get(2);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (reduce == 0) {
            arrayList.add(point);
            arrayList.add(point2);
            arrayList.add(point3);
            arrayList.add(point4);
            return arrayList;
        }
        org.opencv.core.Point point5 = new org.opencv.core.Point();
        org.opencv.core.Point point6 = new org.opencv.core.Point();
        org.opencv.core.Point point7 = new org.opencv.core.Point();
        org.opencv.core.Point point8 = new org.opencv.core.Point();
        double d = reduce;
        point5.x = point.x + ((point3.x - point.x) / d);
        point5.y = point.y + ((point3.y - point.y) / d);
        point6.x = point2.x - ((point2.x - point4.x) / d);
        point6.y = point2.y + ((point4.y - point2.y) / d);
        point7.x = point3.x - ((point3.x - point.x) / d);
        point7.y = point3.y - ((point3.y - point.y) / d);
        point8.x = point4.x + ((point2.x - point4.x) / d);
        point8.y = point4.y - ((point4.y - point2.y) / d);
        arrayList.add(point5);
        arrayList.add(point6);
        arrayList.add(point7);
        arrayList.add(point8);
        return arrayList;
    }

    public static java.util.List<org.opencv.core.Point> reduceNoDegrees(java.util.List<org.opencv.core.Point> src, int reduce) {
        org.opencv.core.Point point = src.get(0);
        org.opencv.core.Point point2 = src.get(1);
        org.opencv.core.Point point3 = src.get(2);
        org.opencv.core.Point point4 = src.get(3);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (reduce == 0) {
            arrayList.add(point);
            arrayList.add(point2);
            arrayList.add(point3);
            arrayList.add(point4);
            return arrayList;
        }
        org.opencv.core.Point point5 = new org.opencv.core.Point();
        org.opencv.core.Point point6 = new org.opencv.core.Point();
        org.opencv.core.Point point7 = new org.opencv.core.Point();
        org.opencv.core.Point point8 = new org.opencv.core.Point();
        double d = reduce;
        point5.x = point.x + ((point3.x - point.x) / d);
        point5.y = point.y + ((point3.y - point.y) / d);
        point6.x = point2.x - ((point2.x - point4.x) / d);
        point6.y = point2.y + ((point4.y - point2.y) / d);
        point7.x = point3.x - ((point3.x - point.x) / d);
        point7.y = point3.y - ((point3.y - point.y) / d);
        point8.x = point4.x + ((point2.x - point4.x) / d);
        point8.y = point4.y - ((point4.y - point2.y) / d);
        arrayList.add(point5);
        arrayList.add(point6);
        arrayList.add(point7);
        arrayList.add(point8);
        return arrayList;
    }
}
