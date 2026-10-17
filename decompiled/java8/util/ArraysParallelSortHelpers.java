package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class ArraysParallelSortHelpers {
    ArraysParallelSortHelpers() {
    }

    static final class EmptyCompleter extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
        static final long serialVersionUID = 2446542900576103244L;

        @Override // java8.util.concurrent.CountedCompleter
        public final void compute() {
        }

        EmptyCompleter(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
            super(countedCompleter);
        }
    }

    static final class Relay extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
        static final long serialVersionUID = 2446542900576103244L;
        final java8.util.concurrent.CountedCompleter<?> task;

        @Override // java8.util.concurrent.CountedCompleter
        public final void compute() {
        }

        Relay(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
            super(null, 1);
            this.task = countedCompleter;
        }

        @Override // java8.util.concurrent.CountedCompleter
        public final void onCompletion(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
            this.task.compute();
        }
    }

    static final class FJObject {
        FJObject() {
        }

        static final class Sorter<T> extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final T[] a;
            final int base;
            java.util.Comparator<? super T> comparator;
            final int gran;
            final int size;
            final T[] w;
            final int wbase;

            Sorter(java8.util.concurrent.CountedCompleter<?> countedCompleter, T[] tArr, T[] tArr2, int i, int i2, int i3, int i4, java.util.Comparator<? super T> comparator) {
                super(countedCompleter);
                this.a = tArr;
                this.w = tArr2;
                this.base = i;
                this.size = i2;
                this.wbase = i3;
                this.gran = i4;
                this.comparator = comparator;
            }

            @Override // java8.util.concurrent.CountedCompleter
            public final void compute() {
                java.util.Comparator<? super T> comparator = this.comparator;
                T[] tArr = this.a;
                T[] tArr2 = this.w;
                int i = this.base;
                int i2 = this.size;
                int i3 = this.wbase;
                int i4 = this.gran;
                java8.util.concurrent.CountedCompleter emptyCompleter = this;
                int i5 = i2;
                while (i5 > i4) {
                    int i6 = i5 >>> 1;
                    int i7 = i5 >>> 2;
                    int i8 = i6 + i7;
                    int i9 = i3 + i6;
                    T[] tArr3 = tArr2;
                    int i10 = i4;
                    int i11 = i3;
                    java8.util.ArraysParallelSortHelpers.Relay relay = new java8.util.ArraysParallelSortHelpers.Relay(new java8.util.ArraysParallelSortHelpers.FJObject.Merger(emptyCompleter, tArr2, tArr, i3, i6, i9, i5 - i6, i, i4, comparator));
                    int i12 = i + i6;
                    int i13 = i + i8;
                    int i14 = i5 - i8;
                    java8.util.ArraysParallelSortHelpers.Relay relay2 = new java8.util.ArraysParallelSortHelpers.Relay(new java8.util.ArraysParallelSortHelpers.FJObject.Merger(relay, tArr, tArr3, i12, i7, i13, i14, i9, i4, comparator));
                    new java8.util.ArraysParallelSortHelpers.FJObject.Sorter(relay2, tArr, tArr3, i13, i14, i11 + i8, i10, comparator).fork();
                    new java8.util.ArraysParallelSortHelpers.FJObject.Sorter(relay2, tArr, tArr3, i12, i7, i9, i10, comparator).fork();
                    int i15 = i + i7;
                    int i16 = i6 - i7;
                    java8.util.ArraysParallelSortHelpers.Relay relay3 = new java8.util.ArraysParallelSortHelpers.Relay(new java8.util.ArraysParallelSortHelpers.FJObject.Merger(relay, tArr, tArr3, i, i7, i15, i16, i11, i4, comparator));
                    new java8.util.ArraysParallelSortHelpers.FJObject.Sorter(relay3, tArr, tArr3, i15, i16, i11 + i7, i10, comparator).fork();
                    emptyCompleter = new java8.util.ArraysParallelSortHelpers.EmptyCompleter(relay3);
                    i5 = i7;
                    tArr2 = tArr3;
                    i4 = i10;
                    i3 = i11;
                }
                int i17 = i5;
                int i18 = i + i17;
                java8.util.TimSort.sort(tArr, i, i18, comparator, tArr2, i3, i17);
                emptyCompleter.tryComplete();
            }
        }

        static final class Merger<T> extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final T[] a;
            java.util.Comparator<? super T> comparator;
            final int gran;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final T[] w;
            final int wbase;

            Merger(java8.util.concurrent.CountedCompleter<?> countedCompleter, T[] tArr, T[] tArr2, int i, int i2, int i3, int i4, int i5, int i6, java.util.Comparator<? super T> comparator) {
                super(countedCompleter);
                this.a = tArr;
                this.w = tArr2;
                this.lbase = i;
                this.lsize = i2;
                this.rbase = i3;
                this.rsize = i4;
                this.wbase = i5;
                this.gran = i6;
                this.comparator = comparator;
            }

            @Override // java8.util.concurrent.CountedCompleter
            public final void compute() {
                int i;
                int i2;
                java.util.Comparator<? super T> comparator = this.comparator;
                java.lang.Object[] objArr = this.a;
                T[] tArr = this.w;
                int i3 = this.lbase;
                int i4 = this.lsize;
                int i5 = this.rbase;
                int i6 = this.rsize;
                int i7 = this.wbase;
                int i8 = this.gran;
                if (objArr == null || tArr == null || i3 < 0 || i5 < 0 || i7 < 0 || comparator == null) {
                    throw new java.lang.IllegalStateException();
                }
                while (true) {
                    int i9 = 0;
                    int i10 = 1;
                    if (i4 >= i6) {
                        if (i4 <= i8) {
                            break;
                        }
                        int i11 = i4 >>> 1;
                        java.lang.Object obj = objArr[i11 + i3];
                        int i12 = i6;
                        while (i9 < i12) {
                            int i13 = (i9 + i12) >>> i10;
                            if (comparator.compare(obj, objArr[i13 + i5]) <= 0) {
                                i12 = i13;
                            } else {
                                i9 = i13 + 1;
                            }
                            i10 = 1;
                        }
                        i2 = i11;
                        i = i12;
                        int i14 = i8;
                        java8.util.ArraysParallelSortHelpers.FJObject.Merger merger = new java8.util.ArraysParallelSortHelpers.FJObject.Merger(this, objArr, tArr, i3 + i2, i4 - i2, i5 + i, i6 - i, i7 + i2 + i, i14, comparator);
                        addToPendingCount(1);
                        merger.fork();
                        i4 = i2;
                        i8 = i14;
                        i6 = i;
                        i7 = i7;
                        objArr = objArr;
                        i5 = i5;
                    } else {
                        if (i6 <= i8) {
                            break;
                        }
                        int i15 = i6 >>> 1;
                        java.lang.Object obj2 = objArr[i15 + i5];
                        int i16 = i4;
                        while (i9 < i16) {
                            int i17 = (i9 + i16) >>> 1;
                            if (comparator.compare(obj2, objArr[i17 + i3]) <= 0) {
                                i16 = i17;
                            } else {
                                i9 = i17 + 1;
                            }
                        }
                        i = i15;
                        i2 = i16;
                        int i142 = i8;
                        java8.util.ArraysParallelSortHelpers.FJObject.Merger merger2 = new java8.util.ArraysParallelSortHelpers.FJObject.Merger(this, objArr, tArr, i3 + i2, i4 - i2, i5 + i, i6 - i, i7 + i2 + i, i142, comparator);
                        addToPendingCount(1);
                        merger2.fork();
                        i4 = i2;
                        i8 = i142;
                        i6 = i;
                        i7 = i7;
                        objArr = objArr;
                        i5 = i5;
                    }
                }
                int i18 = i4 + i3;
                int i19 = i6 + i5;
                while (i3 < i18 && i5 < i19) {
                    java.lang.Object obj3 = objArr[i3];
                    java.lang.Object obj4 = objArr[i5];
                    if (comparator.compare(obj3, obj4) <= 0) {
                        i3++;
                    } else {
                        i5++;
                        obj3 = obj4;
                    }
                    tArr[i7] = obj3;
                    i7++;
                }
                if (i5 < i19) {
                    java.lang.System.arraycopy(objArr, i5, tArr, i7, i19 - i5);
                } else if (i3 < i18) {
                    java.lang.System.arraycopy(objArr, i3, tArr, i7, i18 - i3);
                }
                tryComplete();
            }
        }
    }
}
