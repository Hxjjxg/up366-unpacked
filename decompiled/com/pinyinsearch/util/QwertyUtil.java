package com.pinyinsearch.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class QwertyUtil {
    public static boolean match(com.pinyinsearch.model.PinyinSearchUnit pinyinSearchUnit, java.lang.String str) {
        if (pinyinSearchUnit == null || str == null || pinyinSearchUnit.getBaseData() == null || pinyinSearchUnit.getMatchKeyword() == null) {
            return false;
        }
        pinyinSearchUnit.getMatchKeyword().delete(0, pinyinSearchUnit.getMatchKeyword().length());
        java.lang.String lowerCase = str.toLowerCase();
        int iIndexOf = pinyinSearchUnit.getBaseData().toLowerCase().indexOf(lowerCase);
        if (iIndexOf > -1) {
            pinyinSearchUnit.getMatchKeyword().append(pinyinSearchUnit.getBaseData().substring(iIndexOf, lowerCase.length() + iIndexOf));
            return true;
        }
        int size = pinyinSearchUnit.getPinyinUnits().size();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < size; i++) {
            pinyinSearchUnit.getMatchKeyword().delete(0, pinyinSearchUnit.getMatchKeyword().length());
            stringBuffer.delete(0, stringBuffer.length());
            stringBuffer.append(lowerCase);
            if (findPinyinUnits(pinyinSearchUnit.getPinyinUnits(), i, 0, pinyinSearchUnit.getBaseData(), stringBuffer, pinyinSearchUnit.getMatchKeyword())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean findPinyinUnits(java.util.List<com.pinyinsearch.model.PinyinUnit> list, int i, int i2, java.lang.String str, java.lang.StringBuffer stringBuffer, java.lang.StringBuffer stringBuffer2) {
        int i3;
        int i4;
        int i5 = 0;
        if (list == null || str == null || stringBuffer == null || stringBuffer2 == null) {
            return false;
        }
        java.lang.String string = stringBuffer.toString();
        if (string.length() <= 0) {
            return true;
        }
        if (i >= list.size()) {
            return false;
        }
        com.pinyinsearch.model.PinyinUnit pinyinUnit = list.get(i);
        if (i2 >= pinyinUnit.getPinyinBaseUnitIndex().size()) {
            return false;
        }
        com.pinyinsearch.model.PinyinBaseUnit pinyinBaseUnit = pinyinUnit.getPinyinBaseUnitIndex().get(i2);
        if (pinyinUnit.isPinyin()) {
            if (string.startsWith(java.lang.String.valueOf(pinyinBaseUnit.getPinyin().charAt(0)))) {
                stringBuffer.delete(0, 1);
                stringBuffer2.append(str.charAt(pinyinUnit.getStartPosition()));
                if (findPinyinUnits(list, i + 1, 0, str, stringBuffer, stringBuffer2)) {
                    return true;
                }
                stringBuffer.insert(0, pinyinBaseUnit.getPinyin().charAt(0));
                stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
            }
            if (pinyinBaseUnit.getPinyin().startsWith(string)) {
                stringBuffer2.append(str.charAt(pinyinUnit.getStartPosition()));
                stringBuffer.delete(0, stringBuffer.length());
                return true;
            }
            if (string.startsWith(pinyinBaseUnit.getPinyin())) {
                stringBuffer.delete(0, pinyinBaseUnit.getPinyin().length());
                stringBuffer2.append(str.charAt(pinyinUnit.getStartPosition()));
                if (findPinyinUnits(list, i + 1, 0, str, stringBuffer, stringBuffer2)) {
                    return true;
                }
                stringBuffer.insert(0, pinyinBaseUnit.getPinyin());
                stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
            } else if (findPinyinUnits(list, i, i2 + 1, str, stringBuffer, stringBuffer2)) {
                return true;
            }
        } else {
            if (pinyinBaseUnit.getPinyin().startsWith(string)) {
                stringBuffer2.append(str.substring(pinyinUnit.getStartPosition(), pinyinUnit.getStartPosition() + string.length()));
                stringBuffer.delete(0, stringBuffer.length());
                return true;
            }
            if (string.startsWith(pinyinBaseUnit.getPinyin())) {
                stringBuffer.delete(0, pinyinBaseUnit.getPinyin().length());
                stringBuffer2.append(str.substring(pinyinUnit.getStartPosition(), pinyinUnit.getStartPosition() + pinyinBaseUnit.getPinyin().length()));
                if (findPinyinUnits(list, i + 1, 0, str, stringBuffer, stringBuffer2)) {
                    return true;
                }
                stringBuffer.insert(0, pinyinBaseUnit.getPinyin());
                stringBuffer2.delete(stringBuffer2.length() - pinyinBaseUnit.getPinyin().length(), stringBuffer2.length());
            } else {
                if (stringBuffer2.length() > 0) {
                    return findPinyinUnits(list, i, i2 + 1, str, stringBuffer, stringBuffer2);
                }
                if (pinyinBaseUnit.getPinyin().contains(string)) {
                    int iIndexOf = pinyinBaseUnit.getPinyin().indexOf(string);
                    stringBuffer2.append(str.substring(pinyinUnit.getStartPosition() + iIndexOf, iIndexOf + pinyinUnit.getStartPosition() + string.length()));
                    stringBuffer.delete(0, stringBuffer.length());
                    return true;
                }
                int length = pinyinBaseUnit.getPinyin().length();
                int i6 = 0;
                while (i6 < length) {
                    java.lang.String strSubstring = pinyinBaseUnit.getPinyin().substring(i6);
                    if (string.startsWith(strSubstring)) {
                        stringBuffer.delete(i5, strSubstring.length());
                        stringBuffer2.append(str.substring(pinyinUnit.getStartPosition() + i6, pinyinUnit.getStartPosition() + i6 + strSubstring.length()));
                        i3 = i6;
                        i4 = length;
                        if (findPinyinUnits(list, i + 1, 0, str, stringBuffer, stringBuffer2)) {
                            return true;
                        }
                        stringBuffer.insert(0, pinyinBaseUnit.getPinyin().substring(i3));
                        stringBuffer2.delete(stringBuffer2.length() - strSubstring.length(), stringBuffer2.length());
                    } else {
                        i3 = i6;
                        i4 = length;
                    }
                    i6 = i3 + 1;
                    length = i4;
                    i5 = 0;
                }
                if (findPinyinUnits(list, i, i2 + 1, str, stringBuffer, stringBuffer2)) {
                    return true;
                }
            }
        }
        return i5;
    }
}
