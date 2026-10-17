package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class AbstractPipeline$$Lambda$2 implements java8.util.function.Supplier {
    private final java8.util.Spliterator arg$1;

    private AbstractPipeline$$Lambda$2(java8.util.Spliterator spliterator) {
        this.arg$1 = spliterator;
    }

    public static java8.util.function.Supplier lambdaFactory$(java8.util.Spliterator spliterator) {
        return new java8.util.stream.AbstractPipeline$$Lambda$2(spliterator);
    }

    @Override // java8.util.function.Supplier
    public java.lang.Object get() {
        return java8.util.stream.AbstractPipeline.lambda$wrapSpliterator$78(this.arg$1);
    }
}
