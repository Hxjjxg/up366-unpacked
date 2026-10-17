package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ShareView extends android.widget.FrameLayout {
    public static final int SHARE_PLATFORM_ALIPAY = 5;
    public static final int SHARE_PLATFORM_LOCAL = 6;
    public static final int SHARE_PLATFORM_QQ = 1;
    public static final int SHARE_PLATFORM_QQ_SPACE = 2;
    public static final int SHARE_PLATFORM_WECHAT = 3;
    public static final int SHARE_PLATFORM_WECHAT_SPACE = 4;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_URL = 1;
    public static final int TYPE_URL_IMAGE = 3;
    private final com.up366.mobile.databinding.ShareViewLayoutBinding b;
    private android.graphics.Bitmap bitmap;
    private android.view.View.OnClickListener btnClickListener;
    private com.up366.mobile.common.views.ShareView.ICaptureCallback captureCallback;
    private java.lang.String desc;
    private com.up366.common.callback.ICallbackCodeInfo shareCallback;
    private int shareType;
    private com.umeng.socialize.media.UMImage thumb;
    private java.lang.String title;
    private java.lang.String url;

    public interface ICaptureCallback {
        void onResult(com.up366.mobile.common.views.ShareView.ICaptureCallbackInner iCaptureCallbackInner);
    }

    public interface ICaptureCallbackInner {
        void onResult(android.graphics.Bitmap bitmap);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface ShareType {
    }

    public ShareView(android.content.Context context) {
        this(context, null);
    }

    public ShareView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareView(final android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.up366.mobile.databinding.ShareViewLayoutBinding shareViewLayoutBinding = (com.up366.mobile.databinding.ShareViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.share_view_layout, this, true);
        this.b = shareViewLayoutBinding;
        shareViewLayoutBinding.sharedCancle.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        shareViewLayoutBinding.sharedSaveToLocal.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$8(context, view);
            }
        });
        shareViewLayoutBinding.sharedToQq.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) throws java.lang.Throwable {
                this.f$0.lambda$new$9(context, view);
            }
        });
        shareViewLayoutBinding.sharedToQqSpace.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) throws java.lang.Throwable {
                this.f$0.lambda$new$10(context, view);
            }
        });
        shareViewLayoutBinding.sharedToWechatFriend.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) throws java.lang.Throwable {
                this.f$0.lambda$new$11(context, view);
            }
        });
        shareViewLayoutBinding.sharedToWechatSpace.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) throws java.lang.Throwable {
                this.f$0.lambda$new$12(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(android.view.View view) {
        handleBtnClickListener(view);
        this.shareCallback.onResult(100, "取消分享");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$8(final android.content.Context context, android.view.View view) {
        handleBtnClickListener(view);
        int i = this.shareType;
        if (i == 1) {
            new com.up366.mobile.common.utils.ShareUtils((android.app.Activity) context).shareURL(this.url, this.title, this.desc, this.thumb, com.umeng.socialize.bean.SHARE_MEDIA.QQ, this.shareCallback);
            return;
        }
        if (i == 3) {
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(this.b.getRoot(), "正在保存");
            this.captureCallback.onResult(new com.up366.mobile.common.views.ShareView.ICaptureCallbackInner() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda7
                @Override // com.up366.mobile.common.views.ShareView.ICaptureCallbackInner
                public final void onResult(android.graphics.Bitmap bitmap) {
                    this.f$0.lambda$new$4(context, bitmap);
                }
            });
        } else if (i == 2) {
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(this.b.getRoot(), "正在保存");
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda8
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$new$7(context);
                }
            });
        } else {
            this.shareCallback.onResult(-1, "参数错误：" + this.shareType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(android.content.Context context, final android.graphics.Bitmap bitmap) throws java.lang.Exception {
        new com.up366.mobile.common.utils.ShareUtils((android.app.Activity) context).savePhotoToLocal(bitmap, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                this.f$0.lambda$new$2(bitmap, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(final android.content.Context context, final android.graphics.Bitmap bitmap) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$new$3(context, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(final android.graphics.Bitmap bitmap, final int i, final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$new$1(bitmap, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(android.graphics.Bitmap bitmap, int i, java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(this.b.getRoot());
        bitmap.recycle();
        this.shareCallback.onResult(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$7(android.content.Context context) throws java.lang.Exception {
        new com.up366.mobile.common.utils.ShareUtils((android.app.Activity) context).savePhotoToLocal(this.bitmap, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda3
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                this.f$0.lambda$new$6(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(final int i, final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.ShareView$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$new$5(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(int i, java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(this.b.getRoot());
        this.shareCallback.onResult(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9(android.content.Context context, android.view.View view) throws java.lang.Throwable {
        handleBtnClickListener(view);
        int i = this.shareType;
        if (i == 1 || i == 3) {
            new com.up366.mobile.common.utils.ShareUtils((android.app.Activity) context).shareURL(this.url, this.title, this.desc, this.thumb, com.umeng.socialize.bean.SHARE_MEDIA.QQ, this.shareCallback);
            return;
        }
        if (i == 2) {
            new com.up366.mobile.common.utils.ShareUtils((android.app.Activity) context).shareImage(this.bitmap, com.umeng.socialize.bean.SHARE_MEDIA.QQ, this.shareCallback);
            return;
        }
        this.shareCallback.onResult(-1, "参数错误：" + this.shareType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$10(android.content.Context context, android.view.View view) throws java.lang.Throwable {
        handleBtnClickListener(view);
        int i = this.shareType;
        if (i == 1 || i == 3) {
            new com.up366.mobile.common.utils.ShareUtils((android.app.Activity) context).shareURL(this.url, this.title, this.desc, this.thumb, com.umeng.socialize.bean.SHARE_MEDIA.QZONE, this.shareCallback);
            return;
        }
        if (i == 2) {
            new com.up366.mobile.common.utils.ShareUtils((android.app.Activity) context).shareImage(this.bitmap, com.umeng.socialize.bean.SHARE_MEDIA.QZONE, this.shareCallback);
            return;
        }
        this.shareCallback.onResult(-1, "参数错误：" + this.shareType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$11(android.content.Context context, android.view.View view) throws java.lang.Throwable {
        handleBtnClickListener(view);
        int i = this.shareType;
        if (i == 1 || i == 3) {
            new com.up366.mobile.common.utils.ShareUtils((android.app.Activity) context).shareURL(this.url, this.title, this.desc, this.thumb, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN, this.shareCallback);
            return;
        }
        if (i == 2) {
            new com.up366.mobile.common.utils.ShareUtils((android.app.Activity) context).shareImage(this.bitmap, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN, this.shareCallback);
            return;
        }
        this.shareCallback.onResult(-1, "参数错误：" + this.shareType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$12(android.content.Context context, android.view.View view) throws java.lang.Throwable {
        handleBtnClickListener(view);
        int i = this.shareType;
        if (i == 1 || i == 3) {
            new com.up366.mobile.common.utils.ShareUtils((android.app.Activity) context).shareURL(this.url, this.title, this.desc, this.thumb, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN_CIRCLE, this.shareCallback);
            return;
        }
        if (i == 2) {
            new com.up366.mobile.common.utils.ShareUtils((android.app.Activity) context).shareImage(this.bitmap, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN_CIRCLE, this.shareCallback);
            return;
        }
        this.shareCallback.onResult(-1, "参数错误：" + this.shareType);
    }

    private void handleBtnClickListener(android.view.View view) {
        android.view.View.OnClickListener onClickListener = this.btnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setShareCallback(com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        this.shareCallback = iCallbackCodeInfo;
    }

    public void setBtnClickListener(android.view.View.OnClickListener onClickListener) {
        this.btnClickListener = onClickListener;
    }

    public void setParams(java.lang.String str, java.lang.String str2, java.lang.String str3, com.umeng.socialize.media.UMImage uMImage) {
        this.title = str;
        this.desc = str2;
        this.url = str3;
        this.thumb = uMImage;
    }

    public void setParams(android.graphics.Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setShareType(int i) {
        this.shareType = i;
        if (i == 2 || i == 3) {
            this.b.sharedSaveToLocal.setVisibility(0);
        } else {
            this.b.sharedSaveToLocal.setVisibility(8);
        }
    }

    public void setDialogTitle(java.lang.String str) {
        this.b.dialogTitle.setVisibility(0);
        this.b.dialogTitle.setText(str);
    }

    public void setSharePlatform(java.lang.Integer[] numArr) {
        if (numArr == null || numArr.length == 0) {
            return;
        }
        this.b.sharedToQq.setVisibility(8);
        this.b.sharedToQqSpace.setVisibility(8);
        this.b.sharedToWechatFriend.setVisibility(8);
        this.b.sharedToWechatSpace.setVisibility(8);
        this.b.sharedSaveToLocal.setVisibility(8);
        for (java.lang.Integer num : numArr) {
            int iIntValue = num.intValue();
            if (iIntValue == 1) {
                this.b.sharedToQq.setVisibility(0);
            } else if (iIntValue == 2) {
                this.b.sharedToQqSpace.setVisibility(0);
            } else if (iIntValue == 3) {
                this.b.sharedToWechatFriend.setVisibility(0);
            } else if (iIntValue == 4) {
                this.b.sharedToWechatSpace.setVisibility(0);
            } else if (iIntValue == 6) {
                this.b.sharedSaveToLocal.setVisibility(0);
            }
        }
    }

    public void setCaptureCallback(com.up366.mobile.common.views.ShareView.ICaptureCallback iCaptureCallback) {
        this.captureCallback = iCaptureCallback;
    }

    public void cancel() {
        this.b.sharedCancle.callOnClick();
    }
}
