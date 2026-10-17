package com.up366.notchtools.core;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class NotchProperty {
    private boolean mIsNotch;
    private int mMarginTop;
    private int mNotchHeight;
    private int mStatusBarHeight;

    public int getStatusBarHeight() {
        return this.mStatusBarHeight;
    }

    public void setStatusBarHeight(int i) {
        this.mStatusBarHeight = i;
    }

    public int geNotchHeight() {
        return this.mNotchHeight;
    }

    public void setNotchHeight(int i) {
        this.mNotchHeight = i;
    }

    public boolean isNotch() {
        return this.mIsNotch;
    }

    public void setNotch(boolean z) {
        this.mIsNotch = z;
    }

    public int getMarginTop() {
        return this.mMarginTop;
    }

    public void setMarginTop(int i) {
        this.mMarginTop = i;
    }
}
