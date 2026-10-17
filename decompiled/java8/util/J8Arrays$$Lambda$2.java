package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class J8Arrays$$Lambda$2 implements java8.util.function.IntConsumer {
    private final int[] arg$1;
    private final java8.util.function.IntUnaryOperator arg$2;

    private J8Arrays$$Lambda$2(int[] iArr, java8.util.function.IntUnaryOperator intUnaryOperator) {
        this.arg$1 = iArr;
        this.arg$2 = intUnaryOperator;
    }

    public static java8.util.function.IntConsumer lambdaFactory$(int[] iArr, java8.util.function.IntUnaryOperator intUnaryOperator) {
        return new java8.util.J8Arrays$$Lambda$2(iArr, intUnaryOperator);
    }

    @Override // java8.util.function.IntConsumer
    public void accept(int i) {
        java8.util.J8Arrays.lambda$parallelSetAll$164(this.arg$1, this.arg$2, i);
    }
}
