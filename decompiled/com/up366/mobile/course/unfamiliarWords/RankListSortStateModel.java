package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class RankListSortStateModel {
    public static final java.lang.String TYPE_HAS_KILLED_COUNT = "killedCount";
    public static final java.lang.String TYPE_REMAIN_WORD_COUNT = "wordCount";
    public static final java.lang.String TYPE_TODAY_KILLED_COUNT = "killedCountLately";
    private boolean isOrderDesc;
    private java.lang.String orderField;

    public RankListSortStateModel(boolean z, java.lang.String str) {
        this.isOrderDesc = z;
        this.orderField = str;
    }

    public boolean isOrderDesc() {
        return this.isOrderDesc;
    }

    public void setOrderDesc(boolean z) {
        this.isOrderDesc = z;
    }

    public java.lang.String getOrderField() {
        return this.orderField;
    }

    public void setOrderField(java.lang.String str) {
        this.orderField = str;
    }
}
