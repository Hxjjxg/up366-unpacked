package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
abstract class AbstractPipeline<E_IN, E_OUT, S extends java8.util.stream.BaseStream<E_OUT, S>> extends java8.util.stream.PipelineHelper<E_OUT> implements java8.util.stream.BaseStream<E_OUT, S> {
    private static final java.lang.String MSG_CONSUMED = "source already consumed or closed";
    private static final java.lang.String MSG_STREAM_LINKED = "stream has already been operated upon or closed";
    private int combinedFlags;
    private int depth;
    private boolean linkedOrConsumed;
    private java8.util.stream.AbstractPipeline nextStage;
    private boolean parallel;
    private final java8.util.stream.AbstractPipeline previousStage;
    private boolean sourceAnyStateful;
    private java.lang.Runnable sourceCloseAction;
    protected final int sourceOrOpFlags;
    private java8.util.Spliterator<?> sourceSpliterator;
    private final java8.util.stream.AbstractPipeline sourceStage;
    private java8.util.function.Supplier<? extends java8.util.Spliterator<?>> sourceSupplier;

    static /* synthetic */ java8.util.Spliterator lambda$wrapSpliterator$78(java8.util.Spliterator spliterator) {
        return spliterator;
    }

    abstract <P_IN> java8.util.stream.Node<E_OUT> evaluateToNode(java8.util.stream.PipelineHelper<E_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z, java8.util.function.IntFunction<E_OUT[]> intFunction);

    abstract boolean forEachWithCancel(java8.util.Spliterator<E_OUT> spliterator, java8.util.stream.Sink<E_OUT> sink);

    abstract java8.util.stream.StreamShape getOutputShape();

    /* JADX INFO: renamed from: lazySpliterator */
    abstract java8.util.Spliterator<E_OUT> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<E_OUT>> supplier);

    @Override // java8.util.stream.PipelineHelper
    abstract java8.util.stream.Node.Builder<E_OUT> makeNodeBuilder(long j, java8.util.function.IntFunction<E_OUT[]> intFunction);

    abstract boolean opIsStateful();

    abstract java8.util.stream.Sink<E_IN> opWrapSink(int i, java8.util.stream.Sink<E_OUT> sink);

    abstract <P_IN> java8.util.Spliterator<E_OUT> wrap(java8.util.stream.PipelineHelper<E_OUT> pipelineHelper, java8.util.function.Supplier<java8.util.Spliterator<P_IN>> supplier, boolean z);

    AbstractPipeline(java8.util.function.Supplier<? extends java8.util.Spliterator<?>> supplier, int i, boolean z) {
        this.previousStage = null;
        this.sourceSupplier = supplier;
        this.sourceStage = this;
        int i2 = java8.util.stream.StreamOpFlag.STREAM_MASK & i;
        this.sourceOrOpFlags = i2;
        this.combinedFlags = (~(i2 << 1)) & java8.util.stream.StreamOpFlag.INITIAL_OPS_VALUE;
        this.depth = 0;
        this.parallel = z;
    }

    AbstractPipeline(java8.util.Spliterator<?> spliterator, int i, boolean z) {
        this.previousStage = null;
        this.sourceSpliterator = spliterator;
        this.sourceStage = this;
        int i2 = java8.util.stream.StreamOpFlag.STREAM_MASK & i;
        this.sourceOrOpFlags = i2;
        this.combinedFlags = (~(i2 << 1)) & java8.util.stream.StreamOpFlag.INITIAL_OPS_VALUE;
        this.depth = 0;
        this.parallel = z;
    }

    AbstractPipeline(java8.util.stream.AbstractPipeline<?, E_IN, ?> abstractPipeline, int i) {
        if (abstractPipeline.linkedOrConsumed) {
            throw new java.lang.IllegalStateException(MSG_STREAM_LINKED);
        }
        abstractPipeline.linkedOrConsumed = true;
        abstractPipeline.nextStage = this;
        this.previousStage = abstractPipeline;
        this.sourceOrOpFlags = java8.util.stream.StreamOpFlag.OP_MASK & i;
        this.combinedFlags = java8.util.stream.StreamOpFlag.combineOpFlags(i, abstractPipeline.combinedFlags);
        java8.util.stream.AbstractPipeline abstractPipeline2 = abstractPipeline.sourceStage;
        this.sourceStage = abstractPipeline2;
        if (opIsStateful()) {
            abstractPipeline2.sourceAnyStateful = true;
        }
        this.depth = abstractPipeline.depth + 1;
    }

    final <R> R evaluate(java8.util.stream.TerminalOp<E_OUT, R> terminalOp) {
        if (this.linkedOrConsumed) {
            throw new java.lang.IllegalStateException(MSG_STREAM_LINKED);
        }
        this.linkedOrConsumed = true;
        if (isParallel()) {
            return terminalOp.evaluateParallel(this, sourceSpliterator(terminalOp.getOpFlags()));
        }
        return terminalOp.evaluateSequential(this, sourceSpliterator(terminalOp.getOpFlags()));
    }

    final java8.util.stream.Node<E_OUT> evaluateToArrayNode(java8.util.function.IntFunction<E_OUT[]> intFunction) {
        if (this.linkedOrConsumed) {
            throw new java.lang.IllegalStateException(MSG_STREAM_LINKED);
        }
        this.linkedOrConsumed = true;
        if (isParallel() && this.previousStage != null && opIsStateful()) {
            this.depth = 0;
            java8.util.stream.AbstractPipeline abstractPipeline = this.previousStage;
            return opEvaluateParallel(abstractPipeline, abstractPipeline.sourceSpliterator(0), intFunction);
        }
        return evaluate(sourceSpliterator(0), true, intFunction);
    }

    final java8.util.Spliterator<E_OUT> sourceStageSpliterator() {
        java8.util.stream.AbstractPipeline<E_IN, E_OUT, S> abstractPipeline = this.sourceStage;
        if (this != abstractPipeline) {
            throw new java.lang.IllegalStateException();
        }
        if (this.linkedOrConsumed) {
            throw new java.lang.IllegalStateException(MSG_STREAM_LINKED);
        }
        this.linkedOrConsumed = true;
        java8.util.Spliterator<E_OUT> spliterator = (java8.util.Spliterator<E_OUT>) abstractPipeline.sourceSpliterator;
        if (spliterator != null) {
            abstractPipeline.sourceSpliterator = null;
            return spliterator;
        }
        java8.util.function.Supplier<? extends java8.util.Spliterator<?>> supplier = abstractPipeline.sourceSupplier;
        if (supplier != null) {
            java8.util.Spliterator<E_OUT> spliterator2 = (java8.util.Spliterator) supplier.get();
            this.sourceStage.sourceSupplier = null;
            return spliterator2;
        }
        throw new java.lang.IllegalStateException(MSG_CONSUMED);
    }

    @Override // java8.util.stream.BaseStream
    public final S sequential() {
        this.sourceStage.parallel = false;
        return this;
    }

    @Override // java8.util.stream.BaseStream
    public final S parallel() {
        this.sourceStage.parallel = true;
        return this;
    }

    @Override // java8.util.stream.BaseStream
    public void close() {
        this.linkedOrConsumed = true;
        this.sourceSupplier = null;
        this.sourceSpliterator = null;
        java8.util.stream.AbstractPipeline abstractPipeline = this.sourceStage;
        java.lang.Runnable runnable = abstractPipeline.sourceCloseAction;
        if (runnable != null) {
            abstractPipeline.sourceCloseAction = null;
            runnable.run();
        }
    }

    @Override // java8.util.stream.BaseStream
    public S onClose(java.lang.Runnable runnable) {
        if (this.linkedOrConsumed) {
            throw new java.lang.IllegalStateException(MSG_STREAM_LINKED);
        }
        java8.util.Objects.requireNonNull(runnable);
        java8.util.stream.AbstractPipeline abstractPipeline = this.sourceStage;
        java.lang.Runnable runnable2 = abstractPipeline.sourceCloseAction;
        if (runnable2 != null) {
            runnable = java8.util.stream.Streams.composeWithExceptions(runnable2, runnable);
        }
        abstractPipeline.sourceCloseAction = runnable;
        return this;
    }

    @Override // java8.util.stream.BaseStream
    /* JADX INFO: renamed from: spliterator */
    public java8.util.Spliterator<E_OUT> spliterator2() {
        if (this.linkedOrConsumed) {
            throw new java.lang.IllegalStateException(MSG_STREAM_LINKED);
        }
        this.linkedOrConsumed = true;
        java8.util.stream.AbstractPipeline<E_IN, E_OUT, S> abstractPipeline = this.sourceStage;
        if (this == abstractPipeline) {
            java8.util.Spliterator<E_OUT> spliterator = (java8.util.Spliterator<E_OUT>) abstractPipeline.sourceSpliterator;
            if (spliterator != null) {
                abstractPipeline.sourceSpliterator = null;
                return spliterator;
            }
            java8.util.function.Supplier<? extends java8.util.Spliterator<?>> supplier = abstractPipeline.sourceSupplier;
            if (supplier != null) {
                abstractPipeline.sourceSupplier = null;
                return lazySpliterator2(supplier);
            }
            throw new java.lang.IllegalStateException(MSG_CONSUMED);
        }
        return wrap(this, java8.util.stream.AbstractPipeline$$Lambda$1.lambdaFactory$(this), isParallel());
    }

    static /* synthetic */ java8.util.Spliterator lambda$spliterator$77(java8.util.stream.AbstractPipeline abstractPipeline) {
        return abstractPipeline.sourceSpliterator(0);
    }

    @Override // java8.util.stream.BaseStream
    public final boolean isParallel() {
        return this.sourceStage.parallel;
    }

    final int getStreamFlags() {
        return java8.util.stream.StreamOpFlag.toStreamFlags(this.combinedFlags);
    }

    private java8.util.Spliterator<?> sourceSpliterator(int i) {
        int i2;
        int i3;
        java8.util.stream.AbstractPipeline abstractPipeline = this.sourceStage;
        java8.util.Spliterator<?> spliteratorOpEvaluateParallelLazy = abstractPipeline.sourceSpliterator;
        if (spliteratorOpEvaluateParallelLazy != null) {
            abstractPipeline.sourceSpliterator = null;
        } else {
            java8.util.function.Supplier<? extends java8.util.Spliterator<?>> supplier = abstractPipeline.sourceSupplier;
            if (supplier != null) {
                spliteratorOpEvaluateParallelLazy = supplier.get();
                this.sourceStage.sourceSupplier = null;
            } else {
                throw new java.lang.IllegalStateException(MSG_CONSUMED);
            }
        }
        if (isParallel()) {
            java8.util.stream.AbstractPipeline abstractPipeline2 = this.sourceStage;
            if (abstractPipeline2.sourceAnyStateful) {
                java8.util.stream.AbstractPipeline abstractPipeline3 = abstractPipeline2.nextStage;
                int i4 = 1;
                while (abstractPipeline2 != this) {
                    int i5 = abstractPipeline3.sourceOrOpFlags;
                    if (abstractPipeline3.opIsStateful()) {
                        if (java8.util.stream.StreamOpFlag.SHORT_CIRCUIT.isKnown(i5)) {
                            i5 &= ~java8.util.stream.StreamOpFlag.IS_SHORT_CIRCUIT;
                        }
                        spliteratorOpEvaluateParallelLazy = abstractPipeline3.opEvaluateParallelLazy(abstractPipeline2, spliteratorOpEvaluateParallelLazy);
                        if (spliteratorOpEvaluateParallelLazy.hasCharacteristics(64)) {
                            i2 = (~java8.util.stream.StreamOpFlag.NOT_SIZED) & i5;
                            i3 = java8.util.stream.StreamOpFlag.IS_SIZED;
                        } else {
                            i2 = (~java8.util.stream.StreamOpFlag.IS_SIZED) & i5;
                            i3 = java8.util.stream.StreamOpFlag.NOT_SIZED;
                        }
                        i5 = i2 | i3;
                        i4 = 0;
                    }
                    abstractPipeline3.depth = i4;
                    abstractPipeline3.combinedFlags = java8.util.stream.StreamOpFlag.combineOpFlags(i5, abstractPipeline2.combinedFlags);
                    i4++;
                    java8.util.stream.AbstractPipeline abstractPipeline4 = abstractPipeline3;
                    abstractPipeline3 = abstractPipeline3.nextStage;
                    abstractPipeline2 = abstractPipeline4;
                }
            }
        }
        if (i != 0) {
            this.combinedFlags = java8.util.stream.StreamOpFlag.combineOpFlags(i, this.combinedFlags);
        }
        return spliteratorOpEvaluateParallelLazy;
    }

    @Override // java8.util.stream.PipelineHelper
    final java8.util.stream.StreamShape getSourceShape() {
        java8.util.stream.AbstractPipeline<E_IN, E_OUT, S> abstractPipeline = this;
        while (abstractPipeline.depth > 0) {
            abstractPipeline = abstractPipeline.previousStage;
        }
        return abstractPipeline.getOutputShape();
    }

    @Override // java8.util.stream.PipelineHelper
    final <P_IN> long exactOutputSizeIfKnown(java8.util.Spliterator<P_IN> spliterator) {
        if (java8.util.stream.StreamOpFlag.SIZED.isKnown(getStreamAndOpFlags())) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1L;
    }

    @Override // java8.util.stream.PipelineHelper
    final <P_IN, S_ extends java8.util.stream.Sink<E_OUT>> S_ wrapAndCopyInto(S_ s_, java8.util.Spliterator<P_IN> spliterator) {
        copyInto(wrapSink((java8.util.stream.Sink) java8.util.Objects.requireNonNull(s_)), spliterator);
        return s_;
    }

    @Override // java8.util.stream.PipelineHelper
    final <P_IN, S_ extends java8.util.function.Consumer<E_OUT>> S_ wrapAndCopyInto(S_ s_, java8.util.Spliterator<P_IN> spliterator) {
        copyInto(wrapSink((java8.util.function.Consumer) java8.util.Objects.requireNonNull(s_)), spliterator);
        return s_;
    }

    @Override // java8.util.stream.PipelineHelper
    final <P_IN> void copyInto(java8.util.stream.Sink<P_IN> sink, java8.util.Spliterator<P_IN> spliterator) {
        java8.util.Objects.requireNonNull(sink);
        if (!java8.util.stream.StreamOpFlag.SHORT_CIRCUIT.isKnown(getStreamAndOpFlags())) {
            sink.begin(spliterator.getExactSizeIfKnown());
            spliterator.forEachRemaining(sink);
            sink.end();
            return;
        }
        copyIntoWithCancel(sink, spliterator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.stream.PipelineHelper
    final <P_IN> boolean copyIntoWithCancel(java8.util.stream.Sink<P_IN> sink, java8.util.Spliterator<P_IN> spliterator) {
        java8.util.stream.AbstractPipeline<E_IN, E_OUT, S> abstractPipeline = this;
        while (abstractPipeline.depth > 0) {
            abstractPipeline = abstractPipeline.previousStage;
        }
        sink.begin(spliterator.getExactSizeIfKnown());
        boolean zForEachWithCancel = abstractPipeline.forEachWithCancel(spliterator, sink);
        sink.end();
        return zForEachWithCancel;
    }

    @Override // java8.util.stream.PipelineHelper
    final int getStreamAndOpFlags() {
        return this.combinedFlags;
    }

    final boolean isOrdered() {
        return java8.util.stream.StreamOpFlag.ORDERED.isKnown(this.combinedFlags);
    }

    @Override // java8.util.stream.PipelineHelper
    final <P_IN> java8.util.stream.Sink<P_IN> wrapSink(java8.util.stream.Sink<E_OUT> sink) {
        java8.util.Objects.requireNonNull(sink);
        for (java8.util.stream.AbstractPipeline<E_IN, E_OUT, S> abstractPipeline = this; abstractPipeline.depth > 0; abstractPipeline = abstractPipeline.previousStage) {
            sink = (java8.util.stream.Sink<P_IN>) abstractPipeline.opWrapSink(abstractPipeline.previousStage.combinedFlags, sink);
        }
        return (java8.util.stream.Sink<P_IN>) sink;
    }

    @Override // java8.util.stream.PipelineHelper
    final <P_IN> java8.util.stream.Sink<P_IN> wrapSink(final java8.util.function.Consumer<E_OUT> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        java8.util.stream.Sink<E_OUT> sink = new java8.util.stream.Sink<E_OUT>() { // from class: java8.util.stream.AbstractPipeline.1
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

            @Override // java8.util.function.Consumer
            public void accept(E_OUT e_out) {
                consumer.accept(e_out);
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
        };
        for (java8.util.stream.AbstractPipeline<E_IN, E_OUT, S> abstractPipeline = this; abstractPipeline.depth > 0; abstractPipeline = abstractPipeline.previousStage) {
            sink = (java8.util.stream.Sink<P_IN>) abstractPipeline.opWrapSink(abstractPipeline.previousStage.combinedFlags, sink);
        }
        return (java8.util.stream.Sink<P_IN>) sink;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.stream.PipelineHelper
    final <P_IN> java8.util.Spliterator<E_OUT> wrapSpliterator(java8.util.Spliterator<P_IN> spliterator) {
        return this.depth == 0 ? spliterator : wrap(this, java8.util.stream.AbstractPipeline$$Lambda$2.lambdaFactory$(spliterator), isParallel());
    }

    @Override // java8.util.stream.PipelineHelper
    final <P_IN> java8.util.stream.Node<E_OUT> evaluate(java8.util.Spliterator<P_IN> spliterator, boolean z, java8.util.function.IntFunction<E_OUT[]> intFunction) {
        if (isParallel()) {
            return evaluateToNode(this, spliterator, z, intFunction);
        }
        return ((java8.util.stream.Node.Builder) wrapAndCopyInto(makeNodeBuilder(exactOutputSizeIfKnown(spliterator), intFunction), (java8.util.Spliterator) spliterator)).build2();
    }

    <P_IN> java8.util.stream.Node<E_OUT> opEvaluateParallel(java8.util.stream.PipelineHelper<E_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<E_OUT[]> intFunction) {
        throw new java.lang.UnsupportedOperationException("Parallel evaluation is not supported");
    }

    static /* synthetic */ java.lang.Object[] lambda$opEvaluateParallelLazy$79(int i) {
        return new java.lang.Object[i];
    }

    <P_IN> java8.util.Spliterator<E_OUT> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<E_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
        return opEvaluateParallel(pipelineHelper, spliterator, java8.util.stream.AbstractPipeline$$Lambda$3.instance).spliterator();
    }
}
