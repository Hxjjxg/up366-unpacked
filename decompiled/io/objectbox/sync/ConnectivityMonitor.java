package io.objectbox.sync;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ConnectivityMonitor {

    @javax.annotation.Nullable
    private io.objectbox.sync.SyncClient syncClient;

    public void onObserverRemoved() {
    }

    public void onObserverSet() {
    }

    void setObserver(io.objectbox.sync.SyncClient syncClient) {
        if (syncClient == null) {
            throw new java.lang.IllegalArgumentException("Sync client must not be null");
        }
        this.syncClient = syncClient;
        onObserverSet();
    }

    void removeObserver() {
        this.syncClient = null;
        onObserverRemoved();
    }

    public final void notifyConnectionAvailable() {
        io.objectbox.sync.SyncClient syncClient = this.syncClient;
        if (syncClient != null) {
            syncClient.notifyConnectionAvailable();
        }
    }
}
