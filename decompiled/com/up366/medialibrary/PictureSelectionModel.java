package com.up366.medialibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureSelectionModel {
    private final com.up366.medialibrary.config.PictureSelectionConfig selectionConfig;
    private final com.up366.medialibrary.PictureSelector selector;

    public PictureSelectionModel(com.up366.medialibrary.PictureSelector pictureSelector, int i) {
        this.selector = pictureSelector;
        com.up366.medialibrary.config.PictureSelectionConfig cleanInstance = com.up366.medialibrary.config.PictureSelectionConfig.getCleanInstance();
        this.selectionConfig = cleanInstance;
        cleanInstance.chooseMode = i;
        initCustomCameraFeatures();
        imageEngine(com.up366.medialibrary.common.engine.GlideEngine.createGlideEngine());
    }

    public PictureSelectionModel(com.up366.medialibrary.PictureSelector pictureSelector, int i, boolean z) {
        this.selector = pictureSelector;
        com.up366.medialibrary.config.PictureSelectionConfig cleanInstance = com.up366.medialibrary.config.PictureSelectionConfig.getCleanInstance();
        this.selectionConfig = cleanInstance;
        cleanInstance.camera = z;
        cleanInstance.chooseMode = i;
        initCustomCameraFeatures();
        imageEngine(com.up366.medialibrary.common.engine.GlideEngine.createGlideEngine());
    }

    public com.up366.medialibrary.PictureSelectionModel theme(int i) {
        this.selectionConfig.themeStyleId = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setPictureUIStyle(com.up366.medialibrary.common.style.PictureSelectorUIStyle pictureSelectorUIStyle) {
        if (pictureSelectorUIStyle != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.uiStyle = pictureSelectorUIStyle;
            if (!this.selectionConfig.isWeChatStyle) {
                this.selectionConfig.isWeChatStyle = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.isNewSelectStyle;
            }
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setLanguage(int i) {
        this.selectionConfig.language = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setRequestedOrientation(int i) {
        this.selectionConfig.requestedOrientation = i;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel loadImageEngine(com.up366.medialibrary.common.engine.ImageEngine imageEngine) {
        if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine != imageEngine) {
            com.up366.medialibrary.config.PictureSelectionConfig.imageEngine = imageEngine;
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel imageEngine(com.up366.medialibrary.common.engine.ImageEngine imageEngine) {
        if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine != imageEngine) {
            com.up366.medialibrary.config.PictureSelectionConfig.imageEngine = imageEngine;
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel compressEngine(com.up366.medialibrary.common.engine.CompressEngine compressEngine) {
        if (com.up366.medialibrary.config.PictureSelectionConfig.compressEngine != compressEngine) {
            com.up366.medialibrary.config.PictureSelectionConfig.compressEngine = compressEngine;
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel selectionMode(int i) {
        this.selectionConfig.selectionMode = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isWeChatStyle(boolean z) {
        this.selectionConfig.isWeChatStyle = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isUseCustomCamera(boolean z) {
        this.selectionConfig.isUseCustomCamera = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel bindCustomPlayVideoCallback(com.up366.medialibrary.listener.OnVideoSelectedPlayCallback<com.up366.medialibrary.model.LocalMedia> onVideoSelectedPlayCallback) {
        com.up366.medialibrary.config.PictureSelectionConfig.customVideoPlayCallback = (com.up366.medialibrary.listener.OnVideoSelectedPlayCallback) new java.lang.ref.WeakReference(onVideoSelectedPlayCallback).get();
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel bindCustomPreviewCallback(com.up366.medialibrary.listener.OnCustomImagePreviewCallback<com.up366.medialibrary.model.LocalMedia> onCustomImagePreviewCallback) {
        com.up366.medialibrary.config.PictureSelectionConfig.onCustomImagePreviewCallback = (com.up366.medialibrary.listener.OnCustomImagePreviewCallback) new java.lang.ref.WeakReference(onCustomImagePreviewCallback).get();
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel bindPictureSelectorInterfaceListener(com.up366.medialibrary.listener.OnCustomCameraInterfaceListener onCustomCameraInterfaceListener) {
        com.up366.medialibrary.config.PictureSelectionConfig.onCustomCameraInterfaceListener = (com.up366.medialibrary.listener.OnCustomCameraInterfaceListener) new java.lang.ref.WeakReference(onCustomCameraInterfaceListener).get();
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel bindCustomCameraInterfaceListener(com.up366.medialibrary.listener.OnCustomCameraInterfaceListener onCustomCameraInterfaceListener) {
        com.up366.medialibrary.config.PictureSelectionConfig.onCustomCameraInterfaceListener = (com.up366.medialibrary.listener.OnCustomCameraInterfaceListener) new java.lang.ref.WeakReference(onCustomCameraInterfaceListener).get();
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel bindCustomPermissionsObtainListener(com.up366.medialibrary.listener.OnPermissionsObtainCallback onPermissionsObtainCallback) {
        com.up366.medialibrary.config.PictureSelectionConfig.onPermissionsObtainCallback = (com.up366.medialibrary.listener.OnPermissionsObtainCallback) new java.lang.ref.WeakReference(onPermissionsObtainCallback).get();
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel bindCustomChooseLimitListener(com.up366.medialibrary.listener.OnChooseLimitCallback onChooseLimitCallback) {
        com.up366.medialibrary.config.PictureSelectionConfig.onChooseLimitCallback = (com.up366.medialibrary.listener.OnChooseLimitCallback) new java.lang.ref.WeakReference(onChooseLimitCallback).get();
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel setButtonFeatures(int i) {
        this.selectionConfig.buttonFeatures = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setCustomCameraFeatures(int i) {
        if (this.selectionConfig.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage()) {
            this.selectionConfig.buttonFeatures = com.up366.medialibrary.camera.CustomCameraType.BUTTON_STATE_ONLY_CAPTURE;
        } else if (this.selectionConfig.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo()) {
            this.selectionConfig.buttonFeatures = com.up366.medialibrary.camera.CustomCameraType.BUTTON_STATE_ONLY_RECORDER;
        } else if (this.selectionConfig.ofAllCameraType == com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage()) {
            this.selectionConfig.buttonFeatures = com.up366.medialibrary.camera.CustomCameraType.BUTTON_STATE_ONLY_CAPTURE;
        } else if (this.selectionConfig.ofAllCameraType == com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo()) {
            this.selectionConfig.buttonFeatures = com.up366.medialibrary.camera.CustomCameraType.BUTTON_STATE_ONLY_RECORDER;
        } else {
            this.selectionConfig.buttonFeatures = i;
        }
        return this;
    }

    private com.up366.medialibrary.PictureSelectionModel initCustomCameraFeatures() {
        if (this.selectionConfig.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage()) {
            this.selectionConfig.buttonFeatures = com.up366.medialibrary.camera.CustomCameraType.BUTTON_STATE_ONLY_CAPTURE;
        } else if (this.selectionConfig.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo()) {
            this.selectionConfig.buttonFeatures = com.up366.medialibrary.camera.CustomCameraType.BUTTON_STATE_ONLY_RECORDER;
        } else if (this.selectionConfig.ofAllCameraType == com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage()) {
            this.selectionConfig.buttonFeatures = com.up366.medialibrary.camera.CustomCameraType.BUTTON_STATE_ONLY_CAPTURE;
        } else if (this.selectionConfig.ofAllCameraType == com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo()) {
            this.selectionConfig.buttonFeatures = com.up366.medialibrary.camera.CustomCameraType.BUTTON_STATE_ONLY_RECORDER;
        } else {
            this.selectionConfig.buttonFeatures = com.up366.medialibrary.camera.CustomCameraType.BUTTON_STATE_BOTH;
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setCaptureLoadingColor(int i) {
        this.selectionConfig.captureLoadingColor = i;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel enableCrop(boolean z) {
        this.selectionConfig.enableCrop = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isEnableCrop(boolean z) {
        this.selectionConfig.enableCrop = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel basicUCropConfig(com.up366.medialibrary.third.ucrop.UCrop.Options options) {
        this.selectionConfig.uCropOptions = options;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isMultipleSkipCrop(boolean z) {
        this.selectionConfig.isMultipleSkipCrop = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel enablePreviewAudio(boolean z) {
        this.selectionConfig.enablePreviewAudio = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isEnablePreviewAudio(boolean z) {
        this.selectionConfig.enablePreviewAudio = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel freeStyleCropEnabled(boolean z) {
        this.selectionConfig.freeStyleCropEnabled = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel freeStyleCropMode(int i) {
        this.selectionConfig.freeStyleCropMode = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isCropDragSmoothToCenter(boolean z) {
        this.selectionConfig.isDragCenter = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel scaleEnabled(boolean z) {
        this.selectionConfig.scaleEnabled = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel rotateEnabled(boolean z) {
        this.selectionConfig.rotateEnabled = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel circleDimmedLayer(boolean z) {
        this.selectionConfig.circleDimmedLayer = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel setCircleDimmedColor(int i) {
        this.selectionConfig.circleDimmedColor = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setCropDimmedColor(int i) {
        this.selectionConfig.circleDimmedColor = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setCircleDimmedBorderColor(int i) {
        this.selectionConfig.circleDimmedBorderColor = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setCircleStrokeWidth(int i) {
        this.selectionConfig.circleStrokeWidth = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel showCropFrame(boolean z) {
        this.selectionConfig.showCropFrame = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel showCropGrid(boolean z) {
        this.selectionConfig.showCropGrid = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel hideBottomControls(boolean z) {
        this.selectionConfig.hideBottomControls = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel withAspectRatio(int i, int i2) {
        this.selectionConfig.aspect_ratio_x = i;
        this.selectionConfig.aspect_ratio_y = i2;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isWithVideoImage(boolean z) {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.isWithVideoImage = pictureSelectionConfig.selectionMode != 1 && this.selectionConfig.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAll() && z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setOfAllCameraType(int i) {
        this.selectionConfig.ofAllCameraType = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isMaxSelectEnabledMask(boolean z) {
        this.selectionConfig.isMaxSelectEnabledMask = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isSyncCover(boolean z) {
        this.selectionConfig.isSyncCover = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel maxSelectNum(int i) {
        this.selectionConfig.maxSelectNum = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel minSelectNum(int i) {
        this.selectionConfig.minSelectNum = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel maxVideoSelectNum(int i) {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        if (pictureSelectionConfig.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo()) {
            i = 0;
        }
        pictureSelectionConfig.maxVideoSelectNum = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel minVideoSelectNum(int i) {
        this.selectionConfig.minVideoSelectNum = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isAutomaticTitleRecyclerTop(boolean z) {
        this.selectionConfig.isAutomaticTitleRecyclerTop = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isSingleDirectReturn(boolean z) {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        boolean z2 = false;
        pictureSelectionConfig.isSingleDirectReturn = pictureSelectionConfig.selectionMode == 1 && z;
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig2 = this.selectionConfig;
        if ((pictureSelectionConfig2.selectionMode != 1 || !z) && this.selectionConfig.isOriginalControl) {
            z2 = true;
        }
        pictureSelectionConfig2.isOriginalControl = z2;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isPageStrategy(boolean z, int i) {
        this.selectionConfig.isPageStrategy = z;
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        if (i < 10) {
            i = 60;
        }
        pictureSelectionConfig.pageSize = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isPageStrategy(boolean z, int i, boolean z2) {
        this.selectionConfig.isPageStrategy = z;
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        if (i < 10) {
            i = 60;
        }
        pictureSelectionConfig.pageSize = i;
        this.selectionConfig.isFilterInvalidFile = z2;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isPageStrategy(boolean z) {
        this.selectionConfig.isPageStrategy = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isPageStrategy(boolean z, boolean z2) {
        this.selectionConfig.isPageStrategy = z;
        this.selectionConfig.isFilterInvalidFile = z2;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel videoQuality(int i) {
        this.selectionConfig.videoQuality = i;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel imageFormat(java.lang.String str) {
        this.selectionConfig.suffixType = str;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setCameraImageFormat(java.lang.String str) {
        this.selectionConfig.cameraImageFormat = str;
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() || com.up366.medialibrary.common.utils.SdkVersionUtils.isR()) {
            if (android.text.TextUtils.equals(str, com.up366.medialibrary.common.utils.MimeTypeUtils.PNG)) {
                this.selectionConfig.cameraImageFormatForQ = com.up366.medialibrary.common.utils.MimeTypeUtils.PNG_Q;
            }
            if (android.text.TextUtils.equals(str, com.up366.medialibrary.common.utils.MimeTypeUtils.JPG) || android.text.TextUtils.equals(str, ".jpeg")) {
                this.selectionConfig.cameraImageFormatForQ = "image/jpeg";
            }
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setCameraVideoFormat(java.lang.String str) {
        this.selectionConfig.cameraVideoFormat = str;
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() || com.up366.medialibrary.common.utils.SdkVersionUtils.isR()) {
            if (android.text.TextUtils.equals(str, ".mp4")) {
                this.selectionConfig.cameraVideoFormatForQ = "video/mp4";
            }
            if (android.text.TextUtils.equals(str, com.up366.medialibrary.common.utils.MimeTypeUtils.AVI)) {
                this.selectionConfig.cameraVideoFormatForQ = com.up366.medialibrary.common.utils.MimeTypeUtils.AVI_Q;
            }
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setCameraAudioFormat(java.lang.String str) {
        this.selectionConfig.cameraAudioFormat = str;
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() || com.up366.medialibrary.common.utils.SdkVersionUtils.isR()) {
            if (android.text.TextUtils.equals(str, ".amr")) {
                this.selectionConfig.cameraAudioFormatForQ = "audio/amr";
            }
            if (android.text.TextUtils.equals(str, com.up366.medialibrary.common.utils.MimeTypeUtils.WAV)) {
                this.selectionConfig.cameraAudioFormatForQ = com.up366.medialibrary.common.utils.MimeTypeUtils.WAV_Q;
            }
            if (android.text.TextUtils.equals(str, com.up366.medialibrary.common.utils.MimeTypeUtils.MP3)) {
                this.selectionConfig.cameraAudioFormatForQ = "audio/mpeg";
            }
        }
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel cropWH(int i, int i2) {
        this.selectionConfig.cropWidth = i;
        this.selectionConfig.cropHeight = i2;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel cropImageWideHigh(int i, int i2) {
        this.selectionConfig.cropWidth = i;
        this.selectionConfig.cropHeight = i2;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel videoMaxSecond(int i) {
        this.selectionConfig.videoMaxSecond = i * 1000;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel videoMinSecond(int i) {
        this.selectionConfig.videoMinSecond = i * 1000;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel recordVideoSecond(int i) {
        this.selectionConfig.recordVideoSecond = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel recordVideoMinSecond(int i) {
        this.selectionConfig.recordVideoMinSecond = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel imageSpanCount(int i) {
        this.selectionConfig.imageSpanCount = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel minimumCompressSize(int i) {
        this.selectionConfig.minimumCompressSize = i;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel cropCompressQuality(int i) {
        this.selectionConfig.cropCompressQuality = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel cutOutQuality(int i) {
        this.selectionConfig.cropCompressQuality = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel cutCompressFormat(java.lang.String str) {
        this.selectionConfig.cropCompressFormat = str;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel compress(boolean z) {
        this.selectionConfig.isCompress = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isCompress(boolean z) {
        this.selectionConfig.isCompress = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel compressQuality(int i) {
        this.selectionConfig.compressQuality = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isReturnEmpty(boolean z) {
        this.selectionConfig.returnEmpty = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel synOrAsy(boolean z) {
        this.selectionConfig.synOrAsy = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel compressFocusAlpha(boolean z) {
        this.selectionConfig.focusAlpha = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isQuickCapture(boolean z) {
        this.selectionConfig.isQuickCapture = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isOriginalImageControl(boolean z) {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.isOriginalControl = (pictureSelectionConfig.camera || this.selectionConfig.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo() || this.selectionConfig.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio() || !z) ? false : true;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isDisplayOriginalSize(boolean z) {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.isDisplayOriginalSize = !pictureSelectionConfig.camera && z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isEditorImage(boolean z) {
        this.selectionConfig.isEditorImage = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel compressSavePath(java.lang.String str) {
        this.selectionConfig.compressSavePath = str;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel cameraFileName(java.lang.String str) {
        this.selectionConfig.cameraFileName = str;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel renameCropFileName(java.lang.String str) {
        this.selectionConfig.renameCropFileName = str;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel renameCompressFile(java.lang.String str) {
        this.selectionConfig.renameCompressFileName = str;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isZoomAnim(boolean z) {
        this.selectionConfig.zoomAnim = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel previewEggs(boolean z) {
        this.selectionConfig.previewEggs = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isPreviewEggs(boolean z) {
        this.selectionConfig.previewEggs = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isAutoScalePreviewImage(boolean z) {
        this.selectionConfig.isAutoScalePreviewImage = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isCamera(boolean z) {
        this.selectionConfig.isCamera = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setOutputCameraPath(java.lang.String str) {
        this.selectionConfig.outPutCameraPath = str;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setQuerySandboxDirectory(java.lang.String str) {
        this.selectionConfig.sandboxFolderPath = str;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isGetOnlySandboxDirectory(boolean z) {
        this.selectionConfig.isOnlySandboxDir = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel queryFileSize(float f) {
        this.selectionConfig.filterFileSize = f;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel queryMaxFileSize(float f) {
        this.selectionConfig.filterFileSize = f;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel filterMaxFileSize(long j) {
        if (j >= com.up366.medialibrary.config.PictureConstants.MB) {
            this.selectionConfig.filterMaxFileSize = j;
        } else {
            this.selectionConfig.filterMaxFileSize = j * 1024;
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel filterMinFileSize(long j) {
        if (j >= com.up366.medialibrary.config.PictureConstants.MB) {
            this.selectionConfig.filterMinFileSize = j;
        } else {
            this.selectionConfig.filterMinFileSize = j * 1024;
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel queryMimeTypeConditions(java.lang.String... strArr) {
        if (strArr != null && strArr.length > 0) {
            this.selectionConfig.queryMimeTypeHashSet = new java.util.HashSet<>(java.util.Arrays.asList(strArr));
        } else {
            this.selectionConfig.queryMimeTypeHashSet = null;
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isGif(boolean z) {
        this.selectionConfig.isGif = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isWebp(boolean z) {
        this.selectionConfig.isWebp = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isBmp(boolean z) {
        this.selectionConfig.isBmp = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel previewImage(boolean z) {
        this.selectionConfig.enablePreview = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isPreviewImage(boolean z) {
        this.selectionConfig.enablePreview = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel previewVideo(boolean z) {
        this.selectionConfig.enPreviewVideo = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isPreviewVideo(boolean z) {
        this.selectionConfig.enPreviewVideo = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isNotPreviewDownload(boolean z) {
        this.selectionConfig.isNotPreviewDownload = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel querySpecifiedFormatSuffix(java.lang.String str) {
        this.selectionConfig.specifiedFormat = str;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel openClickSound(boolean z) {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.openClickSound = !pictureSelectionConfig.camera && z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isOpenClickSound(boolean z) {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.openClickSound = !pictureSelectionConfig.camera && z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isDragFrame(boolean z) {
        this.selectionConfig.isDragFrame = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isMultipleRecyclerAnimation(boolean z) {
        this.selectionConfig.isMultipleRecyclerAnimation = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isCameraAroundState(boolean z) {
        this.selectionConfig.isCameraAroundState = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isCameraRotateImage(boolean z) {
        this.selectionConfig.isCameraRotateImage = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isAutoRotating(boolean z) {
        this.selectionConfig.isAutoRotating = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel selectionMedia(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        if (this.selectionConfig.selectionMode == 1 && this.selectionConfig.isSingleDirectReturn) {
            this.selectionConfig.selectionMedias = null;
        } else {
            this.selectionConfig.selectionMedias = list;
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel selectionData(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        if (this.selectionConfig.selectionMode == 1 && this.selectionConfig.isSingleDirectReturn) {
            this.selectionConfig.selectionMedias = null;
        } else {
            this.selectionConfig.selectionMedias = list;
        }
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel isChangeStatusBarFontColor(boolean z) {
        this.selectionConfig.isChangeStatusBarFontColor = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel isOpenStyleNumComplete(boolean z) {
        this.selectionConfig.isOpenStyleNumComplete = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel isOpenStyleCheckNumMode(boolean z) {
        this.selectionConfig.isOpenStyleCheckNumMode = z;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel setTitleBarBackgroundColor(int i) {
        this.selectionConfig.titleBarBackgroundColor = i;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel setStatusBarColorPrimaryDark(int i) {
        this.selectionConfig.pictureStatusBarColor = i;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel setCropTitleBarBackgroundColor(int i) {
        this.selectionConfig.cropTitleBarBackgroundColor = i;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel setCropStatusBarColorPrimaryDark(int i) {
        this.selectionConfig.cropStatusBarColorPrimaryDark = i;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel setCropTitleColor(int i) {
        this.selectionConfig.cropTitleColor = i;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel setUpArrowDrawable(int i) {
        this.selectionConfig.upResId = i;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel setDownArrowDrawable(int i) {
        this.selectionConfig.downResId = i;
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel setPictureCropStyle(com.up366.medialibrary.common.style.PictureCropParameterStyle pictureCropParameterStyle) {
        if (pictureCropParameterStyle != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.cropStyle = pictureCropParameterStyle;
        } else {
            com.up366.medialibrary.config.PictureSelectionConfig.cropStyle = com.up366.medialibrary.common.style.PictureCropParameterStyle.ofDefaultCropStyle();
        }
        return this;
    }

    @java.lang.Deprecated
    public com.up366.medialibrary.PictureSelectionModel setPictureStyle(com.up366.medialibrary.common.style.PictureParameterStyle pictureParameterStyle) {
        if (pictureParameterStyle != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.style = pictureParameterStyle;
            if (!this.selectionConfig.isWeChatStyle) {
                this.selectionConfig.isWeChatStyle = pictureParameterStyle.isNewSelectStyle;
            }
        } else {
            com.up366.medialibrary.config.PictureSelectionConfig.style = com.up366.medialibrary.common.style.PictureParameterStyle.ofDefaultStyle();
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setPictureWindowAnimationStyle(com.up366.medialibrary.common.style.PictureWindowAnimationStyle pictureWindowAnimationStyle) {
        if (pictureWindowAnimationStyle != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle = pictureWindowAnimationStyle;
        } else {
            com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle = com.up366.medialibrary.common.style.PictureWindowAnimationStyle.ofDefaultWindowAnimationStyle();
        }
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel setRecyclerAnimationMode(int i) {
        this.selectionConfig.animationMode = i;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isAndroidQTransform(boolean z) {
        this.selectionConfig.isAndroidQTransform = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isFallbackVersion(boolean z) {
        this.selectionConfig.isFallbackVersion = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isFallbackVersion2(boolean z) {
        this.selectionConfig.isFallbackVersion2 = z;
        return this;
    }

    public com.up366.medialibrary.PictureSelectionModel isFallbackVersion3(boolean z) {
        this.selectionConfig.isFallbackVersion3 = z;
        return this;
    }

    public void forResult(int i) {
        android.app.Activity activity;
        android.content.Intent intent;
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick() || (activity = this.selector.getActivity()) == null || this.selectionConfig == null) {
            return;
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine == null) {
            throw new java.lang.NullPointerException("api imageEngine is null,Please implement ImageEngine");
        }
        if (this.selectionConfig.camera && this.selectionConfig.isUseCustomCamera) {
            intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.medialibrary.activity.PictureCustomCameraActivity.class);
        } else {
            intent = new android.content.Intent(activity, (java.lang.Class<?>) (this.selectionConfig.camera ? com.up366.medialibrary.activity.PictureSelectorCameraEmptyActivity.class : com.up366.medialibrary.activity.PictureSelectorActivity.class));
        }
        this.selectionConfig.isCallbackMode = false;
        androidx.fragment.app.Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, i);
        } else {
            activity.startActivityForResult(intent, i);
        }
        activity.overridePendingTransition(com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, com.up366.medialibrary.R.anim.picture_anim_fade_in);
    }

    @java.lang.Deprecated
    public void forResult(int i, int i2, int i3) {
        android.app.Activity activity;
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick() || (activity = this.selector.getActivity()) == null || this.selectionConfig == null) {
            return;
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine == null) {
            throw new java.lang.NullPointerException("api imageEngine is null,Please implement ImageEngine");
        }
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) (this.selectionConfig.camera ? com.up366.medialibrary.activity.PictureSelectorCameraEmptyActivity.class : com.up366.medialibrary.activity.PictureSelectorActivity.class));
        this.selectionConfig.isCallbackMode = false;
        androidx.fragment.app.Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, i);
        } else {
            activity.startActivityForResult(intent, i);
        }
        activity.overridePendingTransition(i2, i3);
    }

    public void forResult(com.up366.medialibrary.listener.OnResultCallbackListener<com.up366.medialibrary.model.LocalMedia> onResultCallbackListener) {
        android.app.Activity activity;
        android.content.Intent intent;
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick() || (activity = this.selector.getActivity()) == null || this.selectionConfig == null) {
            return;
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine == null) {
            throw new java.lang.NullPointerException("api imageEngine is null,Please implement ImageEngine");
        }
        com.up366.medialibrary.config.PictureSelectionConfig.listener = (com.up366.medialibrary.listener.OnResultCallbackListener) new java.lang.ref.WeakReference(onResultCallbackListener).get();
        this.selectionConfig.isCallbackMode = true;
        if (this.selectionConfig.camera && this.selectionConfig.isUseCustomCamera) {
            intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.medialibrary.activity.PictureCustomCameraActivity.class);
        } else {
            intent = new android.content.Intent(activity, (java.lang.Class<?>) (this.selectionConfig.camera ? com.up366.medialibrary.activity.PictureSelectorCameraEmptyActivity.class : com.up366.medialibrary.activity.PictureSelectorActivity.class));
        }
        androidx.fragment.app.Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivity(intent);
        } else {
            activity.startActivity(intent);
        }
        activity.overridePendingTransition(com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, com.up366.medialibrary.R.anim.picture_anim_fade_in);
    }

    public void forResult(androidx.activity.result.ActivityResultLauncher<android.content.Intent> activityResultLauncher) {
        android.content.Intent intent;
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
            return;
        }
        android.app.Activity activity = this.selector.getActivity();
        if (activityResultLauncher == null || activity == null || this.selectionConfig == null) {
            return;
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine == null) {
            throw new java.lang.NullPointerException("api imageEngine is null,Please implement ImageEngine");
        }
        if (this.selectionConfig.camera && this.selectionConfig.isUseCustomCamera) {
            intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.medialibrary.activity.PictureCustomCameraActivity.class);
        } else {
            intent = new android.content.Intent(activity, (java.lang.Class<?>) (this.selectionConfig.camera ? com.up366.medialibrary.activity.PictureSelectorCameraEmptyActivity.class : com.up366.medialibrary.activity.PictureSelectorActivity.class));
        }
        this.selectionConfig.isCallbackMode = false;
        activityResultLauncher.launch(intent);
        activity.overridePendingTransition(com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, com.up366.medialibrary.R.anim.picture_anim_fade_in);
    }

    public void forResult(int i, com.up366.medialibrary.listener.OnResultCallbackListener<com.up366.medialibrary.model.LocalMedia> onResultCallbackListener) {
        android.app.Activity activity;
        android.content.Intent intent;
        java.lang.Class cls;
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick() || (activity = this.selector.getActivity()) == null || this.selectionConfig == null) {
            return;
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine == null) {
            throw new java.lang.NullPointerException("api imageEngine is null,Please implement ImageEngine");
        }
        com.up366.medialibrary.config.PictureSelectionConfig.listener = (com.up366.medialibrary.listener.OnResultCallbackListener) new java.lang.ref.WeakReference(onResultCallbackListener).get();
        this.selectionConfig.isCallbackMode = true;
        if (this.selectionConfig.camera && this.selectionConfig.isUseCustomCamera) {
            intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.medialibrary.activity.PictureCustomCameraActivity.class);
        } else {
            if (this.selectionConfig.camera) {
                cls = com.up366.medialibrary.activity.PictureSelectorCameraEmptyActivity.class;
            } else {
                cls = com.up366.medialibrary.activity.PictureSelectorActivity.class;
            }
            intent = new android.content.Intent(activity, (java.lang.Class<?>) cls);
        }
        androidx.fragment.app.Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, i);
        } else {
            activity.startActivityForResult(intent, i);
        }
        activity.overridePendingTransition(com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, com.up366.medialibrary.R.anim.picture_anim_fade_in);
    }

    public void openExternalPreview(int i, java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        com.up366.medialibrary.PictureSelector pictureSelector = this.selector;
        if (pictureSelector != null) {
            pictureSelector.externalPicturePreview(i, list, com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation);
            return;
        }
        throw new java.lang.NullPointerException("This PictureSelector is Null");
    }

    @java.lang.Deprecated
    public void openExternalPreview(int i, java.lang.String str, java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        com.up366.medialibrary.PictureSelector pictureSelector = this.selector;
        if (pictureSelector != null) {
            pictureSelector.externalPicturePreview(i, str, list, com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation);
            return;
        }
        throw new java.lang.NullPointerException("This PictureSelector is Null");
    }

    public void externalPictureVideo(java.lang.String str) {
        com.up366.medialibrary.PictureSelector pictureSelector = this.selector;
        if (pictureSelector != null) {
            pictureSelector.externalPictureVideo(str);
            return;
        }
        throw new java.lang.NullPointerException("This PictureSelector is Null");
    }
}
