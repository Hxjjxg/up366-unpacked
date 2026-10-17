package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class IntConsumers {
    public static java8.util.function.IntConsumer andThen(java8.util.function.IntConsumer intConsumer, java8.util.function.IntConsumer intConsumer2) {
        java8.util.Objects.requireNonNull(intConsumer);
        java8.util.Objects.requireNonNull(intConsumer2);
        return java8.util.function.IntConsumers$$Lambda$1.lambdaFactory$(intConsumer, intConsumer2);
    }

    static /* synthetic */ void lambda$andThen$129(java8.util.function.IntConsumer intConsumer, java8.util.function.IntConsumer intConsumer2, int i) {
        intConsumer.accept(i);
        intConsumer2.accept(i);
    }

    private IntConsumers() {
    }
}
