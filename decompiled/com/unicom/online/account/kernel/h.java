package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class h implements java.lang.Runnable {
    public final /* synthetic */ android.content.Context b;
    public final /* synthetic */ java.lang.Object c;
    public final /* synthetic */ int d;
    public final /* synthetic */ com.unicom.online.account.kernel.f e;
    public final /* synthetic */ com.unicom.online.account.kernel.i f;

    public h(com.unicom.online.account.kernel.i iVar, android.content.Context context, java.lang.Object obj, int i, com.unicom.online.account.kernel.f fVar) {
        this.f = iVar;
        this.b = context;
        this.c = obj;
        this.d = i;
        this.e = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            boolean z = com.unicom.online.account.kernel.ap.b;
            com.unicom.online.account.kernel.s sVar = new com.unicom.online.account.kernel.s();
            android.content.Context context = this.b;
            android.net.Network network = (android.net.Network) this.c;
            if (sVar.f) {
                throw new java.lang.IllegalStateException("ConnectionPoolManager已释放，不能再次使用");
            }
            sVar.e = context.getApplicationContext();
            sVar.d = network;
            java.util.concurrent.ExecutorService executorService = sVar.c;
            if (executorService == null || executorService.isShutdown() || sVar.c.isTerminated()) {
                sVar.c = java.util.concurrent.Executors.newCachedThreadPool();
            }
            sVar.c();
            int i = this.d;
            if (i != 2 && i != 3 && i != 4 && i != 5) {
                this.e.b(i, 410009, "410009no this type");
                return;
            }
            java.lang.String str = com.unicom.online.account.kernel.ao.b(this.d) + com.unicom.online.account.kernel.aj.b(com.unicom.online.account.kernel.i.b(this.b, this.d));
            com.unicom.online.account.kernel.u.b().e = 0;
            android.content.Context context2 = this.b;
            com.unicom.online.account.kernel.i iVar = this.f;
            com.unicom.online.account.kernel.az azVar = new com.unicom.online.account.kernel.az(context2, iVar.f, sVar, iVar.d, this.d);
            com.unicom.online.account.kernel.as.b("CALL requestGetHttpsByConnectionPoolWithRetry:");
            java.lang.Thread.currentThread().getId();
            java.lang.Thread.currentThread().getName();
            android.content.Context context3 = this.b;
            java.util.HashMap map = new java.util.HashMap();
            map.put("user-agent", "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1");
            map.put("netType", "2");
            map.put("os", "android");
            map.put("Accept", gdut.bsx.share2.ShareContentType.FILE);
            java.lang.String strB = com.unicom.online.account.kernel.ai.b(context3, str, map, this.c, azVar);
            try {
                if (new org.json.JSONObject(strB).optInt("code") != 100) {
                    android.content.Context context4 = this.b;
                    java.util.HashMap map2 = new java.util.HashMap();
                    map2.put("user-agent", "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1");
                    map2.put("netType", "2");
                    map2.put("os", "android");
                    map2.put("Accept", gdut.bsx.share2.ShareContentType.FILE);
                    strB = com.unicom.online.account.kernel.ai.c(context4, str, map2, this.c, 0, this.f.d);
                }
            } catch (org.json.JSONException unused) {
            }
            try {
                this.f.f.b();
                com.unicom.online.account.kernel.as.b("\ncall releaseNetwork() \n");
            } catch (java.lang.Exception e) {
                com.unicom.online.account.kernel.as.b(e);
            }
            try {
                sVar.b();
                com.unicom.online.account.kernel.as.b("ConnectionPoolManager资源已释放");
            } catch (java.lang.Exception e2) {
                com.unicom.online.account.kernel.as.b("释放ConnectionPoolManager资源失败: " + e2.getMessage());
                com.unicom.online.account.kernel.as.b(e2);
            }
            if (android.text.TextUtils.isEmpty(strB)) {
                java.lang.Thread.currentThread().getId();
                this.e.b(this.d, 410002, "返回数据异常");
            } else {
                java.lang.Thread.currentThread().getId();
                java.lang.Thread.currentThread().getName();
                this.e.b(this.d, 1, strB);
            }
        } catch (java.lang.Exception e3) {
            com.unicom.online.account.kernel.as.b(e3);
            this.e.b(this.d, 410009, "410009" + e3.getMessage());
        }
    }
}
