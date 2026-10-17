package com.up366.common.log;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ConsoleLogWriter {
    private final java.lang.String tag;

    public ConsoleLogWriter(java.lang.String str) {
        this.tag = str;
    }

    /* JADX INFO: renamed from: com.up366.common.log.ConsoleLogWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$up366$common$log$LogLevel;

        static {
            int[] iArr = new int[com.up366.common.log.LogLevel.values().length];
            $SwitchMap$com$up366$common$log$LogLevel = iArr;
            try {
                iArr[com.up366.common.log.LogLevel.VERBOSE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$up366$common$log$LogLevel[com.up366.common.log.LogLevel.DEBUG.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$up366$common$log$LogLevel[com.up366.common.log.LogLevel.INFO.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$up366$common$log$LogLevel[com.up366.common.log.LogLevel.WARN.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$up366$common$log$LogLevel[com.up366.common.log.LogLevel.ERROR.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public void logMessage(long j, long j2, int i, java.lang.String str, com.up366.common.log.LogLevel logLevel, java.lang.String str2) {
        java.lang.String str3 = format(j, j2, i, str, logLevel, str2, new java.lang.Object[0]);
        int i2 = com.up366.common.log.ConsoleLogWriter.AnonymousClass1.$SwitchMap$com$up366$common$log$LogLevel[logLevel.ordinal()];
        if (i2 == 1) {
            android.util.Log.v(this.tag, str3);
            return;
        }
        if (i2 == 2) {
            android.util.Log.d(this.tag, str3);
            return;
        }
        if (i2 == 3) {
            android.util.Log.i(this.tag, str3);
            return;
        }
        if (i2 == 4) {
            android.util.Log.w(this.tag, str3);
        } else if (i2 == 5) {
            android.util.Log.e(this.tag, str3);
        } else {
            android.util.Log.v(this.tag, str3);
        }
    }

    public java.lang.String format(long j, long j2, int i, java.lang.String str, com.up366.common.log.LogLevel logLevel, java.lang.String str2, java.lang.Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    str2 = java.lang.String.format(str2, objArr);
                }
            } catch (java.lang.Exception unused) {
                return "log format error at com.up366.pad.common.log.ConsoleLogFormatter (ConsoleLogFormatter.java:15)";
            }
        }
        return java.lang.String.format("%s (%s:%d)", str2, str, java.lang.Integer.valueOf(i));
    }
}
