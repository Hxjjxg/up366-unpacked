package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class h4 extends com.zx.a.I8b7.f {
    public android.database.sqlite.SQLiteDatabase b = null;

    @Override // com.zx.a.I8b7.f
    public java.lang.String a() {
        return "CREATE TABLE IF NOT EXISTS zx_table (key integer primary key, value text)";
    }

    public void b(int i) {
        if (i != com.zx.a.I8b7.x3.t) {
            com.zx.a.I8b7.x3.t = i;
            com.zx.a.I8b7.x3.v = -1;
            a(14, com.zx.a.I8b7.x3.t + "", false);
            a(7, com.zx.a.I8b7.x3.v + "", false);
        }
    }

    @Override // com.zx.a.I8b7.f
    public java.lang.String c() {
        return "zx_table";
    }

    public void d(int i) {
        if (i != com.zx.a.I8b7.x3.p) {
            com.zx.a.I8b7.x3.p = i;
            com.zx.a.I8b7.w2.a.a.a.a(3, com.zx.a.I8b7.x3.p + "", false);
            java.lang.StringBuilder sb = new java.lang.StringBuilder("syncId had changed refresh:");
            sb.append(i);
            com.zx.a.I8b7.c3.a(sb.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a A[DONT_GENERATE, PHI: r1
  0x003a: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v3 android.database.Cursor) binds: [B:12:0x0038, B:8:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int e() {
        /*
            r11 = this;
            java.lang.String r0 = "value"
            r1 = 0
            java.lang.String r2 = "key"
            java.lang.String[] r5 = new java.lang.String[]{r2, r0}     // Catch: java.lang.Throwable -> L34
            java.lang.String r6 = "key=20"
            android.database.sqlite.SQLiteDatabase r3 = r11.b()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = r11.c()     // Catch: java.lang.Throwable -> L34
            r9 = 0
            r10 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L31
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L31
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L34
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L34
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L34
            com.zx.a.I8b7.x3.u = r0     // Catch: java.lang.Throwable -> L34
        L31:
            if (r1 == 0) goto L3d
            goto L3a
        L34:
            r0 = move-exception
            com.zx.a.I8b7.c3.a(r0)     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L3d
        L3a:
            r1.close()
        L3d:
            int r0 = com.zx.a.I8b7.x3.u
            return r0
        L40:
            r0 = move-exception
            if (r1 == 0) goto L46
            r1.close()
        L46:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.h4.e():int");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a A[DONT_GENERATE, PHI: r1
  0x003a: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v3 android.database.Cursor) binds: [B:12:0x0038, B:8:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int f() {
        /*
            r11 = this;
            java.lang.String r0 = "value"
            r1 = 0
            java.lang.String r2 = "key"
            java.lang.String[] r5 = new java.lang.String[]{r2, r0}     // Catch: java.lang.Throwable -> L34
            java.lang.String r6 = "key=14"
            android.database.sqlite.SQLiteDatabase r3 = r11.b()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = r11.c()     // Catch: java.lang.Throwable -> L34
            r9 = 0
            r10 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L31
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L31
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L34
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L34
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L34
            com.zx.a.I8b7.x3.t = r0     // Catch: java.lang.Throwable -> L34
        L31:
            if (r1 == 0) goto L3d
            goto L3a
        L34:
            r0 = move-exception
            com.zx.a.I8b7.c3.a(r0)     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L3d
        L3a:
            r1.close()
        L3d:
            int r0 = com.zx.a.I8b7.x3.t
            return r0
        L40:
            r0 = move-exception
            if (r1 == 0) goto L46
            r1.close()
        L46:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.h4.f():int");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[DONT_GENERATE, PHI: r1 r2
  0x0043: PHI (r1v1 javax.crypto.spec.IvParameterSpec) = (r1v0 javax.crypto.spec.IvParameterSpec), (r1v4 javax.crypto.spec.IvParameterSpec) binds: [B:16:0x0041, B:11:0x0039] A[DONT_GENERATE, DONT_INLINE]
  0x0043: PHI (r2v2 android.database.Cursor) = (r2v1 android.database.Cursor), (r2v4 android.database.Cursor) binds: [B:16:0x0041, B:11:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public javax.crypto.spec.IvParameterSpec g() {
        /*
            r11 = this;
            java.lang.String r0 = "value"
            r1 = 0
            java.lang.String r2 = "key"
            java.lang.String[] r5 = new java.lang.String[]{r2, r0}     // Catch: java.lang.Throwable -> L3c
            java.lang.String r6 = "key=10"
            android.database.sqlite.SQLiteDatabase r3 = r11.b()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r4 = r11.c()     // Catch: java.lang.Throwable -> L3c
            r9 = 0
            r10 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L39
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L37
            if (r3 == 0) goto L39
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L37
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> L37
            r3 = 0
            byte[] r0 = android.util.Base64.decode(r0, r3)     // Catch: java.lang.Throwable -> L37
            javax.crypto.spec.IvParameterSpec r3 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Throwable -> L37
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L37
            r1 = r3
            goto L39
        L37:
            r0 = move-exception
            goto L3e
        L39:
            if (r2 == 0) goto L46
            goto L43
        L3c:
            r0 = move-exception
            r2 = r1
        L3e:
            com.zx.a.I8b7.c3.a(r0)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L46
        L43:
            r2.close()
        L46:
            return r1
        L47:
            r0 = move-exception
            if (r2 == 0) goto L4d
            r2.close()
        L4d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.h4.g():javax.crypto.spec.IvParameterSpec");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a A[DONT_GENERATE, PHI: r1
  0x003a: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v3 android.database.Cursor) binds: [B:12:0x0038, B:8:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int h() {
        /*
            r11 = this;
            java.lang.String r0 = "value"
            r1 = 0
            java.lang.String r2 = "key"
            java.lang.String[] r5 = new java.lang.String[]{r2, r0}     // Catch: java.lang.Throwable -> L34
            java.lang.String r6 = "key=7"
            android.database.sqlite.SQLiteDatabase r3 = r11.b()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = r11.c()     // Catch: java.lang.Throwable -> L34
            r9 = 0
            r10 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L31
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L31
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L34
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L34
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L34
            com.zx.a.I8b7.x3.v = r0     // Catch: java.lang.Throwable -> L34
        L31:
            if (r1 == 0) goto L3d
            goto L3a
        L34:
            r0 = move-exception
            com.zx.a.I8b7.c3.a(r0)     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L3d
        L3a:
            r1.close()
        L3d:
            int r0 = com.zx.a.I8b7.x3.v
            return r0
        L40:
            r0 = move-exception
            if (r1 == 0) goto L46
            r1.close()
        L46:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.h4.h():int");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[DONT_GENERATE, PHI: r1 r2
  0x0047: PHI (r1v1 javax.crypto.spec.SecretKeySpec) = (r1v0 javax.crypto.spec.SecretKeySpec), (r1v4 javax.crypto.spec.SecretKeySpec) binds: [B:16:0x0045, B:11:0x003d] A[DONT_GENERATE, DONT_INLINE]
  0x0047: PHI (r2v2 android.database.Cursor) = (r2v1 android.database.Cursor), (r2v4 android.database.Cursor) binds: [B:16:0x0045, B:11:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public javax.crypto.SecretKey i() {
        /*
            r11 = this;
            java.lang.String r0 = "value"
            r1 = 0
            java.lang.String r2 = "key"
            java.lang.String[] r5 = new java.lang.String[]{r2, r0}     // Catch: java.lang.Throwable -> L40
            java.lang.String r6 = "key=9"
            android.database.sqlite.SQLiteDatabase r3 = r11.b()     // Catch: java.lang.Throwable -> L40
            java.lang.String r4 = r11.c()     // Catch: java.lang.Throwable -> L40
            r9 = 0
            r10 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L3d
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L3b
            if (r3 == 0) goto L3d
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> L3b
            r3 = 0
            byte[] r0 = android.util.Base64.decode(r0, r3)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "AES"
            java.security.SecureRandom r4 = com.zx.a.I8b7.w.a     // Catch: java.lang.Throwable -> L3b
            javax.crypto.spec.SecretKeySpec r4 = new javax.crypto.spec.SecretKeySpec     // Catch: java.lang.Throwable -> L3b
            r4.<init>(r0, r3)     // Catch: java.lang.Throwable -> L3b
            r1 = r4
            goto L3d
        L3b:
            r0 = move-exception
            goto L42
        L3d:
            if (r2 == 0) goto L4a
            goto L47
        L40:
            r0 = move-exception
            r2 = r1
        L42:
            com.zx.a.I8b7.c3.a(r0)     // Catch: java.lang.Throwable -> L4b
            if (r2 == 0) goto L4a
        L47:
            r2.close()
        L4a:
            return r1
        L4b:
            r0 = move-exception
            if (r2 == 0) goto L51
            r2.close()
        L51:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.h4.i():javax.crypto.SecretKey");
    }

    @Override // com.zx.a.I8b7.f
    public void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.zx.a.I8b7.c3.a("ZXID数据库升级, drop zx_table表");
        try {
            sQLiteDatabase.execSQL("drop table if exists zx_table");
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.c3.a(e);
        }
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS zx_table (key integer primary key, value text)");
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void c(int i) {
        if (i != com.zx.a.I8b7.x3.v) {
            com.zx.a.I8b7.x3.v = i;
            a(7, com.zx.a.I8b7.x3.v + "", false);
        }
    }

    public void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.zx.a.I8b7.w2.a.a.a.a(6001, str, true);
        com.zx.a.I8b7.c3.a("vb had changed refresh:" + str);
    }

    public void b(java.lang.String str) {
        if (android.text.TextUtils.equals(str, com.zx.a.I8b7.x3.o)) {
            return;
        }
        com.zx.a.I8b7.x3.o = str;
        com.zx.a.I8b7.w2.a.a.a.a(64, com.zx.a.I8b7.x3.o, true);
        com.zx.a.I8b7.c3.a("lastReportTB2MD5 had changed refresh:" + com.zx.a.I8b7.x3.o);
    }

    public void a(byte[] bArr) {
        java.lang.String str = new java.lang.String(android.util.Base64.encode(bArr, 0), java.nio.charset.StandardCharsets.UTF_8);
        a(9, str.concat(""), false);
        com.zx.a.I8b7.c3.a("ZXID saveSecretKey secretStr:".concat(str));
    }

    public final void a(int i, java.lang.String str, boolean z) {
        java.lang.String str2;
        if (this.b == null) {
            this.b = d();
        }
        if (z) {
            try {
                str2 = new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.w.b("AES/CBC/PKCS5Padding", com.zx.a.I8b7.x3.x, com.zx.a.I8b7.x3.y, str.getBytes()), 0), java.nio.charset.StandardCharsets.UTF_8);
            } catch (java.lang.Exception e) {
                com.zx.a.I8b7.c3.b("ZXID updateDBValue valueID:" + i + ",value:" + str + ",error:" + e.toString());
                return;
            }
        } else {
            str2 = str;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("key", java.lang.Integer.valueOf(i));
        contentValues.put("value", str2);
        com.zx.a.I8b7.c3.a("replace resultId = " + this.b.replace("zx_table", null, contentValues));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0059 A[DONT_GENERATE, PHI: r2 r3
  0x0059: PHI (r2v2 java.lang.String) = (r2v1 java.lang.String), (r2v4 java.lang.String) binds: [B:13:0x0057, B:9:0x0050] A[DONT_GENERATE, DONT_INLINE]
  0x0059: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v3 android.database.Cursor) binds: [B:13:0x0057, B:9:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(int r14) {
        /*
            r13 = this;
            java.lang.String r0 = "value"
            java.lang.String r1 = "key="
            java.lang.String r2 = ""
            r3 = 0
            java.lang.String r4 = "key"
            java.lang.String[] r7 = new java.lang.String[]{r4, r0}     // Catch: java.lang.Throwable -> L53
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L53
            r4.append(r14)     // Catch: java.lang.Throwable -> L53
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L53
            android.database.sqlite.SQLiteDatabase r5 = r13.b()     // Catch: java.lang.Throwable -> L53
            java.lang.String r6 = r13.c()     // Catch: java.lang.Throwable -> L53
            r11 = 0
            r12 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r5.query(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L53
            if (r3 == 0) goto L50
            boolean r14 = r3.moveToNext()     // Catch: java.lang.Throwable -> L53
            if (r14 == 0) goto L50
            int r14 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L53
            java.lang.String r2 = r3.getString(r14)     // Catch: java.lang.Throwable -> L53
            r14 = 0
            byte[] r14 = android.util.Base64.decode(r2, r14)     // Catch: java.lang.Throwable -> L53
            java.lang.String r0 = "AES/CBC/PKCS5Padding"
            javax.crypto.SecretKey r1 = com.zx.a.I8b7.x3.x     // Catch: java.lang.Throwable -> L53
            javax.crypto.spec.IvParameterSpec r4 = com.zx.a.I8b7.x3.y     // Catch: java.lang.Throwable -> L53
            byte[] r14 = com.zx.a.I8b7.w.a(r0, r1, r4, r14)     // Catch: java.lang.Throwable -> L53
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L53
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L53
            r0.<init>(r14, r1)     // Catch: java.lang.Throwable -> L53
            r2 = r0
        L50:
            if (r3 == 0) goto L5c
            goto L59
        L53:
            r14 = move-exception
            com.zx.a.I8b7.c3.a(r14)     // Catch: java.lang.Throwable -> L5d
            if (r3 == 0) goto L5c
        L59:
            r3.close()
        L5c:
            return r2
        L5d:
            r14 = move-exception
            if (r3 == 0) goto L63
            r3.close()
        L63:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.h4.a(int):java.lang.String");
    }

    public void a(org.json.JSONObject jSONObject) {
        com.zx.a.I8b7.x3.m = jSONObject.toString();
        com.zx.a.I8b7.w2.a.a.a.a(30, com.zx.a.I8b7.x3.m, true);
        com.zx.a.I8b7.c3.a("zxc had changed refresh:" + com.zx.a.I8b7.x3.m);
    }

    public final void a(java.lang.String str, byte[] bArr) throws java.lang.Exception {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        java.io.File file = new java.io.File(com.zx.a.I8b7.x3.a.getFilesDir().getAbsolutePath() + java.io.File.separator + "zx-core-" + str + ".zip");
        if (file.createNewFile()) {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file, true);
            byte[] bArr2 = new byte[io.objectbox.model.PropertyFlags.INDEX_HASH];
            while (true) {
                int i = byteArrayInputStream.read(bArr2);
                if (i != -1) {
                    fileOutputStream.write(bArr2, 0, i);
                } else {
                    fileOutputStream.close();
                    byteArrayInputStream.close();
                    return;
                }
            }
        } else {
            throw new java.io.IOException("zx createNewFile exception");
        }
    }

    public void a(java.lang.String str) {
        javax.crypto.spec.IvParameterSpec ivParameterSpecG;
        javax.crypto.SecretKey secretKeyI;
        org.json.JSONObject jSONObjectA;
        android.database.Cursor cursorQuery = null;
        try {
            ivParameterSpecG = g();
            secretKeyI = i();
            jSONObjectA = a(ivParameterSpecG, secretKeyI);
        } catch (java.lang.Throwable th) {
            try {
                com.zx.a.I8b7.c3.a(th);
                if (cursorQuery == null) {
                    return;
                }
            } finally {
                if (0 != 0) {
                    cursorQuery.close();
                }
            }
        }
        if (jSONObjectA == null) {
            return;
        }
        java.lang.String string = jSONObjectA.getString("mainVersion");
        java.lang.String string2 = jSONObjectA.getString("checksum");
        if (android.text.TextUtils.equals(string, str)) {
            cursorQuery = b().query("zx_table", new java.lang.String[]{"key", "value"}, "key=17", null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToNext()) {
                byte[] bArrA = com.zx.a.I8b7.w.a("AES/CBC/PKCS5Padding", secretKeyI, ivParameterSpecG, android.util.Base64.decode(cursorQuery.getString(cursorQuery.getColumnIndex("value")), 0));
                if (android.text.TextUtils.equals(string2, com.zx.a.I8b7.w.a("SHA256", bArrA))) {
                    a(str, bArrA);
                } else {
                    throw new java.io.IOException("zx checksum1 exception");
                }
            }
            if (cursorQuery == null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050 A[DONT_GENERATE, PHI: r2
  0x0050: PHI (r2v2 android.database.Cursor) = (r2v1 android.database.Cursor), (r2v4 android.database.Cursor) binds: [B:17:0x004e, B:12:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject a(javax.crypto.spec.IvParameterSpec r12, javax.crypto.SecretKey r13) {
        /*
            r11 = this;
            java.lang.String r0 = "value"
            r1 = 0
            java.lang.String r2 = "key"
            java.lang.String[] r5 = new java.lang.String[]{r2, r0}     // Catch: java.lang.Throwable -> L49
            java.lang.String r6 = "key=18"
            android.database.sqlite.SQLiteDatabase r3 = r11.b()     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = "zx_table"
            r9 = 0
            r10 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto L46
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L44
            if (r3 == 0) goto L46
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L44
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> L44
            r3 = 0
            byte[] r0 = android.util.Base64.decode(r0, r3)     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = "AES/CBC/PKCS5Padding"
            byte[] r12 = com.zx.a.I8b7.w.a(r3, r13, r12, r0)     // Catch: java.lang.Throwable -> L44
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L44
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L44
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L44
            r0.<init>(r12, r3)     // Catch: java.lang.Throwable -> L44
            r13.<init>(r0)     // Catch: java.lang.Throwable -> L44
            r2.close()
            return r13
        L44:
            r12 = move-exception
            goto L4b
        L46:
            if (r2 == 0) goto L53
            goto L50
        L49:
            r12 = move-exception
            r2 = r1
        L4b:
            com.zx.a.I8b7.c3.a(r12)     // Catch: java.lang.Throwable -> L54
            if (r2 == 0) goto L53
        L50:
            r2.close()
        L53:
            return r1
        L54:
            r12 = move-exception
            if (r2 == 0) goto L5a
            r2.close()
        L5a:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.h4.a(javax.crypto.spec.IvParameterSpec, javax.crypto.SecretKey):org.json.JSONObject");
    }
}
