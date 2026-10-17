package io.objectbox.sync.server;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface SyncServer extends java.io.Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getPort();

    java.lang.String getStatsString();

    java.lang.String getUrl();

    boolean isRunning();

    void setSyncChangeListener(@javax.annotation.Nullable io.objectbox.sync.listener.SyncChangeListener syncChangeListener);

    void start();

    void stop();
}
