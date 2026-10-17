package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class p implements com.zx.a.I8b7.u0 {
    @Override // com.zx.a.I8b7.u0
    public com.zx.a.I8b7.b2 a(com.zx.a.I8b7.u0.a aVar) throws java.io.IOException {
        com.zx.a.I8b7.r1 r1Var = (com.zx.a.I8b7.r1) aVar;
        com.zx.a.I8b7.y1 y1Var = r1Var.c;
        java.net.HttpURLConnection httpURLConnection = r1Var.d;
        if (httpURLConnection.getDoOutput() && y1Var.d != null) {
            java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
            com.zx.a.I8b7.z1 z1Var = (com.zx.a.I8b7.z1) y1Var.d;
            outputStream.write(z1Var.c, z1Var.d, z1Var.b);
            com.zx.a.I8b7.m2.a(outputStream);
        }
        int responseCode = httpURLConnection.getResponseCode();
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = httpURLConnection.getHeaderFields();
        com.zx.a.I8b7.e1 e1VarB = com.zx.a.I8b7.e1.b("text/json; charset=utf-8");
        if (httpURLConnection.getContentType() != null) {
            e1VarB = com.zx.a.I8b7.e1.b(httpURLConnection.getContentType());
        }
        java.lang.String responseMessage = httpURLConnection.getResponseMessage();
        com.zx.a.I8b7.b2.a aVar2 = new com.zx.a.I8b7.b2.a();
        aVar2.b = responseCode;
        aVar2.d = new java.util.HashMap(headerFields);
        aVar2.c = responseMessage;
        aVar2.e = com.zx.a.I8b7.c2.a(e1VarB, httpURLConnection.getContentLength(), responseCode == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream());
        aVar2.a = y1Var;
        return aVar2.a();
    }
}
