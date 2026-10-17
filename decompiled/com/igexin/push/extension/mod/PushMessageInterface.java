package com.igexin.push.extension.mod;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface PushMessageInterface {

    public enum ActionPrepareState {
        success,
        wait,
        stop
    }

    boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean);

    com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject);

    com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean);
}
