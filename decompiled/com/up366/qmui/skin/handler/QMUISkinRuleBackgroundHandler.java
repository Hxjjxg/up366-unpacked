package com.up366.qmui.skin.handler;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinRuleBackgroundHandler implements com.up366.qmui.skin.handler.IQMUISkinRuleHandler {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.qmui.skin.handler.IQMUISkinRuleHandler
    public void handle(com.up366.qmui.skin.QMUISkinManager qMUISkinManager, android.view.View view, android.content.res.Resources.Theme theme, java.lang.String str, int i) {
        if (view instanceof com.up366.qmui.widget.roundwidget.QMUIRoundButton) {
            ((com.up366.qmui.widget.roundwidget.QMUIRoundButton) view).setBgData(com.up366.qmui.util.QMUIResHelper.getAttrColorStateList(view.getContext(), theme, i));
            return;
        }
        if (view instanceof com.up366.qmui.widget.QMUIProgressBar) {
            view.setBackgroundColor(com.up366.qmui.util.QMUIResHelper.getAttrColor(theme, i));
        } else if (view instanceof com.up366.qmui.widget.QMUISlider) {
            ((com.up366.qmui.widget.QMUISlider) view).setBarNormalColor(com.up366.qmui.util.QMUIResHelper.getAttrColor(theme, i));
        } else {
            com.up366.qmui.util.QMUIViewHelper.setBackgroundKeepingPadding(view, com.up366.qmui.util.QMUIResHelper.getAttrDrawable(view.getContext(), theme, i));
        }
    }
}
