package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ClearCacheActivityLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.TextView clearCacheConfirmBtn;
    public final androidx.recyclerview.widget.RecyclerView clearCacheRecyclerview;
    private final androidx.coordinatorlayout.widget.CoordinatorLayout rootView;
    public final com.up366.mobile.common.views.TitleBackView tbvTrailBack;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    private ClearCacheActivityLayoutBinding(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView, androidx.recyclerview.widget.RecyclerView recyclerView, com.up366.mobile.common.views.TitleBackView titleBackView, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        this.rootView = coordinatorLayout;
        this.appBar = appBarLayout;
        this.clearCacheConfirmBtn = textView;
        this.clearCacheRecyclerview = recyclerView;
        this.tbvTrailBack = titleBackView;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public androidx.coordinatorlayout.widget.CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.ClearCacheActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.ClearCacheActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.clear_cache_activity_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.ClearCacheActivityLayoutBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.app_bar;
        com.google.android.material.appbar.AppBarLayout appBarLayoutFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.app_bar);
        if (appBarLayoutFindChildViewById != null) {
            i = com.up366.mobile.R.id.clear_cache_confirm_btn;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.clear_cache_confirm_btn);
            if (textView != null) {
                i = com.up366.mobile.R.id.clear_cache_recyclerview;
                androidx.recyclerview.widget.RecyclerView recyclerViewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.clear_cache_recyclerview);
                if (recyclerViewFindChildViewById != null) {
                    i = com.up366.mobile.R.id.tbv_trail_back;
                    com.up366.mobile.common.views.TitleBackView titleBackView = (com.up366.mobile.common.views.TitleBackView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tbv_trail_back);
                    if (titleBackView != null) {
                        i = com.up366.mobile.R.id.toolbar_layout;
                        com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout = (com.up366.mobile.common.views.CollapsingToolbarLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.toolbar_layout);
                        if (collapsingToolbarLayout != null) {
                            return new com.up366.mobile.databinding.ClearCacheActivityLayoutBinding((androidx.coordinatorlayout.widget.CoordinatorLayout) view, appBarLayoutFindChildViewById, textView, recyclerViewFindChildViewById, titleBackView, collapsingToolbarLayout);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
