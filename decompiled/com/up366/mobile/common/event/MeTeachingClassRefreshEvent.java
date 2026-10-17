package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MeTeachingClassRefreshEvent {
    private final java.util.List<com.up366.mobile.user.setting.MeTeachingClass> datas;
    private final com.up366.common.http.Response resp;

    public MeTeachingClassRefreshEvent(java.util.List<com.up366.mobile.user.setting.MeTeachingClass> list) {
        this.resp = null;
        this.datas = list;
    }

    public MeTeachingClassRefreshEvent(com.up366.common.http.Response response, java.util.List<com.up366.mobile.user.setting.MeTeachingClass> list) {
        this.resp = response;
        this.datas = list;
    }

    public java.util.List<com.up366.mobile.user.setting.MeTeachingClass> getDatas() {
        return this.datas;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
