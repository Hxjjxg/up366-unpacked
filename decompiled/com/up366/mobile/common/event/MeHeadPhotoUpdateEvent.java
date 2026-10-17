package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MeHeadPhotoUpdateEvent {
    public final java.lang.String photoUrl;
    public final com.up366.common.http.Response response;

    public MeHeadPhotoUpdateEvent(com.up366.common.http.Response response, java.lang.String str) {
        this.response = response;
        this.photoUrl = str;
    }
}
