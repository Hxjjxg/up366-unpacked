package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class HeadPhotoListEvent {
    public final java.util.List<com.up366.mobile.common.logic.model.UserPhoto> photos;
    public final com.up366.common.http.Response resp;

    public HeadPhotoListEvent(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.UserPhoto> list) {
        this.resp = response;
        this.photos = list;
    }
}
