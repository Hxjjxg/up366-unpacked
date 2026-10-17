package com.up366.qmui.widget.tab;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITab {
    public static final int ICON_POSITION_BOTTOM = 3;
    public static final int ICON_POSITION_LEFT = 0;
    public static final int ICON_POSITION_RIGHT = 2;
    public static final int ICON_POSITION_TOP = 1;
    public static final int NO_SIGN_COUNT_AND_RED_POINT = 0;
    public static final int RED_POINT_SIGN_COUNT = -1;
    public static final int SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER = Integer.MIN_VALUE;
    boolean allowIconDrawOutside;
    int iconTextGap;
    int normalColor;
    int normalColorAttr;
    int normalIconAttr;
    int normalTextSize;
    android.graphics.Typeface normalTypeface;
    int selectColor;
    int selectedColorAttr;
    int selectedIconAttr;
    int selectedTextSize;
    android.graphics.Typeface selectedTypeface;
    boolean skinChangeWithTintColor;
    private java.lang.CharSequence text;
    int normalTabIconWidth = -1;
    int normalTabIconHeight = -1;
    float selectedTabIconScale = 1.0f;
    com.up366.qmui.widget.tab.QMUITabIcon tabIcon = null;
    int contentWidth = 0;
    int contentLeft = 0;
    int iconPosition = 1;
    int gravity = 17;
    int signCountDigits = 2;
    int signCountLeftMarginWithIconOrText = 0;
    int signCountBottomMarginWithIconOrText = 0;
    int signCount = 0;
    float rightSpaceWeight = 0.0f;
    float leftSpaceWeight = 0.0f;
    int leftAddonMargin = 0;
    int rightAddonMargin = 0;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface IconPosition {
    }

    QMUITab(java.lang.CharSequence charSequence) {
        this.text = charSequence;
    }

    public java.lang.CharSequence getText() {
        return this.text;
    }

    public void setText(java.lang.CharSequence charSequence) {
        this.text = charSequence;
    }

    public int getIconPosition() {
        return this.iconPosition;
    }

    public void setIconPosition(int i) {
        this.iconPosition = i;
    }

    public void setSpaceWeight(float f, float f2) {
        this.leftSpaceWeight = f;
        this.rightSpaceWeight = f2;
    }

    public int getGravity() {
        return this.gravity;
    }

    public void setGravity(int i) {
        this.gravity = i;
    }

    public void setSignCount(int i) {
        this.signCount = i;
    }

    public void setRedPoint() {
        this.signCount = -1;
    }

    public int getSignCount() {
        return this.signCount;
    }

    public boolean isRedPointShowing() {
        return this.signCount == -1;
    }

    public void clearSignCountOrRedPoint() {
        this.signCount = 0;
    }

    public int getNormalColor(android.view.View view) {
        int i = this.normalColorAttr;
        if (i == 0) {
            return this.normalColor;
        }
        return com.up366.qmui.skin.QMUISkinHelper.getSkinColor(view, i);
    }

    public int getSelectColor(android.view.View view) {
        int i = this.selectedColorAttr;
        if (i == 0) {
            return this.selectColor;
        }
        return com.up366.qmui.skin.QMUISkinHelper.getSkinColor(view, i);
    }

    public int getNormalColorAttr() {
        return this.normalColorAttr;
    }

    public int getSelectedColorAttr() {
        return this.selectedColorAttr;
    }

    public int getNormalIconAttr() {
        return this.normalIconAttr;
    }

    public int getSelectedIconAttr() {
        return this.selectedIconAttr;
    }

    public int getNormalTextSize() {
        return this.normalTextSize;
    }

    public int getSelectedTextSize() {
        return this.selectedTextSize;
    }

    public com.up366.qmui.widget.tab.QMUITabIcon getTabIcon() {
        return this.tabIcon;
    }

    public android.graphics.Typeface getNormalTypeface() {
        return this.normalTypeface;
    }

    public android.graphics.Typeface getSelectedTypeface() {
        return this.selectedTypeface;
    }

    public int getNormalTabIconWidth() {
        com.up366.qmui.widget.tab.QMUITabIcon qMUITabIcon;
        int i = this.normalTabIconWidth;
        return (i != -1 || (qMUITabIcon = this.tabIcon) == null) ? i : qMUITabIcon.getIntrinsicWidth();
    }

    public int getNormalTabIconHeight() {
        com.up366.qmui.widget.tab.QMUITabIcon qMUITabIcon;
        int i = this.normalTabIconHeight;
        return (i != -1 || (qMUITabIcon = this.tabIcon) == null) ? i : qMUITabIcon.getIntrinsicWidth();
    }

    public float getSelectedTabIconScale() {
        return this.selectedTabIconScale;
    }

    public int getIconTextGap() {
        return this.iconTextGap;
    }

    public boolean isAllowIconDrawOutside() {
        return this.allowIconDrawOutside;
    }
}
