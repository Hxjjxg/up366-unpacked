package com.up366.qmui.skin.handler;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinRuleHintColorHandler extends com.up366.qmui.skin.handler.QMUISkinRuleColorStateListHandler {
    @Override // com.up366.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(android.view.View view, java.lang.String str, android.content.res.ColorStateList colorStateList) {
        if (view instanceof android.widget.TextView) {
            ((android.widget.TextView) view).setHintTextColor(colorStateList);
        } else if (view instanceof com.google.android.material.textfield.TextInputLayout) {
            ((com.google.android.material.textfield.TextInputLayout) view).setHintTextColor(colorStateList);
        } else {
            com.up366.qmui.skin.QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
