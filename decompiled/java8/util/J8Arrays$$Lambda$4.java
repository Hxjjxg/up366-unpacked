package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class J8Arrays$$Lambda$4 implements java8.util.function.IntConsumer {
    private final double[] arg$1;
    private final java8.util.function.IntToDoubleFunction arg$2;

    private J8Arrays$$Lambda$4(double[] dArr, java8.util.function.IntToDoubleFunction intToDoubleFunction) {
        this.arg$1 = dArr;
        this.arg$2 = intToDoubleFunction;
    }

    public static java8.util.function.IntConsumer lambdaFactory$(double[] dArr, java8.util.function.IntToDoubleFunction intToDoubleFunction) {
        return new java8.util.J8Arrays$$Lambda$4(dArr, intToDoubleFunction);
    }

    @Override // java8.util.function.IntConsumer
    public void accept(int i) {
        java8.util.J8Arrays.lambda$parallelSetAll$166(this.arg$1, this.arg$2, i);
    }
}
