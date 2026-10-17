package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class f0 {
    public static java.lang.String a(java.lang.String str) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "name from", str);
        c();
        a(b());
        return d(str);
    }

    public static java.lang.String b(java.lang.String str) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "url from", str);
        c();
        b(b());
        return f(str);
    }

    public static java.lang.String c(java.lang.String str) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "slogan from", str);
        c();
        c(b());
        return e(str);
    }

    private static java.lang.String d(java.lang.String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "CMHK":
                java.lang.String str2 = com.chuanglan.shanyan_sdk.AbstractC0055l.e;
                return str2 != null ? str2 : "中国移动香港认证服务条款";
            case "CTCC":
                java.lang.String str3 = com.chuanglan.shanyan_sdk.AbstractC0055l.a;
                return str3 != null ? str3 : "天翼账号服务与隐私协议";
            case "CUCC":
                java.lang.String str4 = com.chuanglan.shanyan_sdk.AbstractC0055l.g;
                return str4 != null ? str4 : "中国联通认证服务协议";
            default:
                java.lang.String str5 = com.chuanglan.shanyan_sdk.AbstractC0055l.c;
                return str5 != null ? str5 : "中国移动认证服务条款";
        }
    }

    private static java.lang.String e(java.lang.String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "CMHK":
                java.lang.String str2 = com.chuanglan.shanyan_sdk.AbstractC0055l.l;
                return str2 != null ? str2 : "中国移动香港提供认证服务";
            case "CTCC":
                java.lang.String str3 = com.chuanglan.shanyan_sdk.AbstractC0055l.j;
                return str3 != null ? str3 : "天翼账号提供认证服务";
            case "CUCC":
                java.lang.String str4 = com.chuanglan.shanyan_sdk.AbstractC0055l.i;
                return str4 != null ? str4 : "中国联通提供认证服务";
            default:
                java.lang.String str5 = com.chuanglan.shanyan_sdk.AbstractC0055l.k;
                return str5 != null ? str5 : "中国移动提供认证服务";
        }
    }

    private static java.lang.String f(java.lang.String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "CMHK":
                java.lang.String str2 = com.chuanglan.shanyan_sdk.AbstractC0055l.f;
                return str2 != null ? str2 : "https://wap.cmpassport.com/uni-access/hkContactCm.html?language=SC";
            case "CTCC":
                java.lang.String str3 = com.chuanglan.shanyan_sdk.AbstractC0055l.b;
                return str3 != null ? str3 : "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
            case "CUCC":
                java.lang.String str4 = com.chuanglan.shanyan_sdk.AbstractC0055l.h;
                return str4 != null ? str4 : "https://auth.wosms.cn/html/oauth/protocol2.html";
            default:
                java.lang.String str5 = com.chuanglan.shanyan_sdk.AbstractC0055l.d;
                return str5 != null ? str5 : "https://wap.cmpassport.com/resources/html/contract.html";
        }
    }

    private static java.util.List a() {
        return java.util.Arrays.asList(new com.chuanglan.shanyan_sdk.tool.OperatorInfoBean("中国移动认证服务条款", "https://wap.cmpassport.com/resources/html/contract.html", "中国移动提供认证服务"), new com.chuanglan.shanyan_sdk.tool.OperatorInfoBean("中国联通认证服务协议", "https://auth.wosms.cn/html/oauth/protocol2.html", "中国联通提供认证服务"), new com.chuanglan.shanyan_sdk.tool.OperatorInfoBean("天翼账号服务与隐私协议", "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", "天翼账号提供认证服务"), new com.chuanglan.shanyan_sdk.tool.OperatorInfoBean("中国移动香港认证服务条款", "https://wap.cmpassport.com/uni-access/hkContactCm.html?language=SC", "中国移动香港提供认证服务"));
    }

    private static java.util.List b() {
        com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfigA = com.chuanglan.shanyan_sdk.tool.a.b().a();
        return shanYanUIConfigA.getOperatorInfo() != null ? new java.util.ArrayList(shanYanUIConfigA.getOperatorInfo()) : a();
    }

    private static void c() {
        com.chuanglan.shanyan_sdk.t0.h().m();
    }

    private static void a(java.util.List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            if (list.size() >= 3) {
                com.chuanglan.shanyan_sdk.AbstractC0055l.c = ((com.chuanglan.shanyan_sdk.tool.OperatorInfoBean) list.get(0)).getOperatorName();
                com.chuanglan.shanyan_sdk.AbstractC0055l.g = ((com.chuanglan.shanyan_sdk.tool.OperatorInfoBean) list.get(1)).getOperatorName();
                com.chuanglan.shanyan_sdk.AbstractC0055l.a = ((com.chuanglan.shanyan_sdk.tool.OperatorInfoBean) list.get(2)).getOperatorName();
            }
            if (list.size() >= 4) {
                com.chuanglan.shanyan_sdk.AbstractC0055l.e = ((com.chuanglan.shanyan_sdk.tool.OperatorInfoBean) list.get(3)).getOperatorName();
            }
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "updateBaseConstantsOperatorPrivacyNameIfNeeded", e);
        }
    }

    private static void c(java.util.List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            if (list.size() >= 3) {
                com.chuanglan.shanyan_sdk.AbstractC0055l.k = ((com.chuanglan.shanyan_sdk.tool.OperatorInfoBean) list.get(0)).getOperatorSloganName();
                com.chuanglan.shanyan_sdk.AbstractC0055l.i = ((com.chuanglan.shanyan_sdk.tool.OperatorInfoBean) list.get(1)).getOperatorSloganName();
                com.chuanglan.shanyan_sdk.AbstractC0055l.j = ((com.chuanglan.shanyan_sdk.tool.OperatorInfoBean) list.get(2)).getOperatorSloganName();
            }
            if (list.size() >= 4) {
                com.chuanglan.shanyan_sdk.AbstractC0055l.l = ((com.chuanglan.shanyan_sdk.tool.OperatorInfoBean) list.get(3)).getOperatorSloganName();
            }
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "updateBaseConstantsOperatorPrivacyUrlIfNeeded", e);
        }
    }

    private static void b(java.util.List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            if (list.size() >= 3) {
                com.chuanglan.shanyan_sdk.AbstractC0055l.d = ((com.chuanglan.shanyan_sdk.tool.OperatorInfoBean) list.get(0)).getOperatorUrl();
                com.chuanglan.shanyan_sdk.AbstractC0055l.h = ((com.chuanglan.shanyan_sdk.tool.OperatorInfoBean) list.get(1)).getOperatorUrl();
                com.chuanglan.shanyan_sdk.AbstractC0055l.b = ((com.chuanglan.shanyan_sdk.tool.OperatorInfoBean) list.get(2)).getOperatorUrl();
            }
            if (list.size() >= 4) {
                com.chuanglan.shanyan_sdk.AbstractC0055l.f = ((com.chuanglan.shanyan_sdk.tool.OperatorInfoBean) list.get(3)).getOperatorUrl();
            }
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "updateBaseConstantsOperatorPrivacyUrlIfNeeded", e);
        }
    }
}
