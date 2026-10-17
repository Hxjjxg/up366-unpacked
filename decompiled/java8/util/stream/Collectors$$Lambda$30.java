package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$30 implements java8.util.function.BiConsumer {
    private final java8.util.function.ToIntFunction arg$1;

    private Collectors$$Lambda$30(java8.util.function.ToIntFunction toIntFunction) {
        this.arg$1 = toIntFunction;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.ToIntFunction toIntFunction) {
        return new java8.util.stream.Collectors$$Lambda$30(toIntFunction);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$summingInt$21(this.arg$1, (int[]) obj, obj2);
    }
}
