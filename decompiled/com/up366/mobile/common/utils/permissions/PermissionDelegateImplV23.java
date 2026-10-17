package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class PermissionDelegateImplV23 extends com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21 {
    PermissionDelegateImplV23() {
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.Permission.getPermissionFromAndroidVersion(str) > com.up366.mobile.common.utils.permissions.AndroidVersion.getAndroidVersionCode()) {
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED)) {
                return true;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.POST_NOTIFICATIONS)) {
                return super.isGrantedPermission(context, str);
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.NEARBY_WIFI_DEVICES)) {
                return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION);
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BODY_SENSORS_BACKGROUND)) {
                return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.BODY_SENSORS);
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_IMAGES) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VIDEO) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_AUDIO)) {
                return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE);
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_SCAN)) {
                return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION);
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_CONNECT) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_ADVERTISE)) {
                return true;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.MANAGE_EXTERNAL_STORAGE)) {
                return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE) && com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE);
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCESS_BACKGROUND_LOCATION)) {
                return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION);
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACTIVITY_RECOGNITION)) {
                return true;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCESS_MEDIA_LOCATION)) {
                return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE);
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCEPT_HANDOVER) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ANSWER_PHONE_CALLS)) {
                return true;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_PHONE_NUMBERS)) {
                return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_PHONE_STATE);
            }
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.GET_INSTALLED_APPS) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.POST_NOTIFICATIONS)) {
            return super.isGrantedPermission(context, str);
        }
        if (com.up366.mobile.common.utils.permissions.Permission.isSpecialPermission(str)) {
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.WRITE_SETTINGS)) {
                return isGrantedSettingPermission(context);
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCESS_NOTIFICATION_POLICY)) {
                return isGrantedNotDisturbPermission(context);
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)) {
                return isGrantedIgnoreBatteryPermission(context);
            }
            return super.isGrantedPermission(context, str);
        }
        return com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(context, str);
    }

    @Override // com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18, com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14, com.up366.mobile.common.utils.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.Permission.getPermissionFromAndroidVersion(str) > com.up366.mobile.common.utils.permissions.AndroidVersion.getAndroidVersionCode()) {
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED)) {
                return false;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.POST_NOTIFICATIONS)) {
                return super.isDoNotAskAgainPermission(activity, str);
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.NEARBY_WIFI_DEVICES)) {
                return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION)) ? false : true;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BODY_SENSORS_BACKGROUND)) {
                return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.BODY_SENSORS) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.BODY_SENSORS)) ? false : true;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_IMAGES) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VIDEO) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_AUDIO)) {
                return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE)) ? false : true;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_SCAN)) {
                return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION)) ? false : true;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_CONNECT) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_ADVERTISE)) {
                return false;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCESS_BACKGROUND_LOCATION)) {
                return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.ACCESS_FINE_LOCATION)) ? false : true;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACTIVITY_RECOGNITION)) {
                return false;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCESS_MEDIA_LOCATION)) {
                return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE)) ? false : true;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ACCEPT_HANDOVER) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.ANSWER_PHONE_CALLS)) {
                return false;
            }
            if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_PHONE_NUMBERS)) {
                return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, com.up366.mobile.common.utils.permissions.Permission.READ_PHONE_STATE) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, com.up366.mobile.common.utils.permissions.Permission.READ_PHONE_STATE)) ? false : true;
            }
        }
        if (com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.GET_INSTALLED_APPS) || com.up366.mobile.common.utils.permissions.PermissionUtils.equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.POST_NOTIFICATIONS)) {
            return super.isDoNotAskAgainPermission(activity, str);
        }
        if (com.up366.mobile.common.utils.permissions.Permission.isSpecialPermission(str)) {
            return false;
        }
        return (com.up366.mobile.common.utils.permissions.PermissionUtils.checkSelfPermission(activity, str) || com.up366.mobile.common.utils.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
    }

    private static boolean isGrantedSettingPermission(android.content.Context context) {
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid6()) {
            return android.provider.Settings.System.canWrite(context);
        }
        return true;
    }

    private static android.content.Intent getSettingPermissionIntent(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(com.up366.mobile.common.utils.permissions.PermissionUtils.getPackageNameUri(context));
        return !com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent) ? com.up366.mobile.common.utils.permissions.PermissionIntentManager.getApplicationDetailsIntent(context) : intent;
    }

    private static boolean isGrantedNotDisturbPermission(android.content.Context context) {
        return ((android.app.NotificationManager) context.getSystemService(android.app.NotificationManager.class)).isNotificationPolicyAccessGranted();
    }

    private static android.content.Intent getNotDisturbPermissionIntent(android.content.Context context) {
        android.content.Intent intent;
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid10()) {
            intent = new android.content.Intent("android.settings.NOTIFICATION_POLICY_ACCESS_DETAIL_SETTINGS");
            intent.setData(com.up366.mobile.common.utils.permissions.PermissionUtils.getPackageNameUri(context));
            if (com.up366.mobile.common.utils.permissions.PhoneRomUtils.isHarmonyOs() || com.up366.mobile.common.utils.permissions.PhoneRomUtils.isMagicOs()) {
                intent = new android.content.Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
            }
        } else {
            intent = new android.content.Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
        }
        return !com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent) ? com.up366.mobile.common.utils.permissions.PermissionIntentManager.getApplicationDetailsIntent(context) : intent;
    }

    private static boolean isGrantedIgnoreBatteryPermission(android.content.Context context) {
        return ((android.os.PowerManager) context.getSystemService(android.os.PowerManager.class)).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    private static android.content.Intent getIgnoreBatteryPermissionIntent(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(com.up366.mobile.common.utils.permissions.PermissionUtils.getPackageNameUri(context));
        if (!com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent)) {
            intent = new android.content.Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
        }
        return !com.up366.mobile.common.utils.permissions.PermissionUtils.areActivityIntent(context, intent) ? com.up366.mobile.common.utils.permissions.PermissionIntentManager.getApplicationDetailsIntent(context) : intent;
    }
}
