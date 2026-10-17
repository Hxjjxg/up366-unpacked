package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class h implements com.zx.a.I8b7.u0 {
    @Override // com.zx.a.I8b7.u0
    public com.zx.a.I8b7.b2 a(com.zx.a.I8b7.u0.a aVar) throws java.io.IOException {
        boolean z;
        com.zx.a.I8b7.c2 c2Var;
        com.zx.a.I8b7.r1 r1Var = (com.zx.a.I8b7.r1) aVar;
        com.zx.a.I8b7.y1 y1Var = r1Var.c;
        com.zx.a.I8b7.y1.a aVar2 = new com.zx.a.I8b7.y1.a(y1Var);
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) y1Var.a.openConnection();
        com.zx.a.I8b7.a2 a2Var = y1Var.d;
        if (a2Var != null) {
            com.zx.a.I8b7.z1 z1Var = (com.zx.a.I8b7.z1) a2Var;
            com.zx.a.I8b7.e1 e1Var = z1Var.a;
            if (e1Var != null) {
                aVar2.c.put("Content-Type", e1Var.a);
            }
            long j = z1Var.b;
            if (j != -1) {
                aVar2.c.put("Content-Length", java.lang.Long.toString(j));
                aVar2.c.remove("Transfer-Encoding");
            } else {
                aVar2.c.put("Transfer-Encoding", "chunked");
                aVar2.c.remove("Content-Length");
            }
        }
        if (y1Var.c.get("Host") == null) {
            aVar2.c.put("Host", y1Var.a.getHost());
        }
        if (y1Var.c.get("Connection") == null) {
            aVar2.c.put("Connection", "Keep-Alive");
        }
        if (y1Var.c.get("Accept-Encoding") == null && y1Var.c.get("Range") == null) {
            aVar2.c.put("Accept-Encoding", "gzip");
            z = true;
        } else {
            z = false;
        }
        com.zx.a.I8b7.b2 b2VarA = r1Var.a(new com.zx.a.I8b7.y1(aVar2), httpURLConnection);
        com.zx.a.I8b7.b2.a aVar3 = new com.zx.a.I8b7.b2.a(b2VarA);
        aVar3.a = y1Var;
        if (z && "gzip".equalsIgnoreCase(b2VarA.a("Content-Encoding")) && (c2Var = b2VarA.e) != null) {
            aVar3.e = com.zx.a.I8b7.c2.a(((com.zx.a.I8b7.c2.a) c2Var).a, -1L, new java.util.zip.GZIPInputStream(((com.zx.a.I8b7.c2.a) b2VarA.e).c));
            aVar3.d.remove("Content-Encoding");
            aVar3.d.remove("Content-Length");
        }
        return aVar3.a();
    }
}
