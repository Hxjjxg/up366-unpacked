package io.objectbox.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class IdUid extends io.objectbox.flatbuffers.Struct {
    public void __init(int i, java.nio.ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public io.objectbox.model.IdUid __assign(int i, java.nio.ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public long id() {
        return ((long) this.bb.getInt(this.bb_pos)) & 4294967295L;
    }

    public long uid() {
        return this.bb.getLong(this.bb_pos + 8);
    }

    public static int createIdUid(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, long j, long j2) {
        flatBufferBuilder.prep(8, 16);
        flatBufferBuilder.putLong(j2);
        flatBufferBuilder.pad(4);
        flatBufferBuilder.putInt((int) j);
        return flatBufferBuilder.offset();
    }

    public static final class Vector extends io.objectbox.flatbuffers.BaseVector {
        public io.objectbox.model.IdUid.Vector __assign(int i, int i2, java.nio.ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public io.objectbox.model.IdUid get(int i) {
            return get(new io.objectbox.model.IdUid(), i);
        }

        public io.objectbox.model.IdUid get(io.objectbox.model.IdUid idUid, int i) {
            return idUid.__assign(__element(i), this.bb);
        }
    }
}
