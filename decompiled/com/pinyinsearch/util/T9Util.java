package com.pinyinsearch.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class T9Util {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0016 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0019 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0007 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0010 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0013 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static char getT9Number(char r0) {
        /*
            switch(r0) {
                case 65: goto L1c;
                case 66: goto L1c;
                case 67: goto L1c;
                case 68: goto L19;
                case 69: goto L19;
                case 70: goto L19;
                case 71: goto L16;
                case 72: goto L16;
                case 73: goto L16;
                case 74: goto L13;
                case 75: goto L13;
                case 76: goto L13;
                case 77: goto L10;
                case 78: goto L10;
                case 79: goto L10;
                case 80: goto Ld;
                case 81: goto Ld;
                case 82: goto Ld;
                case 83: goto Ld;
                case 84: goto La;
                case 85: goto La;
                case 86: goto La;
                case 87: goto L7;
                case 88: goto L7;
                case 89: goto L7;
                case 90: goto L7;
                default: goto L3;
            }
        L3:
            switch(r0) {
                case 97: goto L1c;
                case 98: goto L1c;
                case 99: goto L1c;
                case 100: goto L19;
                case 101: goto L19;
                case 102: goto L19;
                case 103: goto L16;
                case 104: goto L16;
                case 105: goto L16;
                case 106: goto L13;
                case 107: goto L13;
                case 108: goto L13;
                case 109: goto L10;
                case 110: goto L10;
                case 111: goto L10;
                case 112: goto Ld;
                case 113: goto Ld;
                case 114: goto Ld;
                case 115: goto Ld;
                case 116: goto La;
                case 117: goto La;
                case 118: goto La;
                case 119: goto L7;
                case 120: goto L7;
                case 121: goto L7;
                case 122: goto L7;
                default: goto L6;
            }
        L6:
            goto L1e
        L7:
            r0 = 57
            goto L1e
        La:
            r0 = 56
            goto L1e
        Ld:
            r0 = 55
            goto L1e
        L10:
            r0 = 54
            goto L1e
        L13:
            r0 = 53
            goto L1e
        L16:
            r0 = 52
            goto L1e
        L19:
            r0 = 51
            goto L1e
        L1c:
            r0 = 50
        L1e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinyinsearch.util.T9Util.getT9Number(char):char");
    }

    public static boolean match(com.pinyinsearch.model.PinyinSearchUnit pinyinSearchUnit, java.lang.String str) {
        if (pinyinSearchUnit == null || str == null || pinyinSearchUnit.getBaseData() == null || pinyinSearchUnit.getMatchKeyword() == null) {
            return false;
        }
        pinyinSearchUnit.getMatchKeyword().delete(0, pinyinSearchUnit.getMatchKeyword().length());
        int size = pinyinSearchUnit.getPinyinUnits().size();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < size; i++) {
            pinyinSearchUnit.getMatchKeyword().delete(0, pinyinSearchUnit.getMatchKeyword().length());
            stringBuffer.delete(0, stringBuffer.length());
            stringBuffer.append(str);
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
            if (string.startsWith(java.lang.String.valueOf(pinyinBaseUnit.getNumber().charAt(0)))) {
                stringBuffer.delete(0, 1);
                stringBuffer2.append(str.charAt(pinyinUnit.getStartPosition()));
                if (findPinyinUnits(list, i + 1, 0, str, stringBuffer, stringBuffer2)) {
                    return true;
                }
                stringBuffer.insert(0, pinyinBaseUnit.getNumber().charAt(0));
                stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
            }
            if (pinyinBaseUnit.getNumber().startsWith(string)) {
                stringBuffer2.append(str.charAt(pinyinUnit.getStartPosition()));
                stringBuffer.delete(0, stringBuffer.length());
                return true;
            }
            if (string.startsWith(pinyinBaseUnit.getNumber())) {
                stringBuffer.delete(0, pinyinBaseUnit.getNumber().length());
                stringBuffer2.append(str.charAt(pinyinUnit.getStartPosition()));
                if (findPinyinUnits(list, i + 1, 0, str, stringBuffer, stringBuffer2)) {
                    return true;
                }
                stringBuffer.insert(0, pinyinBaseUnit.getNumber());
                stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
            } else if (findPinyinUnits(list, i, i2 + 1, str, stringBuffer, stringBuffer2)) {
                return true;
            }
        } else {
            if (pinyinBaseUnit.getNumber().startsWith(string)) {
                stringBuffer2.append(str.substring(pinyinUnit.getStartPosition(), pinyinUnit.getStartPosition() + string.length()));
                stringBuffer.delete(0, stringBuffer.length());
                return true;
            }
            if (string.startsWith(pinyinBaseUnit.getNumber())) {
                stringBuffer.delete(0, pinyinBaseUnit.getNumber().length());
                stringBuffer2.append(str.substring(pinyinUnit.getStartPosition(), pinyinUnit.getStartPosition() + pinyinBaseUnit.getNumber().length()));
                if (findPinyinUnits(list, i + 1, 0, str, stringBuffer, stringBuffer2)) {
                    return true;
                }
                stringBuffer.insert(0, pinyinBaseUnit.getNumber());
                stringBuffer2.delete(stringBuffer2.length() - pinyinBaseUnit.getNumber().length(), stringBuffer2.length());
            } else {
                if (stringBuffer2.length() > 0) {
                    return findPinyinUnits(list, i, i2 + 1, str, stringBuffer, stringBuffer2);
                }
                if (pinyinBaseUnit.getNumber().contains(string)) {
                    int iIndexOf = pinyinBaseUnit.getNumber().indexOf(string);
                    stringBuffer2.append(str.substring(pinyinUnit.getStartPosition() + iIndexOf, iIndexOf + pinyinUnit.getStartPosition() + string.length()));
                    stringBuffer.delete(0, stringBuffer.length());
                    return true;
                }
                int length = pinyinBaseUnit.getNumber().length();
                int i6 = 0;
                while (i6 < length) {
                    java.lang.String strSubstring = pinyinBaseUnit.getNumber().substring(i6);
                    if (string.startsWith(strSubstring)) {
                        stringBuffer.delete(i5, strSubstring.length());
                        stringBuffer2.append(str.substring(pinyinUnit.getStartPosition() + i6, pinyinUnit.getStartPosition() + i6 + strSubstring.length()));
                        i3 = i6;
                        i4 = length;
                        if (findPinyinUnits(list, i + 1, 0, str, stringBuffer, stringBuffer2)) {
                            return true;
                        }
                        stringBuffer.insert(0, pinyinBaseUnit.getNumber().substring(i3));
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
