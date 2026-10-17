package com.up366.mobile.me.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeFragmentHeadPhotoItemView extends android.widget.LinearLayout {
    private static final int STUDY_CARD_GRAY_UP = 1;
    private static final int STUDY_CARD_NO = 0;
    private static final int STUDY_CARD_ORANGE_UP = 2;
    private static final int STUDY_CARD_VIP = 3;
    private com.up366.mobile.databinding.MeFragmentHeadPhotoItemViewBinding binding;
    private final android.content.Context context;

    public MeFragmentHeadPhotoItemView(android.content.Context context) {
        this(context, null);
    }

    public MeFragmentHeadPhotoItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MeFragmentHeadPhotoItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        this.binding = (com.up366.mobile.databinding.MeFragmentHeadPhotoItemViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.me_fragment_head_photo_item_view, this, true);
    }

    public void setData(com.up366.mobile.common.logic.user.UserInfo userInfo) {
        this.binding.name.setText(userInfo.getRealname());
        this.binding.account.setText(userInfo.getUsername());
        com.up366.common.BitmapUtilsUp.display(this.binding.mePhoto, userInfo.getPhotoUrl(), com.up366.mobile.R.drawable.icon_head_photo_default);
        this.binding.dayStudyTime.setVisibility(com.up366.mobile.common.logic.Auth.isAuth() ? 0 : 4);
        this.binding.dayStudyTime.setText(java.lang.String.format("今日学习时长：%s", com.up366.mobile.common.views.BreakReminderUtils.getStudyLengthString()));
        if (!com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            this.binding.mePhoto.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.views.MeFragmentHeadPhotoItemView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$setData$0(view);
                }
            });
        }
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.studyCardIcon, this.binding.tipCardTime);
        this.binding.tipCardTime.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.views.MeFragmentHeadPhotoItemView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.common.log.Logger.info("tipCardTime click");
            }
        });
        com.up366.mobile.common.logic.model.StudyCardInfo studyCardInfoLoadStudyCardInfo = com.up366.mobile.common.logic.Auth.cur().info().loadStudyCardInfo();
        int status = studyCardInfoLoadStudyCardInfo.getStatus();
        long maxGoodsValidity = studyCardInfoLoadStudyCardInfo.getMaxGoodsValidity();
        if (status == 2) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.studyCardIcon);
            if (maxGoodsValidity > 0) {
                com.up366.mobile.common.utils.ViewUtil.visible(this.binding.tipCardTime);
                this.binding.tipCardTime.setText("有效期至：" + com.up366.common.TimeUtils.formatTime(maxGoodsValidity, "yyyy.MM.dd"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$0(android.view.View view) {
        if (com.up366.mobile.common.logic.Auth.isTourist()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, com.up366.mobile.R.string.tip_tourist);
        } else {
            com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.openPage(view.getContext());
        }
    }

    public void refreshStudyLength() {
        this.binding.dayStudyTime.setText(java.lang.String.format("今日学习时长：%s", com.up366.mobile.common.views.BreakReminderUtils.getStudyLengthString()));
    }

    public android.view.View getHeadPhotoView() {
        return this.binding.mePhoto;
    }
}
