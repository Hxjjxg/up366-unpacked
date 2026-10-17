package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class HeadSemicircleBackgroundView extends android.view.View {
    private float centerHeight;
    int[] colors;
    private android.graphics.Matrix matrix;
    private float minSideHeight;
    private android.graphics.Matrix mt;
    private int offset;
    android.graphics.Paint paint;
    private android.graphics.Path path;
    float[] position;
    private float rad;
    private android.graphics.LinearGradient shader;
    private float sideHeight;

    public HeadSemicircleBackgroundView(android.content.Context context) {
        super(context);
        this.paint = null;
        this.colors = new int[]{-16745729, -15092225};
        this.position = new float[]{0.0f, 1.0f};
        this.sideHeight = 100.0f;
        this.minSideHeight = 100.0f;
        this.centerHeight = 200.0f;
        this.rad = 4.0f;
        init(context, null);
    }

    public HeadSemicircleBackgroundView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint = null;
        this.colors = new int[]{-16745729, -15092225};
        this.position = new float[]{0.0f, 1.0f};
        this.sideHeight = 100.0f;
        this.minSideHeight = 100.0f;
        this.centerHeight = 200.0f;
        this.rad = 4.0f;
        init(context, attributeSet);
    }

    public HeadSemicircleBackgroundView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = null;
        this.colors = new int[]{-16745729, -15092225};
        this.position = new float[]{0.0f, 1.0f};
        this.sideHeight = 100.0f;
        this.minSideHeight = 100.0f;
        this.centerHeight = 200.0f;
        this.rad = 4.0f;
        init(context, attributeSet);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.HeadSemicircleBackgroundView);
            float dimension = typedArrayObtainStyledAttributes.getDimension(3, 100.0f);
            this.sideHeight = dimension;
            this.minSideHeight = typedArrayObtainStyledAttributes.getDimension(1, dimension);
            this.centerHeight = typedArrayObtainStyledAttributes.getDimension(0, 200.0f);
            this.rad = typedArrayObtainStyledAttributes.getFloat(2, 4.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.shader = new android.graphics.LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, this.colors, this.position, android.graphics.Shader.TileMode.CLAMP);
        this.matrix = new android.graphics.Matrix();
        this.mt = new android.graphics.Matrix();
        this.shader.getLocalMatrix(this.matrix);
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paint = paint;
        paint.setShader(this.shader);
        this.path = new android.graphics.Path();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mt.set(this.matrix);
        this.mt.postScale(getMeasuredWidth(), getMeasuredHeight());
        this.shader.setLocalMatrix(this.mt);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        float fMax;
        float fMax2;
        int width = getWidth();
        getHeight();
        int i = this.offset;
        if (i < 0) {
            float f = this.sideHeight + i;
            float f2 = this.centerHeight + i;
            fMax2 = java.lang.Math.max(f, this.minSideHeight);
            fMax = java.lang.Math.max(f2, this.minSideHeight);
        } else {
            float f3 = this.sideHeight + (i / 8);
            fMax = i + this.centerHeight;
            fMax2 = f3;
        }
        this.path.reset();
        this.path.moveTo(0.0f, 0.0f);
        float f4 = width;
        this.path.lineTo(f4, 0.0f);
        this.path.lineTo(f4, fMax2);
        android.graphics.Path path = this.path;
        float f5 = this.rad;
        path.cubicTo(f4 - (f4 / f5), fMax, f4 / f5, fMax, 0.0f, fMax2);
        this.path.lineTo(0.0f, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setMinSideHeight(float f) {
        this.minSideHeight = f;
        postInvalidate();
    }

    public void setMinSideHeight(final android.view.View... viewArr) {
        android.view.View.OnLayoutChangeListener onLayoutChangeListener = new android.view.View.OnLayoutChangeListener() { // from class: com.up366.mobile.common.views.HeadSemicircleBackgroundView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.lambda$setMinSideHeight$0(viewArr, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        for (android.view.View view : viewArr) {
            view.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinSideHeight$0(android.view.View[] viewArr, android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int height = 0;
        for (android.view.View view2 : viewArr) {
            height += view2.getHeight();
        }
        setMinSideHeight(height);
    }

    public void setSideHeight(float f) {
        this.sideHeight = f;
        postInvalidate();
    }

    public void setCenterHeight(final android.view.View... viewArr) {
        android.view.View.OnLayoutChangeListener onLayoutChangeListener = new android.view.View.OnLayoutChangeListener() { // from class: com.up366.mobile.common.views.HeadSemicircleBackgroundView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.lambda$setCenterHeight$1(viewArr, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        for (android.view.View view : viewArr) {
            view.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCenterHeight$1(android.view.View[] viewArr, android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int height = 0;
        for (android.view.View view2 : viewArr) {
            height += view2.getHeight();
        }
        setCenterHeight(height);
    }

    public void setSideHeight(final android.view.View... viewArr) {
        android.view.View.OnLayoutChangeListener onLayoutChangeListener = new android.view.View.OnLayoutChangeListener() { // from class: com.up366.mobile.common.views.HeadSemicircleBackgroundView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.lambda$setSideHeight$2(viewArr, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        for (android.view.View view : viewArr) {
            view.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSideHeight$2(android.view.View[] viewArr, android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int height = 0;
        for (android.view.View view2 : viewArr) {
            height += view2.getHeight();
        }
        setSideHeight(height);
    }

    public void setCenterHeight(float f) {
        this.centerHeight = f;
        postInvalidate();
    }

    public void setRad(float f) {
        this.rad = f;
        postInvalidate();
    }

    public void fixedHeight() {
        this.centerHeight = java.lang.Math.max(this.centerHeight, this.sideHeight);
        postInvalidate();
    }

    public void setOffset(int i) {
        this.offset = i;
        postInvalidate();
    }
}
