package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class BiConsumers {
    public static <T, U> java8.util.function.BiConsumer<T, U> andThen(java8.util.function.BiConsumer<? super T, ? super U> biConsumer, java8.util.function.BiConsumer<? super T, ? super U> biConsumer2) {
        java8.util.Objects.requireNonNull(biConsumer);
        java8.util.Objects.requireNonNull(biConsumer2);
        return java8.util.function.BiConsumers$$Lambda$1.lambdaFactory$(biConsumer, biConsumer2);
    }

    static /* synthetic */ void lambda$andThen$130(java8.util.function.BiConsumer biConsumer, java8.util.function.BiConsumer biConsumer2, java.lang.Object obj, java.lang.Object obj2) {
        biConsumer.accept(obj, obj2);
        biConsumer2.accept(obj, obj2);
    }

    private BiConsumers() {
    }
}
