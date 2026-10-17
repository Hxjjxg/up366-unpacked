package com.up366.mobile.user.account.switchaccount;

/* JADX INFO: compiled from: SwitchAccountData.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010&\u001a\u00020\u000bJ\u0006\u0010'\u001a\u00020 J\b\u0010(\u001a\u00020\u000bH\u0002J\u0013\u0010)\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#¨\u0006-"}, d2 = {"Lcom/up366/mobile/user/account/switchaccount/SwitchAccountData;", "", "<init>", "()V", "uid", "", "getUid", "()I", "setUid", "(I)V", "userName", "", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "realName", "getRealName", "setRealName", "passwd", "getPasswd", "setPasswd", "userPhoto", "getUserPhoto", "setUserPhoto", "authType", "getAuthType", "setAuthType", "openId", "getOpenId", "setOpenId", "isEditing", "", "()Z", "setEditing", "(Z)V", "isDelete", "setDelete", "sortKey", "isCurrentUser", "getPinYin", "equals", "other", "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwitchAccountData {
    private int authType;
    private boolean isDelete;
    private boolean isEditing;
    private int uid;
    private java.lang.String userName = "";
    private java.lang.String realName = "";
    private java.lang.String passwd = "";
    private java.lang.String userPhoto = "";
    private java.lang.String openId = "";

    public final int getUid() {
        return this.uid;
    }

    public final void setUid(int i) {
        this.uid = i;
    }

    public final java.lang.String getUserName() {
        return this.userName;
    }

    public final void setUserName(java.lang.String str) {
        this.userName = str;
    }

    public final java.lang.String getRealName() {
        return this.realName;
    }

    public final void setRealName(java.lang.String str) {
        this.realName = str;
    }

    public final java.lang.String getPasswd() {
        return this.passwd;
    }

    public final void setPasswd(java.lang.String str) {
        this.passwd = str;
    }

    public final java.lang.String getUserPhoto() {
        return this.userPhoto;
    }

    public final void setUserPhoto(java.lang.String str) {
        this.userPhoto = str;
    }

    public final int getAuthType() {
        return this.authType;
    }

    public final void setAuthType(int i) {
        this.authType = i;
    }

    public final java.lang.String getOpenId() {
        return this.openId;
    }

    public final void setOpenId(java.lang.String str) {
        this.openId = str;
    }

    /* JADX INFO: renamed from: isEditing, reason: from getter */
    public final boolean getIsEditing() {
        return this.isEditing;
    }

    public final void setEditing(boolean z) {
        this.isEditing = z;
    }

    /* JADX INFO: renamed from: isDelete, reason: from getter */
    public final boolean getIsDelete() {
        return this.isDelete;
    }

    public final void setDelete(boolean z) {
        this.isDelete = z;
    }

    public final java.lang.String sortKey() {
        if (isCurrentUser()) {
            return "0000";
        }
        return getPinYin();
    }

    public final boolean isCurrentUser() {
        return kotlin.jvm.internal.Intrinsics.areEqual(com.up366.mobile.common.logic.Auth.getUserInfo().getUsername(), this.userName);
    }

    private final java.lang.String getPinYin() {
        try {
            java.lang.String pinYinString = com.up366.mobile.book.helper.PinYinHelper.INSTANCE.getPinYinString(this.realName);
            if (!com.up366.common.StringUtils.isEmptyOrNull(pinYinString)) {
                return pinYinString;
            }
            java.lang.String str = this.userName;
            return str == null ? "" : str;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getPinYin error", e);
            java.lang.String str2 = this.userName;
            kotlin.jvm.internal.Intrinsics.checkNotNull(str2);
            return str2;
        }
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.up366.mobile.user.account.switchaccount.SwitchAccountData");
        com.up366.mobile.user.account.switchaccount.SwitchAccountData switchAccountData = (com.up366.mobile.user.account.switchaccount.SwitchAccountData) other;
        return this.uid == switchAccountData.uid && kotlin.jvm.internal.Intrinsics.areEqual(this.userName, switchAccountData.userName) && kotlin.jvm.internal.Intrinsics.areEqual(this.realName, switchAccountData.realName) && kotlin.jvm.internal.Intrinsics.areEqual(this.passwd, switchAccountData.passwd) && kotlin.jvm.internal.Intrinsics.areEqual(this.userPhoto, switchAccountData.userPhoto) && this.authType == switchAccountData.authType && kotlin.jvm.internal.Intrinsics.areEqual(this.openId, switchAccountData.openId) && this.isEditing == switchAccountData.isEditing && this.isDelete == switchAccountData.isDelete;
    }

    public int hashCode() {
        int i = this.uid * 31;
        java.lang.String str = this.userName;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.realName;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.passwd;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        java.lang.String str4 = this.userPhoto;
        int iHashCode4 = (((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.authType) * 31;
        java.lang.String str5 = this.openId;
        return ((((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticBackport0.m(this.isEditing)) * 31) + com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticBackport0.m(this.isDelete);
    }

    public java.lang.String toString() {
        return "SwitchAccountData(uid=" + this.uid + ", userName=" + this.userName + ", realName=" + this.realName + ",userPhoto=" + this.userPhoto + ", authType=" + this.authType + ", openId=" + this.openId + ", isEditing=" + this.isEditing + ", isDelete=" + this.isDelete + ")";
    }
}
