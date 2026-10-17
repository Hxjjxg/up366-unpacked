package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class SortedOps {
    private SortedOps() {
    }

    static <T> java8.util.stream.Stream<T> makeRef(java8.util.stream.AbstractPipeline<?, T, ?> abstractPipeline) {
        return new java8.util.stream.SortedOps.OfRef(abstractPipeline);
    }

    static <T> java8.util.stream.Stream<T> makeRef(java8.util.stream.AbstractPipeline<?, T, ?> abstractPipeline, java.util.Comparator<? super T> comparator) {
        return new java8.util.stream.SortedOps.OfRef(abstractPipeline, comparator);
    }

    static <T> java8.util.stream.IntStream makeInt(java8.util.stream.AbstractPipeline<?, java.lang.Integer, ?> abstractPipeline) {
        return new java8.util.stream.SortedOps.OfInt(abstractPipeline);
    }

    static <T> java8.util.stream.LongStream makeLong(java8.util.stream.AbstractPipeline<?, java.lang.Long, ?> abstractPipeline) {
        return new java8.util.stream.SortedOps.OfLong(abstractPipeline);
    }

    static <T> java8.util.stream.DoubleStream makeDouble(java8.util.stream.AbstractPipeline<?, java.lang.Double, ?> abstractPipeline) {
        return new java8.util.stream.SortedOps.OfDouble(abstractPipeline);
    }

    private static final class OfRef<T> extends java8.util.stream.ReferencePipeline.StatefulOp<T, T> {
        private final java.util.Comparator<? super T> comparator;
        private final boolean isNaturalSort;

        OfRef(java8.util.stream.AbstractPipeline<?, T, ?> abstractPipeline) {
            super(abstractPipeline, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.IS_ORDERED | java8.util.stream.StreamOpFlag.IS_SORTED);
            this.isNaturalSort = true;
            this.comparator = java8.util.Comparators.naturalOrder();
        }

        OfRef(java8.util.stream.AbstractPipeline<?, T, ?> abstractPipeline, java.util.Comparator<? super T> comparator) {
            super(abstractPipeline, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.IS_ORDERED | java8.util.stream.StreamOpFlag.NOT_SORTED);
            this.isNaturalSort = false;
            this.comparator = (java.util.Comparator) java8.util.Objects.requireNonNull(comparator);
        }

        @Override // java8.util.stream.AbstractPipeline
        public java8.util.stream.Sink<T> opWrapSink(int i, java8.util.stream.Sink<T> sink) {
            java8.util.Objects.requireNonNull(sink);
            if (java8.util.stream.StreamOpFlag.SORTED.isKnown(i) && this.isNaturalSort) {
                return sink;
            }
            if (java8.util.stream.StreamOpFlag.SIZED.isKnown(i)) {
                return new java8.util.stream.SortedOps.SizedRefSortingSink(sink, this.comparator);
            }
            return new java8.util.stream.SortedOps.RefSortingSink(sink, this.comparator);
        }

        @Override // java8.util.stream.ReferencePipeline.StatefulOp, java8.util.stream.AbstractPipeline
        public <P_IN> java8.util.stream.Node<T> opEvaluateParallel(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<T[]> intFunction) {
            if (java8.util.stream.StreamOpFlag.SORTED.isKnown(pipelineHelper.getStreamAndOpFlags()) && this.isNaturalSort) {
                return pipelineHelper.evaluate(spliterator, false, intFunction);
            }
            T[] tArrAsArray = pipelineHelper.evaluate(spliterator, true, intFunction).asArray(intFunction);
            java8.util.J8Arrays.parallelSort(tArrAsArray, this.comparator);
            return java8.util.stream.Nodes.node(tArrAsArray);
        }
    }

    private static final class OfInt extends java8.util.stream.IntPipeline.StatefulOp<java.lang.Integer> {
        OfInt(java8.util.stream.AbstractPipeline<?, java.lang.Integer, ?> abstractPipeline) {
            super(abstractPipeline, java8.util.stream.StreamShape.INT_VALUE, java8.util.stream.StreamOpFlag.IS_ORDERED | java8.util.stream.StreamOpFlag.IS_SORTED);
        }

        @Override // java8.util.stream.AbstractPipeline
        public java8.util.stream.Sink<java.lang.Integer> opWrapSink(int i, java8.util.stream.Sink<java.lang.Integer> sink) {
            java8.util.Objects.requireNonNull(sink);
            if (java8.util.stream.StreamOpFlag.SORTED.isKnown(i)) {
                return sink;
            }
            if (java8.util.stream.StreamOpFlag.SIZED.isKnown(i)) {
                return new java8.util.stream.SortedOps.SizedIntSortingSink(sink);
            }
            return new java8.util.stream.SortedOps.IntSortingSink(sink);
        }

        @Override // java8.util.stream.IntPipeline.StatefulOp, java8.util.stream.AbstractPipeline
        public <P_IN> java8.util.stream.Node<java.lang.Integer> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
            if (java8.util.stream.StreamOpFlag.SORTED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return pipelineHelper.evaluate(spliterator, false, intFunction);
            }
            int[] iArrAsPrimitiveArray = ((java8.util.stream.Node.OfInt) pipelineHelper.evaluate(spliterator, true, intFunction)).asPrimitiveArray();
            java8.util.J8Arrays.parallelSort(iArrAsPrimitiveArray);
            return java8.util.stream.Nodes.node(iArrAsPrimitiveArray);
        }
    }

    private static final class OfLong extends java8.util.stream.LongPipeline.StatefulOp<java.lang.Long> {
        OfLong(java8.util.stream.AbstractPipeline<?, java.lang.Long, ?> abstractPipeline) {
            super(abstractPipeline, java8.util.stream.StreamShape.LONG_VALUE, java8.util.stream.StreamOpFlag.IS_ORDERED | java8.util.stream.StreamOpFlag.IS_SORTED);
        }

        @Override // java8.util.stream.AbstractPipeline
        public java8.util.stream.Sink<java.lang.Long> opWrapSink(int i, java8.util.stream.Sink<java.lang.Long> sink) {
            java8.util.Objects.requireNonNull(sink);
            if (java8.util.stream.StreamOpFlag.SORTED.isKnown(i)) {
                return sink;
            }
            if (java8.util.stream.StreamOpFlag.SIZED.isKnown(i)) {
                return new java8.util.stream.SortedOps.SizedLongSortingSink(sink);
            }
            return new java8.util.stream.SortedOps.LongSortingSink(sink);
        }

        @Override // java8.util.stream.LongPipeline.StatefulOp, java8.util.stream.AbstractPipeline
        public <P_IN> java8.util.stream.Node<java.lang.Long> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
            if (java8.util.stream.StreamOpFlag.SORTED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return pipelineHelper.evaluate(spliterator, false, intFunction);
            }
            long[] jArrAsPrimitiveArray = ((java8.util.stream.Node.OfLong) pipelineHelper.evaluate(spliterator, true, intFunction)).asPrimitiveArray();
            java8.util.J8Arrays.parallelSort(jArrAsPrimitiveArray);
            return java8.util.stream.Nodes.node(jArrAsPrimitiveArray);
        }
    }

    private static final class OfDouble extends java8.util.stream.DoublePipeline.StatefulOp<java.lang.Double> {
        OfDouble(java8.util.stream.AbstractPipeline<?, java.lang.Double, ?> abstractPipeline) {
            super(abstractPipeline, java8.util.stream.StreamShape.DOUBLE_VALUE, java8.util.stream.StreamOpFlag.IS_ORDERED | java8.util.stream.StreamOpFlag.IS_SORTED);
        }

        @Override // java8.util.stream.AbstractPipeline
        public java8.util.stream.Sink<java.lang.Double> opWrapSink(int i, java8.util.stream.Sink<java.lang.Double> sink) {
            java8.util.Objects.requireNonNull(sink);
            if (java8.util.stream.StreamOpFlag.SORTED.isKnown(i)) {
                return sink;
            }
            if (java8.util.stream.StreamOpFlag.SIZED.isKnown(i)) {
                return new java8.util.stream.SortedOps.SizedDoubleSortingSink(sink);
            }
            return new java8.util.stream.SortedOps.DoubleSortingSink(sink);
        }

        @Override // java8.util.stream.DoublePipeline.StatefulOp, java8.util.stream.AbstractPipeline
        public <P_IN> java8.util.stream.Node<java.lang.Double> opEvaluateParallel(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
            if (java8.util.stream.StreamOpFlag.SORTED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return pipelineHelper.evaluate(spliterator, false, intFunction);
            }
            double[] dArrAsPrimitiveArray = ((java8.util.stream.Node.OfDouble) pipelineHelper.evaluate(spliterator, true, intFunction)).asPrimitiveArray();
            java8.util.J8Arrays.parallelSort(dArrAsPrimitiveArray);
            return java8.util.stream.Nodes.node(dArrAsPrimitiveArray);
        }
    }

    private static abstract class AbstractRefSortingSink<T> extends java8.util.stream.Sink.ChainedReference<T, T> {
        protected boolean cancellationRequestedCalled;
        protected final java.util.Comparator<? super T> comparator;

        AbstractRefSortingSink(java8.util.stream.Sink<? super T> sink, java.util.Comparator<? super T> comparator) {
            super(sink);
            this.comparator = comparator;
        }

        @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
        public final boolean cancellationRequested() {
            this.cancellationRequestedCalled = true;
            return false;
        }
    }

    private static final class SizedRefSortingSink<T> extends java8.util.stream.SortedOps.AbstractRefSortingSink<T> {
        private T[] array;
        private int offset;

        SizedRefSortingSink(java8.util.stream.Sink<? super T> sink, java.util.Comparator<? super T> comparator) {
            super(sink, comparator);
        }

        @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
        public void begin(long j) {
            if (j >= 2147483639) {
                throw new java.lang.IllegalArgumentException("Stream size exceeds max array size");
            }
            this.array = (T[]) new java.lang.Object[(int) j];
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
        public void end() {
            int i = 0;
            java.util.Arrays.sort(this.array, 0, this.offset, this.comparator);
            this.downstream.begin(this.offset);
            if (!this.cancellationRequestedCalled) {
                while (i < this.offset) {
                    this.downstream.accept(this.array[i]);
                    i++;
                }
            } else {
                while (i < this.offset && !this.downstream.cancellationRequested()) {
                    this.downstream.accept(this.array[i]);
                    i++;
                }
            }
            this.downstream.end();
            this.array = null;
        }

        @Override // java8.util.function.Consumer
        public void accept(T t) {
            T[] tArr = this.array;
            int i = this.offset;
            this.offset = i + 1;
            tArr[i] = t;
        }
    }

    private static final class RefSortingSink<T> extends java8.util.stream.SortedOps.AbstractRefSortingSink<T> {
        private java.util.ArrayList<T> list;

        RefSortingSink(java8.util.stream.Sink<? super T> sink, java.util.Comparator<? super T> comparator) {
            super(sink, comparator);
        }

        @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
        public void begin(long j) {
            if (j >= 2147483639) {
                throw new java.lang.IllegalArgumentException("Stream size exceeds max array size");
            }
            this.list = j >= 0 ? new java.util.ArrayList<>((int) j) : new java.util.ArrayList<>();
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
        public void end() {
            java8.util.Lists.sort(this.list, this.comparator);
            this.downstream.begin(this.list.size());
            if (!this.cancellationRequestedCalled) {
                java.util.ArrayList<T> arrayList = this.list;
                java8.util.stream.Sink<? super E_OUT> sink = this.downstream;
                sink.getClass();
                java8.lang.Iterables.forEach(arrayList, java8.util.stream.SortedOps$RefSortingSink$$Lambda$1.lambdaFactory$(sink));
            } else {
                for (T t : this.list) {
                    if (this.downstream.cancellationRequested()) {
                        break;
                    } else {
                        this.downstream.accept(t);
                    }
                }
            }
            this.downstream.end();
            this.list = null;
        }

        @Override // java8.util.function.Consumer
        public void accept(T t) {
            this.list.add(t);
        }
    }

    private static abstract class AbstractIntSortingSink extends java8.util.stream.Sink.ChainedInt<java.lang.Integer> {
        protected boolean cancellationRequestedCalled;

        AbstractIntSortingSink(java8.util.stream.Sink<? super java.lang.Integer> sink) {
            super(sink);
        }

        @Override // java8.util.stream.Sink.ChainedInt, java8.util.stream.Sink
        public final boolean cancellationRequested() {
            this.cancellationRequestedCalled = true;
            return false;
        }
    }

    private static final class SizedIntSortingSink extends java8.util.stream.SortedOps.AbstractIntSortingSink {
        private int[] array;
        private int offset;

        SizedIntSortingSink(java8.util.stream.Sink<? super java.lang.Integer> sink) {
            super(sink);
        }

        @Override // java8.util.stream.Sink.ChainedInt, java8.util.stream.Sink
        public void begin(long j) {
            if (j >= 2147483639) {
                throw new java.lang.IllegalArgumentException("Stream size exceeds max array size");
            }
            this.array = new int[(int) j];
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
        public void end() {
            int i = 0;
            java.util.Arrays.sort(this.array, 0, this.offset);
            this.downstream.begin(this.offset);
            if (!this.cancellationRequestedCalled) {
                while (i < this.offset) {
                    this.downstream.accept(this.array[i]);
                    i++;
                }
            } else {
                while (i < this.offset && !this.downstream.cancellationRequested()) {
                    this.downstream.accept(this.array[i]);
                    i++;
                }
            }
            this.downstream.end();
            this.array = null;
        }

        @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
        public void accept(int i) {
            int[] iArr = this.array;
            int i2 = this.offset;
            this.offset = i2 + 1;
            iArr[i2] = i;
        }
    }

    private static final class IntSortingSink extends java8.util.stream.SortedOps.AbstractIntSortingSink {
        private java8.util.stream.SpinedBuffer.OfInt b;

        IntSortingSink(java8.util.stream.Sink<? super java.lang.Integer> sink) {
            super(sink);
        }

        @Override // java8.util.stream.Sink.ChainedInt, java8.util.stream.Sink
        public void begin(long j) {
            if (j >= 2147483639) {
                throw new java.lang.IllegalArgumentException("Stream size exceeds max array size");
            }
            this.b = j > 0 ? new java8.util.stream.SpinedBuffer.OfInt((int) j) : new java8.util.stream.SpinedBuffer.OfInt();
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
        public void end() {
            int[] iArrAsPrimitiveArray = this.b.asPrimitiveArray();
            java.util.Arrays.sort(iArrAsPrimitiveArray);
            this.downstream.begin(iArrAsPrimitiveArray.length);
            int i = 0;
            if (!this.cancellationRequestedCalled) {
                int length = iArrAsPrimitiveArray.length;
                while (i < length) {
                    this.downstream.accept(iArrAsPrimitiveArray[i]);
                    i++;
                }
            } else {
                int length2 = iArrAsPrimitiveArray.length;
                while (i < length2) {
                    int i2 = iArrAsPrimitiveArray[i];
                    if (this.downstream.cancellationRequested()) {
                        break;
                    }
                    this.downstream.accept(i2);
                    i++;
                }
            }
            this.downstream.end();
        }

        @Override // java8.util.stream.Sink.OfInt, java8.util.stream.Sink
        public void accept(int i) {
            this.b.accept(i);
        }
    }

    private static abstract class AbstractLongSortingSink extends java8.util.stream.Sink.ChainedLong<java.lang.Long> {
        protected boolean cancellationRequestedCalled;

        AbstractLongSortingSink(java8.util.stream.Sink<? super java.lang.Long> sink) {
            super(sink);
        }

        @Override // java8.util.stream.Sink.ChainedLong, java8.util.stream.Sink
        public final boolean cancellationRequested() {
            this.cancellationRequestedCalled = true;
            return false;
        }
    }

    private static final class SizedLongSortingSink extends java8.util.stream.SortedOps.AbstractLongSortingSink {
        private long[] array;
        private int offset;

        SizedLongSortingSink(java8.util.stream.Sink<? super java.lang.Long> sink) {
            super(sink);
        }

        @Override // java8.util.stream.Sink.ChainedLong, java8.util.stream.Sink
        public void begin(long j) {
            if (j >= 2147483639) {
                throw new java.lang.IllegalArgumentException("Stream size exceeds max array size");
            }
            this.array = new long[(int) j];
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
        public void end() {
            int i = 0;
            java.util.Arrays.sort(this.array, 0, this.offset);
            this.downstream.begin(this.offset);
            if (!this.cancellationRequestedCalled) {
                while (i < this.offset) {
                    this.downstream.accept(this.array[i]);
                    i++;
                }
            } else {
                while (i < this.offset && !this.downstream.cancellationRequested()) {
                    this.downstream.accept(this.array[i]);
                    i++;
                }
            }
            this.downstream.end();
            this.array = null;
        }

        @Override // java8.util.stream.Sink.OfLong, java8.util.stream.Sink
        public void accept(long j) {
            long[] jArr = this.array;
            int i = this.offset;
            this.offset = i + 1;
            jArr[i] = j;
        }
    }

    private static final class LongSortingSink extends java8.util.stream.SortedOps.AbstractLongSortingSink {
        private java8.util.stream.SpinedBuffer.OfLong b;

        LongSortingSink(java8.util.stream.Sink<? super java.lang.Long> sink) {
            super(sink);
        }

        @Override // java8.util.stream.Sink.ChainedLong, java8.util.stream.Sink
        public void begin(long j) {
            if (j >= 2147483639) {
                throw new java.lang.IllegalArgumentException("Stream size exceeds max array size");
            }
            this.b = j > 0 ? new java8.util.stream.SpinedBuffer.OfLong((int) j) : new java8.util.stream.SpinedBuffer.OfLong();
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
        public void end() {
            long[] jArrAsPrimitiveArray = this.b.asPrimitiveArray();
            java.util.Arrays.sort(jArrAsPrimitiveArray);
            this.downstream.begin(jArrAsPrimitiveArray.length);
            int i = 0;
            if (!this.cancellationRequestedCalled) {
                int length = jArrAsPrimitiveArray.length;
                while (i < length) {
                    this.downstream.accept(jArrAsPrimitiveArray[i]);
                    i++;
                }
            } else {
                int length2 = jArrAsPrimitiveArray.length;
                while (i < length2) {
                    long j = jArrAsPrimitiveArray[i];
                    if (this.downstream.cancellationRequested()) {
                        break;
                    }
                    this.downstream.accept(j);
                    i++;
                }
            }
            this.downstream.end();
        }

        @Override // java8.util.stream.Sink.OfLong, java8.util.stream.Sink
        public void accept(long j) {
            this.b.accept(j);
        }
    }

    private static abstract class AbstractDoubleSortingSink extends java8.util.stream.Sink.ChainedDouble<java.lang.Double> {
        protected boolean cancellationRequestedCalled;

        AbstractDoubleSortingSink(java8.util.stream.Sink<? super java.lang.Double> sink) {
            super(sink);
        }

        @Override // java8.util.stream.Sink.ChainedDouble, java8.util.stream.Sink
        public final boolean cancellationRequested() {
            this.cancellationRequestedCalled = true;
            return false;
        }
    }

    private static final class SizedDoubleSortingSink extends java8.util.stream.SortedOps.AbstractDoubleSortingSink {
        private double[] array;
        private int offset;

        SizedDoubleSortingSink(java8.util.stream.Sink<? super java.lang.Double> sink) {
            super(sink);
        }

        @Override // java8.util.stream.Sink.ChainedDouble, java8.util.stream.Sink
        public void begin(long j) {
            if (j >= 2147483639) {
                throw new java.lang.IllegalArgumentException("Stream size exceeds max array size");
            }
            this.array = new double[(int) j];
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
        public void end() {
            int i = 0;
            java.util.Arrays.sort(this.array, 0, this.offset);
            this.downstream.begin(this.offset);
            if (!this.cancellationRequestedCalled) {
                while (i < this.offset) {
                    this.downstream.accept(this.array[i]);
                    i++;
                }
            } else {
                while (i < this.offset && !this.downstream.cancellationRequested()) {
                    this.downstream.accept(this.array[i]);
                    i++;
                }
            }
            this.downstream.end();
            this.array = null;
        }

        @Override // java8.util.stream.Sink.OfDouble, java8.util.stream.Sink
        public void accept(double d) {
            double[] dArr = this.array;
            int i = this.offset;
            this.offset = i + 1;
            dArr[i] = d;
        }
    }

    private static final class DoubleSortingSink extends java8.util.stream.SortedOps.AbstractDoubleSortingSink {
        private java8.util.stream.SpinedBuffer.OfDouble b;

        DoubleSortingSink(java8.util.stream.Sink<? super java.lang.Double> sink) {
            super(sink);
        }

        @Override // java8.util.stream.Sink.ChainedDouble, java8.util.stream.Sink
        public void begin(long j) {
            if (j >= 2147483639) {
                throw new java.lang.IllegalArgumentException("Stream size exceeds max array size");
            }
            this.b = j > 0 ? new java8.util.stream.SpinedBuffer.OfDouble((int) j) : new java8.util.stream.SpinedBuffer.OfDouble();
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
        public void end() {
            double[] dArrAsPrimitiveArray = this.b.asPrimitiveArray();
            java.util.Arrays.sort(dArrAsPrimitiveArray);
            this.downstream.begin(dArrAsPrimitiveArray.length);
            int i = 0;
            if (!this.cancellationRequestedCalled) {
                int length = dArrAsPrimitiveArray.length;
                while (i < length) {
                    this.downstream.accept(dArrAsPrimitiveArray[i]);
                    i++;
                }
            } else {
                int length2 = dArrAsPrimitiveArray.length;
                while (i < length2) {
                    double d = dArrAsPrimitiveArray[i];
                    if (this.downstream.cancellationRequested()) {
                        break;
                    }
                    this.downstream.accept(d);
                    i++;
                }
            }
            this.downstream.end();
        }

        @Override // java8.util.stream.Sink.OfDouble, java8.util.stream.Sink
        public void accept(double d) {
            this.b.accept(d);
        }
    }
}
