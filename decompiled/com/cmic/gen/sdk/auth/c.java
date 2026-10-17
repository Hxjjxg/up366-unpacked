package com.cmic.gen.sdk.auth;

/* JADX INFO: compiled from: AuthnResult.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class c {
    static org.json.JSONObject a(java.lang.String str, com.cmic.gen.sdk.i iVar, org.json.JSONObject jSONObject) {
        java.lang.String[] strArr = {"未知", "移动", "联通", "电信", "香港移动"};
        try {
            java.lang.String strA = iVar.a("operatortype", "0");
            if (!"0".equals(strA) && !android.text.TextUtils.isEmpty(strA)) {
                jSONObject.put("operatorType", strArr[java.lang.Integer.parseInt(strA)]);
            } else if ("103000".equals(str)) {
                jSONObject.put("operatorType", strArr[1]);
            } else {
                jSONObject.put("operatorType", strArr[0]);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static org.json.JSONObject b(java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("resultCode", str);
            jSONObject.put("desc", str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    static org.json.JSONObject a(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("resultCode", "103000");
            jSONObject.put("desc", "true");
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    static org.json.JSONObject a(java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("resultCode", str);
            jSONObject.put("desc", str2);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    static org.json.JSONObject a(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.i iVar, org.json.JSONObject jSONObject) {
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6 = "0";
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            int i = java.lang.Integer.parseInt(iVar.a("authType", "0"));
            int iB = iVar.b("networktype");
            if (i == 3) {
                if (iB == 3) {
                    str4 = "WIFI下网关鉴权";
                    str5 = "1";
                } else {
                    str4 = "网关鉴权";
                    str5 = "2";
                }
                java.lang.String str7 = str5;
                str3 = str4;
                str6 = str7;
            } else {
                str3 = "其他";
            }
            jSONObject2.put("resultCode", str);
            jSONObject2.put("authType", str6);
            jSONObject2.put("authTypeDes", str3);
            if ("103000".equals(str)) {
                if (1 == iVar.b("logintype")) {
                    jSONObject2.put("openId", iVar.c("openId"));
                }
                jSONObject2.put(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, jSONObject.optString(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN));
                jSONObject2.put("tokenExpiresIn", jSONObject.optString("tokenExpiresIn"));
            } else {
                jSONObject2.put("desc", str2);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.cmic.gen.sdk.h0.a("AuthnResult", "返回参数:" + jSONObject2.toString());
        return jSONObject2;
    }
}
