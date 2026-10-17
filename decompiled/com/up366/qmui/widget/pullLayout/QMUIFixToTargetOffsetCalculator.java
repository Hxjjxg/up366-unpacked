package com.up366.qmui.widget.pullLayout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIFixToTargetOffsetCalculator implements com.up366.qmui.widget.pullLayout.QMUIPullLayout.ActionViewOffsetCalculator {
    @Override // com.up366.qmui.widget.pullLayout.QMUIPullLayout.ActionViewOffsetCalculator
    public int calculateOffset(com.up366.qmui.widget.pullLayout.QMUIPullLayout.PullAction pullAction, int i) {
        int actionInitOffset;
        if (i < pullAction.getTargetTriggerOffset()) {
            actionInitOffset = pullAction.getActionInitOffset();
        } else {
            i = pullAction.getTargetTriggerOffset();
            actionInitOffset = pullAction.getActionInitOffset();
        }
        return i + actionInitOffset;
    }
}
