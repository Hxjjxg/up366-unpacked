package io.objectbox.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Model extends io.objectbox.flatbuffers.Table {
    public static void ValidateVersion() {
        io.objectbox.flatbuffers.Constants.FLATBUFFERS_23_5_26();
    }

    public static io.objectbox.model.Model getRootAsModel(java.nio.ByteBuffer byteBuffer) {
        return getRootAsModel(byteBuffer, new io.objectbox.model.Model());
    }

    public static io.objectbox.model.Model getRootAsModel(java.nio.ByteBuffer byteBuffer, io.objectbox.model.Model model) {
        byteBuffer.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        return model.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, java.nio.ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public io.objectbox.model.Model __assign(int i, java.nio.ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public long modelVersion() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return ((long) this.bb.getInt(i__offset + this.bb_pos)) & 4294967295L;
        }
        return 0L;
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

    public long version() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public io.objectbox.model.ModelEntity entities(int i) {
        return entities(new io.objectbox.model.ModelEntity(), i);
    }

    public io.objectbox.model.ModelEntity entities(io.objectbox.model.ModelEntity modelEntity, int i) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return modelEntity.__assign(__indirect(__vector(i__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int entitiesLength() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public io.objectbox.model.ModelEntity.Vector entitiesVector() {
        return entitiesVector(new io.objectbox.model.ModelEntity.Vector());
    }

    public io.objectbox.model.ModelEntity.Vector entitiesVector(io.objectbox.model.ModelEntity.Vector vector) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.bb);
        }
        return null;
    }

    public io.objectbox.model.IdUid lastEntityId() {
        return lastEntityId(new io.objectbox.model.IdUid());
    }

    public io.objectbox.model.IdUid lastEntityId(io.objectbox.model.IdUid idUid) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return idUid.__assign(i__offset + this.bb_pos, this.bb);
        }
        return null;
    }

    public io.objectbox.model.IdUid lastIndexId() {
        return lastIndexId(new io.objectbox.model.IdUid());
    }

    public io.objectbox.model.IdUid lastIndexId(io.objectbox.model.IdUid idUid) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return idUid.__assign(i__offset + this.bb_pos, this.bb);
        }
        return null;
    }

    public io.objectbox.model.IdUid lastSequenceId() {
        return lastSequenceId(new io.objectbox.model.IdUid());
    }

    public io.objectbox.model.IdUid lastSequenceId(io.objectbox.model.IdUid idUid) {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return idUid.__assign(i__offset + this.bb_pos, this.bb);
        }
        return null;
    }

    public io.objectbox.model.IdUid lastRelationId() {
        return lastRelationId(new io.objectbox.model.IdUid());
    }

    public io.objectbox.model.IdUid lastRelationId(io.objectbox.model.IdUid idUid) {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return idUid.__assign(i__offset + this.bb_pos, this.bb);
        }
        return null;
    }

    public int hash(int i) {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return this.bb.get(__vector(i__offset) + i) & 255;
        }
        return 0;
    }

    public int hashLength() {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public io.objectbox.flatbuffers.ByteVector hashVector() {
        return hashVector(new io.objectbox.flatbuffers.ByteVector());
    }

    public io.objectbox.flatbuffers.ByteVector hashVector(io.objectbox.flatbuffers.ByteVector byteVector) {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return byteVector.__assign(__vector(i__offset), this.bb);
        }
        return null;
    }

    public java.nio.ByteBuffer hashAsByteBuffer() {
        return __vector_as_bytebuffer(20, 1);
    }

    public java.nio.ByteBuffer hashInByteBuffer(java.nio.ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 20, 1);
    }

    public static void startModel(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(9);
    }

    public static void addModelVersion(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(0, (int) j, 0);
    }

    public static void addName(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addVersion(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(2, j, 0L);
    }

    public static void addEntities(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static int createEntitiesVector(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startEntitiesVector(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addLastEntityId(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(4, i, 0);
    }

    public static void addLastIndexId(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(5, i, 0);
    }

    public static void addLastSequenceId(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(6, i, 0);
    }

    public static void addLastRelationId(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addStruct(7, i, 0);
    }

    public static void addHash(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(8, i, 0);
    }

    public static int createHashVector(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, byte[] bArr) {
        return flatBufferBuilder.createByteVector(bArr);
    }

    public static int createHashVector(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, java.nio.ByteBuffer byteBuffer) {
        return flatBufferBuilder.createByteVector(byteBuffer);
    }

    public static void startHashVector(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(1, i, 1);
    }

    public static int endModel(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static void finishModelBuffer(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i);
    }

    public static void finishSizePrefixedModelBuffer(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i);
    }

    public static final class Vector extends io.objectbox.flatbuffers.BaseVector {
        public io.objectbox.model.Model.Vector __assign(int i, int i2, java.nio.ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public io.objectbox.model.Model get(int i) {
            return get(new io.objectbox.model.Model(), i);
        }

        public io.objectbox.model.Model get(io.objectbox.model.Model model, int i) {
            return model.__assign(io.objectbox.model.Model.__indirect(__element(i), this.bb), this.bb);
        }
    }
}
