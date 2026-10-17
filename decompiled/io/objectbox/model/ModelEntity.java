package io.objectbox.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ModelEntity extends io.objectbox.flatbuffers.Table {
    public static void ValidateVersion() {
        io.objectbox.flatbuffers.Constants.FLATBUFFERS_23_5_26();
    }

    public static io.objectbox.model.ModelEntity getRootAsModelEntity(java.nio.ByteBuffer byteBuffer) {
        return getRootAsModelEntity(byteBuffer, new io.objectbox.model.ModelEntity());
    }

    public static io.objectbox.model.ModelEntity getRootAsModelEntity(java.nio.ByteBuffer byteBuffer, io.objectbox.model.ModelEntity modelEntity) {
        byteBuffer.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        return modelEntity.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, java.nio.ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public io.objectbox.model.ModelEntity __assign(int i, java.nio.ByteBuffer byteBuffer) {
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

    public io.objectbox.model.ModelProperty properties(int i) {
        return properties(new io.objectbox.model.ModelProperty(), i);
    }

    public io.objectbox.model.ModelProperty properties(io.objectbox.model.ModelProperty modelProperty, int i) {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return modelProperty.__assign(__indirect(__vector(i__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int propertiesLength() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public io.objectbox.model.ModelProperty.Vector propertiesVector() {
        return propertiesVector(new io.objectbox.model.ModelProperty.Vector());
    }

    public io.objectbox.model.ModelProperty.Vector propertiesVector(io.objectbox.model.ModelProperty.Vector vector) {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.bb);
        }
        return null;
    }

    public io.objectbox.model.IdUid lastPropertyId() {
        return lastPropertyId(new io.objectbox.model.IdUid());
    }

    public io.objectbox.model.IdUid lastPropertyId(io.objectbox.model.IdUid idUid) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return idUid.__assign(i__offset + this.bb_pos, this.bb);
        }
        return null;
    }

    public io.objectbox.model.ModelRelation relations(int i) {
        return relations(new io.objectbox.model.ModelRelation(), i);
    }

    public io.objectbox.model.ModelRelation relations(io.objectbox.model.ModelRelation modelRelation, int i) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return modelRelation.__assign(__indirect(__vector(i__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int relationsLength() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public io.objectbox.model.ModelRelation.Vector relationsVector() {
        return relationsVector(new io.objectbox.model.ModelRelation.Vector());
    }

    public io.objectbox.model.ModelRelation.Vector relationsVector(io.objectbox.model.ModelRelation.Vector vector) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.bb);
        }
        return null;
    }

    public long flags() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return ((long) this.bb.getInt(i__offset + this.bb_pos)) & 4294967295L;
        }
        return 0L;
    }

    public java.lang.String nameSecondary() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public java.nio.ByteBuffer nameSecondaryAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public java.nio.ByteBuffer nameSecondaryInByteBuffer(java.nio.ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public static void startModelEntity(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(7);
    }

    public static void addId(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(0, i, 0);
    }

    public static void addName(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addProperties(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static int createPropertiesVector(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startPropertiesVector(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addLastPropertyId(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(3, i, 0);
    }

    public static void addRelations(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static int createRelationsVector(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startRelationsVector(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addFlags(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(5, (int) j, 0);
    }

    public static void addNameSecondary(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static int endModelEntity(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends io.objectbox.flatbuffers.BaseVector {
        public io.objectbox.model.ModelEntity.Vector __assign(int i, int i2, java.nio.ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public io.objectbox.model.ModelEntity get(int i) {
            return get(new io.objectbox.model.ModelEntity(), i);
        }

        public io.objectbox.model.ModelEntity get(io.objectbox.model.ModelEntity modelEntity, int i) {
            return modelEntity.__assign(io.objectbox.model.ModelEntity.__indirect(__element(i), this.bb), this.bb);
        }
    }
}
