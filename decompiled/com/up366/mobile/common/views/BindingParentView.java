package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BindingParentView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.MeBindingParentViewLayoutBinding b;

    public BindingParentView(android.content.Context context) {
        this(context, null);
    }

    public BindingParentView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BindingParentView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.up366.mobile.databinding.MeBindingParentViewLayoutBinding meBindingParentViewLayoutBinding = (com.up366.mobile.databinding.MeBindingParentViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.me_binding_parent_view_layout, this, true);
        this.b = meBindingParentViewLayoutBinding;
        com.up366.common.BitmapUtilsUp.display(meBindingParentViewLayoutBinding.userPhoto, com.up366.mobile.common.logic.Auth.getUserInfo().getPhotoUrl(), com.up366.mobile.R.drawable.icon_head_photo_default);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(meBindingParentViewLayoutBinding.tipLayout, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.BindingParentView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(android.view.View view) {
        if ("加载中".equals(this.b.tipMessage.getText().toString())) {
            return;
        }
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError(this, "网络未连接，请先连接网络");
            return;
        }
        com.up366.mobile.common.utils.ViewUtil.disable(this.b.tipLayout);
        com.up366.common.BitmapUtilsUp.display(this.b.parentLoading, com.up366.mobile.R.drawable.parent_loading);
        this.b.tipMessage.setText("加载中");
        com.up366.mobile.common.utils.ViewUtil.gone(this.b.retryBtn);
        com.up366.mobile.common.logic.Auth.cur().info().fetchParentQcode();
    }

    public void setData(com.up366.mobile.common.logic.model.ParentQcodeResponse parentQcodeResponse) {
        com.up366.mobile.common.utils.ViewUtil.enable(this.b.tipLayout);
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.tipMask);
        this.b.userRealname.setText(parentQcodeResponse.result.getUserName());
        this.b.userPublic.setText(parentQcodeResponse.result.getTitle());
        com.up366.common.BitmapUtilsUp.display(this.b.qrParent, parentQcodeResponse.result.getDefaultImage());
        if (parentQcodeResponse.resp == null) {
            com.up366.common.BitmapUtilsUp.display(this.b.parentLoading, com.up366.mobile.R.drawable.parent_loading);
            return;
        }
        if (parentQcodeResponse.resp.isError()) {
            com.up366.common.BitmapUtilsUp.display(this.b.parentLoading, com.up366.mobile.R.drawable.parent_load_error);
            this.b.tipMessage.setText("抱歉！加载失败");
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.retryBtn);
        } else {
            com.up366.mobile.common.utils.ViewUtil.gone(this.b.tipLayout, this.b.tipMask);
            com.up366.common.BitmapUtilsUp.display(this.b.qrParent, parentQcodeResponse.result.getUrl(), parentQcodeResponse.result.getDefaultImage());
        }
    }
}
