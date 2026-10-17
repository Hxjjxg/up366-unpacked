package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class SortedOps$RefSortingSink$$Lambda$1 implements java8.util.function.Consumer {
    private final java8.util.stream.Sink arg$1;

    private SortedOps$RefSortingSink$$Lambda$1(java8.util.stream.Sink sink) {
        this.arg$1 = sink;
    }

    public static java8.util.function.Consumer lambdaFactory$(java8.util.stream.Sink sink) {
        return new java8.util.stream.SortedOps$RefSortingSink$$Lambda$1(sink);
    }

    @Override // java8.util.function.Consumer
    public void accept(java.lang.Object obj) {
        this.arg$1.accept(obj);
    }
}
