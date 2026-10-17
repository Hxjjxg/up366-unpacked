package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$6 implements java8.util.function.BiConsumer {
    private final java8.util.function.Function arg$1;
    private final java8.util.function.Function arg$2;

    private Collectors$$Lambda$6(java8.util.function.Function function, java8.util.function.Function function2) {
        this.arg$1 = function;
        this.arg$2 = function2;
    }

    public static java8.util.function.BiConsumer lambdaFactory$(java8.util.function.Function function, java8.util.function.Function function2) {
        return new java8.util.stream.Collectors$$Lambda$6(function, function2);
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        java8.util.stream.Collectors.lambda$uniqKeysMapAccumulator$2(this.arg$1, this.arg$2, (java.util.Map) obj, obj2);
    }
}
