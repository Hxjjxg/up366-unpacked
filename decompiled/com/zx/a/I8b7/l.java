package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class l implements java.lang.Runnable {

    public class a implements com.zx.a.I8b7.x2.b {
        public a(com.zx.a.I8b7.l lVar) {
        }

        @Override // com.zx.a.I8b7.x2.b
        public void a() {
        }

        @Override // com.zx.a.I8b7.x2.b
        public void a(int i, java.lang.String str) {
        }

        @Override // com.zx.a.I8b7.x2.b
        public void a(android.net.Network network) {
            try {
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) network.openConnection(new java.net.URL("https://zxid-m.mobileservice.cn/sdk/ext/pconfig"));
                com.zx.a.I8b7.p0.a(httpURLConnection);
                byte[] bArr = new byte[16];
                new java.security.SecureRandom().nextBytes(bArr);
                com.zx.a.I8b7.w.b(bArr, com.zx.a.I8b7.x3.a(com.zx.a.I8b7.x3.h));
                java.util.HashMap<java.lang.String, java.lang.String> mapB = com.zx.a.I8b7.p0.b(new java.lang.String(android.util.Base64.encode(bArr, 2), java.nio.charset.StandardCharsets.UTF_8));
                httpURLConnection.setRequestMethod("POST");
                for (java.lang.String str : mapB.keySet()) {
                    httpURLConnection.setRequestProperty(str, mapB.get(str));
                }
                httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.connect();
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(jSONObject.toString());
                bufferedWriter.close();
                com.zx.a.I8b7.c3.a(com.zx.a.I8b7.c2.a(com.zx.a.I8b7.e1.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b());
                httpURLConnection.disconnect();
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.c3.a(th.getMessage());
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.x2.c.a.a(new com.zx.a.I8b7.l.a(this));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }
}
