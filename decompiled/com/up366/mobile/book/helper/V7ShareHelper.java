package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V7ShareHelper extends com.up366.mobile.book.helper.ShareHelper {
    private final android.app.Activity context;

    public V7ShareHelper(android.app.Activity activity) {
        super(activity);
        this.context = activity;
    }

    public void share(final java.lang.String str, final com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        java.lang.String strCompatPermission = com.up366.mobile.common.utils.PermissionUtils.compatPermission();
        android.app.Activity activity = this.context;
        com.up366.mobile.common.utils.PermissionUtils.checkPermission(activity, new java.lang.String[]{"存储权限"}, new java.lang.String[]{strCompatPermission}, activity.getString(com.up366.mobile.R.string.permission_storage), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.helper.V7ShareHelper$$ExternalSyntheticLambda3
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str2) {
                this.f$0.lambda$share$0(str, studyPageWebView, iCallbackCodeInfo, i, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$0(java.lang.String str, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo, int i, java.lang.String str2) {
        if (i == 0) {
            shareInternal(str, studyPageWebView, iCallbackCodeInfo);
        } else {
            iCallbackCodeInfo.onResult(-1, "没有存储权限");
        }
    }

    private void shareInternal(java.lang.String str, final com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String serverUrl = com.up366.common.global.GB.get().getServerUrl(object.getString("imgUrl"));
        com.umeng.socialize.media.UMImage uMImage = !com.up366.common.StringUtils.isEmptyOrNull(serverUrl) ? new com.umeng.socialize.media.UMImage(this.context, serverUrl) : null;
        int intValue = object.getIntValue("type");
        java.lang.String serverUrl2 = com.up366.common.global.GB.get().getServerUrl(object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL));
        java.lang.String string = object.getString("title");
        java.lang.String string2 = object.getString("desc");
        if (intValue == 1) {
            new com.up366.mobile.common.dialog.ShareDialog(this.context).shareUrl(string, string2, serverUrl2, uMImage, (com.up366.mobile.common.views.ShareView.ICaptureCallback) null, iCallbackCodeInfo);
            return;
        }
        if (intValue == 2) {
            studyPageWebView.captureAsync(new com.up366.mobile.book.webview.CaptureHelper.IOnCaptureListener() { // from class: com.up366.mobile.book.helper.V7ShareHelper$$ExternalSyntheticLambda1
                @Override // com.up366.mobile.book.webview.CaptureHelper.IOnCaptureListener
                public final void onCapture(android.graphics.Bitmap bitmap) {
                    this.f$0.lambda$shareInternal$2(iCallbackCodeInfo, bitmap);
                }
            });
            return;
        }
        if (intValue == 3) {
            new com.up366.mobile.common.dialog.ShareDialog(this.context).shareUrl(string, string2, serverUrl2, uMImage, new com.up366.mobile.common.views.ShareView.ICaptureCallback() { // from class: com.up366.mobile.book.helper.V7ShareHelper$$ExternalSyntheticLambda2
                @Override // com.up366.mobile.common.views.ShareView.ICaptureCallback
                public final void onResult(com.up366.mobile.common.views.ShareView.ICaptureCallbackInner iCaptureCallbackInner) {
                    com.up366.mobile.book.helper.V7ShareHelper.lambda$shareInternal$3(studyPageWebView, iCaptureCallbackInner);
                }
            }, iCallbackCodeInfo);
        } else {
            if (intValue == 4) {
                shareNoDialog(uMImage, serverUrl2, string, string2, object.getIntValue("shareType"), iCallbackCodeInfo);
                return;
            }
            iCallbackCodeInfo.onResult(-1, "参数错误 type:" + intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareInternal$2(final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo, final android.graphics.Bitmap bitmap) {
        if (!isActivityAlive()) {
            com.up366.common.log.Logger.info("ShareDialog error , activity is not alive, skip share result callback");
        } else {
            new com.up366.mobile.common.dialog.ShareDialog(this.context).shareImage(bitmap, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.helper.V7ShareHelper$$ExternalSyntheticLambda4
                @Override // com.up366.common.callback.ICallbackCodeInfo
                public final void onResult(int i, java.lang.String str) {
                    com.up366.mobile.book.helper.V7ShareHelper.lambda$shareInternal$1(bitmap, iCallbackCodeInfo, i, str);
                }
            });
        }
    }

    static /* synthetic */ void lambda$shareInternal$1(android.graphics.Bitmap bitmap, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo, int i, java.lang.String str) {
        bitmap.recycle();
        iCallbackCodeInfo.onResult(i, str);
    }

    static /* synthetic */ void lambda$shareInternal$3(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, final com.up366.mobile.common.views.ShareView.ICaptureCallbackInner iCaptureCallbackInner) {
        java.util.Objects.requireNonNull(iCaptureCallbackInner);
        studyPageWebView.captureAsync(new com.up366.mobile.book.webview.CaptureHelper.IOnCaptureListener() { // from class: com.up366.mobile.book.helper.V7ShareHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.webview.CaptureHelper.IOnCaptureListener
            public final void onCapture(android.graphics.Bitmap bitmap) {
                iCaptureCallbackInner.onResult(bitmap);
            }
        });
    }

    private boolean isActivityAlive() {
        android.app.Activity activity = this.context;
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return !this.context.isDestroyed();
    }

    private void shareNoDialog(com.umeng.socialize.media.UMImage uMImage, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        if (i == 1) {
            new com.up366.mobile.common.utils.ShareUtils(this.context).shareURL(str, str2, str3, uMImage, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN, iCallbackCodeInfo);
            return;
        }
        if (i == 2) {
            new com.up366.mobile.common.utils.ShareUtils(this.context).shareURL(str, str2, str3, uMImage, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN_CIRCLE, iCallbackCodeInfo);
            return;
        }
        if (i == 3) {
            new com.up366.mobile.common.utils.ShareUtils(this.context).shareURL(str, str2, str3, uMImage, com.umeng.socialize.bean.SHARE_MEDIA.QQ, iCallbackCodeInfo);
            return;
        }
        if (i == 4) {
            new com.up366.mobile.common.utils.ShareUtils(this.context).shareURL(str, str2, str3, uMImage, com.umeng.socialize.bean.SHARE_MEDIA.QZONE, iCallbackCodeInfo);
        } else if (i == 5) {
            new com.up366.mobile.common.utils.ShareUtils(this.context).shareURL(str, str2, str3, uMImage, com.umeng.socialize.bean.SHARE_MEDIA.ALIPAY, iCallbackCodeInfo);
        } else {
            new com.up366.mobile.common.utils.ShareUtils(this.context).shareURL(str, str2, str3, uMImage, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN, iCallbackCodeInfo);
        }
    }
}
