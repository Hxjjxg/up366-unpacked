package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AnswerVideoViewLayoutBindingImpl extends com.up366.mobile.databinding.AnswerVideoViewLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.avv_surface, 1);
        sparseIntArray.put(com.up366.mobile.R.id.avv_post, 2);
        sparseIntArray.put(com.up366.mobile.R.id.alpha_layer, 3);
        sparseIntArray.put(com.up366.mobile.R.id.load_tip, 4);
        sparseIntArray.put(com.up366.mobile.R.id.load_progress, 5);
        sparseIntArray.put(com.up366.mobile.R.id.load_progress_text, 6);
        sparseIntArray.put(com.up366.mobile.R.id.err_tip, 7);
        sparseIntArray.put(com.up366.mobile.R.id.avv_error_tip_info, 8);
        sparseIntArray.put(com.up366.mobile.R.id.avv_error_refresh, 9);
        sparseIntArray.put(com.up366.mobile.R.id.play_main, 10);
        sparseIntArray.put(com.up366.mobile.R.id.progress, 11);
        sparseIntArray.put(com.up366.mobile.R.id.ctrl_content, 12);
        sparseIntArray.put(com.up366.mobile.R.id.play_btn, 13);
        sparseIntArray.put(com.up366.mobile.R.id.time_text_cur, 14);
        sparseIntArray.put(com.up366.mobile.R.id.seek_bar, 15);
        sparseIntArray.put(com.up366.mobile.R.id.time_text_tot, 16);
        sparseIntArray.put(com.up366.mobile.R.id.full_btn, 17);
        sparseIntArray.put(com.up366.mobile.R.id.static_control_bar, 18);
        sparseIntArray.put(com.up366.mobile.R.id.play_btn_static, 19);
        sparseIntArray.put(com.up366.mobile.R.id.time_text_cur_static, 20);
        sparseIntArray.put(com.up366.mobile.R.id.seek_bar_static, 21);
        sparseIntArray.put(com.up366.mobile.R.id.time_text_tot_static, 22);
    }

    public AnswerVideoViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 23, sIncludes, sViewsWithIds));
    }

    private AnswerVideoViewLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.FrameLayout) objArr[3], (android.widget.ImageButton) objArr[9], (android.widget.TextView) objArr[8], (android.widget.ImageView) objArr[2], (android.view.SurfaceView) objArr[1], (android.widget.LinearLayout) objArr[12], (android.widget.LinearLayout) objArr[7], (android.widget.ImageButton) objArr[17], (android.widget.ProgressBar) objArr[5], (android.widget.TextView) objArr[6], (android.widget.LinearLayout) objArr[4], (android.widget.ImageButton) objArr[13], (android.widget.ImageButton) objArr[19], (android.widget.ImageButton) objArr[10], (androidx.core.widget.ContentLoadingProgressBar) objArr[11], (android.widget.SeekBar) objArr[15], (android.widget.SeekBar) objArr[21], (android.widget.LinearLayout) objArr[18], (android.widget.TextView) objArr[14], (android.widget.TextView) objArr[20], (android.widget.TextView) objArr[16], (android.widget.TextView) objArr[22], (android.widget.FrameLayout) objArr[0]);
        this.mDirtyFlags = -1L;
        this.videoLayout.setTag(null);
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
