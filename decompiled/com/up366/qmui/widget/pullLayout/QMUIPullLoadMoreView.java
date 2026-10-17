package com.up366.qmui.widget.pullLayout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIPullLoadMoreView extends androidx.constraintlayout.widget.ConstraintLayout implements com.up366.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView {
    private androidx.appcompat.widget.AppCompatImageView mArrowView;
    private int mHeight;
    private boolean mIsInReleaseState;
    private boolean mIsLoading;
    private com.up366.qmui.widget.QMUILoadingView mLoadingView;
    private java.lang.String mPullText;
    private java.lang.String mReleaseText;
    private androidx.appcompat.widget.AppCompatTextView mTextView;

    public QMUIPullLoadMoreView(android.content.Context context) {
        this(context, null);
    }

    public QMUIPullLoadMoreView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUIPullLoadMoreStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QMUIPullLoadMoreView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsLoading = false;
        this.mIsInReleaseState = false;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUIPullLoadMoreView, i, 0);
        this.mPullText = typedArrayObtainStyledAttributes.getString(com.qmuiteam.qmui.R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_pull_text);
        this.mReleaseText = typedArrayObtainStyledAttributes.getString(com.qmuiteam.qmui.R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_release_text);
        this.mHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_height, com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 56));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_loading_size, com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 20));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_text_size, com.up366.qmui.util.QMUIDisplayHelper.sp2px(context, 14));
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_arrow_text_gap, com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 10));
        android.graphics.drawable.Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(com.qmuiteam.qmui.R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_arrow);
        int color = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIPullLoadMoreView_qmui_skin_support_pull_load_more_bg_color, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIPullLoadMoreView_qmui_skin_support_pull_load_more_loading_tint_color, com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
        int color3 = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIPullLoadMoreView_qmui_skin_support_pull_load_more_arrow_tint_color, com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
        int color4 = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUIPullLoadMoreView_qmui_skin_support_pull_load_more_text_color, com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
        typedArrayObtainStyledAttributes.recycle();
        com.up366.qmui.widget.QMUILoadingView qMUILoadingView = new com.up366.qmui.widget.QMUILoadingView(context);
        this.mLoadingView = qMUILoadingView;
        qMUILoadingView.setSize(dimensionPixelSize);
        this.mLoadingView.setColor(color2);
        this.mLoadingView.setVisibility(8);
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        addView(this.mLoadingView, layoutParams);
        androidx.appcompat.widget.AppCompatImageView appCompatImageView = new androidx.appcompat.widget.AppCompatImageView(context);
        this.mArrowView = appCompatImageView;
        appCompatImageView.setId(android.view.View.generateViewId());
        this.mArrowView.setImageDrawable(drawable);
        this.mArrowView.setRotation(180.0f);
        androidx.core.widget.ImageViewCompat.setImageTintList(this.mArrowView, android.content.res.ColorStateList.valueOf(color3));
        androidx.appcompat.widget.AppCompatTextView appCompatTextView = new androidx.appcompat.widget.AppCompatTextView(context);
        this.mTextView = appCompatTextView;
        appCompatTextView.setId(android.view.View.generateViewId());
        this.mTextView.setTextSize(0, dimensionPixelSize2);
        this.mTextView.setTextColor(color4);
        this.mTextView.setText(this.mPullText);
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.leftToLeft = 0;
        layoutParams2.rightToLeft = this.mTextView.getId();
        layoutParams2.topToTop = 0;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.horizontalChainStyle = 2;
        addView(this.mArrowView, layoutParams2);
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams3 = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.leftToRight = this.mArrowView.getId();
        layoutParams3.rightToRight = 0;
        layoutParams3.topToTop = 0;
        layoutParams3.bottomToBottom = 0;
        layoutParams3.leftMargin = dimensionPixelSize3;
        addView(this.mTextView, layoutParams3);
        setBackgroundColor(color);
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.background(com.qmuiteam.qmui.R.attr.qmui_skin_support_pull_load_more_bg_color);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        qMUISkinValueBuilderAcquire.tintColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_pull_load_more_loading_tint_color);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mLoadingView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        qMUISkinValueBuilderAcquire.tintColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_pull_load_more_arrow_tint_color);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mArrowView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        qMUISkinValueBuilderAcquire.textColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_pull_load_more_text_color);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mTextView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(this.mHeight, com.up366.medialibrary.common.utils.PictureFileUtils.GB));
    }

    @Override // com.up366.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView
    public void onPull(com.up366.qmui.widget.pullLayout.QMUIPullLayout.PullAction pullAction, int i) {
        if (this.mIsLoading) {
            return;
        }
        if (this.mIsInReleaseState) {
            if (pullAction.getTargetTriggerOffset() > i) {
                this.mIsInReleaseState = false;
                this.mTextView.setText(this.mPullText);
                this.mArrowView.animate().rotation(180.0f).start();
                return;
            }
            return;
        }
        if (pullAction.getTargetTriggerOffset() <= i) {
            this.mIsInReleaseState = true;
            this.mTextView.setText(this.mReleaseText);
            this.mArrowView.animate().rotation(0.0f).start();
        }
    }

    @Override // com.up366.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView
    public void onActionTriggered() {
        this.mIsLoading = true;
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.start();
        this.mArrowView.setVisibility(8);
        this.mTextView.setVisibility(8);
    }

    @Override // com.up366.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView
    public void onActionFinished() {
        this.mIsLoading = false;
        this.mLoadingView.stop();
        this.mLoadingView.setVisibility(8);
        this.mArrowView.setVisibility(0);
        this.mTextView.setVisibility(0);
    }
}
