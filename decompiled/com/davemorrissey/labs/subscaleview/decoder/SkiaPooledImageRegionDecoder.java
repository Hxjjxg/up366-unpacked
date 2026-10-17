package com.davemorrissey.labs.subscaleview.decoder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class SkiaPooledImageRegionDecoder implements com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder {
    private static final java.lang.String ASSET_PREFIX = "file:///android_asset/";
    private static final java.lang.String FILE_PREFIX = "file://";
    private static final java.lang.String RESOURCE_PREFIX = "android.resource://";
    private static final java.lang.String TAG = "SkiaPooledImageRegionDecoder";
    private static boolean debug;
    private final android.graphics.Bitmap.Config bitmapConfig;
    private android.content.Context context;
    private final java.util.concurrent.locks.ReadWriteLock decoderLock;
    private com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.DecoderPool decoderPool;
    private long fileLength;
    private final android.graphics.Point imageDimensions;
    private final java.util.concurrent.atomic.AtomicBoolean lazyInited;
    private android.net.Uri uri;

    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    public SkiaPooledImageRegionDecoder(android.graphics.Bitmap.Config config) {
        this.decoderPool = new com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.DecoderPool();
        this.decoderLock = new java.util.concurrent.locks.ReentrantReadWriteLock(true);
        this.fileLength = Long.MAX_VALUE;
        this.imageDimensions = new android.graphics.Point(0, 0);
        this.lazyInited = new java.util.concurrent.atomic.AtomicBoolean(false);
        android.graphics.Bitmap.Config preferredBitmapConfig = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = android.graphics.Bitmap.Config.RGB_565;
        }
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public android.graphics.Point init(android.content.Context context, android.net.Uri uri) throws java.lang.Exception {
        this.context = context;
        this.uri = uri;
        initialiseDecoder();
        return this.imageDimensions;
    }

    private void lazyInit() {
        if (!this.lazyInited.compareAndSet(false, true) || this.fileLength >= Long.MAX_VALUE) {
            return;
        }
        debug("Starting lazy init of additional decoders");
        new java.lang.Thread() { // from class: com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                    com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.this;
                    if (!skiaPooledImageRegionDecoder.allowAdditionalDecoder(skiaPooledImageRegionDecoder.decoderPool.size(), com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.fileLength)) {
                        return;
                    }
                    try {
                        if (com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                            com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.debug("Starting decoder");
                            com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.initialiseDecoder();
                            long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                            com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.debug("Started decoder, took " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + "ms");
                        }
                    } catch (java.lang.Exception e) {
                        com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.debug("Failed to start decoder: " + e.getMessage());
                    }
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialiseDecoder() throws java.lang.Exception {
        android.graphics.BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        android.content.res.Resources resourcesForApplication;
        int identifier;
        java.lang.String string = this.uri.toString();
        long length = Long.MAX_VALUE;
        if (string.startsWith(RESOURCE_PREFIX)) {
            java.lang.String authority = this.uri.getAuthority();
            if (this.context.getPackageName().equals(authority)) {
                resourcesForApplication = this.context.getResources();
            } else {
                resourcesForApplication = this.context.getPackageManager().getResourcesForApplication(authority);
            }
            java.util.List<java.lang.String> pathSegments = this.uri.getPathSegments();
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
            try {
                length = this.context.getResources().openRawResourceFd(identifier).getLength();
            } catch (java.lang.Exception unused2) {
            }
            bitmapRegionDecoderNewInstance = android.graphics.BitmapRegionDecoder.newInstance(this.context.getResources().openRawResource(identifier), false);
        } else if (string.startsWith(ASSET_PREFIX)) {
            java.lang.String strSubstring = string.substring(22);
            try {
                length = this.context.getAssets().openFd(strSubstring).getLength();
            } catch (java.lang.Exception unused3) {
            }
            bitmapRegionDecoderNewInstance = android.graphics.BitmapRegionDecoder.newInstance(this.context.getAssets().open(strSubstring, 1), false);
        } else if (string.startsWith(FILE_PREFIX)) {
            android.graphics.BitmapRegionDecoder bitmapRegionDecoderNewInstance2 = android.graphics.BitmapRegionDecoder.newInstance(string.substring(7), false);
            try {
                java.io.File file = new java.io.File(string);
                if (file.exists()) {
                    length = file.length();
                }
            } catch (java.lang.Exception unused4) {
            }
            bitmapRegionDecoderNewInstance = bitmapRegionDecoderNewInstance2;
        } else {
            java.io.InputStream inputStreamOpenInputStream = null;
            try {
                android.content.ContentResolver contentResolver = this.context.getContentResolver();
                inputStreamOpenInputStream = contentResolver.openInputStream(this.uri);
                android.graphics.BitmapRegionDecoder bitmapRegionDecoderNewInstance3 = android.graphics.BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                try {
                    android.content.res.AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.uri, "r");
                    if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                        length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                    }
                } catch (java.lang.Exception unused5) {
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (java.lang.Exception unused6) {
                    }
                }
                bitmapRegionDecoderNewInstance = bitmapRegionDecoderNewInstance3;
            } catch (java.lang.Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (java.lang.Exception unused7) {
                    }
                }
                throw th;
            }
        }
        this.fileLength = length;
        this.imageDimensions.set(bitmapRegionDecoderNewInstance.getWidth(), bitmapRegionDecoderNewInstance.getHeight());
        this.decoderLock.writeLock().lock();
        try {
            com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                decoderPool.add(bitmapRegionDecoderNewInstance);
            }
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public android.graphics.Bitmap decodeRegion(android.graphics.Rect rect, int i) {
        debug("Decode region " + rect + " on thread " + java.lang.Thread.currentThread().getName());
        if (rect.width() < this.imageDimensions.x || rect.height() < this.imageDimensions.y) {
            lazyInit();
        }
        this.decoderLock.readLock().lock();
        try {
            com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                android.graphics.BitmapRegionDecoder bitmapRegionDecoderAcquire = decoderPool.acquire();
                if (bitmapRegionDecoderAcquire != null) {
                    try {
                        if (!bitmapRegionDecoderAcquire.isRecycled()) {
                            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                            options.inSampleSize = i;
                            options.inPreferredConfig = this.bitmapConfig;
                            android.graphics.Bitmap bitmapDecodeRegion = bitmapRegionDecoderAcquire.decodeRegion(rect, options);
                            if (bitmapDecodeRegion != null) {
                                return bitmapDecodeRegion;
                            }
                            throw new java.lang.RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                        }
                    } finally {
                        if (bitmapRegionDecoderAcquire != null) {
                            this.decoderPool.release(bitmapRegionDecoderAcquire);
                        }
                    }
                }
                if (bitmapRegionDecoderAcquire != null) {
                    this.decoderPool.release(bitmapRegionDecoderAcquire);
                }
            }
            throw new java.lang.IllegalStateException("Cannot decode region after decoder has been recycled");
        } finally {
            this.decoderLock.readLock().unlock();
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
            com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder$DecoderPool r0 = r1.decoderPool     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Ld
            boolean r0 = com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.DecoderPool.access$900(r0)     // Catch: java.lang.Throwable -> L10
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
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.isReady():boolean");
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public synchronized void recycle() {
        this.decoderLock.writeLock().lock();
        try {
            com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                decoderPool.recycle();
                this.decoderPool = null;
                this.context = null;
                this.uri = null;
            }
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    protected boolean allowAdditionalDecoder(int i, long j) {
        if (i >= 4) {
            debug("No additional decoders allowed, reached hard limit (4)");
            return false;
        }
        long j2 = ((long) i) * j;
        if (j2 > 20971520) {
            debug("No additional encoders allowed, reached hard memory limit (20Mb)");
            return false;
        }
        if (i >= getNumberOfCores()) {
            debug("No additional encoders allowed, limited by CPU cores (" + getNumberOfCores() + ")");
            return false;
        }
        if (isLowMemory()) {
            debug("No additional encoders allowed, memory is low");
            return false;
        }
        debug("Additional decoder allowed, current count is " + i + ", estimated native memory " + (j2 / com.up366.medialibrary.config.PictureConstants.MB) + "Mb");
        return true;
    }

    private static class DecoderPool {
        private final java.util.concurrent.Semaphore available;
        private final java.util.Map<android.graphics.BitmapRegionDecoder, java.lang.Boolean> decoders;

        private DecoderPool() {
            this.available = new java.util.concurrent.Semaphore(0, true);
            this.decoders = new java.util.concurrent.ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean isEmpty() {
            return this.decoders.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized int size() {
            return this.decoders.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public android.graphics.BitmapRegionDecoder acquire() {
            this.available.acquireUninterruptibly();
            return getNextAvailable();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release(android.graphics.BitmapRegionDecoder bitmapRegionDecoder) {
            if (markAsUnused(bitmapRegionDecoder)) {
                this.available.release();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void add(android.graphics.BitmapRegionDecoder bitmapRegionDecoder) {
            this.decoders.put(bitmapRegionDecoder, false);
            this.available.release();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void recycle() {
            while (!this.decoders.isEmpty()) {
                android.graphics.BitmapRegionDecoder bitmapRegionDecoderAcquire = acquire();
                bitmapRegionDecoderAcquire.recycle();
                this.decoders.remove(bitmapRegionDecoderAcquire);
            }
        }

        private synchronized android.graphics.BitmapRegionDecoder getNextAvailable() {
            for (java.util.Map.Entry<android.graphics.BitmapRegionDecoder, java.lang.Boolean> entry : this.decoders.entrySet()) {
                if (!entry.getValue().booleanValue()) {
                    entry.setValue(true);
                    return entry.getKey();
                }
            }
            return null;
        }

        private synchronized boolean markAsUnused(android.graphics.BitmapRegionDecoder bitmapRegionDecoder) {
            for (java.util.Map.Entry<android.graphics.BitmapRegionDecoder, java.lang.Boolean> entry : this.decoders.entrySet()) {
                if (bitmapRegionDecoder == entry.getKey()) {
                    if (!entry.getValue().booleanValue()) {
                        return false;
                    }
                    entry.setValue(false);
                    return true;
                }
            }
            return false;
        }
    }

    private int getNumberOfCores() {
        return java.lang.Runtime.getRuntime().availableProcessors();
    }

    private int getNumCoresOldPhones() {
        try {
            return new java.io.File("/sys/devices/system/cpu/").listFiles(new java.io.FileFilter() { // from class: com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(java.io.File file) {
                    return java.util.regex.Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (java.lang.Exception unused) {
            return 1;
        }
    }

    private boolean isLowMemory() {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) this.context.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug(java.lang.String str) {
        if (debug) {
            android.util.Log.d(TAG, str);
        }
    }
}
