package com.up366.mobile.me.teacherclass;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ViewPagerCanControl extends androidx.viewpager.widget.ViewPager {
    private boolean mIsCanScroll;

    public ViewPagerCanControl(android.content.Context context) {
        super(context);
        this.mIsCanScroll = true;
    }

    public ViewPagerCanControl(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsCanScroll = true;
    }

    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.mIsCanScroll) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.mIsCanScroll) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean isScrollble() {
        return this.mIsCanScroll;
    }

    public void setScrollble(boolean z) {
        this.mIsCanScroll = z;
    }
}
