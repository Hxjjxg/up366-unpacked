package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogRuntimeState.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\r\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00028\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0007H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/up366/common/log/KmpLogAtomicState;", "T", "", "get", "()Ljava/lang/Object;", "update", "transform", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface KmpLogAtomicState<T> {
    T get();

    T update(kotlin.jvm.functions.Function1<? super T, ? extends T> transform);
}
