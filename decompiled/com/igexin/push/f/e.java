package com.igexin.push.f;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class e implements com.igexin.push.f.b.c {
    private static volatile com.igexin.push.f.e c;
    public java.lang.String a = "ReDisplayTask";
    public volatile long b = 0;

    public static com.igexin.push.f.e a() {
        if (c == null) {
            synchronized (com.igexin.push.f.e.class) {
                if (c == null) {
                    c = new com.igexin.push.f.e();
                }
            }
        }
        return c;
    }

    private void c() {
        android.database.Cursor cursorA = null;
        try {
            cursorA = com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[0], "status = '1' and notify_status = '1' and redisplay_freq != '0' and redisplay_num <= redisplay_freq  order by expect_redisplay_time asc limit 1");
            if (cursorA != null && cursorA.getCount() == 1 && cursorA.moveToFirst()) {
                this.b = cursorA.getLong(cursorA.getColumnIndex("expect_redisplay_time"));
            } else {
                this.b = Long.MAX_VALUE;
            }
            java.lang.System.currentTimeMillis();
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.b(this.a, " get next redisplay message fail" + th.toString());
                if (cursorA != null) {
                    cursorA.close();
                }
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0083 A[DONT_GENERATE, PHI: r1
  0x0083: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v3 android.database.Cursor) binds: [B:13:0x0081, B:9:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.PriorityQueue<com.igexin.push.core.b.k> e() {
        /*
            r10 = this;
            java.util.PriorityQueue r0 = new java.util.PriorityQueue
            r0.<init>()
            r1 = 0
            com.igexin.push.core.d r2 = com.igexin.push.core.d.a.a()     // Catch: java.lang.Throwable -> L66
            com.igexin.push.b.b r2 = r2.i     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = "message"
            r4 = 0
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L66
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66
            java.lang.String r6 = "status = '1' and notify_status = '1' and redisplay_freq != '0' and redisplay_num <= redisplay_freq and expect_redisplay_time <= "
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L66
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L66
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            r5.append(r6)     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L66
            android.database.Cursor r1 = r2.a(r3, r4, r5)     // Catch: java.lang.Throwable -> L66
            if (r1 == 0) goto L63
        L2d:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L66
            if (r2 == 0) goto L63
            java.lang.String r2 = "msgextra"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L66
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = "expect_redisplay_time"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L66
            long r3 = r1.getLong(r3)     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L66
            java.lang.String r6 = "info"
            int r6 = r1.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L66
            byte[] r6 = r1.getBlob(r6)     // Catch: java.lang.Throwable -> L66
            byte[] r6 = com.igexin.c.b.a.c(r6)     // Catch: java.lang.Throwable -> L66
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L66
            com.igexin.push.core.b.k r6 = new com.igexin.push.core.b.k     // Catch: java.lang.Throwable -> L66
            r6.<init>(r2, r5, r3)     // Catch: java.lang.Throwable -> L66
            r0.offer(r6)     // Catch: java.lang.Throwable -> L66
            goto L2d
        L63:
            if (r1 == 0) goto L86
            goto L83
        L66:
            r2 = move-exception
            com.igexin.c.a.c.a.a(r2)     // Catch: java.lang.Throwable -> L87
            java.lang.String r3 = r10.a     // Catch: java.lang.Throwable -> L87
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L87
            java.lang.String r5 = "get redisplay message"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L87
            r4.append(r2)     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L87
            com.igexin.c.a.c.a.b(r3, r2)     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L86
        L83:
            r1.close()
        L86:
            return r0
        L87:
            r0 = move-exception
            if (r1 == 0) goto L8d
            r1.close()
        L8d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.e.e():java.util.PriorityQueue");
    }

    @Override // com.igexin.push.f.b.c
    public final void a(long j) {
    }

    @Override // com.igexin.push.f.b.c
    public final void b() {
        if (com.igexin.push.g.c.a(java.lang.System.currentTimeMillis())) {
            com.igexin.c.a.c.a.b(this.a, "message in silent time period, ignored...");
        } else {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.d() { // from class: com.igexin.push.f.e.1
                /* JADX WARN: Removed duplicated region for block: B:16:0x0093 A[Catch: all -> 0x00a6, TryCatch #0 {all -> 0x00a6, blocks: (B:5:0x003a, B:7:0x005c, B:9:0x0070, B:11:0x007c, B:12:0x007e, B:13:0x0082, B:15:0x0090, B:16:0x0093, B:18:0x009b, B:19:0x009e), top: B:24:0x003a }] */
                /* JADX WARN: Removed duplicated region for block: B:30:0x0090 A[SYNTHETIC] */
                @Override // com.igexin.push.f.d
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                protected final void b() {
                    /*
                        r8 = this;
                        com.igexin.push.f.e r0 = com.igexin.push.f.e.this
                        java.util.PriorityQueue r0 = com.igexin.push.f.e.a(r0)
                        com.igexin.push.f.e r1 = com.igexin.push.f.e.this
                        com.igexin.push.f.e.b(r1)
                        r0.size()
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        com.igexin.push.f.e r2 = com.igexin.push.f.e.this
                        java.lang.String r2 = com.igexin.push.f.e.b(r2)
                        r1.append(r2)
                        java.lang.String r2 = " | priorityQueue size = "
                        r1.append(r2)
                        int r2 = r0.size()
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r2 = 0
                        java.lang.Object[] r3 = new java.lang.Object[r2]
                        com.igexin.c.a.c.a.a(r1, r3)
                    L32:
                        java.lang.Object r1 = r0.poll()
                        com.igexin.push.core.b.k r1 = (com.igexin.push.core.b.k) r1
                        if (r1 == 0) goto Lb0
                        org.json.JSONObject r3 = r1.a()     // Catch: java.lang.Throwable -> La6
                        java.lang.String r4 = "taskid"
                        java.lang.String r4 = r3.getString(r4)     // Catch: java.lang.Throwable -> La6
                        java.lang.String r5 = "messageid"
                        java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> La6
                        com.igexin.push.core.a.b.d()     // Catch: java.lang.Throwable -> La6
                        java.lang.String r6 = com.igexin.push.core.a.b.a(r4, r5)     // Catch: java.lang.Throwable -> La6
                        java.util.Map<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> r7 = com.igexin.push.core.e.ah     // Catch: java.lang.Throwable -> La6
                        java.lang.Object r7 = r7.get(r6)     // Catch: java.lang.Throwable -> La6
                        com.igexin.push.extension.mod.PushTaskBean r7 = (com.igexin.push.extension.mod.PushTaskBean) r7     // Catch: java.lang.Throwable -> La6
                        if (r7 != 0) goto L82
                        com.igexin.push.core.n r7 = com.igexin.push.core.n.a()     // Catch: java.lang.Throwable -> La6
                        byte[] r1 = r1.f     // Catch: java.lang.Throwable -> La6
                        r7.a(r3, r1, r2)     // Catch: java.lang.Throwable -> La6
                        java.util.Map<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> r1 = com.igexin.push.core.e.ah     // Catch: java.lang.Throwable -> La6
                        java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> La6
                        r7 = r1
                        com.igexin.push.extension.mod.PushTaskBean r7 = (com.igexin.push.extension.mod.PushTaskBean) r7     // Catch: java.lang.Throwable -> La6
                        if (r7 == 0) goto L7c
                        com.igexin.push.core.n r1 = com.igexin.push.core.n.a()     // Catch: java.lang.Throwable -> La6
                        com.igexin.push.extension.mod.PushMessageInterface$ActionPrepareState r1 = r1.b(r4, r5)     // Catch: java.lang.Throwable -> La6
                        com.igexin.push.extension.mod.PushMessageInterface$ActionPrepareState r3 = com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success     // Catch: java.lang.Throwable -> La6
                        if (r1 == r3) goto L82
                    L7c:
                        com.igexin.push.f.e r1 = com.igexin.push.f.e.this     // Catch: java.lang.Throwable -> La6
                    L7e:
                        com.igexin.push.f.e.b(r1)     // Catch: java.lang.Throwable -> La6
                        goto L32
                    L82:
                        com.igexin.push.core.n r1 = com.igexin.push.core.n.a()     // Catch: java.lang.Throwable -> La6
                        java.util.Map r3 = r7.getConditionMap()     // Catch: java.lang.Throwable -> La6
                        boolean r1 = r1.a(r3, r4, r7)     // Catch: java.lang.Throwable -> La6
                        if (r1 != 0) goto L93
                        com.igexin.push.f.e r1 = com.igexin.push.f.e.this     // Catch: java.lang.Throwable -> La6
                        goto L7e
                    L93:
                        java.lang.String r1 = "notification"
                        java.lang.String r1 = r7.getActionIdByType(r1)     // Catch: java.lang.Throwable -> La6
                        if (r1 != 0) goto L9e
                        com.igexin.push.f.e r1 = com.igexin.push.f.e.this     // Catch: java.lang.Throwable -> La6
                        goto L7e
                    L9e:
                        com.igexin.push.core.n r3 = com.igexin.push.core.n.a()     // Catch: java.lang.Throwable -> La6
                        r3.a(r4, r5, r1)     // Catch: java.lang.Throwable -> La6
                        goto L32
                    La6:
                        r1 = move-exception
                        com.igexin.push.f.e r3 = com.igexin.push.f.e.this
                        com.igexin.push.f.e.b(r3)
                        com.igexin.c.a.c.a.a(r1)
                        goto L32
                    Lb0:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.e.AnonymousClass1.b():void");
                }
            }, true);
        }
    }

    @Override // com.igexin.push.f.b.c
    public final boolean d() {
        boolean z = java.lang.System.currentTimeMillis() / 1000 >= this.b;
        com.igexin.c.a.c.a.a(this.a + " | ReDisplayTask isMatch =" + z + "， nextReDisplayTime =" + this.b, new java.lang.Object[0]);
        return z;
    }
}
