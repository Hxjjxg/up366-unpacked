package com.up366.medialibrary.manager;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UCropManager {
    public static void ofEditorImage(android.app.Activity activity, java.lang.String str, java.lang.String str2, int i, int i2) {
        java.lang.String str3;
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.up366.medialibrary.common.utils.ToastUtils.s(activity.getApplicationContext(), activity.getString(com.up366.medialibrary.R.string.picture_not_crop_data));
            return;
        }
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = com.up366.medialibrary.config.PictureSelectionConfig.getInstance();
        boolean zIsHttp = com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str);
        java.lang.String strReplace = str2.replace("image/", ".");
        java.lang.String diskCacheDir = com.up366.medialibrary.common.utils.PictureFileUtils.getDiskCacheDir(activity.getApplicationContext());
        if (android.text.TextUtils.isEmpty(pictureSelectionConfig.renameCropFileName)) {
            str3 = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_CROP_") + strReplace;
        } else {
            str3 = pictureSelectionConfig.renameCropFileName;
        }
        java.io.File file = new java.io.File(diskCacheDir, str3);
        android.net.Uri uriFromFile = (zIsHttp || com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) ? android.net.Uri.parse(str) : android.net.Uri.fromFile(new java.io.File(str));
        com.up366.medialibrary.third.ucrop.UCrop.Options optionsBasicOptions = basicOptions(activity);
        optionsBasicOptions.setInputImageWidth(i);
        optionsBasicOptions.setInputImageHeight(i2);
        optionsBasicOptions.setHideBottomControls(false);
        optionsBasicOptions.setEditorImage(true);
        optionsBasicOptions.setToolbarTitle(activity.getString(com.up366.medialibrary.R.string.picture_editor));
        com.up366.medialibrary.third.ucrop.UCrop.of(uriFromFile, android.net.Uri.fromFile(file)).withOptions(optionsBasicOptions).startAnimationActivity(activity, com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityCropEnterAnimation);
    }

    public static void ofCrop(android.app.Activity activity, java.lang.String str, java.lang.String str2, int i, int i2) {
        java.lang.String str3;
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.up366.medialibrary.common.utils.ToastUtils.s(activity.getApplicationContext(), activity.getString(com.up366.medialibrary.R.string.picture_not_crop_data));
            return;
        }
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = com.up366.medialibrary.config.PictureSelectionConfig.getInstance();
        boolean zIsHttp = com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str);
        java.lang.String strReplace = str2.replace("image/", ".");
        java.lang.String diskCacheDir = com.up366.medialibrary.common.utils.PictureFileUtils.getDiskCacheDir(activity.getApplicationContext());
        if (android.text.TextUtils.isEmpty(pictureSelectionConfig.renameCropFileName)) {
            str3 = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_CROP_") + strReplace;
        } else {
            str3 = pictureSelectionConfig.renameCropFileName;
        }
        java.io.File file = new java.io.File(diskCacheDir, str3);
        android.net.Uri uriFromFile = (zIsHttp || com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) ? android.net.Uri.parse(str) : android.net.Uri.fromFile(new java.io.File(str));
        com.up366.medialibrary.third.ucrop.UCrop.Options optionsBasicOptions = basicOptions(activity);
        optionsBasicOptions.setInputImageWidth(i);
        optionsBasicOptions.setInputImageHeight(i2);
        com.up366.medialibrary.third.ucrop.UCrop.of(uriFromFile, android.net.Uri.fromFile(file)).withOptions(optionsBasicOptions).startAnimationActivity(activity, com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityCropEnterAnimation);
    }

    public static void ofCrop(android.app.Activity activity, java.util.ArrayList<com.up366.medialibrary.model.LocalMedia> arrayList) {
        java.lang.String strRename;
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (arrayList == null || arrayList.size() == 0) {
            com.up366.medialibrary.common.utils.ToastUtils.s(activity.getApplicationContext(), activity.getString(com.up366.medialibrary.R.string.picture_not_crop_data));
            return;
        }
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = com.up366.medialibrary.config.PictureSelectionConfig.getInstance();
        com.up366.medialibrary.third.ucrop.UCrop.Options optionsBasicOptions = basicOptions(activity);
        optionsBasicOptions.setCutListData(arrayList);
        int size = arrayList.size();
        int i = 0;
        if (pictureSelectionConfig.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAll() && pictureSelectionConfig.isWithVideoImage) {
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(size > 0 ? arrayList.get(0).getMimeType() : "")) {
                int i2 = 0;
                while (true) {
                    if (i2 < size) {
                        com.up366.medialibrary.model.LocalMedia localMedia = arrayList.get(i2);
                        if (localMedia != null && com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia.getMimeType())) {
                            i = i2;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
        }
        if (i < size) {
            com.up366.medialibrary.model.LocalMedia localMedia2 = arrayList.get(i);
            optionsBasicOptions.setInputImageWidth(localMedia2.getWidth());
            optionsBasicOptions.setInputImageHeight(localMedia2.getHeight());
            android.net.Uri uriFromFile = (com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(localMedia2.getPath()) || com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(localMedia2.getPath())) ? android.net.Uri.parse(localMedia2.getPath()) : android.net.Uri.fromFile(new java.io.File(localMedia2.getPath()));
            java.lang.String strReplace = localMedia2.getMimeType().replace("image/", ".");
            java.lang.String diskCacheDir = com.up366.medialibrary.common.utils.PictureFileUtils.getDiskCacheDir(activity);
            if (android.text.TextUtils.isEmpty(pictureSelectionConfig.renameCropFileName)) {
                strRename = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_CROP_") + strReplace;
            } else {
                strRename = (pictureSelectionConfig.camera || size == 1) ? pictureSelectionConfig.renameCropFileName : com.up366.medialibrary.common.utils.StringUtils.rename(pictureSelectionConfig.renameCropFileName);
            }
            com.up366.medialibrary.third.ucrop.UCrop.of(uriFromFile, android.net.Uri.fromFile(new java.io.File(diskCacheDir, strRename))).withOptions(optionsBasicOptions).startAnimationMultipleCropActivity(activity, com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityCropEnterAnimation);
        }
    }

    public static com.up366.medialibrary.third.ucrop.UCrop.Options basicOptions(android.content.Context context) {
        boolean typeValueBoolean;
        int typeValueColor;
        int typeValueColor2;
        int typeValueColor3;
        int i;
        com.up366.medialibrary.third.ucrop.UCrop.Options options;
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = com.up366.medialibrary.config.PictureSelectionConfig.getInstance();
        int i2 = 0;
        if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
            i = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_navBarColor;
            typeValueBoolean = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_statusBarChangeTextColor;
            typeValueColor = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleBarBackgroundColor != 0 ? com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleBarBackgroundColor : 0;
            typeValueColor2 = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_statusBarBackgroundColor != 0 ? com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_statusBarBackgroundColor : 0;
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleTextColor != 0) {
                i2 = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleTextColor;
            }
        } else if (com.up366.medialibrary.config.PictureSelectionConfig.cropStyle != null) {
            i = com.up366.medialibrary.config.PictureSelectionConfig.cropStyle.cropNavBarColor;
            typeValueBoolean = com.up366.medialibrary.config.PictureSelectionConfig.cropStyle.isChangeStatusBarFontColor;
            typeValueColor = com.up366.medialibrary.config.PictureSelectionConfig.cropStyle.cropTitleBarBackgroundColor != 0 ? com.up366.medialibrary.config.PictureSelectionConfig.cropStyle.cropTitleBarBackgroundColor : 0;
            typeValueColor2 = com.up366.medialibrary.config.PictureSelectionConfig.cropStyle.cropStatusBarColorPrimaryDark != 0 ? com.up366.medialibrary.config.PictureSelectionConfig.cropStyle.cropStatusBarColorPrimaryDark : 0;
            if (com.up366.medialibrary.config.PictureSelectionConfig.cropStyle.cropTitleColor != 0) {
                i2 = com.up366.medialibrary.config.PictureSelectionConfig.cropStyle.cropTitleColor;
            }
        } else {
            typeValueBoolean = pictureSelectionConfig.isChangeStatusBarFontColor;
            if (!typeValueBoolean) {
                typeValueBoolean = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueBoolean(context, com.up366.medialibrary.R.attr.picture_statusFontColor);
            }
            if (pictureSelectionConfig.cropTitleBarBackgroundColor != 0) {
                typeValueColor = pictureSelectionConfig.cropTitleBarBackgroundColor;
            } else {
                typeValueColor = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(context, com.up366.medialibrary.R.attr.picture_crop_toolbar_bg);
            }
            if (pictureSelectionConfig.cropStatusBarColorPrimaryDark != 0) {
                typeValueColor2 = pictureSelectionConfig.cropStatusBarColorPrimaryDark;
            } else {
                typeValueColor2 = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(context, com.up366.medialibrary.R.attr.picture_crop_status_color);
            }
            if (pictureSelectionConfig.cropTitleColor != 0) {
                typeValueColor3 = pictureSelectionConfig.cropTitleColor;
            } else {
                typeValueColor3 = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(context, com.up366.medialibrary.R.attr.picture_crop_title_color);
            }
            i2 = typeValueColor3;
            i = 0;
        }
        if (pictureSelectionConfig.uCropOptions != null) {
            options = pictureSelectionConfig.uCropOptions;
        } else {
            options = new com.up366.medialibrary.third.ucrop.UCrop.Options();
            options.setCircleDimmedLayer(pictureSelectionConfig.circleDimmedLayer);
            options.setDimmedLayerColor(pictureSelectionConfig.circleDimmedColor);
            options.setShowCropFrame(pictureSelectionConfig.showCropFrame);
            options.setShowCropGrid(pictureSelectionConfig.showCropGrid);
            options.setHideBottomControls(pictureSelectionConfig.hideBottomControls);
            options.setCompressionQuality(pictureSelectionConfig.cropCompressQuality);
            options.setFreeStyleCropEnabled(pictureSelectionConfig.freeStyleCropEnabled);
            options.withAspectRatio(pictureSelectionConfig.aspect_ratio_x, pictureSelectionConfig.aspect_ratio_y);
            if (pictureSelectionConfig.cropWidth > 0 && pictureSelectionConfig.cropHeight > 0) {
                options.withMaxResultSize(pictureSelectionConfig.cropWidth, pictureSelectionConfig.cropHeight);
            }
        }
        options.isOpenWhiteStatusBar(typeValueBoolean);
        options.setToolbarColor(typeValueColor);
        options.setStatusBarColor(typeValueColor2);
        options.setToolbarWidgetColor(i2);
        options.setRenameCropFileName(pictureSelectionConfig.renameCropFileName);
        options.setRequestedOrientation(pictureSelectionConfig.requestedOrientation);
        options.isCamera(pictureSelectionConfig.camera);
        options.isWithVideoImage(pictureSelectionConfig.isWithVideoImage);
        options.isMultipleRecyclerAnimation(pictureSelectionConfig.isMultipleRecyclerAnimation);
        options.setNavBarColor(i);
        options.setDimmedLayerBorderColor(pictureSelectionConfig.circleDimmedBorderColor);
        options.setCircleStrokeWidth(pictureSelectionConfig.circleStrokeWidth);
        options.setDragFrameEnabled(pictureSelectionConfig.isDragFrame);
        options.setScaleEnabled(pictureSelectionConfig.scaleEnabled);
        options.setRotateEnabled(pictureSelectionConfig.rotateEnabled);
        options.setFreestyleCropMode(pictureSelectionConfig.freeStyleCropMode);
        options.setCropDragSmoothToCenter(pictureSelectionConfig.isDragCenter);
        options.isMultipleSkipCrop(pictureSelectionConfig.isMultipleSkipCrop);
        options.setCropExitAnimation(com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityCropExitAnimation);
        if (!android.text.TextUtils.isEmpty(pictureSelectionConfig.cropCompressFormat)) {
            options.setCompressionFormat(android.graphics.Bitmap.CompressFormat.valueOf(pictureSelectionConfig.cropCompressFormat));
        }
        return options;
    }
}
