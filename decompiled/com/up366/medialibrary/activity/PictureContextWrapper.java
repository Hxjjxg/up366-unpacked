package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureContextWrapper extends android.content.ContextWrapper {
    public PictureContextWrapper(android.content.Context context) {
        super(context);
    }

    public static android.content.ContextWrapper wrap(android.content.Context context, int i) {
        com.up366.medialibrary.common.language.PictureLanguageUtils.setAppLanguage(context, i);
        return new com.up366.medialibrary.activity.PictureContextWrapper(context);
    }
}
