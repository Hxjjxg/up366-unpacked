package io.objectbox.sync;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SyncClientImpl implements io.objectbox.sync.SyncClient {

    @javax.annotation.Nullable
    private io.objectbox.BoxStore boxStore;

    @javax.annotation.Nullable
    private volatile io.objectbox.sync.listener.SyncCompletedListener completedListener;

    @javax.annotation.Nullable
    private volatile io.objectbox.sync.listener.SyncConnectionListener connectionListener;

    @javax.annotation.Nullable
    private final io.objectbox.sync.ConnectivityMonitor connectivityMonitor;
    private volatile long handle;
    private final io.objectbox.sync.SyncClientImpl.InternalSyncClientListener internalListener;
    private volatile long lastLoginCode;

    @javax.annotation.Nullable
    private volatile io.objectbox.sync.listener.SyncLoginListener loginListener;
    private final java.lang.String serverUrl;
    private volatile boolean started;

    @javax.annotation.Nullable
    private volatile io.objectbox.sync.listener.SyncTimeListener timeListener;

    private native boolean nativeCancelUpdates(long j);

    private static native long nativeCreate(long j, java.lang.String str, @javax.annotation.Nullable java.lang.String[] strArr);

    private native void nativeDelete(long j);

    private native int nativeGetState(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeObjectsMessageAddBytes(long j, long j2, byte[] bArr, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeObjectsMessageAddString(long j, long j2, java.lang.String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeObjectsMessageSend(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native long nativeObjectsMessageStart(long j, @javax.annotation.Nullable java.lang.String str);

    private native boolean nativeRequestFullSync(long j, boolean z);

    private native boolean nativeRequestUpdates(long j, boolean z);

    private native long nativeRoundtripTime(long j);

    private native long nativeServerTime(long j);

    private native long nativeServerTimeDiff(long j);

    private native void nativeSetListener(long j, @javax.annotation.Nullable io.objectbox.sync.SyncClientImpl.InternalSyncClientListener internalSyncClientListener);

    private native void nativeSetLoginInfo(long j, long j2, @javax.annotation.Nullable byte[] bArr);

    private native void nativeSetRequestUpdatesMode(long j, boolean z, boolean z2);

    private native void nativeSetSyncChangesListener(long j, @javax.annotation.Nullable io.objectbox.sync.listener.SyncChangeListener syncChangeListener);

    private native void nativeSetUncommittedAcks(long j, boolean z);

    private native void nativeStart(long j);

    private native void nativeStop(long j);

    private native boolean nativeTriggerReconnect(long j);

    SyncClientImpl(io.objectbox.sync.SyncBuilder syncBuilder) {
        this.boxStore = syncBuilder.boxStore;
        java.lang.String str = syncBuilder.url;
        this.serverUrl = str;
        this.connectivityMonitor = syncBuilder.platform.getConnectivityMonitor();
        long jNativeCreate = nativeCreate(syncBuilder.boxStore.getNativeStore(), str, syncBuilder.trustedCertPaths);
        if (jNativeCreate == 0) {
            throw new java.lang.RuntimeException("Failed to create sync client: handle is zero.");
        }
        this.handle = jNativeCreate;
        if (syncBuilder.requestUpdatesMode != io.objectbox.sync.SyncBuilder.RequestUpdatesMode.AUTO) {
            nativeSetRequestUpdatesMode(jNativeCreate, syncBuilder.requestUpdatesMode != io.objectbox.sync.SyncBuilder.RequestUpdatesMode.MANUAL, false);
        }
        if (syncBuilder.uncommittedAcks) {
            nativeSetUncommittedAcks(jNativeCreate, true);
        }
        if (syncBuilder.listener != null) {
            setSyncListener(syncBuilder.listener);
        } else {
            this.loginListener = syncBuilder.loginListener;
            this.completedListener = syncBuilder.completedListener;
            if (syncBuilder.changeListener != null) {
                setSyncChangeListener(syncBuilder.changeListener);
            }
            this.connectionListener = syncBuilder.connectionListener;
            this.timeListener = syncBuilder.timeListener;
        }
        io.objectbox.sync.SyncClientImpl.InternalSyncClientListener internalSyncClientListener = new io.objectbox.sync.SyncClientImpl.InternalSyncClientListener();
        this.internalListener = internalSyncClientListener;
        nativeSetListener(jNativeCreate, internalSyncClientListener);
        setLoginCredentials(syncBuilder.credentials);
        io.objectbox.InternalAccess.setSyncClient(syncBuilder.boxStore, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getHandle() {
        long j = this.handle;
        if (j != 0) {
            return j;
        }
        throw new java.lang.IllegalStateException("SyncClient already closed");
    }

    @Override // io.objectbox.sync.SyncClient
    public java.lang.String getServerUrl() {
        return this.serverUrl;
    }

    @Override // io.objectbox.sync.SyncClient
    public long getLastLoginCode() {
        return this.lastLoginCode;
    }

    @Override // io.objectbox.sync.SyncClient
    public boolean isLoggedIn() {
        return this.lastLoginCode == 20;
    }

    @Override // io.objectbox.sync.SyncClient
    public long getServerTimeNanos() {
        return nativeServerTime(getHandle());
    }

    @Override // io.objectbox.sync.SyncClient
    public long getServerTimeDiffNanos() {
        return nativeServerTimeDiff(getHandle());
    }

    @Override // io.objectbox.sync.SyncClient
    public long getRoundtripTimeNanos() {
        return nativeRoundtripTime(getHandle());
    }

    public io.objectbox.sync.SyncState getSyncState() {
        return io.objectbox.sync.SyncState.fromId(nativeGetState(getHandle()));
    }

    @Override // io.objectbox.sync.SyncClient
    public void setSyncLoginListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncLoginListener syncLoginListener) {
        this.loginListener = syncLoginListener;
    }

    @Override // io.objectbox.sync.SyncClient
    public void setSyncCompletedListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncCompletedListener syncCompletedListener) {
        this.completedListener = syncCompletedListener;
    }

    @Override // io.objectbox.sync.SyncClient
    public void setSyncChangeListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncChangeListener syncChangeListener) {
        nativeSetSyncChangesListener(getHandle(), syncChangeListener);
    }

    @Override // io.objectbox.sync.SyncClient
    public void setSyncTimeListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncTimeListener syncTimeListener) {
        this.timeListener = syncTimeListener;
    }

    @Override // io.objectbox.sync.SyncClient
    public void setSyncConnectionListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncConnectionListener syncConnectionListener) {
        this.connectionListener = syncConnectionListener;
    }

    @Override // io.objectbox.sync.SyncClient
    public void setSyncListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncListener syncListener) {
        this.loginListener = syncListener;
        this.completedListener = syncListener;
        this.timeListener = syncListener;
        this.connectionListener = syncListener;
        setSyncChangeListener(syncListener);
    }

    @Override // io.objectbox.sync.SyncClient
    public void setLoginCredentials(io.objectbox.sync.SyncCredentials syncCredentials) {
        io.objectbox.sync.SyncCredentialsToken syncCredentialsToken = (io.objectbox.sync.SyncCredentialsToken) syncCredentials;
        nativeSetLoginInfo(getHandle(), syncCredentialsToken.getTypeId(), syncCredentialsToken.getTokenBytes());
        syncCredentialsToken.clear();
    }

    @Override // io.objectbox.sync.SyncClient
    public boolean awaitFirstLogin(long j) {
        if (!this.started) {
            start();
        }
        return this.internalListener.awaitFirstLogin(j);
    }

    @Override // io.objectbox.sync.SyncClient
    public synchronized void start() {
        nativeStart(getHandle());
        this.started = true;
        io.objectbox.sync.ConnectivityMonitor connectivityMonitor = this.connectivityMonitor;
        if (connectivityMonitor != null) {
            connectivityMonitor.setObserver(this);
        }
    }

    @Override // io.objectbox.sync.SyncClient
    public boolean isStarted() {
        return this.started;
    }

    @Override // io.objectbox.sync.SyncClient
    public synchronized void stop() {
        io.objectbox.sync.ConnectivityMonitor connectivityMonitor = this.connectivityMonitor;
        if (connectivityMonitor != null) {
            connectivityMonitor.removeObserver();
        }
        nativeStop(getHandle());
        this.started = false;
    }

    @Override // io.objectbox.sync.SyncClient, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j;
        synchronized (this) {
            io.objectbox.sync.ConnectivityMonitor connectivityMonitor = this.connectivityMonitor;
            if (connectivityMonitor != null) {
                connectivityMonitor.removeObserver();
            }
            io.objectbox.BoxStore boxStore = this.boxStore;
            if (boxStore != null) {
                if (boxStore.getSyncClient() == this) {
                    io.objectbox.InternalAccess.setSyncClient(boxStore, null);
                }
                this.boxStore = null;
            }
            j = this.handle;
            this.handle = 0L;
        }
        if (j != 0) {
            nativeDelete(j);
        }
    }

    protected void finalize() throws java.lang.Throwable {
        close();
        super.finalize();
    }

    @Override // io.objectbox.sync.SyncClient
    public boolean requestFullSync() {
        return nativeRequestFullSync(getHandle(), false);
    }

    public boolean requestFullSyncAndUpdates() {
        return nativeRequestFullSync(getHandle(), true);
    }

    @Override // io.objectbox.sync.SyncClient
    public boolean requestUpdates() {
        return nativeRequestUpdates(getHandle(), true);
    }

    @Override // io.objectbox.sync.SyncClient
    public boolean requestUpdatesOnce() {
        return nativeRequestUpdates(getHandle(), false);
    }

    @Override // io.objectbox.sync.SyncClient
    public boolean cancelUpdates() {
        return nativeCancelUpdates(getHandle());
    }

    @Override // io.objectbox.sync.SyncClient
    public void notifyConnectionAvailable() {
        nativeTriggerReconnect(getHandle());
    }

    @Override // io.objectbox.sync.SyncClient
    public io.objectbox.sync.ObjectsMessageBuilder startObjectsMessage(long j, @javax.annotation.Nullable java.lang.String str) {
        return new io.objectbox.sync.SyncClientImpl.ObjectsMessageBuilderImpl(j, str);
    }

    private class InternalSyncClientListener {
        private final java.util.concurrent.CountDownLatch firstLoginLatch;

        private InternalSyncClientListener() {
            this.firstLoginLatch = new java.util.concurrent.CountDownLatch(1);
        }

        public void onLogin() {
            io.objectbox.sync.SyncClientImpl.this.lastLoginCode = 20L;
            this.firstLoginLatch.countDown();
            io.objectbox.sync.listener.SyncLoginListener syncLoginListener = io.objectbox.sync.SyncClientImpl.this.loginListener;
            if (syncLoginListener != null) {
                syncLoginListener.onLoggedIn();
            }
        }

        public void onLoginFailure(long j) {
            io.objectbox.sync.SyncClientImpl.this.lastLoginCode = j;
            this.firstLoginLatch.countDown();
            io.objectbox.sync.listener.SyncLoginListener syncLoginListener = io.objectbox.sync.SyncClientImpl.this.loginListener;
            if (syncLoginListener != null) {
                syncLoginListener.onLoginFailed(j);
            }
        }

        public void onSyncComplete() {
            io.objectbox.sync.listener.SyncCompletedListener syncCompletedListener = io.objectbox.sync.SyncClientImpl.this.completedListener;
            if (syncCompletedListener != null) {
                syncCompletedListener.onUpdatesCompleted();
            }
        }

        public void onServerTimeUpdate(long j) {
            io.objectbox.sync.listener.SyncTimeListener syncTimeListener = io.objectbox.sync.SyncClientImpl.this.timeListener;
            if (syncTimeListener != null) {
                syncTimeListener.onServerTimeUpdate(j);
            }
        }

        public void onDisconnect() {
            io.objectbox.sync.listener.SyncConnectionListener syncConnectionListener = io.objectbox.sync.SyncClientImpl.this.connectionListener;
            if (syncConnectionListener != null) {
                syncConnectionListener.onDisconnected();
            }
        }

        boolean awaitFirstLogin(long j) {
            try {
                return this.firstLoginLatch.await(j, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.InterruptedException unused) {
                return false;
            }
        }
    }

    public static class ObjectsMessageBuilderImpl implements io.objectbox.sync.ObjectsMessageBuilder {
        private final long builderHandle;
        private boolean sent;
        private final io.objectbox.sync.SyncClientImpl syncClient;

        private ObjectsMessageBuilderImpl(io.objectbox.sync.SyncClientImpl syncClientImpl, long j, @javax.annotation.Nullable java.lang.String str) {
            this.syncClient = syncClientImpl;
            this.builderHandle = syncClientImpl.nativeObjectsMessageStart(j, str);
        }

        @Override // io.objectbox.sync.ObjectsMessageBuilder
        public io.objectbox.sync.SyncClientImpl.ObjectsMessageBuilderImpl addString(long j, java.lang.String str) {
            checkNotSent();
            this.syncClient.nativeObjectsMessageAddString(this.builderHandle, j, str);
            return this;
        }

        @Override // io.objectbox.sync.ObjectsMessageBuilder
        public io.objectbox.sync.SyncClientImpl.ObjectsMessageBuilderImpl addBytes(long j, byte[] bArr, boolean z) {
            checkNotSent();
            this.syncClient.nativeObjectsMessageAddBytes(this.builderHandle, j, bArr, z);
            return this;
        }

        @Override // io.objectbox.sync.ObjectsMessageBuilder
        public boolean send() {
            if (!this.syncClient.isStarted()) {
                return false;
            }
            checkNotSent();
            this.sent = true;
            io.objectbox.sync.SyncClientImpl syncClientImpl = this.syncClient;
            return syncClientImpl.nativeObjectsMessageSend(syncClientImpl.getHandle(), this.builderHandle);
        }

        private void checkNotSent() {
            if (this.sent) {
                throw new java.lang.IllegalStateException("Already sent this message, start a new one instead.");
            }
        }
    }
}
