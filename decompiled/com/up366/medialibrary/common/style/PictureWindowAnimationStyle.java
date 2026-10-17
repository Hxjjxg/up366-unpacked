package com.up366.medialibrary.common.style;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureWindowAnimationStyle implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.up366.medialibrary.common.style.PictureWindowAnimationStyle> CREATOR = new android.os.Parcelable.Creator<com.up366.medialibrary.common.style.PictureWindowAnimationStyle>() { // from class: com.up366.medialibrary.common.style.PictureWindowAnimationStyle.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.medialibrary.common.style.PictureWindowAnimationStyle createFromParcel(android.os.Parcel parcel) {
            return new com.up366.medialibrary.common.style.PictureWindowAnimationStyle(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.medialibrary.common.style.PictureWindowAnimationStyle[] newArray(int i) {
            return new com.up366.medialibrary.common.style.PictureWindowAnimationStyle[i];
        }
    };
    public int activityCropEnterAnimation;
    public int activityCropExitAnimation;
    public int activityEnterAnimation;
    public int activityExitAnimation;
    public int activityPreviewEnterAnimation;
    public int activityPreviewExitAnimation;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PictureWindowAnimationStyle() {
    }

    public PictureWindowAnimationStyle(int i, int i2) {
        this.activityEnterAnimation = i;
        this.activityExitAnimation = i2;
        this.activityPreviewEnterAnimation = i;
        this.activityPreviewExitAnimation = i2;
        this.activityCropEnterAnimation = i;
        this.activityCropExitAnimation = i2;
    }

    public PictureWindowAnimationStyle(int i, int i2, int i3, int i4) {
        this.activityEnterAnimation = i;
        this.activityExitAnimation = i2;
        this.activityPreviewEnterAnimation = i3;
        this.activityPreviewExitAnimation = i4;
    }

    public static com.up366.medialibrary.common.style.PictureWindowAnimationStyle ofDefaultWindowAnimationStyle() {
        return new com.up366.medialibrary.common.style.PictureWindowAnimationStyle(com.up366.medialibrary.R.anim.picture_anim_enter, com.up366.medialibrary.R.anim.picture_anim_exit);
    }

    public static com.up366.medialibrary.common.style.PictureWindowAnimationStyle ofCustomWindowAnimationStyle(int i, int i2) {
        return new com.up366.medialibrary.common.style.PictureWindowAnimationStyle(i, i2);
    }

    public void ofAllAnimation(int i, int i2) {
        this.activityEnterAnimation = i;
        this.activityExitAnimation = i2;
        this.activityPreviewEnterAnimation = i;
        this.activityPreviewExitAnimation = i2;
        this.activityCropEnterAnimation = i;
        this.activityCropExitAnimation = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.activityEnterAnimation);
        parcel.writeInt(this.activityExitAnimation);
        parcel.writeInt(this.activityPreviewEnterAnimation);
        parcel.writeInt(this.activityPreviewExitAnimation);
        parcel.writeInt(this.activityCropEnterAnimation);
        parcel.writeInt(this.activityCropExitAnimation);
    }

    protected PictureWindowAnimationStyle(android.os.Parcel parcel) {
        this.activityEnterAnimation = parcel.readInt();
        this.activityExitAnimation = parcel.readInt();
        this.activityPreviewEnterAnimation = parcel.readInt();
        this.activityPreviewExitAnimation = parcel.readInt();
        this.activityCropEnterAnimation = parcel.readInt();
        this.activityCropExitAnimation = parcel.readInt();
    }
}
