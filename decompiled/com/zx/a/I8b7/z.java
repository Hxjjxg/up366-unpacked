package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class z {
    public static float a;

    public static int a(android.content.Context context, float f) {
        if (a == 0.0f) {
            a = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((f * a) + 0.5f);
    }
}
