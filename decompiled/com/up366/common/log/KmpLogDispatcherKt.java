package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogDispatcher.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"dispatchSafely", "", "loggers", "", "Lcom/up366/common/log/KmpLogger;", "record", "Lcom/up366/common/log/KmpLogRecord;", "kmpLog_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KmpLogDispatcherKt {
    public static final void dispatchSafely(java.util.List<? extends com.up366.common.log.KmpLogger> list, com.up366.common.log.KmpLogRecord kmpLogRecord) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "loggers");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogRecord, "record");
        for (com.up366.common.log.KmpLogger kmpLogger : list) {
            try {
                kotlin.Result.Companion companion = kotlin.Result.Companion;
                kmpLogger.log(kmpLogRecord);
                kotlin.Result.constructor-impl(kotlin.Unit.INSTANCE);
            } catch (java.lang.Throwable th) {
                kotlin.Result.Companion companion2 = kotlin.Result.Companion;
                kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th));
            }
        }
    }
}
