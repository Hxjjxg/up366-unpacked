package com.igexin.push.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class e {
    private static final java.lang.String a = "GT-ImageLoader";
    private static final com.getui.gtc.base.http.GtHttpClient b = new com.getui.gtc.base.http.GtHttpClient.Builder().addInterceptor(new com.getui.gtc.base.http.Interceptor() { // from class: com.igexin.push.a.e.2
        public final com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
            byte[] file;
            com.getui.gtc.base.http.Request request = chain.request();
            if (!com.igexin.push.a.e.a.equals(request.tag())) {
                return chain.proceed(request);
            }
            try {
                java.io.File file2 = new java.io.File(com.getui.gtc.base.GtcProvider.context().getCacheDir(), com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", request.url().toString().getBytes()));
                if (file2.exists() && (file = com.getui.gtc.base.util.io.IOUtils.readFile(file2)) != null && file.length > 0) {
                    return new com.getui.gtc.base.http.Response.Builder().request(request).code(200).body(com.getui.gtc.base.http.ResponseBody.create(com.getui.gtc.base.http.MediaType.parse("image/cache"), file)).message("cache success").build();
                }
            } catch (java.lang.Throwable unused) {
            }
            com.getui.gtc.base.http.Response responseProceed = chain.proceed(request);
            com.getui.gtc.base.http.ResponseBody responseBodyBody = responseProceed.body();
            byte[] bArrBytes = responseBodyBody.bytes();
            try {
                com.getui.gtc.base.util.io.IOUtils.saveToFile(bArrBytes, new java.io.File(com.getui.gtc.base.GtcProvider.context().getCacheDir(), com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", request.url().toString().getBytes())));
            } catch (java.lang.Throwable unused2) {
            }
            return responseProceed.newBuilder().body(com.getui.gtc.base.http.ResponseBody.create(responseBodyBody.contentType(), bArrBytes)).build();
        }
    }).addInterceptor(new com.getui.gtc.base.http.Interceptor() { // from class: com.igexin.push.a.e.1
        public final com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
            if (com.getui.gtc.base.util.NetworkUtil.isNetWorkAvailable(com.getui.gtc.base.GtcProvider.context())) {
                return chain.proceed(chain.request());
            }
            throw new java.lang.IllegalStateException("network is not available");
        }
    }).build();

    public interface a<T> {
        void a(T t);

        void a(java.lang.Throwable th);
    }

    static class b<T> implements com.igexin.push.a.e.a<T> {
        private static final android.os.Handler a = new android.os.Handler(android.os.Looper.getMainLooper());
        private final com.igexin.push.a.e.a<T> b;

        b(com.igexin.push.a.e.a<T> aVar) {
            this.b = aVar;
        }

        @Override // com.igexin.push.a.e.a
        public final void a(final T t) {
            if (this.b != null) {
                a.post(new java.lang.Runnable() { // from class: com.igexin.push.a.e.b.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.igexin.push.a.e.b.this.b.a(t);
                    }
                });
            }
        }

        @Override // com.igexin.push.a.e.a
        public final void a(final java.lang.Throwable th) {
            if (this.b != null) {
                a.post(new java.lang.Runnable() { // from class: com.igexin.push.a.e.b.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.igexin.push.a.e.b.this.b.a(th);
                    }
                });
            }
        }
    }

    public static class c {
        public int a = 20;
        public boolean b = true;
        public boolean c = true;
        public boolean d = true;
        public boolean e = true;
    }

    private static android.graphics.Bitmap a(android.content.res.Resources resources, int i, int i2, int i3, boolean z) throws java.io.IOException {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeResource(resources, i, options);
        if (i2 > 0 || i3 > 0) {
            a(i2, i3, options, z);
        }
        options.inJustDecodeBounds = false;
        android.graphics.Bitmap bitmapDecodeResource = android.graphics.BitmapFactory.decodeResource(resources, i, options);
        if (bitmapDecodeResource != null) {
            return bitmapDecodeResource;
        }
        throw new java.io.IOException("Failed to decode data.");
    }

    public static android.graphics.Bitmap a(android.graphics.Bitmap bitmap, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setFlags(1);
        float f = i;
        canvas.drawRoundRect(new android.graphics.RectF(new android.graphics.Rect(0, 0, width, height)), f, f, paint);
        if (!z) {
            canvas.drawRect(new android.graphics.RectF(0.0f, 0.0f, f, f), paint);
        }
        if (!z2) {
            canvas.drawRect(new android.graphics.RectF(width - i, 0.0f, width, f), paint);
        }
        if (!z3) {
            canvas.drawRect(new android.graphics.RectF(width - i, height - i, width, height), paint);
        }
        if (!z4) {
            canvas.drawRect(new android.graphics.RectF(0.0f, height - i, f, height), paint);
        }
        android.graphics.Paint paint2 = new android.graphics.Paint();
        paint2.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint2);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    public static android.graphics.Bitmap a(byte[] bArr, int i, int i2, boolean z) throws java.io.IOException {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (i > 0 || i2 > 0) {
            a(i, i2, options, z);
        }
        options.inJustDecodeBounds = false;
        android.graphics.Bitmap bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (bitmapDecodeByteArray != null) {
            return bitmapDecodeByteArray;
        }
        throw new java.io.IOException("Failed to decode data.");
    }

    private static android.graphics.Movie a(android.content.res.Resources resources, int i) {
        return android.graphics.Movie.decodeStream(resources.openRawResource(i));
    }

    public static android.graphics.Movie a(byte[] bArr) {
        return android.graphics.Movie.decodeByteArray(bArr, 0, bArr.length);
    }

    private static void a(int i, int i2, android.graphics.BitmapFactory.Options options, boolean z) {
        int iMax;
        double d;
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                d = i3 / i;
            } else if (i == 0) {
                d = i4 / i2;
            } else {
                int iFloor = (int) java.lang.Math.floor(i4 / i2);
                int iFloor2 = (int) java.lang.Math.floor(i3 / i);
                iMax = z ? java.lang.Math.max(iFloor, iFloor2) : java.lang.Math.min(iFloor, iFloor2);
            }
            iMax = (int) java.lang.Math.floor(d);
        } else {
            iMax = 1;
        }
        options.inSampleSize = iMax;
    }

    public static void a(java.lang.String str, final int i, com.igexin.push.a.e.a<android.graphics.Bitmap> aVar) {
        final com.igexin.push.a.e.b bVar = new com.igexin.push.a.e.b(aVar);
        b(str, 2, new com.getui.gtc.base.http.Call.Callback() { // from class: com.igexin.push.a.e.3
            final /* synthetic */ int c = 0;
            final /* synthetic */ boolean d = true;
            final /* synthetic */ com.igexin.push.a.e.c e = null;

            public final void onFailure(com.getui.gtc.base.http.Call call, java.lang.Exception exc) {
                bVar.a((java.lang.Throwable) exc);
            }

            public final void onResponse(com.getui.gtc.base.http.Call call, com.getui.gtc.base.http.Response response) {
                try {
                    android.graphics.Bitmap bitmapA = com.igexin.push.a.e.a(response.getBody(), i, this.c, this.d);
                    com.igexin.push.a.e.c cVar = this.e;
                    if (cVar != null && cVar.a > 0) {
                        bitmapA = com.igexin.push.a.e.a(bitmapA, this.e.a, this.e.b, this.e.c, this.e.d, this.e.e);
                    }
                    if (bitmapA != null) {
                        bVar.a(bitmapA);
                        return;
                    }
                    bVar.a((java.lang.Throwable) new java.lang.IllegalStateException("decode bitmap failed:" + call.request()));
                } catch (java.lang.Throwable th) {
                    bVar.a(th);
                }
            }
        });
    }

    public static void a(java.lang.String str, com.igexin.push.a.e.a<byte[]> aVar) {
        final com.igexin.push.a.e.b bVar = new com.igexin.push.a.e.b(aVar);
        b(str, 2, new com.getui.gtc.base.http.Call.Callback() { // from class: com.igexin.push.a.e.4
            public final void onFailure(com.getui.gtc.base.http.Call call, java.lang.Exception exc) {
                bVar.a((java.lang.Throwable) exc);
            }

            public final void onResponse(com.getui.gtc.base.http.Call call, com.getui.gtc.base.http.Response response) {
                try {
                    byte[] body = response.getBody();
                    if (body != null) {
                        bVar.a(body);
                        return;
                    }
                    bVar.a((java.lang.Throwable) new java.lang.IllegalStateException("decode gif failed:" + call.request()));
                } catch (java.lang.Throwable th) {
                    bVar.a(th);
                }
            }
        });
    }

    public static boolean a(java.lang.String str) {
        try {
            return new java.io.File(com.getui.gtc.base.GtcProvider.context().getCacheDir(), com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", str.toString().getBytes())).exists();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final java.lang.String str, final int i, final com.getui.gtc.base.http.Call.Callback callback) {
        b.newCall(new com.getui.gtc.base.http.Request.Builder().url(str).tag(a).method("GET").build()).enqueue(new com.getui.gtc.base.http.Call.Callback() { // from class: com.igexin.push.a.e.6
            public final void onFailure(com.getui.gtc.base.http.Call call, java.lang.Exception exc) {
                try {
                    if (i <= 0) {
                        callback.onFailure(call, exc);
                    } else {
                        java.lang.Thread.sleep(500L);
                        com.igexin.push.a.e.b(str, i - 1, callback);
                    }
                } catch (java.lang.Throwable th) {
                    callback.onFailure(call, new java.lang.RuntimeException(th));
                }
            }

            public final void onResponse(com.getui.gtc.base.http.Call call, com.getui.gtc.base.http.Response response) {
                callback.onResponse(call, response);
            }
        });
    }

    public static void b(java.lang.String str, com.igexin.push.a.e.a<android.graphics.Movie> aVar) {
        final com.igexin.push.a.e.b bVar = new com.igexin.push.a.e.b(aVar);
        b(str, 2, new com.getui.gtc.base.http.Call.Callback() { // from class: com.igexin.push.a.e.5
            public final void onFailure(com.getui.gtc.base.http.Call call, java.lang.Exception exc) {
                bVar.a((java.lang.Throwable) exc);
            }

            public final void onResponse(com.getui.gtc.base.http.Call call, com.getui.gtc.base.http.Response response) {
                try {
                    android.graphics.Movie movieA = com.igexin.push.a.e.a(response.getBody());
                    if (movieA != null) {
                        bVar.a(movieA);
                        return;
                    }
                    bVar.a((java.lang.Throwable) new java.lang.IllegalStateException("decode gif failed:" + call.request()));
                } catch (java.lang.Throwable th) {
                    bVar.a(th);
                }
            }
        });
    }
}
