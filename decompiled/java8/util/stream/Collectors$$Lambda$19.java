package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class Collectors$$Lambda$19 implements java8.util.function.Supplier {
    private final java.lang.CharSequence arg$1;
    private final java.lang.CharSequence arg$2;
    private final java.lang.CharSequence arg$3;

    private Collectors$$Lambda$19(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        this.arg$1 = charSequence;
        this.arg$2 = charSequence2;
        this.arg$3 = charSequence3;
    }

    public static java8.util.function.Supplier lambdaFactory$(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        return new java8.util.stream.Collectors$$Lambda$19(charSequence, charSequence2, charSequence3);
    }

    @Override // java8.util.function.Supplier
    public java.lang.Object get() {
        return java8.util.stream.Collectors.lambda$joining$12(this.arg$1, this.arg$2, this.arg$3);
    }
}
