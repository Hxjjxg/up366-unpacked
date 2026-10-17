package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class V1ExerciseChapterPlayViewLayoutBindingImpl extends com.up366.mobile.databinding.V1ExerciseChapterPlayViewLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final android.widget.LinearLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.chapter_play_content_anim, 1);
        sparseIntArray.put(com.up366.mobile.R.id.chapter_play_content_chapter_name, 2);
        sparseIntArray.put(com.up366.mobile.R.id.chapter_play_content_progress_bar, 3);
        sparseIntArray.put(com.up366.mobile.R.id.chapter_play_content_now_time, 4);
        sparseIntArray.put(com.up366.mobile.R.id.chapter_play_content_total_time, 5);
        sparseIntArray.put(com.up366.mobile.R.id.chapter_play_content_last_btn, 6);
        sparseIntArray.put(com.up366.mobile.R.id.chapter_play_content_begin_btn, 7);
        sparseIntArray.put(com.up366.mobile.R.id.chapter_play_content_next_btn, 8);
    }

    public V1ExerciseChapterPlayViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private V1ExerciseChapterPlayViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageView) objArr[1], (android.widget.ImageView) objArr[7], (android.widget.TextView) objArr[2], (android.widget.ImageView) objArr[6], (android.widget.ImageView) objArr[8], (android.widget.TextView) objArr[4], (android.widget.ProgressBar) objArr[3], (android.widget.TextView) objArr[5]);
        this.mDirtyFlags = -1L;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
