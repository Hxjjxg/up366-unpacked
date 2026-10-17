package com.up366.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StringUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static boolean isEmptyOrNull(java.lang.String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static java.lang.String join(java.lang.Object[] objArr, java.lang.String str) {
        if (objArr == null) {
            return null;
        }
        int length = objArr.length;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(str);
            }
            java.lang.Object obj = objArr[i];
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static java.lang.String join(java.util.List<java.lang.String> list, java.lang.String str) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(str);
            }
            if (list.get(i) != null) {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }

    public static java.lang.String format(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(java.util.Locale.getDefault(), str, objArr);
    }

    public static java.lang.String covertCHNumber(int i) {
        java.lang.String strValueOf = java.lang.String.valueOf(i);
        if (strValueOf.length() == 1) {
            return "" + GetCH(i);
        }
        if (strValueOf.length() == 2) {
            java.lang.String str = "十";
            if (!strValueOf.substring(0, 1).equals("1")) {
                str = "" + GetCH(i / 10) + "十";
            }
            return str + ToCH(i % 10);
        }
        if (strValueOf.length() == 3) {
            java.lang.String str2 = "" + GetCH(i / 100) + "百";
            int i2 = i % 100;
            if (i2 > 0 && java.lang.String.valueOf(i2).length() < 2) {
                str2 = str2 + "零";
            }
            return str2 + ToCH(i2);
        }
        if (strValueOf.length() == 4) {
            java.lang.String str3 = "" + GetCH(i / 1000) + "千";
            if (i % 100 > 0 && java.lang.String.valueOf(i % 1000).length() < 3) {
                str3 = str3 + "零";
            }
            return str3 + ToCH(i % 1000);
        }
        if (strValueOf.length() != 5) {
            return "";
        }
        java.lang.String str4 = "" + GetCH(i / 10000) + "万";
        if (i % 100 > 0 && java.lang.String.valueOf(i % 10000).length() < 4) {
            str4 = str4 + "零";
        }
        return str4 + ToCH(i % 10000);
    }

    public static java.lang.String getUtV2(java.lang.String str, java.lang.String str2) {
        return bytesToHexString(com.up366.common.utils.EncryptUtil.enc((com.up366.common.digest.MD5.md5(str) + str2).getBytes(), 99));
    }

    public static java.lang.String getUt(java.lang.String str, int i) {
        java.lang.String str2;
        java.io.FileInputStream fileInputStream;
        java.io.IOException e;
        switch ((int) java.lang.System.currentTimeMillis()) {
            case 1:
                str2 = "0x";
                break;
            case 2:
                str2 = "33xx";
                break;
            case 3:
                str2 = "三";
                break;
            case 4:
                str2 = "";
                break;
            case 5:
                str2 = "\u3000\u3000";
                break;
            case 6:
                str2 = "鸡";
                break;
            case 7:
                str2 = "七";
                break;
            case 8:
                str2 = "$%^7";
                break;
            case 9:
                str2 = "    HG";
                break;
            default:
                return bytesToHexString(com.up366.common.utils.EncryptUtil.enc(str.getBytes(), i));
        }
        try {
            fileInputStream = new java.io.FileInputStream((java.io.File) null);
        } catch (java.io.IOException e2) {
            fileInputStream = null;
            e = e2;
        }
        try {
            new java.io.FileOutputStream((java.io.File) null);
        } catch (java.io.IOException e3) {
            e = e3;
            e.printStackTrace();
        }
        return fileInputStream.toString() + str2;
    }

    private static java.lang.String bytesToHexString(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                sb.append("0");
            }
            sb.append(java.lang.Integer.toHexString(i));
        }
        return sb.toString();
    }

    private static java.lang.String GetCH(int i) {
        switch (i) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            default:
                return "";
        }
    }

    private static java.lang.String ToCH(int i) {
        java.lang.String strValueOf = java.lang.String.valueOf(i);
        if (strValueOf.length() == 1) {
            return "" + GetCH(i);
        }
        if (strValueOf.length() == 2) {
            java.lang.String str = "十";
            if (!strValueOf.substring(0, 1).equals("1")) {
                str = "" + GetCH(i / 10) + "十";
            }
            return str + ToCH(i % 10);
        }
        if (strValueOf.length() == 3) {
            java.lang.String str2 = "" + GetCH(i / 100) + "百";
            int i2 = i % 100;
            if (java.lang.String.valueOf(i2).length() < 2) {
                str2 = str2 + "零";
            }
            return str2 + ToCH(i2);
        }
        if (strValueOf.length() == 4) {
            java.lang.String str3 = "" + GetCH(i / 1000) + "千";
            int i3 = i % 1000;
            if (java.lang.String.valueOf(i3).length() < 3) {
                str3 = str3 + "零";
            }
            return str3 + ToCH(i3);
        }
        if (strValueOf.length() != 5) {
            return "";
        }
        java.lang.String str4 = "" + GetCH(i / 10000) + "萬";
        int i4 = i % 10000;
        if (java.lang.String.valueOf(i4).length() < 4) {
            str4 = str4 + "零";
        }
        return str4 + ToCH(i4);
    }

    public static java.lang.String repeat(java.lang.String str, int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Number of repetitions cannot be negative.");
        }
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
