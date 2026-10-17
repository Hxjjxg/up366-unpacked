package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OnBottomTabSelected {
    public static final int ASSISTANT = 4;
    public static final int COURSE = 2;
    public static final int SCHOOL_HOUSE = 5;
    public static final int USER = 3;
    private final int type;

    public OnBottomTabSelected(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}
