package io.objectbox.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ModelProperty extends io.objectbox.flatbuffers.Table {
    public static void ValidateVersion() {
        io.objectbox.flatbuffers.Constants.FLATBUFFERS_23_5_26();
    }

    public static io.objectbox.model.ModelProperty getRootAsModelProperty(java.nio.ByteBuffer byteBuffer) {
        return getRootAsModelProperty(byteBuffer, new io.objectbox.model.ModelProperty());
    }

    public static io.objectbox.model.ModelProperty getRootAsModelProperty(java.nio.ByteBuffer byteBuffer, io.objectbox.model.ModelProperty modelProperty) {
        byteBuffer.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        return modelProperty.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, java.nio.ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public io.objectbox.model.ModelProperty __assign(int i, java.nio.ByteBuffer byteBuffer) {
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

    public int type() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.bb.getShort(i__offset + this.bb_pos) & 65535;
        }
        return 0;
    }

    public long flags() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return ((long) this.bb.getInt(i__offset + this.bb_pos)) & 4294967295L;
        }
        return 0L;
    }

    public io.objectbox.model.IdUid indexId() {
        return indexId(new io.objectbox.model.IdUid());
    }

    public io.objectbox.model.IdUid indexId(io.objectbox.model.IdUid idUid) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return idUid.__assign(i__offset + this.bb_pos, this.bb);
        }
        return null;
    }

    public java.lang.String targetEntity() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public java.nio.ByteBuffer targetEntityAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public java.nio.ByteBuffer targetEntityInByteBuffer(java.nio.ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public java.lang.String virtualTarget() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public java.nio.ByteBuffer virtualTargetAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public java.nio.ByteBuffer virtualTargetInByteBuffer(java.nio.ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public java.lang.String nameSecondary() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public java.nio.ByteBuffer nameSecondaryAsByteBuffer() {
        return __vector_as_bytebuffer(18, 1);
    }

    public java.nio.ByteBuffer nameSecondaryInByteBuffer(java.nio.ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 18, 1);
    }

    public long maxIndexValueLength() {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return ((long) this.bb.getInt(i__offset + this.bb_pos)) & 4294967295L;
        }
        return 0L;
    }

    public static void startModelProperty(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(9);
    }

    public static void addId(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(0, i, 0);
    }

    public static void addName(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addType(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addShort(2, (short) i, 0);
    }

    public static void addFlags(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(3, (int) j, 0);
    }

    public static void addIndexId(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(4, i, 0);
    }

    public static void addTargetEntity(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static void addVirtualTarget(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static void addNameSecondary(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(7, i, 0);
    }

    public static void addMaxIndexValueLength(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(8, (int) j, 0);
    }

    public static int endModelProperty(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends io.objectbox.flatbuffers.BaseVector {
        public io.objectbox.model.ModelProperty.Vector __assign(int i, int i2, java.nio.ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public io.objectbox.model.ModelProperty get(int i) {
            return get(new io.objectbox.model.ModelProperty(), i);
        }

        public io.objectbox.model.ModelProperty get(io.objectbox.model.ModelProperty modelProperty, int i) {
            return modelProperty.__assign(io.objectbox.model.ModelProperty.__indirect(__element(i), this.bb), this.bb);
        }
    }
}
