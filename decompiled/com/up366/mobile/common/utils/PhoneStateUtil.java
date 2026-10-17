package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PhoneStateUtil {
    private static android.telephony.TelephonyManager tm;

    public static void register(android.content.Context context) {
        if (tm != null) {
            return;
        }
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
        tm = telephonyManager;
        telephonyManager.listen(new android.telephony.PhoneStateListener() { // from class: com.up366.mobile.common.utils.PhoneStateUtil.1
            @Override // android.telephony.PhoneStateListener
            public void onCallStateChanged(int i, java.lang.String str) {
                super.onCallStateChanged(i, str);
                if (i == 0) {
                    com.up366.common.log.Logger.info("挂断");
                } else if (i == 1) {
                    com.up366.common.log.Logger.info("响铃:来电号码:" + str);
                } else if (i == 2) {
                    com.up366.common.log.Logger.info("接听");
                }
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.PhoneState(i));
            }
        }, 32);
    }
}
