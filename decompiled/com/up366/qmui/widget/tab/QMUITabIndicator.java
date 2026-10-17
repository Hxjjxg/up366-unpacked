package com.up366.qmui.widget.tab;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITabIndicator {
    public static final float SCROLL_STATUS_DEFAULT = -2.0f;
    public static final int SCROLL_STATUS_END = 2;
    public static final int SCROLL_STATUS_SCROLLING = 0;
    public static final int SCROLL_STATUS_START = 1;
    private int drwableRectWidth;
    private int mFixedColor;
    private int mFixedColorAttr;
    private android.graphics.drawable.Drawable mIndicatorDrawable;
    private int mIndicatorHeight;
    private android.graphics.Paint mIndicatorPaint;
    private android.graphics.Rect mIndicatorRect;
    private boolean mIndicatorTop;
    private int mIndicatorWidth;
    private boolean mIsIndicatorWidthFollowContent;
    private boolean mShouldReGetFixedColor;
    protected int status;

    public QMUITabIndicator() {
        this.mIndicatorTop = false;
        this.mIsIndicatorWidthFollowContent = true;
        this.mIndicatorRect = null;
        this.mIndicatorPaint = null;
        this.drwableRectWidth = 0;
        this.mFixedColorAttr = 0;
        this.mShouldReGetFixedColor = true;
        this.mFixedColor = 0;
        this.status = -1;
    }

    public QMUITabIndicator(boolean z, boolean z2) {
        this.mIndicatorRect = null;
        this.mIndicatorPaint = null;
        this.drwableRectWidth = 0;
        this.mFixedColorAttr = 0;
        this.mShouldReGetFixedColor = true;
        this.mFixedColor = 0;
        this.status = -1;
        this.mIndicatorTop = z;
        this.mIsIndicatorWidthFollowContent = z2;
    }

    public QMUITabIndicator(int i, boolean z, boolean z2) {
        this(i, z, z2, 0);
    }

    public QMUITabIndicator(int i, boolean z, boolean z2, int i2) {
        this.mIndicatorRect = null;
        this.mIndicatorPaint = null;
        this.drwableRectWidth = 0;
        this.mShouldReGetFixedColor = true;
        this.mFixedColor = 0;
        this.status = -1;
        this.mIndicatorHeight = i;
        this.mIndicatorTop = z;
        this.mIsIndicatorWidthFollowContent = z2;
        this.mFixedColorAttr = i2;
    }

    public com.up366.qmui.widget.tab.QMUITabIndicator setmIndicatorDrawable(android.graphics.drawable.Drawable drawable) {
        this.mIndicatorDrawable = drawable;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabIndicator setmIndicatorHeight(int i) {
        this.mIndicatorHeight = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabIndicator setmIndicatorTop(boolean z) {
        this.mIndicatorTop = z;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabIndicator setmIsIndicatorWidthFollowContent(boolean z) {
        this.mIsIndicatorWidthFollowContent = z;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabIndicator setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabIndicator setmFixedColorAttr(int i) {
        this.mFixedColorAttr = i;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabIndicator setmShouldReGetFixedColor(boolean z) {
        this.mShouldReGetFixedColor = z;
        return this;
    }

    public com.up366.qmui.widget.tab.QMUITabIndicator setmFixedColor(int i) {
        this.mFixedColor = i;
        return this;
    }

    public boolean isIndicatorWidthFollowContent() {
        return this.mIsIndicatorWidthFollowContent;
    }

    public boolean isIndicatorTop() {
        return this.mIndicatorTop;
    }

    protected void updateInfo(int i, int i2, int i3, float f) {
        android.graphics.Rect rect = this.mIndicatorRect;
        if (rect == null) {
            this.mIndicatorRect = new android.graphics.Rect(i, 0, i2 + i, 0);
        } else {
            rect.left = i;
            this.mIndicatorRect.right = i + i2;
        }
        if (this.mFixedColorAttr == 0) {
            updateColor(i3);
        }
        if (f != -2.0f) {
            double d = f;
            if (d <= 0.9d && d >= 0.1d) {
                if ((d > 0.9d || d < 0.1d) && this.status == 2 && f > 0.0f) {
                    this.status = 1;
                    return;
                } else {
                    if (d < 0.9d || d > 0.1d) {
                        this.status = 0;
                        return;
                    }
                    return;
                }
            }
        }
        this.status = 2;
    }

    protected void updateColor(int i) {
        android.graphics.drawable.Drawable drawable = this.mIndicatorDrawable;
        if (drawable != null) {
            com.up366.qmui.util.QMUIDrawableHelper.setDrawableTintColor(drawable, i);
            return;
        }
        if (this.mIndicatorPaint == null) {
            android.graphics.Paint paint = new android.graphics.Paint();
            this.mIndicatorPaint = paint;
            paint.setStyle(android.graphics.Paint.Style.FILL);
        }
        this.mIndicatorPaint.setColor(i);
    }

    protected void updateDrawRect(android.view.View view, android.graphics.Canvas canvas, int i, int i2) {
        if (this.mIndicatorRect != null) {
            int i3 = this.mFixedColorAttr;
            if (i3 != 0 && this.mShouldReGetFixedColor) {
                this.mShouldReGetFixedColor = false;
                int skinColor = com.up366.qmui.skin.QMUISkinHelper.getSkinColor(view, i3);
                this.mFixedColor = skinColor;
                updateColor(skinColor);
            }
            if (this.mIndicatorTop) {
                this.mIndicatorRect.top = i;
                android.graphics.Rect rect = this.mIndicatorRect;
                rect.bottom = rect.top + this.mIndicatorHeight;
            } else {
                this.mIndicatorRect.bottom = i2;
                android.graphics.Rect rect2 = this.mIndicatorRect;
                rect2.top = rect2.bottom - this.mIndicatorHeight;
            }
            if (this.mIndicatorDrawable != null) {
                this.drwableRectWidth = ((this.mIndicatorRect.right - this.mIndicatorRect.left) - this.mIndicatorWidth) / 2;
                this.mIndicatorRect.left += this.drwableRectWidth;
                this.mIndicatorRect.right -= this.drwableRectWidth;
            }
        }
    }

    protected void draw(android.view.View view, android.graphics.Canvas canvas, int i, int i2) {
        if (this.mIndicatorRect != null) {
            updateDrawRect(view, canvas, i, i2);
            android.graphics.drawable.Drawable drawable = this.mIndicatorDrawable;
            if (drawable != null) {
                drawable.setBounds(this.mIndicatorRect);
                this.mIndicatorDrawable.draw(canvas);
            } else {
                canvas.drawRect(this.mIndicatorRect, this.mIndicatorPaint);
            }
        }
    }

    protected void handleSkinChange(com.up366.qmui.skin.QMUISkinManager qMUISkinManager, int i, android.content.res.Resources.Theme theme, com.up366.qmui.widget.tab.QMUITab qMUITab) {
        this.mShouldReGetFixedColor = true;
        if (qMUITab == null || this.mFixedColorAttr != 0) {
            return;
        }
        updateColor(qMUITab.selectedColorAttr == 0 ? qMUITab.selectColor : com.up366.qmui.util.QMUIResHelper.getAttrColor(theme, qMUITab.selectedColorAttr));
    }

    public int getmIndicatorHeight() {
        return this.mIndicatorHeight;
    }

    public int getmIndicatorWidth() {
        return this.mIndicatorWidth;
    }

    public boolean ismIndicatorTop() {
        return this.mIndicatorTop;
    }

    public android.graphics.drawable.Drawable getmIndicatorDrawable() {
        return this.mIndicatorDrawable;
    }

    public boolean ismIsIndicatorWidthFollowContent() {
        return this.mIsIndicatorWidthFollowContent;
    }

    public android.graphics.Rect getmIndicatorRect() {
        return this.mIndicatorRect;
    }

    public void setmIndicatorRect(android.graphics.Rect rect) {
        this.mIndicatorRect = rect;
    }

    public android.graphics.Paint getmIndicatorPaint() {
        return this.mIndicatorPaint;
    }

    public void setmIndicatorPaint(android.graphics.Paint paint) {
        this.mIndicatorPaint = paint;
    }

    public int getDrwableRectWidth() {
        return this.drwableRectWidth;
    }

    public void setDrwableRectWidth(int i) {
        this.drwableRectWidth = i;
    }

    public int getmFixedColorAttr() {
        return this.mFixedColorAttr;
    }

    public boolean ismShouldReGetFixedColor() {
        return this.mShouldReGetFixedColor;
    }

    public int getmFixedColor() {
        return this.mFixedColor;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
