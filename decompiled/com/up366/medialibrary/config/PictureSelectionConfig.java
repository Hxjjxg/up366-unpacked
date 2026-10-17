package com.up366.medialibrary.config;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class PictureSelectionConfig implements android.os.Parcelable {
    public static com.up366.medialibrary.common.engine.CompressEngine compressEngine;
    public static com.up366.medialibrary.common.style.PictureCropParameterStyle cropStyle;
    public static com.up366.medialibrary.listener.OnVideoSelectedPlayCallback<com.up366.medialibrary.model.LocalMedia> customVideoPlayCallback;
    public static com.up366.medialibrary.common.engine.ImageEngine imageEngine;
    public static com.up366.medialibrary.listener.OnResultCallbackListener<com.up366.medialibrary.model.LocalMedia> listener;
    public static com.up366.medialibrary.listener.OnChooseLimitCallback onChooseLimitCallback;
    public static com.up366.medialibrary.listener.OnCustomCameraInterfaceListener onCustomCameraInterfaceListener;
    public static com.up366.medialibrary.listener.OnCustomImagePreviewCallback<com.up366.medialibrary.model.LocalMedia> onCustomImagePreviewCallback;
    public static com.up366.medialibrary.listener.OnPermissionsObtainCallback onPermissionsObtainCallback;

    @java.lang.Deprecated
    public static com.up366.medialibrary.common.style.PictureParameterStyle style;
    public static com.up366.medialibrary.common.style.PictureSelectorUIStyle uiStyle;
    public int animationMode;
    public int aspect_ratio_x;
    public int aspect_ratio_y;
    public int buttonFeatures;
    public boolean camera;
    public java.lang.String cameraAudioFormat;
    public java.lang.String cameraAudioFormatForQ;
    public java.lang.String cameraFileName;
    public java.lang.String cameraImageFormat;
    public java.lang.String cameraImageFormatForQ;
    public int cameraMimeType;
    public java.lang.String cameraPath;
    public java.lang.String cameraVideoFormat;
    public java.lang.String cameraVideoFormatForQ;
    public int captureLoadingColor;
    public boolean checkNumMode;
    public int chooseMode;
    public int circleDimmedBorderColor;
    public int circleDimmedColor;
    public boolean circleDimmedLayer;
    public int circleStrokeWidth;
    public int compressQuality;
    public java.lang.String compressSavePath;
    public java.lang.String cropCompressFormat;
    public int cropCompressQuality;
    public int cropHeight;

    @java.lang.Deprecated
    public int cropStatusBarColorPrimaryDark;

    @java.lang.Deprecated
    public int cropTitleBarBackgroundColor;

    @java.lang.Deprecated
    public int cropTitleColor;
    public int cropWidth;

    @java.lang.Deprecated
    public int downResId;
    public boolean enPreviewVideo;
    public boolean enableCrop;
    public boolean enablePreview;
    public boolean enablePreviewAudio;

    @java.lang.Deprecated
    public float filterFileSize;
    public long filterMaxFileSize;
    public long filterMinFileSize;

    @java.lang.Deprecated
    public boolean focusAlpha;
    public boolean freeStyleCropEnabled;
    public int freeStyleCropMode;
    public boolean hideBottomControls;
    public int imageSpanCount;
    public boolean isAndroidQTransform;
    public boolean isAutoRotating;
    public boolean isAutoScalePreviewImage;
    public boolean isAutomaticTitleRecyclerTop;
    public boolean isBmp;
    public boolean isCallbackMode;
    public boolean isCamera;
    public boolean isCameraAroundState;
    public boolean isCameraRotateImage;

    @java.lang.Deprecated
    public boolean isChangeStatusBarFontColor;
    public boolean isCheckOriginalImage;
    public boolean isCompress;
    public boolean isDisplayOriginalSize;
    public boolean isDragCenter;
    public boolean isDragFrame;
    public boolean isEditorImage;
    public boolean isFallbackVersion;
    public boolean isFallbackVersion2;
    public boolean isFallbackVersion3;
    public boolean isFilterInvalidFile;
    public boolean isGif;
    public boolean isMaxSelectEnabledMask;
    public boolean isMultipleRecyclerAnimation;
    public boolean isMultipleSkipCrop;
    public boolean isNotPreviewDownload;
    public boolean isOnlySandboxDir;

    @java.lang.Deprecated
    public boolean isOpenStyleCheckNumMode;

    @java.lang.Deprecated
    public boolean isOpenStyleNumComplete;
    public boolean isOriginalControl;
    public boolean isPageStrategy;
    public boolean isQuickCapture;
    public boolean isSingleDirectReturn;
    public boolean isSyncCover;
    public boolean isUseCustomCamera;
    public boolean isWeChatStyle;
    public boolean isWebp;
    public boolean isWithVideoImage;
    public int language;
    public int maxSelectNum;
    public int maxVideoSelectNum;
    public int minSelectNum;
    public int minVideoSelectNum;
    public int minimumCompressSize;
    public int ofAllCameraType;
    public boolean openClickSound;
    public java.lang.String originalPath;
    public java.lang.String outPutCameraPath;
    public int pageSize;

    @java.lang.Deprecated
    public int pictureStatusBarColor;
    public boolean previewEggs;
    public java.util.HashSet<java.lang.String> queryMimeTypeHashSet;
    public int recordVideoMinSecond;
    public int recordVideoSecond;
    public java.lang.String renameCompressFileName;
    public java.lang.String renameCropFileName;
    public int requestedOrientation;
    public boolean returnEmpty;
    public boolean rotateEnabled;
    public java.lang.String sandboxFolderPath;
    public boolean scaleEnabled;
    public java.util.List<com.up366.medialibrary.model.LocalMedia> selectionMedias;
    public int selectionMode;
    public boolean showCropFrame;
    public boolean showCropGrid;

    @java.lang.Deprecated
    public java.lang.String specifiedFormat;

    @java.lang.Deprecated
    public java.lang.String suffixType;
    public boolean synOrAsy;
    public int themeStyleId;

    @java.lang.Deprecated
    public int titleBarBackgroundColor;
    public com.up366.medialibrary.third.ucrop.UCrop.Options uCropOptions;

    @java.lang.Deprecated
    public int upResId;
    public int videoMaxSecond;
    public int videoMinSecond;
    public int videoQuality;
    public boolean zoomAnim;
    public static com.up366.medialibrary.common.style.PictureWindowAnimationStyle windowAnimationStyle = com.up366.medialibrary.common.style.PictureWindowAnimationStyle.ofDefaultWindowAnimationStyle();
    public static final android.os.Parcelable.Creator<com.up366.medialibrary.config.PictureSelectionConfig> CREATOR = new android.os.Parcelable.Creator<com.up366.medialibrary.config.PictureSelectionConfig>() { // from class: com.up366.medialibrary.config.PictureSelectionConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.medialibrary.config.PictureSelectionConfig createFromParcel(android.os.Parcel parcel) {
            return new com.up366.medialibrary.config.PictureSelectionConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.up366.medialibrary.config.PictureSelectionConfig[] newArray(int i) {
            return new com.up366.medialibrary.config.PictureSelectionConfig[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected PictureSelectionConfig(android.os.Parcel parcel) {
        this.chooseMode = com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage();
        this.camera = false;
        this.requestedOrientation = -1;
        this.buttonFeatures = com.up366.medialibrary.camera.CustomCameraType.BUTTON_STATE_BOTH;
        this.themeStyleId = com.up366.medialibrary.R.style.picture_default_style;
        this.selectionMode = 2;
        this.maxSelectNum = 9;
        this.minSelectNum = 0;
        this.maxVideoSelectNum = 1;
        this.minVideoSelectNum = 0;
        this.videoQuality = 1;
        this.cropCompressQuality = 90;
        this.recordVideoSecond = 60;
        this.minimumCompressSize = 100;
        this.imageSpanCount = 4;
        this.compressQuality = 80;
        this.filterMinFileSize = 1024L;
        this.language = -2;
        this.isCamera = true;
        this.cameraMimeType = -1;
        this.pageSize = 60;
        this.isPageStrategy = true;
        this.animationMode = -1;
        this.isAutomaticTitleRecyclerTop = true;
        this.isQuickCapture = true;
        this.isCameraRotateImage = true;
        this.isAutoRotating = true;
        this.isSyncCover = false;
        this.isAutoScalePreviewImage = true;
        this.ofAllCameraType = com.up366.medialibrary.common.utils.MimeTypeUtils.ofAll();
        this.chooseMode = parcel.readInt();
        this.camera = parcel.readByte() != 0;
        this.isSingleDirectReturn = parcel.readByte() != 0;
        this.compressSavePath = parcel.readString();
        this.suffixType = parcel.readString();
        this.cameraImageFormat = parcel.readString();
        this.cameraVideoFormat = parcel.readString();
        this.cameraAudioFormat = parcel.readString();
        this.cameraImageFormatForQ = parcel.readString();
        this.cameraVideoFormatForQ = parcel.readString();
        this.cameraAudioFormatForQ = parcel.readString();
        this.focusAlpha = parcel.readByte() != 0;
        this.renameCompressFileName = parcel.readString();
        this.renameCropFileName = parcel.readString();
        this.specifiedFormat = parcel.readString();
        this.requestedOrientation = parcel.readInt();
        this.buttonFeatures = parcel.readInt();
        this.captureLoadingColor = parcel.readInt();
        this.isCameraAroundState = parcel.readByte() != 0;
        this.isAndroidQTransform = parcel.readByte() != 0;
        this.themeStyleId = parcel.readInt();
        this.selectionMode = parcel.readInt();
        this.maxSelectNum = parcel.readInt();
        this.minSelectNum = parcel.readInt();
        this.maxVideoSelectNum = parcel.readInt();
        this.minVideoSelectNum = parcel.readInt();
        this.videoQuality = parcel.readInt();
        this.cropCompressQuality = parcel.readInt();
        this.videoMaxSecond = parcel.readInt();
        this.videoMinSecond = parcel.readInt();
        this.recordVideoSecond = parcel.readInt();
        this.recordVideoMinSecond = parcel.readInt();
        this.minimumCompressSize = parcel.readInt();
        this.imageSpanCount = parcel.readInt();
        this.aspect_ratio_x = parcel.readInt();
        this.aspect_ratio_y = parcel.readInt();
        this.cropWidth = parcel.readInt();
        this.cropHeight = parcel.readInt();
        this.compressQuality = parcel.readInt();
        this.filterFileSize = parcel.readFloat();
        this.filterMaxFileSize = parcel.readLong();
        this.filterMinFileSize = parcel.readLong();
        this.language = parcel.readInt();
        this.isMultipleRecyclerAnimation = parcel.readByte() != 0;
        this.isMultipleSkipCrop = parcel.readByte() != 0;
        this.isWeChatStyle = parcel.readByte() != 0;
        this.isUseCustomCamera = parcel.readByte() != 0;
        this.zoomAnim = parcel.readByte() != 0;
        this.isCompress = parcel.readByte() != 0;
        this.isOriginalControl = parcel.readByte() != 0;
        this.isDisplayOriginalSize = parcel.readByte() != 0;
        this.isEditorImage = parcel.readByte() != 0;
        this.isCamera = parcel.readByte() != 0;
        this.isGif = parcel.readByte() != 0;
        this.isWebp = parcel.readByte() != 0;
        this.isBmp = parcel.readByte() != 0;
        this.enablePreview = parcel.readByte() != 0;
        this.enPreviewVideo = parcel.readByte() != 0;
        this.enablePreviewAudio = parcel.readByte() != 0;
        this.checkNumMode = parcel.readByte() != 0;
        this.openClickSound = parcel.readByte() != 0;
        this.enableCrop = parcel.readByte() != 0;
        this.freeStyleCropEnabled = parcel.readByte() != 0;
        this.isDragCenter = parcel.readByte() != 0;
        this.circleDimmedLayer = parcel.readByte() != 0;
        this.circleDimmedColor = parcel.readInt();
        this.circleDimmedBorderColor = parcel.readInt();
        this.circleStrokeWidth = parcel.readInt();
        this.freeStyleCropMode = parcel.readInt();
        this.showCropFrame = parcel.readByte() != 0;
        this.showCropGrid = parcel.readByte() != 0;
        this.hideBottomControls = parcel.readByte() != 0;
        this.rotateEnabled = parcel.readByte() != 0;
        this.scaleEnabled = parcel.readByte() != 0;
        this.previewEggs = parcel.readByte() != 0;
        this.synOrAsy = parcel.readByte() != 0;
        this.returnEmpty = parcel.readByte() != 0;
        this.isDragFrame = parcel.readByte() != 0;
        this.isNotPreviewDownload = parcel.readByte() != 0;
        this.isWithVideoImage = parcel.readByte() != 0;
        this.selectionMedias = parcel.createTypedArrayList(com.up366.medialibrary.model.LocalMedia.CREATOR);
        this.cameraFileName = parcel.readString();
        this.isCheckOriginalImage = parcel.readByte() != 0;
        this.isChangeStatusBarFontColor = parcel.readByte() != 0;
        this.isOpenStyleNumComplete = parcel.readByte() != 0;
        this.isOpenStyleCheckNumMode = parcel.readByte() != 0;
        this.titleBarBackgroundColor = parcel.readInt();
        this.pictureStatusBarColor = parcel.readInt();
        this.cropTitleBarBackgroundColor = parcel.readInt();
        this.cropStatusBarColorPrimaryDark = parcel.readInt();
        this.cropTitleColor = parcel.readInt();
        this.upResId = parcel.readInt();
        this.downResId = parcel.readInt();
        this.outPutCameraPath = parcel.readString();
        this.sandboxFolderPath = parcel.readString();
        this.originalPath = parcel.readString();
        this.cameraPath = parcel.readString();
        this.cameraMimeType = parcel.readInt();
        this.pageSize = parcel.readInt();
        this.isPageStrategy = parcel.readByte() != 0;
        this.isFilterInvalidFile = parcel.readByte() != 0;
        this.isMaxSelectEnabledMask = parcel.readByte() != 0;
        this.animationMode = parcel.readInt();
        this.isAutomaticTitleRecyclerTop = parcel.readByte() != 0;
        this.isCallbackMode = parcel.readByte() != 0;
        this.isQuickCapture = parcel.readByte() != 0;
        this.isCameraRotateImage = parcel.readByte() != 0;
        this.isAutoRotating = parcel.readByte() != 0;
        this.isSyncCover = parcel.readByte() != 0;
        this.cropCompressFormat = parcel.readString();
        this.isAutoScalePreviewImage = parcel.readByte() != 0;
        this.ofAllCameraType = parcel.readInt();
        this.isOnlySandboxDir = parcel.readByte() != 0;
        this.isFallbackVersion = parcel.readByte() != 0;
        this.isFallbackVersion2 = parcel.readByte() != 0;
        this.isFallbackVersion3 = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.chooseMode);
        parcel.writeByte(this.camera ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSingleDirectReturn ? (byte) 1 : (byte) 0);
        parcel.writeString(this.compressSavePath);
        parcel.writeString(this.suffixType);
        parcel.writeString(this.cameraImageFormat);
        parcel.writeString(this.cameraVideoFormat);
        parcel.writeString(this.cameraAudioFormat);
        parcel.writeString(this.cameraImageFormatForQ);
        parcel.writeString(this.cameraVideoFormatForQ);
        parcel.writeString(this.cameraAudioFormatForQ);
        parcel.writeByte(this.focusAlpha ? (byte) 1 : (byte) 0);
        parcel.writeString(this.renameCompressFileName);
        parcel.writeString(this.renameCropFileName);
        parcel.writeString(this.specifiedFormat);
        parcel.writeInt(this.requestedOrientation);
        parcel.writeInt(this.buttonFeatures);
        parcel.writeInt(this.captureLoadingColor);
        parcel.writeByte(this.isCameraAroundState ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isAndroidQTransform ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.themeStyleId);
        parcel.writeInt(this.selectionMode);
        parcel.writeInt(this.maxSelectNum);
        parcel.writeInt(this.minSelectNum);
        parcel.writeInt(this.maxVideoSelectNum);
        parcel.writeInt(this.minVideoSelectNum);
        parcel.writeInt(this.videoQuality);
        parcel.writeInt(this.cropCompressQuality);
        parcel.writeInt(this.videoMaxSecond);
        parcel.writeInt(this.videoMinSecond);
        parcel.writeInt(this.recordVideoSecond);
        parcel.writeInt(this.recordVideoMinSecond);
        parcel.writeInt(this.minimumCompressSize);
        parcel.writeInt(this.imageSpanCount);
        parcel.writeInt(this.aspect_ratio_x);
        parcel.writeInt(this.aspect_ratio_y);
        parcel.writeInt(this.cropWidth);
        parcel.writeInt(this.cropHeight);
        parcel.writeInt(this.compressQuality);
        parcel.writeFloat(this.filterFileSize);
        parcel.writeLong(this.filterMaxFileSize);
        parcel.writeLong(this.filterMinFileSize);
        parcel.writeInt(this.language);
        parcel.writeByte(this.isMultipleRecyclerAnimation ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isMultipleSkipCrop ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isWeChatStyle ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isUseCustomCamera ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.zoomAnim ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCompress ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isOriginalControl ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isDisplayOriginalSize ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isEditorImage ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCamera ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isGif ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isWebp ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isBmp ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.enablePreview ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.enPreviewVideo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.enablePreviewAudio ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.checkNumMode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.openClickSound ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.enableCrop ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.freeStyleCropEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isDragCenter ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.circleDimmedLayer ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.circleDimmedColor);
        parcel.writeInt(this.circleDimmedBorderColor);
        parcel.writeInt(this.circleStrokeWidth);
        parcel.writeInt(this.freeStyleCropMode);
        parcel.writeByte(this.showCropFrame ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showCropGrid ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hideBottomControls ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.rotateEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.scaleEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.previewEggs ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.synOrAsy ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.returnEmpty ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isDragFrame ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isNotPreviewDownload ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isWithVideoImage ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.selectionMedias);
        parcel.writeString(this.cameraFileName);
        parcel.writeByte(this.isCheckOriginalImage ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isChangeStatusBarFontColor ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isOpenStyleNumComplete ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isOpenStyleCheckNumMode ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.titleBarBackgroundColor);
        parcel.writeInt(this.pictureStatusBarColor);
        parcel.writeInt(this.cropTitleBarBackgroundColor);
        parcel.writeInt(this.cropStatusBarColorPrimaryDark);
        parcel.writeInt(this.cropTitleColor);
        parcel.writeInt(this.upResId);
        parcel.writeInt(this.downResId);
        parcel.writeString(this.outPutCameraPath);
        parcel.writeString(this.sandboxFolderPath);
        parcel.writeString(this.originalPath);
        parcel.writeString(this.cameraPath);
        parcel.writeInt(this.cameraMimeType);
        parcel.writeInt(this.pageSize);
        parcel.writeByte(this.isPageStrategy ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isFilterInvalidFile ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isMaxSelectEnabledMask ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.animationMode);
        parcel.writeByte(this.isAutomaticTitleRecyclerTop ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCallbackMode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isQuickCapture ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCameraRotateImage ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isAutoRotating ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSyncCover ? (byte) 1 : (byte) 0);
        parcel.writeString(this.cropCompressFormat);
        parcel.writeByte(this.isAutoScalePreviewImage ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.ofAllCameraType);
        parcel.writeByte(this.isOnlySandboxDir ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isFallbackVersion ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isFallbackVersion2 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isFallbackVersion3 ? (byte) 1 : (byte) 0);
    }

    protected void initDefaultValue() {
        this.chooseMode = com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage();
        this.camera = false;
        this.themeStyleId = com.up366.medialibrary.R.style.picture_default_style;
        this.selectionMode = 2;
        uiStyle = null;
        style = null;
        cropStyle = null;
        this.maxSelectNum = 9;
        this.minSelectNum = 0;
        this.maxVideoSelectNum = 1;
        this.minVideoSelectNum = 0;
        this.videoQuality = 1;
        this.language = -2;
        this.cropCompressQuality = 90;
        this.videoMaxSecond = 0;
        this.videoMinSecond = 0;
        this.filterFileSize = 0.0f;
        this.filterMaxFileSize = 0L;
        this.filterMinFileSize = 1024L;
        this.recordVideoSecond = 60;
        this.recordVideoMinSecond = 0;
        this.compressQuality = 80;
        this.imageSpanCount = 4;
        this.isCompress = false;
        this.isOriginalControl = false;
        this.aspect_ratio_x = 0;
        this.aspect_ratio_y = 0;
        this.cropWidth = 0;
        this.cropHeight = 0;
        this.isCameraAroundState = false;
        this.isWithVideoImage = false;
        this.isAndroidQTransform = false;
        this.isCamera = true;
        this.isGif = false;
        this.isWebp = true;
        this.isBmp = true;
        this.focusAlpha = false;
        this.isCheckOriginalImage = false;
        this.isSingleDirectReturn = false;
        this.enablePreview = true;
        this.enPreviewVideo = true;
        this.enablePreviewAudio = true;
        this.checkNumMode = false;
        this.isNotPreviewDownload = false;
        this.openClickSound = false;
        this.isFallbackVersion = false;
        this.isFallbackVersion2 = true;
        this.isFallbackVersion3 = true;
        this.enableCrop = false;
        this.isWeChatStyle = false;
        this.isUseCustomCamera = false;
        this.isMultipleSkipCrop = true;
        this.isMultipleRecyclerAnimation = true;
        this.freeStyleCropEnabled = false;
        this.isDragCenter = false;
        this.circleDimmedLayer = false;
        this.showCropFrame = true;
        this.showCropGrid = true;
        this.hideBottomControls = true;
        this.rotateEnabled = true;
        this.scaleEnabled = true;
        this.previewEggs = false;
        this.returnEmpty = false;
        this.synOrAsy = true;
        this.zoomAnim = true;
        this.circleDimmedColor = 0;
        this.circleDimmedBorderColor = 0;
        this.circleStrokeWidth = 1;
        this.isDragFrame = true;
        this.compressSavePath = "";
        this.suffixType = "";
        this.cameraImageFormat = "";
        this.cameraVideoFormat = "";
        this.cameraAudioFormat = "";
        this.cameraImageFormatForQ = "";
        this.cameraVideoFormatForQ = "";
        this.cameraAudioFormatForQ = "";
        this.cameraFileName = "";
        this.specifiedFormat = "";
        this.renameCompressFileName = "";
        this.renameCropFileName = "";
        this.queryMimeTypeHashSet = null;
        this.selectionMedias = new java.util.ArrayList();
        this.uCropOptions = null;
        this.titleBarBackgroundColor = 0;
        this.pictureStatusBarColor = 0;
        this.cropTitleBarBackgroundColor = 0;
        this.cropStatusBarColorPrimaryDark = 0;
        this.cropTitleColor = 0;
        this.upResId = 0;
        this.downResId = 0;
        this.isChangeStatusBarFontColor = false;
        this.isOpenStyleNumComplete = false;
        this.isOpenStyleCheckNumMode = false;
        this.outPutCameraPath = "";
        this.sandboxFolderPath = "";
        this.originalPath = "";
        this.cameraPath = "";
        this.cameraMimeType = -1;
        this.pageSize = 60;
        this.isPageStrategy = true;
        this.isFilterInvalidFile = false;
        this.isMaxSelectEnabledMask = false;
        this.animationMode = -1;
        this.isAutomaticTitleRecyclerTop = true;
        this.isCallbackMode = false;
        this.isQuickCapture = true;
        this.isCameraRotateImage = true;
        this.isAutoRotating = true;
        this.isSyncCover = !com.up366.medialibrary.common.utils.SdkVersionUtils.isQ();
        this.cropCompressFormat = "";
        this.isAutoScalePreviewImage = true;
        this.freeStyleCropMode = -1;
        this.isEditorImage = false;
        this.isDisplayOriginalSize = true;
        this.ofAllCameraType = com.up366.medialibrary.common.utils.MimeTypeUtils.ofAll();
        this.isOnlySandboxDir = false;
    }

    public static com.up366.medialibrary.config.PictureSelectionConfig getInstance() {
        return com.up366.medialibrary.config.PictureSelectionConfig.InstanceHolder.INSTANCE;
    }

    public static com.up366.medialibrary.config.PictureSelectionConfig getCleanInstance() {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = getInstance();
        pictureSelectionConfig.initDefaultValue();
        return pictureSelectionConfig;
    }

    private static final class InstanceHolder {
        private static final com.up366.medialibrary.config.PictureSelectionConfig INSTANCE = new com.up366.medialibrary.config.PictureSelectionConfig();

        private InstanceHolder() {
        }
    }

    public PictureSelectionConfig() {
        this.chooseMode = com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage();
        this.camera = false;
        this.requestedOrientation = -1;
        this.buttonFeatures = com.up366.medialibrary.camera.CustomCameraType.BUTTON_STATE_BOTH;
        this.themeStyleId = com.up366.medialibrary.R.style.picture_default_style;
        this.selectionMode = 2;
        this.maxSelectNum = 9;
        this.minSelectNum = 0;
        this.maxVideoSelectNum = 1;
        this.minVideoSelectNum = 0;
        this.videoQuality = 1;
        this.cropCompressQuality = 90;
        this.recordVideoSecond = 60;
        this.minimumCompressSize = 100;
        this.imageSpanCount = 4;
        this.compressQuality = 80;
        this.filterMinFileSize = 1024L;
        this.language = -2;
        this.isCamera = true;
        this.cameraMimeType = -1;
        this.pageSize = 60;
        this.isPageStrategy = true;
        this.animationMode = -1;
        this.isAutomaticTitleRecyclerTop = true;
        this.isQuickCapture = true;
        this.isCameraRotateImage = true;
        this.isAutoRotating = true;
        this.isSyncCover = false;
        this.isAutoScalePreviewImage = true;
        this.ofAllCameraType = com.up366.medialibrary.common.utils.MimeTypeUtils.ofAll();
    }

    public static void destroy() {
        listener = null;
        customVideoPlayCallback = null;
        onCustomImagePreviewCallback = null;
        onCustomCameraInterfaceListener = null;
        onPermissionsObtainCallback = null;
        onChooseLimitCallback = null;
        imageEngine = null;
        compressEngine = null;
    }
}
