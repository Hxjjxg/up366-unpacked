package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class AbstractPipeline$$Lambda$1 implements java8.util.function.Supplier {
    private final java8.util.stream.AbstractPipeline arg$1;

    private AbstractPipeline$$Lambda$1(java8.util.stream.AbstractPipeline abstractPipeline) {
        this.arg$1 = abstractPipeline;
    }

    public static java8.util.function.Supplier lambdaFactory$(java8.util.stream.AbstractPipeline abstractPipeline) {
        return new java8.util.stream.AbstractPipeline$$Lambda$1(abstractPipeline);
    }

    @Override // java8.util.function.Supplier
    public java.lang.Object get() {
        return java8.util.stream.AbstractPipeline.lambda$spliterator$77(this.arg$1);
    }
}
