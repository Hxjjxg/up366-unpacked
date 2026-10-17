package com.up366.common.log;

/* JADX INFO: compiled from: KmpConsoleLogger.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/up366/common/log/KmpConsoleLogger;", "Lcom/up366/common/log/KmpLogger;", "logFormatter", "Lcom/up366/common/log/KmpLogFormatter;", "<init>", "(Lcom/up366/common/log/KmpLogFormatter;)V", "getLogFormatter", "()Lcom/up366/common/log/KmpLogFormatter;", "setLogFormatter", "log", "", "record", "Lcom/up366/common/log/KmpLogRecord;", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KmpConsoleLogger implements com.up366.common.log.KmpLogger {
    private com.up366.common.log.KmpLogFormatter logFormatter;

    /* JADX WARN: Illegal instructions before constructor call */
    public KmpConsoleLogger() {
        com.up366.common.log.KmpLogFormatter kmpLogFormatter = null;
        this(kmpLogFormatter, 1, kmpLogFormatter);
    }

    public KmpConsoleLogger(com.up366.common.log.KmpLogFormatter kmpLogFormatter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogFormatter, "logFormatter");
        this.logFormatter = kmpLogFormatter;
    }

    public /* synthetic */ KmpConsoleLogger(com.up366.common.log.KmpLogDefaultFormatter kmpLogDefaultFormatter, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? com.up366.common.log.KmpLogDefaultFormatter.INSTANCE : kmpLogDefaultFormatter);
    }

    @Override // com.up366.common.log.KmpLogger
    public com.up366.common.log.KmpLogFormatter getLogFormatter() {
        return this.logFormatter;
    }

    @Override // com.up366.common.log.KmpLogger
    public void setLogFormatter(com.up366.common.log.KmpLogFormatter kmpLogFormatter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogFormatter, "<set-?>");
        this.logFormatter = kmpLogFormatter;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @Override // com.up366.common.log.KmpLogger
    public void log(com.up366.common.log.KmpLogRecord record) throws kotlin.NoWhenBranchMatchedException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(record, "record");
        com.up366.common.log.KmpLogLevel level = record.getLevel();
        java.lang.String tag = record.getTag();
        if (tag == null) {
            tag = "";
        }
        com.up366.common.log.KmpLogPlatformKt.writePlatformLog(level, tag, getLogFormatter().format(record));
    }
}
