package com.igexin.assist.sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class a {
    public static final java.lang.String a = "AssistMangerFactory";
    private static final java.lang.String c = "com.igexin.assist.control.fcm.ManufacturePushManager";
    private static com.igexin.assist.sdk.a d;
    private static final java.lang.String[] e = {"com.igexin.assist.control.xiaomi.MiuiPushManager", "com.igexin.assist.control.meizu.FlymePushManager", "com.igexin.assist.control.huawei.HmsPushManager", "com.igexin.assist.control.oppo.OppoPushManager", "com.igexin.assist.control.vivo.VivoPushManager", "com.igexin.assist.control.st.SmartisanPushManager", "com.igexin.assist.control.fcm.FcmPushManager"};
    public com.igexin.assist.control.AbstractPushManager b;

    public static com.igexin.assist.sdk.a a() {
        if (d == null) {
            synchronized (com.igexin.assist.control.AbstractPushManager.class) {
                if (d == null) {
                    d = new com.igexin.assist.sdk.a();
                }
            }
        }
        return d;
    }

    private void b(android.content.Context context) {
        com.igexin.assist.control.AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null && abstractPushManager.isSupport()) {
            if (this.b.getBrandCode().equals("3")) {
                try {
                    java.lang.Class.forName("com.xiaomi.mipush.sdk.MiPushClient").getDeclaredMethod("clearNotification", android.content.Context.class).invoke(null, context);
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                    com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th.toString(), new java.lang.Object[0]);
                }
                com.igexin.c.a.c.a.b(a, " cancelAllAssistNotification() XM ");
                return;
            }
            if (this.b.getBrandCode().equals("4")) {
                try {
                    java.lang.Class.forName("com.meizu.cloud.pushsdk.PushManager").getDeclaredMethod("clearNotification", android.content.Context.class).invoke(null, context);
                } catch (java.lang.Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                    com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th2.toString(), new java.lang.Object[0]);
                }
                com.igexin.c.a.c.a.b(a, " cancelAllAssistNotification() MZ ");
            }
        }
    }

    private static void c(android.content.Context context) {
        try {
            java.lang.Class.forName("com.xiaomi.mipush.sdk.MiPushClient").getDeclaredMethod("clearNotification", android.content.Context.class).invoke(null, context);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th.toString(), new java.lang.Object[0]);
        }
        com.igexin.c.a.c.a.b(a, " cancelAllAssistNotification() XM ");
    }

    private static void d() {
        for (java.lang.String str : e) {
            try {
                java.lang.Class.forName(str);
                com.igexin.c.a.c.a.d.a().a("UnSupport plugin [" + str + "]. Please change plugin to 3.0.");
                return;
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    private static void d(android.content.Context context) {
        try {
            java.lang.Class.forName("com.meizu.cloud.pushsdk.PushManager").getDeclaredMethod("clearNotification", android.content.Context.class).invoke(null, context);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th.toString(), new java.lang.Object[0]);
        }
        com.igexin.c.a.c.a.b(a, " cancelAllAssistNotification() MZ ");
    }

    private java.lang.String e() {
        com.igexin.assist.control.AbstractPushManager abstractPushManager = this.b;
        return abstractPushManager == null ? "" : abstractPushManager.getBrandCode();
    }

    private java.lang.String f() {
        java.lang.Object objInvoke;
        com.igexin.assist.control.AbstractPushManager abstractPushManager = this.b;
        java.lang.String str = "";
        if (abstractPushManager == null) {
            return "";
        }
        java.lang.String name = abstractPushManager.getClass().getName();
        try {
            if (!name.contains("fcm")) {
                if (name.contains(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI)) {
                    java.lang.reflect.Field declaredField = this.b.getClass().getDeclaredField("XIAOMI_VERSION");
                    boolean zIsAccessible = declaredField.isAccessible();
                    declaredField.setAccessible(true);
                    java.lang.String str2 = (java.lang.String) declaredField.get(this.b.getClass());
                    try {
                        declaredField.setAccessible(zIsAccessible);
                        return str2;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        str = str2;
                        com.igexin.c.a.c.a.a(th);
                        return str;
                    }
                }
                if (name.contains(com.igexin.assist.util.AssistUtils.BRAND_HW)) {
                    return ((java.lang.String) com.igexin.push.g.o.b(com.igexin.push.core.e.l).metaData.get("com.huawei.hms.client.service.name:push")).split(":")[1];
                }
                if (name.contains(com.igexin.assist.util.AssistUtils.BRAND_OPPO)) {
                    java.lang.Class<?> cls = java.lang.Class.forName("com.heytap.msp.push.HeytapPushManager");
                    objInvoke = cls.getDeclaredMethod("getSDKVersionName", null).invoke(cls, null);
                } else {
                    if (name.contains(com.igexin.assist.util.AssistUtils.BRAND_STP)) {
                        java.lang.Class<?> cls2 = java.lang.Class.forName("com.gtups.sdk.PushManager");
                        objInvoke = cls2.getDeclaredMethod("getVersion", android.content.Context.class).invoke(cls2.getDeclaredMethod("getInstance", null).invoke(cls2, null), com.igexin.push.core.e.l);
                    } else {
                        if (name.contains(com.igexin.assist.util.AssistUtils.BRAND_VIVO)) {
                            android.content.pm.ApplicationInfo applicationInfoB = com.igexin.push.g.o.b(com.igexin.push.core.e.l);
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(applicationInfoB.metaData.getInt("sdk_version_vivo"));
                            return sb.toString();
                        }
                        if (name.contains(com.igexin.assist.util.AssistUtils.BRAND_MZ)) {
                            for (java.lang.reflect.Field field : java.lang.Class.forName("com.meizu.cloud.pushsdk.PushManager").getDeclaredFields()) {
                                if (java.lang.reflect.Modifier.isFinal(field.getModifiers()) && "TAG".equals(field.getName())) {
                                    str = (java.lang.String) field.get(null);
                                }
                            }
                        }
                    }
                }
                return (java.lang.String) objInvoke;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        return str;
    }

    public final com.igexin.assist.control.AbstractPushManager a(android.content.Context context) {
        java.lang.String lowerCase = com.igexin.assist.util.AssistUtils.getDeviceBrand().toLowerCase();
        if (com.igexin.push.config.d.M.contains(lowerCase)) {
            com.igexin.c.a.c.a.a("AssistMangerFactory|getPushManager = null, setToken = false", new java.lang.Object[0]);
            com.igexin.push.core.e.f.a().b("false");
            return null;
        }
        try {
            this.b = (com.igexin.assist.control.AbstractPushManager) java.lang.Class.forName("com.igexin.assist.control." + lowerCase + ".ManufacturePushManager").getConstructor(android.content.Context.class).newInstance(context);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.d.a().a(lowerCase + " PushManager = null " + th.toString());
        }
        if (this.b == null) {
            try {
                com.igexin.c.a.c.a.a("AssistMangerFactory|try init fcm push", new java.lang.Object[0]);
                com.igexin.assist.control.AbstractPushManager abstractPushManager = (com.igexin.assist.control.AbstractPushManager) java.lang.Class.forName(c).getConstructor(android.content.Context.class).newInstance(context);
                this.b = abstractPushManager;
                if (!abstractPushManager.isSupport()) {
                    this.b = null;
                }
            } catch (java.lang.Throwable th2) {
                com.igexin.c.a.c.a.d.a().a(lowerCase + " Fcm PushManager = null");
                java.lang.StringBuilder sb = new java.lang.StringBuilder("|Fcm ManufacturePushManager = null ");
                sb.append(th2.toString());
                com.igexin.c.a.c.a.b(a, sb.toString());
                if (!com.igexin.push.core.e.b().booleanValue()) {
                    com.igexin.push.core.e.f.a().b("false");
                }
                if (th2 instanceof java.lang.ClassNotFoundException) {
                    d();
                }
            }
        }
        if (this.b == null && !com.igexin.push.core.e.b().booleanValue()) {
            com.igexin.push.core.e.f.a().b("false");
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("AssistMangerFactory|ManufacturePushManager is null = ");
        sb2.append(this.b == null);
        com.igexin.c.a.c.a.a(sb2.toString(), new java.lang.Object[0]);
        return this.b;
    }

    public final java.lang.String[] b() {
        java.lang.String str;
        java.lang.String strF;
        java.lang.reflect.Field declaredField;
        boolean zIsAccessible;
        com.igexin.assist.control.AbstractPushManager abstractPushManager = this.b;
        java.lang.String str2 = "";
        if (abstractPushManager == null) {
            return new java.lang.String[]{"", ""};
        }
        try {
            declaredField = abstractPushManager.getClass().getDeclaredField("PLUGIN_VERSION");
            zIsAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            str = (java.lang.String) declaredField.get(this.b.getClass());
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            declaredField.setAccessible(zIsAccessible);
        } catch (java.lang.Throwable th2) {
            th = th2;
            str2 = str;
            com.igexin.c.a.c.a.a(th);
            str = str2;
        }
        try {
            strF = (java.lang.String) this.b.getClass().getDeclaredMethod("getBrandSdkVersion", null).invoke(this.b, null);
        } catch (java.lang.Throwable th3) {
            com.igexin.c.a.c.a.a(a, th3.getMessage());
            strF = f();
        }
        return new java.lang.String[]{str, strF};
    }

    public final boolean c() {
        com.igexin.assist.control.AbstractPushManager abstractPushManager;
        if (com.igexin.push.config.d.M.contains(com.igexin.assist.util.AssistUtils.getDeviceBrand().toLowerCase()) || (abstractPushManager = this.b) == null) {
            return false;
        }
        return abstractPushManager.isSupport();
    }
}
