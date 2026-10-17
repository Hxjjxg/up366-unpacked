package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Sets {
    public static <E> java.util.Set<E> of() {
        return java8.util.ImmutableCollections.EMPTY_SET;
    }

    public static <E> java.util.Set<E> of(E e) {
        return new java8.util.ImmutableCollections.Set12(e);
    }

    public static <E> java.util.Set<E> of(E e, E e2) {
        return new java8.util.ImmutableCollections.Set12(e, e2);
    }

    public static <E> java.util.Set<E> of(E e, E e2, E e3) {
        return new java8.util.ImmutableCollections.SetN(e, e2, e3);
    }

    public static <E> java.util.Set<E> of(E e, E e2, E e3, E e4) {
        return new java8.util.ImmutableCollections.SetN(e, e2, e3, e4);
    }

    public static <E> java.util.Set<E> of(E e, E e2, E e3, E e4, E e5) {
        return new java8.util.ImmutableCollections.SetN(e, e2, e3, e4, e5);
    }

    public static <E> java.util.Set<E> of(E e, E e2, E e3, E e4, E e5, E e6) {
        return new java8.util.ImmutableCollections.SetN(e, e2, e3, e4, e5, e6);
    }

    public static <E> java.util.Set<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7) {
        return new java8.util.ImmutableCollections.SetN(e, e2, e3, e4, e5, e6, e7);
    }

    public static <E> java.util.Set<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return new java8.util.ImmutableCollections.SetN(e, e2, e3, e4, e5, e6, e7, e8);
    }

    public static <E> java.util.Set<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return new java8.util.ImmutableCollections.SetN(e, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    public static <E> java.util.Set<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return new java8.util.ImmutableCollections.SetN(e, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    public static <E> java.util.Set<E> of(E... eArr) {
        int length = eArr.length;
        if (length == 0) {
            return java8.util.ImmutableCollections.EMPTY_SET;
        }
        if (length == 1) {
            return new java8.util.ImmutableCollections.Set12(eArr[0]);
        }
        if (length == 2) {
            return new java8.util.ImmutableCollections.Set12(eArr[0], eArr[1]);
        }
        return new java8.util.ImmutableCollections.SetN(eArr);
    }

    public static <E> java.util.Set<E> copyOf(java.util.Collection<? extends E> collection) {
        if (collection instanceof java8.util.ImmutableCollections.AbstractImmutableSet) {
            return (java.util.Set) collection;
        }
        return of(new java.util.HashSet(collection).toArray());
    }

    private Sets() {
    }
}
