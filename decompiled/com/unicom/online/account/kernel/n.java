package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class n implements javax.net.ssl.X509TrustManager {
    public final /* synthetic */ java.lang.String b;

    public n(java.lang.String str) {
        this.b = str;
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) {
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            com.unicom.online.account.kernel.ao.v = "服务器证书链为空";
            throw new java.lang.IllegalArgumentException("服务器证书链为空");
        }
        try {
            java.lang.String name = x509CertificateArr[0].getSubjectDN().getName();
            if (com.unicom.online.account.kernel.ao.b(this.b, name)) {
                return;
            }
            com.unicom.online.account.kernel.ao.v = "自定义证书校验失败，将使用默认校验逻辑: domain=" + this.b + ", subjectName=" + name;
        } catch (java.lang.Exception e) {
            com.unicom.online.account.kernel.as.b(e);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public final java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return new java.security.cert.X509Certificate[0];
    }
}
