package com.up366.mobile.common.base;

/* JADX INFO: compiled from: BaseBackPressedFragment.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/up366/mobile/common/base/BaseBackPressedFragment;", "Lcom/up366/mobile/common/base/BaseFragment;", "<init>", "()V", "listenerBack", "", "getListenerBack", "()Z", "setListenerBack", "(Z)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "onHiddenChanged", "hidden", "BackFragmentListener", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class BaseBackPressedFragment extends com.up366.mobile.common.base.BaseFragment {
    private boolean listenerBack = true;

    /* JADX INFO: compiled from: BaseBackPressedFragment.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/up366/mobile/common/base/BaseBackPressedFragment$BackFragmentListener;", "", "backFragment", "", "fragment", "Lcom/up366/mobile/common/base/BaseBackPressedFragment;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface BackFragmentListener {
        void backFragment(com.up366.mobile.common.base.BaseBackPressedFragment fragment);
    }

    public void onBackPressed() {
    }

    public final boolean getListenerBack() {
        return this.listenerBack;
    }

    public final void setListenerBack(boolean z) {
        this.listenerBack = z;
    }

    public void onViewCreated(android.view.View view, android.os.Bundle savedInstanceState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (requireActivity() instanceof com.up366.mobile.common.base.BaseBackPressedFragment.BackFragmentListener) {
            com.up366.mobile.common.base.BaseBackPressedFragment.BackFragmentListener backFragmentListenerRequireActivity = requireActivity();
            kotlin.jvm.internal.Intrinsics.checkNotNull(backFragmentListenerRequireActivity, "null cannot be cast to non-null type com.up366.mobile.common.base.BaseBackPressedFragment.BackFragmentListener");
            backFragmentListenerRequireActivity.backFragment(this);
        }
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden && this.listenerBack && (requireActivity() instanceof com.up366.mobile.common.base.BaseBackPressedFragment.BackFragmentListener)) {
            com.up366.mobile.common.base.BaseBackPressedFragment.BackFragmentListener backFragmentListenerRequireActivity = requireActivity();
            kotlin.jvm.internal.Intrinsics.checkNotNull(backFragmentListenerRequireActivity, "null cannot be cast to non-null type com.up366.mobile.common.base.BaseBackPressedFragment.BackFragmentListener");
            backFragmentListenerRequireActivity.backFragment(this);
        }
    }
}
