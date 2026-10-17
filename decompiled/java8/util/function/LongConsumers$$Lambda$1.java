package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class LongConsumers$$Lambda$1 implements java8.util.function.LongConsumer {
    private final java8.util.function.LongConsumer arg$1;
    private final java8.util.function.LongConsumer arg$2;

    private LongConsumers$$Lambda$1(java8.util.function.LongConsumer longConsumer, java8.util.function.LongConsumer longConsumer2) {
        this.arg$1 = longConsumer;
        this.arg$2 = longConsumer2;
    }

    public static java8.util.function.LongConsumer lambdaFactory$(java8.util.function.LongConsumer longConsumer, java8.util.function.LongConsumer longConsumer2) {
        return new java8.util.function.LongConsumers$$Lambda$1(longConsumer, longConsumer2);
    }

    @Override // java8.util.function.LongConsumer
    public void accept(long j) {
        java8.util.function.LongConsumers.lambda$andThen$161(this.arg$1, this.arg$2, j);
    }
}
