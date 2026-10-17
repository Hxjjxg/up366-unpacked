package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
final class GetInstalledAppsPermissionCompat {
    private static final int MIUI_OP_GET_INSTALLED_APPS_DEFAULT_VALUE = 10022;
    private static final java.lang.String MIUI_OP_GET_INSTALLED_APPS_FIELD_NAME = "OP_GET_INSTALLED_APPS";

    GetInstalledAppsPermissionCompat() {
    }

    static boolean isGrantedPermission(android.content.Context context) {
        if (!com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid4_4()) {
            return true;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid6() && isSupportGetInstalledAppsPermission(context)) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.GET_INSTALLED_APPS);
        }
        if (com.up366.mobile.common.utils.permissions.PhoneRomUtils.isMiui() && isMiuiSupportGetInstalledAppsPermission() && com.up366.mobile.common.utils.permissions.PhoneRomUtils.isMiuiOptimization()) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkOpNoThrow(context, MIUI_OP_GET_INSTALLED_APPS_FIELD_NAME, MIUI_OP_GET_INSTALLED_APPS_DEFAULT_VALUE);
        }
        return true;
    }

    static boolean isDoNotAskAgainPermission(android.app.Activity activity) {
        if (!com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid4_4()) {
            return false;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid6() && isSupportGetInstalledAppsPermission(activity)) {
            return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.GET_INSTALLED_APPS) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.GET_INSTALLED_APPS)) ? false : true;
        }
        if (com.up366.mobile.common.utils.permissions.PhoneRomUtils.isMiui() && isMiuiSupportGetInstalledAppsPermission() && com.up366.mobile.common.utils.permissions.PhoneRomUtils.isMiuiOptimization()) {
            return !isGrantedPermission(activity);
        }
        return false;
    }

    private static boolean isSupportGetInstalledAppsPermission(android.content.Context context) {
        try {
            android.content.pm.PermissionInfo permissionInfo = context.getPackageManager().getPermissionInfo(com.up366.mobile.common.utils.permissions.Permission.GET_INSTALLED_APPS, 0);
            if (permissionInfo != null) {
                return com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid9() ? permissionInfo.getProtection() == 1 : (permissionInfo.protectionLevel & 15) == 1;
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return android.provider.Settings.Secure.getInt(context.getContentResolver(), "oem_installed_apps_runtime_permission_enable") == 1;
        } catch (android.provider.Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static boolean isMiuiSupportGetInstalledAppsPermission() {
        if (!com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid4_4()) {
            return true;
        }
        try {
            java.lang.Class.forName(android.app.AppOpsManager.class.getName()).getDeclaredField(MIUI_OP_GET_INSTALLED_APPS_FIELD_NAME);
            return true;
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            return true;
        } catch (java.lang.NoSuchFieldException e2) {
            e2.printStackTrace();
            return true;
        }
    }
}
