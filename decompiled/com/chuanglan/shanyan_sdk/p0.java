package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class p0 {
    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context != null) {
            try {
                java.lang.String string = com.chuanglan.shanyan_sdk.u0.a(context).b().getString(str, str2);
                if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(string)) {
                    return string;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getString _key=", str, "defaultValue", str2, "Exception", e);
            }
        }
        return str2;
    }

    public static void b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context != null) {
            try {
                com.chuanglan.shanyan_sdk.p0.a.a(com.chuanglan.shanyan_sdk.u0.a(context).a().putString(str, str2));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "putString _key=", str, "value", str2, "Exception", e);
            }
        }
    }

    private static class a {
        private static final java.lang.reflect.Method a = a();

        private static java.lang.reflect.Method a() {
            try {
                return android.content.SharedPreferences.Editor.class.getMethod("apply", null);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        static void a(android.content.SharedPreferences.Editor editor) {
            try {
                java.lang.reflect.Method method = a;
                if (method != null) {
                    method.invoke(editor, null);
                    return;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            editor.commit();
        }
    }

    public static void b(android.content.Context context, java.lang.String str, int i) {
        if (context != null) {
            try {
                com.chuanglan.shanyan_sdk.p0.a.a(com.chuanglan.shanyan_sdk.u0.a(context).a().putInt(str, i));
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "putInt _key=", str, "value", java.lang.Integer.valueOf(i), "Exception", e);
            }
        }
    }

    public static int a(android.content.Context context, java.lang.String str, int i) {
        if (context != null) {
            try {
                return com.chuanglan.shanyan_sdk.u0.a(context).b().getInt(str, i);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getInt _key=", str, "defaultValue", java.lang.Integer.valueOf(i), "Exception", e);
            }
        }
        return i;
    }

    public static void b(android.content.Context context, java.lang.String str, boolean z) {
        if (context != null) {
            try {
                com.chuanglan.shanyan_sdk.p0.a.a(com.chuanglan.shanyan_sdk.u0.a(context).a().putBoolean(str, z));
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "putBoolean _key=", str, "value", java.lang.Boolean.valueOf(z), "Exception", e);
            }
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str, boolean z) {
        if (context != null) {
            try {
                return com.chuanglan.shanyan_sdk.u0.a(context).b().getBoolean(str, z);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getBoolean _key=", str, "defaultValue", java.lang.Boolean.valueOf(z), "Exception", e);
            }
        }
        return z;
    }

    public static void b(android.content.Context context, java.lang.String str, long j) {
        if (context != null) {
            try {
                com.chuanglan.shanyan_sdk.p0.a.a(com.chuanglan.shanyan_sdk.u0.a(context).a().putLong(str, j));
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "putLong _key=", str, "value", java.lang.Long.valueOf(j), "Exception", e);
            }
        }
    }

    public static long a(android.content.Context context, java.lang.String str, long j) {
        if (context != null) {
            try {
                return com.chuanglan.shanyan_sdk.u0.a(context).b().getLong(str, j);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getLong _key=", str, "defaultValue", java.lang.Long.valueOf(j), "Exception", e);
            }
        }
        return j;
    }
}
