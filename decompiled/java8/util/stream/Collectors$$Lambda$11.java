package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$11 implements java8.util.function.Function {
    private static final java8.util.stream.Collectors$$Lambda$11 instance = new java8.util.stream.Collectors$$Lambda$11();

    private Collectors$$Lambda$11() {
    }

    @Override // java8.util.function.Function
    public java.lang.Object apply(java.lang.Object obj) {
        return java8.util.Lists.of(((java.util.List) obj).toArray());
    }
}
