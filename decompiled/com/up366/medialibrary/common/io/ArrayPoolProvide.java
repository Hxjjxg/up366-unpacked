package com.up366.medialibrary.common.io;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ArrayPoolProvide {
    private static final com.up366.medialibrary.common.io.ArrayPoolProvide mInstance = new com.up366.medialibrary.common.io.ArrayPoolProvide();
    private final java.util.HashSet<java.lang.String> keyCache = new java.util.HashSet<>();
    private final android.util.LruCache<java.lang.String, com.up366.medialibrary.common.io.BufferedInputStreamWrap> bufferedLruCache = new android.util.LruCache<>(20);
    private final com.up366.medialibrary.common.io.LruArrayPool arrayPool = new com.up366.medialibrary.common.io.LruArrayPool(com.up366.medialibrary.common.io.LruArrayPool.DEFAULT_SIZE);

    public byte[] get(int i) {
        return (byte[]) this.arrayPool.get(i, byte[].class);
    }

    public void put(byte[] bArr) {
        this.arrayPool.put(bArr);
    }

    public java.io.InputStream openInputStream(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        try {
            com.up366.medialibrary.common.io.BufferedInputStreamWrap bufferedInputStreamWrapWrapInputStream = this.bufferedLruCache.get(uri.toString());
            if (bufferedInputStreamWrapWrapInputStream != null) {
                bufferedInputStreamWrapWrapInputStream.reset();
            } else {
                bufferedInputStreamWrapWrapInputStream = wrapInputStream(contentResolver, uri);
            }
            return bufferedInputStreamWrapWrapInputStream;
        } catch (java.lang.Exception unused) {
            return wrapInputStream(contentResolver, uri);
        }
    }

    private com.up366.medialibrary.common.io.BufferedInputStreamWrap wrapInputStream(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        com.up366.medialibrary.common.io.BufferedInputStreamWrap bufferedInputStreamWrap;
        com.up366.medialibrary.common.io.BufferedInputStreamWrap bufferedInputStreamWrap2 = null;
        try {
            bufferedInputStreamWrap = new com.up366.medialibrary.common.io.BufferedInputStreamWrap(contentResolver.openInputStream(uri));
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            int iAvailable = bufferedInputStreamWrap.available();
            if (iAvailable <= 0) {
                iAvailable = com.up366.medialibrary.common.io.BufferedInputStreamWrap.DEFAULT_MARK_READ_LIMIT;
            }
            bufferedInputStreamWrap.mark(iAvailable);
            this.bufferedLruCache.put(uri.toString(), bufferedInputStreamWrap);
            this.keyCache.add(uri.toString());
            return bufferedInputStreamWrap;
        } catch (java.lang.Exception e2) {
            e = e2;
            bufferedInputStreamWrap2 = bufferedInputStreamWrap;
            e.printStackTrace();
            return bufferedInputStreamWrap2;
        }
    }

    public void clearMemory() {
        for (java.lang.String str : this.keyCache) {
            com.up366.medialibrary.common.utils.PictureFileUtils.close(this.bufferedLruCache.get(str));
            this.bufferedLruCache.remove(str);
        }
        this.keyCache.clear();
        this.arrayPool.clearMemory();
    }

    public static com.up366.medialibrary.common.io.ArrayPoolProvide getInstance() {
        return mInstance;
    }
}
