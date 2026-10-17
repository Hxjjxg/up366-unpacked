package com.up366.qmui.widget.roundwidget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIRoundButton extends com.up366.qmui.alpha.QMUIAlphaButton implements com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider {
    private static androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> sDefaultSkinAttrs;
    private com.up366.qmui.widget.roundwidget.QMUIRoundButtonDrawable mRoundBg;

    static {
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap = new androidx.collection.SimpleArrayMap<>(3);
        sDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put("background", java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_round_btn_bg_color));
        sDefaultSkinAttrs.put(com.up366.qmui.skin.QMUISkinValueBuilder.BORDER, java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_round_btn_border_color));
        sDefaultSkinAttrs.put(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COLOR, java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_round_btn_text_color));
    }

    public QMUIRoundButton(android.content.Context context) {
        super(context);
        init(context, null, 0);
    }

    public QMUIRoundButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUIButtonStyle);
        init(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUIButtonStyle);
    }

    public QMUIRoundButton(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        com.up366.qmui.widget.roundwidget.QMUIRoundButtonDrawable qMUIRoundButtonDrawableFromAttributeSet = com.up366.qmui.widget.roundwidget.QMUIRoundButtonDrawable.fromAttributeSet(context, attributeSet, i);
        this.mRoundBg = qMUIRoundButtonDrawableFromAttributeSet;
        com.up366.qmui.util.QMUIViewHelper.setBackgroundKeepingPadding((android.view.View) this, (android.graphics.drawable.Drawable) qMUIRoundButtonDrawableFromAttributeSet);
        setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenPress(false);
    }

    public void setBackgroundColor(int i) {
        this.mRoundBg.setBgData(android.content.res.ColorStateList.valueOf(i));
    }

    public void setBgData(android.content.res.ColorStateList colorStateList) {
        this.mRoundBg.setBgData(colorStateList);
    }

    public void setStrokeData(int i, android.content.res.ColorStateList colorStateList) {
        this.mRoundBg.setStrokeData(i, colorStateList);
    }

    public int getStrokeWidth() {
        return this.mRoundBg.getStrokeWidth();
    }

    public void setStrokeColors(android.content.res.ColorStateList colorStateList) {
        this.mRoundBg.setStrokeColors(colorStateList);
    }

    @Override // com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> getDefaultSkinAttrs() {
        return sDefaultSkinAttrs;
    }
}
