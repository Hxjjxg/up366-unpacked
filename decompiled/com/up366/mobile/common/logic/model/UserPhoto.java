package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UserPhoto {
    private java.lang.String photoName;
    private boolean selected;
    private java.lang.String url;

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    public java.lang.String getUid() {
        return com.up366.common.digest.MD5.md5(this.photoName + this.url);
    }

    public java.lang.String getPhotoName() {
        return this.photoName;
    }

    public void setPhotoName(java.lang.String str) {
        this.photoName = str;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public void initState() {
        this.selected = this.url.equals(com.up366.mobile.common.logic.Auth.getUserInfo().getPhotoUrl());
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.common.logic.model.UserPhoto userPhoto = (com.up366.mobile.common.logic.model.UserPhoto) obj;
        return this.selected == userPhoto.selected && this.photoName.equals(userPhoto.photoName) && this.url.equals(userPhoto.url);
    }

    public int hashCode() {
        return java.util.Objects.hash(this.photoName, this.url, java.lang.Boolean.valueOf(this.selected));
    }
}
