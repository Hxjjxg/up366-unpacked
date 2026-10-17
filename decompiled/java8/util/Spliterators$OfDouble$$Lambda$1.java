package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Spliterators$OfDouble$$Lambda$1 implements java8.util.function.DoubleConsumer {
    private final java8.util.function.Consumer arg$1;

    private Spliterators$OfDouble$$Lambda$1(java8.util.function.Consumer consumer) {
        this.arg$1 = consumer;
    }

    public static java8.util.function.DoubleConsumer lambdaFactory$(java8.util.function.Consumer consumer) {
        return new java8.util.Spliterators$OfDouble$$Lambda$1(consumer);
    }

    @Override // java8.util.function.DoubleConsumer
    public void accept(double d) {
        this.arg$1.accept(java.lang.Double.valueOf(d));
    }
}
