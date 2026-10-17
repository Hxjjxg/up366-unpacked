package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
final class PhoneRomUtils {
    private static final java.lang.String ROM_NAME_MIUI = "ro.miui.ui.version.name";
    private static final java.lang.String VERSION_PROPERTY_360 = "ro.build.uiversion";
    private static final java.lang.String VERSION_PROPERTY_HUAWEI = "ro.build.version.emui";
    private static final java.lang.String VERSION_PROPERTY_LEECO = "ro.letv.release.version";
    private static final java.lang.String VERSION_PROPERTY_NUBIA = "ro.build.rom.id";
    private static final java.lang.String VERSION_PROPERTY_ONEPLUS = "ro.rom.version";
    private static final java.lang.String VERSION_PROPERTY_VIVO = "ro.vivo.os.build.display.id";
    private static final java.lang.String VERSION_PROPERTY_XIAOMI = "ro.build.version.incremental";
    private static final java.lang.String VERSION_PROPERTY_ZTE = "ro.build.MiFavor_version";
    private static final java.lang.String[] ROM_HUAWEI = {com.igexin.assist.util.AssistUtils.BRAND_HW};
    private static final java.lang.String[] ROM_VIVO = {com.igexin.assist.util.AssistUtils.BRAND_VIVO};
    private static final java.lang.String[] ROM_XIAOMI = {com.igexin.assist.util.AssistUtils.BRAND_XIAOMI};
    private static final java.lang.String[] ROM_OPPO = {com.igexin.assist.util.AssistUtils.BRAND_OPPO};
    private static final java.lang.String[] ROM_LEECO = {"leeco", "letv"};
    private static final java.lang.String[] ROM_360 = {"360", "qiku"};
    private static final java.lang.String[] ROM_ZTE = {"zte"};
    private static final java.lang.String[] ROM_ONEPLUS = {"oneplus"};
    private static final java.lang.String[] ROM_NUBIA = {"nubia"};
    private static final java.lang.String[] ROM_SAMSUNG = {"samsung"};
    private static final java.lang.String[] ROM_HONOR = {com.igexin.assist.util.AssistUtils.BRAND_HON};
    private static final java.lang.String[] VERSION_PROPERTY_OPPO = {"ro.build.version.opporom", "ro.build.version.oplusrom.display"};
    private static final java.lang.String[] VERSION_PROPERTY_MAGIC = {"msc.config.magic.version", "ro.build.version.magic"};

    private PhoneRomUtils() {
    }

    static boolean isEmui() {
        return !android.text.TextUtils.isEmpty(getPropertyName(VERSION_PROPERTY_HUAWEI));
    }

    static boolean isMiui() {
        return !android.text.TextUtils.isEmpty(getPropertyName("ro.miui.ui.version.name"));
    }

    static boolean isColorOs() {
        for (java.lang.String str : VERSION_PROPERTY_OPPO) {
            if (!android.text.TextUtils.isEmpty(getPropertyName(str))) {
                return true;
            }
        }
        return false;
    }

    static boolean isOriginOs() {
        return !android.text.TextUtils.isEmpty(getPropertyName(VERSION_PROPERTY_VIVO));
    }

    static boolean isOneUi() {
        return isRightRom(getBrand(), getManufacturer(), ROM_SAMSUNG);
    }

    static boolean isHarmonyOs() {
        if (!com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid10()) {
            return false;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
            return "Harmony".equalsIgnoreCase(java.lang.String.valueOf(cls.getMethod("getOsBrand", null).invoke(cls, null)));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    static boolean isMagicOs() {
        return isRightRom(getBrand(), getManufacturer(), ROM_HONOR);
    }

    static boolean isMiuiOptimization() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return java.lang.Boolean.parseBoolean(java.lang.String.valueOf(cls.getMethod("getBoolean", java.lang.String.class, java.lang.Boolean.TYPE).invoke(cls, "persist.sys.miui_optimization", java.lang.Boolean.valueOf(!"1".equals(java.lang.String.valueOf(cls.getMethod("get", java.lang.String.class, java.lang.String.class).invoke(cls, "ro.miui.cts", "")))))));
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            return true;
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
            return true;
        } catch (java.lang.NoSuchMethodException e3) {
            e3.printStackTrace();
            return true;
        } catch (java.lang.reflect.InvocationTargetException e4) {
            e4.printStackTrace();
            return true;
        }
    }

    static java.lang.String getRomVersionName() {
        java.lang.String brand = getBrand();
        java.lang.String manufacturer = getManufacturer();
        if (isRightRom(brand, manufacturer, ROM_HUAWEI)) {
            java.lang.String propertyName = getPropertyName(VERSION_PROPERTY_HUAWEI);
            java.lang.String[] strArrSplit = propertyName.split("_");
            if (strArrSplit.length > 1) {
                return strArrSplit[1];
            }
            return propertyName.contains("EmotionUI") ? propertyName.replaceFirst("EmotionUI\\s*", "") : propertyName;
        }
        if (isRightRom(brand, manufacturer, ROM_VIVO)) {
            return getPropertyName(VERSION_PROPERTY_VIVO);
        }
        if (isRightRom(brand, manufacturer, ROM_XIAOMI)) {
            return getPropertyName(VERSION_PROPERTY_XIAOMI);
        }
        int i = 0;
        if (isRightRom(brand, manufacturer, ROM_OPPO)) {
            java.lang.String[] strArr = VERSION_PROPERTY_OPPO;
            int length = strArr.length;
            while (i < length) {
                java.lang.String str = strArr[i];
                java.lang.String propertyName2 = getPropertyName(str);
                if (!android.text.TextUtils.isEmpty(str)) {
                    return propertyName2;
                }
                i++;
            }
            return "";
        }
        if (isRightRom(brand, manufacturer, ROM_LEECO)) {
            return getPropertyName(VERSION_PROPERTY_LEECO);
        }
        if (isRightRom(brand, manufacturer, ROM_360)) {
            return getPropertyName(VERSION_PROPERTY_360);
        }
        if (isRightRom(brand, manufacturer, ROM_ZTE)) {
            return getPropertyName(VERSION_PROPERTY_ZTE);
        }
        if (isRightRom(brand, manufacturer, ROM_ONEPLUS)) {
            return getPropertyName(VERSION_PROPERTY_ONEPLUS);
        }
        if (isRightRom(brand, manufacturer, ROM_NUBIA)) {
            return getPropertyName(VERSION_PROPERTY_NUBIA);
        }
        if (isRightRom(brand, manufacturer, ROM_HONOR)) {
            java.lang.String[] strArr2 = VERSION_PROPERTY_MAGIC;
            int length2 = strArr2.length;
            while (i < length2) {
                java.lang.String str2 = strArr2[i];
                java.lang.String propertyName3 = getPropertyName(str2);
                if (!android.text.TextUtils.isEmpty(str2)) {
                    return propertyName3;
                }
                i++;
            }
            return "";
        }
        return getPropertyName("");
    }

    private static boolean isRightRom(java.lang.String str, java.lang.String str2, java.lang.String... strArr) {
        for (java.lang.String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    private static java.lang.String getBrand() {
        return android.os.Build.BRAND.toLowerCase();
    }

    private static java.lang.String getManufacturer() {
        return android.os.Build.MANUFACTURER.toLowerCase();
    }

    private static java.lang.String getPropertyName(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        return getSystemProperty(str);
    }

    private static java.lang.String getSystemProperty(java.lang.String str) throws java.lang.Throwable {
        java.lang.String systemPropertyByShell = getSystemPropertyByShell(str);
        if (!android.text.TextUtils.isEmpty(systemPropertyByShell)) {
            return systemPropertyByShell;
        }
        java.lang.String systemPropertyByStream = getSystemPropertyByStream(str);
        return (android.text.TextUtils.isEmpty(systemPropertyByStream) && android.os.Build.VERSION.SDK_INT < 28) ? getSystemPropertyByReflect(str) : systemPropertyByStream;
    }

    private static java.lang.String getSystemPropertyByShell(java.lang.String str) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.lang.String line;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.io.IOException e) {
                e = e;
            }
            try {
                line = bufferedReader.readLine();
            } catch (java.io.IOException e2) {
                e = e2;
                bufferedReader2 = bufferedReader;
                e.printStackTrace();
                if (bufferedReader2 == null) {
                    return "";
                }
                bufferedReader2.close();
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
            if (line == null) {
                bufferedReader.close();
                return "";
            }
            try {
                bufferedReader.close();
            } catch (java.io.IOException e4) {
                e4.printStackTrace();
            }
            return line;
        } catch (java.io.IOException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    private static java.lang.String getSystemPropertyByStream(java.lang.String str) {
        try {
            java.util.Properties properties = new java.util.Properties();
            properties.load(new java.io.FileInputStream(new java.io.File(android.os.Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static java.lang.String getSystemPropertyByReflect(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return (java.lang.String) cls.getMethod("get", java.lang.String.class, java.lang.String.class).invoke(cls, str, "");
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
            return "";
        } catch (java.lang.NoSuchMethodException e3) {
            e3.printStackTrace();
            return "";
        } catch (java.lang.reflect.InvocationTargetException e4) {
            e4.printStackTrace();
            return "";
        }
    }
}
