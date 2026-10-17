package com.up366.photopicker.ui.gallery;

/* JADX INFO: compiled from: GalleryActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/up366/photopicker/ui/gallery/PhotoItem;", "", com.igexin.push.core.b.C, "", "name", "", "data", "uri", "Landroid/net/Uri;", "(JLjava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "getData", "()Ljava/lang/String;", "getId", "()J", "getName", "getUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PhotoItem {
    private final java.lang.String data;
    private final long id;
    private final java.lang.String name;
    private final android.net.Uri uri;

    public static /* synthetic */ com.up366.photopicker.ui.gallery.PhotoItem copy$default(com.up366.photopicker.ui.gallery.PhotoItem photoItem, long j, java.lang.String str, java.lang.String str2, android.net.Uri uri, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            j = photoItem.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = photoItem.name;
        }
        java.lang.String str3 = str;
        if ((i & 4) != 0) {
            str2 = photoItem.data;
        }
        java.lang.String str4 = str2;
        if ((i & 8) != 0) {
            uri = photoItem.uri;
        }
        return photoItem.copy(j2, str3, str4, uri);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final java.lang.String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final java.lang.String getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final android.net.Uri getUri() {
        return this.uri;
    }

    public final com.up366.photopicker.ui.gallery.PhotoItem copy(long id, java.lang.String name, java.lang.String data, android.net.Uri uri) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        return new com.up366.photopicker.ui.gallery.PhotoItem(id, name, data, uri);
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof com.up366.photopicker.ui.gallery.PhotoItem)) {
            return false;
        }
        com.up366.photopicker.ui.gallery.PhotoItem photoItem = (com.up366.photopicker.ui.gallery.PhotoItem) other;
        return this.id == photoItem.id && kotlin.jvm.internal.Intrinsics.areEqual(this.name, photoItem.name) && kotlin.jvm.internal.Intrinsics.areEqual(this.data, photoItem.data) && kotlin.jvm.internal.Intrinsics.areEqual(this.uri, photoItem.uri);
    }

    public int hashCode() {
        return (((((kotlin.UByte$.ExternalSyntheticBackport0.m(this.id) * 31) + this.name.hashCode()) * 31) + this.data.hashCode()) * 31) + this.uri.hashCode();
    }

    public java.lang.String toString() {
        return "PhotoItem(id=" + this.id + ", name=" + this.name + ", data=" + this.data + ", uri=" + this.uri + ')';
    }

    public PhotoItem(long j, java.lang.String str, java.lang.String str2, android.net.Uri uri) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str2, "data");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        this.id = j;
        this.name = str;
        this.data = str2;
        this.uri = uri;
    }

    public final java.lang.String getData() {
        return this.data;
    }

    public final long getId() {
        return this.id;
    }

    public final java.lang.String getName() {
        return this.name;
    }

    public final android.net.Uri getUri() {
        return this.uri;
    }
}
