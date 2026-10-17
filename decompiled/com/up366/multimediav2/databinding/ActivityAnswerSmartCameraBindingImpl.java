package com.up366.multimediav2.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ActivityAnswerSmartCameraBindingImpl extends com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding {
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
        sparseIntArray.put(com.up366.multimediav2.R.id.preview_view, 1);
        sparseIntArray.put(com.up366.multimediav2.R.id.border_view, 2);
        sparseIntArray.put(com.up366.multimediav2.R.id.cl_smart_camera_title, 3);
        sparseIntArray.put(com.up366.multimediav2.R.id.bt_back, 4);
        sparseIntArray.put(com.up366.multimediav2.R.id.bt_light_status, 5);
        sparseIntArray.put(com.up366.multimediav2.R.id.tv_light_toast, 6);
        sparseIntArray.put(com.up366.multimediav2.R.id.bt_help, 7);
        sparseIntArray.put(com.up366.multimediav2.R.id.line, 8);
        sparseIntArray.put(com.up366.multimediav2.R.id.tv_analyze_result, 9);
        sparseIntArray.put(com.up366.multimediav2.R.id.tv_move_page_or_phone, 10);
        sparseIntArray.put(com.up366.multimediav2.R.id.tv_change_manual_toast, 11);
        sparseIntArray.put(com.up366.multimediav2.R.id.qrb_hand_picture, 12);
        sparseIntArray.put(com.up366.multimediav2.R.id.qrb_auto_picture, 13);
        sparseIntArray.put(com.up366.multimediav2.R.id.cl_smart_camera_bottom, 14);
        sparseIntArray.put(com.up366.multimediav2.R.id.ib_select_pic, 15);
        sparseIntArray.put(com.up366.multimediav2.R.id.ib_hand_take_pic, 16);
    }

    public ActivityAnswerSmartCameraBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private ActivityAnswerSmartCameraBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.up366.smart.paper.view.GraphicOverlay) objArr[2], (android.widget.ImageButton) objArr[4], (android.widget.ImageButton) objArr[7], (android.widget.ImageButton) objArr[5], (androidx.constraintlayout.widget.ConstraintLayout) objArr[0], (androidx.constraintlayout.widget.ConstraintLayout) objArr[14], (androidx.constraintlayout.widget.ConstraintLayout) objArr[3], (android.widget.ImageButton) objArr[16], (android.widget.ImageButton) objArr[15], (android.view.View) objArr[8], (androidx.camera.view.PreviewView) objArr[1], (com.up366.qmui.widget.roundwidget.QMUIRoundButton) objArr[13], (com.up366.qmui.widget.roundwidget.QMUIRoundButton) objArr[12], (android.widget.TextView) objArr[9], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[6], (android.widget.TextView) objArr[10]);
        this.mDirtyFlags = -1L;
        this.clRoot.setTag((java.lang.Object) null);
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
