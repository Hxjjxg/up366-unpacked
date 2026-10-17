package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$90 implements java8.util.function.Consumer {
    private final java8.util.function.BiConsumer arg$1;
    private final java.lang.Object arg$2;

    private Collectors$$Lambda$90(java8.util.function.BiConsumer biConsumer, java.lang.Object obj) {
        this.arg$1 = biConsumer;
        this.arg$2 = obj;
    }

    public static java8.util.function.Consumer lambdaFactory$(java8.util.function.BiConsumer biConsumer, java.lang.Object obj) {
        return new java8.util.stream.Collectors$$Lambda$90(biConsumer, obj);
    }

    @Override // java8.util.function.Consumer
    public void accept(java.lang.Object obj) {
        this.arg$1.accept(this.arg$2, obj);
    }
}
