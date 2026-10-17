package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class Streams {
    private Streams() {
        throw new java.lang.Error("no instances");
    }

    static final class RangeIntSpliterator implements java8.util.Spliterator.OfInt {
        private static final int BALANCED_SPLIT_THRESHOLD = 16777216;
        private static final int RIGHT_BALANCED_SPLIT_RATIO = 8;
        private int from;
        private int last;
        private final int upTo;

        @Override // java8.util.Spliterator
        public int characteristics() {
            return 17749;
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Integer> getComparator() {
            return null;
        }

        RangeIntSpliterator(int i, int i2, boolean z) {
            this(i, i2, z ? 1 : 0);
        }

        private RangeIntSpliterator(int i, int i2, int i3) {
            this.from = i;
            this.upTo = i2;
            this.last = i3;
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
            java8.util.Objects.requireNonNull(intConsumer);
            int i = this.from;
            if (i < this.upTo) {
                this.from = i + 1;
                intConsumer.accept(i);
                return true;
            }
            if (this.last <= 0) {
                return false;
            }
            this.last = 0;
            intConsumer.accept(i);
            return true;
        }

        @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
            java8.util.Objects.requireNonNull(intConsumer);
            int i = this.from;
            int i2 = this.upTo;
            int i3 = this.last;
            this.from = i2;
            this.last = 0;
            while (i < i2) {
                intConsumer.accept(i);
                i++;
            }
            if (i3 > 0) {
                intConsumer.accept(i);
            }
        }

        @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            java8.util.Spliterators.OfInt.forEachRemaining(this, consumer);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return (((long) this.upTo) - ((long) this.from)) + ((long) this.last);
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
        public java8.util.Spliterator.OfInt trySplit() {
            long jEstimateSize = estimateSize();
            if (jEstimateSize <= 1) {
                return null;
            }
            int i = this.from;
            int iSplitPoint = splitPoint(jEstimateSize) + i;
            this.from = iSplitPoint;
            return new java8.util.stream.Streams.RangeIntSpliterator(i, iSplitPoint, 0);
        }

        private int splitPoint(long j) {
            return (int) (j / ((long) (j < 16777216 ? 2 : 8)));
        }
    }

    static final class RangeLongSpliterator implements java8.util.Spliterator.OfLong {
        private static final long BALANCED_SPLIT_THRESHOLD = 16777216;
        private static final long RIGHT_BALANCED_SPLIT_RATIO = 8;
        private long from;
        private int last;
        private final long upTo;

        @Override // java8.util.Spliterator
        public int characteristics() {
            return 17749;
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Long> getComparator() {
            return null;
        }

        RangeLongSpliterator(long j, long j2, boolean z) {
            this(j, j2, z ? 1 : 0);
        }

        private RangeLongSpliterator(long j, long j2, int i) {
            this.from = j;
            this.upTo = j2;
            this.last = i;
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
            java8.util.Objects.requireNonNull(longConsumer);
            long j = this.from;
            if (j < this.upTo) {
                this.from = 1 + j;
                longConsumer.accept(j);
                return true;
            }
            if (this.last <= 0) {
                return false;
            }
            this.last = 0;
            longConsumer.accept(j);
            return true;
        }

        @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
            java8.util.Objects.requireNonNull(longConsumer);
            long j = this.from;
            long j2 = this.upTo;
            int i = this.last;
            this.from = j2;
            this.last = 0;
            while (j < j2) {
                longConsumer.accept(j);
                j = 1 + j;
            }
            if (i > 0) {
                longConsumer.accept(j);
            }
        }

        @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return (this.upTo - this.from) + ((long) this.last);
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
        public java8.util.Spliterator.OfLong trySplit() {
            long jEstimateSize = estimateSize();
            if (jEstimateSize <= 1) {
                return null;
            }
            long j = this.from;
            long jSplitPoint = j + splitPoint(jEstimateSize);
            this.from = jSplitPoint;
            return new java8.util.stream.Streams.RangeLongSpliterator(j, jSplitPoint, 0);
        }

        private long splitPoint(long j) {
            return j / (j < BALANCED_SPLIT_THRESHOLD ? 2L : 8L);
        }
    }

    private static abstract class AbstractStreamBuilderImpl<T, S extends java8.util.Spliterator<T>> implements java8.util.Spliterator<T> {
        int count;

        @Override // java8.util.Spliterator
        public int characteristics() {
            return 17488;
        }

        @Override // java8.util.Spliterator
        public S trySplit() {
            return null;
        }

        private AbstractStreamBuilderImpl() {
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return (-this.count) - 1;
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
            return java8.util.Spliterators.getComparator(this);
        }
    }

    static final class StreamBuilderImpl<T> extends java8.util.stream.Streams.AbstractStreamBuilderImpl<T, java8.util.Spliterator<T>> implements java8.util.stream.Stream.Builder<T> {
        java8.util.stream.SpinedBuffer<T> buffer;
        T first;

        StreamBuilderImpl() {
            super();
        }

        StreamBuilderImpl(T t) {
            super();
            this.first = t;
            this.count = -2;
        }

        @Override // java8.util.stream.Stream.Builder, java8.util.function.Consumer
        public void accept(T t) {
            if (this.count == 0) {
                this.first = t;
                this.count++;
            } else {
                if (this.count > 0) {
                    if (this.buffer == null) {
                        java8.util.stream.SpinedBuffer<T> spinedBuffer = new java8.util.stream.SpinedBuffer<>();
                        this.buffer = spinedBuffer;
                        spinedBuffer.accept(this.first);
                        this.count++;
                    }
                    this.buffer.accept(t);
                    return;
                }
                throw new java.lang.IllegalStateException();
            }
        }

        @Override // java8.util.stream.Stream.Builder
        public java8.util.stream.Stream.Builder<T> add(T t) {
            accept(t);
            return this;
        }

        @Override // java8.util.stream.Stream.Builder
        public java8.util.stream.Stream<T> build() {
            int i = this.count;
            if (i >= 0) {
                this.count = (-this.count) - 1;
                return i < 2 ? java8.util.stream.StreamSupport.stream((java8.util.Spliterator) this, false) : java8.util.stream.StreamSupport.stream((java8.util.Spliterator) this.buffer.spliterator(), false);
            }
            throw new java.lang.IllegalStateException();
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            if (this.count != -2) {
                return false;
            }
            consumer.accept(this.first);
            this.count = -1;
            return true;
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            if (this.count == -2) {
                consumer.accept(this.first);
                this.count = -1;
            }
        }
    }

    static final class IntStreamBuilderImpl extends java8.util.stream.Streams.AbstractStreamBuilderImpl<java.lang.Integer, java8.util.Spliterator.OfInt> implements java8.util.stream.IntStream.Builder, java8.util.Spliterator.OfInt {
        java8.util.stream.SpinedBuffer.OfInt buffer;
        int first;

        @Override // java8.util.stream.Streams.AbstractStreamBuilderImpl, java8.util.Spliterator
        public /* bridge */ /* synthetic */ java8.util.Spliterator.OfInt trySplit() {
            return (java8.util.Spliterator.OfInt) super.trySplit();
        }

        @Override // java8.util.stream.Streams.AbstractStreamBuilderImpl, java8.util.Spliterator
        public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
            return (java8.util.Spliterator.OfPrimitive) super.trySplit();
        }

        IntStreamBuilderImpl() {
            super();
        }

        IntStreamBuilderImpl(int i) {
            super();
            this.first = i;
            this.count = -2;
        }

        @Override // java8.util.stream.IntStream.Builder, java8.util.function.IntConsumer
        public void accept(int i) {
            if (this.count == 0) {
                this.first = i;
                this.count++;
            } else {
                if (this.count > 0) {
                    if (this.buffer == null) {
                        java8.util.stream.SpinedBuffer.OfInt ofInt = new java8.util.stream.SpinedBuffer.OfInt();
                        this.buffer = ofInt;
                        ofInt.accept(this.first);
                        this.count++;
                    }
                    this.buffer.accept(i);
                    return;
                }
                throw new java.lang.IllegalStateException();
            }
        }

        @Override // java8.util.stream.IntStream.Builder
        public java8.util.stream.IntStream.Builder add(int i) {
            accept(i);
            return this;
        }

        @Override // java8.util.stream.IntStream.Builder
        public java8.util.stream.IntStream build() {
            int i = this.count;
            if (i >= 0) {
                this.count = (-this.count) - 1;
                return i < 2 ? java8.util.stream.StreamSupport.intStream(this, false) : java8.util.stream.StreamSupport.intStream(this.buffer.spliterator(), false);
            }
            throw new java.lang.IllegalStateException();
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
            java8.util.Objects.requireNonNull(intConsumer);
            if (this.count != -2) {
                return false;
            }
            intConsumer.accept(this.first);
            this.count = -1;
            return true;
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
            java8.util.Objects.requireNonNull(intConsumer);
            if (this.count == -2) {
                intConsumer.accept(this.first);
                this.count = -1;
            }
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            java8.util.Spliterators.OfInt.forEachRemaining(this, consumer);
        }
    }

    static final class LongStreamBuilderImpl extends java8.util.stream.Streams.AbstractStreamBuilderImpl<java.lang.Long, java8.util.Spliterator.OfLong> implements java8.util.stream.LongStream.Builder, java8.util.Spliterator.OfLong {
        java8.util.stream.SpinedBuffer.OfLong buffer;
        long first;

        @Override // java8.util.stream.Streams.AbstractStreamBuilderImpl, java8.util.Spliterator
        public /* bridge */ /* synthetic */ java8.util.Spliterator.OfLong trySplit() {
            return (java8.util.Spliterator.OfLong) super.trySplit();
        }

        @Override // java8.util.stream.Streams.AbstractStreamBuilderImpl, java8.util.Spliterator
        public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
            return (java8.util.Spliterator.OfPrimitive) super.trySplit();
        }

        LongStreamBuilderImpl() {
            super();
        }

        LongStreamBuilderImpl(long j) {
            super();
            this.first = j;
            this.count = -2;
        }

        @Override // java8.util.stream.LongStream.Builder, java8.util.function.LongConsumer
        public void accept(long j) {
            if (this.count == 0) {
                this.first = j;
                this.count++;
            } else {
                if (this.count > 0) {
                    if (this.buffer == null) {
                        java8.util.stream.SpinedBuffer.OfLong ofLong = new java8.util.stream.SpinedBuffer.OfLong();
                        this.buffer = ofLong;
                        ofLong.accept(this.first);
                        this.count++;
                    }
                    this.buffer.accept(j);
                    return;
                }
                throw new java.lang.IllegalStateException();
            }
        }

        @Override // java8.util.stream.LongStream.Builder
        public java8.util.stream.LongStream.Builder add(long j) {
            accept(j);
            return this;
        }

        @Override // java8.util.stream.LongStream.Builder
        public java8.util.stream.LongStream build() {
            int i = this.count;
            if (i >= 0) {
                this.count = (-this.count) - 1;
                return i < 2 ? java8.util.stream.StreamSupport.longStream(this, false) : java8.util.stream.StreamSupport.longStream(this.buffer.spliterator(), false);
            }
            throw new java.lang.IllegalStateException();
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
            java8.util.Objects.requireNonNull(longConsumer);
            if (this.count != -2) {
                return false;
            }
            longConsumer.accept(this.first);
            this.count = -1;
            return true;
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
            java8.util.Objects.requireNonNull(longConsumer);
            if (this.count == -2) {
                longConsumer.accept(this.first);
                this.count = -1;
            }
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
        }
    }

    static final class DoubleStreamBuilderImpl extends java8.util.stream.Streams.AbstractStreamBuilderImpl<java.lang.Double, java8.util.Spliterator.OfDouble> implements java8.util.stream.DoubleStream.Builder, java8.util.Spliterator.OfDouble {
        java8.util.stream.SpinedBuffer.OfDouble buffer;
        double first;

        @Override // java8.util.stream.Streams.AbstractStreamBuilderImpl, java8.util.Spliterator
        public /* bridge */ /* synthetic */ java8.util.Spliterator.OfDouble trySplit() {
            return (java8.util.Spliterator.OfDouble) super.trySplit();
        }

        @Override // java8.util.stream.Streams.AbstractStreamBuilderImpl, java8.util.Spliterator
        public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
            return (java8.util.Spliterator.OfPrimitive) super.trySplit();
        }

        DoubleStreamBuilderImpl() {
            super();
        }

        DoubleStreamBuilderImpl(double d) {
            super();
            this.first = d;
            this.count = -2;
        }

        @Override // java8.util.stream.DoubleStream.Builder, java8.util.function.DoubleConsumer
        public void accept(double d) {
            if (this.count == 0) {
                this.first = d;
                this.count++;
            } else {
                if (this.count > 0) {
                    if (this.buffer == null) {
                        java8.util.stream.SpinedBuffer.OfDouble ofDouble = new java8.util.stream.SpinedBuffer.OfDouble();
                        this.buffer = ofDouble;
                        ofDouble.accept(this.first);
                        this.count++;
                    }
                    this.buffer.accept(d);
                    return;
                }
                throw new java.lang.IllegalStateException();
            }
        }

        @Override // java8.util.stream.DoubleStream.Builder
        public java8.util.stream.DoubleStream.Builder add(double d) {
            accept(d);
            return this;
        }

        @Override // java8.util.stream.DoubleStream.Builder
        public java8.util.stream.DoubleStream build() {
            int i = this.count;
            if (i >= 0) {
                this.count = (-this.count) - 1;
                return i < 2 ? java8.util.stream.StreamSupport.doubleStream(this, false) : java8.util.stream.StreamSupport.doubleStream(this.buffer.spliterator(), false);
            }
            throw new java.lang.IllegalStateException();
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
            java8.util.Objects.requireNonNull(doubleConsumer);
            if (this.count != -2) {
                return false;
            }
            doubleConsumer.accept(this.first);
            this.count = -1;
            return true;
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
            java8.util.Objects.requireNonNull(doubleConsumer);
            if (this.count == -2) {
                doubleConsumer.accept(this.first);
                this.count = -1;
            }
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
        }
    }

    static abstract class ConcatSpliterator<T, T_SPLITR extends java8.util.Spliterator<T>> implements java8.util.Spliterator<T> {
        protected final T_SPLITR aSpliterator;
        protected final T_SPLITR bSpliterator;
        boolean beforeSplit = true;
        final boolean unsized;

        public ConcatSpliterator(T_SPLITR t_splitr, T_SPLITR t_splitr2) {
            this.aSpliterator = t_splitr;
            this.bSpliterator = t_splitr2;
            this.unsized = t_splitr.estimateSize() + t_splitr2.estimateSize() < 0;
        }

        @Override // java8.util.Spliterator
        public T_SPLITR trySplit() {
            T_SPLITR t_splitr = this.beforeSplit ? this.aSpliterator : (T_SPLITR) this.bSpliterator.trySplit();
            this.beforeSplit = false;
            return t_splitr;
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
            if (this.beforeSplit) {
                boolean zTryAdvance = this.aSpliterator.tryAdvance(consumer);
                if (zTryAdvance) {
                    return zTryAdvance;
                }
                this.beforeSplit = false;
                return this.bSpliterator.tryAdvance(consumer);
            }
            return this.bSpliterator.tryAdvance(consumer);
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
            if (this.beforeSplit) {
                this.aSpliterator.forEachRemaining(consumer);
            }
            this.bSpliterator.forEachRemaining(consumer);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            if (this.beforeSplit) {
                long jEstimateSize = this.aSpliterator.estimateSize() + this.bSpliterator.estimateSize();
                if (jEstimateSize >= 0) {
                    return jEstimateSize;
                }
                return Long.MAX_VALUE;
            }
            return this.bSpliterator.estimateSize();
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            if (this.beforeSplit) {
                return this.aSpliterator.characteristics() & this.bSpliterator.characteristics() & (~((this.unsized ? 16448 : 0) | 5));
            }
            return this.bSpliterator.characteristics();
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super T> getComparator() {
            if (this.beforeSplit) {
                throw new java.lang.IllegalStateException();
            }
            return this.bSpliterator.getComparator();
        }

        static class OfRef<T> extends java8.util.stream.Streams.ConcatSpliterator<T, java8.util.Spliterator<T>> {
            OfRef(java8.util.Spliterator<T> spliterator, java8.util.Spliterator<T> spliterator2) {
                super(spliterator, spliterator2);
            }

            @Override // java8.util.Spliterator
            public long getExactSizeIfKnown() {
                return java8.util.Spliterators.getExactSizeIfKnown(this);
            }

            @Override // java8.util.Spliterator
            public boolean hasCharacteristics(int i) {
                return java8.util.Spliterators.hasCharacteristics(this, i);
            }
        }

        private static abstract class OfPrimitive<T, T_CONS, T_SPLITR extends java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends java8.util.stream.Streams.ConcatSpliterator<T, T_SPLITR> implements java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            @Override // java8.util.stream.Streams.ConcatSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                return (java8.util.Spliterator.OfPrimitive) super.trySplit();
            }

            private OfPrimitive(T_SPLITR t_splitr, T_SPLITR t_splitr2) {
                super(t_splitr, t_splitr2);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS t_cons) {
                if (this.beforeSplit) {
                    boolean zTryAdvance = ((java8.util.Spliterator.OfPrimitive) this.aSpliterator).tryAdvance(t_cons);
                    if (zTryAdvance) {
                        return zTryAdvance;
                    }
                    this.beforeSplit = false;
                    return ((java8.util.Spliterator.OfPrimitive) this.bSpliterator).tryAdvance(t_cons);
                }
                return ((java8.util.Spliterator.OfPrimitive) this.bSpliterator).tryAdvance(t_cons);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS t_cons) {
                if (this.beforeSplit) {
                    ((java8.util.Spliterator.OfPrimitive) this.aSpliterator).forEachRemaining(t_cons);
                }
                ((java8.util.Spliterator.OfPrimitive) this.bSpliterator).forEachRemaining(t_cons);
            }

            @Override // java8.util.Spliterator
            public long getExactSizeIfKnown() {
                return java8.util.Spliterators.getExactSizeIfKnown(this);
            }

            @Override // java8.util.Spliterator
            public boolean hasCharacteristics(int i) {
                return java8.util.Spliterators.hasCharacteristics(this, i);
            }
        }

        static class OfInt extends java8.util.stream.Streams.ConcatSpliterator.OfPrimitive<java.lang.Integer, java8.util.function.IntConsumer, java8.util.Spliterator.OfInt> implements java8.util.Spliterator.OfInt {
            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
                super.forEachRemaining(intConsumer);
            }

            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
                return super.tryAdvance(intConsumer);
            }

            @Override // java8.util.stream.Streams.ConcatSpliterator.OfPrimitive, java8.util.stream.Streams.ConcatSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfInt trySplit() {
                return (java8.util.Spliterator.OfInt) super.trySplit();
            }

            OfInt(java8.util.Spliterator.OfInt ofInt, java8.util.Spliterator.OfInt ofInt2) {
                super(ofInt, ofInt2);
            }
        }

        static class OfLong extends java8.util.stream.Streams.ConcatSpliterator.OfPrimitive<java.lang.Long, java8.util.function.LongConsumer, java8.util.Spliterator.OfLong> implements java8.util.Spliterator.OfLong {
            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
                super.forEachRemaining(longConsumer);
            }

            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
                return super.tryAdvance(longConsumer);
            }

            @Override // java8.util.stream.Streams.ConcatSpliterator.OfPrimitive, java8.util.stream.Streams.ConcatSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfLong trySplit() {
                return (java8.util.Spliterator.OfLong) super.trySplit();
            }

            OfLong(java8.util.Spliterator.OfLong ofLong, java8.util.Spliterator.OfLong ofLong2) {
                super(ofLong, ofLong2);
            }
        }

        static class OfDouble extends java8.util.stream.Streams.ConcatSpliterator.OfPrimitive<java.lang.Double, java8.util.function.DoubleConsumer, java8.util.Spliterator.OfDouble> implements java8.util.Spliterator.OfDouble {
            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
                super.forEachRemaining(doubleConsumer);
            }

            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
                return super.tryAdvance(doubleConsumer);
            }

            @Override // java8.util.stream.Streams.ConcatSpliterator.OfPrimitive, java8.util.stream.Streams.ConcatSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfDouble trySplit() {
                return (java8.util.Spliterator.OfDouble) super.trySplit();
            }

            OfDouble(java8.util.Spliterator.OfDouble ofDouble, java8.util.Spliterator.OfDouble ofDouble2) {
                super(ofDouble, ofDouble2);
            }
        }
    }

    static java.lang.Runnable composeWithExceptions(final java.lang.Runnable runnable, final java.lang.Runnable runnable2) {
        return new java.lang.Runnable() { // from class: java8.util.stream.Streams.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                    runnable2.run();
                } catch (java.lang.Throwable th) {
                    try {
                        runnable2.run();
                    } catch (java.lang.Throwable unused) {
                    }
                    if (th instanceof java.lang.RuntimeException) {
                        throw ((java.lang.RuntimeException) th);
                    }
                    if (th instanceof java.lang.Error) {
                        throw ((java.lang.Error) th);
                    }
                    throw new java.lang.IllegalStateException(th);
                }
            }
        };
    }

    static java.lang.Runnable composedClose(final java8.util.stream.BaseStream<?, ?> baseStream, final java8.util.stream.BaseStream<?, ?> baseStream2) {
        return new java.lang.Runnable() { // from class: java8.util.stream.Streams.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    baseStream.close();
                    baseStream2.close();
                } catch (java.lang.Throwable th) {
                    try {
                        baseStream2.close();
                    } catch (java.lang.Throwable unused) {
                    }
                    if (th instanceof java.lang.RuntimeException) {
                        throw ((java.lang.RuntimeException) th);
                    }
                    if (th instanceof java.lang.Error) {
                        throw ((java.lang.Error) th);
                    }
                    throw new java.lang.IllegalStateException(th);
                }
            }
        };
    }
}
