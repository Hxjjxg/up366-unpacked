package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ViewsRotationMapLayoutBinding implements androidx.viewbinding.ViewBinding {
    private final android.widget.FrameLayout rootView;
    public final androidx.viewpager.widget.ViewPager rotationMapPicsPager;
    public final com.up366.mobile.common.views.rotationmap.RotationMapCirclePointView rotationMapPointView;

    private ViewsRotationMapLayoutBinding(android.widget.FrameLayout frameLayout, androidx.viewpager.widget.ViewPager viewPager, com.up366.mobile.common.views.rotationmap.RotationMapCirclePointView rotationMapCirclePointView) {
        this.rootView = frameLayout;
        this.rotationMapPicsPager = viewPager;
        this.rotationMapPointView = rotationMapCirclePointView;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.ViewsRotationMapLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.ViewsRotationMapLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.views_rotation_map_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.ViewsRotationMapLayoutBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.rotation_map_pics_pager;
        androidx.viewpager.widget.ViewPager viewPagerFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.rotation_map_pics_pager);
        if (viewPagerFindChildViewById != null) {
            i = com.up366.mobile.R.id.rotation_map_point_view;
            com.up366.mobile.common.views.rotationmap.RotationMapCirclePointView rotationMapCirclePointView = (com.up366.mobile.common.views.rotationmap.RotationMapCirclePointView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.rotation_map_point_view);
            if (rotationMapCirclePointView != null) {
                return new com.up366.mobile.databinding.ViewsRotationMapLayoutBinding((android.widget.FrameLayout) view, viewPagerFindChildViewById, rotationMapCirclePointView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
