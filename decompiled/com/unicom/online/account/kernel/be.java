package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class be {
    public static void b(android.content.Context context, java.lang.String str, java.lang.Long l) {
        try {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("cuAuthCacheName", 0).edit();
            editorEdit.putLong(str, l.longValue());
            editorEdit.commit();
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public static java.lang.Long c(android.content.Context context, java.lang.String str) {
        long j = 0;
        try {
            j = context.getSharedPreferences("cuAuthCacheName", 0).getLong(str, 0L);
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
        return java.lang.Long.valueOf(j);
    }

    public static void b(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("cuAuthCacheName", 0);
        android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (java.lang.String str2 : sharedPreferences.getAll().keySet()) {
            if (str2.startsWith(str)) {
                editorEdit.remove(str2);
            }
        }
        editorEdit.commit();
    }
}
