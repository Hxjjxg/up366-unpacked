package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MessageLoad {
    public final com.up366.common.http.Response resp;
    public final java.util.List<com.up366.mobile.common.logic.model.Messages> result;

    public MessageLoad(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.Messages> list) {
        this.resp = response;
        this.result = list;
    }

    public MessageLoad(java.util.List<com.up366.mobile.common.logic.model.Messages> list) {
        this.resp = null;
        this.result = list;
    }
}
