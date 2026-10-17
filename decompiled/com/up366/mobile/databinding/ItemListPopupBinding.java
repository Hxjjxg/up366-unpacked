package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ItemListPopupBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView image;
    private final android.widget.LinearLayout rootView;
    public final android.widget.CheckedTextView text;

    private ItemListPopupBinding(android.widget.LinearLayout linearLayout, android.widget.ImageView imageView, android.widget.CheckedTextView checkedTextView) {
        this.rootView = linearLayout;
        this.image = imageView;
        this.text = checkedTextView;
    }

    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.ItemListPopupBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.ItemListPopupBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.item_list_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.ItemListPopupBinding bind(android.view.View view) {
        int i = 2131362573;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131362573);
        if (imageView != null) {
            i = 2131363383;
            android.widget.CheckedTextView checkedTextView = (android.widget.CheckedTextView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131363383);
            if (checkedTextView != null) {
                return new com.up366.mobile.databinding.ItemListPopupBinding((android.widget.LinearLayout) view, imageView, checkedTextView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
