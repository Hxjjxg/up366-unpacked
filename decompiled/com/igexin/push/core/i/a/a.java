package com.igexin.push.core.i.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class a {
    private static final java.lang.String a = "BufferGifDecoder";
    private final android.content.Context b;
    private final com.igexin.push.core.i.a.c d = new com.igexin.push.core.i.a.c();
    private final com.igexin.push.core.i.a.j c = new com.igexin.push.core.i.a.j();

    public a(android.content.Context context) {
        this.b = context.getApplicationContext();
    }

    private static int a(com.igexin.push.core.i.a.i iVar, int i, int i2) {
        int iMin = java.lang.Math.min(iVar.i / i2, iVar.h / i);
        int iMax = java.lang.Math.max(1, iMin == 0 ? 0 : java.lang.Integer.highestOneBit(iMin));
        com.igexin.c.a.c.a.b(a, "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + iVar.h + "x" + iVar.i + "]");
        return iMax;
    }

    private com.igexin.push.core.i.a.f a(java.nio.ByteBuffer byteBuffer, int i, int i2, com.igexin.push.core.i.a.j jVar) {
        com.igexin.push.core.i.a.i iVarB = jVar.b();
        if (iVarB.e <= 0 || iVarB.d != 0) {
            return null;
        }
        android.graphics.Bitmap.Config config = android.graphics.Bitmap.Config.ARGB_8888;
        int iMin = java.lang.Math.min(iVarB.i / i2, iVarB.h / i);
        int iMax = java.lang.Math.max(1, iMin == 0 ? 0 : java.lang.Integer.highestOneBit(iMin));
        com.igexin.c.a.c.a.b(a, "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + iVarB.h + "x" + iVarB.i + "]");
        com.igexin.push.core.i.a.n nVar = new com.igexin.push.core.i.a.n(this.d, iVarB, byteBuffer, iMax);
        nVar.a(config);
        nVar.e();
        android.graphics.Bitmap bitmapN = nVar.n();
        if (bitmapN == null) {
            return null;
        }
        return new com.igexin.push.core.i.a.f(new com.igexin.push.core.i.a.e(nVar, bitmapN));
    }

    private com.igexin.push.core.i.a.f a(byte[] bArr, int i, int i2) {
        return a(java.nio.ByteBuffer.wrap(bArr), i, i2);
    }

    public final com.igexin.push.core.i.a.f a(java.nio.ByteBuffer byteBuffer, int i, int i2) {
        com.igexin.push.core.i.a.j jVarA = this.c.a(byteBuffer);
        com.igexin.push.core.i.a.f fVar = null;
        try {
            com.igexin.push.core.i.a.i iVarB = jVarA.b();
            if (iVarB.e > 0 && iVarB.d == 0) {
                android.graphics.Bitmap.Config config = android.graphics.Bitmap.Config.ARGB_8888;
                int iMin = java.lang.Math.min(iVarB.i / i2, iVarB.h / i);
                int iMax = java.lang.Math.max(1, iMin == 0 ? 0 : java.lang.Integer.highestOneBit(iMin));
                com.igexin.c.a.c.a.b(a, "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + iVarB.h + "x" + iVarB.i + "]");
                com.igexin.push.core.i.a.n nVar = new com.igexin.push.core.i.a.n(this.d, iVarB, byteBuffer, iMax);
                nVar.a(config);
                nVar.e();
                android.graphics.Bitmap bitmapN = nVar.n();
                if (bitmapN != null) {
                    fVar = new com.igexin.push.core.i.a.f(new com.igexin.push.core.i.a.e(nVar, bitmapN));
                }
            }
            return fVar;
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                return null;
            } finally {
                jVarA.a();
            }
        }
    }
}
