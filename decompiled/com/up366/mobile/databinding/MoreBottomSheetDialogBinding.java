package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class MoreBottomSheetDialogBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView btnCancel;
    public final android.widget.TextView btnConvert;
    public final android.widget.TextView btnSaveAlum;
    private final com.up366.mobile.common.views.ClipCornerLayout rootView;

    private MoreBottomSheetDialogBinding(com.up366.mobile.common.views.ClipCornerLayout clipCornerLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3) {
        this.rootView = clipCornerLayout;
        this.btnCancel = textView;
        this.btnConvert = textView2;
        this.btnSaveAlum = textView3;
    }

    public com.up366.mobile.common.views.ClipCornerLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.MoreBottomSheetDialogBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.MoreBottomSheetDialogBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.more_bottom_sheet_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.MoreBottomSheetDialogBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.btn_cancel;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_cancel);
        if (textView != null) {
            i = com.up366.mobile.R.id.btn_convert;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_convert);
            if (textView2 != null) {
                i = com.up366.mobile.R.id.btn_save_alum;
                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_save_alum);
                if (textView3 != null) {
                    return new com.up366.mobile.databinding.MoreBottomSheetDialogBinding((com.up366.mobile.common.views.ClipCornerLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
