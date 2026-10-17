package com.cmic.gen.sdk;

/* JADX INFO: compiled from: ConnectionInterceptor.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class j implements com.cmic.gen.sdk.a0 {
    private static com.cmic.gen.sdk.m1 a;

    /* JADX INFO: compiled from: ConnectionInterceptor.java */
    class a implements javax.net.ssl.HostnameVerifier {
        final /* synthetic */ java.lang.String a;

        a(java.lang.String str) {
            this.a = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
            return javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, sSLSession);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(33:0|2|(5:159|3|4|158|5)|(27:9|(1:11)|13|(1:15)(1:16)|17|152|18|(3:20|(2:23|21)|163)|24|(1:(1:31)(1:32))|33|(1:35)|36|37|(3:39|150|40)(1:41)|42|161|43|44|156|45|(2:46|(3:48|154|49)(1:164))|50|51|(1:53)(1:54)|55|(2:62|165)(3:61|123|166))|12|13|(0)(0)|17|152|18|(0)|24|(2:26|(0)(0))|33|(0)|36|37|(0)(0)|42|161|43|44|156|45|(3:46|(0)(0)|49)|50|51|(0)(0)|55|(1:57)|62|165|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(37:0|2|159|3|4|158|5|(27:9|(1:11)|13|(1:15)(1:16)|17|152|18|(3:20|(2:23|21)|163)|24|(1:(1:31)(1:32))|33|(1:35)|36|37|(3:39|150|40)(1:41)|42|161|43|44|156|45|(2:46|(3:48|154|49)(1:164))|50|51|(1:53)(1:54)|55|(2:62|165)(3:61|123|166))|12|13|(0)(0)|17|152|18|(0)|24|(2:26|(0)(0))|33|(0)|36|37|(0)(0)|42|161|43|44|156|45|(3:46|(0)(0)|49)|50|51|(0)(0)|55|(1:57)|62|165|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01ef, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01f2, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01f3, code lost:
    
        r18 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01f8, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01fa, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01fb, code lost:
    
        r18 = "remote_ip";
        r16 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0208, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0209, code lost:
    
        r13 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x020c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x020d, code lost:
    
        r18 = "remote_ip";
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x025c A[Catch: all -> 0x02cb, TryCatch #5 {all -> 0x02cb, blocks: (B:102:0x0258, B:104:0x025c, B:106:0x0264, B:108:0x026c), top: B:146:0x0258 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007c A[Catch: all -> 0x0210, Exception -> 0x0212, TryCatch #12 {Exception -> 0x0212, all -> 0x0210, blocks: (B:5:0x004d, B:7:0x0053, B:13:0x0076, B:15:0x007c, B:16:0x0096, B:9:0x0057, B:11:0x0061), top: B:158:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0189 A[EDGE_INSN: B:164:0x0189->B:50:0x0189 BREAK  A[LOOP:1: B:46:0x0173->B:49:0x017b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0096 A[Catch: all -> 0x0210, Exception -> 0x0212, TRY_LEAVE, TryCatch #12 {Exception -> 0x0212, all -> 0x0210, blocks: (B:5:0x004d, B:7:0x0053, B:13:0x0076, B:15:0x007c, B:16:0x0096, B:9:0x0057, B:11:0x0061), top: B:158:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b2 A[Catch: all -> 0x0208, Exception -> 0x020c, TryCatch #15 {Exception -> 0x020c, all -> 0x0208, blocks: (B:18:0x00ac, B:20:0x00b2, B:21:0x00ba, B:23:0x00c0, B:24:0x00d6, B:26:0x00da, B:28:0x00de, B:31:0x00e4, B:32:0x0117, B:33:0x011e, B:35:0x0140, B:36:0x0149, B:39:0x0153), top: B:152:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e4 A[Catch: all -> 0x0208, Exception -> 0x020c, TryCatch #15 {Exception -> 0x020c, all -> 0x0208, blocks: (B:18:0x00ac, B:20:0x00b2, B:21:0x00ba, B:23:0x00c0, B:24:0x00d6, B:26:0x00da, B:28:0x00de, B:31:0x00e4, B:32:0x0117, B:33:0x011e, B:35:0x0140, B:36:0x0149, B:39:0x0153), top: B:152:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0117 A[Catch: all -> 0x0208, Exception -> 0x020c, TryCatch #15 {Exception -> 0x020c, all -> 0x0208, blocks: (B:18:0x00ac, B:20:0x00b2, B:21:0x00ba, B:23:0x00c0, B:24:0x00d6, B:26:0x00da, B:28:0x00de, B:31:0x00e4, B:32:0x0117, B:33:0x011e, B:35:0x0140, B:36:0x0149, B:39:0x0153), top: B:152:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0140 A[Catch: all -> 0x0208, Exception -> 0x020c, TryCatch #15 {Exception -> 0x020c, all -> 0x0208, blocks: (B:18:0x00ac, B:20:0x00b2, B:21:0x00ba, B:23:0x00c0, B:24:0x00d6, B:26:0x00da, B:28:0x00de, B:31:0x00e4, B:32:0x0117, B:33:0x011e, B:35:0x0140, B:36:0x0149, B:39:0x0153), top: B:152:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0153 A[Catch: all -> 0x0208, Exception -> 0x020c, TRY_ENTER, TRY_LEAVE, TryCatch #15 {Exception -> 0x020c, all -> 0x0208, blocks: (B:18:0x00ac, B:20:0x00b2, B:21:0x00ba, B:23:0x00c0, B:24:0x00d6, B:26:0x00da, B:28:0x00de, B:31:0x00e4, B:32:0x0117, B:33:0x011e, B:35:0x0140, B:36:0x0149, B:39:0x0153), top: B:152:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01be  */
    @Override // com.cmic.gen.sdk.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.cmic.gen.sdk.x r22, com.cmic.gen.sdk.b0 r23, com.cmic.gen.sdk.i r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.gen.sdk.j.a(com.cmic.gen.sdk.x, com.cmic.gen.sdk.b0, com.cmic.gen.sdk.i):void");
    }

    private void a(com.cmic.gen.sdk.x xVar, com.cmic.gen.sdk.i iVar) {
        if (xVar.j().contains("uniConfig")) {
            return;
        }
        com.cmic.gen.sdk.x1.b(iVar, java.lang.String.valueOf(android.os.SystemClock.elapsedRealtime() - xVar.h()));
    }

    private void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    private java.lang.String a() {
        return com.cmic.gen.sdk.k.a[0] + "." + com.cmic.gen.sdk.k.a[2] + "." + com.cmic.gen.sdk.k.a[4] + "." + com.cmic.gen.sdk.k.a[6];
    }

    public synchronized javax.net.ssl.SSLSocketFactory a(com.cmic.gen.sdk.y0 y0Var, com.cmic.gen.sdk.i iVar) {
        if (y0Var instanceof com.cmic.gen.sdk.s) {
            com.cmic.gen.sdk.m1 m1Var = new com.cmic.gen.sdk.m1(javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory(), iVar);
            if (a == null) {
                a = m1Var;
            }
            return m1Var;
        }
        if (a == null) {
            a = new com.cmic.gen.sdk.m1(javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory(), iVar);
        }
        return a;
    }
}
