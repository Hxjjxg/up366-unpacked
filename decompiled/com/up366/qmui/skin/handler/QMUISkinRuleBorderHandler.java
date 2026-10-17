package com.up366.qmui.skin.handler;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinRuleBorderHandler extends com.up366.qmui.skin.handler.QMUISkinRuleColorStateListHandler {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(android.view.View view, java.lang.String str, android.content.res.ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        if (view instanceof com.up366.qmui.layout.IQMUILayout) {
            ((com.up366.qmui.layout.IQMUILayout) view).setBorderColor(colorStateList.getDefaultColor());
            return;
        }
        if (view instanceof com.up366.qmui.widget.QMUIRadiusImageView) {
            ((com.up366.qmui.widget.QMUIRadiusImageView) view).setBorderColor(colorStateList.getDefaultColor());
            return;
        }
        if (view instanceof com.up366.qmui.widget.roundwidget.QMUIRoundButton) {
            ((com.up366.qmui.widget.roundwidget.QMUIRoundButton) view).setStrokeColors(colorStateList);
        } else if (view instanceof com.up366.qmui.widget.QMUISlider.DefaultThumbView) {
            ((com.up366.qmui.widget.QMUISlider.DefaultThumbView) view).setBorderColor(colorStateList.getDefaultColor());
        } else {
            com.up366.qmui.skin.QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
