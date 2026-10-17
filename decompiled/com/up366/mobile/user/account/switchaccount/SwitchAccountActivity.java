package com.up366.mobile.user.account.switchaccount;

/* JADX INFO: compiled from: SwitchAccountActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0014J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020 H\u0007J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010!H\u0007J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/up366/mobile/user/account/switchaccount/SwitchAccountActivity;", "Lcom/up366/mobile/common/base/BaseActivity;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "binding", "Lcom/up366/mobile/databinding/ActivitySwitchAccountLayoutBinding;", "controller", "Lcom/up366/mobile/common/base/USV5ListViewDataController;", "", "adapter", "Lcom/up366/mobile/user/account/switchaccount/SwitchAccountAdapter;", "helper", "Lcom/up366/mobile/user/account/switchaccount/SwitchAccountHelper;", "isEdit", "", "getCurrentPageName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "initView", "initController", "onClick", "p0", "Landroid/view/View;", "switchEditState", "onMessageEvent", "event", "Lcom/up366/mobile/common/event/SwitchAccountDeleteEvent;", "Lcom/up366/mobile/common/event/SwitchLoginEvent;", "Lcom/up366/mobile/common/event/AuthLoginSuccess;", "Lcom/up366/mobile/common/event/FinishSwitchAccountActivityEvent;", "showErrorDialog", "data", "Lcom/up366/mobile/user/account/switchaccount/SwitchAccountData;", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwitchAccountActivity extends com.up366.mobile.common.base.BaseActivity implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.user.account.switchaccount.SwitchAccountActivity.Companion INSTANCE = new com.up366.mobile.user.account.switchaccount.SwitchAccountActivity.Companion(null);
    private com.up366.mobile.user.account.switchaccount.SwitchAccountAdapter adapter;
    private com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding binding;
    private com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> controller;
    private final com.up366.mobile.user.account.switchaccount.SwitchAccountHelper helper = new com.up366.mobile.user.account.switchaccount.SwitchAccountHelper();
    private boolean isEdit;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initController$lambda$0(java.util.List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initController$lambda$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initController$lambda$2() {
    }

    @kotlin.jvm.JvmStatic
    public static final void startActivity(com.up366.mobile.user.setting.UserSettingActivity userSettingActivity) {
        INSTANCE.startActivity(userSettingActivity);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_setting_swich_account";
    }

    /* JADX INFO: compiled from: SwitchAccountActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/up366/mobile/user/account/switchaccount/SwitchAccountActivity$Companion;", "", "<init>", "()V", "startActivity", "", "userSettingActivity", "Lcom/up366/mobile/user/setting/UserSettingActivity;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @kotlin.jvm.JvmStatic
        public final void startActivity(com.up366.mobile.user.setting.UserSettingActivity userSettingActivity) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(userSettingActivity, "userSettingActivity");
            userSettingActivity.startActivity(new android.content.Intent((android.content.Context) userSettingActivity, (java.lang.Class<?>) com.up366.mobile.user.account.switchaccount.SwitchAccountActivity.class));
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding.inflate(getLayoutInflater());
        getWindow().getDecorView().setSystemUiVisibility(9472);
        getWindow().setStatusBarColor(0);
        com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding = this.binding;
        if (activitySwitchAccountLayoutBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySwitchAccountLayoutBinding = null;
        }
        setContentView(activitySwitchAccountLayoutBinding.getRoot());
        com.up366.common.EventBusUtilsUp.register(this);
        initView();
        initController();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initView() {
        com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding = this.binding;
        com.up366.mobile.user.account.switchaccount.SwitchAccountAdapter switchAccountAdapter = null;
        if (activitySwitchAccountLayoutBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySwitchAccountLayoutBinding = null;
        }
        com.up366.mobile.user.account.switchaccount.SwitchAccountActivity switchAccountActivity = this;
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener((android.view.View) activitySwitchAccountLayoutBinding.back, switchAccountActivity);
        com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding2 = this.binding;
        if (activitySwitchAccountLayoutBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySwitchAccountLayoutBinding2 = null;
        }
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(activitySwitchAccountLayoutBinding2.manageBtn, switchAccountActivity);
        android.content.Context context = (android.content.Context) this;
        this.controller = new com.up366.mobile.common.base.USV5ListViewDataController<>(context);
        this.adapter = new com.up366.mobile.user.account.switchaccount.SwitchAccountAdapter();
        com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding3 = this.binding;
        if (activitySwitchAccountLayoutBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySwitchAccountLayoutBinding3 = null;
        }
        activitySwitchAccountLayoutBinding3.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(context));
        com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding4 = this.binding;
        if (activitySwitchAccountLayoutBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySwitchAccountLayoutBinding4 = null;
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = activitySwitchAccountLayoutBinding4.recycleView;
        com.up366.mobile.user.account.switchaccount.SwitchAccountAdapter switchAccountAdapter2 = this.adapter;
        if (switchAccountAdapter2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            switchAccountAdapter = switchAccountAdapter2;
        }
        recyclerView.setAdapter(switchAccountAdapter);
    }

    public final void initController() {
        com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> uSV5ListViewDataController = this.controller;
        com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> uSV5ListViewDataController2 = null;
        if (uSV5ListViewDataController == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("controller");
            uSV5ListViewDataController = null;
        }
        uSV5ListViewDataController.setLoadingView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountActivity$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                com.up366.mobile.user.account.switchaccount.SwitchAccountActivity.initController$lambda$0(list);
            }
        });
        com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> uSV5ListViewDataController3 = this.controller;
        if (uSV5ListViewDataController3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("controller");
            uSV5ListViewDataController3 = null;
        }
        uSV5ListViewDataController3.setLocalLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountActivity$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() {
                com.up366.mobile.user.account.switchaccount.SwitchAccountActivity.initController$lambda$1();
            }
        });
        com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> uSV5ListViewDataController4 = this.controller;
        if (uSV5ListViewDataController4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("controller");
            uSV5ListViewDataController4 = null;
        }
        uSV5ListViewDataController4.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountActivity$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() {
                com.up366.mobile.user.account.switchaccount.SwitchAccountActivity.initController$lambda$2();
            }
        });
        com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> uSV5ListViewDataController5 = this.controller;
        if (uSV5ListViewDataController5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("controller");
            uSV5ListViewDataController5 = null;
        }
        uSV5ListViewDataController5.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountActivity$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                com.up366.mobile.user.account.switchaccount.SwitchAccountActivity.initController$lambda$3(this.f$0, list, list2);
            }
        });
        com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> uSV5ListViewDataController6 = this.controller;
        if (uSV5ListViewDataController6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("controller");
            uSV5ListViewDataController6 = null;
        }
        com.up366.mobile.user.account.switchaccount.SwitchAccountAdapter switchAccountAdapter = this.adapter;
        if (switchAccountAdapter == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("adapter");
            switchAccountAdapter = null;
        }
        uSV5ListViewDataController6.setAdapter(switchAccountAdapter);
        com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> uSV5ListViewDataController7 = this.controller;
        if (uSV5ListViewDataController7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("controller");
            uSV5ListViewDataController7 = null;
        }
        uSV5ListViewDataController7.setEnable(true);
        com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> uSV5ListViewDataController8 = this.controller;
        if (uSV5ListViewDataController8 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("controller");
        } else {
            uSV5ListViewDataController2 = uSV5ListViewDataController8;
        }
        uSV5ListViewDataController2.onLoadLocalData(new java.lang.Object());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initController$lambda$3(com.up366.mobile.user.account.switchaccount.SwitchAccountActivity switchAccountActivity, java.util.List list, java.util.List list2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list2, "datas");
        int size = switchAccountActivity.helper.getAccountList().size();
        if (size > 3 && !switchAccountActivity.isEdit) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(5, ""));
        }
        java.util.Iterator<com.up366.mobile.user.account.switchaccount.SwitchAccountData> it = switchAccountActivity.helper.getAccountList().iterator();
        while (it.hasNext()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, it.next()));
        }
        if (size <= 3 && !switchAccountActivity.isEdit) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(5, ""));
        }
        list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_16DP, 5));
        list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_16DP, 5));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View p0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding = this.binding;
        com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding2 = null;
        if (activitySwitchAccountLayoutBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySwitchAccountLayoutBinding = null;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(p0, activitySwitchAccountLayoutBinding.back)) {
            finish();
            return;
        }
        com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding3 = this.binding;
        if (activitySwitchAccountLayoutBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySwitchAccountLayoutBinding3 = null;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(p0, activitySwitchAccountLayoutBinding3.manageBtn)) {
            com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding4 = this.binding;
            if (activitySwitchAccountLayoutBinding4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                activitySwitchAccountLayoutBinding4 = null;
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual(activitySwitchAccountLayoutBinding4.manageBtn.getText(), "管理")) {
                this.isEdit = true;
                com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding5 = this.binding;
                if (activitySwitchAccountLayoutBinding5 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activitySwitchAccountLayoutBinding5 = null;
                }
                activitySwitchAccountLayoutBinding5.manageBtn.setText("取消");
                switchEditState(true);
                com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding6 = this.binding;
                if (activitySwitchAccountLayoutBinding6 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activitySwitchAccountLayoutBinding6 = null;
                }
                activitySwitchAccountLayoutBinding6.tip.setText("清除登录痕迹");
                com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding7 = this.binding;
                if (activitySwitchAccountLayoutBinding7 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activitySwitchAccountLayoutBinding2 = activitySwitchAccountLayoutBinding7;
                }
                activitySwitchAccountLayoutBinding2.subTip.setVisibility(0);
                return;
            }
            this.isEdit = false;
            com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding8 = this.binding;
            if (activitySwitchAccountLayoutBinding8 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                activitySwitchAccountLayoutBinding8 = null;
            }
            activitySwitchAccountLayoutBinding8.manageBtn.setText("管理");
            switchEditState(false);
            com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding9 = this.binding;
            if (activitySwitchAccountLayoutBinding9 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                activitySwitchAccountLayoutBinding9 = null;
            }
            activitySwitchAccountLayoutBinding9.tip.setText("轻触头像以切换账号");
            com.up366.mobile.databinding.ActivitySwitchAccountLayoutBinding activitySwitchAccountLayoutBinding10 = this.binding;
            if (activitySwitchAccountLayoutBinding10 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activitySwitchAccountLayoutBinding2 = activitySwitchAccountLayoutBinding10;
            }
            activitySwitchAccountLayoutBinding2.subTip.setVisibility(8);
        }
    }

    private final void switchEditState(boolean isEdit) {
        this.helper.switchEditState(isEdit);
        com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> uSV5ListViewDataController = this.controller;
        if (uSV5ListViewDataController == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("controller");
            uSV5ListViewDataController = null;
        }
        uSV5ListViewDataController.onLoadLocalData(new java.lang.Object());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(com.up366.mobile.common.event.SwitchAccountDeleteEvent event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        com.up366.common.log.Logger.info("SwitchAccountActivity onMessageEvent: " + event);
        com.up366.mobile.user.account.switchaccount.SwitchAccountHelper switchAccountHelper = this.helper;
        com.up366.mobile.user.account.switchaccount.SwitchAccountData info = event.getInfo();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(info, "getInfo(...)");
        switchAccountHelper.deleteAccount(info);
        com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> uSV5ListViewDataController = this.controller;
        if (uSV5ListViewDataController == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("controller");
            uSV5ListViewDataController = null;
        }
        uSV5ListViewDataController.onLoadLocalData(new java.lang.Object());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(com.up366.mobile.common.event.SwitchLoginEvent event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "当前无法连接到网络，请连网后再试。");
            return;
        }
        final com.up366.mobile.user.account.switchaccount.SwitchAccountData switchAccountDataData = event.data();
        if (switchAccountDataData.getIsDelete()) {
            com.up366.common.log.Logger.info("SwitchAccount skip " + switchAccountDataData.getUserName() + " has logout");
            com.up366.mobile.user.account.login.AccountLoginActivity.open((android.content.Context) this, true, switchAccountDataData.getUserName());
            return;
        }
        com.up366.mobile.common.logic.Auth.cleanCookiesWhenSwitchAccount();
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountActivity$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.InterruptedException {
                com.up366.mobile.user.account.switchaccount.SwitchAccountActivity.onMessageEvent$lambda$5(switchAccountDataData, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessageEvent$lambda$5(final com.up366.mobile.user.account.switchaccount.SwitchAccountData switchAccountData, final com.up366.mobile.user.account.switchaccount.SwitchAccountActivity switchAccountActivity) throws java.lang.InterruptedException {
        final com.up366.common.http.NetHolder<java.lang.Object> netHolderDoLoginSync = com.up366.mobile.common.logic.Auth.mgr().doLoginSync(switchAccountData.getUserName(), switchAccountData.getPasswd(), true, switchAccountData.getAuthType(), switchAccountData.getOpenId(), true);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountActivity$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.user.account.switchaccount.SwitchAccountActivity.onMessageEvent$lambda$5$lambda$4(this.f$0, netHolderDoLoginSync, switchAccountData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onMessageEvent$lambda$5$lambda$4(com.up366.mobile.user.account.switchaccount.SwitchAccountActivity switchAccountActivity, com.up366.common.http.NetHolder netHolder, com.up366.mobile.user.account.switchaccount.SwitchAccountData switchAccountData) {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) switchAccountActivity);
        if (!netHolder.resp.isError()) {
            com.up366.mobile.main.PhonePasswordUpdateHelper.INSTANCE.removeAccount(switchAccountData.getUid());
            switchAccountActivity.startActivity(new android.content.Intent((android.content.Context) switchAccountActivity, (java.lang.Class<?>) com.up366.mobile.main.MainActivity.class));
            switchAccountActivity.finish();
            return;
        }
        int code = netHolder.resp.getCode();
        com.up366.common.log.Logger.info("SwitchAccount " + switchAccountData.getUserName() + " autologin: " + code);
        kotlin.jvm.internal.Intrinsics.checkNotNull(switchAccountData);
        switchAccountActivity.showErrorDialog(switchAccountData);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(com.up366.mobile.common.event.AuthLoginSuccess event) {
        finish();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(com.up366.mobile.common.event.FinishSwitchAccountActivityEvent event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showErrorDialog(final com.up366.mobile.user.account.switchaccount.SwitchAccountData data) {
        com.up366.mobile.common.dialog.AppDialog.create((android.content.Context) this).title("账号异常").message(data.getRealName() + "账号异常，无法正常切换，你可以【从列表删除】，或【去登录】重新添加账号").left("从列表删除", com.up366.common.DpUtilsUp.dp2px(130.0f), new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.account.switchaccount.SwitchAccountActivity.showErrorDialog$lambda$6(this.f$0, data, view);
            }
        }).setBtnCloseVisibility(4).right(" 去登录 ", com.up366.common.DpUtilsUp.dp2px(130.0f), new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.account.switchaccount.SwitchAccountActivity.showErrorDialog$lambda$7(this.f$0, data, view);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showErrorDialog$lambda$6(com.up366.mobile.user.account.switchaccount.SwitchAccountActivity switchAccountActivity, com.up366.mobile.user.account.switchaccount.SwitchAccountData switchAccountData, android.view.View view) {
        switchAccountActivity.helper.deleteAccount(switchAccountData);
        com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> uSV5ListViewDataController = switchAccountActivity.controller;
        if (uSV5ListViewDataController == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("controller");
            uSV5ListViewDataController = null;
        }
        uSV5ListViewDataController.onLoadLocalData(new java.lang.Object());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showErrorDialog$lambda$7(com.up366.mobile.user.account.switchaccount.SwitchAccountActivity switchAccountActivity, com.up366.mobile.user.account.switchaccount.SwitchAccountData switchAccountData, android.view.View view) {
        com.up366.mobile.user.account.login.AccountLoginActivity.open((android.content.Context) switchAccountActivity, true, switchAccountData.getUserName());
    }
}
