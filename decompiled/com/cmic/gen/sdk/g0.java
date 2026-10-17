package com.cmic.gen.sdk;

/* JADX INFO: compiled from: LogReportParameter.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class g0 extends com.cmic.gen.sdk.y0 {
    private com.cmic.gen.sdk.g0.b a;
    private com.cmic.gen.sdk.g0.a b;

    /* JADX INFO: compiled from: LogReportParameter.java */
    public static class a {
        private org.json.JSONObject a;

        public org.json.JSONObject a() {
            return this.a;
        }

        public void a(org.json.JSONObject jSONObject) {
            this.a = jSONObject;
        }
    }

    /* JADX INFO: compiled from: LogReportParameter.java */
    public static class b extends com.cmic.gen.sdk.y0 {
        private java.lang.String a;
        private java.lang.String b;
        private java.lang.String c;
        private java.lang.String d;
        private java.lang.String e;

        @Override // com.cmic.gen.sdk.y0
        public org.json.JSONObject b() {
            return null;
        }

        public void c(java.lang.String str) {
            this.d = str;
        }

        public java.lang.String d() {
            return this.a;
        }

        public void e(java.lang.String str) {
            this.a = str;
        }

        public java.lang.String f() {
            return this.e;
        }

        public void g(java.lang.String str) {
            this.e = str;
        }

        @Override // com.cmic.gen.sdk.y0
        public java.lang.String a() {
            return this.d;
        }

        public java.lang.String c() {
            return this.b;
        }

        public void d(java.lang.String str) {
            this.b = str;
        }

        public java.lang.String e() {
            return this.c;
        }

        public void f(java.lang.String str) {
            this.c = str;
        }

        @Override // com.cmic.gen.sdk.y0
        protected java.lang.String a(java.lang.String str) {
            return this.e + this.d + this.c + this.b + "@Fdiwmxy7CBDDQNUI";
        }
    }

    @Override // com.cmic.gen.sdk.y0
    protected java.lang.String a(java.lang.String str) {
        return null;
    }

    public void a(com.cmic.gen.sdk.g0.b bVar) {
        this.a = bVar;
    }

    @Override // com.cmic.gen.sdk.y0
    public org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        try {
            jSONObject2.put("sign", this.a.d());
            jSONObject2.put("msgid", this.a.c());
            jSONObject2.put("systemtime", this.a.e());
            jSONObject2.put("appid", this.a.a());
            jSONObject2.put("version", this.a.f());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put("log", this.b.a());
            jSONObject.put("body", jSONObject3);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void a(com.cmic.gen.sdk.g0.a aVar) {
        this.b = aVar;
    }

    @Override // com.cmic.gen.sdk.y0
    public java.lang.String a() {
        return this.a.d;
    }
}
