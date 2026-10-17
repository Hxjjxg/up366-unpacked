package com.up366.mobile.user.setting;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class UserSettingActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.SettingActivityLayoutBinding binding;
    private com.up366.mobile.common.dialog.BaseDialog dialog;
    private java.util.Queue<java.lang.Boolean> maskQueue = new java.util.ArrayDeque();

    static /* synthetic */ void lambda$onCreate$0(android.view.View view) {
    }

    static /* synthetic */ void lambda$onCreate$22(android.view.View view) {
    }

    static /* synthetic */ void lambda$onCreate$8(android.view.View view) {
    }

    static /* synthetic */ void lambda$uploadErrorDialog$32(android.view.View view) {
    }

    static /* synthetic */ void lambda$uploadOralTest$34(android.view.View view) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_setting";
    }

    public static void startUserSettingActivity(android.content.Context context) {
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.user.setting.UserSettingActivity.class));
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        com.up366.mobile.databinding.SettingActivityLayoutBinding settingActivityLayoutBinding = (com.up366.mobile.databinding.SettingActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.setting_activity_layout);
        this.binding = settingActivityLayoutBinding;
        settingActivityLayoutBinding.selectClass.setTextRightMaxEms(6);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.selectClass, new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        updateSelectClass();
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.submitOralData, new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.submitOralData.setVisibility(com.up366.mobile.common.compat.SpecialUserUtils.isOralTester() ? 0 : 8);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.accountSafe, new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.aboutUp366, new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.binding.switchAccountBtn.setVisibility(com.up366.mobile.common.logic.Auth.isTourist() ? 8 : 0);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.switchAccountBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.submitTask, new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.settingLogoutBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$10(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.clearCache, new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$11(view);
            }
        });
        this.binding.pushMessageSwitch.setSwitchBtn(com.up366.mobile.user.setting.PushMessageHelper.getInst().getPushMessageState());
        this.binding.pushMessageSwitch.setOnCheckedChangeListener(new com.up366.mobile.common.views.SwitchButton.IOnCheckedChangeListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda14
            @Override // com.up366.mobile.common.views.SwitchButton.IOnCheckedChangeListener
            public final void onCheckedChanged(com.up366.mobile.common.views.SwitchButton switchButton, boolean z) {
                com.up366.mobile.user.setting.UserSettingActivity.lambda$onCreate$12(switchButton, z);
            }
        });
        this.binding.pushMessageSwitch.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$13(view);
            }
        });
        this.binding.settingMask.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        this.binding.settingMask.setSwitchBtn(com.up366.mobile.common.mask.MaskHelper.getInst().isHasOpenMask());
        if (com.up366.mobile.common.mask.MaskHelper.getInst().isHasOpenMask() && !com.up366.mobile.common.mask.MaskHelper.hasPermission(this)) {
            com.up366.mobile.common.mask.MaskHelper.getInst().showMaskDialog();
        }
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.settingMask, new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$14(view);
            }
        });
        this.binding.settingMask.setOnCheckedChangeListener(new com.up366.mobile.common.views.SwitchButton.IOnCheckedChangeListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda35
            @Override // com.up366.mobile.common.views.SwitchButton.IOnCheckedChangeListener
            public final void onCheckedChanged(com.up366.mobile.common.views.SwitchButton switchButton, boolean z) {
                this.f$0.lambda$onCreate$15(switchButton, z);
            }
        });
        this.binding.allowProtocol.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$16(view);
            }
        });
        this.binding.priProtocol.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$17(view);
            }
        });
        this.binding.babyProtocol.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$18(view);
            }
        });
        this.binding.userProtocol.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$19(view);
            }
        });
        this.binding.userProtocolCollect.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$20(view);
            }
        });
        this.binding.thirdProtocol.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$21(view);
            }
        });
        this.binding.exitProtocol.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("撤回同意协议").setSpan(new android.text.style.UnderlineSpan()).setSpan(new android.text.style.ForegroundColorSpan(-10715905)).build());
        this.binding.exitProtocol.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$24(view);
            }
        });
        this.binding.settingAuthor.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$25(view);
            }
        });
        this.binding.deviceCheck.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$26(view);
            }
        });
        this.binding.settingUserDataManager.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$27(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(android.view.View view) {
        new com.up366.mobile.common.dialog.InterestSelectCourseDialog(this).show(1, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda23
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$onCreate$1(i, str, (com.up366.mobile.course.mgr.CourseInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(int i, java.lang.String str, com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        if (i == 0) {
            updateSelectClass();
            com.up366.mobile.common.dialog.AppDialog.create(this).title("班级设置成功").message("相关的班级数据将于下次练习时生效").btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda21
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.user.setting.UserSettingActivity.lambda$onCreate$0(view);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(android.view.View view) {
        uploadOralTest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$4(android.view.View view) {
        if (com.up366.mobile.common.logic.Auth.isTourist()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, com.up366.mobile.R.string.tip_tourist);
        } else if (com.up366.mobile.common.logic.Auth.getUserInfo().isBackUpPassword()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "临时密码无法操作~");
        } else {
            com.up366.mobile.user.account.update.AccountUpdateActivity.openPage(this, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$5(android.view.View view) {
        com.up366.mobile.user.setting.AboutUp366Activity.startAboutUp366Activity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(android.view.View view) {
        com.up366.mobile.user.account.switchaccount.SwitchAccountActivity.startActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(android.view.View view) {
        uploadUserData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$10(android.view.View view) {
        com.up366.mobile.common.dialog.AppDialog.create(this).title("确定要退出登录吗？").left(getString(com.up366.mobile.R.string.cancel), new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.mobile.user.setting.UserSettingActivity.lambda$onCreate$8(view2);
            }
        }).right(getString(com.up366.mobile.R.string.confirm), new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.mobile.user.setting.UserSettingActivity.lambda$onCreate$9(view2);
            }
        }).show();
    }

    static /* synthetic */ void lambda$onCreate$9(android.view.View view) {
        com.up366.common.log.Logger.info("logout");
        com.up366.mobile.common.logic.Auth.logout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$11(android.view.View view) {
        com.up366.mobile.common.utils.ViewUtil.clickView(view);
        startActivity(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.user.setting.clearcache.ClearCacheActivity.class));
    }

    static /* synthetic */ void lambda$onCreate$12(com.up366.mobile.common.views.SwitchButton switchButton, boolean z) {
        if (z != com.up366.mobile.user.setting.PushMessageHelper.getInst().getPushMessageState()) {
            com.up366.mobile.user.setting.PushMessageHelper.getInst().switchPushMessageState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$13(android.view.View view) {
        this.binding.pushMessageSwitch.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$14(android.view.View view) {
        com.up366.mobile.common.utils.ViewUtil.clickView(view);
        com.up366.mobile.common.mask.MaskHelper.getInst().setHasOpenMask(!com.up366.mobile.common.mask.MaskHelper.getInst().isHasOpenMask());
        this.binding.settingMask.setSwitchBtn(com.up366.mobile.common.mask.MaskHelper.getInst().isHasOpenMask());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$15(com.up366.mobile.common.views.SwitchButton switchButton, boolean z) {
        this.maskQueue.add(java.lang.Boolean.valueOf(z));
        com.up366.mobile.common.mask.MaskHelper.getInst().setHasOpenMask(z);
        if (this.maskQueue.size() > 1) {
            com.up366.common.log.Logger.info("mask not start, size >1 , " + this.maskQueue.size());
            return;
        }
        handleMask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$16(android.view.View view) {
        skip(com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.LICENSE_URL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$17(android.view.View view) {
        skip(com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.PRIVACY_URL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$18(android.view.View view) {
        skip(com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.BABY_PRIVACY_URL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$19(android.view.View view) {
        skip(com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.SELF_INFO_URL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$20(android.view.View view) {
        skip(com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.SELF_INFO_COLLECT_URL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$21(android.view.View view) {
        skip(com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.THIRD_INFO_URL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$24(android.view.View view) {
        com.up366.mobile.common.dialog.AppDialog.create(this).setBtnCloseVisibility(8).message("\n撤回后，App会直接退出\n下次使用需要重新授权哟", -13421773, 15).left("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.mobile.user.setting.UserSettingActivity.lambda$onCreate$22(view2);
            }
        }).right("确认撤回", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                this.f$0.lambda$onCreate$23(view2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$23(android.view.View view) {
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean("hasAgreePermission", false);
        com.up366.mobile.common.logic.Auth.logoutNoSkip();
        exitApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$25(android.view.View view) {
        com.up366.mobile.user.setting.SettingAuthorActivity.open(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$26(android.view.View view) {
        skipDeviceCheck(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$27(android.view.View view) {
        com.up366.mobile.user.setting.UserDataManagerActivity.start(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void skip(java.lang.String str) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_DISMISS_LOADING, true);
        jSONObject.put(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_SHOW_TITLE_BAR, true);
        jSONObject.put(com.up366.mobile.book.helper.Tools.KEY_EXTRA_DATA_UPDATE_TITLE_FROM_HTML, true);
        com.up366.mobile.book.helper.Tools.openJSV8WebViewWithUrl(this, "", str, jSONObject);
    }

    private void exitApp() {
        java.util.Iterator<android.app.ActivityManager.AppTask> it = ((android.app.ActivityManager) getApplicationContext().getSystemService("activity")).getAppTasks().iterator();
        while (it.hasNext()) {
            it.next().finishAndRemoveTask();
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        com.up366.mobile.common.logic.Auth.cur().config().fetchModelMap(com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel(), com.up366.mobile.BuildConfig.VERSION_CODE, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda30
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$onResume$28(response, (com.up366.mobile.common.logic.model.AppConfigLastVersion) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$28(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.AppConfigLastVersion appConfigLastVersion) {
        if (appConfigLastVersion == null || appConfigLastVersion.getVersion() <= 220) {
            return;
        }
        this.binding.aboutUp366.setShowRedPoint(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized void handleMask() {
        java.lang.Boolean boolPeek = this.maskQueue.peek();
        if (boolPeek == null) {
            return;
        }
        if (boolPeek.booleanValue()) {
            com.up366.mobile.common.mask.MaskManager.getMgr().openMask(this, new com.up366.mobile.common.mask.IMaskManager.ICallBack() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda26
                @Override // com.up366.mobile.common.mask.IMaskManager.ICallBack
                public final void onFinished() {
                    this.f$0.onFinished();
                }
            });
        } else {
            com.up366.mobile.common.mask.MaskManager.getMgr().closeMask(this, new com.up366.mobile.common.mask.IMaskManager.ICallBack() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda26
                @Override // com.up366.mobile.common.mask.IMaskManager.ICallBack
                public final void onFinished() {
                    this.f$0.onFinished();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFinished() {
        if (this.maskQueue.size() % 2 == 0) {
            java.lang.Boolean boolValueOf = java.lang.Boolean.valueOf(!this.maskQueue.remove().booleanValue());
            this.maskQueue.clear();
            this.maskQueue.add(boolValueOf);
        } else {
            this.maskQueue.clear();
        }
        handleMask();
    }

    private void updateSelectClass() {
        this.binding.selectClass.setRightText("");
        com.up366.mobile.common.logic.Auth.cur().course().loadCourseList(new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda31
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$updateSelectClass$31(i, str, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSelectClass$31(int i, java.lang.String str, final java.util.List list) {
        com.up366.mobile.common.logic.Auth.cur().cache().load(com.up366.mobile.common.dialog.InterestSelectCourseDialog.CACHE_KEY, com.up366.mobile.course.mgr.CourseInfo.class, new com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda16
            @Override // com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache
            public final void onLoad(java.lang.Object obj) {
                this.f$0.lambda$updateSelectClass$30(list, (com.up366.mobile.course.mgr.CourseInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSelectClass$30(java.util.List list, final com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        if (courseInfo == null) {
            this.binding.selectClass.setRightText("未选择");
            this.binding.selectClass.setRightTextColor(getResources().getColor(com.up366.mobile.R.color.c1));
        } else if (java8.util.stream.StreamSupport.stream(list).anyMatch(new java8.util.function.Predicate() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda20
            @Override // java8.util.function.Predicate
            public final boolean test(java.lang.Object obj) {
                return com.up366.mobile.user.setting.UserSettingActivity.lambda$updateSelectClass$29(courseInfo, (com.up366.mobile.course.mgr.CourseInfo) obj);
            }
        })) {
            this.binding.selectClass.setRightText(courseInfo.getCourseName());
            this.binding.selectClass.setRightTextColor(getResources().getColor(com.up366.mobile.R.color.c5));
        } else {
            com.up366.mobile.common.logic.Auth.cur().cache().clear(com.up366.mobile.common.dialog.InterestSelectCourseDialog.CACHE_KEY);
            this.binding.selectClass.setRightText("未选择");
            this.binding.selectClass.setRightTextColor(getResources().getColor(com.up366.mobile.R.color.c1));
        }
    }

    static /* synthetic */ boolean lambda$updateSelectClass$29(com.up366.mobile.course.mgr.CourseInfo courseInfo, com.up366.mobile.course.mgr.CourseInfo courseInfo2) {
        return courseInfo2.getCourseId() == courseInfo.getCourseId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void uploadErrorDialog(java.lang.String str) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = this.dialog;
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
        com.up366.mobile.common.dialog.AppDialog.create(this).message("数据上传失败").setBtnCloseVisibility(4).left("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.setting.UserSettingActivity.lambda$uploadErrorDialog$32(view);
            }
        }).right("重试", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$uploadErrorDialog$33(view);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadErrorDialog$33(android.view.View view) {
        doUpload();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void uploadOralTest() {
        if (!com.up366.mobile.common.compat.ZipOralDataToShareCompat.hasUploadData()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "没有可上传的数据，可能你已经上传过了!");
        } else {
            com.up366.mobile.common.dialog.AppDialog.create(this).message("将上传近30天本地作答音频数据，耗时较长，请确认是否上传").setBtnCloseVisibility(4).left("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.user.setting.UserSettingActivity.lambda$uploadOralTest$34(view);
                }
            }).right("确认", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda18
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$uploadOralTest$35(view);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadOralTest$35(android.view.View view) {
        doUpload();
    }

    private void doUpload() {
        showUploadDialog();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda27
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Throwable {
                com.up366.mobile.common.compat.ZipOralDataToShareCompat.upload();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showUploadDialog() {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(this);
        this.dialog = baseDialog;
        baseDialog.create(com.up366.mobile.R.layout.oral_test_submit_upload).setText(com.up366.mobile.R.id.oral_test_submit_upload_tv_title, "数据上传中").show();
        this.dialog.setCancelable(false);
    }

    private void uploadUserData() {
        com.up366.mobile.common.logic.Auth.cur().logMgr().decreaseTryCount();
        com.up366.mobile.common.logic.Auth.cur().logMgr().getTasksNum(-1, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda19
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$uploadUserData$36(i, str, (java.lang.Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$uploadUserData$36(int i, java.lang.String str, java.lang.Integer num) {
        if (num.intValue() == 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "没有需要上传的数据");
        } else if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "网络连接失败，请检查网络连接");
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "上传中...");
            com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.mobile.book.helper.V9FontHelper.copyFontsToLocalStorage(com.up366.common.global.GB.get().getApplicationContext());
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onUserLogout(com.up366.mobile.common.event.AuthLoginout authLoginout) {
        finish();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginSuccess authLoginSuccess) {
        finish();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onEventMainThread(com.up366.mobile.common.event.OralUploadLogEvent oralUploadLogEvent) {
        if (oralUploadLogEvent.isSuccess()) {
            this.dialog.create(com.up366.mobile.R.layout.oral_test_submit_upload_success).setOnClickListener(new int[]{com.up366.mobile.R.id.hw_submit_upload_success_tv_sure}, new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda28
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$onEventMainThread$37(view);
                }
            }).setText(com.up366.mobile.R.id.upload_text, "数据上传成功").setBackListener(new com.up366.mobile.common.dialog.BaseDialog.BackPressedListener() { // from class: com.up366.mobile.user.setting.UserSettingActivity$$ExternalSyntheticLambda29
                @Override // com.up366.mobile.common.dialog.BaseDialog.BackPressedListener
                public final void onBackPressed() {
                    this.f$0.lambda$onEventMainThread$38();
                }
            });
            this.dialog.showIfNot();
        }
        if (oralUploadLogEvent.isFailed()) {
            uploadErrorDialog(oralUploadLogEvent.getErrInfo());
        }
        if (oralUploadLogEvent.isProgressUpdate()) {
            if (this.dialog.getView(com.up366.mobile.R.id.my_progress) == null) {
                this.dialog.create(com.up366.mobile.R.layout.oral_test_submit_upload);
            }
            android.widget.ProgressBar progressBar = (android.widget.ProgressBar) this.dialog.getView(com.up366.mobile.R.id.my_progress);
            this.dialog.setText(com.up366.mobile.R.id.oral_test_submit_upload_tv_title, "数据上传中");
            this.dialog.setText(com.up366.mobile.R.id.hw_submit_upload_tv_size, com.up366.common.ByteUtilsUp.downloadSpeed(oralUploadLogEvent.getOverFileSize(), oralUploadLogEvent.getTotalFileSize()));
            this.dialog.setText(com.up366.mobile.R.id.hw_submit_upload_tv_percent, oralUploadLogEvent.getPercent() + "%");
            progressBar.setProgress(oralUploadLogEvent.getPercent());
            this.dialog.showIfNot();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventMainThread$37(android.view.View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventMainThread$38() {
        this.dialog.dismiss();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.MaskCancelEvent maskCancelEvent) {
        this.binding.settingMask.setSwitchBtn(com.up366.mobile.common.mask.MaskHelper.getInst().isHasOpenMask());
    }

    public static void skipDeviceCheck(android.content.Context context) {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setBookId("C6676343D3F522AD17CEAB045D3444A4");
        bookInfoStudy.setBookType(1);
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("scenario", "_STANDARD_BOOK_");
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(bookInfoStudy.getCourseId()));
        jSONObject.put("bookType", java.lang.Integer.valueOf(bookInfoStudy.getBookType()));
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        intent.putExtra("book", bookInfoStudy);
        context.startActivity(intent);
    }
}
