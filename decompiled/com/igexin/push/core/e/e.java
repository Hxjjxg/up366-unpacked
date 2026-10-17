package com.igexin.push.core.e;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class e implements com.igexin.push.core.e.a {
    private static final java.lang.String b = "RALDataManager";
    private static final int c = 318;
    private static final int d = 300;
    private static volatile com.igexin.push.core.e.e e;
    public final java.util.List<com.igexin.push.core.b.n> a = new java.util.concurrent.CopyOnWriteArrayList();

    /* JADX INFO: renamed from: com.igexin.push.core.e.e$3, reason: invalid class name */
    public class AnonymousClass3 extends com.igexin.push.b.d {
        final /* synthetic */ long a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(android.content.ContentValues contentValues, long j) {
            super(contentValues);
            this.a = j;
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws java.lang.Exception {
            this.d.update(com.igexin.push.core.b.aa, this.h, "id=?", new java.lang.String[]{java.lang.String.valueOf(this.a)});
        }
    }

    private e() {
    }

    private int a(byte b2) {
        java.util.Iterator<com.igexin.push.core.b.n> it = this.a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().c == b2) {
                i++;
            }
        }
        return i;
    }

    public static android.content.ContentValues a(com.igexin.push.core.b.n nVar) {
        if (nVar == null) {
            return null;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.igexin.push.core.b.C, java.lang.Long.valueOf(nVar.a));
        contentValues.put("data", com.igexin.c.b.a.b(nVar.b.getBytes()));
        contentValues.put("type", java.lang.Byte.valueOf(nVar.c));
        contentValues.put("time", java.lang.Long.valueOf(nVar.d));
        contentValues.put("send_times", java.lang.Integer.valueOf(nVar.e));
        return contentValues;
    }

    public static com.igexin.push.core.e.e a() {
        if (e == null) {
            synchronized (com.igexin.push.core.e.e.class) {
                if (e == null) {
                    e = new com.igexin.push.core.e.e();
                }
            }
        }
        return e;
    }

    private boolean a(long j, long j2) {
        com.igexin.push.core.b.n nVarA = a(j);
        if (nVarA == null) {
            return false;
        }
        nVarA.d = j2;
        nVarA.e++;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.e.e.AnonymousClass3(a(nVarA), j), true, true);
        return true;
    }

    private java.util.List<com.igexin.push.core.b.n> b() {
        return this.a;
    }

    private void b(byte b2) {
        com.igexin.push.core.b.n next;
        try {
            java.util.Iterator<com.igexin.push.core.b.n> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (next.c == b2) {
                        break;
                    }
                }
            }
            if (next != null) {
                a(next.a, true);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final com.igexin.push.core.b.n a(long j) {
        for (com.igexin.push.core.b.n nVar : this.a) {
            if (nVar.a == j) {
                return nVar;
            }
        }
        return null;
    }

    public final void a(final long j, boolean z) {
        com.igexin.push.core.b.n nVarA = a(j);
        if (nVarA != null) {
            this.a.remove(nVarA);
        }
        com.igexin.c.a.b.e.a().a(new com.igexin.push.b.d(a(nVarA)) { // from class: com.igexin.push.core.e.e.2
            @Override // com.igexin.push.b.d
            public final void a_() throws java.lang.Exception {
                this.d.delete(com.igexin.push.core.b.aa, "id=?", new java.lang.String[]{java.lang.String.valueOf(j)});
            }
        }, z, !z);
    }

    @Override // com.igexin.push.core.e.a
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query(com.igexin.push.core.b.aa, new java.lang.String[]{com.igexin.push.core.b.C, "data", "type", "time", "send_times"}, null, null, null, null, null);
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(0);
                        byte b2 = (byte) cursorQuery.getInt(2);
                        long j2 = cursorQuery.getLong(3);
                        int i = cursorQuery.getInt(4);
                        if ((j2 == 0 || jCurrentTimeMillis - j2 <= 259200000) && i < com.igexin.push.config.d.N - 1) {
                            java.util.List<com.igexin.push.core.b.n> list = this.a;
                            com.igexin.push.core.b.n nVar = new com.igexin.push.core.b.n(j, new java.lang.String(com.igexin.c.b.a.c(cursorQuery.getBlob(1))), b2, j2);
                            nVar.e = i;
                            list.add(nVar);
                        } else {
                            a(j, true);
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (java.lang.Exception e2) {
                com.igexin.c.a.c.a.a(e2);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (java.lang.Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(final com.igexin.push.core.b.n r5) {
        /*
            r4 = this;
            java.util.List<com.igexin.push.core.b.n> r0 = r4.a
            int r0 = r0.size()
            r1 = 318(0x13e, float:4.46E-43)
            r2 = 7
            r3 = 2
            if (r0 < r1) goto L15
            byte r0 = r5.c
            if (r0 == r3) goto L15
            byte r0 = r5.c
            if (r0 == r2) goto L15
            return
        L15:
            byte r0 = r5.c
            if (r0 == r3) goto L49
            r1 = 3
            if (r0 == r1) goto L40
            r3 = 5
            if (r0 == r3) goto L39
            r3 = 6
            if (r0 == r3) goto L30
            if (r0 == r2) goto L49
            r2 = 8
            if (r0 == r2) goto L29
            goto L4e
        L29:
            int r0 = r4.a(r2)
            if (r0 < r1) goto L4e
            return
        L30:
            int r0 = r4.a(r3)
            r1 = 10
            if (r0 < r1) goto L4e
            return
        L39:
            int r0 = r4.a(r3)
            if (r0 < r1) goto L4e
            return
        L40:
            int r0 = r4.a(r1)
            r1 = 300(0x12c, float:4.2E-43)
            if (r0 < r1) goto L4e
            return
        L49:
            byte r0 = r5.c
            r4.b(r0)
        L4e:
            java.util.List<com.igexin.push.core.b.n> r0 = r4.a
            r0.add(r5)
            com.igexin.c.a.b.e r0 = com.igexin.c.a.b.e.a()
            com.igexin.push.core.e.e$1 r1 = new com.igexin.push.core.e.e$1
            android.content.ContentValues r2 = a(r5)
            r1.<init>(r2)
            r5 = 0
            r2 = 1
            r0.a(r1, r5, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.e.e.b(com.igexin.push.core.b.n):void");
    }

    @Override // com.igexin.push.core.e.a
    public final void c(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }
}
