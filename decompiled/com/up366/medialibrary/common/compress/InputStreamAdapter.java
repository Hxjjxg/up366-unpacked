package com.up366.medialibrary.common.compress;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class InputStreamAdapter implements com.up366.medialibrary.common.compress.InputStreamProvider {
    private java.io.InputStream inputStream;

    public abstract java.io.InputStream openInternal() throws java.io.IOException;

    @Override // com.up366.medialibrary.common.compress.InputStreamProvider
    public java.io.InputStream open() throws java.io.IOException {
        java.io.InputStream inputStreamOpenInternal = openInternal();
        this.inputStream = inputStreamOpenInternal;
        return inputStreamOpenInternal;
    }

    @Override // com.up366.medialibrary.common.compress.InputStreamProvider
    public void close() {
        java.io.InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            } catch (java.lang.Throwable th) {
                this.inputStream = null;
                throw th;
            }
            this.inputStream = null;
        }
    }
}
