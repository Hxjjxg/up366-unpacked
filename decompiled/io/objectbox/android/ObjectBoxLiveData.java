package io.objectbox.android;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ObjectBoxLiveData<T> extends androidx.lifecycle.LiveData<java.util.List<T>> {
    private final io.objectbox.reactive.DataObserver<java.util.List<T>> listener = new io.objectbox.reactive.DataObserver() { // from class: io.objectbox.android.ObjectBoxLiveData$$ExternalSyntheticLambda0
        @Override // io.objectbox.reactive.DataObserver
        public final void onData(java.lang.Object obj) {
            this.f$0.postValue((java.util.List) obj);
        }
    };
    private final io.objectbox.query.Query<T> query;
    private io.objectbox.reactive.DataSubscription subscription;

    public ObjectBoxLiveData(io.objectbox.query.Query<T> query) {
        this.query = query;
    }

    protected void onActive() {
        if (this.subscription == null) {
            this.subscription = this.query.subscribe().observer(this.listener);
        }
    }

    protected void onInactive() {
        if (hasObservers()) {
            return;
        }
        this.subscription.cancel();
        this.subscription = null;
    }
}
