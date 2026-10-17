package io.objectbox.sync;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SyncCredentialsToken extends io.objectbox.sync.SyncCredentials {
    private volatile boolean cleared;

    @javax.annotation.Nullable
    private byte[] token;
    private final io.objectbox.sync.SyncCredentials.CredentialsType type;

    SyncCredentialsToken(io.objectbox.sync.SyncCredentials.CredentialsType credentialsType) {
        this.type = credentialsType;
        this.token = null;
    }

    SyncCredentialsToken(io.objectbox.sync.SyncCredentials.CredentialsType credentialsType, byte[] bArr) {
        this(credentialsType);
        if (bArr == null || bArr.length == 0) {
            throw new java.lang.IllegalArgumentException("Token must not be empty");
        }
        this.token = bArr;
    }

    SyncCredentialsToken(io.objectbox.sync.SyncCredentials.CredentialsType credentialsType, java.lang.String str) {
        this(credentialsType, asUtf8Bytes(str));
    }

    public long getTypeId() {
        return this.type.id;
    }

    @javax.annotation.Nullable
    public byte[] getTokenBytes() {
        if (this.cleared) {
            throw new java.lang.IllegalStateException("Credentials already have been cleared");
        }
        return this.token;
    }

    public void clear() {
        this.cleared = true;
        byte[] bArr = this.token;
        if (bArr != null) {
            java.util.Arrays.fill(bArr, (byte) 0);
        }
        this.token = null;
    }

    private static byte[] asUtf8Bytes(java.lang.String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException(e);
        }
    }
}
