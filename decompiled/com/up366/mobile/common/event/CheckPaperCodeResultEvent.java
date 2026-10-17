package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CheckPaperCodeResultEvent {
    public java.lang.String batchId;
    public java.lang.String id;
    public int isOk;

    public CheckPaperCodeResultEvent(com.alibaba.fastjson.JSONObject jSONObject) {
        this.batchId = jSONObject.getString("batchId");
        this.isOk = jSONObject.getIntValue("isOk");
        this.id = jSONObject.getString(com.igexin.push.core.b.C);
    }
}
