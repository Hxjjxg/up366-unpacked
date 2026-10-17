package io.objectbox.sync;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SyncCredentials {
    public static io.objectbox.sync.SyncCredentials sharedSecret(java.lang.String str) {
        return new io.objectbox.sync.SyncCredentialsToken(io.objectbox.sync.SyncCredentials.CredentialsType.SHARED_SECRET, str);
    }

    public static io.objectbox.sync.SyncCredentials sharedSecret(byte[] bArr) {
        return new io.objectbox.sync.SyncCredentialsToken(io.objectbox.sync.SyncCredentials.CredentialsType.SHARED_SECRET, bArr);
    }

    public static io.objectbox.sync.SyncCredentials google(java.lang.String str) {
        return new io.objectbox.sync.SyncCredentialsToken(io.objectbox.sync.SyncCredentials.CredentialsType.GOOGLE, str);
    }

    public static io.objectbox.sync.SyncCredentials none() {
        return new io.objectbox.sync.SyncCredentialsToken(io.objectbox.sync.SyncCredentials.CredentialsType.NONE);
    }

    public enum CredentialsType {
        NONE(1),
        SHARED_SECRET(2),
        GOOGLE(3);

        public final long id;

        CredentialsType(long j) {
            this.id = j;
        }
    }

    SyncCredentials() {
    }
}
