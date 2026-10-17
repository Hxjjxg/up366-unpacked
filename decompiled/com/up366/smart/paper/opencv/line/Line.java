package com.up366.smart.paper.opencv.line;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class Line {
    private org.opencv.core.Point end;
    private org.opencv.core.Point start;

    public Line() {
    }

    public Line(org.opencv.core.Point start, org.opencv.core.Point end) {
        this.start = start;
        this.end = end;
        sort();
    }

    public org.opencv.core.Point getStart() {
        return this.start;
    }

    public void setStart(org.opencv.core.Point start) {
        this.start = start;
        sort();
    }

    public org.opencv.core.Point getEnd() {
        return this.end;
    }

    public void setEnd(org.opencv.core.Point end) {
        this.end = end;
        sort();
    }

    private void sort() {
        org.opencv.core.Point point = this.start;
        if (point == null || this.end == null || point.y <= this.end.y) {
            return;
        }
        org.opencv.core.Point point2 = this.start;
        this.start = this.end;
        this.end = point2;
    }

    public double slope() {
        org.opencv.core.Point point;
        if (this.start == null || (point = this.end) == null) {
            return 0.0d;
        }
        return (point.y - this.start.y) / (this.end.x - this.start.x);
    }

    public boolean oblique() {
        org.opencv.core.Point point = this.start;
        if (point == null || this.end == null || point.x == this.end.x || this.start.y == this.end.y) {
            return false;
        }
        double d = (this.end.y - this.start.y) / (this.end.x - this.start.x);
        if (d <= java.lang.Math.sqrt(3.0d) / 3.0d || d >= java.lang.Math.sqrt(3.0d)) {
            return d < (-java.lang.Math.sqrt(3.0d)) / 3.0d && d > (-java.lang.Math.sqrt(3.0d));
        }
        return true;
    }

    public java.lang.String toString() {
        return "Line{start=" + this.start.toString() + ", end=" + this.end.toString() + '}';
    }
}
