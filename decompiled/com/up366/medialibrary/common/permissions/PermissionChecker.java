package com.up366.medialibrary.common.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PermissionChecker {
    public static boolean checkSelfPermission(android.content.Context context, java.lang.String str) {
        return androidx.core.content.ContextCompat.checkSelfPermission(context.getApplicationContext(), str) == 0;
    }

    public static void requestPermissions(android.app.Activity activity, java.lang.String[] strArr, int i) {
        androidx.core.app.ActivityCompat.requestPermissions(activity, strArr, i);
    }

    public static void launchAppDetailsSettings(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(android.net.Uri.parse("package:" + applicationContext.getPackageName()));
        if (isIntentAvailable(context, intent)) {
            applicationContext.startActivity(intent.addFlags(268435456));
        }
    }

    private static boolean isIntentAvailable(android.content.Context context, android.content.Intent intent) {
        return context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
