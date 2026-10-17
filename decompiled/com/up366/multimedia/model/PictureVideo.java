package com.up366.multimedia.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PictureVideo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.up366.multimedia.model.PictureVideo> CREATOR = new android.os.Parcelable.Creator<com.up366.multimedia.model.PictureVideo>() { // from class: com.up366.multimedia.model.PictureVideo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.multimedia.model.PictureVideo createFromParcel(android.os.Parcel in) {
            return new com.up366.multimedia.model.PictureVideo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.multimedia.model.PictureVideo[] newArray(int size) {
            return new com.up366.multimedia.model.PictureVideo[size];
        }
    };
    public static final int TYPE_ADD = 0;
    public static final int TYPE_PIC = 1;
    public static final int TYPE_VIDEO = 2;
    public java.lang.String posterUrl;
    public int type;
    public android.net.Uri uri;
    public java.lang.String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PictureVideo(int type, java.lang.String url, java.lang.String posterUrl, android.net.Uri uri) {
        this.url = url;
        this.posterUrl = posterUrl;
        this.type = type;
        this.uri = uri;
    }

    protected PictureVideo(android.os.Parcel in) {
        this.url = in.readString();
        this.posterUrl = in.readString();
        this.type = in.readInt();
        this.uri = (android.net.Uri) in.readParcelable(android.net.Uri.class.getClassLoader());
    }

    public boolean isVideo() {
        return this.type == 2;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    public java.lang.String getPosterUrl() {
        return this.posterUrl;
    }

    public void setPosterUrl(java.lang.String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.posterUrl);
        dest.writeInt(this.type);
        dest.writeParcelable(this.uri, flags);
    }
}
