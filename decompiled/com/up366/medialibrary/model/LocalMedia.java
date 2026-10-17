package com.up366.medialibrary.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LocalMedia implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.up366.medialibrary.model.LocalMedia> CREATOR = new android.os.Parcelable.Creator<com.up366.medialibrary.model.LocalMedia>() { // from class: com.up366.medialibrary.model.LocalMedia.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.medialibrary.model.LocalMedia createFromParcel(android.os.Parcel parcel) {
            return new com.up366.medialibrary.model.LocalMedia(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.medialibrary.model.LocalMedia[] newArray(int i) {
            return new com.up366.medialibrary.model.LocalMedia[i];
        }
    };
    private java.lang.String androidQToPath;
    private long bucketId;
    private int chooseModel;
    private java.lang.String compressPath;
    private boolean compressed;
    private int cropImageHeight;
    private int cropImageWidth;
    private int cropOffsetX;
    private int cropOffsetY;
    private float cropResultAspectRatio;
    private java.lang.String cutPath;
    private long dateAddedTime;
    private long duration;
    private java.lang.String fileName;
    private int height;
    private long id;
    private boolean isChecked;
    private boolean isCut;
    private boolean isEditorImage;
    public boolean isLongImage;
    private boolean isMaxSelectEnabledMask;
    private boolean isOriginal;
    public int loadLongImageStatus;
    private java.lang.String mimeType;
    private int num;

    @java.lang.Deprecated
    private int orientation;
    private java.lang.String originalPath;
    private java.lang.String parentFolderName;
    private java.lang.String path;
    public int position;
    private java.lang.String realPath;
    private long size;
    private int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocalMedia() {
        this.orientation = -1;
        this.loadLongImageStatus = -1;
        this.bucketId = -1L;
    }

    protected LocalMedia(android.os.Parcel parcel) {
        this.orientation = -1;
        this.loadLongImageStatus = -1;
        this.bucketId = -1L;
        this.id = parcel.readLong();
        this.path = parcel.readString();
        this.realPath = parcel.readString();
        this.originalPath = parcel.readString();
        this.compressPath = parcel.readString();
        this.cutPath = parcel.readString();
        this.androidQToPath = parcel.readString();
        this.duration = parcel.readLong();
        this.isChecked = parcel.readByte() != 0;
        this.isCut = parcel.readByte() != 0;
        this.position = parcel.readInt();
        this.num = parcel.readInt();
        this.mimeType = parcel.readString();
        this.chooseModel = parcel.readInt();
        this.compressed = parcel.readByte() != 0;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.cropImageWidth = parcel.readInt();
        this.cropImageHeight = parcel.readInt();
        this.cropOffsetX = parcel.readInt();
        this.cropOffsetY = parcel.readInt();
        this.cropResultAspectRatio = parcel.readFloat();
        this.size = parcel.readLong();
        this.isOriginal = parcel.readByte() != 0;
        this.fileName = parcel.readString();
        this.parentFolderName = parcel.readString();
        this.orientation = parcel.readInt();
        this.loadLongImageStatus = parcel.readInt();
        this.isLongImage = parcel.readByte() != 0;
        this.bucketId = parcel.readLong();
        this.isMaxSelectEnabledMask = parcel.readByte() != 0;
        this.isEditorImage = parcel.readByte() != 0;
        this.dateAddedTime = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.path);
        parcel.writeString(this.realPath);
        parcel.writeString(this.originalPath);
        parcel.writeString(this.compressPath);
        parcel.writeString(this.cutPath);
        parcel.writeString(this.androidQToPath);
        parcel.writeLong(this.duration);
        parcel.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCut ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.position);
        parcel.writeInt(this.num);
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.chooseModel);
        parcel.writeByte(this.compressed ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.cropImageWidth);
        parcel.writeInt(this.cropImageHeight);
        parcel.writeInt(this.cropOffsetX);
        parcel.writeInt(this.cropOffsetY);
        parcel.writeFloat(this.cropResultAspectRatio);
        parcel.writeLong(this.size);
        parcel.writeByte(this.isOriginal ? (byte) 1 : (byte) 0);
        parcel.writeString(this.fileName);
        parcel.writeString(this.parentFolderName);
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.loadLongImageStatus);
        parcel.writeByte(this.isLongImage ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.bucketId);
        parcel.writeByte(this.isMaxSelectEnabledMask ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isEditorImage ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.dateAddedTime);
    }

    public static com.up366.medialibrary.model.LocalMedia parseHttpLocalMedia(java.lang.String str, java.lang.String str2) {
        return parseLocalMedia(0L, str, "", "", "", 0L, com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage(), str2, 0, 0, 0L, -1L, 0L);
    }

    public static com.up366.medialibrary.model.LocalMedia parseLocalMedia(java.lang.String str, int i, int i2) {
        com.up366.medialibrary.model.LocalMedia localMedia = parseLocalMedia(0L, str, "", "", "", 0L, i2, "", 0, 0, 0L, -1L, 0L);
        localMedia.setPosition(i);
        return localMedia;
    }

    public static com.up366.medialibrary.model.LocalMedia parseLocalMedia(long j, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j2, int i, java.lang.String str5, int i2, int i3, long j3, long j4, long j5) {
        com.up366.medialibrary.model.LocalMedia localMedia = new com.up366.medialibrary.model.LocalMedia();
        localMedia.setId(j);
        localMedia.setPath(str);
        localMedia.setRealPath(str2);
        localMedia.setFileName(str3);
        localMedia.setParentFolderName(str4);
        localMedia.setDuration(j2);
        localMedia.setChooseModel(i);
        localMedia.setMimeType(str5);
        localMedia.setWidth(i2);
        localMedia.setHeight(i3);
        localMedia.setSize(j3);
        localMedia.setBucketId(j4);
        localMedia.setDateAddedTime(j5);
        return localMedia;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public java.lang.String getCompressPath() {
        return this.compressPath;
    }

    public void setCompressPath(java.lang.String str) {
        this.compressPath = str;
    }

    public java.lang.String getCutPath() {
        return this.cutPath;
    }

    public void setCutPath(java.lang.String str) {
        this.cutPath = str;
    }

    public java.lang.String getAndroidQToPath() {
        return this.androidQToPath;
    }

    public void setAndroidQToPath(java.lang.String str) {
        this.androidQToPath = str;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public java.lang.String getRealPath() {
        return this.realPath;
    }

    public void setRealPath(java.lang.String str) {
        this.realPath = str;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public boolean isCut() {
        return this.isCut && !android.text.TextUtils.isEmpty(getCutPath());
    }

    public void setCut(boolean z) {
        this.isCut = z;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int i) {
        this.num = i;
    }

    public java.lang.String getMimeType() {
        return android.text.TextUtils.isEmpty(this.mimeType) ? "image/jpeg" : this.mimeType;
    }

    public void setMimeType(java.lang.String str) {
        this.mimeType = str;
    }

    public boolean isCompressed() {
        return this.compressed && !android.text.TextUtils.isEmpty(getCompressPath());
    }

    public void setCompressed(boolean z) {
        this.compressed = z;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getChooseModel() {
        return this.chooseModel;
    }

    public void setChooseModel(int i) {
        this.chooseModel = i;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public boolean isOriginal() {
        return this.isOriginal;
    }

    public void setOriginal(boolean z) {
        this.isOriginal = z;
    }

    public java.lang.String getOriginalPath() {
        return this.originalPath;
    }

    public void setOriginalPath(java.lang.String str) {
        this.originalPath = str;
    }

    public java.lang.String getFileName() {
        return this.fileName;
    }

    public void setFileName(java.lang.String str) {
        this.fileName = str;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public java.lang.String getParentFolderName() {
        return this.parentFolderName;
    }

    public void setParentFolderName(java.lang.String str) {
        this.parentFolderName = str;
    }

    @java.lang.Deprecated
    public int getOrientation() {
        return this.orientation;
    }

    @java.lang.Deprecated
    public void setOrientation(int i) {
        this.orientation = i;
    }

    public long getBucketId() {
        return this.bucketId;
    }

    public void setBucketId(long j) {
        this.bucketId = j;
    }

    public boolean isMaxSelectEnabledMask() {
        return this.isMaxSelectEnabledMask;
    }

    public void setMaxSelectEnabledMask(boolean z) {
        this.isMaxSelectEnabledMask = z;
    }

    public long getDateAddedTime() {
        return this.dateAddedTime;
    }

    public void setDateAddedTime(long j) {
        this.dateAddedTime = j;
    }

    public int getCropImageWidth() {
        return this.cropImageWidth;
    }

    public void setCropImageWidth(int i) {
        this.cropImageWidth = i;
    }

    public int getCropImageHeight() {
        return this.cropImageHeight;
    }

    public void setCropImageHeight(int i) {
        this.cropImageHeight = i;
    }

    public int getCropOffsetX() {
        return this.cropOffsetX;
    }

    public void setCropOffsetX(int i) {
        this.cropOffsetX = i;
    }

    public int getCropOffsetY() {
        return this.cropOffsetY;
    }

    public void setCropOffsetY(int i) {
        this.cropOffsetY = i;
    }

    public float getCropResultAspectRatio() {
        return this.cropResultAspectRatio;
    }

    public void setCropResultAspectRatio(float f) {
        this.cropResultAspectRatio = f;
    }

    public boolean isEditorImage() {
        return this.isEditorImage;
    }

    public void setEditorImage(boolean z) {
        this.isEditorImage = z;
    }

    public boolean isToSandboxPath() {
        return !android.text.TextUtils.isEmpty(getAndroidQToPath());
    }

    public java.lang.String toString() {
        return "LocalMedia{id=" + this.id + ", path='" + this.path + "', realPath='" + this.realPath + "', originalPath='" + this.originalPath + "', compressPath='" + this.compressPath + "', cutPath='" + this.cutPath + "', androidQToPath='" + this.androidQToPath + "', duration=" + this.duration + ", isChecked=" + this.isChecked + ", isCut=" + this.isCut + ", position=" + this.position + ", num=" + this.num + ", mimeType='" + this.mimeType + "', chooseModel=" + this.chooseModel + ", compressed=" + this.compressed + ", width=" + this.width + ", height=" + this.height + ", cropImageWidth=" + this.cropImageWidth + ", cropImageHeight=" + this.cropImageHeight + ", cropOffsetX=" + this.cropOffsetX + ", cropOffsetY=" + this.cropOffsetY + ", cropResultAspectRatio=" + this.cropResultAspectRatio + ", size=" + this.size + ", isOriginal=" + this.isOriginal + ", fileName='" + this.fileName + "', parentFolderName='" + this.parentFolderName + "', orientation=" + this.orientation + ", bucketId=" + this.bucketId + ", isMaxSelectEnabledMask=" + this.isMaxSelectEnabledMask + ", isEditorImage=" + this.isEditorImage + ", dateAddedTime=" + this.dateAddedTime + '}';
    }

    public com.up366.medialibrary.MediaInfo getMediaInfo() {
        java.lang.String strMakeAndCacheThumbnail;
        if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(this.mimeType)) {
            strMakeAndCacheThumbnail = "";
        } else {
            strMakeAndCacheThumbnail = com.up366.medialibrary.common.utils.ThumbnailUtils.makeAndCacheThumbnail(this.realPath);
        }
        return new com.up366.medialibrary.MediaInfo(this.path, this.realPath, this.compressPath, this.androidQToPath, this.size, this.duration, this.fileName, this.mimeType, this.isOriginal, strMakeAndCacheThumbnail);
    }
}
