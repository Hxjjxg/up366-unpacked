package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class AbstractC0049f {
    public static boolean a(int i) {
        return new java.util.Random().nextInt(100) < i;
    }

    public static boolean b(java.lang.String str) {
        return (str == null || com.igexin.push.core.b.m.equals(str) || "".equals(str)) ? false : true;
    }

    public static java.lang.String c(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.lang.String strA = com.chuanglan.shanyan_sdk.f0.a(str);
        java.lang.String strB = com.chuanglan.shanyan_sdk.f0.b(str);
        try {
            jSONObject.put("telecom", str);
            jSONObject.put("protocolName", strA);
            jSONObject.put("protocolUrl", strB);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "operatorInfoToJsonString  Exception_e=", e);
        }
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "operatorInfo", jSONObject);
        return jSONObject.toString();
    }

    public static boolean a(java.lang.String str) {
        return str == null || "".equals(str) || str.trim().length() == 0 || com.igexin.push.core.b.m.equals(str);
    }

    public static java.lang.String a(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("innerCode", i);
            jSONObject.put("innerDesc", str);
            jSONObject.put("message", str2);
            jSONObject.put("number", "");
            jSONObject.put("telecom", str3);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static java.lang.String a(int i, java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("innerCode", i);
            jSONObject.put("innerDesc", str);
            jSONObject.put("message", str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static java.lang.String a(int i, java.lang.String str, java.lang.String str2, android.content.Context context) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("innerCode", i);
            jSONObject.put("innerDesc", str);
            jSONObject.put("message", str2);
            jSONObject.put("number", com.chuanglan.shanyan_sdk.AbstractC0055l.p);
            jSONObject.put("telecom", com.chuanglan.shanyan_sdk.AbstractC0055l.m);
            jSONObject.put("protocolName", com.chuanglan.shanyan_sdk.AbstractC0055l.n);
            jSONObject.put("protocolUrl", com.chuanglan.shanyan_sdk.AbstractC0055l.o);
            com.chuanglan.shanyan_sdk.p0.b(context, "cl_jm_f6", com.chuanglan.shanyan_sdk.AbstractC0055l.m);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static java.lang.String a(int i, java.lang.String str) {
        java.lang.String strE;
        if (str == null) {
            return str;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.AUTH_TOKEN_SUCCESS_CODE;
            if (enumC0060q.d() != i && com.chuanglan.shanyan_sdk.EnumC0060q.LOGIN_SUCCESS_CODE.d() != i) {
                strE = jSONObject.optString("message");
                if (a(strE)) {
                    return str;
                }
            } else if (jSONObject.has(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN)) {
                strE = enumC0060q.e();
            } else {
                strE = com.chuanglan.shanyan_sdk.EnumC0060q.OPEN_PAGE_SUCCESS_CODE.e();
            }
            return strE;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", str, "getJsonMessage  Exception", e);
            return str;
        }
    }
}
