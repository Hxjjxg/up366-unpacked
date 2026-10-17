package com.igexin.sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OppoPushService extends com.heytap.msp.push.service.CompatibleDataMessageCallbackService {
    public static final java.lang.String TAG = "Assist_OP_PS";

    public void processMessage(android.content.Context context, com.heytap.msp.push.mode.DataMessage dataMessage) {
        try {
            android.util.Log.d(TAG, "processMessage receive app meaasge ...");
            android.util.Log.d(TAG, "processMessage receive app meaasge:".concat(java.lang.String.valueOf(dataMessage)));
            if (context != null && dataMessage != null) {
                com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(context, com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_PAYLOAD, dataMessage.getContent());
                messageBean.setMessageSource(com.igexin.assist.sdk.AssistPushConsts.OPPO_PREFIX);
                com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
            }
            com.igexin.assist.util.AssistUtils.startGetuiService(context);
        } catch (java.lang.Throwable th) {
            android.util.Log.d(TAG, th.getMessage());
        }
    }
}
