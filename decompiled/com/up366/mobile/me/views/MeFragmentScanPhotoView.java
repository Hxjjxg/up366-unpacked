package com.up366.mobile.me.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeFragmentScanPhotoView extends android.widget.LinearLayout {
    private final com.up366.mobile.databinding.MeScanParentLayoutBinding binding;

    public MeFragmentScanPhotoView(android.content.Context context) {
        this(context, null);
    }

    public MeFragmentScanPhotoView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MeFragmentScanPhotoView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.up366.mobile.databinding.MeScanParentLayoutBinding meScanParentLayoutBinding = (com.up366.mobile.databinding.MeScanParentLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.me_scan_parent_layout, this, true);
        this.binding = meScanParentLayoutBinding;
        meScanParentLayoutBinding.scanBtn.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(meScanParentLayoutBinding.scanBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.views.MeFragmentScanPhotoView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$1(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener((android.view.View) meScanParentLayoutBinding.parentPhoto, new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.views.MeFragmentScanPhotoView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$2(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(meScanParentLayoutBinding.parentText, new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.views.MeFragmentScanPhotoView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(android.view.View view) {
        if (com.up366.mobile.common.logic.Auth.isTourist()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, com.up366.mobile.R.string.tip_tourist);
        } else {
            ((com.up366.mobile.main.MainActivity) getContext()).getQrScanHelper().open(new com.up366.mobile.common.helper.QRScanHelper.IScanResult() { // from class: com.up366.mobile.me.views.MeFragmentScanPhotoView$$ExternalSyntheticLambda0
                @Override // com.up366.mobile.common.helper.QRScanHelper.IScanResult
                public final void onResult(int i, java.lang.String str) {
                    com.up366.common.log.Logger.error("扫码结果：" + i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(android.view.View view) {
        if (com.up366.mobile.common.logic.Auth.isTourist()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, com.up366.mobile.R.string.tip_tourist);
        } else {
            com.up366.common.global.GB.get().getCurrentActivity().startActivity(new android.content.Intent(getContext(), (java.lang.Class<?>) com.up366.mobile.me.bindingparent.MeBindingParentActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(android.view.View view) {
        this.binding.parentPhoto.callOnClick();
    }

    public void setData(java.util.List<com.up366.mobile.common.logic.model.UserParent> list) {
        this.binding.parentText.setText("未陪伴");
        this.binding.parentText.setTextColor(-79225);
        this.binding.parentPhoto.setImageResource(com.up366.mobile.R.drawable.icon_no_parent_photo);
        if (list == null || list.size() == 0) {
            return;
        }
        com.up366.common.BitmapUtilsUp.initDrawable(com.up366.mobile.R.drawable.icon_no_parent_photo, com.up366.mobile.R.drawable.icon_no_parent_photo);
        com.up366.common.BitmapUtilsUp.display(this.binding.parentPhoto, list.get(0).getHeadPhoto());
        com.up366.common.BitmapUtilsUp.initDrawable(com.up366.mobile.R.drawable.default_book_picture, com.up366.mobile.R.drawable.default_book_picture);
        this.binding.parentText.setText("陪伴中");
        this.binding.parentText.setTextColor(-25056);
    }
}
