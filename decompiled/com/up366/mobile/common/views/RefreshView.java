package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RefreshView implements com.ylw.pullrefreshlibrary.refreshview.IRefreshView {
    private com.airbnb.lottie.LottieAnimationView animationView;
    private int state;
    private float step1 = 0.03f;
    private float step2 = 0.031f;
    private float step3 = 0.954f;
    private android.animation.ValueAnimator.AnimatorUpdateListener step2Listener = new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.mobile.common.views.RefreshView.1
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            if (com.up366.mobile.common.views.RefreshView.this.animationView.getProgress() > com.up366.mobile.common.views.RefreshView.this.step2) {
                com.up366.mobile.common.views.RefreshView.this.animationView.pauseAnimation();
            }
        }
    };
    private android.animation.ValueAnimator.AnimatorUpdateListener step3Listener = new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.mobile.common.views.RefreshView.2
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            if (com.up366.mobile.common.views.RefreshView.this.animationView.getProgress() >= com.up366.mobile.common.views.RefreshView.this.step3) {
                com.up366.mobile.common.views.RefreshView.this.animationView.pauseAnimation();
                com.up366.mobile.common.views.RefreshView.this.animationView.setProgress(com.up366.mobile.common.views.RefreshView.this.step2);
                com.up366.mobile.common.views.RefreshView.this.animationView.resumeAnimation();
            }
        }
    };

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void setRefreshTime(java.lang.String str) {
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void toStep3(android.content.Context context, int i, int i2) {
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void init(android.content.Context context, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout) {
        android.view.View.inflate(context, com.up366.mobile.R.layout.custom_refresh_head_layout, pullRefreshLayout);
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void initView(android.view.View view) {
        com.airbnb.lottie.LottieAnimationView lottieAnimationViewFindViewById = view.findViewById(com.up366.mobile.R.id.animationView);
        this.animationView = lottieAnimationViewFindViewById;
        lottieAnimationViewFindViewById.setSpeed(1.0f);
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void toStep1(android.content.Context context, int i, int i2) {
        this.state = i2;
        this.animationView.removeUpdateListener(this.step2Listener);
        this.animationView.removeUpdateListener(this.step3Listener);
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void toStep2(android.content.Context context, int i, int i2) {
        this.animationView.resumeAnimation();
        this.animationView.setRepeatCount(-1);
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void toStep4(android.content.Context context) {
        this.animationView.setRepeatCount(0);
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void updatePercent(float f) {
        if (this.animationView.isAnimating()) {
            this.animationView.pauseAnimation();
        }
        this.animationView.setProgress(this.step1 * f);
    }

    public com.airbnb.lottie.LottieAnimationView getAnimationView() {
        return this.animationView;
    }
}
