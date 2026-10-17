package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Comparators$$Lambda$1 implements java.util.Comparator, java.io.Serializable {
    private final java.util.Comparator arg$1;
    private final java8.util.function.Function arg$2;

    private Comparators$$Lambda$1(java.util.Comparator comparator, java8.util.function.Function function) {
        this.arg$1 = comparator;
        this.arg$2 = function;
    }

    public static java.util.Comparator lambdaFactory$(java.util.Comparator comparator, java8.util.function.Function function) {
        return new java8.util.Comparators$$Lambda$1(comparator, function);
    }

    @Override // java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.Comparators.lambda$comparing$b1478148$1(this.arg$1, this.arg$2, obj, obj2);
    }
}
