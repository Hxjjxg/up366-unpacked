package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class RefStreams {
    public static <T> java8.util.stream.Stream<T> takeWhile(java8.util.stream.Stream<? extends T> stream, java8.util.function.Predicate<? super T> predicate) {
        java8.util.Objects.requireNonNull(stream);
        java8.util.Objects.requireNonNull(predicate);
        return java8.util.stream.StreamSupport.stream(new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfRef.Taking(stream.spliterator2(), true, predicate), stream.isParallel()).onClose(java8.util.stream.StreamSupport.closeHandler(stream));
    }

    public static <T> java8.util.stream.Stream<T> dropWhile(java8.util.stream.Stream<? extends T> stream, java8.util.function.Predicate<? super T> predicate) {
        java8.util.Objects.requireNonNull(stream);
        java8.util.Objects.requireNonNull(predicate);
        return java8.util.stream.StreamSupport.stream(new java8.util.stream.WhileOps.UnorderedWhileSpliterator.OfRef.Dropping(stream.spliterator2(), true, predicate), stream.isParallel()).onClose(java8.util.stream.StreamSupport.closeHandler(stream));
    }

    public static <T> java8.util.stream.Stream.Builder<T> builder() {
        return new java8.util.stream.Streams.StreamBuilderImpl();
    }

    public static <T> java8.util.stream.Stream<T> empty() {
        return java8.util.stream.StreamSupport.stream(java8.util.Spliterators.emptySpliterator(), false);
    }

    public static <T> java8.util.stream.Stream<T> of(T t) {
        return java8.util.stream.StreamSupport.stream((java8.util.Spliterator) new java8.util.stream.Streams.StreamBuilderImpl(t), false);
    }

    public static <T> java8.util.stream.Stream<T> ofNullable(T t) {
        if (t == null) {
            return empty();
        }
        return java8.util.stream.StreamSupport.stream((java8.util.Spliterator) new java8.util.stream.Streams.StreamBuilderImpl(t), false);
    }

    public static <T> java8.util.stream.Stream<T> of(T... tArr) {
        return java8.util.J8Arrays.stream(tArr);
    }

    public static <T, S extends T> java8.util.stream.Stream<T> iterate(final S s, final java8.util.function.UnaryOperator<S> unaryOperator) {
        java8.util.Objects.requireNonNull(unaryOperator);
        return java8.util.stream.StreamSupport.stream((java8.util.Spliterator) new java8.util.Spliterators.AbstractSpliterator<T>(Long.MAX_VALUE, 1040) { // from class: java8.util.stream.RefStreams.1
            S prev;
            boolean started;

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
            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
                java.lang.Object obj;
                java8.util.Objects.requireNonNull(consumer);
                if (this.started) {
                    obj = (java.lang.Object) unaryOperator.apply(this.prev);
                } else {
                    obj = (java.lang.Object) s;
                    this.started = true;
                }
                this.prev = (S) obj;
                consumer.accept(obj);
                return true;
            }
        }, false);
    }

    public static <T, S extends T> java8.util.stream.Stream<T> iterate(final S s, final java8.util.function.Predicate<? super S> predicate, final java8.util.function.UnaryOperator<S> unaryOperator) {
        java8.util.Objects.requireNonNull(unaryOperator);
        java8.util.Objects.requireNonNull(predicate);
        return java8.util.stream.StreamSupport.stream((java8.util.Spliterator) new java8.util.Spliterators.AbstractSpliterator<T>(Long.MAX_VALUE, 1040) { // from class: java8.util.stream.RefStreams.2
            boolean finished;
            S prev;
            boolean started;

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
            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
                T t;
                java8.util.Objects.requireNonNull(consumer);
                if (this.finished) {
                    return false;
                }
                if (this.started) {
                    t = (java.lang.Object) unaryOperator.apply(this.prev);
                } else {
                    t = (java.lang.Object) s;
                    this.started = true;
                }
                if (!predicate.test(t)) {
                    this.prev = null;
                    this.finished = true;
                    return false;
                }
                this.prev = (S) t;
                consumer.accept(t);
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
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
            @Override // java8.util.Spliterators.AbstractSpliterator, java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
                java8.util.Objects.requireNonNull(consumer);
                if (this.finished) {
                    return;
                }
                this.finished = true;
                java.lang.Object objApply = this.started ? unaryOperator.apply(this.prev) : s;
                this.prev = null;
                while (predicate.test(objApply)) {
                    consumer.accept(objApply);
                    objApply = unaryOperator.apply(objApply);
                }
            }
        }, false);
    }

    public static <T> java8.util.stream.Stream<T> generate(java8.util.function.Supplier<? extends T> supplier) {
        java8.util.Objects.requireNonNull(supplier);
        return java8.util.stream.StreamSupport.stream((java8.util.Spliterator) new java8.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfRef(Long.MAX_VALUE, supplier), false);
    }

    public static <T> java8.util.stream.Stream<T> concat(java8.util.stream.Stream<? extends T> stream, java8.util.stream.Stream<? extends T> stream2) {
        java8.util.Objects.requireNonNull(stream);
        java8.util.Objects.requireNonNull(stream2);
        return java8.util.stream.StreamSupport.stream(new java8.util.stream.Streams.ConcatSpliterator.OfRef(stream.spliterator2(), stream2.spliterator2()), stream.isParallel() || stream2.isParallel()).onClose(java8.util.stream.Streams.composedClose(stream, stream2));
    }

    private RefStreams() {
    }
}
