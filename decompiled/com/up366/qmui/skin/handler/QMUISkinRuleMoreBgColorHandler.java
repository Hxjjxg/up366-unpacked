package com.up366.qmui.skin.handler;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinRuleMoreBgColorHandler extends com.up366.qmui.skin.handler.QMUISkinRuleColorStateListHandler {
    @Override // com.up366.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(android.view.View view, java.lang.String str, android.content.res.ColorStateList colorStateList) {
        if (view instanceof com.up366.qmui.qqface.QMUIQQFaceView) {
            ((com.up366.qmui.qqface.QMUIQQFaceView) view).setMoreActionBgColor(colorStateList);
        } else {
            com.up366.qmui.skin.QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
