package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class SliceOps {
    /* JADX INFO: Access modifiers changed from: private */
    public static long calcSliceFence(long j, long j2) {
        long j3 = j2 >= 0 ? j + j2 : Long.MAX_VALUE;
        if (j3 >= 0) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    private SliceOps() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long calcSize(long j, long j2, long j3) {
        if (j >= 0) {
            return java.lang.Math.max(-1L, java.lang.Math.min(j - j2, j3));
        }
        return -1L;
    }

    /* JADX INFO: renamed from: java8.util.stream.SliceOps$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$java8$util$stream$StreamShape;

        static {
            int[] iArr = new int[java8.util.stream.StreamShape.values().length];
            $SwitchMap$java8$util$stream$StreamShape = iArr;
            try {
                iArr[java8.util.stream.StreamShape.REFERENCE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java8$util$stream$StreamShape[java8.util.stream.StreamShape.INT_VALUE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java8$util$stream$StreamShape[java8.util.stream.StreamShape.LONG_VALUE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java8$util$stream$StreamShape[java8.util.stream.StreamShape.DOUBLE_VALUE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <P_IN> java8.util.Spliterator<P_IN> sliceSpliterator(java8.util.stream.StreamShape streamShape, java8.util.Spliterator<P_IN> spliterator, long j, long j2) {
        long jCalcSliceFence = calcSliceFence(j, j2);
        int i = java8.util.stream.SliceOps.AnonymousClass5.$SwitchMap$java8$util$stream$StreamShape[streamShape.ordinal()];
        if (i == 1) {
            return new java8.util.stream.StreamSpliterators.SliceSpliterator.OfRef(spliterator, j, jCalcSliceFence);
        }
        if (i == 2) {
            return new java8.util.stream.StreamSpliterators.SliceSpliterator.OfInt((java8.util.Spliterator.OfInt) spliterator, j, jCalcSliceFence);
        }
        if (i == 3) {
            return new java8.util.stream.StreamSpliterators.SliceSpliterator.OfLong((java8.util.Spliterator.OfLong) spliterator, j, jCalcSliceFence);
        }
        if (i == 4) {
            return new java8.util.stream.StreamSpliterators.SliceSpliterator.OfDouble((java8.util.Spliterator.OfDouble) spliterator, j, jCalcSliceFence);
        }
        throw new java.lang.IllegalStateException("Unknown shape " + streamShape);
    }

    public static <T> java8.util.stream.Stream<T> makeRef(java8.util.stream.AbstractPipeline<?, T, ?> abstractPipeline, final long j, final long j2) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Skip must be non-negative: " + j);
        }
        return new java8.util.stream.ReferencePipeline.StatefulOp<T, T>(abstractPipeline, java8.util.stream.StreamShape.REFERENCE, flags(j2)) { // from class: java8.util.stream.SliceOps.1
            java8.util.Spliterator<T> unorderedSkipLimitSpliterator(java8.util.Spliterator<T> spliterator, long j3, long j4, long j5) {
                long j6;
                long jMin;
                if (j3 <= j5) {
                    long j7 = j5 - j3;
                    jMin = j4 >= 0 ? java.lang.Math.min(j4, j7) : j7;
                    j6 = 0;
                } else {
                    j6 = j3;
                    jMin = j4;
                }
                return new java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef(spliterator, j6, jMin);
            }

            @Override // java8.util.stream.AbstractPipeline
            <P_IN> java8.util.Spliterator<T> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                if (jExactOutputSizeIfKnown > 0 && spliterator.hasCharacteristics(16384)) {
                    java8.util.Spliterator<T> spliteratorWrapSpliterator = pipelineHelper.wrapSpliterator(spliterator);
                    long j3 = j;
                    return new java8.util.stream.StreamSpliterators.SliceSpliterator.OfRef(spliteratorWrapSpliterator, j3, java8.util.stream.SliceOps.calcSliceFence(j3, j2));
                }
                if (!java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return unorderedSkipLimitSpliterator(pipelineHelper.wrapSpliterator(spliterator), j, j2, jExactOutputSizeIfKnown);
                }
                return new java8.util.stream.SliceOps.SliceTask(this, pipelineHelper, spliterator, java8.util.stream.Nodes.castingArray(), j, j2).invoke().spliterator();
            }

            @Override // java8.util.stream.ReferencePipeline.StatefulOp, java8.util.stream.AbstractPipeline
            <P_IN> java8.util.stream.Node<T> opEvaluateParallel(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<T[]> intFunction) {
                long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                if (jExactOutputSizeIfKnown > 0 && spliterator.hasCharacteristics(16384)) {
                    return java8.util.stream.Nodes.collect(pipelineHelper, java8.util.stream.SliceOps.sliceSpliterator(pipelineHelper.getSourceShape(), spliterator, j, j2), true, intFunction);
                }
                if (!java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return java8.util.stream.Nodes.collect(this, unorderedSkipLimitSpliterator(pipelineHelper.wrapSpliterator(spliterator), j, j2, jExactOutputSizeIfKnown), true, intFunction);
                }
                return (java8.util.stream.Node) new java8.util.stream.SliceOps.SliceTask(this, pipelineHelper, spliterator, intFunction, j, j2).invoke();
            }

            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<T> opWrapSink(int i, java8.util.stream.Sink<T> sink) {
                return new java8.util.stream.Sink.ChainedReference<T, T>(sink) { // from class: java8.util.stream.SliceOps.1.1
                    long m;
                    long n;

                    {
                        this.n = j;
                        this.m = j2 >= 0 ? j2 : Long.MAX_VALUE;
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
                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public void begin(long j3) {
                        this.downstream.begin(java8.util.stream.SliceOps.calcSize(j3, j, this.m));
                    }

                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // java8.util.function.Consumer
                    public void accept(T t) {
                        long j3 = this.n;
                        if (j3 == 0) {
                            long j4 = this.m;
                            if (j4 > 0) {
                                this.m = j4 - 1;
                                this.downstream.accept((java.lang.Object) t);
                                return;
                            }
                            return;
                        }
                        this.n = j3 - 1;
                    }

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        return this.m == 0 || this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    public static java8.util.stream.IntStream makeInt(java8.util.stream.AbstractPipeline<?, java.lang.Integer, ?> abstractPipeline, final long j, final long j2) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Skip must be non-negative: " + j);
        }
        return new java8.util.stream.IntPipeline.StatefulOp<java.lang.Integer>(abstractPipeline, java8.util.stream.StreamShape.INT_VALUE, flags(j2)) { // from class: java8.util.stream.SliceOps.2
            java8.util.Spliterator.OfInt unorderedSkipLimitSpliterator(java8.util.Spliterator.OfInt ofInt, long j3, long j4, long j5) {
                long j6;
                long jMin;
                if (j3 <= j5) {
                    long j7 = j5 - j3;
                    jMin = j4 >= 0 ? java.lang.Math.min(j4, j7) : j7;
                    j6 = 0;
                } else {
                    j6 = j3;
                    jMin = j4;
                }
                return new java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt(ofInt, j6, jMin);
            }

            @Override // java8.util.stream.AbstractPipeline
            <P_IN> java8.util.Spliterator<java.lang.Integer> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                if (jExactOutputSizeIfKnown > 0 && spliterator.hasCharacteristics(16384)) {
                    java8.util.Spliterator.OfInt ofInt = (java8.util.Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator);
                    long j3 = j;
                    return new java8.util.stream.StreamSpliterators.SliceSpliterator.OfInt(ofInt, j3, java8.util.stream.SliceOps.calcSliceFence(j3, j2));
                }
                if (!java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return unorderedSkipLimitSpliterator((java8.util.Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator), j, j2, jExactOutputSizeIfKnown);
                }
                return new java8.util.stream.SliceOps.SliceTask(this, pipelineHelper, spliterator, java8.util.stream.WhileOps.INT_ARR_GEN, j, j2).invoke().spliterator();
            }

            @Override // java8.util.stream.IntPipeline.StatefulOp, java8.util.stream.AbstractPipeline
            <P_IN> java8.util.stream.Node<java.lang.Integer> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
                long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                if (jExactOutputSizeIfKnown > 0 && spliterator.hasCharacteristics(16384)) {
                    return java8.util.stream.Nodes.collectInt(pipelineHelper, java8.util.stream.SliceOps.sliceSpliterator(pipelineHelper.getSourceShape(), spliterator, j, j2), true);
                }
                if (!java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return java8.util.stream.Nodes.collectInt(this, unorderedSkipLimitSpliterator((java8.util.Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator), j, j2, jExactOutputSizeIfKnown), true);
                }
                return (java8.util.stream.Node) new java8.util.stream.SliceOps.SliceTask(this, pipelineHelper, spliterator, intFunction, j, j2).invoke();
            }

            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
                return new java8.util.stream.Sink.ChainedInt<java.lang.Integer>(sink) { // from class: java8.util.stream.SliceOps.2.1
                    long m;
                    long n;

                    {
                        this.n = j;
                        this.m = j2 >= 0 ? j2 : Long.MAX_VALUE;
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
                    @Override // java8.util.stream.Sink.ChainedInt, java8.util.stream.Sink
                    public void begin(long j3) {
                        this.downstream.begin(java8.util.stream.SliceOps.calcSize(j3, j, this.m));
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
                        long j3 = this.n;
                        if (j3 == 0) {
                            long j4 = this.m;
                            if (j4 > 0) {
                                this.m = j4 - 1;
                                this.downstream.accept(i2);
                                return;
                            }
                            return;
                        }
                        this.n = j3 - 1;
                    }

                    @Override // java8.util.stream.Sink.ChainedInt, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        return this.m == 0 || this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    public static java8.util.stream.LongStream makeLong(java8.util.stream.AbstractPipeline<?, java.lang.Long, ?> abstractPipeline, final long j, final long j2) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Skip must be non-negative: " + j);
        }
        return new java8.util.stream.LongPipeline.StatefulOp<java.lang.Long>(abstractPipeline, java8.util.stream.StreamShape.LONG_VALUE, flags(j2)) { // from class: java8.util.stream.SliceOps.3
            java8.util.Spliterator.OfLong unorderedSkipLimitSpliterator(java8.util.Spliterator.OfLong ofLong, long j3, long j4, long j5) {
                long j6;
                long jMin;
                if (j3 <= j5) {
                    long j7 = j5 - j3;
                    jMin = j4 >= 0 ? java.lang.Math.min(j4, j7) : j7;
                    j6 = 0;
                } else {
                    j6 = j3;
                    jMin = j4;
                }
                return new java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong(ofLong, j6, jMin);
            }

            @Override // java8.util.stream.AbstractPipeline
            <P_IN> java8.util.Spliterator<java.lang.Long> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                if (jExactOutputSizeIfKnown > 0 && spliterator.hasCharacteristics(16384)) {
                    java8.util.Spliterator.OfLong ofLong = (java8.util.Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator);
                    long j3 = j;
                    return new java8.util.stream.StreamSpliterators.SliceSpliterator.OfLong(ofLong, j3, java8.util.stream.SliceOps.calcSliceFence(j3, j2));
                }
                if (!java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return unorderedSkipLimitSpliterator((java8.util.Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator), j, j2, jExactOutputSizeIfKnown);
                }
                return new java8.util.stream.SliceOps.SliceTask(this, pipelineHelper, spliterator, java8.util.stream.WhileOps.LONG_ARR_GEN, j, j2).invoke().spliterator();
            }

            @Override // java8.util.stream.LongPipeline.StatefulOp, java8.util.stream.AbstractPipeline
            <P_IN> java8.util.stream.Node<java.lang.Long> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
                long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                if (jExactOutputSizeIfKnown > 0 && spliterator.hasCharacteristics(16384)) {
                    return java8.util.stream.Nodes.collectLong(pipelineHelper, java8.util.stream.SliceOps.sliceSpliterator(pipelineHelper.getSourceShape(), spliterator, j, j2), true);
                }
                if (!java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return java8.util.stream.Nodes.collectLong(this, unorderedSkipLimitSpliterator((java8.util.Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator), j, j2, jExactOutputSizeIfKnown), true);
                }
                return (java8.util.stream.Node) new java8.util.stream.SliceOps.SliceTask(this, pipelineHelper, spliterator, intFunction, j, j2).invoke();
            }

            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Long> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
                return new java8.util.stream.Sink.ChainedLong<java.lang.Long>(sink) { // from class: java8.util.stream.SliceOps.3.1
                    long m;
                    long n;

                    {
                        this.n = j;
                        this.m = j2 >= 0 ? j2 : Long.MAX_VALUE;
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
                    @Override // java8.util.stream.Sink.ChainedLong, java8.util.stream.Sink
                    public void begin(long j3) {
                        this.downstream.begin(java8.util.stream.SliceOps.calcSize(j3, j, this.m));
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
                    public void accept(long j3) {
                        long j4 = this.n;
                        if (j4 == 0) {
                            long j5 = this.m;
                            if (j5 > 0) {
                                this.m = j5 - 1;
                                this.downstream.accept(j3);
                                return;
                            }
                            return;
                        }
                        this.n = j4 - 1;
                    }

                    @Override // java8.util.stream.Sink.ChainedLong, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        return this.m == 0 || this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    public static java8.util.stream.DoubleStream makeDouble(java8.util.stream.AbstractPipeline<?, java.lang.Double, ?> abstractPipeline, final long j, final long j2) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Skip must be non-negative: " + j);
        }
        return new java8.util.stream.DoublePipeline.StatefulOp<java.lang.Double>(abstractPipeline, java8.util.stream.StreamShape.DOUBLE_VALUE, flags(j2)) { // from class: java8.util.stream.SliceOps.4
            java8.util.Spliterator.OfDouble unorderedSkipLimitSpliterator(java8.util.Spliterator.OfDouble ofDouble, long j3, long j4, long j5) {
                long j6;
                long jMin;
                if (j3 <= j5) {
                    long j7 = j5 - j3;
                    jMin = j4 >= 0 ? java.lang.Math.min(j4, j7) : j7;
                    j6 = 0;
                } else {
                    j6 = j3;
                    jMin = j4;
                }
                return new java8.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble(ofDouble, j6, jMin);
            }

            @Override // java8.util.stream.AbstractPipeline
            <P_IN> java8.util.Spliterator<java.lang.Double> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                if (jExactOutputSizeIfKnown > 0 && spliterator.hasCharacteristics(16384)) {
                    java8.util.Spliterator.OfDouble ofDouble = (java8.util.Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator);
                    long j3 = j;
                    return new java8.util.stream.StreamSpliterators.SliceSpliterator.OfDouble(ofDouble, j3, java8.util.stream.SliceOps.calcSliceFence(j3, j2));
                }
                if (!java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return unorderedSkipLimitSpliterator((java8.util.Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator), j, j2, jExactOutputSizeIfKnown);
                }
                return new java8.util.stream.SliceOps.SliceTask(this, pipelineHelper, spliterator, java8.util.stream.WhileOps.DOUBLE_ARR_GEN, j, j2).invoke().spliterator();
            }

            @Override // java8.util.stream.DoublePipeline.StatefulOp, java8.util.stream.AbstractPipeline
            <P_IN> java8.util.stream.Node<java.lang.Double> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
                long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                if (jExactOutputSizeIfKnown > 0 && spliterator.hasCharacteristics(16384)) {
                    return java8.util.stream.Nodes.collectDouble(pipelineHelper, java8.util.stream.SliceOps.sliceSpliterator(pipelineHelper.getSourceShape(), spliterator, j, j2), true);
                }
                if (!java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return java8.util.stream.Nodes.collectDouble(this, unorderedSkipLimitSpliterator((java8.util.Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator), j, j2, jExactOutputSizeIfKnown), true);
                }
                return (java8.util.stream.Node) new java8.util.stream.SliceOps.SliceTask(this, pipelineHelper, spliterator, intFunction, j, j2).invoke();
            }

            @Override // java8.util.stream.AbstractPipeline
            java8.util.stream.Sink<java.lang.Double> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
                return new java8.util.stream.Sink.ChainedDouble<java.lang.Double>(sink) { // from class: java8.util.stream.SliceOps.4.1
                    long m;
                    long n;

                    {
                        this.n = j;
                        this.m = j2 >= 0 ? j2 : Long.MAX_VALUE;
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
                    @Override // java8.util.stream.Sink.ChainedDouble, java8.util.stream.Sink
                    public void begin(long j3) {
                        this.downstream.begin(java8.util.stream.SliceOps.calcSize(j3, j, this.m));
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
                        long j3 = this.n;
                        if (j3 == 0) {
                            long j4 = this.m;
                            if (j4 > 0) {
                                this.m = j4 - 1;
                                this.downstream.accept(d);
                                return;
                            }
                            return;
                        }
                        this.n = j3 - 1;
                    }

                    @Override // java8.util.stream.Sink.ChainedDouble, java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        return this.m == 0 || this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    private static int flags(long j) {
        return (j != -1 ? java8.util.stream.StreamOpFlag.IS_SHORT_CIRCUIT : 0) | java8.util.stream.StreamOpFlag.NOT_SIZED;
    }

    private static final class SliceTask<P_IN, P_OUT> extends java8.util.stream.AbstractShortCircuitTask<P_IN, P_OUT, java8.util.stream.Node<P_OUT>, java8.util.stream.SliceOps.SliceTask<P_IN, P_OUT>> {
        private volatile boolean completed;
        private final java8.util.function.IntFunction<P_OUT[]> generator;
        private final java8.util.stream.AbstractPipeline<P_OUT, P_OUT, ?> op;
        private final long targetOffset;
        private final long targetSize;
        private long thisNodeSize;

        SliceTask(java8.util.stream.AbstractPipeline<P_OUT, P_OUT, ?> abstractPipeline, java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<P_OUT[]> intFunction, long j, long j2) {
            super(pipelineHelper, spliterator);
            this.op = abstractPipeline;
            this.generator = intFunction;
            this.targetOffset = j;
            this.targetSize = j2;
        }

        SliceTask(java8.util.stream.SliceOps.SliceTask<P_IN, P_OUT> sliceTask, java8.util.Spliterator<P_IN> spliterator) {
            super(sliceTask, spliterator);
            this.op = sliceTask.op;
            this.generator = sliceTask.generator;
            this.targetOffset = sliceTask.targetOffset;
            this.targetSize = sliceTask.targetSize;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public java8.util.stream.SliceOps.SliceTask<P_IN, P_OUT> makeChild(java8.util.Spliterator<P_IN> spliterator) {
            return new java8.util.stream.SliceOps.SliceTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractShortCircuitTask
        public final java8.util.stream.Node<P_OUT> getEmptyResult() {
            return java8.util.stream.Nodes.emptyNode(this.op.getOutputShape());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public final java8.util.stream.Node<P_OUT> doLeaf() {
            if (isRoot()) {
                java8.util.stream.Node.Builder<P_OUT> builderMakeNodeBuilder = this.op.makeNodeBuilder(java8.util.stream.StreamOpFlag.SIZED.isPreserved(this.op.sourceOrOpFlags) ? this.op.exactOutputSizeIfKnown(this.spliterator) : -1L, this.generator);
                this.helper.copyIntoWithCancel(this.helper.wrapSink((java8.util.stream.Sink) this.op.opWrapSink(this.helper.getStreamAndOpFlags(), builderMakeNodeBuilder)), this.spliterator);
                return builderMakeNodeBuilder.build2();
            }
            java8.util.stream.Node.Builder<P_OUT> builderMakeNodeBuilder2 = this.op.makeNodeBuilder(-1L, this.generator);
            if (this.targetOffset == 0) {
                this.helper.copyIntoWithCancel(this.helper.wrapSink((java8.util.stream.Sink) this.op.opWrapSink(this.helper.getStreamAndOpFlags(), builderMakeNodeBuilder2)), this.spliterator);
            } else {
                this.helper.wrapAndCopyInto(builderMakeNodeBuilder2, (java8.util.Spliterator) this.spliterator);
            }
            java8.util.stream.Node<P_OUT> nodeBuild2 = builderMakeNodeBuilder2.build2();
            this.thisNodeSize = nodeBuild2.count();
            this.completed = true;
            this.spliterator = null;
            return nodeBuild2;
        }

        @Override // java8.util.stream.AbstractTask, java8.util.concurrent.CountedCompleter
        public final void onCompletion(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
            java8.util.stream.Node<P_OUT> nodeConc;
            if (!isLeaf()) {
                this.thisNodeSize = ((java8.util.stream.SliceOps.SliceTask) this.leftChild).thisNodeSize + ((java8.util.stream.SliceOps.SliceTask) this.rightChild).thisNodeSize;
                if (this.canceled) {
                    this.thisNodeSize = 0L;
                    nodeConc = getEmptyResult();
                } else if (this.thisNodeSize == 0) {
                    nodeConc = getEmptyResult();
                } else if (((java8.util.stream.SliceOps.SliceTask) this.leftChild).thisNodeSize == 0) {
                    nodeConc = ((java8.util.stream.SliceOps.SliceTask) this.rightChild).getLocalResult();
                } else {
                    nodeConc = java8.util.stream.Nodes.conc(this.op.getOutputShape(), ((java8.util.stream.SliceOps.SliceTask) this.leftChild).getLocalResult(), ((java8.util.stream.SliceOps.SliceTask) this.rightChild).getLocalResult());
                }
                if (isRoot()) {
                    nodeConc = doTruncate(nodeConc);
                }
                setLocalResult(nodeConc);
                this.completed = true;
            }
            if (this.targetSize >= 0 && !isRoot() && isLeftCompleted(this.targetOffset + this.targetSize)) {
                cancelLaterNodes();
            }
            super.onCompletion(countedCompleter);
        }

        @Override // java8.util.stream.AbstractShortCircuitTask
        protected void cancel() {
            super.cancel();
            if (this.completed) {
                setLocalResult(getEmptyResult());
            }
        }

        private java8.util.stream.Node<P_OUT> doTruncate(java8.util.stream.Node<P_OUT> node) {
            return node.truncate(this.targetOffset, this.targetSize >= 0 ? java.lang.Math.min(node.count(), this.targetOffset + this.targetSize) : this.thisNodeSize, this.generator);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private boolean isLeftCompleted(long j) {
            java8.util.stream.SliceOps.SliceTask sliceTask;
            long jCompletedSize = this.completed ? this.thisNodeSize : completedSize(j);
            if (jCompletedSize >= j) {
                return true;
            }
            java8.util.stream.SliceOps.SliceTask<P_IN, P_OUT> sliceTask2 = this;
            for (java8.util.stream.SliceOps.SliceTask<P_IN, P_OUT> sliceTask3 = (java8.util.stream.SliceOps.SliceTask) getParent(); sliceTask3 != null; sliceTask3 = (java8.util.stream.SliceOps.SliceTask) sliceTask3.getParent()) {
                if (sliceTask2 == sliceTask3.rightChild && (sliceTask = (java8.util.stream.SliceOps.SliceTask) sliceTask3.leftChild) != null) {
                    jCompletedSize += sliceTask.completedSize(j);
                    if (jCompletedSize >= j) {
                        return true;
                    }
                }
                sliceTask2 = sliceTask3;
            }
            return jCompletedSize >= j;
        }

        private long completedSize(long j) {
            if (this.completed) {
                return this.thisNodeSize;
            }
            java8.util.stream.SliceOps.SliceTask sliceTask = (java8.util.stream.SliceOps.SliceTask) this.leftChild;
            java8.util.stream.SliceOps.SliceTask sliceTask2 = (java8.util.stream.SliceOps.SliceTask) this.rightChild;
            if (sliceTask == null || sliceTask2 == null) {
                return this.thisNodeSize;
            }
            long jCompletedSize = sliceTask.completedSize(j);
            return jCompletedSize >= j ? jCompletedSize : jCompletedSize + sliceTask2.completedSize(j);
        }
    }
}
