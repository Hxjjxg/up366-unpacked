package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIContinuousNestedTopLinearLayout extends com.up366.qmui.layout.QMUILinearLayout implements com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView {
    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int consumeScroll(int i) {
        return i;
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int getCurrentScroll() {
        return 0;
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int getScrollOffsetRange() {
        return 0;
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void injectScrollNotifier(com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void restoreScrollInfo(android.os.Bundle bundle) {
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void saveScrollInfo(android.os.Bundle bundle) {
    }

    public QMUIContinuousNestedTopLinearLayout(android.content.Context context) {
        super(context);
    }

    public QMUIContinuousNestedTopLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIContinuousNestedTopLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
