package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class UpdateDialogLayoutBinding implements androidx.viewbinding.ViewBinding {
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.ImageView updateDialogBackground;
    public final android.widget.ImageButton updateDialogExit;
    public final android.widget.TextView updateDialogFindNewVersionTxt;
    public final android.widget.Button updateDialogInstallBtn;
    public final android.widget.ImageView updateDialogRocket;
    public final android.widget.TextView updateDialogVersionDescTxt;

    private UpdateDialogLayoutBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageView imageView, android.widget.ImageButton imageButton, android.widget.TextView textView, android.widget.Button button, android.widget.ImageView imageView2, android.widget.TextView textView2) {
        this.rootView = constraintLayout;
        this.updateDialogBackground = imageView;
        this.updateDialogExit = imageButton;
        this.updateDialogFindNewVersionTxt = textView;
        this.updateDialogInstallBtn = button;
        this.updateDialogRocket = imageView2;
        this.updateDialogVersionDescTxt = textView2;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.UpdateDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.UpdateDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.update_dialog_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.UpdateDialogLayoutBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.update_dialog_background;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.update_dialog_background);
        if (imageView != null) {
            i = com.up366.mobile.R.id.update_dialog_exit;
            android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.update_dialog_exit);
            if (imageButton != null) {
                i = com.up366.mobile.R.id.update_dialog_find_new_version_txt;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.update_dialog_find_new_version_txt);
                if (textView != null) {
                    i = com.up366.mobile.R.id.update_dialog_install_btn;
                    android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.update_dialog_install_btn);
                    if (button != null) {
                        i = com.up366.mobile.R.id.update_dialog_rocket;
                        android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.update_dialog_rocket);
                        if (imageView2 != null) {
                            i = com.up366.mobile.R.id.update_dialog_version_desc_txt;
                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.update_dialog_version_desc_txt);
                            if (textView2 != null) {
                                return new com.up366.mobile.databinding.UpdateDialogLayoutBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, imageButton, textView, button, imageView2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
