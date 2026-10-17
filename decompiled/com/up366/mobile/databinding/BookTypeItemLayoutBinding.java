package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class BookTypeItemLayoutBinding implements androidx.viewbinding.ViewBinding {
    private final android.widget.RadioButton rootView;

    private BookTypeItemLayoutBinding(android.widget.RadioButton radioButton) {
        this.rootView = radioButton;
    }

    public android.widget.RadioButton getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.BookTypeItemLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.BookTypeItemLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.book_type_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.BookTypeItemLayoutBinding bind(android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        return new com.up366.mobile.databinding.BookTypeItemLayoutBinding((android.widget.RadioButton) view);
    }
}
