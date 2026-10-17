package com.up366.qmui.skin.handler;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinRuleSrcHandler extends com.up366.qmui.skin.handler.QMUISkinRuleDrawableHandler {
    @Override // com.up366.qmui.skin.handler.QMUISkinRuleDrawableHandler
    protected void handle(android.view.View view, java.lang.String str, android.graphics.drawable.Drawable drawable) {
        if (view instanceof android.widget.ImageView) {
            ((android.widget.ImageView) view).setImageDrawable(drawable);
        } else if (view instanceof android.widget.CompoundButton) {
            ((android.widget.CompoundButton) view).setButtonDrawable(drawable);
        } else {
            com.up366.qmui.skin.QMUISkinHelper.warnRuleNotSupport(view, str);
        }
    }
}
