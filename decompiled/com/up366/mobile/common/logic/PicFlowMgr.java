package com.up366.mobile.common.logic;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PicFlowMgr {
    public com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner>> fetchRollingPictureSync() throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.appBanner).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.PicFlowMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                map.put("clientType", 1);
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.common.logic.PicFlowMgr$$ExternalSyntheticLambda1
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.common.logic.model.AppConfigBanner.class);
            }
        }));
    }
}
