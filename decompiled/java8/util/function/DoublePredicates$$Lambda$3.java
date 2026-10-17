package java8.util.function;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final /* synthetic */ class DoublePredicates$$Lambda$3 implements java8.util.function.DoublePredicate {
    private final java8.util.function.DoublePredicate arg$1;
    private final java8.util.function.DoublePredicate arg$2;

    private DoublePredicates$$Lambda$3(java8.util.function.DoublePredicate doublePredicate, java8.util.function.DoublePredicate doublePredicate2) {
        this.arg$1 = doublePredicate;
        this.arg$2 = doublePredicate2;
    }

    /* JADX WARN: Method inline analysis failed
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1685)
    	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1660)
    	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:139)
    	at jadx.core.dex.visitors.MarkMethodsForInline.lambda$unbindSsaVars$0(MarkMethodsForInline.java:150)
    	at jadx.core.dex.nodes.InsnNode.visitArgs(InsnNode.java:339)
    	at jadx.core.dex.visitors.MarkMethodsForInline.unbindSsaVars(MarkMethodsForInline.java:145)
    	at jadx.core.dex.visitors.MarkMethodsForInline.addInlineAttr(MarkMethodsForInline.java:135)
    	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:82)
    	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:55)
    	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:63)
    	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:50)
     */
    public static java8.util.function.DoublePredicate lambdaFactory$(java8.util.function.DoublePredicate doublePredicate, java8.util.function.DoublePredicate doublePredicate2) {
        return new java8.util.function.DoublePredicates$$Lambda$3(doublePredicate, doublePredicate2);
    }

    @Override // java8.util.function.DoublePredicate
    public boolean test(double d) {
        return java8.util.function.DoublePredicates.lambda$or$159(this.arg$1, this.arg$2, d);
    }
}
