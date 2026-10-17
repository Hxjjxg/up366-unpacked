package com.up366.mobile.me.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class UserInfoItemView extends android.widget.LinearLayout {
    private com.up366.mobile.databinding.UserInfoItemViewBinding binding;
    private boolean hasRightArrow;
    private int rightTipColor;
    private java.lang.String rightTipText;
    private boolean showHeadPhoto;
    private java.lang.String titleText;

    public UserInfoItemView(android.content.Context context) {
        super(context);
        initAttr(context, null, 0);
    }

    public UserInfoItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttr(context, attributeSet, 0);
    }

    public UserInfoItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttr(context, attributeSet, i);
    }

    private void initAttr(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.UserInfoItemView);
        this.titleText = typedArrayObtainStyledAttributes.getString(4);
        this.rightTipText = typedArrayObtainStyledAttributes.getString(1);
        this.rightTipColor = typedArrayObtainStyledAttributes.getColor(2, getResources().getColor(com.up366.mobile.R.color.c5));
        this.showHeadPhoto = typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.hasRightArrow = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        com.up366.mobile.databinding.UserInfoItemViewBinding userInfoItemViewBinding = (com.up366.mobile.databinding.UserInfoItemViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.user_info_item_view, this, true);
        this.binding = userInfoItemViewBinding;
        userInfoItemViewBinding.userInfoItemText.setText(this.titleText);
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.userInfoImg, this.binding.userInfoRightArrow, this.binding.userInfoItemContent);
        if (this.showHeadPhoto) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.userInfoImg);
            if (!isInEditMode()) {
                com.up366.common.BitmapUtilsUp.display(this.binding.userInfoImg, com.up366.mobile.common.logic.Auth.getUserInfo().getPhotoUrl(), com.up366.mobile.R.drawable.icon_head_photo_default);
            }
        }
        if (this.hasRightArrow) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.userInfoRightArrow);
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(this.rightTipText)) {
            return;
        }
        com.up366.mobile.common.utils.ViewUtil.visible(this.binding.userInfoItemContent);
        this.binding.userInfoItemContent.setText(this.rightTipText);
        this.binding.userInfoItemContent.setTextColor(this.rightTipColor);
    }

    public void reload() {
        showPhoto();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showPhoto() {
        com.up366.mobile.common.logic.model.UserCustomPhotoStatus userCustomPhotoStatusLoadCustomPhotoStatus = com.up366.mobile.common.logic.Auth.cur().info().loadCustomPhotoStatus();
        if (userCustomPhotoStatusLoadCustomPhotoStatus.isCheckFail()) {
            userCustomPhotoStatusLoadCustomPhotoStatus.checkShowErrorTipStatus();
        }
        com.up366.mobile.common.utils.ViewUtil.visible(this.binding.userInfoImg);
        if (userCustomPhotoStatusLoadCustomPhotoStatus.isChecking()) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.userInfoItemContent);
            this.binding.userInfoItemContent.setTextSize(13.0f);
            this.binding.userInfoItemContent.setText("审核中           ");
            this.binding.mePhotoImgMeng.setVisibility(0);
            com.up366.common.BitmapUtilsUp.display(this.binding.userInfoImg, userCustomPhotoStatusLoadCustomPhotoStatus.getHeadPhoto(), com.up366.mobile.R.drawable.icon_head_photo_default);
            return;
        }
        if (userCustomPhotoStatusLoadCustomPhotoStatus.isNeedShowErrorTip()) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.userInfoItemContent);
            this.binding.userInfoItemContent.setText("审核未通过，已恢复上次头像           ");
            this.binding.userInfoItemContent.setTextSize(13.0f);
            this.binding.userInfoItemContent.setTextColor(-43434);
        } else {
            com.up366.mobile.common.utils.ViewUtil.gone(this.binding.userInfoItemContent);
        }
        com.up366.common.BitmapUtilsUp.display(this.binding.userInfoImg, com.up366.mobile.common.logic.Auth.getUserInfo().getPhotoUrl(), com.up366.mobile.R.drawable.icon_head_photo_default);
    }

    public void setText(java.lang.String str) {
        this.binding.userInfoItemContent.setText(str);
    }

    public void setText(java.lang.String str, int i, boolean z) {
        this.binding.userInfoItemContent.setTextColor(i);
        this.binding.userInfoItemContent.setText(str);
        if (z) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.userInfoRightArrow);
        } else {
            com.up366.mobile.common.utils.ViewUtil.gone(this.binding.userInfoRightArrow);
        }
    }

    public com.up366.mobile.databinding.UserInfoItemViewBinding getBinding() {
        return this.binding;
    }
}
