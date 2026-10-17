package com.up366.qmui.skin.handler;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinRuleSeparatorHandler extends com.up366.qmui.skin.handler.QMUISkinRuleColorHandler {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.qmui.skin.handler.QMUISkinRuleColorHandler
    protected void handle(android.view.View view, java.lang.String str, int i) {
        if (view instanceof com.up366.qmui.layout.IQMUILayout) {
            if (com.up366.qmui.skin.QMUISkinValueBuilder.TOP_SEPARATOR.equals(str)) {
                ((com.up366.qmui.layout.IQMUILayout) view).updateTopSeparatorColor(i);
                return;
            }
            if (com.up366.qmui.skin.QMUISkinValueBuilder.BOTTOM_SEPARATOR.equals(str)) {
                ((com.up366.qmui.layout.IQMUILayout) view).updateBottomSeparatorColor(i);
                return;
            } else if (com.up366.qmui.skin.QMUISkinValueBuilder.LEFT_SEPARATOR.equals(str)) {
                ((com.up366.qmui.layout.IQMUILayout) view).updateLeftSeparatorColor(i);
                return;
            } else {
                if (com.up366.qmui.skin.QMUISkinValueBuilder.RIGHT_SEPARATOR.equals(str)) {
                    ((com.up366.qmui.layout.IQMUILayout) view).updateRightSeparatorColor(i);
                    return;
                }
                return;
            }
        }
        com.up366.qmui.skin.QMUISkinHelper.warnRuleNotSupport(view, str);
    }
}
