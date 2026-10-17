package com.igexin.push.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class k {
    public static java.lang.String a = null;
    public static java.lang.String b = null;
    public static java.lang.String c = null;
    public static java.lang.String d = null;
    public static java.lang.String e = null;
    public static java.lang.String f = null;
    public static java.lang.String g = null;
    private static final java.lang.String h = "FileUtils";
    private static final java.lang.Object i = new java.lang.Object();
    private static java.lang.String j;

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002b, code lost:
    
        if (r1.canRead() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r4) {
        /*
            java.lang.String r0 = ""
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5d
            r1.<init>()     // Catch: java.lang.Exception -> L5d
            java.lang.String r2 = com.igexin.push.g.k.f     // Catch: java.lang.Exception -> L5d
            r1.append(r2)     // Catch: java.lang.Exception -> L5d
            java.lang.String r4 = com.igexin.assist.util.a.a(r4)     // Catch: java.lang.Exception -> L5d
            r1.append(r4)     // Catch: java.lang.Exception -> L5d
            java.lang.String r4 = ".bin"
            r1.append(r4)     // Catch: java.lang.Exception -> L5d
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Exception -> L5d
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L5b
            r1.<init>(r4)     // Catch: java.lang.Exception -> L5b
            boolean r2 = r1.exists()     // Catch: java.lang.Exception -> L5b
            if (r2 == 0) goto L2d
            boolean r1 = r1.canRead()     // Catch: java.lang.Exception -> L5b
            if (r1 != 0) goto L64
        L2d:
            android.content.Context r4 = com.igexin.push.core.e.l     // Catch: java.lang.Exception -> L5d
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Exception -> L5d
            java.lang.String r1 = "android.permission.WRITE_EXTERNAL_STORAGE"
            android.content.Context r2 = com.igexin.push.core.e.l     // Catch: java.lang.Exception -> L5d
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Exception -> L5d
            int r4 = r4.checkPermission(r1, r2)     // Catch: java.lang.Exception -> L5d
            if (r4 == 0) goto L65
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5d
            r4.<init>()     // Catch: java.lang.Exception -> L5d
            android.content.Context r1 = com.igexin.push.core.e.l     // Catch: java.lang.Exception -> L5d
            java.io.File r1 = r1.getCacheDir()     // Catch: java.lang.Exception -> L5d
            r4.append(r1)     // Catch: java.lang.Exception -> L5d
            java.lang.String r1 = "/ImgCache/"
            r4.append(r1)     // Catch: java.lang.Exception -> L5d
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L5d
            com.igexin.push.g.k.f = r4     // Catch: java.lang.Exception -> L5d
            goto L65
        L5b:
            r0 = move-exception
            goto L61
        L5d:
            r4 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
        L61:
            com.igexin.c.a.c.a.a(r0)
        L64:
            r0 = r4
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.g.k.a(java.lang.String):java.lang.String");
    }

    public static void a() {
        try {
            java.lang.String packageName = com.igexin.push.core.e.l.getPackageName();
            b = "/sdcard/libs/" + packageName + ".db";
            c = "/sdcard/libs/com.igexin.sdk.deviceId.db";
            a = "/sdcard/libs/" + packageName + ".properties";
            d = "/sdcard/libs/" + packageName + ".bin";
            e = com.igexin.push.core.e.l.getFilesDir().getPath() + "/" + packageName + ".properties";
            g = com.igexin.push.core.e.l.getFilesDir().getPath() + "/" + packageName + "-guard.properties";
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.igexin.push.core.e.l.getCacheDir());
            sb.append("/ImgCache/");
            f = sb.toString();
            j = "/sdcard/libs/com.getui.sdk.deviceId.db";
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(java.io.File file) {
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (java.io.File file2 : fileArrListFiles) {
                while (file2.exists()) {
                    if (file2.isFile()) {
                        file2.delete();
                    } else if (!file2.delete()) {
                        a(file2);
                    }
                }
            }
        }
        file.delete();
    }

    public static void a(byte[] bArr, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                if (str.startsWith("/sdcard/libs") && !k()) {
                    return;
                }
                java.io.File file = new java.io.File(str);
                if (!b(file)) {
                    return;
                }
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file, false);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                        return;
                    } catch (java.lang.Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                        return;
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.lang.Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
        }
        com.igexin.c.a.c.a.a(e);
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (java.lang.Exception e6) {
                com.igexin.c.a.c.a.a(e6);
            }
        }
    }

    public static boolean a(android.content.Context context) {
        return (new java.io.File(context.getFilesDir().getAbsolutePath(), com.igexin.push.core.d.d.a).exists() || new com.igexin.sdk.main.SdkInitSwitch(context).isSwitchOn()) ? false : true;
    }

    public static java.lang.String b(android.content.Context context) {
        return context.getExternalFilesDir("gtpush") + "/log/";
    }

    public static void b() {
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | save session to file no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return;
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                java.io.File file = new java.io.File(b);
                if (!file.exists() && !file.createNewFile()) {
                    com.igexin.c.a.c.a.a("FileUtils | create file : " + file.toString() + " failed !!!", new java.lang.Object[0]);
                    return;
                }
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(b);
                try {
                    java.lang.String str = com.igexin.push.config.c.v + com.igexin.push.g.o.c();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(str);
                    sb.append(com.igexin.push.core.e.z);
                    sb.append("|");
                    sb.append(com.igexin.push.core.e.a);
                    sb.append("|");
                    sb.append(com.igexin.push.core.e.A);
                    sb.append("|");
                    com.igexin.push.core.ServiceManager.getInstance();
                    sb.append(com.igexin.push.core.ServiceManager.d(com.igexin.push.core.e.l));
                    fileOutputStream2.write(com.igexin.c.a.a.a.b(sb.toString().getBytes(), com.igexin.push.core.e.M));
                    try {
                        fileOutputStream2.close();
                    } catch (java.io.IOException e2) {
                        com.igexin.c.a.c.a.a(e2);
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("FileUtils | " + e.toString(), new java.lang.Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException e5) {
                            com.igexin.c.a.c.a.a(e5);
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception e6) {
                e = e6;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static boolean b(java.io.File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            return file.canWrite();
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static byte[] b(java.lang.String str) throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        byte[] byteArray = null;
        if (!new java.io.File(str).exists()) {
            com.igexin.c.a.c.a.a(h, "get data from file = " + str + " file not exist ######");
            com.igexin.c.a.c.a.a("FileUtils|get data from file = " + str + " file not exist ######", new java.lang.Object[0]);
            return null;
        }
        if (!c(new java.io.File(str))) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            fileInputStream = new java.io.FileInputStream(str);
        } catch (java.lang.Exception e2) {
            e = e2;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (java.lang.Throwable th) {
            th = th;
            byteArrayOutputStream = null;
            com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream2);
            com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream);
            throw th;
        }
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        } catch (java.lang.Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
            com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream2);
            com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream);
            throw th;
        }
        while (true) {
            try {
                try {
                    int i2 = fileInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                } catch (java.lang.Exception e4) {
                    e = e4;
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("FileUtils|" + e.toString(), new java.lang.Object[0]);
                }
                com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream);
                com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream);
                return byteArray;
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream2);
                com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream);
                throw th;
            }
        }
        byteArray = byteArrayOutputStream.toByteArray();
        com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream);
        com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream);
        return byteArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c() throws java.lang.Throwable {
        /*
            boolean r0 = p()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L1e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "FileUtils | read file cid no permission , v-"
            r0.<init>(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.igexin.c.a.c.a.a(r0, r1)
            return r2
        L1e:
            java.lang.String r0 = com.igexin.push.g.k.b     // Catch: java.lang.Exception -> L57
            byte[] r0 = b(r0)     // Catch: java.lang.Exception -> L57
            if (r0 != 0) goto L2e
            java.lang.String r0 = "FileUtils | read file cid id = null"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L57
            com.igexin.c.a.c.a.a(r0, r3)     // Catch: java.lang.Exception -> L57
            return r2
        L2e:
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Exception -> L57
            java.lang.String r4 = com.igexin.push.core.e.M     // Catch: java.lang.Exception -> L57
            byte[] r0 = com.igexin.c.a.a.a.a(r0, r4)     // Catch: java.lang.Exception -> L57
            r3.<init>(r0)     // Catch: java.lang.Exception -> L57
            java.lang.String r0 = "\\|"
            java.lang.String[] r0 = r3.split(r0)     // Catch: java.lang.Exception -> L57
            int r3 = r0.length     // Catch: java.lang.Exception -> L57
            r4 = 2
            if (r3 <= r4) goto L5b
            r0 = r0[r4]     // Catch: java.lang.Exception -> L57
            if (r0 == 0) goto L50
            java.lang.String r3 = "null"
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Exception -> L52
            if (r3 == 0) goto L50
            goto L5b
        L50:
            r2 = r0
            goto L5b
        L52:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L58
        L57:
            r0 = move-exception
        L58:
            com.igexin.c.a.c.a.a(r0)
        L5b:
            java.lang.String r0 = "FileUtils|get cid from file cid = "
            java.lang.String r3 = java.lang.String.valueOf(r2)
            java.lang.String r0 = r0.concat(r3)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.igexin.c.a.c.a.a(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.g.k.c():java.lang.String");
    }

    private static void c(java.lang.String str) throws java.lang.Throwable {
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | saveDeviceIdToNewFile no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("FileUtils|save deviceId = " + str + " to " + j, new java.lang.Object[0]);
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = new java.util.concurrent.locks.ReentrantReadWriteLock().writeLock();
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                if (writeLock.tryLock()) {
                    java.io.File file = new java.io.File(j);
                    if (!file.exists() && !file.createNewFile()) {
                        com.igexin.c.a.c.a.a("FileUtils|create file " + file.toString() + " failed", new java.lang.Object[0]);
                        com.igexin.c.a.b.g.a((java.io.Closeable) null);
                        writeLock.unlock();
                        return;
                    }
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(j);
                    try {
                        fileOutputStream2.write(com.igexin.c.b.a.b("V1|".concat(java.lang.String.valueOf(str)).getBytes(com.igexin.push.g.s.b)));
                        fileOutputStream = fileOutputStream2;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.c.a.a(e);
                        com.igexin.c.a.c.a.a("FileUtils|" + e.toString(), new java.lang.Object[0]);
                        com.igexin.c.a.b.g.a(fileOutputStream);
                        writeLock.unlock();
                        return;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.b.g.a(fileOutputStream);
                        writeLock.unlock();
                        throw th;
                    }
                }
                com.igexin.c.a.b.g.a(fileOutputStream);
                writeLock.unlock();
            } catch (java.lang.Exception e3) {
                e = e3;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static boolean c(java.io.File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            return file.canRead();
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static java.lang.String d() {
        java.lang.String str = null;
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | get device id from file no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return null;
        }
        try {
            com.igexin.c.a.c.a.a("FileUtils|get device id from file : " + c, new java.lang.Object[0]);
            byte[] bArrB = b(c);
            if (bArrB == null) {
                com.igexin.c.a.c.a.a(h, "read file device id = null");
                com.igexin.c.a.c.a.a("FileUtils|read file device id = null", new java.lang.Object[0]);
                return null;
            }
            java.lang.String str2 = new java.lang.String(bArrB, com.igexin.push.g.s.b);
            try {
                com.igexin.c.a.c.a.a("FileUtils|read file device id = ".concat(str2), new java.lang.Object[0]);
                return str2;
            } catch (java.lang.Exception e2) {
                e = e2;
                str = str2;
                com.igexin.c.a.c.a.a(e);
                com.igexin.c.a.c.a.a("FileUtils|get device id from file : " + e.toString(), new java.lang.Object[0]);
                return str;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
        }
    }

    private static void d(java.lang.String str) {
        try {
            com.igexin.push.core.e.f.a().a(str);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static long e() {
        byte[] bArrB;
        long j2 = 0;
        if (!p()) {
            com.igexin.c.a.c.a.a("FileUtils | get session from file no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return 0L;
        }
        try {
            bArrB = b(b);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(h, e2.toString());
            com.igexin.c.a.c.a.a("FileUtils|" + e2.toString(), new java.lang.Object[0]);
        }
        if (bArrB == null) {
            com.igexin.c.a.c.a.a(h, "read session from file, not exist");
            com.igexin.c.a.c.a.a("FileUtils|read session from file, not exist", new java.lang.Object[0]);
            return 0L;
        }
        java.lang.String str = new java.lang.String(com.igexin.c.a.a.a.a(bArrB, com.igexin.push.core.e.M));
        java.lang.String strSubstring = str.contains(com.igexin.push.core.b.m) ? str.substring(7) : str.substring(20);
        int iIndexOf = strSubstring.indexOf("|");
        if (iIndexOf >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        long j3 = java.lang.Long.parseLong(strSubstring);
        if (j3 != 0) {
            j2 = j3;
        }
        com.igexin.c.a.c.a.a("FileUtils|session : ".concat(java.lang.String.valueOf(j2)), new java.lang.Object[0]);
        return j2;
    }

    public static void f() {
        if (com.igexin.push.core.e.H == null) {
            return;
        }
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | save device id to file no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("FileUtils|save device id to file : " + c, new java.lang.Object[0]);
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = new java.util.concurrent.locks.ReentrantReadWriteLock().writeLock();
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                if (writeLock.tryLock()) {
                    java.io.File file = new java.io.File(c);
                    if (!file.exists() && !file.createNewFile()) {
                        com.igexin.c.a.c.a.a("FileUtils|create file : " + file.toString() + " failed !!!", new java.lang.Object[0]);
                        writeLock.unlock();
                        return;
                    }
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(c);
                    try {
                        byte[] bytes = com.igexin.push.core.e.H.getBytes(com.igexin.push.g.s.b);
                        new java.lang.String(bytes, com.igexin.push.g.s.b);
                        fileOutputStream2.write(bytes);
                        fileOutputStream = fileOutputStream2;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.c.a.a(e);
                        com.igexin.c.a.c.a.a("FileUtils|" + e.toString(), new java.lang.Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException e3) {
                                com.igexin.c.a.c.a.a(e3);
                            }
                        }
                        writeLock.unlock();
                        return;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException e4) {
                                com.igexin.c.a.c.a.a(e4);
                            }
                        }
                        writeLock.unlock();
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException e5) {
                        com.igexin.c.a.c.a.a(e5);
                    }
                }
                writeLock.unlock();
            } catch (java.lang.Exception e6) {
                e = e6;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void g() {
        byte[] bytes = com.igexin.push.core.e.A.getBytes();
        byte[] bArr = new byte[bytes.length];
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[i2] = (byte) (bytes[i2] ^ com.igexin.push.core.e.ad[i2]);
        }
        com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.d, android.util.Base64.encodeToString(bArr, 0));
    }

    public static void h() {
        java.io.File[] fileArrListFiles;
        java.io.File file = new java.io.File(f);
        if (file.exists() && (fileArrListFiles = file.listFiles(new java.io.FileFilter() { // from class: com.igexin.push.g.k.1
            final long a = java.lang.System.currentTimeMillis();
            final long b = 604800000;

            @Override // java.io.FileFilter
            public final boolean accept(java.io.File file2) {
                return this.a - file2.lastModified() >= 604800000;
            }
        })) != null) {
            for (java.io.File file2 : fileArrListFiles) {
                file2.delete();
            }
        }
    }

    public static void i() {
        java.io.File[] fileArrListFiles;
        if (k()) {
            java.io.File file = new java.io.File(com.getui.gtc.base.GtcProvider.getSdcardPath() + "/Sdk/WebCache/");
            if (file.exists() && (fileArrListFiles = file.listFiles(new java.io.FileFilter() { // from class: com.igexin.push.g.k.2
                final long a = java.lang.System.currentTimeMillis();
                final long b = 604800000;

                @Override // java.io.FileFilter
                public final boolean accept(java.io.File file2) {
                    return this.a - file2.lastModified() >= 604800000;
                }
            })) != null) {
                for (java.io.File file2 : fileArrListFiles) {
                    if (file2.exists()) {
                        a(file2);
                    }
                }
            }
        }
    }

    public static void j() throws java.lang.Throwable {
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtilsupdateDeviceId no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return;
        }
        java.lang.String strN = n();
        java.lang.String str = com.igexin.push.core.e.H;
        com.igexin.c.a.c.a.a("FileUtils|read deviceId.db = " + strN + "; CoreRuntimeInfo.deviceId = " + com.igexin.push.core.e.H, new java.lang.Object[0]);
        if (strN != null) {
            if (strN.equals(com.igexin.push.core.e.H)) {
                return;
            }
            com.igexin.push.core.e.H = strN;
            try {
                com.igexin.push.core.e.f.a().a(strN);
                return;
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
                return;
            }
        }
        if (com.igexin.push.core.e.H == null) {
            return;
        }
        java.lang.String str2 = com.igexin.push.core.e.H;
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | saveDeviceIdToNewFile no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("FileUtils|save deviceId = " + str2 + " to " + j, new java.lang.Object[0]);
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = new java.util.concurrent.locks.ReentrantReadWriteLock().writeLock();
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                if (writeLock.tryLock()) {
                    java.io.File file = new java.io.File(j);
                    if (!file.exists() && !file.createNewFile()) {
                        com.igexin.c.a.c.a.a("FileUtils|create file " + file.toString() + " failed", new java.lang.Object[0]);
                        com.igexin.c.a.b.g.a((java.io.Closeable) null);
                        writeLock.unlock();
                        return;
                    }
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(j);
                    try {
                        fileOutputStream2.write(com.igexin.c.b.a.b("V1|".concat(java.lang.String.valueOf(str2)).getBytes(com.igexin.push.g.s.b)));
                        fileOutputStream = fileOutputStream2;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.c.a.a(e);
                        com.igexin.c.a.c.a.a("FileUtils|" + e.toString(), new java.lang.Object[0]);
                        com.igexin.c.a.b.g.a(fileOutputStream);
                        writeLock.unlock();
                        return;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.b.g.a(fileOutputStream);
                        writeLock.unlock();
                        throw th;
                    }
                }
                com.igexin.c.a.b.g.a(fileOutputStream);
                writeLock.unlock();
            } catch (java.lang.Exception e3) {
                e = e3;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    public static boolean k() {
        boolean z;
        boolean z2;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                return false;
            }
            java.lang.String[] strArrSplit = com.igexin.push.config.d.ab.split("\\|");
            boolean z3 = true;
            if (strArrSplit.length == 2) {
                java.lang.String binaryString = java.lang.Integer.toBinaryString(java.lang.Integer.parseInt(strArrSplit[0]));
                z2 = binaryString.length() >= 2 && binaryString.charAt(binaryString.length() - 2) == '1';
                z = "2".equals(strArrSplit[1]) || ("1".equals(strArrSplit[1]) && com.getui.gtc.base.util.CommonUtil.isAppForeground());
            } else {
                z = false;
                z2 = false;
            }
            boolean zHasPermission = com.getui.gtc.base.util.CommonUtil.hasPermission(com.igexin.push.core.e.l, com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE, false);
            if (!z2 || !z || !zHasPermission) {
                z3 = false;
            }
            if (z3) {
                java.io.File file = new java.io.File("/sdcard/libs");
                if (file.exists() && file.isFile()) {
                    com.igexin.c.a.c.a.a(h, "libs is file not directory, delete libs file +++++");
                    com.igexin.c.a.c.a.a("FileUtils|libs is file not directory, delete libs file ++++", new java.lang.Object[0]);
                    file.delete();
                }
                if (!file.exists() && !file.mkdir()) {
                    com.igexin.c.a.c.a.a(h, "create libs directory failed ++++++++");
                    com.igexin.c.a.c.a.a("FileUtils|create libs directory failed ++++++", new java.lang.Object[0]);
                }
            }
            return z3;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean l() {
        return true;
    }

    private static java.util.List<org.json.JSONObject> m() {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.FileInputStream fileInputStream;
        byte[] byteArray;
        if (!p()) {
            com.igexin.c.a.c.a.a("FileUtils | get appid cid list no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return null;
        }
        java.lang.String str = com.getui.gtc.base.GtcProvider.getSdcardPath() + "/libs";
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists() || !c(file)) {
                return null;
            }
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (java.io.File file2 : fileArrListFiles) {
                    if (file2 != null && file2.isFile() && file2.getName().indexOf(".db") > 0 && !file2.getName().equals("com.gt.sdk.deviceId.db") && !file2.getName().equals("com.getui.sdk.deviceId.db") && !file2.getName().equals("app.db") && !file2.getName().equals("imsi.db")) {
                        file2.getName();
                        java.lang.String strSubstring = file2.getName().substring(0, file2.getName().length() - 3);
                        if (com.igexin.push.g.c.d(strSubstring) && !com.igexin.push.core.e.l.getPackageName().equals(strSubstring)) {
                            byte[] bArr = new byte[1024];
                            try {
                                fileInputStream = new java.io.FileInputStream(file2);
                                try {
                                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                                    while (true) {
                                        try {
                                            try {
                                                int i2 = fileInputStream.read(bArr);
                                                if (i2 == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(bArr, 0, i2);
                                            } catch (java.lang.Exception e2) {
                                                e = e2;
                                                com.igexin.c.a.c.a.a(e);
                                                com.igexin.c.a.c.a.a("FileUtils| read " + strSubstring + "excetpion:" + e.toString(), new java.lang.Object[0]);
                                                if (fileInputStream != null) {
                                                    fileInputStream.close();
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    byteArrayOutputStream.close();
                                                }
                                                byteArray = null;
                                            }
                                        } catch (java.lang.Throwable th) {
                                            th = th;
                                            if (fileInputStream != null) {
                                                fileInputStream.close();
                                            }
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    byteArray = byteArrayOutputStream.toByteArray();
                                    fileInputStream.close();
                                    byteArrayOutputStream.close();
                                } catch (java.lang.Exception e3) {
                                    e = e3;
                                    byteArrayOutputStream = null;
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = null;
                                }
                            } catch (java.lang.Exception e4) {
                                e = e4;
                                byteArrayOutputStream = null;
                                fileInputStream = null;
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                byteArrayOutputStream = null;
                                fileInputStream = null;
                            }
                            if (byteArray == null) {
                                com.igexin.c.a.c.a.a("FileUtils|read " + strSubstring + "bytes == null", new java.lang.Object[0]);
                            } else {
                                java.lang.String[] strArrSplit = new java.lang.String(com.igexin.c.a.a.a.a(byteArray, com.igexin.push.core.e.M)).split("\\|");
                                if (strArrSplit.length > 2) {
                                    try {
                                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                                        jSONObject.put("cid", strArrSplit[2]);
                                        jSONObject.put("appid", strArrSplit[1]);
                                        arrayList.add(jSONObject);
                                    } catch (java.lang.Exception unused) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (java.lang.Throwable th4) {
            com.igexin.c.a.c.a.a(th4);
            return null;
        }
    }

    private static java.lang.String n() throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.FileInputStream fileInputStream;
        java.lang.String str = null;
        str = null;
        str = null;
        str = null;
        java.io.FileInputStream fileInputStream2 = null;
        if (!p()) {
            com.igexin.c.a.c.a.a("FileUtils | getDeviceIdFromNewFile no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return null;
        }
        java.io.File file = new java.io.File(j);
        if (!c(file)) {
            return null;
        }
        if (file.exists()) {
            byte[] bArr = new byte[1024];
            try {
                fileInputStream = new java.io.FileInputStream(j);
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                } catch (java.lang.Exception e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                    fileInputStream2 = fileInputStream;
                    com.igexin.c.a.b.g.a(fileInputStream2);
                    com.igexin.c.a.b.g.a(byteArrayOutputStream);
                    throw th;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                fileInputStream = null;
                byteArrayOutputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                com.igexin.c.a.b.g.a(fileInputStream2);
                com.igexin.c.a.b.g.a(byteArrayOutputStream);
                throw th;
            }
            while (true) {
                try {
                    try {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        com.igexin.c.a.c.a.a(e);
                    }
                    com.igexin.c.a.b.g.a(fileInputStream);
                    com.igexin.c.a.b.g.a(byteArrayOutputStream);
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    fileInputStream2 = fileInputStream;
                    com.igexin.c.a.b.g.a(fileInputStream2);
                    com.igexin.c.a.b.g.a(byteArrayOutputStream);
                    throw th;
                }
            }
            java.lang.String[] strArrSplit = new java.lang.String(com.igexin.c.b.a.c(byteArrayOutputStream.toByteArray()), com.igexin.push.g.s.b).split("\\|");
            if (strArrSplit.length > 1 && com.igexin.push.core.g.e.equals(strArrSplit[0])) {
                str = strArrSplit[1];
            }
            com.igexin.c.a.b.g.a(fileInputStream);
            com.igexin.c.a.b.g.a(byteArrayOutputStream);
        }
        return str;
    }

    private static void o() {
        java.io.File file = new java.io.File("/sdcard/libs");
        if (file.exists() && file.isFile()) {
            com.igexin.c.a.c.a.a(h, "libs is file not directory, delete libs file +++++");
            com.igexin.c.a.c.a.a("FileUtils|libs is file not directory, delete libs file ++++", new java.lang.Object[0]);
            file.delete();
        }
        if (file.exists() || file.mkdir()) {
            return;
        }
        com.igexin.c.a.c.a.a(h, "create libs directory failed ++++++++");
        com.igexin.c.a.c.a.a("FileUtils|create libs directory failed ++++++", new java.lang.Object[0]);
    }

    private static boolean p() {
        boolean z;
        boolean z2;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                return false;
            }
            java.lang.String[] strArrSplit = com.igexin.push.config.d.ab.split("|");
            if (strArrSplit.length == 2) {
                java.lang.String binaryString = java.lang.Integer.toBinaryString(java.lang.Integer.parseInt(strArrSplit[0]));
                z2 = binaryString.length() >= 2 && binaryString.charAt(binaryString.length() - 2) == '1';
                z = "2".equals(strArrSplit[1]) || ("1".equals(strArrSplit[1]) && com.getui.gtc.base.util.CommonUtil.isAppForeground());
            } else {
                z = false;
                z2 = false;
            }
            return z2 && z && com.getui.gtc.base.util.CommonUtil.hasPermission(com.igexin.push.core.e.l, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE, false);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }
}
