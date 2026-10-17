package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureCustomCameraActivity extends com.up366.medialibrary.activity.PictureSelectorCameraEmptyActivity {
    private static final java.lang.String TAG = "PictureCustomCameraActivity";
    protected boolean isEnterSetting;
    private com.up366.medialibrary.camera.CustomCameraView mCameraView;

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public boolean isImmersive() {
        return false;
    }

    @Override // com.up366.medialibrary.activity.PictureSelectorCameraEmptyActivity, com.up366.medialibrary.activity.PictureBaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(67108864, 67108864);
        getWindow().setFlags(134217728, 134217728);
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
            com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(attributes, 1);
            getWindow().setAttributes(attributes);
        }
        getWindow().addFlags(128);
        super.onCreate(bundle);
        setContentView(com.up366.medialibrary.R.layout.picture_custom_camera);
        this.mCameraView = (com.up366.medialibrary.camera.CustomCameraView) findViewById(com.up366.medialibrary.R.id.cameraView);
        initView();
        requestCamera();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void requestCamera() {
        if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE)) {
            if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.CAMERA)) {
                if (this.config.buttonFeatures == 257) {
                    this.mCameraView.initCamera();
                    return;
                } else if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO)) {
                    this.mCameraView.initCamera();
                    return;
                } else {
                    com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO}, 4);
                    return;
                }
            }
            com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, 2);
            return;
        }
        com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onResume() {
        super.onResume();
        if (this.isEnterSetting) {
            if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE)) {
                if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.CAMERA)) {
                    if (this.config.buttonFeatures == 257 || com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO)) {
                        this.mCameraView.initCamera();
                    } else {
                        com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO}, 4);
                    }
                } else {
                    showPermissionsDialog(false, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, getString(com.up366.medialibrary.R.string.picture_camera));
                }
            } else {
                showPermissionsDialog(false, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE}, getString(com.up366.medialibrary.R.string.picture_jurisdiction));
            }
            this.isEnterSetting = false;
        }
    }

    protected void initView() {
        if (this.config.recordVideoSecond > 0) {
            this.mCameraView.setRecordVideoMaxTime(this.config.recordVideoSecond);
        }
        if (this.config.recordVideoMinSecond > 0) {
            this.mCameraView.setRecordVideoMinTime(this.config.recordVideoMinSecond);
        }
        this.mCameraView.setCaptureLoadingColor(this.config.captureLoadingColor);
        com.up366.medialibrary.camera.view.CaptureLayout captureLayout = this.mCameraView.getCaptureLayout();
        if (captureLayout != null) {
            captureLayout.setButtonFeatures(this.config.buttonFeatures);
        }
        this.mCameraView.setImageCallbackListener(new com.up366.medialibrary.camera.listener.ImageCallbackListener() { // from class: com.up366.medialibrary.activity.PictureCustomCameraActivity$$ExternalSyntheticLambda0
            @Override // com.up366.medialibrary.camera.listener.ImageCallbackListener
            public final void onLoadImage(java.lang.String str, android.widget.ImageView imageView) {
                this.f$0.m145x235e2274(str, imageView);
            }
        });
        this.mCameraView.setCameraListener(new com.up366.medialibrary.camera.listener.CameraListener() { // from class: com.up366.medialibrary.activity.PictureCustomCameraActivity.1
            @Override // com.up366.medialibrary.camera.listener.CameraListener
            public void onPictureSuccess(java.lang.String str) {
                com.up366.medialibrary.activity.PictureCustomCameraActivity.this.config.cameraMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage();
                android.content.Intent intent = new android.content.Intent();
                intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_MEDIA_PATH, str);
                intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_CONFIG, com.up366.medialibrary.activity.PictureCustomCameraActivity.this.config);
                if (com.up366.medialibrary.activity.PictureCustomCameraActivity.this.config.camera) {
                    com.up366.medialibrary.activity.PictureCustomCameraActivity.this.dispatchHandleCamera(intent);
                } else {
                    com.up366.medialibrary.activity.PictureCustomCameraActivity.this.setResult(-1, intent);
                    com.up366.medialibrary.activity.PictureCustomCameraActivity.this.onBackPressed();
                }
            }

            @Override // com.up366.medialibrary.camera.listener.CameraListener
            public void onRecordSuccess(java.lang.String str) {
                com.up366.medialibrary.activity.PictureCustomCameraActivity.this.config.cameraMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo();
                android.content.Intent intent = new android.content.Intent();
                intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_MEDIA_PATH, str);
                intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_CONFIG, com.up366.medialibrary.activity.PictureCustomCameraActivity.this.config);
                if (com.up366.medialibrary.activity.PictureCustomCameraActivity.this.config.camera) {
                    com.up366.medialibrary.activity.PictureCustomCameraActivity.this.dispatchHandleCamera(intent);
                } else {
                    com.up366.medialibrary.activity.PictureCustomCameraActivity.this.setResult(-1, intent);
                    com.up366.medialibrary.activity.PictureCustomCameraActivity.this.onBackPressed();
                }
            }

            @Override // com.up366.medialibrary.camera.listener.CameraListener
            public void onError(int i, java.lang.String str, java.lang.Throwable th) {
                android.util.Log.i(com.up366.medialibrary.activity.PictureCustomCameraActivity.TAG, "onError: " + str);
            }
        });
        this.mCameraView.setOnClickListener(new com.up366.medialibrary.camera.listener.ClickListener() { // from class: com.up366.medialibrary.activity.PictureCustomCameraActivity.2
            @Override // com.up366.medialibrary.camera.listener.ClickListener
            public void onClick() {
                com.up366.medialibrary.activity.PictureCustomCameraActivity.this.onBackPressed();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initView$0$com-up366-medialibrary-activity-PictureCustomCameraActivity, reason: not valid java name */
    /* synthetic */ void m145x235e2274(java.lang.String str, android.widget.ImageView imageView) {
        if (this.config == null || com.up366.medialibrary.config.PictureSelectionConfig.imageEngine == null) {
            return;
        }
        com.up366.medialibrary.config.PictureSelectionConfig.imageEngine.loadImage(getContext(), str, imageView);
    }

    @Override // com.up366.medialibrary.activity.PictureSelectorCameraEmptyActivity
    public void onBackPressed() {
        if (this.config != null && this.config.camera && com.up366.medialibrary.config.PictureSelectionConfig.listener != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.listener.onCancel();
        }
        exit();
    }

    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i == 4) {
            this.mCameraView.onCancelMedia();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.medialibrary.activity.PictureSelectorCameraEmptyActivity, com.up366.medialibrary.activity.PictureBaseActivity
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        if (i == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, 2);
                return;
            } else {
                showPermissionsDialog(true, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE}, getString(com.up366.medialibrary.R.string.picture_jurisdiction));
                return;
            }
        }
        if (i != 2) {
            if (i != 4) {
                return;
            }
            if (iArr.length > 0 && iArr[0] == 0) {
                this.mCameraView.initCamera();
                return;
            } else {
                showPermissionsDialog(false, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO}, getString(com.up366.medialibrary.R.string.picture_audio));
                return;
            }
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO)) {
                this.mCameraView.initCamera();
                return;
            } else {
                com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO}, 4);
                return;
            }
        }
        showPermissionsDialog(true, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, getString(com.up366.medialibrary.R.string.picture_camera));
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void showPermissionsDialog(boolean z, java.lang.String[] strArr, java.lang.String str) {
        if (isFinishing()) {
            return;
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.onPermissionsObtainCallback != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.onPermissionsObtainCallback.onPermissionsIntercept(getContext(), z, strArr, str, new com.up366.medialibrary.listener.OnPermissionDialogOptionCallback() { // from class: com.up366.medialibrary.activity.PictureCustomCameraActivity.3
                @Override // com.up366.medialibrary.listener.OnPermissionDialogOptionCallback
                public void onCancel() {
                    if (com.up366.medialibrary.config.PictureSelectionConfig.listener != null) {
                        com.up366.medialibrary.config.PictureSelectionConfig.listener.onCancel();
                    }
                    com.up366.medialibrary.activity.PictureCustomCameraActivity.this.exit();
                }

                @Override // com.up366.medialibrary.listener.OnPermissionDialogOptionCallback
                public void onSetting() {
                    com.up366.medialibrary.activity.PictureCustomCameraActivity.this.isEnterSetting = true;
                }
            });
            return;
        }
        final com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog = new com.up366.medialibrary.common.dialog.PictureCustomDialog(getContext(), com.up366.medialibrary.R.layout.picture_wind_base_dialog);
        pictureCustomDialog.setCancelable(false);
        pictureCustomDialog.setCanceledOnTouchOutside(false);
        android.widget.Button button = (android.widget.Button) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.btn_cancel);
        android.widget.Button button2 = (android.widget.Button) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.btn_commit);
        button2.setText(getString(com.up366.medialibrary.R.string.picture_go_setting));
        android.widget.TextView textView = (android.widget.TextView) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.tvTitle);
        android.widget.TextView textView2 = (android.widget.TextView) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.tv_content);
        textView.setText(getString(com.up366.medialibrary.R.string.picture_prompt));
        textView2.setText(str);
        button.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureCustomCameraActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m146x17882b35(pictureCustomDialog, view);
            }
        });
        button2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureCustomCameraActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m147xd1fdcbb6(pictureCustomDialog, view);
            }
        });
        pictureCustomDialog.show();
    }

    /* JADX INFO: renamed from: lambda$showPermissionsDialog$1$com-up366-medialibrary-activity-PictureCustomCameraActivity, reason: not valid java name */
    /* synthetic */ void m146x17882b35(com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog, android.view.View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.listener != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.listener.onCancel();
        }
        exit();
    }

    /* JADX INFO: renamed from: lambda$showPermissionsDialog$2$com-up366-medialibrary-activity-PictureCustomCameraActivity, reason: not valid java name */
    /* synthetic */ void m147xd1fdcbb6(com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog, android.view.View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        com.up366.medialibrary.common.permissions.PermissionChecker.launchAppDetailsSettings(getContext());
        this.isEnterSetting = true;
    }
}
