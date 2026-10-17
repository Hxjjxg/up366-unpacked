package com.up366.mobile.me.bindingparent;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeBindingParentSharedActivity extends com.up366.mobile.common.base.BaseActivity implements android.view.View.OnClickListener {
    private com.up366.mobile.databinding.MeBindingParentSharedActivityBinding binding;
    private com.up366.mobile.common.logic.model.ParentQcode qcode;
    private boolean isSave = false;
    private com.up366.common.callback.ICallbackCodeInfo shareCallback = new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.me.bindingparent.MeBindingParentSharedActivity$$ExternalSyntheticLambda0
        @Override // com.up366.common.callback.ICallbackCodeInfo
        public final void onResult(int i, java.lang.String str) {
            this.f$0.lambda$new$0(i, str);
        }
    };

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_bind_parent";
    }

    public static void openPage(android.content.Context context, com.up366.mobile.common.logic.model.ParentQcode parentQcode) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.me.bindingparent.MeBindingParentSharedActivity.class);
        intent.putExtra(com.up366.mobile.common.logic.model.ParentQcode.class.getName(), parentQcode);
        context.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (com.up366.mobile.databinding.MeBindingParentSharedActivityBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.me_binding_parent_shared_activity);
        this.qcode = (com.up366.mobile.common.logic.model.ParentQcode) getIntent().getSerializableExtra(com.up366.mobile.common.logic.model.ParentQcode.class.getName());
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        com.up366.notchtools.NotchTools.getInst().fullScreenUseStatus(this);
        super.onResume();
    }

    private void initView() {
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.sharedToWechatFriend, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.sharedSaveToLocal, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.sharedCancle, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.sharedToQq, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.sharedToQqSpace, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.sharedToWechatSpace, this);
        com.up366.common.BitmapUtilsUp.display(this.binding.userPhoto, com.up366.mobile.common.logic.Auth.getUserInfo().getPhotoUrl(), com.up366.mobile.R.drawable.icon_head_photo_default);
        this.binding.userRealname.setText(this.qcode.getUserName());
        this.binding.userPublic.setText(this.qcode.getTitle());
        if (this.qcode.getType() == 1) {
            this.binding.expireTime.setText(com.up366.common.TimeUtils.formatTime(this.qcode.getExpireTime(), "有效期至MM月dd日"));
        } else {
            this.binding.expireTime.setVisibility(4);
        }
        com.up366.common.BitmapUtilsUp.display(this.binding.qrParent, this.qcode.getUrl(), this.qcode.getDefaultImage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) throws java.lang.Throwable {
        if (view.getId() == 2131363247) {
            finish();
        }
        this.isSave = false;
        switch (view.getId()) {
            case com.up366.mobile.R.id.shared_save_to_local /* 2131363248 */:
                this.isSave = true;
                new com.up366.mobile.common.utils.ShareUtils(this).savePhotoToLocal((android.view.View) this.binding.shareLayout, this.shareCallback);
                break;
            case com.up366.mobile.R.id.shared_to_qq /* 2131363249 */:
                new com.up366.mobile.common.utils.ShareUtils(this).shareImage((android.view.View) this.binding.shareLayout, com.umeng.socialize.bean.SHARE_MEDIA.QQ, this.shareCallback);
                break;
            case com.up366.mobile.R.id.shared_to_qq_space /* 2131363250 */:
                new com.up366.mobile.common.utils.ShareUtils(this).shareImage((android.view.View) this.binding.shareLayout, com.umeng.socialize.bean.SHARE_MEDIA.QZONE, this.shareCallback);
                break;
            case com.up366.mobile.R.id.shared_to_wechat_friend /* 2131363251 */:
                new com.up366.mobile.common.utils.ShareUtils(this).shareImage((android.view.View) this.binding.shareLayout, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN, this.shareCallback);
                break;
            case com.up366.mobile.R.id.shared_to_wechat_space /* 2131363252 */:
                new com.up366.mobile.common.utils.ShareUtils(this).shareImage((android.view.View) this.binding.shareLayout, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN_CIRCLE, this.shareCallback);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$new$0(int i, java.lang.String str) {
        if (i != 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, str);
            return;
        }
        if (this.isSave) {
            com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("SAVE_SHARE_PICTURE", "SUCCESS", 300L);
        }
        finish();
    }
}
