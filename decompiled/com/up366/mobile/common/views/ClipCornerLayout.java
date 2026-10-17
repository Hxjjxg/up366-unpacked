package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ClipCornerLayout extends android.widget.FrameLayout {
    private static final java.lang.String TAG = "ClipCornerLayout";
    private android.graphics.PorterDuffXfermode dstIn;
    private boolean onLayoutChanged;
    private android.graphics.Paint paint;
    private final android.graphics.Path path;
    private float radiusLB;
    private float radiusLT;
    private float radiusRB;
    private float radiusRT;
    private final android.graphics.RectF rect;
    private android.graphics.Bitmap srcBitmap;

    /* JADX INFO: Access modifiers changed from: private */
    interface IAfterClipCallback {
        void onFinish();
    }

    public ClipCornerLayout(android.content.Context context) {
        this(context, null);
    }

    public ClipCornerLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipCornerLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rect = new android.graphics.RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.path = new android.graphics.Path();
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paint = paint;
        paint.setStrokeWidth(1.0f);
        this.paint.setStyle(android.graphics.Paint.Style.FILL);
        this.dstIn = new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN);
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.ClipCornerLayout);
            float dimension = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
            this.radiusLT = typedArrayObtainStyledAttributes.getDimension(2, dimension);
            this.radiusRT = typedArrayObtainStyledAttributes.getDimension(4, dimension);
            this.radiusLB = typedArrayObtainStyledAttributes.getDimension(1, dimension);
            this.radiusRB = typedArrayObtainStyledAttributes.getDimension(3, dimension);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void makeSrcBitmapFromPath(int i, int i2) {
        android.graphics.Bitmap bitmap;
        if (this.onLayoutChanged || (bitmap = this.srcBitmap) == null || bitmap.isRecycled()) {
            android.graphics.Bitmap bitmap2 = this.srcBitmap;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.srcBitmap.recycle();
            }
            this.onLayoutChanged = false;
            this.path.reset();
            this.rect.set(0.0f, 0.0f, i, i2);
            android.graphics.Path path = this.path;
            android.graphics.RectF rectF = this.rect;
            float f = this.radiusLT;
            float f2 = this.radiusRT;
            float f3 = this.radiusRB;
            float f4 = this.radiusLB;
            path.addRoundRect(rectF, new float[]{f, f, f2, f2, f3, f3, f4, f4}, android.graphics.Path.Direction.CW);
            this.srcBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ALPHA_8);
            android.graphics.Canvas canvas = new android.graphics.Canvas(this.srcBitmap);
            android.graphics.Paint paint = new android.graphics.Paint(1);
            paint.setColor(-1);
            canvas.drawPath(this.path, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatchDraw$0(android.graphics.Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(final android.graphics.Canvas canvas) {
        clipCanvas(canvas, new com.up366.mobile.common.views.ClipCornerLayout.IAfterClipCallback() { // from class: com.up366.mobile.common.views.ClipCornerLayout$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.views.ClipCornerLayout.IAfterClipCallback
            public final void onFinish() {
                this.f$0.lambda$dispatchDraw$0(canvas);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$draw$1(android.graphics.Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View
    public void draw(final android.graphics.Canvas canvas) {
        clipCanvas(canvas, new com.up366.mobile.common.views.ClipCornerLayout.IAfterClipCallback() { // from class: com.up366.mobile.common.views.ClipCornerLayout$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.views.ClipCornerLayout.IAfterClipCallback
            public final void onFinish() {
                this.f$0.lambda$draw$1(canvas);
            }
        });
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.onLayoutChanged = true;
        }
    }

    private void clipCanvas(android.graphics.Canvas canvas, com.up366.mobile.common.views.ClipCornerLayout.IAfterClipCallback iAfterClipCallback) {
        if (this.radiusLT + this.radiusRT + this.radiusRB + this.radiusLB == 0.0f) {
            iAfterClipCallback.onFinish();
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        int width = getWidth();
        int height = getHeight();
        makeSrcBitmapFromPath(width, height);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, width, height, this.paint, 31);
        iAfterClipCallback.onFinish();
        this.paint.setXfermode(this.dstIn);
        canvas.drawBitmap(this.srcBitmap, 0.0f, 0.0f, this.paint);
        this.paint.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
        android.util.Log.i(TAG, "clipCanvas: time : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        this.radiusLT = i;
        this.radiusRT = i2;
        this.radiusLB = i3;
        this.radiusRB = i4;
        postInvalidate();
    }
}
