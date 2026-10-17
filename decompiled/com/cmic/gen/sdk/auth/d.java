package com.cmic.gen.sdk.auth;

/* JADX INFO: compiled from: TransmitListenerWrapper.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class d implements com.cmic.gen.sdk.a1 {
    private final android.os.Handler a;
    private final int b;
    private final android.content.Context c;
    private volatile boolean d = false;
    private final com.cmic.gen.sdk.i e;

    /* JADX INFO: compiled from: TransmitListenerWrapper.java */
    class a extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ int b;

        a(int i) {
            this.b = i;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            new com.cmic.gen.sdk.f1().a(com.cmic.gen.sdk.auth.d.this.c, java.lang.String.valueOf(this.b), com.cmic.gen.sdk.auth.d.this.e);
        }
    }

    public d(android.content.Context context, int i, com.cmic.gen.sdk.i iVar) {
        this.c = context;
        this.a = new android.os.Handler(context.getMainLooper());
        this.b = i;
        this.e = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        a(200025, null, "登录超时");
    }

    public void b() {
        this.a.postDelayed(new java.lang.Runnable() { // from class: com.cmic.gen.sdk.auth.d$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        }, this.b);
    }

    @Override // com.cmic.gen.sdk.a1
    public void a(final int i, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, final java.lang.String str) {
        synchronized (this) {
            if (this.d) {
                return;
            }
            this.d = true;
            this.a.removeCallbacksAndMessages(null);
            this.e.b("systemEndTime", android.os.SystemClock.elapsedRealtime());
            this.e.b("endtime", com.cmic.gen.sdk.l1.a());
            this.a.post(new java.lang.Runnable() { // from class: com.cmic.gen.sdk.auth.d$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(i, str);
                }
            });
            com.cmic.gen.sdk.u1.a(this.c).a(this.e);
            if (this.e.b().m() || com.cmic.gen.sdk.x1.a(this.e.b())) {
                return;
            }
            com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.auth.d.a(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, java.lang.String str) {
        if (i != 200 && i != 301 && i != 302) {
            java.lang.String str2 = i + "";
            if (android.text.TextUtils.isEmpty(str)) {
                str = "网络异常";
            }
            str = com.cmic.gen.sdk.auth.c.b(str2, str).toString();
        }
        java.lang.String strC = this.e.c("callbackFn");
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("data", str);
            jSONObject.put("networktype", this.e.b("networktype") + "");
            jSONObject.put("appInfo", com.cmic.gen.sdk.auth.GenAuthnHelper.m);
            com.cmic.gen.sdk.g.a().a(com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance((android.content.Context) null).k, strC + "(" + jSONObject.toString() + ")", (android.webkit.ValueCallback<java.lang.String>) null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            this.e.a().A.add(e);
        }
    }
}
