package com.cmic.gen.sdk;

/* JADX INFO: compiled from: RedirectHandler.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class w0 {
    private java.lang.String a;
    private java.lang.String b;

    public com.cmic.gen.sdk.x a(com.cmic.gen.sdk.x xVar, com.cmic.gen.sdk.y yVar, com.cmic.gen.sdk.i iVar) {
        java.lang.String strA = iVar.a("operatortype", "0");
        if ("2".equals(strA)) {
            com.cmic.gen.sdk.x1.c(iVar, "getNewUnicomPhoneNumberNotify");
        } else if ("3".equals(strA)) {
            com.cmic.gen.sdk.x1.c(iVar, "getNewTelecomPhoneNumberNotify");
        } else {
            com.cmic.gen.sdk.x1.c(iVar, "NONE");
        }
        com.cmic.gen.sdk.x1.a(iVar, java.lang.String.valueOf(yVar.c()));
        com.cmic.gen.sdk.r rVar = new com.cmic.gen.sdk.r(xVar.g().a(), "1.0", yVar.a());
        rVar.e(iVar.c("userCapaid"));
        rVar.d(iVar.c("operatortype"));
        if (iVar.b("logintype") == 3 || iVar.a("isRisk", false)) {
            rVar.c("pre");
        } else {
            rVar.c("authz");
        }
        com.cmic.gen.sdk.x xVarA = a(this.a, xVar.i(), "POST", rVar);
        xVarA.a(xVar.f());
        this.a = null;
        return xVarA;
    }

    public com.cmic.gen.sdk.x b(com.cmic.gen.sdk.x xVar, com.cmic.gen.sdk.y yVar, com.cmic.gen.sdk.i iVar) {
        java.util.List<java.lang.String> list;
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> mapB = yVar.b();
        if (android.text.TextUtils.isEmpty(this.a) && (list = mapB.get("pplocation")) != null && list.size() > 0) {
            this.a = list.get(0);
        }
        com.cmic.gen.sdk.x1.a(iVar, java.lang.String.valueOf(yVar.c()));
        java.util.List<java.lang.String> list2 = mapB.get("Location");
        if (list2 == null || list2.isEmpty()) {
            list2 = mapB.get("Location".toLowerCase());
        }
        java.lang.String strA = iVar.a("operatortype", "0");
        if (list2 != null && list2.size() > 0) {
            java.lang.String str = list2.get(0);
            this.b = str;
            if (!android.text.TextUtils.isEmpty(str)) {
                if ("2".equals(strA)) {
                    com.cmic.gen.sdk.x1.c(iVar, "getUnicomMobile");
                } else if ("3".equals(strA)) {
                    com.cmic.gen.sdk.x1.c(iVar, "getTelecomMobile");
                } else {
                    com.cmic.gen.sdk.x1.c(iVar, "NONE");
                }
            }
        } else if ("2".equals(strA)) {
            com.cmic.gen.sdk.x1.c(iVar, "getUCMobileCostTime1");
        } else if ("3".equals(strA)) {
            com.cmic.gen.sdk.x1.c(iVar, "getTCMobileCostTime1");
        } else {
            com.cmic.gen.sdk.x1.c(iVar, "NONE");
        }
        com.cmic.gen.sdk.h0.a("Location", this.b);
        com.cmic.gen.sdk.x xVarA = a(this.b, xVar.i(), "GET", new com.cmic.gen.sdk.q(xVar.g().a()));
        xVarA.a(xVar.f());
        return xVarA;
    }

    private com.cmic.gen.sdk.x a(java.lang.String str, java.lang.String str2, java.lang.String str3, com.cmic.gen.sdk.y0 y0Var) {
        com.cmic.gen.sdk.x xVar = new com.cmic.gen.sdk.x(str, y0Var, str3, str2);
        if (str3.equals("GET")) {
            xVar.a("Content-Type", "application/x-www-form-urlencoded");
        }
        return xVar;
    }

    public java.lang.String a() {
        return this.a;
    }
}
