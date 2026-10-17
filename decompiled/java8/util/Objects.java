package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Objects {
    public static boolean isNull(java.lang.Object obj) {
        return obj == null;
    }

    public static boolean nonNull(java.lang.Object obj) {
        return obj != null;
    }

    private Objects() {
    }

    public static boolean equals(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean deepEquals(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return deepEquals0(obj, obj2);
    }

    private static boolean deepEquals0(java.lang.Object obj, java.lang.Object obj2) {
        if ((obj instanceof java.lang.Object[]) && (obj2 instanceof java.lang.Object[])) {
            return java.util.Arrays.deepEquals((java.lang.Object[]) obj, (java.lang.Object[]) obj2);
        }
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return equals((byte[]) obj, (byte[]) obj2);
        }
        if ((obj instanceof short[]) && (obj2 instanceof short[])) {
            return equals((short[]) obj, (short[]) obj2);
        }
        if ((obj instanceof int[]) && (obj2 instanceof int[])) {
            return equals((int[]) obj, (int[]) obj2);
        }
        if ((obj instanceof long[]) && (obj2 instanceof long[])) {
            return equals((long[]) obj, (long[]) obj2);
        }
        if ((obj instanceof char[]) && (obj2 instanceof char[])) {
            return equals((char[]) obj, (char[]) obj2);
        }
        if ((obj instanceof float[]) && (obj2 instanceof float[])) {
            return equals((float[]) obj, (float[]) obj2);
        }
        if ((obj instanceof double[]) && (obj2 instanceof double[])) {
            return equals((double[]) obj, (double[]) obj2);
        }
        if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
            return equals((boolean[]) obj, (boolean[]) obj2);
        }
        return obj.equals(obj2);
    }

    public static int hashCode(java.lang.Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static int hash(java.lang.Object... objArr) {
        return java.util.Arrays.hashCode(objArr);
    }

    public static java.lang.String toString(java.lang.Object obj) {
        return java.lang.String.valueOf(obj);
    }

    public static java.lang.String toString(java.lang.Object obj, java.lang.String str) {
        return obj != null ? obj.toString() : str;
    }

    public static <T> int compare(T t, T t2, java.util.Comparator<? super T> comparator) {
        if (t == t2) {
            return 0;
        }
        return comparator.compare(t, t2);
    }

    public static <T> T requireNonNull(T t) {
        t.getClass();
        return t;
    }

    public static <T> T requireNonNull(T t, java.lang.String str) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(str);
    }

    public static <T> T requireNonNullElse(T t, T t2) {
        return t != null ? t : (T) requireNonNull(t2, "defaultObj");
    }

    public static <T> T requireNonNullElseGet(T t, java8.util.function.Supplier<? extends T> supplier) {
        return t != null ? t : (T) requireNonNull(((java8.util.function.Supplier) requireNonNull(supplier, "supplier")).get(), "supplier.get()");
    }

    public static <T> T requireNonNull(T t, java8.util.function.Supplier<java.lang.String> supplier) {
        if (t == null) {
            throw new java.lang.NullPointerException(supplier == null ? null : supplier.get());
        }
        return t;
    }

    public static int checkIndex(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new java.lang.IndexOutOfBoundsException(java.lang.String.format("Index %d out-of-bounds for length %d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
        }
        return i;
    }

    public static int checkFromToIndex(int i, int i2, int i3) {
        if (i < 0 || i > i2 || i2 > i3) {
            throw new java.lang.IndexOutOfBoundsException(java.lang.String.format("Range [%d, %d) out-of-bounds for length %d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3)));
        }
        return i;
    }

    public static int checkFromIndexSize(int i, int i2, int i3) {
        if ((i3 | i | i2) < 0 || i2 > i3 - i) {
            throw new java.lang.IndexOutOfBoundsException(java.lang.String.format("Range [%d, %<d + %d) out-of-bounds for length %d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3)));
        }
        return i;
    }
}
