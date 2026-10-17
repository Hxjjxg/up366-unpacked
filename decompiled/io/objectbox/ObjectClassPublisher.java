package io.objectbox;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class ObjectClassPublisher implements io.objectbox.reactive.DataPublisher<java.lang.Class>, java.lang.Runnable {
    final io.objectbox.BoxStore boxStore;
    volatile boolean changePublisherRunning;
    final org.greenrobot.essentials.collections.MultimapSet<java.lang.Integer, io.objectbox.reactive.DataObserver<java.lang.Class>> observersByEntityTypeId = org.greenrobot.essentials.collections.MultimapSet.create(org.greenrobot.essentials.collections.MultimapSet.SetType.THREAD_SAFE);
    private final java.util.Deque<io.objectbox.ObjectClassPublisher.PublishRequest> changesQueue = new java.util.ArrayDeque();

    private static class PublishRequest {
        private final int[] entityTypeIds;

        @javax.annotation.Nullable
        private final io.objectbox.reactive.DataObserver<java.lang.Class> observer;

        PublishRequest(@javax.annotation.Nullable io.objectbox.reactive.DataObserver<java.lang.Class> dataObserver, int[] iArr) {
            this.observer = dataObserver;
            this.entityTypeIds = iArr;
        }
    }

    ObjectClassPublisher(io.objectbox.BoxStore boxStore) {
        this.boxStore = boxStore;
    }

    @Override // io.objectbox.reactive.DataPublisher
    public void subscribe(io.objectbox.reactive.DataObserver<java.lang.Class> dataObserver, @javax.annotation.Nullable java.lang.Object obj) {
        if (obj == null) {
            for (int i : this.boxStore.getAllEntityTypeIds()) {
                this.observersByEntityTypeId.putElement(java.lang.Integer.valueOf(i), dataObserver);
            }
            return;
        }
        this.observersByEntityTypeId.putElement(java.lang.Integer.valueOf(this.boxStore.getEntityTypeIdOrThrow((java.lang.Class) obj)), dataObserver);
    }

    @Override // io.objectbox.reactive.DataPublisher
    public void unsubscribe(io.objectbox.reactive.DataObserver<java.lang.Class> dataObserver, @javax.annotation.Nullable java.lang.Object obj) {
        if (obj != null) {
            unsubscribe(dataObserver, this.boxStore.getEntityTypeIdOrThrow((java.lang.Class) obj));
            return;
        }
        for (int i : this.boxStore.getAllEntityTypeIds()) {
            unsubscribe(dataObserver, i);
        }
    }

    private void unsubscribe(io.objectbox.reactive.DataObserver<java.lang.Class> dataObserver, int i) {
        io.objectbox.reactive.DataPublisherUtils.removeObserverFromCopyOnWriteSet((java.util.Set) this.observersByEntityTypeId.get(java.lang.Integer.valueOf(i)), dataObserver);
    }

    @Override // io.objectbox.reactive.DataPublisher
    public void publishSingle(io.objectbox.reactive.DataObserver<java.lang.Class> dataObserver, @javax.annotation.Nullable java.lang.Object obj) {
        int[] allEntityTypeIds;
        if (obj != null) {
            allEntityTypeIds = new int[]{this.boxStore.getEntityTypeIdOrThrow((java.lang.Class) obj)};
        } else {
            allEntityTypeIds = this.boxStore.getAllEntityTypeIds();
        }
        queuePublishRequestAndScheduleRun(dataObserver, allEntityTypeIds);
    }

    void publish(int[] iArr) {
        queuePublishRequestAndScheduleRun(null, iArr);
    }

    private void queuePublishRequestAndScheduleRun(@javax.annotation.Nullable io.objectbox.reactive.DataObserver<java.lang.Class> dataObserver, int[] iArr) {
        synchronized (this.changesQueue) {
            this.changesQueue.add(new io.objectbox.ObjectClassPublisher.PublishRequest(dataObserver, iArr));
            if (!this.changePublisherRunning) {
                this.changePublisherRunning = true;
                this.boxStore.internalScheduleThread(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        io.objectbox.ObjectClassPublisher.PublishRequest publishRequestPollFirst;
        java.util.Collection collectionSingletonList;
        while (true) {
            try {
            } finally {
            }
            synchronized (this.changesQueue) {
                publishRequestPollFirst = this.changesQueue.pollFirst();
                if (publishRequestPollFirst == null) {
                    this.changePublisherRunning = false;
                    return;
                }
                this.changePublisherRunning = false;
            }
            for (int i : publishRequestPollFirst.entityTypeIds) {
                if (publishRequestPollFirst.observer != null) {
                    collectionSingletonList = java.util.Collections.singletonList(publishRequestPollFirst.observer);
                } else {
                    collectionSingletonList = this.observersByEntityTypeId.get(java.lang.Integer.valueOf(i));
                }
                if (collectionSingletonList != null && !collectionSingletonList.isEmpty()) {
                    java.lang.Class<?> entityClassOrThrow = this.boxStore.getEntityClassOrThrow(i);
                    try {
                        java.util.Iterator it = collectionSingletonList.iterator();
                        while (it.hasNext()) {
                            ((io.objectbox.reactive.DataObserver) it.next()).onData(entityClassOrThrow);
                        }
                    } catch (java.lang.RuntimeException unused) {
                        handleObserverException(entityClassOrThrow);
                    }
                }
            }
        }
    }

    private void handleObserverException(java.lang.Class cls) {
        java.lang.RuntimeException runtimeException = new java.lang.RuntimeException("Observer failed while processing data for " + cls + ". Consider using an ErrorObserver");
        runtimeException.printStackTrace();
        throw runtimeException;
    }
}
