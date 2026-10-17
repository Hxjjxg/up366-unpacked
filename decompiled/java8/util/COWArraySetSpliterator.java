package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class COWArraySetSpliterator {
    private static final long COW_ARRAY_OFF;
    private static final sun.misc.Unsafe U;

    private COWArraySetSpliterator() {
    }

    static <T> java8.util.Spliterator<T> spliterator(java.util.concurrent.CopyOnWriteArraySet<T> copyOnWriteArraySet) {
        return java8.util.Spliterators.spliterator(java8.util.COWArrayListSpliterator.getArray(getCowArrayList(copyOnWriteArraySet)), 1025);
    }

    private static <T> java.util.concurrent.CopyOnWriteArrayList<T> getCowArrayList(java.util.concurrent.CopyOnWriteArraySet<T> copyOnWriteArraySet) {
        return (java.util.concurrent.CopyOnWriteArrayList) U.getObject(copyOnWriteArraySet, COW_ARRAY_OFF);
    }

    static {
        sun.misc.Unsafe unsafe = java8.util.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            COW_ARRAY_OFF = unsafe.objectFieldOffset(java.util.concurrent.CopyOnWriteArraySet.class.getDeclaredField("al"));
        } catch (java.lang.Exception e) {
            throw new java.lang.Error(e);
        }
    }
}
