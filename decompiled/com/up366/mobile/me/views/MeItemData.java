package com.up366.mobile.me.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeItemData {
    private int leftDrawableId;
    private java.lang.String rightTip;
    private int rightTipColor;
    private java.lang.String title;

    public MeItemData(int i, java.lang.String str, java.lang.String str2) {
        this.leftDrawableId = i;
        this.title = str;
        this.rightTip = str2;
    }

    public MeItemData(int i, java.lang.String str, java.lang.String str2, int i2) {
        this.leftDrawableId = i;
        this.title = str;
        this.rightTip = str2;
        this.rightTipColor = i2;
    }

    public int getLeftDrawableId() {
        return this.leftDrawableId;
    }

    public void setLeftDrawableId(int i) {
        this.leftDrawableId = i;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public java.lang.String getRightTip() {
        return this.rightTip;
    }

    public void setRightTip(java.lang.String str) {
        this.rightTip = str;
    }

    public int getRightTipColor() {
        return this.rightTipColor;
    }

    public void setRightTipColor(int i) {
        this.rightTipColor = i;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.me.views.MeItemData meItemData = (com.up366.mobile.me.views.MeItemData) obj;
        if (this.leftDrawableId != meItemData.leftDrawableId || this.rightTipColor != meItemData.rightTipColor) {
            return false;
        }
        java.lang.String str = this.title;
        if (str == null ? meItemData.title != null : !str.equals(meItemData.title)) {
            return false;
        }
        java.lang.String str2 = this.rightTip;
        java.lang.String str3 = meItemData.rightTip;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        int i = this.leftDrawableId * 31;
        java.lang.String str = this.title;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.rightTip;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.rightTipColor;
    }

    public java.lang.String toString() {
        return "MeItemData{leftDrawableId=" + this.leftDrawableId + ", title='" + this.title + "', rightTip='" + this.rightTip + "'}";
    }
}
