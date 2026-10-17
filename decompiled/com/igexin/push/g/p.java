package com.igexin.push.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class p {
    public static java.lang.Class<?> a(java.lang.String str) throws java.lang.Throwable {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            try {
                return (java.lang.Class) java.lang.Class.class.getDeclaredMethod("forName", java.lang.String.class).invoke(null, str);
            } catch (java.lang.Throwable unused) {
            }
        }
        return java.lang.Class.forName(str);
    }

    private static java.lang.reflect.Field a(java.lang.Class<?> cls, java.lang.String str) throws java.lang.Throwable {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            try {
                return (java.lang.reflect.Field) java.lang.Class.class.getDeclaredMethod("getDeclaredField", java.lang.String.class).invoke(cls, str);
            } catch (java.lang.Throwable unused) {
            }
        }
        return cls.getDeclaredField(str);
    }

    public static java.lang.reflect.Method a(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) throws java.lang.Throwable {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            try {
                return (java.lang.reflect.Method) java.lang.Class.class.getDeclaredMethod("getDeclaredMethod", java.lang.String.class, java.lang.Class[].class).invoke(cls, str, clsArr);
            } catch (java.lang.Throwable unused) {
            }
        }
        return cls.getDeclaredMethod(str, clsArr);
    }

    private static java.lang.reflect.Field b(java.lang.Class<?> cls, java.lang.String str) throws java.lang.Throwable {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            try {
                return (java.lang.reflect.Field) java.lang.Class.class.getDeclaredMethod("getField", java.lang.String.class).invoke(cls, str);
            } catch (java.lang.Throwable unused) {
            }
        }
        return cls.getDeclaredField(str);
    }
}
