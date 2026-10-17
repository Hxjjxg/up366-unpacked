package com.up366.mobile.common.crash.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CrashInfoHelper {
    private static volatile com.up366.mobile.common.crash.helper.CrashInfoHelper instance;
    private java.lang.String androidVersion;
    private java.lang.String exceptionMessage;
    private java.lang.String exceptionStackTrace;
    private java.lang.String exceptionType;
    private java.lang.String manufacturer;
    private java.lang.String model;
    private int sdkInt;
    private long threadId;
    private java.lang.String threadName;

    public static com.up366.mobile.common.crash.helper.CrashInfoHelper getInstance(java.lang.Thread thread, java.lang.Throwable th) {
        if (instance == null) {
            synchronized (com.up366.mobile.common.crash.helper.CrashInfoHelper.class) {
                if (instance == null) {
                    instance = new com.up366.mobile.common.crash.helper.CrashInfoHelper(thread, th);
                }
            }
        }
        return instance;
    }

    private CrashInfoHelper(java.lang.Thread thread, java.lang.Throwable th) {
        if (th != null) {
            this.exceptionType = th.getClass().getName();
            this.exceptionMessage = th.getMessage();
            this.exceptionStackTrace = getStackTraceString(th);
        }
        if (thread != null) {
            this.threadName = thread.getName();
            this.threadId = thread.getId();
        }
        this.manufacturer = android.os.Build.MANUFACTURER;
        this.model = android.os.Build.MODEL;
        this.androidVersion = android.os.Build.VERSION.RELEASE;
        this.sdkInt = android.os.Build.VERSION.SDK_INT;
    }

    public java.lang.String getSummary() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.exceptionType)) {
            sb.append("\n=== 异常信息 ===\nexceptionType : ");
            sb.append(this.exceptionType);
            sb.append("\nexceptionMessage : ");
            sb.append(this.exceptionMessage);
            sb.append("\nexceptionStackTrace : ");
            sb.append(this.exceptionStackTrace);
            sb.append("\n");
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.threadName)) {
            sb.append("\n=== 线程信息 ===\nthreadName : ");
            sb.append(this.threadName);
            sb.append("\nthreadId : ");
            sb.append(this.threadId);
            sb.append("\n");
        }
        sb.append("\n=== 设备信息 ===\nmanufacturer : ");
        sb.append(this.manufacturer);
        sb.append("\nmodel : ");
        sb.append(this.model);
        sb.append("\nandroidVersion : ");
        sb.append(this.androidVersion);
        sb.append("\nsdkInt : ");
        sb.append(this.sdkInt);
        sb.append("\n");
        return sb.toString();
    }

    private java.lang.String getStackTraceString(java.lang.Throwable th) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }
}
