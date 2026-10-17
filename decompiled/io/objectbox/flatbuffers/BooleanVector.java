package io.objectbox.flatbuffers;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class BooleanVector extends io.objectbox.flatbuffers.BaseVector {
    public io.objectbox.flatbuffers.BooleanVector __assign(int i, java.nio.ByteBuffer byteBuffer) {
        __reset(i, 1, byteBuffer);
        return this;
    }

    public boolean get(int i) {
        return this.bb.get(__element(i)) != 0;
    }
}
