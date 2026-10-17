package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class bf {
    public static void b(android.content.Context context, java.util.ArrayList arrayList) {
        if (arrayList.size() == 0) {
            return;
        }
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                com.unicom.online.account.kernel.t tVar = (com.unicom.online.account.kernel.t) arrayList.get(i);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("domain", tVar.b);
                jSONObject.put("port", tVar.c);
                jSONObject.put("ip", tVar.d);
                jSONObject.put("expire", tVar.e);
                jSONArray.put(jSONObject);
            }
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("cu_auth", 0).edit();
            editorEdit.putString("DNSCache_TCP_V2.0", jSONArray.toString());
            editorEdit.apply();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static java.util.ArrayList b(android.content.Context context) {
        try {
            java.lang.String string = context.getSharedPreferences("cu_auth", 0).getString("DNSCache_TCP_V2.0", null);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (string != null && !string.isEmpty()) {
                org.json.JSONArray jSONArray = new org.json.JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                    com.unicom.online.account.kernel.t tVar = new com.unicom.online.account.kernel.t();
                    tVar.b = jSONObject.optString("domain");
                    java.lang.String strOptString = jSONObject.optString("port");
                    tVar.c = strOptString;
                    if (android.text.TextUtils.isEmpty(strOptString)) {
                        tVar.c = "443";
                    } else {
                        try {
                            int i2 = java.lang.Integer.parseInt(tVar.c);
                            if (i2 <= 0 || i2 > 65535) {
                                tVar.c = "443";
                            }
                        } catch (java.lang.NumberFormatException unused) {
                            tVar.c = "443";
                        }
                    }
                    tVar.d = jSONObject.optString("ip");
                    tVar.e = jSONObject.optLong("expire");
                    arrayList.add(tVar);
                }
            }
            return arrayList;
        } catch (java.lang.Exception e) {
            e.getMessage();
            e.printStackTrace();
            return new java.util.ArrayList();
        }
    }
}
