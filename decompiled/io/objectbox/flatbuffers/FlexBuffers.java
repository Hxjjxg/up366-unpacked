package io.objectbox.flatbuffers;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class FlexBuffers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final io.objectbox.flatbuffers.ReadBuf EMPTY_BB = new io.objectbox.flatbuffers.ArrayReadWriteBuf(new byte[]{0}, 1);
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    static boolean isTypeInline(int i) {
        return i <= 3 || i == 26;
    }

    static boolean isTypedVector(int i) {
        return (i >= 11 && i <= 15) || i == 36;
    }

    static boolean isTypedVectorElementType(int i) {
        return (i >= 1 && i <= 4) || i == 26;
    }

    static int toTypedVector(int i, int i2) {
        if (i2 == 0) {
            return i + 10;
        }
        if (i2 == 2) {
            return i + 15;
        }
        if (i2 == 3) {
            return i + 18;
        }
        if (i2 != 4) {
            return 0;
        }
        return i + 21;
    }

    static int toTypedVectorElementType(int i) {
        return i - 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indirect(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2) {
        return (int) (((long) i) - readUInt(readBuf, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long readUInt(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2) {
        if (i2 == 1) {
            return io.objectbox.flatbuffers.FlexBuffers.Unsigned.byteToUnsignedInt(readBuf.get(i));
        }
        if (i2 == 2) {
            return io.objectbox.flatbuffers.FlexBuffers.Unsigned.shortToUnsignedInt(readBuf.getShort(i));
        }
        if (i2 == 4) {
            return io.objectbox.flatbuffers.FlexBuffers.Unsigned.intToUnsignedLong(readBuf.getInt(i));
        }
        if (i2 != 8) {
            return -1L;
        }
        return readBuf.getLong(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int readInt(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2) {
        return (int) readLong(readBuf, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long readLong(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2) {
        int i3;
        if (i2 == 1) {
            i3 = readBuf.get(i);
        } else if (i2 == 2) {
            i3 = readBuf.getShort(i);
        } else {
            if (i2 != 4) {
                if (i2 != 8) {
                    return -1L;
                }
                return readBuf.getLong(i);
            }
            i3 = readBuf.getInt(i);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double readDouble(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2) {
        if (i2 == 4) {
            return readBuf.getFloat(i);
        }
        if (i2 != 8) {
            return -1.0d;
        }
        return readBuf.getDouble(i);
    }

    @java.lang.Deprecated
    public static io.objectbox.flatbuffers.FlexBuffers.Reference getRoot(java.nio.ByteBuffer byteBuffer) {
        return getRoot(byteBuffer.hasArray() ? new io.objectbox.flatbuffers.ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new io.objectbox.flatbuffers.ByteBufferReadWriteBuf(byteBuffer));
    }

    public static io.objectbox.flatbuffers.FlexBuffers.Reference getRoot(io.objectbox.flatbuffers.ReadBuf readBuf) {
        int iLimit = readBuf.limit();
        byte b = readBuf.get(iLimit - 1);
        int i = iLimit - 2;
        return new io.objectbox.flatbuffers.FlexBuffers.Reference(readBuf, i - b, b, io.objectbox.flatbuffers.FlexBuffers.Unsigned.byteToUnsignedInt(readBuf.get(i)));
    }

    public static class Reference {
        private static final io.objectbox.flatbuffers.FlexBuffers.Reference NULL_REFERENCE = new io.objectbox.flatbuffers.FlexBuffers.Reference(io.objectbox.flatbuffers.FlexBuffers.EMPTY_BB, 0, 1, 0);
        private io.objectbox.flatbuffers.ReadBuf bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        Reference(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2, int i3) {
            this(readBuf, i, i2, 1 << (i3 & 3), i3 >> 2);
        }

        Reference(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2, int i3, int i4) {
            this.bb = readBuf;
            this.end = i;
            this.parentWidth = i2;
            this.byteWidth = i3;
            this.type = i4;
        }

        public int getType() {
            return this.type;
        }

        public boolean isNull() {
            return this.type == 0;
        }

        public boolean isBoolean() {
            return this.type == 26;
        }

        public boolean isNumeric() {
            return isIntOrUInt() || isFloat();
        }

        public boolean isIntOrUInt() {
            return isInt() || isUInt();
        }

        public boolean isFloat() {
            int i = this.type;
            return i == 3 || i == 8;
        }

        public boolean isInt() {
            int i = this.type;
            return i == 1 || i == 6;
        }

        public boolean isUInt() {
            int i = this.type;
            return i == 2 || i == 7;
        }

        public boolean isString() {
            return this.type == 5;
        }

        public boolean isKey() {
            return this.type == 4;
        }

        public boolean isVector() {
            int i = this.type;
            return i == 10 || i == 9;
        }

        public boolean isTypedVector() {
            return io.objectbox.flatbuffers.FlexBuffers.isTypedVector(this.type);
        }

        public boolean isMap() {
            return this.type == 9;
        }

        public boolean isBlob() {
            return this.type == 25;
        }

        public int asInt() {
            int i = this.type;
            if (i == 1) {
                return io.objectbox.flatbuffers.FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
            if (i == 2) {
                return (int) io.objectbox.flatbuffers.FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            if (i == 3) {
                return (int) io.objectbox.flatbuffers.FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i == 5) {
                return java.lang.Integer.parseInt(asString());
            }
            if (i == 6) {
                io.objectbox.flatbuffers.ReadBuf readBuf = this.bb;
                return io.objectbox.flatbuffers.FlexBuffers.readInt(readBuf, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i == 7) {
                io.objectbox.flatbuffers.ReadBuf readBuf2 = this.bb;
                return (int) io.objectbox.flatbuffers.FlexBuffers.readUInt(readBuf2, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            }
            if (i == 8) {
                io.objectbox.flatbuffers.ReadBuf readBuf3 = this.bb;
                return (int) io.objectbox.flatbuffers.FlexBuffers.readDouble(readBuf3, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            }
            if (i == 10) {
                return asVector().size();
            }
            if (i != 26) {
                return 0;
            }
            return io.objectbox.flatbuffers.FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
        }

        public long asUInt() {
            int i = this.type;
            if (i == 2) {
                return io.objectbox.flatbuffers.FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            if (i == 1) {
                return io.objectbox.flatbuffers.FlexBuffers.readLong(this.bb, this.end, this.parentWidth);
            }
            if (i == 3) {
                return (long) io.objectbox.flatbuffers.FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i == 10) {
                return asVector().size();
            }
            if (i == 26) {
                return io.objectbox.flatbuffers.FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
            if (i == 5) {
                return java.lang.Long.parseLong(asString());
            }
            if (i == 6) {
                io.objectbox.flatbuffers.ReadBuf readBuf = this.bb;
                return io.objectbox.flatbuffers.FlexBuffers.readLong(readBuf, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i == 7) {
                io.objectbox.flatbuffers.ReadBuf readBuf2 = this.bb;
                return io.objectbox.flatbuffers.FlexBuffers.readUInt(readBuf2, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
            }
            if (i != 8) {
                return 0L;
            }
            io.objectbox.flatbuffers.ReadBuf readBuf3 = this.bb;
            return (long) io.objectbox.flatbuffers.FlexBuffers.readDouble(readBuf3, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.parentWidth);
        }

        public long asLong() {
            int i = this.type;
            if (i == 1) {
                return io.objectbox.flatbuffers.FlexBuffers.readLong(this.bb, this.end, this.parentWidth);
            }
            if (i == 2) {
                return io.objectbox.flatbuffers.FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            if (i == 3) {
                return (long) io.objectbox.flatbuffers.FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i == 5) {
                try {
                    return java.lang.Long.parseLong(asString());
                } catch (java.lang.NumberFormatException unused) {
                    return 0L;
                }
            }
            if (i == 6) {
                io.objectbox.flatbuffers.ReadBuf readBuf = this.bb;
                return io.objectbox.flatbuffers.FlexBuffers.readLong(readBuf, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i == 7) {
                io.objectbox.flatbuffers.ReadBuf readBuf2 = this.bb;
                return io.objectbox.flatbuffers.FlexBuffers.readUInt(readBuf2, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            }
            if (i == 8) {
                io.objectbox.flatbuffers.ReadBuf readBuf3 = this.bb;
                return (long) io.objectbox.flatbuffers.FlexBuffers.readDouble(readBuf3, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            }
            if (i == 10) {
                return asVector().size();
            }
            if (i != 26) {
                return 0L;
            }
            return io.objectbox.flatbuffers.FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
        }

        public double asFloat() {
            int i = this.type;
            if (i == 3) {
                return io.objectbox.flatbuffers.FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i != 1) {
                if (i != 2) {
                    if (i == 5) {
                        return java.lang.Double.parseDouble(asString());
                    }
                    if (i == 6) {
                        io.objectbox.flatbuffers.ReadBuf readBuf = this.bb;
                        return io.objectbox.flatbuffers.FlexBuffers.readInt(readBuf, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
                    }
                    if (i == 7) {
                        io.objectbox.flatbuffers.ReadBuf readBuf2 = this.bb;
                        return io.objectbox.flatbuffers.FlexBuffers.readUInt(readBuf2, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
                    }
                    if (i == 8) {
                        io.objectbox.flatbuffers.ReadBuf readBuf3 = this.bb;
                        return io.objectbox.flatbuffers.FlexBuffers.readDouble(readBuf3, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
                    }
                    if (i == 10) {
                        return asVector().size();
                    }
                    if (i != 26) {
                        return 0.0d;
                    }
                }
                return io.objectbox.flatbuffers.FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            return io.objectbox.flatbuffers.FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
        }

        public io.objectbox.flatbuffers.FlexBuffers.Key asKey() {
            if (isKey()) {
                io.objectbox.flatbuffers.ReadBuf readBuf = this.bb;
                return new io.objectbox.flatbuffers.FlexBuffers.Key(readBuf, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            return io.objectbox.flatbuffers.FlexBuffers.Key.empty();
        }

        public java.lang.String asString() {
            if (isString()) {
                int iIndirect = io.objectbox.flatbuffers.FlexBuffers.indirect(this.bb, this.end, this.parentWidth);
                io.objectbox.flatbuffers.ReadBuf readBuf = this.bb;
                int i = this.byteWidth;
                return this.bb.getString(iIndirect, (int) io.objectbox.flatbuffers.FlexBuffers.readUInt(readBuf, iIndirect - i, i));
            }
            if (isKey()) {
                int iIndirect2 = io.objectbox.flatbuffers.FlexBuffers.indirect(this.bb, this.end, this.byteWidth);
                int i2 = iIndirect2;
                while (this.bb.get(i2) != 0) {
                    i2++;
                }
                return this.bb.getString(iIndirect2, i2 - iIndirect2);
            }
            return "";
        }

        public io.objectbox.flatbuffers.FlexBuffers.Map asMap() {
            if (isMap()) {
                io.objectbox.flatbuffers.ReadBuf readBuf = this.bb;
                return new io.objectbox.flatbuffers.FlexBuffers.Map(readBuf, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            return io.objectbox.flatbuffers.FlexBuffers.Map.empty();
        }

        public io.objectbox.flatbuffers.FlexBuffers.Vector asVector() {
            if (isVector()) {
                io.objectbox.flatbuffers.ReadBuf readBuf = this.bb;
                return new io.objectbox.flatbuffers.FlexBuffers.Vector(readBuf, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            int i = this.type;
            if (i == 15) {
                io.objectbox.flatbuffers.ReadBuf readBuf2 = this.bb;
                return new io.objectbox.flatbuffers.FlexBuffers.TypedVector(readBuf2, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth, 4);
            }
            if (io.objectbox.flatbuffers.FlexBuffers.isTypedVector(i)) {
                io.objectbox.flatbuffers.ReadBuf readBuf3 = this.bb;
                return new io.objectbox.flatbuffers.FlexBuffers.TypedVector(readBuf3, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth, io.objectbox.flatbuffers.FlexBuffers.toTypedVectorElementType(this.type));
            }
            return io.objectbox.flatbuffers.FlexBuffers.Vector.empty();
        }

        public io.objectbox.flatbuffers.FlexBuffers.Blob asBlob() {
            if (isBlob() || isString()) {
                io.objectbox.flatbuffers.ReadBuf readBuf = this.bb;
                return new io.objectbox.flatbuffers.FlexBuffers.Blob(readBuf, io.objectbox.flatbuffers.FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            return io.objectbox.flatbuffers.FlexBuffers.Blob.empty();
        }

        public boolean asBoolean() {
            return isBoolean() ? this.bb.get(this.end) != 0 : asUInt() != 0;
        }

        public java.lang.String toString() {
            return toString(new java.lang.StringBuilder(128)).toString();
        }

        java.lang.StringBuilder toString(java.lang.StringBuilder sb) {
            int i = this.type;
            if (i != 36) {
                switch (i) {
                    case 0:
                        sb.append(com.igexin.push.core.b.m);
                        return sb;
                    case 1:
                    case 6:
                        sb.append(asLong());
                        return sb;
                    case 2:
                    case 7:
                        sb.append(asUInt());
                        return sb;
                    case 3:
                    case 8:
                        sb.append(asFloat());
                        return sb;
                    case 4:
                        io.objectbox.flatbuffers.FlexBuffers.Key keyAsKey = asKey();
                        sb.append('\"');
                        java.lang.StringBuilder string = keyAsKey.toString(sb);
                        string.append('\"');
                        return string;
                    case 5:
                        sb.append('\"');
                        sb.append(asString());
                        sb.append('\"');
                        return sb;
                    case 9:
                        return asMap().toString(sb);
                    case 10:
                        return asVector().toString(sb);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new io.objectbox.flatbuffers.FlexBuffers.FlexBufferException("not_implemented:" + this.type);
                    case 25:
                        return asBlob().toString(sb);
                    case 26:
                        sb.append(asBoolean());
                        return sb;
                    default:
                        return sb;
                }
            }
            sb.append(asVector());
            return sb;
        }
    }

    private static abstract class Object {
        io.objectbox.flatbuffers.ReadBuf bb;
        int byteWidth;
        int end;

        public abstract java.lang.StringBuilder toString(java.lang.StringBuilder sb);

        Object(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2) {
            this.bb = readBuf;
            this.end = i;
            this.byteWidth = i2;
        }

        public java.lang.String toString() {
            return toString(new java.lang.StringBuilder(128)).toString();
        }
    }

    private static abstract class Sized extends io.objectbox.flatbuffers.FlexBuffers.Object {
        protected final int size;

        Sized(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
            this.size = (int) io.objectbox.flatbuffers.FlexBuffers.readUInt(this.bb, i - i2, i2);
        }

        public int size() {
            return this.size;
        }
    }

    public static class Blob extends io.objectbox.flatbuffers.FlexBuffers.Sized {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final io.objectbox.flatbuffers.FlexBuffers.Blob EMPTY = new io.objectbox.flatbuffers.FlexBuffers.Blob(io.objectbox.flatbuffers.FlexBuffers.EMPTY_BB, 1, 1);

        @Override // io.objectbox.flatbuffers.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        Blob(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static io.objectbox.flatbuffers.FlexBuffers.Blob empty() {
            return EMPTY;
        }

        public java.nio.ByteBuffer data() {
            java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(this.bb.data());
            byteBufferWrap.position(this.end);
            byteBufferWrap.limit(this.end + size());
            return byteBufferWrap.asReadOnlyBuffer().slice();
        }

        public byte[] getBytes() {
            int size = size();
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = this.bb.get(this.end + i);
            }
            return bArr;
        }

        public byte get(int i) {
            return this.bb.get(this.end + i);
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.Object
        public java.lang.String toString() {
            return this.bb.getString(this.end, size());
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.Object
        public java.lang.StringBuilder toString(java.lang.StringBuilder sb) {
            sb.append('\"');
            sb.append(this.bb.getString(this.end, size()));
            sb.append('\"');
            return sb;
        }
    }

    public static class Key extends io.objectbox.flatbuffers.FlexBuffers.Object {
        private static final io.objectbox.flatbuffers.FlexBuffers.Key EMPTY = new io.objectbox.flatbuffers.FlexBuffers.Key(io.objectbox.flatbuffers.FlexBuffers.EMPTY_BB, 0, 0);

        Key(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static io.objectbox.flatbuffers.FlexBuffers.Key empty() {
            return EMPTY;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.Object
        public java.lang.StringBuilder toString(java.lang.StringBuilder sb) {
            sb.append(toString());
            return sb;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.Object
        public java.lang.String toString() {
            int i = this.end;
            while (this.bb.get(i) != 0) {
                i++;
            }
            return this.bb.getString(this.end, i - this.end);
        }

        int compareTo(byte[] bArr) {
            byte b;
            byte b2;
            int i = this.end;
            int i2 = 0;
            do {
                b = this.bb.get(i);
                b2 = bArr[i2];
                if (b == 0) {
                    return b - b2;
                }
                i++;
                i2++;
                if (i2 == bArr.length) {
                    int i3 = b - b2;
                    if (i3 != 0 || this.bb.get(i) == 0) {
                        return i3;
                    }
                    return 1;
                }
            } while (b == b2);
            return b - b2;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof io.objectbox.flatbuffers.FlexBuffers.Key)) {
                return false;
            }
            io.objectbox.flatbuffers.FlexBuffers.Key key = (io.objectbox.flatbuffers.FlexBuffers.Key) obj;
            return key.end == this.end && key.byteWidth == this.byteWidth;
        }

        public int hashCode() {
            return this.end ^ this.byteWidth;
        }
    }

    public static class Map extends io.objectbox.flatbuffers.FlexBuffers.Vector {
        private static final io.objectbox.flatbuffers.FlexBuffers.Map EMPTY_MAP = new io.objectbox.flatbuffers.FlexBuffers.Map(io.objectbox.flatbuffers.FlexBuffers.EMPTY_BB, 1, 1);
        private final byte[] comparisonBuffer;

        Map(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
            this.comparisonBuffer = new byte[4];
        }

        public static io.objectbox.flatbuffers.FlexBuffers.Map empty() {
            return EMPTY_MAP;
        }

        public io.objectbox.flatbuffers.FlexBuffers.Reference get(java.lang.String str) {
            int iBinarySearch = binarySearch(str);
            if (iBinarySearch < 0 || iBinarySearch >= this.size) {
                return io.objectbox.flatbuffers.FlexBuffers.Reference.NULL_REFERENCE;
            }
            return get(iBinarySearch);
        }

        public io.objectbox.flatbuffers.FlexBuffers.Reference get(byte[] bArr) {
            int iBinarySearch = binarySearch(bArr);
            if (iBinarySearch < 0 || iBinarySearch >= this.size) {
                return io.objectbox.flatbuffers.FlexBuffers.Reference.NULL_REFERENCE;
            }
            return get(iBinarySearch);
        }

        public io.objectbox.flatbuffers.FlexBuffers.KeyVector keys() {
            int i = this.end - (this.byteWidth * 3);
            return new io.objectbox.flatbuffers.FlexBuffers.KeyVector(new io.objectbox.flatbuffers.FlexBuffers.TypedVector(this.bb, io.objectbox.flatbuffers.FlexBuffers.indirect(this.bb, i, this.byteWidth), io.objectbox.flatbuffers.FlexBuffers.readInt(this.bb, i + this.byteWidth, this.byteWidth), 4));
        }

        public io.objectbox.flatbuffers.FlexBuffers.Vector values() {
            return new io.objectbox.flatbuffers.FlexBuffers.Vector(this.bb, this.end, this.byteWidth);
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.Vector, io.objectbox.flatbuffers.FlexBuffers.Object
        public java.lang.StringBuilder toString(java.lang.StringBuilder sb) {
            sb.append("{ ");
            io.objectbox.flatbuffers.FlexBuffers.KeyVector keyVectorKeys = keys();
            int size = size();
            io.objectbox.flatbuffers.FlexBuffers.Vector vectorValues = values();
            for (int i = 0; i < size; i++) {
                sb.append('\"');
                sb.append(keyVectorKeys.get(i).toString());
                sb.append("\" : ");
                sb.append(vectorValues.get(i).toString());
                if (i != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            return sb;
        }

        private int binarySearch(java.lang.CharSequence charSequence) {
            int i = this.size - 1;
            int i2 = this.end - (this.byteWidth * 3);
            int iIndirect = io.objectbox.flatbuffers.FlexBuffers.indirect(this.bb, i2, this.byteWidth);
            int i3 = io.objectbox.flatbuffers.FlexBuffers.readInt(this.bb, i2 + this.byteWidth, this.byteWidth);
            int i4 = 0;
            while (i4 <= i) {
                int i5 = (i4 + i) >>> 1;
                int iCompareCharSequence = compareCharSequence(io.objectbox.flatbuffers.FlexBuffers.indirect(this.bb, (i5 * i3) + iIndirect, i3), charSequence);
                if (iCompareCharSequence < 0) {
                    i4 = i5 + 1;
                } else {
                    if (iCompareCharSequence <= 0) {
                        return i5;
                    }
                    i = i5 - 1;
                }
            }
            return -(i4 + 1);
        }

        private int binarySearch(byte[] bArr) {
            int i = this.size - 1;
            int i2 = this.end - (this.byteWidth * 3);
            int iIndirect = io.objectbox.flatbuffers.FlexBuffers.indirect(this.bb, i2, this.byteWidth);
            int i3 = io.objectbox.flatbuffers.FlexBuffers.readInt(this.bb, i2 + this.byteWidth, this.byteWidth);
            int i4 = 0;
            while (i4 <= i) {
                int i5 = (i4 + i) >>> 1;
                int iCompareBytes = compareBytes(this.bb, io.objectbox.flatbuffers.FlexBuffers.indirect(this.bb, (i5 * i3) + iIndirect, i3), bArr);
                if (iCompareBytes < 0) {
                    i4 = i5 + 1;
                } else {
                    if (iCompareBytes <= 0) {
                        return i5;
                    }
                    i = i5 - 1;
                }
            }
            return -(i4 + 1);
        }

        private int compareBytes(io.objectbox.flatbuffers.ReadBuf readBuf, int i, byte[] bArr) {
            byte b;
            byte b2;
            int i2 = 0;
            do {
                b = readBuf.get(i);
                b2 = bArr[i2];
                if (b == 0) {
                    return b - b2;
                }
                i++;
                i2++;
                if (i2 == bArr.length) {
                    int i3 = b - b2;
                    if (i3 != 0 || readBuf.get(i) == 0) {
                        return i3;
                    }
                    return 1;
                }
            } while (b == b2);
            return b - b2;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private int compareCharSequence(int i, java.lang.CharSequence charSequence) {
            int iLimit = this.bb.limit();
            int length = charSequence.length();
            int i2 = 0;
            while (i2 < length) {
                byte bCharAt = charSequence.charAt(i2);
                if (bCharAt >= 128) {
                    break;
                }
                byte b = this.bb.get(i);
                if (b == 0) {
                    return -bCharAt;
                }
                if (b < 0) {
                    break;
                }
                if (((char) b) != bCharAt) {
                    return b - bCharAt;
                }
                i++;
                i2++;
            }
            while (i < iLimit) {
                int iEncodeUtf8CodePoint = io.objectbox.flatbuffers.Utf8.encodeUtf8CodePoint(charSequence, i2, this.comparisonBuffer);
                if (iEncodeUtf8CodePoint == 0) {
                    return this.bb.get(i);
                }
                int i3 = 0;
                while (i3 < iEncodeUtf8CodePoint) {
                    int i4 = i + 1;
                    byte b2 = this.bb.get(i);
                    byte b3 = this.comparisonBuffer[i3];
                    if (b2 == 0) {
                        return -b3;
                    }
                    if (b2 != b3) {
                        return b2 - b3;
                    }
                    i3++;
                    i = i4;
                }
                i2 += iEncodeUtf8CodePoint == 4 ? 2 : 1;
            }
            return 0;
        }
    }

    public static class Vector extends io.objectbox.flatbuffers.FlexBuffers.Sized {
        private static final io.objectbox.flatbuffers.FlexBuffers.Vector EMPTY_VECTOR = new io.objectbox.flatbuffers.FlexBuffers.Vector(io.objectbox.flatbuffers.FlexBuffers.EMPTY_BB, 1, 1);

        @Override // io.objectbox.flatbuffers.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.Object
        public /* bridge */ /* synthetic */ java.lang.String toString() {
            return super.toString();
        }

        Vector(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static io.objectbox.flatbuffers.FlexBuffers.Vector empty() {
            return EMPTY_VECTOR;
        }

        public boolean isEmpty() {
            return this == EMPTY_VECTOR;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.Object
        public java.lang.StringBuilder toString(java.lang.StringBuilder sb) {
            sb.append("[ ");
            int size = size();
            for (int i = 0; i < size; i++) {
                get(i).toString(sb);
                if (i != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            return sb;
        }

        public io.objectbox.flatbuffers.FlexBuffers.Reference get(int i) {
            long size = size();
            long j = i;
            if (j >= size) {
                return io.objectbox.flatbuffers.FlexBuffers.Reference.NULL_REFERENCE;
            }
            return new io.objectbox.flatbuffers.FlexBuffers.Reference(this.bb, this.end + (i * this.byteWidth), this.byteWidth, io.objectbox.flatbuffers.FlexBuffers.Unsigned.byteToUnsignedInt(this.bb.get((int) (((long) this.end) + (size * ((long) this.byteWidth)) + j))));
        }
    }

    public static class TypedVector extends io.objectbox.flatbuffers.FlexBuffers.Vector {
        private static final io.objectbox.flatbuffers.FlexBuffers.TypedVector EMPTY_VECTOR = new io.objectbox.flatbuffers.FlexBuffers.TypedVector(io.objectbox.flatbuffers.FlexBuffers.EMPTY_BB, 1, 1, 1);
        private final int elemType;

        TypedVector(io.objectbox.flatbuffers.ReadBuf readBuf, int i, int i2, int i3) {
            super(readBuf, i, i2);
            this.elemType = i3;
        }

        public static io.objectbox.flatbuffers.FlexBuffers.TypedVector empty() {
            return EMPTY_VECTOR;
        }

        public boolean isEmptyVector() {
            return this == EMPTY_VECTOR;
        }

        public int getElemType() {
            return this.elemType;
        }

        @Override // io.objectbox.flatbuffers.FlexBuffers.Vector
        public io.objectbox.flatbuffers.FlexBuffers.Reference get(int i) {
            if (i >= size()) {
                return io.objectbox.flatbuffers.FlexBuffers.Reference.NULL_REFERENCE;
            }
            return new io.objectbox.flatbuffers.FlexBuffers.Reference(this.bb, this.end + (i * this.byteWidth), this.byteWidth, 1, this.elemType);
        }
    }

    public static class KeyVector {
        private final io.objectbox.flatbuffers.FlexBuffers.TypedVector vec;

        KeyVector(io.objectbox.flatbuffers.FlexBuffers.TypedVector typedVector) {
            this.vec = typedVector;
        }

        public io.objectbox.flatbuffers.FlexBuffers.Key get(int i) {
            if (i >= size()) {
                return io.objectbox.flatbuffers.FlexBuffers.Key.EMPTY;
            }
            return new io.objectbox.flatbuffers.FlexBuffers.Key(this.vec.bb, io.objectbox.flatbuffers.FlexBuffers.indirect(this.vec.bb, this.vec.end + (i * this.vec.byteWidth), this.vec.byteWidth), 1);
        }

        public int size() {
            return this.vec.size();
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append('[');
            for (int i = 0; i < this.vec.size(); i++) {
                this.vec.get(i).toString(sb);
                if (i != this.vec.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static class FlexBufferException extends java.lang.RuntimeException {
        FlexBufferException(java.lang.String str) {
            super(str);
        }
    }

    static class Unsigned {
        static int byteToUnsignedInt(byte b) {
            return b & 255;
        }

        static long intToUnsignedLong(int i) {
            return ((long) i) & 4294967295L;
        }

        static int shortToUnsignedInt(short s) {
            return s & 65535;
        }

        Unsigned() {
        }
    }
}
