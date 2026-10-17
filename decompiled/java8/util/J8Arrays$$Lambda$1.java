package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class J8Arrays$$Lambda$1 implements java8.util.function.IntConsumer {
    private final java.lang.Object[] arg$1;
    private final java8.util.function.IntFunction arg$2;

    private J8Arrays$$Lambda$1(java.lang.Object[] objArr, java8.util.function.IntFunction intFunction) {
        this.arg$1 = objArr;
        this.arg$2 = intFunction;
    }

    public static java8.util.function.IntConsumer lambdaFactory$(java.lang.Object[] objArr, java8.util.function.IntFunction intFunction) {
        return new java8.util.J8Arrays$$Lambda$1(objArr, intFunction);
    }

    @Override // java8.util.function.IntConsumer
    public void accept(int i) {
        java8.util.J8Arrays.lambda$parallelSetAll$163(this.arg$1, this.arg$2, i);
    }
}
