package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class s3 {
    public static final java.util.concurrent.atomic.AtomicBoolean e = new java.util.concurrent.atomic.AtomicBoolean(false);
    public com.zx.module.base.ZXModule a = null;
    public final com.zx.a.I8b7.f1 b;
    public final com.zx.a.I8b7.b3 c;
    public final com.zx.a.I8b7.a3 d;

    public class a implements com.zx.module.context.ContextHolder {
        public final /* synthetic */ android.content.Context a;

        public a(com.zx.a.I8b7.s3 s3Var, android.content.Context context) {
            this.a = context;
        }

        @Override // com.zx.module.context.ContextHolder
        public java.lang.Object getContext() {
            return this.a;
        }
    }

    public class b implements com.zx.module.base.Callback {
        public final /* synthetic */ com.zx.sdk.api.SAIDCallback a;

        public b(com.zx.a.I8b7.s3 s3Var, com.zx.sdk.api.SAIDCallback sAIDCallback) {
            this.a = sAIDCallback;
        }

        @Override // com.zx.module.base.Callback
        public void callback(java.lang.String str) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    this.a.onSuccess(jSONObject.getString("data"));
                } else {
                    this.a.onFailed(i, jSONObject.optString("msg"));
                }
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.c3.a(th);
                com.zx.sdk.api.SAIDCallback sAIDCallback = this.a;
                if (sAIDCallback != null) {
                    sAIDCallback.onFailed(10000, th.getMessage());
                }
            }
        }
    }

    public class c implements com.zx.module.base.Callback {
        public final /* synthetic */ com.zx.sdk.api.Callback a;

        public c(com.zx.a.I8b7.s3 s3Var, com.zx.sdk.api.Callback callback) {
            this.a = callback;
        }

        @Override // com.zx.module.base.Callback
        public void callback(java.lang.String str) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    this.a.onSuccess(jSONObject.getString("data"));
                } else {
                    this.a.onFailed(i, jSONObject.optString("data"));
                }
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.c3.a(th);
                com.zx.sdk.api.Callback callback = this.a;
                if (callback != null) {
                    callback.onFailed(10000, th.getMessage());
                }
            }
        }
    }

    public class d implements com.zx.module.base.Callback {
        public final /* synthetic */ com.zx.sdk.api.Callback a;

        public d(com.zx.a.I8b7.s3 s3Var, com.zx.sdk.api.Callback callback) {
            this.a = callback;
        }

        @Override // com.zx.module.base.Callback
        public void callback(java.lang.String str) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    this.a.onSuccess(jSONObject.getString("data"));
                } else {
                    this.a.onFailed(i, jSONObject.optString("data"));
                }
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.c3.a(th);
                com.zx.sdk.api.Callback callback = this.a;
                if (callback != null) {
                    callback.onFailed(10000, th.getMessage());
                }
            }
        }
    }

    public static class e {
        public static final com.zx.a.I8b7.s3 a = new com.zx.a.I8b7.s3();
    }

    public s3() {
        com.zx.a.I8b7.f1 f1Var = new com.zx.a.I8b7.f1();
        this.b = f1Var;
        com.zx.a.I8b7.b3 b3Var = new com.zx.a.I8b7.b3();
        this.c = b3Var;
        com.zx.a.I8b7.a3 a3Var = new com.zx.a.I8b7.a3();
        this.d = a3Var;
        f1Var.a("MESSAGE_ON_ZXID_CHANGED", b3Var);
        f1Var.a("MESSAGE_ON_ZXID_RECEIVED", a3Var);
        try {
            a(com.zx.a.I8b7.x3.a);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXModule init failed: "));
        }
    }

    @com.zx.module.annotation.Java2C.Method2C
    public native java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, com.zx.sdk.api.SAIDCallback sAIDCallback) throws org.json.JSONException, com.zx.module.exception.ZXModuleInvokeException;

    public void a(android.content.Context context) throws com.zx.a.I8b7.t2 {
        try {
            if (e.getAndSet(true)) {
                return;
            }
            this.a = com.zx.a.I8b7.c0.a.a.a(context);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("version", "3.3.7.58976");
            this.a.invoke("setSDKVersion", jSONObject.toString());
            this.a.onCreate(new com.zx.a.I8b7.s3.a(this, context));
            this.a.setMessageListener(this.b);
        } catch (java.lang.Exception e2) {
            e.set(false);
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("Raised exception while initializing: ");
            sbA.append(e2.getMessage());
            throw new com.zx.a.I8b7.t2(sbA.toString(), e2);
        }
    }

    @com.zx.module.annotation.Java2C.Method2C
    public native void a(java.lang.String str, com.zx.sdk.api.Callback callback) throws org.json.JSONException, com.zx.module.exception.ZXModuleInvokeException;

    @com.zx.module.annotation.Java2C.Method2C
    public native void a(boolean z) throws org.json.JSONException, com.zx.module.exception.ZXModuleInvokeException;

    @com.zx.module.annotation.Java2C.Method2C
    public native void b(java.lang.String str, com.zx.sdk.api.Callback callback) throws org.json.JSONException, com.zx.module.exception.ZXModuleInvokeException;

    public void a() throws com.zx.a.I8b7.t2 {
        try {
            this.a.start();
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("Raised exception in start: ");
            sbA.append(th.getMessage());
            throw new com.zx.a.I8b7.t2(sbA.toString(), th);
        }
    }

    public void a(java.lang.String str, com.zx.sdk.api.ZXIDListener zXIDListener) throws com.zx.a.I8b7.t2 {
        if (zXIDListener != null) {
            try {
                com.zx.a.I8b7.a3 a3Var = this.d;
                a3Var.getClass();
                if (!android.text.TextUtils.isEmpty(str)) {
                    java.util.LinkedList<com.zx.sdk.api.ZXIDListener> linkedList = a3Var.a.get(str);
                    if (linkedList == null) {
                        linkedList = new java.util.LinkedList<>();
                    }
                    linkedList.add(zXIDListener);
                    a3Var.a.put(str, linkedList);
                }
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.c3.a(th);
                java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("Raised exception while getZXID: nested exception is ");
                sbA.append(th.getMessage());
                throw new com.zx.a.I8b7.t2(sbA.toString(), th);
            }
        }
        a();
    }
}
