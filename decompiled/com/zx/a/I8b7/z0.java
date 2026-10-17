package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class z0 implements com.zx.a.I8b7.u0 {
    public com.zx.a.I8b7.y0 a;

    public z0(com.zx.a.I8b7.y0 y0Var, int i) {
        this.a = y0Var;
    }

    @Override // com.zx.a.I8b7.u0
    public com.zx.a.I8b7.b2 a(com.zx.a.I8b7.u0.a aVar) throws java.io.IOException {
        com.zx.a.I8b7.r1 r1Var = (com.zx.a.I8b7.r1) aVar;
        com.zx.a.I8b7.y1 y1Var = r1Var.c;
        com.zx.a.I8b7.y1.a aVar2 = new com.zx.a.I8b7.y1.a(y1Var);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(y1Var.b + " " + y1Var.a.toString() + " " + y1Var.e + "\n");
        com.zx.a.I8b7.a2 a2Var = y1Var.d;
        if (a2Var != null && ((com.zx.a.I8b7.z1) a2Var).a.a() != null) {
            if (((com.zx.a.I8b7.z1) y1Var.d).b > 2147483647L) {
                java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("request body content length: ");
                sbA.append(((com.zx.a.I8b7.z1) y1Var.d).b);
                sbA.append("\n");
                sb.append(sbA.toString());
            } else {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                com.zx.a.I8b7.z1 z1Var = (com.zx.a.I8b7.z1) y1Var.d;
                byteArrayOutputStream.write(z1Var.c, z1Var.d, z1Var.b);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                sb.append(new java.lang.String(byteArray, java.nio.charset.StandardCharsets.UTF_8).concat("\n"));
                aVar2.d = com.zx.a.I8b7.a2.a(((com.zx.a.I8b7.z1) y1Var.d).a, byteArray);
            }
        }
        this.a.a(sb.toString());
        com.zx.a.I8b7.b2 b2VarA = r1Var.a(new com.zx.a.I8b7.y1(aVar2), r1Var.d);
        com.zx.a.I8b7.b2.a aVar3 = new com.zx.a.I8b7.b2.a(b2VarA);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(b2VarA.b + " " + b2VarA.c + " " + y1Var.a.toString() + " " + y1Var.e + "\n");
        com.zx.a.I8b7.c2 c2Var = b2VarA.e;
        if (c2Var != null && ((com.zx.a.I8b7.c2.a) c2Var).a.a() != null) {
            com.zx.a.I8b7.c2 c2Var2 = b2VarA.e;
            if (((com.zx.a.I8b7.c2.a) c2Var2).b > 2147483647L) {
                java.lang.StringBuilder sbA2 = com.zx.a.I8b7.q3.a("response body content length: ");
                sbA2.append(((com.zx.a.I8b7.c2.a) b2VarA.e).b);
                sbA2.append("\n");
                sb2.append(sbA2.toString());
            } else {
                byte[] bArrA = c2Var2.a();
                sb2.append("response body size: ");
                sb2.append(bArrA.length);
                sb2.append(", ");
                sb2.append(new java.lang.String(bArrA, java.nio.charset.StandardCharsets.UTF_8).concat("\n"));
                aVar3.e = com.zx.a.I8b7.c2.a(((com.zx.a.I8b7.c2.a) b2VarA.e).a, bArrA.length, new java.io.ByteArrayInputStream(bArrA));
            }
        }
        this.a.a(sb2.toString());
        return aVar3.a();
    }
}
