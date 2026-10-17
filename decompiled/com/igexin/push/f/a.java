package com.igexin.push.f;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class a implements com.igexin.push.f.b.c {
    private static final long b = 360000;
    private static com.igexin.push.f.a c = null;
    private static java.lang.String d = "CheckCondition";
    private long a = 0;

    public static com.igexin.push.f.a a() {
        if (c == null) {
            synchronized (com.igexin.push.f.a.class) {
                if (c == null) {
                    c = new com.igexin.push.f.a();
                }
            }
        }
        return c;
    }

    public static void c() {
        com.igexin.push.core.n nVarA = com.igexin.push.core.n.a();
        com.igexin.c.a.c.a.a("PushMessageExecutor|--------checkConditionStatus the pushMessageMap from db because log gkt...", new java.lang.Object[0]);
        try {
            if (com.igexin.push.g.c.a(java.lang.System.currentTimeMillis())) {
                com.igexin.c.a.c.a.b("PushMessageExecutor", "message in silent time , ignored...");
                return;
            }
            if (nVarA.d()) {
                return;
            }
            for (java.util.Map.Entry<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> entry : com.igexin.push.core.e.ah.entrySet()) {
                try {
                    entry.getKey();
                    com.igexin.push.extension.mod.PushTaskBean value = entry.getValue();
                    if (value != null && value.getStatus() == com.igexin.push.core.b.af) {
                        java.lang.String taskId = value.getTaskId();
                        java.util.Map<java.lang.String, java.lang.String> conditionMap = value.getConditionMap();
                        if (conditionMap == null) {
                            return;
                        }
                        if (nVarA.a(conditionMap, taskId, value)) {
                            com.igexin.push.core.n.a(taskId, value.getMessageId());
                        }
                    }
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new java.lang.Object[0]);
                }
            }
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PushMessageExecutor|" + e2.toString(), new java.lang.Object[0]);
        }
    }

    private static boolean e() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (com.igexin.push.core.e.S <= 0) {
            com.igexin.push.core.e.S = jCurrentTimeMillis - 60000;
            return true;
        }
        if (jCurrentTimeMillis - com.igexin.push.core.e.S <= 60000) {
            return false;
        }
        com.igexin.push.core.e.S = jCurrentTimeMillis;
        return true;
    }

    @Override // com.igexin.push.f.b.c
    public final void a(long j) {
        this.a = j;
    }

    public final void a(boolean z) {
        if (!z || e()) {
            b();
        }
    }

    @Override // com.igexin.push.f.b.c
    public final void b() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.f.a.1
            @Override // com.igexin.push.b.d
            public final void a_() throws java.lang.Exception {
                com.igexin.push.core.n.a().c();
            }
        }, false, true);
    }

    @Override // com.igexin.push.f.b.c
    public final boolean d() {
        return java.lang.System.currentTimeMillis() - this.a > b;
    }
}
