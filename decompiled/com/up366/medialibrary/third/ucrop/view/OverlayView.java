package com.up366.medialibrary.third.ucrop.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OverlayView extends android.view.View {
    private static final long CROP_SIZE_CHANGE_DURATION = 260;
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final boolean DEFAULT_DRAG_FRAME = true;
    public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
    public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
    public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
    private static final long SMOOTH_CENTER_DURATION = 1000;
    private android.animation.ValueAnimator cropSizeChangeAnimator;
    private boolean isDragCenter;
    private boolean isDragFrame;
    private com.up366.medialibrary.third.ucrop.callback.OverlayViewChangeListener mCallback;
    private boolean mCircleDimmedLayer;
    private final android.graphics.Path mCircularPath;
    private final android.graphics.Paint mCropFrameCornersPaint;
    private final android.graphics.Paint mCropFramePaint;
    protected float[] mCropGridCenter;
    private int mCropGridColumnCount;
    protected float[] mCropGridCorners;
    private final android.graphics.Paint mCropGridPaint;
    private int mCropGridRowCount;
    private final int mCropRectCornerTouchAreaLineLength;
    private final int mCropRectMinSize;
    private final android.graphics.RectF mCropViewRect;
    private int mCurrentTouchCornerIndex;
    private int mDimmedBorderColor;
    private int mDimmedColor;
    private final android.graphics.Paint mDimmedStrokePaint;
    private int mFreestyleCropMode;
    private float[] mGridPoints;
    private float mPreviousTouchX;
    private float mPreviousTouchY;
    private boolean mShouldSetupCropBounds;
    private boolean mShowCropFrame;
    private boolean mShowCropGrid;
    private int mStrokeWidth;
    private float mTargetAspectRatio;
    private final android.graphics.RectF mTempRect;
    protected int mThisHeight;
    protected int mThisWidth;
    private final int mTouchPointThreshold;
    private android.animation.ValueAnimator smoothAnimator;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FreestyleMode {
    }

    protected void init() {
    }

    public OverlayView(android.content.Context context) {
        this(context, null);
    }

    public OverlayView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCropViewRect = new android.graphics.RectF();
        this.mTempRect = new android.graphics.RectF();
        this.mGridPoints = null;
        this.mCircularPath = new android.graphics.Path();
        this.mDimmedStrokePaint = new android.graphics.Paint(1);
        this.mCropGridPaint = new android.graphics.Paint(1);
        this.mCropFramePaint = new android.graphics.Paint(1);
        this.mCropFrameCornersPaint = new android.graphics.Paint(1);
        this.mFreestyleCropMode = 0;
        this.mPreviousTouchX = -1.0f;
        this.mPreviousTouchY = -1.0f;
        this.mCurrentTouchCornerIndex = -1;
        this.mStrokeWidth = 1;
        this.isDragFrame = true;
        this.mTouchPointThreshold = getResources().getDimensionPixelSize(com.up366.medialibrary.R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.mCropRectMinSize = getResources().getDimensionPixelSize(com.up366.medialibrary.R.dimen.ucrop_default_crop_rect_min_size);
        this.mCropRectCornerTouchAreaLineLength = getResources().getDimensionPixelSize(com.up366.medialibrary.R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        init();
    }

    public com.up366.medialibrary.third.ucrop.callback.OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    public void setOverlayViewChangeListener(com.up366.medialibrary.third.ucrop.callback.OverlayViewChangeListener overlayViewChangeListener) {
        this.mCallback = overlayViewChangeListener;
    }

    public android.graphics.RectF getCropViewRect() {
        return this.mCropViewRect;
    }

    @java.lang.Deprecated
    public boolean isFreestyleCropEnabled() {
        return this.mFreestyleCropMode == 1;
    }

    @java.lang.Deprecated
    public void setFreestyleCropEnabled(boolean z) {
        this.mFreestyleCropMode = z ? 1 : 0;
    }

    public void setDragFrame(boolean z) {
        this.isDragFrame = z;
    }

    public void setDragSmoothToCenter(boolean z) {
        this.isDragCenter = z;
    }

    public void setDimmedStrokeWidth(int i) {
        this.mStrokeWidth = i;
        android.graphics.Paint paint = this.mDimmedStrokePaint;
        if (paint != null) {
            paint.setStrokeWidth(i);
        }
    }

    public int getFreestyleCropMode() {
        return this.mFreestyleCropMode;
    }

    public void setFreestyleCropMode(int i) {
        this.mFreestyleCropMode = i;
        postInvalidate();
    }

    public void setCircleDimmedLayer(boolean z) {
        this.mCircleDimmedLayer = z;
    }

    public void setCropGridRowCount(int i) {
        this.mCropGridRowCount = i;
        this.mGridPoints = null;
    }

    public void setCropGridColumnCount(int i) {
        this.mCropGridColumnCount = i;
        this.mGridPoints = null;
    }

    public void setShowCropFrame(boolean z) {
        this.mShowCropFrame = z;
    }

    public void setShowCropGrid(boolean z) {
        this.mShowCropGrid = z;
    }

    public void setDimmedColor(int i) {
        this.mDimmedColor = i;
    }

    public void setCropFrameStrokeWidth(int i) {
        this.mCropFramePaint.setStrokeWidth(i);
    }

    public void setCropGridStrokeWidth(int i) {
        this.mCropGridPaint.setStrokeWidth(i);
    }

    public void setDimmedBorderColor(int i) {
        this.mDimmedBorderColor = i;
        android.graphics.Paint paint = this.mDimmedStrokePaint;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setCropFrameColor(int i) {
        this.mCropFramePaint.setColor(i);
    }

    public void setCropGridColor(int i) {
        this.mCropGridPaint.setColor(i);
    }

    public void setTargetAspectRatio(float f) {
        this.mTargetAspectRatio = f;
        if (this.mThisWidth > 0) {
            setupCropBounds();
            postInvalidate();
        } else {
            this.mShouldSetupCropBounds = true;
        }
    }

    public void setupCropBounds() {
        int i = this.mThisWidth;
        float f = this.mTargetAspectRatio;
        int i2 = (int) (i / f);
        int i3 = this.mThisHeight;
        if (i2 > i3) {
            int i4 = (i - ((int) (i3 * f))) / 2;
            this.mCropViewRect.set(getPaddingLeft() + i4, getPaddingTop(), getPaddingLeft() + r1 + i4, getPaddingTop() + this.mThisHeight);
        } else {
            int i5 = (i3 - i2) / 2;
            this.mCropViewRect.set(getPaddingLeft(), getPaddingTop() + i5, getPaddingLeft() + this.mThisWidth, getPaddingTop() + i2 + i5);
        }
        com.up366.medialibrary.third.ucrop.callback.OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
        }
        updateGridPoints();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGridPoints() {
        this.mCropGridCorners = com.up366.medialibrary.third.ucrop.util.RectUtils.getCornersFromRect(this.mCropViewRect);
        this.mCropGridCenter = com.up366.medialibrary.third.ucrop.util.RectUtils.getCenterFromRect(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        this.mCircularPath.addCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), java.lang.Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, android.graphics.Path.Direction.CW);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.mThisWidth = width - paddingLeft;
            this.mThisHeight = height - paddingTop;
            if (this.mShouldSetupCropBounds) {
                this.mShouldSetupCropBounds = false;
                setTargetAspectRatio(this.mTargetAspectRatio);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        drawDimmedLayer(canvas);
        drawCropGrid(canvas);
    }

    private void cropSizeChangedAnim(final android.graphics.RectF rectF) {
        final float f = this.mCropViewRect.left - rectF.left;
        final float f2 = this.mCropViewRect.top - rectF.top;
        android.animation.ValueAnimator valueAnimator = this.cropSizeChangeAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        } else {
            android.animation.ValueAnimator valueAnimator2 = new android.animation.ValueAnimator();
            this.cropSizeChangeAnimator = valueAnimator2;
            valueAnimator2.setInterpolator(new android.view.animation.LinearInterpolator());
            this.cropSizeChangeAnimator.setDuration(CROP_SIZE_CHANGE_DURATION);
            this.cropSizeChangeAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.medialibrary.third.ucrop.view.OverlayView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    super.onAnimationEnd(animator);
                    if (com.up366.medialibrary.third.ucrop.view.OverlayView.this.mCallback != null) {
                        com.up366.medialibrary.third.ucrop.view.OverlayView.this.mCallback.onCropRectUpdated(com.up366.medialibrary.third.ucrop.view.OverlayView.this.mCropViewRect);
                    }
                }
            });
        }
        this.cropSizeChangeAnimator.setFloatValues(0.0f, 1.0f);
        this.cropSizeChangeAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.medialibrary.third.ucrop.view.OverlayView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator3) {
                float fFloatValue = ((java.lang.Float) valueAnimator3.getAnimatedValue()).floatValue();
                float f3 = f * fFloatValue;
                float f4 = fFloatValue * f2;
                com.up366.medialibrary.third.ucrop.view.OverlayView.this.mCropViewRect.set(new android.graphics.RectF(rectF.left + f3, rectF.top + f4, rectF.right - f3, rectF.bottom - f4));
                com.up366.medialibrary.third.ucrop.view.OverlayView.this.updateGridPoints();
                com.up366.medialibrary.third.ucrop.view.OverlayView.this.postInvalidate();
            }
        });
        this.cropSizeChangeAnimator.start();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean z = false;
        if (!this.mCropViewRect.isEmpty() && this.mFreestyleCropMode != 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                android.animation.ValueAnimator valueAnimator = this.smoothAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                int currentTouchIndex = getCurrentTouchIndex(x, y);
                this.mCurrentTouchCornerIndex = currentTouchIndex;
                if (currentTouchIndex != -1 && currentTouchIndex != 4) {
                    z = true;
                }
                if (!z) {
                    this.mPreviousTouchX = -1.0f;
                    this.mPreviousTouchY = -1.0f;
                } else if (this.mPreviousTouchX < 0.0f) {
                    this.mPreviousTouchX = x;
                    this.mPreviousTouchY = y;
                }
                return z;
            }
            if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
                float fMin = java.lang.Math.min(java.lang.Math.max(x, getPaddingLeft()), getWidth() - getPaddingRight());
                float fMin2 = java.lang.Math.min(java.lang.Math.max(y, getPaddingTop()), getHeight() - getPaddingBottom());
                updateCropViewRect(fMin, fMin2);
                this.mPreviousTouchX = fMin;
                this.mPreviousTouchY = fMin2;
                return true;
            }
            if ((motionEvent.getAction() & 255) == 1) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
                this.mCurrentTouchCornerIndex = -1;
                com.up366.medialibrary.third.ucrop.callback.OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
                if (overlayViewChangeListener != null) {
                    overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
                }
                if (this.isDragCenter) {
                    smoothToCenter();
                }
            }
        }
        return false;
    }

    private void updateCropViewRect(float f, float f2) {
        this.mTempRect.set(this.mCropViewRect);
        int i = this.mCurrentTouchCornerIndex;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            this.mTempRect.offset(f - this.mPreviousTouchX, f2 - this.mPreviousTouchY);
                            if (this.mTempRect.left <= getLeft() || this.mTempRect.top <= getTop() || this.mTempRect.right >= getRight() || this.mTempRect.bottom >= getBottom()) {
                                return;
                            }
                            this.mCropViewRect.set(this.mTempRect);
                            updateGridPoints();
                            postInvalidate();
                            return;
                        }
                    } else if (this.isDragFrame) {
                        this.mTempRect.set(f, this.mCropViewRect.top, this.mCropViewRect.right, f2);
                    }
                } else if (this.isDragFrame) {
                    this.mTempRect.set(this.mCropViewRect.left, this.mCropViewRect.top, f, f2);
                }
            } else if (this.isDragFrame) {
                this.mTempRect.set(this.mCropViewRect.left, f2, f, this.mCropViewRect.bottom);
            }
        } else if (this.isDragFrame) {
            this.mTempRect.set(f, f2, this.mCropViewRect.right, this.mCropViewRect.bottom);
        }
        boolean z = this.mTempRect.height() >= ((float) this.mCropRectMinSize);
        boolean z2 = this.mTempRect.width() >= ((float) this.mCropRectMinSize);
        android.graphics.RectF rectF = this.mCropViewRect;
        rectF.set(z2 ? this.mTempRect.left : rectF.left, (z ? this.mTempRect : this.mCropViewRect).top, (z2 ? this.mTempRect : this.mCropViewRect).right, (z ? this.mTempRect : this.mCropViewRect).bottom);
        if (z || z2) {
            updateGridPoints();
            postInvalidate();
        }
    }

    private int getCurrentTouchIndex(float f, float f2) {
        double d = this.mTouchPointThreshold;
        int i = -1;
        for (int i2 = 0; i2 < 8; i2 += 2) {
            double dSqrt = java.lang.Math.sqrt(java.lang.Math.pow(f - this.mCropGridCorners[i2], 2.0d) + java.lang.Math.pow(f2 - this.mCropGridCorners[i2 + 1], 2.0d));
            if (dSqrt < d) {
                i = i2 / 2;
                d = dSqrt;
            }
        }
        if (this.mFreestyleCropMode == 1 && i < 0 && this.mCropViewRect.contains(f, f2)) {
            return 4;
        }
        return i;
    }

    protected void drawDimmedLayer(android.graphics.Canvas canvas) {
        canvas.save();
        if (this.mCircleDimmedLayer) {
            canvas.clipPath(this.mCircularPath, android.graphics.Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, android.graphics.Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.mDimmedColor);
        canvas.restore();
        if (this.mCircleDimmedLayer) {
            canvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), java.lang.Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, this.mDimmedStrokePaint);
        }
    }

    protected void drawCropGrid(android.graphics.Canvas canvas) {
        if (this.mShowCropGrid) {
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                this.mGridPoints = new float[(this.mCropGridRowCount * 4) + (this.mCropGridColumnCount * 4)];
                int i = 0;
                for (int i2 = 0; i2 < this.mCropGridRowCount; i2++) {
                    this.mGridPoints[i] = this.mCropViewRect.left;
                    float f = i2 + 1.0f;
                    this.mGridPoints[i + 1] = (this.mCropViewRect.height() * (f / (this.mCropGridRowCount + 1))) + this.mCropViewRect.top;
                    int i3 = i + 3;
                    this.mGridPoints[i + 2] = this.mCropViewRect.right;
                    i += 4;
                    this.mGridPoints[i3] = (this.mCropViewRect.height() * (f / (this.mCropGridRowCount + 1))) + this.mCropViewRect.top;
                }
                for (int i4 = 0; i4 < this.mCropGridColumnCount; i4++) {
                    float f2 = i4 + 1.0f;
                    this.mGridPoints[i] = (this.mCropViewRect.width() * (f2 / (this.mCropGridColumnCount + 1))) + this.mCropViewRect.left;
                    this.mGridPoints[i + 1] = this.mCropViewRect.top;
                    int i5 = i + 3;
                    this.mGridPoints[i + 2] = (this.mCropViewRect.width() * (f2 / (this.mCropGridColumnCount + 1))) + this.mCropViewRect.left;
                    i += 4;
                    this.mGridPoints[i5] = this.mCropViewRect.bottom;
                }
            }
            float[] fArr = this.mGridPoints;
            if (fArr != null) {
                canvas.drawLines(fArr, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mFreestyleCropMode != 0) {
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            this.mTempRect.inset(this.mCropRectCornerTouchAreaLineLength, -r1);
            canvas.clipRect(this.mTempRect, android.graphics.Region.Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            this.mTempRect.inset(-r1, this.mCropRectCornerTouchAreaLineLength);
            canvas.clipRect(this.mTempRect, android.graphics.Region.Op.DIFFERENCE);
            canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
            canvas.restore();
        }
    }

    protected void processStyledAttributes(android.content.res.TypedArray typedArray) {
        this.mCircleDimmedLayer = typedArray.getBoolean(com.up366.medialibrary.R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        this.mDimmedColor = typedArray.getColor(com.up366.medialibrary.R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(com.up366.medialibrary.R.color.ucrop_color_default_dimmed));
        this.mDimmedStrokePaint.setColor(this.mDimmedBorderColor);
        this.mDimmedStrokePaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mDimmedStrokePaint.setStrokeWidth(this.mStrokeWidth);
        initCropFrameStyle(typedArray);
        this.mShowCropFrame = typedArray.getBoolean(com.up366.medialibrary.R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        initCropGridStyle(typedArray);
        this.mShowCropGrid = typedArray.getBoolean(com.up366.medialibrary.R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    private void initCropFrameStyle(android.content.res.TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(com.up366.medialibrary.R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(com.up366.medialibrary.R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(com.up366.medialibrary.R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(com.up366.medialibrary.R.color.ucrop_color_default_crop_frame));
        this.mCropFramePaint.setStrokeWidth(dimensionPixelSize);
        this.mCropFramePaint.setColor(color);
        this.mCropFramePaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mCropFrameCornersPaint.setStrokeWidth(dimensionPixelSize * 3);
        this.mCropFrameCornersPaint.setColor(color);
        this.mCropFrameCornersPaint.setStyle(android.graphics.Paint.Style.STROKE);
    }

    private void initCropGridStyle(android.content.res.TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(com.up366.medialibrary.R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(com.up366.medialibrary.R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(com.up366.medialibrary.R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(com.up366.medialibrary.R.color.ucrop_color_default_crop_grid));
        this.mCropGridPaint.setStrokeWidth(dimensionPixelSize);
        this.mCropGridPaint.setColor(color);
        this.mCropGridRowCount = typedArray.getInt(com.up366.medialibrary.R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.mCropGridColumnCount = typedArray.getInt(com.up366.medialibrary.R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void smoothToCenter() {
        android.graphics.Point point = new android.graphics.Point((getRight() + getLeft()) / 2, (getTop() + getBottom()) / 2);
        final int iCenterY = (int) (point.y - this.mCropViewRect.centerY());
        final int iCenterX = (int) (point.x - this.mCropViewRect.centerX());
        final android.graphics.RectF rectF = new android.graphics.RectF(this.mCropViewRect);
        new android.graphics.RectF(this.mCropViewRect).offset(iCenterX, iCenterY);
        android.animation.ValueAnimator valueAnimator = this.smoothAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.smoothAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.smoothAnimator.setInterpolator(new android.view.animation.OvershootInterpolator(1.0f));
        this.smoothAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.medialibrary.third.ucrop.view.OverlayView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.up366.medialibrary.third.ucrop.view.OverlayView.this.mCallback != null) {
                    com.up366.medialibrary.third.ucrop.view.OverlayView.this.mCallback.onCropRectUpdated(com.up366.medialibrary.third.ucrop.view.OverlayView.this.mCropViewRect);
                }
            }
        });
        this.smoothAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.medialibrary.third.ucrop.view.OverlayView.4
            float lastAnimationValue = 0.0f;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                float fFloatValue = iCenterX * ((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue();
                float fFloatValue2 = iCenterY * ((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue();
                com.up366.medialibrary.third.ucrop.view.OverlayView.this.mCropViewRect.set(new android.graphics.RectF(rectF.left + fFloatValue, rectF.top + fFloatValue2, rectF.right + fFloatValue, rectF.bottom + fFloatValue2));
                com.up366.medialibrary.third.ucrop.view.OverlayView.this.updateGridPoints();
                com.up366.medialibrary.third.ucrop.view.OverlayView.this.postInvalidate();
                if (com.up366.medialibrary.third.ucrop.view.OverlayView.this.mCallback != null) {
                    com.up366.medialibrary.third.ucrop.view.OverlayView.this.mCallback.postTranslate(iCenterX * (((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue() - this.lastAnimationValue), iCenterY * (((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue() - this.lastAnimationValue));
                }
                this.lastAnimationValue = ((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue();
            }
        });
        this.smoothAnimator.start();
    }
}
