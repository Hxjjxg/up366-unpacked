package com.igexin.sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FlymePushReceiver extends com.meizu.cloud.pushsdk.MzPushMessageReceiver {
    public static final java.lang.String CONTENT = "content";
    public static final java.lang.String MSG_KEY_PAYLOAD = "gt_payload";
    public static final java.lang.String MZ_STATUS_BAR_SMALL_ICON = "mz_push_notification_small_icon";
    public static final java.lang.String TAG = "Assist_MZ";
    private android.content.Context context;
    private int statusBarIconId;

    public void onNotificationArrived(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
        android.util.Log.d("Assist_MZ", "onNotificationArrived receive msg ...");
        android.util.Log.d("Assist_MZ", "onNotificationArrived receive msg:".concat(java.lang.String.valueOf(mzPushMessage)));
    }

    public void onNotificationClicked(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
        try {
            android.util.Log.d("Assist_MZ", "onNotificationClicked receive msg ...");
            android.util.Log.d("Assist_MZ", "onNotificationClicked receive msg:" + mzPushMessage.getTitle() + ":" + mzPushMessage.getContent() + ":" + mzPushMessage.getSelfDefineContentString());
            java.lang.String selfDefineContentString = mzPushMessage.getSelfDefineContentString();
            if (context != null && !android.text.TextUtils.isEmpty(selfDefineContentString)) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(selfDefineContentString);
                    if (jSONObject.has(MSG_KEY_PAYLOAD)) {
                        selfDefineContentString = jSONObject.getString(MSG_KEY_PAYLOAD);
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                if (!android.text.TextUtils.isEmpty(selfDefineContentString)) {
                    com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(context, com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_PAYLOAD, selfDefineContentString);
                    messageBean.setMessageSource(com.igexin.assist.sdk.AssistPushConsts.MZ_PREFIX);
                    com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
                }
            }
            com.igexin.assist.util.AssistUtils.startGetuiService(context);
        } catch (java.lang.Throwable th2) {
            android.util.Log.d("Assist_MZ", th2.getMessage());
        }
    }

    public void onPushStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus) {
        android.util.Log.d("Assist_MZ", "onPushStatus:".concat(java.lang.String.valueOf(pushSwitchStatus)));
    }

    public void onReceive(android.content.Context context, android.content.Intent intent) {
        this.context = context.getApplicationContext();
        super.onReceive(context, intent);
    }

    public void onRegisterStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus) {
        try {
            android.util.Log.d("Assist_MZ", "onRegisterStatus :".concat(java.lang.String.valueOf(registerStatus)));
            java.lang.String pushId = registerStatus.getPushId();
            if (context == null || android.text.TextUtils.isEmpty(pushId)) {
                return;
            }
            com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(context, com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, com.igexin.assist.sdk.AssistPushConsts.MZ_PREFIX.concat(java.lang.String.valueOf(pushId))));
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_MZ", th.getMessage());
        }
    }

    public void onSubAliasStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus) {
    }

    public void onSubTagsStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus) {
    }

    public void onUnRegisterStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus) {
        android.util.Log.d("Assist_MZ", "onUnRegisterStatus:".concat(java.lang.String.valueOf(unRegisterStatus)));
    }
}
