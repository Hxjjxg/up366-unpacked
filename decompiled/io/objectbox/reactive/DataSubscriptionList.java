package io.objectbox.reactive;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DataSubscriptionList implements io.objectbox.reactive.DataSubscription {
    private boolean canceled;
    private final java.util.List<io.objectbox.reactive.DataSubscription> subscriptions = new java.util.ArrayList();

    public synchronized void add(io.objectbox.reactive.DataSubscription dataSubscription) {
        this.subscriptions.add(dataSubscription);
        this.canceled = false;
    }

    @Override // io.objectbox.reactive.DataSubscription
    public synchronized void cancel() {
        this.canceled = true;
        java.util.Iterator<io.objectbox.reactive.DataSubscription> it = this.subscriptions.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.subscriptions.clear();
    }

    @Override // io.objectbox.reactive.DataSubscription
    public synchronized boolean isCanceled() {
        return this.canceled;
    }

    public synchronized int getActiveSubscriptionCount() {
        return this.subscriptions.size();
    }
}
