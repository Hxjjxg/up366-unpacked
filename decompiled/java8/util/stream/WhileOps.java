package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class WhileOps {
    static final int TAKE_FLAGS = java8.util.stream.StreamOpFlag.NOT_SIZED | java8.util.stream.StreamOpFlag.IS_SHORT_CIRCUIT;
    static final int DROP_FLAGS = java8.util.stream.StreamOpFlag.NOT_SIZED;
    static final java8.util.function.IntFunction<java.lang.Integer[]> INT_ARR_GEN = java8.util.stream.WhileOps$$Lambda$1.instance;
    static final java8.util.function.IntFunction<java.lang.Long[]> LONG_ARR_GEN = java8.util.stream.WhileOps$$Lambda$2.instance;
    static final java8.util.function.IntFunction<java.lang.Double[]> DOUBLE_ARR_GEN = java8.util.stream.WhileOps$$Lambda$3.instance;

    interface DropWhileOp<T> {
        java8.util.stream.WhileOps.DropWhileSink<T> opWrapSink(java8.util.stream.Sink<T> sink, boolean z);
    }

    interface DropWhileSink<T> extends java8.util.stream.Sink<T> {
        long getDropCount();
    }

    WhileOps() {
    }

    static /* synthetic */ java.lang.Integer[] lambda$static$154(int i) {
        return new java.lang.Integer[i];
    }

    static /* synthetic */ java.lang.Long[] lambda$static$155(int i) {
        return new java.lang.Long[i];
    }

    static /* synthetic */ java.lang.Double[] lambda$static$156(int i) {
        return new java.lang.Double[i];
    }

    static <T> java8.util.stream.Stream<T> makeTakeWhileRef(java8.util.stream.AbstractPipeline<?, T, ?> abstractPipeline, final java8.util.function.Predicate<? super T> predicate) {
        java8.util.Objects.requireNonNull(predicate);
        return new java8.util.stream.ReferencePipeline.StatefulOp<T, T>(abstractPipeline, java8.util.stream.StreamShape.REFERENCE, TAKE_FLAGS) { // from class: java8.util.stream.WhileOps.1
            @Override // java8.util.stream.AbstractPipeline
            <P_IN> java8.util.Spliterator<T> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                if (java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return opEvaluateParallel(pipelineHelper, spliterator, java8.util.stream.Nodes.castingArray()).spliterator();
                }
                return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfRef.Taking(pipelineHelper.wrapSpliterator(spliterator), false, predicate);
            }

            @Override // java8.util.stream.ReferencePipeline.StatefulOp, java8.util.stream.AbstractPipeline
            <P_IN> java8.util.stream.Node<T> opEvaluateParallel(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<T[]> intFunction) {
                return (java8.util.stream.Node) new java8.util.stream.WhileOps.TakeWhileTask(this, pipelineHelper, spliterator, intFunction).invoke();
            }

            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<T> opWrapSink(int i, java8.util.stream.Sink<T> sink) {
                return new java8.util.stream.Sink.ChainedReference<T, T>(sink) { // from class: java8.util.stream.WhileOps.1.1
                    boolean take = true;

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // java8.util.function.Consumer
                    public void accept(T t) {
                        if (this.take) {
                            boolean zTest = predicate.test(t);
                            this.take = zTest;
                            if (zTest) {
                                this.downstream.accept((java.lang.Object) t);
                            }
                        }
                    }

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        return !this.take || this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    static java8.util.stream.IntStream makeTakeWhileInt(java8.util.stream.AbstractPipeline<?, java.lang.Integer, ?> abstractPipeline, final java8.util.function.IntPredicate intPredicate) {
        java8.util.Objects.requireNonNull(intPredicate);
        return new java8.util.stream.IntPipeline.StatefulOp<java.lang.Integer>(abstractPipeline, java8.util.stream.StreamShape.INT_VALUE, TAKE_FLAGS) { // from class: java8.util.stream.WhileOps.2
            @Override // java8.util.stream.AbstractPipeline
            <P_IN> java8.util.Spliterator<java.lang.Integer> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                if (java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return opEvaluateParallel(pipelineHelper, spliterator, java8.util.stream.WhileOps.INT_ARR_GEN).spliterator();
                }
                return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt.Taking((java8.util.Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator), false, intPredicate);
            }

            @Override // java8.util.stream.IntPipeline.StatefulOp, java8.util.stream.AbstractPipeline
            <P_IN> java8.util.stream.Node<java.lang.Integer> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
                return (java8.util.stream.Node) new java8.util.stream.WhileOps.TakeWhileTask(this, pipelineHelper, spliterator, intFunction).invoke();
            }

            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
                return new java8.util.stream.Sink.ChainedInt<java.lang.Integer>(sink) { // from class: java8.util.stream.WhileOps.2.1
                    boolean take = true;

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
                        if (this.take) {
                            boolean zTest = intPredicate.test(i2);
                            this.take = zTest;
                            if (zTest) {
                                this.downstream.accept(i2);
                            }
                        }
                    }

                    @Override // java8.util.stream.Sink.ChainedInt, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        return !this.take || this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    static java8.util.stream.LongStream makeTakeWhileLong(java8.util.stream.AbstractPipeline<?, java.lang.Long, ?> abstractPipeline, final java8.util.function.LongPredicate longPredicate) {
        java8.util.Objects.requireNonNull(longPredicate);
        return new java8.util.stream.LongPipeline.StatefulOp<java.lang.Long>(abstractPipeline, java8.util.stream.StreamShape.LONG_VALUE, TAKE_FLAGS) { // from class: java8.util.stream.WhileOps.3
            @Override // java8.util.stream.AbstractPipeline
            <P_IN> java8.util.Spliterator<java.lang.Long> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                if (java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return opEvaluateParallel(pipelineHelper, spliterator, java8.util.stream.WhileOps.LONG_ARR_GEN).spliterator();
                }
                return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong.Taking((java8.util.Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator), false, longPredicate);
            }

            @Override // java8.util.stream.LongPipeline.StatefulOp, java8.util.stream.AbstractPipeline
            <P_IN> java8.util.stream.Node<java.lang.Long> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
                return (java8.util.stream.Node) new java8.util.stream.WhileOps.TakeWhileTask(this, pipelineHelper, spliterator, intFunction).invoke();
            }

            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Long> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
                return new java8.util.stream.Sink.ChainedLong<java.lang.Long>(sink) { // from class: java8.util.stream.WhileOps.3.1
                    boolean take = true;

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
                        if (this.take) {
                            boolean zTest = longPredicate.test(j);
                            this.take = zTest;
                            if (zTest) {
                                this.downstream.accept(j);
                            }
                        }
                    }

                    @Override // java8.util.stream.Sink.ChainedLong, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        return !this.take || this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    static java8.util.stream.DoubleStream makeTakeWhileDouble(java8.util.stream.AbstractPipeline<?, java.lang.Double, ?> abstractPipeline, final java8.util.function.DoublePredicate doublePredicate) {
        java8.util.Objects.requireNonNull(doublePredicate);
        return new java8.util.stream.DoublePipeline.StatefulOp<java.lang.Double>(abstractPipeline, java8.util.stream.StreamShape.DOUBLE_VALUE, TAKE_FLAGS) { // from class: java8.util.stream.WhileOps.4
            @Override // java8.util.stream.AbstractPipeline
            <P_IN> java8.util.Spliterator<java.lang.Double> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                if (java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return opEvaluateParallel(pipelineHelper, spliterator, java8.util.stream.WhileOps.DOUBLE_ARR_GEN).spliterator();
                }
                return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble.Taking((java8.util.Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator), false, doublePredicate);
            }

            @Override // java8.util.stream.DoublePipeline.StatefulOp, java8.util.stream.AbstractPipeline
            <P_IN> java8.util.stream.Node<java.lang.Double> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
                return (java8.util.stream.Node) new java8.util.stream.WhileOps.TakeWhileTask(this, pipelineHelper, spliterator, intFunction).invoke();
            }

            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Double> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return new java8.util.stream.Sink.ChainedDouble<java.lang.Double>(sink) { // from class: java8.util.stream.WhileOps.4.1
                    boolean take = true;

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
                        if (this.take) {
                            boolean zTest = doublePredicate.test(d);
                            this.take = zTest;
                            if (zTest) {
                                this.downstream.accept(d);
                            }
                        }
                    }

                    @Override // java8.util.stream.Sink.ChainedDouble, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        return !this.take || this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    static <T> java8.util.stream.Stream<T> makeDropWhileRef(java8.util.stream.AbstractPipeline<?, T, ?> abstractPipeline, java8.util.function.Predicate<? super T> predicate) {
        java8.util.Objects.requireNonNull(predicate);
        return new java8.util.stream.WhileOps.C1Op(abstractPipeline, java8.util.stream.StreamShape.REFERENCE, DROP_FLAGS, predicate);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: java8.util.stream.WhileOps$1Op, reason: invalid class name */
    class C1Op<T> extends java8.util.stream.ReferencePipeline.StatefulOp<T, T> implements java8.util.stream.WhileOps.DropWhileOp<T> {
        final /* synthetic */ java8.util.function.Predicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C1Op(java8.util.stream.AbstractPipeline abstractPipeline, java8.util.stream.AbstractPipeline<?, T, ?> abstractPipeline2, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, abstractPipeline2, streamShape);
            this.val$predicate = i;
        }

        @Override // java8.util.stream.AbstractPipeline
        <P_IN> java8.util.Spliterator<T> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
            if (java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return opEvaluateParallel(pipelineHelper, spliterator, java8.util.stream.Nodes.castingArray()).spliterator();
            }
            return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfRef.Dropping(pipelineHelper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        @Override // java8.util.stream.ReferencePipeline.StatefulOp, java8.util.stream.AbstractPipeline
        <P_IN> java8.util.stream.Node<T> opEvaluateParallel(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<T[]> intFunction) {
            return (java8.util.stream.Node) new java8.util.stream.WhileOps.DropWhileTask(this, pipelineHelper, spliterator, intFunction).invoke();
        }

        @Override // java8.util.stream.AbstractPipeline
        java8.util.stream.Sink<T> opWrapSink(int i, java8.util.stream.Sink<T> sink) {
            return opWrapSink((java8.util.stream.Sink) sink, false);
        }

        /* JADX INFO: renamed from: java8.util.stream.WhileOps$1Op$1OpSink, reason: invalid class name */
        class C1OpSink extends java8.util.stream.Sink.ChainedReference<T, T> implements java8.util.stream.WhileOps.DropWhileSink<T> {
            long dropCount;
            boolean take;
            final /* synthetic */ boolean val$retainAndCountDroppedElements;
            final /* synthetic */ java8.util.stream.Sink val$sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1OpSink(java8.util.stream.Sink sink, boolean z) {
                super(sink);
                this.val$sink = sink;
                this.val$retainAndCountDroppedElements = z;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // java8.util.function.Consumer
            public void accept(T t) {
                boolean z = true;
                if (!this.take) {
                    boolean z2 = !java8.util.stream.WhileOps.C1Op.this.val$predicate.test(t);
                    this.take = z2;
                    if (!z2) {
                        z = false;
                    }
                }
                boolean z3 = this.val$retainAndCountDroppedElements;
                if (z3 && !z) {
                    this.dropCount++;
                }
                if (z3 || z) {
                    this.downstream.accept((java.lang.Object) t);
                }
            }

            @Override // java8.util.stream.WhileOps.DropWhileSink
            public long getDropCount() {
                return this.dropCount;
            }
        }

        @Override // java8.util.stream.WhileOps.DropWhileOp
        public java8.util.stream.WhileOps.DropWhileSink<T> opWrapSink(java8.util.stream.Sink<T> sink, boolean z) {
            return new java8.util.stream.WhileOps.C1Op.C1OpSink(sink, z);
        }
    }

    static java8.util.stream.IntStream makeDropWhileInt(java8.util.stream.AbstractPipeline<?, java.lang.Integer, ?> abstractPipeline, java8.util.function.IntPredicate intPredicate) {
        java8.util.Objects.requireNonNull(intPredicate);
        return new java8.util.stream.WhileOps.C2Op(abstractPipeline, java8.util.stream.StreamShape.INT_VALUE, DROP_FLAGS, intPredicate);
    }

    /* JADX INFO: renamed from: java8.util.stream.WhileOps$2Op, reason: invalid class name */
    class C2Op extends java8.util.stream.IntPipeline.StatefulOp<java.lang.Integer> implements java8.util.stream.WhileOps.DropWhileOp<java.lang.Integer> {
        final /* synthetic */ java8.util.function.IntPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C2Op(java8.util.stream.AbstractPipeline abstractPipeline, java8.util.stream.AbstractPipeline<?, java.lang.Integer, ?> abstractPipeline2, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, abstractPipeline2, streamShape);
            this.val$predicate = i;
        }

        @Override // java8.util.stream.AbstractPipeline
        <P_IN> java8.util.Spliterator<java.lang.Integer> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
            if (java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return opEvaluateParallel(pipelineHelper, spliterator, java8.util.stream.WhileOps.INT_ARR_GEN).spliterator();
            }
            return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt.Dropping((java8.util.Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        @Override // java8.util.stream.IntPipeline.StatefulOp, java8.util.stream.AbstractPipeline
        <P_IN> java8.util.stream.Node<java.lang.Integer> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
            return (java8.util.stream.Node) new java8.util.stream.WhileOps.DropWhileTask(this, pipelineHelper, spliterator, intFunction).invoke();
        }

        @Override // java8.util.stream.AbstractPipeline
        java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
            return opWrapSink(sink, false);
        }

        /* JADX INFO: renamed from: java8.util.stream.WhileOps$2Op$1OpSink, reason: invalid class name */
        class C1OpSink extends java8.util.stream.Sink.ChainedInt<java.lang.Integer> implements java8.util.stream.WhileOps.DropWhileSink<java.lang.Integer> {
            long dropCount;
            boolean take;
            final /* synthetic */ boolean val$retainAndCountDroppedElements;
            final /* synthetic */ java8.util.stream.Sink val$sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1OpSink(java8.util.stream.Sink sink, boolean z) {
                super(sink);
                this.val$sink = sink;
                this.val$retainAndCountDroppedElements = z;
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
            public void accept(int i) {
                boolean z = true;
                if (!this.take) {
                    boolean z2 = !java8.util.stream.WhileOps.C2Op.this.val$predicate.test(i);
                    this.take = z2;
                    if (!z2) {
                        z = false;
                    }
                }
                boolean z3 = this.val$retainAndCountDroppedElements;
                if (z3 && !z) {
                    this.dropCount++;
                }
                if (z3 || z) {
                    this.downstream.accept(i);
                }
            }

            @Override // java8.util.stream.WhileOps.DropWhileSink
            public long getDropCount() {
                return this.dropCount;
            }
        }

        @Override // java8.util.stream.WhileOps.DropWhileOp
        public java8.util.stream.WhileOps.DropWhileSink<java.lang.Integer> opWrapSink(java8.util.stream.Sink<java.lang.Integer> sink, boolean z) {
            return new java8.util.stream.WhileOps.C2Op.C1OpSink(sink, z);
        }
    }

    static java8.util.stream.LongStream makeDropWhileLong(java8.util.stream.AbstractPipeline<?, java.lang.Long, ?> abstractPipeline, java8.util.function.LongPredicate longPredicate) {
        java8.util.Objects.requireNonNull(longPredicate);
        return new java8.util.stream.WhileOps.C3Op(abstractPipeline, java8.util.stream.StreamShape.LONG_VALUE, DROP_FLAGS, longPredicate);
    }

    /* JADX INFO: renamed from: java8.util.stream.WhileOps$3Op, reason: invalid class name */
    class C3Op extends java8.util.stream.LongPipeline.StatefulOp<java.lang.Long> implements java8.util.stream.WhileOps.DropWhileOp<java.lang.Long> {
        final /* synthetic */ java8.util.function.LongPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C3Op(java8.util.stream.AbstractPipeline abstractPipeline, java8.util.stream.AbstractPipeline<?, java.lang.Long, ?> abstractPipeline2, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, abstractPipeline2, streamShape);
            this.val$predicate = i;
        }

        @Override // java8.util.stream.AbstractPipeline
        <P_IN> java8.util.Spliterator<java.lang.Long> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
            if (java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return opEvaluateParallel(pipelineHelper, spliterator, java8.util.stream.WhileOps.LONG_ARR_GEN).spliterator();
            }
            return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong.Dropping((java8.util.Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        @Override // java8.util.stream.LongPipeline.StatefulOp, java8.util.stream.AbstractPipeline
        <P_IN> java8.util.stream.Node<java.lang.Long> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
            return (java8.util.stream.Node) new java8.util.stream.WhileOps.DropWhileTask(this, pipelineHelper, spliterator, intFunction).invoke();
        }

        @Override // java8.util.stream.AbstractPipeline
        java8.util.stream.Sink<java.lang.Long> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
            return opWrapSink(sink, false);
        }

        /* JADX INFO: renamed from: java8.util.stream.WhileOps$3Op$1OpSink, reason: invalid class name */
        class C1OpSink extends java8.util.stream.Sink.ChainedLong<java.lang.Long> implements java8.util.stream.WhileOps.DropWhileSink<java.lang.Long> {
            long dropCount;
            boolean take;
            final /* synthetic */ boolean val$retainAndCountDroppedElements;
            final /* synthetic */ java8.util.stream.Sink val$sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1OpSink(java8.util.stream.Sink sink, boolean z) {
                super(sink);
                this.val$sink = sink;
                this.val$retainAndCountDroppedElements = z;
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
                boolean z = true;
                if (!this.take) {
                    boolean z2 = !java8.util.stream.WhileOps.C3Op.this.val$predicate.test(j);
                    this.take = z2;
                    if (!z2) {
                        z = false;
                    }
                }
                boolean z3 = this.val$retainAndCountDroppedElements;
                if (z3 && !z) {
                    this.dropCount++;
                }
                if (z3 || z) {
                    this.downstream.accept(j);
                }
            }

            @Override // java8.util.stream.WhileOps.DropWhileSink
            public long getDropCount() {
                return this.dropCount;
            }
        }

        @Override // java8.util.stream.WhileOps.DropWhileOp
        public java8.util.stream.WhileOps.DropWhileSink<java.lang.Long> opWrapSink(java8.util.stream.Sink<java.lang.Long> sink, boolean z) {
            return new java8.util.stream.WhileOps.C3Op.C1OpSink(sink, z);
        }
    }

    static java8.util.stream.DoubleStream makeDropWhileDouble(java8.util.stream.AbstractPipeline<?, java.lang.Double, ?> abstractPipeline, java8.util.function.DoublePredicate doublePredicate) {
        java8.util.Objects.requireNonNull(doublePredicate);
        return new java8.util.stream.WhileOps.C4Op(abstractPipeline, java8.util.stream.StreamShape.DOUBLE_VALUE, DROP_FLAGS, doublePredicate);
    }

    /* JADX INFO: renamed from: java8.util.stream.WhileOps$4Op, reason: invalid class name */
    class C4Op extends java8.util.stream.DoublePipeline.StatefulOp<java.lang.Double> implements java8.util.stream.WhileOps.DropWhileOp<java.lang.Double> {
        final /* synthetic */ java8.util.function.DoublePredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C4Op(java8.util.stream.AbstractPipeline abstractPipeline, java8.util.stream.AbstractPipeline<?, java.lang.Double, ?> abstractPipeline2, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, abstractPipeline2, streamShape);
            this.val$predicate = i;
        }

        @Override // java8.util.stream.AbstractPipeline
        <P_IN> java8.util.Spliterator<java.lang.Double> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
            if (java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return opEvaluateParallel(pipelineHelper, spliterator, java8.util.stream.WhileOps.DOUBLE_ARR_GEN).spliterator();
            }
            return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble.Dropping((java8.util.Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        @Override // java8.util.stream.DoublePipeline.StatefulOp, java8.util.stream.AbstractPipeline
        <P_IN> java8.util.stream.Node<java.lang.Double> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
            return (java8.util.stream.Node) new java8.util.stream.WhileOps.DropWhileTask(this, pipelineHelper, spliterator, intFunction).invoke();
        }

        @Override // java8.util.stream.AbstractPipeline
        java8.util.stream.Sink<java.lang.Double> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
            return opWrapSink(sink, false);
        }

        /* JADX INFO: renamed from: java8.util.stream.WhileOps$4Op$1OpSink, reason: invalid class name */
        class C1OpSink extends java8.util.stream.Sink.ChainedDouble<java.lang.Double> implements java8.util.stream.WhileOps.DropWhileSink<java.lang.Double> {
            long dropCount;
            boolean take;
            final /* synthetic */ boolean val$retainAndCountDroppedElements;
            final /* synthetic */ java8.util.stream.Sink val$sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1OpSink(java8.util.stream.Sink sink, boolean z) {
                super(sink);
                this.val$sink = sink;
                this.val$retainAndCountDroppedElements = z;
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
                boolean z = true;
                if (!this.take) {
                    boolean z2 = !java8.util.stream.WhileOps.C4Op.this.val$predicate.test(d);
                    this.take = z2;
                    if (!z2) {
                        z = false;
                    }
                }
                boolean z3 = this.val$retainAndCountDroppedElements;
                if (z3 && !z) {
                    this.dropCount++;
                }
                if (z3 || z) {
                    this.downstream.accept(d);
                }
            }

            @Override // java8.util.stream.WhileOps.DropWhileSink
            public long getDropCount() {
                return this.dropCount;
            }
        }

        @Override // java8.util.stream.WhileOps.DropWhileOp
        public java8.util.stream.WhileOps.DropWhileSink<java.lang.Double> opWrapSink(java8.util.stream.Sink<java.lang.Double> sink, boolean z) {
            return new java8.util.stream.WhileOps.C4Op.C1OpSink(sink, z);
        }
    }

    static abstract class UnorderedWhileSpliterator<T, T_SPLITR extends java8.util.Spliterator<T>> implements java8.util.Spliterator<T> {
        static final int CANCEL_CHECK_COUNT = 63;
        final java.util.concurrent.atomic.AtomicBoolean cancel;
        int count;
        final boolean noSplitting;
        final T_SPLITR s;
        boolean takeOrDrop;

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return -1L;
        }

        abstract T_SPLITR makeSpliterator(T_SPLITR t_splitr);

        UnorderedWhileSpliterator(T_SPLITR t_splitr, boolean z) {
            this.takeOrDrop = true;
            this.s = t_splitr;
            this.noSplitting = z;
            this.cancel = new java.util.concurrent.atomic.AtomicBoolean();
        }

        UnorderedWhileSpliterator(T_SPLITR t_splitr, java8.util.stream.WhileOps.UnorderedWhileSpliterator<T, T_SPLITR> unorderedWhileSpliterator) {
            this.takeOrDrop = true;
            this.s = t_splitr;
            this.noSplitting = unorderedWhileSpliterator.noSplitting;
            this.cancel = unorderedWhileSpliterator.cancel;
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.s.estimateSize();
        }

        @Override // java8.util.Spliterator
        public int characteristics() {
            return this.s.characteristics() & (-16449);
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super T> getComparator() {
            return this.s.getComparator();
        }

        @Override // java8.util.Spliterator
        public T_SPLITR trySplit() {
            java8.util.Spliterator<T> spliteratorTrySplit = this.noSplitting ? null : this.s.trySplit();
            if (spliteratorTrySplit != null) {
                return (T_SPLITR) makeSpliterator(spliteratorTrySplit);
            }
            return null;
        }

        boolean checkCancelOnCount() {
            return (this.count == 0 && this.cancel.get()) ? false : true;
        }

        static abstract class OfRef<T> extends java8.util.stream.WhileOps.UnorderedWhileSpliterator<T, java8.util.Spliterator<T>> implements java8.util.function.Consumer<T> {
            final java8.util.function.Predicate<? super T> p;
            T t;

            OfRef(java8.util.Spliterator<T> spliterator, boolean z, java8.util.function.Predicate<? super T> predicate) {
                super(spliterator, z);
                this.p = predicate;
            }

            OfRef(java8.util.Spliterator<T> spliterator, java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfRef<T> ofRef) {
                super(spliterator, ofRef);
                this.p = ofRef.p;
            }

            @Override // java8.util.function.Consumer
            public void accept(T t) {
                this.count = (this.count + 1) & 63;
                this.t = t;
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
                java8.util.Spliterators.forEachRemaining(this, consumer);
            }

            @Override // java8.util.Spliterator
            public boolean hasCharacteristics(int i) {
                return java8.util.Spliterators.hasCharacteristics(this, i);
            }

            static final class Taking<T> extends java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfRef<T> {
                Taking(java8.util.Spliterator<T> spliterator, boolean z, java8.util.function.Predicate<? super T> predicate) {
                    super(spliterator, z, predicate);
                }

                Taking(java8.util.Spliterator<T> spliterator, java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfRef.Taking<T> taking) {
                    super(spliterator, taking);
                }

                @Override // java8.util.Spliterator
                public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
                    boolean zTest;
                    if (this.takeOrDrop && checkCancelOnCount() && this.s.tryAdvance(this)) {
                        zTest = this.p.test(this.t);
                        if (zTest) {
                            consumer.accept(this.t);
                            return true;
                        }
                    } else {
                        zTest = true;
                    }
                    this.takeOrDrop = false;
                    if (!zTest) {
                        this.cancel.set(true);
                    }
                    return false;
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
                public java8.util.Spliterator<T> trySplit() {
                    if (this.cancel.get()) {
                        return null;
                    }
                    return super.trySplit();
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator
                java8.util.Spliterator<T> makeSpliterator(java8.util.Spliterator<T> spliterator) {
                    return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfRef.Taking(spliterator, this);
                }
            }

            static final class Dropping<T> extends java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfRef<T> {
                Dropping(java8.util.Spliterator<T> spliterator, boolean z, java8.util.function.Predicate<? super T> predicate) {
                    super(spliterator, z, predicate);
                }

                Dropping(java8.util.Spliterator<T> spliterator, java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfRef.Dropping<T> dropping) {
                    super(spliterator, dropping);
                }

                @Override // java8.util.Spliterator
                public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
                    boolean zTryAdvance;
                    if (this.takeOrDrop) {
                        boolean z = false;
                        this.takeOrDrop = false;
                        while (true) {
                            zTryAdvance = this.s.tryAdvance(this);
                            if (!zTryAdvance || !checkCancelOnCount() || !this.p.test(this.t)) {
                                break;
                            }
                            z = true;
                        }
                        if (zTryAdvance) {
                            if (z) {
                                this.cancel.set(true);
                            }
                            consumer.accept(this.t);
                        }
                        return zTryAdvance;
                    }
                    return this.s.tryAdvance(consumer);
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator
                java8.util.Spliterator<T> makeSpliterator(java8.util.Spliterator<T> spliterator) {
                    return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfRef.Dropping(spliterator, this);
                }
            }
        }

        static abstract class OfInt extends java8.util.stream.WhileOps.UnorderedWhileSpliterator<java.lang.Integer, java8.util.Spliterator.OfInt> implements java8.util.function.IntConsumer, java8.util.Spliterator.OfInt {
            final java8.util.function.IntPredicate p;
            int t;

            @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfInt trySplit() {
                return (java8.util.Spliterator.OfInt) super.trySplit();
            }

            @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                return (java8.util.Spliterator.OfPrimitive) super.trySplit();
            }

            OfInt(java8.util.Spliterator.OfInt ofInt, boolean z, java8.util.function.IntPredicate intPredicate) {
                super(ofInt, z);
                this.p = intPredicate;
            }

            OfInt(java8.util.Spliterator.OfInt ofInt, java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt ofInt2) {
                super(ofInt, ofInt2);
                this.p = ofInt2.p;
            }

            @Override // java8.util.function.IntConsumer
            public void accept(int i) {
                this.count = (this.count + 1) & 63;
                this.t = i;
            }

            @Override // java8.util.Spliterator
            public boolean hasCharacteristics(int i) {
                return java8.util.Spliterators.hasCharacteristics(this, i);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
                java8.util.Spliterators.OfInt.forEachRemaining(this, intConsumer);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                java8.util.Spliterators.forEachRemaining(this, consumer);
            }

            static final class Taking extends java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt {
                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt, java8.util.Spliterator.OfPrimitive
                public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
                    super.forEachRemaining(intConsumer);
                }

                Taking(java8.util.Spliterator.OfInt ofInt, boolean z, java8.util.function.IntPredicate intPredicate) {
                    super(ofInt, z, intPredicate);
                }

                Taking(java8.util.Spliterator.OfInt ofInt, java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt ofInt2) {
                    super(ofInt, ofInt2);
                }

                @Override // java8.util.Spliterator.OfPrimitive
                public boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
                    boolean zTest;
                    if (this.takeOrDrop && checkCancelOnCount() && ((java8.util.Spliterator.OfInt) this.s).tryAdvance((java8.util.function.IntConsumer) this)) {
                        zTest = this.p.test(this.t);
                        if (zTest) {
                            intConsumer.accept(this.t);
                            return true;
                        }
                    } else {
                        zTest = true;
                    }
                    this.takeOrDrop = false;
                    if (!zTest) {
                        this.cancel.set(true);
                    }
                    return false;
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
                public java8.util.Spliterator.OfInt trySplit() {
                    if (this.cancel.get()) {
                        return null;
                    }
                    return (java8.util.Spliterator.OfInt) super.trySplit();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator
                public java8.util.Spliterator.OfInt makeSpliterator(java8.util.Spliterator.OfInt ofInt) {
                    return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt.Taking(ofInt, this);
                }
            }

            static final class Dropping extends java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt {
                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt, java8.util.Spliterator.OfPrimitive
                public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
                    super.forEachRemaining(intConsumer);
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt, java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
                public /* bridge */ /* synthetic */ java8.util.Spliterator.OfInt trySplit() {
                    return (java8.util.Spliterator.OfInt) super.trySplit();
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt, java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
                public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                    return (java8.util.Spliterator.OfPrimitive) super.trySplit();
                }

                Dropping(java8.util.Spliterator.OfInt ofInt, boolean z, java8.util.function.IntPredicate intPredicate) {
                    super(ofInt, z, intPredicate);
                }

                Dropping(java8.util.Spliterator.OfInt ofInt, java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt ofInt2) {
                    super(ofInt, ofInt2);
                }

                @Override // java8.util.Spliterator.OfPrimitive
                public boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
                    boolean zTryAdvance;
                    if (this.takeOrDrop) {
                        boolean z = false;
                        this.takeOrDrop = false;
                        while (true) {
                            zTryAdvance = ((java8.util.Spliterator.OfInt) this.s).tryAdvance((java8.util.function.IntConsumer) this);
                            if (!zTryAdvance || !checkCancelOnCount() || !this.p.test(this.t)) {
                                break;
                            }
                            z = true;
                        }
                        if (zTryAdvance) {
                            if (z) {
                                this.cancel.set(true);
                            }
                            intConsumer.accept(this.t);
                        }
                        return zTryAdvance;
                    }
                    return ((java8.util.Spliterator.OfInt) this.s).tryAdvance(intConsumer);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator
                public java8.util.Spliterator.OfInt makeSpliterator(java8.util.Spliterator.OfInt ofInt) {
                    return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt.Dropping(ofInt, this);
                }
            }
        }

        static abstract class OfLong extends java8.util.stream.WhileOps.UnorderedWhileSpliterator<java.lang.Long, java8.util.Spliterator.OfLong> implements java8.util.function.LongConsumer, java8.util.Spliterator.OfLong {
            final java8.util.function.LongPredicate p;
            long t;

            @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfLong trySplit() {
                return (java8.util.Spliterator.OfLong) super.trySplit();
            }

            @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                return (java8.util.Spliterator.OfPrimitive) super.trySplit();
            }

            OfLong(java8.util.Spliterator.OfLong ofLong, boolean z, java8.util.function.LongPredicate longPredicate) {
                super(ofLong, z);
                this.p = longPredicate;
            }

            OfLong(java8.util.Spliterator.OfLong ofLong, java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong ofLong2) {
                super(ofLong, ofLong2);
                this.p = ofLong2.p;
            }

            @Override // java8.util.function.LongConsumer
            public void accept(long j) {
                this.count = (this.count + 1) & 63;
                this.t = j;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator
            public java8.util.Spliterator.OfLong makeSpliterator(java8.util.Spliterator.OfLong ofLong) {
                return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong.Dropping(ofLong, this);
            }

            @Override // java8.util.Spliterator
            public boolean hasCharacteristics(int i) {
                return java8.util.Spliterators.hasCharacteristics(this, i);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
                java8.util.Spliterators.OfLong.forEachRemaining(this, longConsumer);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
            }

            static final class Taking extends java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong {
                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong, java8.util.Spliterator.OfPrimitive
                public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
                    super.forEachRemaining(longConsumer);
                }

                Taking(java8.util.Spliterator.OfLong ofLong, boolean z, java8.util.function.LongPredicate longPredicate) {
                    super(ofLong, z, longPredicate);
                }

                Taking(java8.util.Spliterator.OfLong ofLong, java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong ofLong2) {
                    super(ofLong, ofLong2);
                }

                @Override // java8.util.Spliterator.OfPrimitive
                public boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
                    boolean zTest;
                    if (this.takeOrDrop && checkCancelOnCount() && ((java8.util.Spliterator.OfLong) this.s).tryAdvance((java8.util.function.LongConsumer) this)) {
                        zTest = this.p.test(this.t);
                        if (zTest) {
                            longConsumer.accept(this.t);
                            return true;
                        }
                    } else {
                        zTest = true;
                    }
                    this.takeOrDrop = false;
                    if (!zTest) {
                        this.cancel.set(true);
                    }
                    return false;
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
                public java8.util.Spliterator.OfLong trySplit() {
                    if (this.cancel.get()) {
                        return null;
                    }
                    return (java8.util.Spliterator.OfLong) super.trySplit();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong, java8.util.stream.WhileOps.UnorderedWhileSpliterator
                public java8.util.Spliterator.OfLong makeSpliterator(java8.util.Spliterator.OfLong ofLong) {
                    return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong.Taking(ofLong, this);
                }
            }

            static final class Dropping extends java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong {
                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong, java8.util.Spliterator.OfPrimitive
                public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
                    super.forEachRemaining(longConsumer);
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong, java8.util.stream.WhileOps.UnorderedWhileSpliterator
                /* bridge */ /* synthetic */ java8.util.Spliterator makeSpliterator(java8.util.Spliterator spliterator) {
                    return super.makeSpliterator((java8.util.Spliterator.OfLong) spliterator);
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong, java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
                public /* bridge */ /* synthetic */ java8.util.Spliterator.OfLong trySplit() {
                    return (java8.util.Spliterator.OfLong) super.trySplit();
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong, java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
                public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                    return (java8.util.Spliterator.OfPrimitive) super.trySplit();
                }

                Dropping(java8.util.Spliterator.OfLong ofLong, boolean z, java8.util.function.LongPredicate longPredicate) {
                    super(ofLong, z, longPredicate);
                }

                Dropping(java8.util.Spliterator.OfLong ofLong, java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong ofLong2) {
                    super(ofLong, ofLong2);
                }

                @Override // java8.util.Spliterator.OfPrimitive
                public boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
                    boolean zTryAdvance;
                    if (this.takeOrDrop) {
                        boolean z = false;
                        this.takeOrDrop = false;
                        while (true) {
                            zTryAdvance = ((java8.util.Spliterator.OfLong) this.s).tryAdvance((java8.util.function.LongConsumer) this);
                            if (!zTryAdvance || !checkCancelOnCount() || !this.p.test(this.t)) {
                                break;
                            }
                            z = true;
                        }
                        if (zTryAdvance) {
                            if (z) {
                                this.cancel.set(true);
                            }
                            longConsumer.accept(this.t);
                        }
                        return zTryAdvance;
                    }
                    return ((java8.util.Spliterator.OfLong) this.s).tryAdvance(longConsumer);
                }
            }
        }

        static abstract class OfDouble extends java8.util.stream.WhileOps.UnorderedWhileSpliterator<java.lang.Double, java8.util.Spliterator.OfDouble> implements java8.util.function.DoubleConsumer, java8.util.Spliterator.OfDouble {
            final java8.util.function.DoublePredicate p;
            double t;

            @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfDouble trySplit() {
                return (java8.util.Spliterator.OfDouble) super.trySplit();
            }

            @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                return (java8.util.Spliterator.OfPrimitive) super.trySplit();
            }

            OfDouble(java8.util.Spliterator.OfDouble ofDouble, boolean z, java8.util.function.DoublePredicate doublePredicate) {
                super(ofDouble, z);
                this.p = doublePredicate;
            }

            OfDouble(java8.util.Spliterator.OfDouble ofDouble, java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble ofDouble2) {
                super(ofDouble, ofDouble2);
                this.p = ofDouble2.p;
            }

            @Override // java8.util.function.DoubleConsumer
            public void accept(double d) {
                this.count = (this.count + 1) & 63;
                this.t = d;
            }

            @Override // java8.util.Spliterator
            public boolean hasCharacteristics(int i) {
                return java8.util.Spliterators.hasCharacteristics(this, i);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
                java8.util.Spliterators.OfDouble.forEachRemaining(this, doubleConsumer);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
            }

            static final class Taking extends java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble {
                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble, java8.util.Spliterator.OfPrimitive
                public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
                    super.forEachRemaining(doubleConsumer);
                }

                Taking(java8.util.Spliterator.OfDouble ofDouble, boolean z, java8.util.function.DoublePredicate doublePredicate) {
                    super(ofDouble, z, doublePredicate);
                }

                Taking(java8.util.Spliterator.OfDouble ofDouble, java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble ofDouble2) {
                    super(ofDouble, ofDouble2);
                }

                @Override // java8.util.Spliterator.OfPrimitive
                public boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
                    boolean zTest;
                    if (this.takeOrDrop && checkCancelOnCount() && ((java8.util.Spliterator.OfDouble) this.s).tryAdvance((java8.util.function.DoubleConsumer) this)) {
                        zTest = this.p.test(this.t);
                        if (zTest) {
                            doubleConsumer.accept(this.t);
                            return true;
                        }
                    } else {
                        zTest = true;
                    }
                    this.takeOrDrop = false;
                    if (!zTest) {
                        this.cancel.set(true);
                    }
                    return false;
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
                public java8.util.Spliterator.OfDouble trySplit() {
                    if (this.cancel.get()) {
                        return null;
                    }
                    return (java8.util.Spliterator.OfDouble) super.trySplit();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator
                public java8.util.Spliterator.OfDouble makeSpliterator(java8.util.Spliterator.OfDouble ofDouble) {
                    return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble.Taking(ofDouble, this);
                }
            }

            static final class Dropping extends java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble {
                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble, java8.util.Spliterator.OfPrimitive
                public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
                    super.forEachRemaining(doubleConsumer);
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble, java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
                public /* bridge */ /* synthetic */ java8.util.Spliterator.OfDouble trySplit() {
                    return (java8.util.Spliterator.OfDouble) super.trySplit();
                }

                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble, java8.util.stream.WhileOps.UnorderedWhileSpliterator, java8.util.Spliterator
                public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                    return (java8.util.Spliterator.OfPrimitive) super.trySplit();
                }

                Dropping(java8.util.Spliterator.OfDouble ofDouble, boolean z, java8.util.function.DoublePredicate doublePredicate) {
                    super(ofDouble, z, doublePredicate);
                }

                Dropping(java8.util.Spliterator.OfDouble ofDouble, java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble ofDouble2) {
                    super(ofDouble, ofDouble2);
                }

                @Override // java8.util.Spliterator.OfPrimitive
                public boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
                    boolean zTryAdvance;
                    if (this.takeOrDrop) {
                        boolean z = false;
                        this.takeOrDrop = false;
                        while (true) {
                            zTryAdvance = ((java8.util.Spliterator.OfDouble) this.s).tryAdvance((java8.util.function.DoubleConsumer) this);
                            if (!zTryAdvance || !checkCancelOnCount() || !this.p.test(this.t)) {
                                break;
                            }
                            z = true;
                        }
                        if (zTryAdvance) {
                            if (z) {
                                this.cancel.set(true);
                            }
                            doubleConsumer.accept(this.t);
                        }
                        return zTryAdvance;
                    }
                    return ((java8.util.Spliterator.OfDouble) this.s).tryAdvance(doubleConsumer);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // java8.util.stream.WhileOps.UnorderedWhileSpliterator
                public java8.util.Spliterator.OfDouble makeSpliterator(java8.util.Spliterator.OfDouble ofDouble) {
                    return new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble.Dropping(ofDouble, this);
                }
            }
        }
    }

    private static final class TakeWhileTask<P_IN, P_OUT> extends java8.util.stream.AbstractShortCircuitTask<P_IN, P_OUT, java8.util.stream.Node<P_OUT>, java8.util.stream.WhileOps.TakeWhileTask<P_IN, P_OUT>> {
        private volatile boolean completed;
        private final java8.util.function.IntFunction<P_OUT[]> generator;
        private final boolean isOrdered;
        private final java8.util.stream.AbstractPipeline<P_OUT, P_OUT, ?> op;
        private boolean shortCircuited;
        private long thisNodeSize;

        TakeWhileTask(java8.util.stream.AbstractPipeline<P_OUT, P_OUT, ?> abstractPipeline, java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<P_OUT[]> intFunction) {
            super(pipelineHelper, spliterator);
            this.op = abstractPipeline;
            this.generator = intFunction;
            this.isOrdered = java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags());
        }

        TakeWhileTask(java8.util.stream.WhileOps.TakeWhileTask<P_IN, P_OUT> takeWhileTask, java8.util.Spliterator<P_IN> spliterator) {
            super(takeWhileTask, spliterator);
            this.op = takeWhileTask.op;
            this.generator = takeWhileTask.generator;
            this.isOrdered = takeWhileTask.isOrdered;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public java8.util.stream.WhileOps.TakeWhileTask<P_IN, P_OUT> makeChild(java8.util.Spliterator<P_IN> spliterator) {
            return new java8.util.stream.WhileOps.TakeWhileTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractShortCircuitTask
        public final java8.util.stream.Node<P_OUT> getEmptyResult() {
            return java8.util.stream.Nodes.emptyNode(this.op.getOutputShape());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public final java8.util.stream.Node<P_OUT> doLeaf() {
            java8.util.stream.Node.Builder<P_OUT> builderMakeNodeBuilder = this.helper.makeNodeBuilder(-1L, this.generator);
            boolean zCopyIntoWithCancel = this.helper.copyIntoWithCancel(this.helper.wrapSink((java8.util.stream.Sink) this.op.opWrapSink(this.helper.getStreamAndOpFlags(), builderMakeNodeBuilder)), this.spliterator);
            this.shortCircuited = zCopyIntoWithCancel;
            if (zCopyIntoWithCancel) {
                cancelLaterNodes();
            }
            java8.util.stream.Node<P_OUT> nodeBuild2 = builderMakeNodeBuilder.build2();
            this.thisNodeSize = nodeBuild2.count();
            return nodeBuild2;
        }

        @Override // java8.util.stream.AbstractTask, java8.util.concurrent.CountedCompleter
        public final void onCompletion(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
            java8.util.stream.Node<P_OUT> nodeMerge;
            if (!isLeaf()) {
                this.shortCircuited = ((java8.util.stream.WhileOps.TakeWhileTask) this.leftChild).shortCircuited | ((java8.util.stream.WhileOps.TakeWhileTask) this.rightChild).shortCircuited;
                if (this.isOrdered && this.canceled) {
                    this.thisNodeSize = 0L;
                    nodeMerge = getEmptyResult();
                } else if (this.isOrdered && ((java8.util.stream.WhileOps.TakeWhileTask) this.leftChild).shortCircuited) {
                    this.thisNodeSize = ((java8.util.stream.WhileOps.TakeWhileTask) this.leftChild).thisNodeSize;
                    nodeMerge = ((java8.util.stream.WhileOps.TakeWhileTask) this.leftChild).getLocalResult();
                } else {
                    this.thisNodeSize = ((java8.util.stream.WhileOps.TakeWhileTask) this.leftChild).thisNodeSize + ((java8.util.stream.WhileOps.TakeWhileTask) this.rightChild).thisNodeSize;
                    nodeMerge = merge();
                }
                setLocalResult(nodeMerge);
            }
            this.completed = true;
            super.onCompletion(countedCompleter);
        }

        java8.util.stream.Node<P_OUT> merge() {
            if (((java8.util.stream.WhileOps.TakeWhileTask) this.leftChild).thisNodeSize == 0) {
                return ((java8.util.stream.WhileOps.TakeWhileTask) this.rightChild).getLocalResult();
            }
            if (((java8.util.stream.WhileOps.TakeWhileTask) this.rightChild).thisNodeSize == 0) {
                return ((java8.util.stream.WhileOps.TakeWhileTask) this.leftChild).getLocalResult();
            }
            return java8.util.stream.Nodes.conc(this.op.getOutputShape(), ((java8.util.stream.WhileOps.TakeWhileTask) this.leftChild).getLocalResult(), ((java8.util.stream.WhileOps.TakeWhileTask) this.rightChild).getLocalResult());
        }

        @Override // java8.util.stream.AbstractShortCircuitTask
        protected void cancel() {
            super.cancel();
            if (this.isOrdered && this.completed) {
                setLocalResult(getEmptyResult());
            }
        }
    }

    private static final class DropWhileTask<P_IN, P_OUT> extends java8.util.stream.AbstractTask<P_IN, P_OUT, java8.util.stream.Node<P_OUT>, java8.util.stream.WhileOps.DropWhileTask<P_IN, P_OUT>> {
        private final java8.util.function.IntFunction<P_OUT[]> generator;
        private long index;
        private final boolean isOrdered;
        private final java8.util.stream.AbstractPipeline<P_OUT, P_OUT, ?> op;
        private long thisNodeSize;

        DropWhileTask(java8.util.stream.AbstractPipeline<P_OUT, P_OUT, ?> abstractPipeline, java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<P_OUT[]> intFunction) {
            super(pipelineHelper, spliterator);
            this.op = abstractPipeline;
            this.generator = intFunction;
            this.isOrdered = java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags());
        }

        DropWhileTask(java8.util.stream.WhileOps.DropWhileTask<P_IN, P_OUT> dropWhileTask, java8.util.Spliterator<P_IN> spliterator) {
            super(dropWhileTask, spliterator);
            this.op = dropWhileTask.op;
            this.generator = dropWhileTask.generator;
            this.isOrdered = dropWhileTask.isOrdered;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public java8.util.stream.WhileOps.DropWhileTask<P_IN, P_OUT> makeChild(java8.util.Spliterator<P_IN> spliterator) {
            return new java8.util.stream.WhileOps.DropWhileTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public final java8.util.stream.Node<P_OUT> doLeaf() {
            boolean z = !isRoot();
            java8.util.stream.Node.Builder<P_OUT> builderMakeNodeBuilder = this.helper.makeNodeBuilder((z && this.isOrdered && java8.util.stream.StreamOpFlag.SIZED.isPreserved(this.op.sourceOrOpFlags)) ? this.op.exactOutputSizeIfKnown(this.spliterator) : -1L, this.generator);
            java8.util.stream.WhileOps.DropWhileSink dropWhileSinkOpWrapSink = ((java8.util.stream.WhileOps.DropWhileOp) this.op).opWrapSink(builderMakeNodeBuilder, this.isOrdered && z);
            this.helper.wrapAndCopyInto(dropWhileSinkOpWrapSink, (java8.util.Spliterator) this.spliterator);
            java8.util.stream.Node<P_OUT> nodeBuild2 = builderMakeNodeBuilder.build2();
            this.thisNodeSize = nodeBuild2.count();
            this.index = dropWhileSinkOpWrapSink.getDropCount();
            return nodeBuild2;
        }

        @Override // java8.util.stream.AbstractTask, java8.util.concurrent.CountedCompleter
        public final void onCompletion(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
            if (!isLeaf()) {
                if (this.isOrdered) {
                    long j = ((java8.util.stream.WhileOps.DropWhileTask) this.leftChild).index;
                    this.index = j;
                    if (j == ((java8.util.stream.WhileOps.DropWhileTask) this.leftChild).thisNodeSize) {
                        this.index += ((java8.util.stream.WhileOps.DropWhileTask) this.rightChild).index;
                    }
                }
                this.thisNodeSize = ((java8.util.stream.WhileOps.DropWhileTask) this.leftChild).thisNodeSize + ((java8.util.stream.WhileOps.DropWhileTask) this.rightChild).thisNodeSize;
                java8.util.stream.Node<P_OUT> nodeMerge = merge();
                if (isRoot()) {
                    nodeMerge = doTruncate(nodeMerge);
                }
                setLocalResult(nodeMerge);
            }
            super.onCompletion(countedCompleter);
        }

        private java8.util.stream.Node<P_OUT> merge() {
            if (((java8.util.stream.WhileOps.DropWhileTask) this.leftChild).thisNodeSize == 0) {
                return ((java8.util.stream.WhileOps.DropWhileTask) this.rightChild).getLocalResult();
            }
            if (((java8.util.stream.WhileOps.DropWhileTask) this.rightChild).thisNodeSize == 0) {
                return ((java8.util.stream.WhileOps.DropWhileTask) this.leftChild).getLocalResult();
            }
            return java8.util.stream.Nodes.conc(this.op.getOutputShape(), ((java8.util.stream.WhileOps.DropWhileTask) this.leftChild).getLocalResult(), ((java8.util.stream.WhileOps.DropWhileTask) this.rightChild).getLocalResult());
        }

        private java8.util.stream.Node<P_OUT> doTruncate(java8.util.stream.Node<P_OUT> node) {
            return this.isOrdered ? node.truncate(this.index, node.count(), this.generator) : node;
        }
    }
}
