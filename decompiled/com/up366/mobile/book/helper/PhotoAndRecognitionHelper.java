package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PhotoAndRecognitionHelper {
    private static final int REQUEST_CODE_ALBUM_ACTIVITY = 101;
    private static final int REQUEST_CODE_CROP_ACTIVITY = 102;
    private static final int REQUEST_CODE_RECOGNITION_ACTIVITY = 103;
    private static final int REQUEST_CODE_SMART_CAMERA_ACTIVITY = 104;
    private com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback callback;
    private android.app.Activity context;
    private java.lang.String cropPath;
    private com.up366.mobile.book.helper.PhotoAndRecognitionHelper.FileInfoCallback fileInfoCallback;
    private java.lang.String imagePath;
    private int skipConfirm;
    private boolean smartPicture = true;
    private boolean enableOcr = true;
    private com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();

    public interface FileInfoCallback {
        void onFileInfo(java.util.List<java.lang.String> list);
    }

    public interface ResultCallback {
        void onResult(java.lang.String str, java.lang.String str2, java.lang.String str3);
    }

    public PhotoAndRecognitionHelper(android.app.Activity activity) {
        this.context = activity;
    }

    public void setEnableOcr(boolean z) {
        this.enableOcr = z;
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        switch (i) {
            case 101:
                if (i2 == 0 && intent == null) {
                    gotoSmartCameraActivity();
                    break;
                }
                break;
            case 102:
                checkCropResultGotoActivity(i2, intent);
                break;
            case 103:
                checkRecognitionResultGotoActivity(i2, intent);
                break;
            case 104:
                checkSmartCameraResultGotoActivity(i2, intent);
                break;
        }
    }

    private void checkCropResultGotoActivity(int i, android.content.Intent intent) {
        if (i != -1) {
            if (i != 0) {
                return;
            }
            gotoSmartCameraActivity();
        } else {
            java.lang.String stringExtra = intent.getStringExtra(com.up366.multimediav2.activity.CropActivity.INTENT_IMAGE_OUTPUT_URI);
            this.cropPath = stringExtra;
            if (this.enableOcr) {
                com.up366.mobile.book.activity.ImageEssayRecognitionActivity.startEssayRecognitionActivityForResult(this.context, 103, stringExtra, this.skipConfirm);
            } else {
                processFileInfoDirectly();
            }
        }
    }

    private void checkRecognitionResultGotoActivity(int i, android.content.Intent intent) {
        if (i != -1) {
            if (i == 0) {
                gotoCropActivity(this.cropPath, this.smartPicture, this.jsonObject);
                return;
            } else {
                if (i != 100) {
                    return;
                }
                gotoSmartCameraActivity();
                return;
            }
        }
        if (this.callback == null || intent == null) {
            return;
        }
        this.callback.onResult(intent.getStringExtra(com.up366.mobile.book.activity.ImageEssayRecognitionActivity.INTENT_RECOGNITION_RESULT), intent.getStringExtra(com.up366.mobile.book.activity.ImageEssayRecognitionActivity.INTENT_IMAGE_NET_URL), intent.getStringExtra(com.up366.mobile.book.activity.ImageEssayRecognitionActivity.INTENT_OCR_TID));
    }

    private void checkSmartCameraResultGotoActivity(int i, android.content.Intent intent) {
        if (i == -1) {
            this.smartPicture = intent.getBooleanExtra(com.up366.multimediav2.activity.SmartAnswerCameraActivity.TAKE_PICTURE_SMART, false);
            java.lang.String stringExtra = intent.getStringExtra(com.up366.multimediav2.activity.SmartAnswerCameraActivity.IMAGE_SAVE_PATH_AND_NAME);
            this.imagePath = stringExtra;
            gotoCropActivity(stringExtra, this.smartPicture, this.jsonObject);
            return;
        }
        if (i != 0) {
            if (i != 100) {
                return;
            }
            com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().setSelectPictureSupportZoom(false);
            android.content.Intent intent2 = new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.multimedia.activity.AlbumActivity.class);
            intent2.putExtra("maxSize", 1);
            this.context.startActivityForResult(intent2, 101);
            return;
        }
        if (this.enableOcr) {
            com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback resultCallback = this.callback;
            if (resultCallback != null) {
                resultCallback.onResult(null, null, null);
                return;
            }
            return;
        }
        com.up366.mobile.book.helper.PhotoAndRecognitionHelper.FileInfoCallback fileInfoCallback = this.fileInfoCallback;
        if (fileInfoCallback != null) {
            fileInfoCallback.onFileInfo(new java.util.ArrayList());
        }
    }

    private void processFileInfoDirectly() {
        if (this.fileInfoCallback == null) {
            com.up366.common.log.Logger.error("PhotoAndRecognitionHelper processFileInfoDirectly fileInfoCallback is null");
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(this.cropPath);
        this.fileInfoCallback.onFileInfo(arrayList);
    }

    private void gotoCropActivity(java.lang.String str, boolean z, com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new com.alibaba.fastjson.JSONObject();
        }
        com.up366.multimediav2.activity.CropActivity.startCropActivity(this.context, str, getTempCropImagePath(), z, 102, true, jSONObject.toJSONString());
    }

    private void gotoSmartCameraActivity() {
        deleteTempPicture();
        com.up366.multimediav2.activity.SmartAnswerCameraActivity.startCameraActivityForResult(this.context, 104, this.imagePath);
    }

    private void deleteTempPicture() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.PhotoAndRecognitionHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$deleteTempPicture$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteTempPicture$0() throws java.lang.Exception {
        com.up366.common.FileUtilsUp.deleteDirOrFile(this.imagePath);
        com.up366.common.FileUtilsUp.deleteDirOrFile(getTempCropImagePath());
    }

    public void getPictureCropAndRecognition(int i, com.up366.mobile.book.helper.PhotoAndRecognitionHelper.ResultCallback resultCallback) {
        this.enableOcr = true;
        this.jsonObject = new com.alibaba.fastjson.JSONObject();
        this.skipConfirm = i;
        this.imagePath = this.context.getCacheDir().getAbsolutePath() + "/recognition_picture.jpg";
        this.callback = resultCallback;
        this.fileInfoCallback = null;
        gotoSmartCameraActivity();
    }

    public void getPictureCropAndFileInfo(com.alibaba.fastjson.JSONObject jSONObject, com.up366.mobile.book.helper.PhotoAndRecognitionHelper.FileInfoCallback fileInfoCallback) {
        this.jsonObject = jSONObject;
        this.enableOcr = false;
        this.fileInfoCallback = fileInfoCallback;
        this.callback = null;
        this.imagePath = this.context.getCacheDir().getAbsolutePath() + "/recognition_picture.jpg";
        gotoSmartCameraActivity();
    }

    private java.lang.String getTempCropImagePath() {
        if (!this.enableOcr) {
            return this.context.getCacheDir().getAbsolutePath() + "/" + java.util.UUID.randomUUID().toString().replace("-", "") + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG;
        }
        return this.context.getCacheDir().getAbsolutePath() + "/recognition_picture.temp.jpg";
    }

    public void onMessageEvent(com.up366.multimedia.event.PictureLoadEvent pictureLoadEvent) {
        if (pictureLoadEvent.getImageItems() == null || pictureLoadEvent.getImageItems().isEmpty()) {
            return;
        }
        this.smartPicture = false;
        gotoCropActivity(pictureLoadEvent.getImageItems().get(0).imagePath, false, this.jsonObject);
    }
}
