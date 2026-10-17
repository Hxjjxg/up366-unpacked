package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SettingActivityLayoutBindingImpl extends com.up366.mobile.databinding.SettingActivityLayoutBinding {
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final android.util.SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;

    protected boolean onFieldChange(int i, java.lang.Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, java.lang.Object obj) {
        return true;
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(com.up366.mobile.R.id.app_bar, 1);
        sparseIntArray.put(com.up366.mobile.R.id.toolbar_layout, 2);
        sparseIntArray.put(com.up366.mobile.R.id.tbv_trail_back, 3);
        sparseIntArray.put(com.up366.mobile.R.id.account_safe, 4);
        sparseIntArray.put(com.up366.mobile.R.id.clear_cache, 5);
        sparseIntArray.put(com.up366.mobile.R.id.device_check, 6);
        sparseIntArray.put(com.up366.mobile.R.id.select_class, 7);
        sparseIntArray.put(com.up366.mobile.R.id.submit_task, 8);
        sparseIntArray.put(com.up366.mobile.R.id.setting_mask, 9);
        sparseIntArray.put(com.up366.mobile.R.id.push_message_switch, 10);
        sparseIntArray.put(com.up366.mobile.R.id.setting_author, 11);
        sparseIntArray.put(com.up366.mobile.R.id.setting_user_data_manager, 12);
        sparseIntArray.put(com.up366.mobile.R.id.submit_oral_data, 13);
        sparseIntArray.put(com.up366.mobile.R.id.allow_protocol, 14);
        sparseIntArray.put(com.up366.mobile.R.id.pri_protocol, 15);
        sparseIntArray.put(com.up366.mobile.R.id.baby_protocol, 16);
        sparseIntArray.put(com.up366.mobile.R.id.user_protocol, 17);
        sparseIntArray.put(com.up366.mobile.R.id.user_protocol_collect, 18);
        sparseIntArray.put(com.up366.mobile.R.id.third_protocol, 19);
        sparseIntArray.put(com.up366.mobile.R.id.exit_protocol, 20);
        sparseIntArray.put(com.up366.mobile.R.id.about_up366, 21);
        sparseIntArray.put(com.up366.mobile.R.id.switch_account_btn, 22);
        sparseIntArray.put(com.up366.mobile.R.id.setting_logout_btn, 23);
    }

    public SettingActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 24, sIncludes, sViewsWithIds));
    }

    private SettingActivityLayoutBindingImpl(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, java.lang.Object[] objArr) {
        super(dataBindingComponent, view, 0, (com.up366.mobile.common.views.SettingItemView) objArr[21], (com.up366.mobile.common.views.SettingItemView) objArr[4], (com.up366.mobile.common.views.SettingItemView) objArr[14], (com.google.android.material.appbar.AppBarLayout) objArr[1], (com.up366.mobile.common.views.SettingItemView) objArr[16], (com.up366.mobile.common.views.SettingItemView) objArr[5], (com.up366.mobile.common.views.SettingItemView) objArr[6], (android.widget.TextView) objArr[20], (com.up366.mobile.common.views.SettingItemView) objArr[15], (com.up366.mobile.common.views.SettingItemView) objArr[10], (com.up366.mobile.common.views.SettingItemView) objArr[7], (com.up366.mobile.common.views.SettingItemView) objArr[11], (android.widget.TextView) objArr[23], (com.up366.mobile.common.views.SettingItemView) objArr[9], (com.up366.mobile.common.views.SettingItemView) objArr[12], (com.up366.mobile.common.views.SettingItemView) objArr[13], (com.up366.mobile.common.views.SettingItemView) objArr[8], (android.widget.TextView) objArr[22], (com.up366.mobile.common.views.TitleBackView) objArr[3], (com.up366.mobile.common.views.SettingItemView) objArr[19], (com.up366.mobile.common.views.CollapsingToolbarLayout) objArr[2], (com.up366.mobile.common.views.SettingItemView) objArr[17], (com.up366.mobile.common.views.SettingItemView) objArr[18]);
        this.mDirtyFlags = -1L;
        androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout = (androidx.coordinatorlayout.widget.CoordinatorLayout) objArr[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag((java.lang.Object) null);
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
