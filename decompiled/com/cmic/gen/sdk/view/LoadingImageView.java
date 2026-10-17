package com.cmic.gen.sdk.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class LoadingImageView extends android.widget.ImageView {
    private android.view.animation.Animation a;
    private android.view.animation.LinearInterpolator b;

    public LoadingImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        a();
    }

    protected void a() {
        this.a = android.view.animation.AnimationUtils.loadAnimation(getContext(), com.cmic.gen.sdk.z0.a(getContext(), "umcsdk_anim_loading"));
        android.view.animation.LinearInterpolator linearInterpolator = new android.view.animation.LinearInterpolator();
        this.b = linearInterpolator;
        this.a.setInterpolator(linearInterpolator);
    }

    public LoadingImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        a();
    }

    public LoadingImageView(android.content.Context context) {
        super(context);
        this.a = null;
        this.b = null;
        a();
    }
}
