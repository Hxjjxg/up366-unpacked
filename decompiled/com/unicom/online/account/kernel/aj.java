package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class aj {
    public static java.lang.String b(java.lang.String str) {
        if (str == null || str.trim().isEmpty()) {
            return "";
        }
        java.util.TreeMap treeMap = new java.util.TreeMap();
        if (!str.trim().isEmpty()) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    java.lang.String next = itKeys.next();
                    treeMap.put(next, jSONObject.get(next));
                }
            } catch (java.lang.Exception e) {
                com.unicom.online.account.kernel.as.b(e);
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = true;
        for (java.util.Map.Entry entry : treeMap.entrySet()) {
            java.lang.String str2 = (java.lang.String) entry.getKey();
            java.lang.Object value = entry.getValue();
            if (str2 != null && !str2.trim().isEmpty()) {
                if (!z) {
                    sb.append("&");
                }
                sb.append(str2);
                sb.append("=");
                if (value == null) {
                    value = "";
                }
                sb.append(value);
                z = false;
            }
        }
        return sb.toString();
    }
}
