package com.igexin.push.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class h {
    private static final int a = 10000;
    private static final java.lang.String b = "ErrorReport";

    /* JADX INFO: renamed from: com.igexin.push.g.h$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.igexin.push.g.h.a b;

        public AnonymousClass1(android.content.Context context, com.igexin.push.g.h.a aVar) {
            this.a = context;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z = false;
            try {
                if (com.igexin.push.g.h.a()) {
                    com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.g, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("action", "upload_BI");
                    jSONObject.put("BIType", "25");
                    jSONObject.put("cid", "0");
                    jSONObject.put("BIData", new java.lang.String(com.igexin.c.a.b.g.c(com.igexin.push.g.h.a(this.a).getBytes()), "UTF-8"));
                    byte[] bArrA = com.igexin.push.g.s.a(com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl(), com.igexin.c.b.a.b(jSONObject.toString().getBytes()));
                    if (bArrA != null) {
                        new java.lang.String(bArrA);
                    }
                    z = true;
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.a("ErrorReport|report 25 ex = " + th.toString(), new java.lang.Object[0]);
            }
            com.igexin.push.g.h.a aVar = this.b;
            if (aVar != null) {
                aVar.a(z);
            }
        }
    }

    public interface a {
        void a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.lang.String a(android.content.Context context) {
        java.lang.String packageName = context.getPackageName();
        java.lang.String strA = null;
        try {
            android.content.pm.ApplicationInfo applicationInfoB = com.igexin.push.g.o.b(context);
            if (applicationInfoB != null && applicationInfoB.metaData != null) {
                strA = com.igexin.push.g.d.a(applicationInfoB);
                if (android.text.TextUtils.isEmpty(strA)) {
                    strA = applicationInfoB.metaData.getString(com.igexin.push.core.b.b);
                }
                if (android.text.TextUtils.isEmpty(strA)) {
                    strA = applicationInfoB.metaData.getString("GETUI_APPID");
                }
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        java.lang.String str = android.os.Build.VERSION.SDK;
        java.lang.String str2 = android.os.Build.VERSION.RELEASE;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date()));
        sb.append("|");
        sb.append(strA);
        sb.append("|3.3.13.0|true|");
        sb.append(com.igexin.push.g.o.g() == null ? "" : com.igexin.push.g.o.g());
        sb.append("|");
        sb.append(com.igexin.push.g.o.e());
        sb.append("|");
        sb.append(str);
        sb.append("|");
        sb.append(str2);
        sb.append("|");
        sb.append(com.igexin.push.g.o.a(context));
        sb.append("|");
        sb.append(com.igexin.push.g.o.k());
        sb.append("|");
        sb.append(packageName);
        if (com.igexin.push.g.g.d != null) {
            sb.append("|");
            sb.append(com.igexin.push.g.g.d);
        }
        com.igexin.c.a.c.a.a("ErrorReport|" + sb.toString(), new java.lang.Object[0]);
        return sb.toString();
    }

    private static void a(com.igexin.push.g.h.a aVar, android.content.Context context) {
        com.igexin.b.a.a().a.execute(new com.igexin.push.g.h.AnonymousClass1(context, aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        try {
            return java.lang.System.currentTimeMillis() - com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.g, new long[0]) > 86400000;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }
}
