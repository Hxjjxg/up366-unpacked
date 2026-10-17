package com.up366.medialibrary.common.style;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureCropParameterStyle implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.up366.medialibrary.common.style.PictureCropParameterStyle> CREATOR = new android.os.Parcelable.Creator<com.up366.medialibrary.common.style.PictureCropParameterStyle>() { // from class: com.up366.medialibrary.common.style.PictureCropParameterStyle.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.medialibrary.common.style.PictureCropParameterStyle createFromParcel(android.os.Parcel parcel) {
            return new com.up366.medialibrary.common.style.PictureCropParameterStyle(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.medialibrary.common.style.PictureCropParameterStyle[] newArray(int i) {
            return new com.up366.medialibrary.common.style.PictureCropParameterStyle[i];
        }
    };
    public int cropNavBarColor;
    public int cropStatusBarColorPrimaryDark;
    public int cropTitleBarBackgroundColor;
    public int cropTitleColor;
    public boolean isChangeStatusBarFontColor;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PictureCropParameterStyle() {
    }

    public PictureCropParameterStyle(int i, int i2, int i3, boolean z) {
        this.cropTitleBarBackgroundColor = i;
        this.cropStatusBarColorPrimaryDark = i2;
        this.cropTitleColor = i3;
        this.isChangeStatusBarFontColor = z;
    }

    public PictureCropParameterStyle(int i, int i2, int i3, int i4, boolean z) {
        this.cropTitleBarBackgroundColor = i;
        this.cropNavBarColor = i3;
        this.cropStatusBarColorPrimaryDark = i2;
        this.cropTitleColor = i4;
        this.isChangeStatusBarFontColor = z;
    }

    public static com.up366.medialibrary.common.style.PictureCropParameterStyle ofDefaultCropStyle() {
        return new com.up366.medialibrary.common.style.PictureCropParameterStyle(android.graphics.Color.parseColor("#393a3e"), android.graphics.Color.parseColor("#393a3e"), android.graphics.Color.parseColor("#393a3e"), android.graphics.Color.parseColor("#FFFFFF"), false);
    }

    public static com.up366.medialibrary.common.style.PictureCropParameterStyle ofSelectTotalStyle() {
        return new com.up366.medialibrary.common.style.PictureCropParameterStyle(android.graphics.Color.parseColor("#FFFFFF"), android.graphics.Color.parseColor("#FFFFFF"), android.graphics.Color.parseColor("#000000"), true);
    }

    public static com.up366.medialibrary.common.style.PictureCropParameterStyle ofSelectNumberStyle() {
        return new com.up366.medialibrary.common.style.PictureCropParameterStyle(android.graphics.Color.parseColor("#7D7DFF"), android.graphics.Color.parseColor("#7D7DFF"), android.graphics.Color.parseColor("#FFFFFF"), false);
    }

    public static com.up366.medialibrary.common.style.PictureCropParameterStyle ofNewStyle() {
        return new com.up366.medialibrary.common.style.PictureCropParameterStyle(android.graphics.Color.parseColor("#393a3e"), android.graphics.Color.parseColor("#393a3e"), android.graphics.Color.parseColor("#393a3e"), android.graphics.Color.parseColor("#FFFFFF"), false);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByte(this.isChangeStatusBarFontColor ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.cropTitleBarBackgroundColor);
        parcel.writeInt(this.cropStatusBarColorPrimaryDark);
        parcel.writeInt(this.cropTitleColor);
        parcel.writeInt(this.cropNavBarColor);
    }

    protected PictureCropParameterStyle(android.os.Parcel parcel) {
        this.isChangeStatusBarFontColor = parcel.readByte() != 0;
        this.cropTitleBarBackgroundColor = parcel.readInt();
        this.cropStatusBarColorPrimaryDark = parcel.readInt();
        this.cropTitleColor = parcel.readInt();
        this.cropNavBarColor = parcel.readInt();
    }
}
