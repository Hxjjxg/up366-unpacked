package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ItemTxChatReceiveMsgBindingImpl extends com.up366.mobile.databinding.ItemTxChatReceiveMsgBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.tv_message_time, 1);
        sparseIntArray.put(com.up366.mobile.R.id.ll_msg_title, 2);
        sparseIntArray.put(com.up366.mobile.R.id.iv_user_head, 3);
        sparseIntArray.put(com.up366.mobile.R.id.tv_user_name, 4);
        sparseIntArray.put(com.up366.mobile.R.id.tv_user_role, 5);
        sparseIntArray.put(com.up366.mobile.R.id.stv_message, 6);
    }

    public ItemTxChatReceiveMsgBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemTxChatReceiveMsgBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (android.widget.ImageView) objArr[3], (android.widget.LinearLayout) objArr[2], (com.sunhapper.x.spedit.view.SpXTextView) objArr[6], (android.widget.TextView) objArr[1], (android.widget.TextView) objArr[4], (com.up366.mobile.common.views.RoundBorderTextView) objArr[5]);
        this.mDirtyFlags = -1L;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((java.lang.Object) null);
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
