package com.igexin.push.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class b {
    private static final java.lang.String a = "com.igexin.assist.control.stp.ManufacturePushManager";

    public static boolean a(android.content.Context context) {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName(a).getDeclaredMethod("checkDevice", android.content.Context.class);
            declaredMethod.setAccessible(true);
            boolean zBooleanValue = ((java.lang.Boolean) declaredMethod.invoke(null, context)).booleanValue();
            com.igexin.c.a.c.a.b("Assist_UPS", "isSupportStp: ".concat(java.lang.String.valueOf(zBooleanValue)));
            return zBooleanValue;
        } catch (java.lang.Exception e) {
            e.getMessage();
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(a);
                java.lang.Object objNewInstance = cls.getConstructor(android.content.Context.class).newInstance(context);
                java.lang.reflect.Method declaredMethod2 = cls.getDeclaredMethod("isSupport", null);
                declaredMethod2.setAccessible(true);
                com.igexin.c.a.c.a.b("Assist_UPS", "isSupportStp: ".concat(java.lang.String.valueOf(((java.lang.Boolean) declaredMethod2.invoke(objNewInstance, null)).booleanValue())));
            } catch (java.lang.Exception unused) {
            }
            return false;
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        java.lang.String strConcat = com.igexin.assist.sdk.AssistPushConsts.LOG_TAG.concat(java.lang.String.valueOf(str));
        boolean zBooleanValue = false;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.igexin.assist.control." + str + ".ManufacturePushManager");
            java.lang.Object objNewInstance = cls.getConstructor(android.content.Context.class).newInstance(context);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("context");
            boolean zIsAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            declaredField.set(objNewInstance, context);
            declaredField.setAccessible(zIsAccessible);
            zBooleanValue = ((java.lang.Boolean) cls.getDeclaredMethod("isSupport", null).invoke(objNewInstance, null)).booleanValue();
            com.igexin.c.a.c.a.e.a(strConcat, "isSupport " + str + " = " + zBooleanValue);
            return zBooleanValue;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.e.a(strConcat, "class non-existent  " + th.getMessage());
            return zBooleanValue;
        }
    }
}
