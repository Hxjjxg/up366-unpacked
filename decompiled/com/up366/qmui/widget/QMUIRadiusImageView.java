package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIRadiusImageView extends androidx.appcompat.widget.AppCompatImageView {
    private static final android.graphics.Bitmap.Config BITMAP_CONFIG = android.graphics.Bitmap.Config.ARGB_8888;
    private static final int COLOR_DRAWABLE_DIMEN = 2;
    private static final int DEFAULT_BORDER_COLOR = -7829368;
    private android.graphics.Bitmap mBitmap;
    private android.graphics.Paint mBitmapPaint;
    private android.graphics.BitmapShader mBitmapShader;
    private int mBorderColor;
    private android.graphics.Paint mBorderPaint;
    private int mBorderWidth;
    private android.graphics.ColorFilter mColorFilter;
    private int mCornerRadius;
    private android.graphics.RectF mDrawRectF;
    private int mHeight;
    private boolean mIsCircle;
    private boolean mIsOval;
    private boolean mIsSelected;
    private boolean mIsTouchSelectModeEnabled;
    private android.widget.ImageView.ScaleType mLastCalculateScaleType;
    private android.graphics.Matrix mMatrix;
    private boolean mNeedResetShader;
    private android.graphics.RectF mRectF;
    private int mSelectedBorderColor;
    private int mSelectedBorderWidth;
    private android.graphics.ColorFilter mSelectedColorFilter;
    private int mSelectedMaskColor;
    private int mWidth;

    public QMUIRadiusImageView(android.content.Context context) {
        this(context, null, com.qmuiteam.qmui.R.attr.QMUIRadiusImageViewStyle);
    }

    public QMUIRadiusImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUIRadiusImageViewStyle);
    }

    public QMUIRadiusImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsSelected = false;
        this.mIsOval = false;
        this.mIsCircle = false;
        this.mIsTouchSelectModeEnabled = true;
        this.mNeedResetShader = false;
        this.mRectF = new android.graphics.RectF();
        this.mDrawRectF = new android.graphics.RectF();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mBorderPaint = paint;
        paint.setAntiAlias(true);
        this.mBorderPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mMatrix = new android.graphics.Matrix();
        setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView, i, 0);
        this.mBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView_qmui_border_width, 0);
        this.mBorderColor = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView_qmui_border_color, -7829368);
        this.mSelectedBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView_qmui_selected_border_width, this.mBorderWidth);
        this.mSelectedBorderColor = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView_qmui_selected_border_color, this.mBorderColor);
        int color = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView_qmui_selected_mask_color, 0);
        this.mSelectedMaskColor = color;
        if (color != 0) {
            this.mSelectedColorFilter = new android.graphics.PorterDuffColorFilter(this.mSelectedMaskColor, android.graphics.PorterDuff.Mode.DARKEN);
        }
        this.mIsTouchSelectModeEnabled = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView_qmui_is_touch_select_mode_enabled, true);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView_qmui_is_circle, false);
        this.mIsCircle = z;
        if (!z) {
            this.mIsOval = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView_qmui_is_oval, false);
        }
        if (!this.mIsOval) {
            this.mCornerRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIRadiusImageView_qmui_corner_radius, 0);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new java.lang.IllegalArgumentException("不支持adjustViewBounds");
        }
    }

    public void setBorderWidth(int i) {
        if (this.mBorderWidth != i) {
            this.mBorderWidth = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidate();
        }
    }

    public void setCornerRadius(int i) {
        if (this.mCornerRadius != i) {
            this.mCornerRadius = i;
            if (this.mIsCircle || this.mIsOval) {
                return;
            }
            invalidate();
        }
    }

    public void setSelectedBorderColor(int i) {
        if (this.mSelectedBorderColor != i) {
            this.mSelectedBorderColor = i;
            if (this.mIsSelected) {
                invalidate();
            }
        }
    }

    public void setSelectedBorderWidth(int i) {
        if (this.mSelectedBorderWidth != i) {
            this.mSelectedBorderWidth = i;
            if (this.mIsSelected) {
                invalidate();
            }
        }
    }

    public void setSelectedMaskColor(int i) {
        if (this.mSelectedMaskColor != i) {
            this.mSelectedMaskColor = i;
            if (i != 0) {
                this.mSelectedColorFilter = new android.graphics.PorterDuffColorFilter(this.mSelectedMaskColor, android.graphics.PorterDuff.Mode.DARKEN);
            } else {
                this.mSelectedColorFilter = null;
            }
            if (this.mIsSelected) {
                invalidate();
            }
        }
        this.mSelectedMaskColor = i;
    }

    public void setCircle(boolean z) {
        if (this.mIsCircle != z) {
            this.mIsCircle = z;
            requestLayout();
            invalidate();
        }
    }

    public void setOval(boolean z) {
        boolean z2 = false;
        if (z && this.mIsCircle) {
            this.mIsCircle = false;
            z2 = true;
        }
        if (this.mIsOval != z || z2) {
            this.mIsOval = z;
            requestLayout();
            invalidate();
        }
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getSelectedBorderColor() {
        return this.mSelectedBorderColor;
    }

    public int getSelectedBorderWidth() {
        return this.mSelectedBorderWidth;
    }

    public int getSelectedMaskColor() {
        return this.mSelectedMaskColor;
    }

    public boolean isCircle() {
        return this.mIsCircle;
    }

    public boolean isOval() {
        return !this.mIsCircle && this.mIsOval;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public void setSelected(boolean z) {
        if (this.mIsSelected != z) {
            this.mIsSelected = z;
            invalidate();
        }
    }

    public void setTouchSelectModeEnabled(boolean z) {
        this.mIsTouchSelectModeEnabled = z;
    }

    public boolean isTouchSelectModeEnabled() {
        return this.mIsTouchSelectModeEnabled;
    }

    public void setSelectedColorFilter(android.graphics.ColorFilter colorFilter) {
        if (this.mSelectedColorFilter == colorFilter) {
            return;
        }
        this.mSelectedColorFilter = colorFilter;
        if (this.mIsSelected) {
            invalidate();
        }
    }

    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        if (this.mColorFilter == colorFilter) {
            return;
        }
        this.mColorFilter = colorFilter;
        if (this.mIsSelected) {
            return;
        }
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (!this.mIsCircle) {
            super.onMeasure(i, i2);
            return;
        }
        if (mode == 1073741824) {
            setMeasuredDimension(size, size);
            return;
        }
        if (mode2 == 1073741824) {
            setMeasuredDimension(size2, size2);
            return;
        }
        android.graphics.Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            setMeasuredDimension(0, 0);
        } else {
            int iMin = java.lang.Math.min(java.lang.Math.min(bitmap.getWidth(), size), java.lang.Math.min(this.mBitmap.getHeight(), size2));
            setMeasuredDimension(iMin, iMin);
        }
    }

    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        super.setImageDrawable(drawable);
        setupBitmap();
    }

    public void setImageURI(android.net.Uri uri) {
        super.setImageURI(uri);
        setupBitmap();
    }

    private android.graphics.Bitmap getBitmap() {
        android.graphics.Bitmap bitmapCreateBitmap;
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
            android.graphics.Bitmap bitmap = ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
            if (bitmap == null) {
                return null;
            }
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            if (width == 0.0f || height == 0.0f) {
                return null;
            }
            float minimumWidth = getMinimumWidth() / width;
            float minimumHeight = getMinimumHeight() / height;
            if (minimumWidth <= 1.0f && minimumHeight <= 1.0f) {
                return bitmap;
            }
            float fMax = java.lang.Math.max(minimumWidth, minimumHeight);
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.postScale(fMax, fMax);
            return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, false);
        }
        try {
            if (drawable instanceof android.graphics.drawable.ColorDrawable) {
                bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(2, 2, BITMAP_CONFIG);
            } else {
                bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setupBitmap() {
        android.graphics.Bitmap bitmap = getBitmap();
        if (bitmap == this.mBitmap) {
            return;
        }
        this.mBitmap = bitmap;
        if (bitmap == null) {
            this.mBitmapShader = null;
            invalidate();
            return;
        }
        this.mNeedResetShader = true;
        this.mBitmapShader = new android.graphics.BitmapShader(this.mBitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        if (this.mBitmapPaint == null) {
            android.graphics.Paint paint = new android.graphics.Paint();
            this.mBitmapPaint = paint;
            paint.setAntiAlias(true);
        }
        this.mBitmapPaint.setShader(this.mBitmapShader);
        requestLayout();
        invalidate();
    }

    private void updateBitmapShader() {
        android.graphics.Bitmap bitmap;
        this.mMatrix.reset();
        this.mNeedResetShader = false;
        if (this.mBitmapShader == null || (bitmap = this.mBitmap) == null) {
            return;
        }
        updateMatrix(this.mMatrix, bitmap, this.mRectF);
        this.mBitmapShader.setLocalMatrix(this.mMatrix);
        this.mBitmapPaint.setShader(this.mBitmapShader);
    }

    private void updateMatrix(android.graphics.Matrix matrix, android.graphics.Bitmap bitmap, android.graphics.RectF rectF) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        android.widget.ImageView.ScaleType scaleType = getScaleType();
        if (scaleType == android.widget.ImageView.ScaleType.MATRIX) {
            updateScaleTypeMatrix(matrix, bitmap, rectF);
            return;
        }
        if (scaleType == android.widget.ImageView.ScaleType.CENTER) {
            float f = (this.mWidth - width) / 2.0f;
            float f2 = (this.mHeight - height) / 2.0f;
            matrix.postTranslate(f, f2);
            rectF.set(java.lang.Math.max(0.0f, f), java.lang.Math.max(0.0f, f2), java.lang.Math.min(f + width, this.mWidth), java.lang.Math.min(f2 + height, this.mHeight));
            return;
        }
        if (scaleType == android.widget.ImageView.ScaleType.CENTER_CROP) {
            float fMax = java.lang.Math.max(this.mWidth / width, this.mHeight / height);
            matrix.setScale(fMax, fMax);
            matrix.postTranslate((-((width * fMax) - this.mWidth)) / 2.0f, (-((fMax * height) - this.mHeight)) / 2.0f);
            rectF.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            return;
        }
        if (scaleType == android.widget.ImageView.ScaleType.CENTER_INSIDE) {
            int i = this.mWidth;
            float f3 = i / width;
            int i2 = this.mHeight;
            float f4 = i2 / height;
            if (f3 >= 1.0f && f4 >= 1.0f) {
                float f5 = (i - width) / 2.0f;
                float f6 = (i2 - height) / 2.0f;
                matrix.postTranslate(f5, f6);
                rectF.set(f5, f6, width + f5, height + f6);
                return;
            }
            float fMin = java.lang.Math.min(f3, f4);
            matrix.setScale(fMin, fMin);
            float f7 = width * fMin;
            float f8 = height * fMin;
            float f9 = (this.mWidth - f7) / 2.0f;
            float f10 = (this.mHeight - f8) / 2.0f;
            matrix.postTranslate(f9, f10);
            rectF.set(f9, f10, f7 + f9, f8 + f10);
            return;
        }
        if (scaleType == android.widget.ImageView.ScaleType.FIT_XY) {
            matrix.setScale(this.mWidth / width, this.mHeight / height);
            rectF.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            return;
        }
        float fMin2 = java.lang.Math.min(this.mWidth / width, this.mHeight / height);
        matrix.setScale(fMin2, fMin2);
        float f11 = width * fMin2;
        float f12 = height * fMin2;
        if (scaleType == android.widget.ImageView.ScaleType.FIT_START) {
            rectF.set(0.0f, 0.0f, f11, f12);
            return;
        }
        if (scaleType == android.widget.ImageView.ScaleType.FIT_CENTER) {
            float f13 = (this.mWidth - f11) / 2.0f;
            float f14 = (this.mHeight - f12) / 2.0f;
            matrix.postTranslate(f13, f14);
            rectF.set(f13, f14, f11 + f13, f12 + f14);
            return;
        }
        matrix.postTranslate(this.mWidth - f11, this.mHeight - f12);
        int i3 = this.mWidth;
        float f15 = i3 - f11;
        int i4 = this.mHeight;
        rectF.set(f15, i4 - f12, i3, i4);
    }

    protected void updateScaleTypeMatrix(android.graphics.Matrix matrix, android.graphics.Bitmap bitmap, android.graphics.RectF rectF) {
        matrix.set(getImageMatrix());
        rectF.set(0.0f, 0.0f, this.mWidth, this.mHeight);
    }

    private void drawBitmap(android.graphics.Canvas canvas, int i) {
        float f = (i * 1.0f) / 2.0f;
        this.mBitmapPaint.setColorFilter(this.mIsSelected ? this.mSelectedColorFilter : this.mColorFilter);
        if (this.mIsCircle) {
            canvas.drawCircle(this.mRectF.centerX(), this.mRectF.centerY(), java.lang.Math.min(this.mRectF.width() / 2.0f, this.mRectF.height() / 2.0f) - f, this.mBitmapPaint);
            return;
        }
        this.mDrawRectF.left = this.mRectF.left + f;
        this.mDrawRectF.top = this.mRectF.top + f;
        this.mDrawRectF.right = this.mRectF.right - f;
        this.mDrawRectF.bottom = this.mRectF.bottom - f;
        if (this.mIsOval) {
            canvas.drawOval(this.mDrawRectF, this.mBitmapPaint);
            return;
        }
        android.graphics.RectF rectF = this.mDrawRectF;
        int i2 = this.mCornerRadius;
        canvas.drawRoundRect(rectF, i2, i2, this.mBitmapPaint);
    }

    private void drawBorder(android.graphics.Canvas canvas, int i) {
        if (i <= 0) {
            return;
        }
        float f = i;
        float f2 = (1.0f * f) / 2.0f;
        this.mBorderPaint.setColor(this.mIsSelected ? this.mSelectedBorderColor : this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(f);
        if (this.mIsCircle) {
            canvas.drawCircle(this.mRectF.centerX(), this.mRectF.centerY(), (java.lang.Math.min(this.mRectF.width(), this.mRectF.height()) / 2.0f) - f2, this.mBorderPaint);
            return;
        }
        this.mDrawRectF.left = this.mRectF.left + f2;
        this.mDrawRectF.top = this.mRectF.top + f2;
        this.mDrawRectF.right = this.mRectF.right - f2;
        this.mDrawRectF.bottom = this.mRectF.bottom - f2;
        if (this.mIsOval) {
            canvas.drawOval(this.mDrawRectF, this.mBorderPaint);
            return;
        }
        android.graphics.RectF rectF = this.mDrawRectF;
        int i2 = this.mCornerRadius;
        canvas.drawRoundRect(rectF, i2, i2, this.mBorderPaint);
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        int i = this.mIsSelected ? this.mSelectedBorderWidth : this.mBorderWidth;
        if (this.mBitmap == null || this.mBitmapShader == null) {
            drawBorder(canvas, i);
            return;
        }
        if (this.mWidth != width || this.mHeight != height || this.mLastCalculateScaleType != getScaleType() || this.mNeedResetShader) {
            this.mWidth = width;
            this.mHeight = height;
            this.mLastCalculateScaleType = getScaleType();
            updateBitmapShader();
        }
        drawBitmap(canvas, i);
        drawBorder(canvas, i);
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!isClickable()) {
            setSelected(false);
            return super.onTouchEvent(motionEvent);
        }
        if (!this.mIsTouchSelectModeEnabled) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setSelected(true);
        } else if (action == 1 || action == 3 || action == 4 || action == 8) {
            setSelected(false);
        }
        return super.onTouchEvent(motionEvent);
    }
}
