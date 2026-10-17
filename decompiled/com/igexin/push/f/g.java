package com.igexin.push.f;

import com.igexin.push.core.e.f.AnonymousClass31;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class g implements com.igexin.push.f.b.c {
    private static volatile com.igexin.push.f.g a = null;
    private static java.lang.String b = "Type10Task";
    private java.text.SimpleDateFormat c = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.CHINA);

    public static com.igexin.push.f.g a() {
        if (a == null) {
            synchronized (com.igexin.push.f.g.class) {
                if (a == null) {
                    a = new com.igexin.push.f.g();
                }
            }
        }
        return a;
    }

    static /* synthetic */ java.lang.String a(java.lang.String str) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date()) + "|" + com.igexin.push.core.e.A + "|" + com.igexin.push.core.e.a + "|3|" + str + "|" + com.igexin.push.core.e.C + "|" + com.igexin.push.core.ServiceManager.getInstance().initType.first;
    }

    private static java.lang.String b(java.lang.String str) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date()) + "|" + com.igexin.push.core.e.A + "|" + com.igexin.push.core.e.a + "|3|" + str + "|" + com.igexin.push.core.e.C + "|" + com.igexin.push.core.ServiceManager.getInstance().initType.first;
    }

    private void f() {
        if (com.igexin.push.core.e.ax == 0) {
            return;
        }
        try {
            java.lang.String str = this.c.format(new java.util.Date(com.igexin.push.core.e.ax));
            java.lang.String str2 = this.c.format(new java.util.Date());
            java.util.Date date = this.c.parse(str);
            java.util.Date date2 = this.c.parse(str2);
            com.igexin.c.a.c.a.b(b, " lastDateString = " + str + " ; nowDateString = " + str2);
            if (date2.after(date)) {
                c();
            }
        } catch (java.text.ParseException e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.f.b.c
    public final void a(long j) {
    }

    @Override // com.igexin.push.f.b.c
    public final void b() {
        if (com.igexin.push.core.e.ax != 0) {
            try {
                java.lang.String str = this.c.format(new java.util.Date(com.igexin.push.core.e.ax));
                java.lang.String str2 = this.c.format(new java.util.Date());
                java.util.Date date = this.c.parse(str);
                java.util.Date date2 = this.c.parse(str2);
                com.igexin.c.a.c.a.b(b, " lastDateString = " + str + " ; nowDateString = " + str2);
                if (date2.after(date)) {
                    c();
                }
            } catch (java.text.ParseException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    public final void c() {
        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        final java.lang.String str = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(jCurrentTimeMillis));
        if (!com.igexin.push.config.d.q) {
            com.igexin.c.a.c.a.b(b, "upload type10 enable false");
            return;
        }
        int i = android.text.TextUtils.isEmpty(com.igexin.push.core.e.A) ? com.igexin.push.config.d.Y * 1000 : 0;
        com.igexin.c.a.c.a.b(b, "upload type10 delay time = ".concat(java.lang.String.valueOf(i)));
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
        com.igexin.push.core.d.a(new com.igexin.push.f.b.f(i) { // from class: com.igexin.push.f.g.1
            @Override // com.igexin.c.a.d.a.e
            public final int c() {
                return 0;
            }

            @Override // com.igexin.push.f.b.f
            public final void h() {
                try {
                    if (jCurrentTimeMillis - com.igexin.push.core.e.ax <= 60000) {
                        com.igexin.c.a.c.a.b(com.igexin.push.f.g.b, "upload type10 in 1m");
                        return;
                    }
                    com.igexin.push.core.e.ax = jCurrentTimeMillis;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass31(), false, true);
                    com.igexin.push.core.c.a.a();
                    java.lang.String strA = com.igexin.push.f.g.a(str);
                    android.content.ContentValues contentValues = new android.content.ContentValues();
                    contentValues.put("type", (java.lang.Integer) 10);
                    contentValues.put("data", strA);
                    contentValues.put("time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                    com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, contentValues);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    com.igexin.push.core.c.a.a();
                    java.util.List<com.igexin.push.core.b.c> listC = com.igexin.push.core.c.a.c();
                    final java.util.ArrayList arrayList = new java.util.ArrayList();
                    for (com.igexin.push.core.b.c cVar : listC) {
                        arrayList.add(java.lang.String.valueOf(cVar.a));
                        sb.append(cVar.b);
                        sb.append("\n");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    com.igexin.c.a.c.a.b(com.igexin.push.f.g.b, "upload type10 data = ".concat(java.lang.String.valueOf(sb)));
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.a.a(new com.igexin.push.core.h.e(com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl(), sb.toString().getBytes()) { // from class: com.igexin.push.f.g.1.1
                        @Override // com.igexin.push.core.h.e, com.igexin.push.f.a.d
                        public final void a(byte[] bArr) throws java.lang.Exception {
                            super.a(bArr);
                            com.igexin.push.core.c.a.a();
                            java.util.ArrayList arrayList2 = arrayList;
                            com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, new java.lang.String[]{com.igexin.push.core.b.C}, (java.lang.String[]) arrayList2.toArray(new java.lang.String[arrayList2.size()]));
                        }
                    }), false, true);
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        });
    }

    @Override // com.igexin.push.f.b.c
    public final boolean d() {
        return com.igexin.push.config.d.q;
    }
}
