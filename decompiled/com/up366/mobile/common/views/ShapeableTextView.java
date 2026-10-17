package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ShapeableTextView extends androidx.appcompat.widget.AppCompatTextView implements com.google.android.material.shape.Shapeable {
    private static final int DEF_STYLE_RES = 2132018373;
    private static final int UNDEFINED_PADDING = Integer.MIN_VALUE;
    private final android.graphics.Paint borderPaint;
    private int bottomContentPadding;
    private final android.graphics.Paint clearPaint;
    private final android.graphics.RectF destination;
    private int endContentPadding;
    private boolean hasAdjustedPaddingAfterLayoutDirectionResolved;
    private int leftContentPadding;
    private android.graphics.Path maskPath;
    private final android.graphics.RectF maskRect;
    private final android.graphics.Path path;
    private final com.google.android.material.shape.ShapeAppearancePathProvider pathProvider;
    private int rightContentPadding;
    private com.google.android.material.shape.MaterialShapeDrawable shadowDrawable;
    private com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;
    private int startContentPadding;
    private android.content.res.ColorStateList strokeColor;
    private float strokeWidth;
    private int topContentPadding;

    public ShapeableTextView(android.content.Context context) {
        this(context, null, 0);
    }

    public ShapeableTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShapeableTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, 2132018373), attributeSet, i);
        this.pathProvider = getInstance();
        this.path = new android.graphics.Path();
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = false;
        android.content.Context context2 = getContext();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.clearPaint = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        this.destination = new android.graphics.RectF();
        this.maskRect = new android.graphics.RectF();
        this.maskPath = new android.graphics.Path();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.ShapeableTextView, i, 2132018373);
        this.strokeColor = getColorStateList(context2, typedArrayObtainStyledAttributes, 11);
        this.strokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.leftContentPadding = dimensionPixelSize;
        this.topContentPadding = dimensionPixelSize;
        this.rightContentPadding = dimensionPixelSize;
        this.bottomContentPadding = dimensionPixelSize;
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
        this.rightContentPadding = dimensionPixelSize2;
        this.leftContentPadding = dimensionPixelSize2;
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, dimensionPixelSize);
        this.bottomContentPadding = dimensionPixelSize3;
        this.topContentPadding = dimensionPixelSize3;
        this.leftContentPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, this.leftContentPadding);
        this.topContentPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, this.topContentPadding);
        this.rightContentPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, this.rightContentPadding);
        this.bottomContentPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, this.bottomContentPadding);
        this.startContentPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, Integer.MIN_VALUE);
        this.endContentPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.borderPaint = paint2;
        paint2.setStyle(android.graphics.Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.shapeAppearanceModel = com.google.android.material.shape.ShapeAppearanceModel.builder(context2, attributeSet, i, 2132018373).build();
        setOutlineProvider(new com.up366.mobile.common.views.ShapeableTextView.OutlineProvider());
    }

    protected void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    protected void onMeasure(int i, int i2) {
        if (this.hasAdjustedPaddingAfterLayoutDirectionResolved) {
            super.onMeasure(i, i2);
            return;
        }
        if (!isLayoutDirectionResolved()) {
            super.onMeasure(i, i2);
            return;
        }
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = true;
        if (isPaddingRelative() || isContentPaddingRelative()) {
            setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            super.onMeasure(i, i2);
        } else {
            setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            super.onMeasure(i, i2);
        }
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.maskPath, this.clearPaint);
        drawStroke(canvas);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateShapeMask(i, i2);
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.startContentPadding = Integer.MIN_VALUE;
        this.endContentPadding = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.leftContentPadding) + i, (super.getPaddingTop() - this.topContentPadding) + i2, (super.getPaddingRight() - this.rightContentPadding) + i3, (super.getPaddingBottom() - this.bottomContentPadding) + i4);
        this.leftContentPadding = i;
        this.topContentPadding = i2;
        this.rightContentPadding = i3;
        this.bottomContentPadding = i4;
    }

    public void setContentPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i, (super.getPaddingTop() - this.topContentPadding) + i2, (super.getPaddingEnd() - getContentPaddingEnd()) + i3, (super.getPaddingBottom() - this.bottomContentPadding) + i4);
        this.leftContentPadding = isRtl() ? i3 : i;
        this.topContentPadding = i2;
        if (!isRtl()) {
            i = i3;
        }
        this.rightContentPadding = i;
        this.bottomContentPadding = i4;
    }

    private boolean isContentPaddingRelative() {
        return (this.startContentPadding == Integer.MIN_VALUE && this.endContentPadding == Integer.MIN_VALUE) ? false : true;
    }

    public int getContentPaddingBottom() {
        return this.bottomContentPadding;
    }

    public final int getContentPaddingEnd() {
        int i = this.endContentPadding;
        return i != Integer.MIN_VALUE ? i : isRtl() ? this.leftContentPadding : this.rightContentPadding;
    }

    public int getContentPaddingLeft() {
        int i;
        int i2;
        if (isContentPaddingRelative()) {
            if (isRtl() && (i2 = this.endContentPadding) != Integer.MIN_VALUE) {
                return i2;
            }
            if (!isRtl() && (i = this.startContentPadding) != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.leftContentPadding;
    }

    public int getContentPaddingRight() {
        int i;
        int i2;
        if (isContentPaddingRelative()) {
            if (isRtl() && (i2 = this.startContentPadding) != Integer.MIN_VALUE) {
                return i2;
            }
            if (!isRtl() && (i = this.endContentPadding) != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.rightContentPadding;
    }

    public final int getContentPaddingStart() {
        int i = this.startContentPadding;
        return i != Integer.MIN_VALUE ? i : isRtl() ? this.rightContentPadding : this.leftContentPadding;
    }

    public int getContentPaddingTop() {
        return this.topContentPadding;
    }

    private boolean isRtl() {
        return getLayoutDirection() == 1;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i + getContentPaddingLeft(), i2 + getContentPaddingTop(), i3 + getContentPaddingRight(), i4 + getContentPaddingBottom());
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i + getContentPaddingStart(), i2 + getContentPaddingTop(), i3 + getContentPaddingEnd(), i4 + getContentPaddingBottom());
    }

    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public void setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.shadowDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        updateShapeMask(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    private void updateShapeMask(int i, int i2) {
        this.destination.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i2 - getPaddingBottom());
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.destination, this.path);
        this.maskPath.rewind();
        this.maskPath.addPath(this.path);
        this.maskRect.set(0.0f, 0.0f, i, i2);
        this.maskPath.addRect(this.maskRect, android.graphics.Path.Direction.CCW);
    }

    private void drawStroke(android.graphics.Canvas canvas) {
        if (this.strokeColor == null) {
            return;
        }
        this.borderPaint.setStrokeWidth(this.strokeWidth);
        int colorForState = this.strokeColor.getColorForState(getDrawableState(), this.strokeColor.getDefaultColor());
        if (this.strokeWidth <= 0.0f || colorForState == 0) {
            return;
        }
        this.borderPaint.setColor(colorForState);
        canvas.drawPath(this.path, this.borderPaint);
    }

    public void setStrokeColorResource(int i) {
        setStrokeColor(androidx.appcompat.content.res.AppCompatResources.getColorStateList(getContext(), i));
    }

    public android.content.res.ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public void setStrokeWidth(float f) {
        if (this.strokeWidth != f) {
            this.strokeWidth = f;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i) {
        setStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public void setStrokeColor(android.content.res.ColorStateList colorStateList) {
        this.strokeColor = colorStateList;
        invalidate();
    }

    class OutlineProvider extends android.view.ViewOutlineProvider {
        private final android.graphics.Rect rect = new android.graphics.Rect();

        OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(android.view.View view, android.graphics.Outline outline) {
            if (com.up366.mobile.common.views.ShapeableTextView.this.shapeAppearanceModel == null) {
                return;
            }
            if (com.up366.mobile.common.views.ShapeableTextView.this.shadowDrawable == null) {
                com.up366.mobile.common.views.ShapeableTextView.this.shadowDrawable = new com.google.android.material.shape.MaterialShapeDrawable(com.up366.mobile.common.views.ShapeableTextView.this.shapeAppearanceModel);
            }
            com.up366.mobile.common.views.ShapeableTextView.this.destination.round(this.rect);
            com.up366.mobile.common.views.ShapeableTextView.this.shadowDrawable.setBounds(this.rect);
            com.up366.mobile.common.views.ShapeableTextView.this.shadowDrawable.getOutline(outline);
        }
    }

    public static android.content.res.ColorStateList getColorStateList(android.content.Context context, android.content.res.TypedArray typedArray, int i) {
        int resourceId;
        android.content.res.ColorStateList colorStateList;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateList;
    }

    public static com.google.android.material.shape.ShapeAppearancePathProvider getInstance() {
        return com.up366.mobile.common.views.ShapeableTextView.Lazy.INSTANCE;
    }

    private static class Lazy {
        static final com.google.android.material.shape.ShapeAppearancePathProvider INSTANCE = new com.google.android.material.shape.ShapeAppearancePathProvider();

        private Lazy() {
        }
    }
}
