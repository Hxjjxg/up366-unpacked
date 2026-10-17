package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class I {
    private com.chuanglan.shanyan_sdk.J a;
    private long b;
    private boolean c;

    public I(android.content.Context context) {
        this.a = com.chuanglan.shanyan_sdk.J.a(context);
    }

    private synchronized void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized android.database.sqlite.SQLiteDatabase d() {
        return this.a.getWritableDatabase();
    }

    public long b() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long c() throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.d()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            java.lang.String r2 = "select count(*) from cl_jm_behavior"
            android.database.Cursor r0 = r1.rawQuery(r2, r0)     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L39
            r0.moveToFirst()     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L39
            r2 = 0
            long r2 = r0.getLong(r2)     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L39
            r0.close()     // Catch: java.lang.Exception -> L17
            goto L1b
        L17:
            r0 = move-exception
            r0.printStackTrace()
        L1b:
            r4.a(r1)
            return r2
        L1f:
            r2 = move-exception
            goto L26
        L21:
            r2 = move-exception
            r1 = r0
            goto L3a
        L24:
            r2 = move-exception
            r1 = r0
        L26:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L39
            if (r0 == 0) goto L33
            r0.close()     // Catch: java.lang.Exception -> L2f
            goto L33
        L2f:
            r0 = move-exception
            r0.printStackTrace()
        L33:
            r4.a(r1)
            r0 = 0
            return r0
        L39:
            r2 = move-exception
        L3a:
            if (r0 == 0) goto L44
            r0.close()     // Catch: java.lang.Exception -> L40
            goto L44
        L40:
            r0 = move-exception
            r0.printStackTrace()
        L44:
            r4.a(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuanglan.shanyan_sdk.I.c():long");
    }

    public void a(com.chuanglan.shanyan_sdk.C0069z c0069z) throws java.lang.Throwable {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseD;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        if (c0069z != null) {
            try {
                try {
                    sQLiteDatabaseD = d();
                } catch (java.lang.Exception e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("i4", c0069z.a);
                contentValues.put("i8", c0069z.b);
                contentValues.put("i1", c0069z.c);
                contentValues.put("i7", c0069z.d);
                contentValues.put("i9", c0069z.e);
                sQLiteDatabaseD.insertWithOnConflict("cl_jm_device", null, contentValues, 5);
                sQLiteDatabase = sQLiteDatabaseD;
            } catch (java.lang.Exception e2) {
                e = e2;
                sQLiteDatabase = sQLiteDatabaseD;
                e.printStackTrace();
            } catch (java.lang.Throwable th2) {
                th = th2;
                sQLiteDatabase = sQLiteDatabaseD;
                a(sQLiteDatabase);
                throw th;
            }
        }
        a(sQLiteDatabase);
    }

    public void a(com.chuanglan.shanyan_sdk.C0068y c0068y, boolean z) throws java.lang.Throwable {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseD;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        if (c0068y != null) {
            try {
                try {
                    sQLiteDatabaseD = d();
                } catch (java.lang.Exception e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                this.c = true;
                if (z) {
                    java.lang.String str = c0068y.x;
                    long j = c0068y.p;
                    a(str, j, j, sQLiteDatabaseD);
                }
                if (this.c || !z) {
                    android.content.ContentValues contentValues = new android.content.ContentValues();
                    contentValues.put("i4", c0068y.a);
                    contentValues.put("bk", c0068y.b);
                    contentValues.put("bp", java.lang.Integer.valueOf(c0068y.c));
                    contentValues.put("bm", c0068y.d);
                    contentValues.put("b2", c0068y.e);
                    contentValues.put("bc", c0068y.f);
                    contentValues.put("bh", c0068y.g);
                    contentValues.put("ba", c0068y.h);
                    contentValues.put("b7", c0068y.i);
                    contentValues.put(com.igexin.push.core.b.ac, c0068y.j);
                    contentValues.put("b8", c0068y.k);
                    contentValues.put("bg", c0068y.l);
                    contentValues.put("bj", java.lang.Integer.valueOf(c0068y.m));
                    contentValues.put("bb", java.lang.Integer.valueOf(c0068y.n));
                    contentValues.put("bl", java.lang.Long.valueOf(c0068y.o));
                    contentValues.put("b5", java.lang.Long.valueOf(c0068y.p));
                    contentValues.put("b1", java.lang.Long.valueOf(c0068y.q));
                    contentValues.put("b4", java.lang.Integer.valueOf(c0068y.r));
                    contentValues.put("be", java.lang.Integer.valueOf(c0068y.s));
                    contentValues.put("b3", c0068y.t);
                    contentValues.put("b6", java.lang.Integer.valueOf(c0068y.u));
                    contentValues.put("bd", c0068y.v);
                    contentValues.put("b9", java.lang.Integer.valueOf(c0068y.w));
                    contentValues.put("bf", c0068y.x);
                    sQLiteDatabaseD.insert("cl_jm_behavior", null, contentValues);
                }
                sQLiteDatabase = sQLiteDatabaseD;
            } catch (java.lang.Exception e2) {
                e = e2;
                sQLiteDatabase = sQLiteDatabaseD;
                e.printStackTrace();
            } catch (java.lang.Throwable th2) {
                th = th2;
                sQLiteDatabase = sQLiteDatabaseD;
                a(sQLiteDatabase);
                throw th;
            }
        }
        a(sQLiteDatabase);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List a() throws java.lang.Throwable {
        /*
            r12 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r10 = r12.d()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7f
            java.lang.String r8 = "i4 ASC"
            java.lang.String r2 = "cl_jm_device"
            r7 = 0
            r9 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r1 = r10
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L77
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            r2.<init>()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
        L19:
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            if (r3 == 0) goto L64
            com.chuanglan.shanyan_sdk.z r3 = new com.chuanglan.shanyan_sdk.z     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            r3.<init>()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            java.lang.String r4 = "i4"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            r3.a = r4     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            java.lang.String r4 = "i8"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            r3.b = r4     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            java.lang.String r4 = "i1"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            r3.c = r4     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            java.lang.String r4 = "i7"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            r3.d = r4     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            java.lang.String r4 = "i9"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            r3.e = r4     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            r2.add(r3)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L93
            goto L19
        L64:
            r1.close()     // Catch: java.lang.Exception -> L68
            goto L6c
        L68:
            r0 = move-exception
            r0.printStackTrace()
        L6c:
            r12.a(r10)
            return r2
        L70:
            r2 = move-exception
            goto L82
        L72:
            r1 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
            goto L94
        L77:
            r2 = move-exception
            r1 = r0
            goto L82
        L7a:
            r1 = move-exception
            r10 = r0
            r0 = r1
            r1 = r10
            goto L94
        L7f:
            r2 = move-exception
            r1 = r0
            r10 = r1
        L82:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L8f
            r1.close()     // Catch: java.lang.Exception -> L8b
            goto L8f
        L8b:
            r1 = move-exception
            r1.printStackTrace()
        L8f:
            r12.a(r10)
            return r0
        L93:
            r0 = move-exception
        L94:
            if (r1 == 0) goto L9e
            r1.close()     // Catch: java.lang.Exception -> L9a
            goto L9e
        L9a:
            r1 = move-exception
            r1.printStackTrace()
        L9e:
            r12.a(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuanglan.shanyan_sdk.I.a():java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v9 */
    public java.util.List a(java.lang.String str) throws java.lang.Throwable {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseD;
        java.lang.Throwable th;
        android.database.Cursor cursorQuery;
        try {
            try {
                sQLiteDatabaseD = d();
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
            try {
                cursorQuery = sQLiteDatabaseD.query("cl_jm_behavior", null, null, null, null, null, "id ASC", str);
                try {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    while (cursorQuery.moveToNext()) {
                        com.chuanglan.shanyan_sdk.C0068y c0068y = new com.chuanglan.shanyan_sdk.C0068y();
                        c0068y.a = cursorQuery.getString(cursorQuery.getColumnIndex("i4"));
                        c0068y.b = cursorQuery.getString(cursorQuery.getColumnIndex("bk"));
                        c0068y.c = cursorQuery.getInt(cursorQuery.getColumnIndex("bp"));
                        c0068y.d = cursorQuery.getString(cursorQuery.getColumnIndex("bm"));
                        c0068y.e = cursorQuery.getString(cursorQuery.getColumnIndex("b2"));
                        c0068y.f = cursorQuery.getString(cursorQuery.getColumnIndex("bc"));
                        c0068y.g = cursorQuery.getString(cursorQuery.getColumnIndex("bh"));
                        c0068y.h = cursorQuery.getString(cursorQuery.getColumnIndex("ba"));
                        c0068y.i = cursorQuery.getString(cursorQuery.getColumnIndex("b7"));
                        c0068y.j = cursorQuery.getString(cursorQuery.getColumnIndex(com.igexin.push.core.b.ac));
                        c0068y.k = cursorQuery.getString(cursorQuery.getColumnIndex("b8"));
                        c0068y.l = cursorQuery.getString(cursorQuery.getColumnIndex("bg"));
                        c0068y.m = cursorQuery.getInt(cursorQuery.getColumnIndex("bj"));
                        c0068y.n = cursorQuery.getInt(cursorQuery.getColumnIndex("bb"));
                        c0068y.o = cursorQuery.getLong(cursorQuery.getColumnIndex("bl"));
                        c0068y.p = cursorQuery.getLong(cursorQuery.getColumnIndex("b5"));
                        c0068y.q = cursorQuery.getLong(cursorQuery.getColumnIndex("b1"));
                        c0068y.r = cursorQuery.getInt(cursorQuery.getColumnIndex("b4"));
                        c0068y.s = cursorQuery.getInt(cursorQuery.getColumnIndex("be"));
                        c0068y.t = cursorQuery.getString(cursorQuery.getColumnIndex("b3"));
                        c0068y.u = cursorQuery.getInt(cursorQuery.getColumnIndex("b6"));
                        c0068y.v = cursorQuery.getString(cursorQuery.getColumnIndex("bd"));
                        c0068y.w = cursorQuery.getInt(cursorQuery.getColumnIndex("b9"));
                        c0068y.x = cursorQuery.getString(cursorQuery.getColumnIndex("bf"));
                        this.b = cursorQuery.getInt(cursorQuery.getColumnIndex(com.igexin.push.core.b.C));
                        arrayList.add(c0068y);
                    }
                    try {
                        cursorQuery.close();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                    a(sQLiteDatabaseD);
                    return arrayList;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (java.lang.Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    a(sQLiteDatabaseD);
                    return null;
                }
            } catch (java.lang.Exception e4) {
                e = e4;
                cursorQuery = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                str = 0;
                if (str != 0) {
                    try {
                        str.close();
                    } catch (java.lang.Exception e5) {
                        e5.printStackTrace();
                    }
                }
                a(sQLiteDatabaseD);
                throw th;
            }
        } catch (java.lang.Exception e6) {
            e = e6;
            cursorQuery = null;
            sQLiteDatabaseD = null;
        } catch (java.lang.Throwable th4) {
            sQLiteDatabaseD = null;
            th = th4;
            str = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(int r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r7.d()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            java.lang.String r3 = "select count(*) from cl_jm_behavior"
            android.database.Cursor r1 = r2.rawQuery(r3, r1)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L3d
            r1.moveToFirst()     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L3d
            long r3 = r1.getLong(r0)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L3d
            long r5 = (long) r8
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 <= 0) goto L19
            r0 = 1
        L19:
            r1.close()     // Catch: java.lang.Exception -> L1d
            goto L21
        L1d:
            r8 = move-exception
            r8.printStackTrace()
        L21:
            r7.a(r2)
            return r0
        L25:
            r8 = move-exception
            goto L2c
        L27:
            r8 = move-exception
            r2 = r1
            goto L3e
        L2a:
            r8 = move-exception
            r2 = r1
        L2c:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.lang.Exception -> L35
            goto L39
        L35:
            r8 = move-exception
            r8.printStackTrace()
        L39:
            r7.a(r2)
            return r0
        L3d:
            r8 = move-exception
        L3e:
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Exception -> L44
            goto L48
        L44:
            r0 = move-exception
            r0.printStackTrace()
        L48:
            r7.a(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuanglan.shanyan_sdk.I.a(int):boolean");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0188 -> B:36:0x018b). Please report as a decompilation issue!!! */
    private void a(java.lang.String str, long j, long j2, android.database.sqlite.SQLiteDatabase sQLiteDatabase) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.util.ArrayList arrayList;
        android.database.Cursor cursorRawQuery;
        int i;
        android.database.Cursor cursor = null;
        try {
            try {
                try {
                    arrayList = new java.util.ArrayList();
                    cursorRawQuery = sQLiteDatabase.rawQuery("select * from cl_jm_behavior where bf = ?", new java.lang.String[]{java.lang.String.valueOf(str)});
                } catch (java.lang.Exception e) {
                    e = e;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
            try {
                if (cursorRawQuery.moveToLast()) {
                    com.chuanglan.shanyan_sdk.C0068y c0068y = new com.chuanglan.shanyan_sdk.C0068y();
                    c0068y.a = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("i4"));
                    c0068y.b = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("bk"));
                    c0068y.c = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("bp"));
                    c0068y.d = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("bm"));
                    c0068y.e = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("b2"));
                    c0068y.f = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("bc"));
                    c0068y.g = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("bh"));
                    c0068y.h = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ba"));
                    c0068y.i = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("b7"));
                    c0068y.j = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(com.igexin.push.core.b.ac));
                    c0068y.k = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("b8"));
                    c0068y.l = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("bg"));
                    c0068y.m = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("bj"));
                    c0068y.n = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("bb"));
                    c0068y.o = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("bl"));
                    c0068y.p = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("b5"));
                    c0068y.q = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("b1"));
                    c0068y.r = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("b4"));
                    c0068y.s = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("be"));
                    c0068y.t = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("b3"));
                    c0068y.u = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("b6"));
                    c0068y.v = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("bd"));
                    c0068y.w = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("b9"));
                    c0068y.x = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("bf"));
                    arrayList.add(c0068y);
                    i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(com.igexin.push.core.b.C));
                } else {
                    i = 0;
                }
                if (arrayList.size() > 0) {
                    a((com.chuanglan.shanyan_sdk.C0068y) arrayList.get(0), j, j2, i, sQLiteDatabase);
                    this.c = false;
                } else {
                    this.c = true;
                }
                cursorRawQuery.close();
            } catch (java.lang.Exception e2) {
                e = e2;
                cursor = cursorRawQuery;
                e.printStackTrace();
                if (cursor == null) {
                } else {
                    cursor.close();
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                cursor = cursorRawQuery;
                if (cursor != null) {
                    try {
                        cursor.close();
                        throw th;
                    } catch (java.lang.Exception e3) {
                        e3.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(com.chuanglan.shanyan_sdk.C0068y c0068y, long j, long j2, int i, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("b9", java.lang.Integer.valueOf(c0068y.w + 1));
            contentValues.put("b5", java.lang.Long.valueOf(c0068y.p + j));
            contentValues.put("b1", java.lang.Long.valueOf(c0068y.q + j2));
            sQLiteDatabase.update("cl_jm_behavior", contentValues, "id=?", new java.lang.String[]{"" + i});
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void a(long j) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabaseD = null;
        try {
            try {
                sQLiteDatabaseD = d();
                sQLiteDatabaseD.delete("cl_jm_behavior", "id <= ?", new java.lang.String[]{java.lang.String.valueOf(j)});
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } finally {
            a(sQLiteDatabaseD);
        }
    }
}
