package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class u3 implements java.lang.Runnable {
    public final /* synthetic */ android.app.Activity a;
    public final /* synthetic */ com.zx.sdk.api.PermissionCallback b;

    public class a implements android.view.View.OnClickListener {
        public final /* synthetic */ com.zx.a.I8b7.w3 a;

        public a(com.zx.a.I8b7.w3 w3Var) {
            this.a = w3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            this.a.dismiss();
            com.zx.a.I8b7.u3.this.b.onAuthorized();
        }
    }

    public class b implements android.view.View.OnClickListener {
        public final /* synthetic */ com.zx.a.I8b7.w3 a;

        public b(com.zx.a.I8b7.w3 w3Var) {
            this.a = w3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            this.a.dismiss();
            com.zx.a.I8b7.u3.this.b.onUnauthorized();
        }
    }

    public class c implements android.view.View.OnClickListener {
        public final /* synthetic */ com.zx.a.I8b7.w3 a;

        public c(com.zx.a.I8b7.w3 w3Var) {
            this.a = w3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            this.a.dismiss();
            com.zx.a.I8b7.c3.a("用户点击了解更多");
            com.zx.a.I8b7.u3.this.a.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse("https://zxid.mobileservice.cn/privacy")));
        }
    }

    public u3(com.zx.a.I8b7.v3 v3Var, android.app.Activity activity, com.zx.sdk.api.PermissionCallback permissionCallback) {
        this.a = activity;
        this.b = permissionCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.w3 w3Var = new com.zx.a.I8b7.w3(this.a);
            w3Var.b = new com.zx.a.I8b7.u3.a(w3Var);
            w3Var.a = new com.zx.a.I8b7.u3.b(w3Var);
            w3Var.c = new com.zx.a.I8b7.u3.c(w3Var);
            w3Var.show();
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("卓信ID授权弹窗异常: "));
        }
    }
}
