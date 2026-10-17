package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class MatchOps$$Lambda$4 implements java8.util.function.Supplier {
    private final java8.util.stream.MatchOps.MatchKind arg$1;
    private final java8.util.function.DoublePredicate arg$2;

    private MatchOps$$Lambda$4(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.DoublePredicate doublePredicate) {
        this.arg$1 = matchKind;
        this.arg$2 = doublePredicate;
    }

    public static java8.util.function.Supplier lambdaFactory$(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.DoublePredicate doublePredicate) {
        return new java8.util.stream.MatchOps$$Lambda$4(matchKind, doublePredicate);
    }

    @Override // java8.util.function.Supplier
    public java.lang.Object get() {
        return java8.util.stream.MatchOps.lambda$makeDouble$118(this.arg$1, this.arg$2);
    }
}
