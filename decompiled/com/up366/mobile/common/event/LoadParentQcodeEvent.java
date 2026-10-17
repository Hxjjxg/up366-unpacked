package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LoadParentQcodeEvent {
    public final com.up366.common.http.Response resp;
    public final java.util.List<com.up366.mobile.common.logic.model.ParentQcodeResponse> result;

    public LoadParentQcodeEvent(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.ParentQcodeResponse> list) {
        this.resp = response;
        this.result = list;
    }
}
