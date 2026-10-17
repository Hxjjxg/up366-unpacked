package com.up366.pushlibrary.receiver;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MiMessageReceiver extends com.xiaomi.mipush.sdk.PushMessageReceiver {
    public void onReceivePassThroughMessage(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        com.up366.pushlibrary.LoggerProxy.info("onReceivePassThroughMessage is called. " + miPushMessage.toString());
    }

    public void onNotificationMessageClicked(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        com.up366.pushlibrary.LoggerProxy.info("onNotificationMessageClicked is called. " + miPushMessage.toString());
        com.up366.pushlibrary.PushHelper.getInst().getPushInterface().messageSkip(miPushMessage.getContent());
    }

    public void onNotificationMessageArrived(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        com.up366.pushlibrary.LoggerProxy.info("onNotificationMessageArrived is called.  " + miPushMessage.toString());
    }

    public void onCommandResult(android.content.Context context, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
        com.up366.pushlibrary.LoggerProxy.info("onCommandResult is called. " + miPushCommandMessage.toString());
    }

    public void onReceiveRegisterResult(android.content.Context context, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
        com.up366.pushlibrary.LoggerProxy.info("onReceiveRegisterResult is called. " + miPushCommandMessage.toString());
    }
}
