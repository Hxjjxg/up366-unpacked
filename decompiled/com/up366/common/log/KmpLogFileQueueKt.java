package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogFileQueue.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"KMP_LOG_FILE_QUEUE_CAPACITY", "", "KMP_LOG_FILE_MAX_BATCH_SIZE", "isImportantFileLog", "", "Lcom/up366/common/log/KmpLogLevel;", "kmpLog_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KmpLogFileQueueKt {
    public static final int KMP_LOG_FILE_MAX_BATCH_SIZE = 64;
    public static final int KMP_LOG_FILE_QUEUE_CAPACITY = 1024;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isImportantFileLog(com.up366.common.log.KmpLogLevel kmpLogLevel) {
        return kmpLogLevel == com.up366.common.log.KmpLogLevel.WARN || kmpLogLevel == com.up366.common.log.KmpLogLevel.ERROR || kmpLogLevel == com.up366.common.log.KmpLogLevel.FATAL;
    }
}
