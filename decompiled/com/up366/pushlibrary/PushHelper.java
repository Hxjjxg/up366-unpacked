package com.up366.pushlibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PushHelper {
    private static final com.up366.pushlibrary.PushHelper HELPER = new com.up366.pushlibrary.PushHelper();
    private com.up366.pushlibrary.IPushInterface pushInterface;
    private java.lang.String regId = "";

    public static com.up366.pushlibrary.PushHelper getInst() {
        return HELPER;
    }

    public void init(boolean z, com.up366.pushlibrary.IPushInterface iPushInterface) {
        this.pushInterface = iPushInterface;
        com.heytap.msp.push.HeytapPushManager.init(com.up366.common.global.GB.get().getApplicationContext(), true);
        try {
            com.vivo.push.PushConfig.Builder builder = new com.vivo.push.PushConfig.Builder();
            builder.agreePrivacyStatement(z);
            com.vivo.push.PushClient.getInstance(com.up366.common.global.GB.get().getApplicationContext()).initialize(builder.build());
        } catch (java.lang.Exception e) {
            com.up366.pushlibrary.LoggerProxy.error("init error " + e.getMessage());
        }
    }

    public com.up366.pushlibrary.IPushInterface getPushInterface() {
        com.up366.pushlibrary.IPushInterface iPushInterface = this.pushInterface;
        return iPushInterface != null ? iPushInterface : new com.up366.pushlibrary.DefaultPushInterface();
    }

    public java.lang.String getVivoRegId() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.regId)) {
            com.vivo.push.PushClient.getInstance(com.up366.common.global.GB.get().getApplicationContext()).getRegId(new com.vivo.push.listener.IPushQueryActionListener() { // from class: com.up366.pushlibrary.PushHelper.1
                public void onFail(java.lang.Integer num) {
                }

                public void onSuccess(java.lang.String str) {
                    com.up366.pushlibrary.PushHelper.this.regId = str;
                }
            });
        }
        return this.regId;
    }
}
