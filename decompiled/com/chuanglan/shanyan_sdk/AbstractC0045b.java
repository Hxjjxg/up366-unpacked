package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class AbstractC0045b {
    public static java.lang.String a(java.util.Map map, java.lang.String str) {
        java.util.TreeSet<java.lang.String> treeSet = new java.util.TreeSet(map.keySet());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : treeSet) {
            if (!"i7".equals(str2)) {
                sb.append(str2);
                sb.append(map.get(str2));
            }
        }
        com.chuanglan.shanyan_sdk.Q.c("ProcessShanYanLogger", "getSign stringSet", sb.toString());
        return a(sb.toString(), str);
    }

    public static java.lang.String b(java.lang.String str) {
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(str)) {
            return "";
        }
        try {
            java.lang.String str2 = "";
            for (byte b : java.security.MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str2.getBytes("UTF-8"), "HmacSHA1");
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            return com.chuanglan.shanyan_sdk.AbstractC0054k.a(mac.doFinal(str.getBytes("UTF-8")));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0035 -> B:61:0x0038). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(java.lang.String r4) throws java.lang.Throwable {
        /*
            boolean r0 = com.chuanglan.shanyan_sdk.AbstractC0049f.a(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            r0.<init>()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L26
            r2.<init>(r0)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L26
            java.lang.String r3 = "UTF-8"
            byte[] r4 = r4.getBytes(r3)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            r2.write(r4)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            r2.close()     // Catch: java.io.IOException -> L34
            goto L38
        L1f:
            r4 = move-exception
            goto L6d
        L21:
            r4 = move-exception
            goto L2b
        L23:
            r4 = move-exception
            r2 = r1
            goto L2b
        L26:
            r4 = move-exception
            goto L6c
        L28:
            r4 = move-exception
            r0 = r1
            r2 = r0
        L2b:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L6a
            if (r2 == 0) goto L38
            r2.close()     // Catch: java.io.IOException -> L34
            goto L38
        L34:
            r4 = move-exception
            r4.printStackTrace()
        L38:
            byte[] r4 = r0.toByteArray()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            r0.flush()     // Catch: java.io.IOException -> L43
            r0.close()     // Catch: java.io.IOException -> L43
            goto L47
        L43:
            r0 = move-exception
            r0.printStackTrace()
        L47:
            return r4
        L48:
            r4 = move-exception
            goto L5c
        L4a:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L48
            if (r0 == 0) goto L5b
            r0.flush()     // Catch: java.io.IOException -> L57
            r0.close()     // Catch: java.io.IOException -> L57
            goto L5b
        L57:
            r4 = move-exception
            r4.printStackTrace()
        L5b:
            return r1
        L5c:
            if (r0 == 0) goto L69
            r0.flush()     // Catch: java.io.IOException -> L65
            r0.close()     // Catch: java.io.IOException -> L65
            goto L69
        L65:
            r0 = move-exception
            r0.printStackTrace()
        L69:
            throw r4
        L6a:
            r4 = move-exception
            r1 = r2
        L6c:
            r2 = r1
        L6d:
            if (r2 == 0) goto L77
            r2.close()     // Catch: java.io.IOException -> L73
            goto L77
        L73:
            r0 = move-exception
            r0.printStackTrace()
        L77:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuanglan.shanyan_sdk.AbstractC0045b.a(java.lang.String):byte[]");
    }

    public static org.json.JSONArray b(java.util.List list) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        for (int i = 0; i < list.size(); i++) {
            com.chuanglan.shanyan_sdk.C0069z c0069z = (com.chuanglan.shanyan_sdk.C0069z) list.get(i);
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            try {
                jSONArray2.put(c0069z.a);
                jSONArray2.put(c0069z.b);
                jSONArray2.put(c0069z.c);
                jSONArray2.put(c0069z.d);
                jSONArray2.put(c0069z.e);
                jSONArray.put(jSONArray2);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return jSONArray;
    }

    public static org.json.JSONArray a(java.util.List list) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        com.chuanglan.shanyan_sdk.C0068y c0068y = (com.chuanglan.shanyan_sdk.C0068y) list.get(0);
        for (int i = 0; i < list.size(); i++) {
            com.chuanglan.shanyan_sdk.C0068y c0068y2 = (com.chuanglan.shanyan_sdk.C0068y) list.get(i);
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            if (i == 0) {
                try {
                    jSONArray2.put(c0068y2.a);
                    jSONArray2.put(c0068y2.b);
                    jSONArray2.put(c0068y2.c);
                    jSONArray2.put(c0068y2.d);
                    jSONArray2.put(c0068y2.e);
                    jSONArray2.put(c0068y2.f);
                    jSONArray2.put(c0068y2.g);
                    jSONArray2.put(c0068y2.h);
                    jSONArray2.put(c0068y2.i);
                    jSONArray2.put(c0068y2.j);
                    jSONArray2.put(c0068y2.k);
                    jSONArray2.put(c0068y2.l);
                    jSONArray2.put(c0068y2.m);
                    jSONArray2.put(c0068y2.n);
                    jSONArray2.put(c0068y2.o);
                    jSONArray2.put(c0068y2.p);
                    jSONArray2.put(c0068y2.q);
                    jSONArray2.put(c0068y2.r);
                    jSONArray2.put(c0068y2.s);
                    jSONArray2.put(c0068y2.t);
                    jSONArray2.put(c0068y2.u);
                    jSONArray2.put(c0068y2.v);
                    jSONArray2.put(c0068y2.w);
                    jSONArray2.put(c0068y2.x);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            } else {
                if (java.util.Objects.equals(c0068y.a, c0068y2.a)) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(c0068y2.a);
                }
                if (java.util.Objects.equals(c0068y.b, c0068y2.b)) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(c0068y2.b);
                }
                int i2 = c0068y.c;
                int i3 = c0068y2.c;
                if (i2 == i3) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(i3);
                }
                jSONArray2.put("@");
                jSONArray2.put("@");
                jSONArray2.put("@");
                jSONArray2.put("@");
                if (java.util.Objects.equals(c0068y.h, c0068y2.h)) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(c0068y2.h);
                }
                if (java.util.Objects.equals(c0068y.i, c0068y2.i)) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(c0068y2.i);
                }
                if (java.util.Objects.equals(c0068y.j, c0068y2.j)) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(c0068y2.j);
                }
                if (java.util.Objects.equals(c0068y.k, c0068y2.k)) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(c0068y2.k);
                }
                if (java.util.Objects.equals(c0068y.l, c0068y2.l)) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(c0068y2.l);
                }
                int i4 = c0068y.m;
                int i5 = c0068y2.m;
                if (i4 == i5) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(i5);
                }
                int i6 = c0068y.n;
                int i7 = c0068y2.n;
                if (i6 == i7) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(i7);
                }
                jSONArray2.put(c0068y2.o);
                jSONArray2.put(c0068y2.p);
                jSONArray2.put(c0068y2.q);
                int i8 = c0068y.r;
                int i9 = c0068y2.r;
                if (i8 == i9) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(i9);
                }
                int i10 = c0068y.s;
                int i11 = c0068y2.s;
                if (i10 == i11) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(i11);
                }
                if (java.util.Objects.equals(c0068y.t, c0068y2.t)) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(c0068y2.t);
                }
                int i12 = c0068y.u;
                int i13 = c0068y2.u;
                if (i12 == i13) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(i13);
                }
                if (java.util.Objects.equals(c0068y.v, c0068y2.v)) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(c0068y2.v);
                }
                int i14 = c0068y.w;
                int i15 = c0068y2.w;
                if (i14 == i15) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(i15);
                }
                if (java.util.Objects.equals(c0068y.x, c0068y2.x)) {
                    jSONArray2.put("@");
                } else {
                    jSONArray2.put(c0068y2.x);
                }
            }
            jSONArray.put(jSONArray2);
        }
        return jSONArray;
    }

    public static byte[] a(byte[] bArr, java.lang.String str, java.lang.String str2) {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new javax.crypto.spec.SecretKeySpec(str.getBytes(), "AES"), new javax.crypto.spec.IvParameterSpec(str2.getBytes()));
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
