package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class W {
    private static volatile com.chuanglan.shanyan_sdk.W a;

    private W() {
    }

    public static com.chuanglan.shanyan_sdk.W a() {
        if (a == null) {
            synchronized (com.chuanglan.shanyan_sdk.W.class) {
                if (a == null) {
                    a = new com.chuanglan.shanyan_sdk.W();
                }
            }
        }
        return a;
    }

    public java.util.Map a(java.lang.String str, android.content.Context context) {
        java.util.HashMap map = new java.util.HashMap();
        java.lang.String strA = com.chuanglan.shanyan_sdk.AbstractC0047d.a();
        java.lang.String strC = com.chuanglan.shanyan_sdk.C0065v.g().c(context);
        java.lang.String strD = com.chuanglan.shanyan_sdk.C0065v.g().d(context);
        java.lang.String str2 = com.chuanglan.shanyan_sdk.C0065v.g().b() + "|" + com.chuanglan.shanyan_sdk.C0065v.g().f() + "|" + com.chuanglan.shanyan_sdk.C0065v.g().a();
        map.put("i9", strD);
        map.put("i1", str);
        map.put("i3", com.chuanglan.shanyan_sdk.AbstractC0055l.A);
        map.put("i8", strC);
        map.put("i2", strA);
        map.put("i5", "2.3.7.7");
        map.put("i6", str2);
        map.put("i7", com.chuanglan.shanyan_sdk.AbstractC0045b.a(map, com.chuanglan.shanyan_sdk.AbstractC0045b.b(str)));
        return map;
    }

    public java.util.Map a(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, android.content.Context context) {
        java.lang.String strC = com.chuanglan.shanyan_sdk.C0065v.g().c(context);
        java.lang.String strD = com.chuanglan.shanyan_sdk.C0065v.g().d(context);
        java.util.HashMap map = new java.util.HashMap();
        map.put("a7", str);
        map.put("a5", str2);
        map.put("a8", jSONObject);
        map.put("ab", strC);
        map.put("ac", strD);
        return map;
    }
}
