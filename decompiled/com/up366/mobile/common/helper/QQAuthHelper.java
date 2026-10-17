package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class QQAuthHelper {
    public void getOpenId(android.app.Activity activity, com.up366.common.callback.ICallbackCodeInfoObj<java.lang.String[]> iCallbackCodeInfoObj) {
        com.umeng.socialize.UMShareConfig uMShareConfig = new com.umeng.socialize.UMShareConfig();
        uMShareConfig.isNeedAuthOnGetUserInfo(true);
        com.umeng.socialize.UMShareAPI.get(activity).setShareConfig(uMShareConfig);
        if (!com.umeng.socialize.UMShareAPI.get(activity).isInstall(activity, com.umeng.socialize.bean.SHARE_MEDIA.QQ)) {
            iCallbackCodeInfoObj.onResult(-1, "你未安装QQ", null);
        } else if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            iCallbackCodeInfoObj.onResult(-1, "你未安装QQ", null);
        } else {
            com.umeng.socialize.UMShareAPI.get(activity).getPlatformInfo(activity, com.umeng.socialize.bean.SHARE_MEDIA.QQ, new com.up366.mobile.common.helper.QQAuthHelper.AnonymousClass1(iCallbackCodeInfoObj));
        }
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.helper.QQAuthHelper$1, reason: invalid class name */
    class AnonymousClass1 implements com.umeng.socialize.UMAuthListener {
        final /* synthetic */ com.up366.common.callback.ICallbackCodeInfoObj val$callback;

        public void onStart(com.umeng.socialize.bean.SHARE_MEDIA share_media) {
        }

        AnonymousClass1(com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) {
            this.val$callback = iCallbackCodeInfoObj;
        }

        public void onComplete(com.umeng.socialize.bean.SHARE_MEDIA share_media, int i, java.util.Map<java.lang.String, java.lang.String> map) {
            map.get("openid");
            final java.lang.String str = map.get("accessToken");
            com.up366.mobile.book.helper.DownloadStringHelper downloadStringHelper = new com.up366.mobile.book.helper.DownloadStringHelper();
            final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj = this.val$callback;
            downloadStringHelper.load("https://graph.qq.com/oauth2.0/me?access_token=" + str + "&unionid=1", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.helper.QQAuthHelper$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.callback.ICallbackCodeInfo
                public final void onResult(int i2, java.lang.String str2) {
                    com.up366.mobile.common.helper.QQAuthHelper.AnonymousClass1.lambda$onComplete$0(iCallbackCodeInfoObj, str, i2, str2);
                }
            });
        }

        static /* synthetic */ void lambda$onComplete$0(com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, java.lang.String str, int i, java.lang.String str2) {
            if (i != 0) {
                com.up366.common.log.Logger.info("TAG - QQAuthHelper - onResult - code = [" + i + "], info = [" + str2 + "]");
                iCallbackCodeInfoObj.onResult(-4, "unionid获取失败", null);
                return;
            }
            try {
                iCallbackCodeInfoObj.onResult(0, "", new java.lang.String[]{com.alibaba.fastjson.JSON.parseObject(str2.substring(str2.indexOf("{"), str2.lastIndexOf("}") + 1)).getString("unionid"), str});
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("TAG - QQAuthHelper - onComplete - ", e);
                iCallbackCodeInfoObj.onResult(-5, "unionid获取失败", null);
            }
        }

        public void onError(com.umeng.socialize.bean.SHARE_MEDIA share_media, int i, java.lang.Throwable th) {
            if (th.getMessage().contains("2008")) {
                this.val$callback.onResult(-1, "你未安装QQ", null);
            } else {
                this.val$callback.onResult(-2, th.getMessage(), null);
            }
        }

        public void onCancel(com.umeng.socialize.bean.SHARE_MEDIA share_media, int i) {
            this.val$callback.onResult(-3, "取消操作", null);
        }
    }
}
