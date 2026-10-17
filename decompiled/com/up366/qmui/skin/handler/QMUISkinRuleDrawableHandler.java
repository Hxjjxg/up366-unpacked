package com.up366.qmui.skin.handler;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class QMUISkinRuleDrawableHandler implements com.up366.qmui.skin.handler.IQMUISkinRuleHandler {
    protected abstract void handle(android.view.View view, java.lang.String str, android.graphics.drawable.Drawable drawable);

    @Override // com.up366.qmui.skin.handler.IQMUISkinRuleHandler
    public final void handle(com.up366.qmui.skin.QMUISkinManager qMUISkinManager, android.view.View view, android.content.res.Resources.Theme theme, java.lang.String str, int i) {
        handle(view, str, com.up366.qmui.util.QMUIResHelper.getAttrDrawable(view.getContext(), theme, i));
    }
}
