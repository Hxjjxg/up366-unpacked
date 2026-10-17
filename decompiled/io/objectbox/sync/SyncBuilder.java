package io.objectbox.sync;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SyncBuilder {
    final io.objectbox.BoxStore boxStore;

    @javax.annotation.Nullable
    io.objectbox.sync.listener.SyncChangeListener changeListener;

    @javax.annotation.Nullable
    io.objectbox.sync.listener.SyncCompletedListener completedListener;

    @javax.annotation.Nullable
    io.objectbox.sync.listener.SyncConnectionListener connectionListener;
    final io.objectbox.sync.SyncCredentials credentials;

    @javax.annotation.Nullable
    io.objectbox.sync.listener.SyncListener listener;

    @javax.annotation.Nullable
    io.objectbox.sync.listener.SyncLoginListener loginListener;
    final io.objectbox.sync.internal.Platform platform;
    io.objectbox.sync.SyncBuilder.RequestUpdatesMode requestUpdatesMode = io.objectbox.sync.SyncBuilder.RequestUpdatesMode.AUTO;

    @javax.annotation.Nullable
    io.objectbox.sync.listener.SyncTimeListener timeListener;

    @javax.annotation.Nullable
    java.lang.String[] trustedCertPaths;
    boolean uncommittedAcks;
    final java.lang.String url;

    public enum RequestUpdatesMode {
        MANUAL,
        AUTO,
        AUTO_NO_PUSHES
    }

    public SyncBuilder(io.objectbox.BoxStore boxStore, java.lang.String str, io.objectbox.sync.SyncCredentials syncCredentials) {
        checkNotNull(boxStore, "BoxStore is required.");
        checkNotNull(str, "Sync server URL is required.");
        checkNotNull(syncCredentials, "Sync credentials are required.");
        if (!io.objectbox.BoxStore.isSyncAvailable()) {
            throw new java.lang.IllegalStateException("This library does not include ObjectBox Sync. Please visit https://objectbox.io/sync/ for options.");
        }
        this.platform = io.objectbox.sync.internal.Platform.findPlatform();
        this.boxStore = boxStore;
        this.url = str;
        this.credentials = syncCredentials;
    }

    public io.objectbox.sync.SyncBuilder trustedCertificates(java.lang.String[] strArr) {
        this.trustedCertPaths = (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length);
        return this;
    }

    public io.objectbox.sync.SyncBuilder requestUpdatesMode(io.objectbox.sync.SyncBuilder.RequestUpdatesMode requestUpdatesMode) {
        this.requestUpdatesMode = requestUpdatesMode;
        return this;
    }

    public io.objectbox.sync.SyncBuilder uncommittedAcks() {
        this.uncommittedAcks = true;
        return this;
    }

    public io.objectbox.sync.SyncBuilder loginListener(io.objectbox.sync.listener.SyncLoginListener syncLoginListener) {
        this.loginListener = syncLoginListener;
        return this;
    }

    public io.objectbox.sync.SyncBuilder completedListener(io.objectbox.sync.listener.SyncCompletedListener syncCompletedListener) {
        this.completedListener = syncCompletedListener;
        return this;
    }

    public io.objectbox.sync.SyncBuilder changeListener(io.objectbox.sync.listener.SyncChangeListener syncChangeListener) {
        this.changeListener = syncChangeListener;
        return this;
    }

    public io.objectbox.sync.SyncBuilder timeListener(io.objectbox.sync.listener.SyncTimeListener syncTimeListener) {
        this.timeListener = syncTimeListener;
        return this;
    }

    public io.objectbox.sync.SyncBuilder connectionListener(io.objectbox.sync.listener.SyncConnectionListener syncConnectionListener) {
        this.connectionListener = syncConnectionListener;
        return this;
    }

    public io.objectbox.sync.SyncBuilder listener(io.objectbox.sync.listener.SyncListener syncListener) {
        this.listener = syncListener;
        return this;
    }

    public io.objectbox.sync.SyncClient build() {
        if (this.boxStore.getSyncClient() != null) {
            throw new java.lang.IllegalStateException("The given store is already associated with a Sync client, close it first.");
        }
        return new io.objectbox.sync.SyncClientImpl(this);
    }

    public io.objectbox.sync.SyncClient buildAndStart() {
        io.objectbox.sync.SyncClient syncClientBuild = build();
        syncClientBuild.start();
        return syncClientBuild;
    }

    private void checkNotNull(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException(str);
        }
    }
}
