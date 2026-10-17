package com.up366.common.log;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class Logger {
    private static final java.lang.String DALVIK_VM_STACK_CLASS_NAME = "dalvik.system.VMStack";
    private static final java.lang.String LOGGER_CLASS_NAME = "com.up366.common.log.Logger";
    private static volatile boolean initialized;
    private static final java.lang.String THREAD_CLASS_NAME = java.lang.Thread.class.getName();
    private static volatile java.lang.String logTag = "";

    private Logger() {
    }

    public static void init(com.up366.common.log.LogLevel logLevel, java.lang.String str, java.lang.String str2) {
        boolean z = false;
        com.up366.common.log.KmpLog.INSTANCE.setup(toKmpLogLevel(logLevel), str2 == null ? "" : str2, false);
        if (str2 != null && !str2.isEmpty()) {
            z = true;
        }
        initialized = z;
    }

    public static void verbose(java.lang.String str) {
        log(com.up366.common.log.KmpLogLevel.DEBUG, str, null);
    }

    public static void debug(java.lang.String str) {
        log(com.up366.common.log.KmpLogLevel.DEBUG, str, null);
    }

    public static void debug(java.lang.String str, java.lang.Throwable th) {
        if (th != null) {
            log(com.up366.common.log.KmpLogLevel.DEBUG, str, th);
        }
    }

    public static void info(java.lang.String str) {
        log(com.up366.common.log.KmpLogLevel.INFO, str, null);
    }

    public static void info(java.lang.String str, java.lang.Throwable th) {
        if (th != null) {
            log(com.up366.common.log.KmpLogLevel.INFO, str, th);
        }
    }

    public static void warn(java.lang.String str) {
        log(com.up366.common.log.KmpLogLevel.WARN, str, null);
    }

    public static void warn(java.lang.String str, java.lang.Throwable th) {
        if (th != null) {
            log(com.up366.common.log.KmpLogLevel.WARN, str, th);
        }
    }

    public static void warn(java.lang.Throwable th) {
        if (th != null) {
            log(com.up366.common.log.KmpLogLevel.WARN, messageOf(th), th);
        }
    }

    public static void error(java.lang.String str) {
        log(com.up366.common.log.KmpLogLevel.ERROR, str, null);
    }

    public static void error(java.lang.Throwable th) {
        if (th != null) {
            log(com.up366.common.log.KmpLogLevel.ERROR, messageOf(th), th);
        }
    }

    public static void error(java.lang.String str, java.lang.Throwable th) {
        if (th != null) {
            log(com.up366.common.log.KmpLogLevel.ERROR, str, th);
        }
    }

    public static void addLogWriter(com.up366.common.log.ILogWriter iLogWriter) {
        if (iLogWriter == null) {
            return;
        }
        com.up366.common.log.KmpLog.INSTANCE.addLogger(new com.up366.common.log.Logger.LegacyLogWriterAdapter(iLogWriter));
    }

    private static void log(com.up366.common.log.KmpLogLevel kmpLogLevel, java.lang.String str, java.lang.Throwable th) {
        if (!initialized || str == null) {
            return;
        }
        if (th == null && str.isEmpty()) {
            return;
        }
        if (th == null) {
            dispatch(kmpLogLevel, str, findCaller(java.lang.Thread.currentThread().getStackTrace()));
        } else {
            dispatch(kmpLogLevel, combineLogMessageWithException(str, th), findCaller(java.lang.Thread.currentThread().getStackTrace()));
        }
    }

    private static void dispatch(com.up366.common.log.KmpLogLevel kmpLogLevel, java.lang.String str, com.up366.common.log.Logger.Caller caller) {
        com.up366.common.log.KmpLog.INSTANCE.log(kmpLogLevel, str, logTag, caller.fileName, caller.functionName, caller.lineNumber);
    }

    private static com.up366.common.log.Logger.Caller findCaller(java.lang.StackTraceElement[] stackTraceElementArr) {
        for (java.lang.StackTraceElement stackTraceElement : stackTraceElementArr) {
            java.lang.String className = stackTraceElement.getClassName();
            if (!THREAD_CLASS_NAME.equals(className) && !LOGGER_CLASS_NAME.equals(className) && !DALVIK_VM_STACK_CLASS_NAME.equals(className)) {
                return new com.up366.common.log.Logger.Caller(stackTraceElement.getFileName() == null ? "" : stackTraceElement.getFileName(), stackTraceElement.getMethodName() != null ? stackTraceElement.getMethodName() : "", java.lang.Math.max(stackTraceElement.getLineNumber(), 0));
            }
        }
        return com.up366.common.log.Logger.Caller.UNKNOWN;
    }

    private static com.up366.common.log.KmpLogLevel toKmpLogLevel(com.up366.common.log.LogLevel logLevel) {
        if (logLevel == null) {
            return com.up366.common.log.KmpLogLevel.ERROR;
        }
        int i = com.up366.common.log.Logger.AnonymousClass1.$SwitchMap$com$up366$common$log$LogLevel[logLevel.ordinal()];
        if (i == 1 || i == 2) {
            return com.up366.common.log.KmpLogLevel.DEBUG;
        }
        if (i == 3) {
            return com.up366.common.log.KmpLogLevel.INFO;
        }
        if (i == 4) {
            return com.up366.common.log.KmpLogLevel.WARN;
        }
        return com.up366.common.log.KmpLogLevel.ERROR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.up366.common.log.LogLevel toLegacyLogLevel(com.up366.common.log.KmpLogLevel kmpLogLevel) {
        if (kmpLogLevel == null) {
            return com.up366.common.log.LogLevel.ERROR;
        }
        int i = com.up366.common.log.Logger.AnonymousClass1.$SwitchMap$com$up366$common$log$KmpLogLevel[kmpLogLevel.ordinal()];
        if (i == 1) {
            return com.up366.common.log.LogLevel.DEBUG;
        }
        if (i == 2) {
            return com.up366.common.log.LogLevel.INFO;
        }
        if (i == 3) {
            return com.up366.common.log.LogLevel.WARN;
        }
        return com.up366.common.log.LogLevel.ERROR;
    }

    /* JADX INFO: renamed from: com.up366.common.log.Logger$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$up366$common$log$KmpLogLevel;
        static final /* synthetic */ int[] $SwitchMap$com$up366$common$log$LogLevel;

        static {
            int[] iArr = new int[com.up366.common.log.KmpLogLevel.values().length];
            $SwitchMap$com$up366$common$log$KmpLogLevel = iArr;
            try {
                iArr[com.up366.common.log.KmpLogLevel.DEBUG.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$up366$common$log$KmpLogLevel[com.up366.common.log.KmpLogLevel.INFO.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$up366$common$log$KmpLogLevel[com.up366.common.log.KmpLogLevel.WARN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$up366$common$log$KmpLogLevel[com.up366.common.log.KmpLogLevel.ERROR.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$up366$common$log$KmpLogLevel[com.up366.common.log.KmpLogLevel.FATAL.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[com.up366.common.log.LogLevel.values().length];
            $SwitchMap$com$up366$common$log$LogLevel = iArr2;
            try {
                iArr2[com.up366.common.log.LogLevel.VERBOSE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$up366$common$log$LogLevel[com.up366.common.log.LogLevel.DEBUG.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$up366$common$log$LogLevel[com.up366.common.log.LogLevel.INFO.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$up366$common$log$LogLevel[com.up366.common.log.LogLevel.WARN.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$up366$common$log$LogLevel[com.up366.common.log.LogLevel.ERROR.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
        }
    }

    private static java.lang.String combineLogMessageWithException(java.lang.String str, java.lang.Throwable th) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        stringWriter.write(str);
        stringWriter.write("\n");
        th.printStackTrace(new java.io.PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private static java.lang.String messageOf(java.lang.Throwable th) {
        java.lang.String message = th.getMessage();
        return (message == null || message.trim().isEmpty()) ? th.getClass().getName() : message;
    }

    private static final class Caller {
        private static final com.up366.common.log.Logger.Caller UNKNOWN = new com.up366.common.log.Logger.Caller("", "", 0);
        private final java.lang.String fileName;
        private final java.lang.String functionName;
        private final int lineNumber;

        private Caller(java.lang.String str, java.lang.String str2, int i) {
            this.fileName = str;
            this.functionName = str2;
            this.lineNumber = i;
        }
    }

    private static final class LegacyLogWriterAdapter implements com.up366.common.log.KmpLogger {
        private final com.up366.common.log.ILogWriter delegate;
        private com.up366.common.log.KmpLogFormatter logFormatter;

        private LegacyLogWriterAdapter(com.up366.common.log.ILogWriter iLogWriter) {
            this.logFormatter = com.up366.common.log.KmpLogDefaultFormatter.INSTANCE;
            this.delegate = iLogWriter;
        }

        @Override // com.up366.common.log.KmpLogger
        public com.up366.common.log.KmpLogFormatter getLogFormatter() {
            return this.logFormatter;
        }

        @Override // com.up366.common.log.KmpLogger
        public void setLogFormatter(com.up366.common.log.KmpLogFormatter kmpLogFormatter) {
            this.logFormatter = kmpLogFormatter;
        }

        @Override // com.up366.common.log.KmpLogger
        public void log(com.up366.common.log.KmpLogRecord kmpLogRecord) {
            java.lang.Long timestampMillis = kmpLogRecord.getTimestampMillis();
            this.delegate.logMessage(java.lang.Thread.currentThread().getId(), timestampMillis == null ? java.lang.System.currentTimeMillis() : timestampMillis.longValue(), kmpLogRecord.getSourceLine(), kmpLogRecord.getSourceFile(), com.up366.common.log.Logger.toLegacyLogLevel(kmpLogRecord.getLevel()), kmpLogRecord.getMessage());
        }
    }
}
