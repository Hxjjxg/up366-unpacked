package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RefreshUserInfo {
    private final com.up366.common.http.Response resp;
    private final com.up366.mobile.common.logic.user.UserInfo userInfo;

    public RefreshUserInfo(com.up366.common.http.Response response, com.up366.mobile.common.logic.user.UserInfo userInfo) {
        this.resp = response;
        this.userInfo = userInfo;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }

    public com.up366.mobile.common.logic.user.UserInfo getUserInfo() {
        return this.userInfo;
    }
}
