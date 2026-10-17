package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class PermissionDelegateImplV28 extends com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26 {
    PermissionDelegateImplV28() {
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCEPT_HANDOVER)) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, str);
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCEPT_HANDOVER)) {
            return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, str) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }
}
