package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class J8Arrays {
    private static final int MIN_ARRAY_SORT_GRAN = 8192;

    public static <T> java8.util.Spliterator<T> spliterator(T[] tArr) {
        return java8.util.Spliterators.spliterator(tArr, 1040);
    }

    public static <T> java8.util.Spliterator<T> spliterator(T[] tArr, int i, int i2) {
        return java8.util.Spliterators.spliterator(tArr, i, i2, 1040);
    }

    public static java8.util.Spliterator.OfInt spliterator(int[] iArr) {
        return java8.util.Spliterators.spliterator(iArr, 1040);
    }

    public static java8.util.Spliterator.OfInt spliterator(int[] iArr, int i, int i2) {
        return java8.util.Spliterators.spliterator(iArr, i, i2, 1040);
    }

    public static java8.util.Spliterator.OfLong spliterator(long[] jArr) {
        return java8.util.Spliterators.spliterator(jArr, 1040);
    }

    public static java8.util.Spliterator.OfLong spliterator(long[] jArr, int i, int i2) {
        return java8.util.Spliterators.spliterator(jArr, i, i2, 1040);
    }

    public static java8.util.Spliterator.OfDouble spliterator(double[] dArr) {
        return java8.util.Spliterators.spliterator(dArr, 1040);
    }

    public static java8.util.Spliterator.OfDouble spliterator(double[] dArr, int i, int i2) {
        return java8.util.Spliterators.spliterator(dArr, i, i2, 1040);
    }

    public static <T> java8.util.stream.Stream<T> stream(T[] tArr) {
        return stream(tArr, 0, tArr.length);
    }

    public static <T> java8.util.stream.Stream<T> stream(T[] tArr, int i, int i2) {
        return java8.util.stream.StreamSupport.stream(spliterator(tArr, i, i2), false);
    }

    public static java8.util.stream.IntStream stream(int[] iArr) {
        return stream(iArr, 0, iArr.length);
    }

    public static java8.util.stream.IntStream stream(int[] iArr, int i, int i2) {
        return java8.util.stream.StreamSupport.intStream(spliterator(iArr, i, i2), false);
    }

    public static java8.util.stream.LongStream stream(long[] jArr) {
        return stream(jArr, 0, jArr.length);
    }

    public static java8.util.stream.LongStream stream(long[] jArr, int i, int i2) {
        return java8.util.stream.StreamSupport.longStream(spliterator(jArr, i, i2), false);
    }

    public static java8.util.stream.DoubleStream stream(double[] dArr) {
        return stream(dArr, 0, dArr.length);
    }

    public static java8.util.stream.DoubleStream stream(double[] dArr, int i, int i2) {
        return java8.util.stream.StreamSupport.doubleStream(spliterator(dArr, i, i2), false);
    }

    public static void parallelSort(byte[] bArr) {
        java8.util.DualPivotQuicksort.sort(bArr, 0, bArr.length);
    }

    public static void parallelSort(byte[] bArr, int i, int i2) {
        rangeCheck(bArr.length, i, i2);
        java8.util.DualPivotQuicksort.sort(bArr, i, i2);
    }

    public static void parallelSort(char[] cArr) {
        java8.util.DualPivotQuicksort.sort(cArr, 0, cArr.length);
    }

    public static void parallelSort(char[] cArr, int i, int i2) {
        rangeCheck(cArr.length, i, i2);
        java8.util.DualPivotQuicksort.sort(cArr, i, i2);
    }

    public static void parallelSort(short[] sArr) {
        java8.util.DualPivotQuicksort.sort(sArr, 0, sArr.length);
    }

    public static void parallelSort(short[] sArr, int i, int i2) {
        rangeCheck(sArr.length, i, i2);
        java8.util.DualPivotQuicksort.sort(sArr, i, i2);
    }

    public static void parallelSort(int[] iArr) {
        java8.util.DualPivotQuicksort.sort(iArr, java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism(), 0, iArr.length);
    }

    public static void parallelSort(int[] iArr, int i, int i2) {
        rangeCheck(iArr.length, i, i2);
        java8.util.DualPivotQuicksort.sort(iArr, java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism(), i, i2);
    }

    public static void parallelSort(long[] jArr) {
        java8.util.DualPivotQuicksort.sort(jArr, java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism(), 0, jArr.length);
    }

    public static void parallelSort(long[] jArr, int i, int i2) {
        rangeCheck(jArr.length, i, i2);
        java8.util.DualPivotQuicksort.sort(jArr, java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism(), i, i2);
    }

    public static void parallelSort(float[] fArr) {
        java8.util.DualPivotQuicksort.sort(fArr, java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism(), 0, fArr.length);
    }

    public static void parallelSort(float[] fArr, int i, int i2) {
        rangeCheck(fArr.length, i, i2);
        java8.util.DualPivotQuicksort.sort(fArr, java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism(), i, i2);
    }

    public static void parallelSort(double[] dArr) {
        java8.util.DualPivotQuicksort.sort(dArr, java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism(), 0, dArr.length);
    }

    public static void parallelSort(double[] dArr, int i, int i2) {
        rangeCheck(dArr.length, i, i2);
        java8.util.DualPivotQuicksort.sort(dArr, java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism(), i, i2);
    }

    private static void rangeCheck(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i2 < 0) {
                throw new java.lang.ArrayIndexOutOfBoundsException(i2);
            }
            if (i3 > i) {
                throw new java.lang.ArrayIndexOutOfBoundsException(i3);
            }
            return;
        }
        throw new java.lang.IllegalArgumentException("fromIndex(" + i2 + ") > toIndex(" + i3 + ")");
    }

    static final class NaturalOrder implements java.util.Comparator<java.lang.Object> {
        static final java8.util.J8Arrays.NaturalOrder INSTANCE = new java8.util.J8Arrays.NaturalOrder();

        NaturalOrder() {
        }

        @Override // java.util.Comparator
        public int compare(java.lang.Object obj, java.lang.Object obj2) {
            return ((java.lang.Comparable) obj).compareTo(obj2);
        }
    }

    public static <T extends java.lang.Comparable<? super T>> void parallelSort(T[] tArr) {
        int commonPoolParallelism;
        int length = tArr.length;
        if (length <= 8192 || (commonPoolParallelism = java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1) {
            java8.util.TimSort.sort(tArr, 0, length, java8.util.J8Arrays.NaturalOrder.INSTANCE, null, 0, 0);
        } else {
            int i = length / (commonPoolParallelism << 2);
            new java8.util.ArraysParallelSortHelpers.FJObject.Sorter(null, tArr, (java.lang.Comparable[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), length), 0, length, 0, i <= 8192 ? 8192 : i, java8.util.J8Arrays.NaturalOrder.INSTANCE).invoke();
        }
    }

    public static <T extends java.lang.Comparable<? super T>> void parallelSort(T[] tArr, int i, int i2) {
        int commonPoolParallelism;
        rangeCheck(tArr.length, i, i2);
        int i3 = i2 - i;
        if (i3 <= 8192 || (commonPoolParallelism = java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1) {
            java8.util.TimSort.sort(tArr, i, i2, java8.util.J8Arrays.NaturalOrder.INSTANCE, null, 0, 0);
        } else {
            int i4 = i3 / (commonPoolParallelism << 2);
            new java8.util.ArraysParallelSortHelpers.FJObject.Sorter(null, tArr, (java.lang.Comparable[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), i3), i, i3, 0, i4 <= 8192 ? 8192 : i4, java8.util.J8Arrays.NaturalOrder.INSTANCE).invoke();
        }
    }

    public static <T> void parallelSort(T[] tArr, java.util.Comparator<? super T> comparator) {
        int commonPoolParallelism;
        if (comparator == null) {
            comparator = java8.util.J8Arrays.NaturalOrder.INSTANCE;
        }
        int length = tArr.length;
        if (length <= 8192 || (commonPoolParallelism = java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1) {
            java8.util.TimSort.sort(tArr, 0, length, comparator, null, 0, 0);
        } else {
            int i = length / (commonPoolParallelism << 2);
            new java8.util.ArraysParallelSortHelpers.FJObject.Sorter(null, tArr, (java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), length), 0, length, 0, i <= 8192 ? 8192 : i, comparator).invoke();
        }
    }

    public static <T> void parallelSort(T[] tArr, int i, int i2, java.util.Comparator<? super T> comparator) {
        int commonPoolParallelism;
        rangeCheck(tArr.length, i, i2);
        if (comparator == null) {
            comparator = java8.util.J8Arrays.NaturalOrder.INSTANCE;
        }
        int i3 = i2 - i;
        if (i3 <= 8192 || (commonPoolParallelism = java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism()) == 1) {
            java8.util.TimSort.sort(tArr, i, i2, comparator, null, 0, 0);
        } else {
            int i4 = i3 / (commonPoolParallelism << 2);
            new java8.util.ArraysParallelSortHelpers.FJObject.Sorter(null, tArr, (java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), i3), i, i3, 0, i4 <= 8192 ? 8192 : i4, comparator).invoke();
        }
    }

    public static <T> void setAll(T[] tArr, java8.util.function.IntFunction<? extends T> intFunction) {
        java8.util.Objects.requireNonNull(intFunction);
        for (int i = 0; i < tArr.length; i++) {
            tArr[i] = intFunction.apply(i);
        }
    }

    public static <T> void parallelSetAll(T[] tArr, java8.util.function.IntFunction<? extends T> intFunction) {
        java8.util.Objects.requireNonNull(intFunction);
        java8.util.stream.IntStreams.range(0, tArr.length).parallel().forEach(java8.util.J8Arrays$$Lambda$1.lambdaFactory$(tArr, intFunction));
    }

    static /* synthetic */ void lambda$parallelSetAll$163(java.lang.Object[] objArr, java8.util.function.IntFunction intFunction, int i) {
        objArr[i] = intFunction.apply(i);
    }

    public static void setAll(int[] iArr, java8.util.function.IntUnaryOperator intUnaryOperator) {
        java8.util.Objects.requireNonNull(intUnaryOperator);
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = intUnaryOperator.applyAsInt(i);
        }
    }

    public static void parallelSetAll(int[] iArr, java8.util.function.IntUnaryOperator intUnaryOperator) {
        java8.util.Objects.requireNonNull(intUnaryOperator);
        java8.util.stream.IntStreams.range(0, iArr.length).parallel().forEach(java8.util.J8Arrays$$Lambda$2.lambdaFactory$(iArr, intUnaryOperator));
    }

    static /* synthetic */ void lambda$parallelSetAll$164(int[] iArr, java8.util.function.IntUnaryOperator intUnaryOperator, int i) {
        iArr[i] = intUnaryOperator.applyAsInt(i);
    }

    public static void setAll(long[] jArr, java8.util.function.IntToLongFunction intToLongFunction) {
        java8.util.Objects.requireNonNull(intToLongFunction);
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = intToLongFunction.applyAsLong(i);
        }
    }

    public static void parallelSetAll(long[] jArr, java8.util.function.IntToLongFunction intToLongFunction) {
        java8.util.Objects.requireNonNull(intToLongFunction);
        java8.util.stream.IntStreams.range(0, jArr.length).parallel().forEach(java8.util.J8Arrays$$Lambda$3.lambdaFactory$(jArr, intToLongFunction));
    }

    static /* synthetic */ void lambda$parallelSetAll$165(long[] jArr, java8.util.function.IntToLongFunction intToLongFunction, int i) {
        jArr[i] = intToLongFunction.applyAsLong(i);
    }

    public static void setAll(double[] dArr, java8.util.function.IntToDoubleFunction intToDoubleFunction) {
        java8.util.Objects.requireNonNull(intToDoubleFunction);
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = intToDoubleFunction.applyAsDouble(i);
        }
    }

    public static void parallelSetAll(double[] dArr, java8.util.function.IntToDoubleFunction intToDoubleFunction) {
        java8.util.Objects.requireNonNull(intToDoubleFunction);
        java8.util.stream.IntStreams.range(0, dArr.length).parallel().forEach(java8.util.J8Arrays$$Lambda$4.lambdaFactory$(dArr, intToDoubleFunction));
    }

    static /* synthetic */ void lambda$parallelSetAll$166(double[] dArr, java8.util.function.IntToDoubleFunction intToDoubleFunction, int i) {
        dArr[i] = intToDoubleFunction.applyAsDouble(i);
    }

    public static <T> void parallelPrefix(T[] tArr, java8.util.function.BinaryOperator<T> binaryOperator) {
        java8.util.Objects.requireNonNull(binaryOperator);
        if (tArr.length > 0) {
            new java8.util.ArrayPrefixHelpers.CumulateTask(null, binaryOperator, tArr, 0, tArr.length).invoke();
        }
    }

    public static <T> void parallelPrefix(T[] tArr, int i, int i2, java8.util.function.BinaryOperator<T> binaryOperator) {
        java8.util.Objects.requireNonNull(binaryOperator);
        rangeCheck(tArr.length, i, i2);
        if (i < i2) {
            new java8.util.ArrayPrefixHelpers.CumulateTask(null, binaryOperator, tArr, i, i2).invoke();
        }
    }

    public static void parallelPrefix(long[] jArr, java8.util.function.LongBinaryOperator longBinaryOperator) {
        java8.util.Objects.requireNonNull(longBinaryOperator);
        if (jArr.length > 0) {
            new java8.util.ArrayPrefixHelpers.LongCumulateTask(null, longBinaryOperator, jArr, 0, jArr.length).invoke();
        }
    }

    public static void parallelPrefix(long[] jArr, int i, int i2, java8.util.function.LongBinaryOperator longBinaryOperator) {
        java8.util.Objects.requireNonNull(longBinaryOperator);
        rangeCheck(jArr.length, i, i2);
        if (i < i2) {
            new java8.util.ArrayPrefixHelpers.LongCumulateTask(null, longBinaryOperator, jArr, i, i2).invoke();
        }
    }

    public static void parallelPrefix(double[] dArr, java8.util.function.DoubleBinaryOperator doubleBinaryOperator) {
        java8.util.Objects.requireNonNull(doubleBinaryOperator);
        if (dArr.length > 0) {
            new java8.util.ArrayPrefixHelpers.DoubleCumulateTask(null, doubleBinaryOperator, dArr, 0, dArr.length).invoke();
        }
    }

    public static void parallelPrefix(double[] dArr, int i, int i2, java8.util.function.DoubleBinaryOperator doubleBinaryOperator) {
        java8.util.Objects.requireNonNull(doubleBinaryOperator);
        rangeCheck(dArr.length, i, i2);
        if (i < i2) {
            new java8.util.ArrayPrefixHelpers.DoubleCumulateTask(null, doubleBinaryOperator, dArr, i, i2).invoke();
        }
    }

    public static void parallelPrefix(int[] iArr, java8.util.function.IntBinaryOperator intBinaryOperator) {
        java8.util.Objects.requireNonNull(intBinaryOperator);
        if (iArr.length > 0) {
            new java8.util.ArrayPrefixHelpers.IntCumulateTask(null, intBinaryOperator, iArr, 0, iArr.length).invoke();
        }
    }

    public static void parallelPrefix(int[] iArr, int i, int i2, java8.util.function.IntBinaryOperator intBinaryOperator) {
        java8.util.Objects.requireNonNull(intBinaryOperator);
        rangeCheck(iArr.length, i, i2);
        if (i < i2) {
            new java8.util.ArrayPrefixHelpers.IntCumulateTask(null, intBinaryOperator, iArr, i, i2).invoke();
        }
    }

    public static boolean equals(java.lang.Object[] objArr, int i, int i2, java.lang.Object[] objArr2, int i3, int i4) {
        rangeCheck(objArr.length, i, i2);
        rangeCheck(objArr2.length, i3, i4);
        int i5 = i2 - i;
        if (i5 != i4 - i3) {
            return false;
        }
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i + 1;
            int i8 = i3 + 1;
            if (!java8.util.Objects.equals(objArr[i], objArr2[i3])) {
                return false;
            }
            i6++;
            i = i7;
            i3 = i8;
        }
        return true;
    }

    public static <T> boolean equals(T[] tArr, T[] tArr2, java.util.Comparator<? super T> comparator) {
        int length;
        java8.util.Objects.requireNonNull(comparator);
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == null || tArr2 == null || tArr2.length != (length = tArr.length)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (comparator.compare(tArr[i], tArr2[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equals(T[] tArr, int i, int i2, T[] tArr2, int i3, int i4, java.util.Comparator<? super T> comparator) {
        java8.util.Objects.requireNonNull(comparator);
        rangeCheck(tArr.length, i, i2);
        rangeCheck(tArr2.length, i3, i4);
        int i5 = i2 - i;
        if (i5 != i4 - i3) {
            return false;
        }
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i + 1;
            int i8 = i3 + 1;
            if (comparator.compare(tArr[i], tArr2[i3]) != 0) {
                return false;
            }
            i6++;
            i = i7;
            i3 = i8;
        }
        return true;
    }

    public static <T extends java.lang.Comparable<? super T>> int compare(T[] tArr, T[] tArr2) {
        if (tArr == tArr2) {
            return 0;
        }
        if (tArr == null || tArr2 == null) {
            return tArr == null ? -1 : 1;
        }
        int iMin = java.lang.Math.min(tArr.length, tArr2.length);
        for (int i = 0; i < iMin; i++) {
            T t = tArr[i];
            T t2 = tArr2[i];
            if (t != t2) {
                if (t == null || t2 == null) {
                    return t == null ? -1 : 1;
                }
                int iCompareTo = t.compareTo(t2);
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
        }
        return tArr.length - tArr2.length;
    }

    public static <T extends java.lang.Comparable<? super T>> int compare(T[] tArr, int i, int i2, T[] tArr2, int i3, int i4) {
        rangeCheck(tArr.length, i, i2);
        rangeCheck(tArr2.length, i3, i4);
        int i5 = i2 - i;
        int i6 = i4 - i3;
        int iMin = java.lang.Math.min(i5, i6);
        int i7 = 0;
        while (i7 < iMin) {
            int i8 = i + 1;
            T t = tArr[i];
            int i9 = i3 + 1;
            T t2 = tArr2[i3];
            if (t != t2) {
                if (t == null || t2 == null) {
                    return t == null ? -1 : 1;
                }
                int iCompareTo = t.compareTo(t2);
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            i7++;
            i = i8;
            i3 = i9;
        }
        return i5 - i6;
    }

    public static <T> int compare(T[] tArr, T[] tArr2, java.util.Comparator<? super T> comparator) {
        int iCompare;
        java8.util.Objects.requireNonNull(comparator);
        if (tArr == tArr2) {
            return 0;
        }
        if (tArr == null || tArr2 == null) {
            return tArr == null ? -1 : 1;
        }
        int iMin = java.lang.Math.min(tArr.length, tArr2.length);
        for (int i = 0; i < iMin; i++) {
            T t = tArr[i];
            T t2 = tArr2[i];
            if (t != t2 && (iCompare = comparator.compare(t, t2)) != 0) {
                return iCompare;
            }
        }
        return tArr.length - tArr2.length;
    }

    public static <T> int compare(T[] tArr, int i, int i2, T[] tArr2, int i3, int i4, java.util.Comparator<? super T> comparator) {
        int iCompare;
        java8.util.Objects.requireNonNull(comparator);
        rangeCheck(tArr.length, i, i2);
        rangeCheck(tArr2.length, i3, i4);
        int i5 = i2 - i;
        int i6 = i4 - i3;
        int iMin = java.lang.Math.min(i5, i6);
        int i7 = 0;
        while (i7 < iMin) {
            int i8 = i + 1;
            T t = tArr[i];
            int i9 = i3 + 1;
            T t2 = tArr2[i3];
            if (t != t2 && (iCompare = comparator.compare(t, t2)) != 0) {
                return iCompare;
            }
            i7++;
            i = i8;
            i3 = i9;
        }
        return i5 - i6;
    }

    public static int mismatch(java.lang.Object[] objArr, java.lang.Object[] objArr2) {
        int iMin = java.lang.Math.min(objArr.length, objArr2.length);
        if (objArr == objArr2) {
            return -1;
        }
        for (int i = 0; i < iMin; i++) {
            if (!java8.util.Objects.equals(objArr[i], objArr2[i])) {
                return i;
            }
        }
        if (objArr.length != objArr2.length) {
            return iMin;
        }
        return -1;
    }

    public static int mismatch(java.lang.Object[] objArr, int i, int i2, java.lang.Object[] objArr2, int i3, int i4) {
        rangeCheck(objArr.length, i, i2);
        rangeCheck(objArr2.length, i3, i4);
        int i5 = i2 - i;
        int i6 = i4 - i3;
        int iMin = java.lang.Math.min(i5, i6);
        int i7 = 0;
        while (i7 < iMin) {
            int i8 = i + 1;
            int i9 = i3 + 1;
            if (!java8.util.Objects.equals(objArr[i], objArr2[i3])) {
                return i7;
            }
            i7++;
            i = i8;
            i3 = i9;
        }
        if (i5 != i6) {
            return iMin;
        }
        return -1;
    }

    public static <T> int mismatch(T[] tArr, T[] tArr2, java.util.Comparator<? super T> comparator) {
        java8.util.Objects.requireNonNull(comparator);
        int iMin = java.lang.Math.min(tArr.length, tArr2.length);
        if (tArr == tArr2) {
            return -1;
        }
        for (int i = 0; i < iMin; i++) {
            T t = tArr[i];
            T t2 = tArr2[i];
            if (t != t2 && comparator.compare(t, t2) != 0) {
                return i;
            }
        }
        if (tArr.length != tArr2.length) {
            return iMin;
        }
        return -1;
    }

    public static <T> int mismatch(T[] tArr, int i, int i2, T[] tArr2, int i3, int i4, java.util.Comparator<? super T> comparator) {
        java8.util.Objects.requireNonNull(comparator);
        rangeCheck(tArr.length, i, i2);
        rangeCheck(tArr2.length, i3, i4);
        int i5 = i2 - i;
        int i6 = i4 - i3;
        int iMin = java.lang.Math.min(i5, i6);
        int i7 = 0;
        while (i7 < iMin) {
            int i8 = i + 1;
            T t = tArr[i];
            int i9 = i3 + 1;
            T t2 = tArr2[i3];
            if (t != t2 && comparator.compare(t, t2) != 0) {
                return i7;
            }
            i7++;
            i = i8;
            i3 = i9;
        }
        if (i5 != i6) {
            return iMin;
        }
        return -1;
    }

    public static boolean equals(long[] jArr, int i, int i2, long[] jArr2, int i3, int i4) {
        rangeCheck(jArr.length, i, i2);
        rangeCheck(jArr2.length, i3, i4);
        int i5 = i2 - i;
        if (i5 != i4 - i3) {
            return false;
        }
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i + 1;
            long j = jArr[i];
            int i8 = i3 + 1;
            if (j != jArr2[i3]) {
                return false;
            }
            i6++;
            i3 = i8;
            i = i7;
        }
        return true;
    }

    public static boolean equals(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4) {
        rangeCheck(iArr.length, i, i2);
        rangeCheck(iArr2.length, i3, i4);
        int i5 = i2 - i;
        if (i5 != i4 - i3) {
            return false;
        }
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i + 1;
            int i8 = i3 + 1;
            if (iArr[i] != iArr2[i3]) {
                return false;
            }
            i6++;
            i = i7;
            i3 = i8;
        }
        return true;
    }

    public static boolean equals(double[] dArr, int i, int i2, double[] dArr2, int i3, int i4) {
        int i5 = i;
        int i6 = i3;
        rangeCheck(dArr.length, i5, i2);
        rangeCheck(dArr2.length, i6, i4);
        int i7 = i2 - i5;
        if (i7 != i4 - i6) {
            return false;
        }
        int i8 = 0;
        while (i8 < i7) {
            int i9 = i5 + 1;
            double d = dArr[i5];
            java.lang.Double dValueOf = java.lang.Double.valueOf(d);
            int i10 = i6 + 1;
            double d2 = dArr2[i6];
            java.lang.Double dValueOf2 = java.lang.Double.valueOf(d2);
            dValueOf.getClass();
            long jDoubleToRawLongBits = java.lang.Double.doubleToRawLongBits(d);
            dValueOf2.getClass();
            if (jDoubleToRawLongBits != java.lang.Double.doubleToRawLongBits(d2)) {
                dValueOf.getClass();
                if (java.lang.Double.isNaN(d)) {
                    dValueOf2.getClass();
                    if (!java.lang.Double.isNaN(d2)) {
                    }
                }
                return false;
            }
            i8++;
            i5 = i9;
            i6 = i10;
        }
        return true;
    }

    public static int compare(int[] iArr, int[] iArr2) {
        if (iArr == iArr2) {
            return 0;
        }
        if (iArr == null || iArr2 == null) {
            return iArr == null ? -1 : 1;
        }
        int iMin = java.lang.Math.min(iArr.length, iArr2.length);
        for (int i = 0; i < iMin; i++) {
            int i2 = iArr[i];
            int i3 = iArr2[i];
            if (i2 != i3) {
                return java8.lang.Integers.compare(i2, i3);
            }
        }
        return iArr.length - iArr2.length;
    }

    public static int compare(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4) {
        rangeCheck(iArr.length, i, i2);
        rangeCheck(iArr2.length, i3, i4);
        int i5 = i2 - i;
        int i6 = i4 - i3;
        int iMin = java.lang.Math.min(i5, i6);
        int i7 = 0;
        while (i7 < iMin) {
            int i8 = i + 1;
            int i9 = iArr[i];
            int i10 = i3 + 1;
            int i11 = iArr2[i3];
            if (i9 != i11) {
                return java8.lang.Integers.compare(i9, i11);
            }
            i7++;
            i = i8;
            i3 = i10;
        }
        return i5 - i6;
    }

    public static int compare(long[] jArr, long[] jArr2) {
        if (jArr == jArr2) {
            return 0;
        }
        if (jArr == null || jArr2 == null) {
            return jArr == null ? -1 : 1;
        }
        int iMin = java.lang.Math.min(jArr.length, jArr2.length);
        for (int i = 0; i < iMin; i++) {
            long j = jArr[i];
            long j2 = jArr2[i];
            if (j != j2) {
                return java8.lang.Longs.compare(j, j2);
            }
        }
        return jArr.length - jArr2.length;
    }

    public static int compare(long[] jArr, int i, int i2, long[] jArr2, int i3, int i4) {
        rangeCheck(jArr.length, i, i2);
        rangeCheck(jArr2.length, i3, i4);
        int i5 = i2 - i;
        int i6 = i4 - i3;
        int iMin = java.lang.Math.min(i5, i6);
        int i7 = 0;
        while (i7 < iMin) {
            int i8 = i + 1;
            long j = jArr[i];
            int i9 = i3 + 1;
            long j2 = jArr2[i3];
            if (j != j2) {
                return java8.lang.Longs.compare(j, j2);
            }
            i7++;
            i3 = i9;
            i = i8;
        }
        return i5 - i6;
    }

    public static int compare(double[] dArr, double[] dArr2) {
        int iCompare;
        if (dArr == dArr2) {
            return 0;
        }
        if (dArr == null || dArr2 == null) {
            return dArr == null ? -1 : 1;
        }
        int iMin = java.lang.Math.min(dArr.length, dArr2.length);
        for (int i = 0; i < iMin; i++) {
            double d = dArr[i];
            double d2 = dArr2[i];
            if (java.lang.Double.doubleToRawLongBits(d) != java.lang.Double.doubleToRawLongBits(d2) && (iCompare = java.lang.Double.compare(d, d2)) != 0) {
                return iCompare;
            }
        }
        return dArr.length - dArr2.length;
    }

    public static int compare(double[] dArr, int i, int i2, double[] dArr2, int i3, int i4) {
        int iCompare;
        int i5 = i;
        int i6 = i3;
        rangeCheck(dArr.length, i5, i2);
        rangeCheck(dArr2.length, i6, i4);
        int i7 = i2 - i5;
        int i8 = i4 - i6;
        int iMin = java.lang.Math.min(i7, i8);
        int i9 = 0;
        while (i9 < iMin) {
            int i10 = i5 + 1;
            double d = dArr[i5];
            int i11 = i6 + 1;
            double d2 = dArr2[i6];
            if (java.lang.Double.doubleToRawLongBits(d) != java.lang.Double.doubleToRawLongBits(d2) && (iCompare = java.lang.Double.compare(d, d2)) != 0) {
                return iCompare;
            }
            i9++;
            i6 = i11;
            i5 = i10;
        }
        return i7 - i8;
    }

    public static int mismatch(int[] iArr, int[] iArr2) {
        int iMin = java.lang.Math.min(iArr.length, iArr2.length);
        if (iArr == iArr2) {
            return -1;
        }
        for (int i = 0; i < iMin; i++) {
            if (iArr[i] != iArr2[i]) {
                return i;
            }
        }
        if (iArr.length != iArr2.length) {
            return iMin;
        }
        return -1;
    }

    public static int mismatch(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4) {
        rangeCheck(iArr.length, i, i2);
        rangeCheck(iArr2.length, i3, i4);
        int i5 = i2 - i;
        int i6 = i4 - i3;
        int iMin = java.lang.Math.min(i5, i6);
        int i7 = 0;
        while (i7 < iMin) {
            int i8 = i + 1;
            int i9 = i3 + 1;
            if (iArr[i] != iArr2[i3]) {
                return i7;
            }
            i7++;
            i = i8;
            i3 = i9;
        }
        if (i5 != i6) {
            return iMin;
        }
        return -1;
    }

    public static int mismatch(long[] jArr, long[] jArr2) {
        int iMin = java.lang.Math.min(jArr.length, jArr2.length);
        if (jArr == jArr2) {
            return -1;
        }
        for (int i = 0; i < iMin; i++) {
            if (jArr[i] != jArr2[i]) {
                return i;
            }
        }
        if (jArr.length != jArr2.length) {
            return iMin;
        }
        return -1;
    }

    public static int mismatch(long[] jArr, int i, int i2, long[] jArr2, int i3, int i4) {
        rangeCheck(jArr.length, i, i2);
        rangeCheck(jArr2.length, i3, i4);
        int i5 = i2 - i;
        int i6 = i4 - i3;
        int iMin = java.lang.Math.min(i5, i6);
        int i7 = 0;
        while (i7 < iMin) {
            int i8 = i + 1;
            long j = jArr[i];
            int i9 = i3 + 1;
            if (j != jArr2[i3]) {
                return i7;
            }
            i7++;
            i3 = i9;
            i = i8;
        }
        if (i5 != i6) {
            return iMin;
        }
        return -1;
    }

    public static int mismatch(double[] dArr, double[] dArr2) {
        int iMin = java.lang.Math.min(dArr.length, dArr2.length);
        if (dArr == dArr2) {
            return -1;
        }
        for (int i = 0; i < iMin; i++) {
            double d = dArr[i];
            double d2 = dArr2[i];
            if (java.lang.Double.doubleToRawLongBits(d) != java.lang.Double.doubleToRawLongBits(d2) && (!java.lang.Double.isNaN(d) || !java.lang.Double.isNaN(d2))) {
                return i;
            }
        }
        if (dArr.length != dArr2.length) {
            return iMin;
        }
        return -1;
    }

    public static int mismatch(double[] dArr, int i, int i2, double[] dArr2, int i3, int i4) {
        int i5 = i;
        int i6 = i3;
        rangeCheck(dArr.length, i5, i2);
        rangeCheck(dArr2.length, i6, i4);
        int i7 = i2 - i5;
        int i8 = i4 - i6;
        int iMin = java.lang.Math.min(i7, i8);
        int i9 = 0;
        while (i9 < iMin) {
            int i10 = i5 + 1;
            double d = dArr[i5];
            int i11 = i6 + 1;
            double d2 = dArr2[i6];
            if (java.lang.Double.doubleToRawLongBits(d) != java.lang.Double.doubleToRawLongBits(d2) && (!java.lang.Double.isNaN(d) || !java.lang.Double.isNaN(d2))) {
                return i9;
            }
            i9++;
            i6 = i11;
            i5 = i10;
        }
        if (i7 != i8) {
            return iMin;
        }
        return -1;
    }

    public static <T> T[] toArray(java.util.Collection<T> collection, java8.util.function.IntFunction<T[]> intFunction) {
        return (T[]) collection.toArray(intFunction.apply(0));
    }

    private J8Arrays() {
    }
}
