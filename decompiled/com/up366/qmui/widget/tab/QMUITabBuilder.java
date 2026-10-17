package com.up366.qmui.widget.tab;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITabBuilder {
    private boolean allowIconDrawOutside;
    private boolean dynamicChangeIconColor;
    private int gravity;
    private int iconPosition;
    private int iconTextGap;
    private int normalColor;
    private int normalColorAttr;
    private android.graphics.drawable.Drawable normalDrawable;
    private int normalDrawableAttr;
    int normalTabIconHeight;
    private int normalTabIconWidth;
    private int normalTextSize;
    private android.graphics.Typeface normalTypeface;
    private int selectColor;
    private int selectTextSize;
    private int selectedColorAttr;
    private android.graphics.drawable.Drawable selectedDrawable;
    private int selectedDrawableAttr;
    float selectedTabIconScale;
    private android.graphics.Typeface selectedTypeface;
    private int signCount;
    private int signCountBottomMarginWithIconOrText;
    private int signCountDigits;
    private int signCountLeftMarginWithIconOrText;
    private boolean skinChangeWithTintColor;
    private java.lang.CharSequence text;

    QMUITabBuilder(android.content.Context context) {
        this.normalDrawableAttr = 0;
        this.selectedDrawableAttr = 0;
        this.dynamicChangeIconColor = false;
        this.skinChangeWithTintColor = true;
        this.normalColorAttr = com.qmuiteam.qmui.R.attr.qmui_skin_support_tab_normal_color;
        this.selectedColorAttr = com.qmuiteam.qmui.R.attr.qmui_skin_support_tab_selected_color;
        this.normalColor = 0;
        this.selectColor = 0;
        this.iconPosition = 1;
        this.gravity = 17;
        this.normalTabIconWidth = -1;
        this.normalTabIconHeight = -1;
        this.selectedTabIconScale = 1.0f;
        this.signCount = 0;
        this.signCountDigits = 2;
        this.allowIconDrawOutside = true;
        this.iconTextGap = com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 2);
        int iDp2px = com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 12);
        this.selectTextSize = iDp2px;
        this.normalTextSize = iDp2px;
        int iDp2px2 = com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 3);
        this.signCountLeftMarginWithIconOrText = iDp2px2;
        this.signCountBottomMarginWithIconOrText = iDp2px2;
    }

    QMUITabBuilder(com.up366.qmui.widget.tab.QMUITabBuilder qMUITabBuilder) {
        this.normalDrawableAttr = 0;
        this.selectedDrawableAttr = 0;
        this.dynamicChangeIconColor = false;
        this.skinChangeWithTintColor = true;
        this.normalColorAttr = com.qmuiteam.qmui.R.attr.qmui_skin_support_tab_normal_color;
        this.selectedColorAttr = com.qmuiteam.qmui.R.attr.qmui_skin_support_tab_selected_color;
        this.normalColor = 0;
        this.selectColor = 0;
        this.iconPosition = 1;
        this.gravity = 17;
        this.normalTabIconWidth = -1;
        this.normalTabIconHeight = -1;
        this.selectedTabIconScale = 1.0f;
        this.signCount = 0;
        this.signCountDigits = 2;
        this.allowIconDrawOutside = true;
        this.normalDrawableAttr = qMUITabBuilder.normalDrawableAttr;
        this.selectedDrawableAttr = qMUITabBuilder.selectedDrawableAttr;
        this.normalDrawable = qMUITabBuilder.normalDrawable;
        this.selectedDrawable = qMUITabBuilder.selectedDrawable;
        this.dynamicChangeIconColor = qMUITabBuilder.dynamicChangeIconColor;
        this.normalTextSize = qMUITabBuilder.normalTextSize;
        this.selectTextSize = qMUITabBuilder.selectTextSize;
        this.normalColorAttr = qMUITabBuilder.normalColorAttr;
        this.selectedColorAttr = qMUITabBuilder.selectedColorAttr;
        this.iconPosition = qMUITabBuilder.iconPosition;
        this.gravity = qMUITabBuilder.gravity;
        this.text = qMUITabBuilder.text;
        this.signCount = qMUITabBuilder.signCount;
        this.signCountDigits = qMUITabBuilder.signCountDigits;
        this.signCountLeftMarginWithIconOrText = qMUITabBuilder.signCountLeftMarginWithIconOrText;
        this.signCountBottomMarginWithIconOrText = qMUITabBuilder.signCountBottomMarginWithIconOrText;
        this.normalTypeface = qMUITabBuilder.normalTypeface;
        this.selectedTypeface = qMUITabBuilder.selectedTypeface;
        this.normalTabIconWidth = qMUITabBuilder.normalTabIconWidth;
        this.normalTabIconHeight = qMUITabBuilder.normalTabIconHeight;
        this.selectedTabIconScale = qMUITabBuilder.selectedTabIconScale;
        this.iconTextGap = qMUITabBuilder.iconTextGap;
        this.allowIconDrawOutside = qMUITabBuilder.allowIconDrawOutside;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setAllowIconDrawOutside(boolean z) {
        this.allowIconDrawOutside = z;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setNormalDrawable(android.graphics.drawable.Drawable drawable) {
        this.normalDrawable = drawable;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setNormalDrawableAttr(int i) {
        this.normalDrawableAttr = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setSelectedDrawable(android.graphics.drawable.Drawable drawable) {
        this.selectedDrawable = drawable;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setSelectedDrawableAttr(int i) {
        this.selectedDrawableAttr = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder skinChangeWithTintColor(boolean z) {
        this.skinChangeWithTintColor = z;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setTextSize(int i, int i2) {
        this.normalTextSize = i;
        this.selectTextSize = i2;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setTypeface(android.graphics.Typeface typeface, android.graphics.Typeface typeface2) {
        this.normalTypeface = typeface;
        this.selectedTypeface = typeface2;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setNormalIconSizeInfo(int i, int i2) {
        this.normalTabIconWidth = i;
        this.normalTabIconHeight = i2;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setSelectedIconScale(float f) {
        this.selectedTabIconScale = f;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setIconTextGap(int i) {
        this.iconTextGap = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setSignCount(int i) {
        this.signCount = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setSignCountMarginInfo(int i, int i2, int i3) {
        this.signCountDigits = i;
        this.signCountLeftMarginWithIconOrText = i2;
        this.signCountBottomMarginWithIconOrText = i3;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setColorAttr(int i, int i2) {
        this.normalColorAttr = i;
        this.selectedColorAttr = i2;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setNormalColorAttr(int i) {
        this.normalColorAttr = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setSelectedColorAttr(int i) {
        this.selectedColorAttr = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setColor(int i, int i2) {
        this.normalColorAttr = 0;
        this.selectedColorAttr = 0;
        this.normalColor = i;
        this.selectColor = i2;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setNormalColor(int i) {
        this.normalColorAttr = 0;
        this.normalColor = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setSelectColor(int i) {
        this.selectedColorAttr = 0;
        this.selectColor = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setDynamicChangeIconColor(boolean z) {
        this.dynamicChangeIconColor = z;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setGravity(int i) {
        this.gravity = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setIconPosition(int i) {
        this.iconPosition = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabBuilder setText(java.lang.CharSequence charSequence) {
        this.text = charSequence;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITab build(android.content.Context context) {
        com.up366.qmui.widget.tab.QMUITab qMUITab = new com.up366.qmui.widget.tab.QMUITab(this.text);
        if (!this.skinChangeWithTintColor) {
            int i = this.normalDrawableAttr;
            if (i != 0) {
                this.normalDrawable = com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, i);
            }
            int i2 = this.selectedDrawableAttr;
            if (i2 != 0) {
                this.selectedDrawable = com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, i2);
            }
        }
        if (this.normalDrawable != null) {
            if (this.dynamicChangeIconColor || this.selectedDrawable == null) {
                qMUITab.tabIcon = new com.up366.qmui.widget.tab.QMUITabIcon(this.normalDrawable, null, this.dynamicChangeIconColor);
            } else {
                qMUITab.tabIcon = new com.up366.qmui.widget.tab.QMUITabIcon(this.normalDrawable, this.selectedDrawable, false);
            }
            qMUITab.tabIcon.setBounds(0, 0, this.normalTabIconWidth, this.normalTabIconHeight);
        }
        qMUITab.skinChangeWithTintColor = this.skinChangeWithTintColor;
        qMUITab.normalIconAttr = this.normalDrawableAttr;
        qMUITab.selectedIconAttr = this.selectedDrawableAttr;
        qMUITab.normalTabIconWidth = this.normalTabIconWidth;
        qMUITab.normalTabIconHeight = this.normalTabIconHeight;
        qMUITab.selectedTabIconScale = this.selectedTabIconScale;
        qMUITab.gravity = this.gravity;
        qMUITab.iconPosition = this.iconPosition;
        qMUITab.normalTextSize = this.normalTextSize;
        qMUITab.selectedTextSize = this.selectTextSize;
        qMUITab.normalTypeface = this.normalTypeface;
        qMUITab.selectedTypeface = this.selectedTypeface;
        qMUITab.normalColorAttr = this.normalColorAttr;
        qMUITab.selectedColorAttr = this.selectedColorAttr;
        qMUITab.normalColor = this.normalColor;
        qMUITab.selectColor = this.selectColor;
        qMUITab.signCount = this.signCount;
        qMUITab.signCountDigits = this.signCountDigits;
        qMUITab.signCountLeftMarginWithIconOrText = this.signCountLeftMarginWithIconOrText;
        qMUITab.signCountBottomMarginWithIconOrText = this.signCountBottomMarginWithIconOrText;
        qMUITab.iconTextGap = this.iconTextGap;
        return qMUITab;
    }
}
