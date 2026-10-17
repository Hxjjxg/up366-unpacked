package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface IQMUIContinuousNestedScrollCommon {
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;

    public interface OnScrollNotifier {
        void notify(int i, int i2);

        void onScrollStateChange(android.view.View view, int i);
    }

    void injectScrollNotifier(com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier);

    void restoreScrollInfo(android.os.Bundle bundle);

    void saveScrollInfo(android.os.Bundle bundle);
}
