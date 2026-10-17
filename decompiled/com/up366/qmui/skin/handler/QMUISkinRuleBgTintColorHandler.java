package com.up366.qmui.skin.handler;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinRuleBgTintColorHandler extends com.up366.qmui.skin.handler.QMUISkinRuleColorStateListHandler {
    @Override // com.up366.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(android.view.View view, java.lang.String str, android.content.res.ColorStateList colorStateList) {
        if (view instanceof androidx.core.view.TintableBackgroundView) {
            ((androidx.core.view.TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        } else {
            com.up366.qmui.skin.QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
