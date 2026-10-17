package com.igexin.push.core.d;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class c {
    public static final java.lang.String a = "guard.me";
    public static final java.lang.String b = "guard.others";
    private static final java.lang.String c = "GuardConfig";
    private static final com.igexin.push.core.d.c d = new com.igexin.push.core.d.c();
    private long e;
    private final java.util.Map<java.lang.String, java.lang.String> f = new java.util.HashMap();

    private c() {
        try {
            if (android.text.TextUtils.isEmpty(com.igexin.push.g.k.g)) {
                com.igexin.push.g.k.a();
            }
            java.io.File file = new java.io.File(com.igexin.push.g.k.g);
            if (file.exists()) {
                return;
            }
            file.createNewFile();
        } catch (java.io.IOException e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private int a(java.lang.String str, int... iArr) {
        try {
            return java.lang.Integer.parseInt(b(str));
        } catch (java.lang.NumberFormatException e) {
            com.igexin.c.a.c.a.a(e);
            if (iArr == null || iArr.length != 1) {
                return -1;
            }
            return iArr[0];
        }
    }

    private long a(java.lang.String str, long... jArr) {
        try {
            return java.lang.Long.parseLong(b(str));
        } catch (java.lang.NumberFormatException e) {
            com.igexin.c.a.c.a.a(e);
            if (jArr == null || jArr.length != 1) {
                return 0L;
            }
            return jArr[0];
        }
    }

    public static com.igexin.push.core.d.c a() {
        return d;
    }

    private static void a(com.igexin.push.core.g.a<java.io.RandomAccessFile> aVar) throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile;
        java.nio.channels.FileLock fileLockLock = null;
        try {
            randomAccessFile = new java.io.RandomAccessFile(new java.io.File(com.igexin.push.g.k.g), "rw");
            try {
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                    if (fileLockLock.isValid()) {
                        aVar.a(randomAccessFile);
                    }
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    com.getui.gtc.base.util.io.IOUtils.safeClose(randomAccessFile);
                } catch (java.lang.Exception e) {
                    e = e;
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("GuardConfig| getProcessLock err：" + e.toString(), new java.lang.Object[0]);
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    com.getui.gtc.base.util.io.IOUtils.safeClose(randomAccessFile);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (java.io.IOException unused3) {
                    }
                }
                com.getui.gtc.base.util.io.IOUtils.safeClose(randomAccessFile);
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            randomAccessFile = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (fileLockLock != null) {
                fileLockLock.release();
            }
            com.getui.gtc.base.util.io.IOUtils.safeClose(randomAccessFile);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(java.io.RandomAccessFile randomAccessFile) {
        int i;
        try {
            this.f.clear();
            while (true) {
                java.lang.String line = randomAccessFile.readLine();
                if (line == null) {
                    return true;
                }
                int iIndexOf = line.indexOf("=");
                if (iIndexOf >= 0 && (i = iIndexOf + 1) != line.length()) {
                    this.f.put(line.substring(0, iIndexOf), line.substring(i));
                }
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }

    private java.lang.String b(java.lang.String str) throws java.lang.Throwable {
        if (b()) {
            a(new com.igexin.push.core.g.a<java.io.RandomAccessFile>() { // from class: com.igexin.push.core.d.c.3
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(java.io.RandomAccessFile randomAccessFile) {
                    com.igexin.push.core.d.c.this.a(randomAccessFile);
                }

                @Override // com.igexin.push.core.g.a
                public final /* bridge */ /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
                    com.igexin.push.core.d.c.this.a(randomAccessFile);
                }
            });
        }
        return this.f.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        long jLastModified = new java.io.File(com.igexin.push.g.k.g).lastModified();
        boolean z = this.e != jLastModified;
        this.e = jLastModified;
        return z;
    }

    private static java.lang.Boolean c(java.lang.String str) {
        if (str == null) {
            return null;
        }
        if (str.equalsIgnoreCase("true")) {
            return java.lang.Boolean.TRUE;
        }
        if (str.equalsIgnoreCase("false")) {
            return java.lang.Boolean.FALSE;
        }
        return null;
    }

    public final java.lang.Boolean a(java.lang.String str) throws java.lang.Throwable {
        java.lang.String strB = b(str);
        if (strB == null) {
            return null;
        }
        return c(strB);
    }

    public final void a(final java.lang.String str, final java.lang.Object obj) throws java.lang.Throwable {
        a(new com.igexin.push.core.g.a<java.io.RandomAccessFile>() { // from class: com.igexin.push.core.d.c.2
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
            private void a2(java.io.RandomAccessFile randomAccessFile) {
                if (com.igexin.push.core.d.c.this.b()) {
                    com.igexin.push.core.d.c.this.a(randomAccessFile);
                }
                com.igexin.push.core.d.c.this.f.put(str, java.lang.String.valueOf(obj));
                try {
                    randomAccessFile.setLength(0L);
                    for (java.util.Map.Entry entry : com.igexin.push.core.d.c.this.f.entrySet()) {
                        randomAccessFile.writeBytes(((java.lang.String) entry.getKey()) + "=" + ((java.lang.String) entry.getValue()));
                        randomAccessFile.writeBytes("\n");
                    }
                } catch (java.io.IOException e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }

            @Override // com.igexin.push.core.g.a
            public final /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
                java.io.RandomAccessFile randomAccessFile2 = randomAccessFile;
                if (com.igexin.push.core.d.c.this.b()) {
                    com.igexin.push.core.d.c.this.a(randomAccessFile2);
                }
                com.igexin.push.core.d.c.this.f.put(str, java.lang.String.valueOf(obj));
                try {
                    randomAccessFile2.setLength(0L);
                    for (java.util.Map.Entry entry : com.igexin.push.core.d.c.this.f.entrySet()) {
                        randomAccessFile2.writeBytes(((java.lang.String) entry.getKey()) + "=" + ((java.lang.String) entry.getValue()));
                        randomAccessFile2.writeBytes("\n");
                    }
                } catch (java.io.IOException e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }
        }.a(new com.igexin.push.core.g.a<java.io.RandomAccessFile>() { // from class: com.igexin.push.core.d.c.1
            private void a() {
                com.igexin.push.core.d.c.this.b();
            }

            @Override // com.igexin.push.core.g.a
            public final /* bridge */ /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
                com.igexin.push.core.d.c.this.b();
            }
        }));
    }
}
