package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class p3 implements java.lang.Runnable {
    public final /* synthetic */ java.lang.String a;
    public final /* synthetic */ com.zx.sdk.api.ZXIDChangedListener b;

    public p3(com.zx.a.I8b7.i3 i3Var, java.lang.String str, com.zx.sdk.api.ZXIDChangedListener zXIDChangedListener) {
        this.a = str;
        this.b = zXIDChangedListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.s3 s3VarA = com.zx.a.I8b7.i3.a();
            java.lang.String str = this.a;
            com.zx.sdk.api.ZXIDChangedListener zXIDChangedListener = this.b;
            com.zx.a.I8b7.b3 b3Var = s3VarA.c;
            b3Var.getClass();
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            java.util.LinkedList<com.zx.sdk.api.ZXIDChangedListener> linkedList = b3Var.a.get(str);
            if (linkedList == null) {
                linkedList = new java.util.LinkedList<>();
            }
            linkedList.add(zXIDChangedListener);
            b3Var.a.put(str, linkedList);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.allowPermissionDialog failed: "));
        }
    }
}
