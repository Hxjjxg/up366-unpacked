package com.up366.mobile.common.mask;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MaskHelper {
    private static final java.lang.String LAST_TIP_TIME = "LAST_TIP_TIME";
    private static com.up366.mobile.common.mask.MaskHelper helper;
    private boolean hasShowDialog = false;
    private volatile boolean showPermissDialog = false;
    private volatile boolean isShowMask = com.up366.mobile.common.utils.PreferenceUtils.getBoolean("mask_status", false);

    private MaskHelper() {
    }

    public static com.up366.mobile.common.mask.MaskHelper getInst() {
        if (helper == null) {
            synchronized (com.up366.mobile.common.mask.MaskHelper.class) {
                if (helper == null) {
                    helper = new com.up366.mobile.common.mask.MaskHelper();
                }
            }
        }
        return helper;
    }

    public int getAfterDuration() {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(11, 7);
        calendar.set(12, 0);
        calendar.set(13, 0);
        if (java.lang.System.currentTimeMillis() - calendar.getTimeInMillis() <= 0) {
            return 0;
        }
        calendar.set(11, 21);
        calendar.set(12, 0);
        calendar.set(13, 0);
        if (java.lang.System.currentTimeMillis() - calendar.getTimeInMillis() > 0) {
            return 0;
        }
        return (int) (calendar.getTimeInMillis() - java.lang.System.currentTimeMillis());
    }

    public void showMaskDialog() {
        if (!this.isShowMask && com.up366.mobile.common.logic.Auth.isAuth()) {
            android.app.Activity currentActivity = com.up366.common.global.GB.get().getCurrentActivity();
            if ((currentActivity instanceof com.up366.mobile.SplashActivity) || currentActivity == null || currentActivity.isDestroyed() || currentActivity.isFinishing()) {
                return;
            }
            if (com.up366.common.TimeUtils.getCurrentNtpTimeInSecond() - com.up366.mobile.common.utils.PreferenceUtils.getLong(LAST_TIP_TIME, 0L) >= 36000 && !this.hasShowDialog) {
                this.hasShowDialog = true;
                com.up366.mobile.common.utils.PreferenceUtils.putLongSync(LAST_TIP_TIME, com.up366.common.TimeUtils.getCurrentNtpTimeInSecond());
                android.widget.Toast toast = new android.widget.Toast(currentActivity);
                android.view.View viewInflate = android.view.View.inflate(currentActivity, com.up366.mobile.R.layout.break_remaind_toast_layout, null);
                ((android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.toast_tip)).setText("科学用眼要有套路，天黑了，快去设置里开启护眼模式吧~");
                toast.setView(viewInflate);
                toast.setDuration(1);
                toast.setGravity(55, 0, 0);
                toast.show();
            }
        }
    }

    public void checkPermission(final android.app.Activity activity) {
        if (hasPermission(activity) || (activity instanceof com.up366.mobile.SplashActivity) || this.showPermissDialog) {
            return;
        }
        this.showPermissDialog = true;
        com.up366.common.task.TaskUtils.postMainTaskDelay(500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.mask.MaskHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$checkPermission$0();
            }
        });
        com.up366.mobile.common.dialog.DialogOkCancleV2.create(activity).message("护眼模式开启失败，请授予悬浮窗权限").ok("去开启", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.mask.MaskHelper$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$checkPermission$1(activity, view);
            }
        }).cancle("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.mask.MaskHelper$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$checkPermission$2(view);
            }
        }).setCanceledOnTouchOutside(false).setCancelable(false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPermission$0() throws java.lang.Exception {
        this.showPermissDialog = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPermission$1(android.app.Activity activity, android.view.View view) {
        askForPermission(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPermission$2(android.view.View view) {
        setHasOpenMask(false);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.MaskCancelEvent());
    }

    public static boolean hasPermission(android.app.Activity activity) {
        return android.provider.Settings.canDrawOverlays(activity);
    }

    private void askForPermission(android.app.Activity activity) {
        try {
            try {
                activity.startActivity(new android.content.Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", android.net.Uri.parse("package:" + activity.getPackageName())));
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("askForPermission  error " + e.getMessage(), e);
            }
        } catch (java.lang.Exception unused) {
            android.content.Intent intent = new android.content.Intent();
            intent.addFlags(268435456);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(android.net.Uri.fromParts("package", activity.getPackageName(), null));
            activity.startActivity(intent);
        }
    }

    public boolean isHasOpenMask() {
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            return false;
        }
        return this.isShowMask;
    }

    public void setHasOpenMask(boolean z) {
        this.isShowMask = z;
        com.up366.mobile.common.utils.PreferenceUtils.putBooleanSync("mask_status", java.lang.Boolean.valueOf(z));
    }

    public void showInputSoft(final android.view.View view) {
        com.up366.common.task.TaskUtils.postMainTaskDelay(200L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.mask.MaskHelper$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.mask.MaskHelper.lambda$showInputSoft$3(view);
            }
        });
    }

    static /* synthetic */ void lambda$showInputSoft$3(android.view.View view) throws java.lang.Exception {
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) com.up366.common.global.GB.get().getApplicationContext().getSystemService("input_method");
        view.requestFocus();
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }

    public void onFinishHideInputSoft(com.up366.common.task.Task task) {
        if (!this.isShowMask) {
            com.up366.common.task.TaskUtils.postMainTask(task);
        } else {
            hideSoftInput();
            com.up366.common.task.TaskUtils.postMainTaskDelay(100L, task);
        }
    }

    private void hideSoftInput() {
        android.view.inputmethod.InputMethodManager inputMethodManager;
        android.app.Activity currentActivity = com.up366.common.global.GB.get().getCurrentActivity();
        if (currentActivity == null || (inputMethodManager = (android.view.inputmethod.InputMethodManager) currentActivity.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(com.up366.common.global.GB.get().getCurrentActivity().getWindow().getDecorView().getWindowToken(), 0);
    }
}
