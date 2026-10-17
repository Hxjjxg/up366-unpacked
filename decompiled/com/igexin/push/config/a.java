package com.igexin.push.config;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class a implements com.igexin.push.core.e.a {
    public static final java.lang.String a = "com.igexin.push.config.a";
    public static final int b = 63;
    public static final int c = 65;
    public static final int d = 67;
    public static final int e = 68;
    public static final int f = 79;
    public static final int g = 82;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private static final int k = 15;
    private static final int l = 16;
    private static final int m = 24;
    private static final int n = 26;
    private static final int o = 28;
    private static final int p = 46;
    private static final int q = 47;
    private static final int r = 48;
    private static final int s = 49;
    private static final int t = 60;
    private static final int u = 61;
    private static final int v = 62;
    private static final int w = 69;
    private static final int x = 70;
    private static final int y = 74;
    private static volatile com.igexin.push.config.a z;

    /* JADX INFO: renamed from: com.igexin.push.config.a$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.b.d {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            com.igexin.push.config.a.b(this.d, 63, this.a);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.config.a$3, reason: invalid class name */
    public class AnonymousClass3 extends com.igexin.push.b.d {
        public AnonymousClass3() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            com.igexin.push.config.a.b(this.d, 15, java.lang.String.valueOf(com.igexin.push.config.d.e));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.config.a$4, reason: invalid class name */
    public class AnonymousClass4 extends com.igexin.push.b.d {
        public AnonymousClass4() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            com.igexin.push.config.a.b(this.d, 16, java.lang.String.valueOf(com.igexin.push.config.d.f));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.config.a$5, reason: invalid class name */
    public class AnonymousClass5 extends com.igexin.push.b.d {
        public AnonymousClass5() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            com.igexin.push.config.a.b(this.d, 3, java.lang.String.valueOf(com.igexin.push.config.d.d));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.config.a$6, reason: invalid class name */
    public class AnonymousClass6 extends com.igexin.push.b.d {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass6(java.lang.String str) {
            this.a = str;
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            com.igexin.push.config.a.a(this.d, 26, com.igexin.c.a.a.a.b(this.a.getBytes(), com.igexin.push.core.e.M));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.config.a$7, reason: invalid class name */
    public class AnonymousClass7 extends com.igexin.push.b.d {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass7(java.lang.String str) {
            this.a = str;
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            com.igexin.push.config.a.a(this.d, 24, com.igexin.c.a.a.a.b(this.a.getBytes(), com.igexin.push.core.e.M));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.config.a$9, reason: invalid class name */
    public class AnonymousClass9 extends com.igexin.push.b.d {
        final /* synthetic */ boolean a;

        public AnonymousClass9(boolean z) {
            this.a = z;
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            com.igexin.push.config.a.b(this.d, 79, java.lang.String.valueOf(this.a));
        }
    }

    private a() {
    }

    public static com.igexin.push.config.a a() {
        if (z == null) {
            synchronized (com.igexin.push.config.a.class) {
                if (z == null) {
                    z = new com.igexin.push.config.a();
                }
            }
        }
        return z;
    }

    private void a(final long j2) {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.config.a.8
            @Override // com.igexin.push.b.d
            public final void a_() {
                com.igexin.push.core.e.aH = j2;
                com.igexin.push.config.a.b(this.d, 65, java.lang.String.valueOf(j2));
            }
        }, true, false);
    }

    private static void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i2) {
        sQLiteDatabase.delete("config", "id = ?", new java.lang.String[]{java.lang.String.valueOf(i2)});
    }

    static /* synthetic */ void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i2, byte[] bArr) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.igexin.push.core.b.C, java.lang.Integer.valueOf(i2));
        contentValues.put("value", bArr);
        sQLiteDatabase.replace("config", null, contentValues);
    }

    private void a(boolean z2) {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.config.a.AnonymousClass9(z2), true, false);
    }

    private boolean a(java.lang.String str) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.config.a.AnonymousClass1(str), false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i2, java.lang.String str) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.igexin.push.core.b.C, java.lang.Integer.valueOf(i2));
        contentValues.put("value", str);
        sQLiteDatabase.replace("config", null, contentValues);
    }

    private static void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i2, byte[] bArr) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.igexin.push.core.b.C, java.lang.Integer.valueOf(i2));
        contentValues.put("value", bArr);
        sQLiteDatabase.replace("config", null, contentValues);
    }

    private void b(java.lang.String str) {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.config.a.AnonymousClass6(str), true, false);
    }

    private void c() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.config.a.AnonymousClass3(), false, true);
    }

    private void c(java.lang.String str) {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.config.a.AnonymousClass7(str), true, false);
    }

    private void d() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.config.a.AnonymousClass4(), false, true);
    }

    private void e() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.config.a.AnonymousClass5(), false, true);
    }

    @Override // com.igexin.push.core.e.a
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    public final void b() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.config.a.2
            @Override // com.igexin.push.b.d
            public final void a_() {
                com.igexin.push.config.a.b(this.d, 1, java.lang.String.valueOf(com.igexin.push.config.d.b));
                com.igexin.push.config.a.b(this.d, 2, java.lang.String.valueOf(com.igexin.push.config.d.c));
            }
        }, false, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01e0 A[DONT_GENERATE, PHI: r13
  0x01e0: PHI (r13v4 android.database.Cursor) = (r13v3 android.database.Cursor), (r13v11 android.database.Cursor) binds: [B:111:0x01de, B:106:0x01d4] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.igexin.push.core.e.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.database.sqlite.SQLiteDatabase r13) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.a.b(android.database.sqlite.SQLiteDatabase):void");
    }

    @Override // com.igexin.push.core.e.a
    public final void c(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, 1, java.lang.String.valueOf(com.igexin.push.config.d.b));
        b(sQLiteDatabase, 2, java.lang.String.valueOf(com.igexin.push.config.d.c));
        b(sQLiteDatabase, 3, java.lang.String.valueOf(com.igexin.push.config.d.d));
        b(sQLiteDatabase, 15, java.lang.String.valueOf(com.igexin.push.config.d.e));
        b(sQLiteDatabase, 3, java.lang.String.valueOf(com.igexin.push.config.d.d));
    }
}
