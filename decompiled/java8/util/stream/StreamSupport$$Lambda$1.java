package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class StreamSupport$$Lambda$1 implements java.lang.Runnable {
    private final java8.util.stream.BaseStream arg$1;

    private StreamSupport$$Lambda$1(java8.util.stream.BaseStream baseStream) {
        this.arg$1 = baseStream;
    }

    public static java.lang.Runnable lambdaFactory$(java8.util.stream.BaseStream baseStream) {
        return new java8.util.stream.StreamSupport$$Lambda$1(baseStream);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.arg$1.close();
    }
}
