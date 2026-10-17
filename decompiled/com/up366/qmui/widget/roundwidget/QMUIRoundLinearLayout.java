package com.up366.qmui.widget.roundwidget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIRoundLinearLayout extends android.widget.LinearLayout {
    public QMUIRoundLinearLayout(android.content.Context context) {
        super(context);
        init(context, null, 0);
    }

    public QMUIRoundLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUIButtonStyle);
    }

    public QMUIRoundLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        com.up366.qmui.util.QMUIViewHelper.setBackgroundKeepingPadding(this, com.up366.qmui.widget.roundwidget.QMUIRoundButtonDrawable.fromAttributeSet(context, attributeSet, 0));
    }
}
