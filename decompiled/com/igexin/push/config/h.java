package com.igexin.push.config;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class h {
    public static final java.lang.String a = "MetaDataConfig";

    private static void a() {
        try {
            android.os.Bundle bundle = com.igexin.push.g.o.b(com.igexin.push.core.e.l).metaData;
            if (bundle == null || !bundle.keySet().contains("PUSH_DOMAIN")) {
                return;
            }
            com.igexin.c.a.c.a.b(a, "PUSH_DOMAIN:" + bundle.getString("PUSH_DOMAIN"));
            java.lang.String string = bundle.getString("PUSH_DOMAIN");
            com.igexin.push.config.SDKUrlConfig.setXfrAddressIps(new java.lang.String[]{"socket://xfr." + string + ":5224"});
            java.lang.StringBuilder sb = new java.lang.StringBuilder("XFR_ADDRESS_IPS:");
            sb.append(com.igexin.push.config.SDKUrlConfig.getXfrAddress()[0]);
            com.igexin.c.a.c.a.b(a, sb.toString());
            com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK = new java.lang.String[]{"socket://xfr_bak." + string + ":5224"};
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("XFR_ADDRESS_IPS_BAK:");
            sb2.append(com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK[0]);
            com.igexin.c.a.c.a.a(sb2.toString(), new java.lang.Object[0]);
            com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS = new java.lang.String[]{"https://bi." + string + "/api.php"};
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder("BI_ADDRESS_IPS:");
            sb3.append(com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS[0]);
            com.igexin.c.a.c.a.b(a, sb3.toString());
            com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS = new java.lang.String[]{"https://config." + string + "/api.php"};
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder("CONFIG_ADDRESS_IPS:");
            sb4.append(com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS[0]);
            com.igexin.c.a.c.a.b(a, sb4.toString());
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(e.toString(), new java.lang.Object[0]);
        }
    }

    private static void a(java.lang.String str) {
        com.igexin.push.config.SDKUrlConfig.setXfrAddressIps(new java.lang.String[]{"socket://xfr." + str + ":5224"});
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XFR_ADDRESS_IPS:");
        sb.append(com.igexin.push.config.SDKUrlConfig.getXfrAddress()[0]);
        com.igexin.c.a.c.a.b(a, sb.toString());
        com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK = new java.lang.String[]{"socket://xfr_bak." + str + ":5224"};
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("XFR_ADDRESS_IPS_BAK:");
        sb2.append(com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK[0]);
        com.igexin.c.a.c.a.a(sb2.toString(), new java.lang.Object[0]);
        com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS = new java.lang.String[]{"https://bi." + str + "/api.php"};
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder("BI_ADDRESS_IPS:");
        sb3.append(com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS[0]);
        com.igexin.c.a.c.a.b(a, sb3.toString());
        com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS = new java.lang.String[]{"https://config." + str + "/api.php"};
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder("CONFIG_ADDRESS_IPS:");
        sb4.append(com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS[0]);
        com.igexin.c.a.c.a.b(a, sb4.toString());
    }
}
