package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
abstract class DoublePipeline<E_IN> extends java8.util.stream.AbstractPipeline<E_IN, java.lang.Double, java8.util.stream.DoubleStream> implements java8.util.stream.DoubleStream {
    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
    public /* bridge */ /* synthetic */ java8.util.stream.DoubleStream parallel() {
        return (java8.util.stream.DoubleStream) super.parallel();
    }

    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
    public /* bridge */ /* synthetic */ java8.util.stream.DoubleStream sequential() {
        return (java8.util.stream.DoubleStream) super.sequential();
    }

    DoublePipeline(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Double>> supplier, int i, boolean z) {
        super(supplier, i, z);
    }

    DoublePipeline(java8.util.Spliterator<java.lang.Double> spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    DoublePipeline(java8.util.stream.AbstractPipeline<?, E_IN, ?> abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    private static java8.util.function.DoubleConsumer adapt(java8.util.stream.Sink<java.lang.Double> sink) {
        if (sink instanceof java8.util.function.DoubleConsumer) {
            return (java8.util.function.DoubleConsumer) sink;
        }
        sink.getClass();
        return java8.util.stream.DoublePipeline$$Lambda$1.lambdaFactory$(sink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java8.util.Spliterator.OfDouble adapt(java8.util.Spliterator<java.lang.Double> spliterator) {
        if (spliterator instanceof java8.util.Spliterator.OfDouble) {
            return (java8.util.Spliterator.OfDouble) spliterator;
        }
        throw new java.lang.UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    @Override // java8.util.stream.AbstractPipeline
    final java8.util.stream.StreamShape getOutputShape() {
        return java8.util.stream.StreamShape.DOUBLE_VALUE;
    }

    @Override // java8.util.stream.AbstractPipeline
    final <P_IN> java8.util.stream.Node<java.lang.Double> evaluateToNode(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z, java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
        return java8.util.stream.Nodes.collectDouble(pipelineHelper, spliterator, z);
    }

    @Override // java8.util.stream.AbstractPipeline
    final <P_IN> java8.util.Spliterator<java.lang.Double> wrap(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.function.Supplier<java8.util.Spliterator<P_IN>> supplier, boolean z) {
        return new java8.util.stream.StreamSpliterators.DoubleWrappingSpliterator(pipelineHelper, supplier, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java8.util.stream.AbstractPipeline
    /* JADX INFO: renamed from: lazySpliterator, reason: merged with bridge method [inline-methods] */
    public final java8.util.Spliterator<java.lang.Double> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Double>> supplier) {
        return new java8.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble(supplier);
    }

    @Override // java8.util.stream.AbstractPipeline
    final boolean forEachWithCancel(java8.util.Spliterator<java.lang.Double> spliterator, java8.util.stream.Sink<java.lang.Double> sink) {
        boolean zCancellationRequested;
        java8.util.Spliterator.OfDouble ofDoubleAdapt = adapt(spliterator);
        java8.util.function.DoubleConsumer doubleConsumerAdapt = adapt(sink);
        do {
            zCancellationRequested = sink.cancellationRequested();
            if (zCancellationRequested) {
                break;
            }
        } while (ofDoubleAdapt.tryAdvance(doubleConsumerAdapt));
        return zCancellationRequested;
    }

    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.PipelineHelper
    final java8.util.stream.Node.Builder<java.lang.Double> makeNodeBuilder(long j, java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
        return java8.util.stream.Nodes.doubleBuilder(j);
    }

    private <U> java8.util.stream.Stream<U> mapToObj(final java8.util.function.DoubleFunction<? extends U> doubleFunction, int i) {
        return new java8.util.stream.ReferencePipeline.StatelessOp<java.lang.Double, U>(this, java8.util.stream.StreamShape.DOUBLE_VALUE, i) { // from class: java8.util.stream.DoublePipeline.1
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Double> opWrapSink(int i2, java8.util.stream.Sink<U> sink) {
                return new java8.util.stream.Sink.ChainedDouble<U>(sink) { // from class: java8.util.stream.DoublePipeline.1.1
                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // java8.util.stream.Sink.OfDouble, java8.util.stream.Sink
                    public void accept(double d) {
                        this.downstream.accept((java.lang.Object) doubleFunction.apply(d));
                    }
                };
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java8.util.Spliterator$OfDouble] */
    @Override // java8.util.stream.BaseStream
    public final java.util.Iterator<java.lang.Double> iterator() {
        return java8.util.Spliterators.iterator((java8.util.Spliterator.OfDouble) spliterator2());
    }

    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
    /* JADX INFO: renamed from: spliterator, reason: merged with bridge method [inline-methods] */
    public final java8.util.Spliterator<java.lang.Double> spliterator2() {
        return adapt((java8.util.Spliterator<java.lang.Double>) super.spliterator2());
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.Stream<java.lang.Double> boxed() {
        return mapToObj(java8.util.stream.DoublePipeline$$Lambda$2.instance, 0);
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.DoubleStream map(final java8.util.function.DoubleUnaryOperator doubleUnaryOperator) {
        java8.util.Objects.requireNonNull(doubleUnaryOperator);
        return new java8.util.stream.DoublePipeline.StatelessOp<java.lang.Double>(this, java8.util.stream.StreamShape.DOUBLE_VALUE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.DoublePipeline.2
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Double> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return new java8.util.stream.Sink.ChainedDouble<java.lang.Double>(sink) { // from class: java8.util.stream.DoublePipeline.2.1
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
                    @Override // java8.util.stream.Sink.OfDouble, java8.util.stream.Sink
                    public void accept(double d) {
                        this.downstream.accept(doubleUnaryOperator.applyAsDouble(d));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.DoubleStream
    public final <U> java8.util.stream.Stream<U> mapToObj(java8.util.function.DoubleFunction<? extends U> doubleFunction) {
        java8.util.Objects.requireNonNull(doubleFunction);
        return mapToObj(doubleFunction, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT);
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.IntStream mapToInt(final java8.util.function.DoubleToIntFunction doubleToIntFunction) {
        java8.util.Objects.requireNonNull(doubleToIntFunction);
        return new java8.util.stream.IntPipeline.StatelessOp<java.lang.Double>(this, java8.util.stream.StreamShape.DOUBLE_VALUE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.DoublePipeline.3
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Double> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
                return new java8.util.stream.Sink.ChainedDouble<java.lang.Integer>(sink) { // from class: java8.util.stream.DoublePipeline.3.1
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
                    @Override // java8.util.stream.Sink.OfDouble, java8.util.stream.Sink
                    public void accept(double d) {
                        this.downstream.accept(doubleToIntFunction.applyAsInt(d));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.LongStream mapToLong(final java8.util.function.DoubleToLongFunction doubleToLongFunction) {
        java8.util.Objects.requireNonNull(doubleToLongFunction);
        return new java8.util.stream.LongPipeline.StatelessOp<java.lang.Double>(this, java8.util.stream.StreamShape.DOUBLE_VALUE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.DoublePipeline.4
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Double> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
                return new java8.util.stream.Sink.ChainedDouble<java.lang.Long>(sink) { // from class: java8.util.stream.DoublePipeline.4.1
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
                    @Override // java8.util.stream.Sink.OfDouble, java8.util.stream.Sink
                    public void accept(double d) {
                        this.downstream.accept(doubleToLongFunction.applyAsLong(d));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.DoubleStream flatMap(final java8.util.function.DoubleFunction<? extends java8.util.stream.DoubleStream> doubleFunction) {
        java8.util.Objects.requireNonNull(doubleFunction);
        return new java8.util.stream.DoublePipeline.StatelessOp<java.lang.Double>(this, java8.util.stream.StreamShape.DOUBLE_VALUE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT | java8.util.stream.StreamOpFlag.NOT_SIZED) { // from class: java8.util.stream.DoublePipeline.5
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Double> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return new java8.util.stream.Sink.ChainedDouble<java.lang.Double>(sink) { // from class: java8.util.stream.DoublePipeline.5.1
                    boolean cancellationRequested;
                    java8.util.function.DoubleConsumer downstreamAsDouble;

                    {
                        java8.util.stream.Sink<? super E_OUT> sink2 = this.downstream;
                        sink2.getClass();
                        this.downstreamAsDouble = java8.util.stream.DoublePipeline$5$1$$Lambda$1.lambdaFactory$(sink2);
                    }

                    @Override // java8.util.stream.Sink.ChainedDouble, java8.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference failed for: r4v5, types: [java8.util.Spliterator$OfDouble] */
                    @Override // java8.util.stream.Sink.OfDouble, java8.util.stream.Sink
                    public void accept(double d) throws java.lang.Throwable {
                        java8.util.stream.DoubleStream doubleStream = null;
                        try {
                            java8.util.stream.DoubleStream doubleStream2 = (java8.util.stream.DoubleStream) doubleFunction.apply(d);
                            if (doubleStream2 != null) {
                                try {
                                    if (!this.cancellationRequested) {
                                        doubleStream2.sequential().forEach(this.downstreamAsDouble);
                                    } else {
                                        ?? Spliterator2 = doubleStream2.sequential().spliterator2();
                                        while (!this.downstream.cancellationRequested() && Spliterator2.tryAdvance(this.downstreamAsDouble)) {
                                        }
                                    }
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    doubleStream = doubleStream2;
                                    if (doubleStream != null) {
                                        doubleStream.close();
                                    }
                                    throw th;
                                }
                            }
                            if (doubleStream2 != null) {
                                doubleStream2.close();
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                    }

                    @Override // java8.util.stream.Sink.ChainedDouble, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        this.cancellationRequested = true;
                        return this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.BaseStream
    public java8.util.stream.DoubleStream unordered() {
        return !isOrdered() ? this : new java8.util.stream.DoublePipeline.StatelessOp<java.lang.Double>(this, java8.util.stream.StreamShape.DOUBLE_VALUE, java8.util.stream.StreamOpFlag.NOT_ORDERED) { // from class: java8.util.stream.DoublePipeline.6
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Double> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return sink;
            }
        };
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.DoubleStream filter(final java8.util.function.DoublePredicate doublePredicate) {
        java8.util.Objects.requireNonNull(doublePredicate);
        return new java8.util.stream.DoublePipeline.StatelessOp<java.lang.Double>(this, java8.util.stream.StreamShape.DOUBLE_VALUE, java8.util.stream.StreamOpFlag.NOT_SIZED) { // from class: java8.util.stream.DoublePipeline.7
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Double> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return new java8.util.stream.Sink.ChainedDouble<java.lang.Double>(sink) { // from class: java8.util.stream.DoublePipeline.7.1
                    @Override // java8.util.stream.Sink.ChainedDouble, java8.util.stream.Sink
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
                    @Override // java8.util.stream.Sink.OfDouble, java8.util.stream.Sink
                    public void accept(double d) {
                        if (doublePredicate.test(d)) {
                            this.downstream.accept(d);
                        }
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.DoubleStream peek(final java8.util.function.DoubleConsumer doubleConsumer) {
        java8.util.Objects.requireNonNull(doubleConsumer);
        return new java8.util.stream.DoublePipeline.StatelessOp<java.lang.Double>(this, java8.util.stream.StreamShape.DOUBLE_VALUE, 0) { // from class: java8.util.stream.DoublePipeline.8
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Double> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return new java8.util.stream.Sink.ChainedDouble<java.lang.Double>(sink) { // from class: java8.util.stream.DoublePipeline.8.1
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
                    @Override // java8.util.stream.Sink.OfDouble, java8.util.stream.Sink
                    public void accept(double d) {
                        doubleConsumer.accept(d);
                        this.downstream.accept(d);
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.DoubleStream limit(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(java.lang.Long.toString(j));
        }
        return java8.util.stream.SliceOps.makeDouble(this, 0L, j);
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.DoubleStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : java8.util.stream.SliceOps.makeDouble(this, j, -1L);
        }
        throw new java.lang.IllegalArgumentException(java.lang.Long.toString(j));
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.DoubleStream takeWhile(java8.util.function.DoublePredicate doublePredicate) {
        return java8.util.stream.WhileOps.makeTakeWhileDouble(this, doublePredicate);
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.DoubleStream dropWhile(java8.util.function.DoublePredicate doublePredicate) {
        return java8.util.stream.WhileOps.makeDropWhileDouble(this, doublePredicate);
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.DoubleStream sorted() {
        return java8.util.stream.SortedOps.makeDouble(this);
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.stream.DoubleStream distinct() {
        return boxed().distinct().mapToDouble(java8.util.stream.DoublePipeline$$Lambda$3.instance);
    }

    @Override // java8.util.stream.DoubleStream
    public void forEach(java8.util.function.DoubleConsumer doubleConsumer) {
        evaluate(java8.util.stream.ForEachOps.makeDouble(doubleConsumer, false));
    }

    @Override // java8.util.stream.DoubleStream
    public void forEachOrdered(java8.util.function.DoubleConsumer doubleConsumer) {
        evaluate(java8.util.stream.ForEachOps.makeDouble(doubleConsumer, true));
    }

    static /* synthetic */ double[] lambda$sum$82() {
        return new double[3];
    }

    @Override // java8.util.stream.DoubleStream
    public final double sum() {
        return java8.util.stream.Collectors.computeFinalSum((double[]) collect(java8.util.stream.DoublePipeline$$Lambda$4.instance, java8.util.stream.DoublePipeline$$Lambda$5.instance, java8.util.stream.DoublePipeline$$Lambda$6.instance));
    }

    static /* synthetic */ void lambda$sum$83(double[] dArr, double d) {
        java8.util.stream.Collectors.sumWithCompensation(dArr, d);
        dArr[2] = dArr[2] + d;
    }

    static /* synthetic */ void lambda$sum$84(double[] dArr, double[] dArr2) {
        java8.util.stream.Collectors.sumWithCompensation(dArr, dArr2[0]);
        java8.util.stream.Collectors.sumWithCompensation(dArr, -dArr2[1]);
        dArr[2] = dArr[2] + dArr2[2];
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.OptionalDouble min() {
        return reduce(java8.util.stream.DoublePipeline$$Lambda$7.instance);
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.OptionalDouble max() {
        return reduce(java8.util.stream.DoublePipeline$$Lambda$8.instance);
    }

    static /* synthetic */ double[] lambda$average$85() {
        return new double[4];
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.OptionalDouble average() {
        double[] dArr = (double[]) collect(java8.util.stream.DoublePipeline$$Lambda$9.instance, java8.util.stream.DoublePipeline$$Lambda$10.instance, java8.util.stream.DoublePipeline$$Lambda$11.instance);
        if (dArr[2] > 0.0d) {
            return java8.util.OptionalDouble.of(java8.util.stream.Collectors.computeFinalSum(dArr) / dArr[2]);
        }
        return java8.util.OptionalDouble.empty();
    }

    static /* synthetic */ void lambda$average$86(double[] dArr, double d) {
        dArr[2] = dArr[2] + 1.0d;
        java8.util.stream.Collectors.sumWithCompensation(dArr, d);
        dArr[3] = dArr[3] + d;
    }

    static /* synthetic */ void lambda$average$87(double[] dArr, double[] dArr2) {
        java8.util.stream.Collectors.sumWithCompensation(dArr, dArr2[0]);
        java8.util.stream.Collectors.sumWithCompensation(dArr, -dArr2[1]);
        dArr[2] = dArr[2] + dArr2[2];
        dArr[3] = dArr[3] + dArr2[3];
    }

    @Override // java8.util.stream.DoubleStream
    public final long count() {
        return ((java.lang.Long) evaluate(java8.util.stream.ReduceOps.makeDoubleCounting())).longValue();
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.DoubleSummaryStatistics summaryStatistics() {
        return (java8.util.DoubleSummaryStatistics) collect(java8.util.stream.Collectors.DBL_SUM_STATS, java8.util.stream.DoublePipeline$$Lambda$12.instance, java8.util.stream.DoublePipeline$$Lambda$13.instance);
    }

    @Override // java8.util.stream.DoubleStream
    public final double reduce(double d, java8.util.function.DoubleBinaryOperator doubleBinaryOperator) {
        return ((java.lang.Double) evaluate(java8.util.stream.ReduceOps.makeDouble(d, doubleBinaryOperator))).doubleValue();
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.OptionalDouble reduce(java8.util.function.DoubleBinaryOperator doubleBinaryOperator) {
        return (java8.util.OptionalDouble) evaluate(java8.util.stream.ReduceOps.makeDouble(doubleBinaryOperator));
    }

    @Override // java8.util.stream.DoubleStream
    public final <R> R collect(java8.util.function.Supplier<R> supplier, java8.util.function.ObjDoubleConsumer<R> objDoubleConsumer, java8.util.function.BiConsumer<R, R> biConsumer) {
        java8.util.Objects.requireNonNull(biConsumer);
        return (R) evaluate(java8.util.stream.ReduceOps.makeDouble(supplier, objDoubleConsumer, java8.util.stream.DoublePipeline$$Lambda$14.lambdaFactory$(biConsumer)));
    }

    static /* synthetic */ java.lang.Object lambda$collect$88(java8.util.function.BiConsumer biConsumer, java.lang.Object obj, java.lang.Object obj2) {
        biConsumer.accept(obj, obj2);
        return obj;
    }

    @Override // java8.util.stream.DoubleStream
    public final boolean anyMatch(java8.util.function.DoublePredicate doublePredicate) {
        return ((java.lang.Boolean) evaluate(java8.util.stream.MatchOps.makeDouble(doublePredicate, java8.util.stream.MatchOps.MatchKind.ANY))).booleanValue();
    }

    @Override // java8.util.stream.DoubleStream
    public final boolean allMatch(java8.util.function.DoublePredicate doublePredicate) {
        return ((java.lang.Boolean) evaluate(java8.util.stream.MatchOps.makeDouble(doublePredicate, java8.util.stream.MatchOps.MatchKind.ALL))).booleanValue();
    }

    @Override // java8.util.stream.DoubleStream
    public final boolean noneMatch(java8.util.function.DoublePredicate doublePredicate) {
        return ((java.lang.Boolean) evaluate(java8.util.stream.MatchOps.makeDouble(doublePredicate, java8.util.stream.MatchOps.MatchKind.NONE))).booleanValue();
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.OptionalDouble findFirst() {
        return (java8.util.OptionalDouble) evaluate(java8.util.stream.FindOps.makeDouble(true));
    }

    @Override // java8.util.stream.DoubleStream
    public final java8.util.OptionalDouble findAny() {
        return (java8.util.OptionalDouble) evaluate(java8.util.stream.FindOps.makeDouble(false));
    }

    @Override // java8.util.stream.DoubleStream
    public final double[] toArray() {
        return java8.util.stream.Nodes.flattenDouble((java8.util.stream.Node.OfDouble) evaluateToArrayNode(java8.util.stream.WhileOps.DOUBLE_ARR_GEN)).asPrimitiveArray();
    }

    static class Head<E_IN> extends java8.util.stream.DoublePipeline<E_IN> {
        @Override // java8.util.stream.DoublePipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java.util.Iterator<java.lang.Double> iterator() {
            return super.iterator();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.AbstractPipeline
        /* JADX INFO: renamed from: lazySpliterator */
        /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Double> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Double>> supplier) {
            return super.lazySpliterator2(supplier);
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.DoubleStream parallel() {
            return (java8.util.stream.DoubleStream) super.parallel();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.DoubleStream sequential() {
            return (java8.util.stream.DoubleStream) super.sequential();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        /* JADX INFO: renamed from: spliterator */
        public /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Double> spliterator2() {
            return super.spliterator2();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.BaseStream unordered() {
            return super.unordered();
        }

        Head(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Double>> supplier, int i, boolean z) {
            super(supplier, i, z);
        }

        Head(java8.util.Spliterator<java.lang.Double> spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        @Override // java8.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java8.util.stream.AbstractPipeline
        final java8.util.stream.Sink<E_IN> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.DoubleStream
        public void forEach(java8.util.function.DoubleConsumer doubleConsumer) {
            if (!isParallel()) {
                java8.util.stream.DoublePipeline.adapt(sourceStageSpliterator()).forEachRemaining(doubleConsumer);
            } else {
                super.forEach(doubleConsumer);
            }
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.DoubleStream
        public void forEachOrdered(java8.util.function.DoubleConsumer doubleConsumer) {
            if (!isParallel()) {
                java8.util.stream.DoublePipeline.adapt(sourceStageSpliterator()).forEachRemaining(doubleConsumer);
            } else {
                super.forEachOrdered(doubleConsumer);
            }
        }
    }

    static abstract class StatelessOp<E_IN> extends java8.util.stream.DoublePipeline<E_IN> {
        @Override // java8.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return false;
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java.util.Iterator<java.lang.Double> iterator() {
            return super.iterator();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.AbstractPipeline
        /* JADX INFO: renamed from: lazySpliterator */
        /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Double> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Double>> supplier) {
            return super.lazySpliterator2(supplier);
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.DoubleStream parallel() {
            return (java8.util.stream.DoubleStream) super.parallel();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.DoubleStream sequential() {
            return (java8.util.stream.DoubleStream) super.sequential();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        /* JADX INFO: renamed from: spliterator */
        public /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Double> spliterator2() {
            return super.spliterator2();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.BaseStream unordered() {
            return super.unordered();
        }

        StatelessOp(java8.util.stream.AbstractPipeline<?, E_IN, ?> abstractPipeline, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }
    }

    static abstract class StatefulOp<E_IN> extends java8.util.stream.DoublePipeline<E_IN> {
        @Override // java8.util.stream.AbstractPipeline
        abstract <P_IN> java8.util.stream.Node<java.lang.Double> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Double[]> intFunction);

        @Override // java8.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return true;
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java.util.Iterator<java.lang.Double> iterator() {
            return super.iterator();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.AbstractPipeline
        /* JADX INFO: renamed from: lazySpliterator */
        /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Double> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Double>> supplier) {
            return super.lazySpliterator2(supplier);
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.DoubleStream parallel() {
            return (java8.util.stream.DoubleStream) super.parallel();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.DoubleStream sequential() {
            return (java8.util.stream.DoubleStream) super.sequential();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        /* JADX INFO: renamed from: spliterator */
        public /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Double> spliterator2() {
            return super.spliterator2();
        }

        @Override // java8.util.stream.DoublePipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.BaseStream unordered() {
            return super.unordered();
        }

        StatefulOp(java8.util.stream.AbstractPipeline<?, E_IN, ?> abstractPipeline, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }
    }
}
