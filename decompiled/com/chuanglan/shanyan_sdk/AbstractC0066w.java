package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class AbstractC0066w {
    private static android.content.Context b;
    private static final java.lang.String a = java.io.File.separator;
    private static java.io.File c = null;

    public static void a(android.content.Context context) {
        b = context;
    }

    public static java.io.File b() {
        if (c == null) {
            c = a(b, a() + a + "database");
        }
        return c;
    }

    private static java.lang.String a() {
        return "cl_jm_file";
    }

    private static java.io.File a(android.content.Context context, java.lang.String str) {
        java.io.File file;
        if (!android.os.Environment.getExternalStorageState().equals("mounted")) {
            file = new java.io.File(context.getCacheDir(), str);
        } else {
            file = new java.io.File(android.os.Environment.getExternalStorageDirectory(), str);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static java.io.File a(java.io.File file, java.lang.String str) {
        java.io.File file2 = new java.io.File(file, str);
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return file2;
        }
    }
}
