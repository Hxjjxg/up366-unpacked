package com.up366.mobile.course.wrongnote;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WrongNoteDetailPagerAdapter extends androidx.fragment.app.FragmentStatePagerAdapter {
    private java.util.List<com.up366.mobile.course.wrongnote.WrongNoteDetailFragment> mFragments;

    public WrongNoteDetailPagerAdapter(androidx.fragment.app.FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mFragments = new java.util.ArrayList();
    }

    public void setFragments(java.util.List<com.up366.mobile.course.wrongnote.WrongNoteDetailFragment> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mFragments.clear();
        this.mFragments.addAll(list);
    }

    public androidx.fragment.app.Fragment getItem(int i) {
        return this.mFragments.get(i);
    }

    public int getCount() {
        return this.mFragments.size();
    }
}
