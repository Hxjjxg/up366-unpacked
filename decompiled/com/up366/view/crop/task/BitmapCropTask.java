package com.up366.view.crop.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class BitmapCropTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Throwable> {
    private static final java.lang.String TAG = "BitmapCropTask";
    private int cropOffsetX;
    private int cropOffsetY;
    private final android.graphics.Bitmap.CompressFormat mCompressFormat;
    private final int mCompressQuality;
    private final java.lang.ref.WeakReference<android.content.Context> mContext;
    private final com.up366.view.crop.callback.BitmapCropCallback mCropCallback;
    private final android.graphics.RectF mCropRect;
    private int mCroppedImageHeight;
    private int mCroppedImageWidth;
    private float mCurrentAngle;
    private final android.graphics.RectF mCurrentImageRect;
    private float mCurrentScale;
    private final com.up366.view.crop.model.ExifInfo mExifInfo;
    private final java.lang.String mImageInputPath;
    private final java.lang.String mImageOutputPath;
    private final int mMaxResultImageSizeX;
    private final int mMaxResultImageSizeY;
    private android.graphics.Bitmap mViewBitmap;

    public BitmapCropTask(android.content.Context context, android.graphics.Bitmap bitmap, com.up366.view.crop.model.ImageState imageState, com.up366.view.crop.model.CropParameters cropParameters, com.up366.view.crop.callback.BitmapCropCallback bitmapCropCallback) {
        this.mContext = new java.lang.ref.WeakReference<>(context);
        this.mViewBitmap = bitmap;
        this.mCropRect = imageState.getCropRect();
        this.mCurrentImageRect = imageState.getCurrentImageRect();
        this.mCurrentScale = imageState.getCurrentScale();
        this.mCurrentAngle = imageState.getCurrentAngle();
        this.mMaxResultImageSizeX = cropParameters.getMaxResultImageSizeX();
        this.mMaxResultImageSizeY = cropParameters.getMaxResultImageSizeY();
        this.mCompressFormat = cropParameters.getCompressFormat();
        this.mCompressQuality = cropParameters.getCompressQuality();
        this.mImageInputPath = cropParameters.getImageInputPath();
        this.mImageOutputPath = cropParameters.getImageOutputPath();
        this.mExifInfo = cropParameters.getExifInfo();
        this.mCropCallback = bitmapCropCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public java.lang.Throwable doInBackground(java.lang.Void... voidArr) {
        android.graphics.Bitmap bitmap = this.mViewBitmap;
        if (bitmap == null) {
            return new java.lang.NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new java.lang.NullPointerException("ViewBitmap is recycled");
        }
        if (this.mCurrentImageRect.isEmpty()) {
            return new java.lang.NullPointerException("CurrentImageRect is empty");
        }
        try {
            crop();
            this.mViewBitmap = null;
            return null;
        } catch (java.lang.Throwable th) {
            return th;
        }
    }

    private boolean crop() throws java.lang.Throwable {
        if (this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0) {
            float fWidth = this.mCropRect.width() / this.mCurrentScale;
            float fHeight = this.mCropRect.height() / this.mCurrentScale;
            int i = this.mMaxResultImageSizeX;
            if (fWidth > i || fHeight > this.mMaxResultImageSizeY) {
                float fMin = java.lang.Math.min(i / fWidth, this.mMaxResultImageSizeY / fHeight);
                android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(this.mViewBitmap, java.lang.Math.round(r2.getWidth() * fMin), java.lang.Math.round(this.mViewBitmap.getHeight() * fMin), false);
                android.graphics.Bitmap bitmap = this.mViewBitmap;
                if (bitmap != bitmapCreateScaledBitmap) {
                    bitmap.recycle();
                }
                this.mViewBitmap = bitmapCreateScaledBitmap;
                this.mCurrentScale /= fMin;
            }
        }
        if (this.mCurrentAngle != 0.0f) {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.setRotate(this.mCurrentAngle, this.mViewBitmap.getWidth() / 2, this.mViewBitmap.getHeight() / 2);
            android.graphics.Bitmap bitmap2 = this.mViewBitmap;
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.mViewBitmap.getHeight(), matrix, true);
            android.graphics.Bitmap bitmap3 = this.mViewBitmap;
            if (bitmap3 != bitmapCreateBitmap) {
                bitmap3.recycle();
            }
            this.mViewBitmap = bitmapCreateBitmap;
        }
        this.cropOffsetX = java.lang.Math.round((this.mCropRect.left - this.mCurrentImageRect.left) / this.mCurrentScale);
        this.cropOffsetY = java.lang.Math.round((this.mCropRect.top - this.mCurrentImageRect.top) / this.mCurrentScale);
        this.mCroppedImageWidth = java.lang.Math.round(this.mCropRect.width() / this.mCurrentScale);
        int iRound = java.lang.Math.round(this.mCropRect.height() / this.mCurrentScale);
        this.mCroppedImageHeight = iRound;
        boolean zShouldCrop = shouldCrop(this.mCroppedImageWidth, iRound);
        android.util.Log.i(TAG, "Should crop: " + zShouldCrop);
        if (zShouldCrop) {
            android.media.ExifInterface exifInterface = new android.media.ExifInterface(this.mImageInputPath);
            saveImage(android.graphics.Bitmap.createBitmap(this.mViewBitmap, this.cropOffsetX, this.cropOffsetY, this.mCroppedImageWidth, this.mCroppedImageHeight));
            if (!this.mCompressFormat.equals(android.graphics.Bitmap.CompressFormat.JPEG)) {
                return true;
            }
            com.up366.view.crop.util.ImageHeaderParser.copyExif(exifInterface, this.mCroppedImageWidth, this.mCroppedImageHeight, this.mImageOutputPath);
            return true;
        }
        com.up366.view.crop.util.FileUtils.copyFile(this.mImageInputPath, this.mImageOutputPath);
        return false;
    }

    private void saveImage(android.graphics.Bitmap bitmap) throws java.io.FileNotFoundException {
        android.content.Context context = this.mContext.get();
        if (context == null) {
            return;
        }
        java.io.File file = new java.io.File(this.mImageOutputPath);
        if (file.exists()) {
            file.delete();
        }
        java.io.OutputStream outputStreamOpenOutputStream = null;
        try {
            outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(android.net.Uri.fromFile(file));
            bitmap.compress(this.mCompressFormat, this.mCompressQuality, outputStreamOpenOutputStream);
            bitmap.recycle();
        } finally {
            com.up366.view.crop.util.BitmapLoadUtils.close(outputStreamOpenOutputStream);
        }
    }

    private boolean shouldCrop(int i, int i2) {
        int iRound = java.lang.Math.round(java.lang.Math.max(i, i2) / 1000.0f) + 1;
        if (this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0) {
            return true;
        }
        float f = iRound;
        return java.lang.Math.abs(this.mCropRect.left - this.mCurrentImageRect.left) > f || java.lang.Math.abs(this.mCropRect.top - this.mCurrentImageRect.top) > f || java.lang.Math.abs(this.mCropRect.bottom - this.mCurrentImageRect.bottom) > f || java.lang.Math.abs(this.mCropRect.right - this.mCurrentImageRect.right) > f || this.mCurrentAngle != 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(java.lang.Throwable th) {
        com.up366.view.crop.callback.BitmapCropCallback bitmapCropCallback = this.mCropCallback;
        if (bitmapCropCallback != null) {
            if (th == null) {
                this.mCropCallback.onBitmapCropped(android.net.Uri.fromFile(new java.io.File(this.mImageOutputPath)), this.cropOffsetX, this.cropOffsetY, this.mCroppedImageWidth, this.mCroppedImageHeight);
            } else {
                bitmapCropCallback.onCropFailure(th);
            }
        }
    }
}
