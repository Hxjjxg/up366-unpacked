package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogRuntimeState.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00028\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0002\u0010\u000eR\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00018\u00008\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/up366/common/log/AndroidKmpLogAtomicState;", "T", "Lcom/up366/common/log/KmpLogAtomicState;", "initialValue", "<init>", "(Ljava/lang/Object;)V", "reference", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "get", "()Ljava/lang/Object;", "update", "transform", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidKmpLogAtomicState<T> implements com.up366.common.log.KmpLogAtomicState<T> {
    private final java.util.concurrent.atomic.AtomicReference<T> reference;

    public AndroidKmpLogAtomicState(T t) {
        this.reference = new java.util.concurrent.atomic.AtomicReference<>(t);
    }

    @Override // com.up366.common.log.KmpLogAtomicState
    public T get() {
        return this.reference.get();
    }

    @Override // com.up366.common.log.KmpLogAtomicState
    public T update(kotlin.jvm.functions.Function1<? super T, ? extends T> transform) {
        T t;
        T t2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            t = this.reference.get();
            t2 = (T) transform.invoke(t);
        } while (!androidx.camera.view.PreviewView$1$.ExternalSyntheticBackportWithForwarding0.m(this.reference, t, t2));
        return t2;
    }
}
