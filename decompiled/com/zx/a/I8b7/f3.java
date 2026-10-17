package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class f3 implements java.lang.Runnable {
    public final /* synthetic */ com.zx.sdk.api.PermissionCallback a;

    public f3(com.zx.a.I8b7.i3 i3Var, com.zx.sdk.api.PermissionCallback permissionCallback) {
        this.a = permissionCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.w2.a.a.a.c(1);
            com.zx.a.I8b7.y.a("用户已授权获取卓信ID");
            try {
                com.zx.a.I8b7.i3.a().a(com.zx.a.I8b7.x3.a);
            } catch (java.lang.Exception e) {
                com.zx.a.I8b7.y.b(e.getMessage());
            }
            this.a.onAuthorized();
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("卓信ID授权失败 error: "));
        }
    }
}
