package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppConfigBanner {
    private int clientType;
    private int displayOrder;
    private java.lang.String forwordUrl;
    private java.lang.String guid;
    private java.lang.String imgName;
    private boolean isEnabled;
    private java.lang.String resUrl;
    private int type;

    public int getClientType() {
        return this.clientType;
    }

    public void setClientType(int i) {
        this.clientType = i;
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public java.lang.String getForwordUrl() {
        return this.forwordUrl;
    }

    public void setForwordUrl(java.lang.String str) {
        this.forwordUrl = str;
    }

    public java.lang.String getGuid() {
        return this.guid;
    }

    public void setGuid(java.lang.String str) {
        this.guid = str;
    }

    public java.lang.String getImgName() {
        return this.imgName;
    }

    public void setImgName(java.lang.String str) {
        this.imgName = str;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public java.lang.String getResUrl() {
        return this.resUrl;
    }

    public void setResUrl(java.lang.String str) {
        this.resUrl = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.common.logic.model.AppConfigBanner appConfigBanner = (com.up366.mobile.common.logic.model.AppConfigBanner) obj;
        if (this.clientType != appConfigBanner.clientType || this.displayOrder != appConfigBanner.displayOrder || this.isEnabled != appConfigBanner.isEnabled || this.type != appConfigBanner.type) {
            return false;
        }
        java.lang.String str = this.forwordUrl;
        if (str == null ? appConfigBanner.forwordUrl != null : !str.equals(appConfigBanner.forwordUrl)) {
            return false;
        }
        java.lang.String str2 = this.guid;
        if (str2 == null ? appConfigBanner.guid != null : !str2.equals(appConfigBanner.guid)) {
            return false;
        }
        java.lang.String str3 = this.imgName;
        if (str3 == null ? appConfigBanner.imgName != null : !str3.equals(appConfigBanner.imgName)) {
            return false;
        }
        java.lang.String str4 = this.resUrl;
        java.lang.String str5 = appConfigBanner.resUrl;
        return str4 != null ? str4.equals(str5) : str5 == null;
    }

    public int hashCode() {
        int i = ((this.clientType * 31) + this.displayOrder) * 31;
        java.lang.String str = this.forwordUrl;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.guid;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.imgName;
        int iHashCode3 = (((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.isEnabled ? 1 : 0)) * 31;
        java.lang.String str4 = this.resUrl;
        return ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.type;
    }
}
