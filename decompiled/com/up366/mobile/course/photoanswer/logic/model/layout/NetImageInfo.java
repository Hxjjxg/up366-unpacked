package com.up366.mobile.course.photoanswer.logic.model.layout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class NetImageInfo {
    private int basex;
    private int basey;
    private int[][] bottomTags;
    private int height;
    private int imageCount;
    private boolean isA3;
    private int[][] leftTags;
    private int[][] rightTags;
    private int[][] topTags;
    private int width;

    public boolean isA3() {
        return this.isA3;
    }

    public void setA3(boolean z) {
        this.isA3 = z;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getImageCount() {
        return this.imageCount;
    }

    public void setImageCount(int i) {
        this.imageCount = i;
    }

    public int getBasex() {
        return this.basex;
    }

    public void setBasex(int i) {
        this.basex = i;
    }

    public int getBasey() {
        return this.basey;
    }

    public void setBasey(int i) {
        this.basey = i;
    }

    public int[][] getTopTags() {
        return this.topTags;
    }

    public void setTopTags(int[][] iArr) {
        this.topTags = iArr;
    }

    public int[][] getBottomTags() {
        return this.bottomTags;
    }

    public void setBottomTags(int[][] iArr) {
        this.bottomTags = iArr;
    }

    public int[][] getLeftTags() {
        return this.leftTags;
    }

    public void setLeftTags(int[][] iArr) {
        this.leftTags = iArr;
    }

    public int[][] getRightTags() {
        return this.rightTags;
    }

    public void setRightTags(int[][] iArr) {
        this.rightTags = iArr;
    }
}
