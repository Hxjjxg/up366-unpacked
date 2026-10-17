package io.objectbox.kotlin;

/* JADX INFO: compiled from: BoxStore.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0006\b\u0000\u0010\t\u0018\u0001*\u00020\u0003H\u0086\b\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u0002*\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0086\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"awaitCallInTx", "V", "", "Lio/objectbox/BoxStore;", "callable", "Ljava/util/concurrent/Callable;", "(Lio/objectbox/BoxStore;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boxFor", "Lio/objectbox/Box;", "T", "clazz", "Lkotlin/reflect/KClass;", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BoxStoreKt {
    public static final /* synthetic */ <T> io.objectbox.Box<T> boxFor(io.objectbox.BoxStore boxStore) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(boxStore, "<this>");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, "T");
        io.objectbox.Box<T> boxBoxFor = boxStore.boxFor(java.lang.Object.class);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(boxBoxFor, "boxFor(T::class.java)");
        return boxBoxFor;
    }

    public static final <T> io.objectbox.Box<T> boxFor(io.objectbox.BoxStore boxStore, kotlin.reflect.KClass<T> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(boxStore, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "clazz");
        io.objectbox.Box<T> boxBoxFor = boxStore.boxFor(kotlin.jvm.JvmClassMappingKt.getJavaClass(kClass));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(boxBoxFor, "boxFor(clazz.java)");
        return boxBoxFor;
    }

    public static final <V> java.lang.Object awaitCallInTx(io.objectbox.BoxStore boxStore, java.util.concurrent.Callable<V> callable, kotlin.coroutines.Continuation<? super V> continuation) {
        kotlin.coroutines.Continuation safeContinuation = new kotlin.coroutines.SafeContinuation(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation));
        final kotlin.coroutines.Continuation continuation2 = safeContinuation;
        boxStore.callInTxAsync(callable, new io.objectbox.TxCallback() { // from class: io.objectbox.kotlin.BoxStoreKt$awaitCallInTx$2$1
            @Override // io.objectbox.TxCallback
            public final void txFinished(V v, java.lang.Throwable th) {
                if (th != null) {
                    kotlin.coroutines.Continuation<V> continuation3 = continuation2;
                    kotlin.Result.Companion companion = kotlin.Result.Companion;
                    continuation3.resumeWith(kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th)));
                } else {
                    kotlin.coroutines.Continuation<V> continuation4 = continuation2;
                    kotlin.Result.Companion companion2 = kotlin.Result.Companion;
                    continuation4.resumeWith(kotlin.Result.constructor-impl(v));
                }
            }
        });
        java.lang.Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
