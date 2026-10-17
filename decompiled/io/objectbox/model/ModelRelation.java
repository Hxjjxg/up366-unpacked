package io.objectbox.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ModelRelation extends io.objectbox.flatbuffers.Table {
    public static void ValidateVersion() {
        io.objectbox.flatbuffers.Constants.FLATBUFFERS_23_5_26();
    }

    public static io.objectbox.model.ModelRelation getRootAsModelRelation(java.nio.ByteBuffer byteBuffer) {
        return getRootAsModelRelation(byteBuffer, new io.objectbox.model.ModelRelation());
    }

    public static io.objectbox.model.ModelRelation getRootAsModelRelation(java.nio.ByteBuffer byteBuffer, io.objectbox.model.ModelRelation modelRelation) {
        byteBuffer.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        return modelRelation.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, java.nio.ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public io.objectbox.model.ModelRelation __assign(int i, java.nio.ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public io.objectbox.model.IdUid id() {
        return id(new io.objectbox.model.IdUid());
    }

    public io.objectbox.model.IdUid id(io.objectbox.model.IdUid idUid) {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return idUid.__assign(i__offset + this.bb_pos, this.bb);
        }
        return null;
    }

    public java.lang.String name() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public java.nio.ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public java.nio.ByteBuffer nameInByteBuffer(java.nio.ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public io.objectbox.model.IdUid targetEntityId() {
        return targetEntityId(new io.objectbox.model.IdUid());
    }

    public io.objectbox.model.IdUid targetEntityId(io.objectbox.model.IdUid idUid) {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return idUid.__assign(i__offset + this.bb_pos, this.bb);
        }
        return null;
    }

    public static void startModelRelation(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(3);
    }

    public static void addId(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(0, i, 0);
    }

    public static void addName(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addTargetEntityId(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(2, i, 0);
    }

    public static int endModelRelation(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends io.objectbox.flatbuffers.BaseVector {
        public io.objectbox.model.ModelRelation.Vector __assign(int i, int i2, java.nio.ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public io.objectbox.model.ModelRelation get(int i) {
            return get(new io.objectbox.model.ModelRelation(), i);
        }

        public io.objectbox.model.ModelRelation get(io.objectbox.model.ModelRelation modelRelation, int i) {
            return modelRelation.__assign(io.objectbox.model.ModelRelation.__indirect(__element(i), this.bb), this.bb);
        }
    }
}
