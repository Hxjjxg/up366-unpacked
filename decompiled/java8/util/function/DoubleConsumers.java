package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class DoubleConsumers {
    public static java8.util.function.DoubleConsumer andThen(java8.util.function.DoubleConsumer doubleConsumer, java8.util.function.DoubleConsumer doubleConsumer2) {
        java8.util.Objects.requireNonNull(doubleConsumer);
        java8.util.Objects.requireNonNull(doubleConsumer2);
        return java8.util.function.DoubleConsumers$$Lambda$1.lambdaFactory$(doubleConsumer, doubleConsumer2);
    }

    static /* synthetic */ void lambda$andThen$162(java8.util.function.DoubleConsumer doubleConsumer, java8.util.function.DoubleConsumer doubleConsumer2, double d) {
        doubleConsumer.accept(d);
        doubleConsumer2.accept(d);
    }

    private DoubleConsumers() {
    }
}
