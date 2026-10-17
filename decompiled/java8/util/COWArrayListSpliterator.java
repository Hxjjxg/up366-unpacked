package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class COWArrayListSpliterator {
    private static final long ARRAY_OFF;
    private static final sun.misc.Unsafe U = java8.util.UnsafeAccess.unsafe;

    private COWArrayListSpliterator() {
    }

    static <T> java8.util.Spliterator<T> spliterator(java.util.concurrent.CopyOnWriteArrayList<T> copyOnWriteArrayList) {
        return java8.util.Spliterators.spliterator(getArray(copyOnWriteArrayList), 1040);
    }

    static <T> java.lang.Object[] getArray(java.util.concurrent.CopyOnWriteArrayList<T> copyOnWriteArrayList) {
        return (java.lang.Object[]) U.getObject(copyOnWriteArrayList, ARRAY_OFF);
    }

    static {
        ARRAY_OFF = fieldOffset(java8.util.Spliterators.IS_ANDROID ? "elements" : "array", true);
    }

    static long fieldOffset(java.lang.String str, boolean z) {
        try {
            return U.objectFieldOffset(java.util.concurrent.CopyOnWriteArrayList.class.getDeclaredField(str));
        } catch (java.lang.Exception e) {
            if (z && (e instanceof java.lang.NoSuchFieldException) && java8.util.Spliterators.IS_ANDROID && !java8.util.Spliterators.IS_HARMONY_ANDROID) {
                return fieldOffset("array", false);
            }
            throw new java.lang.Error(e);
        }
    }
}
