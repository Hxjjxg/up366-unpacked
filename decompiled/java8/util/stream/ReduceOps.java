package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class ReduceOps {

    private interface AccumulatingSink<T, R, K extends java8.util.stream.ReduceOps.AccumulatingSink<T, R, K>> extends java8.util.stream.TerminalSink<T, R> {
        void combine(K k);
    }

    private ReduceOps() {
    }

    public static <T, U> java8.util.stream.TerminalOp<T, U> makeRef(final U u, final java8.util.function.BiFunction<U, ? super T, U> biFunction, final java8.util.function.BinaryOperator<U> binaryOperator) {
        java8.util.Objects.requireNonNull(biFunction);
        java8.util.Objects.requireNonNull(binaryOperator);
        return new java8.util.stream.ReduceOps.ReduceOp<T, U, java8.util.stream.ReduceOps.C1ReducingSink>(java8.util.stream.StreamShape.REFERENCE) { // from class: java8.util.stream.ReduceOps.1
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C1ReducingSink makeSink() {
                return new java8.util.stream.ReduceOps.C1ReducingSink(u, biFunction, binaryOperator);
            }
        };
    }

    /* JADX INFO: Add missing generic type declarations: [T, U] */
    /* JADX INFO: renamed from: java8.util.stream.ReduceOps$1ReducingSink, reason: invalid class name */
    class C1ReducingSink<T, U> extends java8.util.stream.ReduceOps.Box<U> implements java8.util.stream.ReduceOps.AccumulatingSink<T, U, java8.util.stream.ReduceOps.C1ReducingSink> {
        final /* synthetic */ java8.util.function.BinaryOperator val$combiner;
        final /* synthetic */ java8.util.function.BiFunction val$reducer;
        final /* synthetic */ java.lang.Object val$seed;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        C1ReducingSink(java.lang.Object obj, java8.util.function.BiFunction biFunction, java8.util.function.BinaryOperator binaryOperator) {
            this.val$seed = obj;
            this.val$reducer = biFunction;
            this.val$combiner = binaryOperator;
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.state = (U) this.val$seed;
        }

        @Override // java8.util.function.Consumer
        public void accept(T t) {
            this.state = (U) this.val$reducer.apply(this.state, t);
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

        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.C1ReducingSink c1ReducingSink) {
            this.state = (U) this.val$combiner.apply(this.state, c1ReducingSink.state);
        }
    }

    public static <T> java8.util.stream.TerminalOp<T, java8.util.Optional<T>> makeRef(final java8.util.function.BinaryOperator<T> binaryOperator) {
        java8.util.Objects.requireNonNull(binaryOperator);
        return new java8.util.stream.ReduceOps.ReduceOp<T, java8.util.Optional<T>, java8.util.stream.ReduceOps.C2ReducingSink>(java8.util.stream.StreamShape.REFERENCE) { // from class: java8.util.stream.ReduceOps.2
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C2ReducingSink makeSink() {
                final java8.util.function.BinaryOperator binaryOperator2 = binaryOperator;
                return new java8.util.stream.ReduceOps.AccumulatingSink<T, java8.util.Optional<T>, java8.util.stream.ReduceOps.C2ReducingSink>() { // from class: java8.util.stream.ReduceOps.2ReducingSink
                    private boolean empty;
                    private T state;

                    @Override // java8.util.stream.Sink
                    public boolean cancellationRequested() {
                        return false;
                    }

                    @Override // java8.util.stream.Sink
                    public void end() {
                    }

                    @Override // java8.util.stream.Sink
                    public void begin(long j) {
                        this.empty = true;
                        this.state = null;
                    }

                    @Override // java8.util.function.Consumer
                    public void accept(T t) {
                        if (this.empty) {
                            this.empty = false;
                            this.state = t;
                        } else {
                            this.state = binaryOperator2.apply(this.state, t);
                        }
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

                    @Override // java8.util.function.Supplier
                    public java8.util.Optional<T> get() {
                        return this.empty ? java8.util.Optional.empty() : java8.util.Optional.of(this.state);
                    }

                    @Override // java8.util.stream.ReduceOps.AccumulatingSink
                    public void combine(java8.util.stream.ReduceOps.C2ReducingSink c2ReducingSink) {
                        if (c2ReducingSink.empty) {
                            return;
                        }
                        accept(c2ReducingSink.state);
                    }
                };
            }
        };
    }

    public static <T, I> java8.util.stream.TerminalOp<T, I> makeRef(final java8.util.stream.Collector<? super T, I, ?> collector) {
        final java8.util.function.Supplier supplier = ((java8.util.stream.Collector) java8.util.Objects.requireNonNull(collector)).supplier();
        final java8.util.function.BiConsumer<I, ? super T> biConsumerAccumulator = collector.accumulator();
        final java8.util.function.BinaryOperator<I> binaryOperatorCombiner = collector.combiner();
        return new java8.util.stream.ReduceOps.ReduceOp<T, I, java8.util.stream.ReduceOps.C3ReducingSink>(java8.util.stream.StreamShape.REFERENCE) { // from class: java8.util.stream.ReduceOps.3
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C3ReducingSink makeSink() {
                return new java8.util.stream.ReduceOps.C3ReducingSink(supplier, biConsumerAccumulator, binaryOperatorCombiner);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public int getOpFlags() {
                if (collector.characteristics().contains(java8.util.stream.Collector.Characteristics.UNORDERED)) {
                    return java8.util.stream.StreamOpFlag.NOT_ORDERED;
                }
                return 0;
            }
        };
    }

    /* JADX INFO: Add missing generic type declarations: [T, I] */
    /* JADX INFO: renamed from: java8.util.stream.ReduceOps$3ReducingSink, reason: invalid class name */
    class C3ReducingSink<I, T> extends java8.util.stream.ReduceOps.Box<I> implements java8.util.stream.ReduceOps.AccumulatingSink<T, I, java8.util.stream.ReduceOps.C3ReducingSink> {
        final /* synthetic */ java8.util.function.BiConsumer val$accumulator;
        final /* synthetic */ java8.util.function.BinaryOperator val$combiner;
        final /* synthetic */ java8.util.function.Supplier val$supplier;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        C3ReducingSink(java8.util.function.Supplier supplier, java8.util.function.BiConsumer biConsumer, java8.util.function.BinaryOperator binaryOperator) {
            this.val$supplier = supplier;
            this.val$accumulator = biConsumer;
            this.val$combiner = binaryOperator;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [U, java.lang.Object] */
        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.state = this.val$supplier.get();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java8.util.function.Consumer
        public void accept(T t) {
            this.val$accumulator.accept(this.state, t);
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

        /* JADX WARN: Type inference failed for: r3v2, types: [U, java.lang.Object] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.C3ReducingSink c3ReducingSink) {
            this.state = this.val$combiner.apply(this.state, c3ReducingSink.state);
        }
    }

    public static <T, R> java8.util.stream.TerminalOp<T, R> makeRef(final java8.util.function.Supplier<R> supplier, final java8.util.function.BiConsumer<R, ? super T> biConsumer, final java8.util.function.BiConsumer<R, R> biConsumer2) {
        java8.util.Objects.requireNonNull(supplier);
        java8.util.Objects.requireNonNull(biConsumer);
        java8.util.Objects.requireNonNull(biConsumer2);
        return new java8.util.stream.ReduceOps.ReduceOp<T, R, java8.util.stream.ReduceOps.C4ReducingSink>(java8.util.stream.StreamShape.REFERENCE) { // from class: java8.util.stream.ReduceOps.4
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C4ReducingSink makeSink() {
                return new java8.util.stream.ReduceOps.C4ReducingSink(supplier, biConsumer, biConsumer2);
            }
        };
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX INFO: renamed from: java8.util.stream.ReduceOps$4ReducingSink, reason: invalid class name */
    class C4ReducingSink<R, T> extends java8.util.stream.ReduceOps.Box<R> implements java8.util.stream.ReduceOps.AccumulatingSink<T, R, java8.util.stream.ReduceOps.C4ReducingSink> {
        final /* synthetic */ java8.util.function.BiConsumer val$accumulator;
        final /* synthetic */ java8.util.function.BiConsumer val$reducer;
        final /* synthetic */ java8.util.function.Supplier val$seedFactory;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        C4ReducingSink(java8.util.function.Supplier supplier, java8.util.function.BiConsumer biConsumer, java8.util.function.BiConsumer biConsumer2) {
            this.val$seedFactory = supplier;
            this.val$accumulator = biConsumer;
            this.val$reducer = biConsumer2;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [U, java.lang.Object] */
        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.state = this.val$seedFactory.get();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java8.util.function.Consumer
        public void accept(T t) {
            this.val$accumulator.accept(this.state, t);
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

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.C4ReducingSink c4ReducingSink) {
            this.val$reducer.accept(this.state, c4ReducingSink.state);
        }
    }

    public static <T> java8.util.stream.TerminalOp<T, java.lang.Long> makeRefCounting() {
        return new java8.util.stream.ReduceOps.ReduceOp<T, java.lang.Long, java8.util.stream.ReduceOps.CountingSink<T>>(java8.util.stream.StreamShape.REFERENCE) { // from class: java8.util.stream.ReduceOps.5
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.CountingSink<T> makeSink() {
                return new java8.util.stream.ReduceOps.CountingSink.OfRef();
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public <P_IN> java.lang.Long evaluateSequential(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                if (java8.util.stream.StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return java.lang.Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (java.lang.Long) super.evaluateSequential((java8.util.stream.PipelineHelper) pipelineHelper, (java8.util.Spliterator) spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public <P_IN> java.lang.Long evaluateParallel(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                if (java8.util.stream.StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return java.lang.Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (java.lang.Long) super.evaluateParallel((java8.util.stream.PipelineHelper) pipelineHelper, (java8.util.Spliterator) spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public int getOpFlags() {
                return java8.util.stream.StreamOpFlag.NOT_ORDERED;
            }
        };
    }

    /* JADX INFO: renamed from: java8.util.stream.ReduceOps$5ReducingSink, reason: invalid class name */
    class C5ReducingSink implements java8.util.stream.ReduceOps.AccumulatingSink<java.lang.Integer, java.lang.Integer, java8.util.stream.ReduceOps.C5ReducingSink>, java8.util.stream.Sink.OfInt {
        private int state;
        final /* synthetic */ int val$identity;
        final /* synthetic */ java8.util.function.IntBinaryOperator val$operator;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        C5ReducingSink(int i, java8.util.function.IntBinaryOperator intBinaryOperator) {
            this.val$identity = i;
            this.val$operator = intBinaryOperator;
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.state = this.val$identity;
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            this.state = this.val$operator.applyAsInt(this.state, i);
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Integer num) {
            java8.util.stream.SinkDefaults.OfInt.accept(this, num);
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.function.Supplier
        public java.lang.Integer get() {
            return java.lang.Integer.valueOf(this.state);
        }

        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.C5ReducingSink c5ReducingSink) {
            accept(c5ReducingSink.state);
        }
    }

    public static java8.util.stream.TerminalOp<java.lang.Integer, java.lang.Integer> makeInt(final int i, final java8.util.function.IntBinaryOperator intBinaryOperator) {
        java8.util.Objects.requireNonNull(intBinaryOperator);
        return new java8.util.stream.ReduceOps.ReduceOp<java.lang.Integer, java.lang.Integer, java8.util.stream.ReduceOps.C5ReducingSink>(java8.util.stream.StreamShape.INT_VALUE) { // from class: java8.util.stream.ReduceOps.6
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C5ReducingSink makeSink() {
                return new java8.util.stream.ReduceOps.C5ReducingSink(i, intBinaryOperator);
            }
        };
    }

    /* JADX INFO: renamed from: java8.util.stream.ReduceOps$6ReducingSink, reason: invalid class name */
    class C6ReducingSink implements java8.util.stream.ReduceOps.AccumulatingSink<java.lang.Integer, java8.util.OptionalInt, java8.util.stream.ReduceOps.C6ReducingSink>, java8.util.stream.Sink.OfInt {
        private boolean empty;
        private int state;
        final /* synthetic */ java8.util.function.IntBinaryOperator val$operator;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        C6ReducingSink(java8.util.function.IntBinaryOperator intBinaryOperator) {
            this.val$operator = intBinaryOperator;
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.empty = true;
            this.state = 0;
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            if (this.empty) {
                this.empty = false;
                this.state = i;
            } else {
                this.state = this.val$operator.applyAsInt(this.state, i);
            }
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Integer num) {
            java8.util.stream.SinkDefaults.OfInt.accept(this, num);
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.function.Supplier
        public java8.util.OptionalInt get() {
            return this.empty ? java8.util.OptionalInt.empty() : java8.util.OptionalInt.of(this.state);
        }

        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.C6ReducingSink c6ReducingSink) {
            if (c6ReducingSink.empty) {
                return;
            }
            accept(c6ReducingSink.state);
        }
    }

    public static java8.util.stream.TerminalOp<java.lang.Integer, java8.util.OptionalInt> makeInt(final java8.util.function.IntBinaryOperator intBinaryOperator) {
        java8.util.Objects.requireNonNull(intBinaryOperator);
        return new java8.util.stream.ReduceOps.ReduceOp<java.lang.Integer, java8.util.OptionalInt, java8.util.stream.ReduceOps.C6ReducingSink>(java8.util.stream.StreamShape.INT_VALUE) { // from class: java8.util.stream.ReduceOps.7
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C6ReducingSink makeSink() {
                return new java8.util.stream.ReduceOps.C6ReducingSink(intBinaryOperator);
            }
        };
    }

    public static <R> java8.util.stream.TerminalOp<java.lang.Integer, R> makeInt(final java8.util.function.Supplier<R> supplier, final java8.util.function.ObjIntConsumer<R> objIntConsumer, final java8.util.function.BinaryOperator<R> binaryOperator) {
        java8.util.Objects.requireNonNull(supplier);
        java8.util.Objects.requireNonNull(objIntConsumer);
        java8.util.Objects.requireNonNull(binaryOperator);
        return new java8.util.stream.ReduceOps.ReduceOp<java.lang.Integer, R, java8.util.stream.ReduceOps.C7ReducingSink>(java8.util.stream.StreamShape.INT_VALUE) { // from class: java8.util.stream.ReduceOps.8
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C7ReducingSink makeSink() {
                return new java8.util.stream.ReduceOps.C7ReducingSink(supplier, objIntConsumer, binaryOperator);
            }
        };
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: java8.util.stream.ReduceOps$7ReducingSink, reason: invalid class name */
    class C7ReducingSink<R> extends java8.util.stream.ReduceOps.Box<R> implements java8.util.stream.ReduceOps.AccumulatingSink<java.lang.Integer, R, java8.util.stream.ReduceOps.C7ReducingSink>, java8.util.stream.Sink.OfInt {
        final /* synthetic */ java8.util.function.ObjIntConsumer val$accumulator;
        final /* synthetic */ java8.util.function.BinaryOperator val$combiner;
        final /* synthetic */ java8.util.function.Supplier val$supplier;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        C7ReducingSink(java8.util.function.Supplier supplier, java8.util.function.ObjIntConsumer objIntConsumer, java8.util.function.BinaryOperator binaryOperator) {
            this.val$supplier = supplier;
            this.val$accumulator = objIntConsumer;
            this.val$combiner = binaryOperator;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [U, java.lang.Object] */
        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.state = this.val$supplier.get();
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            this.val$accumulator.accept(this.state, i);
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Integer num) {
            java8.util.stream.SinkDefaults.OfInt.accept(this, num);
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [U, java.lang.Object] */
        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.C7ReducingSink c7ReducingSink) {
            this.state = this.val$combiner.apply(this.state, c7ReducingSink.state);
        }
    }

    public static java8.util.stream.TerminalOp<java.lang.Integer, java.lang.Long> makeIntCounting() {
        return new java8.util.stream.ReduceOps.ReduceOp<java.lang.Integer, java.lang.Long, java8.util.stream.ReduceOps.CountingSink<java.lang.Integer>>(java8.util.stream.StreamShape.INT_VALUE) { // from class: java8.util.stream.ReduceOps.9
            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Object evaluateParallel(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return evaluateParallel((java8.util.stream.PipelineHelper<java.lang.Integer>) pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Object evaluateSequential(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return evaluateSequential((java8.util.stream.PipelineHelper<java.lang.Integer>) pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.CountingSink<java.lang.Integer> makeSink() {
                return new java8.util.stream.ReduceOps.CountingSink.OfInt();
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public <P_IN> java.lang.Long evaluateSequential(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                if (java8.util.stream.StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return java.lang.Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (java.lang.Long) super.evaluateSequential((java8.util.stream.PipelineHelper) pipelineHelper, (java8.util.Spliterator) spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public <P_IN> java.lang.Long evaluateParallel(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                if (java8.util.stream.StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return java.lang.Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (java.lang.Long) super.evaluateParallel((java8.util.stream.PipelineHelper) pipelineHelper, (java8.util.Spliterator) spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public int getOpFlags() {
                return java8.util.stream.StreamOpFlag.NOT_ORDERED;
            }
        };
    }

    /* JADX INFO: renamed from: java8.util.stream.ReduceOps$8ReducingSink, reason: invalid class name */
    class C8ReducingSink implements java8.util.stream.ReduceOps.AccumulatingSink<java.lang.Long, java.lang.Long, java8.util.stream.ReduceOps.C8ReducingSink>, java8.util.stream.Sink.OfLong {
        private long state;
        final /* synthetic */ long val$identity;
        final /* synthetic */ java8.util.function.LongBinaryOperator val$operator;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        C8ReducingSink(long j, java8.util.function.LongBinaryOperator longBinaryOperator) {
            this.val$identity = j;
            this.val$operator = longBinaryOperator;
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.state = this.val$identity;
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            this.state = this.val$operator.applyAsLong(this.state, j);
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Long l) {
            java8.util.stream.SinkDefaults.OfLong.accept(this, l);
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.function.Supplier
        public java.lang.Long get() {
            return java.lang.Long.valueOf(this.state);
        }

        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.C8ReducingSink c8ReducingSink) {
            accept(c8ReducingSink.state);
        }
    }

    public static java8.util.stream.TerminalOp<java.lang.Long, java.lang.Long> makeLong(final long j, final java8.util.function.LongBinaryOperator longBinaryOperator) {
        java8.util.Objects.requireNonNull(longBinaryOperator);
        return new java8.util.stream.ReduceOps.ReduceOp<java.lang.Long, java.lang.Long, java8.util.stream.ReduceOps.C8ReducingSink>(java8.util.stream.StreamShape.LONG_VALUE) { // from class: java8.util.stream.ReduceOps.10
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C8ReducingSink makeSink() {
                return new java8.util.stream.ReduceOps.C8ReducingSink(j, longBinaryOperator);
            }
        };
    }

    /* JADX INFO: renamed from: java8.util.stream.ReduceOps$9ReducingSink, reason: invalid class name */
    class C9ReducingSink implements java8.util.stream.ReduceOps.AccumulatingSink<java.lang.Long, java8.util.OptionalLong, java8.util.stream.ReduceOps.C9ReducingSink>, java8.util.stream.Sink.OfLong {
        private boolean empty;
        private long state;
        final /* synthetic */ java8.util.function.LongBinaryOperator val$operator;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        C9ReducingSink(java8.util.function.LongBinaryOperator longBinaryOperator) {
            this.val$operator = longBinaryOperator;
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.empty = true;
            this.state = 0L;
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            if (this.empty) {
                this.empty = false;
                this.state = j;
            } else {
                this.state = this.val$operator.applyAsLong(this.state, j);
            }
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Long l) {
            java8.util.stream.SinkDefaults.OfLong.accept(this, l);
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.function.Supplier
        public java8.util.OptionalLong get() {
            return this.empty ? java8.util.OptionalLong.empty() : java8.util.OptionalLong.of(this.state);
        }

        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.C9ReducingSink c9ReducingSink) {
            if (c9ReducingSink.empty) {
                return;
            }
            accept(c9ReducingSink.state);
        }
    }

    public static java8.util.stream.TerminalOp<java.lang.Long, java8.util.OptionalLong> makeLong(final java8.util.function.LongBinaryOperator longBinaryOperator) {
        java8.util.Objects.requireNonNull(longBinaryOperator);
        return new java8.util.stream.ReduceOps.ReduceOp<java.lang.Long, java8.util.OptionalLong, java8.util.stream.ReduceOps.C9ReducingSink>(java8.util.stream.StreamShape.LONG_VALUE) { // from class: java8.util.stream.ReduceOps.11
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C9ReducingSink makeSink() {
                return new java8.util.stream.ReduceOps.C9ReducingSink(longBinaryOperator);
            }
        };
    }

    public static <R> java8.util.stream.TerminalOp<java.lang.Long, R> makeLong(final java8.util.function.Supplier<R> supplier, final java8.util.function.ObjLongConsumer<R> objLongConsumer, final java8.util.function.BinaryOperator<R> binaryOperator) {
        java8.util.Objects.requireNonNull(supplier);
        java8.util.Objects.requireNonNull(objLongConsumer);
        java8.util.Objects.requireNonNull(binaryOperator);
        return new java8.util.stream.ReduceOps.ReduceOp<java.lang.Long, R, java8.util.stream.ReduceOps.C10ReducingSink>(java8.util.stream.StreamShape.LONG_VALUE) { // from class: java8.util.stream.ReduceOps.12
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C10ReducingSink makeSink() {
                return new java8.util.stream.ReduceOps.C10ReducingSink(supplier, objLongConsumer, binaryOperator);
            }
        };
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: java8.util.stream.ReduceOps$10ReducingSink, reason: invalid class name */
    class C10ReducingSink<R> extends java8.util.stream.ReduceOps.Box<R> implements java8.util.stream.ReduceOps.AccumulatingSink<java.lang.Long, R, java8.util.stream.ReduceOps.C10ReducingSink>, java8.util.stream.Sink.OfLong {
        final /* synthetic */ java8.util.function.ObjLongConsumer val$accumulator;
        final /* synthetic */ java8.util.function.BinaryOperator val$combiner;
        final /* synthetic */ java8.util.function.Supplier val$supplier;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        C10ReducingSink(java8.util.function.Supplier supplier, java8.util.function.ObjLongConsumer objLongConsumer, java8.util.function.BinaryOperator binaryOperator) {
            this.val$supplier = supplier;
            this.val$accumulator = objLongConsumer;
            this.val$combiner = binaryOperator;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [U, java.lang.Object] */
        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.state = this.val$supplier.get();
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            this.val$accumulator.accept(this.state, j);
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Long l) {
            java8.util.stream.SinkDefaults.OfLong.accept(this, l);
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [U, java.lang.Object] */
        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.C10ReducingSink c10ReducingSink) {
            this.state = this.val$combiner.apply(this.state, c10ReducingSink.state);
        }
    }

    public static java8.util.stream.TerminalOp<java.lang.Long, java.lang.Long> makeLongCounting() {
        return new java8.util.stream.ReduceOps.ReduceOp<java.lang.Long, java.lang.Long, java8.util.stream.ReduceOps.CountingSink<java.lang.Long>>(java8.util.stream.StreamShape.LONG_VALUE) { // from class: java8.util.stream.ReduceOps.13
            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Object evaluateParallel(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return evaluateParallel((java8.util.stream.PipelineHelper<java.lang.Long>) pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Object evaluateSequential(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return evaluateSequential((java8.util.stream.PipelineHelper<java.lang.Long>) pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.CountingSink<java.lang.Long> makeSink() {
                return new java8.util.stream.ReduceOps.CountingSink.OfLong();
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public <P_IN> java.lang.Long evaluateSequential(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                if (java8.util.stream.StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return java.lang.Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (java.lang.Long) super.evaluateSequential((java8.util.stream.PipelineHelper) pipelineHelper, (java8.util.Spliterator) spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public <P_IN> java.lang.Long evaluateParallel(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                if (java8.util.stream.StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return java.lang.Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (java.lang.Long) super.evaluateParallel((java8.util.stream.PipelineHelper) pipelineHelper, (java8.util.Spliterator) spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public int getOpFlags() {
                return java8.util.stream.StreamOpFlag.NOT_ORDERED;
            }
        };
    }

    /* JADX INFO: renamed from: java8.util.stream.ReduceOps$11ReducingSink, reason: invalid class name */
    class C11ReducingSink implements java8.util.stream.ReduceOps.AccumulatingSink<java.lang.Double, java.lang.Double, java8.util.stream.ReduceOps.C11ReducingSink>, java8.util.stream.Sink.OfDouble {
        private double state;
        final /* synthetic */ double val$identity;
        final /* synthetic */ java8.util.function.DoubleBinaryOperator val$operator;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        C11ReducingSink(double d, java8.util.function.DoubleBinaryOperator doubleBinaryOperator) {
            this.val$identity = d;
            this.val$operator = doubleBinaryOperator;
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.state = this.val$identity;
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            this.state = this.val$operator.applyAsDouble(this.state, d);
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Double d) {
            java8.util.stream.SinkDefaults.OfDouble.accept(this, d);
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.function.Supplier
        public java.lang.Double get() {
            return java.lang.Double.valueOf(this.state);
        }

        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.C11ReducingSink c11ReducingSink) {
            accept(c11ReducingSink.state);
        }
    }

    public static java8.util.stream.TerminalOp<java.lang.Double, java.lang.Double> makeDouble(final double d, final java8.util.function.DoubleBinaryOperator doubleBinaryOperator) {
        java8.util.Objects.requireNonNull(doubleBinaryOperator);
        return new java8.util.stream.ReduceOps.ReduceOp<java.lang.Double, java.lang.Double, java8.util.stream.ReduceOps.C11ReducingSink>(java8.util.stream.StreamShape.DOUBLE_VALUE) { // from class: java8.util.stream.ReduceOps.14
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C11ReducingSink makeSink() {
                return new java8.util.stream.ReduceOps.C11ReducingSink(d, doubleBinaryOperator);
            }
        };
    }

    /* JADX INFO: renamed from: java8.util.stream.ReduceOps$12ReducingSink, reason: invalid class name */
    class C12ReducingSink implements java8.util.stream.ReduceOps.AccumulatingSink<java.lang.Double, java8.util.OptionalDouble, java8.util.stream.ReduceOps.C12ReducingSink>, java8.util.stream.Sink.OfDouble {
        private boolean empty;
        private double state;
        final /* synthetic */ java8.util.function.DoubleBinaryOperator val$operator;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        C12ReducingSink(java8.util.function.DoubleBinaryOperator doubleBinaryOperator) {
            this.val$operator = doubleBinaryOperator;
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.empty = true;
            this.state = 0.0d;
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            if (this.empty) {
                this.empty = false;
                this.state = d;
            } else {
                this.state = this.val$operator.applyAsDouble(this.state, d);
            }
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Double d) {
            java8.util.stream.SinkDefaults.OfDouble.accept(this, d);
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.function.Supplier
        public java8.util.OptionalDouble get() {
            return this.empty ? java8.util.OptionalDouble.empty() : java8.util.OptionalDouble.of(this.state);
        }

        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.C12ReducingSink c12ReducingSink) {
            if (c12ReducingSink.empty) {
                return;
            }
            accept(c12ReducingSink.state);
        }
    }

    public static java8.util.stream.TerminalOp<java.lang.Double, java8.util.OptionalDouble> makeDouble(final java8.util.function.DoubleBinaryOperator doubleBinaryOperator) {
        java8.util.Objects.requireNonNull(doubleBinaryOperator);
        return new java8.util.stream.ReduceOps.ReduceOp<java.lang.Double, java8.util.OptionalDouble, java8.util.stream.ReduceOps.C12ReducingSink>(java8.util.stream.StreamShape.DOUBLE_VALUE) { // from class: java8.util.stream.ReduceOps.15
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C12ReducingSink makeSink() {
                return new java8.util.stream.ReduceOps.C12ReducingSink(doubleBinaryOperator);
            }
        };
    }

    public static <R> java8.util.stream.TerminalOp<java.lang.Double, R> makeDouble(final java8.util.function.Supplier<R> supplier, final java8.util.function.ObjDoubleConsumer<R> objDoubleConsumer, final java8.util.function.BinaryOperator<R> binaryOperator) {
        java8.util.Objects.requireNonNull(supplier);
        java8.util.Objects.requireNonNull(objDoubleConsumer);
        java8.util.Objects.requireNonNull(binaryOperator);
        return new java8.util.stream.ReduceOps.ReduceOp<java.lang.Double, R, java8.util.stream.ReduceOps.C13ReducingSink>(java8.util.stream.StreamShape.DOUBLE_VALUE) { // from class: java8.util.stream.ReduceOps.16
            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.C13ReducingSink makeSink() {
                return new java8.util.stream.ReduceOps.C13ReducingSink(supplier, objDoubleConsumer, binaryOperator);
            }
        };
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: java8.util.stream.ReduceOps$13ReducingSink, reason: invalid class name */
    class C13ReducingSink<R> extends java8.util.stream.ReduceOps.Box<R> implements java8.util.stream.ReduceOps.AccumulatingSink<java.lang.Double, R, java8.util.stream.ReduceOps.C13ReducingSink>, java8.util.stream.Sink.OfDouble {
        final /* synthetic */ java8.util.function.ObjDoubleConsumer val$accumulator;
        final /* synthetic */ java8.util.function.BinaryOperator val$combiner;
        final /* synthetic */ java8.util.function.Supplier val$supplier;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        C13ReducingSink(java8.util.function.Supplier supplier, java8.util.function.ObjDoubleConsumer objDoubleConsumer, java8.util.function.BinaryOperator binaryOperator) {
            this.val$supplier = supplier;
            this.val$accumulator = objDoubleConsumer;
            this.val$combiner = binaryOperator;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [U, java.lang.Object] */
        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.state = this.val$supplier.get();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            this.val$accumulator.accept(this.state, d);
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Double d) {
            java8.util.stream.SinkDefaults.OfDouble.accept(this, d);
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [U, java.lang.Object] */
        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.C13ReducingSink c13ReducingSink) {
            this.state = this.val$combiner.apply(this.state, c13ReducingSink.state);
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }
    }

    public static java8.util.stream.TerminalOp<java.lang.Double, java.lang.Long> makeDoubleCounting() {
        return new java8.util.stream.ReduceOps.ReduceOp<java.lang.Double, java.lang.Long, java8.util.stream.ReduceOps.CountingSink<java.lang.Double>>(java8.util.stream.StreamShape.DOUBLE_VALUE) { // from class: java8.util.stream.ReduceOps.17
            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Object evaluateParallel(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return evaluateParallel((java8.util.stream.PipelineHelper<java.lang.Double>) pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public /* bridge */ /* synthetic */ java.lang.Object evaluateSequential(java8.util.stream.PipelineHelper pipelineHelper, java8.util.Spliterator spliterator) {
                return evaluateSequential((java8.util.stream.PipelineHelper<java.lang.Double>) pipelineHelper, spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp
            public java8.util.stream.ReduceOps.CountingSink<java.lang.Double> makeSink() {
                return new java8.util.stream.ReduceOps.CountingSink.OfDouble();
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public <P_IN> java.lang.Long evaluateSequential(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                if (java8.util.stream.StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return java.lang.Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (java.lang.Long) super.evaluateSequential((java8.util.stream.PipelineHelper) pipelineHelper, (java8.util.Spliterator) spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public <P_IN> java.lang.Long evaluateParallel(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                if (java8.util.stream.StreamOpFlag.SIZED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return java.lang.Long.valueOf(spliterator.getExactSizeIfKnown());
                }
                return (java.lang.Long) super.evaluateParallel((java8.util.stream.PipelineHelper) pipelineHelper, (java8.util.Spliterator) spliterator);
            }

            @Override // java8.util.stream.ReduceOps.ReduceOp, java8.util.stream.TerminalOp
            public int getOpFlags() {
                return java8.util.stream.StreamOpFlag.NOT_ORDERED;
            }
        };
    }

    static abstract class CountingSink<T> extends java8.util.stream.ReduceOps.Box<java.lang.Long> implements java8.util.stream.ReduceOps.AccumulatingSink<T, java.lang.Long, java8.util.stream.ReduceOps.CountingSink<T>> {
        long count;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        CountingSink() {
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.count = 0L;
        }

        @Override // java8.util.stream.ReduceOps.Box, java8.util.function.Supplier
        public java.lang.Long get() {
            return java.lang.Long.valueOf(this.count);
        }

        @Override // java8.util.stream.ReduceOps.AccumulatingSink
        public void combine(java8.util.stream.ReduceOps.CountingSink<T> countingSink) {
            this.count += countingSink.count;
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

        static final class OfRef<T> extends java8.util.stream.ReduceOps.CountingSink<T> {
            OfRef() {
            }

            @Override // java8.util.stream.ReduceOps.CountingSink, java8.util.stream.ReduceOps.AccumulatingSink
            public /* bridge */ /* synthetic */ void combine(java8.util.stream.ReduceOps.AccumulatingSink accumulatingSink) {
                super.combine((java8.util.stream.ReduceOps.CountingSink) accumulatingSink);
            }

            @Override // java8.util.stream.ReduceOps.CountingSink, java8.util.stream.ReduceOps.Box, java8.util.function.Supplier
            public /* bridge */ /* synthetic */ java.lang.Object get() {
                return super.get();
            }

            @Override // java8.util.function.Consumer
            public void accept(T t) {
                this.count++;
            }
        }

        static final class OfInt extends java8.util.stream.ReduceOps.CountingSink<java.lang.Integer> implements java8.util.stream.Sink.OfInt {
            OfInt() {
            }

            @Override // java8.util.stream.ReduceOps.CountingSink, java8.util.stream.ReduceOps.AccumulatingSink
            public /* bridge */ /* synthetic */ void combine(java8.util.stream.ReduceOps.AccumulatingSink accumulatingSink) {
                super.combine((java8.util.stream.ReduceOps.CountingSink) accumulatingSink);
            }

            @Override // java8.util.stream.ReduceOps.CountingSink, java8.util.stream.ReduceOps.Box, java8.util.function.Supplier
            public /* bridge */ /* synthetic */ java.lang.Object get() {
                return super.get();
            }

            @Override // java8.util.stream.ReduceOps.CountingSink, java8.util.stream.Sink
            public void accept(int i) {
                this.count++;
            }

            @Override // java8.util.function.Consumer
            public void accept(java.lang.Integer num) {
                java8.util.stream.SinkDefaults.OfInt.accept(this, num);
            }
        }

        static final class OfLong extends java8.util.stream.ReduceOps.CountingSink<java.lang.Long> implements java8.util.stream.Sink.OfLong {
            OfLong() {
            }

            @Override // java8.util.stream.ReduceOps.CountingSink, java8.util.stream.ReduceOps.AccumulatingSink
            public /* bridge */ /* synthetic */ void combine(java8.util.stream.ReduceOps.AccumulatingSink accumulatingSink) {
                super.combine((java8.util.stream.ReduceOps.CountingSink) accumulatingSink);
            }

            @Override // java8.util.stream.ReduceOps.CountingSink, java8.util.stream.ReduceOps.Box, java8.util.function.Supplier
            public /* bridge */ /* synthetic */ java.lang.Object get() {
                return super.get();
            }

            @Override // java8.util.stream.ReduceOps.CountingSink, java8.util.stream.Sink
            public void accept(long j) {
                this.count++;
            }

            @Override // java8.util.function.Consumer
            public void accept(java.lang.Long l) {
                java8.util.stream.SinkDefaults.OfLong.accept(this, l);
            }
        }

        static final class OfDouble extends java8.util.stream.ReduceOps.CountingSink<java.lang.Double> implements java8.util.stream.Sink.OfDouble {
            OfDouble() {
            }

            @Override // java8.util.stream.ReduceOps.CountingSink, java8.util.stream.ReduceOps.AccumulatingSink
            public /* bridge */ /* synthetic */ void combine(java8.util.stream.ReduceOps.AccumulatingSink accumulatingSink) {
                super.combine((java8.util.stream.ReduceOps.CountingSink) accumulatingSink);
            }

            @Override // java8.util.stream.ReduceOps.CountingSink, java8.util.stream.ReduceOps.Box, java8.util.function.Supplier
            public /* bridge */ /* synthetic */ java.lang.Object get() {
                return super.get();
            }

            @Override // java8.util.stream.ReduceOps.CountingSink, java8.util.stream.Sink
            public void accept(double d) {
                this.count++;
            }

            @Override // java8.util.function.Consumer
            public void accept(java.lang.Double d) {
                java8.util.stream.SinkDefaults.OfDouble.accept(this, d);
            }
        }
    }

    private static abstract class Box<U> {
        U state;

        Box() {
        }

        public U get() {
            return this.state;
        }
    }

    private static abstract class ReduceOp<T, R, S extends java8.util.stream.ReduceOps.AccumulatingSink<T, R, S>> implements java8.util.stream.TerminalOp<T, R> {
        private final java8.util.stream.StreamShape inputShape;

        @Override // java8.util.stream.TerminalOp
        public int getOpFlags() {
            return 0;
        }

        public abstract S makeSink();

        ReduceOp(java8.util.stream.StreamShape streamShape) {
            this.inputShape = streamShape;
        }

        @Override // java8.util.stream.TerminalOp
        public java8.util.stream.StreamShape inputShape() {
            return this.inputShape;
        }

        @Override // java8.util.stream.TerminalOp
        public <P_IN> R evaluateSequential(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
            return ((java8.util.stream.ReduceOps.AccumulatingSink) pipelineHelper.wrapAndCopyInto(makeSink(), (java8.util.Spliterator) spliterator)).get();
        }

        @Override // java8.util.stream.TerminalOp
        public <P_IN> R evaluateParallel(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
            return ((java8.util.stream.ReduceOps.AccumulatingSink) new java8.util.stream.ReduceOps.ReduceTask(this, pipelineHelper, spliterator).invoke()).get();
        }
    }

    private static final class ReduceTask<P_IN, P_OUT, R, S extends java8.util.stream.ReduceOps.AccumulatingSink<P_OUT, R, S>> extends java8.util.stream.AbstractTask<P_IN, P_OUT, S, java8.util.stream.ReduceOps.ReduceTask<P_IN, P_OUT, R, S>> {
        private final java8.util.stream.ReduceOps.ReduceOp<P_OUT, R, S> op;

        ReduceTask(java8.util.stream.ReduceOps.ReduceOp<P_OUT, R, S> reduceOp, java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
            super(pipelineHelper, spliterator);
            this.op = reduceOp;
        }

        ReduceTask(java8.util.stream.ReduceOps.ReduceTask<P_IN, P_OUT, R, S> reduceTask, java8.util.Spliterator<P_IN> spliterator) {
            super(reduceTask, spliterator);
            this.op = reduceTask.op;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public java8.util.stream.ReduceOps.ReduceTask<P_IN, P_OUT, R, S> makeChild(java8.util.Spliterator<P_IN> spliterator) {
            return new java8.util.stream.ReduceOps.ReduceTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public S doLeaf() {
            return (S) this.helper.wrapAndCopyInto(this.op.makeSink(), (java8.util.Spliterator) this.spliterator);
        }

        @Override // java8.util.stream.AbstractTask, java8.util.concurrent.CountedCompleter
        public void onCompletion(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
            if (!isLeaf()) {
                java8.util.stream.ReduceOps.AccumulatingSink accumulatingSink = (java8.util.stream.ReduceOps.AccumulatingSink) ((java8.util.stream.ReduceOps.ReduceTask) this.leftChild).getLocalResult();
                accumulatingSink.combine((java8.util.stream.ReduceOps.AccumulatingSink) ((java8.util.stream.ReduceOps.ReduceTask) this.rightChild).getLocalResult());
                setLocalResult(accumulatingSink);
            }
            super.onCompletion(countedCompleter);
        }
    }
}
