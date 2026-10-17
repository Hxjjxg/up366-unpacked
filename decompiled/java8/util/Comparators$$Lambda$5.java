package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Comparators$$Lambda$5 implements java.util.Comparator, java.io.Serializable {
    private final java8.util.function.ToDoubleFunction arg$1;

    private Comparators$$Lambda$5(java8.util.function.ToDoubleFunction toDoubleFunction) {
        this.arg$1 = toDoubleFunction;
    }

    public static java.util.Comparator lambdaFactory$(java8.util.function.ToDoubleFunction toDoubleFunction) {
        return new java8.util.Comparators$$Lambda$5(toDoubleFunction);
    }

    @Override // java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.Comparators.lambda$comparingDouble$57709dbc$1(this.arg$1, obj, obj2);
    }
}
