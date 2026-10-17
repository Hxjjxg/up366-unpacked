package com.up366.qmui.skin.handler;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinRuleTintColorHandler extends com.up366.qmui.skin.handler.QMUISkinRuleColorStateListHandler {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.qmui.skin.handler.QMUISkinRuleColorStateListHandler
    protected void handle(android.view.View view, java.lang.String str, android.content.res.ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        if (view instanceof com.up366.qmui.widget.QMUILoadingView) {
            ((com.up366.qmui.widget.QMUILoadingView) view).setColor(colorStateList.getDefaultColor());
            return;
        }
        if (view instanceof com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.RefreshView) {
            ((com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.RefreshView) view).setColorSchemeColors(colorStateList.getDefaultColor());
            return;
        }
        if (view instanceof android.widget.ImageView) {
            androidx.core.widget.ImageViewCompat.setImageTintList((android.widget.ImageView) view, colorStateList);
        } else if (view instanceof android.widget.CompoundButton) {
            androidx.core.widget.CompoundButtonCompat.setButtonTintList((android.widget.CompoundButton) view, colorStateList);
        } else {
            com.up366.qmui.skin.QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
