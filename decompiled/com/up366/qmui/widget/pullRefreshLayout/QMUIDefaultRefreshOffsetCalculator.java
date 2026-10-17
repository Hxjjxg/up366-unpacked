package com.up366.qmui.widget.pullRefreshLayout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIDefaultRefreshOffsetCalculator implements com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.RefreshOffsetCalculator {
    @Override // com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.RefreshOffsetCalculator
    public int calculateRefreshOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i4 >= i6) {
            return i2;
        }
        if (i4 <= i5) {
            return i;
        }
        return (int) (i + ((((i4 - i5) * 1.0f) / (i6 - i5)) * (i2 - i)));
    }
}
