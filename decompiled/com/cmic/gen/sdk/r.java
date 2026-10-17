package com.cmic.gen.sdk;

/* JADX INFO: compiled from: GetPhoneNubmerNotify.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class r extends com.cmic.gen.sdk.y0 {
    private final java.lang.String a;
    private final java.lang.String b;
    private final java.lang.String c;
    private java.lang.String d = "authz";
    private java.lang.String e;
    private java.lang.String f;

    public r(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.cmic.gen.sdk.y0
    public java.lang.String a() {
        return this.a;
    }

    @Override // com.cmic.gen.sdk.y0
    protected java.lang.String a(java.lang.String str) {
        return null;
    }

    @Override // com.cmic.gen.sdk.y0
    public org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("ver", this.b);
            jSONObject.put("data", this.c);
            jSONObject.put("operatortype", this.f);
            jSONObject.put("userCapaid", this.e);
            jSONObject.put("funcType", this.d);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void c(java.lang.String str) {
        this.d = str;
    }

    public void d(java.lang.String str) {
        this.f = str;
    }

    public void e(java.lang.String str) {
        this.e = str;
    }
}
