package com.up366.multimediav2.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PermissionUtils {
    public static boolean isDownAndroid6() {
        return false;
    }

    public static boolean isUpAndroid5() {
        return true;
    }

    public static boolean hasCameraPermissions(android.content.Context context) {
        try {
            if (isOppoVivoCamera()) {
                if (!isCameraCanUse() || !isHasCameraPermission()) {
                    return false;
                }
            } else if (isDownAndroid6()) {
                return true;
            }
            return androidx.core.content.ContextCompat.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.CAMERA) == 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean hasStoragePermission(android.content.Context context) {
        if (isDownAndroid6()) {
            return true;
        }
        try {
            if (!isSpecialDevice()) {
                return androidx.core.app.ActivityCompat.checkSelfPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE) == 0;
            }
            java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory().toString() + "/1234545/");
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file.exists()) {
                return false;
            }
            file.delete();
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isSpecialDevice() {
        return (com.up366.multimediav2.util.RomUtils.isOppo() || com.up366.multimediav2.util.RomUtils.isVivo()) && isDownAndroid8();
    }

    public static boolean isUpAndroid7() {
        return android.os.Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isDownAndroid8() {
        return android.os.Build.VERSION.SDK_INT < 26;
    }

    public static boolean isDownAndroid7() {
        return android.os.Build.VERSION.SDK_INT < 24;
    }

    public static boolean isOppoVivoCamera() {
        return (com.up366.multimediav2.util.RomUtils.isOppo() || com.up366.multimediav2.util.RomUtils.isVivo()) && isUpAndroid5() && isDownAndroid8();
    }

    public static boolean isCameraCanUse() {
        android.hardware.Camera camera = null;
        try {
            camera = getCamera();
            camera.setParameters(camera.getParameters());
            if (camera != null) {
                camera.release();
            }
            return true;
        } catch (java.lang.Exception unused) {
            if (camera != null) {
                camera.release();
            }
            return false;
        } catch (java.lang.Throwable th) {
            if (camera != null) {
                camera.release();
            }
            throw th;
        }
    }

    public static boolean isHasCameraPermission() {
        android.hardware.Camera camera;
        try {
            camera = getCamera();
        } catch (java.lang.Exception e) {
            e = e;
            camera = null;
        }
        try {
            java.lang.reflect.Field declaredField = camera.getClass().getDeclaredField("mHasPermission");
            declaredField.setAccessible(true);
            return ((java.lang.Boolean) declaredField.get(camera)).booleanValue();
        } catch (java.lang.Exception e2) {
            e = e2;
            e.printStackTrace();
            if (camera != null) {
                camera.release();
            }
            return true;
        }
    }

    public static android.hardware.Camera getCamera() {
        return android.hardware.Camera.open();
    }
}
