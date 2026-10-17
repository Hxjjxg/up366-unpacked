package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class FindOps$$Lambda$5 implements java8.util.function.Supplier {
    private static final java8.util.stream.FindOps$$Lambda$5 instance = new java8.util.stream.FindOps$$Lambda$5();

    private FindOps$$Lambda$5() {
    }

    @Override // java8.util.function.Supplier
    public java.lang.Object get() {
        return new java8.util.stream.FindOps.FindSink.OfRef();
    }
}
