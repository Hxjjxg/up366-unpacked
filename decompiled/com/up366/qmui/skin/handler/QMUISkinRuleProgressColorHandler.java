package com.up366.qmui.skin.handler;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinRuleProgressColorHandler extends com.up366.qmui.skin.handler.QMUISkinRuleColorHandler {
    @Override // com.up366.qmui.skin.handler.QMUISkinRuleColorHandler
    protected void handle(android.view.View view, java.lang.String str, int i) {
        if (view instanceof com.up366.qmui.widget.QMUIProgressBar) {
            ((com.up366.qmui.widget.QMUIProgressBar) view).setProgressColor(i);
        } else if (view instanceof com.up366.qmui.widget.QMUISlider) {
            ((com.up366.qmui.widget.QMUISlider) view).setBarProgressColor(i);
        } else {
            com.up366.qmui.skin.QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
