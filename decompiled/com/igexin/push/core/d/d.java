package com.igexin.push.core.d;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class d {
    public static final java.lang.String a = "grp.prop";
    public static final java.lang.String b = "itmp";
    public static final java.lang.String c = "itop";
    public static final java.lang.String d = "c";
    public static final java.lang.String e = "i";
    public static final java.lang.String f = "p";
    public static final java.lang.String g = "s";
    private static final java.lang.String h = "RpConfig";
    private static final com.igexin.push.core.d.d i = new com.igexin.push.core.d.d();
    private final java.lang.String j;
    private long k;
    private final java.util.Map<java.lang.String, java.lang.String> l = new java.util.concurrent.ConcurrentHashMap();

    private d() {
        java.lang.String str = com.igexin.push.core.ServiceManager.b.getFilesDir().getAbsolutePath() + "/grp.prop";
        this.j = str;
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                return;
            }
            file.createNewFile();
        } catch (java.io.IOException e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private int a(java.lang.String str, int... iArr) {
        try {
            return java.lang.Integer.parseInt(a(str));
        } catch (java.lang.NumberFormatException e2) {
            com.igexin.c.a.c.a.a(e2);
            if (iArr == null || iArr.length != 1) {
                return -1;
            }
            return iArr[0];
        }
    }

    public static com.igexin.push.core.d.d a() {
        return i;
    }

    private java.util.ArrayList<java.lang.String> a(java.lang.String str, java.util.ArrayList<java.lang.String> arrayList) throws java.lang.Throwable {
        java.lang.String strA = a(str);
        try {
            if (android.text.TextUtils.isEmpty(strA)) {
                return arrayList;
            }
            java.util.ArrayList<java.lang.String> arrayList2 = new java.util.ArrayList<>();
            org.json.JSONArray jSONArray = new org.json.JSONArray(strA);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                java.lang.String strOptString = jSONArray.optString(i2);
                if (!android.text.TextUtils.isEmpty(strOptString)) {
                    arrayList2.add(strOptString);
                }
            }
            return arrayList2;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.igexin.push.core.g.a<java.io.RandomAccessFile> aVar) throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile;
        java.nio.channels.FileLock fileLockLock = null;
        try {
            randomAccessFile = new java.io.RandomAccessFile(new java.io.File(this.j), "rw");
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
                } catch (java.lang.Exception e2) {
                    e = e2;
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("RpConfig| getProcessLock err：" + e.toString(), new java.lang.Object[0]);
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
        } catch (java.lang.Exception e3) {
            e = e3;
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
        int i2;
        try {
            this.l.clear();
            while (true) {
                java.lang.String line = randomAccessFile.readLine();
                if (line == null) {
                    return true;
                }
                int iIndexOf = line.indexOf("=");
                if (iIndexOf >= 0 && (i2 = iIndexOf + 1) != line.length()) {
                    this.l.put(line.substring(0, iIndexOf), line.substring(i2));
                }
            }
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        long jLastModified = new java.io.File(this.j).lastModified();
        boolean z = this.k != jLastModified;
        this.k = jLastModified;
        return z;
    }

    private void c(final java.lang.String str) {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.d.d.2
            @Override // com.igexin.push.b.d
            public final void a_() throws java.lang.Exception {
                com.igexin.push.core.d.d.this.a(new com.igexin.push.core.g.a<java.io.RandomAccessFile>() { // from class: com.igexin.push.core.d.d.2.2
                    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                    private void a2(java.io.RandomAccessFile randomAccessFile) {
                        if (com.igexin.push.core.d.d.this.b()) {
                            com.igexin.push.core.d.d.this.a(randomAccessFile);
                        }
                        com.igexin.push.core.d.d.this.l.remove(str);
                        try {
                            randomAccessFile.setLength(0L);
                            for (java.util.Map.Entry entry : com.igexin.push.core.d.d.this.l.entrySet()) {
                                randomAccessFile.writeBytes(((java.lang.String) entry.getKey()) + "=" + ((java.lang.String) entry.getValue()));
                                randomAccessFile.writeBytes("\n");
                            }
                        } catch (java.io.IOException e2) {
                            com.igexin.c.a.c.a.a(e2);
                        }
                    }

                    @Override // com.igexin.push.core.g.a
                    public final /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
                        java.io.RandomAccessFile randomAccessFile2 = randomAccessFile;
                        if (com.igexin.push.core.d.d.this.b()) {
                            com.igexin.push.core.d.d.this.a(randomAccessFile2);
                        }
                        com.igexin.push.core.d.d.this.l.remove(str);
                        try {
                            randomAccessFile2.setLength(0L);
                            for (java.util.Map.Entry entry : com.igexin.push.core.d.d.this.l.entrySet()) {
                                randomAccessFile2.writeBytes(((java.lang.String) entry.getKey()) + "=" + ((java.lang.String) entry.getValue()));
                                randomAccessFile2.writeBytes("\n");
                            }
                        } catch (java.io.IOException e2) {
                            com.igexin.c.a.c.a.a(e2);
                        }
                    }
                }.a(new com.igexin.push.core.g.a<java.io.RandomAccessFile>() { // from class: com.igexin.push.core.d.d.2.1
                    private void a() {
                        com.igexin.push.core.d.d.this.b();
                    }

                    @Override // com.igexin.push.core.g.a
                    public final /* bridge */ /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
                        com.igexin.push.core.d.d.this.b();
                    }
                }));
            }
        }, false, true);
    }

    public final long a(java.lang.String str, long... jArr) {
        try {
            return java.lang.Long.parseLong(a(str));
        } catch (java.lang.NumberFormatException e2) {
            com.igexin.c.a.c.a.a(e2);
            if (jArr.length == 1) {
                return jArr[0];
            }
            return 0L;
        }
    }

    public final java.lang.String a(java.lang.String str) throws java.lang.Throwable {
        if (b()) {
            a(new com.igexin.push.core.g.a<java.io.RandomAccessFile>() { // from class: com.igexin.push.core.d.d.3
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(java.io.RandomAccessFile randomAccessFile) {
                    com.igexin.push.core.d.d.this.a(randomAccessFile);
                }

                @Override // com.igexin.push.core.g.a
                public final /* bridge */ /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
                    com.igexin.push.core.d.d.this.a(randomAccessFile);
                }
            });
        }
        return this.l.get(str);
    }

    public final void a(final java.lang.String str, final java.lang.Object obj) {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.d.d.1
            @Override // com.igexin.push.b.d
            public final void a_() throws java.lang.Exception {
                com.igexin.push.core.d.d.this.a(new com.igexin.push.core.g.a<java.io.RandomAccessFile>() { // from class: com.igexin.push.core.d.d.1.2
                    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                    private void a2(java.io.RandomAccessFile randomAccessFile) {
                        java.lang.String string;
                        if (com.igexin.push.core.d.d.this.b()) {
                            com.igexin.push.core.d.d.this.a(randomAccessFile);
                        }
                        if (obj instanceof java.util.List) {
                            try {
                                string = new org.json.JSONArray((java.util.Collection) obj).toString();
                            } catch (java.lang.Throwable th) {
                                com.igexin.c.a.c.a.a(th);
                                return;
                            }
                        } else {
                            string = java.lang.String.valueOf(obj);
                        }
                        com.igexin.push.core.d.d.this.l.put(str, string);
                        try {
                            randomAccessFile.setLength(0L);
                            for (java.util.Map.Entry entry : com.igexin.push.core.d.d.this.l.entrySet()) {
                                randomAccessFile.writeBytes(((java.lang.String) entry.getKey()) + "=" + ((java.lang.String) entry.getValue()));
                                randomAccessFile.writeBytes("\n");
                            }
                        } catch (java.io.IOException e2) {
                            com.igexin.c.a.c.a.a(e2);
                        }
                    }

                    @Override // com.igexin.push.core.g.a
                    public final /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
                        java.lang.String string;
                        java.io.RandomAccessFile randomAccessFile2 = randomAccessFile;
                        if (com.igexin.push.core.d.d.this.b()) {
                            com.igexin.push.core.d.d.this.a(randomAccessFile2);
                        }
                        if (obj instanceof java.util.List) {
                            try {
                                string = new org.json.JSONArray((java.util.Collection) obj).toString();
                            } catch (java.lang.Throwable th) {
                                com.igexin.c.a.c.a.a(th);
                                return;
                            }
                        } else {
                            string = java.lang.String.valueOf(obj);
                        }
                        com.igexin.push.core.d.d.this.l.put(str, string);
                        try {
                            randomAccessFile2.setLength(0L);
                            for (java.util.Map.Entry entry : com.igexin.push.core.d.d.this.l.entrySet()) {
                                randomAccessFile2.writeBytes(((java.lang.String) entry.getKey()) + "=" + ((java.lang.String) entry.getValue()));
                                randomAccessFile2.writeBytes("\n");
                            }
                        } catch (java.io.IOException e2) {
                            com.igexin.c.a.c.a.a(e2);
                        }
                    }
                }.a(new com.igexin.push.core.g.a<java.io.RandomAccessFile>() { // from class: com.igexin.push.core.d.d.1.1
                    private void a() {
                        com.igexin.push.core.d.d.this.b();
                    }

                    @Override // com.igexin.push.core.g.a
                    public final /* bridge */ /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
                        com.igexin.push.core.d.d.this.b();
                    }
                }));
            }
        }, false, true);
    }

    public final boolean b(java.lang.String str) {
        return java.lang.Boolean.parseBoolean(a(str));
    }
}
