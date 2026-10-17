package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class LongConsumers {
    public static java8.util.function.LongConsumer andThen(java8.util.function.LongConsumer longConsumer, java8.util.function.LongConsumer longConsumer2) {
        java8.util.Objects.requireNonNull(longConsumer);
        java8.util.Objects.requireNonNull(longConsumer2);
        return java8.util.function.LongConsumers$$Lambda$1.lambdaFactory$(longConsumer, longConsumer2);
    }

    static /* synthetic */ void lambda$andThen$161(java8.util.function.LongConsumer longConsumer, java8.util.function.LongConsumer longConsumer2, long j) {
        longConsumer.accept(j);
        longConsumer2.accept(j);
    }

    private LongConsumers() {
    }
}
