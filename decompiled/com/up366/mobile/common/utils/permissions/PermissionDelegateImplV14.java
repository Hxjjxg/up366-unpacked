package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class PermissionDelegateImplV14 implements com.up366.mobile.common.utils.permissions.PermissionDelegate {
    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        return false;
    }

    PermissionDelegateImplV14() {
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BIND_VPN_SERVICE)) {
            return isGrantedVpnPermission(context);
        }
        return true;
    }

    private static boolean isGrantedVpnPermission(android.content.Context context) {
        return android.net.VpnService.prepare(context) == null;
    }

    private static android.content.Intent getVpnPermissionIntent(android.content.Context context) {
        android.content.Intent intentPrepare = android.net.VpnService.prepare(context);
        return !com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intentPrepare) ? com.up366.mobile.common.utils.permissions.PermissionIntentManager.getApplicationDetailsIntent(context) : intentPrepare;
    }
}
