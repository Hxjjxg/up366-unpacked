package io.objectbox.flatbuffers;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class FloatVector extends io.objectbox.flatbuffers.BaseVector {
    public io.objectbox.flatbuffers.FloatVector __assign(int i, java.nio.ByteBuffer byteBuffer) {
        __reset(i, 4, byteBuffer);
        return this;
    }

    public float get(int i) {
        return this.bb.getFloat(__element(i));
    }
}
