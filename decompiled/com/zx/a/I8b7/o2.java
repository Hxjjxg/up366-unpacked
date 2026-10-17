package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class o2 {
    public static java.lang.String a(int i, java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("message", str);
        } catch (java.lang.Exception unused) {
        }
        return jSONObject.toString();
    }
}
