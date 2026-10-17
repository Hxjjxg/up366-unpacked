package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class QMUIItemViewsAdapter<T, V extends android.view.View> {
    private androidx.core.util.Pools.Pool<V> mCachePool;
    private android.view.ViewGroup mParentView;
    private java.util.List<T> mItemData = new java.util.ArrayList();
    private java.util.List<V> mViews = new java.util.ArrayList();

    protected abstract void bind(T t, V v, int i);

    protected abstract V createView(android.view.ViewGroup viewGroup);

    public QMUIItemViewsAdapter(android.view.ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    public void detach(int i) {
        int size = this.mViews.size();
        while (size > 0 && i > 0) {
            V vRemove = this.mViews.remove(size - 1);
            if (this.mCachePool == null) {
                this.mCachePool = new androidx.core.util.Pools.SimplePool(12);
            }
            java.lang.Object tag = vRemove.getTag(com.qmuiteam.qmui.R.id.qmui_view_can_not_cache_tag);
            if (tag == null || !((java.lang.Boolean) tag).booleanValue()) {
                try {
                    this.mCachePool.release(vRemove);
                } catch (java.lang.Exception unused) {
                }
            }
            this.mParentView.removeView(vRemove);
            size--;
            i--;
        }
    }

    public void clear() {
        this.mItemData.clear();
        detach(this.mViews.size());
    }

    private V getView() {
        androidx.core.util.Pools.Pool<V> pool = this.mCachePool;
        V v = pool != null ? (V) pool.acquire() : null;
        return v == null ? (V) createView(this.mParentView) : v;
    }

    public com.up366.qmui.widget.QMUIItemViewsAdapter<T, V> addItem(T t) {
        this.mItemData.add(t);
        return this;
    }

    public void setup() {
        int size = this.mItemData.size();
        int size2 = this.mViews.size();
        if (size2 > size) {
            detach(size2 - size);
        } else if (size2 < size) {
            for (int i = 0; i < size - size2; i++) {
                android.view.View view = getView();
                this.mParentView.addView(view);
                this.mViews.add((V) view);
            }
        }
        for (int i2 = 0; i2 < size; i2++) {
            bind(this.mItemData.get(i2), this.mViews.get(i2), i2);
        }
        this.mParentView.invalidate();
        this.mParentView.requestLayout();
    }

    public T getItem(int i) {
        java.util.List<T> list = this.mItemData;
        if (list != null && i >= 0 && i < list.size()) {
            return this.mItemData.get(i);
        }
        return null;
    }

    public void replaceItem(int i, T t) throws java.lang.IllegalAccessException {
        if (i < this.mItemData.size() && i >= 0) {
            this.mItemData.set(i, t);
            return;
        }
        throw new java.lang.IllegalAccessException("替换数据不存在");
    }

    public java.util.List<V> getViews() {
        return this.mViews;
    }

    public int getSize() {
        java.util.List<T> list = this.mItemData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
