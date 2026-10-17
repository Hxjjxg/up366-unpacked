package io.objectbox.flatbuffers;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ShortVector extends io.objectbox.flatbuffers.BaseVector {
    public io.objectbox.flatbuffers.ShortVector __assign(int i, java.nio.ByteBuffer byteBuffer) {
        __reset(i, 2, byteBuffer);
        return this;
    }

    public short get(int i) {
        return this.bb.getShort(__element(i));
    }

    public int getAsUnsigned(int i) {
        return get(i) & 65535;
    }
}
