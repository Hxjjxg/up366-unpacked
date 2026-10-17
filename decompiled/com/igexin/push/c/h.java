package com.igexin.push.c;

import com.igexin.push.c.e.AnonymousClass1;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class h {
    private static final java.lang.String e = com.igexin.push.c.b.a + com.igexin.push.c.h.class.getName();
    protected long a;
    private android.os.Handler i;
    protected final java.util.Map<java.lang.String, com.igexin.push.c.e> b = new java.util.LinkedHashMap();
    protected final java.util.Map<java.lang.String, com.igexin.push.c.d> c = new java.util.HashMap();
    private final java.lang.Object f = new java.lang.Object();
    private final java.lang.Object g = new java.lang.Object();
    protected com.igexin.push.c.a d = new com.igexin.push.c.a();
    private final java.util.Comparator<java.util.Map.Entry<java.lang.String, com.igexin.push.c.d>> h = new java.util.Comparator<java.util.Map.Entry<java.lang.String, com.igexin.push.c.d>>() { // from class: com.igexin.push.c.h.1
        private static int a(java.util.Map.Entry<java.lang.String, com.igexin.push.c.d> entry, java.util.Map.Entry<java.lang.String, com.igexin.push.c.d> entry2) {
            return (int) (entry.getValue().c() - entry2.getValue().c());
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(java.util.Map.Entry<java.lang.String, com.igexin.push.c.d> entry, java.util.Map.Entry<java.lang.String, com.igexin.push.c.d> entry2) {
            return (int) (entry.getValue().c() - entry2.getValue().c());
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:6:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.h.<init>(java.lang.String, java.lang.String):void");
    }

    private static com.igexin.push.c.d a(org.json.JSONObject jSONObject) throws java.lang.Exception {
        if (!jSONObject.has("domain")) {
            return null;
        }
        com.igexin.push.c.d dVar = new com.igexin.push.c.d();
        dVar.a(jSONObject.getString("domain"));
        if (jSONObject.has("port")) {
            dVar.b = jSONObject.getInt("port");
        }
        if (jSONObject.has("ip")) {
            dVar.a = jSONObject.getString("ip");
        }
        if (jSONObject.has("consumeTime")) {
            dVar.c = jSONObject.getLong("consumeTime");
        }
        if (jSONObject.has("detectSuccessTime")) {
            dVar.d = jSONObject.getLong("detectSuccessTime");
        }
        if (jSONObject.has("isDomain")) {
            dVar.e = jSONObject.getBoolean("isDomain");
        }
        return dVar;
    }

    private static java.util.List<java.lang.String> a(org.json.JSONArray jSONArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(jSONArray.getJSONObject(i).getString("domain"));
            } catch (java.lang.Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        return arrayList;
    }

    private void a() {
        this.a = 0L;
        if (r()) {
            if (com.igexin.push.core.e.ap != null) {
                com.igexin.push.core.e.f.a().b(com.igexin.push.core.b.m, true);
            }
        } else if (com.igexin.push.core.e.aq != null) {
            com.igexin.push.core.e.f.a().b(com.igexin.push.core.b.m, false);
        }
        java.util.List<java.lang.String> defaultXfrList = com.igexin.push.config.SDKUrlConfig.getDefaultXfrList();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : defaultXfrList) {
            com.igexin.push.c.d dVar = new com.igexin.push.c.d(str, java.lang.Integer.parseInt(com.igexin.c.a.b.g.a(str)[2]));
            if (defaultXfrList.size() > 1) {
                b(dVar);
            }
            arrayList.add(dVar);
        }
        this.d.b(arrayList);
        defaultXfrList.clear();
    }

    private static java.util.List<java.lang.String> b() {
        return com.igexin.push.config.SDKUrlConfig.getDefaultXfrList();
    }

    private void b(com.igexin.push.c.d dVar) {
        com.igexin.push.c.e eVar = new com.igexin.push.c.e();
        eVar.d = c() == com.igexin.push.c.b.EnumC0018b.a;
        eVar.a(d());
        eVar.b = dVar;
        synchronized (this.g) {
            this.b.put(dVar.a(), eVar);
        }
    }

    private void b(java.lang.String str) {
        org.json.JSONObject jSONObject;
        if (android.text.TextUtils.isEmpty(str)) {
            a();
            return;
        }
        org.json.JSONArray jSONArray = null;
        try {
            jSONObject = new org.json.JSONObject(str);
        } catch (org.json.JSONException e2) {
            com.igexin.c.a.c.a.a(e2);
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            a();
            return;
        }
        if (jSONObject.has("lastDetectTime")) {
            try {
                this.a = jSONObject.getLong("lastDetectTime");
            } catch (org.json.JSONException e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - this.a) >= com.igexin.push.c.b.c) {
            a();
            return;
        }
        if (jSONObject.has("list")) {
            try {
                jSONArray = jSONObject.getJSONArray("list");
            } catch (org.json.JSONException e4) {
                com.igexin.c.a.c.a.a(e4);
            }
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            a();
            return;
        }
        java.util.List<java.lang.String> listA = a(jSONArray);
        if (listA.isEmpty()) {
            a();
            return;
        }
        java.util.List<java.lang.String> defaultXfrList = com.igexin.push.config.SDKUrlConfig.getDefaultXfrList();
        java.util.ArrayList arrayList = new java.util.ArrayList(defaultXfrList);
        arrayList.retainAll(listA);
        if (arrayList.size() == listA.size()) {
            java.lang.String str2 = e;
            com.igexin.c.a.c.a.a(str2, "db cache xfr == default, use cache");
            com.igexin.c.a.c.a.a(str2 + " | db cache xfr == default, use cache", new java.lang.Object[0]);
            b(jSONArray);
            return;
        }
        java.lang.String str3 = e;
        com.igexin.c.a.c.a.a(str3, "db cache xfr != default, use default");
        com.igexin.c.a.c.a.a(str3 + " | db cache xfr != default, use default", new java.lang.Object[0]);
        arrayList.clear();
        defaultXfrList.clear();
        listA.clear();
        a();
    }

    private void b(org.json.JSONArray jSONArray) {
        com.igexin.push.c.d dVar;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("domain")) {
                    dVar = new com.igexin.push.c.d();
                    dVar.a(jSONObject.getString("domain"));
                    if (jSONObject.has("port")) {
                        dVar.b = jSONObject.getInt("port");
                    }
                    if (jSONObject.has("ip")) {
                        dVar.a = jSONObject.getString("ip");
                    }
                    if (jSONObject.has("consumeTime")) {
                        dVar.c = jSONObject.getLong("consumeTime");
                    }
                    if (jSONObject.has("detectSuccessTime")) {
                        dVar.d = jSONObject.getLong("detectSuccessTime");
                    }
                    if (jSONObject.has("isDomain")) {
                        dVar.e = jSONObject.getBoolean("isDomain");
                    }
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    this.c.put(dVar.a(), dVar);
                } else {
                    try {
                        dVar = d(jSONObject.getString("domain"));
                    } catch (java.lang.Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                        com.igexin.c.a.c.a.a(e + "|initWithCacheData exception " + e2.toString(), new java.lang.Object[0]);
                        this.c.clear();
                        a();
                        return;
                    }
                }
                if (dVar != null) {
                    b(dVar);
                    arrayList.add(dVar);
                }
            } catch (java.lang.Exception e3) {
                com.igexin.c.a.c.a.a(e3);
                com.igexin.c.a.c.a.a(e + "|initWithCacheData exception " + e3.toString(), new java.lang.Object[0]);
                return;
            }
        }
        this.d.b(arrayList);
    }

    private void c(java.lang.String str) {
        org.json.JSONObject jSONObject;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject = new org.json.JSONObject(str);
        } catch (org.json.JSONException e2) {
            com.igexin.c.a.c.a.a(e2);
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        if (jSONObject.has("loginFailedlCnt")) {
            try {
                this.d.g = jSONObject.getInt("loginFailedlCnt");
            } catch (org.json.JSONException e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
        if (jSONObject.has("lastChange2BackupTime")) {
            try {
                this.d.h = jSONObject.getLong("lastChange2BackupTime");
            } catch (org.json.JSONException e4) {
                com.igexin.c.a.c.a.a(e4);
            }
        }
        if (jSONObject.has("lastOfflineTime")) {
            try {
                this.d.i = jSONObject.getLong("lastOfflineTime");
            } catch (org.json.JSONException e5) {
                com.igexin.c.a.c.a.a(e5);
            }
        }
        if (jSONObject.has("domainType")) {
            try {
                this.d.e = com.igexin.push.c.a.EnumC0017a.a(jSONObject.getInt("domainType"));
                if (this.d.e == com.igexin.push.c.a.EnumC0017a.BACKUP) {
                    this.d.f.set(true);
                }
            } catch (org.json.JSONException e6) {
                com.igexin.c.a.c.a.a(e6);
            }
        }
    }

    private static com.igexin.push.c.d d(java.lang.String str) {
        com.igexin.push.c.d dVar = new com.igexin.push.c.d();
        java.lang.String[] strArrA = com.igexin.c.a.b.g.a(str);
        dVar.a(str);
        dVar.b = java.lang.Integer.parseInt(strArrA[2]);
        return dVar;
    }

    protected static void k() {
        com.igexin.push.core.e.f.a().b(com.igexin.push.core.b.m, true);
        com.igexin.push.core.e.f.a().b(com.igexin.push.core.b.m, false);
    }

    private void p() {
        synchronized (this.f) {
            this.c.clear();
        }
    }

    private boolean q() {
        long jAbs = java.lang.Math.abs(java.lang.System.currentTimeMillis() - this.a);
        if (jAbs >= (com.igexin.push.c.b.c * 2) - 3600) {
            long j = com.igexin.push.c.b.c;
            com.igexin.c.a.c.a.a(e + "|current time - last detect time > " + (com.igexin.push.c.b.c / 1000) + " s, detect = true", new java.lang.Object[0]);
            com.igexin.push.c.f.a.set(true);
            return true;
        }
        if (!com.igexin.push.c.f.a.getAndSet(true)) {
            long jAbs2 = java.lang.Math.abs(com.igexin.push.c.b.c - jAbs);
            com.igexin.push.c.f.g().a(jAbs2, java.util.concurrent.TimeUnit.MILLISECONDS);
            com.igexin.c.a.c.a.a(e + "|set next detect time = " + jAbs2, new java.lang.Object[0]);
        }
        return false;
    }

    private boolean r() {
        return c() == com.igexin.push.c.b.EnumC0018b.b;
    }

    protected final com.igexin.push.c.e a(java.lang.String str) {
        synchronized (this.g) {
            for (java.util.Map.Entry<java.lang.String, com.igexin.push.c.e> entry : this.b.entrySet()) {
                if (entry.getKey().equals(str)) {
                    return entry.getValue();
                }
            }
            return null;
        }
    }

    protected final void a(com.igexin.push.c.d dVar) {
        synchronized (this.f) {
            this.c.put(dVar.a(), dVar);
        }
        com.igexin.push.c.a aVar = this.d;
        synchronized (aVar.d) {
            aVar.b = 0;
            java.util.Collections.sort(aVar.c, aVar.k);
        }
    }

    public abstract int c();

    public abstract com.igexin.push.c.i d();

    public final void e() {
        long jAbs = java.lang.Math.abs(java.lang.System.currentTimeMillis() - this.a);
        if (jAbs < (com.igexin.push.c.b.c * 2) - 3600) {
            if (!com.igexin.push.c.f.a.getAndSet(true)) {
                long jAbs2 = java.lang.Math.abs(com.igexin.push.c.b.c - jAbs);
                com.igexin.push.c.f.g().a(jAbs2, java.util.concurrent.TimeUnit.MILLISECONDS);
                com.igexin.c.a.c.a.a(e + "|set next detect time = " + jAbs2, new java.lang.Object[0]);
            }
            com.igexin.c.a.c.a.a(e + "|startDetect detect = false, return !!!", new java.lang.Object[0]);
            return;
        }
        long j = com.igexin.push.c.b.c;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str = e;
        sb.append(str);
        sb.append("|current time - last detect time > ");
        sb.append(com.igexin.push.c.b.c / 1000);
        sb.append(" s, detect = true");
        com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
        com.igexin.push.c.f.a.set(true);
        com.igexin.c.a.c.a.a(str + "|startDetect detect = true, start detect !!!", new java.lang.Object[0]);
        i();
    }

    public final void f() {
        synchronized (this.g) {
            for (java.util.Map.Entry<java.lang.String, com.igexin.push.c.e> entry : this.b.entrySet()) {
                entry.getValue().a((com.igexin.push.c.i) null);
                entry.getValue().a();
            }
        }
    }

    public final void g() {
        f();
        p();
        java.util.List<java.lang.String> defaultXfrList = com.igexin.push.config.SDKUrlConfig.getDefaultXfrList();
        synchronized (this.g) {
            int size = this.b.size();
            if (defaultXfrList.size() < size) {
                int size2 = size - defaultXfrList.size();
                java.util.Iterator<java.util.Map.Entry<java.lang.String, com.igexin.push.c.e>> it = this.b.entrySet().iterator();
                for (int i = 0; it.hasNext() && i < size2; i++) {
                    it.next().getValue().b();
                    it.remove();
                }
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(this.b.values());
            this.b.clear();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (int i2 = 0; i2 < defaultXfrList.size(); i2++) {
                com.igexin.push.c.d dVar = new com.igexin.push.c.d();
                java.lang.String[] strArrA = com.igexin.c.a.b.g.a(defaultXfrList.get(i2));
                dVar.a(defaultXfrList.get(i2));
                dVar.b = java.lang.Integer.parseInt(strArrA[2]);
                if (i2 < size) {
                    com.igexin.push.c.e eVar = (com.igexin.push.c.e) arrayList.get(i2);
                    eVar.b = dVar;
                    this.b.put(dVar.a(), eVar);
                } else {
                    b(dVar);
                }
                arrayList2.add(dVar);
            }
            this.d.b(arrayList2);
        }
    }

    public final void h() {
        f();
        p();
        java.util.List<java.lang.String> defaultXfrList = com.igexin.push.config.SDKUrlConfig.getDefaultXfrList();
        synchronized (this.g) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.igexin.push.c.e>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().b();
            }
            this.b.clear();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.igexin.push.c.d dVar = new com.igexin.push.c.d();
            java.lang.String[] strArrA = com.igexin.c.a.b.g.a(defaultXfrList.get(0));
            dVar.a(defaultXfrList.get(0));
            dVar.b = java.lang.Integer.parseInt(strArrA[2]);
            arrayList.add(dVar);
            this.d.b(arrayList);
            arrayList.clear();
        }
    }

    public final void i() {
        this.a = java.lang.System.currentTimeMillis();
        synchronized (this.g) {
            for (java.util.Map.Entry<java.lang.String, com.igexin.push.c.e> entry : this.b.entrySet()) {
                entry.getValue();
                entry.getValue().a(d());
                if (entry.getValue().b != null) {
                    entry.getValue().b.b();
                }
                com.igexin.push.c.e value = entry.getValue();
                synchronized (com.igexin.push.c.i.class) {
                    if (value.c != null) {
                        value.a = com.igexin.b.a.a().a.submit(value.new AnonymousClass1());
                    }
                }
            }
        }
    }

    public final synchronized void j() {
        this.a = java.lang.System.currentTimeMillis();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        synchronized (this.g) {
            try {
                jSONObject.put("lastDetectTime", this.a);
                jSONObject.put("list", jSONArray);
                java.util.Iterator<java.util.Map.Entry<java.lang.String, com.igexin.push.c.e>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    org.json.JSONObject jSONObjectF = it.next().getValue().b.f();
                    if (jSONObjectF != null) {
                        jSONArray.put(jSONObjectF);
                    }
                }
            } catch (java.lang.Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        if (jSONObject.length() > 0) {
            if (r()) {
                com.igexin.push.core.e.f.a().b(jSONObject.toString(), true);
                return;
            }
            com.igexin.push.core.e.f.a().b(jSONObject.toString(), false);
        }
    }

    protected final synchronized void l() {
        com.igexin.push.c.a aVar = this.d;
        com.igexin.push.c.a.EnumC0017a enumC0017a = aVar.e;
        com.igexin.c.a.c.a.a(com.igexin.push.c.a.a + "|detect success, current type = " + aVar.e, new java.lang.Object[0]);
        if (aVar.e == com.igexin.push.c.a.EnumC0017a.BACKUP) {
            aVar.a(com.igexin.push.c.a.EnumC0017a.TRY_NORMAL);
            com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
            com.igexin.push.e.a.a(true);
        }
    }

    public final void m() {
        synchronized (com.igexin.push.c.h.class) {
            if (this.i == null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("NetDetect-T");
                handlerThread.start();
                this.i = new android.os.Handler(handlerThread.getLooper());
            }
        }
        this.i.removeCallbacksAndMessages("detToken");
        this.i.postAtTime(new java.lang.Runnable() { // from class: com.igexin.push.c.h.2
            @Override // java.lang.Runnable
            public final void run() {
                java.lang.String unused = com.igexin.push.c.h.e;
                try {
                    com.igexin.push.c.h.this.j();
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        }, "detToken", android.os.SystemClock.uptimeMillis() + com.igexin.push.config.c.s);
    }

    protected final synchronized void n() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("loginFailedlCnt", this.d.g);
            jSONObject.put("lastChange2BackupTime", this.d.h);
            jSONObject.put("lastOfflineTime", this.d.i);
            jSONObject.put("domainType", this.d.e.d);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
        if (jSONObject.length() > 0) {
            if (r()) {
                com.igexin.push.core.e.f.a().a(jSONObject.toString(), true);
                return;
            }
            com.igexin.push.core.e.f.a().a(jSONObject.toString(), false);
        }
    }
}
