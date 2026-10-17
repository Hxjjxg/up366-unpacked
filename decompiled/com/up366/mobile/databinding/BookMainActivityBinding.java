package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class BookMainActivityBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.FrameLayout content;
    public final com.up366.mobile.common.views.ClipCornerLayout contentWrapper;
    public final android.widget.FrameLayout rootContainer;
    public final android.widget.LinearLayout rootView;
    private final android.widget.FrameLayout rootView_;
    public final android.view.View space;
    public final com.up366.mobile.common.views.TitleBarView titleBar;
    public final android.widget.FrameLayout top;

    private BookMainActivityBinding(android.widget.FrameLayout frameLayout, android.widget.FrameLayout frameLayout2, com.up366.mobile.common.views.ClipCornerLayout clipCornerLayout, android.widget.FrameLayout frameLayout3, android.widget.LinearLayout linearLayout, android.view.View view, com.up366.mobile.common.views.TitleBarView titleBarView, android.widget.FrameLayout frameLayout4) {
        this.rootView_ = frameLayout;
        this.content = frameLayout2;
        this.contentWrapper = clipCornerLayout;
        this.rootContainer = frameLayout3;
        this.rootView = linearLayout;
        this.space = view;
        this.titleBar = titleBarView;
        this.top = frameLayout4;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView_;
    }

    public static com.up366.mobile.databinding.BookMainActivityBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.BookMainActivityBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.book_main_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.BookMainActivityBinding bind(android.view.View view) {
        int i = 2131362178;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131362178);
        if (frameLayout != null) {
            i = com.up366.mobile.R.id.content_wrapper;
            com.up366.mobile.common.views.ClipCornerLayout clipCornerLayout = (com.up366.mobile.common.views.ClipCornerLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.content_wrapper);
            if (clipCornerLayout != null) {
                android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) view;
                i = com.up366.mobile.R.id.root_view;
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.root_view);
                if (linearLayout != null) {
                    i = com.up366.mobile.R.id.space;
                    android.view.View viewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.space);
                    if (viewFindChildViewById != null) {
                        i = com.up366.mobile.R.id.title_bar;
                        com.up366.mobile.common.views.TitleBarView titleBarView = (com.up366.mobile.common.views.TitleBarView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.title_bar);
                        if (titleBarView != null) {
                            i = 2131363488;
                            android.widget.FrameLayout frameLayout3 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131363488);
                            if (frameLayout3 != null) {
                                return new com.up366.mobile.databinding.BookMainActivityBinding(frameLayout2, frameLayout, clipCornerLayout, frameLayout2, linearLayout, viewFindChildViewById, titleBarView, frameLayout3);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
