package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class s {
    public android.net.Network d;
    public android.content.Context e;
    public boolean f = false;
    public com.unicom.online.account.kernel.q b = new com.unicom.online.account.kernel.q();
    public java.util.concurrent.ExecutorService c = java.util.concurrent.Executors.newCachedThreadPool();

    public final void b() {
        if (this.f) {
            return;
        }
        this.f = true;
        com.unicom.online.account.kernel.q qVar = this.b;
        if (qVar != null) {
            qVar.c();
        }
        java.util.concurrent.ExecutorService executorService = this.c;
        if (executorService != null && !executorService.isShutdown()) {
            try {
                this.c.shutdown();
                if (!this.c.awaitTermination(1L, java.util.concurrent.TimeUnit.SECONDS)) {
                    this.c.shutdownNow();
                }
            } catch (java.lang.InterruptedException unused) {
                this.c.shutdownNow();
                java.lang.Thread.currentThread().interrupt();
            }
        }
        this.e = null;
        this.d = null;
    }

    public final void c() {
        if (this.f) {
            throw new java.lang.IllegalStateException("ConnectionPoolManager已释放，不能再次使用");
        }
        if (this.e == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(com.unicom.online.account.kernel.ao.o);
        if (arrayList.isEmpty()) {
            return;
        }
        arrayList.size();
        java.util.concurrent.ExecutorService executorService = this.c;
        if (executorService == null || executorService.isShutdown() || this.c.isTerminated()) {
            this.c = java.util.concurrent.Executors.newCachedThreadPool();
        }
        this.c.execute(new com.unicom.online.account.kernel.r(this, arrayList));
    }

    public final void finalize() throws java.lang.Throwable {
        try {
            b();
        } finally {
            super.finalize();
        }
    }
}
