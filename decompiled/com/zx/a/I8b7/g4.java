package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class g4 implements com.zx.a.I8b7.b4 {
    public final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);
    public final java.util.concurrent.atomic.AtomicBoolean b = new java.util.concurrent.atomic.AtomicBoolean(false);
    public com.zx.module.base.Listener c;

    public static void a(com.zx.a.I8b7.g4 g4Var) throws java.lang.Exception {
        g4Var.getClass();
        java.lang.String str = com.zx.a.I8b7.x3.i;
        if (!com.zx.a.I8b7.x3.r) {
            com.zx.a.I8b7.r.c();
        }
        com.zx.a.I8b7.x1.f();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("code", 0);
        jSONObject.put("data", com.zx.a.I8b7.x3.a());
        java.lang.String string = jSONObject.toString();
        g4Var.c.onMessage("MESSAGE_ON_ZXID_RECEIVED", string);
        if (android.text.TextUtils.equals(str, com.zx.a.I8b7.x3.i)) {
            return;
        }
        g4Var.c.onMessage("MESSAGE_ON_ZXID_CHANGED", string);
    }
}
