package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Comparators$$Lambda$2 implements java.util.Comparator, java.io.Serializable {
    private final java8.util.function.Function arg$1;

    private Comparators$$Lambda$2(java8.util.function.Function function) {
        this.arg$1 = function;
    }

    public static java.util.Comparator lambdaFactory$(java8.util.function.Function function) {
        return new java8.util.Comparators$$Lambda$2(function);
    }

    @Override // java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.Comparators.lambda$comparing$628f93f7$1(this.arg$1, obj, obj2);
    }
}
