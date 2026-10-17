package com.up366.mobile.course.p1p.view;

/* JADX INFO: compiled from: P1pScanImageView.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J\u0006\u0010\u0017\u001a\u00020\u0013J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/up366/mobile/course/p1p/view/P1pScanImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "scanDrawableTopRatio", "", "anim", "Landroid/animation/ValueAnimator;", "scanDrawable", "Landroid/graphics/drawable/Drawable;", "dispatchVisibilityChanged", "", "changedView", "Landroid/view/View;", "visibility", "cancelScan", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getScanDrawableHeight", "imageHeight", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class P1pScanImageView extends androidx.appcompat.widget.AppCompatImageView {
    private android.animation.ValueAnimator anim;
    private final android.graphics.drawable.Drawable scanDrawable;
    private float scanDrawableTopRatio;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P1pScanImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        android.graphics.drawable.Drawable drawable = context.getDrawable(com.up366.mobile.R.drawable.p1p_scan_anim_icon);
        kotlin.jvm.internal.Intrinsics.checkNotNull(drawable);
        this.scanDrawable = drawable;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public P1pScanImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public P1pScanImageView(android.content.Context context) {
        this(context, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    protected void dispatchVisibilityChanged(android.view.View changedView, int visibility) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.dispatchVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            android.animation.ValueAnimator valueAnimator = this.anim;
            if (valueAnimator != null && valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.scanDrawableTopRatio = 0.0f;
            android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.anim = valueAnimatorOfFloat;
            kotlin.jvm.internal.Intrinsics.checkNotNull(valueAnimatorOfFloat);
            valueAnimatorOfFloat.setRepeatCount(-1);
            android.animation.ValueAnimator valueAnimator2 = this.anim;
            kotlin.jvm.internal.Intrinsics.checkNotNull(valueAnimator2);
            valueAnimator2.setRepeatMode(1);
            android.animation.ValueAnimator valueAnimator3 = this.anim;
            kotlin.jvm.internal.Intrinsics.checkNotNull(valueAnimator3);
            valueAnimator3.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.mobile.course.p1p.view.P1pScanImageView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator4) {
                    com.up366.mobile.course.p1p.view.P1pScanImageView.dispatchVisibilityChanged$lambda$0(this.f$0, valueAnimator4);
                }
            });
            android.animation.ValueAnimator valueAnimator4 = this.anim;
            kotlin.jvm.internal.Intrinsics.checkNotNull(valueAnimator4);
            valueAnimator4.setDuration(2000L);
            android.animation.ValueAnimator valueAnimator5 = this.anim;
            if (valueAnimator5 != null) {
                valueAnimator5.start();
            }
        }
        if (visibility == 8) {
            android.animation.ValueAnimator valueAnimator6 = this.anim;
            if (valueAnimator6 != null) {
                valueAnimator6.cancel();
            }
            this.anim = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchVisibilityChanged$lambda$0(com.up366.mobile.course.p1p.view.P1pScanImageView p1pScanImageView, android.animation.ValueAnimator valueAnimator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(valueAnimator, com.igexin.push.g.q.f);
        java.lang.Object animatedValue = valueAnimator.getAnimatedValue();
        kotlin.jvm.internal.Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        p1pScanImageView.scanDrawableTopRatio = ((java.lang.Float) animatedValue).floatValue();
        p1pScanImageView.postInvalidate();
    }

    public final void cancelScan() {
        android.animation.ValueAnimator valueAnimator = this.anim;
        if (valueAnimator != null) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(valueAnimator);
            valueAnimator.cancel();
            this.anim = null;
            postInvalidate();
        }
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable == null || this.anim == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > width || intrinsicHeight > height) {
            float f = intrinsicWidth;
            float f2 = intrinsicHeight;
            float fMin = java.lang.Math.min(width / f, height / f2);
            intrinsicWidth = (int) (f * fMin);
            intrinsicHeight = (int) (fMin * f2);
        }
        int i = (width - intrinsicWidth) / 2;
        int scanDrawableHeight = ((height - intrinsicHeight) / 2) + ((int) ((intrinsicHeight - getScanDrawableHeight(intrinsicHeight)) * this.scanDrawableTopRatio));
        this.scanDrawable.setBounds(i, scanDrawableHeight, intrinsicWidth + i, getScanDrawableHeight(intrinsicHeight) + scanDrawableHeight);
        this.scanDrawable.draw(canvas);
    }

    private final int getScanDrawableHeight(int imageHeight) {
        return imageHeight / 5;
    }
}
