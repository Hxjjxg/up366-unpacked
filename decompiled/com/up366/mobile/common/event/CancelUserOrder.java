package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CancelUserOrder {
    public final java.util.List<com.up366.mobile.common.logic.model.UserOrder> orderList;
    public final com.up366.common.http.Response resp;

    public CancelUserOrder(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.UserOrder> list) {
        this.resp = response;
        this.orderList = list;
    }
}
