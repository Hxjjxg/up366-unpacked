package com.up366.common.log;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FileLogWriter {
    private static final long LOG_FILE_ALIVE_DAYS = 864000000;
    private static final java.lang.String LOG_FILE_SUFFIX = ".log";
    private static final java.lang.ThreadLocal<java.text.SimpleDateFormat> dateFormat = new java.lang.ThreadLocal<java.text.SimpleDateFormat>() { // from class: com.up366.common.log.FileLogWriter.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public java.text.SimpleDateFormat initialValue() {
            return new java.text.SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS");
        }
    };
    private final com.up366.common.task.TaskExecutor executor = com.up366.common.task.TaskUtils.createSerialExecutor("FileLogger");
    private java.io.File logFile = null;
    private java.lang.String logFileName = null;
    private java.lang.String logRelativePath;

    public FileLogWriter(java.lang.String str) {
        this.logRelativePath = str;
        cleanOldFiles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getLogFileName() {
        android.text.format.Time time = new android.text.format.Time();
        time.setToNow();
        return time.format("%Y-%m-%d") + LOG_FILE_SUFFIX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createLogFile() throws java.io.IOException {
        java.lang.String logFileName = getLogFileName();
        this.logFileName = logFileName;
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(this.logRelativePath, logFileName);
        java.io.File file = new java.io.File(strJoin);
        this.logFile = file;
        if (file.exists()) {
            return;
        }
        if (!this.logFile.getParentFile().exists()) {
            com.up366.common.FileUtilsUp.mkdirParentDir(strJoin);
        }
        this.logFile.createNewFile();
    }

    private void cleanOldFiles() {
        this.executor.post(new com.up366.common.task.Task() { // from class: com.up366.common.log.FileLogWriter.2
            @Override // com.up366.common.task.Task
            public void run() throws java.lang.Exception {
                java.io.File file = new java.io.File(com.up366.common.log.FileLogWriter.this.logRelativePath);
                if (file.exists()) {
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    java.io.File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles == null) {
                        return;
                    }
                    for (java.io.File file2 : fileArrListFiles) {
                        if (jCurrentTimeMillis - file2.lastModified() > 864000000) {
                            file2.delete();
                        }
                    }
                }
            }
        });
    }

    public void logMessage(long j, long j2, int i, java.lang.String str, com.up366.common.log.LogLevel logLevel, java.lang.String str2) {
        java.lang.String str3 = format(j, j2, i, str, logLevel, str2, new java.lang.Object[0]);
        if (str3 == null || str3.length() <= 0) {
            return;
        }
        writToFile(str3);
    }

    /* JADX INFO: renamed from: com.up366.common.log.FileLogWriter$3, reason: invalid class name */
    class AnonymousClass3 implements com.up366.common.task.Task {
        final /* synthetic */ java.lang.String val$msg;

        AnonymousClass3(java.lang.String str) {
            this.val$msg = str;
        }

        @Override // com.up366.common.task.Task
        public void run() throws java.lang.Exception {
            java.io.FileOutputStream fileOutputStream;
            try {
                if (com.up366.common.log.FileLogWriter.this.logFile == null || !com.up366.common.log.FileLogWriter.this.getLogFileName().equalsIgnoreCase(com.up366.common.log.FileLogWriter.this.logFileName)) {
                    com.up366.common.log.FileLogWriter.this.createLogFile();
                }
                if (com.up366.common.log.FileLogWriter.this.logFile == null) {
                    android.util.Log.e("Up366", "ERROR - FileLogWriter createLogFile error！");
                    return;
                }
                try {
                    fileOutputStream = new java.io.FileOutputStream(com.up366.common.log.FileLogWriter.this.logFile, true);
                    try {
                        fileOutputStream.write((this.val$msg + "\n").getBytes(com.igexin.push.g.s.b));
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        com.up366.common.task.TaskUtils.postLazyTaskGlobal("base-watch-logger-file-size", 10000, new com.up366.common.task.Task() { // from class: com.up366.common.log.FileLogWriter$3$$ExternalSyntheticLambda1
                            @Override // com.up366.common.task.Task
                            public final void run() throws java.lang.Exception {
                                this.f$0.lambda$run$1();
                            }
                        });
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (java.lang.Exception e) {
                android.util.Log.e("Up366", "ERROR - FileLogWriter ", e);
                com.up366.common.log.FileLogWriter.this.logFile = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1() throws java.lang.Exception {
            com.up366.common.log.FileLogWriter.this.executor.post(new com.up366.common.task.Task() { // from class: com.up366.common.log.FileLogWriter$3$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$run$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() throws java.lang.Exception {
            if ((com.up366.common.global.GB.get().getApplicationContext().getApplicationInfo().flags & 2) == 0 && com.up366.common.log.FileLogWriter.this.logFile != null && com.up366.common.log.FileLogWriter.this.logFile.exists() && com.up366.common.log.FileLogWriter.this.logFile.length() > 10485760) {
                com.up366.common.global.GB.get().sendLog("日志文件超过10MB", "");
                com.up366.common.log.FileLogWriter.this.logFile.delete();
            }
        }
    }

    private void writToFile(java.lang.String str) {
        this.executor.post(new com.up366.common.log.FileLogWriter.AnonymousClass3(str));
    }

    public java.lang.String format(long j, long j2, int i, java.lang.String str, com.up366.common.log.LogLevel logLevel, java.lang.String str2, java.lang.Object... objArr) {
        try {
            java.lang.String string = logLevel.toString();
            if (objArr != null && objArr.length > 0) {
                str2 = java.lang.String.format(str2, objArr);
            }
            return java.lang.String.format(java.util.Locale.CHINA, "%s [0x%08x] [%-5s] - %s (%s:%d)", dateFormat.get().format(new java.util.Date(j2)), java.lang.Long.valueOf(j), string, str2, str, java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception unused) {
            return "log format error at com.up366.pad.common.log.FileLogFormatter (FileLogFormatter.java:53)";
        }
    }
}
