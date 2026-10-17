package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class e0 {
    public java.util.concurrent.ExecutorService a;
    public final java.util.Deque<com.zx.a.I8b7.q1.a> b = new java.util.ArrayDeque();
    public final java.util.Deque<com.zx.a.I8b7.q1.a> c = new java.util.ArrayDeque();
    public final java.util.Deque<com.zx.a.I8b7.q1> d = new java.util.ArrayDeque();

    public final void a() {
        java.util.concurrent.ExecutorService executorService;
        if (this.c.size() < 64 && !this.b.isEmpty()) {
            java.util.Iterator<com.zx.a.I8b7.q1.a> it = this.b.iterator();
            while (it.hasNext()) {
                com.zx.a.I8b7.q1.a next = it.next();
                java.util.Iterator<com.zx.a.I8b7.q1.a> it2 = this.c.iterator();
                if (it2.hasNext()) {
                    it2.next().getClass();
                    throw null;
                }
                it.remove();
                this.c.add(next);
                synchronized (this) {
                    if (this.a == null) {
                        this.a = new java.util.concurrent.ThreadPoolExecutor(1, Integer.MAX_VALUE, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), new com.zx.a.I8b7.d0(this));
                    }
                    executorService = this.a;
                }
                executorService.execute(next);
                if (this.c.size() >= 64) {
                    return;
                }
            }
        }
    }

    public final <T> void a(java.util.Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new java.lang.AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                a();
            }
        }
    }
}
