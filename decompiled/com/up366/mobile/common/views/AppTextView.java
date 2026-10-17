package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppTextView extends androidx.appcompat.widget.AppCompatTextView implements android.widget.Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = {android.R.attr.state_checked};
    private int backgroundColor;
    private int borderColor;
    private float borderWidth;
    private int checkBackgroundColor;
    private int checkBorderColor;
    private int checkColor;
    private boolean mChecked;
    private final int normalBackgroundColor;
    private int normalBorderColor;
    private final int normalTextColor;
    private final android.graphics.Paint paintBackground;
    private final android.graphics.Paint paintBorder;
    private final android.graphics.Path path;
    private final float[] radiusArray;
    private float radiusLB;
    private float radiusLT;
    private float radiusRB;
    private float radiusRT;
    private final android.graphics.RectF rect;
    private int textColor;

    public AppTextView(android.content.Context context) {
        this(context, null);
    }

    public AppTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rect = new android.graphics.RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.path = new android.graphics.Path();
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paintBackground = paint;
        paint.setStrokeWidth(1.0f);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        this.paintBorder = paint2;
        paint2.setStrokeWidth(1.0f);
        paint2.setStyle(android.graphics.Paint.Style.STROKE);
        int defaultColor = getTextColors().getDefaultColor();
        this.normalTextColor = defaultColor;
        android.graphics.drawable.Drawable background = getBackground();
        if (background instanceof android.graphics.drawable.ColorDrawable) {
            this.normalBackgroundColor = ((android.graphics.drawable.ColorDrawable) background).getColor();
        } else {
            this.normalBackgroundColor = 16777215;
        }
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.AppTextView);
            float dimension = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
            this.radiusLT = typedArrayObtainStyledAttributes.getDimension(7, dimension);
            this.radiusRT = typedArrayObtainStyledAttributes.getDimension(9, dimension);
            this.radiusLB = typedArrayObtainStyledAttributes.getDimension(6, dimension);
            this.radiusRB = typedArrayObtainStyledAttributes.getDimension(8, dimension);
            this.borderWidth = typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
            this.normalBorderColor = typedArrayObtainStyledAttributes.getColor(0, 16777215);
            this.checkBackgroundColor = typedArrayObtainStyledAttributes.getColor(2, this.normalBackgroundColor);
            this.checkBorderColor = typedArrayObtainStyledAttributes.getColor(3, this.normalBorderColor);
            this.checkColor = typedArrayObtainStyledAttributes.getColor(4, defaultColor);
            typedArrayObtainStyledAttributes.recycle();
        }
        setBackgroundColor(16777215);
        float f = this.radiusLT;
        float f2 = this.radiusRT;
        float f3 = this.radiusRB;
        float f4 = this.radiusLB;
        this.radiusArray = new float[]{f, f, f2, f2, f3, f3, f4, f4};
        this.textColor = defaultColor;
        this.backgroundColor = this.normalBackgroundColor;
        this.borderColor = this.normalBorderColor;
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        this.path.reset();
        float f = width;
        float f2 = height;
        this.rect.set(0.0f, 0.0f, f, f2);
        this.path.addRoundRect(this.rect, this.radiusArray, android.graphics.Path.Direction.CW);
        this.paintBackground.setColor(this.backgroundColor);
        canvas.drawPath(this.path, this.paintBackground);
        float f3 = this.borderWidth;
        if (f3 > 0.0f) {
            float f4 = f3 / 2.0f;
            this.path.reset();
            this.rect.set(f4, f4, f - f4, f2 - f4);
            this.path.addRoundRect(this.rect, this.radiusArray, android.graphics.Path.Direction.CW);
            this.paintBorder.setColor(this.borderColor);
            this.paintBorder.setStrokeWidth(this.borderWidth);
            canvas.drawPath(this.path, this.paintBorder);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.mChecked != z) {
            this.mChecked = z;
            if (z) {
                int i = this.checkColor;
                this.textColor = i;
                this.backgroundColor = this.checkBackgroundColor;
                this.borderColor = this.checkBorderColor;
                setTextColor(i);
            } else {
                int i2 = this.normalTextColor;
                this.textColor = i2;
                this.backgroundColor = this.normalBackgroundColor;
                this.borderColor = this.normalBorderColor;
                setTextColor(i2);
            }
            refreshDrawableState();
            sendAccessibilityEvent(io.objectbox.model.PropertyFlags.INDEX_HASH);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.mChecked);
    }
}
