package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class av {
    public com.unicom.online.account.kernel.bn b = null;

    public final void b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            if (this.b == null) {
                return;
            }
            if (com.unicom.online.account.kernel.bh.b(str3).booleanValue()) {
                str3 = com.unicom.online.account.kernel.bp.c();
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("resultCode", 100);
            jSONObject.put("resultMsg", str);
            jSONObject.put("seq", str3);
            if (android.text.TextUtils.isEmpty(str2)) {
                jSONObject.put("resultData", "");
            } else {
                try {
                    jSONObject.put("resultData", new org.json.JSONObject(str2));
                } catch (org.json.JSONException unused) {
                    jSONObject.put("resultData", str2);
                }
            }
            this.b.b(jSONObject.toString());
            this.b = null;
        } catch (java.lang.Exception e) {
            com.unicom.online.account.kernel.as.b(e);
        }
    }

    public final void b(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            if (this.b == null) {
                return;
            }
            if (com.unicom.online.account.kernel.bh.b(str3).booleanValue()) {
                str3 = com.unicom.online.account.kernel.bp.c();
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("resultCode", i2);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", str2);
            jSONObject.put("seq", str3);
            this.b.b(jSONObject.toString());
            this.b = null;
        } catch (java.lang.Exception e) {
            com.unicom.online.account.kernel.as.b(e);
        }
    }
}
