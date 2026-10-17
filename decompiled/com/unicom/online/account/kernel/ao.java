package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class ao {
    public static final java.lang.String b;
    public static final java.lang.String c;
    public static final java.lang.String d;
    public static final java.lang.String e;
    public static final java.lang.String f;
    public static final java.lang.String g;
    public static final java.lang.String h;
    public static final java.lang.String i;
    public static final java.lang.String j;
    public static final java.lang.String k;
    public static final java.lang.String l;
    public static final java.lang.String m;
    public static final java.lang.String n;
    public static java.util.ArrayList o;
    public static final java.util.HashSet p;
    public static int q;
    public static java.lang.String r;
    public static java.lang.String s;
    public static java.lang.String t;
    public static int u;
    public static java.lang.String v;

    static {
        new java.lang.String(com.unicom.online.account.kernel.aq.b("MTAwMTAuY29t"));
        new java.lang.String(com.unicom.online.account.kernel.aq.b("aWQ2Lm1l"));
        new java.lang.String(com.unicom.online.account.kernel.aq.b("Y21wYXNzcG9ydC5jb20="));
        b = new java.lang.String(com.unicom.online.account.kernel.aq.b("bXN2Ni53b3Ntcy5jbg=="));
        c = new java.lang.String(com.unicom.online.account.kernel.aq.b("YWxpLndvc21zLmNu"));
        d = new java.lang.String(com.unicom.online.account.kernel.aq.b("bS56enguY25rbG9nLmNvbQ=="));
        e = new java.lang.String(com.unicom.online.account.kernel.aq.b("dGVzdC53b3Ntcy5jbg=="));
        f = new java.lang.String(com.unicom.online.account.kernel.aq.b("YXV0aC53b3Ntcy5jbg=="));
        g = new java.lang.String(com.unicom.online.account.kernel.aq.b("c2RrbG9nLndvc21zLmNu"));
        h = new java.lang.String(com.unicom.online.account.kernel.aq.b("Ki53b3Ntcy5jbg=="));
        i = new java.lang.String(com.unicom.online.account.kernel.aq.b("Lndvc21zLmNu"));
        j = new java.lang.String(com.unicom.online.account.kernel.aq.b("L2Ryby92MS9yZXBvcnQ="));
        k = new java.lang.String(com.unicom.online.account.kernel.aq.b("L3VuaWNvbUF1dGgvYW5kcm9pZC92My4wL3Fj"));
        l = new java.lang.String(com.unicom.online.account.kernel.aq.b("L3VuaWNvbUF1dGgvYW5kcm9pZC92My4wL3Fj"));
        m = new java.lang.String(com.unicom.online.account.kernel.aq.b("L3VuaWNvbVVhaWQvYW5kcm9pZC92MS4wL3Fj"));
        n = new java.lang.String(com.unicom.online.account.kernel.aq.b("L2Nsb3VkL2FuZHJvaWQvdjMuMC9xYw=="));
        p = new java.util.HashSet();
        r = "0";
        s = "";
        t = "";
        u = 5;
        v = "";
    }

    public static void b() {
        java.lang.String strReplace = "";
        try {
            strReplace = java.util.UUID.randomUUID().toString().replace("-", "");
            if (android.text.TextUtils.isEmpty(strReplace) || strReplace.length() < 32) {
                strReplace = com.unicom.online.account.kernel.ap.j.substring(0, 32);
            }
        } catch (java.lang.Exception e2) {
            com.unicom.online.account.kernel.as.b(e2);
        }
        s = strReplace;
        c();
    }

    public static boolean c(java.lang.String str, java.lang.String str2) {
        if (!str.startsWith(str2) && !str.endsWith(str2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("CN=");
            java.lang.String str3 = h;
            sb.append(str3);
            if (!str.startsWith(sb.toString())) {
                if (!str.endsWith("CN=" + str3)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static java.lang.String c() {
        if (s.length() != 32) {
            b();
        }
        return s;
    }

    public static void c(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.unicom.online.account.kernel.t tVar;
        int i2 = 0;
        while (true) {
            if (i2 >= o.size()) {
                tVar = null;
                break;
            }
            tVar = (com.unicom.online.account.kernel.t) o.get(i2);
            if (tVar.b.equalsIgnoreCase(str) && tVar.c.equalsIgnoreCase(str2)) {
                break;
            } else {
                i2++;
            }
        }
        if (tVar != null) {
            tVar.d = "";
            tVar.e = 0L;
            boolean z = com.unicom.online.account.kernel.ap.b;
            com.unicom.online.account.kernel.bf.b(context, new java.util.ArrayList(o));
        }
    }

    public static java.lang.String b(int i2) {
        if (i2 == 12 || i2 == 13) {
            return "https://" + com.unicom.online.account.kernel.bp.d() + n + "?";
        }
        if (i2 == 24 || i2 == 25) {
            return "https://" + com.unicom.online.account.kernel.bp.d() + m + "?";
        }
        if (i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5) {
            return "https://" + com.unicom.online.account.kernel.bp.d() + l + "?";
        }
        return "https://" + com.unicom.online.account.kernel.bp.d() + k + "?";
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(java.lang.String r4, java.lang.String r5) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unicom.online.account.kernel.ao.b(java.lang.String, java.lang.String):boolean");
    }

    public static java.lang.String b(java.lang.String str) {
        if (!"cmnet".equals(str) && !"cmwap".equals(str)) {
            if ("3gwap".equals(str) || "uniwap".equals(str) || "3gnet".equals(str) || "uninet".equals(str)) {
                return "3";
            }
            return ("ctnet".equals(str) || "ctwap".equals(str)) ? "2" : "0";
        }
        return "1";
    }

    public static void b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.unicom.online.account.kernel.t tVar = new com.unicom.online.account.kernel.t();
        tVar.b = str;
        tVar.c = str2;
        if (o.isEmpty()) {
            o.add(tVar);
        } else {
            o.add(1, tVar);
            if (o.size() > 4) {
                o.remove(4);
            }
        }
        boolean z = com.unicom.online.account.kernel.ap.b;
        com.unicom.online.account.kernel.bf.b(context, new java.util.ArrayList(o));
    }

    public static void b(int i2, android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.unicom.online.account.kernel.t tVar = new com.unicom.online.account.kernel.t();
        tVar.b = str;
        tVar.c = str2;
        if (i2 < 0) {
            return;
        }
        if (i2 >= o.size()) {
            o.add(tVar);
        } else {
            o.add(i2, tVar);
        }
        while (o.size() > 4) {
            o.remove(r1.size() - 1);
        }
        boolean z = com.unicom.online.account.kernel.ap.b;
        com.unicom.online.account.kernel.bf.b(context, new java.util.ArrayList(o));
    }
}
