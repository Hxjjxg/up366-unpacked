package com.igexin.push.config;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class g {
    private static final java.lang.String a = "IDCConfigParse";

    public static void a(java.lang.String str, boolean z) {
        org.json.JSONObject jSONObject;
        java.lang.String[] strArrA;
        java.lang.String[] strArrA2;
        java.lang.String[] strArrA3;
        java.lang.String[] strArrA4;
        java.lang.String[] strArrA5;
        com.igexin.c.a.c.a.b(a, " parse idc config data : ".concat(java.lang.String.valueOf(str)));
        try {
            jSONObject = new org.json.JSONObject(str);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("N")) {
            try {
                com.igexin.push.config.SDKUrlConfig.setLocation(jSONObject.getString("N"));
            } catch (org.json.JSONException e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        if (jSONObject.has("X1") && (strArrA5 = a(jSONObject, "X1")) != null && strArrA5.length > 0) {
            com.igexin.push.config.SDKUrlConfig.setXfrAddressIps(strArrA5);
            if (z) {
                com.igexin.c.a.c.a.b("Detect_IDCConfigParse", "parse idc success, set new xfr address, reset and redetect +++++++++++++++++");
                com.igexin.push.c.c.a().e();
            }
        }
        if (jSONObject.has("X2") && (strArrA4 = a(jSONObject, "X2")) != null && strArrA4.length > 0) {
            com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK = strArrA4;
        }
        if (jSONObject.has("B") && (strArrA3 = a(jSONObject, "B")) != null && strArrA3.length > 0) {
            com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS = strArrA3;
        }
        if (jSONObject.has("C") && (strArrA2 = a(jSONObject, "C")) != null && strArrA2.length > 0) {
            com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS = strArrA2;
        }
        if (!jSONObject.has("LO") || (strArrA = a(jSONObject, "LO")) == null || strArrA.length <= 0) {
            return;
        }
        com.igexin.push.config.SDKUrlConfig.LOG_ADDRESS_IPS = strArrA;
    }

    private static java.lang.String[] a(org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            org.json.JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            java.lang.String[] strArr = new java.lang.String[length];
            for (int i = 0; i < length; i++) {
                if ("X1".equals(str) || "X2".equals(str)) {
                    strArr[i] = "socket://" + jSONArray.getString(i);
                } else {
                    strArr[i] = "https://" + jSONArray.getString(i);
                }
            }
            return strArr;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }
}
