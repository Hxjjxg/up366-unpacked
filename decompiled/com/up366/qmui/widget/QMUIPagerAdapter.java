package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class QMUIPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    private android.util.SparseArray<java.lang.Object> mScrapItems = new android.util.SparseArray<>();

    public interface Action {
        boolean call(java.lang.Object obj);
    }

    protected abstract void destroy(android.view.ViewGroup viewGroup, int i, java.lang.Object obj);

    protected abstract java.lang.Object hydrate(android.view.ViewGroup viewGroup, int i);

    protected abstract void populate(android.view.ViewGroup viewGroup, java.lang.Object obj, int i);

    public java.lang.Object instantiateItem(android.view.ViewGroup viewGroup, int i) {
        java.lang.Object objHydrate = this.mScrapItems.get(i);
        if (objHydrate == null) {
            objHydrate = hydrate(viewGroup, i);
            this.mScrapItems.put(i, objHydrate);
        }
        populate(viewGroup, objHydrate, i);
        return objHydrate;
    }

    public final void destroyItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
        destroy(viewGroup, i, obj);
    }

    public void each(com.up366.qmui.widget.QMUIPagerAdapter.Action action) {
        int size = this.mScrapItems.size();
        for (int i = 0; i < size && !action.call(this.mScrapItems.valueAt(i)); i++) {
        }
    }
}
