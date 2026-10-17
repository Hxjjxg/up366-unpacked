package com.up366.mobile.book.studyviews.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1PagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    private final java.util.List<android.view.View> views;

    public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
        return view == obj;
    }

    public V1PagerAdapter(java.util.List<android.view.View> list) {
        this.views = list;
    }

    public java.lang.Object instantiateItem(android.view.ViewGroup viewGroup, int i) {
        viewGroup.addView(this.views.get(i));
        return this.views.get(i);
    }

    public void destroyItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
        viewGroup.removeView(this.views.get(i));
    }

    public int getCount() {
        return this.views.size();
    }
}
