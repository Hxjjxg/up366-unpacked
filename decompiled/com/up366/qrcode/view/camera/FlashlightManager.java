package com.up366.qrcode.view.camera;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class FlashlightManager {
    private static final java.lang.String TAG = "FlashlightManager";
    private static final java.lang.Object iHardwareService;
    private static final java.lang.reflect.Method setFlashEnabledMethod;

    static {
        java.lang.Object hardwareService = getHardwareService();
        iHardwareService = hardwareService;
        setFlashEnabledMethod = getSetFlashEnabledMethod(hardwareService);
        if (hardwareService == null) {
            android.util.Log.v("FlashlightManager", "This device does supports control of a flashlight");
        } else {
            android.util.Log.v("FlashlightManager", "This device does not support control of a flashlight");
        }
    }

    private FlashlightManager() {
    }

    static void enableFlashlight() {
        setFlashlight(false);
    }

    static void disableFlashlight() {
        setFlashlight(false);
    }

    private static java.lang.Object getHardwareService() {
        java.lang.reflect.Method methodMaybeGetMethod;
        java.lang.Object objInvoke;
        java.lang.Class<?> clsMaybeForName;
        java.lang.reflect.Method methodMaybeGetMethod2;
        java.lang.Class<?> clsMaybeForName2 = maybeForName("android.os.ServiceManager");
        if (clsMaybeForName2 == null || (methodMaybeGetMethod = maybeGetMethod(clsMaybeForName2, "getService", java.lang.String.class)) == null || (objInvoke = invoke(methodMaybeGetMethod, null, "hardware")) == null || (clsMaybeForName = maybeForName("android.os.IHardwareService$Stub")) == null || (methodMaybeGetMethod2 = maybeGetMethod(clsMaybeForName, "asInterface", android.os.IBinder.class)) == null) {
            return null;
        }
        return invoke(methodMaybeGetMethod2, null, objInvoke);
    }

    private static java.lang.reflect.Method getSetFlashEnabledMethod(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        return maybeGetMethod(obj.getClass(), "setFlashlightEnabled", java.lang.Boolean.TYPE);
    }

    private static java.lang.Class<?> maybeForName(java.lang.String str) {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        } catch (java.lang.RuntimeException e) {
            android.util.Log.w(TAG, "Unexpected error while finding class " + str, e);
            return null;
        }
    }

    private static java.lang.reflect.Method maybeGetMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        } catch (java.lang.RuntimeException e) {
            android.util.Log.w(TAG, "Unexpected error while finding method " + str, e);
            return null;
        }
    }

    private static java.lang.Object invoke(java.lang.reflect.Method method, java.lang.Object obj, java.lang.Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (java.lang.IllegalAccessException e) {
            android.util.Log.w(TAG, "Unexpected error while invoking " + method, e);
            return null;
        } catch (java.lang.RuntimeException e2) {
            android.util.Log.w(TAG, "Unexpected error while invoking " + method, e2);
            return null;
        } catch (java.lang.reflect.InvocationTargetException e3) {
            android.util.Log.w(TAG, "Unexpected error while invoking " + method, e3.getCause());
            return null;
        }
    }

    private static void setFlashlight(boolean z) {
        java.lang.Object obj = iHardwareService;
        if (obj != null) {
            invoke(setFlashEnabledMethod, obj, java.lang.Boolean.valueOf(z));
        }
    }
}
