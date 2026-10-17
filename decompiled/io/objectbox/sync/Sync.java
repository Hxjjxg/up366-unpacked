package io.objectbox.sync;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Sync {
    public static boolean isAvailable() {
        return io.objectbox.BoxStore.isSyncAvailable();
    }

    public static boolean isServerAvailable() {
        return io.objectbox.BoxStore.isSyncServerAvailable();
    }

    public static io.objectbox.sync.SyncBuilder client(io.objectbox.BoxStore boxStore, java.lang.String str, io.objectbox.sync.SyncCredentials syncCredentials) {
        return new io.objectbox.sync.SyncBuilder(boxStore, str, syncCredentials);
    }

    public static io.objectbox.sync.server.SyncServerBuilder server(io.objectbox.BoxStore boxStore, java.lang.String str, io.objectbox.sync.SyncCredentials syncCredentials) {
        return new io.objectbox.sync.server.SyncServerBuilder(boxStore, str, syncCredentials);
    }

    private Sync() {
    }
}
