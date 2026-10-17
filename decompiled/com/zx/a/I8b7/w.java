package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class w {
    public static final java.security.SecureRandom a = new java.security.SecureRandom();

    public static byte[] a(java.lang.String str, javax.crypto.SecretKey secretKey, javax.crypto.spec.IvParameterSpec ivParameterSpec, byte[] bArr) throws javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(2, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    public static byte[] b(java.lang.String str, javax.crypto.SecretKey secretKey, javax.crypto.spec.IvParameterSpec ivParameterSpec, byte[] bArr) throws javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(1, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    public static java.lang.String c(java.lang.String str, java.lang.String str2) throws javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, java.security.spec.InvalidKeySpecException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str2, 0))));
        return a(cipher.doFinal(str.getBytes(java.nio.charset.StandardCharsets.UTF_8)));
    }

    public static java.lang.String d(java.lang.String str, java.lang.String str2) throws javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, java.security.spec.InvalidKeySpecException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        byte[] bArrDoFinal;
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str2, 0))));
            byte[] bytes = str.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            int length = bytes.length;
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length - i;
                if (i3 > 0) {
                    if (i3 > 117) {
                        bArrDoFinal = cipher.doFinal(bytes, i, 117);
                    } else {
                        bArrDoFinal = cipher.doFinal(bytes, i, i3);
                    }
                    byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                    i2++;
                    i = i2 * 117;
                } else {
                    java.lang.String str3 = new java.lang.String(android.util.Base64.encode(byteArrayOutputStream.toByteArray(), 2), java.nio.charset.StandardCharsets.UTF_8);
                    try {
                        byteArrayOutputStream.close();
                        return str3;
                    } catch (java.lang.Throwable unused) {
                        return str3;
                    }
                }
            }
        } catch (java.lang.Throwable unused2) {
            return "";
        }
    }

    public static java.lang.String a(java.lang.String str, byte[] bArr) throws java.security.NoSuchAlgorithmException {
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
        messageDigest.update(bArr);
        return a(messageDigest.digest());
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(str2, str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        } catch (java.security.NoSuchAlgorithmException e) {
            com.zx.a.I8b7.c3.a(e);
            return "";
        }
    }

    public static java.lang.String a(java.lang.String str, boolean z) throws java.lang.Throwable {
        if (!z) {
            str = a("MD5", str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        }
        java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a(str);
        sbA.append(com.zx.a.I8b7.x3.h);
        byte[] bytes = sbA.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8);
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA256");
        messageDigest.update(bytes);
        java.lang.String strA = a(messageDigest.digest());
        return strA.substring(0, 16) + strA.substring(strA.length() - 16);
    }

    public static javax.crypto.SecretKey b(byte[] bArr, java.lang.String str) {
        try {
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA256");
            mac.init(new javax.crypto.spec.SecretKeySpec(str.getBytes(java.nio.charset.StandardCharsets.UTF_8), "HmacSHA256"));
            return new javax.crypto.spec.SecretKeySpec(mac.doFinal(bArr), "AES");
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.c3.a(e);
            return null;
        }
    }

    public static byte[] a(java.lang.String str, javax.crypto.SecretKey secretKey, java.lang.String str2) throws java.lang.Exception {
        byte[] bArr = new byte[12];
        a.nextBytes(bArr);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKey, new javax.crypto.spec.GCMParameterSpec(128, bArr));
        cipher.updateAAD(str2.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        byte[] bArrDoFinal = cipher.doFinal(str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(bArrDoFinal.length + 12);
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.put(bArrDoFinal);
        return byteBufferAllocate.array();
    }

    public static java.lang.String a(byte[] bArr, javax.crypto.SecretKey secretKey, java.lang.String str) throws java.lang.Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, secretKey, new javax.crypto.spec.GCMParameterSpec(128, bArr, 0, 12));
        cipher.updateAAD(str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        return new java.lang.String(cipher.doFinal(bArr, 12, bArr.length - 12), java.nio.charset.StandardCharsets.UTF_8);
    }

    public static javax.crypto.SecretKey a(byte[] bArr, java.lang.String str) {
        try {
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA256");
            mac.init(new javax.crypto.spec.SecretKeySpec(str.getBytes(java.nio.charset.StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] bArr2 = new byte[16];
            java.lang.System.arraycopy(mac.doFinal(bArr), 0, bArr2, 0, 16);
            return new javax.crypto.spec.SecretKeySpec(bArr2, "AES");
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.c3.a(e);
            return null;
        }
    }

    public static byte[] a(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str2.getBytes("UTF-8"), "HmacSHA1");
        javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
        mac.init(secretKeySpec);
        return mac.doFinal(str.getBytes("UTF-8"));
    }

    public static java.lang.String a(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = bArr[i];
            if (i2 < 0) {
                i2 += 256;
            }
            if (i2 < 16) {
                sb.append("0");
            }
            sb.append(java.lang.Integer.toHexString(i2));
        }
        return sb.toString();
    }

    public static byte[] a(java.lang.String str) {
        if (str != null && !str.trim().equals("")) {
            byte[] bArr = new byte[str.length() / 2];
            for (int i = 0; i < str.length() / 2; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) java.lang.Integer.parseInt(str.substring(i2, i2 + 2), 16);
            }
            return bArr;
        }
        return new byte[0];
    }
}
