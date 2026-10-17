package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class PermissionDelegateImplV30 extends com.up366.mobile.common.utils.permissions.PermissionDelegateImplV29 {
    PermissionDelegateImplV30() {
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV29, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV28, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.MANAGE_EXTERNAL_STORAGE)) {
            return isGrantedManageStoragePermission();
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV29, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV28, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.MANAGE_EXTERNAL_STORAGE)) {
            return false;
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }

    private static boolean isGrantedManageStoragePermission() {
        return android.os.Environment.isExternalStorageManager();
    }

    private static android.content.Intent getManageStoragePermissionIntent(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(com.up366.mobile.common.utils.permissions.PermissionUtils.getPackageNameUri(context));
        if (!com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent)) {
            intent = new android.content.Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
        }
        return !com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent) ? com.up366.mobile.common.utils.permissions.PermissionIntentManager.getApplicationDetailsIntent(context) : intent;
    }
}
