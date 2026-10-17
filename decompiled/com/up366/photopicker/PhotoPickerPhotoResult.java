package com.up366.photopicker;

/* JADX INFO: compiled from: PhotoPickerPhotoResult.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001dJ\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006#"}, d2 = {"Lcom/up366/photopicker/PhotoPickerPhotoResult;", "Landroid/os/Parcelable;", "localPath", "", com.up366.mobile.commonui.CommonWebViewActivity.URL, "size", "", "isRectAdjusted", "", "(Ljava/lang/String;Ljava/lang/String;JZ)V", "()Z", "getLocalPath", "()Ljava/lang/String;", "getSize", "()J", "getUrl", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "toWebPayload", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PhotoPickerPhotoResult implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.up366.photopicker.PhotoPickerPhotoResult> CREATOR = new com.up366.photopicker.PhotoPickerPhotoResult.Creator();
    private final boolean isRectAdjusted;
    private final java.lang.String localPath;
    private final long size;
    private final java.lang.String url;

    /* JADX INFO: compiled from: PhotoPickerPhotoResult.kt */
    @kotlin.Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements android.os.Parcelable.Creator<com.up366.photopicker.PhotoPickerPhotoResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.up366.photopicker.PhotoPickerPhotoResult createFromParcel(android.os.Parcel parcel) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new com.up366.photopicker.PhotoPickerPhotoResult(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.up366.photopicker.PhotoPickerPhotoResult[] newArray(int i) {
            return new com.up366.photopicker.PhotoPickerPhotoResult[i];
        }
    }

    public PhotoPickerPhotoResult() {
        this(null, null, 0L, false, 15, null);
    }

    public static /* synthetic */ com.up366.photopicker.PhotoPickerPhotoResult copy$default(com.up366.photopicker.PhotoPickerPhotoResult photoPickerPhotoResult, java.lang.String str, java.lang.String str2, long j, boolean z, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = photoPickerPhotoResult.localPath;
        }
        if ((i & 2) != 0) {
            str2 = photoPickerPhotoResult.url;
        }
        java.lang.String str3 = str2;
        if ((i & 4) != 0) {
            j = photoPickerPhotoResult.size;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z = photoPickerPhotoResult.isRectAdjusted;
        }
        return photoPickerPhotoResult.copy(str, str3, j2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final java.lang.String getLocalPath() {
        return this.localPath;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final java.lang.String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsRectAdjusted() {
        return this.isRectAdjusted;
    }

    public final com.up366.photopicker.PhotoPickerPhotoResult copy(java.lang.String localPath, java.lang.String url, long size, boolean isRectAdjusted) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(url, com.up366.mobile.commonui.CommonWebViewActivity.URL);
        return new com.up366.photopicker.PhotoPickerPhotoResult(localPath, url, size, isRectAdjusted);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof com.up366.photopicker.PhotoPickerPhotoResult)) {
            return false;
        }
        com.up366.photopicker.PhotoPickerPhotoResult photoPickerPhotoResult = (com.up366.photopicker.PhotoPickerPhotoResult) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.localPath, photoPickerPhotoResult.localPath) && kotlin.jvm.internal.Intrinsics.areEqual(this.url, photoPickerPhotoResult.url) && this.size == photoPickerPhotoResult.size && this.isRectAdjusted == photoPickerPhotoResult.isRectAdjusted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        java.lang.String str = this.localPath;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.url.hashCode()) * 31) + kotlin.UByte$.ExternalSyntheticBackport0.m(this.size)) * 31;
        boolean z = this.isRectAdjusted;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public java.lang.String toString() {
        return "PhotoPickerPhotoResult(localPath=" + this.localPath + ", url=" + this.url + ", size=" + this.size + ", isRectAdjusted=" + this.isRectAdjusted + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int flags) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.localPath);
        parcel.writeString(this.url);
        parcel.writeLong(this.size);
        parcel.writeInt(this.isRectAdjusted ? 1 : 0);
    }

    public PhotoPickerPhotoResult(java.lang.String str, java.lang.String str2, long j, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str2, com.up366.mobile.commonui.CommonWebViewActivity.URL);
        this.localPath = str;
        this.url = str2;
        this.size = j;
        this.isRectAdjusted = z;
    }

    public final java.lang.String getLocalPath() {
        return this.localPath;
    }

    public /* synthetic */ PhotoPickerPhotoResult(java.lang.String str, java.lang.String str2, long j, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? false : z);
    }

    public final java.lang.String getUrl() {
        return this.url;
    }

    public final long getSize() {
        return this.size;
    }

    public final boolean isRectAdjusted() {
        return this.isRectAdjusted;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> toWebPayload() {
        return kotlin.collections.MapsKt.mapOf(new kotlin.Pair[]{kotlin.TuplesKt.to("localPath", this.localPath), kotlin.TuplesKt.to(com.up366.mobile.commonui.CommonWebViewActivity.URL, this.url), kotlin.TuplesKt.to("size", java.lang.Long.valueOf(this.size)), kotlin.TuplesKt.to("isRectAdjusted", java.lang.Boolean.valueOf(this.isRectAdjusted))});
    }
}
