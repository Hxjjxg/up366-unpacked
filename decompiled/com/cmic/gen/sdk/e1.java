package com.cmic.gen.sdk;

/* JADX INFO: compiled from: ScripAndTokenParameter.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class e1 extends com.cmic.gen.sdk.f {
    protected java.lang.String C = "";
    protected java.lang.String D = "";

    public void A(java.lang.String str) {
        this.v = c(str);
    }

    public void B(java.lang.String str) {
        this.D = c(str);
    }

    @Override // com.cmic.gen.sdk.y0
    protected java.lang.String a(java.lang.String str) {
        return this.b + this.c + this.d + this.e + this.f + this.g + this.h + this.i + this.j + this.m + this.n + str + this.o + this.q + this.r + this.s + this.t + this.u + this.v + this.C + this.D + this.w + this.x + "0";
    }

    @Override // com.cmic.gen.sdk.y0
    public org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("ver", this.a);
            jSONObject.put("sdkver", this.b);
            jSONObject.put("targetVersion", "0");
            jSONObject.put("appid", this.c);
            jSONObject.put("imsi", this.d);
            jSONObject.put("operatortype", this.e);
            jSONObject.put("networktype", this.f);
            jSONObject.put("mobilebrand", this.g);
            jSONObject.put("mobilemodel", this.h);
            jSONObject.put("mobilesystem", this.i);
            jSONObject.put("clienttype", this.j);
            jSONObject.put("interfacever", this.k);
            jSONObject.put("expandparams", this.l);
            jSONObject.put("msgid", this.m);
            jSONObject.put("timestamp", this.n);
            jSONObject.put("subimsi", this.o);
            jSONObject.put("sign", this.p);
            jSONObject.put("apppackage", this.q);
            jSONObject.put("appsign", this.r);
            jSONObject.put("ipv4_list", this.s);
            jSONObject.put("ipv6_list", this.t);
            jSONObject.put("sdkType", this.u);
            jSONObject.put("tempPDR", this.v);
            jSONObject.put("scrip", this.C);
            jSONObject.put("userCapaid", this.D);
            jSONObject.put("funcType", this.w);
            jSONObject.put("socketip", this.x);
            jSONObject.put("riskControlInfo", this.A);
            jSONObject.put("simOperator", this.z);
            jSONObject.put("oaid", this.B);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public java.lang.String toString() {
        return b().toString();
    }

    public void z(java.lang.String str) {
        this.C = c(str);
    }
}
