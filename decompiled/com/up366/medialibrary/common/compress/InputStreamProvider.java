package com.up366.medialibrary.common.compress;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface InputStreamProvider {
    void close();

    com.up366.medialibrary.model.LocalMedia getMedia();

    java.lang.String getPath();

    java.io.InputStream open() throws java.io.IOException;
}
