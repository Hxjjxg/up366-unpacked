package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Consumers {
    public static <T> java8.util.function.Consumer<T> andThen(java8.util.function.Consumer<? super T> consumer, java8.util.function.Consumer<? super T> consumer2) {
        java8.util.Objects.requireNonNull(consumer);
        java8.util.Objects.requireNonNull(consumer2);
        return java8.util.function.Consumers$$Lambda$1.lambdaFactory$(consumer, consumer2);
    }

    static /* synthetic */ void lambda$andThen$160(java8.util.function.Consumer consumer, java8.util.function.Consumer consumer2, java.lang.Object obj) {
        consumer.accept(obj);
        consumer2.accept(obj);
    }

    private Consumers() {
    }
}
