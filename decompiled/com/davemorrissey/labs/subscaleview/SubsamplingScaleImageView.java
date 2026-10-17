package com.davemorrissey.labs.subscaleview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class SubsamplingScaleImageView extends android.view.View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    private static final java.lang.String TAG = "SubsamplingScaleImageView";
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static android.graphics.Bitmap.Config preferredBitmapConfig;
    private com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Anim anim;
    private android.graphics.Bitmap bitmap;
    private com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private android.graphics.Paint bitmapPaint;
    private boolean debug;
    private android.graphics.Paint debugLinePaint;
    private android.graphics.Paint debugTextPaint;
    private com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder decoder;
    private final java.util.concurrent.locks.ReadWriteLock decoderLock;
    private final float density;
    private android.view.GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private java.util.concurrent.Executor executor;
    private int fullImageSampleSize;
    private final android.os.Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private android.graphics.Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener;
    private android.view.View.OnLongClickListener onLongClickListener;
    private com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener onStateChangedListener;
    private int orientation;
    private android.graphics.Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private java.lang.Float pendingScale;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private boolean quickScaleMoved;
    private android.graphics.PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    private android.graphics.PointF quickScaleVLastPoint;
    private android.graphics.PointF quickScaleVStart;
    private boolean readySent;
    private com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private android.graphics.PointF sPendingCenter;
    private android.graphics.RectF sRect;
    private android.graphics.Rect sRegion;
    private android.graphics.PointF sRequestedCenter;
    private int sWidth;
    private com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private android.view.GestureDetector singleDetector;
    private final float[] srcArray;
    private android.graphics.Paint tileBgPaint;
    private java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile>> tileMap;
    private android.net.Uri uri;
    private android.graphics.PointF vCenterStart;
    private float vDistStart;
    private android.graphics.PointF vTranslate;
    private android.graphics.PointF vTranslateBefore;
    private android.graphics.PointF vTranslateStart;
    private boolean zoomEnabled;
    private static final java.util.List<java.lang.Integer> VALID_ORIENTATIONS = java.util.Arrays.asList(0, 90, 180, 270, -1);
    private static final java.util.List<java.lang.Integer> VALID_ZOOM_STYLES = java.util.Arrays.asList(1, 2, 3);
    private static final java.util.List<java.lang.Integer> VALID_EASING_STYLES = java.util.Arrays.asList(2, 1);
    private static final java.util.List<java.lang.Integer> VALID_PAN_LIMITS = java.util.Arrays.asList(1, 2, 3);
    private static final java.util.List<java.lang.Integer> VALID_SCALE_TYPES = java.util.Arrays.asList(2, 1, 3, 4);

    public static class DefaultOnAnimationEventListener implements com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener {
        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onComplete() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByNewAnim() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByUser() {
        }
    }

    public static class DefaultOnImageEventListener implements com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener {
        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(java.lang.Exception exc) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(java.lang.Exception exc) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewReleased() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(java.lang.Exception exc) {
        }
    }

    public static class DefaultOnStateChangedListener implements com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener {
        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onCenterChanged(android.graphics.PointF pointF, int i) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onScaleChanged(float f, int i) {
        }
    }

    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    public interface OnImageEventListener {
        void onImageLoadError(java.lang.Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(java.lang.Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(java.lang.Exception exc);
    }

    public interface OnStateChangedListener {
        void onCenterChanged(android.graphics.PointF pointF, int i);

        void onScaleChanged(float f, int i);
    }

    private float easeInOutQuad(long j, float f, float f2, long j2) {
        float f3;
        float f4 = j / (j2 / 2.0f);
        if (f4 < 1.0f) {
            f3 = (f2 / 2.0f) * f4;
        } else {
            float f5 = f4 - 1.0f;
            f3 = (-f2) / 2.0f;
            f4 = (f5 * (f5 - 2.0f)) - 1.0f;
        }
        return (f3 * f4) + f;
    }

    private float easeOutQuad(long j, float f, float f2, long j2) {
        float f3 = j / j2;
        return ((-f2) * f3 * (f3 - 2.0f)) + f;
    }

    protected void onImageLoaded() {
    }

    protected void onReady() {
    }

    public SubsamplingScaleImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        int resourceId;
        java.lang.String string;
        super(context, attributeSet);
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = Integer.MAX_VALUE;
        this.maxTileHeight = Integer.MAX_VALUE;
        this.executor = android.os.AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new java.util.concurrent.locks.ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory(com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder.class);
        this.regionDecoderFactory = new com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory(com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(com.igexin.vivo.BuildConfig.VERSION_CODE);
        setGestureDetector(context);
        this.handler = new android.os.Handler(new android.os.Handler.Callback() { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(android.os.Message message) {
                if (message.what == 1 && com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.onLongClickListener != null) {
                    com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.maxTouchCount = 0;
                    com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this;
                    com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.performLongClick();
                    com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.super.setOnLongClickListener(null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView);
            if (typedArrayObtainStyledAttributes.hasValue(com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView_assetName) && (string = typedArrayObtainStyledAttributes.getString(com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView_assetName)) != null && string.length() > 0) {
                setImage(com.davemorrissey.labs.subscaleview.ImageSource.asset(string).tilingEnabled());
            }
            if (typedArrayObtainStyledAttributes.hasValue(com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView_src) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView_src, 0)) > 0) {
                setImage(com.davemorrissey.labs.subscaleview.ImageSource.resource(resourceId).tilingEnabled());
            }
            if (typedArrayObtainStyledAttributes.hasValue(com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView_panEnabled)) {
                setPanEnabled(typedArrayObtainStyledAttributes.getBoolean(com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView_panEnabled, true));
            }
            if (typedArrayObtainStyledAttributes.hasValue(com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView_zoomEnabled)) {
                setZoomEnabled(typedArrayObtainStyledAttributes.getBoolean(com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView_zoomEnabled, true));
            }
            if (typedArrayObtainStyledAttributes.hasValue(com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView_quickScaleEnabled)) {
                setQuickScaleEnabled(typedArrayObtainStyledAttributes.getBoolean(com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView_quickScaleEnabled, true));
            }
            if (typedArrayObtainStyledAttributes.hasValue(com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView_tileBackgroundColor)) {
                setTileBackgroundColor(typedArrayObtainStyledAttributes.getColor(com.davemorrissey.labs.subscaleview.R.styleable.SubsamplingScaleImageView_tileBackgroundColor, android.graphics.Color.argb(0, 0, 0, 0)));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = android.util.TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public SubsamplingScaleImageView(android.content.Context context) {
        this(context, null);
    }

    public static android.graphics.Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    public static void setPreferredBitmapConfig(android.graphics.Bitmap.Config config) {
        preferredBitmapConfig = config;
    }

    public final void setOrientation(int i) {
        if (!VALID_ORIENTATIONS.contains(java.lang.Integer.valueOf(i))) {
            throw new java.lang.IllegalArgumentException("Invalid orientation: " + i);
        }
        this.orientation = i;
        reset(false);
        invalidate();
        requestLayout();
    }

    public final void setImage(com.davemorrissey.labs.subscaleview.ImageSource imageSource) {
        setImage(imageSource, null, null);
    }

    public final void setImage(com.davemorrissey.labs.subscaleview.ImageSource imageSource, com.davemorrissey.labs.subscaleview.ImageViewState imageViewState) {
        setImage(imageSource, null, imageViewState);
    }

    public final void setImage(com.davemorrissey.labs.subscaleview.ImageSource imageSource, com.davemorrissey.labs.subscaleview.ImageSource imageSource2) {
        setImage(imageSource, imageSource2, null);
    }

    public final void setImage(com.davemorrissey.labs.subscaleview.ImageSource imageSource, com.davemorrissey.labs.subscaleview.ImageSource imageSource2, com.davemorrissey.labs.subscaleview.ImageViewState imageViewState) {
        if (imageSource == null) {
            throw new java.lang.NullPointerException("imageSource must not be null");
        }
        reset(true);
        if (imageViewState != null) {
            restoreState(imageViewState);
        }
        if (imageSource2 != null) {
            if (imageSource.getBitmap() != null) {
                throw new java.lang.IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            }
            if (imageSource.getSWidth() <= 0 || imageSource.getSHeight() <= 0) {
                throw new java.lang.IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            }
            this.sWidth = imageSource.getSWidth();
            this.sHeight = imageSource.getSHeight();
            this.pRegion = imageSource2.getSRegion();
            if (imageSource2.getBitmap() != null) {
                this.bitmapIsCached = imageSource2.isCached();
                onPreviewLoaded(imageSource2.getBitmap());
            } else {
                android.net.Uri uri = imageSource2.getUri();
                if (uri == null && imageSource2.getResource() != null) {
                    uri = android.net.Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                }
                execute(new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri, true));
            }
        }
        if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
            onImageLoaded(android.graphics.Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0, false);
            return;
        }
        if (imageSource.getBitmap() != null) {
            onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
            return;
        }
        this.sRegion = imageSource.getSRegion();
        android.net.Uri uri2 = imageSource.getUri();
        this.uri = uri2;
        if (uri2 == null && imageSource.getResource() != null) {
            this.uri = android.net.Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
        }
        if (imageSource.getTile() || this.sRegion != null) {
            execute(new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
        } else {
            execute(new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
        }
    }

    private void reset(boolean z) {
        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener;
        debug("reset newImage=" + z, new java.lang.Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = java.lang.Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z) {
            this.uri = null;
            this.decoderLock.writeLock().lock();
            try {
                com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null) {
                    imageRegionDecoder.recycle();
                    this.decoder = null;
                }
                this.decoderLock.writeLock().unlock();
                android.graphics.Bitmap bitmap = this.bitmap;
                if (bitmap != null && !this.bitmapIsCached) {
                    bitmap.recycle();
                }
                if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
                    onImageEventListener.onPreviewReleased();
                }
                this.sWidth = 0;
                this.sHeight = 0;
                this.sOrientation = 0;
                this.sRegion = null;
                this.pRegion = null;
                this.readySent = false;
                this.imageLoadedSent = false;
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            } catch (java.lang.Throwable th) {
                this.decoderLock.writeLock().unlock();
                throw th;
            }
        }
        java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile>> map = this.tileMap;
        if (map != null) {
            java.util.Iterator<java.util.Map.Entry<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                for (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile tile : it.next().getValue()) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(final android.content.Context context) {
        this.detector = new android.view.GestureDetector(context, new android.view.GestureDetector.SimpleOnGestureListener() { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
                if (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.panEnabled && com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.readySent && com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.vTranslate != null && motionEvent != null && motionEvent2 != null && ((java.lang.Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || java.lang.Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((java.lang.Math.abs(f) > 500.0f || java.lang.Math.abs(f2) > 500.0f) && !com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.isZooming))) {
                    android.graphics.PointF pointF = new android.graphics.PointF(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.vTranslate.x + (f * 0.25f), com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.vTranslate.y + (f2 * 0.25f));
                    new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder(new android.graphics.PointF(((com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.getWidth() / 2) - pointF.x) / com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.scale, ((com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.getHeight() / 2) - pointF.y) / com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.scale)).withEasing(1).withPanLimited(false).withOrigin(3).start();
                    return true;
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
                com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.performClick();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(android.view.MotionEvent motionEvent) {
                if (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.zoomEnabled && com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.readySent && com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.vTranslate != null) {
                    com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.setGestureDetector(context);
                    if (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.quickScaleEnabled) {
                        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.vCenterStart = new android.graphics.PointF(motionEvent.getX(), motionEvent.getY());
                        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.vTranslateStart = new android.graphics.PointF(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.vTranslate.x, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.vTranslate.y);
                        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this;
                        subsamplingScaleImageView.scaleStart = subsamplingScaleImageView.scale;
                        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.isQuickScaling = true;
                        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.isZooming = true;
                        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView2 = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this;
                        subsamplingScaleImageView2.quickScaleSCenter = subsamplingScaleImageView2.viewToSourceCoord(subsamplingScaleImageView2.vCenterStart);
                        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.quickScaleVStart = new android.graphics.PointF(motionEvent.getX(), motionEvent.getY());
                        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.quickScaleVLastPoint = new android.graphics.PointF(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.quickScaleSCenter.x, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.quickScaleSCenter.y);
                        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.quickScaleMoved = false;
                        return false;
                    }
                    com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView3 = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this;
                    subsamplingScaleImageView3.doubleTapZoom(subsamplingScaleImageView3.viewToSourceCoord(new android.graphics.PointF(motionEvent.getX(), motionEvent.getY())), new android.graphics.PointF(motionEvent.getX(), motionEvent.getY()));
                    return true;
                }
                return super.onDoubleTapEvent(motionEvent);
            }
        });
        this.singleDetector = new android.view.GestureDetector(context, new android.view.GestureDetector.SimpleOnGestureListener() { // from class: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
                com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        debug("onSizeChanged %dx%d -> %dx%d", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        android.graphics.PointF center = getCenter();
        if (!this.readySent || center == null) {
            return;
        }
        this.anim = null;
        this.pendingScale = java.lang.Float.valueOf(this.scale);
        this.sPendingCenter = center;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z && z2) {
                size = sWidth();
                size2 = sHeight();
            } else if (z2) {
                size2 = (int) ((((double) sHeight()) / ((double) sWidth())) * ((double) size));
            } else if (z) {
                size = (int) ((((double) sWidth()) / ((double) sHeight())) * ((double) size2));
            }
        }
        setMeasuredDimension(java.lang.Math.max(size, getSuggestedMinimumWidth()), java.lang.Math.max(size2, getSuggestedMinimumHeight()));
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        android.view.GestureDetector gestureDetector;
        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Anim anim = this.anim;
        if (anim != null && !anim.interruptible) {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Anim anim2 = this.anim;
        if (anim2 != null && anim2.listener != null) {
            try {
                this.anim.listener.onInterruptedByUser();
            } catch (java.lang.Exception e) {
                android.util.Log.w(TAG, "Error thrown by animation listener", e);
            }
        }
        this.anim = null;
        if (this.vTranslate == null) {
            android.view.GestureDetector gestureDetector2 = this.singleDetector;
            if (gestureDetector2 != null) {
                gestureDetector2.onTouchEvent(motionEvent);
            }
            return true;
        }
        if (!this.isQuickScaling && ((gestureDetector = this.detector) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return true;
        }
        if (this.vTranslateStart == null) {
            this.vTranslateStart = new android.graphics.PointF(0.0f, 0.0f);
        }
        if (this.vTranslateBefore == null) {
            this.vTranslateBefore = new android.graphics.PointF(0.0f, 0.0f);
        }
        if (this.vCenterStart == null) {
            this.vCenterStart = new android.graphics.PointF(0.0f, 0.0f);
        }
        float f = this.scale;
        this.vTranslateBefore.set(this.vTranslate);
        boolean zOnTouchEventInternal = onTouchEventInternal(motionEvent);
        sendStateChanged(f, this.vTranslateBefore, 2);
        return zOnTouchEventInternal || super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        if (r1 != 262) goto L133;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean onTouchEventInternal(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instruction units count: 1210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void requestDisallowInterceptTouchEvent(boolean z) {
        android.view.ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTapZoom(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        if (!this.panEnabled) {
            android.graphics.PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = this.sRequestedCenter.y;
            } else {
                pointF.x = sWidth() / 2;
                pointF.y = sHeight() / 2;
            }
        }
        float fMin = java.lang.Math.min(this.maxScale, this.doubleTapZoomScale);
        float f = this.scale;
        boolean z = ((double) f) <= ((double) fMin) * 0.9d || f == this.minScale;
        if (!z) {
            fMin = minScale();
        }
        float f2 = fMin;
        int i = this.doubleTapZoomStyle;
        if (i == 3) {
            setScaleAndCenter(f2, pointF);
        } else if (i == 2 || !z || !this.panEnabled) {
            new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder(f2, pointF).withInterruptible(false).withDuration(this.doubleTapZoomDuration).withOrigin(4).start();
        } else if (i == 1) {
            new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder(f2, pointF, pointF2).withInterruptible(false).withDuration(this.doubleTapZoomDuration).withOrigin(4).start();
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x048b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r33) {
        /*
            Method dump skipped, instruction units count: 1887
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onDraw(android.graphics.Canvas):void");
    }

    private void setMatrixArray(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
    }

    private boolean isBaseLayerReady() {
        boolean z = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile>> map = this.tileMap;
        if (map == null) {
            return false;
        }
        for (java.util.Map.Entry<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile>> entry : map.entrySet()) {
            if (entry.getKey().intValue() == this.fullImageSampleSize) {
                for (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile tile : entry.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    private boolean checkReady() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady());
        if (!this.readySent && z) {
            preDraw();
            this.readySent = true;
            onReady();
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onReady();
            }
        }
        return z;
    }

    private boolean checkImageLoaded() {
        boolean zIsBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && zIsBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onImageLoaded();
            }
        }
        return zIsBaseLayerReady;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            android.graphics.Paint paint = new android.graphics.Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if ((this.debugTextPaint == null || this.debugLinePaint == null) && this.debug) {
            android.graphics.Paint paint2 = new android.graphics.Paint();
            this.debugTextPaint = paint2;
            paint2.setTextSize(px(12));
            this.debugTextPaint.setColor(-65281);
            this.debugTextPaint.setStyle(android.graphics.Paint.Style.FILL);
            android.graphics.Paint paint3 = new android.graphics.Paint();
            this.debugLinePaint = paint3;
            paint3.setColor(-65281);
            this.debugLinePaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.debugLinePaint.setStrokeWidth(px(1));
        }
    }

    private synchronized void initialiseBaseLayer(android.graphics.Point point) {
        debug("initialiseBaseLayer maxTileDimensions=%dx%d", java.lang.Integer.valueOf(point.x), java.lang.Integer.valueOf(point.y));
        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate scaleAndTranslate = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate(0.0f, new android.graphics.PointF(0.0f, 0.0f));
        this.satTemp = scaleAndTranslate;
        fitToBounds(true, scaleAndTranslate);
        int iCalculateInSampleSize = calculateInSampleSize(this.satTemp.scale);
        this.fullImageSampleSize = iCalculateInSampleSize;
        if (iCalculateInSampleSize > 1) {
            this.fullImageSampleSize = iCalculateInSampleSize / 2;
        }
        if (this.fullImageSampleSize == 1 && this.sRegion == null && sWidth() < point.x && sHeight() < point.y) {
            this.decoder.recycle();
            this.decoder = null;
            execute(new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
        } else {
            initialiseTileMap(point);
            java.util.Iterator<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile> it = this.tileMap.get(java.lang.Integer.valueOf(this.fullImageSampleSize)).iterator();
            while (it.hasNext()) {
                execute(new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TileLoadTask(this, this.decoder, it.next()));
            }
            refreshRequiredTiles(true);
        }
    }

    private void refreshRequiredTiles(boolean z) {
        if (this.decoder == null || this.tileMap == null) {
            return;
        }
        int iMin = java.lang.Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
        java.util.Iterator<java.util.Map.Entry<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile>>> it = this.tileMap.entrySet().iterator();
        while (it.hasNext()) {
            for (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile tile : it.next().getValue()) {
                if (tile.sampleSize < iMin || (tile.sampleSize > iMin && tile.sampleSize != this.fullImageSampleSize)) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
                if (tile.sampleSize == iMin) {
                    if (tileVisible(tile)) {
                        tile.visible = true;
                        if (!tile.loading && tile.bitmap == null && z) {
                            execute(new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TileLoadTask(this, this.decoder, tile));
                        }
                    } else if (tile.sampleSize != this.fullImageSampleSize) {
                        tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            tile.bitmap = null;
                        }
                    }
                } else if (tile.sampleSize == this.fullImageSampleSize) {
                    tile.visible = true;
                }
            }
        }
    }

    private boolean tileVisible(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile tile) {
        return viewToSourceX(0.0f) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(0.0f) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= viewToSourceY((float) getHeight());
    }

    private void preDraw() {
        java.lang.Float f;
        if (getWidth() == 0 || getHeight() == 0 || this.sWidth <= 0 || this.sHeight <= 0) {
            return;
        }
        if (this.sPendingCenter != null && (f = this.pendingScale) != null) {
            this.scale = f.floatValue();
            if (this.vTranslate == null) {
                this.vTranslate = new android.graphics.PointF();
            }
            this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sPendingCenter.x);
            this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sPendingCenter.y);
            this.sPendingCenter = null;
            this.pendingScale = null;
            fitToBounds(true);
            refreshRequiredTiles(true);
        }
        fitToBounds(false);
    }

    private int calculateInSampleSize(float f) {
        int iRound;
        if (this.minimumTileDpi > 0) {
            android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f *= this.minimumTileDpi / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int iSWidth = (int) (sWidth() * f);
        int iSHeight = (int) (sHeight() * f);
        if (iSWidth == 0 || iSHeight == 0) {
            return 32;
        }
        int i = 1;
        if (sHeight() > iSHeight || sWidth() > iSWidth) {
            iRound = java.lang.Math.round(sHeight() / iSHeight);
            int iRound2 = java.lang.Math.round(sWidth() / iSWidth);
            if (iRound >= iRound2) {
                iRound = iRound2;
            }
        } else {
            iRound = 1;
        }
        while (true) {
            int i2 = i * 2;
            if (i2 >= iRound) {
                return i;
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitToBounds(boolean z, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate scaleAndTranslate) {
        float fMax;
        int iMax;
        float fMax2;
        if (this.panLimit == 2 && isReady()) {
            z = false;
        }
        android.graphics.PointF pointF = scaleAndTranslate.vTranslate;
        float fLimitedScale = limitedScale(scaleAndTranslate.scale);
        float fSWidth = sWidth() * fLimitedScale;
        float fSHeight = sHeight() * fLimitedScale;
        if (this.panLimit == 3 && isReady()) {
            pointF.x = java.lang.Math.max(pointF.x, (getWidth() / 2) - fSWidth);
            pointF.y = java.lang.Math.max(pointF.y, (getHeight() / 2) - fSHeight);
        } else if (z) {
            pointF.x = java.lang.Math.max(pointF.x, getWidth() - fSWidth);
            pointF.y = java.lang.Math.max(pointF.y, getHeight() - fSHeight);
        } else {
            pointF.x = java.lang.Math.max(pointF.x, -fSWidth);
            pointF.y = java.lang.Math.max(pointF.y, -fSHeight);
        }
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        float paddingTop = (getPaddingTop() > 0 || getPaddingBottom() > 0) ? getPaddingTop() / (getPaddingTop() + getPaddingBottom()) : 0.5f;
        if (this.panLimit == 3 && isReady()) {
            fMax = java.lang.Math.max(0, getWidth() / 2);
            iMax = java.lang.Math.max(0, getHeight() / 2);
        } else {
            if (z) {
                fMax = java.lang.Math.max(0.0f, (getWidth() - fSWidth) * paddingLeft);
                fMax2 = java.lang.Math.max(0.0f, (getHeight() - fSHeight) * paddingTop);
                pointF.x = java.lang.Math.min(pointF.x, fMax);
                pointF.y = java.lang.Math.min(pointF.y, fMax2);
                scaleAndTranslate.scale = fLimitedScale;
            }
            fMax = java.lang.Math.max(0, getWidth());
            iMax = java.lang.Math.max(0, getHeight());
        }
        fMax2 = iMax;
        pointF.x = java.lang.Math.min(pointF.x, fMax);
        pointF.y = java.lang.Math.min(pointF.y, fMax2);
        scaleAndTranslate.scale = fLimitedScale;
    }

    private void fitToBounds(boolean z) {
        boolean z2;
        float f = 0.0f;
        if (this.vTranslate == null) {
            this.vTranslate = new android.graphics.PointF(0.0f, 0.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate(f, new android.graphics.PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (!z2 || this.minimumScaleType == 4) {
            return;
        }
        this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initialiseTileMap(android.graphics.Point point) {
        int i = 0;
        int i2 = 1;
        debug("initialiseTileMap maxTileDimensions=%dx%d", java.lang.Integer.valueOf(point.x), java.lang.Integer.valueOf(point.y));
        this.tileMap = new java.util.LinkedHashMap();
        int i3 = this.fullImageSampleSize;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int iSWidth = sWidth() / i4;
            int iSHeight = sHeight() / i5;
            int i6 = iSWidth / i3;
            int i7 = iSHeight / i3;
            while (true) {
                if (i6 + i4 + i2 <= point.x && (i6 <= ((double) getWidth()) * 1.25d || i3 >= this.fullImageSampleSize)) {
                    break;
                }
                i4++;
                iSWidth = sWidth() / i4;
                i6 = iSWidth / i3;
            }
            while (true) {
                if (i7 + i5 + i2 <= point.y && (i7 <= ((double) getHeight()) * 1.25d || i3 >= this.fullImageSampleSize)) {
                    break;
                }
                i5++;
                iSHeight = sHeight() / i5;
                i7 = iSHeight / i3;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(i4 * i5);
            int i8 = i;
            while (i8 < i4) {
                int i9 = i;
                while (i9 < i5) {
                    com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile tile = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile();
                    tile.sampleSize = i3;
                    tile.visible = i3 == this.fullImageSampleSize ? i2 : i;
                    tile.sRect = new android.graphics.Rect(i8 * iSWidth, i9 * iSHeight, i8 == i4 + (-1) ? sWidth() : (i8 + 1) * iSWidth, i9 == i5 + (-1) ? sHeight() : (i9 + 1) * iSHeight);
                    i = 0;
                    tile.vRect = new android.graphics.Rect(0, 0, 0, 0);
                    tile.fileSRect = new android.graphics.Rect(tile.sRect);
                    arrayList.add(tile);
                    i9++;
                    i2 = 1;
                }
                i8++;
                i2 = 1;
            }
            this.tileMap.put(java.lang.Integer.valueOf(i3), arrayList);
            i2 = 1;
            if (i3 == 1) {
                return;
            } else {
                i3 /= 2;
            }
        }
    }

    private static class TilesInitTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, int[]> {
        private final java.lang.ref.WeakReference<android.content.Context> contextRef;
        private com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder decoder;
        private final java.lang.ref.WeakReference<com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder>> decoderFactoryRef;
        private java.lang.Exception exception;
        private final android.net.Uri source;
        private final java.lang.ref.WeakReference<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView> viewRef;

        TilesInitTask(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView, android.content.Context context, com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder> decoderFactory, android.net.Uri uri) {
            this.viewRef = new java.lang.ref.WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new java.lang.ref.WeakReference<>(context);
            this.decoderFactoryRef = new java.lang.ref.WeakReference<>(decoderFactory);
            this.source = uri;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public int[] doInBackground(java.lang.Void... voidArr) {
            try {
                java.lang.String string = this.source.toString();
                android.content.Context context = this.contextRef.get();
                com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder> decoderFactory = this.decoderFactoryRef.get();
                com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("TilesInitTask.doInBackground", new java.lang.Object[0]);
                com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder imageRegionDecoderMake = decoderFactory.make();
                this.decoder = imageRegionDecoderMake;
                android.graphics.Point pointInit = imageRegionDecoderMake.init(context, this.source);
                int iWidth = pointInit.x;
                int iHeight = pointInit.y;
                int exifOrientation = subsamplingScaleImageView.getExifOrientation(context, string);
                if (subsamplingScaleImageView.sRegion != null) {
                    subsamplingScaleImageView.sRegion.left = java.lang.Math.max(0, subsamplingScaleImageView.sRegion.left);
                    subsamplingScaleImageView.sRegion.top = java.lang.Math.max(0, subsamplingScaleImageView.sRegion.top);
                    subsamplingScaleImageView.sRegion.right = java.lang.Math.min(iWidth, subsamplingScaleImageView.sRegion.right);
                    subsamplingScaleImageView.sRegion.bottom = java.lang.Math.min(iHeight, subsamplingScaleImageView.sRegion.bottom);
                    iWidth = subsamplingScaleImageView.sRegion.width();
                    iHeight = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{iWidth, iHeight, exifOrientation};
            } catch (java.lang.Exception e) {
                android.util.Log.e(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e);
                this.exception = e;
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(int[] iArr) {
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else {
                    if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                        return;
                    }
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTilesInited(com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder imageRegionDecoder, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(this.orientation));
        int i7 = this.sWidth;
        if (i7 > 0 && (i6 = this.sHeight) > 0 && (i7 != i || i6 != i2)) {
            reset(false);
            android.graphics.Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                if (!this.bitmapIsCached) {
                    bitmap.recycle();
                }
                this.bitmap = null;
                com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener = this.onImageEventListener;
                if (onImageEventListener != null && this.bitmapIsCached) {
                    onImageEventListener.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
        }
        this.decoder = imageRegionDecoder;
        this.sWidth = i;
        this.sHeight = i2;
        this.sOrientation = i3;
        checkReady();
        if (!checkImageLoaded() && (i4 = this.maxTileWidth) > 0 && i4 != Integer.MAX_VALUE && (i5 = this.maxTileHeight) > 0 && i5 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
            initialiseBaseLayer(new android.graphics.Point(this.maxTileWidth, this.maxTileHeight));
        }
        invalidate();
        requestLayout();
    }

    private static class TileLoadTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, android.graphics.Bitmap> {
        private final java.lang.ref.WeakReference<com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder> decoderRef;
        private java.lang.Exception exception;
        private final java.lang.ref.WeakReference<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile> tileRef;
        private final java.lang.ref.WeakReference<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView> viewRef;

        TileLoadTask(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView, com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder imageRegionDecoder, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile tile) {
            this.viewRef = new java.lang.ref.WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new java.lang.ref.WeakReference<>(imageRegionDecoder);
            this.tileRef = new java.lang.ref.WeakReference<>(tile);
            tile.loading = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public android.graphics.Bitmap doInBackground(java.lang.Void... voidArr) {
            try {
                com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder imageRegionDecoder = this.decoderRef.get();
                com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile tile = this.tileRef.get();
                if (imageRegionDecoder == null || tile == null || subsamplingScaleImageView == null || !imageRegionDecoder.isReady() || !tile.visible) {
                    if (tile == null) {
                        return null;
                    }
                    tile.loading = false;
                    return null;
                }
                subsamplingScaleImageView.debug("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, java.lang.Integer.valueOf(tile.sampleSize));
                subsamplingScaleImageView.decoderLock.readLock().lock();
                try {
                    if (imageRegionDecoder.isReady()) {
                        subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                        if (subsamplingScaleImageView.sRegion != null) {
                            tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                        }
                        return imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                    }
                    tile.loading = false;
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                    return null;
                } finally {
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                }
            } catch (java.lang.Exception e) {
                android.util.Log.e(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TAG, "Failed to decode tile", e);
                this.exception = e;
                return null;
            } catch (java.lang.OutOfMemoryError e2) {
                android.util.Log.e(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e2);
                this.exception = new java.lang.RuntimeException(e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(android.graphics.Bitmap bitmap) {
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile tile = this.tileRef.get();
            if (subsamplingScaleImageView == null || tile == null) {
                return;
            }
            if (bitmap == null) {
                if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                    return;
                }
                subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
                return;
            }
            tile.bitmap = bitmap;
            tile.loading = false;
            subsamplingScaleImageView.onTileLoaded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        android.graphics.Bitmap bitmap;
        debug("onTileLoaded", new java.lang.Object[0]);
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && (bitmap = this.bitmap) != null) {
            if (!this.bitmapIsCached) {
                bitmap.recycle();
            }
            this.bitmap = null;
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null && this.bitmapIsCached) {
                onImageEventListener.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        invalidate();
    }

    private static class BitmapLoadTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Integer> {
        private android.graphics.Bitmap bitmap;
        private final java.lang.ref.WeakReference<android.content.Context> contextRef;
        private final java.lang.ref.WeakReference<com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageDecoder>> decoderFactoryRef;
        private java.lang.Exception exception;
        private final boolean preview;
        private final android.net.Uri source;
        private final java.lang.ref.WeakReference<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView> viewRef;

        BitmapLoadTask(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView, android.content.Context context, com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageDecoder> decoderFactory, android.net.Uri uri, boolean z) {
            this.viewRef = new java.lang.ref.WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new java.lang.ref.WeakReference<>(context);
            this.decoderFactoryRef = new java.lang.ref.WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public java.lang.Integer doInBackground(java.lang.Void... voidArr) {
            try {
                java.lang.String string = this.source.toString();
                android.content.Context context = this.contextRef.get();
                com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageDecoder> decoderFactory = this.decoderFactoryRef.get();
                com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("BitmapLoadTask.doInBackground", new java.lang.Object[0]);
                this.bitmap = decoderFactory.make().decode(context, this.source);
                return java.lang.Integer.valueOf(subsamplingScaleImageView.getExifOrientation(context, string));
            } catch (java.lang.Exception e) {
                android.util.Log.e(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TAG, "Failed to load bitmap", e);
                this.exception = e;
                return null;
            } catch (java.lang.OutOfMemoryError e2) {
                android.util.Log.e(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e2);
                this.exception = new java.lang.RuntimeException(e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(java.lang.Integer num) {
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                android.graphics.Bitmap bitmap = this.bitmap;
                if (bitmap != null && num != null) {
                    if (this.preview) {
                        subsamplingScaleImageView.onPreviewLoaded(bitmap);
                        return;
                    } else {
                        subsamplingScaleImageView.onImageLoaded(bitmap, num.intValue(), false);
                        return;
                    }
                }
                if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                    return;
                }
                if (this.preview) {
                    subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                } else {
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onPreviewLoaded(android.graphics.Bitmap bitmap) {
        debug("onPreviewLoaded", new java.lang.Object[0]);
        if (this.bitmap == null && !this.imageLoadedSent) {
            android.graphics.Rect rect = this.pRegion;
            if (rect != null) {
                this.bitmap = android.graphics.Bitmap.createBitmap(bitmap, rect.left, this.pRegion.top, this.pRegion.width(), this.pRegion.height());
            } else {
                this.bitmap = bitmap;
            }
            this.bitmapIsPreview = true;
            if (checkReady()) {
                invalidate();
                requestLayout();
            }
            return;
        }
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onImageLoaded(android.graphics.Bitmap bitmap, int i, boolean z) {
        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener;
        debug("onImageLoaded", new java.lang.Object[0]);
        int i2 = this.sWidth;
        if (i2 > 0 && this.sHeight > 0 && (i2 != bitmap.getWidth() || this.sHeight != bitmap.getHeight())) {
            reset(false);
        }
        android.graphics.Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null && !this.bitmapIsCached) {
            bitmap2.recycle();
        }
        if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
            onImageEventListener.onPreviewReleased();
        }
        this.bitmapIsPreview = false;
        this.bitmapIsCached = z;
        this.bitmap = bitmap;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.sOrientation = i;
        boolean zCheckReady = checkReady();
        boolean zCheckImageLoaded = checkImageLoaded();
        if (zCheckReady || zCheckImageLoaded) {
            invalidate();
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getExifOrientation(android.content.Context context, java.lang.String str) {
        int i;
        int i2 = 0;
        if (str.startsWith(com.igexin.sdk.FlymePushReceiver.CONTENT)) {
            android.database.Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = context.getContentResolver().query(android.net.Uri.parse(str), new java.lang.String[]{"orientation"}, null, null, null);
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        int i3 = cursorQuery.getInt(0);
                        if (!VALID_ORIENTATIONS.contains(java.lang.Integer.valueOf(i3)) || i3 == -1) {
                            android.util.Log.w(TAG, "Unsupported orientation: " + i3);
                        } else {
                            i2 = i3;
                        }
                    }
                    if (cursorQuery == null) {
                        return i2;
                    }
                } catch (java.lang.Exception unused) {
                    android.util.Log.w(TAG, "Could not get orientation of image from media store");
                    if (cursorQuery == null) {
                        return 0;
                    }
                }
                cursorQuery.close();
                return i2;
            } catch (java.lang.Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        }
        if (!str.startsWith("file:///") || str.startsWith("file:///android_asset/")) {
            return 0;
        }
        try {
            int attributeInt = new androidx.exifinterface.media.ExifInterface(str.substring(7)).getAttributeInt("Orientation", 1);
            if (attributeInt != 1 && attributeInt != 0) {
                if (attributeInt == 6) {
                    i = 90;
                } else if (attributeInt == 3) {
                    i = 180;
                } else {
                    if (attributeInt != 8) {
                        android.util.Log.w(TAG, "Unsupported EXIF orientation: " + attributeInt);
                        return 0;
                    }
                    i = 270;
                }
                return i;
            }
            return 0;
        } catch (java.lang.Exception unused2) {
            android.util.Log.w(TAG, "Could not get EXIF orientation of image");
            return 0;
        }
    }

    private void execute(android.os.AsyncTask<java.lang.Void, java.lang.Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.executor, new java.lang.Void[0]);
    }

    private static class Tile {
        private android.graphics.Bitmap bitmap;
        private android.graphics.Rect fileSRect;
        private boolean loading;
        private android.graphics.Rect sRect;
        private int sampleSize;
        private android.graphics.Rect vRect;
        private boolean visible;

        private Tile() {
        }
    }

    private static class Anim {
        private long duration;
        private int easing;
        private boolean interruptible;
        private com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener listener;
        private int origin;
        private android.graphics.PointF sCenterEnd;
        private android.graphics.PointF sCenterEndRequested;
        private android.graphics.PointF sCenterStart;
        private float scaleEnd;
        private float scaleStart;
        private long time;
        private android.graphics.PointF vFocusEnd;
        private android.graphics.PointF vFocusStart;

        private Anim() {
            this.duration = 500L;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = java.lang.System.currentTimeMillis();
        }
    }

    private static class ScaleAndTranslate {
        private float scale;
        private final android.graphics.PointF vTranslate;

        private ScaleAndTranslate(float f, android.graphics.PointF pointF) {
            this.scale = f;
            this.vTranslate = pointF;
        }
    }

    private void restoreState(com.davemorrissey.labs.subscaleview.ImageViewState imageViewState) {
        if (imageViewState == null || !VALID_ORIENTATIONS.contains(java.lang.Integer.valueOf(imageViewState.getOrientation()))) {
            return;
        }
        this.orientation = imageViewState.getOrientation();
        this.pendingScale = java.lang.Float.valueOf(imageViewState.getScale());
        this.sPendingCenter = imageViewState.getCenter();
        invalidate();
    }

    public void setMaxTileSize(int i) {
        this.maxTileWidth = i;
        this.maxTileHeight = i;
    }

    public void setMaxTileSize(int i, int i2) {
        this.maxTileWidth = i;
        this.maxTileHeight = i2;
    }

    private android.graphics.Point getMaxBitmapDimensions(android.graphics.Canvas canvas) {
        return new android.graphics.Point(java.lang.Math.min(canvas.getMaximumBitmapWidth(), this.maxTileWidth), java.lang.Math.min(canvas.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.sHeight;
        }
        return this.sWidth;
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.sWidth;
        }
        return this.sHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fileSRect(android.graphics.Rect rect, android.graphics.Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
            return;
        }
        if (getRequiredRotation() == 90) {
            rect2.set(rect.top, this.sHeight - rect.right, rect.bottom, this.sHeight - rect.left);
        } else if (getRequiredRotation() == 180) {
            rect2.set(this.sWidth - rect.right, this.sHeight - rect.bottom, this.sWidth - rect.left, this.sHeight - rect.top);
        } else {
            rect2.set(this.sWidth - rect.bottom, rect.left, this.sWidth - rect.top, rect.right);
        }
    }

    private int getRequiredRotation() {
        int i = this.orientation;
        return i == -1 ? this.sOrientation : i;
    }

    private float distance(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) java.lang.Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    private float viewToSourceX(float f) {
        android.graphics.PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f) {
        android.graphics.PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f - pointF.y) / this.scale;
    }

    public void viewToFileRect(android.graphics.Rect rect, android.graphics.Rect rect2) {
        if (this.vTranslate == null || !this.readySent) {
            return;
        }
        rect2.set((int) viewToSourceX(rect.left), (int) viewToSourceY(rect.top), (int) viewToSourceX(rect.right), (int) viewToSourceY(rect.bottom));
        fileSRect(rect2, rect2);
        rect2.set(java.lang.Math.max(0, rect2.left), java.lang.Math.max(0, rect2.top), java.lang.Math.min(this.sWidth, rect2.right), java.lang.Math.min(this.sHeight, rect2.bottom));
        android.graphics.Rect rect3 = this.sRegion;
        if (rect3 != null) {
            rect2.offset(rect3.left, this.sRegion.top);
        }
    }

    public void visibleFileRect(android.graphics.Rect rect) {
        if (this.vTranslate == null || !this.readySent) {
            return;
        }
        rect.set(0, 0, getWidth(), getHeight());
        viewToFileRect(rect, rect);
    }

    public final android.graphics.PointF viewToSourceCoord(android.graphics.PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new android.graphics.PointF());
    }

    public final android.graphics.PointF viewToSourceCoord(float f, float f2) {
        return viewToSourceCoord(f, f2, new android.graphics.PointF());
    }

    public final android.graphics.PointF viewToSourceCoord(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final android.graphics.PointF viewToSourceCoord(float f, float f2, android.graphics.PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f), viewToSourceY(f2));
        return pointF;
    }

    private float sourceToViewX(float f) {
        android.graphics.PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f) {
        android.graphics.PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f * this.scale) + pointF.y;
    }

    public final android.graphics.PointF sourceToViewCoord(android.graphics.PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new android.graphics.PointF());
    }

    public final android.graphics.PointF sourceToViewCoord(float f, float f2) {
        return sourceToViewCoord(f, f2, new android.graphics.PointF());
    }

    public final android.graphics.PointF sourceToViewCoord(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final android.graphics.PointF sourceToViewCoord(float f, float f2, android.graphics.PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f), sourceToViewY(f2));
        return pointF;
    }

    private void sourceToViewRect(android.graphics.Rect rect, android.graphics.Rect rect2) {
        rect2.set((int) sourceToViewX(rect.left), (int) sourceToViewY(rect.top), (int) sourceToViewX(rect.right), (int) sourceToViewY(rect.bottom));
    }

    private android.graphics.PointF vTranslateForSCenter(float f, float f2, float f3) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate(0.0f, new android.graphics.PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = f3;
        this.satTemp.vTranslate.set(paddingLeft - (f * f3), paddingTop - (f2 * f3));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.PointF limitedSCenter(float f, float f2, float f3, android.graphics.PointF pointF) {
        android.graphics.PointF pointFVTranslateForSCenter = vTranslateForSCenter(f, f2, f3);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - pointFVTranslateForSCenter.x) / f3, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - pointFVTranslateForSCenter.y) / f3);
        return pointF;
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i = this.minimumScaleType;
        if (i == 2 || i == 4) {
            return java.lang.Math.max((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
        }
        if (i == 3) {
            float f = this.minScale;
            if (f > 0.0f) {
                return f;
            }
        }
        return java.lang.Math.min((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float limitedScale(float f) {
        return java.lang.Math.min(this.maxScale, java.lang.Math.max(minScale(), f));
    }

    private float ease(int i, long j, float f, float f2, long j2) {
        if (i == 1) {
            return easeOutQuad(j, f, f2, j2);
        }
        if (i == 2) {
            return easeInOutQuad(j, f, f2, j2);
        }
        throw new java.lang.IllegalStateException("Unexpected easing type: " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug(java.lang.String str, java.lang.Object... objArr) {
        if (this.debug) {
            android.util.Log.d(TAG, java.lang.String.format(str, objArr));
        }
    }

    private int px(int i) {
        return (int) (this.density * i);
    }

    public final void setRegionDecoderClass(java.lang.Class<? extends com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder> cls) {
        if (cls == null) {
            throw new java.lang.IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.regionDecoderFactory = new com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory(cls);
    }

    public final void setRegionDecoderFactory(com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new java.lang.IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.regionDecoderFactory = decoderFactory;
    }

    public final void setBitmapDecoderClass(java.lang.Class<? extends com.davemorrissey.labs.subscaleview.decoder.ImageDecoder> cls) {
        if (cls == null) {
            throw new java.lang.IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.bitmapDecoderFactory = new com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory(cls);
    }

    public final void setBitmapDecoderFactory(com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new java.lang.IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.bitmapDecoderFactory = decoderFactory;
    }

    public final void getPanRemaining(android.graphics.RectF rectF) {
        if (isReady()) {
            float fSWidth = this.scale * sWidth();
            float fSHeight = this.scale * sHeight();
            int i = this.panLimit;
            if (i == 3) {
                rectF.top = java.lang.Math.max(0.0f, -(this.vTranslate.y - (getHeight() / 2)));
                rectF.left = java.lang.Math.max(0.0f, -(this.vTranslate.x - (getWidth() / 2)));
                rectF.bottom = java.lang.Math.max(0.0f, this.vTranslate.y - ((getHeight() / 2) - fSHeight));
                rectF.right = java.lang.Math.max(0.0f, this.vTranslate.x - ((getWidth() / 2) - fSWidth));
                return;
            }
            if (i == 2) {
                rectF.top = java.lang.Math.max(0.0f, -(this.vTranslate.y - getHeight()));
                rectF.left = java.lang.Math.max(0.0f, -(this.vTranslate.x - getWidth()));
                rectF.bottom = java.lang.Math.max(0.0f, this.vTranslate.y + fSHeight);
                rectF.right = java.lang.Math.max(0.0f, this.vTranslate.x + fSWidth);
                return;
            }
            rectF.top = java.lang.Math.max(0.0f, -this.vTranslate.y);
            rectF.left = java.lang.Math.max(0.0f, -this.vTranslate.x);
            rectF.bottom = java.lang.Math.max(0.0f, (fSHeight + this.vTranslate.y) - getHeight());
            rectF.right = java.lang.Math.max(0.0f, (fSWidth + this.vTranslate.x) - getWidth());
        }
    }

    public final void setPanLimit(int i) {
        if (!VALID_PAN_LIMITS.contains(java.lang.Integer.valueOf(i))) {
            throw new java.lang.IllegalArgumentException("Invalid pan limit: " + i);
        }
        this.panLimit = i;
        if (isReady()) {
            fitToBounds(true);
            invalidate();
        }
    }

    public final void setMinimumScaleType(int i) {
        if (!VALID_SCALE_TYPES.contains(java.lang.Integer.valueOf(i))) {
            throw new java.lang.IllegalArgumentException("Invalid scale type: " + i);
        }
        this.minimumScaleType = i;
        if (isReady()) {
            fitToBounds(true);
            invalidate();
        }
    }

    public final void setMaxScale(float f) {
        this.maxScale = f;
    }

    public final void setMinScale(float f) {
        this.minScale = f;
    }

    public final void setMinimumDpi(int i) {
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setMaximumDpi(int i) {
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public void setMinimumTileDpi(int i) {
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) java.lang.Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public final android.graphics.PointF getCenter() {
        return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScaleAndCenter(float f, android.graphics.PointF pointF) {
        this.anim = null;
        this.pendingScale = java.lang.Float.valueOf(f);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = java.lang.Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new android.graphics.PointF(sWidth() / 2, sHeight() / 2);
        } else {
            this.sPendingCenter = new android.graphics.PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final com.davemorrissey.labs.subscaleview.ImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new com.davemorrissey.labs.subscaleview.ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    public final void setZoomEnabled(boolean z) {
        this.zoomEnabled = z;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.quickScaleEnabled = z;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final void setPanEnabled(boolean z) {
        android.graphics.PointF pointF;
        this.panEnabled = z;
        if (z || (pointF = this.vTranslate) == null) {
            return;
        }
        pointF.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
        this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
        if (isReady()) {
            refreshRequiredTiles(true);
            invalidate();
        }
    }

    public final void setTileBackgroundColor(int i) {
        if (android.graphics.Color.alpha(i) == 0) {
            this.tileBgPaint = null;
        } else {
            android.graphics.Paint paint = new android.graphics.Paint();
            this.tileBgPaint = paint;
            paint.setStyle(android.graphics.Paint.Style.FILL);
            this.tileBgPaint.setColor(i);
        }
        invalidate();
    }

    public final void setDoubleTapZoomScale(float f) {
        this.doubleTapZoomScale = f;
    }

    public final void setDoubleTapZoomDpi(int i) {
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setDoubleTapZoomStyle(int i) {
        if (!VALID_ZOOM_STYLES.contains(java.lang.Integer.valueOf(i))) {
            throw new java.lang.IllegalArgumentException("Invalid zoom style: " + i);
        }
        this.doubleTapZoomStyle = i;
    }

    public final void setDoubleTapZoomDuration(int i) {
        this.doubleTapZoomDuration = java.lang.Math.max(0, i);
    }

    public void setExecutor(java.util.concurrent.Executor executor) {
        if (executor == null) {
            throw new java.lang.NullPointerException("Executor must not be null");
        }
        this.executor = executor;
    }

    public void setEagerLoadingEnabled(boolean z) {
        this.eagerLoadingEnabled = z;
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }

    public boolean hasImage() {
        return (this.uri == null && this.bitmap == null) ? false : true;
    }

    @Override // android.view.View
    public void setOnLongClickListener(android.view.View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnImageEventListener(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener) {
        this.onImageEventListener = onImageEventListener;
    }

    public void setOnStateChangedListener(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener onStateChangedListener) {
        this.onStateChangedListener = onStateChangedListener;
    }

    private void sendStateChanged(float f, android.graphics.PointF pointF, int i) {
        com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener onStateChangedListener = this.onStateChangedListener;
        if (onStateChangedListener != null) {
            float f2 = this.scale;
            if (f2 != f) {
                onStateChangedListener.onScaleChanged(f2, i);
            }
        }
        if (this.onStateChangedListener == null || this.vTranslate.equals(pointF)) {
            return;
        }
        this.onStateChangedListener.onCenterChanged(getCenter(), i);
    }

    public com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder animateCenter(android.graphics.PointF pointF) {
        if (isReady()) {
            return new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder(pointF);
        }
        return null;
    }

    public com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder animateScale(float f) {
        if (isReady()) {
            return new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder(f);
        }
        return null;
    }

    public com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder animateScaleAndCenter(float f, android.graphics.PointF pointF) {
        if (isReady()) {
            return new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder(f, pointF);
        }
        return null;
    }

    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final android.graphics.PointF targetSCenter;
        private final float targetScale;
        private final android.graphics.PointF vFocus;

        private AnimationBuilder(android.graphics.PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f, android.graphics.PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f, android.graphics.PointF pointF, android.graphics.PointF pointF2) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }

        public com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder withDuration(long j) {
            this.duration = j;
            return this;
        }

        public com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder withInterruptible(boolean z) {
            this.interruptible = z;
            return this;
        }

        public com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder withEasing(int i) {
            if (!com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.VALID_EASING_STYLES.contains(java.lang.Integer.valueOf(i))) {
                throw new java.lang.IllegalArgumentException("Unknown easing type: " + i);
            }
            this.easing = i;
            return this;
        }

        public com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder withOnAnimationEventListener(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder withPanLimited(boolean z) {
            this.panLimited = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.AnimationBuilder withOrigin(int i) {
            this.origin = i;
            return this;
        }

        public void start() {
            if (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim != null && com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.listener != null) {
                try {
                    com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.listener.onInterruptedByNewAnim();
                } catch (java.lang.Exception e) {
                    android.util.Log.w(com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.TAG, "Error thrown by animation listener", e);
                }
            }
            int paddingLeft = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.getPaddingLeft() + (((com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.getWidth() - com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.getPaddingRight()) - com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.getPaddingTop() + (((com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.getHeight() - com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.getPaddingBottom()) - com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float fLimitedScale = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            android.graphics.PointF pointFLimitedSCenter = this.panLimited ? com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.limitedSCenter(this.targetSCenter.x, this.targetSCenter.y, fLimitedScale, new android.graphics.PointF()) : this.targetSCenter;
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Anim();
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.scaleStart = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.scale;
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.scaleEnd = fLimitedScale;
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.time = java.lang.System.currentTimeMillis();
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.sCenterEndRequested = pointFLimitedSCenter;
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.sCenterStart = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.getCenter();
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.sCenterEnd = pointFLimitedSCenter;
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.vFocusStart = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.sourceToViewCoord(pointFLimitedSCenter);
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.vFocusEnd = new android.graphics.PointF(paddingLeft, paddingTop);
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.duration = this.duration;
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.easing = this.easing;
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.origin = this.origin;
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.time = java.lang.System.currentTimeMillis();
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.listener = this.listener;
            android.graphics.PointF pointF = this.vFocus;
            if (pointF != null) {
                float f = pointF.x - (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.sCenterStart.x * fLimitedScale);
                float f2 = this.vFocus.y - (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.sCenterStart.y * fLimitedScale);
                com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate scaleAndTranslate = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate(fLimitedScale, new android.graphics.PointF(f, f2));
                com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.anim.vFocusEnd = new android.graphics.PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f2));
            }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.this.invalidate();
        }
    }
}
