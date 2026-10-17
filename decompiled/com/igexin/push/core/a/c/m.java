package com.igexin.push.core.a.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class m implements com.igexin.push.extension.mod.PushMessageInterface {
    private static final java.lang.String a = com.igexin.push.core.b.f + com.igexin.push.core.a.c.m.class.getName();

    private static void a(java.lang.String str) {
        try {
            com.igexin.c.a.c.a.a(a + "|del condition taskid = " + str, new java.lang.Object[0]);
            com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{"taskid"}, new java.lang.String[]{str});
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.b(a, "del condition" + th.toString());
        }
    }

    private static void a(java.lang.String str, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        if (baseActionBean == null) {
            return;
        }
        com.igexin.push.core.b.l lVar = (com.igexin.push.core.b.l) baseActionBean;
        java.lang.String str2 = lVar.q;
        java.util.HashSet<java.lang.String> hashSet = com.igexin.push.core.e.aj.get(lVar.q);
        java.lang.Integer num = com.igexin.push.core.e.ak.get(lVar.q);
        if (hashSet != null && !hashSet.isEmpty()) {
            hashSet.remove(str);
        }
        if (android.text.TextUtils.isEmpty(str2) || num == null || hashSet == null || !hashSet.isEmpty()) {
            return;
        }
        ((android.app.NotificationManager) com.igexin.push.core.e.l.getSystemService(com.igexin.push.core.b.n)).cancel(num.intValue());
        com.igexin.push.core.e.aj.remove(str2);
        com.igexin.push.core.e.ak.remove(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016c A[PHI: r4 r5
  0x016c: PHI (r4v3 boolean) = (r4v2 boolean), (r4v10 boolean) binds: [B:63:0x0176, B:57:0x016a] A[DONT_GENERATE, DONT_INLINE]
  0x016c: PHI (r5v4 android.database.Cursor) = (r5v3 android.database.Cursor), (r5v6 android.database.Cursor) binds: [B:63:0x0176, B:57:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean executeAction(com.igexin.push.extension.mod.PushTaskBean r17, com.igexin.push.extension.mod.BaseActionBean r18) {
        /*
            Method dump skipped, instruction units count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.c.m.executeAction(com.igexin.push.extension.mod.PushTaskBean, com.igexin.push.extension.mod.BaseActionBean):boolean");
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has("taskid")) {
                return null;
            }
            com.igexin.push.core.b.t tVar = new com.igexin.push.core.b.t();
            tVar.setType(com.igexin.push.core.b.o);
            tVar.setActionId(jSONObject.getString("actionid"));
            tVar.setDoActionId(jSONObject.getString("do"));
            tVar.a = jSONObject.getString("taskid");
            tVar.b = jSONObject.optBoolean("force");
            return tVar;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
    }
}
