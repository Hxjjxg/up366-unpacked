package com.up366.qrcode.view.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIDeviceHelper {
    private static final java.lang.String ESSENTIAL = "essential";
    private static final java.lang.String FLYME = "flyme";
    private static final java.lang.String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
    private static final java.lang.String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final java.lang.String TAG = "QMUIDeviceHelper";
    private static final java.lang.String ZTEC2016 = "zte c2016";
    private static final java.lang.String ZUKZ1 = "zuk z1";
    private static java.lang.String sFlymeVersionName;
    private static java.lang.String sMiuiVersionName;
    private static final java.lang.String[] MEIZUBOARD = {"m9", "M9", "mx", "MX"};
    private static boolean sIsTabletChecked = false;
    private static boolean sIsTabletValue = false;
    private static final java.lang.String BRAND = android.os.Build.BRAND.toLowerCase();

    static {
        java.io.FileInputStream fileInputStream;
        java.util.Properties properties = new java.util.Properties();
        if (android.os.Build.VERSION.SDK_INT < 26) {
            java.io.FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new java.io.FileInputStream(new java.io.File(android.os.Environment.getRootDirectory(), "build.prop"));
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.lang.Exception unused) {
            }
            try {
                properties.load(fileInputStream);
                com.up366.qrcode.view.utils.QMUILangHelper.close(fileInputStream);
            } catch (java.lang.Exception unused2) {
                fileInputStream2 = fileInputStream;
                android.util.Log.e(TAG, "read file error");
                com.up366.qrcode.view.utils.QMUILangHelper.close(fileInputStream2);
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                com.up366.qrcode.view.utils.QMUILangHelper.close(fileInputStream2);
                throw th;
            }
        }
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod("get", java.lang.String.class);
            sMiuiVersionName = getLowerCaseName(properties, declaredMethod, "ro.miui.ui.version.name");
            sFlymeVersionName = getLowerCaseName(properties, declaredMethod, KEY_FLYME_VERSION_NAME);
        } catch (java.lang.Exception unused3) {
            android.util.Log.e(TAG, "read SystemProperties error");
        }
    }

    private static boolean _isTablet(android.content.Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static boolean isTablet(android.content.Context context) {
        if (sIsTabletChecked) {
            return sIsTabletValue;
        }
        boolean z_isTablet = _isTablet(context);
        sIsTabletValue = z_isTablet;
        sIsTabletChecked = true;
        return z_isTablet;
    }

    public static boolean isFlyme() {
        return !android.text.TextUtils.isEmpty(sFlymeVersionName) && sFlymeVersionName.contains(FLYME);
    }

    public static boolean isMIUI() {
        return !android.text.TextUtils.isEmpty(sMiuiVersionName);
    }

    public static boolean isMIUIV5() {
        return "v5".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV6() {
        return "v6".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV7() {
        return "v7".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV8() {
        return "v8".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV9() {
        return "v9".equals(sMiuiVersionName);
    }

    public static boolean isFlymeLowerThan(int i) {
        return isFlymeLowerThan(i, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isFlymeLowerThan(int r6, int r7, int r8) {
        /*
            java.lang.String r0 = com.up366.qrcode.view.utils.QMUIDeviceHelper.sFlymeVersionName
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L5d
            java.lang.String r3 = ""
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L5d
            java.lang.String r0 = "(\\d+\\.){2}\\d"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = com.up366.qrcode.view.utils.QMUIDeviceHelper.sFlymeVersionName     // Catch: java.lang.Throwable -> L5d
            java.util.regex.Matcher r0 = r0.matcher(r3)     // Catch: java.lang.Throwable -> L5d
            boolean r3 = r0.find()     // Catch: java.lang.Throwable -> L5d
            if (r3 == 0) goto L5d
            java.lang.String r0 = r0.group()     // Catch: java.lang.Throwable -> L5d
            int r3 = r0.length()     // Catch: java.lang.Throwable -> L5d
            if (r3 <= 0) goto L5d
            java.lang.String r3 = "\\."
            java.lang.String[] r0 = r0.split(r3)     // Catch: java.lang.Throwable -> L5d
            int r3 = r0.length     // Catch: java.lang.Throwable -> L5d
            if (r3 < r1) goto L3d
            r3 = r0[r2]     // Catch: java.lang.Throwable -> L5d
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Throwable -> L5d
            if (r3 >= r6) goto L3d
            r3 = r1
            goto L3e
        L3d:
            r3 = r2
        L3e:
            int r4 = r0.length     // Catch: java.lang.Throwable -> L5e
            r5 = 2
            if (r4 < r5) goto L4d
            if (r7 <= 0) goto L4d
            r7 = r0[r1]     // Catch: java.lang.Throwable -> L5e
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Throwable -> L5e
            if (r7 >= r6) goto L4d
            r3 = r1
        L4d:
            int r7 = r0.length     // Catch: java.lang.Throwable -> L5e
            r4 = 3
            if (r7 < r4) goto L5e
            if (r8 <= 0) goto L5e
            r7 = r0[r5]     // Catch: java.lang.Throwable -> L5e
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Throwable -> L5e
            if (r7 >= r6) goto L5e
            r3 = r1
            goto L5e
        L5d:
            r3 = r2
        L5e:
            boolean r6 = isMeizu()
            if (r6 == 0) goto L67
            if (r3 == 0) goto L67
            goto L68
        L67:
            r1 = r2
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.qrcode.view.utils.QMUIDeviceHelper.isFlymeLowerThan(int, int, int):boolean");
    }

    public static boolean isMeizu() {
        return isPhone(MEIZUBOARD) || isFlyme();
    }

    public static boolean isXiaomi() {
        return android.os.Build.MANUFACTURER.toLowerCase().equals(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI);
    }

    public static boolean isVivo() {
        java.lang.String str = BRAND;
        return str.contains(com.igexin.assist.util.AssistUtils.BRAND_VIVO) || str.contains("bbk");
    }

    public static boolean isOppo() {
        return BRAND.contains(com.igexin.assist.util.AssistUtils.BRAND_OPPO);
    }

    public static boolean isHuawei() {
        java.lang.String str = BRAND;
        return str.contains(com.igexin.assist.util.AssistUtils.BRAND_HW) || str.contains(com.igexin.assist.util.AssistUtils.BRAND_HON);
    }

    public static boolean isEssentialPhone() {
        return BRAND.contains(ESSENTIAL);
    }

    public static boolean isZUKZ1() {
        java.lang.String str = android.os.Build.MODEL;
        return str != null && str.toLowerCase().contains(ZUKZ1);
    }

    public static boolean isZTKC2016() {
        java.lang.String str = android.os.Build.MODEL;
        return str != null && str.toLowerCase().contains(ZTEC2016);
    }

    private static boolean isPhone(java.lang.String[] strArr) {
        java.lang.String str = android.os.Build.BOARD;
        if (str == null) {
            return false;
        }
        for (java.lang.String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFloatWindowOpAllowed(android.content.Context context) {
        return checkOp(context, 24);
    }

    private static boolean checkOp(android.content.Context context, int i) {
        android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) context.getSystemService("appops");
        try {
            java.lang.Class<?> cls = appOpsManager.getClass();
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            return ((java.lang.Integer) cls.getDeclaredMethod("checkOp", cls2, cls2, java.lang.String.class).invoke(appOpsManager, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(android.os.Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static java.lang.String getLowerCaseName(java.util.Properties properties, java.lang.reflect.Method method, java.lang.String str) {
        java.lang.String property = properties.getProperty(str);
        if (property == null) {
            try {
                property = (java.lang.String) method.invoke(null, str);
            } catch (java.lang.Exception unused) {
            }
        }
        return property != null ? property.toLowerCase() : property;
    }
}
