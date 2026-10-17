package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class LongStreams {
    /* JADX WARN: Type inference failed for: r1v0, types: [java8.util.Spliterator$OfLong] */
    public static java8.util.stream.LongStream takeWhile(java8.util.stream.LongStream longStream, java8.util.function.LongPredicate longPredicate) {
        java8.util.Objects.requireNonNull(longStream);
        java8.util.Objects.requireNonNull(longPredicate);
        return java8.util.stream.StreamSupport.longStream(new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong.Taking(longStream.spliterator2(), true, longPredicate), longStream.isParallel()).onClose(java8.util.stream.StreamSupport.closeHandler(longStream));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java8.util.Spliterator$OfLong] */
    public static java8.util.stream.LongStream dropWhile(java8.util.stream.LongStream longStream, java8.util.function.LongPredicate longPredicate) {
        java8.util.Objects.requireNonNull(longStream);
        java8.util.Objects.requireNonNull(longPredicate);
        return java8.util.stream.StreamSupport.longStream(new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong.Dropping(longStream.spliterator2(), true, longPredicate), longStream.isParallel()).onClose(java8.util.stream.StreamSupport.closeHandler(longStream));
    }

    public static java8.util.stream.LongStream.Builder builder() {
        return new java8.util.stream.Streams.LongStreamBuilderImpl();
    }

    public static java8.util.stream.LongStream empty() {
        return java8.util.stream.StreamSupport.longStream(java8.util.Spliterators.emptyLongSpliterator(), false);
    }

    public static java8.util.stream.LongStream of(long j) {
        return java8.util.stream.StreamSupport.longStream(new java8.util.stream.Streams.LongStreamBuilderImpl(j), false);
    }

    public static java8.util.stream.LongStream of(long... jArr) {
        return java8.util.J8Arrays.stream(jArr);
    }

    public static java8.util.stream.LongStream iterate(final long j, final java8.util.function.LongUnaryOperator longUnaryOperator) {
        java8.util.Objects.requireNonNull(longUnaryOperator);
        return java8.util.stream.StreamSupport.longStream(new java8.util.Spliterators.AbstractLongSpliterator(Long.MAX_VALUE, 1296) { // from class: java8.util.stream.LongStreams.1
            long prev;
            boolean started;

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
                long jApplyAsLong;
                java8.util.Objects.requireNonNull(longConsumer);
                if (this.started) {
                    jApplyAsLong = longUnaryOperator.applyAsLong(this.prev);
                } else {
                    jApplyAsLong = j;
                    this.started = true;
                }
                this.prev = jApplyAsLong;
                longConsumer.accept(jApplyAsLong);
                return true;
            }
        }, false);
    }

    public static java8.util.stream.LongStream iterate(final long j, final java8.util.function.LongPredicate longPredicate, final java8.util.function.LongUnaryOperator longUnaryOperator) {
        java8.util.Objects.requireNonNull(longUnaryOperator);
        java8.util.Objects.requireNonNull(longPredicate);
        return java8.util.stream.StreamSupport.longStream(new java8.util.Spliterators.AbstractLongSpliterator(Long.MAX_VALUE, 1296) { // from class: java8.util.stream.LongStreams.2
            boolean finished;
            long prev;
            boolean started;

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
                long jApplyAsLong;
                java8.util.Objects.requireNonNull(longConsumer);
                if (this.finished) {
                    return false;
                }
                if (this.started) {
                    jApplyAsLong = longUnaryOperator.applyAsLong(this.prev);
                } else {
                    jApplyAsLong = j;
                    this.started = true;
                }
                if (!longPredicate.test(jApplyAsLong)) {
                    this.finished = true;
                    return false;
                }
                this.prev = jApplyAsLong;
                longConsumer.accept(jApplyAsLong);
                return true;
            }

            @Override // java8.util.Spliterators.AbstractLongSpliterator, java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
                java8.util.Objects.requireNonNull(longConsumer);
                if (this.finished) {
                    return;
                }
                this.finished = true;
                long jApplyAsLong = this.started ? longUnaryOperator.applyAsLong(this.prev) : j;
                while (longPredicate.test(jApplyAsLong)) {
                    longConsumer.accept(jApplyAsLong);
                    jApplyAsLong = longUnaryOperator.applyAsLong(jApplyAsLong);
                }
            }
        }, false);
    }

    public static java8.util.stream.LongStream generate(java8.util.function.LongSupplier longSupplier) {
        java8.util.Objects.requireNonNull(longSupplier);
        return java8.util.stream.StreamSupport.longStream(new java8.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong(Long.MAX_VALUE, longSupplier), false);
    }

    public static java8.util.stream.LongStream range(long j, long j2) {
        if (j >= j2) {
            return empty();
        }
        long j3 = j2 - j;
        if (j3 < 0) {
            long jDivideUnsigned = java8.lang.Longs.divideUnsigned(j3, 2L) + j + 1;
            return concat(range(j, jDivideUnsigned), range(jDivideUnsigned, j2));
        }
        return java8.util.stream.StreamSupport.longStream(new java8.util.stream.Streams.RangeLongSpliterator(j, j2, false), false);
    }

    public static java8.util.stream.LongStream rangeClosed(long j, long j2) {
        if (j > j2) {
            return empty();
        }
        long j3 = j2 - j;
        if (j3 + 1 <= 0) {
            long jDivideUnsigned = java8.lang.Longs.divideUnsigned(j3, 2L) + j + 1;
            return concat(range(j, jDivideUnsigned), rangeClosed(jDivideUnsigned, j2));
        }
        return java8.util.stream.StreamSupport.longStream(new java8.util.stream.Streams.RangeLongSpliterator(j, j2, true), false);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java8.util.Spliterator$OfLong] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java8.util.Spliterator$OfLong] */
    public static java8.util.stream.LongStream concat(java8.util.stream.LongStream longStream, java8.util.stream.LongStream longStream2) {
        java8.util.Objects.requireNonNull(longStream);
        java8.util.Objects.requireNonNull(longStream2);
        return java8.util.stream.StreamSupport.longStream(new java8.util.stream.Streams.ConcatSpliterator.OfLong(longStream.spliterator2(), longStream2.spliterator2()), longStream.isParallel() || longStream2.isParallel()).onClose(java8.util.stream.Streams.composedClose(longStream, longStream2));
    }

    private LongStreams() {
    }
}
