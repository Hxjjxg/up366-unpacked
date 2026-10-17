package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Comparators$$Lambda$3 implements java.util.Comparator, java.io.Serializable {
    private final java8.util.function.ToIntFunction arg$1;

    private Comparators$$Lambda$3(java8.util.function.ToIntFunction toIntFunction) {
        this.arg$1 = toIntFunction;
    }

    public static java.util.Comparator lambdaFactory$(java8.util.function.ToIntFunction toIntFunction) {
        return new java8.util.Comparators$$Lambda$3(toIntFunction);
    }

    @Override // java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.Comparators.lambda$comparingInt$134fc06a$1(this.arg$1, obj, obj2);
    }
}
