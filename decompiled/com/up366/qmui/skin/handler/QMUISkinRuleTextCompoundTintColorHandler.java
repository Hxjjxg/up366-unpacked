package com.up366.qmui.skin.handler;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinRuleTextCompoundTintColorHandler extends com.up366.qmui.skin.handler.QMUISkinRuleColorStateListHandler {
    @Override // com.up366.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(android.view.View view, java.lang.String str, android.content.res.ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        if (view instanceof android.widget.TextView) {
            ((android.widget.TextView) view).setCompoundDrawableTintList(colorStateList);
        } else {
            com.up366.qmui.skin.QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
