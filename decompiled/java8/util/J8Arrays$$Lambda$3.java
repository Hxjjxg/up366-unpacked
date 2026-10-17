package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class J8Arrays$$Lambda$3 implements java8.util.function.IntConsumer {
    private final long[] arg$1;
    private final java8.util.function.IntToLongFunction arg$2;

    private J8Arrays$$Lambda$3(long[] jArr, java8.util.function.IntToLongFunction intToLongFunction) {
        this.arg$1 = jArr;
        this.arg$2 = intToLongFunction;
    }

    public static java8.util.function.IntConsumer lambdaFactory$(long[] jArr, java8.util.function.IntToLongFunction intToLongFunction) {
        return new java8.util.J8Arrays$$Lambda$3(jArr, intToLongFunction);
    }

    @Override // java8.util.function.IntConsumer
    public void accept(int i) {
        java8.util.J8Arrays.lambda$parallelSetAll$165(this.arg$1, this.arg$2, i);
    }
}
