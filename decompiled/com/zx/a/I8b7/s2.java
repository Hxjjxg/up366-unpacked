package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class s2 {
    public static final java.util.Set<java.lang.String> b;
    public com.zx.a.I8b7.b4 a;

    static {
        java.util.HashSet hashSet = new java.util.HashSet();
        b = hashSet;
        com.zx.a.I8b7.x3.c = "core-n";
        com.zx.a.I8b7.x3.d = "3.3.7.58976";
        hashSet.add("fd39c63f1732f201");
        hashSet.add("182215c3273d3c96");
        hashSet.add("30c3b906fa3a6c10");
        hashSet.add("83e1f70a049353e0");
        hashSet.add("a14a9b473d09b4a4");
        hashSet.add("c5d0f5289411bfb1");
        hashSet.add("888db8aca12678cf");
        hashSet.add("4d34408b292920ff");
        java.util.Set<java.lang.String> set = com.zx.a.I8b7.x3.J;
        set.add("fd39c63f1732f201");
        set.add("182215c3273d3c96");
        set.add("30c3b906fa3a6c10");
        set.add("83e1f70a049353e0");
        set.add("888db8aca12678cf");
    }

    public final java.lang.String a(java.lang.String str, int i) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("data", str);
        jSONObject.put("code", i);
        return jSONObject.toString();
    }

    public java.lang.String f182215c3273d3c96(java.lang.String str) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("data", false);
        jSONObject.put("code", 0);
        return jSONObject.toString();
    }

    public java.lang.String f30c3b906fa3a6c10(java.lang.String str) throws org.json.JSONException {
        try {
            boolean z = new org.json.JSONObject(str).getBoolean("isDebug");
            android.util.Log.d("setDebug", "isDebug: " + z);
            com.zx.a.I8b7.y.a = z;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", 0);
            return jSONObject.toString();
        } catch (java.lang.Throwable th) {
            return a(th.getMessage(), 1);
        }
    }

    public void f4d34408b292920ff(java.lang.String str, com.zx.module.base.Callback callback) {
        com.zx.a.I8b7.c3.a("getAuthToken:" + str + "with cb");
        try {
            com.zx.a.I8b7.z3.b.a.b(new org.json.JSONObject(str), callback, 1);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.b("getAuthToken error:" + th);
            if (callback != null) {
                try {
                    callback.callback(a(th.getMessage(), 1));
                } catch (java.lang.Throwable th2) {
                    com.zx.a.I8b7.c3.a(th2);
                }
            }
        }
    }

    @com.zx.module.annotation.Java2C.Method2C
    public native java.lang.String f777db222212609ec(java.lang.String str) throws java.lang.Throwable;

    public java.lang.String f83e1f70a049353e0(java.lang.String str) throws org.json.JSONException {
        com.zx.a.I8b7.x3.b = new org.json.JSONObject(str).getString("version");
        return a("", 0);
    }

    public java.lang.String f888db8aca12678cf(java.lang.String str) throws org.json.JSONException {
        return a("lib not work", 1);
    }

    public void fa14a9b473d09b4a4(java.lang.String str, com.zx.module.base.Callback callback) {
        com.zx.a.I8b7.c3.a("getUAID:" + str + "with cb");
        try {
            com.zx.a.I8b7.z3.b.a.b(new org.json.JSONObject(str), callback, 0);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.b("getUAID error:" + th);
            if (callback != null) {
                try {
                    callback.callback(a(th.getMessage(), 1));
                } catch (java.lang.Throwable th2) {
                    com.zx.a.I8b7.c3.a(th2);
                }
            }
        }
    }

    public void fc5d0f5289411bfb1(java.lang.String str, com.zx.module.base.Callback callback) {
        com.zx.a.I8b7.c3.a("getTag:" + str + "with cb");
        try {
            callback.callback(a(com.zx.a.I8b7.l2.c(), 0));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.b("getTag error:" + th);
            if (callback != null) {
                try {
                    callback.callback(a(th.getMessage(), 1));
                } catch (java.lang.Throwable th2) {
                    com.zx.a.I8b7.c3.a(th2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String ffd39c63f1732f201(java.lang.String r5) throws org.json.JSONException {
        /*
            r4 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r5)
            java.lang.String r5 = "allowExpired"
            boolean r5 = r0.getBoolean(r5)
            com.zx.a.I8b7.b4 r0 = r4.a
            com.zx.a.I8b7.g4 r0 = (com.zx.a.I8b7.g4) r0
            r0.getClass()
            if (r5 == 0) goto L19
            java.lang.String r5 = com.zx.a.I8b7.x3.a()
            goto L5f
        L19:
            java.lang.String r5 = com.zx.a.I8b7.x3.i
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L22
            goto L5e
        L22:
            java.lang.String r0 = "-"
            java.lang.String[] r0 = r5.split(r0)     // Catch: java.lang.Exception -> L40
            r1 = 1
            r0 = r0[r1]     // Catch: java.lang.Exception -> L40
            long r0 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Exception -> L40
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L40
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 < 0) goto L3b
            goto L5e
        L3b:
            java.lang.String r5 = com.zx.a.I8b7.x3.a()
            goto L5f
        L40:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "zid判断过期异常:"
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = ", err :"
            r1.append(r5)
            java.lang.String r5 = r0.getMessage()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            com.zx.a.I8b7.c3.b(r5)
        L5e:
            r5 = 0
        L5f:
            r0 = 0
            java.lang.String r5 = r4.a(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.s2.ffd39c63f1732f201(java.lang.String):java.lang.String");
    }
}
