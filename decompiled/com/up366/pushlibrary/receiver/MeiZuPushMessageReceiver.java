package com.up366.pushlibrary.receiver;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeiZuPushMessageReceiver extends com.meizu.cloud.pushsdk.MzPushMessageReceiver {
    public void onPushStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus) {
    }

    public void onSubAliasStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus) {
    }

    public void onSubTagsStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus) {
    }

    public void onUnRegisterStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus) {
    }

    public void onRegisterStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus) {
        java.lang.String pushId = registerStatus.getPushId();
        com.up366.pushlibrary.LoggerProxy.info("MeiZuPushMessageReceive pushId: " + pushId);
        com.up366.pushlibrary.PushHelper.getInst().getPushInterface().sendMeiZuPushTokenToServer(pushId);
    }

    public void onNotificationClicked(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
        com.up366.pushlibrary.LoggerProxy.info("onNotificationClicked: " + mzPushMessage.toString());
        com.up366.pushlibrary.PushHelper.getInst().getPushInterface().messageSkip(mzPushMessage.getContent());
    }
}
