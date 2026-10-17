package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class y2 implements javax.net.ssl.HostnameVerifier {
    public static final com.zx.a.I8b7.y2 a = new com.zx.a.I8b7.y2();
    public static final java.util.regex.Pattern b = java.util.regex.Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* JADX WARN: Removed duplicated region for block: B:61:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r10, java.security.cert.X509Certificate r11) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.y2.a(java.lang.String, java.security.cert.X509Certificate):boolean");
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
        try {
            return a(str, (java.security.cert.X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (javax.net.ssl.SSLException unused) {
            return false;
        }
    }

    public static java.util.List<java.lang.String> a(java.security.cert.X509Certificate x509Certificate, int i) {
        java.lang.Integer num;
        java.lang.String str;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.util.Collection<java.util.List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return java.util.Collections.emptyList();
            }
            for (java.util.List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (java.lang.Integer) list.get(0)) != null && num.intValue() == i && (str = (java.lang.String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (java.security.cert.CertificateParsingException unused) {
            return java.util.Collections.emptyList();
        }
    }
}
