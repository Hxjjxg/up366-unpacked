package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WeixinAuthHelper {
    public void getOpenId(android.app.Activity activity, com.up366.common.callback.ICallbackCodeInfoObj<java.lang.String[]> iCallbackCodeInfoObj) {
        getOpenId(0, activity, iCallbackCodeInfoObj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOpenId(int i, android.app.Activity activity, com.up366.common.callback.ICallbackCodeInfoObj<java.lang.String[]> iCallbackCodeInfoObj) {
        com.umeng.socialize.UMShareConfig uMShareConfig = new com.umeng.socialize.UMShareConfig();
        uMShareConfig.isNeedAuthOnGetUserInfo(true);
        com.umeng.socialize.UMShareAPI.get(activity).setShareConfig(uMShareConfig);
        if (!com.umeng.socialize.UMShareAPI.get(activity).isInstall(activity, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN)) {
            iCallbackCodeInfoObj.onResult(-1, "你未安装微信", null);
        } else {
            com.umeng.socialize.UMShareAPI.get(activity).getPlatformInfo(activity, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN, new com.up366.mobile.common.helper.WeixinAuthHelper.AnonymousClass1(iCallbackCodeInfoObj, i, activity));
        }
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.helper.WeixinAuthHelper$1, reason: invalid class name */
    class AnonymousClass1 implements com.umeng.socialize.UMAuthListener {
        final /* synthetic */ android.app.Activity val$activity;
        final /* synthetic */ com.up366.common.callback.ICallbackCodeInfoObj val$callback;
        final /* synthetic */ int val$tryCount;

        AnonymousClass1(com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, int i, android.app.Activity activity) {
            this.val$callback = iCallbackCodeInfoObj;
            this.val$tryCount = i;
            this.val$activity = activity;
        }

        public void onStart(com.umeng.socialize.bean.SHARE_MEDIA share_media) {
            com.up366.common.log.Logger.info("TAG - WeixinAuthHelper - onStart - ");
        }

        public void onComplete(com.umeng.socialize.bean.SHARE_MEDIA share_media, int i, java.util.Map<java.lang.String, java.lang.String> map) {
            this.val$callback.onResult(0, "", new java.lang.String[]{map.get("unionid"), map.get("accessToken")});
            if (this.val$tryCount == 1) {
                com.up366.mobile.common.onlinelog.OpLog.report("wx_auth_get_open_id_retry_success", "success");
            }
            com.up366.common.log.Logger.info("TAG - WeixinAuthHelper - onComplete - " + map);
        }

        public void onError(com.umeng.socialize.bean.SHARE_MEDIA share_media, int i, java.lang.Throwable th) {
            com.up366.common.log.Logger.error("TAG - WeixinAuthHelper - onError - ", th);
            java.lang.String message = th.getMessage();
            if (message.contains("2008")) {
                this.val$callback.onResult(-1, "你未安装微信", null);
                return;
            }
            if (this.val$tryCount < 1 && message.contains("2004")) {
                com.up366.common.log.Logger.warn("TAG - WeixinAuthHelper - onError - retry...");
                final int i2 = this.val$tryCount;
                final android.app.Activity activity = this.val$activity;
                final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj = this.val$callback;
                com.up366.common.task.TaskUtils.postMainTaskDelay(500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.WeixinAuthHelper$1$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$onError$0(i2, activity, iCallbackCodeInfoObj);
                    }
                });
                return;
            }
            if (message.contains("2004")) {
                this.val$callback.onResult(-2, "获取用户资料失败", null);
                com.up366.mobile.common.onlinelog.OpLog.report("wx_auth_get_open_id_retry_error", "error", th);
            } else if (message.contains("2002")) {
                this.val$callback.onResult(-4, "授权失败", null);
            } else {
                this.val$callback.onResult(-2, message, null);
                com.up366.mobile.common.onlinelog.OpLog.report("wx_auth_get_open_id_error", message, th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$0(int i, android.app.Activity activity, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) throws java.lang.Exception {
            com.up366.mobile.common.helper.WeixinAuthHelper.this.getOpenId(i + 1, activity, iCallbackCodeInfoObj);
        }

        public void onCancel(com.umeng.socialize.bean.SHARE_MEDIA share_media, int i) {
            com.up366.common.log.Logger.info("TAG - WeixinAuthHelper - onCancel - " + i);
            this.val$callback.onResult(-3, "取消操作", null);
        }
    }
}
