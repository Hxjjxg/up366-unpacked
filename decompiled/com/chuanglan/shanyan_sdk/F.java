package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class F {
    public static final int j = android.graphics.Color.parseColor("#FFFFFF");
    private static volatile com.chuanglan.shanyan_sdk.F k = null;
    private java.io.InputStream b;
    private android.view.View c;
    private android.graphics.Movie d;
    private android.graphics.Bitmap e;
    private android.graphics.Canvas f;
    private android.graphics.Paint h;
    private final long a = 16;
    private android.os.Handler g = new android.os.Handler();
    private java.lang.Runnable i = new com.chuanglan.shanyan_sdk.F.a();

    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.chuanglan.shanyan_sdk.F.this.b();
                if (com.chuanglan.shanyan_sdk.F.this.c != null) {
                    com.chuanglan.shanyan_sdk.F.this.g.postDelayed(com.chuanglan.shanyan_sdk.F.this.i, 16L);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "GifDecoder  Exception_e=", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f.save();
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.h = paint;
        paint.setColor(j);
        this.h.setStyle(android.graphics.Paint.Style.FILL);
        this.h.setAntiAlias(true);
        this.h.setDither(true);
        this.f.drawPaint(this.h);
        this.d.setTime((int) (java.lang.System.currentTimeMillis() % ((long) this.d.duration())));
        this.d.draw(this.f, 0.0f, 0.0f);
        android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(this.e);
        android.view.View view = this.c;
        if (view != null) {
            view.setBackground(bitmapDrawable);
        }
        this.f.restore();
    }

    public static com.chuanglan.shanyan_sdk.F c() {
        if (k == null) {
            synchronized (com.chuanglan.shanyan_sdk.F.class) {
                if (k == null) {
                    k = new com.chuanglan.shanyan_sdk.F();
                }
            }
        }
        return k;
    }

    public com.chuanglan.shanyan_sdk.F a(java.io.InputStream inputStream) {
        b(inputStream);
        return this;
    }

    public void a() {
        if (this.c != null) {
            this.c = null;
        }
    }

    public void a(android.view.View view) {
        this.c = view;
        java.io.InputStream inputStream = this.b;
        if (inputStream == null) {
            return;
        }
        if (view == null) {
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "imagetView can not be null");
            return;
        }
        android.graphics.Movie movieDecodeStream = android.graphics.Movie.decodeStream(inputStream);
        this.d = movieDecodeStream;
        if (movieDecodeStream == null) {
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "Illegal movie file");
        } else {
            if (movieDecodeStream.width() <= 0 || this.d.height() <= 0) {
                return;
            }
            this.e = android.graphics.Bitmap.createBitmap(this.d.width(), this.d.height(), android.graphics.Bitmap.Config.RGB_565);
            this.f = new android.graphics.Canvas(this.e);
            this.g.post(this.i);
        }
    }

    public void b(java.io.InputStream inputStream) {
        java.io.InputStream inputStream2 = this.b;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        this.b = inputStream;
    }
}
