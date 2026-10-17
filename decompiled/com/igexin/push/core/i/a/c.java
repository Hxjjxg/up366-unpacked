package com.igexin.push.core.i.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class c implements com.igexin.push.core.i.a.d.a {
    private java.util.ArrayList<android.graphics.Bitmap> a = null;
    private final java.lang.String b = "GifBitmapProvider";

    @Override // com.igexin.push.core.i.a.d.a
    public final android.graphics.Bitmap a(int i, int i2, android.graphics.Bitmap.Config config, int i3) {
        if (this.a == null) {
            java.util.ArrayList<android.graphics.Bitmap> arrayList = new java.util.ArrayList<>(2);
            this.a = arrayList;
            arrayList.add(0, android.graphics.Bitmap.createBitmap(i, i2, config));
            this.a.add(1, android.graphics.Bitmap.createBitmap(i, i2, config));
        }
        return this.a.get(i3 % 2);
    }

    @Override // com.igexin.push.core.i.a.d.a
    public final void a() {
        java.util.ArrayList<android.graphics.Bitmap> arrayList = this.a;
        if (arrayList != null) {
            for (android.graphics.Bitmap bitmap : arrayList) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
            this.a = null;
        }
    }

    @Override // com.igexin.push.core.i.a.d.a
    public final void a(android.graphics.Bitmap bitmap) {
        com.igexin.c.a.c.a.b("GifBitmapProvider", "release bitmap  ");
        bitmap.recycle();
    }

    @Override // com.igexin.push.core.i.a.d.a
    public final byte[] a(int i) {
        return new byte[i];
    }

    @Override // com.igexin.push.core.i.a.d.a
    public final void b() {
    }

    @Override // com.igexin.push.core.i.a.d.a
    public final int[] b(int i) {
        return new int[i];
    }

    @Override // com.igexin.push.core.i.a.d.a
    public final void c() {
    }
}
