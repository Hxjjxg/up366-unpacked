package com.up366.qmui.widget.pullRefreshLayout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUICenterGravityRefreshOffsetCalculator implements com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.RefreshOffsetCalculator {
    @Override // com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.RefreshOffsetCalculator
    public int calculateRefreshOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        return i4 < i3 ? i4 - i3 : (i4 - i3) / 2;
    }
}
