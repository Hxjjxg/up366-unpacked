package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class SpinedBuffer$$Lambda$1 implements java8.util.function.Consumer {
    private final java.util.List arg$1;

    private SpinedBuffer$$Lambda$1(java.util.List list) {
        this.arg$1 = list;
    }

    public static java8.util.function.Consumer lambdaFactory$(java.util.List list) {
        return new java8.util.stream.SpinedBuffer$$Lambda$1(list);
    }

    @Override // java8.util.function.Consumer
    public void accept(java.lang.Object obj) {
        this.arg$1.add(obj);
    }
}
