package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class v implements com.zx.a.I8b7.u0 {
    public final com.zx.a.I8b7.z2 a;

    public v(com.zx.a.I8b7.z2 z2Var) {
        this.a = z2Var;
    }

    @Override // com.zx.a.I8b7.u0
    public com.zx.a.I8b7.b2 a(com.zx.a.I8b7.u0.a aVar) throws java.io.IOException {
        com.zx.a.I8b7.r1 r1Var = (com.zx.a.I8b7.r1) aVar;
        com.zx.a.I8b7.y1 y1Var = r1Var.c;
        java.net.HttpURLConnection httpURLConnection = r1Var.d;
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(y1Var.d != null);
        httpURLConnection.setConnectTimeout(this.a.f);
        httpURLConnection.setReadTimeout(this.a.g);
        httpURLConnection.setInstanceFollowRedirects(this.a.e);
        this.a.getClass();
        httpURLConnection.setUseCaches(false);
        if ("https".equalsIgnoreCase(y1Var.a.getProtocol())) {
            javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) httpURLConnection;
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.a.c;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            }
            javax.net.ssl.HostnameVerifier hostnameVerifier = this.a.d;
            if (hostnameVerifier != null) {
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            }
        }
        java.util.Map<java.lang.String, java.lang.String> map = y1Var.c;
        if (map != null && map.size() > 0) {
            for (java.lang.String str : map.keySet()) {
                httpURLConnection.setRequestProperty(str, map.get(str));
            }
        }
        httpURLConnection.connect();
        return r1Var.a(y1Var, httpURLConnection);
    }
}
