package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class ArraysArrayListSpliterator {
    private static final long ARRAY_OFF;
    private static final sun.misc.Unsafe U;

    private ArraysArrayListSpliterator() {
    }

    static <T> java8.util.Spliterator<T> spliterator(java.util.List<T> list) {
        return java8.util.Spliterators.spliterator(getArray(list), 16);
    }

    private static <T> java.lang.Object[] getArray(java.util.List<T> list) {
        return (java.lang.Object[]) U.getObject(list, ARRAY_OFF);
    }

    static {
        sun.misc.Unsafe unsafe = java8.util.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            ARRAY_OFF = unsafe.objectFieldOffset(java.lang.Class.forName("java.util.Arrays$ArrayList").getDeclaredField("a"));
        } catch (java.lang.Exception e) {
            throw new java.lang.Error(e);
        }
    }
}
