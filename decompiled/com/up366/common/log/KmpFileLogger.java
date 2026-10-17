package com.up366.common.log;

/* JADX INFO: compiled from: KmpFileLogger.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/up366/common/log/KmpFileLogger;", "Lcom/up366/common/log/KmpLogger;", "directoryPath", "", "isAutoSyncErrorEnable", "", "logFormatter", "Lcom/up366/common/log/KmpLogFormatter;", "<init>", "(Ljava/lang/String;ZLcom/up366/common/log/KmpLogFormatter;)V", "getLogFormatter", "()Lcom/up366/common/log/KmpLogFormatter;", "setLogFormatter", "(Lcom/up366/common/log/KmpLogFormatter;)V", "log", "", "record", "Lcom/up366/common/log/KmpLogRecord;", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KmpFileLogger implements com.up366.common.log.KmpLogger {
    private final java.lang.String directoryPath;
    private final boolean isAutoSyncErrorEnable;
    private com.up366.common.log.KmpLogFormatter logFormatter;

    public KmpFileLogger(java.lang.String str, boolean z, com.up366.common.log.KmpLogFormatter kmpLogFormatter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "directoryPath");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogFormatter, "logFormatter");
        this.directoryPath = str;
        this.isAutoSyncErrorEnable = z;
        this.logFormatter = kmpLogFormatter;
    }

    public /* synthetic */ KmpFileLogger(java.lang.String str, boolean z, com.up366.common.log.KmpLogDefaultFormatter kmpLogDefaultFormatter, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? com.up366.common.log.KmpLogDefaultFormatter.INSTANCE : kmpLogDefaultFormatter);
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

    @Override // com.up366.common.log.KmpLogger
    public void log(com.up366.common.log.KmpLogRecord record) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(record, "record");
        java.lang.Long timestampMillis = record.getTimestampMillis();
        long jLongValue = timestampMillis != null ? timestampMillis.longValue() : com.up366.common.log.KmpLogPlatformKt.currentTimeMillis();
        com.up366.common.log.KmpLogRecord kmpLogRecordCopy$default = record.getTimestampMillis() == null ? com.up366.common.log.KmpLogRecord.copy$default(record, null, null, null, java.lang.Long.valueOf(jLongValue), null, null, 0, 119, null) : record;
        com.up366.common.log.KmpLogFileRecord kmpLogFileRecord = new com.up366.common.log.KmpLogFileRecord(this.directoryPath, com.up366.common.log.KmpLogPlatformKt.currentLogFileName(jLongValue), getLogFormatter().format(kmpLogRecordCopy$default) + "\n", record.getLevel());
        if (com.up366.common.log.KmpFileLoggerKt.shouldWriteFileSynchronously(record.getLevel(), this.isAutoSyncErrorEnable)) {
            com.up366.common.log.KmpLogPlatformKt.appendPlatformLogFile(kmpLogFileRecord.getDirectoryPath(), kmpLogFileRecord.getFileName(), kmpLogFileRecord.getLine());
        } else {
            com.up366.common.log.KmpLogPlatformKt.enqueuePlatformLogFile(kmpLogFileRecord);
        }
    }
}
