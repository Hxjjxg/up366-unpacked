package io.objectbox.flatbuffers;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DoubleVector extends io.objectbox.flatbuffers.BaseVector {
    public io.objectbox.flatbuffers.DoubleVector __assign(int i, java.nio.ByteBuffer byteBuffer) {
        __reset(i, 8, byteBuffer);
        return this;
    }

    public double get(int i) {
        return this.bb.getDouble(__element(i));
    }
}
