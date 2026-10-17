package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class PermissionDelegateImplV21 extends com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19 {
    PermissionDelegateImplV21() {
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.PACKAGE_USAGE_STATS)) {
            return isGrantedPackagePermission(context);
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.PACKAGE_USAGE_STATS)) {
            return false;
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }

    private static boolean isGrantedPackagePermission(android.content.Context context) {
        return com.up366.mobile.common.utils.permissions.PermissionUtils.checkOpNoThrow(context, "android:get_usage_stats");
    }

    private static android.content.Intent getPackagePermissionIntent(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.settings.USAGE_ACCESS_SETTINGS");
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid10()) {
            intent.setData(com.up366.mobile.common.utils.permissions.PermissionUtils.getPackageNameUri(context));
        }
        return !com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent) ? com.up366.mobile.common.utils.permissions.PermissionIntentManager.getApplicationDetailsIntent(context) : intent;
    }
}
