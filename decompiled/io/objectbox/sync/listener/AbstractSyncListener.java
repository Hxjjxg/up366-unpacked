package io.objectbox.sync.listener;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AbstractSyncListener implements io.objectbox.sync.listener.SyncListener {
    @Override // io.objectbox.sync.listener.SyncConnectionListener
    public void onDisconnected() {
    }

    @Override // io.objectbox.sync.listener.SyncLoginListener
    public void onLoggedIn() {
    }

    @Override // io.objectbox.sync.listener.SyncLoginListener
    public void onLoginFailed(long j) {
    }

    @Override // io.objectbox.sync.listener.SyncTimeListener
    public void onServerTimeUpdate(long j) {
    }

    @Override // io.objectbox.sync.listener.SyncChangeListener
    public void onSyncChanges(io.objectbox.sync.SyncChange[] syncChangeArr) {
    }

    @Override // io.objectbox.sync.listener.SyncCompletedListener
    public void onUpdatesCompleted() {
    }
}
