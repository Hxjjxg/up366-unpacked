package com.up366.mobile.common.views;

/* JADX INFO: compiled from: RefreshViewV2.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/up366/mobile/common/views/RefreshViewV2;", "Lcom/up366/mobile/common/views/RefreshView;", "<init>", "()V", "initView", "", "headView", "Landroid/view/View;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RefreshViewV2 extends com.up366.mobile.common.views.RefreshView {
    @Override // com.up366.mobile.common.views.RefreshView, com.ylw.pullrefreshlibrary.refreshview.IRefreshView
    public void initView(android.view.View headView) {
        super.initView(headView);
        getAnimationView().clearAnimation();
        getAnimationView().setAnimation(com.up366.mobile.R.raw.footerloading);
        android.view.ViewGroup.LayoutParams layoutParams = getAnimationView().getLayoutParams();
        layoutParams.height = com.up366.qmui.util.QMUIDisplayHelper.dpToPx(30);
        getAnimationView().setLayoutParams(layoutParams);
    }
}
