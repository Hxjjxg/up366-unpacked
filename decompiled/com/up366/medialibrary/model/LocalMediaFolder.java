package com.up366.medialibrary.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LocalMediaFolder implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.up366.medialibrary.model.LocalMediaFolder> CREATOR = new android.os.Parcelable.Creator<com.up366.medialibrary.model.LocalMediaFolder>() { // from class: com.up366.medialibrary.model.LocalMediaFolder.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.medialibrary.model.LocalMediaFolder createFromParcel(android.os.Parcel parcel) {
            return new com.up366.medialibrary.model.LocalMediaFolder(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.medialibrary.model.LocalMediaFolder[] newArray(int i) {
            return new com.up366.medialibrary.model.LocalMediaFolder[i];
        }
    };
    private long bucketId;
    private int checkedNum;
    private int currentDataPage;
    private java.util.List<com.up366.medialibrary.model.LocalMedia> data;
    private java.lang.String firstImagePath;
    private java.lang.String firstMimeType;
    private int imageNum;
    private boolean isCameraFolder;
    private boolean isChecked;
    private boolean isHasMore;
    private java.lang.String name;
    private int ofAllType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocalMediaFolder() {
        this.bucketId = -1L;
        this.ofAllType = -1;
        this.data = new java.util.ArrayList();
    }

    protected LocalMediaFolder(android.os.Parcel parcel) {
        this.bucketId = -1L;
        this.ofAllType = -1;
        this.data = new java.util.ArrayList();
        this.bucketId = parcel.readLong();
        this.name = parcel.readString();
        this.firstImagePath = parcel.readString();
        this.firstMimeType = parcel.readString();
        this.imageNum = parcel.readInt();
        this.checkedNum = parcel.readInt();
        this.isChecked = parcel.readByte() != 0;
        this.ofAllType = parcel.readInt();
        this.isCameraFolder = parcel.readByte() != 0;
        this.data = parcel.createTypedArrayList(com.up366.medialibrary.model.LocalMedia.CREATOR);
        this.currentDataPage = parcel.readInt();
        this.isHasMore = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this.bucketId);
        parcel.writeString(this.name);
        parcel.writeString(this.firstImagePath);
        parcel.writeString(this.firstMimeType);
        parcel.writeInt(this.imageNum);
        parcel.writeInt(this.checkedNum);
        parcel.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.ofAllType);
        parcel.writeByte(this.isCameraFolder ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.data);
        parcel.writeInt(this.currentDataPage);
        parcel.writeByte(this.isHasMore ? (byte) 1 : (byte) 0);
    }

    public long getBucketId() {
        return this.bucketId;
    }

    public void setBucketId(long j) {
        this.bucketId = j;
    }

    public java.lang.String getName() {
        return android.text.TextUtils.isEmpty(this.name) ? "unknown" : this.name;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public java.lang.String getFirstImagePath() {
        return this.firstImagePath;
    }

    public void setFirstImagePath(java.lang.String str) {
        this.firstImagePath = str;
    }

    public int getImageNum() {
        return this.imageNum;
    }

    public void setImageNum(int i) {
        this.imageNum = i;
    }

    public int getCheckedNum() {
        return this.checkedNum;
    }

    public void setCheckedNum(int i) {
        this.checkedNum = i;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public int getOfAllType() {
        return this.ofAllType;
    }

    public void setOfAllType(int i) {
        this.ofAllType = i;
    }

    public boolean isCameraFolder() {
        return this.isCameraFolder;
    }

    public void setCameraFolder(boolean z) {
        this.isCameraFolder = z;
    }

    public java.util.List<com.up366.medialibrary.model.LocalMedia> getData() {
        return this.data;
    }

    public void setData(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        this.data = list;
    }

    public int getCurrentDataPage() {
        return this.currentDataPage;
    }

    public void setCurrentDataPage(int i) {
        this.currentDataPage = i;
    }

    public boolean isHasMore() {
        return this.isHasMore;
    }

    public void setHasMore(boolean z) {
        this.isHasMore = z;
    }

    public java.lang.String getFirstMimeType() {
        return this.firstMimeType;
    }

    public void setFirstMimeType(java.lang.String str) {
        this.firstMimeType = str;
    }
}
