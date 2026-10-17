package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ScrollViewWithScrollChangeListener extends android.widget.ScrollView {
    private com.up366.mobile.common.views.ScrollViewWithScrollChangeListener.ScrollChangeListener scrollChangeListener;

    public interface ScrollChangeListener {
        void onScrollChanged(int i, int i2, int i3, int i4);

        void onScrollStateChange(int i);
    }

    public ScrollViewWithScrollChangeListener(android.content.Context context) {
        super(context);
    }

    public ScrollViewWithScrollChangeListener(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScrollViewWithScrollChangeListener(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        com.up366.mobile.common.views.ScrollViewWithScrollChangeListener.ScrollChangeListener scrollChangeListener = this.scrollChangeListener;
        if (scrollChangeListener != null) {
            scrollChangeListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.up366.mobile.common.views.ScrollViewWithScrollChangeListener.ScrollChangeListener scrollChangeListener = this.scrollChangeListener;
        if (scrollChangeListener != null) {
            scrollChangeListener.onScrollStateChange(motionEvent.getAction());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        com.up366.mobile.common.views.ScrollViewWithScrollChangeListener.ScrollChangeListener scrollChangeListener;
        int scrollY = getScrollY();
        super.computeScroll();
        if (scrollY != getScrollY() || (scrollChangeListener = this.scrollChangeListener) == null) {
            return;
        }
        scrollChangeListener.onScrollStateChange(3);
    }

    public com.up366.mobile.common.views.ScrollViewWithScrollChangeListener.ScrollChangeListener getScrollChangeListener() {
        return this.scrollChangeListener;
    }

    public void setScrollChangeListener(com.up366.mobile.common.views.ScrollViewWithScrollChangeListener.ScrollChangeListener scrollChangeListener) {
        this.scrollChangeListener = scrollChangeListener;
    }
}
