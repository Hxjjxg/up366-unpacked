package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class g1 {
    public com.zx.sdk.api.ZXID a(java.lang.String str, java.lang.String str2) {
        java.lang.String string = null;
        if (android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        com.zx.sdk.api.ZXID zxid = new com.zx.sdk.api.ZXID();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(jSONObject.getString("ext"));
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("aids").optJSONObject(str);
            zxid.setAids(jSONObjectOptJSONObject == null ? "" : jSONObjectOptJSONObject.toString());
            org.json.JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("tags");
            if (jSONArrayOptJSONArray != null) {
                string = jSONArrayOptJSONArray.toString();
            }
            zxid.setTags(string);
            java.lang.String strOptString = jSONObject.optString("zid");
            zxid.setValue(strOptString);
            java.lang.String[] strArrSplit = strOptString.split("-");
            zxid.setVersion(strArrSplit[0]);
            zxid.setExpiredTime(java.lang.Long.parseLong(strArrSplit[1]) * 1000);
            java.lang.String strOptString2 = jSONObject2.optString("openid");
            if (!android.text.TextUtils.isEmpty(strOptString2) && !"OPENID_CLOSED".equals(strOptString2)) {
                zxid.setOpenid(strOptString2);
            }
            zxid.setOT(jSONObject2.optInt("ot"));
            org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("taids");
            if (jSONObjectOptJSONObject2 != null) {
                zxid.setTaid(jSONObjectOptJSONObject2.optString(str, ""));
            }
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.c3.a(e);
        }
        return zxid;
    }

    public abstract void a(java.lang.String str);
}
