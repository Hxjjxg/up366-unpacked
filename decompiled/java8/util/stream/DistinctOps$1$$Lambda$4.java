package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class DistinctOps$1$$Lambda$4 implements java8.util.function.Consumer {
    private final java.util.concurrent.atomic.AtomicBoolean arg$1;
    private final java.util.concurrent.ConcurrentMap arg$2;

    private DistinctOps$1$$Lambda$4(java.util.concurrent.atomic.AtomicBoolean atomicBoolean, java.util.concurrent.ConcurrentMap concurrentMap) {
        this.arg$1 = atomicBoolean;
        this.arg$2 = concurrentMap;
    }

    public static java8.util.function.Consumer lambdaFactory$(java.util.concurrent.atomic.AtomicBoolean atomicBoolean, java.util.concurrent.ConcurrentMap concurrentMap) {
        return new java8.util.stream.DistinctOps$1$$Lambda$4(atomicBoolean, concurrentMap);
    }

    @Override // java8.util.function.Consumer
    public void accept(java.lang.Object obj) {
        java8.util.stream.DistinctOps.AnonymousClass1.lambda$opEvaluateParallel$131(this.arg$1, this.arg$2, obj);
    }
}
