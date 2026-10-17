package com.up366.qmui.widget.pullLayout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIAlwaysFollowOffsetCalculator implements com.up366.qmui.widget.pullLayout.QMUIPullLayout.ActionViewOffsetCalculator {
    @Override // com.up366.qmui.widget.pullLayout.QMUIPullLayout.ActionViewOffsetCalculator
    public int calculateOffset(com.up366.qmui.widget.pullLayout.QMUIPullLayout.PullAction pullAction, int i) {
        return i + pullAction.getActionInitOffset();
    }
}
