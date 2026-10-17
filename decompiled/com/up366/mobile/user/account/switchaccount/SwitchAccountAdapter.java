package com.up366.mobile.user.account.switchaccount;

/* JADX INFO: compiled from: SwitchAccountAdapter.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"Lcom/up366/mobile/user/account/switchaccount/SwitchAccountAdapter;", "Lcom/up366/mobile/common/base/USV5RecyclerAdapter;", "<init>", "()V", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwitchAccountAdapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public static final int TYPE_ADD = 5;

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.user.account.switchaccount.SwitchAccountItemView(parent.getContext()));
        }
        if (viewType == 5) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.user.account.switchaccount.SwitchAccountAddItemView(parent.getContext()));
        }
        androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolderDefaultHandler = defaultHandler(parent, viewType);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewHolderDefaultHandler, "defaultHandler(...)");
        return viewHolderDefaultHandler;
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(position);
        if (dataHolder.viewType == 1) {
            android.view.View view = holder.itemView;
            kotlin.jvm.internal.Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.up366.mobile.user.account.switchaccount.SwitchAccountItemView");
            java.lang.Object obj = dataHolder.o;
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.up366.mobile.user.account.switchaccount.SwitchAccountData");
            ((com.up366.mobile.user.account.switchaccount.SwitchAccountItemView) view).setData((com.up366.mobile.user.account.switchaccount.SwitchAccountData) obj);
            return;
        }
        defaultHandler(holder, position);
    }
}
