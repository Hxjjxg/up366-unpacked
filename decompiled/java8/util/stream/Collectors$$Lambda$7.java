package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$7 implements java8.util.function.BiConsumer {
    private static final java8.util.stream.Collectors$$Lambda$7 instance = new java8.util.stream.Collectors$$Lambda$7();

    private Collectors$$Lambda$7() {
    }

    @Override // java8.util.function.BiConsumer
    public void accept(java.lang.Object obj, java.lang.Object obj2) {
        ((java.util.Collection) obj).add(obj2);
    }
}
