package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class ah implements javax.net.ssl.HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
        if (!android.text.TextUtils.isEmpty(str) && sSLSession != null) {
            try {
                if (com.unicom.online.account.kernel.ao.b(str, ((java.security.cert.X509Certificate) sSLSession.getPeerCertificates()[0]).getSubjectDN().getName())) {
                    return true;
                }
                return javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
            } catch (javax.net.ssl.SSLPeerUnverifiedException e) {
                com.unicom.online.account.kernel.as.b(e);
            }
        }
        return false;
    }
}
