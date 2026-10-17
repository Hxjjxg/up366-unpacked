package com.igexin.base.api;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GTBase {
    public static android.content.Context context;

    public static boolean init(android.content.Context context2) {
        if (context2 == null) {
            return false;
        }
        context = context2;
        com.igexin.base.api.SharedPreferencesManager.init(context2);
        return true;
    }
}
