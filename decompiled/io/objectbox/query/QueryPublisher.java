package io.objectbox.query;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class QueryPublisher<T> implements io.objectbox.reactive.DataPublisher<java.util.List<T>>, java.lang.Runnable {
    private final io.objectbox.Box<T> box;
    private io.objectbox.reactive.DataObserver<java.lang.Class<T>> objectClassObserver;
    private io.objectbox.reactive.DataSubscription objectClassSubscription;
    private final io.objectbox.query.Query<T> query;
    private final java.util.Set<io.objectbox.reactive.DataObserver<java.util.List<T>>> observers = new java.util.concurrent.CopyOnWriteArraySet();
    private final java.util.Deque<io.objectbox.reactive.DataObserver<java.util.List<T>>> publishQueue = new java.util.ArrayDeque();
    private volatile boolean publisherRunning = false;
    private final io.objectbox.query.QueryPublisher.SubscribedObservers<T> SUBSCRIBED_OBSERVERS = new io.objectbox.query.QueryPublisher.SubscribedObservers<>();

    private static class SubscribedObservers<T> implements io.objectbox.reactive.DataObserver<java.util.List<T>> {
        @Override // io.objectbox.reactive.DataObserver
        public void onData(java.util.List<T> list) {
        }

        private SubscribedObservers() {
        }
    }

    QueryPublisher(io.objectbox.query.Query<T> query, io.objectbox.Box<T> box) {
        this.query = query;
        this.box = box;
    }

    @Override // io.objectbox.reactive.DataPublisher
    public synchronized void subscribe(io.objectbox.reactive.DataObserver<java.util.List<T>> dataObserver, @javax.annotation.Nullable java.lang.Object obj) {
        io.objectbox.BoxStore store = this.box.getStore();
        if (this.objectClassObserver == null) {
            this.objectClassObserver = new io.objectbox.reactive.DataObserver() { // from class: io.objectbox.query.QueryPublisher$$ExternalSyntheticLambda0
                @Override // io.objectbox.reactive.DataObserver
                public final void onData(java.lang.Object obj2) {
                    this.f$0.m1427lambda$subscribe$0$ioobjectboxqueryQueryPublisher((java.lang.Class) obj2);
                }
            };
        }
        if (this.observers.isEmpty()) {
            if (this.objectClassSubscription != null) {
                throw new java.lang.IllegalStateException("Existing subscription found");
            }
            this.objectClassSubscription = store.subscribe(this.box.getEntityClass()).weak().onlyChanges().observer(this.objectClassObserver);
        }
        this.observers.add(dataObserver);
    }

    /* JADX INFO: renamed from: lambda$subscribe$0$io-objectbox-query-QueryPublisher, reason: not valid java name */
    /* synthetic */ void m1427lambda$subscribe$0$ioobjectboxqueryQueryPublisher(java.lang.Class cls) {
        publish();
    }

    @Override // io.objectbox.reactive.DataPublisher
    public void publishSingle(io.objectbox.reactive.DataObserver<java.util.List<T>> dataObserver, @javax.annotation.Nullable java.lang.Object obj) {
        queueObserverAndScheduleRun(dataObserver);
    }

    void publish() {
        queueObserverAndScheduleRun(this.SUBSCRIBED_OBSERVERS);
    }

    private void queueObserverAndScheduleRun(io.objectbox.reactive.DataObserver<java.util.List<T>> dataObserver) {
        synchronized (this.publishQueue) {
            this.publishQueue.add(dataObserver);
            if (!this.publisherRunning) {
                this.publisherRunning = true;
                this.box.getStore().internalScheduleThread(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.ArrayList arrayList;
        boolean z;
        while (true) {
            try {
                arrayList = new java.util.ArrayList();
            } finally {
            }
            synchronized (this.publishQueue) {
                z = false;
                while (true) {
                    io.objectbox.reactive.DataObserver<java.util.List<T>> dataObserverPoll = this.publishQueue.poll();
                    if (dataObserverPoll == null) {
                        break;
                    } else if (this.SUBSCRIBED_OBSERVERS.equals(dataObserverPoll)) {
                        z = true;
                    } else {
                        arrayList.add(dataObserverPoll);
                    }
                    this.publisherRunning = false;
                }
                if (!z && arrayList.isEmpty()) {
                    this.publisherRunning = false;
                    return;
                }
                this.publisherRunning = false;
            }
            java.util.List<T> listFind = this.query.find();
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((io.objectbox.reactive.DataObserver) it.next()).onData(listFind);
            }
            if (z) {
                java.util.Iterator<io.objectbox.reactive.DataObserver<java.util.List<T>>> it2 = this.observers.iterator();
                while (it2.hasNext()) {
                    it2.next().onData(listFind);
                }
            }
        }
    }

    @Override // io.objectbox.reactive.DataPublisher
    public synchronized void unsubscribe(io.objectbox.reactive.DataObserver<java.util.List<T>> dataObserver, @javax.annotation.Nullable java.lang.Object obj) {
        io.objectbox.reactive.DataPublisherUtils.removeObserverFromCopyOnWriteSet(this.observers, dataObserver);
        if (this.observers.isEmpty()) {
            this.objectClassSubscription.cancel();
            this.objectClassSubscription = null;
        }
    }
}
