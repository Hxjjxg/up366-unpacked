package com.up366.view.crop.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class OverlayView extends android.view.View {
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
    public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
    public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
    private com.up366.view.crop.callback.OverlayViewChangeListener mCallback;
    private boolean mCircleDimmedLayer;
    private android.graphics.Path mCircularPath;
    private android.graphics.Paint mCropFrameCornersPaint;
    private android.graphics.Paint mCropFramePaint;
    protected float[] mCropGridCenter;
    private int mCropGridColumnCount;
    protected float[] mCropGridCorners;
    private android.graphics.Paint mCropGridPaint;
    private int mCropGridRowCount;
    private int mCropRectCornerTouchAreaLineLength;
    private float mCropRectInitRatio;
    private int mCropRectMinSize;
    private final android.graphics.RectF mCropViewRect;
    private int mCurrentTouchCornerIndex;
    private int mDimmedColor;
    private android.graphics.Paint mDimmedStrokePaint;
    private final android.graphics.RectF mDistanceRect;
    private int mFreestyleCropMode;
    private float[] mGridPoints;
    private boolean mIsAcrossStartBorder;
    private float mPreviousTouchX;
    private float mPreviousTouchY;
    private boolean mShouldSetupCropBounds;
    private boolean mShowCropFrame;
    private boolean mShowCropGrid;
    private float mTargetAspectRatio;
    private final android.graphics.RectF mTempRect;
    protected int mThisHeight;
    protected int mThisWidth;
    private int mTouchPointThreshold;
    private final android.graphics.RectF startCropRect;

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
        this.startCropRect = new android.graphics.RectF();
        this.mDistanceRect = new android.graphics.RectF();
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
        this.mCropRectInitRatio = 0.95f;
        this.mIsAcrossStartBorder = false;
        this.mTouchPointThreshold = getResources().getDimensionPixelSize(com.up366.view.R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.mCropRectMinSize = getResources().getDimensionPixelSize(com.up366.view.R.dimen.ucrop_default_crop_rect_min_size);
        this.mCropRectInitRatio = getResources().getInteger(com.up366.view.R.integer.ucrop_default_crop_rect_init_ratio) / 100.0f;
        this.mCropRectCornerTouchAreaLineLength = getResources().getDimensionPixelSize(com.up366.view.R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        init();
    }

    public com.up366.view.crop.callback.OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    public void setOverlayViewChangeListener(com.up366.view.crop.callback.OverlayViewChangeListener overlayViewChangeListener) {
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

    public boolean isAcrossStartBorder() {
        return this.mIsAcrossStartBorder;
    }

    public void setAcrossStartBorderEnabled(boolean z) {
        this.mIsAcrossStartBorder = z;
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

    public void setCropFrameColor(int i) {
        this.mCropFramePaint.setColor(i);
    }

    public void setCropGridColor(int i) {
        this.mCropGridPaint.setColor(i);
    }

    public void setCropGridCornerColor(int i) {
        this.mCropFrameCornersPaint.setColor(i);
    }

    public void setTargetAspectRatio(float f) {
        this.mTargetAspectRatio = f;
        if (this.mThisWidth > 0) {
            setupCropBounds();
            this.startCropRect.set(this.mCropViewRect);
            this.mCropViewRect.inset((this.mCropViewRect.width() * (1.0f - this.mCropRectInitRatio)) / 2.0f, (this.mCropViewRect.height() * (1.0f - this.mCropRectInitRatio)) / 2.0f);
            com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.view.crop.view.OverlayView$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.m1391x4430a5fe();
                }
            });
            updateGridPoints();
            postInvalidate();
            return;
        }
        this.mShouldSetupCropBounds = true;
    }

    /* JADX INFO: renamed from: lambda$setTargetAspectRatio$0$com-up366-view-crop-view-OverlayView, reason: not valid java name */
    /* synthetic */ void m1391x4430a5fe() throws java.lang.Exception {
        com.up366.view.crop.callback.OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
        }
    }

    public float getmTargetAspectRatio() {
        return this.mTargetAspectRatio;
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
        com.up366.view.crop.callback.OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
        }
        updateGridPoints();
    }

    private void updateGridPoints() {
        this.mCropGridCorners = com.up366.view.crop.util.RectUtils.getCornersFromRect(this.mCropViewRect);
        this.mCropGridCenter = com.up366.view.crop.util.RectUtils.getCenterFromRect(this.mCropViewRect);
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

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.mCropViewRect.isEmpty() && this.mFreestyleCropMode != 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                int currentTouchIndex = getCurrentTouchIndex(x, y);
                this.mCurrentTouchCornerIndex = currentTouchIndex;
                boolean z = currentTouchIndex != -1;
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
                com.up366.view.crop.callback.OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
                if (overlayViewChangeListener != null) {
                    overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
                }
            }
        }
        return false;
    }

    private void updateCropViewRect(float f, float f2) {
        this.mTempRect.set(this.mCropViewRect);
        switch (this.mCurrentTouchCornerIndex) {
            case 0:
                this.mTempRect.set(f, f2, this.mCropViewRect.right, this.mCropViewRect.bottom);
                break;
            case 1:
                this.mTempRect.set(this.mCropViewRect.left, f2, f, this.mCropViewRect.bottom);
                break;
            case 2:
                this.mTempRect.set(this.mCropViewRect.left, this.mCropViewRect.top, f, f2);
                break;
            case 3:
                this.mTempRect.set(f, this.mCropViewRect.top, this.mCropViewRect.right, f2);
                break;
            case 4:
                if (this.mIsAcrossStartBorder) {
                    this.mTempRect.offset(f - this.mPreviousTouchX, 0.0f);
                    if (!this.startCropRect.contains(this.mTempRect)) {
                        this.mTempRect.offset(-(f - this.mPreviousTouchX), 0.0f);
                    }
                    this.mTempRect.offset(0.0f, f2 - this.mPreviousTouchY);
                    if (!this.startCropRect.contains(this.mTempRect)) {
                        this.mTempRect.offset(0.0f, -(f2 - this.mPreviousTouchY));
                    }
                } else {
                    this.mTempRect.offset(f - this.mPreviousTouchX, f2 - this.mPreviousTouchY);
                }
                if (this.mTempRect.left <= getLeft() || this.mTempRect.top <= getTop() || this.mTempRect.right >= getRight() || this.mTempRect.bottom >= getBottom()) {
                    return;
                }
                this.mCropViewRect.set(this.mTempRect);
                updateGridPoints();
                postInvalidate();
                return;
            case 5:
                this.mTempRect.set(this.mCropViewRect.left, f2, this.mCropViewRect.right, this.mCropViewRect.bottom);
                break;
            case 6:
                this.mTempRect.set(this.mCropViewRect.left, this.mCropViewRect.top, f, this.mCropViewRect.bottom);
                break;
            case 7:
                this.mTempRect.set(this.mCropViewRect.left, this.mCropViewRect.top, this.mCropViewRect.right, f2);
                break;
            case 8:
                this.mTempRect.set(f, this.mCropViewRect.top, this.mCropViewRect.right, this.mCropViewRect.bottom);
                break;
        }
        if (this.mIsAcrossStartBorder) {
            if (this.mTempRect.left < this.startCropRect.left) {
                this.mTempRect.left = this.startCropRect.left;
            }
            if (this.mTempRect.top < this.startCropRect.top) {
                this.mTempRect.top = this.startCropRect.top;
            }
            if (this.mTempRect.right > this.startCropRect.right) {
                this.mTempRect.right = this.startCropRect.right;
            }
            if (this.mTempRect.bottom > this.startCropRect.bottom) {
                this.mTempRect.bottom = this.startCropRect.bottom;
            }
        }
        if (java.lang.Math.min(this.mTempRect.width(), this.mTempRect.height()) >= this.mCropRectMinSize) {
            this.mCropViewRect.set(this.mTempRect);
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
        if (this.mFreestyleCropMode != 1 || i >= 0) {
            return i;
        }
        this.mDistanceRect.set(this.mCropViewRect.left - this.mTouchPointThreshold, this.mCropViewRect.top - this.mTouchPointThreshold, this.mCropViewRect.right + this.mTouchPointThreshold, this.mCropViewRect.bottom + this.mTouchPointThreshold);
        if (!this.mDistanceRect.contains(f, f2)) {
            return i;
        }
        this.mDistanceRect.set(this.mCropViewRect.left + this.mTouchPointThreshold, this.mCropViewRect.top + this.mTouchPointThreshold, this.mCropViewRect.right - this.mTouchPointThreshold, this.mCropViewRect.bottom - this.mTouchPointThreshold);
        if (this.mDistanceRect.contains(f, f2)) {
            return 4;
        }
        if (java.lang.Math.sqrt(java.lang.Math.pow(f - this.mCropGridCorners[0], 2.0d)) < d) {
            i = 8;
        }
        if (java.lang.Math.sqrt(java.lang.Math.pow(f - this.mCropGridCorners[2], 2.0d)) < d) {
            i = 6;
        }
        if (java.lang.Math.sqrt(java.lang.Math.pow(f2 - this.mCropGridCorners[1], 2.0d)) < d) {
            i = 5;
        }
        if (java.lang.Math.sqrt(java.lang.Math.pow(f2 - this.mCropGridCorners[5], 2.0d)) < d) {
            return 7;
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
        this.mCircleDimmedLayer = typedArray.getBoolean(com.up366.view.R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        int color = typedArray.getColor(com.up366.view.R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(com.up366.view.R.color.ucrop_color_default_dimmed));
        this.mDimmedColor = color;
        this.mDimmedStrokePaint.setColor(color);
        this.mDimmedStrokePaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mDimmedStrokePaint.setStrokeWidth(1.0f);
        initCropFrameStyle(typedArray);
        this.mShowCropFrame = typedArray.getBoolean(com.up366.view.R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        initCropGridStyle(typedArray);
        this.mShowCropGrid = typedArray.getBoolean(com.up366.view.R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    private void initCropFrameStyle(android.content.res.TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(com.up366.view.R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(com.up366.view.R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(com.up366.view.R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(com.up366.view.R.color.ucrop_color_default_crop_frame));
        this.mCropFramePaint.setStrokeWidth(dimensionPixelSize);
        this.mCropFramePaint.setColor(color);
        this.mCropFramePaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mCropFrameCornersPaint.setStrokeWidth(dimensionPixelSize * 3);
        this.mCropFrameCornersPaint.setColor(color);
        this.mCropFrameCornersPaint.setStyle(android.graphics.Paint.Style.STROKE);
    }

    private void initCropGridStyle(android.content.res.TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(com.up366.view.R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(com.up366.view.R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(com.up366.view.R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(com.up366.view.R.color.ucrop_color_default_crop_grid));
        this.mCropGridPaint.setStrokeWidth(dimensionPixelSize);
        this.mCropGridPaint.setColor(color);
        this.mCropGridRowCount = typedArray.getInt(com.up366.view.R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.mCropGridColumnCount = typedArray.getInt(com.up366.view.R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }
}
