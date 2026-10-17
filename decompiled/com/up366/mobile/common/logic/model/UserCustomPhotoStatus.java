package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UserCustomPhotoStatus {
    private long addTime;
    private java.lang.String headPhoto;
    private int status = -1;
    private boolean needShowErrorTip = false;

    public java.lang.String getHeadPhoto() {
        return this.headPhoto;
    }

    public void setHeadPhoto(java.lang.String str) {
        this.headPhoto = str;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public boolean isChecking() {
        return this.status == 0;
    }

    public boolean isCheckOk() {
        return this.status == 1;
    }

    public boolean isCheckFail() {
        return this.status == 2;
    }

    public boolean isNeedShowErrorTip() {
        return this.needShowErrorTip;
    }

    public void checkShowErrorTipStatus() {
        if (!isCheckFail()) {
            this.needShowErrorTip = false;
            return;
        }
        if (com.up366.mobile.common.utils.PreferenceUtils.getLong("lastFailTime" + com.up366.mobile.common.logic.Auth.UID(), 0L) != this.addTime) {
            com.up366.mobile.common.utils.PreferenceUtils.putLong("lastFailTime" + com.up366.mobile.common.logic.Auth.UID(), this.addTime);
            this.needShowErrorTip = true;
            return;
        }
        this.needShowErrorTip = false;
    }
}
