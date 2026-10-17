package com.up366.medialibrary.common.io;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class IntegerArrayAdapter implements com.up366.medialibrary.common.io.ArrayAdapterInterface<int[]> {
    private static final java.lang.String TAG = "IntegerArrayPool";

    @Override // com.up366.medialibrary.common.io.ArrayAdapterInterface
    public int getElementSizeInBytes() {
        return 4;
    }

    @Override // com.up366.medialibrary.common.io.ArrayAdapterInterface
    public java.lang.String getTag() {
        return TAG;
    }

    @Override // com.up366.medialibrary.common.io.ArrayAdapterInterface
    public int getArrayLength(int[] iArr) {
        return iArr.length;
    }

    @Override // com.up366.medialibrary.common.io.ArrayAdapterInterface
    public int[] newArray(int i) {
        return new int[i];
    }
}
