package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class EmptyStateView extends android.widget.FrameLayout {
    com.up366.mobile.databinding.EmptyStateViewBinding binding;

    public EmptyStateView(android.content.Context context) {
        super(context);
        init();
    }

    public EmptyStateView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public EmptyStateView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.binding = (com.up366.mobile.databinding.EmptyStateViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.empty_state_view, this, true);
    }

    public void setData(com.up366.mobile.common.views.viewmodel.EmptyViewModel emptyViewModel) {
        if (emptyViewModel == null) {
            return;
        }
        this.binding.btnEmptyStateLeft.setVisibility(8);
        this.binding.btnEmptyStateRight.setVisibility(8);
        if (emptyViewModel.isLoading()) {
            this.binding.emptyLoadingLayout.setVisibility(0);
            com.up366.mobile.common.utils.AnimUtils.showAnimation(this.binding.emptyLoadingImg);
            this.binding.ivEmptyStateTipimg.setVisibility(8);
            this.binding.tvEmptyViewTip.setVisibility(8);
            return;
        }
        this.binding.emptyLoadingLayout.setVisibility(8);
        com.up366.mobile.common.utils.AnimUtils.cancelAnimation(this.binding.emptyLoadingImg);
        this.binding.ivEmptyStateTipimg.setVisibility(0);
        this.binding.tvEmptyViewTip.setVisibility(0);
        this.binding.tvEmptyViewTip.setText(emptyViewModel.getTipMessage());
        if (emptyViewModel.getTipImage() != 0) {
            this.binding.ivEmptyStateTipimg.setImageResource(emptyViewModel.getTipImage());
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(emptyViewModel.getLeftBtn())) {
            this.binding.btnEmptyStateLeft.setVisibility(0);
            this.binding.btnEmptyStateLeft.setText(emptyViewModel.getLeftBtn());
            this.binding.btnEmptyStateLeft.setOnClickListener(emptyViewModel.getLeftBtnListener());
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(emptyViewModel.getRightBtn())) {
            return;
        }
        this.binding.btnEmptyStateRight.setVisibility(0);
        this.binding.btnEmptyStateRight.setText(emptyViewModel.getRightBtn());
        this.binding.btnEmptyStateRight.setOnClickListener(emptyViewModel.getRightBtnListener());
    }

    public void showTransparentLoadingState() {
        com.up366.mobile.common.utils.ViewUtil.visible(this.binding.emptyLoadingLayout);
        com.up366.mobile.common.utils.AnimUtils.showAnimation(this.binding.emptyLoadingImg);
        this.binding.rootView.setBackgroundColor(0);
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.btnEmptyStateLeft, this.binding.btnEmptyStateRight, this.binding.ivEmptyStateTipimg, this.binding.tvEmptyViewTip);
    }

    public void showLoadingState() {
        com.up366.mobile.common.utils.ViewUtil.visible(this.binding.emptyLoadingLayout);
        com.up366.mobile.common.utils.AnimUtils.showAnimation(this.binding.emptyLoadingImg);
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.btnEmptyStateLeft, this.binding.btnEmptyStateRight, this.binding.ivEmptyStateTipimg, this.binding.tvEmptyViewTip);
    }

    public void showPoorNetStateError(android.view.View.OnClickListener onClickListener) {
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.emptyLoadingLayout);
        com.up366.mobile.common.utils.AnimUtils.cancelAnimation(this.binding.emptyLoadingImg);
        com.up366.mobile.common.utils.ViewUtil.visible(this.binding.btnEmptyStateLeft, this.binding.btnEmptyStateRight, this.binding.ivEmptyStateTipimg, this.binding.tvEmptyViewTip);
        this.binding.ivEmptyStateTipimg.setImageResource(com.up366.mobile.R.drawable.bg_empty_state6);
        this.binding.tvEmptyViewTip.setText(com.up366.mobile.R.string.poor_network_state_tip);
        this.binding.btnEmptyStateLeft.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.EmptyStateView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.commonui.LookHelpActivity.openPage(view.getContext());
            }
        });
        this.binding.btnEmptyStateRight.setOnClickListener(onClickListener);
    }

    public void showEmptyState(java.lang.String str) {
        showEmptyState(com.up366.mobile.R.drawable.bg_empty_state3, str);
    }

    public void showEmptyState(int i, java.lang.String str) {
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.emptyLoadingLayout, this.binding.btnEmptyStateLeft, this.binding.btnEmptyStateRight);
        com.up366.mobile.common.utils.AnimUtils.cancelAnimation(this.binding.emptyLoadingImg);
        com.up366.mobile.common.utils.ViewUtil.visible(this.binding.ivEmptyStateTipimg, this.binding.tvEmptyViewTip);
        this.binding.ivEmptyStateTipimg.setImageResource(i);
        this.binding.tvEmptyViewTip.setText(str);
    }

    public void showErrorState(android.view.View.OnClickListener onClickListener) {
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.emptyLoadingLayout, this.binding.btnEmptyStateLeft);
        com.up366.mobile.common.utils.AnimUtils.cancelAnimation(this.binding.emptyLoadingImg);
        com.up366.mobile.common.utils.ViewUtil.visible(this.binding.ivEmptyStateTipimg, this.binding.tvEmptyViewTip, this.binding.btnEmptyStateRight);
        this.binding.ivEmptyStateTipimg.setImageResource(com.up366.mobile.R.drawable.bg_empty_state4);
        this.binding.tvEmptyViewTip.setText(com.up366.mobile.R.string.server_error);
        this.binding.btnEmptyStateRight.setOnClickListener(onClickListener);
    }
}
