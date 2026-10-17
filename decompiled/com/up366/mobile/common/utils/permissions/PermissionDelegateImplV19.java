package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class PermissionDelegateImplV19 extends com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18 {
    PermissionDelegateImplV19() {
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.NOTIFICATION_SERVICE)) {
            return com.up366.mobile.common.utils.permissions.NotificationPermissionCompat.isGrantedPermission(context);
        }
        if (!com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid13() && com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.POST_NOTIFICATIONS)) {
            return com.up366.mobile.common.utils.permissions.NotificationPermissionCompat.isGrantedPermission(context);
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.SYSTEM_ALERT_WINDOW)) {
            return false;
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.GET_INSTALLED_APPS)) {
            return com.up366.mobile.common.utils.permissions.GetInstalledAppsPermissionCompat.isDoNotAskAgainPermission(activity);
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.NOTIFICATION_SERVICE)) {
            return false;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid13() || !com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.POST_NOTIFICATIONS)) {
            return super.isDoNotAskAgainPermission(activity, str);
        }
        return false;
    }
}
