package com.cmic.gen.sdk;

/* JADX INFO: compiled from: GetPrePhoneScripParameter.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class s extends com.cmic.gen.sdk.y0 {
    private com.cmic.gen.sdk.f a;
    private byte[] b;
    private java.lang.String c;
    private byte[] d;
    private java.lang.String e;
    private boolean f = false;

    @Override // com.cmic.gen.sdk.y0
    protected java.lang.String a(java.lang.String str) {
        return null;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void b(byte[] bArr) {
        this.d = bArr;
    }

    public void c(java.lang.String str) {
        this.c = str;
    }

    public void d(java.lang.String str) {
        this.e = str;
    }

    public void a(byte[] bArr) {
        this.b = bArr;
    }

    @Override // com.cmic.gen.sdk.y0
    public org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (this.f) {
            try {
                jSONObject.put("encrypted", this.c);
                jSONObject.put("encryptedIV", android.util.Base64.encodeToString(this.d, 0));
                jSONObject.put("reqdata", com.cmic.gen.sdk.a.b(this.b, this.a.toString(), this.d));
                jSONObject.put("securityreinforce", this.e);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public com.cmic.gen.sdk.f c() {
        return this.a;
    }

    public void a(com.cmic.gen.sdk.f fVar) {
        this.a = fVar;
    }

    @Override // com.cmic.gen.sdk.y0
    public java.lang.String a() {
        return this.a.a();
    }
}
