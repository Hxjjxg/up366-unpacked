package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class EventScanPaperGeneralSubmitData {
    private java.lang.String curWebViewId;
    private com.alibaba.fastjson.JSONObject submitData;

    public EventScanPaperGeneralSubmitData(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str) {
        this.submitData = jSONObject;
        this.curWebViewId = str;
    }

    public com.alibaba.fastjson.JSONObject getSubmitData() {
        return this.submitData;
    }

    public java.lang.String getCurWebViewId() {
        return this.curWebViewId;
    }
}
