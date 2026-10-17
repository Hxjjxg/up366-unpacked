package com.igexin.push.core.a.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class f implements com.igexin.push.extension.mod.PushMessageInterface {
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        if (pushTaskBean == null || baseActionBean == null || android.text.TextUtils.isEmpty(baseActionBean.getDoActionId())) {
            return true;
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            com.igexin.push.core.b.i iVar = new com.igexin.push.core.b.i();
            iVar.setType(com.igexin.push.core.b.s);
            iVar.setActionId(jSONObject.getString("actionid"));
            iVar.setDoActionId(jSONObject.getString("do"));
            return iVar;
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
