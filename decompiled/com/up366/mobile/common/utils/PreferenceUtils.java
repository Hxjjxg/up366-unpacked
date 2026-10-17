package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PreferenceUtils {
    private static final java.lang.String GLOBLE_SETTING = "app_settings";
    private static final java.lang.String GLOBLE_TEXT = "app_text";

    public static void compatData() {
        android.content.SharedPreferences sharedPreferences = com.up366.common.global.GB.getCallBack().getApplicationContext().getSharedPreferences(GLOBLE_SETTING, 0);
        com.tencent.mmkv.MMKV.mmkvWithID(GLOBLE_SETTING).importFromSharedPreferences(sharedPreferences);
        sharedPreferences.edit().clear().commit();
        android.content.SharedPreferences sharedPreferences2 = com.up366.common.global.GB.getCallBack().getApplicationContext().getSharedPreferences(GLOBLE_TEXT, 0);
        com.tencent.mmkv.MMKV.mmkvWithID(GLOBLE_TEXT).importFromSharedPreferences(sharedPreferences2);
        sharedPreferences2.edit().clear().commit();
    }

    public static void putString(java.lang.String str, java.lang.String str2) {
        getShare().edit().putString(str, str2).apply();
    }

    public static void putStringSync(java.lang.String str, java.lang.String str2) {
        getShare().edit().putString(str, str2).commit();
    }

    public static java.lang.String getString(java.lang.String str, java.lang.String str2) {
        return getShare().getString(str, str2);
    }

    public static void putText(java.lang.String str, java.lang.String str2) {
        getShareText().edit().putString(str, com.up366.common.ZipStringUtils.zip(str2)).apply();
    }

    public static void putTextSync(java.lang.String str, java.lang.String str2) {
        getShareText().edit().putString(str, com.up366.common.ZipStringUtils.zip(str2)).commit();
    }

    public static java.lang.String getText(java.lang.String str, java.lang.String str2) {
        java.lang.String string = getShareText().getString(str, str2);
        if (!com.up366.common.StringUtils.isEmptyOrNull(string) && !string.equals(str2)) {
            try {
                return com.up366.common.ZipStringUtils.unzip(string);
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error(e.getMessage(), e);
            }
        }
        return str2;
    }

    public static void putInt(java.lang.String str, int i) {
        getShare().edit().putInt(str, i).apply();
    }

    public static void putIntSync(java.lang.String str, int i) {
        getShare().edit().putInt(str, i).commit();
    }

    public static int getInt(java.lang.String str, int i) {
        return getShare().getInt(str, i);
    }

    public static void putLong(java.lang.String str, long j) {
        getShare().edit().putLong(str, j).apply();
    }

    public static void putLongSync(java.lang.String str, long j) {
        getShare().edit().putLong(str, j).commit();
    }

    public static long getLong(java.lang.String str, long j) {
        return getShare().getLong(str, j);
    }

    public static void putBoolean(java.lang.String str, java.lang.Boolean bool) {
        getShare().edit().putBoolean(str, bool.booleanValue()).apply();
    }

    public static void putBooleanSync(java.lang.String str, java.lang.Boolean bool) {
        getShare().edit().putBoolean(str, bool.booleanValue()).commit();
    }

    public static boolean getBoolean(java.lang.String str, java.lang.Boolean bool) {
        return getShare().getBoolean(str, bool.booleanValue());
    }

    private static synchronized android.content.SharedPreferences getShare() {
        return com.tencent.mmkv.MMKV.mmkvWithID(GLOBLE_SETTING);
    }

    private static synchronized android.content.SharedPreferences getShareText() {
        return com.tencent.mmkv.MMKV.mmkvWithID(GLOBLE_TEXT);
    }
}
