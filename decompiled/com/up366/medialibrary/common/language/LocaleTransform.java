package com.up366.medialibrary.common.language;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LocaleTransform {
    public static java.util.Locale getLanguage(int i) {
        switch (i) {
            case 1:
                return java.util.Locale.TRADITIONAL_CHINESE;
            case 2:
                return java.util.Locale.ENGLISH;
            case 3:
                return java.util.Locale.KOREA;
            case 4:
                return java.util.Locale.GERMANY;
            case 5:
                return java.util.Locale.FRANCE;
            case 6:
                return java.util.Locale.JAPAN;
            case 7:
                return new java.util.Locale("vi");
            case 8:
                return new java.util.Locale("es", "ES");
            case 9:
                return new java.util.Locale("pt", com.igexin.assist.sdk.AssistPushConsts.MSG_VALUE_PAYLOAD);
            case 10:
                return new java.util.Locale("ar", "AE");
            default:
                return java.util.Locale.CHINESE;
        }
    }
}
