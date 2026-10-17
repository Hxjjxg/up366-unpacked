package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrongNoteRankOrderRefresh {
    public static final java.lang.String RANK_TYPE_KILLED_COUNT = "killedCount";
    public static final java.lang.String RANK_TYPE_NAME = "realname";
    public static final java.lang.String RANK_TYPE_WRONG_COUNT = "wrongCount";
    public static final java.lang.String TANK_TYPE_TODAY_KILLED_COUNT = "recentKilledCount";
    private boolean orderDesc;
    private java.lang.String rankType;

    public WrongNoteRankOrderRefresh(java.lang.String str, boolean z) {
        this.rankType = str;
        this.orderDesc = z;
    }

    public java.lang.String getRankType() {
        return this.rankType;
    }

    public void setRankType(java.lang.String str) {
        this.rankType = str;
    }

    public boolean isOrderDesc() {
        return this.orderDesc;
    }

    public void setOrderDesc(boolean z) {
        this.orderDesc = z;
    }
}
