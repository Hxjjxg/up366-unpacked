package com.cmic.gen.sdk;

/* JADX INFO: compiled from: RetryAndRedirectInterceptor.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class b1 implements com.cmic.gen.sdk.a0 {
    private com.cmic.gen.sdk.a0 a;
    private com.cmic.gen.sdk.b0 b;
    private final com.cmic.gen.sdk.w0 c = new com.cmic.gen.sdk.w0();

    public void b(com.cmic.gen.sdk.x xVar, com.cmic.gen.sdk.b0 b0Var, com.cmic.gen.sdk.i iVar) {
        if (this.a != null) {
            this.b = new com.cmic.gen.sdk.b1.a(xVar, iVar, b0Var);
            if (xVar.l()) {
                this.a.a(xVar, this.b, iVar);
            } else {
                b0Var.a(com.cmic.gen.sdk.v.a(200025));
            }
        }
    }

    @Override // com.cmic.gen.sdk.a0
    public void a(com.cmic.gen.sdk.x xVar, com.cmic.gen.sdk.b0 b0Var, com.cmic.gen.sdk.i iVar) {
        b(xVar, b0Var, iVar);
    }

    public void a(com.cmic.gen.sdk.a0 a0Var) {
        this.a = a0Var;
    }

    /* JADX INFO: compiled from: RetryAndRedirectInterceptor.java */
    class a implements com.cmic.gen.sdk.b0 {
        final /* synthetic */ com.cmic.gen.sdk.x a;
        final /* synthetic */ com.cmic.gen.sdk.i b;
        final /* synthetic */ com.cmic.gen.sdk.b0 c;

        a(com.cmic.gen.sdk.x xVar, com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.b0 b0Var) {
            this.a = xVar;
            this.b = iVar;
            this.c = b0Var;
        }

        @Override // com.cmic.gen.sdk.b0
        public void a(com.cmic.gen.sdk.y yVar) {
            if (yVar.d()) {
                com.cmic.gen.sdk.b1.this.b(com.cmic.gen.sdk.b1.this.c.b(this.a, yVar, this.b), this.c, this.b);
            } else if (android.text.TextUtils.isEmpty(com.cmic.gen.sdk.b1.this.c.a())) {
                this.c.a(yVar);
            } else {
                com.cmic.gen.sdk.b1.this.b(com.cmic.gen.sdk.b1.this.c.a(this.a, yVar, this.b), this.c, this.b);
            }
        }

        @Override // com.cmic.gen.sdk.b0
        public void a(com.cmic.gen.sdk.v vVar) {
            if (this.a.b()) {
                com.cmic.gen.sdk.h0.b("RetryAndRedirectInterceptor", "retry: " + this.a.j());
                com.cmic.gen.sdk.b1.this.b(this.a, this.c, this.b);
                return;
            }
            this.c.a(vVar);
        }
    }
}
