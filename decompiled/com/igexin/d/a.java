package com.igexin.d;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class a implements java.lang.reflect.InvocationHandler {
    private static java.lang.String b = "ZxExecutor";
    private static volatile com.igexin.d.a c;
    public android.content.Context a;

    /* JADX INFO: renamed from: com.igexin.d.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.igexin.d.a.c(com.igexin.d.a.this.a)) {
                    com.igexin.d.a aVar = com.igexin.d.a.this;
                    com.igexin.d.a.a(aVar, aVar.a);
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* JADX INFO: renamed from: com.igexin.d.a$2, reason: invalid class name */
    final class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;

        AnonymousClass2(android.content.Context context, java.lang.String str, java.lang.String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.lang.Class cls = (java.lang.Class) com.igexin.push.g.d.a(this.a, com.igexin.sdk.PushService.class).second;
                if (cls != null) {
                    android.content.Intent intent = new android.content.Intent(this.a, (java.lang.Class<?>) cls);
                    intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_UPLOAD_TYPE253);
                    intent.putExtra(com.igexin.push.core.b.C, this.b);
                    intent.putExtra("aid", this.c);
                    com.igexin.push.g.c.a(this.a, intent);
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private a() {
    }

    public static com.igexin.d.a a() {
        if (c == null) {
            synchronized (com.igexin.d.a.class) {
                if (c == null) {
                    com.igexin.d.a aVar = new com.igexin.d.a();
                    c = aVar;
                    return aVar;
                }
            }
        }
        return c;
    }

    static /* synthetic */ void a(com.igexin.d.a aVar, android.content.Context context) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.zx.sdk.api.ZXManager");
            java.lang.Object objInvoke = cls.getDeclaredMethod("newSDK", java.lang.String.class).invoke(cls, com.igexin.push.a.r);
            java.lang.reflect.Method declaredMethod = objInvoke.getClass().getDeclaredMethod("init", android.content.Context.class);
            java.lang.reflect.Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("allowPermissionDialog", java.lang.Boolean.TYPE);
            declaredMethod.invoke(objInvoke, context);
            declaredMethod2.invoke(objInvoke, java.lang.Boolean.FALSE);
            java.lang.Class<?> cls2 = java.lang.Class.forName("com.zx.sdk.api.ZXIDListener");
            objInvoke.getClass().getDeclaredMethod("getZXID", cls2).invoke(objInvoke, java.lang.reflect.Proxy.newProxyInstance(com.igexin.d.a.class.getClassLoader(), new java.lang.Class[]{cls2}, aVar));
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void a(java.lang.String str, java.lang.String str2, android.content.Context context) {
        com.igexin.b.a.a().a.execute(new com.igexin.d.a.AnonymousClass2(context, str, str2));
    }

    private void b(android.content.Context context) {
        this.a = context.getApplicationContext();
        com.igexin.b.a.a().b().schedule(new com.igexin.d.a.AnonymousClass1(), 2000L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(android.content.Context context) throws java.lang.Throwable {
        com.igexin.push.b.b bVar;
        android.database.Cursor cursorA = null;
        try {
            bVar = new com.igexin.push.b.b(context);
            try {
                cursorA = bVar.a("config", new java.lang.String[]{"value"}, "id = 79");
                if (cursorA == null || !cursorA.moveToFirst()) {
                    if (cursorA != null) {
                        try {
                            cursorA.close();
                        } catch (java.lang.Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                    bVar.close();
                    return false;
                }
                boolean z = java.lang.Boolean.parseBoolean(cursorA.getString(0));
                if (cursorA != null) {
                    try {
                        cursorA.close();
                    } catch (java.lang.Throwable th2) {
                        com.igexin.c.a.c.a.a(th2);
                    }
                }
                bVar.close();
                return z;
            } catch (java.lang.Throwable th3) {
                th = th3;
                if (cursorA != null) {
                    try {
                        cursorA.close();
                    } catch (java.lang.Throwable th4) {
                        com.igexin.c.a.c.a.a(th4);
                        throw th;
                    }
                }
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            bVar = null;
        }
    }

    private void d(android.content.Context context) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.zx.sdk.api.ZXManager");
            java.lang.Object objInvoke = cls.getDeclaredMethod("newSDK", java.lang.String.class).invoke(cls, com.igexin.push.a.r);
            java.lang.reflect.Method declaredMethod = objInvoke.getClass().getDeclaredMethod("init", android.content.Context.class);
            java.lang.reflect.Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("allowPermissionDialog", java.lang.Boolean.TYPE);
            declaredMethod.invoke(objInvoke, context);
            declaredMethod2.invoke(objInvoke, java.lang.Boolean.FALSE);
            java.lang.Class<?> cls2 = java.lang.Class.forName("com.zx.sdk.api.ZXIDListener");
            objInvoke.getClass().getDeclaredMethod("getZXID", cls2).invoke(objInvoke, java.lang.reflect.Proxy.newProxyInstance(com.igexin.d.a.class.getClassLoader(), new java.lang.Class[]{cls2}, this));
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b A[Catch: all -> 0x00ae, TRY_LEAVE, TryCatch #0 {all -> 0x00ae, blocks: (B:3:0x0001, B:18:0x0031, B:20:0x003a, B:21:0x0047, B:22:0x005b, B:25:0x0084, B:26:0x009a, B:8:0x0016, B:11:0x0020), top: B:29:0x0001 }] */
    @Override // java.lang.reflect.InvocationHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(java.lang.Object r6, java.lang.reflect.Method r7, java.lang.Object[] r8) {
        /*
            r5 = this;
            r6 = 0
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> Lae
            int r0 = r7.hashCode()     // Catch: java.lang.Throwable -> Lae
            r1 = -530890460(0xffffffffe05b4124, float:-6.3195794E19)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L20
            r1 = 1116433148(0x428b6afc, float:69.708954)
            if (r0 == r1) goto L16
            goto L2a
        L16:
            java.lang.String r0 = "onFailed"
            boolean r7 = r7.equals(r0)     // Catch: java.lang.Throwable -> Lae
            if (r7 == 0) goto L2a
            r7 = r3
            goto L2b
        L20:
            java.lang.String r0 = "onSuccess"
            boolean r7 = r7.equals(r0)     // Catch: java.lang.Throwable -> Lae
            if (r7 == 0) goto L2a
            r7 = r2
            goto L2b
        L2a:
            r7 = -1
        L2b:
            if (r7 == 0) goto L5b
            if (r7 == r3) goto L31
            goto Lae
        L31:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae
            r7.<init>()     // Catch: java.lang.Throwable -> Lae
            int r0 = r8.length     // Catch: java.lang.Throwable -> Lae
            r1 = r2
        L38:
            if (r1 >= r0) goto L47
            r4 = r8[r1]     // Catch: java.lang.Throwable -> Lae
            r7.append(r4)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r4 = ","
            r7.append(r4)     // Catch: java.lang.Throwable -> Lae
            int r1 = r1 + 1
            goto L38
        L47:
            java.lang.String r8 = "ZxExecutor | "
            java.lang.String r0 = " get zxid failed code  msg = "
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r7 = r0.concat(r7)     // Catch: java.lang.Throwable -> Lae
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lae
            r0[r2] = r7     // Catch: java.lang.Throwable -> Lae
            com.igexin.c.a.c.a.a(r8, r0)     // Catch: java.lang.Throwable -> Lae
            goto Lae
        L5b:
            r7 = r8[r2]     // Catch: java.lang.Throwable -> Lae
            java.lang.String r8 = com.igexin.d.a.b     // Catch: java.lang.Throwable -> Lae
            java.lang.String r0 = " get zxid success "
            java.lang.String r1 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r0 = r0.concat(r1)     // Catch: java.lang.Throwable -> Lae
            com.igexin.c.a.c.a.b(r8, r0)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r8 = "com.zx.sdk.api.ZXID"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r0 = "getAids"
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r0, r6)     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r8 = r8.invoke(r7, r6)     // Catch: java.lang.Throwable -> Lae
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch: java.lang.Throwable -> Lae
            boolean r0 = r8 instanceof org.json.JSONObject     // Catch: java.lang.Throwable -> Lae
            java.lang.String r1 = ""
            if (r0 == 0) goto L9a
            java.lang.String r0 = "venderAid"
            java.lang.String r1 = r8.optString(r0, r1)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r8 = com.igexin.d.a.b     // Catch: java.lang.Throwable -> Lae
            java.lang.String r0 = " get aid success "
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r0 = r0.concat(r2)     // Catch: java.lang.Throwable -> Lae
            com.igexin.c.a.c.a.b(r8, r0)     // Catch: java.lang.Throwable -> Lae
        L9a:
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lae
            android.content.Context r8 = r5.a     // Catch: java.lang.Throwable -> Lae
            com.igexin.b.a r0 = com.igexin.b.a.a()     // Catch: java.lang.Throwable -> Lae
            java.util.concurrent.ThreadPoolExecutor r0 = r0.a     // Catch: java.lang.Throwable -> Lae
            com.igexin.d.a$2 r2 = new com.igexin.d.a$2     // Catch: java.lang.Throwable -> Lae
            r2.<init>(r8, r7, r1)     // Catch: java.lang.Throwable -> Lae
            r0.execute(r2)     // Catch: java.lang.Throwable -> Lae
        Lae:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.d.a.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }
}
