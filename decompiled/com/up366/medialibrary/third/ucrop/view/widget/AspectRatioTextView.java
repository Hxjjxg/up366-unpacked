package com.up366.medialibrary.third.ucrop.view.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AspectRatioTextView extends androidx.appcompat.widget.AppCompatTextView {
    private final float MARGIN_MULTIPLIER;
    private float mAspectRatio;
    private java.lang.String mAspectRatioTitle;
    private float mAspectRatioX;
    private float mAspectRatioY;
    private final android.graphics.Rect mCanvasClipBounds;
    private android.graphics.Paint mDotPaint;
    private int mDotSize;

    public AspectRatioTextView(android.content.Context context) {
        this(context, null);
    }

    public AspectRatioTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MARGIN_MULTIPLIER = 1.5f;
        this.mCanvasClipBounds = new android.graphics.Rect();
        init(context.obtainStyledAttributes(attributeSet, com.up366.medialibrary.R.styleable.ucrop_AspectRatioTextView));
    }

    public AspectRatioTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.MARGIN_MULTIPLIER = 1.5f;
        this.mCanvasClipBounds = new android.graphics.Rect();
        init(context.obtainStyledAttributes(attributeSet, com.up366.medialibrary.R.styleable.ucrop_AspectRatioTextView));
    }

    public void setActiveColor(int i) {
        applyActiveColor(i);
        invalidate();
    }

    public void setAspectRatio(com.up366.medialibrary.third.ucrop.model.AspectRatio aspectRatio) {
        this.mAspectRatioTitle = aspectRatio.getAspectRatioTitle();
        this.mAspectRatioX = aspectRatio.getAspectRatioX();
        float aspectRatioY = aspectRatio.getAspectRatioY();
        this.mAspectRatioY = aspectRatioY;
        float f = this.mAspectRatioX;
        if (f == 0.0f || aspectRatioY == 0.0f) {
            this.mAspectRatio = 0.0f;
        } else {
            this.mAspectRatio = f / aspectRatioY;
        }
        setTitle();
    }

    public float getAspectRatio(boolean z) {
        if (z) {
            toggleAspectRatio();
            setTitle();
        }
        return this.mAspectRatio;
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.mCanvasClipBounds);
            int i = this.mDotSize;
            canvas.drawCircle((this.mCanvasClipBounds.right - this.mCanvasClipBounds.left) / 2.0f, (this.mCanvasClipBounds.bottom - (this.mCanvasClipBounds.top / 2.0f)) - (i * 1.5f), i / 2.0f, this.mDotPaint);
        }
    }

    private void init(android.content.res.TypedArray typedArray) {
        setGravity(1);
        this.mAspectRatioTitle = typedArray.getString(com.up366.medialibrary.R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.mAspectRatioX = typedArray.getFloat(com.up366.medialibrary.R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        float f = typedArray.getFloat(com.up366.medialibrary.R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.mAspectRatioY = f;
        float f2 = this.mAspectRatioX;
        if (f2 == 0.0f || f == 0.0f) {
            this.mAspectRatio = 0.0f;
        } else {
            this.mAspectRatio = f2 / f;
        }
        this.mDotSize = getContext().getResources().getDimensionPixelSize(com.up366.medialibrary.R.dimen.ucrop_size_dot_scale_text_view);
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.mDotPaint = paint;
        paint.setStyle(android.graphics.Paint.Style.FILL);
        setTitle();
        applyActiveColor(getResources().getColor(com.up366.medialibrary.R.color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    private void applyActiveColor(int i) {
        android.graphics.Paint paint = this.mDotPaint;
        if (paint != null) {
            paint.setColor(i);
        }
        setTextColor(new android.content.res.ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[]{0}}, new int[]{i, androidx.core.content.ContextCompat.getColor(getContext(), com.up366.medialibrary.R.color.ucrop_color_widget)}));
    }

    private void toggleAspectRatio() {
        if (this.mAspectRatio != 0.0f) {
            float f = this.mAspectRatioX;
            float f2 = this.mAspectRatioY;
            this.mAspectRatioX = f2;
            this.mAspectRatioY = f;
            this.mAspectRatio = f2 / f;
        }
    }

    private void setTitle() {
        if (android.text.TextUtils.isEmpty(this.mAspectRatioTitle)) {
            setText(java.lang.String.format(java.util.Locale.US, "%d:%d", java.lang.Integer.valueOf((int) this.mAspectRatioX), java.lang.Integer.valueOf((int) this.mAspectRatioY)));
        } else {
            setText(this.mAspectRatioTitle);
        }
    }
}
