package com.pinyinsearch.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PinyinUtil {
    private static net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat format = new net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat();

    public static void parse(com.pinyinsearch.model.PinyinSearchUnit pinyinSearchUnit) {
        int i;
        if (pinyinSearchUnit == null || android.text.TextUtils.isEmpty(pinyinSearchUnit.getBaseData()) || pinyinSearchUnit.getPinyinUnits() == null) {
            return;
        }
        java.lang.String lowerCase = pinyinSearchUnit.getBaseData().toLowerCase();
        if (format == null) {
            format = new net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat();
        }
        format.setToneType(net.sourceforge.pinyin4j.format.HanyuPinyinToneType.WITHOUT_TONE);
        int length = lowerCase.length();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        com.pinyinsearch.model.PinyinUnit pinyinUnit = null;
        boolean z = true;
        int i2 = 0;
        int i3 = -1;
        java.lang.String[] hanyuPinyinStringArray = null;
        while (i2 < length) {
            char cCharAt = lowerCase.charAt(i2);
            try {
                hanyuPinyinStringArray = net.sourceforge.pinyin4j.PinyinHelper.toHanyuPinyinStringArray(cCharAt, format);
            } catch (net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
            if (hanyuPinyinStringArray == null) {
                if (z) {
                    pinyinUnit = new com.pinyinsearch.model.PinyinUnit();
                    stringBuffer.delete(0, stringBuffer.length());
                    z = false;
                    i3 = i2;
                }
                stringBuffer.append(cCharAt);
                i = i2;
            } else {
                if (!z) {
                    addPinyinUnit(pinyinSearchUnit.getPinyinUnits(), pinyinUnit, false, stringBuffer.toString(), new java.lang.String[]{stringBuffer.toString()}, i3);
                    stringBuffer.delete(0, stringBuffer.length());
                    z = true;
                }
                com.pinyinsearch.model.PinyinUnit pinyinUnit2 = new com.pinyinsearch.model.PinyinUnit();
                i = i2;
                addPinyinUnit(pinyinSearchUnit.getPinyinUnits(), pinyinUnit2, true, java.lang.String.valueOf(cCharAt), hanyuPinyinStringArray, i);
                pinyinUnit = pinyinUnit2;
                i3 = i;
            }
            i2 = i + 1;
        }
        if (z) {
            return;
        }
        addPinyinUnit(pinyinSearchUnit.getPinyinUnits(), pinyinUnit, false, stringBuffer.toString(), new java.lang.String[]{stringBuffer.toString()}, i3);
        stringBuffer.delete(0, stringBuffer.length());
    }

    public static java.lang.String getFirstLetter(com.pinyinsearch.model.PinyinSearchUnit pinyinSearchUnit) {
        java.util.List<com.pinyinsearch.model.PinyinUnit> pinyinUnits;
        java.util.List<com.pinyinsearch.model.PinyinBaseUnit> pinyinBaseUnitIndex;
        java.lang.String pinyin;
        if (pinyinSearchUnit == null || (pinyinUnits = pinyinSearchUnit.getPinyinUnits()) == null || pinyinUnits.size() <= 0 || (pinyinBaseUnitIndex = pinyinUnits.get(0).getPinyinBaseUnitIndex()) == null || pinyinBaseUnitIndex.size() <= 0 || (pinyin = pinyinBaseUnitIndex.get(0).getPinyin()) == null || pinyin.length() <= 0) {
            return null;
        }
        return java.lang.String.valueOf(pinyin.charAt(0));
    }

    public static java.lang.String getFirstCharacter(com.pinyinsearch.model.PinyinSearchUnit pinyinSearchUnit) {
        java.util.List<com.pinyinsearch.model.PinyinUnit> pinyinUnits;
        java.util.List<com.pinyinsearch.model.PinyinBaseUnit> pinyinBaseUnitIndex;
        java.lang.String originalString;
        if (pinyinSearchUnit == null || (pinyinUnits = pinyinSearchUnit.getPinyinUnits()) == null || pinyinUnits.size() <= 0 || (pinyinBaseUnitIndex = pinyinUnits.get(0).getPinyinBaseUnitIndex()) == null || pinyinBaseUnitIndex.size() <= 0 || (originalString = pinyinBaseUnitIndex.get(0).getOriginalString()) == null || originalString.length() <= 0) {
            return null;
        }
        return java.lang.String.valueOf(originalString.charAt(0));
    }

    public static java.lang.String getSortKey(com.pinyinsearch.model.PinyinSearchUnit pinyinSearchUnit) {
        java.util.List<com.pinyinsearch.model.PinyinUnit> pinyinUnits;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.delete(0, stringBuffer.length());
        if (pinyinSearchUnit == null || (pinyinUnits = pinyinSearchUnit.getPinyinUnits()) == null || pinyinUnits.size() <= 0) {
            return null;
        }
        for (com.pinyinsearch.model.PinyinUnit pinyinUnit : pinyinUnits) {
            if (pinyinUnit.isPinyin()) {
                stringBuffer.append(pinyinUnit.getPinyinBaseUnitIndex().get(0).getPinyin()).append(" ");
                stringBuffer.append(pinyinUnit.getPinyinBaseUnitIndex().get(0).getOriginalString()).append(" ");
            } else {
                stringBuffer.append(pinyinUnit.getPinyinBaseUnitIndex().get(0).getOriginalString()).append(" ");
            }
        }
        return stringBuffer.toString();
    }

    public static boolean isKanji(char c) {
        java.lang.String[] hanyuPinyinStringArray;
        try {
            hanyuPinyinStringArray = net.sourceforge.pinyin4j.PinyinHelper.toHanyuPinyinStringArray(c, format);
        } catch (net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
            hanyuPinyinStringArray = null;
        }
        return hanyuPinyinStringArray != null;
    }

    private static void addPinyinUnit(java.util.List<com.pinyinsearch.model.PinyinUnit> list, com.pinyinsearch.model.PinyinUnit pinyinUnit, boolean z, java.lang.String str, java.lang.String[] strArr, int i) {
        if (list == null || pinyinUnit == null || str == null || strArr == null) {
            return;
        }
        initPinyinUnit(pinyinUnit, z, str, strArr, i);
        list.add(pinyinUnit);
    }

    private static void initPinyinUnit(com.pinyinsearch.model.PinyinUnit pinyinUnit, boolean z, java.lang.String str, java.lang.String[] strArr, int i) {
        if (pinyinUnit == null || str == null || strArr == null) {
            return;
        }
        int length = strArr.length;
        pinyinUnit.setPinyin(z);
        pinyinUnit.setStartPosition(i);
        if (z) {
            if (length > 1) {
                com.pinyinsearch.model.PinyinBaseUnit pinyinBaseUnit = new com.pinyinsearch.model.PinyinBaseUnit();
                initPinyinBaseUnit(pinyinBaseUnit, str, strArr[0]);
                pinyinUnit.getPinyinBaseUnitIndex().add(pinyinBaseUnit);
                for (int i2 = 1; i2 < length; i2++) {
                    int size = pinyinUnit.getPinyinBaseUnitIndex().size();
                    int i3 = 0;
                    while (i3 < size && !pinyinUnit.getPinyinBaseUnitIndex().get(i3).getPinyin().equals(strArr[i2])) {
                        i3++;
                    }
                    if (i3 == size) {
                        com.pinyinsearch.model.PinyinBaseUnit pinyinBaseUnit2 = new com.pinyinsearch.model.PinyinBaseUnit();
                        initPinyinBaseUnit(pinyinBaseUnit2, str, strArr[i2]);
                        pinyinUnit.getPinyinBaseUnitIndex().add(pinyinBaseUnit2);
                    }
                }
                return;
            }
        }
        for (java.lang.String str2 : strArr) {
            com.pinyinsearch.model.PinyinBaseUnit pinyinBaseUnit3 = new com.pinyinsearch.model.PinyinBaseUnit();
            initPinyinBaseUnit(pinyinBaseUnit3, str, str2);
            pinyinUnit.getPinyinBaseUnitIndex().add(pinyinBaseUnit3);
        }
    }

    private static void initPinyinBaseUnit(com.pinyinsearch.model.PinyinBaseUnit pinyinBaseUnit, java.lang.String str, java.lang.String str2) {
        if (pinyinBaseUnit == null || str == null || str2 == null) {
            return;
        }
        pinyinBaseUnit.setOriginalString(new java.lang.String(str));
        pinyinBaseUnit.setPinyin(new java.lang.String(str2));
        int length = str2.length();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.delete(0, stringBuffer.length());
        for (int i = 0; i < length; i++) {
            stringBuffer.append(com.pinyinsearch.util.T9Util.getT9Number(str2.charAt(i)));
        }
        pinyinBaseUnit.setNumber(new java.lang.String(stringBuffer.toString()));
        stringBuffer.delete(0, stringBuffer.length());
    }
}
