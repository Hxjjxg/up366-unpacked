package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$78 implements java8.util.function.BinaryOperator {
    private static final java8.util.stream.Collectors$$Lambda$78 instance = new java8.util.stream.Collectors$$Lambda$78();

    private Collectors$$Lambda$78() {
    }

    @Override // java8.util.function.BiFunction
    public java.lang.Object apply(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.stream.Collectors.lambda$summarizingLong$73((java8.util.LongSummaryStatistics) obj, (java8.util.LongSummaryStatistics) obj2);
    }
}
