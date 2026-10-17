package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CourseUrgeBookItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.CourseUrgeBookItemViewBinding b;

    public CourseUrgeBookItemView(android.content.Context context) {
        this(context, null);
    }

    public CourseUrgeBookItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CourseUrgeBookItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.CourseUrgeBookItemViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.course_urge_book_item_view, this, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || com.up366.mobile.common.helper.GuideDialogHelper.getInst().isHasShow()) {
            return;
        }
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isInEditMode() || com.up366.mobile.common.helper.GuideDialogHelper.getInst().isHasShow()) {
            return;
        }
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    public void setData(final com.up366.mobile.course.mgr.DailyInterestInfo dailyInterestInfo) {
        this.b.name.setText(dailyInterestInfo.getBookName());
        this.b.num.setText(dailyInterestInfo.getMark());
        this.b.itemBg.setVisibility(dailyInterestInfo.isFirst() ? 0 : 8);
        this.b.btnFirstGo.setVisibility(dailyInterestInfo.isFirst() ? 0 : 8);
        this.b.btnGo.setVisibility(dailyInterestInfo.isFirst() ? 8 : 0);
        com.up366.common.BitmapUtilsUp.display(this.b.icon, dailyInterestInfo.getCoverImg(), com.up366.mobile.R.drawable.icon_dubbing);
        this.b.iconNew.setVisibility((!dailyInterestInfo.isNew() || dailyInterestInfo.isFirst()) ? 4 : 0);
        this.b.btnFirstGo.setText("去练习");
        this.b.btnGo.setText("去练习");
        if (dailyInterestInfo.getShowType() == 1) {
            this.b.btnFirstGo.setText("扫一扫");
            this.b.btnGo.setText("扫一扫");
        }
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseUrgeBookItemView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setData$2(dailyInterestInfo, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$2(final com.up366.mobile.course.mgr.DailyInterestInfo dailyInterestInfo, android.view.View view) {
        if (dailyInterestInfo.getShowType() == 1) {
            ((com.up366.mobile.main.MainActivity) getContext()).getQrScanHelper().open(new com.up366.mobile.common.helper.QRScanHelper.IScanResult() { // from class: com.up366.mobile.common.views.CourseUrgeBookItemView$$ExternalSyntheticLambda1
                @Override // com.up366.mobile.common.helper.QRScanHelper.IScanResult
                public final void onResult(int i, java.lang.String str) {
                    com.up366.common.log.Logger.info("TAG - QrScanHelper - result - " + i);
                }
            });
            return;
        }
        com.up366.common.log.Logger.info("TAG - CourseUrgeBookItemView - click - " + dailyInterestInfo.getBookName());
        com.up366.mobile.common.utils.UrgeSkipUtils.skip(dailyInterestInfo.getBookId(), dailyInterestInfo.getBookName(), dailyInterestInfo.getBookType(), new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.common.views.CourseUrgeBookItemView$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                com.up366.mobile.common.views.CourseUrgeBookItemView.lambda$setData$1(dailyInterestInfo, i);
            }
        });
    }

    static /* synthetic */ void lambda$setData$1(com.up366.mobile.course.mgr.DailyInterestInfo dailyInterestInfo, int i) {
        dailyInterestInfo.setNew(false);
        com.up366.mobile.common.logic.Auth.cur().cache().put("book-cached-version-" + dailyInterestInfo.getBookId(), dailyInterestInfo.getMobileRevision(), com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.ScrollBottomAndShowEvent.ShowEvent showEvent) {
        if ("配音达人".equals(this.b.name.getText().toString())) {
            com.up366.mobile.common.helper.GuideDialogHelper.getInst().addPeiyinTip(this.b.focusView);
            com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync(com.up366.mobile.common.utils.AppCacheKeysUtils.GUIDE_PEIYIN, true, 2000L);
        }
    }

    public void setDataPreview(int i, final java.lang.String str, final java.lang.String str2, boolean z) {
        this.b.name.setText(str);
        this.b.num.setVisibility(8);
        this.b.itemBg.setVisibility(z ? 0 : 8);
        this.b.itemBg.setImageResource(com.up366.mobile.R.drawable.study_top_bg2);
        this.b.btnGo.setVisibility(0);
        com.up366.common.BitmapUtilsUp.display(this.b.icon, i);
        this.b.iconNew.setVisibility(4);
        this.b.btnFirstGo.setText("去查看");
        this.b.btnGo.setText("去查看");
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseUrgeBookItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setDataPreview$3(str2, str, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDataPreview$3(java.lang.String str, java.lang.String str2, android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getContext(), (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, str);
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL_NAME, str2);
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.TITLE_BAR_COLOR, "#ffbcebff");
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.TITLE_NO_SCROLL, true);
        getContext().startActivity(intent);
    }
}
