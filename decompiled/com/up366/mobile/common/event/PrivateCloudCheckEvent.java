package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PrivateCloudCheckEvent {
    public static final int STATE_CHECKING = 1;
    public static final int STATE_ERROR = -1;
    public static final int STATE_NULL = -2;
    public static final int STATE_OK = 0;
    private java.lang.String ip;
    private int state;

    public int getState() {
        return this.state;
    }

    public com.up366.mobile.common.event.PrivateCloudCheckEvent setState(int i) {
        this.state = i;
        return this;
    }

    public java.lang.String getIp() {
        return this.ip;
    }

    public com.up366.mobile.common.event.PrivateCloudCheckEvent setIp(java.lang.String str) {
        this.ip = str;
        return this;
    }
}
