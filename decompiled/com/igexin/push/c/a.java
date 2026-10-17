package com.igexin.push.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class a {
    static final java.lang.String a = com.igexin.push.c.b.a + com.igexin.push.c.a.class.getName();
    private static final int q = 10;
    int b;
    protected int g;
    protected volatile long h;
    protected volatile long i;
    boolean j;
    private int l;
    private int m;
    private com.igexin.push.c.d n;
    final java.util.List<com.igexin.push.c.d> c = new java.util.ArrayList();
    private final java.util.List<com.igexin.push.c.a.b> o = new java.util.ArrayList();
    final java.lang.Object d = new java.lang.Object();
    private final java.lang.Object p = new java.lang.Object();
    public volatile com.igexin.push.c.a.EnumC0017a e = com.igexin.push.c.a.EnumC0017a.NORMAL;
    private int r = 0;
    public java.util.concurrent.atomic.AtomicBoolean f = new java.util.concurrent.atomic.AtomicBoolean(false);
    final java.util.Comparator<com.igexin.push.c.d> k = new java.util.Comparator<com.igexin.push.c.d>() { // from class: com.igexin.push.c.a.1
        private static int a(com.igexin.push.c.d dVar, com.igexin.push.c.d dVar2) {
            return (int) (dVar.c() - dVar2.c());
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.igexin.push.c.d dVar, com.igexin.push.c.d dVar2) {
            return (int) (dVar.c() - dVar2.c());
        }
    };

    /* JADX INFO: renamed from: com.igexin.push.c.a$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.igexin.push.c.a.EnumC0017a.values().length];
            a = iArr;
            try {
                iArr[com.igexin.push.c.a.EnumC0017a.NORMAL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.igexin.push.c.a.EnumC0017a.BACKUP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.igexin.push.c.a.EnumC0017a.TRY_NORMAL.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.c.a$a, reason: collision with other inner class name */
    protected enum EnumC0017a {
        NORMAL(0),
        BACKUP(1),
        TRY_NORMAL(2);

        int d;

        EnumC0017a(int i) {
            this.d = i;
        }

        private int a() {
            return this.d;
        }

        public static com.igexin.push.c.a.EnumC0017a a(int i) {
            for (com.igexin.push.c.a.EnumC0017a enumC0017a : values()) {
                if (enumC0017a.d == i) {
                    return enumC0017a;
                }
            }
            return null;
        }
    }

    public static final class b {
        public java.lang.String a;
        public long b;

        public final com.igexin.push.c.a.b a(org.json.JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            try {
                this.a = jSONObject.getString("address");
                this.b = jSONObject.getLong("outdateTime");
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            return this;
        }

        public final org.json.JSONObject a() {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("address", this.a);
                jSONObject.put("outdateTime", this.b);
                return jSONObject;
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
                return null;
            }
        }

        public final java.lang.String toString() {
            return "ServerAddress{address='" + this.a + "', outdateTime=" + this.b + '}';
        }
    }

    private java.lang.String a(boolean z) {
        try {
            synchronized (this.p) {
                java.lang.String str = this.j ? com.igexin.push.core.e.at : com.igexin.push.core.e.au;
                if (this.o.isEmpty() && android.text.TextUtils.isEmpty(str)) {
                    com.igexin.c.a.c.a.a(a + "cm list size = 0", new java.lang.Object[0]);
                    this.m = 0;
                    this.l = 0;
                    return null;
                }
                if (this.o.isEmpty() && !android.text.TextUtils.isEmpty(str)) {
                    a(str);
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.lang.String str2 = a;
                sb.append(str2);
                sb.append("cm try = ");
                sb.append(this.m);
                sb.append(" times");
                com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
                if (this.m >= this.o.size()) {
                    com.igexin.c.a.c.a.a(str2 + "cm invalid", new java.lang.Object[0]);
                    this.m = 0;
                    this.l = 0;
                    this.o.clear();
                    return null;
                }
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                java.util.Iterator<com.igexin.push.c.a.b> it = this.o.iterator();
                while (it.hasNext()) {
                    com.igexin.push.c.a.b next = it.next();
                    if (next.b < jCurrentTimeMillis) {
                        com.igexin.c.a.c.a.a(a + "|add[" + next.a + "] outDate", new java.lang.Object[0]);
                        it.remove();
                    }
                }
                h();
                if (this.o.isEmpty()) {
                    return null;
                }
                if (z) {
                    this.m++;
                }
                int i = this.l >= this.o.size() ? 0 : this.l;
                this.l = i;
                java.lang.String str3 = this.o.get(i).a;
                this.l++;
                return str3;
            }
        } catch (java.lang.Exception e) {
            java.lang.String str4 = a;
            com.igexin.c.a.c.a.a(str4, e.toString());
            com.igexin.c.a.c.a.a(str4 + "|" + e.toString(), new java.lang.Object[0]);
            return null;
        }
    }

    private void a(java.lang.String str) {
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.o.add(new com.igexin.push.c.a.b().a(jSONArray.getJSONObject(i)));
            }
            com.igexin.c.a.c.a.a(a + "|get cm from cache, isWf = " + this.j + ", lastCmList = " + str, new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private java.lang.String b(boolean z) {
        java.lang.String strA;
        synchronized (this.d) {
            int i = this.b >= this.c.size() ? 0 : this.b;
            this.b = i;
            com.igexin.push.c.d dVar = this.c.get(i);
            this.n = dVar;
            strA = dVar.a(z);
        }
        return strA;
    }

    private void c(boolean z) {
        this.j = z;
    }

    private java.util.List<com.igexin.push.c.a.b> g() {
        return this.o;
    }

    private void h() {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<com.igexin.push.c.a.b> it = this.o.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        com.igexin.push.core.e.f.a().c(jSONArray.length() == 0 ? com.igexin.push.core.b.m : jSONArray.toString(), !this.j);
    }

    private void i() {
        synchronized (this.d) {
            this.b = 0;
            java.util.Collections.sort(this.c, this.k);
        }
    }

    private void j() {
        com.igexin.c.a.c.a.a(a + "|detect success, current type = " + this.e, new java.lang.Object[0]);
        if (this.e == com.igexin.push.c.a.EnumC0017a.BACKUP) {
            a(com.igexin.push.c.a.EnumC0017a.TRY_NORMAL);
            com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
            com.igexin.push.e.a.a(true);
        }
    }

    private void k() {
        com.igexin.c.a.c.a.a(a + "|before disconnect, type = " + this.e, new java.lang.Object[0]);
        int i = com.igexin.push.c.a.AnonymousClass2.a[this.e.ordinal()];
        if (i != 1) {
            if (i == 2 && java.lang.System.currentTimeMillis() - this.h > com.igexin.push.config.d.r) {
                a(com.igexin.push.c.a.EnumC0017a.TRY_NORMAL);
                return;
            }
            return;
        }
        if (java.lang.System.currentTimeMillis() - this.i <= 86400000 || this.g <= com.igexin.push.config.d.t) {
            return;
        }
        a(com.igexin.push.c.a.EnumC0017a.BACKUP);
    }

    final synchronized void a(com.igexin.push.c.a.EnumC0017a enumC0017a) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str = a;
        sb.append(str);
        sb.append("|set domain type = ");
        sb.append(enumC0017a);
        com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
        if (com.igexin.push.config.d.g) {
            if (this.e != enumC0017a) {
                a((java.util.List<com.igexin.push.c.a.b>) null);
            }
            int i = com.igexin.push.c.a.AnonymousClass2.a[enumC0017a.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.f.set(true);
                    if (this.e != enumC0017a) {
                        this.h = java.lang.System.currentTimeMillis();
                    }
                    com.igexin.push.config.SDKUrlConfig.setConnectAddress(com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK[0]);
                    com.igexin.push.config.SDKUrlConfig.getConnectAddress();
                    com.igexin.c.a.c.a.a(str + "|set domain type backup cm = " + com.igexin.push.config.SDKUrlConfig.getConnectAddress(), new java.lang.Object[0]);
                } else if (i == 3) {
                    if (this.e != enumC0017a) {
                        this.r = 0;
                    }
                }
                this.e = enumC0017a;
                com.igexin.push.c.c.a().f().n();
            }
            this.b = 0;
            com.igexin.push.config.SDKUrlConfig.setConnectAddress(b(true));
            if (enumC0017a == com.igexin.push.c.a.EnumC0017a.NORMAL) {
                this.f.set(false);
            }
            com.igexin.push.config.SDKUrlConfig.getConnectAddress();
            com.igexin.c.a.c.a.a(str + "|set domain type normal cm = " + com.igexin.push.config.SDKUrlConfig.getConnectAddress(), new java.lang.Object[0]);
            this.e = enumC0017a;
            com.igexin.push.c.c.a().f().n();
        }
    }

    public final void a(java.util.List<com.igexin.push.c.a.b> list) {
        synchronized (this.p) {
            this.l = 0;
            this.m = 0;
            this.o.clear();
            if (list != null) {
                this.o.addAll(list);
                com.igexin.c.a.c.a.a(a + "|set cm list: " + list.toString(), new java.lang.Object[0]);
            }
            h();
        }
    }

    public final boolean a() {
        boolean z;
        try {
            com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
            z = true;
            boolean z2 = !com.igexin.push.e.a.d();
            java.lang.String strA = a(z2);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str = a;
            sb.append(str);
            sb.append("|get from cm = ");
            sb.append(strA);
            com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
            if (strA == null) {
                if (com.igexin.push.config.d.g && this.e == com.igexin.push.c.a.EnumC0017a.BACKUP) {
                    this.b = this.b >= com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK.length ? 0 : this.b;
                    java.lang.String[] strArr = com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK;
                    int i = this.b;
                    java.lang.String str2 = strArr[i];
                    this.b = i + 1;
                    z = false;
                    strA = str2;
                } else {
                    com.igexin.push.c.d dVar = this.n;
                    if (dVar != null && !dVar.d()) {
                        this.b++;
                    }
                    strA = b(z2);
                    z = false;
                }
            }
            try {
                if (!com.igexin.push.config.SDKUrlConfig.getConnectAddress().equals(strA)) {
                    com.igexin.push.config.SDKUrlConfig.getConnectAddress();
                    com.igexin.c.a.c.a.a(str + "|address changed : form [" + com.igexin.push.config.SDKUrlConfig.getConnectAddress() + "] to [" + strA + "]", new java.lang.Object[0]);
                }
                com.igexin.push.config.SDKUrlConfig.setConnectAddress(strA);
            } catch (java.lang.Exception e) {
                e = e;
                com.igexin.c.a.c.a.a(e);
                java.lang.String str3 = a;
                com.igexin.c.a.c.a.a(str3, e.toString());
                com.igexin.c.a.c.a.a(str3 + "|switch address|" + e.toString(), new java.lang.Object[0]);
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            z = false;
        }
        return z;
    }

    public final synchronized void b() {
        this.m = 0;
        com.igexin.push.c.d dVar = this.n;
        if (dVar != null) {
            dVar.e();
        }
    }

    public final void b(java.util.List<com.igexin.push.c.d> list) {
        synchronized (this.d) {
            this.c.clear();
            this.c.addAll(list);
            java.util.Collections.sort(this.c, this.k);
        }
    }

    public final synchronized void c() {
        this.g++;
        com.igexin.c.a.c.a.a(a + "|loginFailedCnt = " + this.g, new java.lang.Object[0]);
    }

    public final void d() {
        if (com.igexin.push.c.a.AnonymousClass2.a[this.e.ordinal()] == 2 && java.lang.System.currentTimeMillis() - this.h > com.igexin.push.config.d.r) {
            a(com.igexin.push.c.a.EnumC0017a.TRY_NORMAL);
        }
    }

    public final void e() {
        if (this.e != com.igexin.push.c.a.EnumC0017a.BACKUP) {
            this.g = 0;
        }
        int i = com.igexin.push.c.a.AnonymousClass2.a[this.e.ordinal()];
        if (i == 1) {
            this.i = java.lang.System.currentTimeMillis();
            com.igexin.push.c.c.a().f().n();
            this.f.set(false);
        } else {
            if (i != 3) {
                return;
            }
            a(com.igexin.push.c.a.EnumC0017a.NORMAL);
            this.f.set(false);
        }
    }

    public final void f() {
        com.igexin.push.c.a.EnumC0017a enumC0017a;
        com.igexin.c.a.c.a.a(a + "|before disconnect, type = " + this.e, new java.lang.Object[0]);
        int i = com.igexin.push.c.a.AnonymousClass2.a[this.e.ordinal()];
        if (i != 1) {
            if (i == 2 && java.lang.System.currentTimeMillis() - this.h > com.igexin.push.config.d.r) {
                enumC0017a = com.igexin.push.c.a.EnumC0017a.TRY_NORMAL;
                a(enumC0017a);
            }
        } else if (java.lang.System.currentTimeMillis() - this.i > 86400000 && this.g > com.igexin.push.config.d.t) {
            enumC0017a = com.igexin.push.c.a.EnumC0017a.BACKUP;
            a(enumC0017a);
        }
        if (com.igexin.push.core.e.u && this.e != com.igexin.push.c.a.EnumC0017a.BACKUP) {
            this.i = java.lang.System.currentTimeMillis();
            com.igexin.push.c.c.a().f().n();
        }
        if (com.igexin.push.c.a.AnonymousClass2.a[this.e.ordinal()] != 3) {
            return;
        }
        int i2 = this.r + 1;
        this.r = i2;
        if (i2 >= 10) {
            this.g = 0;
            this.h = java.lang.System.currentTimeMillis();
            a(com.igexin.push.c.a.EnumC0017a.BACKUP);
        }
    }
}
