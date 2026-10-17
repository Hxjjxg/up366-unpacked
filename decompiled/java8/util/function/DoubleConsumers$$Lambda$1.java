package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class DoubleConsumers$$Lambda$1 implements java8.util.function.DoubleConsumer {
    private final java8.util.function.DoubleConsumer arg$1;
    private final java8.util.function.DoubleConsumer arg$2;

    private DoubleConsumers$$Lambda$1(java8.util.function.DoubleConsumer doubleConsumer, java8.util.function.DoubleConsumer doubleConsumer2) {
        this.arg$1 = doubleConsumer;
        this.arg$2 = doubleConsumer2;
    }

    public static java8.util.function.DoubleConsumer lambdaFactory$(java8.util.function.DoubleConsumer doubleConsumer, java8.util.function.DoubleConsumer doubleConsumer2) {
        return new java8.util.function.DoubleConsumers$$Lambda$1(doubleConsumer, doubleConsumer2);
    }

    @Override // java8.util.function.DoubleConsumer
    public void accept(double d) {
        java8.util.function.DoubleConsumers.lambda$andThen$162(this.arg$1, this.arg$2, d);
    }
}
