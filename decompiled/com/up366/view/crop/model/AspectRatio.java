package com.up366.view.crop.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AspectRatio implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.up366.view.crop.model.AspectRatio> CREATOR = new android.os.Parcelable.Creator<com.up366.view.crop.model.AspectRatio>() { // from class: com.up366.view.crop.model.AspectRatio.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.view.crop.model.AspectRatio createFromParcel(android.os.Parcel parcel) {
            return new com.up366.view.crop.model.AspectRatio(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.view.crop.model.AspectRatio[] newArray(int i) {
            return new com.up366.view.crop.model.AspectRatio[i];
        }
    };
    private final java.lang.String mAspectRatioTitle;
    private final float mAspectRatioX;
    private final float mAspectRatioY;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AspectRatio(java.lang.String str, float f, float f2) {
        this.mAspectRatioTitle = str;
        this.mAspectRatioX = f;
        this.mAspectRatioY = f2;
    }

    protected AspectRatio(android.os.Parcel parcel) {
        this.mAspectRatioTitle = parcel.readString();
        this.mAspectRatioX = parcel.readFloat();
        this.mAspectRatioY = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.mAspectRatioTitle);
        parcel.writeFloat(this.mAspectRatioX);
        parcel.writeFloat(this.mAspectRatioY);
    }

    public java.lang.String getAspectRatioTitle() {
        return this.mAspectRatioTitle;
    }

    public float getAspectRatioX() {
        return this.mAspectRatioX;
    }

    public float getAspectRatioY() {
        return this.mAspectRatioY;
    }
}
