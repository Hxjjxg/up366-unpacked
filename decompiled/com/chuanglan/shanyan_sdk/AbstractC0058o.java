package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
abstract class AbstractC0058o {
    private java.lang.String a;
    private java.util.Map b;
    private android.content.Context c;

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.o$a */
    private static class a extends javax.net.ssl.SSLSocketFactory {
        private static final java.lang.String[] b = {"TLSv1.2"};
        private final javax.net.ssl.SSLSocketFactory a;

        a(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
            this.a = sSLSocketFactory;
        }

        private java.net.Socket a(java.net.Socket socket) {
            if (socket instanceof javax.net.ssl.SSLSocket) {
                ((javax.net.ssl.SSLSocket) socket).setEnabledProtocols(b);
            }
            return socket;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) {
            return a(this.a.createSocket(socket, str, i, z));
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public java.lang.String[] getDefaultCipherSuites() {
            return this.a.getDefaultCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public java.lang.String[] getSupportedCipherSuites() {
            return this.a.getSupportedCipherSuites();
        }

        @Override // javax.net.SocketFactory
        public java.net.Socket createSocket(java.lang.String str, int i) {
            return a(this.a.createSocket(str, i));
        }

        @Override // javax.net.SocketFactory
        public java.net.Socket createSocket(java.lang.String str, int i, java.net.InetAddress inetAddress, int i2) {
            return a(this.a.createSocket(str, i, inetAddress, i2));
        }

        @Override // javax.net.SocketFactory
        public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i) {
            return a(this.a.createSocket(inetAddress, i));
        }

        @Override // javax.net.SocketFactory
        public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i, java.net.InetAddress inetAddress2, int i2) {
            return a(this.a.createSocket(inetAddress, i, inetAddress2, i2));
        }
    }

    AbstractC0058o(java.lang.String str, android.content.Context context) {
        this.b = null;
        this.a = str;
        this.c = context;
        this.b = new java.util.HashMap();
    }

    private static javax.net.ssl.SSLSocketFactory a() {
        try {
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return new com.chuanglan.shanyan_sdk.AbstractC0058o.a(sSLContext.getSocketFactory());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory();
        }
    }

    private byte[] b(java.util.Map map) {
        return map == null ? new byte[0] : com.chuanglan.shanyan_sdk.AbstractC0045b.a(new org.json.JSONObject(map).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x016a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0181 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(com.chuanglan.shanyan_sdk.V r7, java.util.Map r8, com.chuanglan.shanyan_sdk.AbstractC0056m r9, java.lang.Boolean r10, java.lang.String r11, int r12, int r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuanglan.shanyan_sdk.AbstractC0058o.b(com.chuanglan.shanyan_sdk.V, java.util.Map, com.chuanglan.shanyan_sdk.m, java.lang.Boolean, java.lang.String, int, int):void");
    }

    private void a(java.net.HttpURLConnection httpURLConnection) {
        for (java.util.Map.Entry entry : this.b.entrySet()) {
            httpURLConnection.setRequestProperty((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue());
        }
    }

    private void a(javax.net.ssl.HttpsURLConnection httpsURLConnection) {
        for (java.util.Map.Entry entry : this.b.entrySet()) {
            httpsURLConnection.setRequestProperty((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue());
        }
    }

    private byte[] a(java.util.Map map) {
        java.lang.String string;
        if (map == null) {
            return new byte[0];
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry entry : map.entrySet()) {
            sb.append(java.net.URLEncoder.encode((java.lang.String) entry.getKey(), com.igexin.push.g.s.b));
            sb.append("=");
            sb.append(java.net.URLEncoder.encode(java.lang.String.valueOf(entry.getValue()), com.igexin.push.g.s.b));
            sb.append("&");
        }
        if (sb.length() > 0) {
            string = sb.substring(0, sb.length() - 1);
        } else {
            string = sb.toString();
        }
        return string.getBytes("UTF-8");
    }

    void a(com.chuanglan.shanyan_sdk.V v, java.util.Map map, com.chuanglan.shanyan_sdk.AbstractC0056m abstractC0056m, java.lang.Boolean bool, java.lang.String str) throws java.lang.Throwable {
        int iMax;
        int i;
        int iIndexOf;
        int i2;
        int iA = com.chuanglan.shanyan_sdk.p0.a(this.c, "cl_jm_e6", 6);
        if (bool.booleanValue()) {
            iMax = 5000;
            i = 25000;
        } else {
            iMax = java.lang.Math.max(java.lang.Math.round(((iA * 1000) - com.chuanglan.shanyan_sdk.AbstractC0055l.z) / 2), 2000);
            i = iMax;
        }
        if (com.chuanglan.shanyan_sdk.P.b && (iIndexOf = this.a.indexOf("//")) != -1 && (i2 = iIndexOf + 4) < this.a.length()) {
            com.chuanglan.shanyan_sdk.Q.c("NetworkShanYanLogger", "test:", this.a.substring(i2));
        }
        if (this.a.startsWith("https")) {
            b(v, map, abstractC0056m, bool, str, iMax, i);
        } else {
            a(v, map, abstractC0056m, bool, str, iMax, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0147 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.chuanglan.shanyan_sdk.V r7, java.util.Map r8, com.chuanglan.shanyan_sdk.AbstractC0056m r9, java.lang.Boolean r10, java.lang.String r11, int r12, int r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuanglan.shanyan_sdk.AbstractC0058o.a(com.chuanglan.shanyan_sdk.V, java.util.Map, com.chuanglan.shanyan_sdk.m, java.lang.Boolean, java.lang.String, int, int):void");
    }
}
