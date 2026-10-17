package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class bj extends javax.net.ssl.SSLSocketFactory {
    public static final java.lang.String[] c = {"TLSv1.1", "TLSv1.2"};
    public final javax.net.ssl.SSLSocketFactory b;

    public bj(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        this.b = sSLSocketFactory;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) throws java.io.IOException {
        java.net.Socket socketCreateSocket = this.b.createSocket(socket, str, i, z);
        if (socketCreateSocket instanceof javax.net.ssl.SSLSocket) {
            ((javax.net.ssl.SSLSocket) socketCreateSocket).setEnabledProtocols(c);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final java.lang.String[] getDefaultCipherSuites() {
        return this.b.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final java.lang.String[] getSupportedCipherSuites() {
        return this.b.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket(java.lang.String str, int i) throws java.io.IOException {
        java.net.Socket socketCreateSocket = this.b.createSocket(str, i);
        if (socketCreateSocket instanceof javax.net.ssl.SSLSocket) {
            ((javax.net.ssl.SSLSocket) socketCreateSocket).setEnabledProtocols(c);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket(java.lang.String str, int i, java.net.InetAddress inetAddress, int i2) throws java.io.IOException {
        java.net.Socket socketCreateSocket = this.b.createSocket(str, i, inetAddress, i2);
        if (socketCreateSocket instanceof javax.net.ssl.SSLSocket) {
            ((javax.net.ssl.SSLSocket) socketCreateSocket).setEnabledProtocols(c);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket(java.net.InetAddress inetAddress, int i) throws java.io.IOException {
        java.net.Socket socketCreateSocket = this.b.createSocket(inetAddress, i);
        if (socketCreateSocket instanceof javax.net.ssl.SSLSocket) {
            ((javax.net.ssl.SSLSocket) socketCreateSocket).setEnabledProtocols(c);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket(java.net.InetAddress inetAddress, int i, java.net.InetAddress inetAddress2, int i2) throws java.io.IOException {
        java.net.Socket socketCreateSocket = this.b.createSocket(inetAddress, i, inetAddress2, i2);
        if (socketCreateSocket instanceof javax.net.ssl.SSLSocket) {
            ((javax.net.ssl.SSLSocket) socketCreateSocket).setEnabledProtocols(c);
        }
        return socketCreateSocket;
    }
}
