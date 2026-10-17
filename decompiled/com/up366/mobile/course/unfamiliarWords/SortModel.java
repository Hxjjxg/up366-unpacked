package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class SortModel implements java.io.Serializable {
    public static final java.lang.String FIELD_UPDATE_TIME = "updateTime";
    public static final java.lang.String FIELD_WORD = "word";
    public static final java.lang.String FIELD_WORD_TIMES = "wordTimes";
    private int degree;
    private boolean isChineseHidden;
    private boolean isEnglishHidden;
    private boolean orderDesc;
    private java.lang.String orderField;

    public SortModel() {
    }

    public SortModel(java.lang.String str, boolean z, boolean z2, boolean z3) {
        this.orderField = str;
        this.orderDesc = z;
        this.isChineseHidden = z2;
        this.isEnglishHidden = z3;
    }

    public SortModel(java.lang.String str, boolean z) {
        this.orderField = str;
        this.orderDesc = z;
    }

    public SortModel(java.lang.String str, boolean z, int i) {
        this.orderField = str;
        this.orderDesc = z;
        this.degree = i;
    }

    public java.lang.String getOrderField() {
        return this.orderField;
    }

    public void setOrderField(java.lang.String str) {
        this.orderField = str;
    }

    public boolean isOrderDesc() {
        return this.orderDesc;
    }

    public void setOrderDesc(boolean z) {
        this.orderDesc = z;
    }

    public int getDegree() {
        return this.degree;
    }

    public void setDegree(int i) {
        this.degree = i;
    }

    public boolean isChineseHidden() {
        return this.isChineseHidden;
    }

    public void setChineseHidden(boolean z) {
        this.isChineseHidden = z;
    }

    public boolean isEnglishHidden() {
        return this.isEnglishHidden;
    }

    public void setEnglishHidden(boolean z) {
        this.isEnglishHidden = z;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.course.unfamiliarWords.SortModel sortModel = (com.up366.mobile.course.unfamiliarWords.SortModel) obj;
        if (this.orderDesc != sortModel.orderDesc || this.degree != sortModel.degree || this.isChineseHidden != sortModel.isChineseHidden || this.isEnglishHidden != sortModel.isEnglishHidden) {
            return false;
        }
        java.lang.String str = this.orderField;
        java.lang.String str2 = sortModel.orderField;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        java.lang.String str = this.orderField;
        return ((((((((str != null ? str.hashCode() : 0) * 31) + (this.orderDesc ? 1 : 0)) * 31) + this.degree) * 31) + (this.isChineseHidden ? 1 : 0)) * 31) + (this.isEnglishHidden ? 1 : 0);
    }
}
