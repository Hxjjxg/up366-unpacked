package com.up366.mobile.book.exercise.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TakePhotoHelper {
    private static final int GET_PHOTO_HANDLE_TYPE = 0;
    private static final int GET_PHOTO_V2_HANDLE_TYPE = 1;
    private static int globalRequestCode;
    private static int handleType;
    private android.content.Context context;
    private com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo;
    private com.up366.mobile.book.helper.PhotoAndRecognitionHelper photoAndRecognitionHelper;
    private int requestCode;

    /* JADX WARN: Multi-variable type inference failed */
    public TakePhotoHelper(com.up366.mobile.book.StudyActivity studyActivity) {
        this.context = studyActivity;
        com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().setApactX(3).setApactY(4).setOutX(900).setOutY(1360).setViewId(java.lang.String.valueOf(-120468907));
        this.photoAndRecognitionHelper = new com.up366.mobile.book.helper.PhotoAndRecognitionHelper(studyActivity);
    }

    public TakePhotoHelper(android.app.Activity activity) {
        this.context = activity;
        com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().setApactX(3).setApactY(4).setOutX(900).setOutY(1360).setViewId(java.lang.String.valueOf(-120468907));
        this.photoAndRecognitionHelper = new com.up366.mobile.book.helper.PhotoAndRecognitionHelper(activity);
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        if (handleType == 0) {
            com.up366.multimedia.util.MediaHelper.getInstance().onActivityResult(i, i2, intent);
        } else {
            this.photoAndRecognitionHelper.onActivityResult(i, i2, intent);
        }
    }

    public void getPhotoNew(final java.lang.String str, java.lang.String str2, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        int i = globalRequestCode + 1;
        globalRequestCode = i;
        this.requestCode = i;
        handleType = 0;
        this.iCallbackCodeInfo = new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.exercise.js.TakePhotoHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i2, java.lang.String str3) {
                com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.exercise.js.TakePhotoHelper$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.book.exercise.js.TakePhotoHelper.lambda$getPhotoNew$0(str3, str, iCallbackCodeInfo, i2);
                    }
                });
            }
        };
        com.up366.mobile.common.utils.PhotoSelectUtils.showPictureDialog(this.context, str2, false, true, false);
    }

    static /* synthetic */ void lambda$getPhotoNew$0(java.lang.String str, java.lang.String str2, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo, int i) throws java.lang.Exception {
        if (com.up366.common.FileUtilsUp.isFileExists(str)) {
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(str2, com.up366.common.digest.MD5.md5(str), new java.io.File(str).getName());
            com.up366.common.BitmapUtilsUp.compressBitmap(strJoin, str, com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO, com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO, 80);
            str = strJoin;
        }
        iCallbackCodeInfo.onResult(i, str);
    }

    public void getPictureCropAndRecognition(final int i, final com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback resultCallback) {
        java.lang.String strCompatPermission = com.up366.mobile.common.utils.PermissionUtils.compatPermission();
        android.content.Context context = this.context;
        com.up366.mobile.common.utils.PermissionUtils.checkPermission(context, new java.lang.String[]{"相机权限", "存储权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA, strCompatPermission}, context.getString(com.up366.mobile.R.string.permission_camera), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.exercise.js.TakePhotoHelper$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i2, java.lang.String str) {
                this.f$0.lambda$getPictureCropAndRecognition$2(i, resultCallback, i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPictureCropAndRecognition$2(int i, com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback resultCallback, int i2, java.lang.String str) {
        if (i2 == 0) {
            int i3 = globalRequestCode + 1;
            globalRequestCode = i3;
            this.requestCode = i3;
            handleType = 1;
            this.photoAndRecognitionHelper.getPictureCropAndRecognition(i, resultCallback);
        }
    }

    public void getPictureCrop(final java.lang.String str, final com.alibaba.fastjson.JSONObject jSONObject, final com.up366.common.callback.ICallbackCodeInfoObj<java.util.List<java.lang.String>> iCallbackCodeInfoObj) {
        java.lang.String strCompatPermission = com.up366.mobile.common.utils.PermissionUtils.compatPermission();
        android.content.Context context = this.context;
        com.up366.mobile.common.utils.PermissionUtils.checkPermission(context, new java.lang.String[]{"相机权限", "存储权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA, strCompatPermission}, context.getString(com.up366.mobile.R.string.permission_camera), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.exercise.js.TakePhotoHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str2) {
                this.f$0.lambda$getPictureCrop$4(str, iCallbackCodeInfoObj, jSONObject, i, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPictureCrop$4(final java.lang.String str, final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, com.alibaba.fastjson.JSONObject jSONObject, final int i, java.lang.String str2) {
        if (i == 0) {
            int i2 = globalRequestCode + 1;
            globalRequestCode = i2;
            this.requestCode = i2;
            handleType = 1;
            this.photoAndRecognitionHelper.getPictureCropAndFileInfo(jSONObject, new com.up366.mobile.book.helper.PhotoAndRecognitionHelper.FileInfoCallback() { // from class: com.up366.mobile.book.exercise.js.TakePhotoHelper$$ExternalSyntheticLambda3
                @Override // com.up366.mobile.book.helper.PhotoAndRecognitionHelper.FileInfoCallback
                public final void onFileInfo(java.util.List list) {
                    com.up366.mobile.book.exercise.js.TakePhotoHelper.lambda$getPictureCrop$3(str, iCallbackCodeInfoObj, i, list);
                }
            });
        }
    }

    static /* synthetic */ void lambda$getPictureCrop$3(java.lang.String str, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, int i, java.util.List list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            java.lang.String str2 = (java.lang.String) it.next();
            if (com.up366.common.FileUtilsUp.isFileExists(str2)) {
                java.lang.String strJoin = com.up366.common.FileUtilsUp.join(str, com.up366.common.digest.MD5.md5(str2), new java.io.File(str2).getName());
                com.up366.common.BitmapUtilsUp.compressBitmap(strJoin, str2, com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO, com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO, 80);
                arrayList.add(strJoin);
            }
        }
        iCallbackCodeInfoObj.onResult(i, "", arrayList);
    }

    public void onMessageEvent(com.up366.multimedia.event.PictureLoadEvent pictureLoadEvent) {
        if (globalRequestCode == this.requestCode) {
            if (handleType == 0) {
                com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo = this.iCallbackCodeInfo;
                if (iCallbackCodeInfo != null) {
                    iCallbackCodeInfo.onResult(0, pictureLoadEvent.getDatas()[0]);
                    return;
                }
                return;
            }
            this.photoAndRecognitionHelper.onMessageEvent(pictureLoadEvent);
        }
    }
}
