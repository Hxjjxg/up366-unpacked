package com.cmic.gen.sdk;

/* JADX INFO: compiled from: WifiChangeInterceptor.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class z1 implements com.cmic.gen.sdk.a0 {
    private com.cmic.gen.sdk.a0 a;

    /* JADX INFO: compiled from: WifiChangeInterceptor.java */
    class a implements com.cmic.gen.sdk.a2.b {
        private final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);
        final /* synthetic */ com.cmic.gen.sdk.i b;
        final /* synthetic */ com.cmic.gen.sdk.x c;
        final /* synthetic */ com.cmic.gen.sdk.b0 d;
        final /* synthetic */ com.cmic.gen.sdk.a2 e;

        /* JADX INFO: renamed from: com.cmic.gen.sdk.z1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WifiChangeInterceptor.java */
        class C0009a extends com.cmic.gen.sdk.k1.a {
            final /* synthetic */ android.net.Network b;
            final /* synthetic */ android.net.ConnectivityManager.NetworkCallback c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0009a(android.content.Context context, com.cmic.gen.sdk.i iVar, android.net.Network network, android.net.ConnectivityManager.NetworkCallback networkCallback) {
                super(context, iVar);
                this.b = network;
                this.c = networkCallback;
            }

            @Override // com.cmic.gen.sdk.k1.a
            protected void a() {
                if (this.b != null) {
                    com.cmic.gen.sdk.h0.a("WifiChangeInterceptor", "onAvailable");
                    com.cmic.gen.sdk.z1.a.this.c.a(this.b);
                    com.cmic.gen.sdk.z1.a aVar = com.cmic.gen.sdk.z1.a.this;
                    com.cmic.gen.sdk.z1.this.b(aVar.c, aVar.d, aVar.b);
                } else {
                    com.cmic.gen.sdk.z1.a.this.d.a(com.cmic.gen.sdk.v.a(102508));
                }
                com.cmic.gen.sdk.z1.a.this.e.a(this.c);
            }
        }

        a(com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.x xVar, com.cmic.gen.sdk.b0 b0Var, com.cmic.gen.sdk.a2 a2Var) {
            this.b = iVar;
            this.c = xVar;
            this.d = b0Var;
            this.e = a2Var;
        }

        @Override // com.cmic.gen.sdk.a2.b
        public void a(android.net.Network network, android.net.ConnectivityManager.NetworkCallback networkCallback) {
            if (this.a.getAndSet(true)) {
                return;
            }
            com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.z1.a.C0009a(null, this.b, network, networkCallback));
        }
    }

    /* JADX INFO: compiled from: WifiChangeInterceptor.java */
    class b implements com.cmic.gen.sdk.b0 {
        final /* synthetic */ com.cmic.gen.sdk.b0 a;

        b(com.cmic.gen.sdk.b0 b0Var) {
            this.a = b0Var;
        }

        @Override // com.cmic.gen.sdk.b0
        public void a(com.cmic.gen.sdk.y yVar) {
            this.a.a(yVar);
        }

        @Override // com.cmic.gen.sdk.b0
        public void a(com.cmic.gen.sdk.v vVar) {
            this.a.a(vVar);
        }
    }

    @Override // com.cmic.gen.sdk.a0
    public void a(com.cmic.gen.sdk.x xVar, com.cmic.gen.sdk.b0 b0Var, com.cmic.gen.sdk.i iVar) {
        if (!xVar.k()) {
            b(xVar, b0Var, iVar);
        } else {
            com.cmic.gen.sdk.a2 a2VarA = com.cmic.gen.sdk.a2.a((android.content.Context) null);
            a2VarA.a(new com.cmic.gen.sdk.z1.a(iVar, xVar, b0Var, a2VarA));
        }
    }

    public void b(com.cmic.gen.sdk.x xVar, com.cmic.gen.sdk.b0 b0Var, com.cmic.gen.sdk.i iVar) {
        com.cmic.gen.sdk.a0 a0Var = this.a;
        if (a0Var != null) {
            a0Var.a(xVar, new com.cmic.gen.sdk.z1.b(b0Var), iVar);
        }
    }

    public void a(com.cmic.gen.sdk.a0 a0Var) {
        this.a = a0Var;
    }
}
