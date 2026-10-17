package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ShareHelper {
    private final android.app.Activity context;

    public ShareHelper(android.app.Activity activity) {
        this.context = activity;
    }

    public void share(final java.lang.String str, final com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        java.lang.String strCompatPermission = com.up366.mobile.common.utils.PermissionUtils.compatPermission();
        android.app.Activity activity = this.context;
        com.up366.mobile.common.utils.PermissionUtils.checkPermission(activity, new java.lang.String[]{"存储权限"}, new java.lang.String[]{strCompatPermission}, activity.getString(com.up366.mobile.R.string.permission_storage), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.helper.ShareHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str2) {
                this.f$0.lambda$share$0(str, studyPageWebView, i, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$share$0(java.lang.String str, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, int i, java.lang.String str2) {
        if (i == 0) {
            shareInternal(str, studyPageWebView);
        } else {
            postCallback(-1, "没有存储权限", studyPageWebView);
        }
    }

    private void shareInternal(final java.lang.String str, final com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.ShareHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$shareInternal$4(str, studyPageWebView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareInternal$4(java.lang.String str, final com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) throws java.lang.Exception {
        if (com.alibaba.fastjson.JSON.parseObject(str).getIntValue("shareType") == 2) {
            studyPageWebView.captureAsync(new com.up366.mobile.book.webview.CaptureHelper.IOnCaptureListener() { // from class: com.up366.mobile.book.helper.ShareHelper$$ExternalSyntheticLambda3
                @Override // com.up366.mobile.book.webview.CaptureHelper.IOnCaptureListener
                public final void onCapture(android.graphics.Bitmap bitmap) {
                    this.f$0.lambda$shareInternal$2(studyPageWebView, bitmap);
                }
            });
        } else {
            share(str, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.helper.ShareHelper$$ExternalSyntheticLambda4
                @Override // com.up366.common.callback.ICallbackCodeInfo
                public final void onResult(int i, java.lang.String str2) {
                    this.f$0.lambda$shareInternal$3(studyPageWebView, i, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareInternal$2(final com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, final android.graphics.Bitmap bitmap) {
        new com.up366.mobile.common.dialog.ShareDialog(this.context).shareImage(bitmap, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.helper.ShareHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                this.f$0.lambda$shareInternal$1(bitmap, studyPageWebView, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareInternal$1(android.graphics.Bitmap bitmap, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, int i, java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ShareHelper - share - onResult - code = [" + i + "], info = [" + str + "]");
        bitmap.recycle();
        if (com.up366.common.FileUtilsUp.isFileExists(str)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.context, "保存成功");
        }
        if (i != 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(studyPageWebView, str);
        }
        postCallback(i, str, studyPageWebView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareInternal$3(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, int i, java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ShareHelper - share - onResult - code = [" + i + "], info = [" + str + "]");
        if (i != 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(studyPageWebView, str);
        }
        postCallback(i, str, studyPageWebView);
    }

    private void postCallback(int i, java.lang.String str, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("msg", str);
        if (i == -1) {
            jSONObject.put("code", -4);
        } else if (i == 100) {
            jSONObject.put("code", -1);
        } else {
            jSONObject.put("code", java.lang.Integer.valueOf(i));
        }
        studyPageWebView.callJSMethod("onShareFinished(%s)", jSONObject.toJSONString());
    }

    public void share(java.lang.String str, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String serverUrl = com.up366.common.global.GB.get().getServerUrl(object.getString("imgUrl"));
        com.umeng.socialize.media.UMImage uMImage = !com.up366.common.StringUtils.isEmptyOrNull(serverUrl) ? new com.umeng.socialize.media.UMImage(this.context, serverUrl) : null;
        java.lang.String serverUrl2 = com.up366.common.global.GB.get().getServerUrl(object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL));
        java.lang.String string = object.getString("title");
        java.lang.String string2 = object.getString("desc");
        int intValue = object.getIntValue("type");
        if (intValue == 1) {
            new com.up366.mobile.common.utils.ShareUtils(this.context).shareURL(serverUrl2, string, string2, uMImage, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN, iCallbackCodeInfo);
            return;
        }
        if (intValue == 2) {
            new com.up366.mobile.common.utils.ShareUtils(this.context).shareURL(serverUrl2, string, string2, uMImage, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN_CIRCLE, iCallbackCodeInfo);
            return;
        }
        if (intValue == 3) {
            new com.up366.mobile.common.utils.ShareUtils(this.context).shareURL(serverUrl2, string, string2, uMImage, com.umeng.socialize.bean.SHARE_MEDIA.QQ, iCallbackCodeInfo);
        } else if (intValue == 4) {
            new com.up366.mobile.common.utils.ShareUtils(this.context).shareURL(serverUrl2, string, string2, uMImage, com.umeng.socialize.bean.SHARE_MEDIA.QZONE, iCallbackCodeInfo);
        } else {
            new com.up366.mobile.common.utils.ShareUtils(this.context).shareURL(serverUrl2, string, string2, uMImage, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN, iCallbackCodeInfo);
        }
    }
}
