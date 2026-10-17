package com.up366.medialibrary.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MyViewPageHelper {
    com.up366.medialibrary.widget.MScroller scroller;
    androidx.viewpager.widget.ViewPager viewPager;

    public MyViewPageHelper(androidx.viewpager.widget.ViewPager viewPager) {
        this.viewPager = viewPager;
        init();
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    public com.up366.medialibrary.widget.MScroller getScroller() {
        return this.scroller;
    }

    public void setCurrentItem(int i, boolean z) {
        if (java.lang.Math.abs(this.viewPager.getCurrentItem() - i) > 1) {
            this.scroller.setNoDuration(true);
            this.viewPager.setCurrentItem(i, z);
            this.scroller.setNoDuration(false);
        } else {
            this.scroller.setNoDuration(false);
            this.viewPager.setCurrentItem(i, z);
        }
    }

    private void init() {
        this.scroller = new com.up366.medialibrary.widget.MScroller(this.viewPager.getContext());
        try {
            java.lang.reflect.Field declaredField = androidx.viewpager.widget.ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.viewPager, this.scroller);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
