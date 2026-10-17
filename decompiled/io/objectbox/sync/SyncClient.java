package io.objectbox.sync;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface SyncClient extends java.io.Closeable {
    boolean awaitFirstLogin(long j);

    boolean cancelUpdates();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    long getLastLoginCode();

    long getRoundtripTimeNanos();

    long getServerTimeDiffNanos();

    long getServerTimeNanos();

    java.lang.String getServerUrl();

    boolean isLoggedIn();

    boolean isStarted();

    void notifyConnectionAvailable();

    boolean requestFullSync();

    boolean requestUpdates();

    boolean requestUpdatesOnce();

    void setLoginCredentials(io.objectbox.sync.SyncCredentials syncCredentials);

    void setSyncChangeListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncChangeListener syncChangeListener);

    void setSyncCompletedListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncCompletedListener syncCompletedListener);

    void setSyncConnectionListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncConnectionListener syncConnectionListener);

    void setSyncListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncListener syncListener);

    void setSyncLoginListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncLoginListener syncLoginListener);

    void setSyncTimeListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncTimeListener syncTimeListener);

    void start();

    io.objectbox.sync.ObjectsMessageBuilder startObjectsMessage(long j, @javax.annotation.Nullable java.lang.String str);

    void stop();
}
