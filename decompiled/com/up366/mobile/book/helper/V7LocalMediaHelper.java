package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V7LocalMediaHelper {
    private final android.app.Activity context;

    public interface ISaveGalleryCallback {
        void onResult(int i);
    }

    public V7LocalMediaHelper(android.app.Activity activity) {
        this.context = activity;
    }

    public void saveToGallery(final java.lang.String str, final com.up366.mobile.book.helper.V7LocalMediaHelper.ISaveGalleryCallback iSaveGalleryCallback) throws java.lang.Throwable {
        if (android.os.Build.VERSION.SDK_INT < 30) {
            com.up366.mobile.common.utils.PermissionUtils.checkStoragePermission(this.context, "保存媒体文件", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.book.helper.V7LocalMediaHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.callback.ICallbackCodeInfo
                public final void onResult(int i, java.lang.String str2) throws java.lang.Throwable {
                    this.f$0.lambda$saveToGallery$0(str, iSaveGalleryCallback, i, str2);
                }
            });
        } else {
            saveToGalleryImpl(str, iSaveGalleryCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToGallery$0(java.lang.String str, com.up366.mobile.book.helper.V7LocalMediaHelper.ISaveGalleryCallback iSaveGalleryCallback, int i, java.lang.String str2) throws java.lang.Throwable {
        if (i == 0) {
            saveToGalleryImpl(str, iSaveGalleryCallback);
        } else {
            iSaveGalleryCallback.onResult(2);
        }
    }

    private void saveToGalleryImpl(java.lang.String str, com.up366.mobile.book.helper.V7LocalMediaHelper.ISaveGalleryCallback iSaveGalleryCallback) throws java.lang.Throwable {
        try {
            java.lang.String string = com.alibaba.fastjson.JSON.parseObject(str).getString("localPath");
            if (!com.up366.common.FileUtilsUp.isFileExists(string)) {
                throw new java.lang.IllegalStateException("file not exists:" + string);
            }
            java.lang.String str2 = "." + string.replaceFirst("^.*\\.", "");
            java.lang.String time = com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd_HHmmssSSS");
            if (android.os.Build.VERSION.SDK_INT > 23) {
                saveToMediaStore(time + str2, string);
                iSaveGalleryCallback.onResult(0);
                return;
            }
            java.lang.String str3 = (android.os.Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera/") + time + str2;
            com.up366.common.FileUtilsUp.copyFileOrDir(string, str3);
            android.content.Intent intent = new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(android.net.Uri.fromFile(new java.io.File(str3)));
            this.context.sendBroadcast(intent);
            iSaveGalleryCallback.onResult(0);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG -  saveToGallery error : " + e.getMessage(), e);
            iSaveGalleryCallback.onResult(1);
        }
    }

    private void saveToMediaStore(java.lang.String str, java.lang.String str2) throws java.io.FileNotFoundException {
        android.net.Uri uriInsert;
        android.content.ContentResolver contentResolver = this.context.getContentResolver();
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_display_name", str);
        if (str.endsWith("mp4")) {
            uriInsert = contentResolver.insert(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        } else {
            uriInsert = contentResolver.insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        if (uriInsert == null) {
            throw new java.lang.IllegalStateException("insert error!");
        }
        copyStream(new java.io.FileInputStream(str2), this.context.getContentResolver().openOutputStream(uriInsert));
    }

    public static void saveBase64Img(android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        byte[] bArrDecode;
        java.lang.String str2;
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                bArrDecode = android.util.Base64.decode(str, 0);
                java.lang.String time = com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd_HHmmssSSS");
                str2 = (android.os.Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera/") + time + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG;
                fileOutputStream = new java.io.FileOutputStream(str2);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            fileOutputStream.write(bArrDecode);
            fileOutputStream.close();
            android.content.Intent intent = new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(android.net.Uri.fromFile(new java.io.File(str2)));
            context.sendBroadcast(intent);
            com.up366.common.IOUtils.close(fileOutputStream);
        } catch (java.io.IOException e2) {
            e = e2;
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.up366.common.IOUtils.close(fileOutputStream2);
            throw th;
        }
    }

    private static void copyStream(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        try {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, i);
                    }
                }
                outputStream.flush();
            } catch (java.io.IOException e) {
                com.up366.common.log.Logger.error("copyStream error : " + e.getMessage(), e);
            }
        } finally {
            com.up366.common.IOUtils.close(inputStream);
            com.up366.common.IOUtils.close(outputStream);
        }
    }
}
