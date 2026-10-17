package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Maps$Entry$$Lambda$3 implements java.util.Comparator, java.io.Serializable {
    private final java.util.Comparator arg$1;

    private Maps$Entry$$Lambda$3(java.util.Comparator comparator) {
        this.arg$1 = comparator;
    }

    public static java.util.Comparator lambdaFactory$(java.util.Comparator comparator) {
        return new java8.util.Maps$Entry$$Lambda$3(comparator);
    }

    @Override // java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        return java8.util.Maps.Entry.lambda$comparingByKey$6d558cbf$1(this.arg$1, (java.util.Map.Entry) obj, (java.util.Map.Entry) obj2);
    }
}
