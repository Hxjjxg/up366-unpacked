package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$83 implements java8.util.function.BinaryOperator {
    private static final java8.util.stream.Collectors$$Lambda$83 instance = new java8.util.stream.Collectors$$Lambda$83();

    private Collectors$$Lambda$83() {
    }

    @Override // java8.util.function.BiFunction
    public java.lang.Object apply(java.lang.Object obj, java.lang.Object obj2) {
        return ((java8.util.stream.Collectors.C1PairBox) obj).combine((java8.util.stream.Collectors.C1PairBox) obj2);
    }
}
