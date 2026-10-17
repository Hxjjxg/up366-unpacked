package io.objectbox.sync.server;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SyncServerBuilder {
    final io.objectbox.BoxStore boxStore;

    @javax.annotation.Nullable
    java.lang.String certificatePath;
    io.objectbox.sync.listener.SyncChangeListener changeListener;
    final java.util.List<io.objectbox.sync.SyncCredentials> credentials = new java.util.ArrayList();
    final java.util.List<io.objectbox.sync.server.PeerInfo> peers = new java.util.ArrayList();
    final java.lang.String url;

    public SyncServerBuilder(io.objectbox.BoxStore boxStore, java.lang.String str, io.objectbox.sync.SyncCredentials syncCredentials) {
        checkNotNull(boxStore, "BoxStore is required.");
        checkNotNull(str, "Sync server URL is required.");
        checkNotNull(syncCredentials, "Authenticator credentials are required.");
        if (!io.objectbox.BoxStore.isSyncServerAvailable()) {
            throw new java.lang.IllegalStateException("This library does not include ObjectBox Sync Server. Please visit https://objectbox.io/sync/ for options.");
        }
        this.boxStore = boxStore;
        this.url = str;
        authenticatorCredentials(syncCredentials);
    }

    public io.objectbox.sync.server.SyncServerBuilder certificatePath(java.lang.String str) {
        this.certificatePath = str;
        return this;
    }

    public io.objectbox.sync.server.SyncServerBuilder authenticatorCredentials(io.objectbox.sync.SyncCredentials syncCredentials) {
        checkNotNull(syncCredentials, "Authenticator credentials must not be null.");
        this.credentials.add(syncCredentials);
        return this;
    }

    public io.objectbox.sync.server.SyncServerBuilder changeListener(io.objectbox.sync.listener.SyncChangeListener syncChangeListener) {
        this.changeListener = syncChangeListener;
        return this;
    }

    public io.objectbox.sync.server.SyncServerBuilder peer(java.lang.String str) {
        return peer(str, io.objectbox.sync.SyncCredentials.none());
    }

    public io.objectbox.sync.server.SyncServerBuilder peer(java.lang.String str, io.objectbox.sync.SyncCredentials syncCredentials) {
        this.peers.add(new io.objectbox.sync.server.PeerInfo(str, syncCredentials));
        return this;
    }

    public io.objectbox.sync.server.SyncServer build() {
        if (this.credentials.isEmpty()) {
            throw new java.lang.IllegalStateException("At least one authenticator is required.");
        }
        return new io.objectbox.sync.server.SyncServerImpl(this);
    }

    public io.objectbox.sync.server.SyncServer buildAndStart() {
        io.objectbox.sync.server.SyncServer syncServerBuild = build();
        syncServerBuild.start();
        return syncServerBuild;
    }

    private void checkNotNull(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException(str);
        }
    }
}
