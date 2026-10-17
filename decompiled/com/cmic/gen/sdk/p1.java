package com.cmic.gen.sdk;

/* JADX INFO: compiled from: TransmitRequest.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class p1 {
    private final java.util.Map<java.lang.String, java.util.List<java.lang.String>> a;
    private final java.lang.String b;
    private final org.json.JSONObject c;
    private final java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;

    public p1(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, org.json.JSONObject jSONObject) {
        this.b = str;
        this.d = str2;
        this.a = map;
        this.c = jSONObject;
    }

    public void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        java.util.List<java.lang.String> list = this.a.get(str);
        if (list != null) {
            list.add(str2);
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(str2);
        this.a.put(str, arrayList);
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> b() {
        return this.a;
    }

    public java.lang.String c() {
        return this.d;
    }

    public java.lang.String d() {
        return this.b;
    }

    public void b(java.lang.String str) {
        this.e = str;
    }

    public void a(java.lang.String str) {
        this.f = str;
    }

    public java.lang.String a() {
        try {
            java.lang.String strOptString = this.c.optString("expandParams");
            java.lang.String str = "apppackage=" + this.e + "|appsign=" + this.f;
            if (!android.text.TextUtils.isEmpty(strOptString)) {
                str = strOptString + "|" + str;
            }
            this.c.put("expandParams", str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        org.json.JSONObject jSONObject = this.c;
        return jSONObject == null ? "" : jSONObject.toString();
    }
}
