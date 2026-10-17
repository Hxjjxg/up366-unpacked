package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class q {
    public static final java.lang.String[] f = {"TLSv1.1", "TLSv1.2"};
    public java.util.concurrent.ExecutorService b = java.util.concurrent.Executors.newCachedThreadPool();
    public final java.util.concurrent.ConcurrentHashMap c = new java.util.concurrent.ConcurrentHashMap();
    public final java.util.concurrent.ConcurrentHashMap d = new java.util.concurrent.ConcurrentHashMap();
    public final java.util.concurrent.ConcurrentHashMap e = new java.util.concurrent.ConcurrentHashMap();

    public final void b(android.content.Context context, android.net.Network network, java.util.ArrayList arrayList) {
        com.unicom.online.account.kernel.o oVar;
        if (arrayList.isEmpty()) {
            return;
        }
        arrayList.size();
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.unicom.online.account.kernel.t tVar = (com.unicom.online.account.kernel.t) it.next();
            if (tVar != null && !android.text.TextUtils.isEmpty(tVar.b)) {
                java.lang.String str = tVar.b;
                java.lang.String str2 = tVar.c;
                int i = android.text.TextUtils.isEmpty(str2) ? 443 : java.lang.Integer.parseInt(str2);
                int i2 = (i <= 0 || i > 65535) ? 443 : i;
                java.lang.String str3 = str + ":" + i2;
                com.unicom.online.account.kernel.o oVar2 = (com.unicom.online.account.kernel.o) this.d.get(str + ":" + i2);
                if (oVar2 == null) {
                    oVar2 = com.unicom.online.account.kernel.o.NONE;
                }
                if (oVar2 != com.unicom.online.account.kernel.o.CONNECTED && oVar2 != (oVar = com.unicom.online.account.kernel.o.CONNECTING)) {
                    this.d.put(str3, oVar);
                    this.e.put(str3, new java.util.concurrent.CountDownLatch(1));
                    java.util.concurrent.ExecutorService executorService = this.b;
                    if (executorService == null || executorService.isShutdown() || this.b.isTerminated()) {
                        this.b = java.util.concurrent.Executors.newCachedThreadPool();
                    }
                    this.b.execute(new com.unicom.online.account.kernel.m(this, context, str, i2, network, str3));
                }
            }
        }
    }

    public final com.unicom.online.account.kernel.p c(java.lang.String str, int i, android.net.Network network) {
        java.util.concurrent.CountDownLatch countDownLatch;
        java.lang.String str2 = str + ":" + i;
        com.unicom.online.account.kernel.p pVarB = (com.unicom.online.account.kernel.p) this.c.get(str2);
        if (pVarB != null && pVarB.b.isConnected() && !pVarB.b.isClosed()) {
            return pVarB;
        }
        com.unicom.online.account.kernel.o oVar = (com.unicom.online.account.kernel.o) this.d.get(str + ":" + i);
        if (oVar == null) {
            oVar = com.unicom.online.account.kernel.o.NONE;
        }
        if (oVar == com.unicom.online.account.kernel.o.CONNECTING && (countDownLatch = (java.util.concurrent.CountDownLatch) this.e.get(str2)) != null) {
            try {
                countDownLatch.await(com.igexin.push.config.c.i, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.InterruptedException unused) {
            }
            pVarB = (com.unicom.online.account.kernel.p) this.c.get(str2);
            if (pVarB != null && pVarB.b.isConnected() && !pVarB.b.isClosed()) {
                return pVarB;
            }
            com.unicom.online.account.kernel.o oVar2 = (com.unicom.online.account.kernel.o) this.d.get(str + ":" + i);
            if (oVar2 == null) {
                oVar2 = com.unicom.online.account.kernel.o.NONE;
            }
            if (oVar2 == com.unicom.online.account.kernel.o.FAILED) {
                return null;
            }
        }
        try {
            pVarB = b(str, i, network);
            if (pVarB != null) {
                this.c.put(str2, pVarB);
                this.d.put(str2, com.unicom.online.account.kernel.o.CONNECTED);
            } else {
                this.d.put(str2, com.unicom.online.account.kernel.o.FAILED);
                com.unicom.online.account.kernel.ao.v = "域名 " + str + " 端口 " + i + "创建新连接失败";
            }
        } catch (java.lang.Exception e) {
            this.d.put(str2, com.unicom.online.account.kernel.o.FAILED);
            com.unicom.online.account.kernel.ao.v = "域名 " + str + " 端口 " + i + " 创建新连接异常: " + e.getMessage();
            e.getMessage();
            com.unicom.online.account.kernel.as.b(e);
        }
        return pVarB;
    }

    public static com.unicom.online.account.kernel.p b(java.lang.String str, int i, android.net.Network network) throws java.lang.Exception {
        java.net.Socket socket;
        com.unicom.online.account.kernel.bi biVarB = com.unicom.online.account.kernel.bi.b();
        boolean zVerify = true;
        javax.net.ssl.TrustManager[] trustManagerArr = {new com.unicom.online.account.kernel.n(str)};
        javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagerArr, new java.security.SecureRandom());
        javax.net.ssl.SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        if (network != null) {
            socket = network.getSocketFactory().createSocket();
        } else {
            socket = new java.net.Socket();
        }
        try {
            socket.setTcpNoDelay(true);
            socket.setKeepAlive(true);
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
        socket.connect(new java.net.InetSocketAddress(str, i), biVarB.b + biVarB.c);
        javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) socketFactory.createSocket(socket, str, i, true);
        sSLSocket.setEnabledProtocols(f);
        sSLSocket.setSoTimeout(biVarB.d);
        try {
            sSLSocket.startHandshake();
            sSLSocket.setSoTimeout(biVarB.e);
            javax.net.ssl.SSLSession session = sSLSocket.getSession();
            if (android.text.TextUtils.isEmpty(str) || session == null) {
                zVerify = false;
            } else {
                try {
                    if (!com.unicom.online.account.kernel.ao.b(str, ((java.security.cert.X509Certificate) session.getPeerCertificates()[0]).getSubjectDN().getName())) {
                        zVerify = javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier().verify(str, session);
                    }
                } catch (javax.net.ssl.SSLPeerUnverifiedException e2) {
                    com.unicom.online.account.kernel.as.b(e2);
                    zVerify = false;
                } catch (java.lang.Exception e3) {
                    com.unicom.online.account.kernel.as.b(e3);
                    zVerify = false;
                }
            }
            if (!zVerify) {
                com.unicom.online.account.kernel.ao.v = "主机名验证失败: " + str;
                try {
                    sSLSocket.close();
                } catch (java.lang.Exception unused) {
                }
                return null;
            }
            return new com.unicom.online.account.kernel.p(sSLSocket);
        } catch (java.lang.Exception e4) {
            com.unicom.online.account.kernel.as.b(e4);
            com.unicom.online.account.kernel.ao.v = "createSSLSocket: " + e4.getMessage();
            try {
                sSLSocket.close();
            } catch (java.lang.Exception unused2) {
            }
            throw e4;
        }
    }

    public final void c() {
        b();
        java.util.concurrent.ExecutorService executorService = this.b;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        this.b.shutdown();
        try {
            if (this.b.awaitTermination(1L, java.util.concurrent.TimeUnit.SECONDS)) {
                return;
            }
            this.b.shutdownNow();
        } catch (java.lang.InterruptedException unused) {
            this.b.shutdownNow();
            java.lang.Thread.currentThread().interrupt();
        }
    }

    public final void b() {
        for (java.util.Map.Entry entry : this.c.entrySet()) {
            com.unicom.online.account.kernel.p pVar = (com.unicom.online.account.kernel.p) entry.getValue();
            if (pVar != null) {
                try {
                    if (!pVar.b.isClosed()) {
                        pVar.b.close();
                    }
                } catch (java.io.IOException e) {
                    java.lang.String[] strArrSplit = ((java.lang.String) entry.getKey()).split(":");
                    java.lang.String str = strArrSplit[0];
                    if (strArrSplit.length > 1) {
                        java.lang.String str2 = strArrSplit[1];
                    }
                    e.getMessage();
                }
            }
        }
        this.c.clear();
        this.d.clear();
        this.e.clear();
    }
}
