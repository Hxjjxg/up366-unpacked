package com.up366.pushlibrary.receiver;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class VivoMessageReceiver extends com.vivo.push.sdk.OpenClientPushMessageReceiver {
    public void onNotificationMessageClicked(android.content.Context context, com.vivo.push.model.UPSNotificationMessage uPSNotificationMessage) {
        com.up366.pushlibrary.LoggerProxy.info("onNotificationClicked: " + uPSNotificationMessage.toString());
        com.up366.pushlibrary.PushHelper.getInst().getPushInterface().messageSkip(uPSNotificationMessage.getContent());
    }

    public void onReceiveRegId(android.content.Context context, java.lang.String str) {
        com.up366.pushlibrary.LoggerProxy.info("VivoMessageReceiver regId: " + str);
        com.up366.pushlibrary.PushHelper.getInst().getPushInterface().sendVivoPushTokenToServer(str);
    }
}
