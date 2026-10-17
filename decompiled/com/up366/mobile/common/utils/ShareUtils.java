package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ShareUtils {
    public static final int TYPE_CANCEL = 100;
    public static final int TYPE_ERROR = -105;
    public static final int TYPE_NET_ERROR = -102;
    public static final int TYPE_NOT_SUPPORT = -101;
    public static final int TYPE_NO_ALIPAY = -107;
    public static final int TYPE_NO_QQ = -103;
    public static final int TYPE_NO_WX = -104;
    public static final int TYPE_SAVE_PICTURE_ERROR = -106;
    public static final int TYPE_SUCCESS = 0;
    private final android.app.Activity context;

    public ShareUtils(android.app.Activity activity) {
        this.context = activity;
    }

    public void shareURL(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, com.umeng.socialize.bean.SHARE_MEDIA share_media) {
        if (i == 0) {
            i = com.up366.mobile.R.drawable.share_default_thumb;
        }
        shareURL(str, str2, str3, new com.umeng.socialize.media.UMImage(this.context, i), share_media);
    }

    public void shareURL(java.lang.String str, java.lang.String str2, java.lang.String str3, com.umeng.socialize.media.UMImage uMImage, com.umeng.socialize.bean.SHARE_MEDIA share_media) {
        shareURL(str, str2, str3, uMImage, share_media, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.utils.ShareUtils$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str4) {
                com.up366.common.log.Logger.info("TAG - ShareUtils - onResult - code = [" + i + "], info = [" + str4 + "]");
            }
        });
    }

    public void shareURL(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, com.umeng.socialize.media.UMImage uMImage, final com.umeng.socialize.bean.SHARE_MEDIA share_media, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        final com.umeng.socialize.media.UMImage uMImage2 = uMImage == null ? new com.umeng.socialize.media.UMImage(this.context, com.up366.mobile.R.drawable.share_default_thumb) : uMImage;
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ShareUtils$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$shareURL$2(uMImage2, str, str2, str3, share_media, iCallbackCodeInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareURL$2(com.umeng.socialize.media.UMImage uMImage, java.lang.String str, java.lang.String str2, java.lang.String str3, final com.umeng.socialize.bean.SHARE_MEDIA share_media, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) throws java.lang.Exception {
        android.graphics.Bitmap bitmapFromUrl;
        java.lang.String strAsUrlImage = uMImage.asUrlImage();
        if (!com.up366.common.StringUtils.isEmptyOrNull(strAsUrlImage) && (bitmapFromUrl = getBitmapFromUrl(strAsUrlImage)) != null) {
            java.lang.String str4 = com.up366.mobile.common.utils.AppFileUtils.getAppInternalCacheDir() + "/share_tem_thumb.png";
            com.up366.common.BitmapUtilsUp.saveBitmap(bitmapFromUrl, str4);
            uMImage = new com.umeng.socialize.media.UMImage(this.context, new java.io.File(str4));
        }
        final com.umeng.socialize.media.UMWeb uMWeb = new com.umeng.socialize.media.UMWeb(str);
        uMWeb.setTitle(str2);
        uMWeb.setDescription(str3);
        uMWeb.setThumb(uMImage);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ShareUtils$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$shareURL$1(uMWeb, share_media, iCallbackCodeInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareURL$1(com.umeng.socialize.media.UMWeb uMWeb, com.umeng.socialize.bean.SHARE_MEDIA share_media, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) throws java.lang.Exception {
        shareImpl(null, uMWeb, share_media, iCallbackCodeInfo);
    }

    public void shareImage(android.view.View view, com.umeng.socialize.bean.SHARE_MEDIA share_media, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) throws java.lang.Throwable {
        shareImage(getBitmapFromView(view), share_media, iCallbackCodeInfo);
    }

    public void shareImage(android.graphics.Bitmap bitmap, com.umeng.socialize.bean.SHARE_MEDIA share_media, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) throws java.lang.Throwable {
        java.lang.String str = com.up366.mobile.common.utils.AppFileUtils.getAppInternalCacheDir() + "/share_tem_thumb.png";
        java.lang.String str2 = com.up366.mobile.common.utils.AppFileUtils.getAppInternalCacheDir() + "/share_tem.png";
        com.up366.common.BitmapUtilsUp.saveBitmap(android.graphics.Bitmap.createScaledBitmap(bitmap, 128, 256, true), str);
        com.up366.common.BitmapUtilsUp.saveBitmap(bitmap, str2);
        com.umeng.socialize.media.UMImage uMImage = new com.umeng.socialize.media.UMImage(this.context, new java.io.File(str2));
        uMImage.setThumb(new com.umeng.socialize.media.UMImage(this.context, new java.io.File(str)));
        shareImpl(uMImage, null, share_media, iCallbackCodeInfo);
    }

    private void shareImpl(com.umeng.socialize.media.UMImage uMImage, com.umeng.socialize.media.UMWeb uMWeb, com.umeng.socialize.bean.SHARE_MEDIA share_media, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        if (share_media != com.umeng.socialize.bean.SHARE_MEDIA.QQ && share_media != com.umeng.socialize.bean.SHARE_MEDIA.QZONE && share_media != com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN && share_media != com.umeng.socialize.bean.SHARE_MEDIA.ALIPAY && share_media != com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN_CIRCLE) {
            iCallbackCodeInfo.onResult(-101, "不支持的分享类型");
            return;
        }
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            iCallbackCodeInfo.onResult(-102, "网络异常，请检查网络连接...");
            return;
        }
        if (share_media == com.umeng.socialize.bean.SHARE_MEDIA.QQ || share_media == com.umeng.socialize.bean.SHARE_MEDIA.QZONE) {
            if (!com.umeng.socialize.UMShareAPI.get(this.context).isInstall(this.context, com.umeng.socialize.bean.SHARE_MEDIA.QQ)) {
                iCallbackCodeInfo.onResult(-103, "分享失败！请先安装QQ");
                return;
            } else if (!com.up366.mobile.common.utils.PlatformUtils.isQQClientAvailable()) {
                iCallbackCodeInfo.onResult(-103, "分享失败！请先安装QQ");
                return;
            }
        }
        if ((share_media == com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN || share_media == com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN_CIRCLE) && !com.umeng.socialize.UMShareAPI.get(this.context).isInstall(this.context, com.umeng.socialize.bean.SHARE_MEDIA.WEIXIN)) {
            iCallbackCodeInfo.onResult(-104, "分享失败！请先安装微信");
            return;
        }
        if (share_media == com.umeng.socialize.bean.SHARE_MEDIA.ALIPAY && !com.umeng.socialize.UMShareAPI.get(this.context).isInstall(this.context, com.umeng.socialize.bean.SHARE_MEDIA.ALIPAY)) {
            iCallbackCodeInfo.onResult(-107, "分享失败！请先安装支付宝");
            return;
        }
        com.umeng.socialize.ShareAction shareAction = new com.umeng.socialize.ShareAction(this.context);
        if (uMImage != null) {
            shareAction.withMedia(uMImage);
        }
        if (uMWeb != null) {
            shareAction.withMedia(uMWeb);
        }
        shareAction.setPlatform(share_media).setCallback(new com.umeng.socialize.UMShareListener() { // from class: com.up366.mobile.common.utils.ShareUtils.1
            public void onStart(com.umeng.socialize.bean.SHARE_MEDIA share_media2) {
            }

            public void onResult(com.umeng.socialize.bean.SHARE_MEDIA share_media2) {
                iCallbackCodeInfo.onResult(0, "success");
            }

            public void onError(com.umeng.socialize.bean.SHARE_MEDIA share_media2, java.lang.Throwable th) {
                com.up366.common.log.Logger.info("TAG - ShareUtils - onError - platform = [" + share_media2 + "]", th);
                java.lang.StringBuilder sb = new java.lang.StringBuilder("分享失败：");
                sb.append(th.getMessage());
                iCallbackCodeInfo.onResult(-105, sb.toString());
            }

            public void onCancel(com.umeng.socialize.bean.SHARE_MEDIA share_media2) {
                iCallbackCodeInfo.onResult(100, "取消分享");
            }
        }).share();
    }

    public void savePhotoToLocal(android.view.View view, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        savePhotoToLocal(getBitmapFromView(view), iCallbackCodeInfo);
    }

    public void savePhotoToLocal(final android.graphics.Bitmap bitmap, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ShareUtils$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$savePhotoToLocal$4(bitmap, iCallbackCodeInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$savePhotoToLocal$4(final android.graphics.Bitmap bitmap, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) throws java.lang.Exception {
        com.up366.mobile.common.utils.PermissionUtils.checkStoragePermission(com.up366.common.global.GB.get().getCurrentActivity(), "保存图片", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.utils.ShareUtils$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                this.f$0.lambda$savePhotoToLocal$3(bitmap, iCallbackCodeInfo, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$savePhotoToLocal$3(android.graphics.Bitmap bitmap, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo, int i, java.lang.String str) {
        if (i == 0) {
            if (android.os.Build.VERSION.SDK_INT < 30) {
                savePhotoToExternalStorage(bitmap, iCallbackCodeInfo);
                return;
            } else {
                savePhotoToMediaStore(bitmap, iCallbackCodeInfo);
                return;
            }
        }
        iCallbackCodeInfo.onResult(-106, "图片保存失败");
    }

    private void savePhotoToExternalStorage(android.graphics.Bitmap bitmap, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        java.lang.String strValueOf = java.lang.String.valueOf(java.util.Calendar.getInstance().getTimeInMillis());
        java.lang.String str = (android.os.Environment.getExternalStorageDirectory().toString() + "/DCIM/up366/") + strValueOf + com.up366.medialibrary.common.utils.MimeTypeUtils.PNG;
        try {
            com.up366.common.FileUtilsUp.mkdirParentDir(str);
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(str);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            scanPhoto(this.context, str);
            iCallbackCodeInfo.onResult(0, str);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("图片保存失败", e);
            iCallbackCodeInfo.onResult(-106, "图片保存失败");
        }
    }

    private void savePhotoToMediaStore(android.graphics.Bitmap bitmap, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        java.lang.String strValueOf = java.lang.String.valueOf(java.util.Calendar.getInstance().getTimeInMillis());
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_display_name", strValueOf);
        contentValues.put("mime_type", com.up366.medialibrary.common.utils.MimeTypeUtils.PNG_Q);
        contentValues.put("relative_path", android.os.Environment.DIRECTORY_DCIM + "/up366");
        android.net.Uri uriInsert = this.context.getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert != null) {
            try {
                java.io.OutputStream outputStreamOpenOutputStream = this.context.getContentResolver().openOutputStream(uriInsert);
                if (outputStreamOpenOutputStream != null) {
                    bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, outputStreamOpenOutputStream);
                    outputStreamOpenOutputStream.close();
                    iCallbackCodeInfo.onResult(0, uriInsert.toString());
                } else {
                    iCallbackCodeInfo.onResult(-106, "图片保存失败");
                }
                return;
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("图片保存失败", e);
                iCallbackCodeInfo.onResult(-106, "图片保存失败");
                return;
            }
        }
        iCallbackCodeInfo.onResult(-106, "图片保存失败");
    }

    private android.graphics.Bitmap getBitmapFromView(android.view.View view) {
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        android.graphics.drawable.Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    private android.graphics.Bitmap getBitmapFromUrl(java.lang.String str) {
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                java.io.InputStream inputStream = httpURLConnection.getInputStream();
                android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                return bitmapDecodeStream;
            }
            if (responseCode != 301 && responseCode != 302) {
                return null;
            }
            java.lang.String headerField = httpURLConnection.getHeaderField("Location");
            if (str.equals(headerField)) {
                return null;
            }
            return getBitmapFromUrl(headerField);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            com.up366.common.log.Logger.error("error getBitmapFromUrl url" + str);
            return null;
        }
    }

    private java.io.File loadDefaultThumb() throws java.lang.Throwable {
        java.lang.String str = com.up366.mobile.common.utils.AppFileUtils.getAppInternalCacheDir() + "/share_default_thumb.png";
        if (com.up366.common.FileUtilsUp.isFileExists(str)) {
            return new java.io.File(str);
        }
        com.up366.common.BitmapUtilsUp.saveBitmap(android.graphics.BitmapFactory.decodeResource(com.up366.common.global.GB.get().getApplicationContext().getResources(), com.up366.mobile.R.drawable.share_default_thumb), str);
        return new java.io.File(str);
    }

    private void scanPhoto(final android.content.Context context, final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ShareUtils$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.utils.ShareUtils.lambda$scanPhoto$5(str, context);
            }
        });
    }

    static /* synthetic */ void lambda$scanPhoto$5(java.lang.String str, android.content.Context context) throws java.lang.Exception {
        android.content.Intent intent = new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(android.net.Uri.fromFile(new java.io.File(str)));
        context.sendBroadcast(intent);
    }
}
