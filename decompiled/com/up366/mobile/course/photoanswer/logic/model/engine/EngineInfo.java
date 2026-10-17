package com.up366.mobile.course.photoanswer.logic.model.engine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class EngineInfo {
    private int[] rect;
    private java.lang.String type;

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String str) {
        this.type = str;
    }

    public int[] getRect() {
        return this.rect;
    }

    public void setRect(int[] iArr) {
        this.rect = iArr;
    }

    public java.lang.String toString() {
        return "EngineInfo{type='" + this.type + "', rect=" + java.util.Arrays.toString(this.rect) + '}';
    }
}
