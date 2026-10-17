package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class TitleviewDropdownLayoutItemBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView listItem;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;

    private TitleviewDropdownLayoutItemBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView) {
        this.rootView = constraintLayout;
        this.listItem = textView;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.TitleviewDropdownLayoutItemBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.TitleviewDropdownLayoutItemBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.titleview_dropdown_layout_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.TitleviewDropdownLayoutItemBinding bind(android.view.View view) {
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131362710);
        if (textView != null) {
            return new com.up366.mobile.databinding.TitleviewDropdownLayoutItemBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(2131362710)));
    }
}
