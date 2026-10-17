package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class az {
    public final android.content.Context c;
    public final com.unicom.online.account.kernel.ab e;
    public final com.unicom.online.account.kernel.s f;
    public final java.util.concurrent.atomic.AtomicBoolean g;
    public final int h;
    public int b = 0;
    public java.lang.String d = com.unicom.online.account.kernel.j.b;

    public az(android.content.Context context, com.unicom.online.account.kernel.ab abVar, com.unicom.online.account.kernel.s sVar, java.util.concurrent.atomic.AtomicBoolean atomicBoolean, int i) {
        this.c = context;
        this.e = abVar;
        this.f = sVar;
        this.g = atomicBoolean;
        this.h = i;
    }

    public static void b(com.unicom.online.account.kernel.s sVar, java.lang.Object obj) {
        android.net.Network network;
        try {
            if (sVar.f) {
                throw new java.lang.IllegalStateException("ConnectionPoolManager已释放，不能再次使用");
            }
            com.unicom.online.account.kernel.q qVar = sVar.b;
            if (qVar != null) {
                qVar.b();
            }
            com.unicom.online.account.kernel.q qVar2 = sVar.b;
            if (qVar2 != null) {
                qVar2.c();
            }
            sVar.b = new com.unicom.online.account.kernel.q();
            try {
                network = (android.net.Network) obj;
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
            if (sVar.f) {
                throw new java.lang.IllegalStateException("ConnectionPoolManager已释放，不能再次使用");
            }
            sVar.d = network;
            sVar.c();
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    public final boolean b() {
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        if (i2 <= 2) {
            try {
                java.lang.Thread.sleep(java.lang.Math.min(((long) java.lang.Math.pow(2.0d, i)) * 100, 400L));
                return true;
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
            }
        }
        return false;
    }

    public final com.unicom.online.account.kernel.ax b(java.lang.Object obj) {
        if (obj != null) {
            try {
                this.e.b();
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
        int iC = com.unicom.online.account.kernel.au.c(this.c.getApplicationContext());
        java.lang.String str = com.unicom.online.account.kernel.ao.b;
        java.lang.Object[] objArr = {null};
        if (iC == 1) {
            java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
            try {
                this.e.b(this.c, new com.unicom.online.account.kernel.aw(objArr, countDownLatch));
                countDownLatch.await(2500L, java.util.concurrent.TimeUnit.MILLISECONDS);
                java.lang.Object obj2 = objArr[0];
                if (obj2 != null) {
                    return new com.unicom.online.account.kernel.ax(obj2, true);
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                e2.getMessage();
            }
        } else if (iC == 0) {
            objArr[0] = null;
            return new com.unicom.online.account.kernel.ax(null, true);
        }
        return new com.unicom.online.account.kernel.ax(null, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.unicom.online.account.kernel.ay b(java.lang.String r7) {
        /*
            java.lang.String r0 = "callDepth"
            java.lang.String r1 = "data"
            java.lang.String r2 = "requestUrl:"
            r3 = 0
            if (r7 != 0) goto La
            return r3
        La:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L66
            r4.<init>(r7)     // Catch: java.lang.Exception -> L66
            boolean r7 = r4.has(r1)     // Catch: java.lang.Exception -> L66
            if (r7 == 0) goto L52
            java.lang.String r7 = ""
            java.lang.String r7 = r4.optString(r1, r7)     // Catch: java.lang.Exception -> L66
            boolean r1 = r7.contains(r2)     // Catch: java.lang.Exception -> L66
            java.lang.String r5 = "requestUrl->"
            if (r1 != 0) goto L29
            boolean r1 = r7.contains(r5)     // Catch: java.lang.Exception -> L66
            if (r1 == 0) goto L52
        L29:
            int r1 = r7.indexOf(r2)     // Catch: java.lang.Exception -> L66
            r6 = -1
            if (r1 == r6) goto L37
            int r1 = r7.indexOf(r2)     // Catch: java.lang.Exception -> L66
            int r1 = r1 + 11
            goto L3d
        L37:
            int r1 = r7.indexOf(r5)     // Catch: java.lang.Exception -> L66
            int r1 = r1 + 12
        L3d:
            java.lang.String r2 = "\n"
            int r2 = r7.indexOf(r2, r1)     // Catch: java.lang.Exception -> L66
            if (r2 != r6) goto L49
            int r2 = r7.length()     // Catch: java.lang.Exception -> L66
        L49:
            java.lang.String r7 = r7.substring(r1, r2)     // Catch: java.lang.Exception -> L66
            java.lang.String r7 = r7.trim()     // Catch: java.lang.Exception -> L66
            goto L53
        L52:
            r7 = r3
        L53:
            boolean r1 = r4.has(r0)     // Catch: java.lang.Exception -> L66
            r2 = 0
            if (r1 == 0) goto L5e
            int r2 = r4.optInt(r0, r2)     // Catch: java.lang.Exception -> L66
        L5e:
            if (r7 == 0) goto L6a
            com.unicom.online.account.kernel.ay r0 = new com.unicom.online.account.kernel.ay     // Catch: java.lang.Exception -> L66
            r0.<init>(r7, r2)     // Catch: java.lang.Exception -> L66
            return r0
        L66:
            r7 = move-exception
            r7.getMessage()
        L6a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unicom.online.account.kernel.az.b(java.lang.String):com.unicom.online.account.kernel.ay");
    }

    public final java.lang.String b(java.lang.String str, int i) {
        java.lang.String str2;
        java.lang.String strB = com.unicom.online.account.kernel.j.b(this.c, com.unicom.online.account.kernel.au.b());
        java.lang.String str3 = this.d;
        if (str3 == null || !str3.equals(strB)) {
            try {
                str2 = com.unicom.online.account.kernel.ao.b(i) + com.unicom.online.account.kernel.aj.b(com.unicom.online.account.kernel.i.b(this.c, i));
            } catch (java.lang.Exception e) {
                e.getMessage();
                str2 = null;
            }
            if (str2 != null && !str2.isEmpty()) {
                "RetryController: 由于私网IP变化，URL已重新生成: ".concat(str2);
                str = str2;
            }
            this.d = strB;
        }
        return str;
    }
}
