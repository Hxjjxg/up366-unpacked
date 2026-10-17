package io.objectbox.kotlin;

/* JADX INFO: compiled from: Flow.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0002H\u0007\u001a$\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00060\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0007H\u0007\u001a\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\tH\u0007¨\u0006\n"}, d2 = {"flow", "Lkotlinx/coroutines/flow/Flow;", "Ljava/lang/Class;", "T", "Lio/objectbox/BoxStore;", "forClass", "", "Lio/objectbox/query/Query;", "toFlow", "Lio/objectbox/reactive/SubscriptionBuilder;", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FlowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: io.objectbox.kotlin.FlowKt$toFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: Flow.kt */
    @kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u0001H\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.objectbox.kotlin.FlowKt$toFlow$1", f = "Flow.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1<T> extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.channels.ProducerScope<? super T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ io.objectbox.reactive.SubscriptionBuilder<T> $this_toFlow;
        private /* synthetic */ java.lang.Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(io.objectbox.reactive.SubscriptionBuilder<T> subscriptionBuilder, kotlin.coroutines.Continuation<? super io.objectbox.kotlin.FlowKt.AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_toFlow = subscriptionBuilder;
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            kotlin.coroutines.Continuation<kotlin.Unit> anonymousClass1 = new io.objectbox.kotlin.FlowKt.AnonymousClass1<>(this.$this_toFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final java.lang.Object invoke(kotlinx.coroutines.channels.ProducerScope<? super T> producerScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return create(producerScope, continuation).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                kotlin.ResultKt.throwOnFailure(obj);
                final kotlinx.coroutines.channels.ProducerScope producerScope = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
                final io.objectbox.reactive.DataSubscription dataSubscriptionObserver = this.$this_toFlow.observer(new io.objectbox.reactive.DataObserver() { // from class: io.objectbox.kotlin.FlowKt$toFlow$1$$ExternalSyntheticLambda0
                    @Override // io.objectbox.reactive.DataObserver
                    public final void onData(java.lang.Object obj2) {
                        io.objectbox.kotlin.FlowKt.AnonymousClass1.invokeSuspend$lambda$0(producerScope, obj2);
                    }
                });
                this.label = 1;
                if (kotlinx.coroutines.channels.ProduceKt.awaitClose(producerScope, new kotlin.jvm.functions.Function0<kotlin.Unit>() { // from class: io.objectbox.kotlin.FlowKt.toFlow.1.1
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                        m1396invoke();
                        return kotlin.Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m1396invoke() {
                        dataSubscriptionObserver.cancel();
                    }
                }, (kotlin.coroutines.Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.ResultKt.throwOnFailure(obj);
            }
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(kotlinx.coroutines.channels.ProducerScope producerScope, java.lang.Object obj) {
            kotlinx.coroutines.channels.ChannelsKt.trySendBlocking((kotlinx.coroutines.channels.SendChannel) producerScope, obj);
        }
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> toFlow(io.objectbox.reactive.SubscriptionBuilder<T> subscriptionBuilder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subscriptionBuilder, "<this>");
        return kotlinx.coroutines.flow.FlowKt.callbackFlow(new io.objectbox.kotlin.FlowKt.AnonymousClass1(subscriptionBuilder, null));
    }

    public static final <T> kotlinx.coroutines.flow.Flow<java.lang.Class<T>> flow(io.objectbox.BoxStore boxStore, java.lang.Class<T> cls) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(boxStore, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cls, "forClass");
        io.objectbox.reactive.SubscriptionBuilder<java.lang.Class<T>> subscriptionBuilderSubscribe = boxStore.subscribe(cls);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(subscriptionBuilderSubscribe, "this.subscribe(forClass)");
        return toFlow(subscriptionBuilderSubscribe);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<java.util.List<T>> flow(io.objectbox.query.Query<T> query) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(query, "<this>");
        io.objectbox.reactive.SubscriptionBuilder<java.util.List<T>> subscriptionBuilderSubscribe = query.subscribe();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(subscriptionBuilderSubscribe, "this@flow.subscribe()");
        return toFlow(subscriptionBuilderSubscribe);
    }
}
