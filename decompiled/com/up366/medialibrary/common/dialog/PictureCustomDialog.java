package com.up366.medialibrary.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureCustomDialog extends android.app.Dialog {
    public PictureCustomDialog(android.content.Context context, int i) {
        super(context, com.up366.medialibrary.R.style.Picture_Theme_Dialog);
        setContentView(i);
        android.view.Window window = getWindow();
        if (window != null) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -2;
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
    }
}
