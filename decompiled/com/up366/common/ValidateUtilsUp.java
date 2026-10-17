package com.up366.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ValidateUtilsUp {
    private static java.util.regex.Pattern pMobile = java.util.regex.Pattern.compile("^(13|15|18|14|17|19|16)[0-9]{9}$");
    private static java.util.regex.Pattern pTel = java.util.regex.Pattern.compile("^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{1,5}))?$");
    private static java.util.regex.Pattern pUsername = java.util.regex.Pattern.compile("^[a-z_][a-z0-9_]{4,32}$");
    private static java.util.regex.Pattern pPassword = java.util.regex.Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,15}$");
    private static java.util.regex.Pattern pQQ = java.util.regex.Pattern.compile("^[1-9]*[1-9][0-9]*$");

    private static boolean isEmojiCharacter(char c) {
        if (c == 9760 || c == 9996 || c == 9994 || c == 9785 || c == 9786) {
            return true;
        }
        return (c == 0 || c == '\t' || c == '\n' || c == '\r' || (c >= ' ' && c <= 55295) || ((c >= 57344 && c <= 65533) || (c >= 0 && c <= 65535))) ? false : true;
    }

    public static boolean isMail(java.lang.String str) {
        return match("^([a-z0-9A-Z]+[-_\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", str);
    }

    public static boolean isMobile(java.lang.String str) {
        return pMobile.matcher(str).matches();
    }

    public static boolean isTel(java.lang.String str) {
        return pTel.matcher(str).matches();
    }

    public static boolean isUsername(java.lang.String str) {
        return pUsername.matcher(str).matches();
    }

    @java.lang.Deprecated
    public static boolean isPassword(java.lang.String str) {
        return pPassword.matcher(str).matches();
    }

    public static boolean verifyPassword(java.lang.String str) {
        return str != null && str.matches(".*[a-z].*") && str.matches(".*[A-Z].*") && str.matches(".*[0-9].*") && str.matches(".*[\\-=\\[\\]\\\\;,.'/~!@#$%^&*()_+{}|:\"<>?].*") && str.matches("[a-zA-Z0-9\\-=\\[\\]\\\\;,.'/~!@#$%^&*()_+{}|:\"<>?]{8,15}");
    }

    public static boolean verifyPasswordV2(java.lang.String str) {
        return str != null && str.matches(".*[a-z].*") && str.matches(".*[A-Z].*") && str.matches(".*[0-9].*") && str.matches("[a-zA-Z0-9]{8,16}");
    }

    public static boolean isQQ(java.lang.String str) {
        return pQQ.matcher(str).matches();
    }

    public static boolean isIdCardNo(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        java.util.HashMap map = new java.util.HashMap();
        map.put(11, "北京");
        map.put(12, "天津");
        map.put(13, "河北");
        map.put(14, "山西");
        map.put(15, "内蒙古");
        map.put(21, "辽宁");
        map.put(22, "吉林");
        map.put(23, "黑龙江");
        map.put(31, "上海");
        map.put(32, "江苏");
        map.put(33, "浙江");
        map.put(34, "安徽");
        map.put(35, "福建");
        map.put(36, "江西");
        map.put(37, "山东");
        map.put(41, "河南");
        map.put(42, "湖北");
        map.put(43, "湖南");
        map.put(44, "广东");
        map.put(45, "广西");
        map.put(46, "海南");
        map.put(50, "重庆");
        map.put(51, "四川");
        map.put(52, "贵州");
        map.put(53, "云南");
        map.put(54, "西藏");
        map.put(61, "陕西");
        map.put(62, "甘肃");
        map.put(63, "青海");
        map.put(64, "宁夏");
        map.put(65, "新疆");
        map.put(71, "台湾");
        map.put(81, "香港");
        map.put(82, "澳门");
        map.put(91, "国外");
        if (str == null || str.equals("") || (!(str.length() == 15 || str.length() == 18) || map.get(java.lang.Integer.valueOf(java.lang.Integer.parseInt(str.substring(0, 2)))) == null)) {
            return false;
        }
        if (str.length() == 15) {
            int i = java.lang.Integer.parseInt(str.substring(2, 6)) + 1900;
            int i2 = i % 4;
            if (i2 == 0 || (i % 100 == 0 && i2 == 0)) {
                str3 = "^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$";
            } else {
                str3 = "^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$";
            }
            return match(str3, str);
        }
        if (str.length() == 18) {
            int i3 = java.lang.Integer.parseInt(str.substring(2, 6)) + 1900;
            int i4 = i3 % 4;
            if (i4 == 0 || (i3 % 100 == 0 && i4 == 0)) {
                str2 = "^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$";
            } else {
                str2 = "^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$";
            }
            if (match(str2, str)) {
                java.lang.String[] strArr = new java.lang.String[18];
                int i5 = 0;
                while (i5 < str.length()) {
                    int i6 = i5 + 1;
                    strArr[i5] = str.substring(i5, i6);
                    i5 = i6;
                }
                int iIntValue = (((((((((((java.lang.Integer.valueOf(strArr[0]).intValue() + java.lang.Integer.valueOf(strArr[10]).intValue()) * 7) + ((java.lang.Integer.valueOf(strArr[1]).intValue() + java.lang.Integer.valueOf(strArr[11]).intValue()) * 9)) + ((java.lang.Integer.valueOf(strArr[2]).intValue() + java.lang.Integer.valueOf(strArr[12]).intValue()) * 10)) + ((java.lang.Integer.valueOf(strArr[3]).intValue() + java.lang.Integer.valueOf(strArr[13]).intValue()) * 5)) + ((java.lang.Integer.valueOf(strArr[4]).intValue() + java.lang.Integer.valueOf(strArr[14]).intValue()) * 8)) + ((java.lang.Integer.valueOf(strArr[5]).intValue() + java.lang.Integer.valueOf(strArr[15]).intValue()) * 4)) + ((java.lang.Integer.valueOf(strArr[6]).intValue() + java.lang.Integer.valueOf(strArr[16]).intValue()) * 2)) + java.lang.Integer.valueOf(strArr[7]).intValue()) + (java.lang.Integer.valueOf(strArr[8]).intValue() * 6)) + (java.lang.Integer.valueOf(strArr[9]).intValue() * 3)) % 11;
                return "10X98765432".substring(iIntValue, iIntValue + 1).equalsIgnoreCase(java.lang.String.valueOf(strArr[17]));
            }
        }
        return false;
    }

    public static boolean containsEmoji(java.lang.String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (isEmojiCharacter(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean match(java.lang.String str, java.lang.String str2) {
        return java.util.regex.Pattern.compile(str, 34).matcher(str2).matches();
    }
}
