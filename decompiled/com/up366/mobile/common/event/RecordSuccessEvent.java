package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RecordSuccessEvent {
    public static final int TYPE_RECORD = 1;
    public static final int TYPE_RE_RECORD = 2;
    private int type;

    public RecordSuccessEvent() {
    }

    public RecordSuccessEvent(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
