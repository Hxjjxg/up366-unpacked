package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class a0 {
    public java.lang.Object a;

    public a0(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Exception {
        javax.crypto.Cipher cipherA = a();
        java.lang.Object objInvoke = java.lang.Class.class.getMethod(a(cipherA, "e9uUVEzVoVWhlVZ8sn1SxQ=="), null).invoke(com.zx.a.I8b7.a0.class, null);
        this.a = java.lang.Class.forName(a(cipherA, "xQCe3P4Nvo89QAc9u/pHAX2XPV4G/jFlxbQMn2JZQJc=")).getConstructor(java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Class.forName(a(cipherA, "BXR/YZEsZikKgydkACAIi9ZlpwlaFcVU0svFCdqK+9k="))).newInstance(str, str2, null, objInvoke);
    }

    public final javax.crypto.Cipher a() throws java.lang.Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new javax.crypto.spec.SecretKeySpec(android.util.Base64.decode("4A4l6BZlmqOanvxq+udGBw==", 2), "AES"), new javax.crypto.spec.IvParameterSpec(android.util.Base64.decode("PmwJuXddVGbC+te23VrmEA==", 2)));
        return cipher;
    }

    public java.lang.Class b() throws java.lang.Exception {
        javax.crypto.Cipher cipherA = a();
        java.lang.String strA = a(cipherA, "l4Kd4/MbY9AEp4YDnYjHmKacfKJJ9a3waN7VR+soAx/A/LcgDPs74QgTnx2q/91S");
        return (java.lang.Class) java.lang.Class.class.getMethod(a(cipherA, "zVquUq9GnBlh+JZR3JyQWw=="), java.lang.String.class, java.lang.Boolean.TYPE, java.lang.Class.forName(a(cipherA, "BXR/YZEsZikKgydkACAIi9ZlpwlaFcVU0svFCdqK+9k="))).invoke(java.lang.Class.class, strA, java.lang.Boolean.TRUE, this.a);
    }

    public final java.lang.String a(javax.crypto.Cipher cipher, java.lang.String str) throws java.lang.Exception {
        return new java.lang.String(cipher.doFinal(android.util.Base64.decode(str, 2)), "UTF-8");
    }
}
