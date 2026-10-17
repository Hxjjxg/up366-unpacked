package com.up366.medialibrary.common.language;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureLanguageUtils {
    private static final java.lang.String KEY_LOCALE = "KEY_LOCALE";
    private static final java.lang.String VALUE_FOLLOW_SYSTEM = "VALUE_FOLLOW_SYSTEM";

    private PictureLanguageUtils() {
        throw new java.lang.UnsupportedOperationException("u can't instantiate me...");
    }

    public static void setAppLanguage(android.content.Context context, int i) {
        java.lang.ref.WeakReference weakReference = new java.lang.ref.WeakReference(context);
        if (i >= 0) {
            applyLanguage((android.content.Context) weakReference.get(), com.up366.medialibrary.common.language.LocaleTransform.getLanguage(i));
        } else {
            setDefaultLanguage((android.content.Context) weakReference.get());
        }
    }

    private static void applyLanguage(android.content.Context context, java.util.Locale locale) {
        applyLanguage(context, locale, false);
    }

    private static void applyLanguage(android.content.Context context, java.util.Locale locale, boolean z) {
        if (z) {
            com.up366.medialibrary.common.utils.SPUtils.getPictureSpUtils().put(KEY_LOCALE, VALUE_FOLLOW_SYSTEM);
        } else {
            java.lang.String language = locale.getLanguage();
            java.lang.String country = locale.getCountry();
            com.up366.medialibrary.common.utils.SPUtils.getPictureSpUtils().put(KEY_LOCALE, language + "$" + country);
        }
        updateLanguage(context, locale);
    }

    private static void updateLanguage(android.content.Context context, java.util.Locale locale) {
        android.content.res.Resources resources = context.getResources();
        android.content.res.Configuration configuration = resources.getConfiguration();
        java.util.Locale locale2 = configuration.locale;
        if (equals(locale2.getLanguage(), locale.getLanguage()) && equals(locale2.getCountry(), locale.getCountry())) {
            return;
        }
        android.util.DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(locale);
        context.createConfigurationContext(configuration);
        resources.updateConfiguration(configuration, displayMetrics);
    }

    private static void setDefaultLanguage(android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        android.content.res.Configuration configuration = resources.getConfiguration();
        android.util.DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(java.util.Locale.getDefault());
        context.createConfigurationContext(configuration);
        resources.updateConfiguration(configuration, displayMetrics);
    }

    private static boolean equals(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof java.lang.String) && (charSequence2 instanceof java.lang.String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
