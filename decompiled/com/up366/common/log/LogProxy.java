package com.up366.common.log;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class LogProxy {
    private java.util.List<com.up366.common.log.ILogWriter> logWriters;
    private final com.up366.common.log.ConsoleLogWriter mConsoleLogWriter;
    private final com.up366.common.log.FileLogWriter mFileLogWriter;

    LogProxy(com.up366.common.log.FileLogWriter fileLogWriter, com.up366.common.log.ConsoleLogWriter consoleLogWriter) {
        this.mFileLogWriter = fileLogWriter;
        this.mConsoleLogWriter = consoleLogWriter;
    }

    void verbose(java.lang.String str, java.lang.Object... objArr) {
        internalLogMessage(java.lang.System.currentTimeMillis(), com.up366.common.log.LogLevel.VERBOSE, str, objArr);
    }

    void debug(java.lang.String str, java.lang.Object... objArr) {
        internalLogMessage(java.lang.System.currentTimeMillis(), com.up366.common.log.LogLevel.DEBUG, str, objArr);
    }

    void info(java.lang.String str, java.lang.Object... objArr) {
        internalLogMessage(java.lang.System.currentTimeMillis(), com.up366.common.log.LogLevel.INFO, str, objArr);
    }

    void warn(java.lang.String str, java.lang.Object... objArr) {
        internalLogMessage(java.lang.System.currentTimeMillis(), com.up366.common.log.LogLevel.WARN, str, objArr);
    }

    void error(java.lang.String str, java.lang.Object... objArr) {
        internalLogMessage(java.lang.System.currentTimeMillis(), com.up366.common.log.LogLevel.ERROR, str, objArr);
    }

    private void internalLogMessage(long j, com.up366.common.log.LogLevel logLevel, java.lang.String str, java.lang.Object... objArr) {
        logMessage(java.lang.Thread.currentThread().getId(), j, logLevel, getCallerLineNumber(), getCallerFilename(), str, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void logMessage(long r13, long r15, com.up366.common.log.LogLevel r17, int r18, java.lang.String r19, java.lang.String r20, java.lang.Object... r21) {
        /*
            r12 = this;
            r1 = r12
            r0 = r21
            if (r0 == 0) goto Lf
            int r2 = r0.length     // Catch: java.lang.Exception -> Ld
            if (r2 <= 0) goto Lf
            java.lang.String r0 = java.lang.String.format(r20, r21)     // Catch: java.lang.Exception -> Ld
            goto L11
        Ld:
            r0 = move-exception
            goto L54
        Lf:
            r0 = r20
        L11:
            int r2 = r0.length()     // Catch: java.lang.Exception -> Ld
            if (r2 <= 0) goto L5d
            com.up366.common.log.ConsoleLogWriter r2 = r1.mConsoleLogWriter     // Catch: java.lang.Exception -> Ld
            r3 = r13
            r5 = r15
            r7 = r18
            r8 = r19
            r9 = r17
            r10 = r0
            r2.logMessage(r3, r5, r7, r8, r9, r10)     // Catch: java.lang.Exception -> Ld
            com.up366.common.log.FileLogWriter r2 = r1.mFileLogWriter     // Catch: java.lang.Exception -> Ld
            r3 = r13
            r5 = r15
            r7 = r18
            r8 = r19
            r9 = r17
            r10 = r0
            r2.logMessage(r3, r5, r7, r8, r9, r10)     // Catch: java.lang.Exception -> Ld
            java.util.List<com.up366.common.log.ILogWriter> r2 = r1.logWriters     // Catch: java.lang.Exception -> Ld
            if (r2 == 0) goto L5d
            java.util.Iterator r11 = r2.iterator()     // Catch: java.lang.Exception -> Ld
        L3b:
            boolean r2 = r11.hasNext()     // Catch: java.lang.Exception -> Ld
            if (r2 == 0) goto L5d
            java.lang.Object r2 = r11.next()     // Catch: java.lang.Exception -> Ld
            com.up366.common.log.ILogWriter r2 = (com.up366.common.log.ILogWriter) r2     // Catch: java.lang.Exception -> Ld
            r3 = r13
            r5 = r15
            r7 = r18
            r8 = r19
            r9 = r17
            r10 = r0
            r2.logMessage(r3, r5, r7, r8, r9, r10)     // Catch: java.lang.Exception -> Ld
            goto L3b
        L54:
            java.lang.String r2 = "LogUtils"
            java.lang.String r3 = r0.getMessage()
            android.util.Log.e(r2, r3, r0)
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.common.log.LogProxy.logMessage(long, long, com.up366.common.log.LogLevel, int, java.lang.String, java.lang.String, java.lang.Object[]):void");
    }

    private int getCallerLineNumber() {
        return java.lang.Thread.currentThread().getStackTrace()[6].getLineNumber();
    }

    private java.lang.String getCallerFilename() {
        return java.lang.Thread.currentThread().getStackTrace()[6].getFileName();
    }

    public void setLogWriters(java.util.List<com.up366.common.log.ILogWriter> list) {
        this.logWriters = list;
    }
}
