package com.up366.mobile.me.userinfo;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeSwitchHeadPhotoActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding binding;
    private java.lang.String customizePhoto;
    private java.util.List<com.up366.mobile.common.logic.model.UserPhoto> localDataS;
    private com.up366.mobile.common.logic.model.UserCustomPhotoStatus photoStatus;
    private android.view.View saveBtn;
    private com.up366.mobile.common.logic.model.UserPhoto systemUserPhoto;
    private boolean updateBySystemPhoto = false;
    private boolean hasCancel = false;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_modify_picture";
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        com.up366.qmui.util.QMUIStatusBarHelper.translucent((android.app.Activity) this);
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarDarkMode(this);
        com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding meSwitchHeadPhotoActivityLayoutBinding = (com.up366.mobile.databinding.MeSwitchHeadPhotoActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.me_switch_head_photo_activity_layout);
        this.binding = meSwitchHeadPhotoActivityLayoutBinding;
        com.bumptech.glide.Glide.with(meSwitchHeadPhotoActivityLayoutBinding.mePhotoImgLoading).asGif().load(java.lang.Integer.valueOf(com.up366.mobile.R.drawable.loading)).into(this.binding.mePhotoImgLoading);
        this.photoStatus = com.up366.mobile.common.logic.Auth.cur().info().loadCustomPhotoStatus();
        initView();
    }

    private void initView() {
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.headPhotoRule, new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(view);
            }
        });
        this.binding.updateByUser.setVisibility(8);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.updateByUser, new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$8(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.updateBySystem, new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$11(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.confirmUpdateBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$12(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.confirmCancelBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$13(view);
            }
        });
        showPhoto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$1(android.view.View view) {
        final com.up366.bottomsheet.BottomSheetBuilder bottomSheetBuilder = new com.up366.bottomsheet.BottomSheetBuilder(this);
        android.view.View viewInflate = android.view.LayoutInflater.from(this).inflate(com.up366.mobile.R.layout.me_photo_rules_layout, (android.view.ViewGroup) null);
        viewInflate.findViewById(com.up366.mobile.R.id.close_btn).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                bottomSheetBuilder.dismiss();
            }
        });
        bottomSheetBuilder.setView(viewInflate).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$8(android.view.View view) {
        if (this.photoStatus.isChecking()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "审核中，不能更换哦~");
            return;
        }
        this.updateBySystemPhoto = false;
        final com.up366.bottomsheet.BottomSheetBuilder bottomSheetBuilder = new com.up366.bottomsheet.BottomSheetBuilder(this);
        android.view.View viewInflate = android.view.LayoutInflater.from(this).inflate(com.up366.mobile.R.layout.me_photo_user_bottom_check_layout, (android.view.ViewGroup) null);
        viewInflate.findViewById(com.up366.mobile.R.id.take_photo).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                this.f$0.lambda$initView$3(bottomSheetBuilder, view2);
            }
        });
        viewInflate.findViewById(com.up366.mobile.R.id.album_btn).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                this.f$0.lambda$initView$5(bottomSheetBuilder, view2);
            }
        });
        viewInflate.findViewById(com.up366.mobile.R.id.cancel_btn).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                bottomSheetBuilder.dismiss();
            }
        });
        viewInflate.findViewById(com.up366.mobile.R.id.close_btn).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                bottomSheetBuilder.dismiss();
            }
        });
        bottomSheetBuilder.setView(viewInflate).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(final com.up366.bottomsheet.BottomSheetBuilder bottomSheetBuilder, android.view.View view) {
        com.up366.mobile.common.utils.PermissionUtils.checkCameraPermission(com.up366.common.global.GB.get().getCurrentActivity(), "拍照自定义头像", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda5
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                this.f$0.lambda$initView$2(bottomSheetBuilder, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$2(com.up366.bottomsheet.BottomSheetBuilder bottomSheetBuilder, int i, java.lang.String str) {
        bottomSheetBuilder.dismiss();
        if (i != 0) {
            return;
        }
        com.up366.medialibrary.PictureSelector.create((android.app.Activity) this).openCamera(com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage()).isEnableCrop(true).forResult(new com.up366.medialibrary.listener.OnResultCallbackListener<com.up366.medialibrary.model.LocalMedia>() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.1
            @Override // com.up366.medialibrary.listener.OnResultCallbackListener
            public void onCancel() {
            }

            @Override // com.up366.medialibrary.listener.OnResultCallbackListener
            public void onResult(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
                com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.this.customizePhoto = list.get(0).getCutPath();
                com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.this.binding.confirmCancelBtn.setVisibility(0);
                com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.this.binding.confirmUpdateBtn.setVisibility(0);
                com.up366.common.BitmapUtilsUp.display(com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.this.binding.mePhotoImg, com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.this.customizePhoto, com.up366.mobile.R.drawable.icon_head_photo_default);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(final com.up366.bottomsheet.BottomSheetBuilder bottomSheetBuilder, android.view.View view) {
        com.up366.mobile.common.utils.PermissionUtils.checkReadStoragePermission(com.up366.common.global.GB.get().getCurrentActivity(), "相册选择头像", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda1
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                this.f$0.lambda$initView$4(bottomSheetBuilder, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$4(com.up366.bottomsheet.BottomSheetBuilder bottomSheetBuilder, int i, java.lang.String str) {
        bottomSheetBuilder.dismiss();
        if (i != 0) {
            return;
        }
        com.up366.medialibrary.PictureSelector.create((android.app.Activity) this).openGallery(com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage()).isPageStrategy(true).isEnableCrop(true).isCompress(true).isCamera(false).isDisplayOriginalSize(false).maxSelectNum(1).isWithVideoImage(true).setPictureUIStyle(com.up366.medialibrary.common.style.PictureSelectorUIStyle.ofUp366Style()).isMaxSelectEnabledMask(true).isOriginalImageControl(false).forResult(new com.up366.medialibrary.listener.OnResultCallbackListener<com.up366.medialibrary.model.LocalMedia>() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.2
            @Override // com.up366.medialibrary.listener.OnResultCallbackListener
            public void onCancel() {
            }

            @Override // com.up366.medialibrary.listener.OnResultCallbackListener
            public void onResult(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
                com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.this.customizePhoto = list.get(0).getCutPath();
                com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.this.binding.confirmCancelBtn.setVisibility(0);
                com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.this.binding.confirmUpdateBtn.setVisibility(0);
                com.up366.common.BitmapUtilsUp.display(com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.this.binding.mePhotoImg, com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.this.customizePhoto, com.up366.mobile.R.drawable.icon_head_photo_default);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$11(android.view.View view) {
        if (this.photoStatus.isChecking()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "审核中，不能更换哦~");
            return;
        }
        this.updateBySystemPhoto = true;
        final com.up366.bottomsheet.BottomSheetBuilder bottomSheetBuilder = new com.up366.bottomsheet.BottomSheetBuilder(this);
        android.view.View viewInflate = android.view.LayoutInflater.from(this).inflate(com.up366.mobile.R.layout.me_photo_system_photos_layout, (android.view.ViewGroup) null);
        viewInflate.findViewById(com.up366.mobile.R.id.close_btn).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                bottomSheetBuilder.dismiss();
            }
        });
        android.view.View viewFindViewById = viewInflate.findViewById(com.up366.mobile.R.id.confirm_btn);
        this.saveBtn = viewFindViewById;
        viewFindViewById.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                this.f$0.lambda$initView$10(bottomSheetBuilder, view2);
            }
        });
        androidx.recyclerview.widget.RecyclerView recyclerViewFindViewById = viewInflate.findViewById(com.up366.mobile.R.id.recycle_view);
        com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivityAdapter meSwitchHeadPhotoActivityAdapter = new com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivityAdapter();
        com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.UserPhoto> controller = getController(recyclerViewFindViewById, meSwitchHeadPhotoActivityAdapter);
        recyclerViewFindViewById.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(this, 1));
        recyclerViewFindViewById.setAdapter(meSwitchHeadPhotoActivityAdapter);
        bottomSheetBuilder.setView(viewInflate).show();
        controller.loadLocalData();
        controller.loadWebData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$10(com.up366.bottomsheet.BottomSheetBuilder bottomSheetBuilder, android.view.View view) {
        this.binding.confirmCancelBtn.setVisibility(0);
        this.binding.confirmUpdateBtn.setVisibility(0);
        com.up366.common.BitmapUtilsUp.display(this.binding.mePhotoImg, this.systemUserPhoto.getUrl(), com.up366.mobile.R.drawable.icon_head_photo_default);
        bottomSheetBuilder.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$12(android.view.View view) {
        this.hasCancel = false;
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "网络异常，请重试");
            return;
        }
        if (this.updateBySystemPhoto) {
            if (this.systemUserPhoto.getUrl().equals(com.up366.mobile.common.logic.Auth.getUserInfo().getPhotoUrl())) {
                com.up366.common.http.Response response = new com.up366.common.http.Response();
                response.setCode(0);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.MeHeadPhotoUpdateEvent(response, this.systemUserPhoto.getUrl()));
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "上传中，请稍后...");
                this.binding.mePhotoImgLoading.setVisibility(0);
                this.binding.mePhotoImgMeng.setVisibility(0);
                this.binding.mePhotoImgMeng.setText("");
                com.up366.mobile.common.logic.Auth.cur().info().updateUserPhoto(this.systemUserPhoto.getUrl());
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "上传中，请稍后...");
        this.binding.mePhotoImgLoading.setVisibility(0);
        this.binding.mePhotoImgMeng.setVisibility(0);
        this.binding.mePhotoImgMeng.setText("");
        final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(this.customizePhoto, "", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfoSaveSync, new com.up366.mobile.common.utils.alifile.IOSSCallback() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.3
            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onProgress(long j, long j2) {
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onSuccess() {
                com.up366.common.log.Logger.info("TAG - MeSwitchHeadPhotoActivity - onSuccess - ");
                com.up366.mobile.common.logic.Auth.cur().info().saveCustomPhoto(fileMapInfoSaveSync.getUrl());
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onFailure(int i, java.lang.String str) {
                com.up366.common.http.Response response2 = new com.up366.common.http.Response();
                response2.setCode(i);
                response2.setInfo(str);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.MeHeadPhotoUpdateEvent(response2, com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.this.customizePhoto));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$13(android.view.View view) {
        this.hasCancel = true;
        this.binding.confirmCancelBtn.setVisibility(4);
        this.binding.confirmUpdateBtn.setVisibility(4);
        this.binding.mePhotoImgLoading.setVisibility(8);
        this.binding.mePhotoImgMeng.setVisibility(8);
        com.up366.common.BitmapUtilsUp.display(this.binding.mePhotoImg, com.up366.mobile.common.logic.Auth.getUserInfo().getPhotoUrl(), com.up366.mobile.R.drawable.icon_head_photo_default);
    }

    private void showPhoto() {
        if (this.photoStatus.isChecking()) {
            this.binding.updateByUser.setEnabled(false);
            this.binding.mePhotoImgMeng.setVisibility(0);
            this.binding.mePhotoImgMeng.setText("审核中");
            com.up366.common.BitmapUtilsUp.display(this.binding.mePhotoImg, this.photoStatus.getHeadPhoto(), com.up366.mobile.R.drawable.icon_head_photo_default);
            return;
        }
        com.up366.common.BitmapUtilsUp.display(this.binding.mePhotoImg, com.up366.mobile.common.logic.Auth.getUserInfo().getPhotoUrl(), com.up366.mobile.R.drawable.icon_head_photo_default);
        if (this.photoStatus.isCheckOk()) {
            long addTime = this.photoStatus.getAddTime() + com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3;
            if (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() < addTime) {
                this.binding.updateByUser.setEnabled(false);
                this.binding.tipText.setVisibility(0);
                this.binding.tipText.setText(com.up366.common.TimeUtils.formatTime(addTime, "yyyy-MM-dd 00:00 后可再次自定义"));
                return;
            }
            return;
        }
        if (this.photoStatus.isCheckFail()) {
            this.photoStatus.checkShowErrorTipStatus();
        }
        if (this.photoStatus.isNeedShowErrorTip()) {
            this.binding.jiao.setVisibility(0);
            this.binding.mePhotoErrorText.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.UserPhoto> getController(final androidx.recyclerview.widget.RecyclerView recyclerView, com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivityAdapter meSwitchHeadPhotoActivityAdapter) {
        final com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.UserPhoto> uSV5ListViewDataController = new com.up366.mobile.common.base.USV5ListViewDataController<>(this);
        uSV5ListViewDataController.setLocalLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$getController$15(recyclerView, uSV5ListViewDataController);
            }
        });
        uSV5ListViewDataController.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda11
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$getController$17(recyclerView, uSV5ListViewDataController);
            }
        });
        uSV5ListViewDataController.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda14
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state3).setTipMessage("没有可以选择的头像呀！").build()));
            }
        });
        uSV5ListViewDataController.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda15
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.lambda$getController$19(list, list2);
            }
        });
        uSV5ListViewDataController.setErrorViewClickAction(new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda16
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                this.f$0.lambda$getController$21(recyclerView, uSV5ListViewDataController, i);
            }
        });
        uSV5ListViewDataController.setAdapter(meSwitchHeadPhotoActivityAdapter);
        uSV5ListViewDataController.setEnable(true);
        return uSV5ListViewDataController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getController$15(final androidx.recyclerview.widget.RecyclerView recyclerView, final com.up366.mobile.common.base.USV5ListViewDataController uSV5ListViewDataController) throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().info().loadUserPhotoList(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$getController$14(recyclerView, uSV5ListViewDataController, response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getController$14(androidx.recyclerview.widget.RecyclerView recyclerView, com.up366.mobile.common.base.USV5ListViewDataController uSV5ListViewDataController, com.up366.common.http.Response response, java.util.List list) {
        setDataS(list, recyclerView);
        uSV5ListViewDataController.onLoadLocalData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getController$17(final androidx.recyclerview.widget.RecyclerView recyclerView, final com.up366.mobile.common.base.USV5ListViewDataController uSV5ListViewDataController) throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().info().fetchPhotoList(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda13
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$getController$16(recyclerView, uSV5ListViewDataController, response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getController$16(androidx.recyclerview.widget.RecyclerView recyclerView, com.up366.mobile.common.base.USV5ListViewDataController uSV5ListViewDataController, com.up366.common.http.Response response, java.util.List list) {
        java.util.List<com.up366.mobile.common.logic.model.UserPhoto> list2 = this.localDataS;
        if (list2 == null || list2.size() <= 0) {
            setDataS(list, recyclerView);
            uSV5ListViewDataController.onLoadWebData(response, list);
        }
    }

    static /* synthetic */ void lambda$getController$19(java.util.List list, java.util.List list2) {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, (com.up366.mobile.common.logic.model.UserPhoto) it.next()));
        }
        list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_16DP, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getController$21(final androidx.recyclerview.widget.RecyclerView recyclerView, final com.up366.mobile.common.base.USV5ListViewDataController uSV5ListViewDataController, int i) {
        com.up366.mobile.common.logic.Auth.cur().info().fetchPhotoList(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity$$ExternalSyntheticLambda12
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$getController$20(recyclerView, uSV5ListViewDataController, response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getController$20(androidx.recyclerview.widget.RecyclerView recyclerView, com.up366.mobile.common.base.USV5ListViewDataController uSV5ListViewDataController, com.up366.common.http.Response response, java.util.List list) {
        setDataS(list, recyclerView);
        uSV5ListViewDataController.onLoadWebData(response, list);
    }

    private void setDataS(java.util.List<com.up366.mobile.common.logic.model.UserPhoto> list, androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.localDataS = list;
        androidx.recyclerview.widget.GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof androidx.recyclerview.widget.GridLayoutManager) {
            layoutManager.setSpanCount((list == null || list.size() == 0) ? 1 : 4);
        }
        this.saveBtn.setVisibility(8);
        if (list == null || list.size() == 0) {
            return;
        }
        this.saveBtn.setVisibility(0);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onPause() {
        super.onPause();
        this.binding.jiao.setVisibility(8);
        this.binding.mePhotoErrorText.setVisibility(8);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDestroy();
    }

    public static void openPage(android.content.Context context) {
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.me.userinfo.MeSwitchHeadPhotoActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.MeHeadPhotoUpdateEvent meHeadPhotoUpdateEvent) {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        if (this.hasCancel) {
            return;
        }
        this.binding.mePhotoImgLoading.setVisibility(8);
        this.binding.mePhotoImgMeng.setVisibility(8);
        if (!meHeadPhotoUpdateEvent.response.isError()) {
            this.binding.confirmUpdateBtn.setVisibility(8);
            this.binding.confirmCancelBtn.setVisibility(8);
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) this, this.updateBySystemPhoto ? "更换成功" : "上传成功，等待审核");
            if (this.updateBySystemPhoto) {
                return;
            }
            this.binding.mePhotoImgMeng.setVisibility(0);
            this.binding.mePhotoImgMeng.setText("审核中");
            this.binding.updateByUser.setEnabled(false);
            this.photoStatus.setStatus(0);
            com.up366.mobile.common.logic.Auth.cur().info().fetchCustomPhotoStatus(null);
            return;
        }
        com.up366.common.log.Logger.error("save head photo error : " + meHeadPhotoUpdateEvent.response);
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, com.up366.common.NetworkUtilsUp.isConnected() ? "服务器异常，请重试" : "网络异常，请重试");
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.SelectHeadPhotoEvent selectHeadPhotoEvent) {
        this.systemUserPhoto = selectHeadPhotoEvent.photoData;
        this.saveBtn.setEnabled(!selectHeadPhotoEvent.photoData.getUrl().equals(com.up366.mobile.common.logic.Auth.getUserInfo().getPhotoUrl()));
    }
}
