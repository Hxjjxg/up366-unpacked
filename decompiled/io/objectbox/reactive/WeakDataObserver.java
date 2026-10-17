package io.objectbox.reactive;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class WeakDataObserver<T> implements io.objectbox.reactive.DataObserver<T>, io.objectbox.reactive.DelegatingObserver {
    private io.objectbox.reactive.DataSubscription subscription;
    private final java.lang.ref.WeakReference<io.objectbox.reactive.DataObserver<T>> weakDelegate;

    WeakDataObserver(io.objectbox.reactive.DataObserver<T> dataObserver) {
        this.weakDelegate = new java.lang.ref.WeakReference<>(dataObserver);
    }

    @Override // io.objectbox.reactive.DataObserver
    public void onData(T t) {
        io.objectbox.reactive.DataObserver<T> dataObserver = this.weakDelegate.get();
        if (dataObserver != null) {
            dataObserver.onData(t);
        } else {
            this.subscription.cancel();
        }
    }

    @Override // io.objectbox.reactive.DelegatingObserver
    public io.objectbox.reactive.DataObserver<T> getObserverDelegate() {
        return this.weakDelegate.get();
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof io.objectbox.reactive.WeakDataObserver)) {
            return false;
        }
        io.objectbox.reactive.DataObserver<T> dataObserver = this.weakDelegate.get();
        if (dataObserver == null || dataObserver != ((io.objectbox.reactive.WeakDataObserver) obj).weakDelegate.get()) {
            return super.equals(obj);
        }
        return true;
    }

    public int hashCode() {
        io.objectbox.reactive.DataObserver<T> dataObserver = this.weakDelegate.get();
        if (dataObserver != null) {
            return dataObserver.hashCode();
        }
        return super.hashCode();
    }

    public void setSubscription(io.objectbox.reactive.DataSubscription dataSubscription) {
        this.subscription = dataSubscription;
    }
}
