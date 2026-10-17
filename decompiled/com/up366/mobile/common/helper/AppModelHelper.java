package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppModelHelper {
    private final java.lang.String appModel;

    private static class Holder {
        private static final com.up366.mobile.common.helper.AppModelHelper HELPER = new com.up366.mobile.common.helper.AppModelHelper();

        private Holder() {
        }
    }

    private AppModelHelper() {
        this.appModel = isArmV8a() ? "STUDENT-ANDROID-MOBILE64" : com.up366.mobile.BuildConfig.APP_MODEL;
    }

    public static com.up366.mobile.common.helper.AppModelHelper getInst() {
        return com.up366.mobile.common.helper.AppModelHelper.Holder.HELPER;
    }

    public java.lang.String getAppModel() {
        return this.appModel;
    }

    private static boolean isArmV8a() {
        for (java.lang.String str : android.os.Build.SUPPORTED_ABIS) {
            if ("arm64-v8a".equals(str)) {
                return true;
            }
        }
        return false;
    }
}
