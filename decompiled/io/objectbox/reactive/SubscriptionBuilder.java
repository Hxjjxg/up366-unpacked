package io.objectbox.reactive;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SubscriptionBuilder<T> {
    private io.objectbox.reactive.DataSubscriptionList dataSubscriptionList;
    private io.objectbox.reactive.ErrorObserver errorObserver;
    private io.objectbox.reactive.DataObserver<T> observer;
    private boolean onlyChanges;
    private final io.objectbox.reactive.DataPublisher<T> publisher;
    private final java.lang.Object publisherParam;
    private io.objectbox.reactive.Scheduler scheduler;
    private boolean single;
    private io.objectbox.reactive.DataTransformer<T, java.lang.Object> transformer;
    private boolean weak;

    public SubscriptionBuilder(io.objectbox.reactive.DataPublisher<T> dataPublisher, @javax.annotation.Nullable java.lang.Object obj) {
        this.publisher = dataPublisher;
        this.publisherParam = obj;
    }

    public io.objectbox.reactive.SubscriptionBuilder<T> weak() {
        this.weak = true;
        return this;
    }

    public io.objectbox.reactive.SubscriptionBuilder<T> single() {
        this.single = true;
        return this;
    }

    public io.objectbox.reactive.SubscriptionBuilder<T> onlyChanges() {
        this.onlyChanges = true;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <TO> io.objectbox.reactive.SubscriptionBuilder<TO> transform(io.objectbox.reactive.DataTransformer<T, TO> dataTransformer) {
        if (this.transformer != null) {
            throw new java.lang.IllegalStateException("Only one transformer allowed");
        }
        this.transformer = dataTransformer;
        return this;
    }

    public io.objectbox.reactive.SubscriptionBuilder<T> onError(io.objectbox.reactive.ErrorObserver errorObserver) {
        if (this.errorObserver != null) {
            throw new java.lang.IllegalStateException("Only one errorObserver allowed");
        }
        this.errorObserver = errorObserver;
        return this;
    }

    public io.objectbox.reactive.SubscriptionBuilder<T> on(io.objectbox.reactive.Scheduler scheduler) {
        if (this.scheduler != null) {
            throw new java.lang.IllegalStateException("Only one scheduler allowed");
        }
        this.scheduler = scheduler;
        return this;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public io.objectbox.reactive.DataSubscription observer(io.objectbox.reactive.DataObserver<T> dataObserver) {
        io.objectbox.reactive.WeakDataObserver weakDataObserver;
        if (this.weak) {
            weakDataObserver = new io.objectbox.reactive.WeakDataObserver(dataObserver);
            dataObserver = weakDataObserver;
        } else {
            weakDataObserver = null;
        }
        this.observer = dataObserver;
        io.objectbox.reactive.DataSubscriptionImpl dataSubscriptionImpl = new io.objectbox.reactive.DataSubscriptionImpl(this.publisher, this.publisherParam, dataObserver);
        if (weakDataObserver != null) {
            weakDataObserver.setSubscription(dataSubscriptionImpl);
        }
        io.objectbox.reactive.DataSubscriptionList dataSubscriptionList = this.dataSubscriptionList;
        if (dataSubscriptionList != null) {
            dataSubscriptionList.add(dataSubscriptionImpl);
        }
        if (this.transformer != null || this.scheduler != null || this.errorObserver != null) {
            dataObserver = new io.objectbox.reactive.SubscriptionBuilder.ActionObserver(dataSubscriptionImpl);
        }
        if (this.single) {
            if (this.onlyChanges) {
                throw new java.lang.IllegalStateException("Illegal combination of single() and onlyChanges()");
            }
            this.publisher.publishSingle(dataObserver, this.publisherParam);
        } else {
            this.publisher.subscribe(dataObserver, this.publisherParam);
            if (!this.onlyChanges) {
                this.publisher.publishSingle(dataObserver, this.publisherParam);
            }
        }
        return dataSubscriptionImpl;
    }

    public io.objectbox.reactive.SubscriptionBuilder<T> dataSubscriptionList(io.objectbox.reactive.DataSubscriptionList dataSubscriptionList) {
        this.dataSubscriptionList = dataSubscriptionList;
        return this;
    }

    class ActionObserver implements io.objectbox.reactive.DataObserver<T>, io.objectbox.reactive.DelegatingObserver<T> {
        private io.objectbox.reactive.SubscriptionBuilder<T>.ActionObserver.SchedulerRunOnChange schedulerRunOnData;
        private io.objectbox.reactive.SubscriptionBuilder<T>.ActionObserver.SchedulerRunOnError schedulerRunOnError;
        private final io.objectbox.reactive.DataSubscriptionImpl subscription;

        public ActionObserver(io.objectbox.reactive.DataSubscriptionImpl dataSubscriptionImpl) {
            this.subscription = dataSubscriptionImpl;
            if (io.objectbox.reactive.SubscriptionBuilder.this.scheduler != null) {
                this.schedulerRunOnData = new io.objectbox.reactive.SubscriptionBuilder.ActionObserver.SchedulerRunOnChange();
                if (io.objectbox.reactive.SubscriptionBuilder.this.errorObserver != null) {
                    this.schedulerRunOnError = new io.objectbox.reactive.SubscriptionBuilder.ActionObserver.SchedulerRunOnError();
                }
            }
        }

        @Override // io.objectbox.reactive.DataObserver
        public void onData(T t) {
            if (io.objectbox.reactive.SubscriptionBuilder.this.transformer != null) {
                transformAndContinue(t);
            } else {
                callOnData(t);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void transformAndContinue(T t) {
            if (this.subscription.isCanceled()) {
                return;
            }
            try {
                callOnData(io.objectbox.reactive.SubscriptionBuilder.this.transformer.transform(t));
            } catch (java.lang.Throwable th) {
                callOnError(th, "Transformer failed without an ErrorObserver set");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void callOnError(java.lang.Throwable th, java.lang.String str) {
            if (io.objectbox.reactive.SubscriptionBuilder.this.errorObserver != null) {
                if (this.subscription.isCanceled()) {
                    return;
                }
                if (io.objectbox.reactive.SubscriptionBuilder.this.scheduler != null) {
                    io.objectbox.reactive.SubscriptionBuilder.this.scheduler.run(this.schedulerRunOnError, th);
                    return;
                } else {
                    io.objectbox.reactive.SubscriptionBuilder.this.errorObserver.onError(th);
                    return;
                }
            }
            java.lang.RuntimeException runtimeException = new java.lang.RuntimeException(str, th);
            runtimeException.printStackTrace();
            throw runtimeException;
        }

        void callOnData(T t) {
            if (this.subscription.isCanceled()) {
                return;
            }
            if (io.objectbox.reactive.SubscriptionBuilder.this.scheduler != null) {
                io.objectbox.reactive.SubscriptionBuilder.this.scheduler.run(this.schedulerRunOnData, t);
                return;
            }
            try {
                io.objectbox.reactive.SubscriptionBuilder.this.observer.onData(t);
            } catch (java.lang.Error | java.lang.RuntimeException e) {
                callOnError(e, "Observer failed without an ErrorObserver set");
            }
        }

        @Override // io.objectbox.reactive.DelegatingObserver
        public io.objectbox.reactive.DataObserver<T> getObserverDelegate() {
            return io.objectbox.reactive.SubscriptionBuilder.this.observer;
        }

        class SchedulerRunOnChange implements io.objectbox.reactive.RunWithParam<T> {
            SchedulerRunOnChange() {
            }

            @Override // io.objectbox.reactive.RunWithParam
            public void run(T t) {
                if (io.objectbox.reactive.SubscriptionBuilder.ActionObserver.this.subscription.isCanceled()) {
                    return;
                }
                try {
                    io.objectbox.reactive.SubscriptionBuilder.this.observer.onData(t);
                } catch (java.lang.Error | java.lang.RuntimeException e) {
                    io.objectbox.reactive.SubscriptionBuilder.ActionObserver.this.callOnError(e, "Observer failed without an ErrorObserver set");
                }
            }
        }

        class SchedulerRunOnError implements io.objectbox.reactive.RunWithParam<java.lang.Throwable> {
            SchedulerRunOnError() {
            }

            @Override // io.objectbox.reactive.RunWithParam
            public void run(java.lang.Throwable th) {
                if (io.objectbox.reactive.SubscriptionBuilder.ActionObserver.this.subscription.isCanceled()) {
                    return;
                }
                io.objectbox.reactive.SubscriptionBuilder.this.errorObserver.onError(th);
            }
        }
    }
}
