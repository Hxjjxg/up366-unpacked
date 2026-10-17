package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class Q {
    private static com.chuanglan.shanyan_sdk.listener.OneKeyLoginLogListener a;

    public static void a(com.chuanglan.shanyan_sdk.listener.OneKeyLoginLogListener oneKeyLoginLogListener) {
        a = oneKeyLoginLogListener;
    }

    public static void b(java.lang.String str, java.lang.Object... objArr) {
        java.lang.String strA = a(objArr);
        if (com.chuanglan.shanyan_sdk.P.a) {
            android.util.Log.e(str, strA);
        }
        com.chuanglan.shanyan_sdk.listener.OneKeyLoginLogListener oneKeyLoginLogListener = a;
        if (oneKeyLoginLogListener != null) {
            oneKeyLoginLogListener.onLog("e", str, strA);
        }
    }

    public static void c(java.lang.String str, java.lang.Object... objArr) {
        java.lang.String strA = a(objArr);
        if (com.chuanglan.shanyan_sdk.P.b) {
            android.util.Log.v(str, strA);
            com.chuanglan.shanyan_sdk.listener.OneKeyLoginLogListener oneKeyLoginLogListener = a;
            if (oneKeyLoginLogListener != null) {
                oneKeyLoginLogListener.onLog("v", str, strA);
            }
        }
    }

    public static void d(java.lang.String str, java.lang.Object... objArr) {
        java.lang.String strA = a(objArr);
        if (com.chuanglan.shanyan_sdk.P.a) {
            android.util.Log.w(str, strA);
        }
        com.chuanglan.shanyan_sdk.listener.OneKeyLoginLogListener oneKeyLoginLogListener = a;
        if (oneKeyLoginLogListener != null) {
            oneKeyLoginLogListener.onLog("w", str, strA);
        }
    }

    public static void a(java.lang.String str, java.lang.Object... objArr) {
        java.lang.String strA = a(objArr);
        if (com.chuanglan.shanyan_sdk.P.a) {
            android.util.Log.d(str, strA);
        }
        com.chuanglan.shanyan_sdk.listener.OneKeyLoginLogListener oneKeyLoginLogListener = a;
        if (oneKeyLoginLogListener != null) {
            oneKeyLoginLogListener.onLog("d", str, strA);
        }
    }

    private static java.lang.String a(java.lang.Object... objArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (objArr != null) {
            try {
                for (java.lang.Object obj : objArr) {
                    sb.append(obj);
                    sb.append("**");
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
