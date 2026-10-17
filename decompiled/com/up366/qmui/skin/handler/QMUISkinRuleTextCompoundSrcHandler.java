package com.up366.qmui.skin.handler;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinRuleTextCompoundSrcHandler extends com.up366.qmui.skin.handler.QMUISkinRuleDrawableHandler {
    @Override // com.up366.qmui.skin.handler.QMUISkinRuleDrawableHandler
    protected void handle(android.view.View view, java.lang.String str, android.graphics.drawable.Drawable drawable) {
        if (view instanceof android.widget.TextView) {
            android.widget.TextView textView = (android.widget.TextView) view;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            android.graphics.drawable.Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COMPOUND_LEFT_SRC.equals(str)) {
                compoundDrawables[0] = drawable;
            } else if (com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COMPOUND_TOP_SRC.equals(str)) {
                compoundDrawables[1] = drawable;
            } else if (com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COMPOUND_RIGHT_SRC.equals(str)) {
                compoundDrawables[2] = drawable;
            } else if (com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COMPOUND_BOTTOM_SRC.equals(str)) {
                compoundDrawables[3] = drawable;
            }
            textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
            return;
        }
        com.up366.qmui.skin.QMUISkinHelper.warnRuleNotSupport(view, str);
    }
}
