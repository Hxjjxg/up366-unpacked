package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class DistinctOps {
    private DistinctOps() {
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: java8.util.stream.DistinctOps$1, reason: invalid class name */
    static class AnonymousClass1<T> extends java8.util.stream.ReferencePipeline.StatefulOp<T, T> {
        AnonymousClass1(java8.util.stream.AbstractPipeline abstractPipeline, java8.util.stream.StreamShape streamShape, int i) {
            super(abstractPipeline, streamShape, i);
        }

        <P_IN> java8.util.stream.Node<T> reduce(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
            return java8.util.stream.Nodes.node((java.util.Collection) java8.util.stream.ReduceOps.makeRef(java8.util.stream.DistinctOps$1$$Lambda$1.instance, java8.util.stream.DistinctOps$1$$Lambda$2.instance, java8.util.stream.DistinctOps$1$$Lambda$3.instance).evaluateParallel(pipelineHelper, spliterator));
        }

        @Override // java8.util.stream.ReferencePipeline.StatefulOp, java8.util.stream.AbstractPipeline
        <P_IN> java8.util.stream.Node<T> opEvaluateParallel(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.IntFunction<T[]> intFunction) {
            java.util.Collection keysAndNullSet;
            if (java8.util.stream.StreamOpFlag.DISTINCT.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return pipelineHelper.evaluate(spliterator, false, intFunction);
            }
            if (java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return reduce(pipelineHelper, spliterator);
            }
            java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
            java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap(512, 0.75f, java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism() + 1);
            java8.util.stream.ForEachOps.makeRef(java8.util.stream.DistinctOps$1$$Lambda$4.lambdaFactory$(atomicBoolean, concurrentHashMap), false).evaluateParallel(pipelineHelper, spliterator);
            java.util.Set setKeySet = concurrentHashMap.keySet();
            java.util.Collection collection = setKeySet;
            if (atomicBoolean.get()) {
                int size = setKeySet.size();
                if (size >= 127) {
                    keysAndNullSet = new java8.util.stream.DistinctOps.KeysAndNullSet(setKeySet, size);
                } else {
                    java.util.HashSet hashSet = new java.util.HashSet(java.lang.Math.max(((int) ((size + 1) / 0.75f)) + 1, 16));
                    hashSet.addAll(setKeySet);
                    hashSet.add(null);
                    keysAndNullSet = hashSet;
                }
                collection = keysAndNullSet;
            }
            return java8.util.stream.Nodes.node(collection);
        }

        static /* synthetic */ void lambda$opEvaluateParallel$131(java.util.concurrent.atomic.AtomicBoolean atomicBoolean, java.util.concurrent.ConcurrentMap concurrentMap, java.lang.Object obj) {
            if (obj == null) {
                atomicBoolean.set(true);
            } else {
                concurrentMap.putIfAbsent(obj, java.lang.Boolean.TRUE);
            }
        }

        @Override // java8.util.stream.AbstractPipeline
        <P_IN> java8.util.Spliterator<T> opEvaluateParallelLazy(java8.util.stream.PipelineHelper<T> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
            if (java8.util.stream.StreamOpFlag.DISTINCT.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return pipelineHelper.wrapSpliterator(spliterator);
            }
            if (java8.util.stream.StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return reduce(pipelineHelper, spliterator).spliterator();
            }
            return new java8.util.stream.StreamSpliterators.DistinctSpliterator(pipelineHelper.wrapSpliterator(spliterator));
        }

        @Override // java8.util.stream.AbstractPipeline
        java8.util.stream.Sink<T> opWrapSink(int i, java8.util.stream.Sink<T> sink) {
            java8.util.Objects.requireNonNull(sink);
            if (java8.util.stream.StreamOpFlag.DISTINCT.isKnown(i)) {
                return sink;
            }
            if (java8.util.stream.StreamOpFlag.SORTED.isKnown(i)) {
                return new java8.util.stream.Sink.ChainedReference<T, T>(sink) { // from class: java8.util.stream.DistinctOps.1.1
                    T lastSeen;
                    boolean seenNull;

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public void begin(long j) {
                        this.seenNull = false;
                        this.lastSeen = null;
                        this.downstream.begin(-1L);
                    }

                    @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                    public void end() {
                        this.seenNull = false;
                        this.lastSeen = null;
                        this.downstream.end();
                    }

                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // java8.util.function.Consumer
                    public void accept(T t) {
                        if (t == null) {
                            if (this.seenNull) {
                                return;
                            }
                            this.seenNull = true;
                            java8.util.stream.Sink<? super E_OUT> sink2 = this.downstream;
                            this.lastSeen = null;
                            sink2.accept((java.lang.Object) null);
                            return;
                        }
                        T t2 = this.lastSeen;
                        if (t2 == null || !t.equals(t2)) {
                            java8.util.stream.Sink<? super E_OUT> sink3 = this.downstream;
                            this.lastSeen = t;
                            sink3.accept((java.lang.Object) t);
                        }
                    }
                };
            }
            return new java8.util.stream.Sink.ChainedReference<T, T>(sink) { // from class: java8.util.stream.DistinctOps.1.2
                java.util.Set<T> seen;

                @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                public void begin(long j) {
                    this.seen = new java.util.HashSet();
                    this.downstream.begin(-1L);
                }

                @Override // java8.util.stream.Sink.ChainedReference, java8.util.stream.Sink
                public void end() {
                    this.seen = null;
                    this.downstream.end();
                }

                /* JADX WARN: Type inference incomplete: some casts might be missing */
                @Override // java8.util.function.Consumer
                public void accept(T t) {
                    if (this.seen.add(t)) {
                        this.downstream.accept((java.lang.Object) t);
                    }
                }
            };
        }
    }

    static <T> java8.util.stream.ReferencePipeline<T, T> makeRef(java8.util.stream.AbstractPipeline<?, T, ?> abstractPipeline) {
        return new java8.util.stream.DistinctOps.AnonymousClass1(abstractPipeline, java8.util.stream.StreamShape.REFERENCE, java8.util.stream.StreamOpFlag.IS_DISTINCT | java8.util.stream.StreamOpFlag.NOT_SIZED);
    }

    static final class KeysAndNullSet<E> extends java.util.AbstractSet<E> {
        final java.util.Set<E> keys;
        final int size;

        KeysAndNullSet(java.util.Set<E> set, int i) {
            this.keys = set;
            this.size = i + 1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<E> iterator() {
            return new java.util.Iterator<E>() { // from class: java8.util.stream.DistinctOps.KeysAndNullSet.1
                java.util.Iterator<E> it;
                boolean nullDelivered = false;

                {
                    this.it = java8.util.stream.DistinctOps.KeysAndNullSet.this.keys.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.nullDelivered) {
                        return this.it.hasNext();
                    }
                    return true;
                }

                @Override // java.util.Iterator
                public E next() {
                    if (!this.nullDelivered) {
                        this.nullDelivered = true;
                        return null;
                    }
                    return this.it.next();
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new java.lang.UnsupportedOperationException();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }
    }
}
