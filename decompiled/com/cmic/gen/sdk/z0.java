package com.cmic.gen.sdk;

/* JADX INFO: compiled from: ResourceUtil.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class z0 {
    public static int a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static int b(android.content.Context context, java.lang.String str) {
        int iA = a(context, str, "drawable");
        if (iA != 0) {
            return iA;
        }
        throw new android.content.res.Resources.NotFoundException(str);
    }

    public static int c(android.content.Context context, java.lang.String str) {
        int iA = a(context, str, com.igexin.push.core.b.C);
        if (iA != 0) {
            return iA;
        }
        throw new android.content.res.Resources.NotFoundException(str);
    }

    public static int a(android.content.Context context, java.lang.String str) {
        int iA = a(context, str, "anim");
        if (iA != 0) {
            return iA;
        }
        throw new android.content.res.Resources.NotFoundException(str);
    }
}
