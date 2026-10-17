package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
final class PermissionIntentManager {
    private static final java.lang.String COLOR_OS_SAFE_CENTER_APP_PACKAGE_NAME_1 = "com.oppo.safe";
    private static final java.lang.String COLOR_OS_SAFE_CENTER_APP_PACKAGE_NAME_2 = "com.color.safecenter";
    private static final java.lang.String COLOR_OS_SAFE_CENTER_APP_PACKAGE_NAME_3 = "com.oplus.safecenter";
    private static final java.lang.String EMUI_MOBILE_MANAGER_APP_PACKAGE_NAME = "com.huawei.systemmanager";
    private static final java.lang.String MIUI_MOBILE_MANAGER_APP_PACKAGE_NAME = "com.miui.securitycenter";
    private static final java.lang.String ORIGIN_OS_MOBILE_MANAGER_APP_PACKAGE_NAME = "com.iqoo.secure";

    PermissionIntentManager() {
    }

    static android.content.Intent getOriginOsWindowPermissionPageIntent(android.content.Context context) {
        android.content.Intent vivoMobileManagerAppIntent = getVivoMobileManagerAppIntent(context);
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, vivoMobileManagerAppIntent)) {
            return vivoMobileManagerAppIntent;
        }
        return null;
    }

    static android.content.Intent getOneUiWindowPermissionPageIntent(android.content.Context context) {
        return getOneUiPermissionPageIntent(context);
    }

    static android.content.Intent getOriginOsPermissionPageIntent(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("permission.intent.action.softPermissionDetail");
        intent.putExtra("packagename", context.getPackageName());
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent)) {
            return intent;
        }
        return null;
    }

    static android.content.Intent getOneUiPermissionPageIntent(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$AppOpsDetailsActivity");
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("package", context.getPackageName());
        intent.putExtra(":settings:show_fragment_args", bundle);
        intent.setData(com.up366.mobile.common.utils.permissions.PermissionUtils.getPackageNameUri(context));
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent)) {
            return intent;
        }
        return null;
    }

    static android.content.Intent getHuaWeiMobileManagerAppIntent(android.content.Context context) {
        android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(EMUI_MOBILE_MANAGER_APP_PACKAGE_NAME);
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    static android.content.Intent getXiaoMiMobileManagerAppIntent(android.content.Context context) {
        android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(MIUI_MOBILE_MANAGER_APP_PACKAGE_NAME);
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    static android.content.Intent getOppoSafeCenterAppIntent(android.content.Context context) {
        android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(COLOR_OS_SAFE_CENTER_APP_PACKAGE_NAME_1);
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        android.content.Intent launchIntentForPackage2 = context.getPackageManager().getLaunchIntentForPackage(COLOR_OS_SAFE_CENTER_APP_PACKAGE_NAME_2);
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, launchIntentForPackage2)) {
            return launchIntentForPackage2;
        }
        android.content.Intent launchIntentForPackage3 = context.getPackageManager().getLaunchIntentForPackage(COLOR_OS_SAFE_CENTER_APP_PACKAGE_NAME_3);
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, launchIntentForPackage3)) {
            return launchIntentForPackage3;
        }
        return null;
    }

    static android.content.Intent getVivoMobileManagerAppIntent(android.content.Context context) {
        android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(ORIGIN_OS_MOBILE_MANAGER_APP_PACKAGE_NAME);
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    static android.content.Intent getApplicationDetailsIntent(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(com.up366.mobile.common.utils.permissions.PermissionUtils.getPackageNameUri(context));
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent)) {
            return intent;
        }
        android.content.Intent intent2 = new android.content.Intent("android.settings.APPLICATION_SETTINGS");
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent2)) {
            return intent2;
        }
        android.content.Intent intent3 = new android.content.Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
        return com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent3) ? intent3 : getAndroidSettingAppIntent();
    }

    static android.content.Intent getAndroidSettingAppIntent() {
        return new android.content.Intent("android.settings.SETTINGS");
    }
}
