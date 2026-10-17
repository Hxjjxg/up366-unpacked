package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Comparators$$Lambda$4 implements java.util.Comparator, java.io.Serializable {
    private final java8.util.function.ToLongFunction arg$1;

    private Comparators$$Lambda$4(java8.util.function.ToLongFunction toLongFunction) {
        this.arg$1 = toLongFunction;
    }

    public static java.util.Comparator lambdaFactory$(java8.util.function.ToLongFunction toLongFunction) {
        return new java8.util.Comparators$$Lambda$4(toLongFunction);
    }

    @Override // java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.Comparators.lambda$comparingLong$c3a37e6$1(this.arg$1, obj, obj2);
    }
}
