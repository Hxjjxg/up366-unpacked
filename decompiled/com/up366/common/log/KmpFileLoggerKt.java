package com.up366.common.log;

/* JADX INFO: compiled from: KmpFileLogger.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"shouldWriteFileSynchronously", "", "level", "Lcom/up366/common/log/KmpLogLevel;", "isAutoSyncErrorEnable", "kmpLog_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KmpFileLoggerKt {
    public static final boolean shouldWriteFileSynchronously(com.up366.common.log.KmpLogLevel kmpLogLevel, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogLevel, "level");
        return z && kmpLogLevel.getValue() >= com.up366.common.log.KmpLogLevel.ERROR.getValue();
    }
}
