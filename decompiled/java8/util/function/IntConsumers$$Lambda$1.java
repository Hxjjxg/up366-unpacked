package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class IntConsumers$$Lambda$1 implements java8.util.function.IntConsumer {
    private final java8.util.function.IntConsumer arg$1;
    private final java8.util.function.IntConsumer arg$2;

    private IntConsumers$$Lambda$1(java8.util.function.IntConsumer intConsumer, java8.util.function.IntConsumer intConsumer2) {
        this.arg$1 = intConsumer;
        this.arg$2 = intConsumer2;
    }

    public static java8.util.function.IntConsumer lambdaFactory$(java8.util.function.IntConsumer intConsumer, java8.util.function.IntConsumer intConsumer2) {
        return new java8.util.function.IntConsumers$$Lambda$1(intConsumer, intConsumer2);
    }

    @Override // java8.util.function.IntConsumer
    public void accept(int i) {
        java8.util.function.IntConsumers.lambda$andThen$129(this.arg$1, this.arg$2, i);
    }
}
