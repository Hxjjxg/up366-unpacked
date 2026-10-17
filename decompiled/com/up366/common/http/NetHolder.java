package com.up366.common.http;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class NetHolder<T> {
    public T info;
    public com.up366.common.http.Response resp;

    public void initWith(com.up366.common.http.Response response, T t) {
        this.resp = response;
        this.info = t;
    }
}
