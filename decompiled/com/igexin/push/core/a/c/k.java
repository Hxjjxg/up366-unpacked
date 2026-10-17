package com.igexin.push.core.a.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class k implements com.igexin.push.extension.mod.PushMessageInterface {
    private static final java.lang.String a = com.igexin.push.config.c.a;

    public static void a(java.lang.String str, android.content.Context context) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            android.content.Intent intentA = com.igexin.push.g.d.a(str);
            intentA.setPackage(context.getPackageName());
            intentA.addFlags(268435456);
            context.startActivity(intentA);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        java.lang.String id;
        java.lang.String messageId;
        java.lang.String doActionId;
        com.igexin.push.core.b.r rVar = (com.igexin.push.core.b.r) baseActionBean;
        try {
            android.content.Intent intentA = com.igexin.push.g.d.a(rVar.b);
            intentA.setPackage(com.igexin.push.core.e.l.getPackageName());
            intentA.addFlags(268435456);
            if (com.igexin.push.g.c.b(intentA, com.igexin.push.core.e.l)) {
                com.igexin.push.core.e.l.startActivity(intentA);
                com.igexin.push.core.a.b.d();
                id = pushTaskBean.getTaskId();
                messageId = pushTaskBean.getMessageId();
                doActionId = rVar.getDoActionId();
            } else {
                java.lang.String str = a;
                com.igexin.c.a.c.a.a(str, "execute failed, activity not exist");
                com.igexin.c.a.c.a.a(str + "|execute failed, activity not exist", new java.lang.Object[0]);
                com.igexin.push.core.a.b.d();
                id = pushTaskBean.getId();
                messageId = pushTaskBean.getMessageId();
                doActionId = rVar.a;
            }
            com.igexin.push.core.a.b.a(id, messageId, doActionId);
            return true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getId(), pushTaskBean.getMessageId(), rVar.a);
            return true;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has("type") || !jSONObject.has("uri") || !jSONObject.has("do_failed")) {
                return null;
            }
            java.lang.String strOptString = jSONObject.optString("uri");
            if (android.text.TextUtils.isEmpty(strOptString)) {
                return null;
            }
            com.igexin.push.core.b.r rVar = new com.igexin.push.core.b.r();
            rVar.setType(com.igexin.push.core.b.p);
            rVar.setActionId(jSONObject.getString("actionid"));
            rVar.setDoActionId(jSONObject.getString("do"));
            rVar.b = strOptString;
            rVar.a = jSONObject.optString("do_failed");
            return rVar;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        com.igexin.push.core.b.r rVar = (com.igexin.push.core.b.r) baseActionBean;
        try {
            android.content.Intent intentA = com.igexin.push.g.d.a(rVar.b);
            intentA.setPackage(com.igexin.push.core.e.l.getPackageName());
            intentA.addFlags(268435456);
            if (com.igexin.push.g.c.b(intentA, com.igexin.push.core.e.l)) {
                return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
            }
            java.lang.String str = a;
            com.igexin.c.a.c.a.a(str, "execute failed, activity not exist");
            com.igexin.c.a.c.a.a(str + "|execute failed, activity not exist", new java.lang.Object[0]);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getId(), pushTaskBean.getMessageId(), rVar.a);
            return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.stop;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getId(), pushTaskBean.getMessageId(), rVar.a);
            return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.stop;
        }
    }
}
