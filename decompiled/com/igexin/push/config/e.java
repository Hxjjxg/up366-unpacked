package com.igexin.push.config;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class e {
    private static java.lang.String a = "FileConfig";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[Catch: all -> 0x00cc, Exception -> 0x00e2, TryCatch #17 {Exception -> 0x00e2, all -> 0x00cc, blocks: (B:22:0x0045, B:24:0x0052, B:27:0x007c, B:28:0x0083, B:29:0x0084), top: B:97:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d A[Catch: all -> 0x00be, Exception -> 0x00c3, TryCatch #14 {Exception -> 0x00c3, all -> 0x00be, blocks: (B:31:0x0097, B:33:0x009d, B:35:0x00a5), top: B:101:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ad A[EDGE_INSN: B:83:0x00ad->B:37:0x00ad BREAK  A[LOOP:0: B:101:0x0097->B:104:0x0097], EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.e.a():void");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.io.InputStream r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 646
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.e.a(java.io.InputStream):void");
    }

    public static void a(java.lang.Boolean bool) {
        try {
            com.igexin.push.g.k.l();
            if (new java.io.File(com.igexin.push.g.k.e).exists()) {
                b(bool);
                return;
            }
            byte[] bytes = "sdk.debug=".concat(java.lang.String.valueOf(bool)).getBytes();
            if (bytes != null) {
                com.igexin.push.g.k.a(bytes, com.igexin.push.g.k.e);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void a(boolean z, boolean z2) {
        try {
            com.igexin.push.g.k.l();
            com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.a, java.lang.Boolean.valueOf(z));
            com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.b, java.lang.Boolean.valueOf(z2));
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static int b() {
        try {
            com.igexin.push.g.k.l();
            java.lang.Boolean boolA = com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.a);
            int i = boolA == null ? -1 : boolA.booleanValue() ? 1 : 0;
            com.igexin.c.a.c.a.a(a + "|getGuardMeFromFile gm= " + i, new java.lang.Object[0]);
            return i;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }

    private static void b(java.lang.Boolean bool) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.io.BufferedReader bufferedReader = null;
        try {
            fileInputStream = new java.io.FileInputStream(com.igexin.push.g.k.e);
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream, "UTF-8"));
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    while (true) {
                        java.lang.String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.startsWith("#")) {
                            sb.append(line);
                        } else {
                            java.lang.String[] strArrSplit = line.split("=");
                            if (strArrSplit.length < 2) {
                                sb.append(line);
                            } else {
                                java.lang.String strTrim = strArrSplit[0].trim();
                                strArrSplit[1].trim();
                                if (!strTrim.equals("sdk.debug")) {
                                    sb.append(line);
                                }
                            }
                        }
                        sb.append("\n");
                    }
                    sb.append("sdk.debug=".concat(java.lang.String.valueOf(bool)));
                    byte[] bytes = sb.toString().getBytes();
                    if (bytes != null) {
                        com.igexin.push.g.k.a(bytes, com.igexin.push.g.k.e);
                    }
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                    try {
                        fileInputStream.close();
                    } catch (java.lang.Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                    }
                } catch (java.lang.Exception unused) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e3) {
                            com.igexin.c.a.c.a.a(e3);
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.lang.Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e5) {
                            com.igexin.c.a.c.a.a(e5);
                        }
                    }
                    if (fileInputStream == null) {
                        throw th;
                    }
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (java.lang.Exception e6) {
                        com.igexin.c.a.c.a.a(e6);
                        throw th;
                    }
                }
            } catch (java.lang.Exception unused2) {
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception unused3) {
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static int c() {
        try {
            java.lang.Boolean boolA = com.igexin.push.core.d.c.a().a(com.igexin.push.core.d.c.b);
            int i = boolA == null ? -1 : boolA.booleanValue() ? 1 : 0;
            com.igexin.c.a.c.a.a(a + "|getGuardOthersFromFile gm= " + i, new java.lang.Object[0]);
            return i;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }
}
