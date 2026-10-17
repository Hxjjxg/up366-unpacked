package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountCityInfo {
    private java.lang.String cityId;
    private java.lang.String cityName;
    private java.lang.String cityNamePinyin;

    public java.lang.String getCityId() {
        return this.cityId;
    }

    public void setCityId(java.lang.String str) {
        this.cityId = str;
    }

    public java.lang.String getCityName() {
        return this.cityName;
    }

    public void setCityName(java.lang.String str) {
        this.cityName = str;
    }

    public java.lang.String getCityNamePinyin() {
        return this.cityNamePinyin;
    }

    public char getFirstLetter() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.cityNamePinyin)) {
            return '#';
        }
        return this.cityNamePinyin.toUpperCase().charAt(0);
    }

    public void setCityNamePinyin(java.lang.String str) {
        this.cityNamePinyin = str;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo = (com.up366.mobile.common.logic.model.AccountCityInfo) obj;
        java.lang.String str = this.cityId;
        if (str == null ? accountCityInfo.cityId != null : !str.equals(accountCityInfo.cityId)) {
            return false;
        }
        java.lang.String str2 = this.cityName;
        if (str2 == null ? accountCityInfo.cityName != null : !str2.equals(accountCityInfo.cityName)) {
            return false;
        }
        java.lang.String str3 = this.cityNamePinyin;
        java.lang.String str4 = accountCityInfo.cityNamePinyin;
        return str3 != null ? str3.equals(str4) : str4 == null;
    }

    public int hashCode() {
        java.lang.String str = this.cityId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.cityName;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.cityNamePinyin;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }
}
