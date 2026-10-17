package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class u0 {
    private static volatile com.chuanglan.shanyan_sdk.u0 a;
    private static android.content.SharedPreferences b;
    private static android.content.SharedPreferences.Editor c;
    private static android.content.Context d;

    private u0() {
    }

    public static com.chuanglan.shanyan_sdk.u0 a(android.content.Context context) {
        if (a == null) {
            synchronized (com.chuanglan.shanyan_sdk.u0.class) {
                if (a == null) {
                    d = context;
                    a = new com.chuanglan.shanyan_sdk.u0();
                    android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("cl_jm_file", 0);
                    b = sharedPreferences;
                    c = sharedPreferences.edit();
                }
            }
        }
        return a;
    }

    android.content.SharedPreferences b() {
        android.content.SharedPreferences sharedPreferences = b;
        return sharedPreferences == null ? d.getSharedPreferences("cl_jm_file", 0) : sharedPreferences;
    }

    android.content.SharedPreferences.Editor a() {
        android.content.SharedPreferences.Editor editor = c;
        return editor == null ? b.edit() : editor;
    }
}
