package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class PermissionDelegateImplV31 extends com.up366.mobile.common.utils.permissions.PermissionDelegateImplV30 {
    PermissionDelegateImplV31() {
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV30, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV29, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV28, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.SCHEDULE_EXACT_ALARM)) {
            return isGrantedAlarmPermission(context);
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_SCAN) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_CONNECT) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_ADVERTISE)) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, str);
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV30, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV29, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV28, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.SCHEDULE_EXACT_ALARM)) {
            return false;
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_SCAN) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_CONNECT) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_ADVERTISE)) {
            return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, str) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        if (activity.getApplicationInfo().targetSdkVersion < 31 || !com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCESS_BACKGROUND_LOCATION)) {
            return super.isDoNotAskAgainPermission(activity, str);
        }
        return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION) || com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.ACCESS_COARSE_LOCATION)) ? (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, str) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true : (com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.ACCESS_COARSE_LOCATION)) ? false : true;
    }

    private static boolean isGrantedAlarmPermission(android.content.Context context) {
        return ((android.app.AlarmManager) context.getSystemService(android.app.AlarmManager.class)).canScheduleExactAlarms();
    }

    private static android.content.Intent getAlarmPermissionIntent(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
        intent.setData(com.up366.mobile.common.utils.permissions.PermissionUtils.getPackageNameUri(context));
        return !com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent) ? com.up366.mobile.common.utils.permissions.PermissionIntentManager.getApplicationDetailsIntent(context) : intent;
    }
}
