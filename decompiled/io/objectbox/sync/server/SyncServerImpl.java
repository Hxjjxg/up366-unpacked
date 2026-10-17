package io.objectbox.sync.server;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SyncServerImpl implements io.objectbox.sync.server.SyncServer {
    private volatile long handle;

    @javax.annotation.Nullable
    private volatile io.objectbox.sync.listener.SyncChangeListener syncChangeListener;
    private final java.lang.String url;

    private native void nativeAddPeer(long j, java.lang.String str, long j2, @javax.annotation.Nullable byte[] bArr);

    private static native long nativeCreate(long j, java.lang.String str, @javax.annotation.Nullable java.lang.String str2);

    private native void nativeDelete(long j);

    private native int nativeGetPort(long j);

    private native java.lang.String nativeGetStatsString(long j);

    private native boolean nativeIsRunning(long j);

    private native void nativeSetAuthenticator(long j, long j2, @javax.annotation.Nullable byte[] bArr);

    private native void nativeSetSyncChangesListener(long j, @javax.annotation.Nullable io.objectbox.sync.listener.SyncChangeListener syncChangeListener);

    private native void nativeStart(long j);

    private native void nativeStop(long j);

    SyncServerImpl(io.objectbox.sync.server.SyncServerBuilder syncServerBuilder) {
        java.lang.String str = syncServerBuilder.url;
        this.url = str;
        long jNativeCreate = nativeCreate(syncServerBuilder.boxStore.getNativeStore(), str, syncServerBuilder.certificatePath);
        if (jNativeCreate == 0) {
            throw new java.lang.RuntimeException("Failed to create sync server: handle is zero.");
        }
        this.handle = jNativeCreate;
        java.util.Iterator<io.objectbox.sync.SyncCredentials> it = syncServerBuilder.credentials.iterator();
        while (it.hasNext()) {
            io.objectbox.sync.SyncCredentialsToken syncCredentialsToken = (io.objectbox.sync.SyncCredentialsToken) it.next();
            nativeSetAuthenticator(jNativeCreate, syncCredentialsToken.getTypeId(), syncCredentialsToken.getTokenBytes());
            syncCredentialsToken.clear();
        }
        for (io.objectbox.sync.server.PeerInfo peerInfo : syncServerBuilder.peers) {
            io.objectbox.sync.SyncCredentialsToken syncCredentialsToken2 = (io.objectbox.sync.SyncCredentialsToken) peerInfo.credentials;
            nativeAddPeer(jNativeCreate, peerInfo.url, syncCredentialsToken2.getTypeId(), syncCredentialsToken2.getTokenBytes());
        }
        if (syncServerBuilder.changeListener != null) {
            setSyncChangeListener(syncServerBuilder.changeListener);
        }
    }

    private long getHandle() {
        long j = this.handle;
        if (j != 0) {
            return j;
        }
        throw new java.lang.IllegalStateException("SyncServer already closed");
    }

    @Override // io.objectbox.sync.server.SyncServer
    public java.lang.String getUrl() {
        return this.url;
    }

    @Override // io.objectbox.sync.server.SyncServer
    public int getPort() {
        return nativeGetPort(getHandle());
    }

    @Override // io.objectbox.sync.server.SyncServer
    public boolean isRunning() {
        return nativeIsRunning(getHandle());
    }

    @Override // io.objectbox.sync.server.SyncServer
    public java.lang.String getStatsString() {
        return nativeGetStatsString(getHandle());
    }

    @Override // io.objectbox.sync.server.SyncServer
    public void setSyncChangeListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncChangeListener syncChangeListener) {
        this.syncChangeListener = syncChangeListener;
        nativeSetSyncChangesListener(getHandle(), syncChangeListener);
    }

    @Override // io.objectbox.sync.server.SyncServer
    public void start() {
        nativeStart(getHandle());
    }

    @Override // io.objectbox.sync.server.SyncServer
    public void stop() {
        nativeStop(getHandle());
    }

    @Override // io.objectbox.sync.server.SyncServer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.handle;
        this.handle = 0L;
        if (j != 0) {
            nativeDelete(j);
        }
    }

    protected void finalize() throws java.lang.Throwable {
        close();
        super.finalize();
    }
}
