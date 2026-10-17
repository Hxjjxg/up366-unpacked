package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class TaskItemLayoutV2BindingImpl extends com.up366.mobile.databinding.TaskItemLayoutV2Binding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final com.up366.mobile.common.views.PaddingShadowLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.top_layout, 1);
        sparseIntArray.put(com.up366.mobile.R.id.task_top_right_mokao, 2);
        sparseIntArray.put(com.up366.mobile.R.id.task_ji_jiang_jie_zhi, 3);
        sparseIntArray.put(com.up366.mobile.R.id.task_top_right_weizuoda, 4);
        sparseIntArray.put(com.up366.mobile.R.id.task_top_right_weikaishi, 5);
        sparseIntArray.put(com.up366.mobile.R.id.task_top_right_shangchuanshibai, 6);
        sparseIntArray.put(com.up366.mobile.R.id.lock, 7);
        sparseIntArray.put(com.up366.mobile.R.id.new_submit, 8);
        sparseIntArray.put(com.up366.mobile.R.id.class_layout, 9);
        sparseIntArray.put(com.up366.mobile.R.id.tv_homework_class_name, 10);
        sparseIntArray.put(com.up366.mobile.R.id.tv_use_time, 11);
        sparseIntArray.put(com.up366.mobile.R.id.cl_task_name_score, 12);
        sparseIntArray.put(com.up366.mobile.R.id.task_name, 13);
        sparseIntArray.put(com.up366.mobile.R.id.task_score, 14);
        sparseIntArray.put(com.up366.mobile.R.id.time_tip, 15);
        sparseIntArray.put(com.up366.mobile.R.id.end_time, 16);
        sparseIntArray.put(com.up366.mobile.R.id.bottom_btn_layout, 17);
        sparseIntArray.put(com.up366.mobile.R.id.online_answer, 18);
        sparseIntArray.put(com.up366.mobile.R.id.download_paper, 19);
        sparseIntArray.put(com.up366.mobile.R.id.retry_take_photo_btn, 20);
        sparseIntArray.put(com.up366.mobile.R.id.take_photo_btn, 21);
        sparseIntArray.put(com.up366.mobile.R.id.answer_review, 22);
        sparseIntArray.put(com.up366.mobile.R.id.task_report, 23);
        sparseIntArray.put(com.up366.mobile.R.id.return_error_tip, 24);
    }

    public TaskItemLayoutV2BindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 25, sIncludes, sViewsWithIds));
    }

    private TaskItemLayoutV2BindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.TextView) objArr[22], (android.widget.LinearLayout) objArr[17], (android.widget.LinearLayout) objArr[12], (android.widget.LinearLayout) objArr[9], (android.widget.TextView) objArr[19], (android.widget.TextView) objArr[16], (android.widget.ImageView) objArr[7], (android.widget.TextView) objArr[8], (android.widget.TextView) objArr[18], (android.widget.TextView) objArr[20], (android.widget.ImageView) objArr[24], (android.widget.TextView) objArr[21], (com.up366.mobile.common.views.RoundBorderTextView) objArr[3], (android.widget.TextView) objArr[13], (android.widget.TextView) objArr[23], (android.widget.TextView) objArr[14], (com.up366.mobile.common.views.RoundBorderTextView) objArr[2], (com.up366.mobile.common.views.RoundBorderTextView) objArr[6], (com.up366.mobile.common.views.RoundBorderTextView) objArr[5], (com.up366.mobile.common.views.RoundBorderTextView) objArr[4], (android.widget.ImageView) objArr[15], (android.widget.LinearLayout) objArr[1], (android.widget.TextView) objArr[10], (android.widget.TextView) objArr[11]);
        this.mDirtyFlags = -1L;
        com.up366.mobile.common.views.PaddingShadowLayout paddingShadowLayout = (com.up366.mobile.common.views.PaddingShadowLayout) objArr[0];
        this.mboundView0 = paddingShadowLayout;
        paddingShadowLayout.setTag(null);
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
