package com.igexin.sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class VivoPushMessageReceiver extends com.vivo.push.sdk.OpenClientPushMessageReceiver {
    public static final java.lang.String TAG = "Assist_VV";

    public void onReceiveRegId(android.content.Context context, java.lang.String str) {
        try {
            android.util.Log.d("Assist_VV", "onReceiveRegId :".concat(java.lang.String.valueOf(str)));
            if (context == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(context, com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, com.igexin.assist.sdk.AssistPushConsts.VIVO_PREFIX.concat(java.lang.String.valueOf(str))));
        } catch (java.lang.Throwable th) {
            android.util.Log.d("Assist_VV", th.getMessage());
        }
    }
}
