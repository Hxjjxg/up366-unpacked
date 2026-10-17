package io.objectbox.query;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QueryThreadLocal<T> extends java.lang.ThreadLocal<io.objectbox.query.Query<T>> {
    private final io.objectbox.query.Query<T> original;

    public QueryThreadLocal(io.objectbox.query.Query<T> query) {
        this.original = query;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    public io.objectbox.query.Query<T> initialValue() {
        return this.original.copy();
    }
}
