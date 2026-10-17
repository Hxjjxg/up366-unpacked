package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ImageEssayRecognitionHelper {
    private java.lang.String imageNetUrl;
    private java.lang.String imagePath;
    private int pollingTimes;
    private boolean stopRecognition;
    private java.util.Timer timer = new java.util.Timer();

    public ImageEssayRecognitionHelper(java.lang.String str) {
        this.imagePath = str;
    }

    public void start() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.ImageEssayRecognitionHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                this.f$0.startUploadImage();
            }
        });
    }

    public void stop() {
        this.stopRecognition = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadImage() {
        uploadImageToast();
        java.lang.String strReplace = this.imagePath.replace(com.up366.medialibrary.common.utils.MimeTypeUtils.JPG, java.lang.System.currentTimeMillis() + "_upload.jpg");
        com.up366.common.BitmapUtilsUp.compressBitmap(strReplace, this.imagePath, com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO, com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO, 80);
        com.up366.mobile.common.logic.Auth.cur().fileMgr().save(strReplace, null, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getObjectKeyUnique(strReplace, com.up366.medialibrary.common.utils.MimeTypeUtils.JPG), new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.helper.ImageEssayRecognitionHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                this.f$0.lambda$startUploadImage$0(fileMapInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startUploadImage$0(final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfo, new com.up366.mobile.common.utils.alifile.IOSSCallback() { // from class: com.up366.mobile.book.helper.ImageEssayRecognitionHelper.1
            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onProgress(long j, long j2) {
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onSuccess() {
                com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.timer.cancel();
                com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.imageNetUrl = fileMapInfo.getUrl();
                com.up366.common.log.Logger.info("ImageEssayRecognitionHelper upload image success imageNetUrl=" + com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.imageNetUrl);
                com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.startRecognition();
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onFailure(int i, java.lang.String str) {
                com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.timer.cancel();
                com.up366.common.log.Logger.error("ImageEssayRecognitionHelper upload image error code=" + i + " info=" + str + " imageUrl : " + com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.imageNetUrl);
                com.up366.mobile.common.event.ImageEssayRecognitionEvent imageEssayRecognitionEvent = new com.up366.mobile.common.event.ImageEssayRecognitionEvent();
                imageEssayRecognitionEvent.setCode(-1);
                com.up366.common.EventBusUtilsUp.post(imageEssayRecognitionEvent);
            }
        });
    }

    private void uploadImageToast() {
        this.timer.schedule(new java.util.TimerTask() { // from class: com.up366.mobile.book.helper.ImageEssayRecognitionHelper.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.stopRecognition) {
                    com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.timer.cancel();
                } else {
                    com.up366.mobile.common.utils.ToastPopupUtil.showInfo(com.up366.common.global.GB.get().getCurrentActivity(), "网络缓慢，请耐心等待");
                }
            }
        }, com.igexin.push.config.c.i, com.igexin.push.config.c.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecognition() {
        java.lang.String str;
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            str = com.up366.mobile.common.http.HttpMgrUtils.IMAGE_ESSAY_RECOGNITION_LOGIN;
        } else {
            str = com.up366.mobile.common.http.HttpMgrUtils.IMAGE_ESSAY_RECOGNITION_LOGOUT;
        }
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(str) { // from class: com.up366.mobile.book.helper.ImageEssayRecognitionHelper.3
            java.lang.String ut;

            {
                this.ut = com.up366.common.StringUtils.getUt(com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.imageNetUrl + com.up366.mobile.common.logic.Auth.UID() + com.up366.common.global.GB.get().getUniqueDeviceId(), 90);
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.imageNetUrl);
                map.put("mode", "essay");
                map.put("rotate", 1);
                if (!com.up366.mobile.common.logic.Auth.isAuth()) {
                    map.put("ut", this.ut);
                }
                com.up366.common.log.Logger.info("params " + com.alibaba.fastjson.JSON.toJSONString(map));
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str2) {
                super.onResponse(response, str2);
                if (response.isError()) {
                    com.up366.common.log.Logger.error("upload recognition image url error code=" + response.getCode() + " info=" + response.getInfo());
                    com.up366.mobile.common.event.ImageEssayRecognitionEvent imageEssayRecognitionEvent = new com.up366.mobile.common.event.ImageEssayRecognitionEvent();
                    imageEssayRecognitionEvent.setCode(-1);
                    com.up366.common.EventBusUtilsUp.post(imageEssayRecognitionEvent);
                    return;
                }
                com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.getRecognitionResult(com.alibaba.fastjson.JSON.parseObject(str2).getString("tid"));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecognitionResult(java.lang.String str) {
        java.lang.String str2;
        this.pollingTimes++;
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            str2 = com.up366.mobile.common.http.HttpMgrUtils.IMAGE_ESSAY_RECOGNITION_RESULT_LOGIN;
        } else {
            str2 = com.up366.mobile.common.http.HttpMgrUtils.IMAGE_ESSAY_RECOGNITION_RESULT_LOGOUT;
        }
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.book.helper.ImageEssayRecognitionHelper.AnonymousClass4(str2, str));
    }

    /* JADX INFO: renamed from: com.up366.mobile.book.helper.ImageEssayRecognitionHelper$4, reason: invalid class name */
    class AnonymousClass4 extends com.up366.common.http.RequestParams<java.lang.String> {
        final /* synthetic */ java.lang.String val$ocrTid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(java.lang.String str, java.lang.String str2) {
            super(str);
            this.val$ocrTid = str2;
        }

        @Override // com.up366.common.http.RequestParams
        public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
            super.initParams(map);
            map.put("tid", this.val$ocrTid);
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(com.up366.common.http.Response response, java.lang.String str) {
            super.onResponse(response, str);
            if (response.isError()) {
                if (response.getCode() == 3) {
                    if (com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.stopRecognition) {
                        return;
                    }
                    com.up366.common.log.Logger.info("polling recognition result tid=" + this.val$ocrTid + " polling times=" + com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.pollingTimes);
                    final java.lang.String str2 = this.val$ocrTid;
                    com.up366.common.task.TaskUtils.postLazyTaskGlobal("essay_recognition", 1000, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.ImageEssayRecognitionHelper$4$$ExternalSyntheticLambda0
                        @Override // com.up366.common.task.Task
                        public final void run() throws java.lang.Exception {
                            this.f$0.lambda$onResponse$0(str2);
                        }
                    });
                    return;
                }
                if (response.getCode() == 1) {
                    com.up366.mobile.common.event.ImageEssayRecognitionEvent imageEssayRecognitionEvent = new com.up366.mobile.common.event.ImageEssayRecognitionEvent();
                    imageEssayRecognitionEvent.setCode(com.up366.mobile.common.event.ImageEssayRecognitionEvent.RECOGNITION_NO_DATA);
                    com.up366.common.EventBusUtilsUp.post(imageEssayRecognitionEvent);
                    return;
                }
                com.up366.common.log.Logger.info(this.val$ocrTid + " recognition fail code=" + response.getCode() + " info=" + response.getInfo() + " imgurl " + com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.imageNetUrl);
                com.up366.mobile.common.event.ImageEssayRecognitionEvent imageEssayRecognitionEvent2 = new com.up366.mobile.common.event.ImageEssayRecognitionEvent();
                imageEssayRecognitionEvent2.setCode(-1);
                com.up366.common.EventBusUtilsUp.post(imageEssayRecognitionEvent2);
                return;
            }
            com.up366.common.log.Logger.info(this.val$ocrTid + " recognition success imageNetUrl=" + com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.imageNetUrl + " result=" + str);
            com.up366.mobile.common.event.ImageEssayRecognitionEvent imageEssayRecognitionEvent3 = new com.up366.mobile.common.event.ImageEssayRecognitionEvent();
            imageEssayRecognitionEvent3.setCode(0);
            imageEssayRecognitionEvent3.setMessage(response.getInfo());
            imageEssayRecognitionEvent3.setOcrTid(this.val$ocrTid);
            imageEssayRecognitionEvent3.setImageNetUrl(com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.imageNetUrl);
            imageEssayRecognitionEvent3.setResultString(str);
            com.up366.common.EventBusUtilsUp.post(imageEssayRecognitionEvent3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(java.lang.String str) throws java.lang.Exception {
            com.up366.mobile.book.helper.ImageEssayRecognitionHelper.this.getRecognitionResult(str);
        }
    }
}
