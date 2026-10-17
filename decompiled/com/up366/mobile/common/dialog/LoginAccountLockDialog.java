package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LoginAccountLockDialog {
    private static boolean hasShow;

    static /* synthetic */ void lambda$show$2(android.view.View view) {
    }

    static /* synthetic */ void lambda$show$3(android.view.View view) {
    }

    public static void show(final java.lang.String str, final java.lang.String str2) {
        if (hasShow) {
            return;
        }
        hasShow = true;
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda2(new java.lang.Runnable() { // from class: com.up366.mobile.common.dialog.LoginAccountLockDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.dialog.LoginAccountLockDialog.lambda$show$5(str, str2);
            }
        }));
    }

    static /* synthetic */ void lambda$show$5(java.lang.String str, java.lang.String str2) {
        final android.app.Activity currentActivity = com.up366.common.global.GB.get().getCurrentActivity();
        if ("lock-account".equals(str)) {
            com.up366.mobile.common.dialog.AppDialog.create(currentActivity).title("提示").message(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("密码连续错误10次，账号将被锁定\n").append("请找回密码或明日登录").build()).setOnDissmissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.dialog.LoginAccountLockDialog$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    com.up366.mobile.common.dialog.LoginAccountLockDialog.hasShow = false;
                }
            }).btnOne("找回密码", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.LoginAccountLockDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.common.dialog.LoginAccountLockDialog.lambda$show$1(currentActivity, view);
                }
            }).clickTip(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("我知道了").setSpan(new android.text.style.ForegroundColorSpan(-6710887)).build(), new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.LoginAccountLockDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.common.dialog.LoginAccountLockDialog.lambda$show$2(view);
                }
            }).show();
        } else {
            if ("lock-device".equals(str)) {
                com.up366.mobile.common.dialog.AppDialog.create(currentActivity).title("账号异常").message(str2 + "\n为了您的账号安全，请重置密码").btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.LoginAccountLockDialog$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        com.up366.mobile.common.dialog.LoginAccountLockDialog.lambda$show$3(view);
                    }
                }).setOnDissmissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.dialog.LoginAccountLockDialog$$ExternalSyntheticLambda5
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(android.content.DialogInterface dialogInterface) {
                        com.up366.mobile.common.dialog.LoginAccountLockDialog.hasShow = false;
                    }
                }).show();
                return;
            }
            com.up366.common.log.Logger.error("TAG - LoginAccountLockDialog - no handle type : " + str);
        }
    }

    static /* synthetic */ void lambda$show$1(android.app.Activity activity, android.view.View view) {
        activity.getIntent().putExtra("find_password", true);
        com.up366.mobile.user.account.AccountActivity.openPage(activity, 2);
    }
}
