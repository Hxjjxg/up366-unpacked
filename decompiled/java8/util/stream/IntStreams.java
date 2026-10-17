package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class IntStreams {
    /* JADX WARN: Type inference failed for: r1v0, types: [java8.util.Spliterator$OfInt] */
    public static java8.util.stream.IntStream takeWhile(java8.util.stream.IntStream intStream, java8.util.function.IntPredicate intPredicate) {
        java8.util.Objects.requireNonNull(intStream);
        java8.util.Objects.requireNonNull(intPredicate);
        return java8.util.stream.StreamSupport.intStream(new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt.Taking(intStream.spliterator2(), true, intPredicate), intStream.isParallel()).onClose(java8.util.stream.StreamSupport.closeHandler(intStream));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java8.util.Spliterator$OfInt] */
    public static java8.util.stream.IntStream dropWhile(java8.util.stream.IntStream intStream, java8.util.function.IntPredicate intPredicate) {
        java8.util.Objects.requireNonNull(intStream);
        java8.util.Objects.requireNonNull(intPredicate);
        return java8.util.stream.StreamSupport.intStream(new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt.Dropping(intStream.spliterator2(), true, intPredicate), intStream.isParallel()).onClose(java8.util.stream.StreamSupport.closeHandler(intStream));
    }

    public static java8.util.stream.IntStream.Builder builder() {
        return new java8.util.stream.Streams.IntStreamBuilderImpl();
    }

    public static java8.util.stream.IntStream empty() {
        return java8.util.stream.StreamSupport.intStream(java8.util.Spliterators.emptyIntSpliterator(), false);
    }

    public static java8.util.stream.IntStream of(int i) {
        return java8.util.stream.StreamSupport.intStream(new java8.util.stream.Streams.IntStreamBuilderImpl(i), false);
    }

    public static java8.util.stream.IntStream of(int... iArr) {
        return java8.util.J8Arrays.stream(iArr);
    }

    public static java8.util.stream.IntStream iterate(final int i, final java8.util.function.IntUnaryOperator intUnaryOperator) {
        java8.util.Objects.requireNonNull(intUnaryOperator);
        return java8.util.stream.StreamSupport.intStream(new java8.util.Spliterators.AbstractIntSpliterator(Long.MAX_VALUE, 1296) { // from class: java8.util.stream.IntStreams.1
            int prev;
            boolean started;

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
                int iApplyAsInt;
                java8.util.Objects.requireNonNull(intConsumer);
                if (this.started) {
                    iApplyAsInt = intUnaryOperator.applyAsInt(this.prev);
                } else {
                    iApplyAsInt = i;
                    this.started = true;
                }
                this.prev = iApplyAsInt;
                intConsumer.accept(iApplyAsInt);
                return true;
            }
        }, false);
    }

    public static java8.util.stream.IntStream iterate(final int i, final java8.util.function.IntPredicate intPredicate, final java8.util.function.IntUnaryOperator intUnaryOperator) {
        java8.util.Objects.requireNonNull(intUnaryOperator);
        java8.util.Objects.requireNonNull(intPredicate);
        return java8.util.stream.StreamSupport.intStream(new java8.util.Spliterators.AbstractIntSpliterator(Long.MAX_VALUE, 1296) { // from class: java8.util.stream.IntStreams.2
            boolean finished;
            int prev;
            boolean started;

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
                int iApplyAsInt;
                java8.util.Objects.requireNonNull(intConsumer);
                if (this.finished) {
                    return false;
                }
                if (this.started) {
                    iApplyAsInt = intUnaryOperator.applyAsInt(this.prev);
                } else {
                    iApplyAsInt = i;
                    this.started = true;
                }
                if (!intPredicate.test(iApplyAsInt)) {
                    this.finished = true;
                    return false;
                }
                this.prev = iApplyAsInt;
                intConsumer.accept(iApplyAsInt);
                return true;
            }

            @Override // java8.util.Spliterators.AbstractIntSpliterator, java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
                java8.util.Objects.requireNonNull(intConsumer);
                if (this.finished) {
                    return;
                }
                this.finished = true;
                int iApplyAsInt = this.started ? intUnaryOperator.applyAsInt(this.prev) : i;
                while (intPredicate.test(iApplyAsInt)) {
                    intConsumer.accept(iApplyAsInt);
                    iApplyAsInt = intUnaryOperator.applyAsInt(iApplyAsInt);
                }
            }
        }, false);
    }

    public static java8.util.stream.IntStream generate(java8.util.function.IntSupplier intSupplier) {
        java8.util.Objects.requireNonNull(intSupplier);
        return java8.util.stream.StreamSupport.intStream(new java8.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt(Long.MAX_VALUE, intSupplier), false);
    }

    public static java8.util.stream.IntStream range(int i, int i2) {
        if (i >= i2) {
            return empty();
        }
        return java8.util.stream.StreamSupport.intStream(new java8.util.stream.Streams.RangeIntSpliterator(i, i2, false), false);
    }

    public static java8.util.stream.IntStream rangeClosed(int i, int i2) {
        if (i > i2) {
            return empty();
        }
        return java8.util.stream.StreamSupport.intStream(new java8.util.stream.Streams.RangeIntSpliterator(i, i2, true), false);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java8.util.Spliterator$OfInt] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java8.util.Spliterator$OfInt] */
    public static java8.util.stream.IntStream concat(java8.util.stream.IntStream intStream, java8.util.stream.IntStream intStream2) {
        java8.util.Objects.requireNonNull(intStream);
        java8.util.Objects.requireNonNull(intStream2);
        return java8.util.stream.StreamSupport.intStream(new java8.util.stream.Streams.ConcatSpliterator.OfInt(intStream.spliterator2(), intStream2.spliterator2()), intStream.isParallel() || intStream2.isParallel()).onClose(java8.util.stream.Streams.composedClose(intStream, intStream2));
    }

    private IntStreams() {
    }
}
