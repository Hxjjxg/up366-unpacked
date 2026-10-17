package com.up366.photopicker.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Up366PhotoPickerDialogSwitchModeBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView btnSwitchCancel;
    public final android.widget.TextView btnSwitchConfirm;
    private final android.widget.FrameLayout rootView;
    public final android.widget.TextView tvSwitchContent;
    public final android.widget.TextView tvSwitchTitle;

    private Up366PhotoPickerDialogSwitchModeBinding(android.widget.FrameLayout frameLayout, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4) {
        this.rootView = frameLayout;
        this.btnSwitchCancel = textView;
        this.btnSwitchConfirm = textView2;
        this.tvSwitchContent = textView3;
        this.tvSwitchTitle = textView4;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerDialogSwitchModeBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerDialogSwitchModeBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.photopicker.R.layout.up366_photo_picker_dialog_switch_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerDialogSwitchModeBinding bind(android.view.View view) {
        int i = com.up366.photopicker.R.id.btnSwitchCancel;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = com.up366.photopicker.R.id.btnSwitchConfirm;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = com.up366.photopicker.R.id.tvSwitchContent;
                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = com.up366.photopicker.R.id.tvSwitchTitle;
                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        return new com.up366.photopicker.databinding.Up366PhotoPickerDialogSwitchModeBinding((android.widget.FrameLayout) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
