package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class ag {
    public static final java.nio.charset.Charset b = java.nio.charset.Charset.forName("UTF-8");
    public static final java.lang.String c = "Mozilla/5.0 (Linux; Android " + android.os.Build.VERSION.RELEASE + ") UnicomApp";

    public static com.unicom.online.account.kernel.af b(com.unicom.online.account.kernel.p pVar, java.lang.String str, java.util.HashMap map, java.lang.String str2) throws com.unicom.online.account.kernel.ae, java.io.IOException {
        boolean z;
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("请求URL不能为空");
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            try {
                str2 = new java.net.URL(str).getHost();
            } catch (java.lang.Exception e) {
                throw new java.lang.IllegalArgumentException("无法从URL中提取域名", e);
            }
        }
        javax.net.ssl.SSLSocket sSLSocket = pVar.b;
        com.unicom.online.account.kernel.af afVar = new com.unicom.online.account.kernel.af();
        try {
            sSLSocket.setSoTimeout(com.unicom.online.account.kernel.bi.b().e);
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
        try {
            java.lang.String path = new java.net.URL(str).getPath();
            java.lang.String query = new java.net.URL(str).getQuery();
            if (query != null && !query.isEmpty()) {
                path = path + "?" + query;
            }
            if (android.text.TextUtils.isEmpty(path)) {
                path = "/";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("GET ");
            sb.append(path);
            sb.append(" HTTP/1.1\r\n");
            sb.append("Host: ");
            sb.append(str2);
            sb.append("\r\n");
            sb.append("Connection: close\r\n");
            java.util.Iterator it = map.entrySet().iterator();
            boolean z2 = false;
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                if ("user-agent".equalsIgnoreCase((java.lang.String) ((java.util.Map.Entry) it.next()).getKey())) {
                    z2 = true;
                }
            }
            if (!z2) {
                sb.append("User-Agent: ");
                sb.append(c);
                sb.append("\r\n");
            }
            for (java.util.Map.Entry entry : map.entrySet()) {
                sb.append((java.lang.String) entry.getKey());
                sb.append(": ");
                sb.append((java.lang.String) entry.getValue());
                sb.append("\r\n");
            }
            sb.append("\r\n");
            java.io.OutputStream outputStream = sSLSocket.getOutputStream();
            java.nio.charset.Charset charset = b;
            java.io.PrintWriter printWriter = new java.io.PrintWriter(new java.io.OutputStreamWriter(outputStream, charset));
            printWriter.print(sb.toString());
            printWriter.flush();
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(sSLSocket.getInputStream(), charset));
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            java.util.HashMap map2 = new java.util.HashMap();
            java.lang.String str3 = null;
            java.lang.String str4 = null;
            int i = 0;
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    afVar.b = i;
                    afVar.c = sb2.toString().trim();
                    afVar.d = str3;
                    afVar.e = map2;
                    return afVar;
                }
                if (!z) {
                    sb2.append(line);
                    sb2.append("\n");
                } else if (str4 == null) {
                    if (line.startsWith("HTTP/1.") && line.length() > 12) {
                        try {
                            i = java.lang.Integer.parseInt(line.substring(9, 12));
                        } catch (java.lang.NumberFormatException unused) {
                        }
                    }
                    str4 = line;
                } else if (line.isEmpty()) {
                    z = false;
                } else {
                    int iIndexOf = line.indexOf(58);
                    if (iIndexOf > 0) {
                        java.lang.String lowerCase = line.substring(0, iIndexOf).trim().toLowerCase();
                        java.lang.String strTrim = line.substring(iIndexOf + 1).trim();
                        map2.put(lowerCase, strTrim);
                        if ("location".equals(lowerCase)) {
                            str3 = strTrim;
                        }
                    }
                }
            }
        } catch (java.io.IOException e3) {
            com.unicom.online.account.kernel.as.b(e3);
            e3.getMessage();
            com.unicom.online.account.kernel.ao.v = "GET请求IO异常: " + e3.getMessage();
            throw new java.io.IOException("HTTP请求IO异常: " + e3.getMessage(), e3);
        } catch (java.lang.Exception e4) {
            com.unicom.online.account.kernel.as.b(e4);
            e4.getMessage();
            com.unicom.online.account.kernel.ao.v = "GET请求异常: " + e4.getMessage();
            throw new com.unicom.online.account.kernel.ae("HTTP请求异常: " + e4.getMessage(), e4);
        }
    }
}
