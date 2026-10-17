package com.igexin.push.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class s {
    public static final java.lang.String a = "com.igexin.push.g.s";
    public static final java.lang.String b = "utf-8";
    private static final java.lang.String c = "POST";
    private static final java.lang.String d = "GET";
    private static final java.lang.String e = "GETUI";
    private static final int f = 30000;

    private static java.lang.String a(java.io.InputStream inputStream, java.lang.String str) throws java.lang.Exception {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, str));
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            char[] cArr = new char[256];
            while (true) {
                int i = bufferedReader.read(cArr);
                if (i <= 0) {
                    break;
                }
                stringWriter.write(cArr, 0, i);
            }
            return stringWriter.toString();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static java.lang.String a(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            java.lang.String[] strArrSplit = str.split(";");
            int length = strArrSplit.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                java.lang.String strTrim = strArrSplit[i].trim();
                if (strTrim.startsWith("charset")) {
                    java.lang.String[] strArrSplit2 = strTrim.split("=", 2);
                    if (strArrSplit2.length == 2 && !android.text.TextUtils.isEmpty(strArrSplit2[1])) {
                        return strArrSplit2[1].trim();
                    }
                } else {
                    i++;
                }
            }
        }
        return b;
    }

    private static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) throws java.lang.Exception {
        if (map == null || map.isEmpty()) {
            return null;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = b;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = false;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.String value = entry.getValue();
            if (!android.text.TextUtils.isEmpty(key) && !android.text.TextUtils.isEmpty(value)) {
                if (z) {
                    sb.append("&");
                } else {
                    z = true;
                }
                sb.append(key);
                sb.append("=");
                sb.append(java.net.URLEncoder.encode(value, str));
            }
        }
        return sb.toString();
    }

    private static java.net.HttpURLConnection a(java.net.URL url, java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(f);
        httpURLConnection.setReadTimeout(f);
        httpURLConnection.setRequestProperty("User-Agent", e);
        httpURLConnection.setRequestProperty("Content-Type", str2);
        httpURLConnection.setRequestProperty("HOST", url.getHost() + ":" + url.getPort());
        return httpURLConnection;
    }

    private static java.net.URL a(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.lang.String str3;
        java.lang.StringBuilder sb;
        java.lang.StringBuilder sb2;
        java.lang.String string;
        java.net.URL url = new java.net.URL(str);
        if (android.text.TextUtils.isEmpty(str2)) {
            return url;
        }
        if (android.text.TextUtils.isEmpty(url.getQuery())) {
            str3 = "?";
            if (str.endsWith("?")) {
                sb2 = new java.lang.StringBuilder();
                sb2.append(str);
                sb2.append(str2);
                string = sb2.toString();
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append(str3);
                sb.append(str2);
                string = sb.toString();
            }
        } else {
            str3 = "&";
            if (str.endsWith("&")) {
                sb2 = new java.lang.StringBuilder();
                sb2.append(str);
                sb2.append(str2);
                string = sb2.toString();
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append(str3);
                sb.append(str2);
                string = sb.toString();
            }
        }
        return new java.net.URL(string);
    }

    private static java.net.URL a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2) throws java.lang.Exception {
        return a(str, a(map, str2));
    }

    private static byte[] a(java.io.InputStream inputStream) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        java.io.BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new java.io.BufferedInputStream(inputStream);
            try {
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream(1024);
                    bArr = new byte[1024];
                } catch (java.lang.Exception e2) {
                    e = e2;
                    com.igexin.c.a.c.a.a(e);
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (java.io.IOException e3) {
                            com.igexin.c.a.c.a.a(e3);
                        }
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            bufferedInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        while (true) {
            int i = bufferedInputStream.read(bArr);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
            th = th;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (java.io.IOException e5) {
                    com.igexin.c.a.c.a.a(e5);
                }
            }
            throw th;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            bufferedInputStream.close();
        } catch (java.io.IOException e6) {
            com.igexin.c.a.c.a.a(e6);
        }
        return byteArray;
    }

    private static byte[] a(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.io.IOException {
        return ("Content-Disposition:form-data;name=\"" + str + "\"\r\nContent-Type:text/plain\r\n\r\n" + str2).getBytes(str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] a(java.lang.String r2, java.lang.String r3, byte[] r4, int r5, int r6) throws java.lang.Exception {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
            java.lang.String r2 = "POST"
            java.net.HttpURLConnection r2 = a(r1, r2, r3)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
            r2.setConnectTimeout(r5)     // Catch: java.io.IOException -> L2d java.lang.Throwable -> L38
            r2.setReadTimeout(r6)     // Catch: java.io.IOException -> L2d java.lang.Throwable -> L38
            java.io.OutputStream r0 = r2.getOutputStream()     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L38
            r0.write(r4)     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L38
            byte[] r3 = a(r2)     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L38
            if (r0 == 0) goto L22
            r0.close()
        L22:
            if (r2 == 0) goto L27
            r2.disconnect()
        L27:
            return r3
        L28:
            r3 = move-exception
            com.igexin.c.a.c.a.a(r3)     // Catch: java.lang.Throwable -> L38
            throw r3     // Catch: java.lang.Throwable -> L38
        L2d:
            r3 = move-exception
            goto L34
        L2f:
            r3 = move-exception
            r2 = r0
            goto L39
        L32:
            r3 = move-exception
            r2 = r0
        L34:
            com.igexin.c.a.c.a.a(r3)     // Catch: java.lang.Throwable -> L38
            throw r3     // Catch: java.lang.Throwable -> L38
        L38:
            r3 = move-exception
        L39:
            if (r0 == 0) goto L3e
            r0.close()
        L3e:
            if (r2 == 0) goto L43
            r2.disconnect()
        L43:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.g.s.a(java.lang.String, java.lang.String, byte[], int, int):byte[]");
    }

    private static byte[] a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i, int i2) throws java.lang.Exception {
        return a(str, map, b, i, i2);
    }

    private static byte[] a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i, int i2, java.lang.String str2) throws java.lang.Exception {
        java.net.HttpURLConnection httpURLConnectionB = b(str, map, i, i2, str2);
        try {
            try {
                return a(httpURLConnectionB);
            } catch (java.lang.Exception e2) {
                throw e2;
            }
        } finally {
            if (httpURLConnectionB != null) {
                httpURLConnectionB.disconnect();
            }
        }
    }

    private static byte[] a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2, int i, int i2) throws java.lang.Exception {
        java.lang.String strConcat = "application/x-www-form-urlencoded;charset=".concat(java.lang.String.valueOf(str2));
        java.lang.String strA = a(map, str2);
        byte[] bytes = new byte[0];
        if (strA != null) {
            bytes = strA.getBytes(str2);
        }
        return a(str, strConcat, bytes, i, i2);
    }

    private static byte[] a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, com.igexin.push.g.j> map2, int i, int i2) throws java.lang.Exception {
        return (map2 == null || map2.isEmpty()) ? a(str, map, b, i, i2) : a(str, map, map2, b, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0164 A[Catch: all -> 0x0202, Exception -> 0x0204, TryCatch #10 {Exception -> 0x0204, all -> 0x0202, blocks: (B:62:0x015b, B:75:0x0181, B:77:0x018a, B:80:0x01a6, B:82:0x01ca, B:65:0x0164, B:68:0x016d, B:71:0x0176, B:33:0x00ff, B:35:0x0105, B:38:0x0110, B:40:0x0116, B:42:0x011f, B:46:0x012a, B:48:0x0131, B:50:0x0138, B:52:0x0140, B:84:0x01d5), top: B:126:0x015b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] a(java.lang.String r18, java.util.Map<java.lang.String, java.lang.String> r19, java.util.Map<java.lang.String, com.igexin.push.g.j> r20, java.lang.String r21, int r22, int r23) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.g.s.a(java.lang.String, java.util.Map, java.util.Map, java.lang.String, int, int):byte[]");
    }

    public static byte[] a(java.lang.String str, byte[] bArr) throws java.lang.Exception {
        return a(str, "application/octet-stream", bArr, 10000, 10000);
    }

    private static byte[] a(java.net.HttpURLConnection httpURLConnection) throws java.lang.Exception {
        return httpURLConnection.getErrorStream() == null ? a(httpURLConnection.getInputStream()) : b(httpURLConnection).getBytes();
    }

    private static java.lang.String b(java.net.HttpURLConnection httpURLConnection) throws java.lang.Exception {
        java.lang.String strA = a(httpURLConnection.getErrorStream(), a(httpURLConnection.getContentType()));
        if (!android.text.TextUtils.isEmpty(strA)) {
            return strA;
        }
        throw new java.io.IOException(httpURLConnection.getResponseCode() + ":" + httpURLConnection.getResponseMessage());
    }

    private static java.net.HttpURLConnection b(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i, int i2, java.lang.String str2) throws java.lang.Exception {
        java.net.HttpURLConnection httpURLConnectionA = a(a(str, a(map, str2)), d, "application/x-www-form-urlencoded;charset=".concat(java.lang.String.valueOf(str2)));
        httpURLConnectionA.setConnectTimeout(i);
        httpURLConnectionA.setReadTimeout(i2);
        return httpURLConnectionA;
    }

    private static byte[] b(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.io.IOException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Content-Disposition:form-data;name=\"dp_data\";filename=\"");
        if (android.text.TextUtils.isEmpty(str)) {
            str = "filename";
        }
        sb.append(str);
        sb.append("\"\r\nContent-Type:");
        sb.append(str2);
        sb.append("\r\n\r\n");
        return sb.toString().getBytes(str3);
    }

    private static byte[] b(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i, int i2) throws java.lang.Exception {
        return a(str, map, i, i2, b);
    }

    private static byte[] c(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i, int i2) throws java.lang.Exception {
        java.net.HttpURLConnection httpURLConnectionB = b(str, map, i, i2, b);
        try {
            try {
                return a(httpURLConnectionB);
            } catch (java.lang.Exception e2) {
                throw e2;
            }
        } finally {
            if (httpURLConnectionB != null) {
                httpURLConnectionB.disconnect();
            }
        }
    }
}
