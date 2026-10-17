package com.up366.mobile.me.teacherclass;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeTeachingClassAdapter extends androidx.fragment.app.FragmentStatePagerAdapter {
    private java.util.List<com.up366.mobile.common.base.BaseFragment> mFragments;

    public MeTeachingClassAdapter(androidx.fragment.app.FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public MeTeachingClassAdapter(androidx.fragment.app.FragmentManager fragmentManager, int i) {
        super(fragmentManager, i);
    }

    public void setmFragments(java.util.List<com.up366.mobile.common.base.BaseFragment> list) {
        this.mFragments = list;
    }

    public androidx.fragment.app.Fragment getItem(int i) {
        return this.mFragments.get(i);
    }

    public int getCount() {
        return this.mFragments.size();
    }
}
