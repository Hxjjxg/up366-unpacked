package com.up366.qrcode.view.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ViewfinderView extends android.view.View {
    private float animatedValue;
    private android.animation.ValueAnimator animator;
    private int corLength;
    private int corWidth;
    private int innercornercolor;
    private final int maskColor;
    private final android.graphics.Paint paint;
    private android.graphics.Bitmap scanLight;
    private android.graphics.Rect scanRect;

    public ViewfinderView(android.content.Context context) {
        this(context, null);
    }

    public ViewfinderView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ViewfinderView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scanRect = new android.graphics.Rect();
        this.paint = new android.graphics.Paint();
        android.content.res.Resources resources = getResources();
        this.maskColor = resources.getColor(com.up366.qrcode.R.color.viewfinder_mask);
        this.scanLight = android.graphics.BitmapFactory.decodeResource(resources, com.up366.qrcode.R.drawable.scan_light);
        initInnerRect(context, attributeSet);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation1();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.animation.ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    private void initInnerRect(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.qrcode.R.styleable.ViewfinderView);
        float dimension = typedArrayObtainStyledAttributes.getDimension(com.up366.qrcode.R.styleable.ViewfinderView_inner_margintop, -1.0f);
        if (dimension != -1.0f) {
            com.up366.qrcode.view.camera.CameraManager.FRAME_MARGINTOP = (int) dimension;
        }
        com.up366.qrcode.view.camera.CameraManager.FRAME_WIDTH = (int) typedArrayObtainStyledAttributes.getDimension(com.up366.qrcode.R.styleable.ViewfinderView_inner_width, (float) (((double) com.up366.qrcode.view.utils.ZXingLibrary.DisplayUtil.screenWidthPx) / 1.8d));
        com.up366.qrcode.view.camera.CameraManager.FRAME_HEIGHT = (int) typedArrayObtainStyledAttributes.getDimension(com.up366.qrcode.R.styleable.ViewfinderView_inner_height, (float) (((double) com.up366.qrcode.view.utils.ZXingLibrary.DisplayUtil.screenWidthPx) / 1.8d));
        this.innercornercolor = typedArrayObtainStyledAttributes.getColor(com.up366.qrcode.R.styleable.ViewfinderView_inner_corner_color, getResources().getColor(com.up366.qrcode.R.color.scan_grid_color));
        this.corLength = (int) typedArrayObtainStyledAttributes.getDimension(com.up366.qrcode.R.styleable.ViewfinderView_inner_corner_length, 50.0f);
        this.corWidth = (int) typedArrayObtainStyledAttributes.getDimension(com.up366.qrcode.R.styleable.ViewfinderView_inner_corner_width, 8.0f);
        this.scanLight = android.graphics.BitmapFactory.decodeResource(getResources(), typedArrayObtainStyledAttributes.getResourceId(com.up366.qrcode.R.styleable.ViewfinderView_inner_scan_bitmap, com.up366.qrcode.R.drawable.scan_light));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Rect framingRect = com.up366.qrcode.view.camera.CameraManager.get().getFramingRect();
        if (framingRect == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.paint.setColor(this.maskColor);
        float f = width;
        canvas.drawRect(0.0f, 0.0f, f, framingRect.top, this.paint);
        canvas.drawRect(0.0f, framingRect.top, framingRect.left, framingRect.bottom + 1, this.paint);
        canvas.drawRect(framingRect.right + 1, framingRect.top, f, framingRect.bottom + 1, this.paint);
        canvas.drawRect(0.0f, framingRect.bottom + 1, f, height, this.paint);
        drawFrameBounds(canvas, framingRect);
        drawScanLight(canvas, framingRect);
    }

    private void drawScanLight(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        canvas.save();
        canvas.clipRect(rect);
        this.scanRect.set(rect.left, rect.top, rect.right, rect.top + 30);
        this.scanRect.offset(0, (int) this.animatedValue);
        canvas.drawBitmap(this.scanLight, (android.graphics.Rect) null, this.scanRect, this.paint);
        canvas.restore();
    }

    public void startAnimation1() {
        android.animation.ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.animator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatCount(99999);
        this.animator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.qrcode.view.view.ViewfinderView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                this.f$0.m1388x3d8a7aa8(valueAnimator2);
            }
        });
        this.animator.setRepeatMode(2);
        this.animator.setDuration(1500L);
        this.animator.start();
    }

    /* JADX INFO: renamed from: lambda$startAnimation1$0$com-up366-qrcode-view-view-ViewfinderView, reason: not valid java name */
    /* synthetic */ void m1388x3d8a7aa8(android.animation.ValueAnimator valueAnimator) {
        if (com.up366.qrcode.view.camera.CameraManager.get().getFramingRect() == null) {
            return;
        }
        this.animatedValue = (((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue() * r0.height()) - 15.0f;
        postInvalidate();
    }

    private void drawFrameBounds(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        this.paint.setColor(this.innercornercolor);
        this.paint.setStyle(android.graphics.Paint.Style.FILL);
        canvas.drawLine(rect.left, rect.top, rect.right, rect.top, this.paint);
        canvas.drawLine(rect.left, rect.bottom, rect.right, rect.bottom, this.paint);
        canvas.drawLine(rect.left, rect.top, rect.left, rect.bottom, this.paint);
        canvas.drawLine(rect.right, rect.top, rect.right, rect.bottom, this.paint);
        canvas.drawRect(rect.left, rect.top, rect.left + this.corWidth, rect.top + this.corLength, this.paint);
        canvas.drawRect(rect.left, rect.top, rect.left + this.corLength, rect.top + this.corWidth, this.paint);
        canvas.drawRect(rect.right - this.corWidth, rect.top, rect.right, rect.top + this.corLength, this.paint);
        canvas.drawRect(rect.right - this.corLength, rect.top, rect.right, rect.top + this.corWidth, this.paint);
        canvas.drawRect(rect.left, rect.bottom - this.corLength, rect.left + this.corWidth, rect.bottom, this.paint);
        canvas.drawRect(rect.left, rect.bottom - this.corWidth, rect.left + this.corLength, rect.bottom, this.paint);
        canvas.drawRect(rect.right - this.corWidth, rect.bottom - this.corLength, rect.right, rect.bottom, this.paint);
        canvas.drawRect(rect.right - this.corLength, rect.bottom - this.corWidth, rect.right, rect.bottom, this.paint);
    }

    public void drawViewfinder() {
        invalidate();
    }
}
