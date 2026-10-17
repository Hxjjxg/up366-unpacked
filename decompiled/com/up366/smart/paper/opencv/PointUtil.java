package com.up366.smart.paper.opencv;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PointUtil {
    public static double pointDistance(org.opencv.core.Point first, org.opencv.core.Point second) {
        return java.lang.Math.sqrt(java.lang.Math.pow(first.x - second.x, 2.0d) + java.lang.Math.pow(first.y - second.y, 2.0d));
    }
}
