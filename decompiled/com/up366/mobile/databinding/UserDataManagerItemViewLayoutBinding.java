package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class UserDataManagerItemViewLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.CheckBox check;
    public final android.widget.TextView description;
    public final android.view.View line;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView title;

    private UserDataManagerItemViewLayoutBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.CheckBox checkBox, android.widget.TextView textView, android.view.View view, android.widget.TextView textView2) {
        this.rootView = constraintLayout;
        this.check = checkBox;
        this.description = textView;
        this.line = view;
        this.title = textView2;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.UserDataManagerItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.UserDataManagerItemViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.user_data_manager_item_view_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.UserDataManagerItemViewLayoutBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.check;
        android.widget.CheckBox checkBox = (android.widget.CheckBox) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.check);
        if (checkBox != null) {
            i = com.up366.mobile.R.id.description;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.description);
            if (textView != null) {
                i = com.up366.mobile.R.id.line;
                android.view.View viewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.line);
                if (viewFindChildViewById != null) {
                    i = 2131363459;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131363459);
                    if (textView2 != null) {
                        return new com.up366.mobile.databinding.UserDataManagerItemViewLayoutBinding((androidx.constraintlayout.widget.ConstraintLayout) view, checkBox, textView, viewFindChildViewById, textView2);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
