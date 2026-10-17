package com.up366.mobile.main;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CommonSharedActivity extends com.up366.mobile.common.base.BaseActivity implements android.view.View.OnClickListener {
    private static final java.lang.String IMG_PATH = "imagePath";
    private com.up366.mobile.databinding.CommonSharedActivityLayoutBinding binding;
    private java.lang.String imgPath = "";
    private com.up366.common.callback.ICallbackCodeInfo shareCallback = new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.main.CommonSharedActivity$$ExternalSyntheticLambda2
        @Override // com.up366.common.callback.ICallbackCodeInfo
        public final void onResult(int i, java.lang.String str) {
            this.f$0.lambda$new$3(i, str);
        }
    };

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        com.up366.mobile.databinding.CommonSharedActivityLayoutBinding commonSharedActivityLayoutBinding = (com.up366.mobile.databinding.CommonSharedActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.common_shared_activity_layout);
        this.binding = commonSharedActivityLayoutBinding;
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(commonSharedActivityLayoutBinding.sharedToWechatFriend, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.sharedCancle, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.sharedToQq, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.sharedToQqSpace, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.sharedToWechatSpace, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.sharedSaveToLocal, this);
        this.binding.sharedSaveToLocal.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.up366.mobile.main.CommonSharedActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(android.view.View view) {
                return this.f$0.lambda$onCreate$0(view);
            }
        });
        this.imgPath = getIntent().getStringExtra(IMG_PATH);
        com.up366.common.BitmapUtilsUp.display(this.binding.image, this.imgPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean lambda$onCreate$0(android.view.View view) {
        new com.up366.mobile.common.compat.CopyAppDataToSdcardCompat().handle(this, com.up366.mobile.common.compat.CopyAppDataToSdcardCompat.STRING);
        return true;
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDestroy();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.CloseOtherCommonShareEvent closeOtherCommonShareEvent) {
        if (this.imgPath.equals(closeOtherCommonShareEvent.imgPath)) {
            return;
        }
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) throws java.lang.Throwable {
        if (view.getId() == 2131363247) {
            finish();
        }
        switch (view.getId()) {
            case com.up366.mobile.R.id.shared_save_to_local /* 2131363248 */:
                new com.up366.mobile.common.utils.ShareUtils(this).savePhotoToLocal((android.view.View) this.binding.image, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.main.CommonSharedActivity$$ExternalSyntheticLambda1
                    @Override // com.up366.common.callback.ICallbackCodeInfo
                    public final void onResult(int i, java.lang.String str) {
                        this.f$0.lambda$onClick$2(i, str);
                    }
                });
                break;
            case com.up366.mobile.R.id.shared_to_qq /* 2131363249 */:
                new com.up366.mobile.common.utils.ShareUtils(this).shareImage((android.view.View) this.binding.image, com.umeng.socialize.bean.SHARE_MEDIA.QQ, this.shareCallback);
                break;
            case com.up366.mobile.R.id.shared_to_qq_space /* 2131363250 */:
                new com.up366.mobile.common.utils.ShareUtils(this).shareImage((android.view.View) this.binding.image, com.umeng.socialize.bean.SHARE_MEDIA.QZONE, this.shareCallback);
                break;
            case com.up366.mobile.R.id.shared_to_wechat_friend /* 2131363251 */:
                new com.up366.mobile.common.utils.ShareUtils(this).shareImage((android.view.View) this.binding.image, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN, this.shareCallback);
                break;
            case com.up366.mobile.R.id.shared_to_wechat_space /* 2131363252 */:
                new com.up366.mobile.common.utils.ShareUtils(this).shareImage((android.view.View) this.binding.image, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN_CIRCLE, this.shareCallback);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onClick$2(int i, java.lang.String str) {
        if (i == 0) {
            com.up366.common.task.TaskUtils.postMainTaskDelay(150L, new com.up366.common.task.Task() { // from class: com.up366.mobile.main.CommonSharedActivity$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(com.up366.common.global.GB.get().getCurrentActivity(), "保存成功");
                }
            });
            finish();
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$new$3(int i, java.lang.String str) {
        if (i != 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, str);
        } else {
            finish();
        }
    }

    public static void openPage(android.app.Activity activity, final java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.main.CommonSharedActivity.class);
        intent.putExtra(IMG_PATH, str);
        activity.startActivityForResult(intent, 10011);
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.main.CommonSharedActivity$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.CloseOtherCommonShareEvent(str));
            }
        });
    }
}
