package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class h3 implements java.lang.Runnable {
    public final /* synthetic */ com.zx.sdk.api.PermissionCallback a;
    public final /* synthetic */ android.app.Activity b;

    public h3(com.zx.a.I8b7.i3 i3Var, com.zx.sdk.api.PermissionCallback permissionCallback, android.app.Activity activity) {
        this.a = permissionCallback;
        this.b = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.j1 j1Var = new com.zx.a.I8b7.j1(this.a);
            android.os.Handler handler = com.zx.a.I8b7.v3.a;
            com.zx.a.I8b7.v3 v3Var = com.zx.a.I8b7.v3.a.a;
            if (v3Var.b()) {
                android.app.Activity activity = this.b;
                v3Var.getClass();
                com.zx.a.I8b7.v3.a.post(new com.zx.a.I8b7.u3(v3Var, activity, j1Var));
            } else if (v3Var.a()) {
                j1Var.onAuthorized();
            } else {
                j1Var.onUnauthorized();
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.registerListener(listener) failed: "));
        }
    }
}
