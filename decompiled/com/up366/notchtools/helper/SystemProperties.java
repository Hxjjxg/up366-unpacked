package com.up366.notchtools.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SystemProperties {
    private static final java.lang.String TAG = "SystemProperties";
    private static java.lang.reflect.Method getStringProperty;
    private static com.up366.notchtools.helper.SystemProperties sSystemProperties;

    public static com.up366.notchtools.helper.SystemProperties getInstance() {
        if (sSystemProperties == null) {
            synchronized (com.up366.notchtools.helper.SystemProperties.class) {
                if (sSystemProperties == null) {
                    sSystemProperties = new com.up366.notchtools.helper.SystemProperties();
                }
            }
        }
        return sSystemProperties;
    }

    private SystemProperties() {
        getStringProperty = getMethod(getClass("android.os.SystemProperties"));
    }

    private java.lang.Class getClass(java.lang.String str) {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException e) {
            android.util.Log.e(TAG, e.getMessage());
            try {
                return java.lang.ClassLoader.getSystemClassLoader().loadClass(str);
            } catch (java.lang.ClassNotFoundException e2) {
                android.util.Log.e(TAG, e2.getMessage());
                return null;
            }
        }
    }

    private java.lang.reflect.Method getMethod(java.lang.Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("get", java.lang.String.class);
        } catch (java.lang.Exception e) {
            android.util.Log.e(TAG, e.getMessage());
            return null;
        }
    }

    public final java.lang.String get(java.lang.String str) {
        if (str == null) {
            return "";
        }
        try {
            java.lang.reflect.Method method = getStringProperty;
            java.lang.String str2 = (java.lang.String) (method != null ? method.invoke(null, str) : null);
            if (str2 != null) {
                return str2.trim();
            }
        } catch (java.lang.Exception unused) {
        }
        return "";
    }
}
