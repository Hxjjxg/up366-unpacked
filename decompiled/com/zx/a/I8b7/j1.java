package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class j1 implements com.zx.sdk.api.PermissionCallback {
    public com.zx.sdk.api.PermissionCallback a;

    public j1(com.zx.sdk.api.PermissionCallback permissionCallback) {
        this.a = permissionCallback;
    }

    @Override // com.zx.sdk.api.PermissionCallback
    public void onAuthorized() {
        try {
            if (this.a != null) {
                com.zx.a.I8b7.i3 i3VarB = com.zx.a.I8b7.i3.b();
                com.zx.sdk.api.PermissionCallback permissionCallback = this.a;
                i3VarB.getClass();
                com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.f3(i3VarB, permissionCallback));
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }

    @Override // com.zx.sdk.api.PermissionCallback
    public void onUnauthorized() {
        try {
            if (this.a != null) {
                com.zx.a.I8b7.i3 i3VarB = com.zx.a.I8b7.i3.b();
                i3VarB.getClass();
                com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.g3(i3VarB));
                this.a.onUnauthorized();
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }
}
