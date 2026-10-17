package com.up366.medialibrary.common.io;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class ByteArrayAdapter implements com.up366.medialibrary.common.io.ArrayAdapterInterface<byte[]> {
    private static final java.lang.String TAG = "ByteArrayPool";

    @Override // com.up366.medialibrary.common.io.ArrayAdapterInterface
    public int getElementSizeInBytes() {
        return 1;
    }

    @Override // com.up366.medialibrary.common.io.ArrayAdapterInterface
    public java.lang.String getTag() {
        return TAG;
    }

    @Override // com.up366.medialibrary.common.io.ArrayAdapterInterface
    public int getArrayLength(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.up366.medialibrary.common.io.ArrayAdapterInterface
    public byte[] newArray(int i) {
        return new byte[i];
    }
}
