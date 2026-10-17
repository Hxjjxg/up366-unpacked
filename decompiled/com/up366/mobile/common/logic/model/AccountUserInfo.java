package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountUserInfo {
    private boolean checked;
    private boolean checkedEnable;
    private java.lang.String realname;
    private java.lang.String username;

    public java.lang.String getUsername() {
        return this.username;
    }

    public void setUsername(java.lang.String str) {
        this.username = str;
    }

    public java.lang.String getRealname() {
        return this.realname;
    }

    public void setRealname(java.lang.String str) {
        this.realname = str;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public boolean isCheckedEnable() {
        return this.checkedEnable;
    }

    public void setCheckedEnable(boolean z) {
        this.checkedEnable = z;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.common.logic.model.AccountUserInfo accountUserInfo = (com.up366.mobile.common.logic.model.AccountUserInfo) obj;
        if (this.checked != accountUserInfo.checked || this.checkedEnable != accountUserInfo.checkedEnable) {
            return false;
        }
        java.lang.String str = this.username;
        if (str == null ? accountUserInfo.username != null : !str.equals(accountUserInfo.username)) {
            return false;
        }
        java.lang.String str2 = this.realname;
        java.lang.String str3 = accountUserInfo.realname;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        java.lang.String str = this.username;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.realname;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.checked ? 1 : 0)) * 31) + (this.checkedEnable ? 1 : 0);
    }
}
