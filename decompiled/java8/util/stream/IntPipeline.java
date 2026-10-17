package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
abstract class IntPipeline<E_IN> extends java8.util.stream.AbstractPipeline<E_IN, java.lang.Integer, java8.util.stream.IntStream> implements java8.util.stream.IntStream {
    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
    public /* bridge */ /* synthetic */ java8.util.stream.IntStream parallel() {
        return (java8.util.stream.IntStream) super.parallel();
    }

    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
    public /* bridge */ /* synthetic */ java8.util.stream.IntStream sequential() {
        return (java8.util.stream.IntStream) super.sequential();
    }

    IntPipeline(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Integer>> supplier, int i, boolean z) {
        super(supplier, i, z);
    }

    IntPipeline(java8.util.Spliterator<java.lang.Integer> spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    IntPipeline(java8.util.stream.AbstractPipeline<?, E_IN, ?> abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    private static java8.util.function.IntConsumer adapt(java8.util.stream.Sink<java.lang.Integer> sink) {
        if (sink instanceof java8.util.function.IntConsumer) {
            return (java8.util.function.IntConsumer) sink;
        }
        sink.getClass();
        return java8.util.stream.IntPipeline$$Lambda$1.lambdaFactory$(sink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java8.util.Spliterator.OfInt adapt(java8.util.Spliterator<java.lang.Integer> spliterator) {
        if (spliterator instanceof java8.util.Spliterator.OfInt) {
            return (java8.util.Spliterator.OfInt) spliterator;
        }
        throw new java.lang.UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    @Override // java8.util.stream.AbstractPipeline
    final java8.util.stream.StreamShape getOutputShape() {
        return java8.util.stream.StreamShape.INT_VALUE;
    }

    @Override // java8.util.stream.AbstractPipeline
    final <P_IN> java8.util.stream.Node<java.lang.Integer> evaluateToNode(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z, java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
        return java8.util.stream.Nodes.collectInt(pipelineHelper, spliterator, z);
    }

    @Override // java8.util.stream.AbstractPipeline
    final <P_IN> java8.util.Spliterator<java.lang.Integer> wrap(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.function.Supplier<java8.util.Spliterator<P_IN>> supplier, boolean z) {
        return new java8.util.stream.StreamSpliterators.IntWrappingSpliterator(pipelineHelper, supplier, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java8.util.stream.AbstractPipeline
    /* JADX INFO: renamed from: lazySpliterator */
    public final java8.util.Spliterator<java.lang.Integer> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Integer>> supplier) {
        return new java8.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt(supplier);
    }

    @Override // java8.util.stream.AbstractPipeline
    final boolean forEachWithCancel(java8.util.Spliterator<java.lang.Integer> spliterator, java8.util.stream.Sink<java.lang.Integer> sink) {
        boolean zCancellationRequested;
        java8.util.Spliterator.OfInt ofIntAdapt = adapt(spliterator);
        java8.util.function.IntConsumer intConsumerAdapt = adapt(sink);
        do {
            zCancellationRequested = sink.cancellationRequested();
            if (zCancellationRequested) {
                break;
            }
        } while (ofIntAdapt.tryAdvance(intConsumerAdapt));
        return zCancellationRequested;
    }

    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.PipelineHelper
    final java8.util.stream.Node.Builder<java.lang.Integer> makeNodeBuilder(long j, java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
        return java8.util.stream.Nodes.intBuilder(j);
    }

    private <U> java8.util.stream.Stream<U> mapToObj(final java8.util.function.IntFunction<? extends U> intFunction, int i) {
        return new java8.util.stream.ReferencePipeline.StatelessOp<java.lang.Integer, U>(this, java8.util.stream.StreamShape.INT_VALUE, i) { // from class: java8.util.stream.IntPipeline.1
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i2, java8.util.stream.Sink<U> sink) {
                return new java8.util.stream.Sink.ChainedInt<U>(sink) { // from class: java8.util.stream.IntPipeline.1.1
                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
                    public void accept(int i3) {
                        this.downstream.accept((java.lang.Object) intFunction.apply(i3));
                    }
                };
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java8.util.Spliterator$OfInt] */
    @Override // java8.util.stream.BaseStream
    public final java.util.Iterator<java.lang.Integer> iterator() {
        return java8.util.Spliterators.iterator((java8.util.Spliterator.OfInt) spliterator2());
    }

    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
    /* JADX INFO: renamed from: spliterator */
    public final java8.util.Spliterator<java.lang.Integer> spliterator2() {
        return adapt((java8.util.Spliterator<java.lang.Integer>) super.spliterator2());
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.LongStream asLongStream() {
        return new java8.util.stream.LongPipeline.StatelessOp<java.lang.Integer>(this, java8.util.stream.StreamShape.INT_VALUE, 0) { // from class: java8.util.stream.IntPipeline.2
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
                return new java8.util.stream.Sink.ChainedInt<java.lang.Long>(sink) { // from class: java8.util.stream.IntPipeline.2.1
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
                    @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
                    public void accept(int i2) {
                        this.downstream.accept(i2);
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.DoubleStream asDoubleStream() {
        return new java8.util.stream.DoublePipeline.StatelessOp<java.lang.Integer>(this, java8.util.stream.StreamShape.INT_VALUE, 0) { // from class: java8.util.stream.IntPipeline.3
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return new java8.util.stream.Sink.ChainedInt<java.lang.Double>(sink) { // from class: java8.util.stream.IntPipeline.3.1
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
                    @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
                    public void accept(int i2) {
                        this.downstream.accept(i2);
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.Stream<java.lang.Integer> boxed() {
        return mapToObj(java8.util.stream.IntPipeline$$Lambda$2.instance, 0);
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.IntStream map(final java8.util.function.IntUnaryOperator intUnaryOperator) {
        java8.util.Objects.requireNonNull(intUnaryOperator);
        return new java8.util.stream.IntPipeline.StatelessOp<java.lang.Integer>(this, java8.util.stream.StreamShape.INT_VALUE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.IntPipeline.4
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
                return new java8.util.stream.Sink.ChainedInt<java.lang.Integer>(sink) { // from class: java8.util.stream.IntPipeline.4.1
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
                    @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
                    public void accept(int i2) {
                        this.downstream.accept(intUnaryOperator.applyAsInt(i2));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.IntStream
    public final <U> java8.util.stream.Stream<U> mapToObj(java8.util.function.IntFunction<? extends U> intFunction) {
        java8.util.Objects.requireNonNull(intFunction);
        return mapToObj(intFunction, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT);
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.LongStream mapToLong(final java8.util.function.IntToLongFunction intToLongFunction) {
        java8.util.Objects.requireNonNull(intToLongFunction);
        return new java8.util.stream.LongPipeline.StatelessOp<java.lang.Integer>(this, java8.util.stream.StreamShape.INT_VALUE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.IntPipeline.5
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
                return new java8.util.stream.Sink.ChainedInt<java.lang.Long>(sink) { // from class: java8.util.stream.IntPipeline.5.1
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
                    @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
                    public void accept(int i2) {
                        this.downstream.accept(intToLongFunction.applyAsLong(i2));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.DoubleStream mapToDouble(final java8.util.function.IntToDoubleFunction intToDoubleFunction) {
        java8.util.Objects.requireNonNull(intToDoubleFunction);
        return new java8.util.stream.DoublePipeline.StatelessOp<java.lang.Integer>(this, java8.util.stream.StreamShape.INT_VALUE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.IntPipeline.6
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return new java8.util.stream.Sink.ChainedInt<java.lang.Double>(sink) { // from class: java8.util.stream.IntPipeline.6.1
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
                    @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
                    public void accept(int i2) {
                        this.downstream.accept(intToDoubleFunction.applyAsDouble(i2));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.IntStream flatMap(final java8.util.function.IntFunction<? extends java8.util.stream.IntStream> intFunction) {
        java8.util.Objects.requireNonNull(intFunction);
        return new java8.util.stream.IntPipeline.StatelessOp<java.lang.Integer>(this, java8.util.stream.StreamShape.INT_VALUE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT | java8.util.stream.StreamOpFlag.NOT_SIZED) { // from class: java8.util.stream.IntPipeline.7
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
                return new java8.util.stream.Sink.ChainedInt<java.lang.Integer>(sink) { // from class: java8.util.stream.IntPipeline.7.1
                    boolean cancellationRequested;
                    java8.util.function.IntConsumer downstreamAsInt;

                    {
                        java8.util.stream.Sink<? super E_OUT> sink2 = this.downstream;
                        sink2.getClass();
                        this.downstreamAsInt = java8.util.stream.IntPipeline$7$1$$Lambda$1.lambdaFactory$(sink2);
                    }

                    @Override // java8.util.stream.Sink.ChainedInt, java8.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference failed for: r0v6, types: [java8.util.Spliterator$OfInt] */
                    @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
                    public void accept(int i2) throws java.lang.Throwable {
                        java.lang.Throwable th;
                        java8.util.stream.IntStream intStream;
                        try {
                            intStream = (java8.util.stream.IntStream) intFunction.apply(i2);
                            if (intStream != null) {
                                try {
                                    if (!this.cancellationRequested) {
                                        intStream.sequential().forEach(this.downstreamAsInt);
                                    } else {
                                        ?? Spliterator2 = intStream.sequential().spliterator2();
                                        while (!this.downstream.cancellationRequested() && Spliterator2.tryAdvance(this.downstreamAsInt)) {
                                        }
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    if (intStream != null) {
                                        intStream.close();
                                    }
                                    throw th;
                                }
                            }
                            if (intStream != null) {
                                intStream.close();
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            intStream = null;
                        }
                    }

                    @Override // java8.util.stream.Sink.ChainedInt, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        this.cancellationRequested = true;
                        return this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.BaseStream
    public java8.util.stream.IntStream unordered() {
        return !isOrdered() ? this : new java8.util.stream.IntPipeline.StatelessOp<java.lang.Integer>(this, java8.util.stream.StreamShape.INT_VALUE, java8.util.stream.StreamOpFlag.NOT_ORDERED) { // from class: java8.util.stream.IntPipeline.8
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
                return sink;
            }
        };
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.IntStream filter(final java8.util.function.IntPredicate intPredicate) {
        java8.util.Objects.requireNonNull(intPredicate);
        return new java8.util.stream.IntPipeline.StatelessOp<java.lang.Integer>(this, java8.util.stream.StreamShape.INT_VALUE, java8.util.stream.StreamOpFlag.NOT_SIZED) { // from class: java8.util.stream.IntPipeline.9
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
                return new java8.util.stream.Sink.ChainedInt<java.lang.Integer>(sink) { // from class: java8.util.stream.IntPipeline.9.1
                    @Override // java8.util.stream.Sink.ChainedInt, java8.util.stream.Sink
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
                    @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
                    public void accept(int i2) {
                        if (intPredicate.test(i2)) {
                            this.downstream.accept(i2);
                        }
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.IntStream peek(final java8.util.function.IntConsumer intConsumer) {
        java8.util.Objects.requireNonNull(intConsumer);
        return new java8.util.stream.IntPipeline.StatelessOp<java.lang.Integer>(this, java8.util.stream.StreamShape.INT_VALUE, 0) { // from class: java8.util.stream.IntPipeline.10
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
                return new java8.util.stream.Sink.ChainedInt<java.lang.Integer>(sink) { // from class: java8.util.stream.IntPipeline.10.1
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
                    @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
                    public void accept(int i2) {
                        intConsumer.accept(i2);
                        this.downstream.accept(i2);
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.IntStream limit(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(java.lang.Long.toString(j));
        }
        return java8.util.stream.SliceOps.makeInt(this, 0L, j);
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.IntStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : java8.util.stream.SliceOps.makeInt(this, j, -1L);
        }
        throw new java.lang.IllegalArgumentException(java.lang.Long.toString(j));
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.IntStream takeWhile(java8.util.function.IntPredicate intPredicate) {
        return java8.util.stream.WhileOps.makeTakeWhileInt(this, intPredicate);
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.IntStream dropWhile(java8.util.function.IntPredicate intPredicate) {
        return java8.util.stream.WhileOps.makeDropWhileInt(this, intPredicate);
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.IntStream sorted() {
        return java8.util.stream.SortedOps.makeInt(this);
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.stream.IntStream distinct() {
        return boxed().distinct().mapToInt(java8.util.stream.IntPipeline$$Lambda$3.instance);
    }

    @Override // java8.util.stream.IntStream
    public void forEach(java8.util.function.IntConsumer intConsumer) {
        evaluate(java8.util.stream.ForEachOps.makeInt(intConsumer, false));
    }

    @Override // java8.util.stream.IntStream
    public void forEachOrdered(java8.util.function.IntConsumer intConsumer) {
        evaluate(java8.util.stream.ForEachOps.makeInt(intConsumer, true));
    }

    @Override // java8.util.stream.IntStream
    public final int sum() {
        return reduce(0, java8.util.stream.IntPipeline$$Lambda$4.instance);
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.OptionalInt min() {
        return reduce(java8.util.stream.IntPipeline$$Lambda$5.instance);
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.OptionalInt max() {
        return reduce(java8.util.stream.IntPipeline$$Lambda$6.instance);
    }

    @Override // java8.util.stream.IntStream
    public final long count() {
        return ((java.lang.Long) evaluate(java8.util.stream.ReduceOps.makeIntCounting())).longValue();
    }

    static /* synthetic */ long[] lambda$average$95() {
        return new long[2];
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.OptionalDouble average() {
        long j = ((long[]) collect(java8.util.stream.IntPipeline$$Lambda$7.instance, java8.util.stream.IntPipeline$$Lambda$8.instance, java8.util.stream.IntPipeline$$Lambda$9.instance))[0];
        if (j > 0) {
            return java8.util.OptionalDouble.of(r0[1] / j);
        }
        return java8.util.OptionalDouble.empty();
    }

    static /* synthetic */ void lambda$average$96(long[] jArr, int i) {
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + ((long) i);
    }

    static /* synthetic */ void lambda$average$97(long[] jArr, long[] jArr2) {
        jArr[0] = jArr[0] + jArr2[0];
        jArr[1] = jArr[1] + jArr2[1];
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.IntSummaryStatistics summaryStatistics() {
        return (java8.util.IntSummaryStatistics) collect(java8.util.stream.Collectors.INT_SUM_STATS, java8.util.stream.IntPipeline$$Lambda$10.instance, java8.util.stream.IntPipeline$$Lambda$11.instance);
    }

    @Override // java8.util.stream.IntStream
    public final int reduce(int i, java8.util.function.IntBinaryOperator intBinaryOperator) {
        return ((java.lang.Integer) evaluate(java8.util.stream.ReduceOps.makeInt(i, intBinaryOperator))).intValue();
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.OptionalInt reduce(java8.util.function.IntBinaryOperator intBinaryOperator) {
        return (java8.util.OptionalInt) evaluate(java8.util.stream.ReduceOps.makeInt(intBinaryOperator));
    }

    @Override // java8.util.stream.IntStream
    public final <R> R collect(java8.util.function.Supplier<R> supplier, java8.util.function.ObjIntConsumer<R> objIntConsumer, java8.util.function.BiConsumer<R, R> biConsumer) {
        java8.util.Objects.requireNonNull(biConsumer);
        return (R) evaluate(java8.util.stream.ReduceOps.makeInt(supplier, objIntConsumer, java8.util.stream.IntPipeline$$Lambda$12.lambdaFactory$(biConsumer)));
    }

    static /* synthetic */ java.lang.Object lambda$collect$98(java8.util.function.BiConsumer biConsumer, java.lang.Object obj, java.lang.Object obj2) {
        biConsumer.accept(obj, obj2);
        return obj;
    }

    @Override // java8.util.stream.IntStream
    public final boolean anyMatch(java8.util.function.IntPredicate intPredicate) {
        return ((java.lang.Boolean) evaluate(java8.util.stream.MatchOps.makeInt(intPredicate, java8.util.stream.MatchOps.MatchKind.ANY))).booleanValue();
    }

    @Override // java8.util.stream.IntStream
    public final boolean allMatch(java8.util.function.IntPredicate intPredicate) {
        return ((java.lang.Boolean) evaluate(java8.util.stream.MatchOps.makeInt(intPredicate, java8.util.stream.MatchOps.MatchKind.ALL))).booleanValue();
    }

    @Override // java8.util.stream.IntStream
    public final boolean noneMatch(java8.util.function.IntPredicate intPredicate) {
        return ((java.lang.Boolean) evaluate(java8.util.stream.MatchOps.makeInt(intPredicate, java8.util.stream.MatchOps.MatchKind.NONE))).booleanValue();
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.OptionalInt findFirst() {
        return (java8.util.OptionalInt) evaluate(java8.util.stream.FindOps.makeInt(true));
    }

    @Override // java8.util.stream.IntStream
    public final java8.util.OptionalInt findAny() {
        return (java8.util.OptionalInt) evaluate(java8.util.stream.FindOps.makeInt(false));
    }

    @Override // java8.util.stream.IntStream
    public final int[] toArray() {
        return java8.util.stream.Nodes.flattenInt((java8.util.stream.Node.OfInt) evaluateToArrayNode(java8.util.stream.WhileOps.INT_ARR_GEN)).asPrimitiveArray();
    }

    static class Head<E_IN> extends java8.util.stream.IntPipeline<E_IN> {
        @Override // java8.util.stream.IntPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java.util.Iterator<java.lang.Integer> iterator() {
            return super.iterator();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.AbstractPipeline
        /* JADX INFO: renamed from: lazySpliterator */
        /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Integer> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Integer>> supplier) {
            return super.lazySpliterator2(supplier);
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.IntStream parallel() {
            return (java8.util.stream.IntStream) super.parallel();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.IntStream sequential() {
            return (java8.util.stream.IntStream) super.sequential();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        /* JADX INFO: renamed from: spliterator */
        public /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Integer> spliterator2() {
            return super.spliterator2();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.BaseStream unordered() {
            return super.unordered();
        }

        Head(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Integer>> supplier, int i, boolean z) {
            super(supplier, i, z);
        }

        Head(java8.util.Spliterator<java.lang.Integer> spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        @Override // java8.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java8.util.stream.AbstractPipeline
        final java8.util.stream.Sink<E_IN> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.IntStream
        public void forEach(java8.util.function.IntConsumer intConsumer) {
            if (!isParallel()) {
                java8.util.stream.IntPipeline.adapt(sourceStageSpliterator()).forEachRemaining(intConsumer);
            } else {
                super.forEach(intConsumer);
            }
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.IntStream
        public void forEachOrdered(java8.util.function.IntConsumer intConsumer) {
            if (!isParallel()) {
                java8.util.stream.IntPipeline.adapt(sourceStageSpliterator()).forEachRemaining(intConsumer);
            } else {
                super.forEachOrdered(intConsumer);
            }
        }
    }

    static abstract class StatelessOp<E_IN> extends java8.util.stream.IntPipeline<E_IN> {
        @Override // java8.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return false;
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java.util.Iterator<java.lang.Integer> iterator() {
            return super.iterator();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.AbstractPipeline
        /* JADX INFO: renamed from: lazySpliterator */
        /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Integer> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Integer>> supplier) {
            return super.lazySpliterator2(supplier);
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.IntStream parallel() {
            return (java8.util.stream.IntStream) super.parallel();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.IntStream sequential() {
            return (java8.util.stream.IntStream) super.sequential();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        /* JADX INFO: renamed from: spliterator */
        public /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Integer> spliterator2() {
            return super.spliterator2();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.BaseStream unordered() {
            return super.unordered();
        }

        StatelessOp(java8.util.stream.AbstractPipeline<?, E_IN, ?> abstractPipeline, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }
    }

    static abstract class StatefulOp<E_IN> extends java8.util.stream.IntPipeline<E_IN> {
        @Override // java8.util.stream.AbstractPipeline
        abstract <P_IN> java8.util.stream.Node<java.lang.Integer> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Integer[]> intFunction);

        @Override // java8.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return true;
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java.util.Iterator<java.lang.Integer> iterator() {
            return super.iterator();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.AbstractPipeline
        /* JADX INFO: renamed from: lazySpliterator */
        /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Integer> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<java.lang.Integer>> supplier) {
            return super.lazySpliterator2(supplier);
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.IntStream parallel() {
            return (java8.util.stream.IntStream) super.parallel();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.IntStream sequential() {
            return (java8.util.stream.IntStream) super.sequential();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.AbstractPipeline, java8.util.stream.BaseStream
        /* JADX INFO: renamed from: spliterator */
        public /* bridge */ /* synthetic */ java8.util.Spliterator<java.lang.Integer> spliterator2() {
            return super.spliterator2();
        }

        @Override // java8.util.stream.IntPipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.BaseStream unordered() {
            return super.unordered();
        }

        StatefulOp(java8.util.stream.AbstractPipeline<?, E_IN, ?> abstractPipeline, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }
    }
}
