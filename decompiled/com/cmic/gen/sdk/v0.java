package com.cmic.gen.sdk;

/* JADX INFO: compiled from: RSAUtil.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class v0 {
    private static final java.lang.String d = "v0";
    private static com.cmic.gen.sdk.v0 e;
    private java.security.PublicKey a = null;
    private java.security.PublicKey b = null;
    private java.security.PublicKey c = null;

    private v0() {
        try {
            c();
            if (this.b == null) {
                b();
            }
            if (this.c == null) {
                a();
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public static com.cmic.gen.sdk.v0 d() {
        if (e == null) {
            e = new com.cmic.gen.sdk.v0();
        }
        return e;
    }

    public java.lang.String a(byte[] bArr) {
        if (this.a == null) {
            com.cmic.gen.sdk.h0.b(d, "mServerPublicKey == null");
            return null;
        }
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
            cipher.init(1, this.b);
            return android.util.Base64.encodeToString(cipher.doFinal(bArr), 0);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public java.lang.String b(byte[] bArr) {
        if (this.c == null) {
            com.cmic.gen.sdk.h0.b(d, "mJSServerPublicKey == null");
            return "";
        }
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
            cipher.init(1, this.c);
            return android.util.Base64.encodeToString(cipher.doFinal(bArr), 2);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public java.lang.String c(byte[] bArr) {
        if (this.a == null) {
            com.cmic.gen.sdk.h0.b(d, "mServerPublicKey == null");
            return "";
        }
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
            cipher.init(1, this.a);
            return com.cmic.gen.sdk.x1.a(cipher.doFinal(bArr));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void a() throws java.lang.Exception {
        try {
            this.c = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkzi87lcyX1t/OSjlmjmj\nUFTAb0Y0wPZ79j10sjVrDtV+lMZXz/hOalITFyXRpmS8g8I1H3AlhihQQsierIFa\nQj5omUsXhzvNO+4DorkMJ14n1o1sfL0iOLTrzydghuUpyspj0M8v5bJTBbLv8DGM\nreKtJ8sbIYC5aj8pAdxn+YTnZ4Rhp/pNRbmIAlxs4Btu3whJt/RTfEASgsDRaTgO\nr9Rlj2YDiyEM4T3d0LsLjNed7B0Ogulzj6OzvHj+foIyb+YEEn6C5F9r+uNY2l2i\nYlHfaizd1HKfISrcAseJu6lGKRP0I3mv538Twqg1u0DFV6waQ9gwgOhq4ORCiNpd\nIQIDAQAB", 0)));
        } catch (java.lang.NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    private void b() throws java.lang.Exception {
        try {
            this.b = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuyqBGJVxu+5Z2ZwItIhl\noxI53CVpYUR3OWAQyAQNcMhDDf3nGsxLLHP8kGWqrpLn1uAIgI+EIAl0sM+i1leD\nFD+sYU2rkUVZgpwO7ly+THBFw/YcZNwS094NBdhzxmCCFbCKHVNzDLirlV9T2q4k\nJhjaEmyCOtSU6+mdjcHhbcbF6lKYx8tfQlpPmyM5suFY138qtEoB4b+q/j8q22MI\naUotg1Av257RuMh97hAwoi5D7HS5LH0piLIN/au/X08rxbXnWNdgQtFtUeCNy3vw\nkO0ykg5qH942X8poQ+a9GgBUeDBpY4GSIv6/qq+zJxiJxpoL0SGKAP3FlcuLr07f\nxwIDAQAB", 0)));
        } catch (java.lang.NullPointerException unused) {
            throw new java.lang.Exception("公钥输入流为空");
        }
    }

    private void c() throws java.lang.Exception {
        try {
            this.a = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNFGdEpQ1d8cPqekvvEDQyBGnI\nKwvjX9o3OmnnqWMGbIiFYIpc21QeG7aqizuWdXlgS5M9rstDfHQfG/AaPElJ7Yix\nBCau4hdVwFpRmb9NIuqavDeHKP9BKPZ01Ra5/666NGKBqmkRRer3lBCe6EKNUc2U\n/DZg6U/Q3CTPiORt/wIDAQAB", 0)));
        } catch (java.lang.NullPointerException e2) {
            e2.printStackTrace();
        }
    }
}
