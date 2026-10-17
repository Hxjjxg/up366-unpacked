package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class PictureBaseActivity extends androidx.appcompat.app.AppCompatActivity {
    protected int colorPrimary;
    protected int colorPrimaryDark;
    protected com.up366.medialibrary.config.PictureSelectionConfig config;
    protected android.view.View container;
    protected boolean isOnSaveInstanceState;
    protected com.up366.medialibrary.loader.IBridgeMediaLoader mLoader;
    protected com.up366.medialibrary.common.dialog.PictureLoadingDialog mLoadingDialog;
    protected boolean numComplete;
    protected boolean openWhiteStatusBar;
    protected java.util.List<com.up366.medialibrary.model.LocalMedia> selectionMedias = new java.util.ArrayList();
    protected android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    protected boolean isHasMore = true;
    protected int mPage = 1;

    /* JADX WARN: Multi-variable type inference failed */
    protected android.content.Context getContext() {
        return this;
    }

    public abstract int getResourceId();

    protected void initCompleteText(int i) {
    }

    protected void initCompleteText(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
    }

    protected void initPictureSelectorStyle() {
    }

    protected void initWidgets() {
    }

    public boolean isImmersive() {
        return true;
    }

    public boolean isRequestedOrientation() {
        return true;
    }

    protected void showPermissionsDialog(boolean z, java.lang.String[] strArr, java.lang.String str) {
    }

    public void immersive() {
        com.up366.medialibrary.common.utils.ImmersiveManage.immersiveAboveAPI23(this, this.colorPrimaryDark, this.colorPrimary, this.openWhiteStatusBar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(android.os.Bundle bundle) {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = com.up366.medialibrary.config.PictureSelectionConfig.getInstance();
        this.config = pictureSelectionConfig;
        if (pictureSelectionConfig.language != -2) {
            com.up366.medialibrary.common.language.PictureLanguageUtils.setAppLanguage(getContext(), this.config.language);
        }
        setTheme(this.config.themeStyleId == 0 ? com.up366.medialibrary.R.style.picture_default_style : this.config.themeStyleId);
        super.onCreate(bundle);
        newCreateEngine();
        newCreateResultCallbackListener();
        if (isRequestedOrientation()) {
            setNewRequestedOrientation();
        }
        initConfig();
        if (isImmersive()) {
            immersive();
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_navBarColor != 0) {
                com.up366.medialibrary.common.utils.NavBarUtils.setNavBarColor((android.app.Activity) this, com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_navBarColor);
            }
        } else if (com.up366.medialibrary.config.PictureSelectionConfig.style != null && com.up366.medialibrary.config.PictureSelectionConfig.style.pictureNavBarColor != 0) {
            com.up366.medialibrary.common.utils.NavBarUtils.setNavBarColor((android.app.Activity) this, com.up366.medialibrary.config.PictureSelectionConfig.style.pictureNavBarColor);
        }
        int resourceId = getResourceId();
        if (resourceId != 0) {
            setContentView(resourceId);
        }
        initLoader();
        initWidgets();
        initPictureSelectorStyle();
        this.isOnSaveInstanceState = false;
    }

    protected void initLoader() {
        if (this.config.isPageStrategy) {
            this.mLoader = new com.up366.medialibrary.loader.LocalMediaPageLoader(getContext(), this.config);
        } else {
            this.mLoader = new com.up366.medialibrary.loader.LocalMediaLoader(getContext(), this.config);
        }
    }

    private void newCreateEngine() {
        com.up366.medialibrary.common.engine.PictureSelectorEngine pictureSelectorEngine;
        if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine != null || (pictureSelectorEngine = com.up366.medialibrary.app.PictureAppMaster.getInstance().getPictureSelectorEngine()) == null) {
            return;
        }
        com.up366.medialibrary.config.PictureSelectionConfig.imageEngine = pictureSelectorEngine.createEngine();
    }

    private void newCreateResultCallbackListener() {
        com.up366.medialibrary.common.engine.PictureSelectorEngine pictureSelectorEngine;
        if (this.config.isCallbackMode && com.up366.medialibrary.config.PictureSelectionConfig.listener == null && (pictureSelectorEngine = com.up366.medialibrary.app.PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.listener = pictureSelectorEngine.getResultCallbackListener();
        }
    }

    protected void attachBaseContext(android.content.Context context) {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig == null || pictureSelectionConfig.language == -2) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(com.up366.medialibrary.activity.PictureContextWrapper.wrap(context, this.config.language));
        }
    }

    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.config.language != -2) {
            com.up366.medialibrary.common.language.PictureLanguageUtils.setAppLanguage(getContext(), this.config.language);
        }
    }

    protected void setNewRequestedOrientation() {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig == null || pictureSelectionConfig.camera) {
            return;
        }
        setRequestedOrientation(this.config.requestedOrientation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initConfig() {
        if (this.config.selectionMedias != null) {
            this.selectionMedias.clear();
            this.selectionMedias.addAll(this.config.selectionMedias);
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
            this.openWhiteStatusBar = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_statusBarChangeTextColor;
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleBarBackgroundColor != 0) {
                this.colorPrimary = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleBarBackgroundColor;
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_statusBarBackgroundColor != 0) {
                this.colorPrimaryDark = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_statusBarBackgroundColor;
            }
            this.numComplete = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_switchSelectTotalStyle;
            this.config.checkNumMode = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_switchSelectNumberStyle;
        } else if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
            this.openWhiteStatusBar = com.up366.medialibrary.config.PictureSelectionConfig.style.isChangeStatusBarFontColor;
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleBarBackgroundColor != 0) {
                this.colorPrimary = com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleBarBackgroundColor;
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureStatusBarColor != 0) {
                this.colorPrimaryDark = com.up366.medialibrary.config.PictureSelectionConfig.style.pictureStatusBarColor;
            }
            this.numComplete = com.up366.medialibrary.config.PictureSelectionConfig.style.isOpenCompletedNumStyle;
            this.config.checkNumMode = com.up366.medialibrary.config.PictureSelectionConfig.style.isOpenCheckNumStyle;
        } else {
            boolean z = this.config.isChangeStatusBarFontColor;
            this.openWhiteStatusBar = z;
            if (!z) {
                this.openWhiteStatusBar = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueBoolean(this, com.up366.medialibrary.R.attr.picture_statusFontColor);
            }
            boolean z2 = this.config.isOpenStyleNumComplete;
            this.numComplete = z2;
            if (!z2) {
                this.numComplete = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueBoolean(this, com.up366.medialibrary.R.attr.picture_style_numComplete);
            }
            com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = this.config;
            pictureSelectionConfig.checkNumMode = pictureSelectionConfig.isOpenStyleCheckNumMode;
            if (!this.config.checkNumMode) {
                this.config.checkNumMode = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueBoolean(this, com.up366.medialibrary.R.attr.picture_style_checkNumMode);
            }
            if (this.config.titleBarBackgroundColor != 0) {
                this.colorPrimary = this.config.titleBarBackgroundColor;
            } else {
                this.colorPrimary = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(this, com.up366.medialibrary.R.attr.colorPrimary);
            }
            if (this.config.pictureStatusBarColor != 0) {
                this.colorPrimaryDark = this.config.pictureStatusBarColor;
            } else {
                this.colorPrimaryDark = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(this, com.up366.medialibrary.R.attr.colorPrimaryDark);
            }
        }
        if (this.config.openClickSound) {
            com.up366.medialibrary.common.utils.VoiceUtils.getInstance().init(getContext());
        }
    }

    protected void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.isOnSaveInstanceState = true;
        bundle.putParcelable(com.up366.medialibrary.config.PictureConstants.EXTRA_CONFIG, this.config);
    }

    protected void showPleaseDialog() {
        try {
            if (isFinishing()) {
                return;
            }
            if (this.mLoadingDialog == null) {
                this.mLoadingDialog = new com.up366.medialibrary.common.dialog.PictureLoadingDialog(getContext());
            }
            if (this.mLoadingDialog.isShowing()) {
                this.mLoadingDialog.dismiss();
            }
            this.mLoadingDialog.show();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    protected void dismissDialog() {
        if (isFinishing()) {
            return;
        }
        try {
            com.up366.medialibrary.common.dialog.PictureLoadingDialog pictureLoadingDialog = this.mLoadingDialog;
            if (pictureLoadingDialog == null || !pictureLoadingDialog.isShowing()) {
                return;
            }
            this.mLoadingDialog.dismiss();
        } catch (java.lang.Exception e) {
            this.mLoadingDialog = null;
            e.printStackTrace();
        }
    }

    protected void compressImage(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        if (com.up366.medialibrary.config.PictureSelectionConfig.compressEngine != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.compressEngine.onCompress(getContext(), list, new com.up366.medialibrary.listener.OnCallbackListener<java.util.List<com.up366.medialibrary.model.LocalMedia>>() { // from class: com.up366.medialibrary.activity.PictureBaseActivity.1
                @Override // com.up366.medialibrary.listener.OnCallbackListener
                public void onCall(java.util.List<com.up366.medialibrary.model.LocalMedia> list2) {
                    com.up366.medialibrary.activity.PictureBaseActivity.this.onResult(list2);
                }
            });
        } else {
            showPleaseDialog();
            compressToLuban(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void compressToLuban(final java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        if (this.config.synOrAsy) {
            com.up366.medialibrary.common.utils.PictureThreadUtils.executeByIo(new com.up366.medialibrary.common.utils.PictureThreadUtils.SimpleTask<java.util.List<com.up366.medialibrary.model.LocalMedia>>() { // from class: com.up366.medialibrary.activity.PictureBaseActivity.2
                @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
                public java.util.List<com.up366.medialibrary.model.LocalMedia> doInBackground() throws java.lang.Exception {
                    return com.up366.medialibrary.common.compress.Luban.with(com.up366.medialibrary.activity.PictureBaseActivity.this.getContext()).loadMediaData(list).isCamera(com.up366.medialibrary.activity.PictureBaseActivity.this.config.camera).setTargetDir(com.up366.medialibrary.activity.PictureBaseActivity.this.config.compressSavePath).setCompressQuality(com.up366.medialibrary.activity.PictureBaseActivity.this.config.compressQuality).isAutoRotating(com.up366.medialibrary.activity.PictureBaseActivity.this.config.isAutoRotating).setFocusAlpha(com.up366.medialibrary.activity.PictureBaseActivity.this.config.focusAlpha).setNewCompressFileName(com.up366.medialibrary.activity.PictureBaseActivity.this.config.renameCompressFileName).ignoreBy(com.up366.medialibrary.activity.PictureBaseActivity.this.config.minimumCompressSize).get();
                }

                @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
                public void onSuccess(java.util.List<com.up366.medialibrary.model.LocalMedia> list2) {
                    com.up366.medialibrary.common.utils.PictureThreadUtils.cancel(com.up366.medialibrary.common.utils.PictureThreadUtils.getIoPool());
                    com.up366.medialibrary.activity.PictureBaseActivity.this.onResult(list2);
                }
            });
        } else {
            com.up366.medialibrary.common.compress.Luban.with(this).loadMediaData(list).ignoreBy(this.config.minimumCompressSize).isCamera(this.config.camera).setCompressQuality(this.config.compressQuality).setTargetDir(this.config.compressSavePath).isAutoRotating(this.config.isAutoRotating).setFocusAlpha(this.config.focusAlpha).setNewCompressFileName(this.config.renameCompressFileName).setCompressListener(new com.up366.medialibrary.common.compress.OnCompressListener() { // from class: com.up366.medialibrary.activity.PictureBaseActivity.3
                @Override // com.up366.medialibrary.common.compress.OnCompressListener
                public void onStart() {
                }

                @Override // com.up366.medialibrary.common.compress.OnCompressListener
                public void onSuccess(java.util.List<com.up366.medialibrary.model.LocalMedia> list2) {
                    com.up366.medialibrary.activity.PictureBaseActivity.this.onResult(list2);
                }

                @Override // com.up366.medialibrary.common.compress.OnCompressListener
                public void onError(java.lang.Throwable th) {
                    com.up366.medialibrary.activity.PictureBaseActivity.this.onResult(list);
                }
            }).launch();
        }
    }

    protected void handlerResult(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        if (this.config.isCompress) {
            compressImage(list);
        } else {
            onResult(list);
        }
    }

    protected void createNewFolder(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
        if (list.size() == 0) {
            com.up366.medialibrary.model.LocalMediaFolder localMediaFolder = new com.up366.medialibrary.model.LocalMediaFolder();
            localMediaFolder.setName(getString(this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio() ? com.up366.medialibrary.R.string.picture_all_audio : com.up366.medialibrary.R.string.picture_camera_roll));
            localMediaFolder.setFirstImagePath("");
            localMediaFolder.setCameraFolder(true);
            localMediaFolder.setBucketId(-1L);
            localMediaFolder.setChecked(true);
            list.add(localMediaFolder);
        }
    }

    protected com.up366.medialibrary.model.LocalMediaFolder getImageFolder(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
        if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) {
            str2 = str;
        }
        java.io.File parentFile = new java.io.File(str2).getParentFile();
        for (com.up366.medialibrary.model.LocalMediaFolder localMediaFolder : list) {
            if (parentFile != null && localMediaFolder.getName().equals(parentFile.getName())) {
                return localMediaFolder;
            }
        }
        com.up366.medialibrary.model.LocalMediaFolder localMediaFolder2 = new com.up366.medialibrary.model.LocalMediaFolder();
        localMediaFolder2.setName(parentFile != null ? parentFile.getName() : "");
        localMediaFolder2.setFirstImagePath(str);
        localMediaFolder2.setFirstMimeType(str3);
        list.add(localMediaFolder2);
        return localMediaFolder2;
    }

    protected void onResult(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() && this.config.isAndroidQTransform) {
            onResultToAndroidAsy(list);
            return;
        }
        dismissDialog();
        if (this.config.camera && this.config.selectionMode == 2) {
            list.addAll(list.size() > 0 ? list.size() - 1 : 0, this.selectionMedias);
        }
        if (this.config.isCheckOriginalImage) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.up366.medialibrary.model.LocalMedia localMedia = list.get(i);
                localMedia.setOriginal(true);
                localMedia.setOriginalPath(localMedia.getPath());
            }
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.listener != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.listener.onResult(list);
        } else {
            setResult(-1, com.up366.medialibrary.PictureSelector.putIntentResult(list));
        }
        exit();
    }

    private void onResultToAndroidAsy(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.up366.medialibrary.model.LocalMedia localMedia = list.get(i);
            if (localMedia != null && !android.text.TextUtils.isEmpty(localMedia.getPath()) && (this.config.isCheckOriginalImage || (!localMedia.isCut() && !localMedia.isCompressed() && !localMedia.isToSandboxPath()))) {
                startThreadCopySandbox(list);
                return;
            }
        }
        normalResult(list);
    }

    private void normalResult(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.up366.medialibrary.model.LocalMedia localMedia = list.get(i);
            if (localMedia != null && !android.text.TextUtils.isEmpty(localMedia.getPath())) {
                if (localMedia.isCut() && localMedia.isCompressed()) {
                    localMedia.setAndroidQToPath(localMedia.getCompressPath());
                }
                if (this.config.isCheckOriginalImage) {
                    localMedia.setOriginal(true);
                    localMedia.setOriginalPath(localMedia.getAndroidQToPath());
                }
            }
        }
        if (this.config.camera && this.config.selectionMode == 2) {
            list.addAll(list.size() > 0 ? list.size() - 1 : 0, this.selectionMedias);
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.listener != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.listener.onResult(list);
        } else {
            setResult(-1, com.up366.medialibrary.PictureSelector.putIntentResult(list));
        }
        exit();
    }

    private void startThreadCopySandbox(final java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        showPleaseDialog();
        com.up366.medialibrary.common.utils.PictureThreadUtils.executeByIo(new com.up366.medialibrary.common.utils.PictureThreadUtils.SimpleTask<java.util.List<com.up366.medialibrary.model.LocalMedia>>() { // from class: com.up366.medialibrary.activity.PictureBaseActivity.4
            /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00c5 A[SYNTHETIC] */
            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.util.List<com.up366.medialibrary.model.LocalMedia> doInBackground() {
                /*
                    Method dump skipped, instruction units count: 204
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.up366.medialibrary.activity.PictureBaseActivity.AnonymousClass4.doInBackground():java.util.List");
            }

            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public void onSuccess(java.util.List<com.up366.medialibrary.model.LocalMedia> list2) {
                com.up366.medialibrary.common.utils.PictureThreadUtils.cancel(com.up366.medialibrary.common.utils.PictureThreadUtils.getIoPool());
                com.up366.medialibrary.activity.PictureBaseActivity.this.dismissDialog();
                if (list2 != null) {
                    if (com.up366.medialibrary.activity.PictureBaseActivity.this.config.camera && com.up366.medialibrary.activity.PictureBaseActivity.this.config.selectionMode == 2) {
                        list2.addAll(list2.size() > 0 ? list2.size() - 1 : 0, com.up366.medialibrary.activity.PictureBaseActivity.this.selectionMedias);
                    }
                    if (com.up366.medialibrary.config.PictureSelectionConfig.listener != null) {
                        com.up366.medialibrary.config.PictureSelectionConfig.listener.onResult(list2);
                    } else {
                        com.up366.medialibrary.activity.PictureBaseActivity.this.setResult(-1, com.up366.medialibrary.PictureSelector.putIntentResult(list2));
                    }
                    com.up366.medialibrary.activity.PictureBaseActivity.this.exit();
                }
            }
        });
    }

    protected void exit() {
        finish();
        if (this.config.camera) {
            overridePendingTransition(0, com.up366.medialibrary.R.anim.picture_anim_fade_out);
            if ((getContext() instanceof com.up366.medialibrary.activity.PictureSelectorCameraEmptyActivity) || (getContext() instanceof com.up366.medialibrary.activity.PictureCustomCameraActivity)) {
                releaseResultListener();
                return;
            }
            return;
        }
        overridePendingTransition(0, com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityExitAnimation);
        if (getContext() instanceof com.up366.medialibrary.activity.PictureSelectorActivity) {
            releaseResultListener();
            if (this.config.openClickSound) {
                com.up366.medialibrary.common.utils.VoiceUtils.getInstance().releaseSoundPool();
            }
        }
    }

    protected void onDestroy() {
        com.up366.medialibrary.common.dialog.PictureLoadingDialog pictureLoadingDialog = this.mLoadingDialog;
        if (pictureLoadingDialog != null) {
            pictureLoadingDialog.dismiss();
            this.mLoadingDialog = null;
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    protected java.lang.String getAudioPath(android.content.Intent intent) {
        try {
            android.net.Uri data = intent.getData();
            if (data == null) {
                return "";
            }
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(data.toString())) {
                return data.toString();
            }
            return data.getPath();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void startCustomCamera() {
        startActivityForResult(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.medialibrary.activity.PictureCustomCameraActivity.class), com.up366.medialibrary.config.PictureConstants.REQUEST_CAMERA);
        overridePendingTransition(com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, com.up366.medialibrary.R.anim.picture_anim_fade_in);
    }

    protected void startOpenCameraImage() {
        if (this.config.isUseCustomCamera) {
            startCustomCamera();
            return;
        }
        android.content.Intent intent = new android.content.Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            android.net.Uri uriCreateCameraOutImageUri = com.up366.medialibrary.common.utils.CameraFileUtils.createCameraOutImageUri(getContext(), this.config);
            if (uriCreateCameraOutImageUri != null) {
                if (this.config.isCameraAroundState) {
                    intent.putExtra(com.up366.medialibrary.config.PictureConstants.CAMERA_FACING, 1);
                }
                intent.putExtra("output", uriCreateCameraOutImageUri);
                startActivityForResult(intent, com.up366.medialibrary.config.PictureConstants.REQUEST_CAMERA);
                return;
            }
            com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), "open is camera error，the uri is empty ");
            if (this.config.camera) {
                exit();
            }
        }
    }

    protected void startOpenCameraVideo() {
        if (this.config.isUseCustomCamera) {
            startCustomCamera();
            return;
        }
        android.content.Intent intent = new android.content.Intent("android.media.action.VIDEO_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            android.net.Uri uriCreateCameraOutVideoUri = com.up366.medialibrary.common.utils.CameraFileUtils.createCameraOutVideoUri(getContext(), this.config);
            if (uriCreateCameraOutVideoUri != null) {
                intent.putExtra("output", uriCreateCameraOutVideoUri);
                if (this.config.isCameraAroundState) {
                    intent.putExtra(com.up366.medialibrary.config.PictureConstants.CAMERA_FACING, 1);
                }
                intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_QUICK_CAPTURE, this.config.isQuickCapture);
                intent.putExtra("android.intent.extra.durationLimit", this.config.recordVideoSecond);
                intent.putExtra("android.intent.extra.videoQuality", this.config.videoQuality);
                startActivityForResult(intent, com.up366.medialibrary.config.PictureConstants.REQUEST_CAMERA);
                return;
            }
            com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), "open is camera error，the uri is empty ");
            if (this.config.camera) {
                exit();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startOpenCameraAudio() {
        try {
            if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO)) {
                android.content.Intent intent = new android.content.Intent("android.provider.MediaStore.RECORD_SOUND");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    android.net.Uri uriCreateCameraOutAudioUri = com.up366.medialibrary.common.utils.CameraFileUtils.createCameraOutAudioUri(getContext(), this.config);
                    if (uriCreateCameraOutAudioUri != null) {
                        intent.putExtra("output", uriCreateCameraOutAudioUri);
                        startActivityForResult(intent, com.up366.medialibrary.config.PictureConstants.REQUEST_CAMERA);
                    } else {
                        com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), "open is audio error，the uri is empty ");
                        if (this.config.camera) {
                            exit();
                        }
                    }
                } else {
                    com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), "System recording is not supported");
                }
            } else {
                com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO}, 3);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), e.getMessage());
        }
    }

    private void releaseResultListener() {
        if (this.config != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.destroy();
            com.up366.medialibrary.common.utils.PictureThreadUtils.cancel(com.up366.medialibrary.common.utils.PictureThreadUtils.getIoPool());
            com.up366.medialibrary.common.io.ArrayPoolProvide.getInstance().clearMemory();
        }
    }

    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 3) {
            if (iArr[0] == 0) {
                android.content.Intent intent = new android.content.Intent("android.provider.MediaStore.RECORD_SOUND");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, com.up366.medialibrary.config.PictureConstants.REQUEST_CAMERA);
                    return;
                }
                return;
            }
            com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), getString(com.up366.medialibrary.R.string.picture_audio));
        }
    }

    protected void showPromptDialog(java.lang.String str) {
        if (isFinishing()) {
            return;
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.onChooseLimitCallback != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.onChooseLimitCallback.onChooseLimit(getContext(), str);
            return;
        }
        final com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog = new com.up366.medialibrary.common.dialog.PictureCustomDialog(getContext(), com.up366.medialibrary.R.layout.picture_prompt_dialog);
        android.widget.TextView textView = (android.widget.TextView) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.btnOk);
        ((android.widget.TextView) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.tv_content)).setText(str);
        textView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureBaseActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.up366.medialibrary.activity.PictureBaseActivity.this.isFinishing()) {
                    return;
                }
                pictureCustomDialog.dismiss();
            }
        });
        pictureCustomDialog.show();
    }

    protected void sortFolder(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.medialibrary.activity.PictureBaseActivity$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.medialibrary.activity.PictureBaseActivity.lambda$sortFolder$0((com.up366.medialibrary.model.LocalMediaFolder) obj, (com.up366.medialibrary.model.LocalMediaFolder) obj2);
            }
        });
    }

    static /* synthetic */ int lambda$sortFolder$0(com.up366.medialibrary.model.LocalMediaFolder localMediaFolder, com.up366.medialibrary.model.LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.getData() == null || localMediaFolder2.getData() == null) {
            return 0;
        }
        return java.lang.Integer.compare(localMediaFolder2.getImageNum(), localMediaFolder.getImageNum());
    }
}
