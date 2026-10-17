package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class FragmentTxLiveChatBindingImpl extends com.up366.mobile.databinding.FragmentTxLiveChatBinding {
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
        sparseIntArray.put(com.up366.mobile.R.id.et_temp, 1);
        sparseIntArray.put(com.up366.mobile.R.id.live_chat_pull_refresh_layout, 2);
        sparseIntArray.put(com.up366.mobile.R.id.rv_message, 3);
        sparseIntArray.put(com.up366.mobile.R.id.fl_input, 4);
        sparseIntArray.put(com.up366.mobile.R.id.ll_input_send, 5);
        sparseIntArray.put(com.up366.mobile.R.id.ib_face_msg, 6);
        sparseIntArray.put(com.up366.mobile.R.id.et_input_msg, 7);
        sparseIntArray.put(com.up366.mobile.R.id.ib_msg_send, 8);
    }

    public FragmentTxLiveChatBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private FragmentTxLiveChatBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (androidx.constraintlayout.widget.ConstraintLayout) objArr[0], (com.sunhapper.x.spedit.view.SpXEditText) objArr[7], (com.up366.mobile.common.views.CommonEditText) objArr[1], (android.widget.FrameLayout) objArr[4], (android.widget.ImageButton) objArr[6], (android.widget.ImageButton) objArr[8], (com.ylw.pullrefreshlibrary.PullRefreshLayout) objArr[2], (androidx.constraintlayout.widget.ConstraintLayout) objArr[5], (androidx.recyclerview.widget.RecyclerView) objArr[3]);
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
