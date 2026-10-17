package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TabIndicatorView extends android.widget.RadioGroup {
    private android.animation.ValueAnimator anim;
    private int cur;
    private int last;
    private int lineColor;
    private float lineHeight;
    private float lineWidth;
    private float marginBottom;
    private float offset;
    private android.graphics.Paint paint;

    public TabIndicatorView(android.content.Context context) {
        super(context);
        this.lineWidth = 100.0f;
        this.lineHeight = 6.0f;
        this.lineColor = -14583045;
        this.marginBottom = 0.0f;
        this.cur = 0;
        init(context, null);
    }

    public TabIndicatorView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lineWidth = 100.0f;
        this.lineHeight = 6.0f;
        this.lineColor = -14583045;
        this.marginBottom = 0.0f;
        this.cur = 0;
        init(context, attributeSet);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.TabIndicatorView);
            this.lineWidth = typedArrayObtainStyledAttributes.getDimension(2, 100.0f);
            this.lineHeight = typedArrayObtainStyledAttributes.getDimension(1, 6.0f);
            this.lineColor = typedArrayObtainStyledAttributes.getColor(0, -14583045);
            this.marginBottom = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paint = paint;
        paint.setStrokeWidth(this.lineHeight);
        this.paint.setColor(this.lineColor);
        setWillNotDraw(false);
        setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() { // from class: com.up366.mobile.common.views.TabIndicatorView$$ExternalSyntheticLambda0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(android.widget.RadioGroup radioGroup, int i) {
                this.f$0.lambda$init$0(radioGroup, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(android.widget.RadioGroup radioGroup, int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2).getId() == i) {
                setCur(i2);
                return;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int childCount = getChildCount();
        int width = getWidth();
        int height = getHeight();
        if (childCount == 0) {
            return;
        }
        float f = (width * 1.0f) / childCount;
        int i = this.cur;
        float f2 = this.lineWidth;
        float f3 = (((i * f) + (f / 2.0f)) - (f2 / 2.0f)) + (this.offset * f * (this.last - i));
        float f4 = (height - (this.lineHeight / 2.0f)) - this.marginBottom;
        canvas.drawLine(f3, f4, f3 + f2, f4, this.paint);
    }

    public void setCur(int i) {
        int i2 = this.cur;
        if (i2 == i) {
            return;
        }
        this.last = i2;
        this.cur = i;
        postInvalidate();
        if (this.anim == null) {
            android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.anim = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(800L);
            this.anim.setInterpolator(new android.view.animation.BounceInterpolator());
        }
        this.anim.cancel();
        this.anim.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.mobile.common.views.TabIndicatorView$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f$0.lambda$setCur$1(valueAnimator);
            }
        });
        this.anim.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCur$1(android.animation.ValueAnimator valueAnimator) {
        this.offset = 1.0f - ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        postInvalidate();
    }
}
