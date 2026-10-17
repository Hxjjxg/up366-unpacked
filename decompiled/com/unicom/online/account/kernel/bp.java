package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class bp {
    public static volatile com.unicom.online.account.kernel.bp c;
    public static java.lang.ref.WeakReference d;
    public final java.util.concurrent.ExecutorService b = java.util.concurrent.Executors.newSingleThreadExecutor();

    public static android.content.Context b() {
        java.lang.ref.WeakReference weakReference = d;
        if (weakReference != null) {
            return (android.content.Context) weakReference.get();
        }
        return null;
    }

    public static java.lang.String c() {
        java.lang.String str = com.unicom.online.account.kernel.u.b;
        if (!android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        return "seqEmpty" + java.lang.System.currentTimeMillis() + "-" + java.util.UUID.randomUUID().toString().substring(0, 6);
    }

    public static java.lang.String d() {
        if (com.unicom.online.account.kernel.bh.b(com.unicom.online.account.kernel.ap.i).booleanValue()) {
            com.unicom.online.account.kernel.ap.i = com.unicom.online.account.kernel.ao.b;
        }
        return com.unicom.online.account.kernel.ap.i;
    }

    public static com.unicom.online.account.kernel.bp e() {
        if (c == null) {
            synchronized (com.unicom.online.account.kernel.bp.class) {
                if (c == null) {
                    c = new com.unicom.online.account.kernel.bp();
                }
            }
        }
        return c;
    }

    public final void f() {
        boolean z = com.unicom.online.account.kernel.ap.b;
        try {
            android.content.Context contextB = b();
            java.lang.String str = com.unicom.online.account.kernel.ao.b;
            java.util.ArrayList arrayListB = com.unicom.online.account.kernel.bf.b(contextB);
            com.unicom.online.account.kernel.ao.o = arrayListB;
            if (arrayListB.isEmpty()) {
                com.unicom.online.account.kernel.ao.b(b(), d(), "443");
                com.unicom.online.account.kernel.ao.b(1, b(), com.unicom.online.account.kernel.ao.f, "443");
            }
        } catch (java.lang.Exception unused) {
            com.unicom.online.account.kernel.ao.o = new java.util.ArrayList();
        }
        this.b.submit(new com.unicom.online.account.kernel.bo(this));
    }

    public static void b(int i, android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        if (str.equals("_Token_")) {
            java.lang.String strConcat = str.concat("_isOk_");
            if (i != 2 && i != 3 && i != 4 && i != 5) {
                str3 = "";
            } else {
                str3 = "T" + i;
            }
            if (com.unicom.online.account.kernel.bh.c(str2).booleanValue()) {
                java.lang.String strB = com.unicom.online.account.kernel.c.b(1, context, str3, strConcat);
                if (com.unicom.online.account.kernel.bh.c(strB).booleanValue()) {
                    try {
                        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("cuAuthCacheName", 0).edit();
                        editorEdit.putString(strB, str2);
                        editorEdit.commit();
                    } catch (java.lang.Exception e) {
                        e.getMessage();
                    }
                }
            }
        }
    }

    public static java.lang.String b(int i, int i2, java.lang.String str, int i3, int i4, int i5, java.lang.String str2) {
        com.unicom.online.account.kernel.ak akVar = com.unicom.online.account.kernel.an.b;
        if (!com.unicom.online.account.kernel.ap.b) {
            return "";
        }
        if (com.unicom.online.account.kernel.bh.b(str).booleanValue()) {
            c();
        }
        try {
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
            linkedHashMap.put("result", java.lang.Integer.valueOf(i));
            linkedHashMap.put("type", java.lang.Integer.valueOf(i2));
            linkedHashMap.put("os", 1);
            linkedHashMap.put("apiKey", com.unicom.online.account.kernel.ap.j);
            linkedHashMap.put("seq", com.unicom.online.account.kernel.u.b);
            linkedHashMap.put("ret_code", java.lang.Integer.valueOf(i3));
            linkedHashMap.put("sdk_v", "6.3.3CR001B1208");
            linkedHashMap.put("setTime", java.lang.Integer.valueOf(i4));
            int i6 = com.unicom.online.account.kernel.ao.q;
            linkedHashMap.put("netType", java.lang.Integer.valueOf(i6 != 0 ? i6 != 1 ? i6 != 2 ? -1 : 0 : 2 : 1));
            linkedHashMap.put("newNetworkErrMsg", com.unicom.online.account.kernel.ao.v);
            linkedHashMap.put("access_process", new com.unicom.online.account.kernel.al());
            linkedHashMap.put("err_info", new com.unicom.online.account.kernel.am(str2, i5));
            return new org.json.JSONObject(linkedHashMap).toString();
        } catch (java.lang.Exception e) {
            com.unicom.online.account.kernel.as.b(e);
            return "";
        }
    }
}
