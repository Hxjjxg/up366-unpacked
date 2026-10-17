package com.up366.multimedia.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ViewPagerFixed extends androidx.viewpager.widget.ViewPager {
    public ViewPagerFixed(android.content.Context context) {
        super(context);
    }

    public ViewPagerFixed(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onTouchEvent(android.view.MotionEvent ev) {
        try {
            return super.onTouchEvent(ev);
        } catch (java.lang.IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean onInterceptTouchEvent(android.view.MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (java.lang.IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
