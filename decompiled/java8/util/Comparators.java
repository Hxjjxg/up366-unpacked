package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Comparators {

    private enum NaturalOrderComparator implements java.util.Comparator<java.lang.Comparable<java.lang.Object>> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(java.lang.Comparable<java.lang.Object> comparable, java.lang.Comparable<java.lang.Object> comparable2) {
            return comparable.compareTo(comparable2);
        }

        @Override // java.util.Comparator
        public java.util.Comparator<java.lang.Comparable<java.lang.Object>> reversed() {
            return java8.util.Comparators.reverseOrder();
        }
    }

    private static final class NullComparator<T> implements java.util.Comparator<T>, java.io.Serializable {
        private static final long serialVersionUID = -7569533591570686392L;
        private final boolean nullFirst;
        private final java.util.Comparator<T> real;

        /* JADX WARN: Multi-variable type inference failed */
        NullComparator(boolean z, java.util.Comparator<? super T> comparator) {
            this.nullFirst = z;
            this.real = comparator;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            if (t == null) {
                if (t2 == null) {
                    return 0;
                }
                return this.nullFirst ? -1 : 1;
            }
            if (t2 == null) {
                return this.nullFirst ? 1 : -1;
            }
            java.util.Comparator<T> comparator = this.real;
            if (comparator == null) {
                return 0;
            }
            return comparator.compare(t, t2);
        }

        @Override // java.util.Comparator
        public java.util.Comparator<T> thenComparing(java.util.Comparator<? super T> comparator) {
            java8.util.Objects.requireNonNull(comparator);
            boolean z = this.nullFirst;
            java.util.Comparator<T> comparator2 = this.real;
            if (comparator2 != null) {
                comparator = java8.util.Comparators.thenComparing(comparator2, comparator);
            }
            return new java8.util.Comparators.NullComparator(z, comparator);
        }

        @Override // java.util.Comparator
        public java.util.Comparator<T> reversed() {
            boolean z = !this.nullFirst;
            java.util.Comparator<T> comparator = this.real;
            return new java8.util.Comparators.NullComparator(z, comparator == null ? null : java.util.Collections.reverseOrder(comparator));
        }
    }

    public static <T extends java.lang.Comparable<? super T>> java.util.Comparator<T> reverseOrder() {
        return java.util.Collections.reverseOrder();
    }

    public static <T extends java.lang.Comparable<? super T>> java.util.Comparator<T> naturalOrder() {
        return java8.util.Comparators.NaturalOrderComparator.INSTANCE;
    }

    public static <T, U> java.util.Comparator<T> comparing(java8.util.function.Function<? super T, ? extends U> function, java.util.Comparator<? super U> comparator) {
        java8.util.Objects.requireNonNull(function);
        java8.util.Objects.requireNonNull(comparator);
        return (java.util.Comparator) ((java.io.Serializable) java8.util.Comparators$$Lambda$1.lambdaFactory$(comparator, function));
    }

    static /* synthetic */ int lambda$comparing$b1478148$1(java.util.Comparator comparator, java8.util.function.Function function, java.lang.Object obj, java.lang.Object obj2) {
        return comparator.compare(function.apply(obj), function.apply(obj2));
    }

    public static <T, U extends java.lang.Comparable<? super U>> java.util.Comparator<T> comparing(java8.util.function.Function<? super T, ? extends U> function) {
        java8.util.Objects.requireNonNull(function);
        return (java.util.Comparator) ((java.io.Serializable) java8.util.Comparators$$Lambda$2.lambdaFactory$(function));
    }

    static /* synthetic */ int lambda$comparing$628f93f7$1(java8.util.function.Function function, java.lang.Object obj, java.lang.Object obj2) {
        return ((java.lang.Comparable) function.apply(obj)).compareTo(function.apply(obj2));
    }

    public static <T> java.util.Comparator<T> comparingInt(java8.util.function.ToIntFunction<? super T> toIntFunction) {
        java8.util.Objects.requireNonNull(toIntFunction);
        return (java.util.Comparator) ((java.io.Serializable) java8.util.Comparators$$Lambda$3.lambdaFactory$(toIntFunction));
    }

    static /* synthetic */ int lambda$comparingInt$134fc06a$1(java8.util.function.ToIntFunction toIntFunction, java.lang.Object obj, java.lang.Object obj2) {
        return java8.lang.Integers.compare(toIntFunction.applyAsInt(obj), toIntFunction.applyAsInt(obj2));
    }

    public static <T> java.util.Comparator<T> comparingLong(java8.util.function.ToLongFunction<? super T> toLongFunction) {
        java8.util.Objects.requireNonNull(toLongFunction);
        return (java.util.Comparator) ((java.io.Serializable) java8.util.Comparators$$Lambda$4.lambdaFactory$(toLongFunction));
    }

    static /* synthetic */ int lambda$comparingLong$c3a37e6$1(java8.util.function.ToLongFunction toLongFunction, java.lang.Object obj, java.lang.Object obj2) {
        return java8.lang.Longs.compare(toLongFunction.applyAsLong(obj), toLongFunction.applyAsLong(obj2));
    }

    public static <T> java.util.Comparator<T> comparingDouble(java8.util.function.ToDoubleFunction<? super T> toDoubleFunction) {
        java8.util.Objects.requireNonNull(toDoubleFunction);
        return (java.util.Comparator) ((java.io.Serializable) java8.util.Comparators$$Lambda$5.lambdaFactory$(toDoubleFunction));
    }

    static /* synthetic */ int lambda$comparingDouble$57709dbc$1(java8.util.function.ToDoubleFunction toDoubleFunction, java.lang.Object obj, java.lang.Object obj2) {
        return java.lang.Double.compare(toDoubleFunction.applyAsDouble(obj), toDoubleFunction.applyAsDouble(obj2));
    }

    public static <T> java.util.Comparator<T> thenComparing(java.util.Comparator<? super T> comparator, java.util.Comparator<? super T> comparator2) {
        java8.util.Objects.requireNonNull(comparator);
        java8.util.Objects.requireNonNull(comparator2);
        if (comparator instanceof java8.util.Comparators.NullComparator) {
            return ((java8.util.Comparators.NullComparator) comparator).thenComparing(comparator2);
        }
        return (java.util.Comparator) ((java.io.Serializable) java8.util.Comparators$$Lambda$6.lambdaFactory$(comparator, comparator2));
    }

    static /* synthetic */ int lambda$thenComparing$aafead48$1(java.util.Comparator comparator, java.util.Comparator comparator2, java.lang.Object obj, java.lang.Object obj2) {
        int iCompare = comparator.compare(obj, obj2);
        return iCompare != 0 ? iCompare : comparator2.compare(obj, obj2);
    }

    public static <T, U> java.util.Comparator<T> thenComparing(java.util.Comparator<? super T> comparator, java8.util.function.Function<? super T, ? extends U> function, java.util.Comparator<? super U> comparator2) {
        return thenComparing(comparator, comparing(function, comparator2));
    }

    public static <T, U extends java.lang.Comparable<? super U>> java.util.Comparator<T> thenComparing(java.util.Comparator<? super T> comparator, java8.util.function.Function<? super T, ? extends U> function) {
        return thenComparing(comparator, comparing(function));
    }

    public static <T> java.util.Comparator<T> thenComparingInt(java.util.Comparator<? super T> comparator, java8.util.function.ToIntFunction<? super T> toIntFunction) {
        return thenComparing(comparator, comparingInt(toIntFunction));
    }

    public static <T> java.util.Comparator<T> thenComparingLong(java.util.Comparator<? super T> comparator, java8.util.function.ToLongFunction<? super T> toLongFunction) {
        return thenComparing(comparator, comparingLong(toLongFunction));
    }

    public static <T> java.util.Comparator<T> thenComparingDouble(java.util.Comparator<? super T> comparator, java8.util.function.ToDoubleFunction<? super T> toDoubleFunction) {
        return thenComparing(comparator, comparingDouble(toDoubleFunction));
    }

    public static <T> java.util.Comparator<T> reversed(java.util.Comparator<T> comparator) {
        if (comparator instanceof java8.util.Comparators.NullComparator) {
            return ((java8.util.Comparators.NullComparator) comparator).reversed();
        }
        return java.util.Collections.reverseOrder(comparator);
    }

    public static <T> java.util.Comparator<T> nullsFirst(java.util.Comparator<? super T> comparator) {
        return new java8.util.Comparators.NullComparator(true, comparator);
    }

    public static <T> java.util.Comparator<T> nullsLast(java.util.Comparator<? super T> comparator) {
        return new java8.util.Comparators.NullComparator(false, comparator);
    }

    private Comparators() {
    }
}
