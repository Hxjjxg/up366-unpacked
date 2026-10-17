package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class PermissionDelegateImplV34 extends com.up366.mobile.common.utils.permissions.PermissionDelegateImplV33 {
    PermissionDelegateImplV34() {
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV33, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV31, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV30, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV29, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV28, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED)) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED);
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_IMAGES) && !com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_IMAGES)) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED);
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VIDEO) && !com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VIDEO)) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED);
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV33, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV31, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV30, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV29, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV28, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED)) {
            return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, str) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }
}
