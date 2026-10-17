package com.igexin.push.core.h;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class b extends com.igexin.push.f.a.d {
    public static final int a = 2;
    public static final int b = 8;
    public static final int c = 65557;
    private static final java.lang.String d = "EXT-DownloadImgPlugin";
    private java.lang.String n;
    private com.igexin.push.extension.mod.BaseActionBean o;
    private int p;
    private com.igexin.push.core.h.d q;
    private java.lang.String r;

    public b(java.lang.String str, java.lang.String str2, java.lang.String str3, com.igexin.push.extension.mod.BaseActionBean baseActionBean, int i, com.igexin.push.core.h.d dVar) {
        super(str);
        this.o = baseActionBean;
        this.n = str3;
        this.p = i;
        this.q = dVar;
        this.r = str2;
        this.l = false;
    }

    private void a(java.lang.String str) {
        int i = this.p;
        if (i == 2) {
            ((com.igexin.push.core.b.l) this.o).D = str;
        } else {
            if (i != 8) {
                return;
            }
            ((com.igexin.push.core.b.l) this.o).E = str;
        }
    }

    private static void b() {
        java.io.File file = new java.io.File(com.igexin.push.g.k.f);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    @Override // com.igexin.push.f.a.d
    public final void a(java.lang.Exception exc) {
        com.igexin.push.core.h.d dVar = this.q;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.igexin.push.f.a.d
    public final void a(byte[] bArr) {
        this.m = false;
        try {
            java.io.File file = new java.io.File(com.igexin.push.g.k.f);
            if (!file.exists()) {
                file.mkdirs();
            }
            java.lang.String str = com.igexin.push.g.k.f + com.igexin.assist.util.a.a(this.r) + ".bin";
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(str);
            android.graphics.Bitmap.CompressFormat compressFormat = android.graphics.Bitmap.CompressFormat.PNG;
            android.graphics.Bitmap bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (bitmapDecodeByteArray != null) {
                bitmapDecodeByteArray.compress(compressFormat, 100, fileOutputStream);
                fileOutputStream.close();
                bitmapDecodeByteArray.recycle();
                int i = this.p;
                if (i == 2) {
                    ((com.igexin.push.core.b.l) this.o).D = str;
                } else if (i == 8) {
                    ((com.igexin.push.core.b.l) this.o).E = str;
                }
                this.m = true;
            } else {
                fileOutputStream.close();
                this.m = false;
            }
            if (this.q != null) {
                if (this.m) {
                    this.q.a(this.o);
                    return;
                }
                com.igexin.push.core.h.d dVar = this.q;
                new java.lang.Exception("no target existed or downloading bitmap failed!");
                dVar.a();
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return c;
    }
}
