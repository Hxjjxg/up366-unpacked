package com.up366.multimedia.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class TopPopupDialog extends com.flyco.dialog.widget.base.BaseDialog<com.up366.multimedia.dialog.TopPopupDialog> {
    private com.up366.multimedia.dialog.TopPopupAdapter mAdapter;
    private int mDividerColor;
    private float mDividerHeight;
    private android.view.animation.LayoutAnimationController mLac;
    private android.widget.ListView mLv;
    private com.flyco.dialog.listener.OnOperItemClickL mOnOperItemClickL;
    private com.up366.multimedia.dialog.TopPopupDialog.OnShowStateUpdateListener showStateUpdateListener;

    public interface OnShowStateUpdateListener {
        void onShowStateChanged(boolean isShow);
    }

    public void setOnOperItemClickL(com.flyco.dialog.listener.OnOperItemClickL onOperItemClickL) {
        this.mOnOperItemClickL = onOperItemClickL;
    }

    public void setShowStateUpdateListener(com.up366.multimedia.dialog.TopPopupDialog.OnShowStateUpdateListener showStateUpdateListener) {
        this.showStateUpdateListener = showStateUpdateListener;
    }

    public TopPopupDialog(android.content.Context context, java.util.List<com.up366.multimedia.util.AlbumHelper.ImageBucket> buckets) {
        super(context, true);
        this.mDividerColor = -3355444;
        this.mDividerHeight = 0.5f;
        com.up366.multimedia.dialog.TopPopupAdapter topPopupAdapter = new com.up366.multimedia.dialog.TopPopupAdapter(context);
        this.mAdapter = topPopupAdapter;
        topPopupAdapter.setDatas(buckets);
        init();
    }

    private void init() {
        widthScale(1.0f);
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 2.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
        translateAnimation.setDuration(550L);
        android.view.animation.LayoutAnimationController layoutAnimationController = new android.view.animation.LayoutAnimationController(translateAnimation, 0.12f);
        this.mLac = layoutAnimationController;
        layoutAnimationController.setInterpolator(new android.view.animation.DecelerateInterpolator());
    }

    public android.view.View onCreateView() {
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(this.mContext);
        android.view.View view = new android.view.View(this.mContext);
        view.setBackgroundColor(this.mContext.getResources().getColor(com.afollestad.materialcamera.R.color.media_gray));
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = dp2px(50.0f);
        view.setLayoutParams(layoutParams);
        frameLayout.addView(view);
        this.mLv = new android.widget.ListView(this.mContext);
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = dp2px(isSpecialDevice() ? 25.0f : 50.0f);
        layoutParams2.bottomMargin = dp2px(160.0f);
        this.mLv.setLayoutParams(layoutParams2);
        this.mLv.setCacheColorHint(0);
        this.mLv.setFadingEdgeLength(0);
        this.mLv.setVerticalScrollBarEnabled(false);
        this.mLv.setSelector(new android.graphics.drawable.ColorDrawable(0));
        this.mLv.setBackgroundResource(com.afollestad.materialcamera.R.drawable.bg_repeat_drawable);
        android.view.View.OnClickListener onClickListener = new android.view.View.OnClickListener() { // from class: com.up366.multimedia.dialog.TopPopupDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view2) {
                com.up366.multimedia.dialog.TopPopupDialog.this.dismiss();
            }
        };
        view.setOnClickListener(onClickListener);
        frameLayout.setOnClickListener(onClickListener);
        frameLayout.addView(this.mLv);
        return frameLayout;
    }

    private boolean isSpecialDevice() {
        return "PACM00".equals(android.os.Build.MODEL) && android.os.Build.VERSION.SDK_INT == 28;
    }

    public void setUiBeforShow() {
        this.mLv.setDivider(new android.graphics.drawable.ColorDrawable(this.mDividerColor));
        this.mLv.setDividerHeight(dp2px(this.mDividerHeight));
        this.mLv.setAdapter((android.widget.ListAdapter) this.mAdapter);
        this.mLv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() { // from class: com.up366.multimedia.dialog.TopPopupDialog.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {
                com.up366.multimedia.dialog.TopPopupDialog.this.mAdapter.setSelectedPosition(position);
                if (com.up366.multimedia.dialog.TopPopupDialog.this.mOnOperItemClickL != null) {
                    com.up366.multimedia.dialog.TopPopupDialog.this.mOnOperItemClickL.onOperItemClick(parent, view, position, id);
                }
            }
        });
        this.mLv.setLayoutAnimation(this.mLac);
    }

    public void setSelectedPostion(int selectedPostion) {
        this.mAdapter.setSelectedPosition(selectedPostion);
    }

    public void show() {
        super.show();
        com.up366.multimedia.dialog.TopPopupDialog.OnShowStateUpdateListener onShowStateUpdateListener = this.showStateUpdateListener;
        if (onShowStateUpdateListener != null) {
            onShowStateUpdateListener.onShowStateChanged(true);
        }
    }

    public void dismiss() {
        super.dismiss();
        com.up366.multimedia.dialog.TopPopupDialog.OnShowStateUpdateListener onShowStateUpdateListener = this.showStateUpdateListener;
        if (onShowStateUpdateListener != null) {
            onShowStateUpdateListener.onShowStateChanged(false);
        }
    }
}
