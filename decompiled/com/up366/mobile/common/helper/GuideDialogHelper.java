package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GuideDialogHelper {
    public static final int TYPE_HEAD_PHOTO = 3;
    public static final int TYPE_HOME_WORK = 1;
    public static final int TYPE_MY_BOOK = 4;
    public static final int TYPE_MY_COURSE = 5;
    public static final int TYPE_PEI_YIN = 2;
    public static final int TYPE_SETTINGS = 6;
    private static final com.up366.mobile.common.helper.GuideDialogHelper inst = new com.up366.mobile.common.helper.GuideDialogHelper();
    private android.util.SparseArray<com.up366.mobile.common.dialog.GuideDialog> dialogs;
    private boolean hasShow;
    private boolean dataLoadSuccess = false;
    private boolean courseFragmentShowing = false;
    private boolean bannerShowSuccess = false;
    private boolean toDeviceCheck = false;

    private GuideDialogHelper() {
        this.hasShow = false;
        boolean z = com.up366.mobile.common.utils.PreferenceUtils.getBoolean("GuideDialogUtils_showTip", false);
        this.hasShow = z;
        if (z) {
            return;
        }
        this.dialogs = new android.util.SparseArray<>();
    }

    public static com.up366.mobile.common.helper.GuideDialogHelper getInst() {
        return inst;
    }

    public void show(int i) {
        com.up366.mobile.common.dialog.GuideDialog guideDialog = this.dialogs.get(i);
        if (guideDialog != null) {
            guideDialog.show();
        } else {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.AddAndShowGuideDialogEvent(i));
        }
    }

    public void setDataLoadSuccess(boolean z) {
        this.dataLoadSuccess = z;
        checkReady();
    }

    public void setCourseFragmentShowing(boolean z) {
        this.courseFragmentShowing = z;
        checkReady();
    }

    public void setBannerShowSuccess(boolean z) {
        this.bannerShowSuccess = z;
        checkReady();
    }

    private void checkReady() {
        if (this.hasShow) {
            return;
        }
        if ((com.up366.common.global.GB.get().getCurrentActivity() instanceof com.up366.mobile.main.MainActivity) && this.dataLoadSuccess && this.courseFragmentShowing && this.bannerShowSuccess) {
            com.up366.organize.PageTaskManager.getInst().ready(com.up366.mobile.main.PageTaskUtils.NAME_GUIDE);
        } else {
            com.up366.organize.PageTaskManager.getInst().wait(com.up366.mobile.main.PageTaskUtils.NAME_GUIDE);
        }
    }

    public boolean isHasShow() {
        return this.hasShow;
    }

    public void showTip() {
        if (!this.hasShow && (com.up366.common.global.GB.get().getCurrentActivity() instanceof com.up366.mobile.main.MainActivity) && this.dataLoadSuccess && this.courseFragmentShowing && this.bannerShowSuccess) {
            com.up366.common.task.TaskUtils.postMainTaskDelay(175L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.GuideDialogHelper$$ExternalSyntheticLambda4
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.common.helper.GuideDialogHelper.lambda$showTip$0();
                }
            });
        }
    }

    static /* synthetic */ void lambda$showTip$0() throws java.lang.Exception {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.StartShowGuideTipEvent());
        com.up366.organize.PageTaskManager.getInst().startRun(com.up366.mobile.main.PageTaskUtils.NAME_GUIDE);
    }

    public void addHomeWorkTip(android.view.View... viewArr) {
        if (this.dialogs.get(1) != null) {
            return;
        }
        this.dialogs.put(1, new com.up366.mobile.common.dialog.GuideDialog.Builder().setType(1).setLayoutId(com.up366.mobile.R.layout.guide_dialog_task).setFocusViews(viewArr).setDrawRect(false).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.helper.GuideDialogHelper$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                com.up366.mobile.common.helper.GuideDialogHelper.lambda$addHomeWorkTip$2(dialogInterface);
            }
        }).build());
    }

    static /* synthetic */ void lambda$addHomeWorkTip$2(android.content.DialogInterface dialogInterface) {
        if (com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_DAILY).isInBlackList()) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OnBottomTabSelected(3));
            com.up366.common.task.TaskUtils.postMainTaskDelay(165L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.GuideDialogHelper$$ExternalSyntheticLambda7
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.helper.GuideDialogHelper.getInst().show(3);
                }
            });
        } else {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.ScrollBottomAndShowEvent(2));
        }
    }

    public void addPeiyinTip(android.view.View... viewArr) {
        if (this.dialogs.get(2) != null) {
            return;
        }
        this.dialogs.put(2, new com.up366.mobile.common.dialog.GuideDialog.Builder().setType(2).setLayoutId(com.up366.mobile.R.layout.guide_dialog_peiyin).setFocusViews(viewArr).setDrawRect(false).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.helper.GuideDialogHelper$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                com.up366.mobile.common.helper.GuideDialogHelper.lambda$addPeiyinTip$4(dialogInterface);
            }
        }).build());
    }

    static /* synthetic */ void lambda$addPeiyinTip$4(android.content.DialogInterface dialogInterface) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OnBottomTabSelected(3));
        com.up366.common.task.TaskUtils.postMainTaskDelay(165L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.GuideDialogHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.helper.GuideDialogHelper.getInst().show(3);
            }
        });
    }

    public void addHeadPhotoTip(android.view.View... viewArr) {
        if (this.dialogs.get(3) != null) {
            return;
        }
        this.dialogs.put(3, new com.up366.mobile.common.dialog.GuideDialog.Builder().setType(3).setDrawRect(false).setBottom(true).setLayoutId(com.up366.mobile.R.layout.guide_dialog_head_photo).setFocusViews(viewArr).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.helper.GuideDialogHelper$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                com.up366.mobile.common.helper.GuideDialogHelper.getInst().show(4);
            }
        }).build());
    }

    public void addMyBookTip(android.view.View... viewArr) {
        if (this.dialogs.get(4) != null) {
            return;
        }
        this.dialogs.put(4, new com.up366.mobile.common.dialog.GuideDialog.Builder().setType(4).setBottom(true).setDrawRect(false).setLayoutId(com.up366.mobile.R.layout.guide_dialog_my_book).setFocusViews(viewArr).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.helper.GuideDialogHelper$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                com.up366.mobile.common.helper.GuideDialogHelper.getInst().show(5);
            }
        }).build());
    }

    public void addMyCourseTip(android.view.View... viewArr) {
        if (this.dialogs.get(5) != null) {
            return;
        }
        this.dialogs.put(5, new com.up366.mobile.common.dialog.GuideDialog.Builder().setType(5).setDrawRect(false).setLayoutId(com.up366.mobile.R.layout.guide_dialog_my_course).setFocusViews(viewArr).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.helper.GuideDialogHelper$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.AddAndShowSettingsGuideDialogEvent());
            }
        }).build());
    }

    public void addSettingTip(android.view.View... viewArr) {
        if (this.dialogs.get(6) != null) {
            return;
        }
        this.dialogs.put(6, new com.up366.mobile.common.dialog.GuideDialog.Builder().setType(6).setDrawRect(false).setLayoutId(com.up366.mobile.R.layout.guide_dialog_settings).setFocusViews(viewArr).setClick(com.up366.mobile.R.id.check_btn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.helper.GuideDialogHelper$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$addSettingTip$8(view);
            }
        }).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.helper.GuideDialogHelper$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                this.f$0.lambda$addSettingTip$10(dialogInterface);
            }
        }).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addSettingTip$8(android.view.View view) {
        this.toDeviceCheck = true;
        com.up366.mobile.user.setting.UserSettingActivity.skipDeviceCheck(view.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addSettingTip$10(android.content.DialogInterface dialogInterface) {
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean("GuideDialogUtils_showTip", true);
        this.hasShow = true;
        this.dialogs.clear();
        this.dialogs = null;
        this.hasShow = true;
        if (this.toDeviceCheck) {
            com.up366.common.task.TaskUtils.postMainTaskDelay(350L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.GuideDialogHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.common.helper.GuideDialogHelper.lambda$addSettingTip$9();
                }
            });
        } else {
            com.up366.organize.PageTaskManager.getInst().finished(com.up366.mobile.main.PageTaskUtils.NAME_GUIDE);
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.FinishGuideEvent());
        }
    }

    static /* synthetic */ void lambda$addSettingTip$9() throws java.lang.Exception {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.FinishGuideEvent());
        com.up366.organize.PageTaskManager.getInst().finished(com.up366.mobile.main.PageTaskUtils.NAME_GUIDE);
    }

    public void setHasShow(boolean z) {
        this.hasShow = z;
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean("GuideDialogUtils_showTip", java.lang.Boolean.valueOf(z));
    }
}
