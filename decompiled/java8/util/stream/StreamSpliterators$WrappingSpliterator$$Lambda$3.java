package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class StreamSpliterators$WrappingSpliterator$$Lambda$3 implements java8.util.function.Consumer {
    private final java8.util.function.Consumer arg$1;

    private StreamSpliterators$WrappingSpliterator$$Lambda$3(java8.util.function.Consumer consumer) {
        this.arg$1 = consumer;
    }

    public static java8.util.function.Consumer lambdaFactory$(java8.util.function.Consumer consumer) {
        return new java8.util.stream.StreamSpliterators$WrappingSpliterator$$Lambda$3(consumer);
    }

    @Override // java8.util.function.Consumer
    public void accept(java.lang.Object obj) {
        this.arg$1.accept(obj);
    }
}
