package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class FragmentTxLiveOnlineUsersBinding implements androidx.viewbinding.ViewBinding {
    private final android.widget.LinearLayout rootView;
    public final androidx.recyclerview.widget.RecyclerView rvOnlineUsers;

    private FragmentTxLiveOnlineUsersBinding(android.widget.LinearLayout linearLayout, androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.rvOnlineUsers = recyclerView;
    }

    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.FragmentTxLiveOnlineUsersBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.FragmentTxLiveOnlineUsersBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.fragment_tx_live_online_users, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.FragmentTxLiveOnlineUsersBinding bind(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView recyclerViewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.rv_online_users);
        if (recyclerViewFindChildViewById != null) {
            return new com.up366.mobile.databinding.FragmentTxLiveOnlineUsersBinding((android.widget.LinearLayout) view, recyclerViewFindChildViewById);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(com.up366.mobile.R.id.rv_online_users)));
    }
}
