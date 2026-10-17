package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$75 implements java8.util.function.BiConsumer {
    private final java8.util.function.ToIntFunction arg$1;

    private Collectors$$Lambda$75(java8.util.function.ToIntFunction toIntFunction) {
        this.arg$1 = toIntFunction;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.ToIntFunction toIntFunction) {
        return new java8.util.stream.Collectors$$Lambda$75(toIntFunction);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$summarizingInt$70(this.arg$1, (java8.util.IntSummaryStatistics) obj, obj2);
    }
}
