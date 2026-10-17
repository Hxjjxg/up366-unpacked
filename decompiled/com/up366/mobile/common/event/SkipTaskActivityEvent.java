package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SkipTaskActivityEvent {
    public int type;

    public SkipTaskActivityEvent(int i) {
        this.type = i;
    }

    public boolean isCurrent() {
        return this.type == 0;
    }
}
