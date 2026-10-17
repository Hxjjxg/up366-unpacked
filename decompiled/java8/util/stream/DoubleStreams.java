package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DoubleStreams {
    /* JADX WARN: Type inference failed for: r1v0, types: [java8.util.Spliterator$OfDouble] */
    public static java8.util.stream.DoubleStream takeWhile(java8.util.stream.DoubleStream doubleStream, java8.util.function.DoublePredicate doublePredicate) {
        java8.util.Objects.requireNonNull(doubleStream);
        java8.util.Objects.requireNonNull(doublePredicate);
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble.Taking(doubleStream.spliterator2(), true, doublePredicate), doubleStream.isParallel()).onClose(java8.util.stream.StreamSupport.closeHandler(doubleStream));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java8.util.Spliterator$OfDouble] */
    public static java8.util.stream.DoubleStream dropWhile(java8.util.stream.DoubleStream doubleStream, java8.util.function.DoublePredicate doublePredicate) {
        java8.util.Objects.requireNonNull(doubleStream);
        java8.util.Objects.requireNonNull(doublePredicate);
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble.Dropping(doubleStream.spliterator2(), true, doublePredicate), doubleStream.isParallel()).onClose(java8.util.stream.StreamSupport.closeHandler(doubleStream));
    }

    public static java8.util.stream.DoubleStream.Builder builder() {
        return new java8.util.stream.Streams.DoubleStreamBuilderImpl();
    }

    public static java8.util.stream.DoubleStream empty() {
        return java8.util.stream.StreamSupport.doubleStream(java8.util.Spliterators.emptyDoubleSpliterator(), false);
    }

    public static java8.util.stream.DoubleStream of(double d) {
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.stream.Streams.DoubleStreamBuilderImpl(d), false);
    }

    public static java8.util.stream.DoubleStream of(double... dArr) {
        return java8.util.J8Arrays.stream(dArr);
    }

    public static java8.util.stream.DoubleStream iterate(final double d, final java8.util.function.DoubleUnaryOperator doubleUnaryOperator) {
        java8.util.Objects.requireNonNull(doubleUnaryOperator);
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.Spliterators.AbstractDoubleSpliterator(Long.MAX_VALUE, 1296) { // from class: java8.util.stream.DoubleStreams.1
            double prev;
            boolean started;

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
                double dApplyAsDouble;
                java8.util.Objects.requireNonNull(doubleConsumer);
                if (this.started) {
                    dApplyAsDouble = doubleUnaryOperator.applyAsDouble(this.prev);
                } else {
                    dApplyAsDouble = d;
                    this.started = true;
                }
                this.prev = dApplyAsDouble;
                doubleConsumer.accept(dApplyAsDouble);
                return true;
            }
        }, false);
    }

    public static java8.util.stream.DoubleStream iterate(final double d, final java8.util.function.DoublePredicate doublePredicate, final java8.util.function.DoubleUnaryOperator doubleUnaryOperator) {
        java8.util.Objects.requireNonNull(doubleUnaryOperator);
        java8.util.Objects.requireNonNull(doublePredicate);
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.Spliterators.AbstractDoubleSpliterator(Long.MAX_VALUE, 1296) { // from class: java8.util.stream.DoubleStreams.2
            boolean finished;
            double prev;
            boolean started;

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
                double dApplyAsDouble;
                java8.util.Objects.requireNonNull(doubleConsumer);
                if (this.finished) {
                    return false;
                }
                if (this.started) {
                    dApplyAsDouble = doubleUnaryOperator.applyAsDouble(this.prev);
                } else {
                    dApplyAsDouble = d;
                    this.started = true;
                }
                if (!doublePredicate.test(dApplyAsDouble)) {
                    this.finished = true;
                    return false;
                }
                this.prev = dApplyAsDouble;
                doubleConsumer.accept(dApplyAsDouble);
                return true;
            }

            @Override // java8.util.Spliterators.AbstractDoubleSpliterator, java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
                java8.util.Objects.requireNonNull(doubleConsumer);
                if (this.finished) {
                    return;
                }
                this.finished = true;
                double dApplyAsDouble = this.started ? doubleUnaryOperator.applyAsDouble(this.prev) : d;
                while (doublePredicate.test(dApplyAsDouble)) {
                    doubleConsumer.accept(dApplyAsDouble);
                    dApplyAsDouble = doubleUnaryOperator.applyAsDouble(dApplyAsDouble);
                }
            }
        }, false);
    }

    public static java8.util.stream.DoubleStream generate(java8.util.function.DoubleSupplier doubleSupplier) {
        java8.util.Objects.requireNonNull(doubleSupplier);
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble(Long.MAX_VALUE, doubleSupplier), false);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java8.util.Spliterator$OfDouble] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java8.util.Spliterator$OfDouble] */
    public static java8.util.stream.DoubleStream concat(java8.util.stream.DoubleStream doubleStream, java8.util.stream.DoubleStream doubleStream2) {
        java8.util.Objects.requireNonNull(doubleStream);
        java8.util.Objects.requireNonNull(doubleStream2);
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.stream.Streams.ConcatSpliterator.OfDouble(doubleStream.spliterator2(), doubleStream2.spliterator2()), doubleStream.isParallel() || doubleStream2.isParallel()).onClose(java8.util.stream.Streams.composedClose(doubleStream, doubleStream2));
    }

    private DoubleStreams() {
    }
}
