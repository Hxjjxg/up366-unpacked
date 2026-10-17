package com.up366.mobile.wxapi;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class WXEntryActivity extends com.umeng.socialize.weixin.view.WXCallbackActivity {
    public void onReq(com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        super.onReq(baseReq);
        com.up366.common.log.Logger.info(" onReq  C " + com.alibaba.fastjson.JSON.toJSONString(baseReq));
        if (4 == baseReq.getType()) {
            goToShowMsg((com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req) baseReq);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void goToShowMsg(com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req req) {
        com.tencent.mm.opensdk.modelmsg.WXAppExtendObject wXAppExtendObject = req.message.mediaObject;
        if (!com.up366.mobile.common.utils.PreferenceUtils.getBoolean("hasAgreePermission", false)) {
            startActivity(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.SplashActivity.class));
            finish();
            return;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(wXAppExtendObject.extInfo) || "undefined".equals(wXAppExtendObject.extInfo)) {
            startActivity(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) (com.up366.mobile.common.logic.Auth.isAuth() ? com.up366.mobile.main.MainActivity.class : com.up366.mobile.user.account.login.AccountLoginActivity.class)));
            finish();
            return;
        }
        java.lang.String str = "";
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(java.net.URLDecoder.decode(wXAppExtendObject.extInfo).replace("d={", "{"));
            str = "up366mobile://new?uid=" + object.get("uid") + "&cid=" + object.get("cid") + "&jid=" + object.get("jid") + "&ttgt=" + object.get("ttgt");
            com.up366.common.log.Logger.info("obj.extInfo  :" + wXAppExtendObject.extInfo);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("extInfo : " + wXAppExtendObject.extInfo + "，skip parse object error " + e.getMessage(), e);
        }
        com.up366.mobile.jump.JumpProxyActivity.skipByWx(this, str);
        finish();
    }
}
