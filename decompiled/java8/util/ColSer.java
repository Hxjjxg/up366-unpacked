package java8.util;

/* JADX INFO: compiled from: ImmutableCollections.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class ColSer implements java.io.Serializable {
    static final int IMM_LIST = 1;
    static final int IMM_MAP = 3;
    static final int IMM_SET = 2;
    private static final long serialVersionUID = 6309168927139932177L;
    private transient java.lang.Object[] array;
    private final int tag;

    ColSer(int i, java.lang.Object... objArr) {
        this.tag = i;
        this.array = objArr;
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.lang.ClassNotFoundException, java.io.IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new java.io.InvalidObjectException("negative length " + i);
        }
        java.lang.Object[] objArr = new java.lang.Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = objectInputStream.readObject();
        }
        this.array = objArr;
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.array.length);
        int i = 0;
        while (true) {
            java.lang.Object[] objArr = this.array;
            if (i >= objArr.length) {
                return;
            }
            objectOutputStream.writeObject(objArr[i]);
            i++;
        }
    }

    private java.lang.Object readResolve() throws java.io.ObjectStreamException {
        try {
            java.lang.Object[] objArr = this.array;
            if (objArr == null) {
                throw new java.io.InvalidObjectException("null array");
            }
            int i = this.tag & 255;
            if (i == 1) {
                return java8.util.Lists.of(objArr);
            }
            if (i == 2) {
                return java8.util.Sets.of(objArr);
            }
            if (i == 3) {
                if (objArr.length == 0) {
                    return java8.util.ImmutableCollections.EMPTY_MAP;
                }
                if (objArr.length == 2) {
                    java.lang.Object[] objArr2 = this.array;
                    return new java8.util.ImmutableCollections.Map1(objArr2[0], objArr2[1]);
                }
                return new java8.util.ImmutableCollections.MapN(this.array);
            }
            throw new java.io.InvalidObjectException(java.lang.String.format("invalid flags 0x%x", java.lang.Integer.valueOf(this.tag)));
        } catch (java.lang.IllegalArgumentException e) {
            throw ioe(e);
        } catch (java.lang.NullPointerException e2) {
            throw ioe(e2);
        }
    }

    private static java.io.InvalidObjectException ioe(java.lang.RuntimeException runtimeException) {
        java.io.InvalidObjectException invalidObjectException = new java.io.InvalidObjectException("invalid object");
        invalidObjectException.initCause(runtimeException);
        return invalidObjectException;
    }
}
