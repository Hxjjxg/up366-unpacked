package io.objectbox.sync.server;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class PeerInfo {
    io.objectbox.sync.SyncCredentials credentials;
    java.lang.String url;

    PeerInfo(java.lang.String str, io.objectbox.sync.SyncCredentials syncCredentials) {
        this.url = str;
        this.credentials = syncCredentials;
    }
}
