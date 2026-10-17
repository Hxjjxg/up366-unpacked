package com.up366.smart.paper.opencv.line;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PointLine {
    public com.up366.smart.paper.opencv.line.TwoLine firstTwoLine;
    public org.opencv.core.Point point;
    public com.up366.smart.paper.opencv.line.TwoLine secondTwoLine;

    public PointLine(org.opencv.core.Point point, com.up366.smart.paper.opencv.line.TwoLine firstTwoLine, com.up366.smart.paper.opencv.line.TwoLine secondTwoLine) {
        this.point = point;
        this.firstTwoLine = firstTwoLine;
        this.secondTwoLine = secondTwoLine;
    }

    public double pointAngle() {
        return com.up366.smart.paper.opencv.preprocessed.PointUtil.pointsAngle(this.firstTwoLine.extendLine.getStart(), this.point, this.secondTwoLine.extendLine.getStart());
    }

    public java.lang.String toString() {
        return "PointLine{point=" + this.point.toString() + ", firstTwoLine=" + this.firstTwoLine.toString() + ", secondTwoLine=" + this.secondTwoLine.toString() + '}';
    }
}
