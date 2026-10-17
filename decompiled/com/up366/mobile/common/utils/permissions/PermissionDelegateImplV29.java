package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class PermissionDelegateImplV29 extends com.up366.mobile.common.utils.permissions.PermissionDelegateImplV28 {
    PermissionDelegateImplV29() {
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV28, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCESS_MEDIA_LOCATION)) {
            return hasReadStoragePermission(context) && com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.ACCESS_MEDIA_LOCATION);
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCESS_BACKGROUND_LOCATION) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACTIVITY_RECOGNITION)) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, str);
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid11() || !com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.MANAGE_EXTERNAL_STORAGE) || isUseDeprecationExternalStorage()) {
            return super.isGrantedPermission(context, str);
        }
        return false;
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV28, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCESS_BACKGROUND_LOCATION)) {
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION)) {
                return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, str) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return !com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION);
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCESS_MEDIA_LOCATION)) {
            return (!hasReadStoragePermission(activity) || com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, str) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACTIVITY_RECOGNITION)) {
            return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, str) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid11() || !com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.MANAGE_EXTERNAL_STORAGE) || isUseDeprecationExternalStorage()) {
            return super.isDoNotAskAgainPermission(activity, str);
        }
        return true;
    }

    private static boolean isUseDeprecationExternalStorage() {
        return android.os.Environment.isExternalStorageLegacy();
    }

    private boolean hasReadStoragePermission(android.content.Context context) {
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid13() && com.up366.mobile.common.utils.permissions.AndroidVersion.getTargetSdkVersionCode(context) >= 33) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_IMAGES) || isGrantedPermission(context, com.up366.mobile.common.utils.permissions.Permission.MANAGE_EXTERNAL_STORAGE);
        }
        if (!com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid11() || com.up366.mobile.common.utils.permissions.AndroidVersion.getTargetSdkVersionCode(context) < 30) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE);
        }
        return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE) || isGrantedPermission(context, com.up366.mobile.common.utils.permissions.Permission.MANAGE_EXTERNAL_STORAGE);
    }
}
