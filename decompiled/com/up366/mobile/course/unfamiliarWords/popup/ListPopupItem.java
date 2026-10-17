package com.up366.mobile.course.unfamiliarWords.popup;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class ListPopupItem {
    private int imageRes;
    private boolean isChecked;
    private java.lang.String title;

    public ListPopupItem(java.lang.String str, boolean z) {
        this.title = str;
        this.isChecked = z;
    }

    public ListPopupItem(java.lang.String str) {
        this.title = str;
    }

    public ListPopupItem(java.lang.String str, int i) {
        this.title = str;
        this.imageRes = i;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public int getImageRes() {
        return this.imageRes;
    }

    public void setImageRes(int i) {
        this.imageRes = i;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }
}
