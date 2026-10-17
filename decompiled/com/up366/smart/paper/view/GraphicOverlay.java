package com.up366.smart.paper.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class GraphicOverlay extends android.view.View {
    private final java.util.List<com.up366.smart.paper.view.GraphicOverlay.Graphic> graphics;
    private int imageHeight;
    private int imageWidth;
    private boolean isImageFlipped;
    private final java.lang.Object lock;
    private boolean needUpdateTransformation;
    private float postScaleHeightOffset;
    private float postScaleWidthOffset;
    private float scaleFactor;
    private final android.graphics.Matrix transformationMatrix;

    public static abstract class Graphic {
        private com.up366.smart.paper.view.GraphicOverlay overlay;

        public abstract void draw(android.graphics.Canvas canvas);

        public Graphic(com.up366.smart.paper.view.GraphicOverlay overlay) {
            this.overlay = overlay;
        }

        public float scale(float imagePixel) {
            return imagePixel * this.overlay.scaleFactor;
        }

        public android.content.Context getApplicationContext() {
            return this.overlay.getContext().getApplicationContext();
        }

        public boolean isImageFlipped() {
            return this.overlay.isImageFlipped;
        }

        public float translateX(float x) {
            return this.overlay.isImageFlipped ? this.overlay.getWidth() - (scale(x) - this.overlay.postScaleWidthOffset) : scale(x) - this.overlay.postScaleWidthOffset;
        }

        public float translateY(float y) {
            return scale(y) - this.overlay.postScaleHeightOffset;
        }

        public android.graphics.Matrix getTransformationMatrix() {
            return this.overlay.transformationMatrix;
        }

        public void postInvalidate() {
            this.overlay.postInvalidate();
        }
    }

    public GraphicOverlay(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        this.lock = new java.lang.Object();
        this.graphics = new java.util.ArrayList();
        this.transformationMatrix = new android.graphics.Matrix();
        this.scaleFactor = 1.0f;
        this.needUpdateTransformation = true;
        addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() { // from class: com.up366.smart.paper.view.GraphicOverlay$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.m1389lambda$new$0$comup366smartpaperviewGraphicOverlay(view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$com-up366-smart-paper-view-GraphicOverlay, reason: not valid java name */
    /* synthetic */ void m1389lambda$new$0$comup366smartpaperviewGraphicOverlay(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.needUpdateTransformation = true;
    }

    public void clear() {
        synchronized (this.lock) {
            this.graphics.clear();
        }
        postInvalidate();
    }

    public void add(com.up366.smart.paper.view.GraphicOverlay.Graphic graphic) {
        synchronized (this.lock) {
            this.graphics.add(graphic);
        }
    }

    public void remove(com.up366.smart.paper.view.GraphicOverlay.Graphic graphic) {
        synchronized (this.lock) {
            this.graphics.remove(graphic);
        }
        postInvalidate();
    }

    public void setImageSourceInfo(int imageWidth, int imageHeight, boolean isFlipped) {
        synchronized (this.lock) {
            this.imageWidth = imageWidth;
            this.imageHeight = imageHeight;
            this.isImageFlipped = isFlipped;
            this.needUpdateTransformation = true;
        }
        postInvalidate();
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    private void updateTransformationIfNeeded() {
        if (!this.needUpdateTransformation || this.imageWidth <= 0 || this.imageHeight <= 0) {
            return;
        }
        float width = getWidth() / getHeight();
        float f = this.imageWidth / this.imageHeight;
        this.postScaleWidthOffset = 0.0f;
        this.postScaleHeightOffset = 0.0f;
        if (width > f) {
            this.scaleFactor = getWidth() / this.imageWidth;
            this.postScaleHeightOffset = ((getWidth() / f) - getHeight()) / 2.0f;
        } else {
            this.scaleFactor = getHeight() / this.imageHeight;
            this.postScaleWidthOffset = ((getHeight() * f) - getWidth()) / 2.0f;
        }
        this.transformationMatrix.reset();
        android.graphics.Matrix matrix = this.transformationMatrix;
        float f2 = this.scaleFactor;
        matrix.setScale(f2, f2);
        this.transformationMatrix.postTranslate(-this.postScaleWidthOffset, -this.postScaleHeightOffset);
        if (this.isImageFlipped) {
            this.transformationMatrix.postScale(-1.0f, 1.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        }
        this.needUpdateTransformation = false;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        synchronized (this.lock) {
            updateTransformationIfNeeded();
            java.util.Iterator<com.up366.smart.paper.view.GraphicOverlay.Graphic> it = this.graphics.iterator();
            while (it.hasNext()) {
                it.next().draw(canvas);
            }
        }
    }
}
