package io.objectbox.flatbuffers;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class UnionVector extends io.objectbox.flatbuffers.BaseVector {
    public io.objectbox.flatbuffers.UnionVector __assign(int i, int i2, java.nio.ByteBuffer byteBuffer) {
        __reset(i, i2, byteBuffer);
        return this;
    }

    public io.objectbox.flatbuffers.Table get(io.objectbox.flatbuffers.Table table, int i) {
        return io.objectbox.flatbuffers.Table.__union(table, __element(i), this.bb);
    }
}
