package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonLoadingView extends android.widget.FrameLayout {
    public static final int TYPE_LOADING = 0;
    public static final int TYPE_LOAD_ERROR = 1;
    private final com.up366.mobile.databinding.CommonLoadingViewLayoutBinding b;
    private int currentType;

    public CommonLoadingView(android.content.Context context) {
        this(context, null);
    }

    public CommonLoadingView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonLoadingView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentType = 0;
        setClickable(true);
        com.up366.mobile.databinding.CommonLoadingViewLayoutBinding commonLoadingViewLayoutBinding = (com.up366.mobile.databinding.CommonLoadingViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.common_loading_view_layout, this, true);
        this.b = commonLoadingViewLayoutBinding;
        commonLoadingViewLayoutBinding.titleBar.setVisibility(8);
        commonLoadingViewLayoutBinding.tip.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        commonLoadingViewLayoutBinding.progress.setOnAnimPercentUpdateListener(new com.up366.mobile.common.views.DownloadProgressView.IOnAnimProgressUpdateListener() { // from class: com.up366.mobile.common.views.CommonLoadingView$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.views.DownloadProgressView.IOnAnimProgressUpdateListener
            public final void onUpdate(int i2) {
                this.f$0.lambda$new$0(i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(int i) {
        if (i < 0) {
            this.b.percentText.setVisibility(4);
        } else {
            this.b.percentText.setVisibility(0);
            this.b.percentText.setText(com.up366.common.StringUtils.format("%d%%", java.lang.Integer.valueOf(i)));
        }
    }

    @Override // android.view.View
    public android.view.ViewGroup.LayoutParams getLayoutParams() {
        android.view.ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        return layoutParams == null ? new android.view.ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public void setShowTitleBar(boolean z) {
        this.b.titleBar.setVisibility(z ? 0 : 8);
    }

    public void setTitleBarBackViewType(int i) {
        this.b.titleBar.binding.back.setType(i);
    }

    public void setTitle(java.lang.String str) {
        this.b.titleBar.setTitle(str);
    }

    public void setData(int i) {
        setData(i, null, null);
    }

    public void setData(int i, java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.currentType = i;
        if (i == 0) {
            this.b.progress.setState(0);
            this.b.tip.setText("准备中，马上就好哦");
            this.b.animationView.setVisibility(0);
            this.b.error.setVisibility(4);
            return;
        }
        if (i != 1) {
            return;
        }
        this.b.animationView.setVisibility(4);
        this.b.error.setVisibility(0);
        if (this.b.progress.getProgress() > 0) {
            this.b.progress.setState(3);
            this.b.percentText.setVisibility(0);
        } else {
            this.b.progress.setState(2);
            this.b.percentText.setVisibility(4);
        }
        this.b.tip.setText(getRetrySpan(onClickListener));
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, str);
    }

    public int getCurrentType() {
        return this.currentType;
    }

    private java.lang.CharSequence getRetrySpan(final android.view.View.OnClickListener onClickListener) {
        return new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("加载失败，").append("点击重试").setSpan(new android.text.style.ClickableSpan() { // from class: com.up366.mobile.common.views.CommonLoadingView.1
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                android.view.View.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(com.up366.mobile.common.views.CommonLoadingView.this);
                } else {
                    com.up366.common.log.Logger.error("CommonLoadingView getRetrySpan listener is null");
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(false);
            }
        }).build();
    }
}
