package com.up366.mobile.apshare;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ShareEntryActivity extends com.umeng.socialize.media.ShareCallbackActivity {
    public void onReq(com.alipay.share.sdk.openapi.BaseReq baseReq) {
    }

    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResp(com.alipay.share.sdk.openapi.BaseResp baseResp) {
        int i = baseResp.errCode;
        if (i == -2) {
            com.up366.medialibrary.common.utils.ToastUtils.s(this, "取消分享");
        } else if (i == 0) {
            com.up366.medialibrary.common.utils.ToastUtils.s(this, "分享成功");
        } else {
            com.up366.medialibrary.common.utils.ToastUtils.s(this, "分享失败：" + baseResp.errStr);
        }
        finish();
    }
}
