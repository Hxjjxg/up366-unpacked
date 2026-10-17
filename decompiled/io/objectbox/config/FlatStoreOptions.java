package io.objectbox.config;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class FlatStoreOptions extends io.objectbox.flatbuffers.Table {
    public static void ValidateVersion() {
        io.objectbox.flatbuffers.Constants.FLATBUFFERS_23_5_26();
    }

    public static io.objectbox.config.FlatStoreOptions getRootAsFlatStoreOptions(java.nio.ByteBuffer byteBuffer) {
        return getRootAsFlatStoreOptions(byteBuffer, new io.objectbox.config.FlatStoreOptions());
    }

    public static io.objectbox.config.FlatStoreOptions getRootAsFlatStoreOptions(java.nio.ByteBuffer byteBuffer, io.objectbox.config.FlatStoreOptions flatStoreOptions) {
        byteBuffer.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        return flatStoreOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, java.nio.ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public io.objectbox.config.FlatStoreOptions __assign(int i, java.nio.ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public java.lang.String directoryPath() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public java.nio.ByteBuffer directoryPathAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public java.nio.ByteBuffer directoryPathInByteBuffer(java.nio.ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public int modelBytes(int i) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.bb.get(__vector(i__offset) + i) & 255;
        }
        return 0;
    }

    public int modelBytesLength() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public io.objectbox.flatbuffers.ByteVector modelBytesVector() {
        return modelBytesVector(new io.objectbox.flatbuffers.ByteVector());
    }

    public io.objectbox.flatbuffers.ByteVector modelBytesVector(io.objectbox.flatbuffers.ByteVector byteVector) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return byteVector.__assign(__vector(i__offset), this.bb);
        }
        return null;
    }

    public java.nio.ByteBuffer modelBytesAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public java.nio.ByteBuffer modelBytesInByteBuffer(java.nio.ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public long maxDbSizeInKbyte() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public long fileMode() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return ((long) this.bb.getInt(i__offset + this.bb_pos)) & 4294967295L;
        }
        return 0L;
    }

    public long maxReaders() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return ((long) this.bb.getInt(i__offset + this.bb_pos)) & 4294967295L;
        }
        return 0L;
    }

    public int validateOnOpenPages() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return this.bb.getShort(i__offset + this.bb_pos) & 65535;
        }
        return 0;
    }

    public long validateOnOpenPageLimit() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return this.bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public int putPaddingMode() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return this.bb.getShort(i__offset + this.bb_pos) & 65535;
        }
        return 0;
    }

    public boolean skipReadSchema() {
        int i__offset = __offset(20);
        return (i__offset == 0 || this.bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean usePreviousCommit() {
        int i__offset = __offset(22);
        return (i__offset == 0 || this.bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean usePreviousCommitOnValidationFailure() {
        int i__offset = __offset(24);
        return (i__offset == 0 || this.bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean readOnly() {
        int i__offset = __offset(26);
        return (i__offset == 0 || this.bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public long debugFlags() {
        int i__offset = __offset(28);
        if (i__offset != 0) {
            return ((long) this.bb.getInt(i__offset + this.bb_pos)) & 4294967295L;
        }
        return 0L;
    }

    public boolean noReaderThreadLocals() {
        int i__offset = __offset(30);
        return (i__offset == 0 || this.bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public long maxDataSizeInKbyte() {
        int i__offset = __offset(32);
        if (i__offset != 0) {
            return this.bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    public int validateOnOpenKv() {
        int i__offset = __offset(34);
        if (i__offset != 0) {
            return this.bb.getShort(i__offset + this.bb_pos) & 65535;
        }
        return 0;
    }

    public static int createFlatStoreOptions(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i, int i2, long j, long j2, long j3, int i3, long j4, int i4, boolean z, boolean z2, boolean z3, boolean z4, long j5, boolean z5, long j6, int i5) {
        flatBufferBuilder.startTable(16);
        addMaxDataSizeInKbyte(flatBufferBuilder, j6);
        addValidateOnOpenPageLimit(flatBufferBuilder, j4);
        addMaxDbSizeInKbyte(flatBufferBuilder, j);
        addDebugFlags(flatBufferBuilder, j5);
        addMaxReaders(flatBufferBuilder, j3);
        addFileMode(flatBufferBuilder, j2);
        addModelBytes(flatBufferBuilder, i2);
        addDirectoryPath(flatBufferBuilder, i);
        addValidateOnOpenKv(flatBufferBuilder, i5);
        addPutPaddingMode(flatBufferBuilder, i4);
        addValidateOnOpenPages(flatBufferBuilder, i3);
        addNoReaderThreadLocals(flatBufferBuilder, z5);
        addReadOnly(flatBufferBuilder, z4);
        addUsePreviousCommitOnValidationFailure(flatBufferBuilder, z3);
        addUsePreviousCommit(flatBufferBuilder, z2);
        addSkipReadSchema(flatBufferBuilder, z);
        return endFlatStoreOptions(flatBufferBuilder);
    }

    public static void startFlatStoreOptions(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(16);
    }

    public static void addDirectoryPath(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addModelBytes(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static int createModelBytesVector(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, byte[] bArr) {
        return flatBufferBuilder.createByteVector(bArr);
    }

    public static int createModelBytesVector(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, java.nio.ByteBuffer byteBuffer) {
        return flatBufferBuilder.createByteVector(byteBuffer);
    }

    public static void startModelBytesVector(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(1, i, 1);
    }

    public static void addMaxDbSizeInKbyte(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(2, j, 0L);
    }

    public static void addFileMode(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(3, (int) j, 0);
    }

    public static void addMaxReaders(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(4, (int) j, 0);
    }

    public static void addValidateOnOpenPages(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addShort(5, (short) i, 0);
    }

    public static void addValidateOnOpenPageLimit(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(6, j, 0L);
    }

    public static void addPutPaddingMode(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addShort(7, (short) i, 0);
    }

    public static void addSkipReadSchema(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(8, z, false);
    }

    public static void addUsePreviousCommit(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(9, z, false);
    }

    public static void addUsePreviousCommitOnValidationFailure(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(10, z, false);
    }

    public static void addReadOnly(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(11, z, false);
    }

    public static void addDebugFlags(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(12, (int) j, 0);
    }

    public static void addNoReaderThreadLocals(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(13, z, false);
    }

    public static void addMaxDataSizeInKbyte(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(14, j, 0L);
    }

    public static void addValidateOnOpenKv(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addShort(15, (short) i, 0);
    }

    public static int endFlatStoreOptions(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static void finishFlatStoreOptionsBuffer(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i);
    }

    public static void finishSizePrefixedFlatStoreOptionsBuffer(io.objectbox.flatbuffers.FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i);
    }

    public static final class Vector extends io.objectbox.flatbuffers.BaseVector {
        public io.objectbox.config.FlatStoreOptions.Vector __assign(int i, int i2, java.nio.ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public io.objectbox.config.FlatStoreOptions get(int i) {
            return get(new io.objectbox.config.FlatStoreOptions(), i);
        }

        public io.objectbox.config.FlatStoreOptions get(io.objectbox.config.FlatStoreOptions flatStoreOptions, int i) {
            return flatStoreOptions.__assign(io.objectbox.config.FlatStoreOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }
}
