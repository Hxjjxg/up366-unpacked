package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class x0 implements com.zx.a.I8b7.s0 {
    public com.zx.a.I8b7.r0 a;
    public java.lang.String b = "";
    public int c = 8;

    public x0(com.zx.a.I8b7.r0 r0Var) {
        this.a = (com.zx.a.I8b7.r0) com.zx.a.I8b7.p2.a(r0Var);
    }

    @Override // com.zx.a.I8b7.s0
    public void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        java.lang.String str3;
        java.lang.String str4 = "";
        try {
            java.lang.StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[this.c];
            java.lang.String className = stackTraceElement.getClassName();
            str3 = java.lang.String.format("%s.%s", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName());
        } catch (java.lang.Throwable unused) {
            str3 = "";
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = this.b;
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            str3 = str + "-" + str3;
        }
        if (th != null && str2 != null) {
            str2 = str2 + " : " + a(th);
        }
        if (th != null && str2 == null) {
            str2 = a(th);
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "Empty/NULL log message";
        }
        java.lang.String strTrim = str2.trim();
        if (strTrim.startsWith("{") && strTrim.endsWith("}")) {
            try {
                strTrim = new org.json.JSONObject(strTrim).toString(2);
            } catch (java.lang.Throwable unused2) {
            }
        }
        if (strTrim.startsWith("[") && strTrim.endsWith("]")) {
            try {
                strTrim = new org.json.JSONArray(strTrim).toString(2);
            } catch (java.lang.Throwable unused3) {
            }
        }
        try {
            java.lang.StackTraceElement stackTraceElement2 = java.lang.Thread.currentThread().getStackTrace()[this.c];
            java.lang.String className2 = stackTraceElement2.getClassName();
            str4 = java.lang.String.format("(%s:%d)", className2.substring(className2.lastIndexOf(".") + 1) + ".java", java.lang.Integer.valueOf(stackTraceElement2.getLineNumber()));
        } catch (java.lang.Throwable unused4) {
        }
        if (th == null) {
            strTrim = strTrim + " " + str4;
        }
        this.a.a(i, str3, strTrim);
    }

    public static java.lang.String a(java.lang.Throwable th) {
        for (java.lang.Throwable cause = th; cause != null; cause = cause.getCause()) {
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.PrintWriter printWriter = new java.io.PrintWriter((java.io.OutputStream) byteArrayOutputStream, false);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return byteArrayOutputStream.toString();
    }
}
