package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class StreamSpliterators$WrappingSpliterator$$Lambda$1 implements java8.util.function.Consumer {
    private final java8.util.stream.SpinedBuffer arg$1;

    private StreamSpliterators$WrappingSpliterator$$Lambda$1(java8.util.stream.SpinedBuffer spinedBuffer) {
        this.arg$1 = spinedBuffer;
    }

    public static java8.util.function.Consumer lambdaFactory$(java8.util.stream.SpinedBuffer spinedBuffer) {
        return new java8.util.stream.StreamSpliterators$WrappingSpliterator$$Lambda$1(spinedBuffer);
    }

    @Override // java8.util.function.Consumer
    public void accept(java.lang.Object obj) {
        this.arg$1.accept(obj);
    }
}
