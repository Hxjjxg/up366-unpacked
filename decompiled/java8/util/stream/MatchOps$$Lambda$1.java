package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class MatchOps$$Lambda$1 implements java8.util.function.Supplier {
    private final java8.util.stream.MatchOps.MatchKind arg$1;
    private final java8.util.function.Predicate arg$2;

    private MatchOps$$Lambda$1(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.Predicate predicate) {
        this.arg$1 = matchKind;
        this.arg$2 = predicate;
    }

    public static java8.util.function.Supplier lambdaFactory$(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.Predicate predicate) {
        return new java8.util.stream.MatchOps$$Lambda$1(matchKind, predicate);
    }

    @Override // java8.util.function.Supplier
    public java.lang.Object get() {
        return java8.util.stream.MatchOps.lambda$makeRef$115(this.arg$1, this.arg$2);
    }
}
