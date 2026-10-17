package com.up366.smart.paper.opencv.line;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class LineUtil {
    public static org.opencv.core.Point lineIntersection(com.up366.smart.paper.opencv.line.Line one, com.up366.smart.paper.opencv.line.Line two, int width, int height) {
        double d = one.getStart().x;
        double d2 = one.getStart().y;
        double d3 = one.getEnd().x;
        double d4 = one.getEnd().y;
        double d5 = two.getStart().x;
        double d6 = two.getStart().y;
        double d7 = two.getEnd().x;
        double d8 = d4 - d2;
        double d9 = (d8 * d) + ((d - d3) * d2);
        double d10 = two.getEnd().y - d6;
        double d11 = (d10 * d5) + ((d5 - d7) * d6);
        double d12 = d3 - d;
        double d13 = d7 - d5;
        double d14 = (d12 * d10) - (d13 * d8);
        if (d14 == 0.0d) {
            return null;
        }
        double d15 = ((d12 * d11) - (d13 * d9)) / d14;
        double d16 = ((d11 * d8) - (d9 * d10)) / d14;
        if (d15 < 0.0d || d16 < 0.0d || d15 > width || d16 > height) {
            return null;
        }
        return new org.opencv.core.Point(d15, d16);
    }

    public static com.up366.smart.paper.opencv.line.Line lineExtend(com.up366.smart.paper.opencv.line.Line line, int width, int height) {
        double d;
        double d2;
        line.toString();
        com.up366.smart.paper.opencv.line.Line line2 = new com.up366.smart.paper.opencv.line.Line();
        double d3 = line.getStart().x;
        double d4 = line.getEnd().x;
        if (d3 - d4 == 0.0d) {
            line2.setStart(new org.opencv.core.Point(d3, 0.0d));
            line2.setEnd(new org.opencv.core.Point(d3, height));
            return line2;
        }
        double d5 = line.getStart().y;
        double d6 = line.getEnd().y;
        if (d5 - d6 == 0.0d) {
            line2.setStart(new org.opencv.core.Point(0.0d, d5));
            line2.setEnd(new org.opencv.core.Point(width, d5));
            return line2;
        }
        double d7 = (d6 - d5) / (d4 - d3);
        double d8 = d3 - ((d5 - 0.0d) / d7);
        double d9 = width;
        if (d8 > d9) {
            d2 = d5 - ((d3 - d9) * d7);
            d = d9;
        } else if (d8 < 0.0d) {
            d2 = d5 - (d3 * d7);
            d = 0.0d;
        } else {
            d = d8;
            d2 = 0.0d;
        }
        line2.setStart(new org.opencv.core.Point(d, d2));
        double d10 = height;
        double d11 = ((d10 - d6) / d7) + d4;
        if (d11 > d9) {
            d10 = ((d9 - d4) * d7) + d6;
        } else if (d11 < 0.0d) {
            d10 = ((0.0d - d4) * d7) + d6;
            d9 = 0.0d;
        } else {
            d9 = d11;
        }
        line2.setEnd(new org.opencv.core.Point(d9, d10));
        return line2;
    }

    public static boolean lineNear(com.up366.smart.paper.opencv.line.Line one, com.up366.smart.paper.opencv.line.Line two, int width, int height) {
        org.opencv.core.Point pointLineIntersection = lineIntersection(one, two, width, height);
        if (pointLineIntersection == null) {
            return com.up366.smart.paper.opencv.preprocessed.PointUtil.pointsDistance(one.getStart(), two.getStart()) < 20.0d && com.up366.smart.paper.opencv.preprocessed.PointUtil.pointsDistance(one.getEnd(), two.getEnd()) < 20.0d;
        }
        double dPointsAngle = com.up366.smart.paper.opencv.preprocessed.PointUtil.pointsAngle(one.getStart(), pointLineIntersection, two.getStart());
        return dPointsAngle < 30.0d || dPointsAngle > 150.0d;
    }
}
