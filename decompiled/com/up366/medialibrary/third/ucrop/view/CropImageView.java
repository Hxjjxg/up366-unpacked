package com.up366.medialibrary.third.ucrop.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CropImageView extends com.up366.medialibrary.third.ucrop.view.TransformImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;
    public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
    public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
    public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0f;
    public static final float SOURCE_IMAGE_ASPECT_RATIO = 0.0f;
    private com.up366.medialibrary.third.ucrop.callback.CropBoundsChangeListener mCropBoundsChangeListener;
    private final android.graphics.RectF mCropRect;
    private long mImageToWrapCropBoundsAnimDuration;
    private int mMaxResultImageSizeX;
    private int mMaxResultImageSizeY;
    private float mMaxScale;
    private float mMaxScaleMultiplier;
    private float mMinScale;
    private float mTargetAspectRatio;
    private final android.graphics.Matrix mTempMatrix;
    private java.lang.Runnable mWrapCropBoundsRunnable;
    private java.lang.Runnable mZoomImageToPositionRunnable;

    public CropImageView(android.content.Context context) {
        this(context, null);
    }

    public CropImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCropRect = new android.graphics.RectF();
        this.mTempMatrix = new android.graphics.Matrix();
        this.mMaxScaleMultiplier = 10.0f;
        this.mZoomImageToPositionRunnable = null;
        this.mMaxResultImageSizeX = 0;
        this.mMaxResultImageSizeY = 0;
        this.mImageToWrapCropBoundsAnimDuration = 500L;
    }

    public void cropAndSaveImage(android.graphics.Bitmap.CompressFormat compressFormat, int i, com.up366.medialibrary.third.ucrop.callback.BitmapCropCallback bitmapCropCallback) {
        cancelAllAnimations();
        setImageToWrapCropBounds(false);
        new com.up366.medialibrary.third.ucrop.task.BitmapCropTask(getContext(), getViewBitmap(), new com.up366.medialibrary.third.ucrop.model.ImageState(this.mCropRect, com.up366.medialibrary.third.ucrop.util.RectUtils.trapToRect(this.mCurrentImageCorners), getCurrentScale(), getCurrentAngle()), new com.up366.medialibrary.third.ucrop.model.CropParameters(this.mMaxResultImageSizeX, this.mMaxResultImageSizeY, compressFormat, i, getImageInputPath(), getImageOutputPath(), getExifInfo()), bitmapCropCallback).executeOnExecutor(java.util.concurrent.Executors.newCachedThreadPool(), new java.lang.Void[0]);
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public float getTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    public void setCropRect(android.graphics.RectF rectF) {
        this.mTargetAspectRatio = rectF.width() / rectF.height();
        this.mCropRect.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        calculateImageScaleBounds();
        setImageToWrapCropBounds();
    }

    public void setTargetAspectRatio(float f) {
        if (getDrawable() == null) {
            this.mTargetAspectRatio = f;
            return;
        }
        if (f == 0.0f) {
            this.mTargetAspectRatio = r0.getIntrinsicWidth() / r0.getIntrinsicHeight();
        } else {
            this.mTargetAspectRatio = f;
        }
        com.up366.medialibrary.third.ucrop.callback.CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
    }

    public com.up366.medialibrary.third.ucrop.callback.CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.mCropBoundsChangeListener;
    }

    public void setCropBoundsChangeListener(com.up366.medialibrary.third.ucrop.callback.CropBoundsChangeListener cropBoundsChangeListener) {
        this.mCropBoundsChangeListener = cropBoundsChangeListener;
    }

    public void setMaxResultImageSizeX(int i) {
        this.mMaxResultImageSizeX = i;
    }

    public void setMaxResultImageSizeY(int i) {
        this.mMaxResultImageSizeY = i;
    }

    public void setImageToWrapCropBoundsAnimDuration(long j) {
        if (j > 0) {
            this.mImageToWrapCropBoundsAnimDuration = j;
            return;
        }
        throw new java.lang.IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxScaleMultiplier(float f) {
        this.mMaxScaleMultiplier = f;
    }

    public void zoomOutImage(float f) {
        zoomOutImage(f, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomOutImage(float f, float f2, float f3) {
        if (f >= getMinScale()) {
            postScale(f / getCurrentScale(), f2, f3);
        }
    }

    public void zoomInImage(float f) {
        zoomInImage(f, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomInImage(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            postScale(f / getCurrentScale(), f2, f3);
        }
    }

    @Override // com.up366.medialibrary.third.ucrop.view.TransformImageView
    public void postScale(float f, float f2, float f3) {
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            super.postScale(f, f2, f3);
        } else {
            if (f >= 1.0f || getCurrentScale() * f < getMinScale()) {
                return;
            }
            super.postScale(f, f2, f3);
        }
    }

    public void postRotate(float f) {
        postRotate(f, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void cancelAllAnimations() {
        removeCallbacks(this.mWrapCropBoundsRunnable);
        removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    public void setImageToWrapCropBounds() {
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean z) {
        float f;
        float fMax;
        float f2;
        if (!this.mBitmapLaidOut || isImageWrapCropBounds()) {
            return;
        }
        float f3 = this.mCurrentImageCenter[0];
        float f4 = this.mCurrentImageCenter[1];
        float currentScale = getCurrentScale();
        float fCenterX = this.mCropRect.centerX() - f3;
        float fCenterY = this.mCropRect.centerY() - f4;
        this.mTempMatrix.reset();
        this.mTempMatrix.setTranslate(fCenterX, fCenterY);
        float[] fArrCopyOf = java.util.Arrays.copyOf(this.mCurrentImageCorners, this.mCurrentImageCorners.length);
        this.mTempMatrix.mapPoints(fArrCopyOf);
        boolean zIsImageWrapCropBounds = isImageWrapCropBounds(fArrCopyOf);
        if (zIsImageWrapCropBounds) {
            float[] fArrCalculateImageIndents = calculateImageIndents();
            float f5 = -(fArrCalculateImageIndents[0] + fArrCalculateImageIndents[2]);
            f2 = -(fArrCalculateImageIndents[1] + fArrCalculateImageIndents[3]);
            f = f5;
            fMax = 0.0f;
        } else {
            android.graphics.RectF rectF = new android.graphics.RectF(this.mCropRect);
            this.mTempMatrix.reset();
            this.mTempMatrix.setRotate(getCurrentAngle());
            this.mTempMatrix.mapRect(rectF);
            float[] rectSidesFromCorners = com.up366.medialibrary.third.ucrop.util.RectUtils.getRectSidesFromCorners(this.mCurrentImageCorners);
            f = fCenterX;
            fMax = (java.lang.Math.max(rectF.width() / rectSidesFromCorners[0], rectF.height() / rectSidesFromCorners[1]) * currentScale) - currentScale;
            f2 = fCenterY;
        }
        if (z) {
            com.up366.medialibrary.third.ucrop.view.CropImageView.WrapCropBoundsRunnable wrapCropBoundsRunnable = new com.up366.medialibrary.third.ucrop.view.CropImageView.WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f3, f4, f, f2, currentScale, fMax, zIsImageWrapCropBounds);
            this.mWrapCropBoundsRunnable = wrapCropBoundsRunnable;
            post(wrapCropBoundsRunnable);
        } else {
            postTranslate(f, f2);
            if (zIsImageWrapCropBounds) {
                return;
            }
            zoomInImage(currentScale + fMax, this.mCropRect.centerX(), this.mCropRect.centerY());
        }
    }

    private float[] calculateImageIndents() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] fArrCopyOf = java.util.Arrays.copyOf(this.mCurrentImageCorners, this.mCurrentImageCorners.length);
        float[] cornersFromRect = com.up366.medialibrary.third.ucrop.util.RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(fArrCopyOf);
        this.mTempMatrix.mapPoints(cornersFromRect);
        android.graphics.RectF rectFTrapToRect = com.up366.medialibrary.third.ucrop.util.RectUtils.trapToRect(fArrCopyOf);
        android.graphics.RectF rectFTrapToRect2 = com.up366.medialibrary.third.ucrop.util.RectUtils.trapToRect(cornersFromRect);
        float f = rectFTrapToRect.left - rectFTrapToRect2.left;
        float f2 = rectFTrapToRect.top - rectFTrapToRect2.top;
        float f3 = rectFTrapToRect.right - rectFTrapToRect2.right;
        float f4 = rectFTrapToRect.bottom - rectFTrapToRect2.bottom;
        if (f <= 0.0f) {
            f = 0.0f;
        }
        if (f2 <= 0.0f) {
            f2 = 0.0f;
        }
        if (f3 >= 0.0f) {
            f3 = 0.0f;
        }
        if (f4 >= 0.0f) {
            f4 = 0.0f;
        }
        float[] fArr = {f, f2, f3, f4};
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(getCurrentAngle());
        this.mTempMatrix.mapPoints(fArr);
        return fArr;
    }

    @Override // com.up366.medialibrary.third.ucrop.view.TransformImageView
    protected void onImageLaidOut() {
        super.onImageLaidOut();
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.mTargetAspectRatio == 0.0f) {
            this.mTargetAspectRatio = intrinsicWidth / intrinsicHeight;
        }
        int i = (int) (this.mThisWidth / this.mTargetAspectRatio);
        if (i > this.mThisHeight) {
            this.mCropRect.set((this.mThisWidth - ((int) (this.mThisHeight * this.mTargetAspectRatio))) / 2, 0.0f, r2 + r4, this.mThisHeight);
        } else {
            this.mCropRect.set(0.0f, (this.mThisHeight - i) / 2, this.mThisWidth, i + r4);
        }
        calculateImageScaleBounds(intrinsicWidth, intrinsicHeight);
        setupInitialImagePosition(intrinsicWidth, intrinsicHeight);
        com.up366.medialibrary.third.ucrop.callback.CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
        if (this.mTransformImageListener != null) {
            this.mTransformImageListener.onScale(getCurrentScale());
            this.mTransformImageListener.onRotate(getCurrentAngle());
        }
    }

    protected boolean isImageWrapCropBounds() {
        return isImageWrapCropBounds(this.mCurrentImageCorners);
    }

    protected boolean isImageWrapCropBounds(float[] fArr) {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] fArrCopyOf = java.util.Arrays.copyOf(fArr, fArr.length);
        this.mTempMatrix.mapPoints(fArrCopyOf);
        float[] cornersFromRect = com.up366.medialibrary.third.ucrop.util.RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(cornersFromRect);
        return com.up366.medialibrary.third.ucrop.util.RectUtils.trapToRect(fArrCopyOf).contains(com.up366.medialibrary.third.ucrop.util.RectUtils.trapToRect(cornersFromRect));
    }

    protected void zoomImageToPosition(float f, float f2, float f3, long j) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        float currentScale = getCurrentScale();
        com.up366.medialibrary.third.ucrop.view.CropImageView.ZoomImageToPosition zoomImageToPosition = new com.up366.medialibrary.third.ucrop.view.CropImageView.ZoomImageToPosition(this, j, currentScale, f - currentScale, f2, f3);
        this.mZoomImageToPositionRunnable = zoomImageToPosition;
        post(zoomImageToPosition);
    }

    private void calculateImageScaleBounds() {
        if (getDrawable() == null) {
            return;
        }
        calculateImageScaleBounds(r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
    }

    private void calculateImageScaleBounds(float f, float f2) {
        float fMin = java.lang.Math.min(java.lang.Math.min(this.mCropRect.width() / f, this.mCropRect.width() / f2), java.lang.Math.min(this.mCropRect.height() / f2, this.mCropRect.height() / f));
        this.mMinScale = fMin;
        this.mMaxScale = fMin * this.mMaxScaleMultiplier;
    }

    private void setupInitialImagePosition(float f, float f2) {
        float fWidth = this.mCropRect.width();
        float fHeight = this.mCropRect.height();
        float fMax = java.lang.Math.max(this.mCropRect.width() / f, this.mCropRect.height() / f2);
        float f3 = ((fWidth - (f * fMax)) / 2.0f) + this.mCropRect.left;
        float f4 = ((fHeight - (f2 * fMax)) / 2.0f) + this.mCropRect.top;
        this.mCurrentImageMatrix.reset();
        this.mCurrentImageMatrix.postScale(fMax, fMax);
        this.mCurrentImageMatrix.postTranslate(f3, f4);
        setImageMatrix(this.mCurrentImageMatrix);
    }

    protected void processStyledAttributes(android.content.res.TypedArray typedArray) {
        float fAbs = java.lang.Math.abs(typedArray.getFloat(com.up366.medialibrary.R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float fAbs2 = java.lang.Math.abs(typedArray.getFloat(com.up366.medialibrary.R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (fAbs == 0.0f || fAbs2 == 0.0f) {
            this.mTargetAspectRatio = 0.0f;
        } else {
            this.mTargetAspectRatio = fAbs / fAbs2;
        }
    }

    private static class WrapCropBoundsRunnable implements java.lang.Runnable {
        private final float mCenterDiffX;
        private final float mCenterDiffY;
        private final java.lang.ref.WeakReference<com.up366.medialibrary.third.ucrop.view.CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final long mDurationMs;
        private final float mOldScale;
        private final float mOldX;
        private final float mOldY;
        private final long mStartTime = java.lang.System.currentTimeMillis();
        private final boolean mWillBeImageInBoundsAfterTranslate;

        public WrapCropBoundsRunnable(com.up366.medialibrary.third.ucrop.view.CropImageView cropImageView, long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.mCropImageView = new java.lang.ref.WeakReference<>(cropImageView);
            this.mDurationMs = j;
            this.mOldX = f;
            this.mOldY = f2;
            this.mCenterDiffX = f3;
            this.mCenterDiffY = f4;
            this.mOldScale = f5;
            this.mDeltaScale = f6;
            this.mWillBeImageInBoundsAfterTranslate = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.up366.medialibrary.third.ucrop.view.CropImageView cropImageView = this.mCropImageView.get();
            if (cropImageView == null) {
                return;
            }
            float fMin = java.lang.Math.min(this.mDurationMs, java.lang.System.currentTimeMillis() - this.mStartTime);
            float fEaseOut = com.up366.medialibrary.third.ucrop.util.CubicEasing.easeOut(fMin, 0.0f, this.mCenterDiffX, this.mDurationMs);
            float fEaseOut2 = com.up366.medialibrary.third.ucrop.util.CubicEasing.easeOut(fMin, 0.0f, this.mCenterDiffY, this.mDurationMs);
            float fEaseInOut = com.up366.medialibrary.third.ucrop.util.CubicEasing.easeInOut(fMin, 0.0f, this.mDeltaScale, this.mDurationMs);
            if (fMin < this.mDurationMs) {
                cropImageView.postTranslate(fEaseOut - (cropImageView.mCurrentImageCenter[0] - this.mOldX), fEaseOut2 - (cropImageView.mCurrentImageCenter[1] - this.mOldY));
                if (!this.mWillBeImageInBoundsAfterTranslate) {
                    cropImageView.zoomInImage(this.mOldScale + fEaseInOut, cropImageView.mCropRect.centerX(), cropImageView.mCropRect.centerY());
                }
                if (cropImageView.isImageWrapCropBounds()) {
                    return;
                }
                cropImageView.post(this);
            }
        }
    }

    private static class ZoomImageToPosition implements java.lang.Runnable {
        private final java.lang.ref.WeakReference<com.up366.medialibrary.third.ucrop.view.CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final float mDestX;
        private final float mDestY;
        private final long mDurationMs;
        private final float mOldScale;
        private final long mStartTime = java.lang.System.currentTimeMillis();

        public ZoomImageToPosition(com.up366.medialibrary.third.ucrop.view.CropImageView cropImageView, long j, float f, float f2, float f3, float f4) {
            this.mCropImageView = new java.lang.ref.WeakReference<>(cropImageView);
            this.mDurationMs = j;
            this.mOldScale = f;
            this.mDeltaScale = f2;
            this.mDestX = f3;
            this.mDestY = f4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.up366.medialibrary.third.ucrop.view.CropImageView cropImageView = this.mCropImageView.get();
            if (cropImageView == null) {
                return;
            }
            float fMin = java.lang.Math.min(this.mDurationMs, java.lang.System.currentTimeMillis() - this.mStartTime);
            float fEaseInOut = com.up366.medialibrary.third.ucrop.util.CubicEasing.easeInOut(fMin, 0.0f, this.mDeltaScale, this.mDurationMs);
            if (fMin < this.mDurationMs) {
                cropImageView.zoomInImage(this.mOldScale + fEaseInOut, this.mDestX, this.mDestY);
                cropImageView.post(this);
            } else {
                cropImageView.setImageToWrapCropBounds();
            }
        }
    }
}
