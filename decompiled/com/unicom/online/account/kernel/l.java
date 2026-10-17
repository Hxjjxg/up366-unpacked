package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class l {
    public static int b;
    public static int c;
    public static int d;
    public static java.lang.ref.WeakReference e;

    public static void b(int i, com.unicom.online.account.shield.ResultListener resultListener, int i2, java.lang.String str, int i3) {
        com.unicom.online.account.kernel.ar.b("type:" + i + "\nmsg:" + str);
        try {
            java.lang.String strC = com.unicom.online.account.kernel.bp.c();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("resultCode", i2);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", "");
            jSONObject.put("seq", strC);
            b();
            if (resultListener != null) {
                resultListener.onResult(jSONObject.toString());
            }
            com.unicom.online.account.kernel.bp.e().getClass();
            if (com.unicom.online.account.kernel.ap.b) {
                com.unicom.online.account.kernel.bp.e().getClass();
                java.lang.String strB = com.unicom.online.account.kernel.bp.b(1, 1, strC, i2, i3, i2, str);
                com.unicom.online.account.kernel.bp.e().getClass();
                com.unicom.online.account.kernel.an.b(com.unicom.online.account.kernel.bp.b(), strB);
            }
        } catch (java.lang.Exception e2) {
            if (com.unicom.online.account.kernel.ar.b) {
                e2.printStackTrace();
            }
        }
    }

    public static android.content.Context c() {
        java.lang.ref.WeakReference weakReference = e;
        if (weakReference != null) {
            return (android.content.Context) weakReference.get();
        }
        return null;
    }

    public static void b() {
        d = 0;
        c = 0;
        b = 0;
    }
}
