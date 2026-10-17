package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class BinaryOperators$$Lambda$2 implements java8.util.function.BinaryOperator {
    private final java.util.Comparator arg$1;

    private BinaryOperators$$Lambda$2(java.util.Comparator comparator) {
        this.arg$1 = comparator;
    }

    public static java8.util.function.BinaryOperator lambdaFactory$(java.util.Comparator comparator) {
        return new java8.util.function.BinaryOperators$$Lambda$2(comparator);
    }

    @Override // java8.util.function.BiFunction
    public java.lang.Object apply(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.function.BinaryOperators.lambda$maxBy$111(this.arg$1, obj, obj2);
    }
}
