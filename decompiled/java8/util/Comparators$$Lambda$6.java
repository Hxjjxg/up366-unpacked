package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Comparators$$Lambda$6 implements java.util.Comparator, java.io.Serializable {
    private final java.util.Comparator arg$1;
    private final java.util.Comparator arg$2;

    private Comparators$$Lambda$6(java.util.Comparator comparator, java.util.Comparator comparator2) {
        this.arg$1 = comparator;
        this.arg$2 = comparator2;
    }

    public static java.util.Comparator lambdaFactory$(java.util.Comparator comparator, java.util.Comparator comparator2) {
        return new java8.util.Comparators$$Lambda$6(comparator, comparator2);
    }

    @Override // java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.Comparators.lambda$thenComparing$aafead48$1(this.arg$1, this.arg$2, obj, obj2);
    }
}
