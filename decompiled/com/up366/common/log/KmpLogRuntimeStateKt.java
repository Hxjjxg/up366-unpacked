package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogRuntimeState.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"createKmpLogAtomicState", "Lcom/up366/common/log/KmpLogAtomicState;", "T", "initialValue", "(Ljava/lang/Object;)Lcom/up366/common/log/KmpLogAtomicState;", "kmpLog_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KmpLogRuntimeStateKt {
    public static final <T> com.up366.common.log.KmpLogAtomicState<T> createKmpLogAtomicState(T t) {
        return new com.up366.common.log.AndroidKmpLogAtomicState(t);
    }
}
