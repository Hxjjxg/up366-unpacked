package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureSelectorCameraEmptyActivity extends com.up366.medialibrary.activity.PictureBaseActivity {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public void immersive() {
        com.up366.medialibrary.common.utils.ImmersiveManage.immersiveAboveAPI23(this, androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.picture_color_transparent), androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.picture_color_transparent), this.openWhiteStatusBar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (this.config == null) {
            exit();
            return;
        }
        if (this.config.isUseCustomCamera) {
            return;
        }
        setActivitySize();
        if (bundle == null) {
            if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE)) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.onCustomCameraInterfaceListener != null) {
                    if (this.config.chooseMode == 2) {
                        com.up366.medialibrary.config.PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, 2);
                        return;
                    } else {
                        com.up366.medialibrary.config.PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, 1);
                        return;
                    }
                }
                onTakePhoto();
                return;
            }
            com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    private void setActivitySize() {
        android.view.Window window = getWindow();
        window.setGravity(51);
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public int getResourceId() {
        return com.up366.medialibrary.R.layout.picture_empty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onTakePhoto() {
        if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.CAMERA)) {
            startCamera();
        } else {
            com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, 2);
        }
    }

    private void startCamera() {
        int i = this.config.chooseMode;
        if (i == 0 || i == 1) {
            startOpenCameraImage();
        } else if (i == 2) {
            startOpenCameraVideo();
        } else {
            if (i != 3) {
                return;
            }
            startOpenCameraAudio();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int i, int i2, android.content.Intent intent) throws java.lang.Throwable {
        java.lang.Throwable th;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 69) {
                singleCropHandleResult(intent);
                return;
            } else {
                if (i != 909) {
                    return;
                }
                dispatchHandleCamera(intent);
                return;
            }
        }
        if (i2 == 0) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.listener != null) {
                com.up366.medialibrary.config.PictureSelectionConfig.listener.onCancel();
            }
            if (i == 909) {
                com.up366.medialibrary.common.utils.MediaUtils.deleteCamera(this, this.config.cameraPath);
            }
            exit();
            return;
        }
        if (i2 != 96 || intent == null || (th = (java.lang.Throwable) intent.getSerializableExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_ERROR)) == null) {
            return;
        }
        com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), th.getMessage());
    }

    protected void singleCropHandleResult(android.content.Intent intent) throws java.io.IOException {
        if (intent == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.net.Uri output = com.up366.medialibrary.third.ucrop.UCrop.getOutput(intent);
        if (output == null) {
            return;
        }
        java.lang.String path = output.getPath();
        boolean zIsEmpty = android.text.TextUtils.isEmpty(path);
        com.up366.medialibrary.model.LocalMedia localMedia = com.up366.medialibrary.model.LocalMedia.parseLocalMedia(this.config.cameraPath, this.config.isCamera ? 1 : 0, this.config.chooseMode);
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            int iLastIndexOf = android.text.TextUtils.isEmpty(this.config.cameraPath) ? 0 : this.config.cameraPath.lastIndexOf("/") + 1;
            localMedia.setId(iLastIndexOf > 0 ? com.up366.medialibrary.common.utils.ValueOf.toLong(this.config.cameraPath.substring(iLastIndexOf)) : java.lang.System.currentTimeMillis());
            localMedia.setAndroidQToPath(path);
        } else {
            localMedia.setId(java.lang.System.currentTimeMillis());
        }
        localMedia.setCut(!zIsEmpty);
        localMedia.setCutPath(path);
        localMedia.setMimeType(com.up366.medialibrary.common.utils.MimeTypeUtils.getImageMimeType(path));
        localMedia.setCropImageWidth(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, 0));
        localMedia.setCropImageHeight(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, 0));
        localMedia.setCropOffsetX(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_OFFSET_X, 0));
        localMedia.setCropOffsetY(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_OFFSET_Y, 0));
        localMedia.setCropResultAspectRatio(intent.getFloatExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, 0.0f));
        localMedia.setEditorImage(intent.getBooleanExtra("com.up366.medialibrary.third.ucrop.EditorImage", false));
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(localMedia.getPath())) {
            localMedia.setRealPath(com.up366.medialibrary.common.utils.PictureFileUtils.getPath(getContext(), android.net.Uri.parse(localMedia.getPath())));
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType())) {
                com.up366.medialibrary.model.MediaExtraInfo videoSize = com.up366.medialibrary.common.utils.MediaUtils.getVideoSize(getContext(), localMedia.getPath());
                localMedia.setWidth(videoSize.getWidth());
                localMedia.setHeight(videoSize.getHeight());
            } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia.getMimeType())) {
                com.up366.medialibrary.model.MediaExtraInfo imageSize = com.up366.medialibrary.common.utils.MediaUtils.getImageSize(getContext(), localMedia.getPath());
                localMedia.setWidth(imageSize.getWidth());
                localMedia.setHeight(imageSize.getHeight());
            }
        } else {
            localMedia.setRealPath(localMedia.getPath());
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType())) {
                com.up366.medialibrary.model.MediaExtraInfo videoSize2 = com.up366.medialibrary.common.utils.MediaUtils.getVideoSize(getContext(), localMedia.getPath());
                localMedia.setWidth(videoSize2.getWidth());
                localMedia.setHeight(videoSize2.getHeight());
            } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia.getMimeType())) {
                com.up366.medialibrary.model.MediaExtraInfo imageSize2 = com.up366.medialibrary.common.utils.MediaUtils.getImageSize(getContext(), localMedia.getPath());
                localMedia.setWidth(imageSize2.getWidth());
                localMedia.setHeight(imageSize2.getHeight());
            }
        }
        java.io.File file = new java.io.File(localMedia.getRealPath());
        localMedia.setSize(file.length());
        localMedia.setFileName(file.getName());
        arrayList.add(localMedia);
        handlerResult(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void dispatchHandleCamera(android.content.Intent intent) throws java.lang.Throwable {
        java.lang.String imageMimeType;
        int dCIMLastImageId;
        try {
            if (this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio()) {
                this.config.cameraMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio();
                this.config.cameraPath = getAudioPath(intent);
                if (android.text.TextUtils.isEmpty(this.config.cameraPath)) {
                    return;
                }
                if (com.up366.medialibrary.common.utils.SdkVersionUtils.isR()) {
                    try {
                        android.net.Uri uriCreateAudioUri = com.up366.medialibrary.common.utils.CameraFileUtils.createAudioUri(getContext(), android.text.TextUtils.isEmpty(this.config.cameraAudioFormatForQ) ? this.config.suffixType : this.config.cameraAudioFormatForQ);
                        if (uriCreateAudioUri != null) {
                            com.up366.medialibrary.common.utils.PictureFileUtils.writeFileFromIS(com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(this, android.net.Uri.parse(this.config.cameraPath)), com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenOutputStream(this, uriCreateAudioUri));
                            this.config.cameraPath = uriCreateAudioUri.toString();
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (android.text.TextUtils.isEmpty(this.config.cameraPath)) {
                return;
            }
            com.up366.medialibrary.model.LocalMedia localMedia = new com.up366.medialibrary.model.LocalMedia();
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(this.config.cameraPath)) {
                java.lang.String path = com.up366.medialibrary.common.utils.PictureFileUtils.getPath(getContext(), android.net.Uri.parse(this.config.cameraPath));
                java.io.File file = new java.io.File(path);
                imageMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.getImageMimeType(path, this.config.cameraMimeType);
                localMedia.setSize(file.length());
                localMedia.setFileName(file.getName());
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(imageMimeType)) {
                    com.up366.medialibrary.model.MediaExtraInfo imageSize = com.up366.medialibrary.common.utils.MediaUtils.getImageSize(getContext(), this.config.cameraPath);
                    localMedia.setWidth(imageSize.getWidth());
                    localMedia.setHeight(imageSize.getHeight());
                } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(imageMimeType)) {
                    com.up366.medialibrary.model.MediaExtraInfo videoSize = com.up366.medialibrary.common.utils.MediaUtils.getVideoSize(getContext(), this.config.cameraPath);
                    localMedia.setWidth(videoSize.getWidth());
                    localMedia.setHeight(videoSize.getHeight());
                    localMedia.setDuration(videoSize.getDuration());
                } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHasAudio(imageMimeType)) {
                    localMedia.setDuration(com.up366.medialibrary.common.utils.MediaUtils.getAudioSize(getContext(), this.config.cameraPath).getDuration());
                }
                int iLastIndexOf = android.text.TextUtils.isEmpty(this.config.cameraPath) ? 0 : this.config.cameraPath.lastIndexOf("/") + 1;
                localMedia.setId(iLastIndexOf > 0 ? com.up366.medialibrary.common.utils.ValueOf.toLong(this.config.cameraPath.substring(iLastIndexOf)) : java.lang.System.currentTimeMillis());
                localMedia.setRealPath(path);
                java.lang.String stringExtra = intent != null ? intent.getStringExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_MEDIA_PATH) : null;
                localMedia.setAndroidQToPath(com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(stringExtra) ? null : stringExtra);
                localMedia.setBucketId(com.up366.medialibrary.common.utils.AlbumUtils.generateCameraBucketId(getContext(), file, ""));
                localMedia.setDateAddedTime(file.lastModified() / 1000);
            } else {
                java.io.File file2 = new java.io.File(this.config.cameraPath);
                imageMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.getImageMimeType(this.config.cameraPath, this.config.cameraMimeType);
                localMedia.setSize(file2.length());
                localMedia.setFileName(file2.getName());
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(imageMimeType)) {
                    com.up366.medialibrary.common.utils.BitmapUtils.rotateImage(getContext(), this.config.isCameraRotateImage, this.config.cameraPath);
                    com.up366.medialibrary.model.MediaExtraInfo imageSize2 = com.up366.medialibrary.common.utils.MediaUtils.getImageSize(getContext(), this.config.cameraPath);
                    localMedia.setWidth(imageSize2.getWidth());
                    localMedia.setHeight(imageSize2.getHeight());
                } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(imageMimeType)) {
                    com.up366.medialibrary.model.MediaExtraInfo videoSize2 = com.up366.medialibrary.common.utils.MediaUtils.getVideoSize(getContext(), this.config.cameraPath);
                    localMedia.setWidth(videoSize2.getWidth());
                    localMedia.setHeight(videoSize2.getHeight());
                    localMedia.setDuration(videoSize2.getDuration());
                } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHasAudio(imageMimeType)) {
                    localMedia.setDuration(com.up366.medialibrary.common.utils.MediaUtils.getAudioSize(getContext(), this.config.cameraPath).getDuration());
                }
                localMedia.setId(java.lang.System.currentTimeMillis());
                localMedia.setRealPath(this.config.cameraPath);
                java.lang.String stringExtra2 = intent != null ? intent.getStringExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_MEDIA_PATH) : null;
                if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
                    if (!android.text.TextUtils.isEmpty(stringExtra2) && !com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(stringExtra2)) {
                        localMedia.setAndroidQToPath(stringExtra2);
                    } else {
                        localMedia.setAndroidQToPath(this.config.cameraPath);
                    }
                }
                localMedia.setBucketId(com.up366.medialibrary.common.utils.AlbumUtils.generateCameraBucketId(getContext(), file2, this.config.outPutCameraPath));
                localMedia.setDateAddedTime(file2.lastModified() / 1000);
            }
            localMedia.setPath(this.config.cameraPath);
            localMedia.setMimeType(imageMimeType);
            localMedia.setParentFolderName(com.up366.medialibrary.common.utils.AlbumUtils.generateCameraFolderName(this.config.cameraPath, imageMimeType, this.config.outPutCameraPath));
            localMedia.setChooseModel(this.config.chooseMode);
            dispatchCameraHandleResult(localMedia);
            if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType()) && com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(this.config.cameraPath)) {
                    if (this.config.isFallbackVersion3) {
                        new com.up366.medialibrary.lib.PictureMediaScannerConnection(getContext(), localMedia.getRealPath());
                        return;
                    } else {
                        sendBroadcast(new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", android.net.Uri.fromFile(new java.io.File(localMedia.getRealPath()))));
                        return;
                    }
                }
                return;
            }
            if (this.config.isFallbackVersion3) {
                new com.up366.medialibrary.lib.PictureMediaScannerConnection(getContext(), this.config.cameraPath);
            } else {
                sendBroadcast(new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", android.net.Uri.fromFile(new java.io.File(this.config.cameraPath))));
            }
            if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia.getMimeType()) || (dCIMLastImageId = com.up366.medialibrary.common.utils.MediaUtils.getDCIMLastImageId(getContext())) == -1) {
                return;
            }
            com.up366.medialibrary.common.utils.MediaUtils.removeMedia(getContext(), dCIMLastImageId);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void dispatchCameraHandleResult(com.up366.medialibrary.model.LocalMedia localMedia) {
        boolean zIsImage = com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia.getMimeType());
        if (this.config.enableCrop && !this.config.isCheckOriginalImage && zIsImage) {
            this.config.originalPath = this.config.cameraPath;
            com.up366.medialibrary.manager.UCropManager.ofCrop(this, this.config.cameraPath, localMedia.getMimeType(), localMedia.getWidth(), localMedia.getHeight());
        } else if (this.config.isCompress && zIsImage) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(localMedia);
            compressImage(arrayList);
        } else {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            arrayList2.add(localMedia);
            onResult(arrayList2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, 2);
                return;
            } else {
                com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), getString(com.up366.medialibrary.R.string.picture_jurisdiction));
                exit();
                return;
            }
        }
        if (i != 2) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            onTakePhoto();
        } else {
            exit();
            com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), getString(com.up366.medialibrary.R.string.picture_camera));
        }
    }

    public void onBackPressed() {
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        exit();
    }
}
