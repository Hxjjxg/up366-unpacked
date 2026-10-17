package com.up366.medialibrary.third.ucrop.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FastBitmapDrawable extends android.graphics.drawable.Drawable {
    private android.graphics.Bitmap mBitmap;
    private int mHeight;
    private int mWidth;
    private final android.graphics.Paint mPaint = new android.graphics.Paint(2);
    private int mAlpha = 255;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public FastBitmapDrawable(android.graphics.Bitmap bitmap) {
        setBitmap(bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.mBitmap, (android.graphics.Rect) null, getBounds(), this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mAlpha = i;
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.mHeight;
    }

    public android.graphics.Bitmap getBitmap() {
        return this.mBitmap;
    }

    public void setBitmap(android.graphics.Bitmap bitmap) {
        this.mBitmap = bitmap;
        if (bitmap != null) {
            this.mWidth = bitmap.getWidth();
            this.mHeight = this.mBitmap.getHeight();
        } else {
            this.mHeight = 0;
            this.mWidth = 0;
        }
    }
}
