package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CircleImageView extends androidx.appcompat.widget.AppCompatImageView {
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private android.graphics.Bitmap mBitmap;
    private int mBitmapHeight;
    private final android.graphics.Paint mBitmapPaint;
    private android.graphics.BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private int mBorderColor;
    private final android.graphics.Paint mBorderPaint;
    private float mBorderRadius;
    private final android.graphics.RectF mBorderRect;
    private int mBorderWidth;
    private float mDrawableRadius;
    private final android.graphics.RectF mDrawableRect;
    private boolean mReady;
    private boolean mSetupPending;
    private final android.graphics.Matrix mShaderMatrix;
    private static final android.widget.ImageView.ScaleType SCALE_TYPE = android.widget.ImageView.ScaleType.CENTER_CROP;
    private static final android.graphics.Bitmap.Config BITMAP_CONFIG = android.graphics.Bitmap.Config.ARGB_8888;

    public void setScaleType(android.widget.ImageView.ScaleType scaleType) {
    }

    public CircleImageView(android.content.Context context) {
        super(context);
        this.mDrawableRect = new android.graphics.RectF();
        this.mBorderRect = new android.graphics.RectF();
        this.mShaderMatrix = new android.graphics.Matrix();
        this.mBitmapPaint = new android.graphics.Paint();
        this.mBorderPaint = new android.graphics.Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        init();
    }

    public CircleImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawableRect = new android.graphics.RectF();
        this.mBorderRect = new android.graphics.RectF();
        this.mShaderMatrix = new android.graphics.Matrix();
        this.mBitmapPaint = new android.graphics.Paint();
        this.mBorderPaint = new android.graphics.Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.CircleImageView, i, 0);
        this.mBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.mBorderColor = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        typedArrayObtainStyledAttributes.recycle();
        init();
    }

    private void init() {
        super.setScaleType(SCALE_TYPE);
        this.mReady = true;
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }

    public android.widget.ImageView.ScaleType getScaleType() {
        return SCALE_TYPE;
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new java.lang.IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mDrawableRadius, this.mBitmapPaint);
        if (this.mBorderWidth != 0) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mBorderRadius, this.mBorderPaint);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        if (i == this.mBorderColor) {
            return;
        }
        this.mBorderColor = i;
        this.mBorderPaint.setColor(i);
        invalidate();
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setBorderWidth(int i) {
        if (i == this.mBorderWidth) {
            return;
        }
        this.mBorderWidth = i;
        setup();
    }

    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
    }

    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        super.setImageDrawable(drawable);
        this.mBitmap = getBitmapFromDrawable(drawable);
        setup();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.mBitmap = getBitmapFromDrawable(getDrawable());
        setup();
    }

    public void setImageURI(android.net.Uri uri) {
        super.setImageURI(uri);
        this.mBitmap = getBitmapFromDrawable(getDrawable());
        setup();
    }

    private android.graphics.Bitmap getBitmapFromDrawable(android.graphics.drawable.Drawable drawable) {
        android.graphics.Bitmap bitmapCreateBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
            return ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof android.graphics.drawable.ColorDrawable) {
                bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(2, 2, BITMAP_CONFIG);
            } else {
                int intrinsicHeight = 80;
                int intrinsicWidth = drawable.getIntrinsicWidth() == 0 ? 80 : drawable.getIntrinsicWidth();
                if (drawable.getIntrinsicHeight() != 0) {
                    intrinsicHeight = drawable.getIntrinsicHeight();
                }
                bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, BITMAP_CONFIG);
            }
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (java.lang.OutOfMemoryError unused) {
            return null;
        }
    }

    private void setup() {
        if (!this.mReady) {
            this.mSetupPending = true;
            return;
        }
        if (this.mBitmap == null) {
            return;
        }
        this.mBitmapShader = new android.graphics.BitmapShader(this.mBitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setShader(this.mBitmapShader);
        this.mBorderPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.mBitmapHeight = this.mBitmap.getHeight();
        this.mBitmapWidth = this.mBitmap.getWidth();
        this.mBorderRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mBorderRadius = java.lang.Math.min((this.mBorderRect.height() - this.mBorderWidth) / 2.0f, (this.mBorderRect.width() - this.mBorderWidth) / 2.0f);
        android.graphics.RectF rectF = this.mDrawableRect;
        int i = this.mBorderWidth;
        rectF.set(i, i, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
        this.mDrawableRadius = java.lang.Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
        updateShaderMatrix();
        invalidate();
    }

    private void updateShaderMatrix() {
        float fWidth;
        float fHeight;
        this.mShaderMatrix.set(null);
        float fWidth2 = 0.0f;
        if (this.mBitmapWidth * this.mDrawableRect.height() > this.mDrawableRect.width() * this.mBitmapHeight) {
            fWidth = this.mDrawableRect.height() / this.mBitmapHeight;
            fHeight = 0.0f;
            fWidth2 = (this.mDrawableRect.width() - (this.mBitmapWidth * fWidth)) * 0.5f;
        } else {
            fWidth = this.mDrawableRect.width() / this.mBitmapWidth;
            fHeight = (this.mDrawableRect.height() - (this.mBitmapHeight * fWidth)) * 0.5f;
        }
        this.mShaderMatrix.setScale(fWidth, fWidth);
        android.graphics.Matrix matrix = this.mShaderMatrix;
        int i = this.mBorderWidth;
        matrix.postTranslate(((int) (fWidth2 + 0.5f)) + i, ((int) (fHeight + 0.5f)) + i);
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }
}
