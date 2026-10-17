package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface IQMUIContinuousNestedBottomView extends com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon {
    public static final int HEIGHT_IS_ENOUGH_TO_SCROLL = -1;

    void consumeScroll(int i);

    int getContentHeight();

    int getCurrentScroll();

    int getScrollOffsetRange();

    void smoothScrollYBy(int i, int i2);

    void stopScroll();
}
