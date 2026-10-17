package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class u2 implements com.zx.module.base.ZXModule {
    public com.zx.a.I8b7.b4 a;
    public final com.zx.a.I8b7.s2 b = new com.zx.a.I8b7.s2();

    @Override // com.zx.module.base.ZXModule
    public java.lang.String getModuleIdentifier() {
        return "core-n";
    }

    @Override // com.zx.module.base.ZXModule
    public java.lang.String getModuleVersion() {
        return "3.3.7.58976";
    }

    @Override // com.zx.module.base.ZXModule
    public java.lang.String invoke(java.lang.String str, java.lang.String str2) throws com.zx.module.exception.ZXModuleInvokeException {
        com.zx.a.I8b7.s2 s2Var = this.b;
        s2Var.getClass();
        try {
            java.lang.String strSubstring = com.zx.a.I8b7.w.b(str, "SHA256").substring(0, 16);
            if (!((java.util.HashSet) com.zx.a.I8b7.s2.b).contains(strSubstring)) {
                return s2Var.a(str + " not in invokableMethods", 3);
            }
            java.lang.reflect.Method declaredMethod = com.zx.a.I8b7.s2.class.getDeclaredMethod("f" + strSubstring, java.lang.String.class);
            declaredMethod.setAccessible(true);
            return (java.lang.String) declaredMethod.invoke(s2Var, str2);
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.c3.a(e);
            throw new com.zx.module.exception.ZXModuleInvokeException("Cannot invoke " + str + ", nested exception is " + e.getMessage(), e);
        }
    }

    @Override // com.zx.module.base.ZXModule
    public java.lang.String invokeAsync(java.lang.String str, java.lang.String str2, com.zx.module.base.Callback callback) throws com.zx.module.exception.ZXModuleInvokeException {
        com.zx.a.I8b7.s2 s2Var = this.b;
        s2Var.getClass();
        try {
            java.lang.String strSubstring = com.zx.a.I8b7.w.b(str, "SHA256").substring(0, 16);
            if (!((java.util.HashSet) com.zx.a.I8b7.s2.b).contains(strSubstring)) {
                java.lang.String strA = s2Var.a(str + " not in invokableMethods", 3);
                callback.callback(strA);
                return strA;
            }
            com.zx.a.I8b7.c3.a("开始执行invokeAsync: method:" + str + "; " + str2 + ":cb");
            java.lang.StringBuilder sb = new java.lang.StringBuilder("f");
            sb.append(strSubstring);
            java.lang.reflect.Method declaredMethod = com.zx.a.I8b7.s2.class.getDeclaredMethod(sb.toString(), java.lang.String.class, com.zx.module.base.Callback.class);
            declaredMethod.setAccessible(true);
            return (java.lang.String) declaredMethod.invoke(s2Var, str2, callback);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("开始执行invokeAsync:");
            sbA.append(e.getMessage());
            com.zx.a.I8b7.c3.b(sbA.toString());
            throw new com.zx.module.exception.ZXModuleInvokeException("Cannot invokeAsync " + str + ", nested exception is " + e.getMessage(), e);
        }
    }

    @Override // com.zx.module.base.ZXModule
    public void onCreate(com.zx.module.context.ContextHolder contextHolder) throws com.zx.module.exception.ZXModuleOnCreateException {
        com.zx.a.I8b7.g4 g4Var = new com.zx.a.I8b7.g4();
        this.a = g4Var;
        android.content.Context context = (android.content.Context) contextHolder.getContext();
        try {
            if (!g4Var.b.getAndSet(true)) {
                com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.f4(g4Var, context));
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXCore init failed: "));
            g4Var.b.set(false);
        }
        this.b.a = this.a;
    }

    @Override // com.zx.module.base.ZXModule
    public void onDestroy() throws com.zx.module.exception.ZXModuleOnDestroyException {
    }

    @Override // com.zx.module.base.ZXModule
    public void setMessageListener(com.zx.module.base.Listener listener) {
        com.zx.a.I8b7.g4 g4Var = (com.zx.a.I8b7.g4) this.a;
        g4Var.getClass();
        g4Var.c = new com.zx.a.I8b7.c4(g4Var, listener);
    }

    @Override // com.zx.module.base.ZXModule
    public void start() throws com.zx.module.exception.ZXModuleStartException {
        com.zx.a.I8b7.g4 g4Var = (com.zx.a.I8b7.g4) this.a;
        if (g4Var.a.compareAndSet(false, true)) {
            try {
                com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.sdk.common.utils.ZXTask(new com.zx.a.I8b7.d4(g4Var), new com.zx.a.I8b7.e4(g4Var)));
            } catch (java.lang.Throwable th) {
                com.zx.module.base.Listener listener = g4Var.c;
                if (listener != null) {
                    listener.onMessage("MESSAGE_ON_ZXID_RECEIVED", com.zx.a.I8b7.o2.a(com.igexin.sdk.PushConsts.GET_SDKONLINESTATE, th.getMessage()));
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("ZXCore start failed: ");
                    com.zx.a.I8b7.r3.a(th, sb);
                }
            }
        }
    }
}
