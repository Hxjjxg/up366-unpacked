package com.igexin.sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MiuiPushReceiver extends com.xiaomi.mipush.sdk.PushMessageReceiver {
    public static final java.lang.String TAG = "Assist_XM";

    public void onCommandResult(android.content.Context context, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
        android.util.Log.d("Assist_XM", "onCommandResult receive command:".concat(java.lang.String.valueOf(miPushCommandMessage)));
    }

    public void onNotificationMessageArrived(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        android.util.Log.d("Assist_XM", "onNotificationArrived receive message ...");
        android.util.Log.d("Assist_XM", "onNotificationArrived receive message:".concat(java.lang.String.valueOf(miPushMessage)));
    }

    public void onNotificationMessageClicked(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        try {
            android.util.Log.d("Assist_XM", "onNotificationMessageClicked receive message ...");
            android.util.Log.d("Assist_XM", "onNotificationMessageClicked receive message:".concat(java.lang.String.valueOf(miPushMessage)));
            if (context != null && miPushMessage != null) {
                com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(context, com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_PAYLOAD, miPushMessage.getContent());
                messageBean.setMessageSource(com.igexin.assist.sdk.AssistPushConsts.XM_PREFIX);
                com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
            }
            com.igexin.assist.util.AssistUtils.startGetuiService(context);
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_XM", th.getMessage());
        }
    }

    public void onReceivePassThroughMessage(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        try {
            android.util.Log.d("Assist_XM", "onReceivePassThroughMessage receive message ...");
            android.util.Log.d("Assist_XM", "onReceivePassThroughMessage receive message:".concat(java.lang.String.valueOf(miPushMessage)));
            if (context != null && miPushMessage != null) {
                com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(context, com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_PAYLOAD, miPushMessage.getContent());
                messageBean.setMessageSource(com.igexin.assist.sdk.AssistPushConsts.XM_PREFIX);
                com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
            }
            com.igexin.assist.util.AssistUtils.startGetuiService(context);
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_XM", th.getMessage());
        }
    }

    public void onReceiveRegisterResult(android.content.Context context, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
        try {
            android.util.Log.d("Assist_XM", "onReceiveRegisterResult receiver message:".concat(java.lang.String.valueOf(miPushCommandMessage)));
            if (context == null || miPushCommandMessage == null) {
                return;
            }
            java.lang.String command = miPushCommandMessage.getCommand();
            java.util.List commandArguments = miPushCommandMessage.getCommandArguments();
            java.lang.String str = (commandArguments == null || commandArguments.size() <= 0) ? null : (java.lang.String) commandArguments.get(0);
            if ("register".equals(command) && miPushCommandMessage.getResultCode() == 0) {
                com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(context, com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, com.igexin.assist.sdk.AssistPushConsts.XM_PREFIX.concat(java.lang.String.valueOf(str))));
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_XM", th.getMessage());
        }
    }
}
