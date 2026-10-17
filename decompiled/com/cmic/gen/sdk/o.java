package com.cmic.gen.sdk;

/* JADX INFO: compiled from: EventUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class o {
    private static com.cmic.gen.sdk.o.b<java.lang.String, java.lang.String> a = new com.cmic.gen.sdk.o.b<>(null);

    /* JADX INFO: compiled from: EventUtils.java */
    class a extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ com.cmic.gen.sdk.f0 b;
        final /* synthetic */ com.cmic.gen.sdk.i c;

        a(com.cmic.gen.sdk.f0 f0Var, com.cmic.gen.sdk.i iVar) {
            this.b = f0Var;
            this.c = iVar;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            new com.cmic.gen.sdk.f1().a(this.b.b(), this.c);
        }
    }

    /* JADX INFO: compiled from: EventUtils.java */
    private static class b<K, V> extends java.util.HashMap<K, V> {
        private b() {
        }

        public V a(java.lang.Object obj, V v) {
            return (!containsKey(obj) || get(obj) == null) ? v : get(obj);
        }

        /* synthetic */ b(com.cmic.gen.sdk.o.a aVar) {
            this();
        }
    }

    public static void a() {
        java.lang.String strValueOf = java.lang.String.valueOf(0);
        a.put("authPageIn", strValueOf);
        a.put("authPageOut", strValueOf);
        a.put("authClickFailed", strValueOf);
        a.put("authClickSuccess", strValueOf);
        a.put("timeOnAuthPage", strValueOf);
        a.put("PrivacyNotSelectedToast", strValueOf);
        a.put("PrivacyNotSelectedPopup", strValueOf);
        a.put("PrivacyNotSelectedCustom", strValueOf);
        a.put("PrivacyNotSelectedShake", strValueOf);
    }

    public static void a(java.lang.String str) {
        try {
            java.lang.String str2 = a.get(str);
            a.put(str, java.lang.String.valueOf((!android.text.TextUtils.isEmpty(str2) ? java.lang.Integer.parseInt(str2) : 0) + 1));
            a.put(str + "Time", com.cmic.gen.sdk.l1.a());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        a.put(str, str2);
    }

    public static void a(android.content.Context context, com.cmic.gen.sdk.i iVar) {
        try {
            if (iVar.b().m()) {
                return;
            }
            com.cmic.gen.sdk.i0 i0Var = new com.cmic.gen.sdk.i0();
            java.lang.String strValueOf = java.lang.String.valueOf(0);
            i0Var.c(!a.a("authPageIn", strValueOf).equals(strValueOf) ? a.get("authPageIn") : null);
            i0Var.d(!a.a("authPageOut", strValueOf).equals(strValueOf) ? a.get("authPageOut") : null);
            i0Var.b(!a.a("authClickSuccess", strValueOf).equals(strValueOf) ? a.get("authClickSuccess") : null);
            i0Var.a(!a.a("authClickFailed", strValueOf).equals(strValueOf) ? a.get("authClickFailed") : null);
            i0Var.k(!a.a("timeOnAuthPage", strValueOf).equals(strValueOf) ? a.get("timeOnAuthPage") : null);
            i0Var.j(!a.a("PrivacyNotSelectedToast", strValueOf).equals(strValueOf) ? a.get("PrivacyNotSelectedToast") : null);
            i0Var.h(!a.a("PrivacyNotSelectedPopup", strValueOf).equals(strValueOf) ? a.get("PrivacyNotSelectedPopup") : null);
            i0Var.i(!a.a("PrivacyNotSelectedShake", strValueOf).equals(strValueOf) ? a.get("PrivacyNotSelectedShake") : null);
            i0Var.g(a.a("PrivacyNotSelectedCustom", strValueOf).equals(strValueOf) ? null : a.get("PrivacyNotSelectedCustom"));
            i0Var.e(a.a("authPrivacyState", strValueOf));
            i0Var.f(iVar.c("displayLogo"));
            org.json.JSONObject jSONObjectA = i0Var.a();
            com.cmic.gen.sdk.f0 f0Var = new com.cmic.gen.sdk.f0();
            f0Var.f(iVar.a("appid", ""));
            f0Var.A(iVar.c("traceId"));
            f0Var.f(iVar.c("appid"));
            f0Var.d(com.cmic.gen.sdk.s0.a(context));
            f0Var.e(com.cmic.gen.sdk.s0.d(context));
            f0Var.z(iVar.c("timeOut"));
            f0Var.s(a.a("authPageInTime", ""));
            f0Var.u(a.a("authPageOutTime", ""));
            f0Var.t("eventTracking5");
            f0Var.p(iVar.a("operatortype", ""));
            f0Var.n(iVar.a("networktype", 0) + "");
            f0Var.g(com.cmic.gen.sdk.j1.b());
            f0Var.q(com.cmic.gen.sdk.j1.c());
            f0Var.r(com.cmic.gen.sdk.j1.a());
            f0Var.x(iVar.c("simCardNum"));
            f0Var.a(jSONObjectA);
            f0Var.i(iVar.a("imsiState", "0"));
            f0Var.h((java.lang.System.currentTimeMillis() - iVar.a("methodTimes", 0L)) + "");
            com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.o.a(f0Var, iVar));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
