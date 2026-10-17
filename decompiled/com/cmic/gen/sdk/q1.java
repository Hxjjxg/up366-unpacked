package com.cmic.gen.sdk;

/* JADX INFO: compiled from: UMCTelephonyManagement.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class q1 {
    private static com.cmic.gen.sdk.q1 b;
    private static long c;
    private com.cmic.gen.sdk.q1.a a = null;

    /* JADX INFO: compiled from: UMCTelephonyManagement.java */
    public static class a {
        private int a = -1;
        private int b = -1;

        public int a() {
            return this.b;
        }
    }

    private q1() {
    }

    public static com.cmic.gen.sdk.q1 a() {
        if (b == null) {
            b = new com.cmic.gen.sdk.q1();
        }
        return b;
    }

    public com.cmic.gen.sdk.q1.a b() {
        com.cmic.gen.sdk.q1.a aVar = this.a;
        return aVar == null ? new com.cmic.gen.sdk.q1.a() : aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008a A[PHI: r11
  0x008a: PHI (r11v4 android.database.Cursor) = (r11v2 android.database.Cursor), (r11v6 android.database.Cursor) binds: [B:21:0x0088, B:18:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(android.content.Context r11) {
        /*
            r10 = this;
            java.lang.String r0 = "sim_id"
            java.lang.String r1 = "_id"
            java.lang.String r2 = "readSimInfoDbStart"
            java.lang.String r3 = "UMCTelephonyManagement"
            com.cmic.gen.sdk.h0.a(r3, r2)
            java.lang.String r2 = "content://telephony/siminfo"
            android.net.Uri r5 = android.net.Uri.parse(r2)
            android.content.ContentResolver r4 = r11.getContentResolver()
            r11 = 0
            java.lang.String[] r6 = new java.lang.String[]{r1, r0}     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            java.lang.String r7 = "sim_id>=?"
            java.lang.String r2 = "0"
            java.lang.String[] r8 = new java.lang.String[]{r2}     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            r9 = 0
            android.database.Cursor r11 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            if (r11 == 0) goto L80
        L29:
            boolean r2 = r11.moveToNext()     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            if (r2 == 0) goto L80
            int r2 = r11.getColumnIndex(r0)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            int r2 = r11.getInt(r2)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            int r4 = r11.getColumnIndex(r1)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            int r4 = r11.getInt(r4)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            com.cmic.gen.sdk.q1$a r5 = r10.a     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            int r5 = com.cmic.gen.sdk.q1.a.b(r5)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            r6 = -1
            if (r5 != r6) goto L72
            com.cmic.gen.sdk.q1$a r5 = r10.a     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            int r5 = com.cmic.gen.sdk.q1.a.a(r5)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            if (r5 == r6) goto L72
            com.cmic.gen.sdk.q1$a r5 = r10.a     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            int r5 = com.cmic.gen.sdk.q1.a.a(r5)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            if (r5 != r4) goto L72
            com.cmic.gen.sdk.q1$a r5 = r10.a     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            com.cmic.gen.sdk.q1.a.b(r5, r2)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            r5.<init>()     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            java.lang.String r6 = "通过读取sim db获取数据流量卡的卡槽值："
            r5.append(r6)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            r5.append(r2)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            com.cmic.gen.sdk.h0.a(r3, r5)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
        L72:
            com.cmic.gen.sdk.q1$a r5 = r10.a     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            int r5 = com.cmic.gen.sdk.q1.a.b(r5)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            if (r5 != r2) goto L29
            com.cmic.gen.sdk.q1$a r2 = r10.a     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            com.cmic.gen.sdk.q1.a.a(r2, r4)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> L93
            goto L29
        L80:
            if (r11 == 0) goto L8d
            goto L8a
        L83:
            java.lang.String r0 = "readSimInfoDb error"
            com.cmic.gen.sdk.h0.b(r3, r0)     // Catch: java.lang.Throwable -> L93
            if (r11 == 0) goto L8d
        L8a:
            r11.close()
        L8d:
            java.lang.String r11 = "readSimInfoDbEnd"
            com.cmic.gen.sdk.h0.a(r3, r11)
            return
        L93:
            r0 = move-exception
            if (r11 == 0) goto L99
            r11.close()
        L99:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.gen.sdk.q1.b(android.content.Context):void");
    }

    public void a(android.content.Context context, boolean z) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - c;
        if (jCurrentTimeMillis >= com.igexin.push.config.c.s || jCurrentTimeMillis <= 0) {
            this.a = new com.cmic.gen.sdk.q1.a();
            if (z) {
                a(context);
                if (com.cmic.gen.sdk.j1.d() && com.cmic.gen.sdk.j1.e()) {
                    com.cmic.gen.sdk.h0.a("UMCTelephonyManagement", "华为手机兼容性处理");
                    if (this.a.b == 0 || this.a.b == 1) {
                        if (this.a.a == -1) {
                            com.cmic.gen.sdk.q1.a aVar = this.a;
                            aVar.a = aVar.b;
                        }
                        this.a.b = -1;
                    }
                    if (this.a.a != -1 || this.a.b != -1) {
                        b(context);
                    }
                }
                c = java.lang.System.currentTimeMillis();
            }
        }
    }

    private void a(android.content.Context context) {
        int i = android.os.Build.VERSION.SDK_INT;
        android.telephony.SubscriptionManager subscriptionManagerFrom = android.telephony.SubscriptionManager.from(context.getApplicationContext());
        if (subscriptionManagerFrom != null) {
            try {
                if (this.a.a == -1 && i >= 24) {
                    this.a.b = com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m$1();
                    com.cmic.gen.sdk.h0.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = " + this.a.b);
                    return;
                }
            } catch (java.lang.Exception unused) {
                com.cmic.gen.sdk.h0.b("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
            }
            try {
                java.lang.Object objInvoke = subscriptionManagerFrom.getClass().getMethod("getDefaultDataSubId", null).invoke(subscriptionManagerFrom, null);
                if ((objInvoke instanceof java.lang.Integer) || (objInvoke instanceof java.lang.Long)) {
                    this.a.b = ((java.lang.Integer) objInvoke).intValue();
                    com.cmic.gen.sdk.h0.a("UMCTelephonyManagement", "android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = " + this.a.b);
                    return;
                }
            } catch (java.lang.Exception unused2) {
                com.cmic.gen.sdk.h0.b("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
            }
            try {
                java.lang.Object objInvoke2 = subscriptionManagerFrom.getClass().getMethod("getDefaultDataSubscriptionId", null).invoke(subscriptionManagerFrom, null);
                if ((objInvoke2 instanceof java.lang.Integer) || (objInvoke2 instanceof java.lang.Long)) {
                    this.a.b = ((java.lang.Integer) objInvoke2).intValue();
                    com.cmic.gen.sdk.h0.a("UMCTelephonyManagement", "反射getDefaultDataSubscriptionId适配成功: dataSubId = " + this.a.b);
                }
            } catch (java.lang.Exception unused3) {
                com.cmic.gen.sdk.h0.b("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
            }
        }
    }
}
