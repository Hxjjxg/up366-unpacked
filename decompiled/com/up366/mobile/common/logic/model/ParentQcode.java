package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ParentQcode implements java.io.Serializable {
    public static final int TYPE_PROGRAME = 2;
    public static final int TYPE_PUBLIC = 1;
    private long curTime;
    private int defaultImage;
    private long expireTime;
    private java.lang.String title;
    private int type;
    private java.lang.String url;
    private java.lang.String userName;

    public ParentQcode() {
    }

    public ParentQcode(int i) {
        this.type = i;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    public long getCurTime() {
        return this.curTime;
    }

    public void setCurTime(long j) {
        this.curTime = j;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public com.up366.mobile.common.logic.model.ParentQcode initDefaultData() {
        int i = this.type;
        if (i != 1) {
            if (i == 2) {
                this.userName = getRealName();
                this.defaultImage = com.up366.mobile.R.drawable.parent_small_program;
                this.title = "「天学英语家长圈」小程序";
            }
            return this;
        }
        this.userName = getRealName() + "邀请您";
        this.defaultImage = com.up366.mobile.R.drawable.qr_parent;
        this.title = "关注「天学英语家长圈」公众号";
        return this;
    }

    public java.lang.String getUserName() {
        return this.userName;
    }

    public int getDefaultImage() {
        return this.defaultImage;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    private java.lang.String getRealName() {
        java.lang.String realname = com.up366.mobile.common.logic.Auth.getUserInfo().getRealname();
        if (com.up366.common.StringUtils.isEmptyOrNull(realname)) {
            return "";
        }
        if (realname.length() <= 6) {
            return realname;
        }
        return realname.substring(0, 6) + "...";
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.common.logic.model.ParentQcode parentQcode = (com.up366.mobile.common.logic.model.ParentQcode) obj;
        if (this.expireTime != parentQcode.expireTime || this.curTime != parentQcode.curTime || this.type != parentQcode.type || this.defaultImage != parentQcode.defaultImage) {
            return false;
        }
        java.lang.String str = this.url;
        if (str == null ? parentQcode.url != null : !str.equals(parentQcode.url)) {
            return false;
        }
        java.lang.String str2 = this.userName;
        if (str2 == null ? parentQcode.userName != null : !str2.equals(parentQcode.userName)) {
            return false;
        }
        java.lang.String str3 = this.title;
        java.lang.String str4 = parentQcode.title;
        return str3 != null ? str3.equals(str4) : str4 == null;
    }

    public int hashCode() {
        java.lang.String str = this.url;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.expireTime;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.curTime;
        int i2 = (((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.type) * 31;
        java.lang.String str2 = this.userName;
        int iHashCode2 = (((i2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.defaultImage) * 31;
        java.lang.String str3 = this.title;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }
}
