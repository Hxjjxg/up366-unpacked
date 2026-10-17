package com.cmic.gen.sdk;

/* JADX INFO: compiled from: PermissionUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class t0 {
    public static boolean a(android.content.Context context, java.lang.String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
