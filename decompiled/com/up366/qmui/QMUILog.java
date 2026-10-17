package com.up366.qmui;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUILog {
    private static com.up366.qmui.QMUILog.QMUILogDelegate sDelegete;

    public interface QMUILogDelegate {
        void d(java.lang.String str, java.lang.String str2, java.lang.Object... objArr);

        void e(java.lang.String str, java.lang.String str2, java.lang.Object... objArr);

        void i(java.lang.String str, java.lang.String str2, java.lang.Object... objArr);

        void printErrStackTrace(java.lang.String str, java.lang.Throwable th, java.lang.String str2, java.lang.Object... objArr);

        void w(java.lang.String str, java.lang.String str2, java.lang.Object... objArr);
    }

    public static void setDelegete(com.up366.qmui.QMUILog.QMUILogDelegate qMUILogDelegate) {
        sDelegete = qMUILogDelegate;
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        com.up366.qmui.QMUILog.QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate != null) {
            qMUILogDelegate.e(str, str2, objArr);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        com.up366.qmui.QMUILog.QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate != null) {
            qMUILogDelegate.w(str, str2, objArr);
        }
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        com.up366.qmui.QMUILog.QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate != null) {
            qMUILogDelegate.i(str, str2, objArr);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        com.up366.qmui.QMUILog.QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate != null) {
            qMUILogDelegate.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(java.lang.String str, java.lang.Throwable th, java.lang.String str2, java.lang.Object... objArr) {
        com.up366.qmui.QMUILog.QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate != null) {
            qMUILogDelegate.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
