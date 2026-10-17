package com.cmic.gen.sdk;

/* JADX INFO: compiled from: SharedPreferencesUtil.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class h1 {
    private static android.content.Context a;

    /* JADX INFO: compiled from: SharedPreferencesUtil.java */
    public static class a {
        private final android.content.SharedPreferences.Editor a;

        a(android.content.SharedPreferences.Editor editor) {
            this.a = editor;
        }

        public void a(java.lang.String str, java.lang.String str2) {
            this.a.putString(com.cmic.gen.sdk.j0.a(str), str2);
        }

        public void b() {
            this.a.clear();
        }

        public void c() {
            this.a.commit();
        }

        public void a(java.lang.String str, long j) {
            this.a.putLong(com.cmic.gen.sdk.j0.a(str), j);
        }

        public void a(java.lang.String str, int i) {
            this.a.putInt(com.cmic.gen.sdk.j0.a(str), i);
        }

        public void a() {
            this.a.apply();
        }

        public void a(java.lang.String str) {
            this.a.remove(com.cmic.gen.sdk.j0.a(str));
        }
    }

    public static void a(android.content.Context context) {
        a = context.getApplicationContext();
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences sharedPreferences = a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(com.cmic.gen.sdk.j0.a(str), str2).commit();
    }

    public static int a(java.lang.String str, int i) {
        return a.getSharedPreferences("ssoconfigs", 0).getInt(com.cmic.gen.sdk.j0.a(str), i);
    }

    public static void b(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().remove(com.cmic.gen.sdk.j0.a(str)).commit();
    }

    public static int a(java.lang.String str, java.lang.String str2, int i) {
        return a.getSharedPreferences(str, 0).getInt(com.cmic.gen.sdk.j0.a(str2), i);
    }

    public static long a(java.lang.String str, long j) {
        return a.getSharedPreferences("ssoconfigs", 0).getLong(com.cmic.gen.sdk.j0.a(str), j);
    }

    public static long a(java.lang.String str, java.lang.String str2, long j) {
        return a.getSharedPreferences(str, 0).getLong(com.cmic.gen.sdk.j0.a(str2), j);
    }

    public static void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = a.getSharedPreferences("ssoconfigs", 0).edit();
        for (java.lang.String str : map.keySet()) {
            java.lang.Object obj = map.get(str);
            java.lang.String strA = com.cmic.gen.sdk.j0.a(str);
            if (obj instanceof java.lang.String) {
                editorEdit.putString(strA, (java.lang.String) obj);
            } else if (obj instanceof java.lang.Integer) {
                editorEdit.putInt(strA, ((java.lang.Integer) obj).intValue());
            } else if (obj instanceof java.lang.Long) {
                editorEdit.putLong(strA, ((java.lang.Long) obj).longValue());
            } else if (obj instanceof java.lang.Boolean) {
                editorEdit.putBoolean(strA, ((java.lang.Boolean) obj).booleanValue());
            }
        }
        editorEdit.commit();
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        return a.getSharedPreferences("ssoconfigs", 0).getString(com.cmic.gen.sdk.j0.a(str), str2);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return a.getSharedPreferences(str, 0).getString(com.cmic.gen.sdk.j0.a(str2), str3);
    }

    public static com.cmic.gen.sdk.h1.a a() {
        return new com.cmic.gen.sdk.h1.a(a.getSharedPreferences("ssoconfigs", 0).edit());
    }

    public static com.cmic.gen.sdk.h1.a a(java.lang.String str) {
        return new com.cmic.gen.sdk.h1.a(a.getSharedPreferences(str, 0).edit());
    }
}
