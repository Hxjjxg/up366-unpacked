package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class StreamSpliterators {
    StreamSpliterators() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class AbstractWrappingSpliterator<P_IN, P_OUT, T_BUFFER extends java8.util.stream.AbstractSpinedBuffer> implements java8.util.Spliterator<P_OUT> {
        T_BUFFER buffer;
        java8.util.stream.Sink<P_IN> bufferSink;
        boolean finished;
        final boolean isParallel;
        long nextToConsume;
        final java8.util.stream.PipelineHelper<P_OUT> ph;
        java8.util.function.BooleanSupplier pusher;
        java8.util.Spliterator<P_IN> spliterator;
        private java8.util.function.Supplier<java8.util.Spliterator<P_IN>> spliteratorSupplier;

        abstract void initPartialTraversalState();

        abstract java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator<P_IN, P_OUT, ?> wrap(java8.util.Spliterator<P_IN> spliterator);

        AbstractWrappingSpliterator(java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.function.Supplier<java8.util.Spliterator<P_IN>> supplier, boolean z) {
            this.ph = pipelineHelper;
            this.spliteratorSupplier = supplier;
            this.spliterator = null;
            this.isParallel = z;
        }

        AbstractWrappingSpliterator(java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z) {
            this.ph = pipelineHelper;
            this.spliteratorSupplier = null;
            this.spliterator = spliterator;
            this.isParallel = z;
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        final void init() {
            if (this.spliterator == null) {
                this.spliterator = this.spliteratorSupplier.get();
                this.spliteratorSupplier = null;
            }
        }

        final boolean doAdvance() {
            T_BUFFER t_buffer = this.buffer;
            if (t_buffer == null) {
                if (this.finished) {
                    return false;
                }
                init();
                initPartialTraversalState();
                this.nextToConsume = 0L;
                this.bufferSink.begin(this.spliterator.getExactSizeIfKnown());
                return fillBuffer();
            }
            long j = this.nextToConsume + 1;
            this.nextToConsume = j;
            boolean z = j < t_buffer.count();
            if (z) {
                return z;
            }
            this.nextToConsume = 0L;
            this.buffer.clear();
            return fillBuffer();
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator<P_OUT> trySplit() {
            if (!this.isParallel || this.buffer != null || this.finished) {
                return null;
            }
            init();
            java8.util.Spliterator<P_IN> spliteratorTrySplit = this.spliterator.trySplit();
            if (spliteratorTrySplit == null) {
                return null;
            }
            return wrap(spliteratorTrySplit);
        }

        private boolean fillBuffer() {
            while (this.buffer.count() == 0) {
                if (this.bufferSink.cancellationRequested() || !this.pusher.getAsBoolean()) {
                    if (this.finished) {
                        return false;
                    }
                    this.bufferSink.end();
                    this.finished = true;
                }
            }
            return true;
        }

        @Override // java8.util.Spliterator
        public final long estimateSize() {
            init();
            return this.spliterator.estimateSize();
        }

        @Override // java8.util.Spliterator
        public final long getExactSizeIfKnown() {
            init();
            if (java8.util.stream.StreamOpFlag.SIZED.isKnown(this.ph.getStreamAndOpFlags())) {
                return this.spliterator.getExactSizeIfKnown();
            }
            return -1L;
        }

        @Override // java8.util.Spliterator
        public final int characteristics() {
            init();
            int characteristics = java8.util.stream.StreamOpFlag.toCharacteristics(java8.util.stream.StreamOpFlag.toStreamFlags(this.ph.getStreamAndOpFlags()));
            return (characteristics & 64) != 0 ? (characteristics & (-16449)) | (this.spliterator.characteristics() & 16448) : characteristics;
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super P_OUT> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new java.lang.IllegalStateException();
        }

        public final java.lang.String toString() {
            return java.lang.String.format("%s[%s]", getClass().getName(), this.spliterator);
        }
    }

    static final class WrappingSpliterator<P_IN, P_OUT> extends java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator<P_IN, P_OUT, java8.util.stream.SpinedBuffer<P_OUT>> {
        WrappingSpliterator(java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.function.Supplier<java8.util.Spliterator<P_IN>> supplier, boolean z) {
            super(pipelineHelper, supplier, z);
        }

        WrappingSpliterator(java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z) {
            super(pipelineHelper, spliterator, z);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        public java8.util.stream.StreamSpliterators.WrappingSpliterator<P_IN, P_OUT> wrap(java8.util.Spliterator<P_IN> spliterator) {
            return new java8.util.stream.StreamSpliterators.WrappingSpliterator<>(this.ph, spliterator, this.isParallel);
        }

        @Override // java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        void initPartialTraversalState() {
            java8.util.stream.SpinedBuffer spinedBuffer = new java8.util.stream.SpinedBuffer();
            this.buffer = spinedBuffer;
            this.bufferSink = this.ph.wrapSink(java8.util.stream.StreamSpliterators$WrappingSpliterator$$Lambda$1.lambdaFactory$(spinedBuffer));
            this.pusher = java8.util.stream.StreamSpliterators$WrappingSpliterator$$Lambda$2.lambdaFactory$(this);
        }

        static /* synthetic */ boolean lambda$initPartialTraversalState$144(java8.util.stream.StreamSpliterators.WrappingSpliterator wrappingSpliterator) {
            return wrappingSpliterator.spliterator.tryAdvance(wrappingSpliterator.bufferSink);
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super P_OUT> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            boolean zDoAdvance = doAdvance();
            if (zDoAdvance) {
                consumer.accept((java.lang.Object) ((java8.util.stream.SpinedBuffer) this.buffer).get(this.nextToConsume));
            }
            return zDoAdvance;
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super P_OUT> consumer) {
            if (this.buffer == 0 && !this.finished) {
                java8.util.Objects.requireNonNull(consumer);
                init();
                java8.util.stream.PipelineHelper<P_OUT> pipelineHelper = this.ph;
                consumer.getClass();
                pipelineHelper.wrapAndCopyInto(java8.util.stream.StreamSpliterators$WrappingSpliterator$$Lambda$3.lambdaFactory$(consumer), this.spliterator);
                this.finished = true;
                return;
            }
            while (tryAdvance(consumer)) {
            }
        }
    }

    static final class IntWrappingSpliterator<P_IN> extends java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator<P_IN, java.lang.Integer, java8.util.stream.SpinedBuffer.OfInt> implements java8.util.Spliterator.OfInt {
        IntWrappingSpliterator(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.function.Supplier<java8.util.Spliterator<P_IN>> supplier, boolean z) {
            super(pipelineHelper, supplier, z);
        }

        IntWrappingSpliterator(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z) {
            super(pipelineHelper, spliterator, z);
        }

        @Override // java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator<P_IN, java.lang.Integer, ?> wrap(java8.util.Spliterator<P_IN> spliterator) {
            return new java8.util.stream.StreamSpliterators.IntWrappingSpliterator((java8.util.stream.PipelineHelper<java.lang.Integer>) this.ph, (java8.util.Spliterator) spliterator, this.isParallel);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        void initPartialTraversalState() {
            final java8.util.stream.SpinedBuffer.OfInt ofInt = new java8.util.stream.SpinedBuffer.OfInt();
            this.buffer = ofInt;
            this.bufferSink = this.ph.wrapSink((java8.util.stream.Sink) new java8.util.stream.Sink.OfInt() { // from class: java8.util.stream.StreamSpliterators.IntWrappingSpliterator.1
                @Override // java8.util.stream.Sink
                public void begin(long j) {
                }

                @Override // java8.util.stream.Sink
                public boolean cancellationRequested() {
                    return false;
                }

                @Override // java8.util.stream.Sink
                public void end() {
                }

                @Override // java8.util.stream.Sink
                public void accept(double d) {
                    java8.util.stream.SinkDefaults.reject();
                }

                @Override // java8.util.stream.Sink
                public void accept(long j) {
                    java8.util.stream.SinkDefaults.reject();
                }

                @Override // java8.util.function.Consumer
                public void accept(java.lang.Integer num) {
                    accept(num.intValue());
                }

                @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
                public void accept(int i) {
                    ofInt.accept(i);
                }
            });
            this.pusher = java8.util.stream.StreamSpliterators$IntWrappingSpliterator$$Lambda$1.lambdaFactory$(this);
        }

        static /* synthetic */ boolean lambda$initPartialTraversalState$145(java8.util.stream.StreamSpliterators.IntWrappingSpliterator intWrappingSpliterator) {
            return intWrappingSpliterator.spliterator.tryAdvance(intWrappingSpliterator.bufferSink);
        }

        @Override // java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator, java8.util.Spliterator
        public java8.util.Spliterator.OfInt trySplit() {
            return (java8.util.Spliterator.OfInt) super.trySplit();
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
            java8.util.Objects.requireNonNull(intConsumer);
            boolean zDoAdvance = doAdvance();
            if (zDoAdvance) {
                intConsumer.accept(((java8.util.stream.SpinedBuffer.OfInt) this.buffer).get(this.nextToConsume));
            }
            return zDoAdvance;
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(final java8.util.function.IntConsumer intConsumer) {
            if (this.buffer == 0 && !this.finished) {
                java8.util.Objects.requireNonNull(intConsumer);
                init();
                this.ph.wrapAndCopyInto(new java8.util.stream.Sink.OfInt() { // from class: java8.util.stream.StreamSpliterators.IntWrappingSpliterator.2
                    @Override // java8.util.stream.Sink
                    public void begin(long j) {
                    }

                    @Override // java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        return false;
                    }

                    @Override // java8.util.stream.Sink
                    public void end() {
                    }

                    @Override // java8.util.stream.Sink
                    public void accept(double d) {
                        java8.util.stream.SinkDefaults.reject();
                    }

                    @Override // java8.util.stream.Sink
                    public void accept(long j) {
                        java8.util.stream.SinkDefaults.reject();
                    }

                    @Override // java8.util.function.Consumer
                    public void accept(java.lang.Integer num) {
                        accept(num.intValue());
                    }

                    @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
                    public void accept(int i) {
                        intConsumer.accept(i);
                    }
                }, (java8.util.Spliterator) this.spliterator);
                this.finished = true;
                return;
            }
            while (tryAdvance(intConsumer)) {
            }
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            java8.util.Spliterators.OfInt.forEachRemaining(this, consumer);
        }
    }

    static final class LongWrappingSpliterator<P_IN> extends java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator<P_IN, java.lang.Long, java8.util.stream.SpinedBuffer.OfLong> implements java8.util.Spliterator.OfLong {
        LongWrappingSpliterator(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.function.Supplier<java8.util.Spliterator<P_IN>> supplier, boolean z) {
            super(pipelineHelper, supplier, z);
        }

        LongWrappingSpliterator(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z) {
            super(pipelineHelper, spliterator, z);
        }

        @Override // java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator<P_IN, java.lang.Long, ?> wrap(java8.util.Spliterator<P_IN> spliterator) {
            return new java8.util.stream.StreamSpliterators.LongWrappingSpliterator((java8.util.stream.PipelineHelper<java.lang.Long>) this.ph, (java8.util.Spliterator) spliterator, this.isParallel);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        void initPartialTraversalState() {
            final java8.util.stream.SpinedBuffer.OfLong ofLong = new java8.util.stream.SpinedBuffer.OfLong();
            this.buffer = ofLong;
            this.bufferSink = this.ph.wrapSink((java8.util.stream.Sink) new java8.util.stream.Sink.OfLong() { // from class: java8.util.stream.StreamSpliterators.LongWrappingSpliterator.1
                @Override // java8.util.stream.Sink
                public void begin(long j) {
                }

                @Override // java8.util.stream.Sink
                public boolean cancellationRequested() {
                    return false;
                }

                @Override // java8.util.stream.Sink
                public void end() {
                }

                @Override // java8.util.stream.Sink
                public void accept(double d) {
                    java8.util.stream.SinkDefaults.reject();
                }

                @Override // java8.util.stream.Sink
                public void accept(int i) {
                    java8.util.stream.SinkDefaults.reject();
                }

                @Override // java8.util.function.Consumer
                public void accept(java.lang.Long l) {
                    accept(l.longValue());
                }

                @Override // java8.util.stream.Sink.OfLong, java8.util.stream.Sink
                public void accept(long j) {
                    ofLong.accept(j);
                }
            });
            this.pusher = java8.util.stream.StreamSpliterators$LongWrappingSpliterator$$Lambda$1.lambdaFactory$(this);
        }

        static /* synthetic */ boolean lambda$initPartialTraversalState$146(java8.util.stream.StreamSpliterators.LongWrappingSpliterator longWrappingSpliterator) {
            return longWrappingSpliterator.spliterator.tryAdvance(longWrappingSpliterator.bufferSink);
        }

        @Override // java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator, java8.util.Spliterator
        public java8.util.Spliterator.OfLong trySplit() {
            return (java8.util.Spliterator.OfLong) super.trySplit();
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
            java8.util.Objects.requireNonNull(longConsumer);
            boolean zDoAdvance = doAdvance();
            if (zDoAdvance) {
                longConsumer.accept(((java8.util.stream.SpinedBuffer.OfLong) this.buffer).get(this.nextToConsume));
            }
            return zDoAdvance;
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(final java8.util.function.LongConsumer longConsumer) {
            if (this.buffer == 0 && !this.finished) {
                java8.util.Objects.requireNonNull(longConsumer);
                init();
                this.ph.wrapAndCopyInto(new java8.util.stream.Sink.OfLong() { // from class: java8.util.stream.StreamSpliterators.LongWrappingSpliterator.2
                    @Override // java8.util.stream.Sink
                    public void begin(long j) {
                    }

                    @Override // java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        return false;
                    }

                    @Override // java8.util.stream.Sink
                    public void end() {
                    }

                    @Override // java8.util.stream.Sink
                    public void accept(double d) {
                        java8.util.stream.SinkDefaults.reject();
                    }

                    @Override // java8.util.stream.Sink
                    public void accept(int i) {
                        java8.util.stream.SinkDefaults.reject();
                    }

                    @Override // java8.util.function.Consumer
                    public void accept(java.lang.Long l) {
                        accept(l.longValue());
                    }

                    @Override // java8.util.stream.Sink.OfLong, java8.util.stream.Sink
                    public void accept(long j) {
                        longConsumer.accept(j);
                    }
                }, (java8.util.Spliterator) this.spliterator);
                this.finished = true;
                return;
            }
            while (tryAdvance(longConsumer)) {
            }
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
        }
    }

    static final class DoubleWrappingSpliterator<P_IN> extends java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator<P_IN, java.lang.Double, java8.util.stream.SpinedBuffer.OfDouble> implements java8.util.Spliterator.OfDouble {
        DoubleWrappingSpliterator(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.function.Supplier<java8.util.Spliterator<P_IN>> supplier, boolean z) {
            super(pipelineHelper, supplier, z);
        }

        DoubleWrappingSpliterator(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z) {
            super(pipelineHelper, spliterator, z);
        }

        @Override // java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator<P_IN, java.lang.Double, ?> wrap(java8.util.Spliterator<P_IN> spliterator) {
            return new java8.util.stream.StreamSpliterators.DoubleWrappingSpliterator((java8.util.stream.PipelineHelper<java.lang.Double>) this.ph, (java8.util.Spliterator) spliterator, this.isParallel);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        void initPartialTraversalState() {
            final java8.util.stream.SpinedBuffer.OfDouble ofDouble = new java8.util.stream.SpinedBuffer.OfDouble();
            this.buffer = ofDouble;
            this.bufferSink = this.ph.wrapSink((java8.util.stream.Sink) new java8.util.stream.Sink.OfDouble() { // from class: java8.util.stream.StreamSpliterators.DoubleWrappingSpliterator.1
                @Override // java8.util.stream.Sink
                public void begin(long j) {
                }

                @Override // java8.util.stream.Sink
                public boolean cancellationRequested() {
                    return false;
                }

                @Override // java8.util.stream.Sink
                public void end() {
                }

                @Override // java8.util.stream.Sink
                public void accept(int i) {
                    java8.util.stream.SinkDefaults.reject();
                }

                @Override // java8.util.stream.Sink
                public void accept(long j) {
                    java8.util.stream.SinkDefaults.reject();
                }

                @Override // java8.util.stream.Sink.OfDouble, java8.util.stream.Sink
                public void accept(double d) {
                    ofDouble.accept(d);
                }

                @Override // java8.util.function.Consumer
                public void accept(java.lang.Double d) {
                    accept(d.doubleValue());
                }
            });
            this.pusher = java8.util.stream.StreamSpliterators$DoubleWrappingSpliterator$$Lambda$1.lambdaFactory$(this);
        }

        @Override // java8.util.stream.StreamSpliterators.AbstractWrappingSpliterator, java8.util.Spliterator
        public java8.util.Spliterator.OfDouble trySplit() {
            return (java8.util.Spliterator.OfDouble) super.trySplit();
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
            java8.util.Objects.requireNonNull(doubleConsumer);
            boolean zDoAdvance = doAdvance();
            if (zDoAdvance) {
                doubleConsumer.accept(((java8.util.stream.SpinedBuffer.OfDouble) this.buffer).get(this.nextToConsume));
            }
            return zDoAdvance;
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(final java8.util.function.DoubleConsumer doubleConsumer) {
            if (this.buffer == 0 && !this.finished) {
                java8.util.Objects.requireNonNull(doubleConsumer);
                init();
                this.ph.wrapAndCopyInto(new java8.util.stream.Sink.OfDouble() { // from class: java8.util.stream.StreamSpliterators.DoubleWrappingSpliterator.2
                    @Override // java8.util.stream.Sink
                    public void begin(long j) {
                    }

                    @Override // java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        return false;
                    }

                    @Override // java8.util.stream.Sink
                    public void end() {
                    }

                    @Override // java8.util.stream.Sink
                    public void accept(int i) {
                        java8.util.stream.SinkDefaults.reject();
                    }

                    @Override // java8.util.stream.Sink
                    public void accept(long j) {
                        java8.util.stream.SinkDefaults.reject();
                    }

                    @Override // java8.util.stream.Sink.OfDouble, java8.util.stream.Sink
                    public void accept(double d) {
                        doubleConsumer.accept(d);
                    }

                    @Override // java8.util.function.Consumer
                    public void accept(java.lang.Double d) {
                        accept(d.doubleValue());
                    }
                }, (java8.util.Spliterator) this.spliterator);
                this.finished = true;
                return;
            }
            while (tryAdvance(doubleConsumer)) {
            }
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
        }
    }

    static class DelegatingSpliterator<T, T_SPLITR extends java8.util.Spliterator<T>> implements java8.util.Spliterator<T> {
        private T_SPLITR s;
        private final java8.util.function.Supplier<? extends T_SPLITR> supplier;

        DelegatingSpliterator(java8.util.function.Supplier<? extends T_SPLITR> supplier) {
            this.supplier = supplier;
        }

        T_SPLITR get() {
            if (this.s == null) {
                this.s = this.supplier.get();
            }
            return this.s;
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.Spliterator
        public T_SPLITR trySplit() {
            return (T_SPLITR) get().trySplit();
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
            return get().tryAdvance(consumer);
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
            get().forEachRemaining(consumer);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return get().estimateSize();
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return get().characteristics();
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super T> getComparator() {
            return get().getComparator();
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return get().getExactSizeIfKnown();
        }

        public java.lang.String toString() {
            return getClass().getName() + "[" + get() + "]";
        }

        static class OfPrimitive<T, T_CONS, T_SPLITR extends java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends java8.util.stream.StreamSpliterators.DelegatingSpliterator<T, T_SPLITR> implements java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            @Override // java8.util.stream.StreamSpliterators.DelegatingSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                return (java8.util.Spliterator.OfPrimitive) super.trySplit();
            }

            OfPrimitive(java8.util.function.Supplier<? extends T_SPLITR> supplier) {
                super(supplier);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS t_cons) {
                return get().tryAdvance(t_cons);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS t_cons) {
                get().forEachRemaining(t_cons);
            }
        }

        static final class OfInt extends java8.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive<java.lang.Integer, java8.util.function.IntConsumer, java8.util.Spliterator.OfInt> implements java8.util.Spliterator.OfInt {
            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
                super.forEachRemaining(intConsumer);
            }

            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
                return super.tryAdvance(intConsumer);
            }

            @Override // java8.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive, java8.util.stream.StreamSpliterators.DelegatingSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfInt trySplit() {
                return (java8.util.Spliterator.OfInt) super.trySplit();
            }

            OfInt(java8.util.function.Supplier<java8.util.Spliterator.OfInt> supplier) {
                super(supplier);
            }
        }

        static final class OfLong extends java8.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive<java.lang.Long, java8.util.function.LongConsumer, java8.util.Spliterator.OfLong> implements java8.util.Spliterator.OfLong {
            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
                super.forEachRemaining(longConsumer);
            }

            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
                return super.tryAdvance(longConsumer);
            }

            @Override // java8.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive, java8.util.stream.StreamSpliterators.DelegatingSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfLong trySplit() {
                return (java8.util.Spliterator.OfLong) super.trySplit();
            }

            OfLong(java8.util.function.Supplier<java8.util.Spliterator.OfLong> supplier) {
                super(supplier);
            }
        }

        static final class OfDouble extends java8.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive<java.lang.Double, java8.util.function.DoubleConsumer, java8.util.Spliterator.OfDouble> implements java8.util.Spliterator.OfDouble {
            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
                super.forEachRemaining(doubleConsumer);
            }

            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
                return super.tryAdvance(doubleConsumer);
            }

            @Override // java8.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive, java8.util.stream.StreamSpliterators.DelegatingSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfDouble trySplit() {
                return (java8.util.Spliterator.OfDouble) super.trySplit();
            }

            OfDouble(java8.util.function.Supplier<java8.util.Spliterator.OfDouble> supplier) {
                super(supplier);
            }
        }
    }

    static abstract class SliceSpliterator<T, T_SPLITR extends java8.util.Spliterator<T>> {
        long fence;
        long index;
        T_SPLITR s;
        final long sliceFence;
        final long sliceOrigin;

        protected abstract T_SPLITR makeSpliterator(T_SPLITR t_splitr, long j, long j2, long j3, long j4);

        SliceSpliterator(T_SPLITR t_splitr, long j, long j2, long j3, long j4) {
            this.s = t_splitr;
            this.sliceOrigin = j;
            this.sliceFence = j2;
            this.index = j3;
            this.fence = j4;
        }

        public T_SPLITR trySplit() {
            long j = this.sliceOrigin;
            long j2 = this.fence;
            if (j >= j2 || this.index >= j2) {
                return null;
            }
            while (true) {
                T_SPLITR t_splitr = (T_SPLITR) this.s.trySplit();
                if (t_splitr == null) {
                    return null;
                }
                long jEstimateSize = this.index + t_splitr.estimateSize();
                long jMin = java.lang.Math.min(jEstimateSize, this.sliceFence);
                long j3 = this.sliceOrigin;
                if (j3 >= jMin) {
                    this.index = jMin;
                } else {
                    long j4 = this.sliceFence;
                    if (jMin >= j4) {
                        this.s = t_splitr;
                        this.fence = jMin;
                    } else {
                        long j5 = this.index;
                        if (j5 >= j3 && jEstimateSize <= j4) {
                            this.index = jMin;
                            return t_splitr;
                        }
                        this.index = jMin;
                        return (T_SPLITR) makeSpliterator(t_splitr, j3, j4, j5, jMin);
                    }
                }
            }
        }

        public long estimateSize() {
            long j = this.sliceOrigin;
            long j2 = this.fence;
            if (j < j2) {
                return j2 - java.lang.Math.max(j, this.index);
            }
            return 0L;
        }

        public int characteristics() {
            return this.s.characteristics();
        }

        static final class OfRef<T> extends java8.util.stream.StreamSpliterators.SliceSpliterator<T, java8.util.Spliterator<T>> implements java8.util.Spliterator<T> {
            static /* synthetic */ void lambda$forEachRemaining$149(java.lang.Object obj) {
            }

            static /* synthetic */ void lambda$tryAdvance$148(java.lang.Object obj) {
            }

            OfRef(java8.util.Spliterator<T> spliterator, long j, long j2) {
                this(spliterator, j, j2, 0L, java.lang.Math.min(spliterator.estimateSize(), j2));
            }

            private OfRef(java8.util.Spliterator<T> spliterator, long j, long j2, long j3, long j4) {
                super(spliterator, j, j2, j3, j4);
            }

            @Override // java8.util.stream.StreamSpliterators.SliceSpliterator
            protected java8.util.Spliterator<T> makeSpliterator(java8.util.Spliterator<T> spliterator, long j, long j2, long j3, long j4) {
                return new java8.util.stream.StreamSpliterators.SliceSpliterator.OfRef(spliterator, j, j2, j3, j4);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
                java8.util.Objects.requireNonNull(consumer);
                if (this.sliceOrigin >= this.fence) {
                    return false;
                }
                while (this.sliceOrigin > this.index) {
                    this.s.tryAdvance(java8.util.stream.StreamSpliterators$SliceSpliterator$OfRef$$Lambda$1.instance);
                    this.index++;
                }
                if (this.index >= this.fence) {
                    return false;
                }
                this.index++;
                return this.s.tryAdvance(consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
                java8.util.Objects.requireNonNull(consumer);
                if (this.sliceOrigin < this.fence && this.index < this.fence) {
                    if (this.index >= this.sliceOrigin && this.index + this.s.estimateSize() <= this.sliceFence) {
                        this.s.forEachRemaining(consumer);
                        this.index = this.fence;
                        return;
                    }
                    while (this.sliceOrigin > this.index) {
                        this.s.tryAdvance(java8.util.stream.StreamSpliterators$SliceSpliterator$OfRef$$Lambda$2.instance);
                        this.index++;
                    }
                    while (this.index < this.fence) {
                        this.s.tryAdvance(consumer);
                        this.index++;
                    }
                }
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

        static abstract class OfPrimitive<T, T_SPLITR extends java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, T_CONS> extends java8.util.stream.StreamSpliterators.SliceSpliterator<T, T_SPLITR> implements java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            protected abstract T_CONS emptyConsumer();

            @Override // java8.util.stream.StreamSpliterators.SliceSpliterator, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                return (java8.util.Spliterator.OfPrimitive) super.trySplit();
            }

            OfPrimitive(T_SPLITR t_splitr, long j, long j2) {
                this(t_splitr, j, j2, 0L, java.lang.Math.min(t_splitr.estimateSize(), j2));
            }

            OfPrimitive(T_SPLITR t_splitr, long j, long j2, long j3, long j4) {
                super(t_splitr, j, j2, j3, j4);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS t_cons) {
                java8.util.Objects.requireNonNull(t_cons);
                if (this.sliceOrigin >= this.fence) {
                    return false;
                }
                while (this.sliceOrigin > this.index) {
                    ((java8.util.Spliterator.OfPrimitive) this.s).tryAdvance(emptyConsumer());
                    this.index++;
                }
                if (this.index >= this.fence) {
                    return false;
                }
                this.index++;
                return ((java8.util.Spliterator.OfPrimitive) this.s).tryAdvance(t_cons);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS t_cons) {
                java8.util.Objects.requireNonNull(t_cons);
                if (this.sliceOrigin < this.fence && this.index < this.fence) {
                    if (this.index >= this.sliceOrigin && this.index + ((java8.util.Spliterator.OfPrimitive) this.s).estimateSize() <= this.sliceFence) {
                        ((java8.util.Spliterator.OfPrimitive) this.s).forEachRemaining(t_cons);
                        this.index = this.fence;
                        return;
                    }
                    while (this.sliceOrigin > this.index) {
                        ((java8.util.Spliterator.OfPrimitive) this.s).tryAdvance(emptyConsumer());
                        this.index++;
                    }
                    while (this.index < this.fence) {
                        ((java8.util.Spliterator.OfPrimitive) this.s).tryAdvance(t_cons);
                        this.index++;
                    }
                }
            }
        }

        static final class OfInt extends java8.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive<java.lang.Integer, java8.util.Spliterator.OfInt, java8.util.function.IntConsumer> implements java8.util.Spliterator.OfInt {
            static /* synthetic */ void lambda$emptyConsumer$150(int i) {
            }

            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
                super.forEachRemaining(intConsumer);
            }

            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
                return super.tryAdvance(intConsumer);
            }

            @Override // java8.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive, java8.util.stream.StreamSpliterators.SliceSpliterator, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfInt trySplit() {
                return (java8.util.Spliterator.OfInt) super.trySplit();
            }

            OfInt(java8.util.Spliterator.OfInt ofInt, long j, long j2) {
                super(ofInt, j, j2);
            }

            OfInt(java8.util.Spliterator.OfInt ofInt, long j, long j2, long j3, long j4) {
                super(ofInt, j, j2, j3, j4);
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
                return java8.util.Spliterators.getComparator(this);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                java8.util.Spliterators.OfInt.forEachRemaining(this, consumer);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.SliceSpliterator
            public java8.util.Spliterator.OfInt makeSpliterator(java8.util.Spliterator.OfInt ofInt, long j, long j2, long j3, long j4) {
                return new java8.util.stream.StreamSpliterators.SliceSpliterator.OfInt(ofInt, j, j2, j3, j4);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive
            public java8.util.function.IntConsumer emptyConsumer() {
                return java8.util.stream.StreamSpliterators$SliceSpliterator$OfInt$$Lambda$1.instance;
            }
        }

        static final class OfLong extends java8.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive<java.lang.Long, java8.util.Spliterator.OfLong, java8.util.function.LongConsumer> implements java8.util.Spliterator.OfLong {
            static /* synthetic */ void lambda$emptyConsumer$151(long j) {
            }

            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
                super.forEachRemaining(longConsumer);
            }

            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
                return super.tryAdvance(longConsumer);
            }

            @Override // java8.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive, java8.util.stream.StreamSpliterators.SliceSpliterator, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfLong trySplit() {
                return (java8.util.Spliterator.OfLong) super.trySplit();
            }

            OfLong(java8.util.Spliterator.OfLong ofLong, long j, long j2) {
                super(ofLong, j, j2);
            }

            OfLong(java8.util.Spliterator.OfLong ofLong, long j, long j2, long j3, long j4) {
                super(ofLong, j, j2, j3, j4);
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
                return java8.util.Spliterators.getComparator(this);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.SliceSpliterator
            public java8.util.Spliterator.OfLong makeSpliterator(java8.util.Spliterator.OfLong ofLong, long j, long j2, long j3, long j4) {
                return new java8.util.stream.StreamSpliterators.SliceSpliterator.OfLong(ofLong, j, j2, j3, j4);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive
            public java8.util.function.LongConsumer emptyConsumer() {
                return java8.util.stream.StreamSpliterators$SliceSpliterator$OfLong$$Lambda$1.instance;
            }
        }

        static final class OfDouble extends java8.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive<java.lang.Double, java8.util.Spliterator.OfDouble, java8.util.function.DoubleConsumer> implements java8.util.Spliterator.OfDouble {
            static /* synthetic */ void lambda$emptyConsumer$152(double d) {
            }

            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
                super.forEachRemaining(doubleConsumer);
            }

            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
                return super.tryAdvance(doubleConsumer);
            }

            @Override // java8.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive, java8.util.stream.StreamSpliterators.SliceSpliterator, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfDouble trySplit() {
                return (java8.util.Spliterator.OfDouble) super.trySplit();
            }

            OfDouble(java8.util.Spliterator.OfDouble ofDouble, long j, long j2) {
                super(ofDouble, j, j2);
            }

            OfDouble(java8.util.Spliterator.OfDouble ofDouble, long j, long j2, long j3, long j4) {
                super(ofDouble, j, j2, j3, j4);
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
                return java8.util.Spliterators.getComparator(this);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.SliceSpliterator
            public java8.util.Spliterator.OfDouble makeSpliterator(java8.util.Spliterator.OfDouble ofDouble, long j, long j2, long j3, long j4) {
                return new java8.util.stream.StreamSpliterators.SliceSpliterator.OfDouble(ofDouble, j, j2, j3, j4);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive
            public java8.util.function.DoubleConsumer emptyConsumer() {
                return java8.util.stream.StreamSpliterators$SliceSpliterator$OfDouble$$Lambda$1.instance;
            }
        }
    }

    static abstract class UnorderedSliceSpliterator<T, T_SPLITR extends java8.util.Spliterator<T>> {
        static final int CHUNK_SIZE = 128;
        protected final int chunkSize;
        private final java.util.concurrent.atomic.AtomicLong permits;
        protected final T_SPLITR s;
        private final long skipThreshold;
        protected final boolean unlimited;

        enum PermitStatus {
            NO_MORE,
            MAYBE_MORE,
            UNLIMITED
        }

        protected abstract T_SPLITR makeSpliterator(T_SPLITR t_splitr);

        UnorderedSliceSpliterator(T_SPLITR t_splitr, long j, long j2) {
            this.s = t_splitr;
            this.unlimited = j2 < 0;
            this.skipThreshold = j2 >= 0 ? j2 : 0L;
            this.chunkSize = j2 >= 0 ? (int) java.lang.Math.min(128L, ((j + j2) / ((long) java8.util.stream.AbstractTask.getLeafTarget())) + 1) : 128;
            this.permits = new java.util.concurrent.atomic.AtomicLong(j2 >= 0 ? j + j2 : j);
        }

        UnorderedSliceSpliterator(T_SPLITR t_splitr, java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator<T, T_SPLITR> unorderedSliceSpliterator) {
            this.s = t_splitr;
            this.unlimited = unorderedSliceSpliterator.unlimited;
            this.permits = unorderedSliceSpliterator.permits;
            this.skipThreshold = unorderedSliceSpliterator.skipThreshold;
            this.chunkSize = unorderedSliceSpliterator.chunkSize;
        }

        protected final long acquirePermits(long j) {
            long j2;
            long jMin;
            do {
                j2 = this.permits.get();
                if (j2 == 0) {
                    if (this.unlimited) {
                        return j;
                    }
                    return 0L;
                }
                jMin = java.lang.Math.min(j2, j);
                if (jMin <= 0) {
                    break;
                }
            } while (!this.permits.compareAndSet(j2, j2 - jMin));
            if (this.unlimited) {
                return java.lang.Math.max(j - jMin, 0L);
            }
            long j3 = this.skipThreshold;
            return j2 > j3 ? java.lang.Math.max(jMin - (j2 - j3), 0L) : jMin;
        }

        protected final java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus permitStatus() {
            if (this.permits.get() > 0) {
                return java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus.MAYBE_MORE;
            }
            return this.unlimited ? java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus.UNLIMITED : java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus.NO_MORE;
        }

        public final T_SPLITR trySplit() {
            java8.util.Spliterator<T> spliteratorTrySplit;
            if (this.permits.get() == 0 || (spliteratorTrySplit = this.s.trySplit()) == null) {
                return null;
            }
            return (T_SPLITR) makeSpliterator(spliteratorTrySplit);
        }

        public final long estimateSize() {
            return this.s.estimateSize();
        }

        public final int characteristics() {
            return this.s.characteristics() & (-16465);
        }

        static final class OfRef<T> extends java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator<T, java8.util.Spliterator<T>> implements java8.util.Spliterator<T>, java8.util.function.Consumer<T> {
            T tmpSlot;

            OfRef(java8.util.Spliterator<T> spliterator, long j, long j2) {
                super(spliterator, j, j2);
            }

            OfRef(java8.util.Spliterator<T> spliterator, java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef<T> ofRef) {
                super(spliterator, ofRef);
            }

            @Override // java8.util.function.Consumer
            public final void accept(T t) {
                this.tmpSlot = t;
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
                java8.util.Objects.requireNonNull(consumer);
                while (permitStatus() != java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus.NO_MORE && this.s.tryAdvance(this)) {
                    if (acquirePermits(1L) == 1) {
                        consumer.accept(this.tmpSlot);
                        this.tmpSlot = null;
                        return true;
                    }
                }
                return false;
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
                java8.util.Objects.requireNonNull(consumer);
                java8.util.stream.StreamSpliterators.ArrayBuffer.OfRef ofRef = null;
                while (true) {
                    java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus permitStatus = permitStatus();
                    if (permitStatus == java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus.NO_MORE) {
                        return;
                    }
                    if (permitStatus == java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus.MAYBE_MORE) {
                        if (ofRef == null) {
                            ofRef = new java8.util.stream.StreamSpliterators.ArrayBuffer.OfRef(this.chunkSize);
                        } else {
                            ofRef.reset();
                        }
                        long j = 0;
                        while (this.s.tryAdvance(ofRef)) {
                            j++;
                            if (j >= this.chunkSize) {
                                break;
                            }
                        }
                        if (j == 0) {
                            return;
                        } else {
                            ofRef.forEach(consumer, acquirePermits(j));
                        }
                    } else {
                        this.s.forEachRemaining(consumer);
                        return;
                    }
                }
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

            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator
            protected java8.util.Spliterator<T> makeSpliterator(java8.util.Spliterator<T> spliterator) {
                return new java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef(spliterator, this);
            }
        }

        static abstract class OfPrimitive<T, T_CONS, T_BUFF extends java8.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive<T_CONS>, T_SPLITR extends java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator<T, T_SPLITR> implements java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            protected abstract void acceptConsumed(T_CONS t_cons);

            protected abstract T_BUFF bufferCreate(int i);

            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                return (java8.util.Spliterator.OfPrimitive) super.trySplit();
            }

            OfPrimitive(T_SPLITR t_splitr, long j, long j2) {
                super(t_splitr, j, j2);
            }

            OfPrimitive(T_SPLITR t_splitr, java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive<T, T_CONS, T_BUFF, T_SPLITR> ofPrimitive) {
                super(t_splitr, ofPrimitive);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS t_cons) {
                java8.util.Objects.requireNonNull(t_cons);
                while (permitStatus() != java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus.NO_MORE && ((java8.util.Spliterator.OfPrimitive) this.s).tryAdvance(this)) {
                    if (acquirePermits(1L) == 1) {
                        acceptConsumed(t_cons);
                        return true;
                    }
                }
                return false;
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS t_cons) {
                java8.util.Objects.requireNonNull(t_cons);
                java8.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive ofPrimitiveBufferCreate = null;
                while (true) {
                    java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus permitStatus = permitStatus();
                    if (permitStatus == java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus.NO_MORE) {
                        return;
                    }
                    if (permitStatus == java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus.MAYBE_MORE) {
                        if (ofPrimitiveBufferCreate == null) {
                            ofPrimitiveBufferCreate = bufferCreate(this.chunkSize);
                        } else {
                            ofPrimitiveBufferCreate.reset();
                        }
                        long j = 0;
                        while (((java8.util.Spliterator.OfPrimitive) this.s).tryAdvance(ofPrimitiveBufferCreate)) {
                            j++;
                            if (j >= this.chunkSize) {
                                break;
                            }
                        }
                        if (j == 0) {
                            return;
                        } else {
                            ofPrimitiveBufferCreate.forEach(t_cons, acquirePermits(j));
                        }
                    } else {
                        ((java8.util.Spliterator.OfPrimitive) this.s).forEachRemaining(t_cons);
                        return;
                    }
                }
            }
        }

        static final class OfInt extends java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive<java.lang.Integer, java8.util.function.IntConsumer, java8.util.stream.StreamSpliterators.ArrayBuffer.OfInt, java8.util.Spliterator.OfInt> implements java8.util.Spliterator.OfInt, java8.util.function.IntConsumer {
            int tmpValue;

            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
                super.forEachRemaining(intConsumer);
            }

            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
                return super.tryAdvance(intConsumer);
            }

            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive, java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfInt trySplit() {
                return (java8.util.Spliterator.OfInt) super.trySplit();
            }

            OfInt(java8.util.Spliterator.OfInt ofInt, long j, long j2) {
                super(ofInt, j, j2);
            }

            OfInt(java8.util.Spliterator.OfInt ofInt, java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt ofInt2) {
                super(ofInt, ofInt2);
            }

            @Override // java8.util.function.IntConsumer
            public void accept(int i) {
                this.tmpValue = i;
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
                return java8.util.Spliterators.getComparator(this);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                java8.util.Spliterators.OfInt.forEachRemaining(this, consumer);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive
            public void acceptConsumed(java8.util.function.IntConsumer intConsumer) {
                intConsumer.accept(this.tmpValue);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive
            public java8.util.stream.StreamSpliterators.ArrayBuffer.OfInt bufferCreate(int i) {
                return new java8.util.stream.StreamSpliterators.ArrayBuffer.OfInt(i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator
            public java8.util.Spliterator.OfInt makeSpliterator(java8.util.Spliterator.OfInt ofInt) {
                return new java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt(ofInt, this);
            }
        }

        static final class OfLong extends java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive<java.lang.Long, java8.util.function.LongConsumer, java8.util.stream.StreamSpliterators.ArrayBuffer.OfLong, java8.util.Spliterator.OfLong> implements java8.util.Spliterator.OfLong, java8.util.function.LongConsumer {
            long tmpValue;

            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
                super.forEachRemaining(longConsumer);
            }

            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
                return super.tryAdvance(longConsumer);
            }

            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive, java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfLong trySplit() {
                return (java8.util.Spliterator.OfLong) super.trySplit();
            }

            OfLong(java8.util.Spliterator.OfLong ofLong, long j, long j2) {
                super(ofLong, j, j2);
            }

            OfLong(java8.util.Spliterator.OfLong ofLong, java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong ofLong2) {
                super(ofLong, ofLong2);
            }

            @Override // java8.util.function.LongConsumer
            public void accept(long j) {
                this.tmpValue = j;
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
                return java8.util.Spliterators.getComparator(this);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive
            public void acceptConsumed(java8.util.function.LongConsumer longConsumer) {
                longConsumer.accept(this.tmpValue);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive
            public java8.util.stream.StreamSpliterators.ArrayBuffer.OfLong bufferCreate(int i) {
                return new java8.util.stream.StreamSpliterators.ArrayBuffer.OfLong(i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator
            public java8.util.Spliterator.OfLong makeSpliterator(java8.util.Spliterator.OfLong ofLong) {
                return new java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong(ofLong, this);
            }
        }

        static final class OfDouble extends java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive<java.lang.Double, java8.util.function.DoubleConsumer, java8.util.stream.StreamSpliterators.ArrayBuffer.OfDouble, java8.util.Spliterator.OfDouble> implements java8.util.Spliterator.OfDouble, java8.util.function.DoubleConsumer {
            double tmpValue;

            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
                super.forEachRemaining(doubleConsumer);
            }

            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
                return super.tryAdvance(doubleConsumer);
            }

            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive, java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfDouble trySplit() {
                return (java8.util.Spliterator.OfDouble) super.trySplit();
            }

            OfDouble(java8.util.Spliterator.OfDouble ofDouble, long j, long j2) {
                super(ofDouble, j, j2);
            }

            OfDouble(java8.util.Spliterator.OfDouble ofDouble, java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble ofDouble2) {
                super(ofDouble, ofDouble2);
            }

            @Override // java8.util.function.DoubleConsumer
            public void accept(double d) {
                this.tmpValue = d;
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
                return java8.util.Spliterators.getComparator(this);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive
            public void acceptConsumed(java8.util.function.DoubleConsumer doubleConsumer) {
                doubleConsumer.accept(this.tmpValue);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive
            public java8.util.stream.StreamSpliterators.ArrayBuffer.OfDouble bufferCreate(int i) {
                return new java8.util.stream.StreamSpliterators.ArrayBuffer.OfDouble(i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator
            public java8.util.Spliterator.OfDouble makeSpliterator(java8.util.Spliterator.OfDouble ofDouble) {
                return new java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble(ofDouble, this);
            }
        }
    }

    static final class DistinctSpliterator<T> implements java8.util.Spliterator<T>, java8.util.function.Consumer<T> {
        private static final java.lang.Object NULL_VALUE = new java.lang.Object();
        private final java8.util.Spliterator<T> s;
        private final java.util.concurrent.ConcurrentMap<T, java.lang.Boolean> seen;
        private T tmpSlot;

        DistinctSpliterator(java8.util.Spliterator<T> spliterator) {
            this(spliterator, new java.util.concurrent.ConcurrentHashMap(512, 0.75f, java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism() + 1));
        }

        private DistinctSpliterator(java8.util.Spliterator<T> spliterator, java.util.concurrent.ConcurrentMap<T, java.lang.Boolean> concurrentMap) {
            this.s = spliterator;
            this.seen = concurrentMap;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown(this);
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.function.Consumer
        public void accept(T t) {
            this.tmpSlot = t;
        }

        private T mapNull(T t) {
            return t != null ? t : (T) NULL_VALUE;
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
            while (this.s.tryAdvance(this)) {
                if (this.seen.putIfAbsent(mapNull(this.tmpSlot), java.lang.Boolean.TRUE) == null) {
                    consumer.accept(this.tmpSlot);
                    this.tmpSlot = null;
                    return true;
                }
            }
            return false;
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
            this.s.forEachRemaining(java8.util.stream.StreamSpliterators$DistinctSpliterator$$Lambda$1.lambdaFactory$(this, consumer));
        }

        static /* synthetic */ void lambda$forEachRemaining$153(java8.util.stream.StreamSpliterators.DistinctSpliterator distinctSpliterator, java8.util.function.Consumer consumer, java.lang.Object obj) {
            if (distinctSpliterator.seen.putIfAbsent((T) distinctSpliterator.mapNull(obj), java.lang.Boolean.TRUE) == null) {
                consumer.accept(obj);
            }
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator<T> trySplit() {
            java8.util.Spliterator<T> spliteratorTrySplit = this.s.trySplit();
            if (spliteratorTrySplit != null) {
                return new java8.util.stream.StreamSpliterators.DistinctSpliterator(spliteratorTrySplit, this.seen);
            }
            return null;
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.s.estimateSize();
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return (this.s.characteristics() & (-16469)) | 1;
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super T> getComparator() {
            return this.s.getComparator();
        }
    }

    static abstract class InfiniteSupplyingSpliterator<T> implements java8.util.Spliterator<T> {
        long estimate;

        @Override // java8.util.Spliterator
        public int characteristics() {
            return 1024;
        }

        protected InfiniteSupplyingSpliterator(long j) {
            this.estimate = j;
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.estimate;
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

        static final class OfRef<T> extends java8.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator<T> {
            final java8.util.function.Supplier<? extends T> s;

            OfRef(long j, java8.util.function.Supplier<? extends T> supplier) {
                super(j);
                this.s = supplier;
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
                java8.util.Spliterators.forEachRemaining(this, consumer);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
                java8.util.Objects.requireNonNull(consumer);
                consumer.accept(this.s.get());
                return true;
            }

            @Override // java8.util.Spliterator
            public java8.util.Spliterator<T> trySplit() {
                if (this.estimate == 0) {
                    return null;
                }
                long j = this.estimate >>> 1;
                this.estimate = j;
                return new java8.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfRef(j, this.s);
            }
        }

        static final class OfInt extends java8.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator<java.lang.Integer> implements java8.util.Spliterator.OfInt {
            final java8.util.function.IntSupplier s;

            OfInt(long j, java8.util.function.IntSupplier intSupplier) {
                super(j);
                this.s = intSupplier;
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
                java8.util.Objects.requireNonNull(intConsumer);
                intConsumer.accept(this.s.getAsInt());
                return true;
            }

            @Override // java8.util.Spliterator
            public java8.util.Spliterator.OfInt trySplit() {
                if (this.estimate == 0) {
                    return null;
                }
                long j = this.estimate >>> 1;
                this.estimate = j;
                return new java8.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt(j, this.s);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
                java8.util.Spliterators.OfInt.forEachRemaining(this, intConsumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                java8.util.Spliterators.OfInt.forEachRemaining(this, consumer);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
            }
        }

        static final class OfLong extends java8.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator<java.lang.Long> implements java8.util.Spliterator.OfLong {
            final java8.util.function.LongSupplier s;

            OfLong(long j, java8.util.function.LongSupplier longSupplier) {
                super(j);
                this.s = longSupplier;
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
                java8.util.Objects.requireNonNull(longConsumer);
                longConsumer.accept(this.s.getAsLong());
                return true;
            }

            @Override // java8.util.Spliterator
            public java8.util.Spliterator.OfLong trySplit() {
                if (this.estimate == 0) {
                    return null;
                }
                long j = this.estimate >>> 1;
                this.estimate = j;
                return new java8.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong(j, this.s);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
                java8.util.Spliterators.OfLong.forEachRemaining(this, longConsumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
            }
        }

        static final class OfDouble extends java8.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator<java.lang.Double> implements java8.util.Spliterator.OfDouble {
            final java8.util.function.DoubleSupplier s;

            OfDouble(long j, java8.util.function.DoubleSupplier doubleSupplier) {
                super(j);
                this.s = doubleSupplier;
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
                java8.util.Objects.requireNonNull(doubleConsumer);
                doubleConsumer.accept(this.s.getAsDouble());
                return true;
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public java8.util.Spliterator.OfDouble trySplit() {
                if (this.estimate == 0) {
                    return null;
                }
                long j = this.estimate >>> 1;
                this.estimate = j;
                return new java8.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble(j, this.s);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
                java8.util.Spliterators.OfDouble.forEachRemaining(this, doubleConsumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
            }
        }
    }

    static abstract class ArrayBuffer {
        int index;

        ArrayBuffer() {
        }

        void reset() {
            this.index = 0;
        }

        static final class OfRef<T> extends java8.util.stream.StreamSpliterators.ArrayBuffer implements java8.util.function.Consumer<T> {
            final java.lang.Object[] array;

            OfRef(int i) {
                this.array = new java.lang.Object[i];
            }

            @Override // java8.util.function.Consumer
            public void accept(T t) {
                java.lang.Object[] objArr = this.array;
                int i = this.index;
                this.index = i + 1;
                objArr[i] = t;
            }

            public void forEach(java8.util.function.Consumer<? super T> consumer, long j) {
                for (int i = 0; i < j; i++) {
                    consumer.accept(this.array[i]);
                }
            }
        }

        static abstract class OfPrimitive<T_CONS> extends java8.util.stream.StreamSpliterators.ArrayBuffer {
            int index;

            abstract void forEach(T_CONS t_cons, long j);

            OfPrimitive() {
            }

            @Override // java8.util.stream.StreamSpliterators.ArrayBuffer
            void reset() {
                this.index = 0;
            }
        }

        static final class OfInt extends java8.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive<java8.util.function.IntConsumer> implements java8.util.function.IntConsumer {
            final int[] array;

            OfInt(int i) {
                this.array = new int[i];
            }

            @Override // java8.util.function.IntConsumer
            public void accept(int i) {
                int[] iArr = this.array;
                int i2 = this.index;
                this.index = i2 + 1;
                iArr[i2] = i;
            }

            @Override // java8.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive
            public void forEach(java8.util.function.IntConsumer intConsumer, long j) {
                for (int i = 0; i < j; i++) {
                    intConsumer.accept(this.array[i]);
                }
            }
        }

        static final class OfLong extends java8.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive<java8.util.function.LongConsumer> implements java8.util.function.LongConsumer {
            final long[] array;

            OfLong(int i) {
                this.array = new long[i];
            }

            @Override // java8.util.function.LongConsumer
            public void accept(long j) {
                long[] jArr = this.array;
                int i = this.index;
                this.index = i + 1;
                jArr[i] = j;
            }

            @Override // java8.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive
            public void forEach(java8.util.function.LongConsumer longConsumer, long j) {
                for (int i = 0; i < j; i++) {
                    longConsumer.accept(this.array[i]);
                }
            }
        }

        static final class OfDouble extends java8.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive<java8.util.function.DoubleConsumer> implements java8.util.function.DoubleConsumer {
            final double[] array;

            OfDouble(int i) {
                this.array = new double[i];
            }

            @Override // java8.util.function.DoubleConsumer
            public void accept(double d) {
                double[] dArr = this.array;
                int i = this.index;
                this.index = i + 1;
                dArr[i] = d;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive
            public void forEach(java8.util.function.DoubleConsumer doubleConsumer, long j) {
                for (int i = 0; i < j; i++) {
                    doubleConsumer.accept(this.array[i]);
                }
            }
        }
    }
}
