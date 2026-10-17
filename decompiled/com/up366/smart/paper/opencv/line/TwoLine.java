package com.up366.smart.paper.opencv.line;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class TwoLine {
    public com.up366.smart.paper.opencv.line.Line baseLine;
    public com.up366.smart.paper.opencv.line.Line extendLine;

    public TwoLine(com.up366.smart.paper.opencv.line.Line baseLine, com.up366.smart.paper.opencv.line.Line extendLine) {
        this.baseLine = baseLine;
        this.extendLine = extendLine;
    }

    public TwoLine() {
    }

    public java.lang.String toString() {
        return "TwoLine{baseLine=" + this.baseLine.toString() + ", extendLine=" + this.extendLine.toString() + '}';
    }
}
