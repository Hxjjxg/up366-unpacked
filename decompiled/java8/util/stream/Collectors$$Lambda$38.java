package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$38 implements java8.util.function.BiConsumer {
    private final java8.util.function.ToDoubleFunction arg$1;

    private Collectors$$Lambda$38(java8.util.function.ToDoubleFunction toDoubleFunction) {
        this.arg$1 = toDoubleFunction;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.ToDoubleFunction toDoubleFunction) {
        return new java8.util.stream.Collectors$$Lambda$38(toDoubleFunction);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$summingDouble$29(this.arg$1, (double[]) obj, obj2);
    }
}
