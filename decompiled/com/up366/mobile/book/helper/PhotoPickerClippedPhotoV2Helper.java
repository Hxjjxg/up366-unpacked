package com.up366.mobile.book.helper;

/* JADX INFO: compiled from: PhotoPickerClippedPhotoV2Helper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\tJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/up366/mobile/book/helper/PhotoPickerClippedPhotoV2Helper;", "", "activity", "Landroid/app/Activity;", "requestCode", "", "<init>", "(Landroid/app/Activity;I)V", "callback", "Lcom/up366/mobile/book/helper/PhotoPickerClippedPhotoV2Helper$Callback;", "launch", "Lcom/up366/photopicker/PhotoPickerLaunchResult;", com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_JSON, "", "jsonObject", "Lcom/alibaba/fastjson/JSONObject;", "onActivityResult", "", "resultCode", "data", "Landroid/content/Intent;", "getRequestCode", "hasPendingRequest", "clearPendingRequest", "", "clearCallback", "launchResult", "photos", "", "Lcom/up366/photopicker/PhotoPickerPhotoResult;", "Callback", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoPickerClippedPhotoV2Helper {
    public static final int REQUEST_CODE = 14930;
    private final android.app.Activity activity;
    private com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.Callback callback;
    private final int requestCode;

    /* JADX INFO: compiled from: PhotoPickerClippedPhotoV2Helper.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\t"}, d2 = {"Lcom/up366/mobile/book/helper/PhotoPickerClippedPhotoV2Helper$Callback;", "", "onResult", "", "launchResult", "Lcom/up366/photopicker/PhotoPickerLaunchResult;", "photos", "", "Lcom/up366/photopicker/PhotoPickerPhotoResult;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Callback {
        void onResult(com.up366.photopicker.PhotoPickerLaunchResult launchResult, java.util.List<com.up366.photopicker.PhotoPickerPhotoResult> photos);
    }

    public PhotoPickerClippedPhotoV2Helper(android.app.Activity activity, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.requestCode = i;
    }

    public /* synthetic */ PhotoPickerClippedPhotoV2Helper(android.app.Activity activity, int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i2 & 2) != 0 ? REQUEST_CODE : i);
    }

    public final com.up366.photopicker.PhotoPickerLaunchResult launch(java.lang.String json, com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.Callback callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        final com.up366.photopicker.config.PhotoPickerConfig photoPickerConfigFromJson = com.up366.mobile.book.helper.LegacyClippedPhotoConfigMapper.INSTANCE.fromJson(json);
        java.lang.String strCompatPermission = com.up366.mobile.common.utils.PermissionUtils.compatPermission();
        android.app.Activity activity = this.activity;
        com.up366.mobile.common.utils.PermissionUtils.checkPermission(activity, new java.lang.String[]{"相机权限", "存储权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA, strCompatPermission}, activity.getString(com.up366.mobile.R.string.permission_camera), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.launch$lambda$0(this.f$0, photoPickerConfigFromJson, i, str);
            }
        });
        return new com.up366.photopicker.PhotoPickerLaunchResult(true, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launch$lambda$0(com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper photoPickerClippedPhotoV2Helper, com.up366.photopicker.config.PhotoPickerConfig photoPickerConfig, int i, java.lang.String str) {
        if (i != 0) {
            photoPickerClippedPhotoV2Helper.clearCallback(new com.up366.photopicker.PhotoPickerLaunchResult(false, java.lang.String.valueOf(i), str), kotlin.collections.CollectionsKt.emptyList());
            return;
        }
        com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResultLaunchCameraWithResult = com.up366.photopicker.PhotoPicker.launchCameraWithResult(photoPickerClippedPhotoV2Helper.activity, photoPickerConfig, photoPickerClippedPhotoV2Helper.requestCode);
        if (photoPickerLaunchResultLaunchCameraWithResult.getSuccess()) {
            return;
        }
        photoPickerClippedPhotoV2Helper.clearCallback(photoPickerLaunchResultLaunchCameraWithResult, kotlin.collections.CollectionsKt.emptyList());
    }

    public final com.up366.photopicker.PhotoPickerLaunchResult launch(com.alibaba.fastjson.JSONObject jsonObject, com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.Callback callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        return launch(jsonObject != null ? jsonObject.toJSONString() : null, callback);
    }

    public final boolean onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
        java.util.ArrayList<com.up366.photopicker.PhotoPickerPhotoResult> arrayList;
        com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResult;
        if (requestCode != this.requestCode) {
            return false;
        }
        com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.Callback callback = this.callback;
        if (callback == null) {
            return true;
        }
        if (resultCode == -1) {
            arrayList = com.up366.photopicker.PhotoPicker.parseResults(data);
        } else {
            arrayList = new java.util.ArrayList<>();
        }
        if (resultCode == -1) {
            photoPickerLaunchResult = new com.up366.photopicker.PhotoPickerLaunchResult(true, null, null, 6, null);
        } else if (resultCode == 0) {
            photoPickerLaunchResult = com.up366.photopicker.PhotoPicker.parseLaunchResult(data);
            if (photoPickerLaunchResult == null) {
                photoPickerLaunchResult = new com.up366.photopicker.PhotoPickerLaunchResult(true, null, null, 6, null);
            }
        } else {
            photoPickerLaunchResult = new com.up366.photopicker.PhotoPickerLaunchResult(false, null, "Unexpected activity result: " + resultCode, 2, null);
        }
        this.callback = null;
        callback.onResult(photoPickerLaunchResult, arrayList);
        return true;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final boolean hasPendingRequest() {
        return this.callback != null;
    }

    public final void clearPendingRequest() {
        this.callback = null;
    }

    private final void clearCallback(com.up366.photopicker.PhotoPickerLaunchResult launchResult, java.util.List<com.up366.photopicker.PhotoPickerPhotoResult> photos) {
        com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.Callback callback = this.callback;
        if (callback == null) {
            return;
        }
        this.callback = null;
        callback.onResult(launchResult, photos);
    }
}
