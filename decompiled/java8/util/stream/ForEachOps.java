package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class ForEachOps {
    private ForEachOps() {
    }

    public static <T> java8.util.stream.TerminalOp<T, java.lang.Void> makeRef(java8.util.function.Consumer<? super T> consumer, boolean z) {
        java8.util.Objects.requireNonNull(consumer);
        return new java8.util.stream.ForEachOps.ForEachOp.OfRef(consumer, z);
    }

    public static java8.util.stream.TerminalOp<java.lang.Integer, java.lang.Void> makeInt(java8.util.function.IntConsumer intConsumer, boolean z) {
        java8.util.Objects.requireNonNull(intConsumer);
        return new java8.util.stream.ForEachOps.ForEachOp.OfInt(intConsumer, z);
    }

    public static java8.util.stream.TerminalOp<java.lang.Long, java.lang.Void> makeLong(java8.util.function.LongConsumer longConsumer, boolean z) {
        java8.util.Objects.requireNonNull(longConsumer);
        return new java8.util.stream.ForEachOps.ForEachOp.OfLong(longConsumer, z);
    }

    public static java8.util.stream.TerminalOp<java.lang.Double, java.lang.Void> makeDouble(java8.util.function.DoubleConsumer doubleConsumer, boolean z) {
        java8.util.Objects.requireNonNull(doubleConsumer);
        return new java8.util.stream.ForEachOps.ForEachOp.OfDouble(doubleConsumer, z);
    }

    static abstract class ForEachOp<T> implements java8.util.stream.TerminalOp<T, java.lang.Void>, java8.util.stream.TerminalSink<T, java.lang.Void> {
        private final boolean ordered;

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

        @Override // java8.util.function.Supplier
        public java.lang.Void get() {
            return null;
        }

        protected ForEachOp(boolean z) {
            this.ordered = z;
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.TerminalOp
        public java8.util.stream.StreamShape inputShape() {
            return java8.util.stream.StreamShape.REFERENCE;
        }

        @Override // java8.util.stream.TerminalOp
        public int getOpFlags() {
            if (this.ordered) {
                return 0;
            }
            return java8.util.stream.StreamOpFlag.NOT_ORDERED;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java8.util.stream.TerminalOp
        public <S> java.lang.Void evaluateSequential(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<S> spliterator) {
            return ((java8.util.stream.ForEachOps.ForEachOp) pipelineHelper.wrapAndCopyInto(this, (java8.util.Spliterator) spliterator)).get();
        }

        @Override // java8.util.stream.TerminalOp
        public <S> java.lang.Void evaluateParallel(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<S> spliterator) {
            if (this.ordered) {
                new java8.util.stream.ForEachOps.ForEachOrderedTask(pipelineHelper, spliterator, this).invoke();
                return null;
            }
            new java8.util.stream.ForEachOps.ForEachTask(pipelineHelper, spliterator, pipelineHelper.wrapSink((java8.util.stream.Sink<T>) this)).invoke();
            return null;
        }

        static final class OfRef<T> extends java8.util.stream.ForEachOps.ForEachOp<T> {
            final java8.util.function.Consumer<? super T> consumer;

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Void evaluateParallel(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return super.evaluateParallel(pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Void evaluateSequential(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return super.evaluateSequential(pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.function.Supplier
            public /* bridge */ /* synthetic */ java.lang.Object get() {
                return super.get();
            }

            OfRef(java8.util.function.Consumer<? super T> consumer, boolean z) {
                super(z);
                this.consumer = consumer;
            }

            @Override // java8.util.function.Consumer
            public void accept(T t) {
                this.consumer.accept(t);
            }
        }

        static final class OfInt extends java8.util.stream.ForEachOps.ForEachOp<java.lang.Integer> implements java8.util.stream.Sink.OfInt {
            final java8.util.function.IntConsumer consumer;

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Void evaluateParallel(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return super.evaluateParallel(pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Void evaluateSequential(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return super.evaluateSequential(pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.function.Supplier
            public /* bridge */ /* synthetic */ java.lang.Object get() {
                return super.get();
            }

            OfInt(java8.util.function.IntConsumer intConsumer, boolean z) {
                super(z);
                this.consumer = intConsumer;
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.TerminalOp
            public java8.util.stream.StreamShape inputShape() {
                return java8.util.stream.StreamShape.INT_VALUE;
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.Sink
            public void accept(int i) {
                this.consumer.accept(i);
            }

            @Override // java8.util.function.Consumer
            public void accept(java.lang.Integer num) {
                java8.util.stream.SinkDefaults.OfInt.accept(this, num);
            }
        }

        static final class OfLong extends java8.util.stream.ForEachOps.ForEachOp<java.lang.Long> implements java8.util.stream.Sink.OfLong {
            final java8.util.function.LongConsumer consumer;

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Void evaluateParallel(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return super.evaluateParallel(pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Void evaluateSequential(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return super.evaluateSequential(pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.function.Supplier
            public /* bridge */ /* synthetic */ java.lang.Object get() {
                return super.get();
            }

            OfLong(java8.util.function.LongConsumer longConsumer, boolean z) {
                super(z);
                this.consumer = longConsumer;
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.TerminalOp
            public java8.util.stream.StreamShape inputShape() {
                return java8.util.stream.StreamShape.LONG_VALUE;
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.Sink
            public void accept(long j) {
                this.consumer.accept(j);
            }

            @Override // java8.util.function.Consumer
            public void accept(java.lang.Long l) {
                java8.util.stream.SinkDefaults.OfLong.accept(this, l);
            }
        }

        static final class OfDouble extends java8.util.stream.ForEachOps.ForEachOp<java.lang.Double> implements java8.util.stream.Sink.OfDouble {
            final java8.util.function.DoubleConsumer consumer;

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Void evaluateParallel(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return super.evaluateParallel(pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Void evaluateSequential(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return super.evaluateSequential(pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.function.Supplier
            public /* bridge */ /* synthetic */ java.lang.Object get() {
                return super.get();
            }

            OfDouble(java8.util.function.DoubleConsumer doubleConsumer, boolean z) {
                super(z);
                this.consumer = doubleConsumer;
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.TerminalOp
            public java8.util.stream.StreamShape inputShape() {
                return java8.util.stream.StreamShape.DOUBLE_VALUE;
            }

            @Override // java8.util.stream.ForEachOps.ForEachOp, java8.util.stream.Sink
            public void accept(double d) {
                this.consumer.accept(d);
            }

            @Override // java8.util.function.Consumer
            public void accept(java.lang.Double d) {
                java8.util.stream.SinkDefaults.OfDouble.accept(this, d);
            }
        }
    }

    static final class ForEachTask<S, T> extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
        private final java8.util.stream.PipelineHelper<T> helper;
        private final java8.util.stream.Sink<S> sink;
        private java8.util.Spliterator<S> spliterator;
        private long targetSize;

        ForEachTask(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<S> spliterator, java8.util.stream.Sink<S> sink) {
            super(null);
            this.sink = sink;
            this.helper = pipelineHelper;
            this.spliterator = spliterator;
            this.targetSize = 0L;
        }

        ForEachTask(java8.util.stream.ForEachOps.ForEachTask<S, T> forEachTask, java8.util.Spliterator<S> spliterator) {
            super(forEachTask);
            this.spliterator = spliterator;
            this.sink = forEachTask.sink;
            this.targetSize = forEachTask.targetSize;
            this.helper = forEachTask.helper;
        }

        @Override // java8.util.concurrent.CountedCompleter
        public void compute() {
            java8.util.Spliterator<S> spliteratorTrySplit;
            java8.util.Spliterator<S> spliterator = this.spliterator;
            long jEstimateSize = spliterator.estimateSize();
            long jSuggestTargetSize = this.targetSize;
            if (jSuggestTargetSize == 0) {
                jSuggestTargetSize = java8.util.stream.AbstractTask.suggestTargetSize(jEstimateSize);
                this.targetSize = jSuggestTargetSize;
            }
            boolean zIsKnown = java8.util.stream.StreamOpFlag.SHORT_CIRCUIT.isKnown(this.helper.getStreamAndOpFlags());
            java8.util.stream.Sink<S> sink = this.sink;
            boolean z = false;
            java8.util.stream.ForEachOps.ForEachTask<S, T> forEachTask = this;
            while (true) {
                if (zIsKnown && sink.cancellationRequested()) {
                    break;
                }
                if (jEstimateSize <= jSuggestTargetSize || (spliteratorTrySplit = spliterator.trySplit()) == null) {
                    break;
                }
                java8.util.stream.ForEachOps.ForEachTask<S, T> forEachTask2 = new java8.util.stream.ForEachOps.ForEachTask<>(forEachTask, spliteratorTrySplit);
                forEachTask.addToPendingCount(1);
                if (z) {
                    spliterator = spliteratorTrySplit;
                } else {
                    java8.util.stream.ForEachOps.ForEachTask<S, T> forEachTask3 = forEachTask;
                    forEachTask = forEachTask2;
                    forEachTask2 = forEachTask3;
                }
                z = !z;
                forEachTask.fork();
                forEachTask = forEachTask2;
                jEstimateSize = spliterator.estimateSize();
            }
            forEachTask.helper.copyInto(sink, spliterator);
            forEachTask.spliterator = null;
            forEachTask.propagateCompletion();
        }
    }

    static final class ForEachOrderedTask<S, T> extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
        private final java8.util.stream.Sink<T> action;
        private final java.util.concurrent.ConcurrentMap<java8.util.stream.ForEachOps.ForEachOrderedTask<S, T>, java8.util.stream.ForEachOps.ForEachOrderedTask<S, T>> completionMap;
        private final java8.util.stream.PipelineHelper<T> helper;
        private final java8.util.stream.ForEachOps.ForEachOrderedTask<S, T> leftPredecessor;
        private java8.util.stream.Node<T> node;
        private java8.util.Spliterator<S> spliterator;
        private final long targetSize;

        protected ForEachOrderedTask(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<S> spliterator, java8.util.stream.Sink<T> sink) {
            super(null);
            this.helper = pipelineHelper;
            this.spliterator = spliterator;
            this.targetSize = java8.util.stream.AbstractTask.suggestTargetSize(spliterator.estimateSize());
            this.completionMap = new java.util.concurrent.ConcurrentHashMap(java.lang.Math.max(16, java8.util.stream.AbstractTask.getLeafTarget() << 1), 0.75f, java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism() + 1);
            this.action = sink;
            this.leftPredecessor = null;
        }

        ForEachOrderedTask(java8.util.stream.ForEachOps.ForEachOrderedTask<S, T> forEachOrderedTask, java8.util.Spliterator<S> spliterator, java8.util.stream.ForEachOps.ForEachOrderedTask<S, T> forEachOrderedTask2) {
            super(forEachOrderedTask);
            this.helper = forEachOrderedTask.helper;
            this.spliterator = spliterator;
            this.targetSize = forEachOrderedTask.targetSize;
            this.completionMap = forEachOrderedTask.completionMap;
            this.action = forEachOrderedTask.action;
            this.leftPredecessor = forEachOrderedTask2;
        }

        @Override // java8.util.concurrent.CountedCompleter
        public final void compute() {
            doCompute(this);
        }

        private static <S, T> void doCompute(java8.util.stream.ForEachOps.ForEachOrderedTask<S, T> forEachOrderedTask) {
            java8.util.Spliterator<S> spliteratorTrySplit;
            java8.util.Spliterator<S> spliterator = ((java8.util.stream.ForEachOps.ForEachOrderedTask) forEachOrderedTask).spliterator;
            long j = ((java8.util.stream.ForEachOps.ForEachOrderedTask) forEachOrderedTask).targetSize;
            boolean z = false;
            while (spliterator.estimateSize() > j && (spliteratorTrySplit = spliterator.trySplit()) != null) {
                java8.util.stream.ForEachOps.ForEachOrderedTask<S, T> forEachOrderedTask2 = new java8.util.stream.ForEachOps.ForEachOrderedTask<>(forEachOrderedTask, spliteratorTrySplit, ((java8.util.stream.ForEachOps.ForEachOrderedTask) forEachOrderedTask).leftPredecessor);
                java8.util.stream.ForEachOps.ForEachOrderedTask<S, T> forEachOrderedTask3 = new java8.util.stream.ForEachOps.ForEachOrderedTask<>(forEachOrderedTask, spliterator, forEachOrderedTask2);
                forEachOrderedTask.addToPendingCount(1);
                forEachOrderedTask3.addToPendingCount(1);
                ((java8.util.stream.ForEachOps.ForEachOrderedTask) forEachOrderedTask).completionMap.put(forEachOrderedTask2, forEachOrderedTask3);
                if (((java8.util.stream.ForEachOps.ForEachOrderedTask) forEachOrderedTask).leftPredecessor != null) {
                    forEachOrderedTask2.addToPendingCount(1);
                    if (((java8.util.stream.ForEachOps.ForEachOrderedTask) forEachOrderedTask).completionMap.replace(((java8.util.stream.ForEachOps.ForEachOrderedTask) forEachOrderedTask).leftPredecessor, forEachOrderedTask, forEachOrderedTask2)) {
                        forEachOrderedTask.addToPendingCount(-1);
                    } else {
                        forEachOrderedTask2.addToPendingCount(-1);
                    }
                }
                if (z) {
                    spliterator = spliteratorTrySplit;
                    forEachOrderedTask = forEachOrderedTask2;
                    forEachOrderedTask2 = forEachOrderedTask3;
                } else {
                    forEachOrderedTask = forEachOrderedTask3;
                }
                z = !z;
                forEachOrderedTask2.fork();
            }
            if (forEachOrderedTask.getPendingCount() > 0) {
                java8.util.function.IntFunction<T[]> intFunction = java8.util.stream.ForEachOps$ForEachOrderedTask$$Lambda$1.instance;
                java8.util.stream.PipelineHelper<T> pipelineHelper = ((java8.util.stream.ForEachOps.ForEachOrderedTask) forEachOrderedTask).helper;
                ((java8.util.stream.ForEachOps.ForEachOrderedTask) forEachOrderedTask).node = ((java8.util.stream.Node.Builder) ((java8.util.stream.ForEachOps.ForEachOrderedTask) forEachOrderedTask).helper.wrapAndCopyInto(pipelineHelper.makeNodeBuilder(pipelineHelper.exactOutputSizeIfKnown(spliterator), intFunction), (java8.util.Spliterator) spliterator)).build2();
                ((java8.util.stream.ForEachOps.ForEachOrderedTask) forEachOrderedTask).spliterator = null;
            }
            forEachOrderedTask.tryComplete();
        }

        static /* synthetic */ java.lang.Object[] lambda$doCompute$80(int i) {
            return new java.lang.Object[i];
        }

        @Override // java8.util.concurrent.CountedCompleter
        public void onCompletion(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
            java8.util.stream.Node<T> node = this.node;
            if (node != null) {
                node.forEach(this.action);
                this.node = null;
            } else {
                java8.util.Spliterator<S> spliterator = this.spliterator;
                if (spliterator != null) {
                    this.helper.wrapAndCopyInto(this.action, (java8.util.Spliterator) spliterator);
                    this.spliterator = null;
                }
            }
            java8.util.stream.ForEachOps.ForEachOrderedTask<S, T> forEachOrderedTaskRemove = this.completionMap.remove(this);
            if (forEachOrderedTaskRemove != null) {
                forEachOrderedTaskRemove.tryComplete();
            }
        }
    }
}
