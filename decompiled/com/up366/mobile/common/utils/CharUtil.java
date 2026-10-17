package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CharUtil {
    public static void main(java.lang.String[] strArr) {
        java.lang.String[] strArr2 = {"www.micmiu.com", "!@#$%^&*()_+{}[]|\"'?/:;<>,.", "！￥……（）——：；“”‘’《》，。？、", "不要啊", "やめて", "韩佳人", "한가인"};
        for (int i = 0; i < 7; i++) {
            java.lang.String str = strArr2[i];
            java.lang.System.out.println("===========> 测试字符串：" + str);
            java.lang.System.out.println("正则判断：" + isChineseByREG(str) + " -- " + isChineseByName(str));
            java.io.PrintStream printStream = java.lang.System.out;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Unicode判断结果 ：");
            sb.append(isAllChinese(str));
            printStream.println(sb.toString());
            java.lang.System.out.println("详细判断列表：");
            for (char c : str.toCharArray()) {
                java.io.PrintStream printStream2 = java.lang.System.out;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(c);
                sb2.append(" --> ");
                sb2.append(isChinese(c) ? "是" : "否");
                printStream2.println(sb2.toString());
            }
        }
    }

    private static boolean isChinese(char c) {
        java.lang.Character.UnicodeBlock unicodeBlockOf = java.lang.Character.UnicodeBlock.of(c);
        return unicodeBlockOf == java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlockOf == java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS;
    }

    public static boolean isContainChinese(java.lang.String str) {
        for (char c : str.toCharArray()) {
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAllChinese(java.lang.String str) {
        for (char c : str.toCharArray()) {
            if (!isChinese(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isChineseByREG(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return java.util.regex.Pattern.compile("[\\u4E00-\\u9FBF]+").matcher(str.trim()).find();
    }

    public static boolean isChineseByName(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return java.util.regex.Pattern.compile("\\p{InCJK Unified Ideographs}&&\\P{Cn}").matcher(str.trim()).find();
    }
}
