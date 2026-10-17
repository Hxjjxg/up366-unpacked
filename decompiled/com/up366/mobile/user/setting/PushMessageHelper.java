package com.up366.mobile.user.setting;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PushMessageHelper {
    private static java.lang.String PUSH_MESSAGE_KEY = "pushMessageSwitch";
    private static com.up366.mobile.user.setting.PushMessageHelper helper = new com.up366.mobile.user.setting.PushMessageHelper();
    private static boolean pushMessageState;

    private PushMessageHelper() {
        pushMessageState = com.up366.mobile.common.utils.PreferenceUtils.getBoolean(PUSH_MESSAGE_KEY, true);
    }

    public static com.up366.mobile.user.setting.PushMessageHelper getInst() {
        return helper;
    }

    public boolean getPushMessageState() {
        return pushMessageState;
    }

    public void switchPushMessageState() {
        boolean z = !pushMessageState;
        pushMessageState = z;
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean(PUSH_MESSAGE_KEY, java.lang.Boolean.valueOf(z));
    }
}
