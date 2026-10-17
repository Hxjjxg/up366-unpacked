package com.up366.medialibrary.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PreviewViewPager extends androidx.viewpager.widget.ViewPager {
    private com.up366.medialibrary.widget.MyViewPageHelper helper;

    public PreviewViewPager(android.content.Context context) {
        super(context);
    }

    public PreviewViewPager(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.helper = new com.up366.medialibrary.widget.MyViewPageHelper(this);
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    public void setCurrentItem(int i, boolean z) {
        com.up366.medialibrary.widget.MScroller scroller = this.helper.getScroller();
        if (java.lang.Math.abs(getCurrentItem() - i) > 1) {
            scroller.setNoDuration(true);
            super.setCurrentItem(i, z);
            scroller.setNoDuration(false);
        } else {
            scroller.setNoDuration(false);
            super.setCurrentItem(i, z);
        }
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (java.lang.IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (java.lang.IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (java.lang.ArrayIndexOutOfBoundsException | java.lang.IllegalArgumentException unused) {
            return false;
        }
    }
}
