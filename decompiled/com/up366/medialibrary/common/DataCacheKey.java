package com.up366.medialibrary.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DataCacheKey implements com.bumptech.glide.load.Key {
    private final com.bumptech.glide.load.Key signature;
    private final com.bumptech.glide.load.Key sourceKey;

    public DataCacheKey(com.bumptech.glide.load.Key key, com.bumptech.glide.load.Key key2) {
        this.sourceKey = key;
        this.signature = key2;
    }

    public com.bumptech.glide.load.Key getSourceKey() {
        return this.sourceKey;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.up366.medialibrary.common.DataCacheKey)) {
            return false;
        }
        com.up366.medialibrary.common.DataCacheKey dataCacheKey = (com.up366.medialibrary.common.DataCacheKey) obj;
        return this.sourceKey.equals(dataCacheKey.sourceKey) && this.signature.equals(dataCacheKey.signature);
    }

    public int hashCode() {
        return (this.sourceKey.hashCode() * 31) + this.signature.hashCode();
    }

    public java.lang.String toString() {
        return "DataCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + '}';
    }

    public void updateDiskCacheKey(java.security.MessageDigest messageDigest) {
        this.sourceKey.updateDiskCacheKey(messageDigest);
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
