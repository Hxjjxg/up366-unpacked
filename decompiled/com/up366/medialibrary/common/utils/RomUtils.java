package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RomUtils {
    private static java.lang.Integer romType;

    public static class AvailableRomType {
        public static final int ANDROID_NATIVE = 3;
        public static final int FLYME = 2;
        public static final int MIUI = 1;
        public static final int NA = 4;
    }

    private static boolean isAndroid5OrAbove() {
        return true;
    }

    public static int getLightStatausBarAvailableRomType() {
        java.lang.Integer num = romType;
        if (num != null) {
            return num.intValue();
        }
        if (isMIUIV6OrAbove()) {
            java.lang.Integer num2 = 1;
            romType = num2;
            return num2.intValue();
        }
        if (isFlymeV4OrAbove()) {
            java.lang.Integer num3 = 2;
            romType = num3;
            return num3.intValue();
        }
        if (isAndroid5OrAbove()) {
            java.lang.Integer num4 = 3;
            romType = num4;
            return num4.intValue();
        }
        java.lang.Integer num5 = 4;
        romType = num5;
        return num5.intValue();
    }

    private static boolean isFlymeV4OrAbove() {
        return getFlymeVersion() >= 4;
    }

    public static int getFlymeVersion() {
        java.lang.String str = android.os.Build.DISPLAY;
        if (android.text.TextUtils.isEmpty(str) || !str.contains("Flyme")) {
            return 0;
        }
        return com.up366.medialibrary.common.utils.StringUtils.stringToInt(str.replaceAll("Flyme", "").replaceAll("OS", "").replaceAll(" ", "").substring(0, 1));
    }

    private static boolean isMIUIV6OrAbove() throws java.lang.Throwable {
        java.lang.String systemProperty = getSystemProperty();
        if (android.text.TextUtils.isEmpty(systemProperty)) {
            return false;
        }
        try {
            return com.up366.medialibrary.common.utils.ValueOf.toInt(systemProperty) >= 4;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getMIUIVersionCode() throws java.lang.Throwable {
        java.lang.String systemProperty = getSystemProperty();
        if (android.text.TextUtils.isEmpty(systemProperty)) {
            return 0;
        }
        try {
            return com.up366.medialibrary.common.utils.ValueOf.toInt(systemProperty);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static java.lang.String getSystemProperty() throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ro.miui.ui.version.code").getInputStream()), 1024);
            try {
                java.lang.String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                return line;
            } catch (java.io.IOException unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.io.IOException unused2) {
            bufferedReader = null;
        } catch (java.lang.Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }
}
