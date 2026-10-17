package com.up366.medialibrary.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureLoadingDialog extends android.app.Dialog {
    public PictureLoadingDialog(android.content.Context context) {
        super(context, com.up366.medialibrary.R.style.Picture_Theme_AlertDialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        android.view.Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(com.up366.medialibrary.R.style.PictureThemeDialogWindowStyle);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.up366.medialibrary.R.layout.picture_alert_dialog);
    }
}
