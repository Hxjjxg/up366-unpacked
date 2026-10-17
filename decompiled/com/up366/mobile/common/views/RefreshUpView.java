package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RefreshUpView extends android.widget.FrameLayout {
    public static final int PAGE_SIZE_DEFAULT = 10;
    public static final int PAGE_SIZE_DEFAULT_TWO = 20;
    private com.up366.mobile.databinding.RefreshUpViewBinding b;
    private com.up366.mobile.common.views.RefreshUpView.Data data;
    private int pageSize;

    static /* synthetic */ void lambda$onDetachedFromWindow$2() throws java.lang.Exception {
    }

    public RefreshUpView(android.content.Context context) {
        this(context, null);
    }

    public RefreshUpView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RefreshUpView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pageSize = 10;
        this.b = (com.up366.mobile.databinding.RefreshUpViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.refresh_up_view, this, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.mobile.common.views.RefreshUpView.Data data = this.data;
        if (data == null || data.response == null) {
            return;
        }
        com.up366.mobile.common.utils.ViewUtil.gone(this.b.endTipLayout, this.b.loadingTip, this.b.errorTip);
        if (this.data.response.isError()) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.errorTip);
            android.text.SpannableStringBuilder spannableStringBuilderBuild = new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("加载失败，点击").append("重试").setSpan(new android.text.style.ForegroundColorSpan(-10715905)).build();
            this.b.errorTip.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.RefreshUpView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$onAttachedToWindow$0(view);
                }
            });
            this.b.errorTip.setText(spannableStringBuilderBuild);
            return;
        }
        if (this.data.pager.getCurrentPage() < this.data.pager.getPageCount()) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.loadingTip);
            com.up366.common.task.TaskUtils.postLazyTaskGlobal("RefreshView-" + hashCode(), 300, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.RefreshUpView$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onAttachedToWindow$1();
                }
            });
            return;
        }
        this.b.endTipLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAttachedToWindow$0(android.view.View view) {
        com.up366.mobile.common.utils.ViewUtil.invisible(this.b.errorTip);
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.loadingTip);
        this.data.controller.loadNextPageData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAttachedToWindow$1() throws java.lang.Exception {
        this.data.controller.loadNextPageData();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.up366.common.task.TaskUtils.postLazyTaskGlobal("RefreshView-" + hashCode(), 0, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.RefreshUpView$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.views.RefreshUpView.lambda$onDetachedFromWindow$2();
            }
        });
    }

    public void setData(com.up366.mobile.common.views.RefreshUpView.Data data) {
        this.data = data;
    }

    public static class Data {
        com.up366.mobile.common.base.BaseListViewDataController controller;
        com.up366.mobile.common.utils.ResponseUtil.Pager pager;
        com.up366.common.http.Response response;

        public Data(com.up366.common.http.Response response, com.up366.mobile.common.base.BaseListViewDataController baseListViewDataController) {
            this.response = response;
            this.controller = baseListViewDataController;
            this.pager = com.up366.mobile.common.utils.ResponseUtil.getPage(response);
        }
    }
}
