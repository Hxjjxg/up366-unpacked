package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
abstract class ReferencePipeline<P_IN, P_OUT> extends java8.util.stream.AbstractPipeline<P_IN, P_OUT, java8.util.stream.Stream<P_OUT>> implements java8.util.stream.Stream<P_OUT> {
    ReferencePipeline(java8.util.function.Supplier<? extends java8.util.Spliterator<?>> supplier, int i, boolean z) {
        super(supplier, i, z);
    }

    ReferencePipeline(java8.util.Spliterator<?> spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    ReferencePipeline(java8.util.stream.AbstractPipeline<?, P_IN, ?> abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    @Override // java8.util.stream.AbstractPipeline
    final java8.util.stream.StreamShape getOutputShape() {
        return java8.util.stream.StreamShape.REFERENCE;
    }

    @Override // java8.util.stream.AbstractPipeline
    final <P_IN_> java8.util.stream.Node<P_OUT> evaluateToNode(java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN_> spliterator, boolean z, java8.util.function.IntFunction<P_OUT[]> intFunction) {
        return java8.util.stream.Nodes.collect(pipelineHelper, spliterator, z, intFunction);
    }

    @Override // java8.util.stream.AbstractPipeline
    final <P_IN_> java8.util.Spliterator<P_OUT> wrap(java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.function.Supplier<java8.util.Spliterator<P_IN_>> supplier, boolean z) {
        return new java8.util.stream.StreamSpliterators.WrappingSpliterator(pipelineHelper, supplier, z);
    }

    @Override // java8.util.stream.AbstractPipeline
    /* JADX INFO: renamed from: lazySpliterator */
    final java8.util.Spliterator<P_OUT> lazySpliterator2(java8.util.function.Supplier<? extends java8.util.Spliterator<P_OUT>> supplier) {
        return new java8.util.stream.StreamSpliterators.DelegatingSpliterator(supplier);
    }

    @Override // java8.util.stream.AbstractPipeline
    final boolean forEachWithCancel(java8.util.Spliterator<P_OUT> spliterator, java8.util.stream.Sink<P_OUT> sink) {
        boolean zCancellationRequested;
        do {
            zCancellationRequested = sink.cancellationRequested();
            if (zCancellationRequested) {
                break;
            }
        } while (spliterator.tryAdvance(sink));
        return zCancellationRequested;
    }

    @Override // java8.util.stream.AbstractPipeline, java8.util.stream.PipelineHelper
    final java8.util.stream.Node.Builder<P_OUT> makeNodeBuilder(long j, java8.util.function.IntFunction<P_OUT[]> intFunction) {
        return java8.util.stream.Nodes.builder(j, intFunction);
    }

    @Override // java8.util.stream.BaseStream
    public final java.util.Iterator<P_OUT> iterator() {
        return java8.util.Spliterators.iterator(spliterator2());
    }

    @Override // java8.util.stream.BaseStream
    public java8.util.stream.Stream<P_OUT> unordered() {
        return !isOrdered() ? this : new java8.util.stream.ReferencePipeline.StatelessOp<P_OUT, P_OUT>(this, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.NOT_ORDERED) { // from class: java8.util.stream.ReferencePipeline.1
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<P_OUT> opWrapSink(int i, java8.util.stream.Sink<P_OUT> sink) {
                return sink;
            }
        };
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.Stream<P_OUT> filter(final java8.util.function.Predicate<? super P_OUT> predicate) {
        java8.util.Objects.requireNonNull(predicate);
        return new java8.util.stream.ReferencePipeline.StatelessOp<P_OUT, P_OUT>(this, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.NOT_SIZED) { // from class: java8.util.stream.ReferencePipeline.2
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<P_OUT> opWrapSink(int i, java8.util.stream.Sink<P_OUT> sink) {
                return new java8.util.stream.Sink.ChainedReference<P_OUT, P_OUT>(sink) { // from class: java8.util.stream.ReferencePipeline.2.1
                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // java8.util.function.Consumer
                    public void accept(P_OUT p_out) {
                        if (predicate.test(p_out)) {
                            this.downstream.accept((java.lang.Object) p_out);
                        }
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.Stream
    public final <R> java8.util.stream.Stream<R> map(final java8.util.function.Function<? super P_OUT, ? extends R> function) {
        java8.util.Objects.requireNonNull(function);
        return new java8.util.stream.ReferencePipeline.StatelessOp<P_OUT, R>(this, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.ReferencePipeline.3
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<P_OUT> opWrapSink(int i, java8.util.stream.Sink<R> sink) {
                return new java8.util.stream.Sink.ChainedReference<P_OUT, R>(sink) { // from class: java8.util.stream.ReferencePipeline.3.1
                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // java8.util.function.Consumer
                    public void accept(P_OUT p_out) {
                        this.downstream.accept((java.lang.Object) function.apply(p_out));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.IntStream mapToInt(final java8.util.function.ToIntFunction<? super P_OUT> toIntFunction) {
        java8.util.Objects.requireNonNull(toIntFunction);
        return new java8.util.stream.IntPipeline.StatelessOp<P_OUT>(this, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.ReferencePipeline.4
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<P_OUT> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
                return new java8.util.stream.Sink.ChainedReference<P_OUT, java.lang.Integer>(sink) { // from class: java8.util.stream.ReferencePipeline.4.1
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
                    @Override // java8.util.function.Consumer
                    public void accept(P_OUT p_out) {
                        this.downstream.accept(toIntFunction.applyAsInt(p_out));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.LongStream mapToLong(final java8.util.function.ToLongFunction<? super P_OUT> toLongFunction) {
        java8.util.Objects.requireNonNull(toLongFunction);
        return new java8.util.stream.LongPipeline.StatelessOp<P_OUT>(this, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.ReferencePipeline.5
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<P_OUT> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
                return new java8.util.stream.Sink.ChainedReference<P_OUT, java.lang.Long>(sink) { // from class: java8.util.stream.ReferencePipeline.5.1
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
                    @Override // java8.util.function.Consumer
                    public void accept(P_OUT p_out) {
                        this.downstream.accept(toLongFunction.applyAsLong(p_out));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.DoubleStream mapToDouble(final java8.util.function.ToDoubleFunction<? super P_OUT> toDoubleFunction) {
        java8.util.Objects.requireNonNull(toDoubleFunction);
        return new java8.util.stream.DoublePipeline.StatelessOp<P_OUT>(this, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT) { // from class: java8.util.stream.ReferencePipeline.6
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<P_OUT> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return new java8.util.stream.Sink.ChainedReference<P_OUT, java.lang.Double>(sink) { // from class: java8.util.stream.ReferencePipeline.6.1
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
                    @Override // java8.util.function.Consumer
                    public void accept(P_OUT p_out) {
                        this.downstream.accept(toDoubleFunction.applyAsDouble(p_out));
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.Stream
    public final <R> java8.util.stream.Stream<R> flatMap(final java8.util.function.Function<? super P_OUT, ? extends java8.util.stream.Stream<? extends R>> function) {
        java8.util.Objects.requireNonNull(function);
        return new java8.util.stream.ReferencePipeline.StatelessOp<P_OUT, R>(this, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT | java8.util.stream.StreamOpFlag.NOT_SIZED) { // from class: java8.util.stream.ReferencePipeline.7
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<P_OUT> opWrapSink(int i, java8.util.stream.Sink<R> sink) {
                return new java8.util.stream.Sink.ChainedReference<P_OUT, R>(sink) { // from class: java8.util.stream.ReferencePipeline.7.1
                    boolean cancellationRequested;

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }

                    @Override // java8.util.function.Consumer
                    public void accept(P_OUT p_out) throws java.lang.Throwable {
                        java.lang.Throwable th;
                        java8.util.stream.Stream stream;
                        try {
                            stream = (java8.util.stream.Stream) function.apply(p_out);
                            if (stream != null) {
                                try {
                                    if (!this.cancellationRequested) {
                                        stream.sequential().forEach(this.downstream);
                                    } else {
                                        java8.util.Spliterator<T> spliterator = stream.sequential().spliterator2();
                                        while (!this.downstream.cancellationRequested() && spliterator.tryAdvance(this.downstream)) {
                                        }
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    if (stream != null) {
                                        stream.close();
                                    }
                                    throw th;
                                }
                            }
                            if (stream != null) {
                                stream.close();
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            stream = null;
                        }
                    }

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        this.cancellationRequested = true;
                        return this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.IntStream flatMapToInt(final java8.util.function.Function<? super P_OUT, ? extends java8.util.stream.IntStream> function) {
        java8.util.Objects.requireNonNull(function);
        return new java8.util.stream.IntPipeline.StatelessOp<P_OUT>(this, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT | java8.util.stream.StreamOpFlag.NOT_SIZED) { // from class: java8.util.stream.ReferencePipeline.8
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<P_OUT> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
                return new java8.util.stream.Sink.ChainedReference<P_OUT, java.lang.Integer>(sink) { // from class: java8.util.stream.ReferencePipeline.8.1
                    boolean cancellationRequested;
                    java8.util.function.IntConsumer downstreamAsInt;

                    {
                        java8.util.stream.Sink<? super E_OUT> sink2 = this.downstream;
                        sink2.getClass();
                        this.downstreamAsInt = java8.util.stream.ReferencePipeline$8$1$$Lambda$1.lambdaFactory$(sink2);
                    }

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference failed for: r0v6, types: [java8.util.Spliterator$OfInt] */
                    @Override // java8.util.function.Consumer
                    public void accept(P_OUT p_out) throws java.lang.Throwable {
                        java.lang.Throwable th;
                        java8.util.stream.IntStream intStream;
                        try {
                            intStream = (java8.util.stream.IntStream) function.apply(p_out);
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

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        this.cancellationRequested = true;
                        return this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.DoubleStream flatMapToDouble(final java8.util.function.Function<? super P_OUT, ? extends java8.util.stream.DoubleStream> function) {
        java8.util.Objects.requireNonNull(function);
        return new java8.util.stream.DoublePipeline.StatelessOp<P_OUT>(this, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT | java8.util.stream.StreamOpFlag.NOT_SIZED) { // from class: java8.util.stream.ReferencePipeline.9
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<P_OUT> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return new java8.util.stream.Sink.ChainedReference<P_OUT, java.lang.Double>(sink) { // from class: java8.util.stream.ReferencePipeline.9.1
                    boolean cancellationRequested;
                    java8.util.function.DoubleConsumer downstreamAsDouble;

                    {
                        java8.util.stream.Sink<? super E_OUT> sink2 = this.downstream;
                        sink2.getClass();
                        this.downstreamAsDouble = java8.util.stream.ReferencePipeline$9$1$$Lambda$1.lambdaFactory$(sink2);
                    }

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference failed for: r0v6, types: [java8.util.Spliterator$OfDouble] */
                    @Override // java8.util.function.Consumer
                    public void accept(P_OUT p_out) throws java.lang.Throwable {
                        java.lang.Throwable th;
                        java8.util.stream.DoubleStream doubleStream;
                        try {
                            doubleStream = (java8.util.stream.DoubleStream) function.apply(p_out);
                            if (doubleStream != null) {
                                try {
                                    if (!this.cancellationRequested) {
                                        doubleStream.sequential().forEach(this.downstreamAsDouble);
                                    } else {
                                        ?? Spliterator2 = doubleStream.sequential().spliterator2();
                                        while (!this.downstream.cancellationRequested() && Spliterator2.tryAdvance(this.downstreamAsDouble)) {
                                        }
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    if (doubleStream != null) {
                                        doubleStream.close();
                                    }
                                    throw th;
                                }
                            }
                            if (doubleStream != null) {
                                doubleStream.close();
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            doubleStream = null;
                        }
                    }

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        this.cancellationRequested = true;
                        return this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.LongStream flatMapToLong(final java8.util.function.Function<? super P_OUT, ? extends java8.util.stream.LongStream> function) {
        java8.util.Objects.requireNonNull(function);
        return new java8.util.stream.LongPipeline.StatelessOp<P_OUT>(this, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.NOT_SORTED | java8.util.stream.StreamOpFlag.NOT_DISTINCT | java8.util.stream.StreamOpFlag.NOT_SIZED) { // from class: java8.util.stream.ReferencePipeline.10
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<P_OUT> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
                return new java8.util.stream.Sink.ChainedReference<P_OUT, java.lang.Long>(sink) { // from class: java8.util.stream.ReferencePipeline.10.1
                    boolean cancellationRequested;
                    java8.util.function.LongConsumer downstreamAsLong;

                    {
                        java8.util.stream.Sink<? super E_OUT> sink2 = this.downstream;
                        sink2.getClass();
                        this.downstreamAsLong = java8.util.stream.ReferencePipeline$10$1$$Lambda$1.lambdaFactory$(sink2);
                    }

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference failed for: r0v6, types: [java8.util.Spliterator$OfLong] */
                    @Override // java8.util.function.Consumer
                    public void accept(P_OUT p_out) throws java.lang.Throwable {
                        java.lang.Throwable th;
                        java8.util.stream.LongStream longStream;
                        try {
                            longStream = (java8.util.stream.LongStream) function.apply(p_out);
                            if (longStream != null) {
                                try {
                                    if (!this.cancellationRequested) {
                                        longStream.sequential().forEach(this.downstreamAsLong);
                                    } else {
                                        ?? Spliterator2 = longStream.sequential().spliterator2();
                                        while (!this.downstream.cancellationRequested() && Spliterator2.tryAdvance(this.downstreamAsLong)) {
                                        }
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    if (longStream != null) {
                                        longStream.close();
                                    }
                                    throw th;
                                }
                            }
                            if (longStream != null) {
                                longStream.close();
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            longStream = null;
                        }
                    }

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        this.cancellationRequested = true;
                        return this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.Stream<P_OUT> peek(final java8.util.function.Consumer<? super P_OUT> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        return new java8.util.stream.ReferencePipeline.StatelessOp<P_OUT, P_OUT>(this, java8.util.stream.StreamShape.REFERENCE, 0) { // from class: java8.util.stream.ReferencePipeline.11
            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<P_OUT> opWrapSink(int i, java8.util.stream.Sink<P_OUT> sink) {
                return new java8.util.stream.Sink.ChainedReference<P_OUT, P_OUT>(sink) { // from class: java8.util.stream.ReferencePipeline.11.1
                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // java8.util.function.Consumer
                    public void accept(P_OUT p_out) {
                        consumer.accept(p_out);
                        this.downstream.accept((java.lang.Object) p_out);
                    }
                };
            }
        };
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.Stream<P_OUT> distinct() {
        return java8.util.stream.DistinctOps.makeRef(this);
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.Stream<P_OUT> sorted() {
        return java8.util.stream.SortedOps.makeRef(this);
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.Stream<P_OUT> sorted(java.util.Comparator<? super P_OUT> comparator) {
        return java8.util.stream.SortedOps.makeRef(this, comparator);
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.Stream<P_OUT> limit(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(java.lang.Long.toString(j));
        }
        return java8.util.stream.SliceOps.makeRef(this, 0L, j);
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.Stream<P_OUT> skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : java8.util.stream.SliceOps.makeRef(this, j, -1L);
        }
        throw new java.lang.IllegalArgumentException(java.lang.Long.toString(j));
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.Stream<P_OUT> takeWhile(java8.util.function.Predicate<? super P_OUT> predicate) {
        return java8.util.stream.WhileOps.makeTakeWhileRef(this, predicate);
    }

    @Override // java8.util.stream.Stream
    public final java8.util.stream.Stream<P_OUT> dropWhile(java8.util.function.Predicate<? super P_OUT> predicate) {
        return java8.util.stream.WhileOps.makeDropWhileRef(this, predicate);
    }

    @Override // java8.util.stream.Stream
    public void forEach(java8.util.function.Consumer<? super P_OUT> consumer) {
        evaluate(java8.util.stream.ForEachOps.makeRef(consumer, false));
    }

    @Override // java8.util.stream.Stream
    public void forEachOrdered(java8.util.function.Consumer<? super P_OUT> consumer) {
        evaluate(java8.util.stream.ForEachOps.makeRef(consumer, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java8.util.stream.Stream
    public final <A> A[] toArray(java8.util.function.IntFunction<A[]> intFunction) {
        return (A[]) java8.util.stream.Nodes.flatten(evaluateToArrayNode(intFunction), intFunction).asArray(intFunction);
    }

    static /* synthetic */ java.lang.Object[] lambda$toArray$99(int i) {
        return new java.lang.Object[i];
    }

    @Override // java8.util.stream.Stream
    public final java.lang.Object[] toArray() {
        return toArray(java8.util.stream.ReferencePipeline$$Lambda$1.instance);
    }

    @Override // java8.util.stream.Stream
    public final boolean anyMatch(java8.util.function.Predicate<? super P_OUT> predicate) {
        return ((java.lang.Boolean) evaluate(java8.util.stream.MatchOps.makeRef(predicate, java8.util.stream.MatchOps.MatchKind.ANY))).booleanValue();
    }

    @Override // java8.util.stream.Stream
    public final boolean allMatch(java8.util.function.Predicate<? super P_OUT> predicate) {
        return ((java.lang.Boolean) evaluate(java8.util.stream.MatchOps.makeRef(predicate, java8.util.stream.MatchOps.MatchKind.ALL))).booleanValue();
    }

    @Override // java8.util.stream.Stream
    public final boolean noneMatch(java8.util.function.Predicate<? super P_OUT> predicate) {
        return ((java.lang.Boolean) evaluate(java8.util.stream.MatchOps.makeRef(predicate, java8.util.stream.MatchOps.MatchKind.NONE))).booleanValue();
    }

    @Override // java8.util.stream.Stream
    public final java8.util.Optional<P_OUT> findFirst() {
        return (java8.util.Optional) evaluate(java8.util.stream.FindOps.makeRef(true));
    }

    @Override // java8.util.stream.Stream
    public final java8.util.Optional<P_OUT> findAny() {
        return (java8.util.Optional) evaluate(java8.util.stream.FindOps.makeRef(false));
    }

    @Override // java8.util.stream.Stream
    public final P_OUT reduce(P_OUT p_out, java8.util.function.BinaryOperator<P_OUT> binaryOperator) {
        return (P_OUT) evaluate(java8.util.stream.ReduceOps.makeRef(p_out, binaryOperator, binaryOperator));
    }

    @Override // java8.util.stream.Stream
    public final java8.util.Optional<P_OUT> reduce(java8.util.function.BinaryOperator<P_OUT> binaryOperator) {
        return (java8.util.Optional) evaluate(java8.util.stream.ReduceOps.makeRef(binaryOperator));
    }

    @Override // java8.util.stream.Stream
    public final <R> R reduce(R r, java8.util.function.BiFunction<R, ? super P_OUT, R> biFunction, java8.util.function.BinaryOperator<R> binaryOperator) {
        return (R) evaluate(java8.util.stream.ReduceOps.makeRef(r, (java8.util.function.BiFunction<R, ? super T, R>) biFunction, binaryOperator));
    }

    @Override // java8.util.stream.Stream
    public final <R, A> R collect(java8.util.stream.Collector<? super P_OUT, A, R> collector) {
        A a;
        if (isParallel() && collector.characteristics().contains(java8.util.stream.Collector.Characteristics.CONCURRENT) && (!isOrdered() || collector.characteristics().contains(java8.util.stream.Collector.Characteristics.UNORDERED))) {
            a = collector.supplier().get();
            forEach(java8.util.stream.ReferencePipeline$$Lambda$2.lambdaFactory$(collector.accumulator(), a));
        } else {
            a = (R) evaluate(java8.util.stream.ReduceOps.makeRef(collector));
        }
        return collector.characteristics().contains(java8.util.stream.Collector.Characteristics.IDENTITY_FINISH) ? a : (R) collector.finisher().apply(a);
    }

    @Override // java8.util.stream.Stream
    public final <R> R collect(java8.util.function.Supplier<R> supplier, java8.util.function.BiConsumer<R, ? super P_OUT> biConsumer, java8.util.function.BiConsumer<R, R> biConsumer2) {
        return (R) evaluate(java8.util.stream.ReduceOps.makeRef(supplier, biConsumer, biConsumer2));
    }

    @Override // java8.util.stream.Stream
    public final java8.util.Optional<P_OUT> max(java.util.Comparator<? super P_OUT> comparator) {
        return reduce(java8.util.function.BinaryOperators.maxBy(comparator));
    }

    @Override // java8.util.stream.Stream
    public final java8.util.Optional<P_OUT> min(java.util.Comparator<? super P_OUT> comparator) {
        return reduce(java8.util.function.BinaryOperators.minBy(comparator));
    }

    @Override // java8.util.stream.Stream
    public final long count() {
        return ((java.lang.Long) evaluate(java8.util.stream.ReduceOps.makeRefCounting())).longValue();
    }

    static class Head<E_IN, E_OUT> extends java8.util.stream.ReferencePipeline<E_IN, E_OUT> {
        @Override // java8.util.stream.ReferencePipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.BaseStream unordered() {
            return super.unordered();
        }

        Head(java8.util.function.Supplier<? extends java8.util.Spliterator<?>> supplier, int i, boolean z) {
            super(supplier, i, z);
        }

        Head(java8.util.Spliterator<?> spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        @Override // java8.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java8.util.stream.AbstractPipeline
        final java8.util.stream.Sink<E_IN> opWrapSink(int i, java8.util.stream.Sink<E_OUT> sink) {
            throw new java.lang.UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java8.util.stream.ReferencePipeline, java8.util.stream.Stream
        public void forEach(java8.util.function.Consumer<? super E_OUT> consumer) {
            if (!isParallel()) {
                sourceStageSpliterator().forEachRemaining(consumer);
            } else {
                super.forEach(consumer);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java8.util.stream.ReferencePipeline, java8.util.stream.Stream
        public void forEachOrdered(java8.util.function.Consumer<? super E_OUT> consumer) {
            if (!isParallel()) {
                sourceStageSpliterator().forEachRemaining(consumer);
            } else {
                super.forEachOrdered(consumer);
            }
        }
    }

    static abstract class StatelessOp<E_IN, E_OUT> extends java8.util.stream.ReferencePipeline<E_IN, E_OUT> {
        @Override // java8.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return false;
        }

        @Override // java8.util.stream.ReferencePipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.BaseStream unordered() {
            return super.unordered();
        }

        StatelessOp(java8.util.stream.AbstractPipeline<?, E_IN, ?> abstractPipeline, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }
    }

    static abstract class StatefulOp<E_IN, E_OUT> extends java8.util.stream.ReferencePipeline<E_IN, E_OUT> {
        @Override // java8.util.stream.AbstractPipeline
        abstract <P_IN> java8.util.stream.Node<E_OUT> opEvaluateParallel(java8.util.stream.PipelineHelper<E_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<E_OUT[]> intFunction);

        @Override // java8.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return true;
        }

        @Override // java8.util.stream.ReferencePipeline, java8.util.stream.BaseStream
        public /* bridge */ /* synthetic */ java8.util.stream.BaseStream unordered() {
            return super.unordered();
        }

        StatefulOp(java8.util.stream.AbstractPipeline<?, E_IN, ?> abstractPipeline, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }
    }
}
