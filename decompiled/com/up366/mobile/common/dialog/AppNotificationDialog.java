package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppNotificationDialog {
    public static final int RET_AGREE = 1;
    public static final int RET_NOT_ACCEPT = -1;
    public static final int RET_OK = 0;

    public static boolean isAgreePermission() {
        return com.up366.mobile.common.utils.PreferenceUtils.getBoolean("hasAgreePermission", false);
    }

    public void show(final android.app.Activity activity, final com.up366.common.callback.ICallbackCode iCallbackCode) {
        if (isAgreePermission()) {
            iCallbackCode.onResult(0);
            return;
        }
        final com.up366.mobile.common.dialog.BaseDialog baseDialogCreate = new com.up366.mobile.common.dialog.BaseDialog(activity, com.up366.mobile.R.style.LargeDialog).create(com.up366.mobile.R.layout.dialog_app_notification_layout);
        baseDialogCreate.setCancelable(false);
        baseDialogCreate.setCanceledOnTouchOutside(false);
        com.up366.mobile.common.views.TitleBarView titleBarView = (com.up366.mobile.common.views.TitleBarView) baseDialogCreate.getView(com.up366.mobile.R.id.title_bar);
        titleBarView.setWindow(baseDialogCreate.getWindow());
        titleBarView.setUpStatusBarLightMode(true);
        android.widget.TextView textView = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.agree);
        final android.widget.TextView textView2 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.ok);
        android.widget.TextView textView3 = (android.widget.TextView) baseDialogCreate.getView(com.up366.mobile.R.id.quit);
        android.view.View view = baseDialogCreate.getView(com.up366.mobile.R.id.btn_close);
        android.view.WindowManager.LayoutParams attributes = baseDialogCreate.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        baseDialogCreate.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(textView2, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppNotificationDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.mobile.common.dialog.AppNotificationDialog.lambda$show$4(baseDialogCreate, activity, iCallbackCode, view2);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(textView3, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppNotificationDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                android.app.Activity activity2 = activity;
                com.up366.mobile.common.dialog.AppDialog.create(activity2).title("天学网需要您同意本隐私协议").setMessageMovementMethod().setMessageColor(-13421773).message(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("在仅浏览模式下，不会收集任何信息。您可以通过").append("《隐私政策》").setSpan(com.up366.mobile.common.dialog.AppNotificationDialog.getClickSpan(activity2, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.PRIVACY_URL))).append("和").append("《儿童隐私保护政策》").setSpan(com.up366.mobile.common.dialog.AppNotificationDialog.getClickSpan(activity2, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.BABY_PRIVACY_URL))).append("查看您享有的权益和相应条款。").build(), 3).left("仅浏览", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppNotificationDialog$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view3) {
                        com.up366.mobile.common.dialog.AppNotificationDialog.enterBrowse(activity2);
                    }
                }).right("同意并继续", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppNotificationDialog$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view3) {
                        textView.callOnClick();
                    }
                }).setCancelable(false).show();
            }
        });
        view.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppNotificationDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                iCallbackCode.onResult(-1);
            }
        });
        android.text.SpannableString spannableString = new android.text.SpannableString(textView.getText());
        spannableString.setSpan(getClickSpan(activity, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.LICENSE_URL)), 4, 12, 18);
        spannableString.setSpan(getClickSpan(activity, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.PRIVACY_URL)), 13, 19, 18);
        spannableString.setSpan(getClickSpan(activity, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.BABY_PRIVACY_URL)), 20, 30, 18);
        spannableString.setSpan(getClickSpan(activity, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.AUTHORITY_URL)), 31, 37, 18);
        spannableString.setSpan(getClickSpan(activity, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.THIRD_INFO_URL)), 38, 51, 18);
        textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        baseDialogCreate.show();
    }

    static /* synthetic */ void lambda$show$4(final com.up366.mobile.common.dialog.BaseDialog baseDialog, final android.app.Activity activity, final com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        baseDialog.dismiss();
        com.up366.mobile.common.dialog.AppDialog.create(activity).title("青少年守护").setMessageMovementMethod().setMessageColor(-13421773).message("天学网非常重视未成年人的个人信息保护，请确认您的年龄，便于平台基于个人信息保护政策为您提供更有效的保护措施。").left("未满14周岁", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppNotificationDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                android.app.Activity activity2 = activity;
                com.up366.common.callback.ICallbackCode iCallbackCode2 = iCallbackCode;
                com.up366.mobile.common.dialog.AppDialog.create(activity2).title("监护人授权").setMessageMovementMethod().setMessageColor(-13421773).message(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("由于您未满14周岁。请先确认已获得监护人的同意，再使用APP内的功能。请认真阅读").append("《儿童隐私保护政策》").setSpan(com.up366.mobile.common.dialog.AppNotificationDialog.getClickSpan(activity2, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.BABY_PRIVACY_URL))).append("并获取监护人同意").build(), 3).left("退出App", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppNotificationDialog$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view3) {
                        iCallbackCode2.onResult(-1);
                    }
                }).right("监护人已同意", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppNotificationDialog$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view3) {
                        com.up366.mobile.common.dialog.AppNotificationDialog.enter(baseDialog, iCallbackCode2);
                    }
                }).setBtnCloseVisibility(4).setCancelable(false).show();
            }
        }).right("已满14周岁", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AppNotificationDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.mobile.common.dialog.AppNotificationDialog.enter(baseDialog, iCallbackCode);
            }
        }).setBtnCloseVisibility(4).setCancelable(false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enterBrowse(android.content.Context context) {
        com.up366.mobile.common.utils.AppFileUtils.initPaths(context);
        com.up366.mobile.common.helper.ApplicationHelper.initLogger();
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.main.PreviewDemoActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enter(com.up366.mobile.common.dialog.BaseDialog baseDialog, com.up366.common.callback.ICallbackCode iCallbackCode) {
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean("hasAgreePermission", true);
        com.up366.asmlibrary.privacy.PrivacyProxy.setAgreePrivacyDialog(true);
        baseDialog.dismiss();
        iCallbackCode.onResult(1);
    }

    public static android.text.style.ClickableSpan getClickSpan(final android.content.Context context, final java.lang.String str) {
        return new android.text.style.ClickableSpan() { // from class: com.up366.mobile.common.dialog.AppNotificationDialog.1
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
                intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, str);
                context.startActivity(intent);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        };
    }
}
