package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class PermissionDelegateImplV33 extends com.up366.mobile.common.utils.permissions.PermissionDelegateImplV31 {
    PermissionDelegateImplV33() {
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV31, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV30, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV29, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV28, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BODY_SENSORS_BACKGROUND)) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.BODY_SENSORS) && com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.BODY_SENSORS_BACKGROUND);
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.POST_NOTIFICATIONS) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.NEARBY_WIFI_DEVICES) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_IMAGES) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VIDEO) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_AUDIO)) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, str);
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.getTargetSdkVersionCode(context) >= 33) {
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE)) {
                return true;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE)) {
                return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_IMAGES) && com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VIDEO) && com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_AUDIO);
            }
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV31, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV30, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV29, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV28, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BODY_SENSORS_BACKGROUND)) {
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.BODY_SENSORS)) {
                return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, str) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return !com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.BODY_SENSORS);
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.POST_NOTIFICATIONS) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.NEARBY_WIFI_DEVICES) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_IMAGES) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VIDEO) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_AUDIO)) {
            return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, str) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.getTargetSdkVersionCode(activity) >= 33) {
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE)) {
                return false;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE)) {
                return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_IMAGES) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_IMAGES) || com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VIDEO) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VIDEO) || com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_AUDIO) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_AUDIO)) ? false : true;
            }
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }
}
