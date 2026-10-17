package com.igexin.push.core.a.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class n implements com.igexin.push.extension.mod.PushMessageInterface {
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        java.lang.String str = ((com.igexin.push.core.b.u) baseActionBean).a;
        if (!android.text.TextUtils.isEmpty(str)) {
            java.lang.String[] strArrSplit = str.split("\\|");
            android.content.Intent intent = new android.content.Intent();
            intent.setPackage(com.igexin.push.core.e.g);
            for (java.lang.String str2 : strArrSplit) {
                if (com.igexin.push.core.b.j.equals(str2)) {
                    com.igexin.push.core.d.b.d().b();
                } else {
                    intent.setAction("com.igexin.sdk.action.updatedconfig." + str2);
                    com.igexin.push.core.e.l.sendBroadcast(intent, com.igexin.push.core.e.ac);
                }
            }
        }
        if (baseActionBean.getDoActionId().equals("")) {
            return true;
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            com.igexin.push.core.b.u uVar = new com.igexin.push.core.b.u();
            uVar.setType(com.igexin.push.core.b.t);
            uVar.setActionId(jSONObject.getString("actionid"));
            uVar.setDoActionId(jSONObject.getString("do"));
            uVar.a = jSONObject.getString("module");
            return uVar;
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
