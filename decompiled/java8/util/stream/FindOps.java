package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class FindOps {
    private static final java8.util.stream.TerminalOp<java.lang.Double, java8.util.OptionalDouble> ANY_DOUBLE;
    private static final java8.util.stream.TerminalOp<java.lang.Integer, java8.util.OptionalInt> ANY_INT;
    private static final java8.util.stream.TerminalOp<java.lang.Long, java8.util.OptionalLong> ANY_LONG;
    private static final java8.util.stream.TerminalOp ANY_REF;
    private static final java8.util.function.Predicate<java8.util.OptionalDouble> DOUBLE_IS_PRESENT;
    private static final java8.util.function.Supplier<java8.util.stream.TerminalSink<java.lang.Double, java8.util.OptionalDouble>> DOUBLE_SINK_SUPP;
    private static final java8.util.stream.TerminalOp<java.lang.Double, java8.util.OptionalDouble> FIRST_DOUBLE;
    private static final java8.util.stream.TerminalOp<java.lang.Integer, java8.util.OptionalInt> FIRST_INT;
    private static final java8.util.stream.TerminalOp<java.lang.Long, java8.util.OptionalLong> FIRST_LONG;
    private static final java8.util.stream.TerminalOp FIRST_REF;
    private static final java8.util.function.Predicate<java8.util.OptionalInt> INT_IS_PRESENT;
    private static final java8.util.function.Supplier<java8.util.stream.TerminalSink<java.lang.Integer, java8.util.OptionalInt>> INT_SINK_SUPP;
    private static final java8.util.function.Predicate<java8.util.OptionalLong> LONG_IS_PRESENT;
    private static final java8.util.function.Supplier<java8.util.stream.TerminalSink<java.lang.Long, java8.util.OptionalLong>> LONG_SINK_SUPP;
    private static final java8.util.function.Predicate<java8.util.Optional<java.lang.Object>> REF_IS_PRESENT;
    private static final java8.util.function.Supplier<java8.util.stream.TerminalSink<java.lang.Object, java8.util.Optional<java.lang.Object>>> REF_SINK_SUPP;

    private FindOps() {
    }

    static {
        java8.util.function.Predicate<java8.util.Optional<java.lang.Object>> predicate = java8.util.stream.FindOps$$Lambda$1.instance;
        REF_IS_PRESENT = predicate;
        java8.util.function.Predicate<java8.util.OptionalInt> predicate2 = java8.util.stream.FindOps$$Lambda$2.instance;
        INT_IS_PRESENT = predicate2;
        java8.util.function.Predicate<java8.util.OptionalLong> predicate3 = java8.util.stream.FindOps$$Lambda$3.instance;
        LONG_IS_PRESENT = predicate3;
        java8.util.function.Predicate<java8.util.OptionalDouble> predicate4 = java8.util.stream.FindOps$$Lambda$4.instance;
        DOUBLE_IS_PRESENT = predicate4;
        java8.util.function.Supplier<java8.util.stream.TerminalSink<java.lang.Object, java8.util.Optional<java.lang.Object>>> supplier = java8.util.stream.FindOps$$Lambda$5.instance;
        REF_SINK_SUPP = supplier;
        java8.util.function.Supplier<java8.util.stream.TerminalSink<java.lang.Integer, java8.util.OptionalInt>> supplier2 = java8.util.stream.FindOps$$Lambda$6.instance;
        INT_SINK_SUPP = supplier2;
        java8.util.function.Supplier<java8.util.stream.TerminalSink<java.lang.Long, java8.util.OptionalLong>> supplier3 = java8.util.stream.FindOps$$Lambda$7.instance;
        LONG_SINK_SUPP = supplier3;
        java8.util.function.Supplier<java8.util.stream.TerminalSink<java.lang.Double, java8.util.OptionalDouble>> supplier4 = java8.util.stream.FindOps$$Lambda$8.instance;
        DOUBLE_SINK_SUPP = supplier4;
        FIRST_REF = new java8.util.stream.FindOps.FindOp(true, java8.util.stream.StreamShape.REFERENCE, java8.util.Optional.empty(), predicate, supplier);
        ANY_REF = new java8.util.stream.FindOps.FindOp(false, java8.util.stream.StreamShape.REFERENCE, java8.util.Optional.empty(), predicate, supplier);
        FIRST_INT = new java8.util.stream.FindOps.FindOp(true, java8.util.stream.StreamShape.INT_VALUE, java8.util.OptionalInt.empty(), predicate2, supplier2);
        ANY_INT = new java8.util.stream.FindOps.FindOp(false, java8.util.stream.StreamShape.INT_VALUE, java8.util.OptionalInt.empty(), predicate2, supplier2);
        FIRST_LONG = new java8.util.stream.FindOps.FindOp(true, java8.util.stream.StreamShape.LONG_VALUE, java8.util.OptionalLong.empty(), predicate3, supplier3);
        ANY_LONG = new java8.util.stream.FindOps.FindOp(false, java8.util.stream.StreamShape.LONG_VALUE, java8.util.OptionalLong.empty(), predicate3, supplier3);
        FIRST_DOUBLE = new java8.util.stream.FindOps.FindOp(true, java8.util.stream.StreamShape.DOUBLE_VALUE, java8.util.OptionalDouble.empty(), predicate4, supplier4);
        ANY_DOUBLE = new java8.util.stream.FindOps.FindOp(false, java8.util.stream.StreamShape.DOUBLE_VALUE, java8.util.OptionalDouble.empty(), predicate4, supplier4);
    }

    public static <T> java8.util.stream.TerminalOp<T, java8.util.Optional<T>> makeRef(boolean z) {
        return z ? FIRST_REF : ANY_REF;
    }

    public static java8.util.stream.TerminalOp<java.lang.Integer, java8.util.OptionalInt> makeInt(boolean z) {
        return z ? FIRST_INT : ANY_INT;
    }

    public static java8.util.stream.TerminalOp<java.lang.Long, java8.util.OptionalLong> makeLong(boolean z) {
        return z ? FIRST_LONG : ANY_LONG;
    }

    public static java8.util.stream.TerminalOp<java.lang.Double, java8.util.OptionalDouble> makeDouble(boolean z) {
        return z ? FIRST_DOUBLE : ANY_DOUBLE;
    }

    private static final class FindOp<T, O> implements java8.util.stream.TerminalOp<T, O> {
        final O emptyValue;
        final int opFlags;
        final java8.util.function.Predicate<O> presentPredicate;
        private final java8.util.stream.StreamShape shape;
        final java8.util.function.Supplier<java8.util.stream.TerminalSink<T, O>> sinkSupplier;

        FindOp(boolean z, java8.util.stream.StreamShape streamShape, O o, java8.util.function.Predicate<O> predicate, java8.util.function.Supplier<java8.util.stream.TerminalSink<T, O>> supplier) {
            this.opFlags = (z ? 0 : java8.util.stream.StreamOpFlag.NOT_ORDERED) | java8.util.stream.StreamOpFlag.IS_SHORT_CIRCUIT;
            this.shape = streamShape;
            this.emptyValue = o;
            this.presentPredicate = predicate;
            this.sinkSupplier = supplier;
        }

        @Override // java8.util.stream.TerminalOp
        public int getOpFlags() {
            return this.opFlags;
        }

        @Override // java8.util.stream.TerminalOp
        public java8.util.stream.StreamShape inputShape() {
            return this.shape;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java8.util.stream.TerminalOp
        public <S> O evaluateSequential(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<S> spliterator) {
            O o = (O) ((java8.util.stream.TerminalSink) pipelineHelper.wrapAndCopyInto(this.sinkSupplier.get(), (java8.util.Spliterator) spliterator)).get();
            return o != null ? o : this.emptyValue;
        }

        @Override // java8.util.stream.TerminalOp
        public <P_IN> O evaluateParallel(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
            return new java8.util.stream.FindOps.FindTask(this, java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags()), pipelineHelper, spliterator).invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class FindSink<T, O> implements java8.util.stream.TerminalSink<T, O> {
        boolean hasValue;
        T value;

        @Override // java8.util.stream.Sink
        public void begin(long j) {
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        FindSink() {
        }

        @Override // java8.util.function.Consumer
        public void accept(T t) {
            if (this.hasValue) {
                return;
            }
            this.hasValue = true;
            this.value = t;
        }

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return this.hasValue;
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

        static final class OfRef<T> extends java8.util.stream.FindOps.FindSink<T, java8.util.Optional<T>> {
            OfRef() {
            }

            @Override // java8.util.function.Supplier
            public java8.util.Optional<T> get() {
                if (this.hasValue) {
                    return java8.util.Optional.of(this.value);
                }
                return null;
            }
        }

        static final class OfInt extends java8.util.stream.FindOps.FindSink<java.lang.Integer, java8.util.OptionalInt> implements java8.util.stream.Sink.OfInt {
            OfInt() {
            }

            @Override // java8.util.stream.Sink.OfInt
            public /* bridge */ /* synthetic */ void accept(java.lang.Integer num) {
                super.accept(num);
            }

            @Override // java8.util.stream.FindOps.FindSink, java8.util.stream.Sink
            public void accept(int i) {
                accept(java.lang.Integer.valueOf(i));
            }

            @Override // java8.util.function.Supplier
            public java8.util.OptionalInt get() {
                if (this.hasValue) {
                    return java8.util.OptionalInt.of(((java.lang.Integer) this.value).intValue());
                }
                return null;
            }
        }

        static final class OfLong extends java8.util.stream.FindOps.FindSink<java.lang.Long, java8.util.OptionalLong> implements java8.util.stream.Sink.OfLong {
            OfLong() {
            }

            @Override // java8.util.stream.Sink.OfLong
            public /* bridge */ /* synthetic */ void accept(java.lang.Long l) {
                super.accept(l);
            }

            @Override // java8.util.stream.FindOps.FindSink, java8.util.stream.Sink
            public void accept(long j) {
                accept(java.lang.Long.valueOf(j));
            }

            @Override // java8.util.function.Supplier
            public java8.util.OptionalLong get() {
                if (this.hasValue) {
                    return java8.util.OptionalLong.of(((java.lang.Long) this.value).longValue());
                }
                return null;
            }
        }

        static final class OfDouble extends java8.util.stream.FindOps.FindSink<java.lang.Double, java8.util.OptionalDouble> implements java8.util.stream.Sink.OfDouble {
            OfDouble() {
            }

            @Override // java8.util.stream.Sink.OfDouble
            public /* bridge */ /* synthetic */ void accept(java.lang.Double d) {
                super.accept(d);
            }

            @Override // java8.util.stream.FindOps.FindSink, java8.util.stream.Sink
            public void accept(double d) {
                accept(java.lang.Double.valueOf(d));
            }

            @Override // java8.util.function.Supplier
            public java8.util.OptionalDouble get() {
                if (this.hasValue) {
                    return java8.util.OptionalDouble.of(((java.lang.Double) this.value).doubleValue());
                }
                return null;
            }
        }
    }

    private static final class FindTask<P_IN, P_OUT, O> extends java8.util.stream.AbstractShortCircuitTask<P_IN, P_OUT, O, java8.util.stream.FindOps.FindTask<P_IN, P_OUT, O>> {
        private final boolean mustFindFirst;
        private final java8.util.stream.FindOps.FindOp<P_OUT, O> op;

        FindTask(java8.util.stream.FindOps.FindOp<P_OUT, O> findOp, boolean z, java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
            super(pipelineHelper, spliterator);
            this.mustFindFirst = z;
            this.op = findOp;
        }

        FindTask(java8.util.stream.FindOps.FindTask<P_IN, P_OUT, O> findTask, java8.util.Spliterator<P_IN> spliterator) {
            super(findTask, spliterator);
            this.mustFindFirst = findTask.mustFindFirst;
            this.op = findTask.op;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public java8.util.stream.FindOps.FindTask<P_IN, P_OUT, O> makeChild(java8.util.Spliterator<P_IN> spliterator) {
            return new java8.util.stream.FindOps.FindTask<>(this, spliterator);
        }

        @Override // java8.util.stream.AbstractShortCircuitTask
        protected O getEmptyResult() {
            return this.op.emptyValue;
        }

        private void foundResult(O o) {
            if (isLeftmostNode()) {
                shortCircuit(o);
            } else {
                cancelLaterNodes();
            }
        }

        @Override // java8.util.stream.AbstractTask
        protected O doLeaf() {
            O o = (O) ((java8.util.stream.TerminalSink) this.helper.wrapAndCopyInto(this.op.sinkSupplier.get(), (java8.util.Spliterator) this.spliterator)).get();
            if (!this.mustFindFirst) {
                if (o != null) {
                    shortCircuit(o);
                }
                return null;
            }
            if (o == null) {
                return null;
            }
            foundResult(o);
            return o;
        }

        @Override // java8.util.stream.AbstractTask, java8.util.concurrent.CountedCompleter
        public void onCompletion(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
            if (this.mustFindFirst) {
                java8.util.stream.FindOps.FindTask findTask = (java8.util.stream.FindOps.FindTask) this.leftChild;
                java8.util.stream.FindOps.FindTask findTask2 = null;
                while (true) {
                    if (findTask != findTask2) {
                        O localResult = findTask.getLocalResult();
                        if (localResult == null || !this.op.presentPredicate.test(localResult)) {
                            findTask2 = findTask;
                            findTask = (java8.util.stream.FindOps.FindTask) this.rightChild;
                        } else {
                            setLocalResult(localResult);
                            foundResult(localResult);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            super.onCompletion(countedCompleter);
        }
    }
}
