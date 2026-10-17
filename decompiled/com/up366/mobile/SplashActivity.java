package com.up366.mobile;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SplashActivity extends android.app.Activity {
    private com.up366.mobile.databinding.SplashLayoutBinding binding;
    private boolean hasAccept = false;

    static /* synthetic */ void lambda$onCreate$0(android.view.View view) {
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.asmlibrary.privacy.PrivacyProxy.setAgreePrivacyDialog(com.up366.mobile.common.dialog.AppNotificationDialog.isAgreePermission());
        if (getResources().getConfiguration().orientation != 1) {
            setRequestedOrientation(1);
        }
        final android.view.View decorView = getWindow().getDecorView();
        final android.graphics.drawable.Drawable drawable = androidx.core.content.res.ResourcesCompat.getDrawable(getResources(), com.up366.mobile.R.drawable.splash_last, (android.content.res.Resources.Theme) null);
        if (drawable != null) {
            getWindow().getDecorView().setBackground(new android.graphics.drawable.ColorDrawable() { // from class: com.up366.mobile.SplashActivity.1
                @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
                public void draw(android.graphics.Canvas canvas) {
                    super.draw(canvas);
                    drawable.setBounds(0, 0, decorView.getWidth(), decorView.getHeight());
                    drawable.draw(canvas);
                }
            });
        }
        if (skip(getIntent())) {
            finish();
            return;
        }
        if (!isTaskRoot()) {
            android.content.Intent intent = getIntent();
            java.lang.String action = intent.getAction();
            if (intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(action)) {
                if (com.up366.mobile.common.logic.Auth.isAuth() && com.up366.mobile.common.logic.Auth.cur().config().isMoLiYingUser()) {
                    this.hasAccept = true;
                    skipActivity();
                    return;
                } else {
                    finish();
                    return;
                }
            }
        }
        new com.up366.mobile.common.dialog.AppNotificationDialog().show(this, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.SplashActivity$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                this.f$0.lambda$onCreate$2(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(int i) {
        if (i == -1) {
            finish();
            return;
        }
        long j = com.up366.mobile.common.utils.AppFileUtils.getStorageSize(this).freeBytes;
        com.up366.common.log.Logger.info("TAG - SplashActivity - onCreate - UsableSpace:" + com.up366.common.ByteUtilsUp.bytesToMKB(j));
        if (j < 104857600) {
            com.up366.common.log.Logger.info("TAG - SplashActivity - onCreate - 内存空间不足，无法继续启动应用");
            com.up366.mobile.common.dialog.AppDialog.create(this).title("存储空间不足").message("请清理手机内存后重试").btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.SplashActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.SplashActivity.lambda$onCreate$0(view);
                }
            }).setOnDissmissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.SplashActivity$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    this.f$0.lambda$onCreate$1(dialogInterface);
                }
            }).show();
        } else {
            if (i == 1) {
                com.up366.mobile.common.helper.ApplicationHelper.getInst().onCreate(getApplication());
            }
            this.hasAccept = true;
            skipActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(android.content.DialogInterface dialogInterface) {
        finish();
    }

    private void skipActivity() {
        if (this.hasAccept) {
            if (com.up366.mobile.common.logic.Auth.isAuth()) {
                if (com.up366.mobile.common.logic.Auth.cur().config().isMoLiYingUser()) {
                    com.up366.common.log.Logger.info("TAG - SplashActivity - skipActivity - 跳转到魔法学院");
                    com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("splash", 5000);
                    com.up366.mobile.AiSkipHelper.skipToMain(this);
                    finish();
                    return;
                }
                com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("splash", 5000);
                android.content.Intent intent = new android.content.Intent(this, (java.lang.Class<?>) com.up366.mobile.main.MainActivity.class);
                intent.addFlags(268468224);
                startActivity(intent);
                return;
            }
            com.up366.mobile.user.account.login.AccountLoginActivity.open(this);
            finish();
        }
    }

    private boolean skip(android.content.Intent intent) {
        if (intent == null || intent.getExtras() == null || com.up366.common.StringUtils.isEmptyOrNull(intent.getExtras().getString("g"))) {
            return false;
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("g", intent.getExtras().getString("g"));
        com.up366.pushlibrary.PushHelper.getInst().getPushInterface().messageSkip(com.alibaba.fastjson.JSON.toJSONString(map));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startActivity$3(android.content.Intent intent, android.os.Bundle bundle) {
        super.startActivity(intent, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(final android.content.Intent intent, final android.os.Bundle bundle) {
        com.up366.mobile.common.utils.ViewUtil.checkAndPost(hashCode(), new java.lang.Runnable() { // from class: com.up366.mobile.SplashActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startActivity$3(intent, bundle);
            }
        });
    }
}
