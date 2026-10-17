package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ValueOf {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T to(java.lang.Object obj, T t) {
        return obj == 0 ? t : obj;
    }

    public static java.lang.String toString(java.lang.Object obj) {
        try {
            return obj.toString();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static double toDouble(java.lang.Object obj) {
        return toDouble(obj, 0);
    }

    public static double toDouble(java.lang.Object obj, int i) {
        if (obj == null) {
            return i;
        }
        try {
            return java.lang.Double.parseDouble(obj.toString().trim());
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    public static long toLong(java.lang.Object obj, long j) {
        long j2;
        if (obj == null) {
            return j;
        }
        try {
            java.lang.String strTrim = obj.toString().trim();
            if (strTrim.contains(".")) {
                j2 = java.lang.Long.parseLong(strTrim.substring(0, strTrim.lastIndexOf(".")));
            } else {
                j2 = java.lang.Long.parseLong(strTrim);
            }
            return j2;
        } catch (java.lang.Exception unused) {
            return j;
        }
    }

    public static long toLong(java.lang.Object obj) {
        return toLong(obj, 0L);
    }

    public static float toFloat(java.lang.Object obj, long j) {
        if (obj == null) {
            return j;
        }
        try {
            return java.lang.Float.parseFloat(obj.toString().trim());
        } catch (java.lang.Exception unused) {
            return j;
        }
    }

    public static float toFloat(java.lang.Object obj) {
        return toFloat(obj, 0L);
    }

    public static int toInt(java.lang.Object obj, int i) {
        int i2;
        if (obj == null) {
            return i;
        }
        try {
            java.lang.String strTrim = obj.toString().trim();
            if (strTrim.contains(".")) {
                i2 = java.lang.Integer.parseInt(strTrim.substring(0, strTrim.lastIndexOf(".")));
            } else {
                i2 = java.lang.Integer.parseInt(strTrim);
            }
            return i2;
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    public static int toInt(java.lang.Object obj) {
        return toInt(obj, 0);
    }

    public static boolean toBoolean(java.lang.Object obj) {
        return toBoolean(obj, false);
    }

    public static boolean toBoolean(java.lang.Object obj, boolean z) {
        if (obj == null) {
            return false;
        }
        try {
            return !"false".equals(obj.toString().trim().trim());
        } catch (java.lang.Exception unused) {
            return z;
        }
    }
}
