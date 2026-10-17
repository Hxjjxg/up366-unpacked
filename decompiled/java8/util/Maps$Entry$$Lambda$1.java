package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Maps$Entry$$Lambda$1 implements java.util.Comparator, java.io.Serializable {
    private static final java8.util.Maps$Entry$$Lambda$1 instance = new java8.util.Maps$Entry$$Lambda$1();

    private Maps$Entry$$Lambda$1() {
    }

    @Override // java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        return ((java.lang.Comparable) ((java.util.Map.Entry) obj).getKey()).compareTo(((java.util.Map.Entry) obj2).getKey());
    }
}
