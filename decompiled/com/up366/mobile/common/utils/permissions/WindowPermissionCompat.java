package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
final class WindowPermissionCompat {
    private static final int OP_SYSTEM_ALERT_WINDOW_DEFAULT_VALUE = 24;
    private static final java.lang.String OP_SYSTEM_ALERT_WINDOW_FIELD_NAME = "OP_SYSTEM_ALERT_WINDOW";

    WindowPermissionCompat() {
    }

    static boolean isGrantedPermission(android.content.Context context) {
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid6()) {
            return android.provider.Settings.canDrawOverlays(context);
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid4_4()) {
            return com.up366.mobile.common.utils.permissions.PermissionUtils.checkOpNoThrow(context, OP_SYSTEM_ALERT_WINDOW_FIELD_NAME, 24);
        }
        return true;
    }
}
