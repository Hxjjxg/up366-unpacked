package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class MatchOps$$Lambda$3 implements java8.util.function.Supplier {
    private final java8.util.stream.MatchOps.MatchKind arg$1;
    private final java8.util.function.LongPredicate arg$2;

    private MatchOps$$Lambda$3(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.LongPredicate longPredicate) {
        this.arg$1 = matchKind;
        this.arg$2 = longPredicate;
    }

    public static java8.util.function.Supplier lambdaFactory$(java8.util.stream.MatchOps.MatchKind matchKind, java8.util.function.LongPredicate longPredicate) {
        return new java8.util.stream.MatchOps$$Lambda$3(matchKind, longPredicate);
    }

    @Override // java8.util.function.Supplier
    public java.lang.Object get() {
        return java8.util.stream.MatchOps.lambda$makeLong$117(this.arg$1, this.arg$2);
    }
}
