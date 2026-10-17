package io.objectbox.flatbuffers;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class StringVector extends io.objectbox.flatbuffers.BaseVector {
    private io.objectbox.flatbuffers.Utf8 utf8 = io.objectbox.flatbuffers.Utf8.getDefault();

    public io.objectbox.flatbuffers.StringVector __assign(int i, int i2, java.nio.ByteBuffer byteBuffer) {
        __reset(i, i2, byteBuffer);
        return this;
    }

    public java.lang.String get(int i) {
        return io.objectbox.flatbuffers.Table.__string(__element(i), this.bb, this.utf8);
    }
}
