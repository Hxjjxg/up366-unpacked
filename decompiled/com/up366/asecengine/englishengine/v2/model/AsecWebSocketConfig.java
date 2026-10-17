package com.up366.asecengine.englishengine.v2.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsecWebSocketConfig {
    private long connectTimeoutMs = 30000;
    private java.lang.String connectionIdPrefix = "";
    private java.lang.String webSocketUrl;

    public java.lang.String getWebSocketUrl() {
        return this.webSocketUrl;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig setWebSocketUrl(java.lang.String str) {
        this.webSocketUrl = str;
        return this;
    }

    public long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig setConnectTimeoutMs(long j) {
        this.connectTimeoutMs = java.lang.Math.max(1000L, j);
        return this;
    }

    public java.lang.String getConnectionIdPrefix() {
        return this.connectionIdPrefix;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig setConnectionIdPrefix(java.lang.String str) {
        this.connectionIdPrefix = str;
        return this;
    }

    public java.lang.String resolveWebSocketUrl(java.lang.String str, java.lang.String str2) {
        if (this.webSocketUrl == null) {
            return null;
        }
        return com.up366.asecengine.englishengine.v2.AsecRequestIdHelper.appendRequestIdToUrl(this.webSocketUrl, str) + "&connection_id=" + str2;
    }

    public java.lang.String generateConnectionId() {
        return this.connectionIdPrefix + "__" + java.lang.System.currentTimeMillis() + "__native";
    }
}
