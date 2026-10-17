package com.unicom.online.account.shield;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UniAccountHelper {
    private static final int CU_GET_TOKEN_GM = 3;
    private static final int CU_GET_TOKEN_IT = 2;
    private static final int CU_GET_TOKEN_LOOP = 32;
    private static final int CU_GET_UAID_LOOP = 33;
    private static final int CU_MOBILE_AUTH_GM = 5;
    private static final int CU_MOBILE_AUTH_IT = 4;
    private static final java.lang.String FAKEMOBILEIMAGE = "fakeMobileImage";
    private static final java.lang.String FAKEMOBILESTYLE = "fakeMobileStyle";
    private static final int ID_0_STOP_ONCE_SUCCESS = 0;
    private static final int ID_1_STOP_ALL_SEND = 1;
    private static final java.lang.String StrcuPreGetToken = "_Token_";
    private static final boolean enableToken = true;
    private static final boolean enableUAID = false;
    private static final boolean enable_ReInit = false;
    private static volatile com.unicom.online.account.shield.UniAccountHelper s_instance;

    private UniAccountHelper() {
    }

    private com.unicom.online.account.shield.UniAccountHelper clearCache_one(int i) {
        java.lang.String str;
        if (com.unicom.online.account.kernel.l.c() == null) {
            java.lang.System.currentTimeMillis();
            return null;
        }
        com.unicom.online.account.kernel.bp bpVarE = com.unicom.online.account.kernel.bp.e();
        android.content.Context contextC = com.unicom.online.account.kernel.l.c();
        bpVarE.getClass();
        if (i == 2 || i == 3 || i == 4 || i == 5) {
            str = "T" + i;
        } else {
            str = "";
        }
        if (contextC != null) {
            com.unicom.online.account.kernel.be.b(contextC, "AC_" + str + "_Token__isOk_");
        }
        return s_instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuGetTokenUaidLoopCommon(int i, int i2, int i3, com.unicom.online.account.shield.ResultListener resultListener) {
        if (com.unicom.online.account.kernel.l.d == 0) {
            com.unicom.online.account.kernel.l.b();
        } else if (i != 1) {
            cuPreGetToken(i3, i2, StrcuPreGetToken, new com.unicom.online.account.kernel.bk(this, i2, i, i3, resultListener));
        } else {
            cuPreGetToken(i3, i2, StrcuPreGetToken, new com.unicom.online.account.kernel.bl(this, i2, i, i3, resultListener));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void cuPreGetToken(int r25, int r26, java.lang.String r27, com.unicom.online.account.shield.ResultListener r28) {
        /*
            Method dump skipped, instruction units count: 836
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unicom.online.account.shield.UniAccountHelper.cuPreGetToken(int, int, java.lang.String, com.unicom.online.account.shield.ResultListener):void");
    }

    private java.lang.String getHostName() {
        return com.unicom.online.account.kernel.bp.d();
    }

    public static com.unicom.online.account.shield.UniAccountHelper getInstance() {
        if (s_instance == null) {
            synchronized (com.unicom.online.account.shield.UniAccountHelper.class) {
                if (s_instance == null) {
                    s_instance = new com.unicom.online.account.shield.UniAccountHelper();
                }
            }
        }
        return s_instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getUseCacheFlag() {
        return com.unicom.online.account.kernel.ap.e;
    }

    private void initFail(int i, com.unicom.online.account.shield.ResultListener resultListener, java.lang.String str, int i2) {
        com.unicom.online.account.kernel.l.b(i, resultListener, 410021, str, i2);
    }

    private static void initialize(android.content.Context context) {
        if (com.unicom.online.account.kernel.l.e == null) {
            com.unicom.online.account.kernel.l.e = new java.lang.ref.WeakReference(context.getApplicationContext());
        }
    }

    public com.unicom.online.account.shield.UniAccountHelper clearCache() {
        if (com.unicom.online.account.kernel.l.c() == null) {
            java.lang.System.currentTimeMillis();
            return null;
        }
        com.unicom.online.account.kernel.bp bpVarE = com.unicom.online.account.kernel.bp.e();
        android.content.Context contextC = com.unicom.online.account.kernel.l.c();
        bpVarE.getClass();
        if (contextC != null) {
            com.unicom.online.account.kernel.be.b(contextC, "AC_");
        }
        return s_instance;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String cuDebugInfo(java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unicom.online.account.shield.UniAccountHelper.cuDebugInfo(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean cuDebugInfoBoolean(java.lang.String r7) throws java.lang.Exception {
        /*
            r6 = this;
            java.lang.String r0 = "no info"
            com.unicom.online.account.kernel.bp r1 = com.unicom.online.account.kernel.bp.e()
            r1.getClass()
            android.content.Context r1 = com.unicom.online.account.kernel.bp.b()
            if (r1 == 0) goto L78
            java.lang.String r7 = r7.toLowerCase()     // Catch: java.lang.Exception -> L72
            int r1 = r7.hashCode()     // Catch: java.lang.Exception -> L72
            r2 = 125151933(0x775aabd, float:1.8481927E-34)
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == r2) goto L4d
            r2 = 447977265(0x1ab39731, float:7.427693E-23)
            if (r1 == r2) goto L43
            r2 = 1186807453(0x46bd3e9d, float:24223.307)
            if (r1 == r2) goto L39
            r2 = 1728343896(0x67046f58, float:6.254063E23)
            if (r1 == r2) goto L2f
            goto L57
        L2f:
            java.lang.String r1 = "getcacheflag"
            boolean r7 = r7.equals(r1)     // Catch: java.lang.Exception -> L72
            if (r7 == 0) goto L57
            r7 = 0
            goto L58
        L39:
            java.lang.String r1 = "getcbinmainthread"
            boolean r7 = r7.equals(r1)     // Catch: java.lang.Exception -> L72
            if (r7 == 0) goto L57
            r7 = r5
            goto L58
        L43:
            java.lang.String r1 = "getlogenable"
            boolean r7 = r7.equals(r1)     // Catch: java.lang.Exception -> L72
            if (r7 == 0) goto L57
            r7 = r4
            goto L58
        L4d:
            java.lang.String r1 = "getcryptogm"
            boolean r7 = r7.equals(r1)     // Catch: java.lang.Exception -> L72
            if (r7 == 0) goto L57
            r7 = r3
            goto L58
        L57:
            r7 = -1
        L58:
            if (r7 == 0) goto L6f
            if (r7 == r5) goto L6c
            if (r7 == r4) goto L69
            if (r7 != r3) goto L63
            boolean r7 = com.unicom.online.account.kernel.ap.g     // Catch: java.lang.Exception -> L72
            goto L71
        L63:
            java.lang.Exception r7 = new java.lang.Exception     // Catch: java.lang.Exception -> L72
            r7.<init>(r0)     // Catch: java.lang.Exception -> L72
            throw r7     // Catch: java.lang.Exception -> L72
        L69:
            boolean r7 = com.unicom.online.account.kernel.as.b     // Catch: java.lang.Exception -> L72
            goto L71
        L6c:
            boolean r7 = com.unicom.online.account.kernel.ap.f     // Catch: java.lang.Exception -> L72
            goto L71
        L6f:
            boolean r7 = com.unicom.online.account.kernel.ap.e     // Catch: java.lang.Exception -> L72
        L71:
            return r7
        L72:
            java.lang.Exception r7 = new java.lang.Exception
            r7.<init>(r0)
            throw r7
        L78:
            java.lang.Exception r7 = new java.lang.Exception
            java.lang.String r0 = "sdk 未初始化, context 为空"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unicom.online.account.shield.UniAccountHelper.cuDebugInfoBoolean(java.lang.String):boolean");
    }

    public void cuGetToken(int i, com.unicom.online.account.shield.ResultListener resultListener) {
        int i2 = com.unicom.online.account.kernel.ap.g ? 3 : 2;
        if ((com.unicom.online.account.kernel.l.b & 7) != 0) {
            com.unicom.online.account.kernel.l.b(i2, resultListener, 410023, "取号服务中，勿重复调用", i);
        } else {
            cuPreGetToken(i, i2, StrcuPreGetToken, resultListener);
        }
    }

    public void cuGetTokenLoop(int i, int i2, com.unicom.online.account.shield.ResultListener resultListener) {
        cuGetTokenLoop(i, com.unicom.online.account.kernel.ap.g ? 3 : 2, i2, resultListener);
    }

    public void cuMobileAuth(int i, com.unicom.online.account.shield.ResultListener resultListener) {
        int i2 = com.unicom.online.account.kernel.ap.g ? 5 : 4;
        if ((com.unicom.online.account.kernel.l.b & 7) != 0) {
            com.unicom.online.account.kernel.l.b(i2, resultListener, 410023, "取号服务中，勿重复调用", i);
        } else {
            cuPreGetToken(i, i2, StrcuPreGetToken, resultListener);
        }
    }

    public java.lang.String getProtocolUrl(int i) {
        return i != 0 ? new java.lang.String(com.unicom.online.account.kernel.aq.b("aHR0cHM6Ly9tc3Y2Lndvc21zLmNuL2h0bWwvb2F1dGgvcHJvdG9jb2wyLmh0bWw=")) : "aHR0cHM6Ly9tc3Y2Lndvc21zLmNuL2h0bWwvb2F1dGgvcHJvdG9jb2wyLmh0bWw=";
    }

    public java.lang.String getSdkVersion() {
        com.unicom.online.account.kernel.bp.e().getClass();
        boolean z = com.unicom.online.account.kernel.ap.b;
        return "6.3.3CR001B1208";
    }

    public com.unicom.online.account.shield.UniAccountHelper init(android.content.Context context, java.lang.String str) {
        return init(context, str, false);
    }

    public void releaseNetwork() {
        com.unicom.online.account.kernel.bp.e().getClass();
    }

    public com.unicom.online.account.shield.UniAccountHelper setCBinMainThread(boolean z) {
        com.unicom.online.account.kernel.ap.f = z;
        return s_instance;
    }

    public com.unicom.online.account.shield.UniAccountHelper setCertFingerType(java.lang.String str) {
        if (!str.equalsIgnoreCase("MD5") && !str.equalsIgnoreCase("SHA1") && !str.equalsIgnoreCase("SHA256") && !str.equalsIgnoreCase("sm3")) {
            return null;
        }
        com.unicom.online.account.kernel.ap.h = str.toLowerCase();
        return s_instance;
    }

    public com.unicom.online.account.shield.UniAccountHelper setCryptoGM(boolean z) {
        com.unicom.online.account.kernel.ap.g = z;
        return s_instance;
    }

    public void setLogEnable(boolean z) {
        com.unicom.online.account.kernel.ar.b = z;
        com.unicom.online.account.kernel.bp.e().getClass();
        com.unicom.online.account.kernel.as.b = z;
        com.unicom.online.account.kernel.bp.e().getClass();
    }

    public com.unicom.online.account.shield.UniAccountHelper setUseCacheFlag(boolean z) {
        com.unicom.online.account.kernel.ap.e = z;
        return s_instance;
    }

    private void initFail(int i, com.unicom.online.account.shield.ResultListener resultListener, int i2, java.lang.String str, int i3) {
        com.unicom.online.account.kernel.ar.b("type:" + i + "\nmsg:" + str);
        try {
            java.lang.String strC = com.unicom.online.account.kernel.bp.c();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("resultCode", i2);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", "");
            jSONObject.put("seq", strC);
            com.unicom.online.account.kernel.l.b();
            if (resultListener != null) {
                resultListener.onResult(jSONObject.toString());
            }
            com.unicom.online.account.kernel.bp.e().getClass();
            if (com.unicom.online.account.kernel.ap.b) {
                com.unicom.online.account.kernel.bp.e().getClass();
                java.lang.String strB = com.unicom.online.account.kernel.bp.b(1, 1, strC, i2, i3, i2, str);
                com.unicom.online.account.kernel.bp.e().getClass();
                com.unicom.online.account.kernel.an.b(com.unicom.online.account.kernel.bp.b(), strB);
            }
        } catch (java.lang.Exception e) {
            if (com.unicom.online.account.kernel.ar.b) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0113 A[Catch: Exception -> 0x0126, TryCatch #0 {Exception -> 0x0126, blocks: (B:15:0x007b, B:17:0x0081, B:20:0x0089, B:22:0x0091, B:23:0x009e, B:25:0x00ad, B:26:0x00b8, B:31:0x00c9, B:33:0x00ef, B:35:0x00f7, B:37:0x00ff, B:39:0x0107, B:42:0x0110, B:44:0x0115, B:43:0x0113, B:30:0x00c6, B:49:0x0128, B:27:0x00bb), top: B:56:0x007b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0128 A[Catch: Exception -> 0x0126, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0126, blocks: (B:15:0x007b, B:17:0x0081, B:20:0x0089, B:22:0x0091, B:23:0x009e, B:25:0x00ad, B:26:0x00b8, B:31:0x00c9, B:33:0x00ef, B:35:0x00f7, B:37:0x00ff, B:39:0x0107, B:42:0x0110, B:44:0x0115, B:43:0x0113, B:30:0x00c6, B:49:0x0128, B:27:0x00bb), top: B:56:0x007b, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.unicom.online.account.shield.UniAccountHelper init(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unicom.online.account.shield.UniAccountHelper.init(android.content.Context, java.lang.String, boolean):com.unicom.online.account.shield.UniAccountHelper");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0041 A[PHI: r1
  0x0041: PHI (r1v6 int) = (r1v4 int), (r1v5 int) binds: [B:10:0x003f, B:13:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void cuGetTokenLoop(int r4, int r5, int r6, com.unicom.online.account.shield.ResultListener r7) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "cuGetTokenLoop ---> "
            r0.<init>(r1)
            long r1 = java.lang.System.currentTimeMillis()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            boolean r1 = com.unicom.online.account.kernel.ar.b
            if (r1 == 0) goto L29
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "6.3.3 "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "UniAccount"
            android.util.Log.d(r1, r0)
        L29:
            int r0 = com.unicom.online.account.kernel.l.b
            r1 = r0 & 7
            if (r1 == 0) goto L39
            r4 = 410023(0x641a7, float:5.74565E-40)
            java.lang.String r0 = "取号服务中，勿重复调用"
            com.unicom.online.account.kernel.l.b(r5, r7, r4, r0, r6)
            return
        L39:
            r1 = 1
            r0 = r0 | r1
            com.unicom.online.account.kernel.l.b = r0
            int r0 = com.unicom.online.account.kernel.l.c
            if (r4 > 0) goto L43
        L41:
            r4 = r1
            goto L47
        L43:
            r1 = 5
            if (r4 <= r1) goto L47
            goto L41
        L47:
            int r0 = r0 + r4
            com.unicom.online.account.kernel.l.c = r0
            com.unicom.online.account.kernel.l.d = r0
            r4 = 0
            r3.cuGetTokenUaidLoopCommon(r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unicom.online.account.shield.UniAccountHelper.cuGetTokenLoop(int, int, int, com.unicom.online.account.shield.ResultListener):void");
    }
}
