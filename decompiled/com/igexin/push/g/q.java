package com.igexin.push.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class q {
    public static final java.lang.String a = "us";
    public static final java.lang.String b = "ups";
    public static final java.lang.String c = "uis";
    public static final java.lang.String d = "ua";
    public static final java.lang.String e = "sc";
    public static final java.lang.String f = "it";
    public static final java.lang.String g = "logkey2";
    public static final java.lang.String h = "hwBadgeNum";
    public static final java.lang.String i = "vivoBadgeNum";
    public static final java.lang.String j = "oppoBadgeNum";
    public static java.lang.String k = "idvph";
    public static final java.lang.String l = "lkm";
    public static final java.lang.String m = "emgph";
    public static final java.lang.String n = "secnph";
    private static final java.lang.String o = "SpUtils";
    private static final java.lang.String p = "getui_sp";

    public static void a(android.content.Context context, android.content.Intent intent) {
        java.lang.String str;
        java.lang.Throwable th;
        try {
            java.lang.String str2 = (java.lang.String) b(context, a, "");
            if (!android.text.TextUtils.isEmpty(str2)) {
                try {
                    if (com.igexin.sdk.PushService.class.isAssignableFrom(java.lang.Class.forName(str2))) {
                        try {
                            a(context, a, "");
                            str2 = "";
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            str = "";
                            com.igexin.c.a.c.a.a(o, th.toString());
                            com.igexin.c.a.c.a.a("SpUtils|" + th.toString(), new java.lang.Object[0]);
                            str2 = str;
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    str = str2;
                    th = th3;
                }
            }
            if (intent.hasExtra(a)) {
                java.lang.String strB = com.igexin.c.b.a.b(intent.getStringExtra(a), "");
                if (!str2.equals(strB)) {
                    if (!com.igexin.push.core.b.ao.equals(strB)) {
                        a(context, a, strB);
                    } else if (!android.text.TextUtils.isEmpty(str2)) {
                        a(context, a, "");
                    }
                }
            }
            if (intent.hasExtra(b)) {
                java.lang.String strB2 = com.igexin.c.b.a.b(intent.getStringExtra(b), "");
                java.lang.String str3 = (java.lang.String) b(context, b, "");
                if (!str3.equals(strB2)) {
                    if (!com.igexin.push.core.b.ao.equals(strB2)) {
                        a(context, b, strB2);
                    } else if (!android.text.TextUtils.isEmpty(str3)) {
                        a(context, b, "");
                    }
                }
            }
            if (intent.hasExtra(c)) {
                java.lang.String str4 = (java.lang.String) b(context, c, "");
                java.lang.String strB3 = com.igexin.c.b.a.b(intent.getStringExtra(c), "");
                if (!str4.equals(strB3)) {
                    a(context, c, strB3);
                }
            }
            if (intent.hasExtra(d)) {
                com.igexin.push.core.ServiceManager.getInstance();
                java.lang.String strD = com.igexin.push.core.ServiceManager.d(context);
                java.lang.String strB4 = com.igexin.c.b.a.b(intent.getStringExtra(d), "");
                if (strD.equals(strB4)) {
                    return;
                }
                a(context, d, strB4);
            }
        } catch (java.lang.Throwable th4) {
            com.igexin.c.a.c.a.a(th4);
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(p, 0).edit();
        if (obj instanceof java.lang.String) {
            editorEdit.putString(str, (java.lang.String) obj);
        } else if (obj instanceof java.lang.Integer) {
            editorEdit.putInt(str, ((java.lang.Integer) obj).intValue());
        } else if (obj instanceof java.lang.Boolean) {
            editorEdit.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
        } else if (obj instanceof java.lang.Float) {
            editorEdit.putFloat(str, ((java.lang.Float) obj).floatValue());
        } else if (obj instanceof java.lang.Long) {
            editorEdit.putLong(str, ((java.lang.Long) obj).longValue());
        }
        editorEdit.apply();
    }

    public static boolean a(android.content.Context context) {
        try {
            java.lang.String str = (java.lang.String) b(context, a, "");
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            java.lang.Class.forName(str);
            return true;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(o, e2.toString());
            com.igexin.c.a.c.a.a("SpUtils|" + e2.toString(), new java.lang.Object[0]);
            return false;
        }
    }

    public static java.lang.Object b(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(p, 0);
        return obj instanceof java.lang.String ? sharedPreferences.getString(str, (java.lang.String) obj) : obj instanceof java.lang.Integer ? java.lang.Integer.valueOf(sharedPreferences.getInt(str, ((java.lang.Integer) obj).intValue())) : obj instanceof java.lang.Boolean ? java.lang.Boolean.valueOf(sharedPreferences.getBoolean(str, ((java.lang.Boolean) obj).booleanValue())) : obj instanceof java.lang.Float ? java.lang.Float.valueOf(sharedPreferences.getFloat(str, ((java.lang.Float) obj).floatValue())) : obj instanceof java.lang.Long ? java.lang.Long.valueOf(sharedPreferences.getLong(str, ((java.lang.Long) obj).longValue())) : obj;
    }
}
