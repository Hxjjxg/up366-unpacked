package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ShowJumpErrorInfoEvent {
    public static final int TYPE_NOT_ALLOW_OTHER_URL = 1;
    public final java.lang.String errorInfo;
    public int type;

    public ShowJumpErrorInfoEvent(int i, java.lang.String str) {
        this.type = i;
        this.errorInfo = str;
    }
}
