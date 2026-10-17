package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$10 implements java8.util.function.BinaryOperator {
    private static final java8.util.stream.Collectors$$Lambda$10 instance = new java8.util.stream.Collectors$$Lambda$10();

    private Collectors$$Lambda$10() {
    }

    @Override // java8.util.function.BiFunction
    public java.lang.Object apply(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.stream.Collectors.lambda$toUnmodifiableList$6((java.util.List) obj, (java.util.List) obj2);
    }
}
