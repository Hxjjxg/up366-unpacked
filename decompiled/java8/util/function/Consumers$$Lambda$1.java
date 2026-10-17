package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Consumers$$Lambda$1 implements java8.util.function.Consumer {
    private final java8.util.function.Consumer arg$1;
    private final java8.util.function.Consumer arg$2;

    private Consumers$$Lambda$1(java8.util.function.Consumer consumer, java8.util.function.Consumer consumer2) {
        this.arg$1 = consumer;
        this.arg$2 = consumer2;
    }

    public static java8.util.function.Consumer lambdaFactory$(java8.util.function.Consumer consumer, java8.util.function.Consumer consumer2) {
        return new java8.util.function.Consumers$$Lambda$1(consumer, consumer2);
    }

    @Override // java8.util.function.Consumer
    public void accept(java.lang.Object obj) {
        java8.util.function.Consumers.lambda$andThen$160(this.arg$1, this.arg$2, obj);
    }
}
