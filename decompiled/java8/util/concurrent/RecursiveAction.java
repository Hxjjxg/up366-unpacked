package java8.util.concurrent;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class RecursiveAction extends java8.util.concurrent.ForkJoinTask<java.lang.Void> {
    private static final long serialVersionUID = 5232453952276485070L;

    protected abstract void compute();

    @Override // java8.util.concurrent.ForkJoinTask
    public final java.lang.Void getRawResult() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java8.util.concurrent.ForkJoinTask
    public final void setRawResult(java.lang.Void r1) {
    }

    @Override // java8.util.concurrent.ForkJoinTask
    protected final boolean exec() {
        compute();
        return true;
    }
}
