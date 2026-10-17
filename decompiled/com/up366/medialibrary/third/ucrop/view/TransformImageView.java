package com.up366.medialibrary.third.ucrop.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TransformImageView extends androidx.appcompat.widget.AppCompatImageView {
    private static final int MATRIX_VALUES_COUNT = 9;
    private static final int RECT_CENTER_POINT_COORDS = 2;
    private static final int RECT_CORNER_POINTS_COORDS = 8;
    private static final java.lang.String TAG = "TransformImageView";
    protected boolean mBitmapDecoded;
    protected boolean mBitmapLaidOut;
    protected final float[] mCurrentImageCenter;
    protected final float[] mCurrentImageCorners;
    protected android.graphics.Matrix mCurrentImageMatrix;
    private com.up366.medialibrary.third.ucrop.model.ExifInfo mExifInfo;
    private java.lang.String mImageInputPath;
    private java.lang.String mImageOutputPath;
    private float[] mInitialImageCenter;
    private float[] mInitialImageCorners;
    private final float[] mMatrixValues;
    private int mMaxBitmapSize;
    protected int mThisHeight;
    protected int mThisWidth;
    protected com.up366.medialibrary.third.ucrop.view.TransformImageView.TransformImageListener mTransformImageListener;

    public interface TransformImageListener {
        void onLoadComplete();

        void onLoadFailure(java.lang.Exception exc);

        void onRotate(float f);

        void onScale(float f);
    }

    public TransformImageView(android.content.Context context) {
        this(context, null);
    }

    public TransformImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentImageCorners = new float[8];
        this.mCurrentImageCenter = new float[2];
        this.mMatrixValues = new float[9];
        this.mCurrentImageMatrix = new android.graphics.Matrix();
        this.mBitmapDecoded = false;
        this.mBitmapLaidOut = false;
        this.mMaxBitmapSize = 0;
        init();
    }

    public void setTransformImageListener(com.up366.medialibrary.third.ucrop.view.TransformImageView.TransformImageListener transformImageListener) {
        this.mTransformImageListener = transformImageListener;
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaleType) {
        if (scaleType == android.widget.ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            android.util.Log.w(TAG, "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setMaxBitmapSize(int i) {
        this.mMaxBitmapSize = i;
    }

    public int getMaxBitmapSize() {
        if (this.mMaxBitmapSize <= 0) {
            this.mMaxBitmapSize = com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.calculateMaxBitmapSize(getContext());
        }
        return this.mMaxBitmapSize;
    }

    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        setImageDrawable(new com.up366.medialibrary.third.ucrop.util.FastBitmapDrawable(bitmap));
    }

    public java.lang.String getImageInputPath() {
        return this.mImageInputPath;
    }

    public java.lang.String getImageOutputPath() {
        return this.mImageOutputPath;
    }

    public com.up366.medialibrary.third.ucrop.model.ExifInfo getExifInfo() {
        return this.mExifInfo;
    }

    public void setImageUri(android.net.Uri uri, android.net.Uri uri2, int i, int i2) throws java.lang.Exception {
        int maxBitmapSize = getMaxBitmapSize();
        com.up366.medialibrary.third.ucrop.util.BitmapLoadUtils.decodeBitmapInBackground(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, i, i2, new com.up366.medialibrary.third.ucrop.callback.BitmapLoadCallback() { // from class: com.up366.medialibrary.third.ucrop.view.TransformImageView.1
            @Override // com.up366.medialibrary.third.ucrop.callback.BitmapLoadCallback
            public void onBitmapLoaded(android.graphics.Bitmap bitmap, com.up366.medialibrary.third.ucrop.model.ExifInfo exifInfo, java.lang.String str, java.lang.String str2) {
                com.up366.medialibrary.third.ucrop.view.TransformImageView.this.mImageInputPath = str;
                com.up366.medialibrary.third.ucrop.view.TransformImageView.this.mImageOutputPath = str2;
                com.up366.medialibrary.third.ucrop.view.TransformImageView.this.mExifInfo = exifInfo;
                com.up366.medialibrary.third.ucrop.view.TransformImageView.this.mBitmapDecoded = true;
                com.up366.medialibrary.third.ucrop.view.TransformImageView.this.setImageBitmap(bitmap);
            }

            @Override // com.up366.medialibrary.third.ucrop.callback.BitmapLoadCallback
            public void onFailure(java.lang.Exception exc) {
                android.util.Log.e(com.up366.medialibrary.third.ucrop.view.TransformImageView.TAG, "onFailure: setImageUri", exc);
                if (com.up366.medialibrary.third.ucrop.view.TransformImageView.this.mTransformImageListener != null) {
                    com.up366.medialibrary.third.ucrop.view.TransformImageView.this.mTransformImageListener.onLoadFailure(exc);
                }
            }
        });
    }

    public float getCurrentScale() {
        return getMatrixScale(this.mCurrentImageMatrix);
    }

    public float getMatrixScale(android.graphics.Matrix matrix) {
        return (float) java.lang.Math.sqrt(java.lang.Math.pow(getMatrixValue(matrix, 0), 2.0d) + java.lang.Math.pow(getMatrixValue(matrix, 3), 2.0d));
    }

    public float getCurrentAngle() {
        return getMatrixAngle(this.mCurrentImageMatrix);
    }

    public float getMatrixAngle(android.graphics.Matrix matrix) {
        return (float) (-(java.lang.Math.atan2(getMatrixValue(matrix, 1), getMatrixValue(matrix, 0)) * 57.29577951308232d));
    }

    public void setImageMatrix(android.graphics.Matrix matrix) {
        super.setImageMatrix(matrix);
        this.mCurrentImageMatrix.set(matrix);
        updateCurrentImagePoints();
    }

    public android.graphics.Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof com.up366.medialibrary.third.ucrop.util.FastBitmapDrawable)) {
            return null;
        }
        return ((com.up366.medialibrary.third.ucrop.util.FastBitmapDrawable) getDrawable()).getBitmap();
    }

    public void postTranslate(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.mCurrentImageMatrix.postTranslate(f, f2);
        setImageMatrix(this.mCurrentImageMatrix);
    }

    public void postScale(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.mCurrentImageMatrix.postScale(f, f, f2, f3);
            setImageMatrix(this.mCurrentImageMatrix);
            com.up366.medialibrary.third.ucrop.view.TransformImageView.TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                transformImageListener.onScale(getMatrixScale(this.mCurrentImageMatrix));
            }
        }
    }

    public void postRotate(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.mCurrentImageMatrix.postRotate(f, f2, f3);
            setImageMatrix(this.mCurrentImageMatrix);
            com.up366.medialibrary.third.ucrop.view.TransformImageView.TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                transformImageListener.onRotate(getMatrixAngle(this.mCurrentImageMatrix));
            }
        }
    }

    protected void init() {
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || (this.mBitmapDecoded && !this.mBitmapLaidOut)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.mThisWidth = width - paddingLeft;
            this.mThisHeight = height - paddingTop;
            onImageLaidOut();
        }
    }

    protected void onImageLaidOut() {
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        android.util.Log.d(TAG, java.lang.String.format("Image size: [%d:%d]", java.lang.Integer.valueOf((int) intrinsicWidth), java.lang.Integer.valueOf((int) intrinsicHeight)));
        android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        this.mInitialImageCorners = com.up366.medialibrary.third.ucrop.util.RectUtils.getCornersFromRect(rectF);
        this.mInitialImageCenter = com.up366.medialibrary.third.ucrop.util.RectUtils.getCenterFromRect(rectF);
        this.mBitmapLaidOut = true;
        com.up366.medialibrary.third.ucrop.view.TransformImageView.TransformImageListener transformImageListener = this.mTransformImageListener;
        if (transformImageListener != null) {
            transformImageListener.onLoadComplete();
        }
    }

    protected float getMatrixValue(android.graphics.Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    protected void printMatrix(java.lang.String str, android.graphics.Matrix matrix) {
        android.util.Log.d(TAG, str + ": matrix: { x: " + getMatrixValue(matrix, 2) + ", y: " + getMatrixValue(matrix, 5) + ", scale: " + getMatrixScale(matrix) + ", angle: " + getMatrixAngle(matrix) + " }");
    }

    private void updateCurrentImagePoints() {
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCorners, this.mInitialImageCorners);
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCenter, this.mInitialImageCenter);
    }
}
