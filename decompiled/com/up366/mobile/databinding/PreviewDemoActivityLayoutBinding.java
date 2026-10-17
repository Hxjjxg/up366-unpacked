package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class PreviewDemoActivityLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.Button btnAll;
    public final androidx.constraintlayout.helper.widget.Flow flow;
    public final com.up366.mobile.common.views.CourseUrgeBookItemView item1;
    public final com.up366.mobile.common.views.CourseUrgeBookItemView item2;
    public final com.up366.mobile.common.views.CourseUrgeBookItemView item3;
    public final com.up366.mobile.common.views.CourseUrgeBookItemView item4;
    private final android.widget.LinearLayout rootView;
    public final android.widget.TextView title;

    private PreviewDemoActivityLayoutBinding(android.widget.LinearLayout linearLayout, android.widget.Button button, androidx.constraintlayout.helper.widget.Flow flow, com.up366.mobile.common.views.CourseUrgeBookItemView courseUrgeBookItemView, com.up366.mobile.common.views.CourseUrgeBookItemView courseUrgeBookItemView2, com.up366.mobile.common.views.CourseUrgeBookItemView courseUrgeBookItemView3, com.up366.mobile.common.views.CourseUrgeBookItemView courseUrgeBookItemView4, android.widget.TextView textView) {
        this.rootView = linearLayout;
        this.btnAll = button;
        this.flow = flow;
        this.item1 = courseUrgeBookItemView;
        this.item2 = courseUrgeBookItemView2;
        this.item3 = courseUrgeBookItemView3;
        this.item4 = courseUrgeBookItemView4;
        this.title = textView;
    }

    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.PreviewDemoActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.PreviewDemoActivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.preview_demo_activity_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.PreviewDemoActivityLayoutBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.btn_all;
        android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_all);
        if (button != null) {
            i = com.up366.mobile.R.id.flow;
            androidx.constraintlayout.helper.widget.Flow flowFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.flow);
            if (flowFindChildViewById != null) {
                i = 2131362615;
                com.up366.mobile.common.views.CourseUrgeBookItemView courseUrgeBookItemView = (com.up366.mobile.common.views.CourseUrgeBookItemView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131362615);
                if (courseUrgeBookItemView != null) {
                    i = 2131362616;
                    com.up366.mobile.common.views.CourseUrgeBookItemView courseUrgeBookItemView2 = (com.up366.mobile.common.views.CourseUrgeBookItemView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131362616);
                    if (courseUrgeBookItemView2 != null) {
                        i = 2131362617;
                        com.up366.mobile.common.views.CourseUrgeBookItemView courseUrgeBookItemView3 = (com.up366.mobile.common.views.CourseUrgeBookItemView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131362617);
                        if (courseUrgeBookItemView3 != null) {
                            i = 2131362618;
                            com.up366.mobile.common.views.CourseUrgeBookItemView courseUrgeBookItemView4 = (com.up366.mobile.common.views.CourseUrgeBookItemView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131362618);
                            if (courseUrgeBookItemView4 != null) {
                                i = 2131363459;
                                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131363459);
                                if (textView != null) {
                                    return new com.up366.mobile.databinding.PreviewDemoActivityLayoutBinding((android.widget.LinearLayout) view, button, flowFindChildViewById, courseUrgeBookItemView, courseUrgeBookItemView2, courseUrgeBookItemView3, courseUrgeBookItemView4, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
