package com.davemorrissey.labs.subscaleview.decoder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class SkiaImageRegionDecoder implements com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder {
    private static final java.lang.String ASSET_PREFIX = "file:///android_asset/";
    private static final java.lang.String FILE_PREFIX = "file://";
    private static final java.lang.String RESOURCE_PREFIX = "android.resource://";
    private final android.graphics.Bitmap.Config bitmapConfig;
    private android.graphics.BitmapRegionDecoder decoder;
    private final java.util.concurrent.locks.ReadWriteLock decoderLock;

    public SkiaImageRegionDecoder() {
        this(null);
    }

    public SkiaImageRegionDecoder(android.graphics.Bitmap.Config config) {
        this.decoderLock = new java.util.concurrent.locks.ReentrantReadWriteLock(true);
        android.graphics.Bitmap.Config preferredBitmapConfig = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = android.graphics.Bitmap.Config.RGB_565;
        }
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public android.graphics.Point init(android.content.Context context, android.net.Uri uri) throws java.lang.Exception {
        android.content.res.Resources resourcesForApplication;
        int identifier;
        java.lang.String string = uri.toString();
        if (string.startsWith(RESOURCE_PREFIX)) {
            java.lang.String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resourcesForApplication = context.getResources();
            } else {
                resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
            }
            java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else if (size == 1 && android.text.TextUtils.isDigitsOnly(pathSegments.get(0))) {
                try {
                    identifier = java.lang.Integer.parseInt(pathSegments.get(0));
                } catch (java.lang.NumberFormatException unused) {
                    identifier = 0;
                }
            } else {
                identifier = 0;
            }
            this.decoder = android.graphics.BitmapRegionDecoder.newInstance(context.getResources().openRawResource(identifier), false);
        } else if (string.startsWith(ASSET_PREFIX)) {
            this.decoder = android.graphics.BitmapRegionDecoder.newInstance(context.getAssets().open(string.substring(22), 1), false);
        } else if (string.startsWith(FILE_PREFIX)) {
            this.decoder = android.graphics.BitmapRegionDecoder.newInstance(string.substring(7), false);
        } else {
            java.io.InputStream inputStreamOpenInputStream = null;
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                this.decoder = android.graphics.BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (java.lang.Exception unused2) {
                    }
                }
            } catch (java.lang.Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (java.lang.Exception unused3) {
                    }
                }
                throw th;
            }
        }
        return new android.graphics.Point(this.decoder.getWidth(), this.decoder.getHeight());
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public android.graphics.Bitmap decodeRegion(android.graphics.Rect rect, int i) {
        getDecodeLock().lock();
        try {
            android.graphics.BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
            if (bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled()) {
                android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                options.inSampleSize = i;
                options.inPreferredConfig = this.bitmapConfig;
                android.graphics.Bitmap bitmapDecodeRegion = this.decoder.decodeRegion(rect, options);
                if (bitmapDecodeRegion != null) {
                    return bitmapDecodeRegion;
                }
                throw new java.lang.RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
            throw new java.lang.IllegalStateException("Cannot decode region after decoder has been recycled");
        } finally {
            getDecodeLock().unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isReady() {
        /*
            r1 = this;
            monitor-enter(r1)
            android.graphics.BitmapRegionDecoder r0 = r1.decoder     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Ld
            boolean r0 = r0.isRecycled()     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto Ld
            r0 = 1
            goto Le
        Ld:
            r0 = 0
        Le:
            monitor-exit(r1)
            return r0
        L10:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder.isReady():boolean");
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public synchronized void recycle() {
        this.decoderLock.writeLock().lock();
        try {
            this.decoder.recycle();
            this.decoder = null;
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    private java.util.concurrent.locks.Lock getDecodeLock() {
        return this.decoderLock.readLock();
    }
}
