package io.objectbox.reactive;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class DataSubscriptionImpl<T> implements io.objectbox.reactive.DataSubscription {
    private volatile boolean canceled;
    private io.objectbox.reactive.DataObserver<T> observer;
    private io.objectbox.reactive.DataPublisher<T> publisher;
    private java.lang.Object publisherParam;

    DataSubscriptionImpl(io.objectbox.reactive.DataPublisher<T> dataPublisher, @javax.annotation.Nullable java.lang.Object obj, io.objectbox.reactive.DataObserver<T> dataObserver) {
        this.publisher = dataPublisher;
        this.publisherParam = obj;
        this.observer = dataObserver;
    }

    @Override // io.objectbox.reactive.DataSubscription
    public synchronized void cancel() {
        this.canceled = true;
        io.objectbox.reactive.DataPublisher<T> dataPublisher = this.publisher;
        if (dataPublisher != null) {
            dataPublisher.unsubscribe(this.observer, this.publisherParam);
            this.publisher = null;
            this.observer = null;
            this.publisherParam = null;
        }
    }

    @Override // io.objectbox.reactive.DataSubscription
    public boolean isCanceled() {
        return this.canceled;
    }
}
