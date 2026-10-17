package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class i {
    public com.unicom.online.account.kernel.av e;
    public final java.util.concurrent.atomic.AtomicBoolean d = new java.util.concurrent.atomic.AtomicBoolean(false);
    public final com.unicom.online.account.kernel.ab f = new com.unicom.online.account.kernel.ab();
    public final java.util.concurrent.ExecutorService c = java.util.concurrent.Executors.newSingleThreadExecutor();
    public java.util.concurrent.ScheduledExecutorService b = java.util.concurrent.Executors.newScheduledThreadPool(1);

    public final void b(java.lang.String str) {
        if (this.d.get()) {
            return;
        }
        this.d.set(true);
        try {
            this.f.b();
        } catch (java.lang.Exception e) {
            com.unicom.online.account.kernel.as.b(e);
        }
        try {
            java.util.concurrent.ExecutorService executorService = this.c;
            if (executorService != null && !executorService.isShutdown()) {
                this.c.shutdownNow();
            }
        } catch (java.lang.Exception e2) {
            com.unicom.online.account.kernel.as.b(e2);
        }
        try {
            java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.b;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                this.b = null;
            }
        } catch (java.lang.Exception e3) {
            com.unicom.online.account.kernel.as.b(e3);
        }
    }

    public final void c(android.content.Context context, int i) {
        com.unicom.online.account.kernel.f fVar = new com.unicom.online.account.kernel.f(this);
        try {
            int iC = com.unicom.online.account.kernel.au.c(context.getApplicationContext());
            java.lang.String str = com.unicom.online.account.kernel.ao.b;
            if (iC == 1) {
                com.unicom.online.account.kernel.as.b("requestPreCheck： WIFI + FLOW");
                b(context, i, fVar);
            } else if (iC == 0) {
                com.unicom.online.account.kernel.as.b("requestPreCheck： FLOW");
                com.unicom.online.account.kernel.u.b().getClass();
                b(context, i, null, fVar);
            } else {
                com.unicom.online.account.kernel.as.b("requestPreCheck： NO_CELL");
                fVar.b(i, 410004, "数据网络未开启");
            }
        } catch (java.lang.Exception e) {
            com.unicom.online.account.kernel.as.b(e);
            fVar.b(i, 410005, "网络判断异常" + e.getMessage());
        }
    }

    public static java.lang.String b(android.content.Context context, int i) {
        java.lang.String strC;
        java.lang.String strB;
        java.lang.String str;
        java.lang.String strB2;
        java.lang.String str2;
        java.lang.String strC2;
        try {
            java.lang.String str3 = com.unicom.online.account.kernel.ap.j;
            java.lang.String str4 = "" + java.lang.System.currentTimeMillis();
            java.lang.String packageName = context.getPackageName();
            java.lang.String strB3 = com.unicom.online.account.kernel.j.b(context, com.unicom.online.account.kernel.au.b());
            java.lang.String strC3 = com.unicom.online.account.kernel.ao.c();
            java.lang.String strSubstring = strC3.substring(0, 16);
            java.lang.String strSubstring2 = strC3.substring(16, 32);
            com.unicom.online.account.kernel.u.b().c = java.lang.System.currentTimeMillis();
            if (com.unicom.online.account.kernel.ap.g) {
                str = "3.1";
                byte[] bytes = strB3.getBytes("Utf-8");
                byte[] bytes2 = strSubstring.getBytes();
                byte[] bytes3 = strSubstring2.getBytes();
                com.unicom.online.account.kernel.ad.c.getClass();
                strC = com.unicom.online.account.kernel.aq.b(com.unicom.online.account.kernel.bc.b(bytes2, bytes3, bytes, 1));
                strB = com.unicom.online.account.kernel.aq.b(com.unicom.online.account.kernel.ad.b(strC3.getBytes(), com.unicom.online.account.kernel.k.b()));
            } else {
                try {
                    strC = com.unicom.online.account.kernel.b.c(strB3, strSubstring, strSubstring2);
                } catch (java.lang.Exception e) {
                    com.unicom.online.account.kernel.as.b(e);
                    strC = null;
                }
                java.security.PublicKey publicKeyGeneratePublic = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(com.unicom.online.account.kernel.aq.b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVc1ecjpc5k7TkabF935iQONDZ0/E5XWPVv9FEsI59XTRW0+BCMK1MODRSWMvHFrPMh9ZilnRr7qXuAKCBEynQEghmpIVvMYhFu48FAI9bKfkI5lKuQK+tc4X0+zTbNrpedNoKXK4C7dDjTETBH6prwWE9j5WsAf0gbjUbIs3FxwIDAQAB")));
                javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, publicKeyGeneratePublic);
                strB = com.unicom.online.account.kernel.aq.b(cipher.doFinal(strC3.getBytes()));
                str = "2.1";
            }
            if (com.unicom.online.account.kernel.ap.h.equalsIgnoreCase("sm3")) {
                strB2 = com.unicom.online.account.kernel.au.b(context, context.getPackageName());
            } else {
                strB2 = com.unicom.online.account.kernel.au.b(context, context.getPackageName(), com.unicom.online.account.kernel.ap.h);
            }
            if (com.unicom.online.account.kernel.ap.b(i)) {
                str2 = com.unicom.online.account.kernel.ao.r;
                if (!android.text.TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
            } else {
                str2 = "";
            }
            java.lang.String strReplaceAll = (strB2 + "\n" + str3 + "\n" + str + "\njson\n" + str2 + "\n" + packageName + "\n" + strC + "\n6.3.3CR001B1208\n" + strB + "\n" + str4).replaceAll("\n", "");
            if (com.unicom.online.account.kernel.ap.g) {
                strC2 = com.unicom.online.account.kernel.bb.b(strReplaceAll);
            } else {
                strC2 = com.unicom.online.account.kernel.au.c(strReplaceAll);
            }
            java.lang.String strReplaceAll2 = strC.replaceAll("\\+", "%2B");
            java.lang.String strReplaceAll3 = strB.replaceAll("\\+", "%2B");
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("androidMd5", strB2);
            jSONObject.put("apiKey", str3);
            jSONObject.put("apiVersion", str);
            jSONObject.put("format", com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_JSON);
            if (com.unicom.online.account.kernel.ap.b(i)) {
                jSONObject.put("operator", str2);
            }
            jSONObject.put("packName", packageName);
            jSONObject.put("privateIp", strReplaceAll2);
            jSONObject.put("sdkVersion", "6.3.3CR001B1208");
            jSONObject.put("secretKey", strReplaceAll3);
            jSONObject.put("timeStamp", str4);
            jSONObject.put("sign", strC2);
            return jSONObject.toString();
        } catch (java.lang.Exception e2) {
            com.unicom.online.account.kernel.as.b(e2);
            return "";
        }
    }

    public final void b(final android.content.Context context, final int i, final com.unicom.online.account.kernel.f fVar) {
        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.Thread.currentThread().getName();
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        java.util.concurrent.Executors.newCachedThreadPool().execute(new java.lang.Runnable() { // from class: com.unicom.online.account.kernel.i$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(context, countDownLatch, jCurrentTimeMillis, i, fVar);
            }
        });
    }

    public final /* synthetic */ void b(android.content.Context context, java.util.concurrent.CountDownLatch countDownLatch, long j, int i, com.unicom.online.account.kernel.f fVar) {
        try {
            this.f.b(context, new com.unicom.online.account.kernel.g(this, countDownLatch, j, context, i, fVar));
        } catch (java.lang.Exception unused) {
            countDownLatch.countDown();
        }
    }

    public final void b(android.content.Context context, int i, java.lang.Object obj, com.unicom.online.account.kernel.f fVar) {
        synchronized (this) {
            try {
                this.c.submit(new com.unicom.online.account.kernel.h(this, context, obj, i, fVar));
            } catch (java.lang.Exception e) {
                fVar.b(i, 410009, "410009" + e.getMessage());
            }
        }
    }
}
