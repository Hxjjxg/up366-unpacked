package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Spliterators {
    private static final boolean ALLOW_RNDACC_SPLITER_OPT;
    static final boolean DELEGATION_ENABLED;
    private static final java.lang.String DELEGATION_ENABLED_P;
    private static final java8.util.Spliterator.OfDouble EMPTY_DOUBLE_SPLITERATOR;
    private static final java8.util.Spliterator.OfInt EMPTY_INT_SPLITERATOR;
    private static final java8.util.Spliterator.OfLong EMPTY_LONG_SPLITERATOR;
    private static final java8.util.Spliterator<java.lang.Object> EMPTY_SPLITERATOR;
    static final boolean HAS_STREAMS;
    static final boolean IS_ANDROID;
    static final boolean IS_ANDROID_O;
    static final boolean IS_HARMONY_ANDROID;
    static final boolean IS_JAVA6;
    static final boolean IS_JAVA9;
    private static final boolean IS_ROBOVM;
    private static final java.lang.String NATIVE_OPT_ENABLED_P;
    static final boolean NATIVE_SPECIALIZATION;
    private static final java.lang.String RNDACC_SPLITER_ENABLED_P;

    static {
        java.lang.String str = java8.util.Spliterators.class.getName() + ".assume.oracle.collections.impl";
        NATIVE_OPT_ENABLED_P = str;
        java.lang.String str2 = java8.util.Spliterators.class.getName() + ".jre.delegation.enabled";
        DELEGATION_ENABLED_P = str2;
        java.lang.String str3 = java8.util.Spliterators.class.getName() + ".randomaccess.spliterator.enabled";
        RNDACC_SPLITER_ENABLED_P = str3;
        NATIVE_SPECIALIZATION = getBooleanPropVal(str, true);
        DELEGATION_ENABLED = getBooleanPropVal(str2, true);
        ALLOW_RNDACC_SPLITER_OPT = getBooleanPropVal(str3, true);
        IS_ROBOVM = isRoboVm();
        boolean zIsAndroid = isAndroid();
        IS_ANDROID = zIsAndroid;
        IS_HARMONY_ANDROID = zIsAndroid && !isClassPresent("android.opengl.GLES32$DebugProc");
        IS_ANDROID_O = zIsAndroid && isClassPresent("java.time.DateTimeException");
        IS_JAVA6 = !zIsAndroid && isJava6();
        HAS_STREAMS = isStreamEnabled();
        IS_JAVA9 = isClassPresent("java.lang.StackWalker$Option");
        EMPTY_SPLITERATOR = new java8.util.Spliterators.EmptySpliterator.OfRef();
        EMPTY_INT_SPLITERATOR = new java8.util.Spliterators.EmptySpliterator.OfInt();
        EMPTY_LONG_SPLITERATOR = new java8.util.Spliterators.EmptySpliterator.OfLong();
        EMPTY_DOUBLE_SPLITERATOR = new java8.util.Spliterators.EmptySpliterator.OfDouble();
    }

    private Spliterators() {
    }

    public static <T> void forEachRemaining(java8.util.Spliterator<T> spliterator, java8.util.function.Consumer<? super T> consumer) {
        while (spliterator.tryAdvance(consumer)) {
        }
    }

    public static <T> long getExactSizeIfKnown(java8.util.Spliterator<T> spliterator) {
        if ((spliterator.characteristics() & 64) == 0) {
            return -1L;
        }
        return spliterator.estimateSize();
    }

    public static <T> boolean hasCharacteristics(java8.util.Spliterator<T> spliterator, int i) {
        return (spliterator.characteristics() & i) == i;
    }

    public static <T> java.util.Comparator<? super T> getComparator(java8.util.Spliterator<T> spliterator) {
        throw new java.lang.IllegalStateException();
    }

    public static final class OfPrimitive {
        public static <T, T_CONS, T_SPLITR extends java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> void forEachRemaining(java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> ofPrimitive, T_CONS t_cons) {
            while (ofPrimitive.tryAdvance(t_cons)) {
            }
        }

        private OfPrimitive() {
        }
    }

    public static final class OfInt {
        public static void forEachRemaining(java8.util.Spliterator.OfInt ofInt, java8.util.function.IntConsumer intConsumer) {
            while (ofInt.tryAdvance(intConsumer)) {
            }
        }

        public static boolean tryAdvance(java8.util.Spliterator.OfInt ofInt, java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            if (consumer instanceof java8.util.function.IntConsumer) {
                return ofInt.tryAdvance((java8.util.function.IntConsumer) consumer);
            }
            return ofInt.tryAdvance(toIntConsumer(consumer));
        }

        private static java8.util.function.IntConsumer toIntConsumer(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            consumer.getClass();
            return java8.util.Spliterators$OfInt$$Lambda$1.lambdaFactory$(consumer);
        }

        public static void forEachRemaining(java8.util.Spliterator.OfInt ofInt, java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            if (consumer instanceof java8.util.function.IntConsumer) {
                ofInt.forEachRemaining((java8.util.function.IntConsumer) consumer);
            } else {
                ofInt.forEachRemaining(toIntConsumer(consumer));
            }
        }

        private OfInt() {
        }
    }

    public static final class OfLong {
        public static void forEachRemaining(java8.util.Spliterator.OfLong ofLong, java8.util.function.LongConsumer longConsumer) {
            while (ofLong.tryAdvance(longConsumer)) {
            }
        }

        public static boolean tryAdvance(java8.util.Spliterator.OfLong ofLong, java8.util.function.Consumer<? super java.lang.Long> consumer) {
            if (consumer instanceof java8.util.function.LongConsumer) {
                return ofLong.tryAdvance((java8.util.function.LongConsumer) consumer);
            }
            return ofLong.tryAdvance(toLongConsumer(consumer));
        }

        private static java8.util.function.LongConsumer toLongConsumer(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            consumer.getClass();
            return java8.util.Spliterators$OfLong$$Lambda$1.lambdaFactory$(consumer);
        }

        public static void forEachRemaining(java8.util.Spliterator.OfLong ofLong, java8.util.function.Consumer<? super java.lang.Long> consumer) {
            if (consumer instanceof java8.util.function.LongConsumer) {
                ofLong.forEachRemaining((java8.util.function.LongConsumer) consumer);
            } else {
                ofLong.forEachRemaining(toLongConsumer(consumer));
            }
        }

        private OfLong() {
        }
    }

    public static final class OfDouble {
        public static void forEachRemaining(java8.util.Spliterator.OfDouble ofDouble, java8.util.function.DoubleConsumer doubleConsumer) {
            while (ofDouble.tryAdvance(doubleConsumer)) {
            }
        }

        public static boolean tryAdvance(java8.util.Spliterator.OfDouble ofDouble, java8.util.function.Consumer<? super java.lang.Double> consumer) {
            if (consumer instanceof java8.util.function.DoubleConsumer) {
                return ofDouble.tryAdvance((java8.util.function.DoubleConsumer) consumer);
            }
            return ofDouble.tryAdvance(toDoubleConsumer(consumer));
        }

        private static java8.util.function.DoubleConsumer toDoubleConsumer(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            consumer.getClass();
            return java8.util.Spliterators$OfDouble$$Lambda$1.lambdaFactory$(consumer);
        }

        public static void forEachRemaining(java8.util.Spliterator.OfDouble ofDouble, java8.util.function.Consumer<? super java.lang.Double> consumer) {
            if (consumer instanceof java8.util.function.DoubleConsumer) {
                ofDouble.forEachRemaining((java8.util.function.DoubleConsumer) consumer);
            } else {
                ofDouble.forEachRemaining(toDoubleConsumer(consumer));
            }
        }

        private OfDouble() {
        }
    }

    public static <T> java8.util.Spliterator<T> emptySpliterator() {
        return (java8.util.Spliterator<T>) EMPTY_SPLITERATOR;
    }

    public static java8.util.Spliterator.OfInt emptyIntSpliterator() {
        return EMPTY_INT_SPLITERATOR;
    }

    public static java8.util.Spliterator.OfLong emptyLongSpliterator() {
        return EMPTY_LONG_SPLITERATOR;
    }

    public static java8.util.Spliterator.OfDouble emptyDoubleSpliterator() {
        return EMPTY_DOUBLE_SPLITERATOR;
    }

    public static <T> java8.util.Spliterator<T> spliterator(java.lang.Object[] objArr, int i) {
        return new java8.util.Spliterators.ArraySpliterator((java.lang.Object[]) java8.util.Objects.requireNonNull(objArr), i);
    }

    public static <T> java8.util.Spliterator<T> spliterator(java.lang.Object[] objArr, int i, int i2, int i3) {
        checkFromToBounds(((java.lang.Object[]) java8.util.Objects.requireNonNull(objArr)).length, i, i2);
        return new java8.util.Spliterators.ArraySpliterator(objArr, i, i2, i3);
    }

    public static java8.util.Spliterator.OfInt spliterator(int[] iArr, int i) {
        return new java8.util.Spliterators.IntArraySpliterator((int[]) java8.util.Objects.requireNonNull(iArr), i);
    }

    public static java8.util.Spliterator.OfInt spliterator(int[] iArr, int i, int i2, int i3) {
        checkFromToBounds(((int[]) java8.util.Objects.requireNonNull(iArr)).length, i, i2);
        return new java8.util.Spliterators.IntArraySpliterator(iArr, i, i2, i3);
    }

    public static java8.util.Spliterator.OfLong spliterator(long[] jArr, int i) {
        return new java8.util.Spliterators.LongArraySpliterator((long[]) java8.util.Objects.requireNonNull(jArr), i);
    }

    public static java8.util.Spliterator.OfLong spliterator(long[] jArr, int i, int i2, int i3) {
        checkFromToBounds(((long[]) java8.util.Objects.requireNonNull(jArr)).length, i, i2);
        return new java8.util.Spliterators.LongArraySpliterator(jArr, i, i2, i3);
    }

    public static java8.util.Spliterator.OfDouble spliterator(double[] dArr, int i) {
        return new java8.util.Spliterators.DoubleArraySpliterator((double[]) java8.util.Objects.requireNonNull(dArr), i);
    }

    public static java8.util.Spliterator.OfDouble spliterator(double[] dArr, int i, int i2, int i3) {
        checkFromToBounds(((double[]) java8.util.Objects.requireNonNull(dArr)).length, i, i2);
        return new java8.util.Spliterators.DoubleArraySpliterator(dArr, i, i2, i3);
    }

    private static void checkFromToBounds(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i2 < 0) {
                throw new java.lang.ArrayIndexOutOfBoundsException(i2);
            }
            if (i3 > i) {
                throw new java.lang.ArrayIndexOutOfBoundsException(i3);
            }
            return;
        }
        throw new java.lang.ArrayIndexOutOfBoundsException("origin(" + i2 + ") > fence(" + i3 + ")");
    }

    public static <T> java8.util.Spliterator<T> spliterator(java.util.Collection<? extends T> collection) {
        java8.util.Objects.requireNonNull(collection);
        if (HAS_STREAMS && ((DELEGATION_ENABLED || IS_JAVA9) && !hasAndroid7LHMBug(collection))) {
            return delegatingSpliterator(collection);
        }
        java.lang.String name = collection.getClass().getName();
        if (collection instanceof java.util.List) {
            return listSpliterator((java.util.List) collection, name);
        }
        if (collection instanceof java.util.Set) {
            return setSpliterator((java.util.Set) collection, name);
        }
        if (collection instanceof java.util.Queue) {
            return queueSpliterator((java.util.Queue) collection);
        }
        if (!IS_HARMONY_ANDROID && NATIVE_SPECIALIZATION && "java.util.HashMap$Values".equals(name)) {
            return java8.util.HMSpliterators.getValuesSpliterator(collection);
        }
        return spliterator(collection, 0);
    }

    private static <T> java8.util.Spliterator<T> listSpliterator(java.util.List<? extends T> list, java.lang.String str) {
        if (NATIVE_SPECIALIZATION || IS_ANDROID) {
            if (list instanceof java.util.ArrayList) {
                return java8.util.ArrayListSpliterator.spliterator((java.util.ArrayList) list);
            }
            if ("java.util.Arrays$ArrayList".equals(str)) {
                return java8.util.ArraysArrayListSpliterator.spliterator(list);
            }
            if (list instanceof java.util.concurrent.CopyOnWriteArrayList) {
                return java8.util.COWArrayListSpliterator.spliterator((java.util.concurrent.CopyOnWriteArrayList) list);
            }
            if (list instanceof java.util.LinkedList) {
                return java8.util.LinkedListSpliterator.spliterator((java.util.LinkedList) list);
            }
            if (list instanceof java.util.Vector) {
                return java8.util.VectorSpliterator.spliterator((java.util.Vector) list);
            }
        }
        if (ALLOW_RNDACC_SPLITER_OPT && (list instanceof java.util.RandomAccess)) {
            if (!(list instanceof java.util.AbstractList) && isFromJdk(str)) {
                return spliterator(list, 16);
            }
            if (!(list instanceof java.util.concurrent.CopyOnWriteArrayList)) {
                return java8.util.RASpliterator.spliterator(list);
            }
        }
        return spliterator(list, 16);
    }

    private static <T> java8.util.Spliterator<T> setSpliterator(final java.util.Set<? extends T> set, java.lang.String str) {
        boolean z = IS_HARMONY_ANDROID;
        if (!z && NATIVE_SPECIALIZATION) {
            if ("java.util.HashMap$EntrySet".equals(str)) {
                return java8.util.HMSpliterators.getEntrySetSpliterator(set);
            }
            if ("java.util.HashMap$KeySet".equals(str)) {
                return java8.util.HMSpliterators.getKeySetSpliterator(set);
            }
        }
        if (set instanceof java.util.LinkedHashSet) {
            return spliterator(set, 17);
        }
        if (!z && NATIVE_SPECIALIZATION && (set instanceof java.util.HashSet)) {
            return java8.util.HMSpliterators.getHashSetSpliterator((java.util.HashSet) set);
        }
        if (set instanceof java.util.SortedSet) {
            return new java8.util.Spliterators.IteratorSpliterator<T>(set, 21) { // from class: java8.util.Spliterators.1
                @Override // java8.util.Spliterators.IteratorSpliterator, java8.util.Spliterator
                public java.util.Comparator<? super T> getComparator() {
                    return ((java.util.SortedSet) set).comparator();
                }
            };
        }
        if ((NATIVE_SPECIALIZATION || IS_ANDROID) && (set instanceof java.util.concurrent.CopyOnWriteArraySet)) {
            return java8.util.COWArraySetSpliterator.spliterator((java.util.concurrent.CopyOnWriteArraySet) set);
        }
        return spliterator(set, 1);
    }

    private static <T> java8.util.Spliterator<T> queueSpliterator(java.util.Queue<? extends T> queue) {
        if (queue instanceof java.util.concurrent.ArrayBlockingQueue) {
            return spliterator(queue, 4368);
        }
        if (NATIVE_SPECIALIZATION || IS_ANDROID) {
            if (queue instanceof java.util.concurrent.LinkedBlockingQueue) {
                return java8.util.LBQSpliterator.spliterator((java.util.concurrent.LinkedBlockingQueue) queue);
            }
            if (queue instanceof java.util.ArrayDeque) {
                return java8.util.ArrayDequeSpliterator.spliterator((java.util.ArrayDeque) queue);
            }
            if (queue instanceof java.util.concurrent.LinkedBlockingDeque) {
                return java8.util.LBDSpliterator.spliterator((java.util.concurrent.LinkedBlockingDeque) queue);
            }
            if (queue instanceof java.util.concurrent.PriorityBlockingQueue) {
                return java8.util.PBQueueSpliterator.spliterator((java.util.concurrent.PriorityBlockingQueue) queue);
            }
            if (queue instanceof java.util.PriorityQueue) {
                return java8.util.PQueueSpliterator.spliterator((java.util.PriorityQueue) queue);
            }
        }
        if ((queue instanceof java.util.Deque) || !(!queue.getClass().getName().startsWith("java.util") || (queue instanceof java.util.concurrent.PriorityBlockingQueue) || (queue instanceof java.util.PriorityQueue) || (queue instanceof java.util.concurrent.DelayQueue) || (queue instanceof java.util.concurrent.SynchronousQueue))) {
            return spliterator(queue, queue instanceof java.util.ArrayDeque ? 272 : 16);
        }
        return spliterator(queue, 0);
    }

    private static <T> java8.util.Spliterator<T> delegatingSpliterator(java.util.Collection<? extends T> collection) {
        return new java8.util.DelegatingSpliterator(collection.spliterator());
    }

    public static <T> java8.util.Spliterator<T> spliterator(java.util.Collection<? extends T> collection, int i) {
        return new java8.util.Spliterators.IteratorSpliterator((java.util.Collection) java8.util.Objects.requireNonNull(collection), i);
    }

    public static <T> java8.util.Spliterator<T> spliterator(java.util.Iterator<? extends T> it, long j, int i) {
        return new java8.util.Spliterators.IteratorSpliterator((java.util.Iterator) java8.util.Objects.requireNonNull(it), j, i);
    }

    public static <T> java8.util.Spliterator<T> spliteratorUnknownSize(java.util.Iterator<? extends T> it, int i) {
        return new java8.util.Spliterators.IteratorSpliterator((java.util.Iterator) java8.util.Objects.requireNonNull(it), i);
    }

    public static java8.util.Spliterator.OfInt spliterator(java8.util.PrimitiveIterator.OfInt ofInt, long j, int i) {
        return new java8.util.Spliterators.IntIteratorSpliterator((java8.util.PrimitiveIterator.OfInt) java8.util.Objects.requireNonNull(ofInt), j, i);
    }

    public static java8.util.Spliterator.OfInt spliteratorUnknownSize(java8.util.PrimitiveIterator.OfInt ofInt, int i) {
        return new java8.util.Spliterators.IntIteratorSpliterator((java8.util.PrimitiveIterator.OfInt) java8.util.Objects.requireNonNull(ofInt), i);
    }

    public static java8.util.Spliterator.OfLong spliterator(java8.util.PrimitiveIterator.OfLong ofLong, long j, int i) {
        return new java8.util.Spliterators.LongIteratorSpliterator((java8.util.PrimitiveIterator.OfLong) java8.util.Objects.requireNonNull(ofLong), j, i);
    }

    public static java8.util.Spliterator.OfLong spliteratorUnknownSize(java8.util.PrimitiveIterator.OfLong ofLong, int i) {
        return new java8.util.Spliterators.LongIteratorSpliterator((java8.util.PrimitiveIterator.OfLong) java8.util.Objects.requireNonNull(ofLong), i);
    }

    public static java8.util.Spliterator.OfDouble spliterator(java8.util.PrimitiveIterator.OfDouble ofDouble, long j, int i) {
        return new java8.util.Spliterators.DoubleIteratorSpliterator((java8.util.PrimitiveIterator.OfDouble) java8.util.Objects.requireNonNull(ofDouble), j, i);
    }

    public static java8.util.Spliterator.OfDouble spliteratorUnknownSize(java8.util.PrimitiveIterator.OfDouble ofDouble, int i) {
        return new java8.util.Spliterators.DoubleIteratorSpliterator((java8.util.PrimitiveIterator.OfDouble) java8.util.Objects.requireNonNull(ofDouble), i);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: java8.util.Spliterators$1Adapter, reason: invalid class name */
    class C1Adapter<T> implements java.util.Iterator<T>, java8.util.function.Consumer<T> {
        T nextElement;
        final /* synthetic */ java8.util.Spliterator val$spliterator;
        boolean valueReady = false;

        C1Adapter(java8.util.Spliterator spliterator) {
            this.val$spliterator = spliterator;
        }

        @Override // java8.util.function.Consumer
        public void accept(T t) {
            this.valueReady = true;
            this.nextElement = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.valueReady) {
                this.val$spliterator.tryAdvance(this);
            }
            return this.valueReady;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.valueReady && !hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            this.valueReady = false;
            return this.nextElement;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove");
        }
    }

    public static <T> java.util.Iterator<T> iterator(java8.util.Spliterator<? extends T> spliterator) {
        java8.util.Objects.requireNonNull(spliterator);
        return new java8.util.Spliterators.C1Adapter(spliterator);
    }

    /* JADX INFO: renamed from: java8.util.Spliterators$2Adapter, reason: invalid class name */
    class C2Adapter implements java8.util.PrimitiveIterator.OfInt, java8.util.function.IntConsumer {
        int nextElement;
        final /* synthetic */ java8.util.Spliterator.OfInt val$spliterator;
        boolean valueReady = false;

        C2Adapter(java8.util.Spliterator.OfInt ofInt) {
            this.val$spliterator = ofInt;
        }

        @Override // java8.util.function.IntConsumer
        public void accept(int i) {
            this.valueReady = true;
            this.nextElement = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.valueReady) {
                this.val$spliterator.tryAdvance((java8.util.function.IntConsumer) this);
            }
            return this.valueReady;
        }

        @Override // java8.util.PrimitiveIterator.OfInt
        public int nextInt() {
            if (!this.valueReady && !hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            this.valueReady = false;
            return this.nextElement;
        }

        @Override // java.util.Iterator
        public java.lang.Integer next() {
            return java.lang.Integer.valueOf(nextInt());
        }

        @Override // java8.util.PrimitiveIterator
        public void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
            java8.util.Iterators.forEachRemaining(this, intConsumer);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove");
        }
    }

    public static java8.util.PrimitiveIterator.OfInt iterator(java8.util.Spliterator.OfInt ofInt) {
        java8.util.Objects.requireNonNull(ofInt);
        return new java8.util.Spliterators.C2Adapter(ofInt);
    }

    /* JADX INFO: renamed from: java8.util.Spliterators$3Adapter, reason: invalid class name */
    class C3Adapter implements java8.util.PrimitiveIterator.OfLong, java8.util.function.LongConsumer {
        long nextElement;
        final /* synthetic */ java8.util.Spliterator.OfLong val$spliterator;
        boolean valueReady = false;

        C3Adapter(java8.util.Spliterator.OfLong ofLong) {
            this.val$spliterator = ofLong;
        }

        @Override // java8.util.function.LongConsumer
        public void accept(long j) {
            this.valueReady = true;
            this.nextElement = j;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.valueReady) {
                this.val$spliterator.tryAdvance((java8.util.function.LongConsumer) this);
            }
            return this.valueReady;
        }

        @Override // java8.util.PrimitiveIterator.OfLong
        public long nextLong() {
            if (!this.valueReady && !hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            this.valueReady = false;
            return this.nextElement;
        }

        @Override // java.util.Iterator
        public java.lang.Long next() {
            return java.lang.Long.valueOf(nextLong());
        }

        @Override // java8.util.PrimitiveIterator
        public void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
            java8.util.Iterators.forEachRemaining(this, longConsumer);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove");
        }
    }

    public static java8.util.PrimitiveIterator.OfLong iterator(java8.util.Spliterator.OfLong ofLong) {
        java8.util.Objects.requireNonNull(ofLong);
        return new java8.util.Spliterators.C3Adapter(ofLong);
    }

    /* JADX INFO: renamed from: java8.util.Spliterators$4Adapter, reason: invalid class name */
    class C4Adapter implements java8.util.PrimitiveIterator.OfDouble, java8.util.function.DoubleConsumer {
        double nextElement;
        final /* synthetic */ java8.util.Spliterator.OfDouble val$spliterator;
        boolean valueReady = false;

        C4Adapter(java8.util.Spliterator.OfDouble ofDouble) {
            this.val$spliterator = ofDouble;
        }

        @Override // java8.util.function.DoubleConsumer
        public void accept(double d) {
            this.valueReady = true;
            this.nextElement = d;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.valueReady) {
                this.val$spliterator.tryAdvance((java8.util.function.DoubleConsumer) this);
            }
            return this.valueReady;
        }

        @Override // java8.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            if (!this.valueReady && !hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            this.valueReady = false;
            return this.nextElement;
        }

        @Override // java.util.Iterator
        public java.lang.Double next() {
            return java.lang.Double.valueOf(nextDouble());
        }

        @Override // java8.util.PrimitiveIterator
        public void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
            java8.util.Iterators.forEachRemaining(this, doubleConsumer);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove");
        }
    }

    public static java8.util.PrimitiveIterator.OfDouble iterator(java8.util.Spliterator.OfDouble ofDouble) {
        java8.util.Objects.requireNonNull(ofDouble);
        return new java8.util.Spliterators.C4Adapter(ofDouble);
    }

    private static abstract class EmptySpliterator<T, S extends java8.util.Spliterator<T>, C> {
        public int characteristics() {
            return 16448;
        }

        public long estimateSize() {
            return 0L;
        }

        public S trySplit() {
            return null;
        }

        EmptySpliterator() {
        }

        public boolean tryAdvance(C c) {
            java8.util.Objects.requireNonNull(c);
            return false;
        }

        public void forEachRemaining(C c) {
            java8.util.Objects.requireNonNull(c);
        }

        private static final class OfRef<T> extends java8.util.Spliterators.EmptySpliterator<T, java8.util.Spliterator<T>, java8.util.function.Consumer<? super T>> implements java8.util.Spliterator<T> {
            @Override // java8.util.Spliterator
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.Consumer consumer) {
                super.forEachRemaining(consumer);
            }

            @Override // java8.util.Spliterator
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.Consumer consumer) {
                return super.tryAdvance(consumer);
            }

            OfRef() {
            }

            @Override // java8.util.Spliterator
            public long getExactSizeIfKnown() {
                return java8.util.Spliterators.getExactSizeIfKnown(this);
            }

            @Override // java8.util.Spliterator
            public boolean hasCharacteristics(int i) {
                return java8.util.Spliterators.hasCharacteristics(this, i);
            }

            @Override // java8.util.Spliterator
            public java.util.Comparator<? super T> getComparator() {
                throw new java.lang.IllegalStateException();
            }
        }

        private static final class OfInt extends java8.util.Spliterators.EmptySpliterator<java.lang.Integer, java8.util.Spliterator.OfInt, java8.util.function.IntConsumer> implements java8.util.Spliterator.OfInt {
            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
                super.forEachRemaining(intConsumer);
            }

            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
                return super.tryAdvance(intConsumer);
            }

            @Override // java8.util.Spliterators.EmptySpliterator, java8.util.Spliterator.OfDouble, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfInt trySplit() {
                return (java8.util.Spliterator.OfInt) super.trySplit();
            }

            @Override // java8.util.Spliterators.EmptySpliterator, java8.util.Spliterator.OfDouble, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                return (java8.util.Spliterator.OfPrimitive) super.trySplit();
            }

            OfInt() {
            }

            @Override // java8.util.Spliterator
            public long getExactSizeIfKnown() {
                return java8.util.Spliterators.getExactSizeIfKnown(this);
            }

            @Override // java8.util.Spliterator
            public boolean hasCharacteristics(int i) {
                return java8.util.Spliterators.hasCharacteristics(this, i);
            }

            @Override // java8.util.Spliterator
            public java.util.Comparator<? super java.lang.Integer> getComparator() {
                throw new java.lang.IllegalStateException();
            }

            @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                java8.util.Spliterators.OfInt.forEachRemaining(this, consumer);
            }
        }

        private static final class OfLong extends java8.util.Spliterators.EmptySpliterator<java.lang.Long, java8.util.Spliterator.OfLong, java8.util.function.LongConsumer> implements java8.util.Spliterator.OfLong {
            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
                super.forEachRemaining(longConsumer);
            }

            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
                return super.tryAdvance(longConsumer);
            }

            @Override // java8.util.Spliterators.EmptySpliterator, java8.util.Spliterator.OfDouble, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfLong trySplit() {
                return (java8.util.Spliterator.OfLong) super.trySplit();
            }

            @Override // java8.util.Spliterators.EmptySpliterator, java8.util.Spliterator.OfDouble, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                return (java8.util.Spliterator.OfPrimitive) super.trySplit();
            }

            OfLong() {
            }

            @Override // java8.util.Spliterator
            public long getExactSizeIfKnown() {
                return java8.util.Spliterators.getExactSizeIfKnown(this);
            }

            @Override // java8.util.Spliterator
            public boolean hasCharacteristics(int i) {
                return java8.util.Spliterators.hasCharacteristics(this, i);
            }

            @Override // java8.util.Spliterator
            public java.util.Comparator<? super java.lang.Long> getComparator() {
                throw new java.lang.IllegalStateException();
            }

            @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
            }
        }

        private static final class OfDouble extends java8.util.Spliterators.EmptySpliterator<java.lang.Double, java8.util.Spliterator.OfDouble, java8.util.function.DoubleConsumer> implements java8.util.Spliterator.OfDouble {
            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
                super.forEachRemaining(doubleConsumer);
            }

            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
                return super.tryAdvance(doubleConsumer);
            }

            @Override // java8.util.Spliterators.EmptySpliterator, java8.util.Spliterator.OfDouble, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfDouble trySplit() {
                return (java8.util.Spliterator.OfDouble) super.trySplit();
            }

            @Override // java8.util.Spliterators.EmptySpliterator, java8.util.Spliterator.OfDouble, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                return (java8.util.Spliterator.OfPrimitive) super.trySplit();
            }

            OfDouble() {
            }

            @Override // java8.util.Spliterator
            public long getExactSizeIfKnown() {
                return java8.util.Spliterators.getExactSizeIfKnown(this);
            }

            @Override // java8.util.Spliterator
            public boolean hasCharacteristics(int i) {
                return java8.util.Spliterators.hasCharacteristics(this, i);
            }

            @Override // java8.util.Spliterator
            public java.util.Comparator<? super java.lang.Double> getComparator() {
                throw new java.lang.IllegalStateException();
            }

            @Override // java8.util.Spliterator.OfDouble, java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator.OfDouble, java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
            }
        }
    }

    static final class ArraySpliterator<T> implements java8.util.Spliterator<T> {
        private final java.lang.Object[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        public ArraySpliterator(java.lang.Object[] objArr, int i) {
            this(objArr, 0, objArr.length, i);
        }

        public ArraySpliterator(java.lang.Object[] objArr, int i, int i2, int i3) {
            this.array = objArr;
            this.index = i;
            this.fence = i2;
            this.characteristics = i3 | 16448;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown(this);
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator<T> trySplit() {
            int i = this.index;
            int i2 = (this.fence + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            java.lang.Object[] objArr = this.array;
            this.index = i2;
            return new java8.util.Spliterators.ArraySpliterator(objArr, i, i2, this.characteristics);
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
            int i;
            java8.util.Objects.requireNonNull(consumer);
            java.lang.Object[] objArr = this.array;
            int length = objArr.length;
            int i2 = this.fence;
            if (length < i2 || (i = this.index) < 0) {
                return;
            }
            this.index = i2;
            if (i < i2) {
                do {
                    consumer.accept(objArr[i]);
                    i++;
                } while (i < i2);
            }
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            int i = this.index;
            if (i < 0 || i >= this.fence) {
                return false;
            }
            java.lang.Object[] objArr = this.array;
            this.index = i + 1;
            consumer.accept(objArr[i]);
            return true;
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super T> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    static final class IntArraySpliterator implements java8.util.Spliterator.OfInt {
        private final int[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        public IntArraySpliterator(int[] iArr, int i) {
            this(iArr, 0, iArr.length, i);
        }

        public IntArraySpliterator(int[] iArr, int i, int i2, int i3) {
            this.array = iArr;
            this.index = i;
            this.fence = i2;
            this.characteristics = i3 | 16448;
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator.OfInt trySplit() {
            int i = this.index;
            int i2 = (this.fence + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            int[] iArr = this.array;
            this.index = i2;
            return new java8.util.Spliterators.IntArraySpliterator(iArr, i, i2, this.characteristics);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
            int i;
            java8.util.Objects.requireNonNull(intConsumer);
            int[] iArr = this.array;
            int length = iArr.length;
            int i2 = this.fence;
            if (length < i2 || (i = this.index) < 0) {
                return;
            }
            this.index = i2;
            if (i < i2) {
                do {
                    intConsumer.accept(iArr[i]);
                    i++;
                } while (i < i2);
            }
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
            java8.util.Objects.requireNonNull(intConsumer);
            int i = this.index;
            if (i < 0 || i >= this.fence) {
                return false;
            }
            int[] iArr = this.array;
            this.index = i + 1;
            intConsumer.accept(iArr[i]);
            return true;
        }

        @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            java8.util.Spliterators.OfInt.forEachRemaining(this, consumer);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown(this);
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Integer> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    static final class LongArraySpliterator implements java8.util.Spliterator.OfLong {
        private final long[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        public LongArraySpliterator(long[] jArr, int i) {
            this(jArr, 0, jArr.length, i);
        }

        public LongArraySpliterator(long[] jArr, int i, int i2, int i3) {
            this.array = jArr;
            this.index = i;
            this.fence = i2;
            this.characteristics = i3 | 16448;
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator.OfLong trySplit() {
            int i = this.index;
            int i2 = (this.fence + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            long[] jArr = this.array;
            this.index = i2;
            return new java8.util.Spliterators.LongArraySpliterator(jArr, i, i2, this.characteristics);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
            int i;
            java8.util.Objects.requireNonNull(longConsumer);
            long[] jArr = this.array;
            int length = jArr.length;
            int i2 = this.fence;
            if (length < i2 || (i = this.index) < 0) {
                return;
            }
            this.index = i2;
            if (i < i2) {
                do {
                    longConsumer.accept(jArr[i]);
                    i++;
                } while (i < i2);
            }
        }

        @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
            java8.util.Objects.requireNonNull(longConsumer);
            int i = this.index;
            if (i < 0 || i >= this.fence) {
                return false;
            }
            long[] jArr = this.array;
            this.index = i + 1;
            longConsumer.accept(jArr[i]);
            return true;
        }

        @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown(this);
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Long> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    static final class DoubleArraySpliterator implements java8.util.Spliterator.OfDouble {
        private final double[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        public DoubleArraySpliterator(double[] dArr, int i) {
            this(dArr, 0, dArr.length, i);
        }

        public DoubleArraySpliterator(double[] dArr, int i, int i2, int i3) {
            this.array = dArr;
            this.index = i;
            this.fence = i2;
            this.characteristics = i3 | 16448;
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator.OfDouble trySplit() {
            int i = this.index;
            int i2 = (this.fence + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            double[] dArr = this.array;
            this.index = i2;
            return new java8.util.Spliterators.DoubleArraySpliterator(dArr, i, i2, this.characteristics);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
            int i;
            java8.util.Objects.requireNonNull(doubleConsumer);
            double[] dArr = this.array;
            int length = dArr.length;
            int i2 = this.fence;
            if (length < i2 || (i = this.index) < 0) {
                return;
            }
            this.index = i2;
            if (i < i2) {
                do {
                    doubleConsumer.accept(dArr[i]);
                    i++;
                } while (i < i2);
            }
        }

        @Override // java8.util.Spliterator.OfDouble, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
            java8.util.Objects.requireNonNull(doubleConsumer);
            int i = this.index;
            if (i < 0 || i >= this.fence) {
                return false;
            }
            double[] dArr = this.array;
            this.index = i + 1;
            doubleConsumer.accept(dArr[i]);
            return true;
        }

        @Override // java8.util.Spliterator.OfDouble, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown(this);
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Double> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    public static abstract class AbstractSpliterator<T> implements java8.util.Spliterator<T> {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;

        protected AbstractSpliterator(long j, int i) {
            this.est = j;
            this.characteristics = (i & 64) != 0 ? i | 16384 : i;
        }

        static final class HoldingConsumer<T> implements java8.util.function.Consumer<T> {
            java.lang.Object value;

            HoldingConsumer() {
            }

            @Override // java8.util.function.Consumer
            public void accept(T t) {
                this.value = t;
            }
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator<T> trySplit() {
            java8.util.Spliterators.AbstractSpliterator.HoldingConsumer holdingConsumer = new java8.util.Spliterators.AbstractSpliterator.HoldingConsumer();
            long j = this.est;
            if (j <= 1 || !tryAdvance(holdingConsumer)) {
                return null;
            }
            int i = this.batch + 1024;
            if (i > j) {
                i = (int) j;
            }
            if (i > MAX_BATCH) {
                i = MAX_BATCH;
            }
            java.lang.Object[] objArr = new java.lang.Object[i];
            int i2 = 0;
            do {
                objArr[i2] = holdingConsumer.value;
                i2++;
                if (i2 >= i) {
                    break;
                }
            } while (tryAdvance(holdingConsumer));
            this.batch = i2;
            long j2 = this.est;
            if (j2 != Long.MAX_VALUE) {
                this.est = j2 - ((long) i2);
            }
            return new java8.util.Spliterators.ArraySpliterator(objArr, 0, i2, characteristics());
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            if ((characteristics() & 64) == 0) {
                return -1L;
            }
            return estimateSize();
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return (characteristics() & i) == i;
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super T> getComparator() {
            return java8.util.Spliterators.getComparator(this);
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
            while (tryAdvance(consumer)) {
            }
        }
    }

    public static abstract class AbstractIntSpliterator implements java8.util.Spliterator.OfInt {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;

        protected AbstractIntSpliterator(long j, int i) {
            this.est = j;
            this.characteristics = (i & 64) != 0 ? i | 16384 : i;
        }

        static final class HoldingIntConsumer implements java8.util.function.IntConsumer {
            int value;

            HoldingIntConsumer() {
            }

            @Override // java8.util.function.IntConsumer
            public void accept(int i) {
                this.value = i;
            }
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator.OfInt trySplit() {
            java8.util.Spliterators.AbstractIntSpliterator.HoldingIntConsumer holdingIntConsumer = new java8.util.Spliterators.AbstractIntSpliterator.HoldingIntConsumer();
            long j = this.est;
            if (j <= 1 || !tryAdvance((java8.util.function.IntConsumer) holdingIntConsumer)) {
                return null;
            }
            int i = this.batch + 1024;
            if (i > j) {
                i = (int) j;
            }
            if (i > MAX_BATCH) {
                i = MAX_BATCH;
            }
            int[] iArr = new int[i];
            int i2 = 0;
            do {
                iArr[i2] = holdingIntConsumer.value;
                i2++;
                if (i2 >= i) {
                    break;
                }
            } while (tryAdvance((java8.util.function.IntConsumer) holdingIntConsumer));
            this.batch = i2;
            long j2 = this.est;
            if (j2 != Long.MAX_VALUE) {
                this.est = j2 - ((long) i2);
            }
            return new java8.util.Spliterators.IntArraySpliterator(iArr, 0, i2, characteristics());
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            if ((characteristics() & 64) == 0) {
                return -1L;
            }
            return estimateSize();
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return (characteristics() & i) == i;
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Integer> getComparator() {
            return java8.util.Spliterators.getComparator(this);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
            while (tryAdvance(intConsumer)) {
            }
        }

        @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            java8.util.Spliterators.OfInt.forEachRemaining(this, consumer);
        }

        @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
        }
    }

    public static abstract class AbstractLongSpliterator implements java8.util.Spliterator.OfLong {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;

        protected AbstractLongSpliterator(long j, int i) {
            this.est = j;
            this.characteristics = (i & 64) != 0 ? i | 16384 : i;
        }

        static final class HoldingLongConsumer implements java8.util.function.LongConsumer {
            long value;

            HoldingLongConsumer() {
            }

            @Override // java8.util.function.LongConsumer
            public void accept(long j) {
                this.value = j;
            }
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator.OfLong trySplit() {
            java8.util.Spliterators.AbstractLongSpliterator.HoldingLongConsumer holdingLongConsumer = new java8.util.Spliterators.AbstractLongSpliterator.HoldingLongConsumer();
            long j = this.est;
            if (j <= 1 || !tryAdvance((java8.util.function.LongConsumer) holdingLongConsumer)) {
                return null;
            }
            int i = this.batch + 1024;
            if (i > j) {
                i = (int) j;
            }
            if (i > MAX_BATCH) {
                i = MAX_BATCH;
            }
            long[] jArr = new long[i];
            int i2 = 0;
            do {
                jArr[i2] = holdingLongConsumer.value;
                i2++;
                if (i2 >= i) {
                    break;
                }
            } while (tryAdvance((java8.util.function.LongConsumer) holdingLongConsumer));
            this.batch = i2;
            long j2 = this.est;
            if (j2 != Long.MAX_VALUE) {
                this.est = j2 - ((long) i2);
            }
            return new java8.util.Spliterators.LongArraySpliterator(jArr, 0, i2, characteristics());
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            if ((characteristics() & 64) == 0) {
                return -1L;
            }
            return estimateSize();
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return (characteristics() & i) == i;
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Long> getComparator() {
            return java8.util.Spliterators.getComparator(this);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
            while (tryAdvance(longConsumer)) {
            }
        }

        @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
        }

        @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
        }
    }

    public static abstract class AbstractDoubleSpliterator implements java8.util.Spliterator.OfDouble {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;

        protected AbstractDoubleSpliterator(long j, int i) {
            this.est = j;
            this.characteristics = (i & 64) != 0 ? i | 16384 : i;
        }

        static final class HoldingDoubleConsumer implements java8.util.function.DoubleConsumer {
            double value;

            HoldingDoubleConsumer() {
            }

            @Override // java8.util.function.DoubleConsumer
            public void accept(double d) {
                this.value = d;
            }
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator.OfDouble trySplit() {
            java8.util.Spliterators.AbstractDoubleSpliterator.HoldingDoubleConsumer holdingDoubleConsumer = new java8.util.Spliterators.AbstractDoubleSpliterator.HoldingDoubleConsumer();
            long j = this.est;
            if (j <= 1 || !tryAdvance((java8.util.function.DoubleConsumer) holdingDoubleConsumer)) {
                return null;
            }
            int i = this.batch + 1024;
            if (i > j) {
                i = (int) j;
            }
            if (i > MAX_BATCH) {
                i = MAX_BATCH;
            }
            double[] dArr = new double[i];
            int i2 = 0;
            do {
                dArr[i2] = holdingDoubleConsumer.value;
                i2++;
                if (i2 >= i) {
                    break;
                }
            } while (tryAdvance((java8.util.function.DoubleConsumer) holdingDoubleConsumer));
            this.batch = i2;
            long j2 = this.est;
            if (j2 != Long.MAX_VALUE) {
                this.est = j2 - ((long) i2);
            }
            return new java8.util.Spliterators.DoubleArraySpliterator(dArr, 0, i2, characteristics());
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            if ((characteristics() & 64) == 0) {
                return -1L;
            }
            return estimateSize();
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return (characteristics() & i) == i;
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Double> getComparator() {
            return java8.util.Spliterators.getComparator(this);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
            while (tryAdvance(doubleConsumer)) {
            }
        }

        @Override // java8.util.Spliterator.OfDouble, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
        }

        @Override // java8.util.Spliterator.OfDouble, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
        }
    }

    static class IteratorSpliterator<T> implements java8.util.Spliterator<T> {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private final java.util.Collection<? extends T> collection;
        private long est;
        private java.util.Iterator<? extends T> it;

        public IteratorSpliterator(java.util.Collection<? extends T> collection, int i) {
            this.collection = collection;
            this.it = null;
            this.characteristics = (i & 4096) == 0 ? i | 16448 : i;
        }

        public IteratorSpliterator(java.util.Iterator<? extends T> it, long j, int i) {
            this.collection = null;
            this.it = it;
            this.est = j;
            this.characteristics = (i & 4096) == 0 ? i | 16448 : i;
        }

        public IteratorSpliterator(java.util.Iterator<? extends T> it, int i) {
            this.collection = null;
            this.it = it;
            this.est = Long.MAX_VALUE;
            this.characteristics = i & (-16449);
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator<T> trySplit() {
            long size;
            java.util.Iterator<? extends T> it = this.it;
            if (it == null) {
                it = this.collection.iterator();
                this.it = it;
                size = this.collection.size();
                this.est = size;
            } else {
                size = this.est;
            }
            if (size <= 1 || !it.hasNext()) {
                return null;
            }
            int i = this.batch + 1024;
            if (i > size) {
                i = (int) size;
            }
            if (i > MAX_BATCH) {
                i = MAX_BATCH;
            }
            java.lang.Object[] objArr = new java.lang.Object[i];
            int i2 = 0;
            do {
                objArr[i2] = it.next();
                i2++;
                if (i2 >= i) {
                    break;
                }
            } while (it.hasNext());
            this.batch = i2;
            long j = this.est;
            if (j != Long.MAX_VALUE) {
                this.est = j - ((long) i2);
            }
            return new java8.util.Spliterators.ArraySpliterator(objArr, 0, i2, this.characteristics);
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            java.util.Iterator<? extends T> it = this.it;
            if (it == null) {
                it = this.collection.iterator();
                this.it = it;
                this.est = this.collection.size();
            }
            java8.util.Iterators.forEachRemaining(it, consumer);
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            if (this.it == null) {
                this.it = this.collection.iterator();
                this.est = this.collection.size();
            }
            if (!this.it.hasNext()) {
                return false;
            }
            consumer.accept(this.it.next());
            return true;
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            if (this.it == null) {
                this.it = this.collection.iterator();
                long size = this.collection.size();
                this.est = size;
                return size;
            }
            return this.est;
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown(this);
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super T> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    static final class IntIteratorSpliterator implements java8.util.Spliterator.OfInt {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;
        private java8.util.PrimitiveIterator.OfInt it;

        public IntIteratorSpliterator(java8.util.PrimitiveIterator.OfInt ofInt, long j, int i) {
            this.it = ofInt;
            this.est = j;
            this.characteristics = (i & 4096) == 0 ? i | 16448 : i;
        }

        public IntIteratorSpliterator(java8.util.PrimitiveIterator.OfInt ofInt, int i) {
            this.it = ofInt;
            this.est = Long.MAX_VALUE;
            this.characteristics = i & (-16449);
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator.OfInt trySplit() {
            java8.util.PrimitiveIterator.OfInt ofInt = this.it;
            long j = this.est;
            if (j <= 1 || !ofInt.hasNext()) {
                return null;
            }
            int i = this.batch + 1024;
            if (i > j) {
                i = (int) j;
            }
            if (i > MAX_BATCH) {
                i = MAX_BATCH;
            }
            int[] iArr = new int[i];
            int i2 = 0;
            do {
                iArr[i2] = ofInt.nextInt();
                i2++;
                if (i2 >= i) {
                    break;
                }
            } while (ofInt.hasNext());
            this.batch = i2;
            long j2 = this.est;
            if (j2 != Long.MAX_VALUE) {
                this.est = j2 - ((long) i2);
            }
            return new java8.util.Spliterators.IntArraySpliterator(iArr, 0, i2, this.characteristics);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
            java8.util.Iterators.forEachRemaining(this.it, (java8.util.function.IntConsumer) java8.util.Objects.requireNonNull(intConsumer));
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
            java8.util.Objects.requireNonNull(intConsumer);
            if (!this.it.hasNext()) {
                return false;
            }
            intConsumer.accept(this.it.nextInt());
            return true;
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown(this);
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Integer> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new java.lang.IllegalStateException();
        }

        @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            java8.util.Spliterators.OfInt.forEachRemaining(this, consumer);
        }
    }

    static final class LongIteratorSpliterator implements java8.util.Spliterator.OfLong {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;
        private java8.util.PrimitiveIterator.OfLong it;

        public LongIteratorSpliterator(java8.util.PrimitiveIterator.OfLong ofLong, long j, int i) {
            this.it = ofLong;
            this.est = j;
            this.characteristics = (i & 4096) == 0 ? i | 16448 : i;
        }

        public LongIteratorSpliterator(java8.util.PrimitiveIterator.OfLong ofLong, int i) {
            this.it = ofLong;
            this.est = Long.MAX_VALUE;
            this.characteristics = i & (-16449);
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator.OfLong trySplit() {
            java8.util.PrimitiveIterator.OfLong ofLong = this.it;
            long j = this.est;
            if (j <= 1 || !ofLong.hasNext()) {
                return null;
            }
            int i = this.batch + 1024;
            if (i > j) {
                i = (int) j;
            }
            if (i > MAX_BATCH) {
                i = MAX_BATCH;
            }
            long[] jArr = new long[i];
            int i2 = 0;
            do {
                jArr[i2] = ofLong.nextLong();
                i2++;
                if (i2 >= i) {
                    break;
                }
            } while (ofLong.hasNext());
            this.batch = i2;
            long j2 = this.est;
            if (j2 != Long.MAX_VALUE) {
                this.est = j2 - ((long) i2);
            }
            return new java8.util.Spliterators.LongArraySpliterator(jArr, 0, i2, this.characteristics);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
            java8.util.Iterators.forEachRemaining(this.it, (java8.util.function.LongConsumer) java8.util.Objects.requireNonNull(longConsumer));
        }

        @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
            java8.util.Objects.requireNonNull(longConsumer);
            if (!this.it.hasNext()) {
                return false;
            }
            longConsumer.accept(this.it.nextLong());
            return true;
        }

        @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown(this);
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Long> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    static final class DoubleIteratorSpliterator implements java8.util.Spliterator.OfDouble {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;
        private java8.util.PrimitiveIterator.OfDouble it;

        public DoubleIteratorSpliterator(java8.util.PrimitiveIterator.OfDouble ofDouble, long j, int i) {
            this.it = ofDouble;
            this.est = j;
            this.characteristics = (i & 4096) == 0 ? i | 16448 : i;
        }

        public DoubleIteratorSpliterator(java8.util.PrimitiveIterator.OfDouble ofDouble, int i) {
            this.it = ofDouble;
            this.est = Long.MAX_VALUE;
            this.characteristics = i & (-16449);
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator.OfDouble trySplit() {
            java8.util.PrimitiveIterator.OfDouble ofDouble = this.it;
            long j = this.est;
            if (j <= 1 || !ofDouble.hasNext()) {
                return null;
            }
            int i = this.batch + 1024;
            if (i > j) {
                i = (int) j;
            }
            if (i > MAX_BATCH) {
                i = MAX_BATCH;
            }
            double[] dArr = new double[i];
            int i2 = 0;
            do {
                dArr[i2] = ofDouble.nextDouble();
                i2++;
                if (i2 >= i) {
                    break;
                }
            } while (ofDouble.hasNext());
            this.batch = i2;
            long j2 = this.est;
            if (j2 != Long.MAX_VALUE) {
                this.est = j2 - ((long) i2);
            }
            return new java8.util.Spliterators.DoubleArraySpliterator(dArr, 0, i2, this.characteristics);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
            java8.util.Iterators.forEachRemaining(this.it, (java8.util.function.DoubleConsumer) java8.util.Objects.requireNonNull(doubleConsumer));
        }

        @Override // java8.util.Spliterator.OfDouble, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
            java8.util.Objects.requireNonNull(doubleConsumer);
            if (!this.it.hasNext()) {
                return false;
            }
            doubleConsumer.accept(this.it.nextDouble());
            return true;
        }

        @Override // java8.util.Spliterator.OfDouble, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown(this);
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Double> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    private static boolean getBooleanPropVal(final java.lang.String str, final boolean z) {
        return ((java.lang.Boolean) java.security.AccessController.doPrivileged(new java.security.PrivilegedAction<java.lang.Boolean>() { // from class: java8.util.Spliterators.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public java.lang.Boolean run() {
                boolean z2 = z;
                try {
                    z2 = java.lang.Boolean.parseBoolean(java.lang.System.getProperty(str, java.lang.Boolean.toString(z2)).trim());
                } catch (java.lang.IllegalArgumentException | java.lang.NullPointerException unused) {
                }
                return java.lang.Boolean.valueOf(z2);
            }
        })).booleanValue();
    }

    private static boolean isClassPresent(java.lang.String str) {
        java.lang.Class<?> cls;
        try {
            cls = java.lang.Class.forName(str, false, java8.util.Spliterators.class.getClassLoader());
        } catch (java.lang.Throwable unused) {
            cls = null;
        }
        return cls != null;
    }

    private static boolean isJava6() {
        return isVersionBelow("java.class.version", 51.0d);
    }

    private static boolean isRoboVm() {
        return isClassPresent("org.robovm.rt.bro.Bro");
    }

    private static boolean isAndroid() {
        return isClassPresent("android.util.DisplayMetrics") || IS_ROBOVM;
    }

    private static boolean isStreamEnabled() {
        if (!isAndroid() && isVersionBelow("java.class.version", 52.0d)) {
            return false;
        }
        java.lang.String[] strArr = {"java.util.function.Consumer", "java.util.Spliterator"};
        java.lang.reflect.Method declaredMethod = null;
        java.lang.Class<?> cls = null;
        for (int i = 0; i < 2; i++) {
            try {
                cls = java.lang.Class.forName(strArr[i]);
            } catch (java.lang.Exception unused) {
                return false;
            }
        }
        if (cls != null) {
            try {
                declaredMethod = java.util.Collection.class.getDeclaredMethod("spliterator", null);
            } catch (java.lang.Exception unused2) {
                return false;
            }
        }
        return declaredMethod != null;
    }

    private static boolean isVersionBelow(java.lang.String str, double d) {
        try {
            java.lang.String property = java.lang.System.getProperty(str);
            if (property != null) {
                return java.lang.Double.parseDouble(property) < d;
            }
            return false;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private static boolean isFromJdk(java.lang.String str) {
        return str.startsWith("java.util.Collections$", 0) && str.endsWith("RandomAccessList");
    }

    private static boolean hasAndroid7LHMBug(java.util.Collection<?> collection) {
        if (!IS_ANDROID || IS_HARMONY_ANDROID || IS_ANDROID_O || !collection.getClass().getName().startsWith("java.util.HashMap$")) {
            return false;
        }
        return collection.spliterator().hasCharacteristics(16);
    }
}
