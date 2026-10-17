package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MessageInfoLoad {
    public final com.up366.common.http.Response resp;
    public final com.up366.mobile.common.logic.model.Messages result;

    public MessageInfoLoad(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.Messages messages) {
        this.resp = response;
        this.result = messages;
    }

    public MessageInfoLoad(com.up366.mobile.common.logic.model.Messages messages) {
        this.resp = null;
        this.result = messages;
    }
}
