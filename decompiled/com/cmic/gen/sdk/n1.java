package com.cmic.gen.sdk;

/* JADX INFO: compiled from: TlsSniSocketFactory.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class n1 extends com.cmic.gen.sdk.h {
    private static final java.lang.String[] f = {"TLSv1.2"};
    private final java.lang.String a = "n1";
    javax.net.ssl.HostnameVerifier b = javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier();
    private final javax.net.ssl.HttpsURLConnection c;
    private final android.net.Network d;
    private final com.cmic.gen.sdk.i e;

    public n1(javax.net.ssl.HttpsURLConnection httpsURLConnection, android.net.Network network, com.cmic.gen.sdk.i iVar) {
        this.c = httpsURLConnection;
        this.d = network;
        this.e = iVar;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i) throws java.io.IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i, java.net.InetAddress inetAddress, int i2) throws java.io.IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i) throws java.io.IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i, java.net.InetAddress inetAddress2, int i2) throws java.io.IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) throws java.io.IOException {
        java.lang.String requestProperty = this.c.getRequestProperty("Host");
        if (requestProperty != null) {
            str = requestProperty;
        }
        com.cmic.gen.sdk.h0.a(this.a, "customized createSocket. host: " + str);
        com.cmic.gen.sdk.h0.a(this.a, "plainSocket localAddress: " + socket.getLocalAddress().getHostAddress());
        if (z) {
            com.cmic.gen.sdk.h0.a(this.a, "plainSocket close");
            socket.close();
        }
        android.net.SSLCertificateSocketFactory sSLCertificateSocketFactory = (android.net.SSLCertificateSocketFactory) android.net.SSLCertificateSocketFactory.getDefault(0);
        javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) sSLCertificateSocketFactory.createSocket();
        android.net.Network network = this.d;
        if (network != null) {
            network.bindSocket(sSLSocket);
        }
        sSLSocket.connect(socket.getRemoteSocketAddress());
        this.e.b("socketip", sSLSocket.getLocalAddress().getHostAddress());
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        com.cmic.gen.sdk.h0.a(this.a, "Setting SNI hostname");
        sSLCertificateSocketFactory.setHostname(sSLSocket, str);
        javax.net.ssl.SSLSession session = sSLSocket.getSession();
        if (!this.b.verify(str, session)) {
            throw new javax.net.ssl.SSLPeerUnverifiedException("Cannot verify hostname: " + str);
        }
        com.cmic.gen.sdk.h0.a(this.a, "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
        return sSLSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getDefaultCipherSuites() {
        return new java.lang.String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getSupportedCipherSuites() {
        return new java.lang.String[0];
    }
}
