package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class PopupMenuItemLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.FrameLayout rootLayout;
    private final android.widget.FrameLayout rootView;

    private PopupMenuItemLayoutBinding(android.widget.FrameLayout frameLayout, android.widget.FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.rootLayout = frameLayout2;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.PopupMenuItemLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.PopupMenuItemLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.popup_menu_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.PopupMenuItemLayoutBinding bind(android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) view;
        return new com.up366.mobile.databinding.PopupMenuItemLayoutBinding(frameLayout, frameLayout);
    }
}
