package com.ylw.pullrefreshlibrary.refreshview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class RefreshView implements com.ylw.pullrefreshlibrary.refreshview.IRefreshView {
    private android.widget.ImageView ivUpRefresh;
    private android.widget.ProgressBar pbRefresh;
    private android.widget.TextView tvUpRefreshLoad;
    private android.widget.TextView tvUpRefreshTime;
    private android.widget.TextView tvUpRefreshTip;

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void updatePercent(float f) {
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void init(android.content.Context context, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout) {
        android.view.View.inflate(context, com.ylw.pullrefreshlibrary.R.layout.refresh_head_layout, pullRefreshLayout);
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void initView(android.view.View view) {
        this.ivUpRefresh = (android.widget.ImageView) view.findViewById(com.ylw.pullrefreshlibrary.R.id.iv_refresh_head_down);
        this.pbRefresh = (android.widget.ProgressBar) view.findViewById(com.ylw.pullrefreshlibrary.R.id.pb_refresh_head);
        this.tvUpRefreshTip = (android.widget.TextView) view.findViewById(com.ylw.pullrefreshlibrary.R.id.tv_refresh_up_tip);
        this.tvUpRefreshLoad = (android.widget.TextView) view.findViewById(com.ylw.pullrefreshlibrary.R.id.tv_refresh_up_load);
        this.tvUpRefreshTime = (android.widget.TextView) view.findViewById(com.ylw.pullrefreshlibrary.R.id.tv_refresh_up_time);
        this.pbRefresh.setVisibility(4);
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void toStep1(android.content.Context context, int i, int i2) {
        this.ivUpRefresh.setVisibility(0);
        this.ivUpRefresh.setBackgroundResource(com.ylw.pullrefreshlibrary.R.drawable.refresh_down);
        this.tvUpRefreshTip.setText("下拉刷新...");
        this.tvUpRefreshLoad.setVisibility(4);
        this.tvUpRefreshTip.setVisibility(0);
        this.tvUpRefreshTime.setVisibility(0);
        this.pbRefresh.setVisibility(4);
        roate2(this.ivUpRefresh, context);
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void toStep2(android.content.Context context, int i, int i2) {
        this.ivUpRefresh.setVisibility(0);
        this.tvUpRefreshTip.setText("放开以刷新...");
        this.tvUpRefreshLoad.setVisibility(4);
        this.tvUpRefreshTip.setVisibility(0);
        this.tvUpRefreshTime.setVisibility(0);
        this.pbRefresh.setVisibility(4);
        roate1(this.ivUpRefresh, context);
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void toStep3(android.content.Context context, int i, int i2) {
        this.ivUpRefresh.setVisibility(4);
        this.ivUpRefresh.clearAnimation();
        this.tvUpRefreshLoad.setText("正在刷新...");
        this.tvUpRefreshLoad.setVisibility(0);
        this.tvUpRefreshTip.setVisibility(4);
        this.tvUpRefreshTime.setVisibility(4);
        this.pbRefresh.setVisibility(0);
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void toStep4(android.content.Context context) {
        this.ivUpRefresh.setVisibility(0);
        this.ivUpRefresh.clearAnimation();
        this.ivUpRefresh.setBackgroundResource(com.ylw.pullrefreshlibrary.R.drawable.refresh_finish);
        this.tvUpRefreshLoad.setVisibility(0);
        this.tvUpRefreshLoad.setText("刷新完成！");
        this.tvUpRefreshTip.setVisibility(4);
        this.tvUpRefreshTime.setVisibility(4);
        this.pbRefresh.setVisibility(4);
    }

    @Override // com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void setRefreshTime(java.lang.String str) {
        this.tvUpRefreshTime.setText(java.lang.String.format("上次刷新时间：%s", str));
    }

    private void roate1(android.view.View view, android.content.Context context) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(context, com.ylw.pullrefreshlibrary.R.anim.roate_180_full_after_1));
    }

    private void roate2(android.view.View view, android.content.Context context) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(context, com.ylw.pullrefreshlibrary.R.anim.roate_180_full_after_2));
    }
}
