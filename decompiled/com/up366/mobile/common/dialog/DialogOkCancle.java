package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DialogOkCancle {
    public static void showDialog(java.lang.String str, java.lang.String str2, android.view.View.OnClickListener onClickListener) {
        android.content.res.Resources resources = com.up366.common.global.GB.get().getCurrentActivity().getResources();
        showDialog(str, str2, resources.getString(com.up366.mobile.R.string.confirm), 0, resources.getString(com.up366.mobile.R.string.cancel), 0, onClickListener);
    }

    public static void showDialog(java.lang.String str, java.lang.CharSequence charSequence, java.lang.String str2, android.view.View.OnClickListener onClickListener) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(com.up366.common.global.GB.get().getCurrentActivity());
        baseDialog.defaultCreate().setText(com.up366.mobile.R.id.dialog_common_msg, charSequence).setText(com.up366.mobile.R.id.dialog_common_title, str).setText(com.up366.mobile.R.id.dialog_common_confirm, str2).setText(com.up366.mobile.R.id.dialog_common_cancel, com.up366.common.global.GB.get().getCurrentActivity().getResources().getString(com.up366.mobile.R.string.cancel)).setOnClickListener(new int[]{com.up366.mobile.R.id.dialog_common_confirm, com.up366.mobile.R.id.dialog_common_cancel}, onClickListener);
        baseDialog.setTextColor(com.up366.mobile.R.id.dialog_common_cancel, com.up366.mobile.R.color.colorDefaultDialogBtn);
        baseDialog.showIfNot();
    }

    public static void showDialog(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, int i2, android.view.View.OnClickListener onClickListener) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(com.up366.common.global.GB.get().getCurrentActivity());
        baseDialog.defaultCreate().setText(com.up366.mobile.R.id.dialog_common_msg, str2).setText(com.up366.mobile.R.id.dialog_common_title, str).setText(com.up366.mobile.R.id.dialog_common_confirm, str3).setText(com.up366.mobile.R.id.dialog_common_cancel, str4).setOnClickListener(new int[]{com.up366.mobile.R.id.dialog_common_confirm, com.up366.mobile.R.id.dialog_common_cancel}, onClickListener);
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            baseDialog.getView(com.up366.mobile.R.id.dialog_common_title).setVisibility(8);
        } else {
            baseDialog.getView(com.up366.mobile.R.id.dialog_common_title).setVisibility(0);
        }
        if (i2 != 0) {
            baseDialog.setTextColor(com.up366.mobile.R.id.dialog_common_cancel, i2);
        }
        if (i != 0) {
            baseDialog.setTextColor(com.up366.mobile.R.id.dialog_common_confirm, i);
        }
        baseDialog.showIfNot();
    }

    public static void showNoteDialog(java.lang.String str, java.lang.String str2, android.view.View.OnClickListener onClickListener) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(com.up366.common.global.GB.get().getCurrentActivity());
        baseDialog.create(com.up366.mobile.R.layout.dialog_note_tip).setText(com.up366.mobile.R.id.txt_title, str).setText(com.up366.mobile.R.id.btn_to_back, str2).setOnClickListener(new int[]{com.up366.mobile.R.id.btn_to_back, com.up366.mobile.R.id.btn_close}, onClickListener);
        baseDialog.showIfNot();
    }
}
