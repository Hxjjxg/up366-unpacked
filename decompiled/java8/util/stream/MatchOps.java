package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class MatchOps {
    private MatchOps() {
    }

    enum MatchKind {
        ANY(true, true),
        ALL(false, false),
        NONE(true, false);

        private final boolean shortCircuitResult;
        private final boolean stopOnPredicateMatches;

        MatchKind(boolean z, boolean z2) {
            this.stopOnPredicateMatches = z;
            this.shortCircuitResult = z2;
        }
    }

    public static <T> java8.util.stream.TerminalOp<T, java.lang.Boolean> makeRef(java8.util.function.Predicate<? super T> predicate, java8.util.stream.MatchOps.MatchKind matchKind) {
        java8.util.Objects.requireNonNull(predicate);
        java8.util.Objects.requireNonNull(matchKind);
        return new java8.util.stream.MatchOps.MatchOp(java8.util.stream.StreamShape.REFERENCE, matchKind, java8.util.stream.MatchOps$$Lambda$1.lambdaFactory$(matchKind, predicate));
    }

    static /* synthetic */ java8.util.stream.MatchOps.BooleanTerminalSink lambda$makeRef$115(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.Predicate predicate) {
        return new java8.util.stream.MatchOps.BooleanTerminalSink<T>(predicate) { // from class: java8.util.stream.MatchOps.1MatchSink
            final /* synthetic */ java8.util.function.Predicate val$predicate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this.val$matchKind);
                this.val$predicate = predicate;
            }

            @Override // java8.util.function.Consumer
            public void accept(T t) {
                if (this.stop || this.val$predicate.test(t) != this.val$matchKind.stopOnPredicateMatches) {
                    return;
                }
                this.stop = true;
                this.value = this.val$matchKind.shortCircuitResult;
            }
        };
    }

    public static java8.util.stream.TerminalOp<java.lang.Integer, java.lang.Boolean> makeInt(java8.util.function.IntPredicate intPredicate, java8.util.stream.MatchOps.MatchKind matchKind) {
        java8.util.Objects.requireNonNull(intPredicate);
        java8.util.Objects.requireNonNull(matchKind);
        return new java8.util.stream.MatchOps.MatchOp(java8.util.stream.StreamShape.INT_VALUE, matchKind, java8.util.stream.MatchOps$$Lambda$2.lambdaFactory$(matchKind, intPredicate));
    }

    /* JADX INFO: renamed from: java8.util.stream.MatchOps$2MatchSink, reason: invalid class name */
    class C2MatchSink extends java8.util.stream.MatchOps.BooleanTerminalSink<java.lang.Integer> implements java8.util.stream.Sink.OfInt {
        final /* synthetic */ java8.util.stream.MatchOps.MatchKind val$matchKind;
        final /* synthetic */ java8.util.function.IntPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C2MatchSink(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.IntPredicate intPredicate) {
            super(matchKind);
            this.val$matchKind = matchKind;
            this.val$predicate = intPredicate;
        }

        @Override // java8.util.stream.MatchOps.BooleanTerminalSink, java8.util.stream.Sink
        public void accept(int i) {
            if (this.stop || this.val$predicate.test(i) != this.val$matchKind.stopOnPredicateMatches) {
                return;
            }
            this.stop = true;
            this.value = this.val$matchKind.shortCircuitResult;
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Integer num) {
            java8.util.stream.SinkDefaults.OfInt.accept(this, num);
        }
    }

    static /* synthetic */ java8.util.stream.MatchOps.BooleanTerminalSink lambda$makeInt$116(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.IntPredicate intPredicate) {
        return new java8.util.stream.MatchOps.C2MatchSink(matchKind, intPredicate);
    }

    public static java8.util.stream.TerminalOp<java.lang.Long, java.lang.Boolean> makeLong(java8.util.function.LongPredicate longPredicate, java8.util.stream.MatchOps.MatchKind matchKind) {
        java8.util.Objects.requireNonNull(longPredicate);
        java8.util.Objects.requireNonNull(matchKind);
        return new java8.util.stream.MatchOps.MatchOp(java8.util.stream.StreamShape.LONG_VALUE, matchKind, java8.util.stream.MatchOps$$Lambda$3.lambdaFactory$(matchKind, longPredicate));
    }

    /* JADX INFO: renamed from: java8.util.stream.MatchOps$3MatchSink, reason: invalid class name */
    class C3MatchSink extends java8.util.stream.MatchOps.BooleanTerminalSink<java.lang.Long> implements java8.util.stream.Sink.OfLong {
        final /* synthetic */ java8.util.stream.MatchOps.MatchKind val$matchKind;
        final /* synthetic */ java8.util.function.LongPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3MatchSink(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.LongPredicate longPredicate) {
            super(matchKind);
            this.val$matchKind = matchKind;
            this.val$predicate = longPredicate;
        }

        @Override // java8.util.stream.MatchOps.BooleanTerminalSink, java8.util.stream.Sink
        public void accept(long j) {
            if (this.stop || this.val$predicate.test(j) != this.val$matchKind.stopOnPredicateMatches) {
                return;
            }
            this.stop = true;
            this.value = this.val$matchKind.shortCircuitResult;
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Long l) {
            java8.util.stream.SinkDefaults.OfLong.accept(this, l);
        }
    }

    static /* synthetic */ java8.util.stream.MatchOps.BooleanTerminalSink lambda$makeLong$117(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.LongPredicate longPredicate) {
        return new java8.util.stream.MatchOps.C3MatchSink(matchKind, longPredicate);
    }

    public static java8.util.stream.TerminalOp<java.lang.Double, java.lang.Boolean> makeDouble(java8.util.function.DoublePredicate doublePredicate, java8.util.stream.MatchOps.MatchKind matchKind) {
        java8.util.Objects.requireNonNull(doublePredicate);
        java8.util.Objects.requireNonNull(matchKind);
        return new java8.util.stream.MatchOps.MatchOp(java8.util.stream.StreamShape.DOUBLE_VALUE, matchKind, java8.util.stream.MatchOps$$Lambda$4.lambdaFactory$(matchKind, doublePredicate));
    }

    /* JADX INFO: renamed from: java8.util.stream.MatchOps$4MatchSink, reason: invalid class name */
    class C4MatchSink extends java8.util.stream.MatchOps.BooleanTerminalSink<java.lang.Double> implements java8.util.stream.Sink.OfDouble {
        final /* synthetic */ java8.util.stream.MatchOps.MatchKind val$matchKind;
        final /* synthetic */ java8.util.function.DoublePredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4MatchSink(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.DoublePredicate doublePredicate) {
            super(matchKind);
            this.val$matchKind = matchKind;
            this.val$predicate = doublePredicate;
        }

        @Override // java8.util.stream.MatchOps.BooleanTerminalSink, java8.util.stream.Sink
        public void accept(double d) {
            if (this.stop || this.val$predicate.test(d) != this.val$matchKind.stopOnPredicateMatches) {
                return;
            }
            this.stop = true;
            this.value = this.val$matchKind.shortCircuitResult;
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Double d) {
            java8.util.stream.SinkDefaults.OfDouble.accept(this, d);
        }
    }

    static /* synthetic */ java8.util.stream.MatchOps.BooleanTerminalSink lambda$makeDouble$118(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.DoublePredicate doublePredicate) {
        return new java8.util.stream.MatchOps.C4MatchSink(matchKind, doublePredicate);
    }

    private static final class MatchOp<T> implements java8.util.stream.TerminalOp<T, java.lang.Boolean> {
        private final java8.util.stream.StreamShape inputShape;
        final java8.util.stream.MatchOps.MatchKind matchKind;
        final java8.util.function.Supplier<java8.util.stream.MatchOps.BooleanTerminalSink<T>> sinkSupplier;

        MatchOp(java8.util.stream.StreamShape streamShape, java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.Supplier<java8.util.stream.MatchOps.BooleanTerminalSink<T>> supplier) {
            this.inputShape = streamShape;
            this.matchKind = matchKind;
            this.sinkSupplier = supplier;
        }

        @Override // java8.util.stream.TerminalOp
        public int getOpFlags() {
            return java8.util.stream.StreamOpFlag.IS_SHORT_CIRCUIT | java8.util.stream.StreamOpFlag.NOT_ORDERED;
        }

        @Override // java8.util.stream.TerminalOp
        public java8.util.stream.StreamShape inputShape() {
            return this.inputShape;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java8.util.stream.TerminalOp
        public <S> java.lang.Boolean evaluateSequential(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<S> spliterator) {
            return java.lang.Boolean.valueOf(((java8.util.stream.MatchOps.BooleanTerminalSink) pipelineHelper.wrapAndCopyInto(this.sinkSupplier.get(), (java8.util.Spliterator) spliterator)).getAndClearState());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java8.util.stream.TerminalOp
        public <S> java.lang.Boolean evaluateParallel(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<S> spliterator) {
            return new java8.util.stream.MatchOps.MatchTask(this, pipelineHelper, spliterator).invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class BooleanTerminalSink<T> implements java8.util.stream.Sink<T> {
        boolean stop;
        boolean value;

        @Override // java8.util.stream.Sink
        public void begin(long j) {
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        BooleanTerminalSink(java8.util.stream.MatchOps.MatchKind matchKind) {
            this.value = !matchKind.shortCircuitResult;
        }

        public boolean getAndClearState() {
            return this.value;
        }

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return this.stop;
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
    }

    private static final class MatchTask<P_IN, P_OUT> extends java8.util.stream.AbstractShortCircuitTask<P_IN, P_OUT, java.lang.Boolean, java8.util.stream.MatchOps.MatchTask<P_IN, P_OUT>> {
        private final java8.util.stream.MatchOps.MatchOp<P_OUT> op;

        MatchTask(java8.util.stream.MatchOps.MatchOp<P_OUT> matchOp, java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
            super(pipelineHelper, spliterator);
            this.op = matchOp;
        }

        MatchTask(java8.util.stream.MatchOps.MatchTask<P_IN, P_OUT> matchTask, java8.util.Spliterator<P_IN> spliterator) {
            super(matchTask, spliterator);
            this.op = matchTask.op;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public java8.util.stream.MatchOps.MatchTask<P_IN, P_OUT> makeChild(java8.util.Spliterator<P_IN> spliterator) {
            return new java8.util.stream.MatchOps.MatchTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public java.lang.Boolean doLeaf() {
            boolean andClearState = ((java8.util.stream.MatchOps.BooleanTerminalSink) this.helper.wrapAndCopyInto(this.op.sinkSupplier.get(), (java8.util.Spliterator) this.spliterator)).getAndClearState();
            if (andClearState != this.op.matchKind.shortCircuitResult) {
                return null;
            }
            shortCircuit(java.lang.Boolean.valueOf(andClearState));
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java8.util.stream.AbstractShortCircuitTask
        public java.lang.Boolean getEmptyResult() {
            return java.lang.Boolean.valueOf(!this.op.matchKind.shortCircuitResult);
        }
    }
}
