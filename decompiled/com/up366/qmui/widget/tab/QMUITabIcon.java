package com.up366.qmui.widget.tab;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITabIcon extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback {
    public static final int TAB_ICON_INTRINSIC = -1;
    private float mCurrentSelectFraction;
    private boolean mDynamicChangeIconColor;
    private android.graphics.drawable.Drawable mNormalIconDrawable;
    private android.graphics.drawable.Drawable mSelectedIconDrawable;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }

    public QMUITabIcon(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2) {
        this(drawable, drawable2, true);
    }

    public QMUITabIcon(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, boolean z) {
        this.mCurrentSelectFraction = 0.0f;
        this.mDynamicChangeIconColor = true;
        android.graphics.drawable.Drawable drawableMutate = drawable.mutate();
        this.mNormalIconDrawable = drawableMutate;
        drawableMutate.setCallback(this);
        if (drawable2 != null) {
            android.graphics.drawable.Drawable drawableMutate2 = drawable2.mutate();
            this.mSelectedIconDrawable = drawableMutate2;
            drawableMutate2.setCallback(this);
        }
        this.mNormalIconDrawable.setAlpha(255);
        int intrinsicWidth = this.mNormalIconDrawable.getIntrinsicWidth();
        int intrinsicHeight = this.mNormalIconDrawable.getIntrinsicHeight();
        this.mNormalIconDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        android.graphics.drawable.Drawable drawable3 = this.mSelectedIconDrawable;
        if (drawable3 != null) {
            drawable3.setAlpha(0);
            this.mSelectedIconDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        this.mDynamicChangeIconColor = z;
    }

    public boolean hasSelectedIcon() {
        return this.mSelectedIconDrawable != null;
    }

    public void tint(int i, int i2) {
        if (this.mSelectedIconDrawable == null) {
            androidx.core.graphics.drawable.DrawableCompat.setTint(this.mNormalIconDrawable, com.up366.qmui.util.QMUIColorHelper.computeColor(i, i2, this.mCurrentSelectFraction));
        } else {
            androidx.core.graphics.drawable.DrawableCompat.setTint(this.mNormalIconDrawable, i);
            androidx.core.graphics.drawable.DrawableCompat.setTint(this.mSelectedIconDrawable, i2);
        }
        invalidateSelf();
    }

    public void src(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2) {
        int i = (int) ((1.0f - this.mCurrentSelectFraction) * 255.0f);
        this.mNormalIconDrawable.setCallback(null);
        android.graphics.drawable.Drawable drawableMutate = drawable.mutate();
        this.mNormalIconDrawable = drawableMutate;
        drawableMutate.setCallback(this);
        this.mNormalIconDrawable.setAlpha(i);
        android.graphics.drawable.Drawable drawable3 = this.mSelectedIconDrawable;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        android.graphics.drawable.Drawable drawableMutate2 = drawable2.mutate();
        this.mSelectedIconDrawable = drawableMutate2;
        drawableMutate2.setCallback(this);
        this.mSelectedIconDrawable.setAlpha(255 - i);
        invalidateSelf();
    }

    public void src(android.graphics.drawable.Drawable drawable, int i, int i2) {
        this.mNormalIconDrawable.setCallback(this);
        android.graphics.drawable.Drawable drawableMutate = drawable.mutate();
        this.mNormalIconDrawable = drawableMutate;
        drawableMutate.setCallback(this);
        android.graphics.drawable.Drawable drawable2 = this.mSelectedIconDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            this.mSelectedIconDrawable = null;
        }
        if (this.mDynamicChangeIconColor) {
            androidx.core.graphics.drawable.DrawableCompat.setTint(this.mNormalIconDrawable, com.up366.qmui.util.QMUIColorHelper.computeColor(i, i2, this.mCurrentSelectFraction));
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mNormalIconDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mNormalIconDrawable.getIntrinsicHeight();
    }

    public void setSelectFraction(float f, int i) {
        float fConstrain = com.up366.qmui.util.QMUILangHelper.constrain(f, 0.0f, 1.0f);
        this.mCurrentSelectFraction = fConstrain;
        if (this.mSelectedIconDrawable == null) {
            if (this.mDynamicChangeIconColor) {
                androidx.core.graphics.drawable.DrawableCompat.setTint(this.mNormalIconDrawable, i);
            }
        } else {
            int i2 = (int) ((1.0f - fConstrain) * 255.0f);
            this.mNormalIconDrawable.setAlpha(i2);
            this.mSelectedIconDrawable.setAlpha(255 - i2);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        this.mNormalIconDrawable.draw(canvas);
        android.graphics.drawable.Drawable drawable = this.mSelectedIconDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        this.mNormalIconDrawable.setBounds(rect);
        android.graphics.drawable.Drawable drawable = this.mSelectedIconDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(drawable);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable, long j) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(drawable, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(drawable, runnable);
        }
    }
}
