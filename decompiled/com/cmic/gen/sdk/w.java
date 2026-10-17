package com.cmic.gen.sdk;

/* JADX INFO: compiled from: HttpGetPrephoneRequest.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class w extends com.cmic.gen.sdk.x {
    private final com.cmic.gen.sdk.s l;
    private boolean m;

    w(java.lang.String str, com.cmic.gen.sdk.s sVar, java.lang.String str2, java.lang.String str3) {
        super(str, sVar, str2, str3);
        this.m = false;
        this.l = sVar;
    }

    public void a(com.cmic.gen.sdk.i iVar) {
        java.lang.String[] strArrA;
        com.cmic.gen.sdk.f fVarC = this.l.c();
        fVarC.v(iVar.c("socketip"));
        com.cmic.gen.sdk.h0.a("GetPrePhonescripParam", "socket socketip = " + iVar.c("socketip"));
        if (!this.m) {
            if (iVar.a("isCloseIpv4", false)) {
                strArrA = null;
            } else {
                strArrA = com.cmic.gen.sdk.w1.a(true);
                fVarC.j(strArrA[0]);
            }
            if (!iVar.a("isCloseIpv6", false)) {
                if (strArrA == null) {
                    strArrA = com.cmic.gen.sdk.w1.a(true);
                }
                fVarC.k(strArrA[1]);
            }
            this.m = true;
        }
        fVarC.t(fVarC.b(iVar.c("appkey")));
        this.l.a(fVarC);
        this.l.a(true);
        this.c = this.l.b().toString();
    }
}
