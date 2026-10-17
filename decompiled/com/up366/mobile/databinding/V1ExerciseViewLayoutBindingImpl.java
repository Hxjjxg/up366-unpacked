package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class V1ExerciseViewLayoutBindingImpl extends com.up366.mobile.databinding.V1ExerciseViewLayoutBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.title_bar, 1);
        sparseIntArray.put(com.up366.mobile.R.id.page, 2);
        sparseIntArray.put(com.up366.mobile.R.id.exercise_content_viewpager, 3);
        sparseIntArray.put(com.up366.mobile.R.id.exercise_activity_progress_bar, 4);
        sparseIntArray.put(com.up366.mobile.R.id.exercise_activity_play_button, 5);
    }

    public V1ExerciseViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private V1ExerciseViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageView) objArr[5], (android.widget.ProgressBar) objArr[4], (com.up366.mobile.book.studyviews.model.V1ChildViewPager) objArr[3], (com.up366.mobile.book.studyviews.view.V1ExerciseHeadPagerView) objArr[2], (com.up366.mobile.common.views.TitleBarView) objArr[1]);
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
