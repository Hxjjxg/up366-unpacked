package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIObservableScrollView extends android.widget.ScrollView {
    private java.util.List<com.up366.qmui.widget.QMUIObservableScrollView.OnScrollChangedListener> mOnScrollChangedListeners;
    private int mScrollOffset;

    public interface OnScrollChangedListener {
        void onScrollChanged(com.up366.qmui.widget.QMUIObservableScrollView qMUIObservableScrollView, int i, int i2, int i3, int i4);
    }

    public QMUIObservableScrollView(android.content.Context context) {
        super(context);
        this.mScrollOffset = 0;
    }

    public QMUIObservableScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollOffset = 0;
    }

    public QMUIObservableScrollView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScrollOffset = 0;
    }

    public void addOnScrollChangedListener(com.up366.qmui.widget.QMUIObservableScrollView.OnScrollChangedListener onScrollChangedListener) {
        if (this.mOnScrollChangedListeners == null) {
            this.mOnScrollChangedListeners = new java.util.ArrayList();
        }
        if (this.mOnScrollChangedListeners.contains(onScrollChangedListener)) {
            return;
        }
        this.mOnScrollChangedListeners.add(onScrollChangedListener);
    }

    public void removeOnScrollChangedListener(com.up366.qmui.widget.QMUIObservableScrollView.OnScrollChangedListener onScrollChangedListener) {
        java.util.List<com.up366.qmui.widget.QMUIObservableScrollView.OnScrollChangedListener> list = this.mOnScrollChangedListeners;
        if (list == null) {
            return;
        }
        list.remove(onScrollChangedListener);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.mScrollOffset = i2;
        java.util.List<com.up366.qmui.widget.QMUIObservableScrollView.OnScrollChangedListener> list = this.mOnScrollChangedListeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        java.util.Iterator<com.up366.qmui.widget.QMUIObservableScrollView.OnScrollChangedListener> it = this.mOnScrollChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollChanged(this, i, i2, i3, i4);
        }
    }

    public int getScrollOffset() {
        return this.mScrollOffset;
    }
}
