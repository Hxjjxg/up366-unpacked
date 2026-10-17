package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Lists {
    public static <E> void sort(java.util.List<E> list, java.util.Comparator<? super E> comparator) {
        java.util.Collections.sort(list, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void replaceAll(java.util.List<E> list, java8.util.function.UnaryOperator<E> unaryOperator) {
        java8.util.Objects.requireNonNull(list);
        java8.util.Objects.requireNonNull(unaryOperator);
        java.util.ListIterator<E> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.set(unaryOperator.apply(listIterator.next()));
        }
    }

    public static <E> java8.util.Spliterator<E> spliterator(java.util.List<E> list) {
        return java8.util.Spliterators.spliterator(list);
    }

    public static <E> java.util.List<E> of() {
        return java8.util.ImmutableCollections.EMPTY_LIST;
    }

    public static <E> java.util.List<E> of(E e) {
        return new java8.util.ImmutableCollections.List12(e);
    }

    public static <E> java.util.List<E> of(E e, E e2) {
        return new java8.util.ImmutableCollections.List12(e, e2);
    }

    public static <E> java.util.List<E> of(E e, E e2, E e3) {
        return new java8.util.ImmutableCollections.ListN(e, e2, e3);
    }

    public static <E> java.util.List<E> of(E e, E e2, E e3, E e4) {
        return new java8.util.ImmutableCollections.ListN(e, e2, e3, e4);
    }

    public static <E> java.util.List<E> of(E e, E e2, E e3, E e4, E e5) {
        return new java8.util.ImmutableCollections.ListN(e, e2, e3, e4, e5);
    }

    public static <E> java.util.List<E> of(E e, E e2, E e3, E e4, E e5, E e6) {
        return new java8.util.ImmutableCollections.ListN(e, e2, e3, e4, e5, e6);
    }

    public static <E> java.util.List<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7) {
        return new java8.util.ImmutableCollections.ListN(e, e2, e3, e4, e5, e6, e7);
    }

    public static <E> java.util.List<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return new java8.util.ImmutableCollections.ListN(e, e2, e3, e4, e5, e6, e7, e8);
    }

    public static <E> java.util.List<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return new java8.util.ImmutableCollections.ListN(e, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    public static <E> java.util.List<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return new java8.util.ImmutableCollections.ListN(e, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    public static <E> java.util.List<E> of(E... eArr) {
        int length = eArr.length;
        if (length == 0) {
            return java8.util.ImmutableCollections.EMPTY_LIST;
        }
        if (length == 1) {
            return new java8.util.ImmutableCollections.List12(eArr[0]);
        }
        if (length == 2) {
            return new java8.util.ImmutableCollections.List12(eArr[0], eArr[1]);
        }
        return new java8.util.ImmutableCollections.ListN(eArr);
    }

    public static <E> java.util.List<E> copyOf(java.util.Collection<? extends E> collection) {
        return java8.util.ImmutableCollections.listCopy(collection);
    }

    private Lists() {
    }
}
