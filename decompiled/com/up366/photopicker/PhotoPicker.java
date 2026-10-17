package com.up366.photopicker;

/* JADX INFO: compiled from: PhotoPicker.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0015\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0018J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J#\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+H\u0007J \u0010,\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+H\u0007J \u0010-\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+H\u0007J \u0010.\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)2\u0006\u0010/\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u00100\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0007J\u0018\u00101\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0007J\u0018\u00102\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0007J\u0018\u00103\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0007J\u0014\u00104\u001a\u0004\u0018\u00010\u000e2\b\u00105\u001a\u0004\u0018\u00010\u0013H\u0007J\"\u00106\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0004j\b\u0012\u0004\u0012\u00020\t`\u00062\b\u00105\u001a\u0004\u0018\u00010\u0013H\u0007J\"\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u00105\u001a\u0004\u0018\u00010\u0013H\u0007J#\u00108\u001a\u00020'2\u0006\u0010/\u001a\u00020\u00132\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0000¢\u0006\u0002\b:J\b\u0010;\u001a\u00020\u000eH\u0002¨\u0006<"}, d2 = {"Lcom/up366/photopicker/PhotoPicker;", "", "()V", "buildPhotoResults", "Ljava/util/ArrayList;", "Lcom/up366/photopicker/PhotoPickerPhotoResult;", "Lkotlin/collections/ArrayList;", "paths", "", "", "isRectAdjusted", "", "buildPhotoResults$photopicker_release", "checkCameraLaunch", "Lcom/up366/photopicker/PhotoPickerLaunchResult;", "context", "Landroid/content/Context;", "checkGalleryLaunch", "createCameraIntent", "Landroid/content/Intent;", "config", "Lcom/up366/photopicker/config/PhotoPickerConfig;", "createLaunchResultIntent", "result", "createLaunchResultIntent$photopicker_release", "createMultiGalleryIntent", "createPhotoResult", "localPath", "createPhotoResult$photopicker_release", "createSingleGalleryIntent", "failedLaunchResult", "errorCode", "errorMessage", "getCameraStartFailedMessage", "getCameraUnavailableMessage", "getGalleryStartFailedMessage", "getPermissionDeniedMessage", "isCameraAvailable", "launchCamera", "", "activity", "Landroid/app/Activity;", "requestCode", "", "launchCameraSafely", "launchCameraWithResult", "launchGalleryInternal", "intent", "launchMultiGallery", "launchMultiGalleryWithResult", "launchSingleGallery", "launchSingleGalleryWithResult", "parseLaunchResult", "data", "parsePaths", "parseResults", "putResults", "results", "putResults$photopicker_release", "successLaunchResult", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PhotoPicker {
    public static final com.up366.photopicker.PhotoPicker INSTANCE = new com.up366.photopicker.PhotoPicker();

    private PhotoPicker() {
    }

    private final com.up366.photopicker.PhotoPickerLaunchResult successLaunchResult() {
        return new com.up366.photopicker.PhotoPickerLaunchResult(true, null, null, 6, null);
    }

    private final com.up366.photopicker.PhotoPickerLaunchResult failedLaunchResult(java.lang.String errorCode, java.lang.String errorMessage) {
        return new com.up366.photopicker.PhotoPickerLaunchResult(false, errorCode, errorMessage);
    }

    @kotlin.jvm.JvmStatic
    public static final android.content.Intent createCameraIntent(android.content.Context context, com.up366.photopicker.config.PhotoPickerConfig config) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(config, "config");
        com.up366.common.log.Logger.info("PhotoPicker createCameraIntent");
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.photopicker.ui.camera.CameraActivity.class);
        intent.putExtra("config", com.alibaba.fastjson.JSON.toJSONString(config));
        return intent;
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isCameraAvailable(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String getCameraUnavailableMessage(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        java.lang.String string = context.getString(com.up366.photopicker.R.string.up366_photo_picker_camera_unavailable);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…icker_camera_unavailable)");
        return string;
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String getCameraStartFailedMessage(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        java.lang.String string = context.getString(com.up366.photopicker.R.string.up366_photo_picker_camera_start_failed);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…cker_camera_start_failed)");
        return string;
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String getGalleryStartFailedMessage(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        java.lang.String string = context.getString(com.up366.photopicker.R.string.up366_photo_picker_gallery_start_failed);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ker_gallery_start_failed)");
        return string;
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String getPermissionDeniedMessage(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        java.lang.String string = context.getString(com.up366.photopicker.R.string.up366_photo_picker_permission_denied);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…picker_permission_denied)");
        return string;
    }

    @kotlin.jvm.JvmStatic
    public static final com.up366.photopicker.PhotoPickerLaunchResult checkCameraLaunch(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.photopicker.PhotoPicker photoPicker = INSTANCE;
        if (isCameraAvailable(context)) {
            return photoPicker.successLaunchResult();
        }
        return photoPicker.failedLaunchResult(com.up366.photopicker.PhotoPickerErrorCode.CAMERA_UNAVAILABLE, getCameraUnavailableMessage(context));
    }

    @kotlin.jvm.JvmStatic
    public static final android.content.Intent createSingleGalleryIntent(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.photopicker.ui.gallery.GalleryActivity.class);
        intent.putExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_GALLERY_MULTI_SELECT, false);
        return intent;
    }

    @kotlin.jvm.JvmStatic
    public static final android.content.Intent createMultiGalleryIntent(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.photopicker.ui.gallery.GalleryActivity.class);
        intent.putExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_GALLERY_MULTI_SELECT, true);
        return intent;
    }

    @kotlin.jvm.JvmStatic
    public static final void launchCamera(android.app.Activity activity, com.up366.photopicker.config.PhotoPickerConfig config, int requestCode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(config, "config");
        launchCameraSafely(activity, config, requestCode);
    }

    @kotlin.jvm.JvmStatic
    public static final boolean launchCameraSafely(android.app.Activity activity, com.up366.photopicker.config.PhotoPickerConfig config, int requestCode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(config, "config");
        return launchCameraWithResult(activity, config, requestCode).getSuccess();
    }

    @kotlin.jvm.JvmStatic
    public static final com.up366.photopicker.PhotoPickerLaunchResult launchCameraWithResult(android.app.Activity activity, com.up366.photopicker.config.PhotoPickerConfig config, int requestCode) {
        com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResultFailedLaunchResult;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(config, "config");
        com.up366.common.log.Logger.info("PhotoPicker launchCameraWithResult requestCode=" + requestCode);
        com.up366.photopicker.PhotoPicker photoPicker = INSTANCE;
        android.app.Activity activity2 = activity;
        com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResultCheckCameraLaunch = checkCameraLaunch(activity2);
        if (!photoPickerLaunchResultCheckCameraLaunch.getSuccess()) {
            com.up366.common.log.Logger.error("PhotoPicker 相机启动前检查失败 errorCode=" + photoPickerLaunchResultCheckCameraLaunch.getErrorCode() + " message=" + photoPickerLaunchResultCheckCameraLaunch.getErrorMessage());
            android.widget.Toast.makeText(activity2, photoPickerLaunchResultCheckCameraLaunch.getErrorMessage(), 0).show();
            return photoPickerLaunchResultCheckCameraLaunch;
        }
        try {
            activity.startActivityForResult(createCameraIntent(activity, config), requestCode);
            com.up366.common.log.Logger.info("PhotoPicker 成功拉起 CameraActivity");
            return photoPicker.successLaunchResult();
        } catch (android.content.ActivityNotFoundException e) {
            photoPickerLaunchResultFailedLaunchResult = INSTANCE.failedLaunchResult(com.up366.photopicker.PhotoPickerErrorCode.CAMERA_START_FAILED, getCameraStartFailedMessage(activity2));
            com.up366.common.log.Logger.error("PhotoPicker 拉起 CameraActivity 失败", e);
            android.widget.Toast.makeText(activity2, photoPickerLaunchResultFailedLaunchResult.getErrorMessage(), 0).show();
            return photoPickerLaunchResultFailedLaunchResult;
        } catch (java.lang.Exception e2) {
            photoPickerLaunchResultFailedLaunchResult = INSTANCE.failedLaunchResult(com.up366.photopicker.PhotoPickerErrorCode.CAMERA_START_FAILED, getCameraStartFailedMessage(activity2));
            com.up366.common.log.Logger.error("PhotoPicker 拉起 CameraActivity 异常", e2);
            android.widget.Toast.makeText(activity2, photoPickerLaunchResultFailedLaunchResult.getErrorMessage(), 0).show();
            return photoPickerLaunchResultFailedLaunchResult;
        }
    }

    @kotlin.jvm.JvmStatic
    public static final void launchSingleGallery(android.app.Activity activity, int requestCode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        launchSingleGalleryWithResult(activity, requestCode);
    }

    @kotlin.jvm.JvmStatic
    public static final void launchMultiGallery(android.app.Activity activity, int requestCode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        launchMultiGalleryWithResult(activity, requestCode);
    }

    @kotlin.jvm.JvmStatic
    public static final com.up366.photopicker.PhotoPickerLaunchResult checkGalleryLaunch(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.successLaunchResult();
    }

    @kotlin.jvm.JvmStatic
    public static final com.up366.photopicker.PhotoPickerLaunchResult launchSingleGalleryWithResult(android.app.Activity activity, int requestCode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        com.up366.common.log.Logger.info("PhotoPicker launchSingleGalleryWithResult requestCode=" + requestCode);
        return INSTANCE.launchGalleryInternal(activity, createSingleGalleryIntent(activity), requestCode);
    }

    @kotlin.jvm.JvmStatic
    public static final com.up366.photopicker.PhotoPickerLaunchResult launchMultiGalleryWithResult(android.app.Activity activity, int requestCode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        com.up366.common.log.Logger.info("PhotoPicker launchMultiGalleryWithResult requestCode=" + requestCode);
        return INSTANCE.launchGalleryInternal(activity, createMultiGalleryIntent(activity), requestCode);
    }

    @kotlin.jvm.JvmStatic
    public static final java.util.ArrayList<com.up366.photopicker.PhotoPickerPhotoResult> parseResults(android.content.Intent data) {
        java.util.ArrayList parcelableArrayListExtra;
        if (data == null) {
            return new java.util.ArrayList<>();
        }
        if (android.os.Build.VERSION.SDK_INT >= 33) {
            parcelableArrayListExtra = data.getParcelableArrayListExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_PHOTO_RESULTS, com.up366.photopicker.PhotoPickerPhotoResult.class);
        } else {
            parcelableArrayListExtra = data.getParcelableArrayListExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_PHOTO_RESULTS);
        }
        java.util.ArrayList arrayList = parcelableArrayListExtra;
        if (arrayList != null && !arrayList.isEmpty()) {
            com.up366.common.log.Logger.info("PhotoPicker parseResults count=" + parcelableArrayListExtra.size());
            return new java.util.ArrayList<>(arrayList);
        }
        return new java.util.ArrayList<>();
    }

    @kotlin.jvm.JvmStatic
    public static final java.util.ArrayList<java.lang.String> parsePaths(android.content.Intent data) {
        java.util.ArrayList<com.up366.photopicker.PhotoPickerPhotoResult> results = parseResults(data);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = results.iterator();
        while (it.hasNext()) {
            java.lang.String localPath = ((com.up366.photopicker.PhotoPickerPhotoResult) it.next()).getLocalPath();
            if (localPath != null) {
                arrayList.add(localPath);
            }
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (java.lang.Object obj : arrayList) {
            if (!kotlin.text.StringsKt.isBlank((java.lang.String) obj)) {
                arrayList2.add(obj);
            }
        }
        return new java.util.ArrayList<>(arrayList2);
    }

    @kotlin.jvm.JvmStatic
    public static final com.up366.photopicker.PhotoPickerLaunchResult parseLaunchResult(android.content.Intent data) {
        if (data == null) {
            return null;
        }
        if (data.hasExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_LAUNCH_SUCCESS) || data.hasExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_LAUNCH_ERROR_CODE) || data.hasExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_LAUNCH_ERROR_MESSAGE)) {
            return new com.up366.photopicker.PhotoPickerLaunchResult(data.getBooleanExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_LAUNCH_SUCCESS, false), data.getStringExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_LAUNCH_ERROR_CODE), data.getStringExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_LAUNCH_ERROR_MESSAGE));
        }
        return null;
    }

    public static /* synthetic */ java.util.ArrayList buildPhotoResults$photopicker_release$default(com.up366.photopicker.PhotoPicker photoPicker, java.util.Collection collection, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return photoPicker.buildPhotoResults$photopicker_release(collection, z);
    }

    public final java.util.ArrayList<com.up366.photopicker.PhotoPickerPhotoResult> buildPhotoResults$photopicker_release(java.util.Collection<java.lang.String> paths, boolean isRectAdjusted) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paths, "paths");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = paths.iterator();
        while (it.hasNext()) {
            com.up366.photopicker.PhotoPickerPhotoResult photoPickerPhotoResultCreatePhotoResult$photopicker_release = INSTANCE.createPhotoResult$photopicker_release((java.lang.String) it.next(), isRectAdjusted);
            if (photoPickerPhotoResultCreatePhotoResult$photopicker_release != null) {
                arrayList.add(photoPickerPhotoResultCreatePhotoResult$photopicker_release);
            }
        }
        return new java.util.ArrayList<>(arrayList);
    }

    public static /* synthetic */ com.up366.photopicker.PhotoPickerPhotoResult createPhotoResult$photopicker_release$default(com.up366.photopicker.PhotoPicker photoPicker, java.lang.String str, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return photoPicker.createPhotoResult$photopicker_release(str, z);
    }

    public final com.up366.photopicker.PhotoPickerPhotoResult createPhotoResult$photopicker_release(java.lang.String localPath, boolean isRectAdjusted) {
        java.lang.Object obj;
        if (localPath != null) {
            java.lang.String str = kotlin.text.StringsKt.isBlank(localPath) ^ true ? localPath : null;
            if (str != null) {
                try {
                    kotlin.Result.Companion companion = kotlin.Result.Companion;
                    com.up366.photopicker.PhotoPicker photoPicker = this;
                    java.io.File file = new java.io.File(str);
                    obj = kotlin.Result.constructor-impl(java.lang.Long.valueOf(file.exists() ? file.length() : 0L));
                } catch (java.lang.Throwable th) {
                    kotlin.Result.Companion companion2 = kotlin.Result.Companion;
                    obj = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th));
                }
                if (kotlin.Result.isFailure-impl(obj)) {
                    obj = 0L;
                }
                return new com.up366.photopicker.PhotoPickerPhotoResult(str, "", ((java.lang.Number) obj).longValue(), isRectAdjusted);
            }
        }
        return null;
    }

    public final void putResults$photopicker_release(android.content.Intent intent, java.util.Collection<com.up366.photopicker.PhotoPickerPhotoResult> results) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intent, "intent");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(results, "results");
        java.util.ArrayList<? extends android.os.Parcelable> arrayList = new java.util.ArrayList<>(results);
        com.up366.common.log.Logger.info("PhotoPicker putResults count=" + arrayList.size());
        intent.putParcelableArrayListExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_PHOTO_RESULTS, arrayList);
    }

    public final android.content.Intent createLaunchResultIntent$photopicker_release(com.up366.photopicker.PhotoPickerLaunchResult result) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_LAUNCH_SUCCESS, result.getSuccess());
        intent.putExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_LAUNCH_ERROR_CODE, result.getErrorCode());
        intent.putExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_LAUNCH_ERROR_MESSAGE, result.getErrorMessage());
        return intent;
    }

    private final com.up366.photopicker.PhotoPickerLaunchResult launchGalleryInternal(android.app.Activity activity, android.content.Intent intent, int requestCode) {
        com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResultFailedLaunchResult;
        com.up366.common.log.Logger.info("PhotoPicker launchGalleryInternal requestCode=" + requestCode);
        android.app.Activity activity2 = activity;
        com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResultCheckGalleryLaunch = checkGalleryLaunch(activity2);
        if (!photoPickerLaunchResultCheckGalleryLaunch.getSuccess()) {
            com.up366.common.log.Logger.error("PhotoPicker 相册启动前检查失败 errorCode=" + photoPickerLaunchResultCheckGalleryLaunch.getErrorCode() + " message=" + photoPickerLaunchResultCheckGalleryLaunch.getErrorMessage());
            android.widget.Toast.makeText(activity2, photoPickerLaunchResultCheckGalleryLaunch.getErrorMessage(), 0).show();
            return photoPickerLaunchResultCheckGalleryLaunch;
        }
        try {
            activity.startActivityForResult(intent, requestCode);
            com.up366.common.log.Logger.info("PhotoPicker 成功拉起 GalleryActivity");
            return successLaunchResult();
        } catch (android.content.ActivityNotFoundException e) {
            photoPickerLaunchResultFailedLaunchResult = failedLaunchResult(com.up366.photopicker.PhotoPickerErrorCode.GALLERY_START_FAILED, getGalleryStartFailedMessage(activity2));
            com.up366.common.log.Logger.error("PhotoPicker 拉起 GalleryActivity 失败", e);
            android.widget.Toast.makeText(activity2, photoPickerLaunchResultFailedLaunchResult.getErrorMessage(), 0).show();
            return photoPickerLaunchResultFailedLaunchResult;
        } catch (java.lang.Exception e2) {
            photoPickerLaunchResultFailedLaunchResult = failedLaunchResult(com.up366.photopicker.PhotoPickerErrorCode.GALLERY_START_FAILED, getGalleryStartFailedMessage(activity2));
            com.up366.common.log.Logger.error("PhotoPicker 拉起 GalleryActivity 异常", e2);
            android.widget.Toast.makeText(activity2, photoPickerLaunchResultFailedLaunchResult.getErrorMessage(), 0).show();
            return photoPickerLaunchResultFailedLaunchResult;
        }
    }
}
