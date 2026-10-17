package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$8 implements java8.util.function.BinaryOperator {
    private static final java8.util.stream.Collectors$$Lambda$8 instance = new java8.util.stream.Collectors$$Lambda$8();

    private Collectors$$Lambda$8() {
    }

    @Override // java8.util.function.BiFunction
    public java.lang.Object apply(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.stream.Collectors.lambda$toCollection$4((java.util.Collection) obj, (java.util.Collection) obj2);
    }
}
