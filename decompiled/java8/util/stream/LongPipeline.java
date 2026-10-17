package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
abstract class LongPipeline<E_IN> extends java8.util.stream.AbstractPipeline<E_IN, java.lang.Long, java8.util.stream.LongStream> implements java8.util.stream.LongStream {
    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
    public /* bridge */ /* synthetic */ java8.util.stream.LongStream parallel() {
        return (java8.util.stream.LongStream) super.parallel();
    }

    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
    public /* bridge */ /* synthetic */ java8.util.stream.LongStream sequential() {
        return (java8.util.stream.LongStream) super.sequential();
    }

    LongPipeline(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Long>> supplier, int i, boolean z) {
        super(supplier, i, z);
    }

    LongPipeline(java8.util.Spliterator<java.lang.Long> spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    LongPipeline(java8.util.stream.AbstractPipeline<?, E_IN, ?> abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    private static java8.util.function.LongConsumer adapt(java8.util.stream.Sink<java.lang.Long> sink) {
        if (sink instanceof java8.util.function.LongConsumer) {
            return (java8.util.function.LongConsumer) sink;
        }
        sink.getClass();
        return java8.util.stream.LongPipeline$$Lambda$1.lambdaFactory$(sink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java8.util.Spliterator.OfLong adapt(java8.util.Spliterator<java.lang.Long> spliterator) {
        if (spliterator instanceof java8.util.Spliterator.OfLong) {
            return (java8.util.Spliterator.OfLong) spliterator;
        }
        throw new java.lang.UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    @Override // java8.util.stream.AbstractPipeline
    final java8.util.stream.StreamShape getOutputShape() {
        return java8.util.stream.StreamShape.LONG_VALUE;
    }

    @Override // java8.util.stream.AbstractPipeline
    final <P_IN> java8.util.stream.Node<java.lang.Long> evaluateToNode(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z, java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
        return java8.util.stream.Nodes.collectLong(pipelineHelper, spliterator, z);
    }

    @Override // java8.util.stream.AbstractPipeline
    final <P_IN> java8.util.Spliterator<java.lang.Long> wrap(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.function.Supplier<java8.util.Spliterator<P_IN>> supplier, boolean z) {
        return new java8.util.stream.StreamSpliterators.LongWrappingSpliterator(pipelineHelper, supplier, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java8.util.stream.AbstractPipeline
    /* JADX INFO: renamed from: lazySpliterator */
    public final java8.util.Spliterator<java.lang.Long> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Long>> supplier) {
        return new java8.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong(supplier);
    }

    @Override // java8.util.stream.AbstractPipeline
    final boolean forEachWithCancel(java8.util.Spliterator<java.lang.Long> spliterator, java8.util.stream.Sink<java.lang.Long> sink) {
        boolean zCancellationRequested;
        java8.util.Spliterator.OfLong ofLongAdapt = adapt(spliterator);
        java8.util.function.LongConsumer longConsumerAdapt = adapt(sink);
        do {
            zCancellationRequested = sink.cancellationRequested();
            if (zCancellationRequested) {
                break;
            }
        } while (ofLongAdapt.tryAdvance(longConsumerAdapt));
        return zCancellationRequested;
    }

    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.PipelineHelper
    final java8.util.stream.Node.Builder<java.lang.Long> makeNodeBuilder(long j, java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
        return java8.util.stream.Nodes.longBuilder(j);
    }

    private <U> java8.util.stream.Stream<U> mapToObj(final java8.util.function.LongFunction<? extends U> longFunction, int i) {
        return new java8.util.stream.ReferencePipeline.StatelessOp<java.lang.Long, U>(this, java8.util.stream.StreamShape.LONG_VALUE, i) { // from class: java8.util.stream.LongPipeline.1
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Long> opWrapSink(int i2, java8.util.stream.Sink<U> sink) {
                return new java8.util.stream.Sink.ChainedLong<U>(sink) { // from class: java8.util.stream.LongPipeline.1.1
                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // java8.util.stream.Sink.OfLong, java8.util.stream.Sink
                    public void accept(long j) {
                        this.downstream.accept((java.lang.Object) longFunction.apply(j));
                    }
                };
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java8.util.Spliterator$OfLong] */
    @Override // java8.util.stream.BaseStream
    public final java.util.Iterator<java.lang.Long> iterator() {
        return java8.util.Spliterators.iterator((java8.util.Spliterator.OfLong) spliterator2());
    }

    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
    /* JADX INFO: renamed from: spliterator */
    public final java8.util.Spliterator<java.lang.Long> spliterator2() {
        return adapt((java8.util.Spliterator<java.lang.Long>) super.spliterator2());
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.DoubleStream asDoubleStream() {
        return new java8.util.stream.DoublePipeline.StatelessOp<java.lang.Long>(this, java8.util.stream.StreamShape.LONG_VALUE, java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.LongPipeline.2
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Long> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return new java8.util.stream.Sink.ChainedLong<java.lang.Double>(sink) { // from class: java8.util.stream.LongPipeline.2.1
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // java8.util.stream.Sink.OfLong, java8.util.stream.Sink
                    public void accept(long j) {
                        this.downstream.accept(j);
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.Stream<java.lang.Long> boxed() {
        return mapToObj(java8.util.stream.LongPipeline$$Lambda$2.instance, 0);
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.LongStream map(final java8.util.function.LongUnaryOperator longUnaryOperator) {
        java8.util.Objects.requireNonNull(longUnaryOperator);
        return new java8.util.stream.LongPipeline.StatelessOp<java.lang.Long>(this, java8.util.stream.StreamShape.LONG_VALUE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.LongPipeline.3
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Long> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
                return new java8.util.stream.Sink.ChainedLong<java.lang.Long>(sink) { // from class: java8.util.stream.LongPipeline.3.1
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // java8.util.stream.Sink.OfLong, java8.util.stream.Sink
                    public void accept(long j) {
                        this.downstream.accept(longUnaryOperator.applyAsLong(j));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.LongStream
    public final <U> java8.util.stream.Stream<U> mapToObj(java8.util.function.LongFunction<? extends U> longFunction) {
        java8.util.Objects.requireNonNull(longFunction);
        return mapToObj(longFunction, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT);
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.IntStream mapToInt(final java8.util.function.LongToIntFunction longToIntFunction) {
        java8.util.Objects.requireNonNull(longToIntFunction);
        return new java8.util.stream.IntPipeline.StatelessOp<java.lang.Long>(this, java8.util.stream.StreamShape.LONG_VALUE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.LongPipeline.4
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Long> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
                return new java8.util.stream.Sink.ChainedLong<java.lang.Integer>(sink) { // from class: java8.util.stream.LongPipeline.4.1
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // java8.util.stream.Sink.OfLong, java8.util.stream.Sink
                    public void accept(long j) {
                        this.downstream.accept(longToIntFunction.applyAsInt(j));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.DoubleStream mapToDouble(final java8.util.function.LongToDoubleFunction longToDoubleFunction) {
        java8.util.Objects.requireNonNull(longToDoubleFunction);
        return new java8.util.stream.DoublePipeline.StatelessOp<java.lang.Long>(this, java8.util.stream.StreamShape.LONG_VALUE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.LongPipeline.5
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Long> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return new java8.util.stream.Sink.ChainedLong<java.lang.Double>(sink) { // from class: java8.util.stream.LongPipeline.5.1
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // java8.util.stream.Sink.OfLong, java8.util.stream.Sink
                    public void accept(long j) {
                        this.downstream.accept(longToDoubleFunction.applyAsDouble(j));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.LongStream flatMap(final java8.util.function.LongFunction<? extends java8.util.stream.LongStream> longFunction) {
        java8.util.Objects.requireNonNull(longFunction);
        return new java8.util.stream.LongPipeline.StatelessOp<java.lang.Long>(this, java8.util.stream.StreamShape.LONG_VALUE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT | java8.util.stream.StreamOpFlag.NOT_SIZED) { // from class: java8.util.stream.LongPipeline.6
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Long> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
                return new java8.util.stream.Sink.ChainedLong<java.lang.Long>(sink) { // from class: java8.util.stream.LongPipeline.6.1
                    boolean cancellationRequested;
                    java8.util.function.LongConsumer downstreamAsLong;

                    {
                        java8.util.stream.Sink<? super E_OUT> sink2 = this.downstream;
                        sink2.getClass();
                        this.downstreamAsLong = java8.util.stream.LongPipeline$6$1$$Lambda$1.lambdaFactory$(sink2);
                    }

                    @Override // java8.util.stream.Sink.ChainedLong, java8.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference failed for: r4v5, types: [java8.util.Spliterator$OfLong] */
                    @Override // java8.util.stream.Sink.OfLong, java8.util.stream.Sink
                    public void accept(long j) throws java.lang.Throwable {
                        java8.util.stream.LongStream longStream = null;
                        try {
                            java8.util.stream.LongStream longStream2 = (java8.util.stream.LongStream) longFunction.apply(j);
                            if (longStream2 != null) {
                                try {
                                    if (!this.cancellationRequested) {
                                        longStream2.sequential().forEach(this.downstreamAsLong);
                                    } else {
                                        ?? Spliterator2 = longStream2.sequential().spliterator2();
                                        while (!this.downstream.cancellationRequested() && Spliterator2.tryAdvance(this.downstreamAsLong)) {
                                        }
                                    }
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    longStream = longStream2;
                                    if (longStream != null) {
                                        longStream.close();
                                    }
                                    throw th;
                                }
                            }
                            if (longStream2 != null) {
                                longStream2.close();
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                    }

                    @Override // java8.util.stream.Sink.ChainedLong, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        this.cancellationRequested = true;
                        return this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.BaseStream
    public java8.util.stream.LongStream unordered() {
        return !isOrdered() ? this : new java8.util.stream.LongPipeline.StatelessOp<java.lang.Long>(this, java8.util.stream.StreamShape.LONG_VALUE, java8.util.stream.StreamOpFlag.NOT_ORDERED) { // from class: java8.util.stream.LongPipeline.7
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Long> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
                return sink;
            }
        };
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.LongStream filter(final java8.util.function.LongPredicate longPredicate) {
        java8.util.Objects.requireNonNull(longPredicate);
        return new java8.util.stream.LongPipeline.StatelessOp<java.lang.Long>(this, java8.util.stream.StreamShape.LONG_VALUE, java8.util.stream.StreamOpFlag.NOT_SIZED) { // from class: java8.util.stream.LongPipeline.8
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Long> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
                return new java8.util.stream.Sink.ChainedLong<java.lang.Long>(sink) { // from class: java8.util.stream.LongPipeline.8.1
                    @Override // java8.util.stream.Sink.ChainedLong, java8.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // java8.util.stream.Sink.OfLong, java8.util.stream.Sink
                    public void accept(long j) {
                        if (longPredicate.test(j)) {
                            this.downstream.accept(j);
                        }
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.LongStream peek(final java8.util.function.LongConsumer longConsumer) {
        java8.util.Objects.requireNonNull(longConsumer);
        return new java8.util.stream.LongPipeline.StatelessOp<java.lang.Long>(this, java8.util.stream.StreamShape.LONG_VALUE, 0) { // from class: java8.util.stream.LongPipeline.9
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Long> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
                return new java8.util.stream.Sink.ChainedLong<java.lang.Long>(sink) { // from class: java8.util.stream.LongPipeline.9.1
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // java8.util.stream.Sink.OfLong, java8.util.stream.Sink
                    public void accept(long j) {
                        longConsumer.accept(j);
                        this.downstream.accept(j);
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.LongStream limit(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(java.lang.Long.toString(j));
        }
        return java8.util.stream.SliceOps.makeLong(this, 0L, j);
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.LongStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : java8.util.stream.SliceOps.makeLong(this, j, -1L);
        }
        throw new java.lang.IllegalArgumentException(java.lang.Long.toString(j));
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.LongStream takeWhile(java8.util.function.LongPredicate longPredicate) {
        return java8.util.stream.WhileOps.makeTakeWhileLong(this, longPredicate);
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.LongStream dropWhile(java8.util.function.LongPredicate longPredicate) {
        return java8.util.stream.WhileOps.makeDropWhileLong(this, longPredicate);
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.LongStream sorted() {
        return java8.util.stream.SortedOps.makeLong(this);
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.stream.LongStream distinct() {
        return boxed().distinct().mapToLong(java8.util.stream.LongPipeline$$Lambda$3.instance);
    }

    @Override // java8.util.stream.LongStream
    public void forEach(java8.util.function.LongConsumer longConsumer) {
        evaluate(java8.util.stream.ForEachOps.makeLong(longConsumer, false));
    }

    @Override // java8.util.stream.LongStream
    public void forEachOrdered(java8.util.function.LongConsumer longConsumer) {
        evaluate(java8.util.stream.ForEachOps.makeLong(longConsumer, true));
    }

    @Override // java8.util.stream.LongStream
    public final long sum() {
        return reduce(0L, java8.util.stream.LongPipeline$$Lambda$4.instance);
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.OptionalLong min() {
        return reduce(java8.util.stream.LongPipeline$$Lambda$5.instance);
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.OptionalLong max() {
        return reduce(java8.util.stream.LongPipeline$$Lambda$6.instance);
    }

    static /* synthetic */ long[] lambda$average$90() {
        return new long[2];
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.OptionalDouble average() {
        long j = ((long[]) collect(java8.util.stream.LongPipeline$$Lambda$7.instance, java8.util.stream.LongPipeline$$Lambda$8.instance, java8.util.stream.LongPipeline$$Lambda$9.instance))[0];
        if (j > 0) {
            return java8.util.OptionalDouble.of(r0[1] / j);
        }
        return java8.util.OptionalDouble.empty();
    }

    static /* synthetic */ void lambda$average$91(long[] jArr, long j) {
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + j;
    }

    static /* synthetic */ void lambda$average$92(long[] jArr, long[] jArr2) {
        jArr[0] = jArr[0] + jArr2[0];
        jArr[1] = jArr[1] + jArr2[1];
    }

    @Override // java8.util.stream.LongStream
    public final long count() {
        return ((java.lang.Long) evaluate(java8.util.stream.ReduceOps.makeLongCounting())).longValue();
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.LongSummaryStatistics summaryStatistics() {
        return (java8.util.LongSummaryStatistics) collect(java8.util.stream.Collectors.LNG_SUM_STATS, java8.util.stream.LongPipeline$$Lambda$10.instance, java8.util.stream.LongPipeline$$Lambda$11.instance);
    }

    @Override // java8.util.stream.LongStream
    public final long reduce(long j, java8.util.function.LongBinaryOperator longBinaryOperator) {
        return ((java.lang.Long) evaluate(java8.util.stream.ReduceOps.makeLong(j, longBinaryOperator))).longValue();
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.OptionalLong reduce(java8.util.function.LongBinaryOperator longBinaryOperator) {
        return (java8.util.OptionalLong) evaluate(java8.util.stream.ReduceOps.makeLong(longBinaryOperator));
    }

    @Override // java8.util.stream.LongStream
    public final <R> R collect(java8.util.function.Supplier<R> supplier, java8.util.function.ObjLongConsumer<R> objLongConsumer, java8.util.function.BiConsumer<R, R> biConsumer) {
        java8.util.Objects.requireNonNull(biConsumer);
        return (R) evaluate(java8.util.stream.ReduceOps.makeLong(supplier, objLongConsumer, java8.util.stream.LongPipeline$$Lambda$12.lambdaFactory$(biConsumer)));
    }

    static /* synthetic */ java.lang.Object lambda$collect$93(java8.util.function.BiConsumer biConsumer, java.lang.Object obj, java.lang.Object obj2) {
        biConsumer.accept(obj, obj2);
        return obj;
    }

    @Override // java8.util.stream.LongStream
    public final boolean anyMatch(java8.util.function.LongPredicate longPredicate) {
        return ((java.lang.Boolean) evaluate(java8.util.stream.MatchOps.makeLong(longPredicate, java8.util.stream.MatchOps.MatchKind.ANY))).booleanValue();
    }

    @Override // java8.util.stream.LongStream
    public final boolean allMatch(java8.util.function.LongPredicate longPredicate) {
        return ((java.lang.Boolean) evaluate(java8.util.stream.MatchOps.makeLong(longPredicate, java8.util.stream.MatchOps.MatchKind.ALL))).booleanValue();
    }

    @Override // java8.util.stream.LongStream
    public final boolean noneMatch(java8.util.function.LongPredicate longPredicate) {
        return ((java.lang.Boolean) evaluate(java8.util.stream.MatchOps.makeLong(longPredicate, java8.util.stream.MatchOps.MatchKind.NONE))).booleanValue();
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.OptionalLong findFirst() {
        return (java8.util.OptionalLong) evaluate(java8.util.stream.FindOps.makeLong(true));
    }

    @Override // java8.util.stream.LongStream
    public final java8.util.OptionalLong findAny() {
        return (java8.util.OptionalLong) evaluate(java8.util.stream.FindOps.makeLong(false));
    }

    @Override // java8.util.stream.LongStream
    public final long[] toArray() {
        return java8.util.stream.Nodes.flattenLong((java8.util.stream.Node.OfLong) evaluateToArrayNode(java8.util.stream.WhileOps.LONG_ARR_GEN)).asPrimitiveArray();
    }

    static class Head<E_IN> extends java8.util.stream.LongPipeline<E_IN> {
        @Override // java8.util.stream.LongPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java.util.Iterator<java.lang.Long> iterator() {
            return super.iterator();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.AbstractPipeline
        /* JADX INFO: renamed from: lazySpliterator */
        /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Long> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Long>> supplier) {
            return super.lazySpliterator2(supplier);
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.LongStream parallel() {
            return (java8.util.stream.LongStream) super.parallel();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.LongStream sequential() {
            return (java8.util.stream.LongStream) super.sequential();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        /* JADX INFO: renamed from: spliterator */
        public /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Long> spliterator2() {
            return super.spliterator2();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.BaseStream unordered() {
            return super.unordered();
        }

        Head(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Long>> supplier, int i, boolean z) {
            super(supplier, i, z);
        }

        Head(java8.util.Spliterator<java.lang.Long> spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        @Override // java8.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java8.util.stream.AbstractPipeline
        final java8.util.stream.Sink<E_IN> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.LongStream
        public void forEach(java8.util.function.LongConsumer longConsumer) {
            if (!isParallel()) {
                java8.util.stream.LongPipeline.adapt(sourceStageSpliterator()).forEachRemaining(longConsumer);
            } else {
                super.forEach(longConsumer);
            }
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.LongStream
        public void forEachOrdered(java8.util.function.LongConsumer longConsumer) {
            if (!isParallel()) {
                java8.util.stream.LongPipeline.adapt(sourceStageSpliterator()).forEachRemaining(longConsumer);
            } else {
                super.forEachOrdered(longConsumer);
            }
        }
    }

    static abstract class StatelessOp<E_IN> extends java8.util.stream.LongPipeline<E_IN> {
        @Override // java8.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return false;
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java.util.Iterator<java.lang.Long> iterator() {
            return super.iterator();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.AbstractPipeline
        /* JADX INFO: renamed from: lazySpliterator */
        /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Long> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Long>> supplier) {
            return super.lazySpliterator2(supplier);
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.LongStream parallel() {
            return (java8.util.stream.LongStream) super.parallel();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.LongStream sequential() {
            return (java8.util.stream.LongStream) super.sequential();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        /* JADX INFO: renamed from: spliterator */
        public /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Long> spliterator2() {
            return super.spliterator2();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.BaseStream unordered() {
            return super.unordered();
        }

        StatelessOp(java8.util.stream.AbstractPipeline<?, E_IN, ?> abstractPipeline, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }
    }

    static abstract class StatefulOp<E_IN> extends java8.util.stream.LongPipeline<E_IN> {
        @Override // java8.util.stream.AbstractPipeline
        abstract <P_IN> java8.util.stream.Node<java.lang.Long> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Long[]> intFunction);

        @Override // java8.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return true;
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java.util.Iterator<java.lang.Long> iterator() {
            return super.iterator();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.AbstractPipeline
        /* JADX INFO: renamed from: lazySpliterator */
        /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Long> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Long>> supplier) {
            return super.lazySpliterator2(supplier);
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.LongStream parallel() {
            return (java8.util.stream.LongStream) super.parallel();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.LongStream sequential() {
            return (java8.util.stream.LongStream) super.sequential();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        /* JADX INFO: renamed from: spliterator */
        public /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Long> spliterator2() {
            return super.spliterator2();
        }

        @Override // java8.util.stream.LongPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.BaseStream unordered() {
            return super.unordered();
        }

        StatefulOp(java8.util.stream.AbstractPipeline<?, E_IN, ?> abstractPipeline, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }
    }
}
