package com.cmic.gen.sdk;

/* JADX INFO: compiled from: Tls12SocketFactory.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class m1 extends com.cmic.gen.sdk.h {
    private static final java.lang.String[] b = {"TLSv1.2"};
    private final com.cmic.gen.sdk.i a;

    public m1(javax.net.ssl.SSLSocketFactory sSLSocketFactory, com.cmic.gen.sdk.i iVar) {
        this.delegate = sSLSocketFactory;
        this.a = iVar;
    }

    private java.net.Socket a(java.net.Socket socket) {
        boolean z = socket instanceof javax.net.ssl.SSLSocket;
        this.a.b("socketip", socket.getLocalAddress().getHostAddress());
        return socket;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket() throws java.io.IOException {
        return a(this.delegate.createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public java.lang.String toString() {
        return "Tls12SocketFactory";
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) throws java.io.IOException {
        return a(this.delegate.createSocket(socket, str, i, z));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i) throws java.io.IOException {
        return a(this.delegate.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i, java.net.InetAddress inetAddress, int i2) throws java.io.IOException {
        return a(this.delegate.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i) throws java.io.IOException {
        return a(this.delegate.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i, java.net.InetAddress inetAddress2, int i2) throws java.io.IOException {
        return a(this.delegate.createSocket(inetAddress, i, inetAddress2, i2));
    }
}
