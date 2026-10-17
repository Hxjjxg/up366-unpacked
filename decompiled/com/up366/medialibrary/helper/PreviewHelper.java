package com.up366.medialibrary.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PreviewHelper {
    private com.up366.medialibrary.MediaMoreConfig config;

    protected PreviewHelper() {
    }

    public void config(com.up366.medialibrary.MediaMoreConfig mediaMoreConfig) {
        this.config = mediaMoreConfig;
    }

    public void clear() {
        this.config = null;
    }

    public com.up366.medialibrary.MediaMoreConfig getConfig() {
        com.up366.medialibrary.MediaMoreConfig mediaMoreConfig = this.config;
        return mediaMoreConfig == null ? new com.up366.medialibrary.MediaMoreConfigBuilder().build() : mediaMoreConfig;
    }
}
