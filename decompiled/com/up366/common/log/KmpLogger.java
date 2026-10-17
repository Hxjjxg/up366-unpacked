package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogger.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/up366/common/log/KmpLogger;", "", "logFormatter", "Lcom/up366/common/log/KmpLogFormatter;", "getLogFormatter", "()Lcom/up366/common/log/KmpLogFormatter;", "setLogFormatter", "(Lcom/up366/common/log/KmpLogFormatter;)V", "log", "", "record", "Lcom/up366/common/log/KmpLogRecord;", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface KmpLogger {
    com.up366.common.log.KmpLogFormatter getLogFormatter();

    void log(com.up366.common.log.KmpLogRecord record);

    void setLogFormatter(com.up366.common.log.KmpLogFormatter kmpLogFormatter);
}
