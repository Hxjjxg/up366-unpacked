package com.up366.qmui.span;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class QMUITouchableSpan extends android.text.style.ClickableSpan implements com.up366.qmui.link.ITouchableSpan, com.up366.qmui.skin.IQMUISkinHandlerSpan {
    private static final java.lang.String TAG = "QMUITouchableSpan";
    private boolean mIsNeedUnderline = false;
    private boolean mIsPressed;
    private int mNormalBackgroundColor;
    private int mNormalBgAttr;
    private int mNormalTextColor;
    private int mNormalTextColorAttr;
    private int mPressedBackgroundColor;
    private int mPressedBgAttr;
    private int mPressedTextColor;
    private int mPressedTextColorAttr;

    public abstract void onSpanClick(android.view.View view);

    @Override // android.text.style.ClickableSpan, com.up366.qmui.link.ITouchableSpan
    public final void onClick(android.view.View view) {
        if (androidx.core.view.ViewCompat.isAttachedToWindow(view)) {
            onSpanClick(view);
        }
    }

    public QMUITouchableSpan(int i, int i2, int i3, int i4) {
        this.mNormalTextColor = i;
        this.mPressedTextColor = i2;
        this.mNormalBackgroundColor = i3;
        this.mPressedBackgroundColor = i4;
    }

    public QMUITouchableSpan(android.view.View view, int i, int i2, int i3, int i4) {
        this.mNormalBgAttr = i3;
        this.mPressedBgAttr = i4;
        this.mNormalTextColorAttr = i;
        this.mPressedTextColorAttr = i2;
        if (i != 0) {
            this.mNormalTextColor = com.up366.qmui.skin.QMUISkinHelper.getSkinColor(view, i);
        }
        if (i2 != 0) {
            this.mPressedTextColor = com.up366.qmui.skin.QMUISkinHelper.getSkinColor(view, i2);
        }
        if (i3 != 0) {
            this.mNormalBackgroundColor = com.up366.qmui.skin.QMUISkinHelper.getSkinColor(view, i3);
        }
        if (i4 != 0) {
            this.mPressedBackgroundColor = com.up366.qmui.skin.QMUISkinHelper.getSkinColor(view, i4);
        }
    }

    public int getNormalBackgroundColor() {
        return this.mNormalBackgroundColor;
    }

    public void setNormalTextColor(int i) {
        this.mNormalTextColor = i;
    }

    public void setPressedTextColor(int i) {
        this.mPressedTextColor = i;
    }

    public int getNormalTextColor() {
        return this.mNormalTextColor;
    }

    public int getPressedBackgroundColor() {
        return this.mPressedBackgroundColor;
    }

    public int getPressedTextColor() {
        return this.mPressedTextColor;
    }

    @Override // com.up366.qmui.link.ITouchableSpan
    public void setPressed(boolean z) {
        this.mIsPressed = z;
    }

    public boolean isPressed() {
        return this.mIsPressed;
    }

    public void setIsNeedUnderline(boolean z) {
        this.mIsNeedUnderline = z;
    }

    public boolean isNeedUnderline() {
        return this.mIsNeedUnderline;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(android.text.TextPaint textPaint) {
        textPaint.setColor(this.mIsPressed ? this.mPressedTextColor : this.mNormalTextColor);
        textPaint.bgColor = this.mIsPressed ? this.mPressedBackgroundColor : this.mNormalBackgroundColor;
        textPaint.setUnderlineText(this.mIsNeedUnderline);
    }

    @Override // com.up366.qmui.skin.IQMUISkinHandlerSpan
    public void handle(android.view.View view, com.up366.qmui.skin.QMUISkinManager qMUISkinManager, int i, android.content.res.Resources.Theme theme) {
        boolean z;
        int i2 = this.mNormalTextColorAttr;
        if (i2 != 0) {
            this.mNormalTextColor = com.up366.qmui.util.QMUIResHelper.getAttrColor(theme, i2);
            z = false;
        } else {
            z = true;
        }
        int i3 = this.mPressedTextColorAttr;
        if (i3 != 0) {
            this.mPressedTextColor = com.up366.qmui.util.QMUIResHelper.getAttrColor(theme, i3);
            z = false;
        }
        int i4 = this.mNormalBgAttr;
        if (i4 != 0) {
            this.mNormalBackgroundColor = com.up366.qmui.util.QMUIResHelper.getAttrColor(theme, i4);
            z = false;
        }
        int i5 = this.mPressedBgAttr;
        if (i5 != 0) {
            this.mPressedBackgroundColor = com.up366.qmui.util.QMUIResHelper.getAttrColor(theme, i5);
            z = false;
        }
        if (z) {
            com.up366.qmui.QMUILog.w(TAG, "There are no attrs for skin. Please use constructor with 5 parameters", new java.lang.Object[0]);
        }
    }
}
