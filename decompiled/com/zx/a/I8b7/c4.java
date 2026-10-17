package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class c4 implements com.zx.module.base.Listener {
    public final /* synthetic */ com.zx.module.base.Listener a;
    public final /* synthetic */ com.zx.a.I8b7.g4 b;

    public c4(com.zx.a.I8b7.g4 g4Var, com.zx.module.base.Listener listener) {
        this.b = g4Var;
        this.a = listener;
    }

    @Override // com.zx.module.base.Listener
    public void onMessage(java.lang.String str, java.lang.String str2) {
        try {
            if (str.equals("zxid") || str.equals("MESSAGE_ON_ZXID_RECEIVED")) {
                this.b.a.set(false);
            }
            this.a.onMessage(str, str2);
        } catch (java.lang.Throwable unused) {
        }
    }
}
