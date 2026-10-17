package com.igexin.push.core.a.c;

import com.igexin.push.core.e.f.AnonymousClass11;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class d implements com.igexin.push.extension.mod.PushMessageInterface {
    public static final java.lang.String a = "BasicAction";

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() + (((com.igexin.push.core.b.h) baseActionBean).a * 1000);
        com.igexin.push.core.e.f.a().a(true);
        com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
        if (com.igexin.push.core.e.X != jCurrentTimeMillis) {
            com.igexin.push.core.e.X = jCurrentTimeMillis;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass11(), false, true);
        }
        if (!baseActionBean.getDoActionId().equals("")) {
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        }
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has("duration")) {
                return null;
            }
            com.igexin.push.core.b.h hVar = new com.igexin.push.core.b.h();
            hVar.setType(jSONObject.getString("type"));
            hVar.setActionId(jSONObject.getString("actionid"));
            hVar.setDoActionId(jSONObject.getString("do"));
            if (jSONObject.has("duration")) {
                hVar.a = java.lang.Long.valueOf(jSONObject.getString("duration")).longValue();
            }
            return hVar;
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
    }
}
