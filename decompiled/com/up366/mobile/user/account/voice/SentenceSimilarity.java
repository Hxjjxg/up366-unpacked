package com.up366.mobile.user.account.voice;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SentenceSimilarity {
    public static int calculateDistance(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new java.lang.IllegalArgumentException("Input parameters must not be null");
        }
        int length = charSequence.length();
        int i = length + 1;
        int length2 = charSequence2.length() + 1;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
        }
        int i3 = 1;
        while (i3 < length2) {
            iArr2[0] = i3;
            for (int i4 = 1; i4 < i; i4++) {
                int i5 = i4 - 1;
                iArr2[i4] = java.lang.Math.min(java.lang.Math.min(iArr[i4] + 1, iArr2[i5] + 1), iArr[i5] + (charSequence.charAt(i5) == charSequence2.charAt(i3 + (-1)) ? 0 : 1));
            }
            i3++;
            int[] iArr3 = iArr2;
            iArr2 = iArr;
            iArr = iArr3;
        }
        return iArr[length];
    }

    public static double wordsSimilarity(java.lang.String str, java.lang.String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return 0.0d;
        }
        java.lang.String[] strArrSplit = str.toLowerCase().split("[\\ \\,\\.\\?!]+");
        java.lang.String[] strArrSplit2 = str2.toLowerCase().split("[\\ \\,\\.\\?!]+");
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < strArrSplit2.length; i3++) {
            int length = strArrSplit2[i3].length();
            int i4 = i2;
            while (true) {
                if (i4 < strArrSplit.length) {
                    int iCalculateDistance = calculateDistance(strArrSplit[i4], strArrSplit2[i3]);
                    if (iCalculateDistance < java.lang.Math.floor(strArrSplit2[i3].length() / 4) + 1.0d) {
                        i2 = i4;
                        length = iCalculateDistance;
                        break;
                    }
                    i4++;
                }
            }
            i += length;
        }
        double length2 = (str2.length() - strArrSplit2.length) + 1;
        return ((length2 - ((double) i)) * 1.0d) / length2;
    }

    public static double similarityPercentage(java.lang.String str, java.lang.String str2) {
        double length = str.length() > str2.length() ? str.length() : str2.length();
        return (length - ((double) calculateDistance(str, str2))) / length;
    }

    public static double diffPercentage(java.lang.String str, java.lang.String str2) {
        return ((double) calculateDistance(str, str2)) / ((double) (str.length() > str2.length() ? str.length() : str2.length()));
    }
}
