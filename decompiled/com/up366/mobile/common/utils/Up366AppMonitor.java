package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Up366AppMonitor {
    public static void initUmeng(android.app.Application application) {
        com.tencent.tauth.Tencent.setIsPermissionGranted(true, android.os.Build.MODEL);
        com.umeng.commonsdk.UMConfigure.setLogEnabled(false);
        com.umeng.commonsdk.UMConfigure.enableIccidCollection(false);
        com.umeng.commonsdk.UMConfigure.enableImeiCollection(false);
        com.umeng.commonsdk.UMConfigure.enableImsiCollection(false);
        com.umeng.commonsdk.UMConfigure.enableWiFiMacCollection(false);
        com.umeng.commonsdk.UMConfigure.preInit(application, com.up366.mobile.BuildConfig.UMENG_APPKEY, com.up366.mobile.BuildConfig.UMENG_CHANNEL);
        com.umeng.commonsdk.UMConfigure.init(application, com.up366.mobile.BuildConfig.UMENG_APPKEY, com.up366.mobile.BuildConfig.UMENG_CHANNEL, 1, (java.lang.String) null);
        com.umeng.analytics.MobclickAgent.setScenarioType(application, com.umeng.analytics.MobclickAgent.EScenarioType.E_UM_NORMAL);
        com.umeng.socialize.PlatformConfig.setWeixin("wx2365a1ae1308d623", "f196f53017e1ce480adfc1e50e6d2841");
        com.umeng.socialize.PlatformConfig.setQQZone("1102079355", "gU7VO7eibjNLX2hT");
        com.umeng.socialize.PlatformConfig.setWXFileProvider(com.up366.mobile.BuildConfig.APPLICATION_ID);
        com.umeng.socialize.PlatformConfig.setQQFileProvider(com.up366.mobile.BuildConfig.APPLICATION_ID);
        com.umeng.socialize.PlatformConfig.setAlipay("2015092500325292");
    }

    public static void onActivityResume(android.app.Activity activity) {
        if (!isContainsFragment(activity)) {
            com.umeng.analytics.MobclickAgent.onPageStart(activity.getClass().getSimpleName());
        }
        com.umeng.analytics.MobclickAgent.onResume(activity);
    }

    public static void onActivityPause(android.app.Activity activity) {
        if (!isContainsFragment(activity)) {
            com.umeng.analytics.MobclickAgent.onPageEnd(activity.getClass().getSimpleName());
        }
        com.umeng.analytics.MobclickAgent.onPause(activity);
    }

    public static void onFragmentResume(androidx.fragment.app.Fragment fragment) {
        com.umeng.analytics.MobclickAgent.onPageStart(fragment.getClass().getSimpleName());
    }

    public static void onFragmentPause(androidx.fragment.app.Fragment fragment) {
        com.umeng.analytics.MobclickAgent.onPageEnd(fragment.getClass().getSimpleName());
    }

    private static boolean isContainsFragment(android.app.Activity activity) {
        if (activity == null) {
            return false;
        }
        java.lang.String simpleName = activity.getClass().getSimpleName();
        return simpleName.equals("MainActivity") || simpleName.equals("StudyActivity");
    }
}
