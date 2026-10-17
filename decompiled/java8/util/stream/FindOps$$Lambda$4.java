package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class FindOps$$Lambda$4 implements java8.util.function.Predicate {
    private static final java8.util.stream.FindOps$$Lambda$4 instance = new java8.util.stream.FindOps$$Lambda$4();

    private FindOps$$Lambda$4() {
    }

    @Override // java8.util.function.Predicate
    public boolean test(java.lang.Object obj) {
        return ((java8.util.OptionalDouble) obj).isPresent();
    }
}
