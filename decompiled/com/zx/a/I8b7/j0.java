package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class j0 {
    public static boolean a() {
        try {
            if (!com.zx.a.I8b7.x3.b.equals(com.zx.a.I8b7.x3.j) || android.text.TextUtils.isEmpty(com.zx.a.I8b7.x3.D)) {
                return false;
            }
            if (java.lang.System.currentTimeMillis() - com.zx.a.I8b7.x3.w >= new org.json.JSONObject(com.zx.a.I8b7.x3.D).getLong("frequency") * 1000) {
                return false;
            }
            com.zx.a.I8b7.c3.a("report freq c true");
            return true;
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.c3.a(e);
            return false;
        }
    }
}
