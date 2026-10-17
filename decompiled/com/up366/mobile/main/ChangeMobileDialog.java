package com.up366.mobile.main;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ChangeMobileDialog {
    public static final int CODE_NEED_TIP = 12;

    public static void show(android.content.Context context, com.up366.mobile.main.ChangeMobileDialog.TipUserInfo tipUserInfo, java.lang.String str, final com.up366.common.callback.ICallbackCode iCallbackCode) {
        final com.up366.mobile.common.dialog.BaseDialog baseDialogCreate = new com.up366.mobile.common.dialog.BaseDialog(context, com.up366.mobile.R.style.AppDialogTheme).create(com.up366.mobile.R.layout.change_mobile_dialog);
        baseDialogCreate.setCancelable(false);
        baseDialogCreate.setCanceledOnTouchOutside(false);
        android.widget.TextView textView = (android.widget.TextView) baseDialogCreate.getView(2131363459);
        android.widget.TextView textView2 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.account_value);
        android.widget.TextView textView3 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.realname_value);
        android.widget.TextView textView4 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.school_value);
        android.widget.TextView textView5 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.mobile_value);
        textView.setText(str + "已绑定其他账号\n是否换绑？");
        textView2.setText(tipUserInfo.getUsername());
        textView3.setText(tipUserInfo.getRealname());
        textView4.setText(tipUserInfo.getOrganName());
        textView5.setText(str);
        android.widget.TextView textView6 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.account_value1);
        android.widget.TextView textView7 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.realname_value1);
        android.widget.TextView textView8 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.school_value1);
        android.widget.TextView textView9 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.mobile_value1);
        textView6.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getUsername());
        textView7.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getRealname());
        textView8.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getOrganName());
        if (!com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile())) {
            textView9.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile());
        } else {
            textView9.setText("-");
        }
        android.widget.TextView textView10 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.btn_cancel);
        android.widget.TextView textView11 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.btn_confirm_change);
        android.view.Window window = baseDialogCreate.getWindow();
        if (window != null) {
            android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = (int) (((double) context.getResources().getDisplayMetrics().widthPixels) * 0.85d);
            window.setAttributes(layoutParams);
        }
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(textView10, new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.ChangeMobileDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.main.ChangeMobileDialog.lambda$show$0(baseDialogCreate, iCallbackCode, view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(textView11, new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.ChangeMobileDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.main.ChangeMobileDialog.lambda$show$1(baseDialogCreate, iCallbackCode, view);
            }
        });
        baseDialogCreate.show();
    }

    static /* synthetic */ void lambda$show$0(com.up366.mobile.common.dialog.BaseDialog baseDialog, com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        baseDialog.dismiss();
        iCallbackCode.onResult(-1);
    }

    static /* synthetic */ void lambda$show$1(com.up366.mobile.common.dialog.BaseDialog baseDialog, com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        baseDialog.dismiss();
        iCallbackCode.onResult(0);
    }

    public static void show1(android.content.Context context, final com.up366.common.callback.ICallbackCode iCallbackCode) {
        final com.up366.mobile.common.dialog.BaseDialog baseDialogCreate = new com.up366.mobile.common.dialog.BaseDialog(context, com.up366.mobile.R.style.AppDialogTheme).create(com.up366.mobile.R.layout.change_mobile_dialog2);
        baseDialogCreate.setCancelable(false);
        baseDialogCreate.setCanceledOnTouchOutside(false);
        android.widget.TextView textView = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.btn_cancel);
        android.widget.TextView textView2 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.btn_confirm_change);
        android.view.Window window = baseDialogCreate.getWindow();
        if (window != null) {
            android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = (int) (((double) context.getResources().getDisplayMetrics().widthPixels) * 0.85d);
            window.setAttributes(layoutParams);
        }
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(textView, new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.ChangeMobileDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.main.ChangeMobileDialog.lambda$show1$2(baseDialogCreate, iCallbackCode, view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(textView2, new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.ChangeMobileDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.main.ChangeMobileDialog.lambda$show1$3(baseDialogCreate, iCallbackCode, view);
            }
        });
        baseDialogCreate.show();
    }

    static /* synthetic */ void lambda$show1$2(com.up366.mobile.common.dialog.BaseDialog baseDialog, com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        baseDialog.dismiss();
        iCallbackCode.onResult(-1);
    }

    static /* synthetic */ void lambda$show1$3(com.up366.mobile.common.dialog.BaseDialog baseDialog, com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        baseDialog.dismiss();
        iCallbackCode.onResult(0);
    }

    public static class TipUserInfo {
        private java.lang.String organName;
        private java.lang.String realname;
        private int uid;
        private java.lang.String username;

        public java.lang.String getRealname() {
            return this.realname;
        }

        public void setRealname(java.lang.String str) {
            this.realname = str;
        }

        public java.lang.String getUsername() {
            return this.username;
        }

        public void setUsername(java.lang.String str) {
            this.username = str;
        }

        public java.lang.String getOrganName() {
            return this.organName;
        }

        public void setOrganName(java.lang.String str) {
            this.organName = str;
        }

        public int getUid() {
            return this.uid;
        }

        public void setUid(int i) {
            this.uid = i;
        }
    }
}
