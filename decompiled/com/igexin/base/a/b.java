package com.igexin.base.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
final class b implements java.lang.Runnable {
    private static com.igexin.base.a.b b;
    final java.util.List<com.igexin.base.a.c> a = new java.util.ArrayList();

    private b() {
        java.util.concurrent.Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(this, 5L, 5L, java.util.concurrent.TimeUnit.SECONDS);
    }

    public static synchronized com.igexin.base.a.b a() {
        if (b == null) {
            b = new com.igexin.base.a.b();
        }
        return b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x022c A[Catch: all -> 0x0244, TRY_ENTER, TryCatch #3 {all -> 0x0244, blocks: (B:114:0x022c, B:116:0x0232, B:120:0x023a, B:122:0x0240, B:123:0x0243), top: B:134:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f1  */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.igexin.base.a.c] */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v10 */
    /* JADX WARN: Type inference failed for: r27v11 */
    /* JADX WARN: Type inference failed for: r27v12 */
    /* JADX WARN: Type inference failed for: r27v13 */
    /* JADX WARN: Type inference failed for: r27v14 */
    /* JADX WARN: Type inference failed for: r27v15 */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4 */
    /* JADX WARN: Type inference failed for: r27v5 */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r27v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(com.igexin.base.a.c r27) {
        /*
            Method dump skipped, instruction units count: 586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.base.a.b.a(com.igexin.base.a.c):boolean");
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (com.igexin.base.a.c cVar : this.a) {
            if (cVar.isEnabled() && (cVar.a.size() >= cVar.b || android.os.SystemClock.elapsedRealtime() - cVar.d >= cVar.c)) {
                a(cVar);
                cVar.d = android.os.SystemClock.elapsedRealtime();
            }
        }
    }
}
